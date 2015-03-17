package org.eclipse.m2m.qvt.oml.profiler.parts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.annotation.PostConstruct;

import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.m2m.qvt.oml.profiler.data.MeasurementList;
import org.eclipse.m2m.qvt.oml.profiler.data.SelectedTimeUnit;
import org.eclipse.m2m.qvt.oml.profiler.model.Measurement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

public class SelectionPart
{
    private Text itsFilterText;
    
    private long itsMaxTime = 0;
    
    private long itsTotalTime = 0;
    
    @PostConstruct
    public void postConstruct(Composite aParent, final MeasurementList aData, final ESelectionService aSelectionService, final SelectedTimeUnit aTimeUnit)
    {
        aParent.setLayout(new GridLayout(2, false));

        final Label lblTotalTime = new Label(aParent, SWT.NONE);
        lblTotalTime.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
        setTotalTime(lblTotalTime, aTimeUnit);

        Label lblFilter = new Label(aParent, SWT.NONE);
        lblFilter.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblFilter.setText("Filter");
        
        itsFilterText = new Text(aParent, SWT.BORDER);
        itsFilterText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        final TableViewer tableViewer = new TableViewer(aParent, SWT.BORDER | SWT.FULL_SELECTION);
        Table table = tableViewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        tableViewer.addFilter(new ViewerFilter()
        {
            @Override
            public boolean select(Viewer viewer, Object parentElement, Object element)
            {
                if (itsFilterText.getText().isEmpty())
                {
                    return true;
                }
                return ((Measurement) element).getId().toLowerCase().contains(itsFilterText.getText().toLowerCase());
            }
        });
        itsFilterText.addModifyListener(new ModifyListener()
        {
            public void modifyText(ModifyEvent e)
            {
                tableViewer.refresh();
            }
        });
        tableViewer.addSelectionChangedListener(new ISelectionChangedListener()
        {
            public void selectionChanged(SelectionChangedEvent event)
            {
                if (event.getSelection().isEmpty())
                {
                    aSelectionService.setSelection(null);
                    return;
                }
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                aSelectionService.setSelection((Measurement) selection.getFirstElement());
            }
        });
        
        tableViewer.setContentProvider(ArrayContentProvider.getInstance());
        ViewerSupport.bind(tableViewer, aData, PojoProperties.value("id"));
        {
            TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
            final TableColumn taclmnTime = tableViewerColumn.getColumn();
            taclmnTime.setWidth(100);
            taclmnTime.setText("Weight");
            tableViewerColumn.setLabelProvider(new OwnerDrawLabelProvider()
            {
                @Override
                protected void paint(Event event, Object element)
                {
                    if (null == element)
                    {
                        return;
                    }
                    Measurement measurement = (Measurement) element;
                    long time = measurement.getTotalTime();
                    Rectangle bounds = event.getBounds();
                    int clmnWidth = taclmnTime.getWidth() - 12;
                    event.gc.setBackground(new Color(Display.getCurrent(), 195, 41, 41));
                    event.gc.fillRectangle(bounds.x + 2, bounds.y + 2,
                            Math.round(time * clmnWidth * 1f/ itsMaxTime), bounds.height - 4);
                    String timeStr = aTimeUnit.format(time);
                    Point timeExt = event.gc.stringExtent(timeStr); 
                    event.gc.drawString(timeStr, bounds.x + clmnWidth - timeExt.x, bounds.y + 2, true);
                }

                @Override
                protected void measure(Event event, Object element)
                {
                }
            });
        }
        {
            TableViewerColumn taclmnMethod = new TableViewerColumn(tableViewer, SWT.NONE);
            taclmnMethod.getColumn().setWidth(400);
            taclmnMethod.getColumn().setText("Transformation");
			taclmnMethod.setLabelProvider(new ColumnLabelProvider() 
			{
				@Override
				public String getText(Object element) 
				{
					Measurement measurement = (Measurement) element;
					return measurement.getId().substring(2);
				}
			});
        }

        aData.addChangeListener(new IChangeListener() {
			public synchronized void handleChange(ChangeEvent event) {
				itsTotalTime = 0;
				itsMaxTime = 0;
				for (Object object : aData) {
					long time = ((Measurement)object).getTotalTime();
					itsMaxTime = Math.max(itsMaxTime, time);
					itsTotalTime += time;
				}
				setTotalTime(lblTotalTime, aTimeUnit);
			}
		});
        aTimeUnit.addPropertyChangeListener(new PropertyChangeListener()
        {
            public void propertyChange(PropertyChangeEvent aEvt)
            {
                tableViewer.refresh();
				setTotalTime(lblTotalTime, aTimeUnit);
            }
        });
    }
    
    private void setTotalTime(Label aLabel, SelectedTimeUnit aTimeUnit) {
    	String text = "Total time: ";
    	if (itsTotalTime > 0) {
    		text += aTimeUnit.format(itsTotalTime);
    	}
    	aLabel.setText(text);
    }
}