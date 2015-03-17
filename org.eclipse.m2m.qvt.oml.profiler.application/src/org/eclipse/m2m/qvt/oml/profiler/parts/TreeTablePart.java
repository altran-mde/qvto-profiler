package org.eclipse.m2m.qvt.oml.profiler.parts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.m2m.qvt.oml.profiler.data.HighlightedText;
import org.eclipse.m2m.qvt.oml.profiler.data.SelectedTimeUnit;
import org.eclipse.m2m.qvt.oml.profiler.model.Measurement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

public class TreeTablePart
{
    private MyViewerComparator comparator = new MyViewerComparator();
    private TreeViewer treeViewer;
    private Measurement itsRoot;
    private MeasurementIdLabelProvider itsIdLabelProvider;

    @Inject
    private void setData(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Measurement aRoot)
    {
        itsRoot = aRoot;
        
        if (treeViewer == null || treeViewer.getTree().isDisposed())
        {
            return;
        }
        comparator.setColumn(-1);
        treeViewer.getTree().setSortColumn(null);
        treeViewer.setInput(aRoot == null ? Collections.emptyList() : Arrays.asList(aRoot));
        treeViewer.expandAll();
    }

    @PostConstruct
    public void postConstruct(Composite parent, Display aDisplay, final HighlightedText aHighlightedText, final SelectedTimeUnit aTimeUnit)
    {
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new FillLayout(SWT.HORIZONTAL));

        treeViewer = new TreeViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
        treeViewer.setComparator(comparator);
        Tree tree = treeViewer.getTree();
        tree.setHeaderVisible(true);
        tree.setLinesVisible(true);

        treeViewer.setContentProvider(new TreeContentProvider());
        {
            TreeViewerColumn trclmnMethod = new TreeViewerColumn(treeViewer, SWT.NONE);
            trclmnMethod.getColumn().setWidth(580);
            trclmnMethod.getColumn().setText("Method");
            itsIdLabelProvider = new MeasurementIdLabelProvider(aDisplay);
            trclmnMethod.setLabelProvider(itsIdLabelProvider);
            trclmnMethod.getColumn().addSelectionListener(getSelectionAdapter(treeViewer, trclmnMethod, 0));
        }
        {
            TreeViewerColumn trclmnInvocations = new TreeViewerColumn(treeViewer, SWT.NONE);
            trclmnInvocations.getColumn().setWidth(75);
            trclmnInvocations.getColumn().setText("Invocations");
            trclmnInvocations.setLabelProvider(new ColumnLabelProvider()
            {
                @Override
                public String getText(Object element)
                {
                    Measurement Measurement = (Measurement) element;
                    return String.valueOf(Measurement.getInvocations());
                }
            });
            trclmnInvocations.getColumn().addSelectionListener(getSelectionAdapter(treeViewer, trclmnInvocations, 1));
        }
        {
            TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
            final TreeColumn trclmnTime_1 = treeViewerColumn.getColumn();
            trclmnTime_1.setWidth(75);
            trclmnTime_1.setText("Time [%]");
            treeViewerColumn.setLabelProvider(new OwnerDrawLabelProvider()
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
                            (int) ((time / totalTime) * (trclmnTime_1.getWidth() - 5)), bounds.height - 4);
                }

                @Override
                protected void measure(Event event, Object element)
                {
                }
            });
            trclmnTime_1.addSelectionListener(getSelectionAdapter(treeViewer, treeViewerColumn, 2));
//            treeViewer.getTree().setSortColumn(trclmnTime_1);
        }
        {
            TreeViewerColumn trclmnTime = new TreeViewerColumn(treeViewer, SWT.NONE);
            trclmnTime.getColumn().setWidth(75);
            trclmnTime.getColumn().setText("Time");
            trclmnTime.setLabelProvider(new ColumnLabelProvider()
            {
                @Override
                public String getText(Object element)
                {
                    Measurement Measurement = (Measurement) element;
                    return aTimeUnit.format(Measurement.getTotalTime());
                }
            });
            trclmnTime.getColumn().addSelectionListener(getSelectionAdapter(treeViewer, trclmnTime, 3));
        }
        {
            TreeViewerColumn trclmnAverageTime = new TreeViewerColumn(treeViewer, SWT.NONE);
            trclmnAverageTime.getColumn().setWidth(75);
            trclmnAverageTime.getColumn().setText("Average time");
            trclmnAverageTime.setLabelProvider(new ColumnLabelProvider()
            {
                @Override
                public String getText(Object element)
                {
                    Measurement measurement = (Measurement) element;
                    return aTimeUnit.format(measurement.getTotalTime() / measurement.getInvocations());
                }
            });
//            trclmnAverageTime.getColumn().addSelectionListener(getSelectionAdapter(treeViewer, trclmnAverageTime, 4));
        }
        {
            TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
            final TreeColumn trclmnOwnTime_1 = treeViewerColumn.getColumn();
            trclmnOwnTime_1.setWidth(90);
            trclmnOwnTime_1.setText("Own time [%]");
            treeViewerColumn.setLabelProvider(new OwnerDrawLabelProvider()
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
                            (int) ((ownTime / totalTime) * (trclmnOwnTime_1.getWidth() - 5)), bounds.height - 4);
                }

                @Override
                protected void measure(Event event, Object element)
                {
                }
            });
            trclmnOwnTime_1.addSelectionListener(getSelectionAdapter(treeViewer, treeViewerColumn, 5));
        }
        {
            TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
            TreeColumn trclmnOwnTime = treeViewerColumn.getColumn();
            trclmnOwnTime.setWidth(75);
            trclmnOwnTime.setText("Own time");
            treeViewerColumn.setLabelProvider(new ColumnLabelProvider()
            {
                @Override
                public String getText(Object element)
                {
                    Measurement measurement = (Measurement) element;
                    return aTimeUnit.format(measurement.getOwnTime());
                }
            });
            trclmnOwnTime.addSelectionListener(getSelectionAdapter(treeViewer, treeViewerColumn, 6));
        }
        {
            TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
            TreeColumn trclmnOwnAverageTime = treeViewerColumn.getColumn();
            trclmnOwnAverageTime.setWidth(75);
            trclmnOwnAverageTime.setText("Own average time");
            treeViewerColumn.setLabelProvider(new ColumnLabelProvider()
            {
                @Override
                public String getText(Object element)
                {
                    Measurement measurement = (Measurement) element;
                    return aTimeUnit.format(measurement.getOwnTime() / measurement.getInvocations());
                }
            });
//            trclmnOwnAverageTime.addSelectionListener(getSelectionAdapter(treeViewer, treeViewerColumn, 7));
        }
        {
            TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
            TreeColumn trclmnMinTime = treeViewerColumn.getColumn();
            trclmnMinTime.setWidth(75);
            trclmnMinTime.setText("Min time");
            treeViewerColumn.setLabelProvider(new ColumnLabelProvider()
            {
                @Override
                public String getText(Object element)
                {
                    Measurement measurement = (Measurement) element;
                    return aTimeUnit.format(measurement.getMinimumTime());
                }
            });
            trclmnMinTime.addSelectionListener(getSelectionAdapter(treeViewer, treeViewerColumn, 8));
        }
        {
            TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
            TreeColumn trclmnMaxTime = treeViewerColumn.getColumn();
            trclmnMaxTime.setWidth(75);
            trclmnMaxTime.setText("Max time");
            treeViewerColumn.setLabelProvider(new ColumnLabelProvider()
            {
                @Override
                public String getText(Object element)
                {
                    Measurement Measurement = (Measurement) element;
                    return aTimeUnit.format(Measurement.getMaximumTime());
                }
            });
            trclmnMaxTime.addSelectionListener(getSelectionAdapter(treeViewer, treeViewerColumn, 9));
        }
        
        treeViewer.addSelectionChangedListener(new ISelectionChangedListener()
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
                treeViewer.refresh();
            }
        });
        aTimeUnit.addPropertyChangeListener(new PropertyChangeListener()
        {
            public void propertyChange(PropertyChangeEvent aEvt)
            {
            	treeViewer.refresh();
            }
        });
    }

    private SelectionAdapter getSelectionAdapter(final TreeViewer treeViewer, final TreeViewerColumn column,
            final int index)
    {
        SelectionAdapter selectionAdapter = new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                comparator.setColumn(index);
                int dir = comparator.getDirection();
                treeViewer.getTree().setSortDirection(dir);
                treeViewer.getTree().setSortColumn(column.getColumn());
                treeViewer.refresh();
                treeViewer.expandAll();
            }
        };
        return selectionAdapter;
    }
}