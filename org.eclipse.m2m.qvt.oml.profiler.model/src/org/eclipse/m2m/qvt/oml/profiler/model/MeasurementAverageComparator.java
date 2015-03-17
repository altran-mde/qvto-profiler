package org.eclipse.m2m.qvt.oml.profiler.model;

import java.util.Comparator;

public class MeasurementAverageComparator implements Comparator<Measurement>
{
    public int compare(Measurement aM1, Measurement aM2)
    {
        int result = ((Long)aM2.getOwnTime()).compareTo(aM1.getOwnTime());
        if (result == 0)
        {
            // If it takes as long, then check the average time
            // i.e. less invocations on same time => higher average time
            result = ((Integer)aM1.getInvocations()).compareTo(aM2.getInvocations());
        }
        if (result == 0)
        {
            // Deterministic
            result = aM1.getId().compareTo(aM2.getId());
        }
        return result;
    }
}