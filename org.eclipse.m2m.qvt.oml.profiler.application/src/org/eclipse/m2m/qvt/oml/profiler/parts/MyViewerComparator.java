package org.eclipse.m2m.qvt.oml.profiler.parts;

import org.eclipse.m2m.qvt.oml.profiler.model.Measurement;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;

public class MyViewerComparator extends ViewerComparator
{
    private int propertyIndex = -1;
    private boolean decending = true;

    public int getDirection()
    {
        return decending ? SWT.DOWN : SWT.UP;
    }

    public void setColumn(int column)
    {
        if (column == propertyIndex)
        {
            // Same column as last sort; toggle the direction
            decending = !decending;
        }
        else
        {
            // New column; do an ascending sort
            propertyIndex = column;
            decending = true;
        }
    }

    @Override
    public int compare(Viewer viewer, Object e1, Object e2)
    {
        Measurement entry1 = (Measurement) e1;
        Measurement entry2 = (Measurement) e2;
        int rc = 0;
        switch (propertyIndex)
        {
            case 0:
                rc = entry1.getId().compareTo(entry2.getId());
                break;
            case 1:
                rc = ((Integer)entry1.getInvocations()).compareTo(entry2.getInvocations());
                break;
            case 2:
            case 3:
                rc = ((Long)entry1.getTotalTime()).compareTo(entry2.getTotalTime());
                break;
//            case 4:
//                rc = nullSafeCompare(entry1.getAverageTimeInUs(), entry2.getAverageTimeInUs());
//                break;
            case 5:
            case 6:
                rc = ((Long)entry1.getOwnTime()).compareTo(entry2.getOwnTime());
                break;
//            case 7:
//                rc = nullSafeCompare(entry1.getOwnAverageTimeInUs(), entry2.getOwnAverageTimeInUs());
//                break;
            case 8:
                rc = ((Long)entry1.getMinimumTime()).compareTo(entry2.getMinimumTime());
                break;
            case 9:
                rc = ((Long)entry1.getMaximumTime()).compareTo(entry2.getMaximumTime());
                break;
            default:
                rc = 0;
        }

        // If descending order, flip the direction
        if (decending)
        {
            rc = -rc;
        }
        return rc;
    }
}