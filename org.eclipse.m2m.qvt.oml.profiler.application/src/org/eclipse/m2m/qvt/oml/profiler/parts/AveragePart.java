package org.eclipse.m2m.qvt.oml.profiler.parts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.m2m.qvt.oml.profiler.data.HighlightedText;
import org.eclipse.m2m.qvt.oml.profiler.data.SelectedTimeUnit;
import org.eclipse.m2m.qvt.oml.profiler.model.Measurement;
import org.eclipse.m2m.qvt.oml.profiler.model.MeasurementAverageFormat;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class AveragePart
{
    private MyViewerComparator comparator = new MyViewerComparator();
    private TableViewer tableViewer;
    private Measurement itsRoot;
    private MeasurementIdLabelProvider itsIdLabelProvider;

    @Inject
    private void setData(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Measurement aRoot)
    {
        itsRoot = aRoot;
        
        if (tableViewer == null || tableViewer.getTable().isDisposed())
        {
            return;
        }
        if (aRoot == null)
        {
            tableViewer.setInput(Collections.emptyList());
            return;
        }
        tableViewer.setInput(MeasurementAverageFormat.createAverage(aRoot));
    }

    @PostConstruct
    public void postConstruct(Composite parent, Display aDisplay, final HighlightedText aHighlightedText, final SelectedTimeUnit aTimeUnit)
    {
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new FillLayout(SWT.HORIZONTAL));

        tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
        Table table = tableViewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        comparator.setColumn(5);
        tableViewer.setComparator(comparator);
        int dir = comparator.getDirection();
        tableViewer.getTable().setSortDirection(dir);

        tableViewer.setContentProvider(ArrayContentProvider.getInstance());
        {
            TableViewerColumn taclmnMethod = new TableViewerColumn(tableViewer, SWT.NONE);
            taclmnMethod.getColumn().setWidth(580);
            taclmnMethod.getColumn().setText("Method");
            itsIdLabelProvider = new MeasurementIdLabelProvider(aDisplay);
            taclmnMethod.setLabelProvider(itsIdLabelProvider);
            taclmnMethod.getColumn().addSelectionListener(getSelectionAdapter(tableViewer, taclmnMethod, 0));
        }
        {
            TableViewerColumn taclmnInvocations = new TableViewerColumn(tableViewer, SWT.NONE);
            taclmnInvocations.getColumn().setWidth(75);
            taclmnInvocations.getColumn().setText("Invocations");
            taclmnInvocations.setLabelProvider(new ColumnLabelProvider()
            {
                @Override
                public String getText(Object element)
                {
                    Measurement Measurement = (Measurement) element;
                    return String.valueOf(Measurement.getInvocations());
                }
            });
            taclmnInvocations.getColumn().addSelectionListener(getSelectionAdapter(tableViewer, taclmnInvocations, 1));
        }
        {
            TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
            final TableColumn taclmnTime_1 = tableViewerColumn.getColumn();
            taclmnTime_1.setWidth(75);
            taclmnTime_1.setText("Time [%]");
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
                    double totalTime = itsRoot.getTotalTime();
                    long time = measurement.getTotalTime();
                    Rectangle bounds = event.getBounds();
                    event.gc.setBackground(new Color(Display.getCurrent(), 195, 41, 41));
                    event.gc.fillRectangle(bounds.x + 2, bounds.y + 2,
                            (int) ((time / totalTime) * (taclmnTime_1.getWidth() - 5)), bounds.height - 4);
                }

                @Override
                protected void measure(Event event, Object element)
                {
                }
            });
            taclmnTime_1.addSelectionListener(getSelectionAdapter(tableViewer, tableViewerColumn, 2));
        }
        {
            TableViewerColumn taclmnTime = new TableViewerColumn(tableViewer, SWT.NONE);
            taclmnTime.getColumn().setWidth(75);
            taclmnTime.getColumn().setText("Time");
            taclmnTime.setLabelProvider(new ColumnLabelProvider()
            {
                @Override
                public String getText(Object element)
                {
                    Measurement Measurement = (Measurement) element;
                    return aTimeUnit.format(Measurement.getTotalTime());
                }
            });
            taclmnTime.getColumn().addSelectionListener(getSelectionAdapter(tableViewer, taclmnTime, 3));
        }
        {
            TableViewerColumn taclmnAverageTime = new TableViewerColumn(tableViewer, SWT.NONE);
            taclmnAverageTime.getColumn().setWidth(75);
            taclmnAverageTime.getColumn().setText("Average time");
            taclmnAverageTime.setLabelProvider(new ColumnLabelProvider()
            {
                @Override
                public String getText(Object element)
                {
                    Measurement measurement = (Measurement) element;
                    return aTimeUnit.format(measurement.getTotalTime() / measurement.getInvocations());
                }
            });
//            taclmnAverageTime.getColumn().addSelectionListener(getSelectionAdapter(tableViewer, taclmnAverageTime, 4));
        }
        {
            TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
            final TableColumn taclmnOwnTime_1 = tableViewerColumn.getColumn();
            taclmnOwnTime_1.setWidth(90);
            taclmnOwnTime_1.setText("Own time [%]");
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
                    double totalTime = itsRoot.getTotalTime();
                    Long ownTime = measurement.getOwnTime();
                    Rectangle bounds = event.getBounds();
                    event.gc.setBackground(new Color(Display.getCurrent(), 195, 41, 41));
                    event.gc.fillRectangle(bounds.x + 2, bounds.y + 2,
                            (int) ((ownTime / totalTime) * (taclmnOwnTime_1.getWidth() - 5)), bounds.height - 4);
                }

                @Override
                protected void measure(Event event, Object element)
                {
                }
            });
            taclmnOwnTime_1.addSelectionListener(getSelectionAdapter(tableViewer, tableViewerColumn, 5));
            tableViewer.getTable().setSortColumn(taclmnOwnTime_1);
        }
        {
            TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
            TableColumn taclmnOwnTime = tableViewerColumn.getColumn();
            taclmnOwnTime.setWidth(75);
            taclmnOwnTime.setText("Own time");
            tableViewerColumn.setLabelProvider(new ColumnLabelProvider()
            {
                @Override
                public String getText(Object element)
                {
                    Measurement measurement = (Measurement) element;
                    return aTimeUnit.format(measurement.getOwnTime());
                }
            });
            taclmnOwnTime.addSelectionListener(getSelectionAdapter(tableViewer, tableViewerColumn, 6));
        }
        {
            TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
            TableColumn taclmnOwnAverageTime = tableViewerColumn.getColumn();
            taclmnOwnAverageTime.setWidth(75);
            taclmnOwnAverageTime.setText("Own average time");
            tableViewerColumn.setLabelProvider(new ColumnLabelProvider()
            {
                @Override
                public String getText(Object element)
                {
                    Measurement measurement = (Measurement) element;
                    return aTimeUnit.format(measurement.getOwnTime() / measurement.getInvocations());
                }
            });
//            taclmnOwnAverageTime.addSelectionListener(getSelectionAdapter(tableViewer, tableViewerColumn, 7));
        }
        {
            TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
            TableColumn taclmnMinTime = tableViewerColumn.getColumn();
            taclmnMinTime.setWidth(75);
            taclmnMinTime.setText("Min time");
            tableViewerColumn.setLabelProvider(new ColumnLabelProvider()
            {
                @Override
                public String getText(Object element)
                {
                    Measurement measurement = (Measurement) element;
                    return aTimeUnit.format(measurement.getMinimumTime());
                }
            });
            taclmnMinTime.addSelectionListener(getSelectionAdapter(tableViewer, tableViewerColumn, 8));
        }
        {
            TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
            TableColumn taclmnMaxTime = tableViewerColumn.getColumn();
            taclmnMaxTime.setWidth(75);
            taclmnMaxTime.setText("Max time");
            tableViewerColumn.setLabelProvider(new ColumnLabelProvider()
            {
                @Override
                public String getText(Object element)
                {
                    Measurement Measurement = (Measurement) element;
                    return aTimeUnit.format(Measurement.getMaximumTime());
                }
            });
            taclmnMaxTime.addSelectionListener(getSelectionAdapter(tableViewer, tableViewerColumn, 9));
        }

        tableViewer.addSelectionChangedListener(new ISelectionChangedListener()
        {
            public void selectionChanged(SelectionChangedEvent aEvent)
            {
                if (aEvent.getSelection().isEmpty())
                {
                    aHighlightedText.setSelection(null);
                }
                else
                {
                    aHighlightedText.setSelection(((Measurement)((IStructuredSelection)aEvent.getSelection()).getFirstElement()).getId());
                }
            }
        });
        aHighlightedText.addPropertyChangeListener(new PropertyChangeListener()
        {
            public void propertyChange(PropertyChangeEvent aEvt)
            {
                itsIdLabelProvider.setSelection((String) aEvt.getNewValue());
                tableViewer.refresh();
            }
        });
        aTimeUnit.addPropertyChangeListener(new PropertyChangeListener()
        {
            public void propertyChange(PropertyChangeEvent aEvt)
            {
                tableViewer.refresh();
            }
        });
    }

    private SelectionAdapter getSelectionAdapter(final TableViewer tableViewer, final TableViewerColumn column,
            final int index)
    {
        SelectionAdapter selectionAdapter = new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                comparator.setColumn(index);
                int dir = comparator.getDirection();
                tableViewer.getTable().setSortDirection(dir);
                tableViewer.getTable().setSortColumn(column.getColumn());
                tableViewer.refresh();
            }
        };
        return selectionAdapter;
    }
}