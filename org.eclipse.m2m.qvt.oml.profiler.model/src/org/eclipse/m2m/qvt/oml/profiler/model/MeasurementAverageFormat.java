package org.eclipse.m2m.qvt.oml.profiler.model;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

public class MeasurementAverageFormat extends Format
{
    private static final long serialVersionUID = -7271025904414514019L;

    private static final MeasurementFormat FORMAT = new MeasurementFormat();

    public static Collection<Measurement> createAverage(Measurement aRoot)
    {
        final Measurement average = ModelFactory.eINSTANCE.createMeasurement();
        average.setId("Average");
        
        average.getMeasurement(aRoot.getId()).merge(aRoot);
        for (Iterator<EObject> content = aRoot.eAllContents(); content.hasNext();)
        {
        	Measurement measurement = (Measurement) content.next();
            average.getMeasurement(measurement.getId()).merge(measurement);
        }
        return average.getMeasurements();
    }
    
    @Override
    public StringBuffer format(Object aObj, StringBuffer aToAppendTo, FieldPosition aPos)
    {
        if (!(aObj instanceof Measurement))
        {
            return aToAppendTo;
        }
        ArrayList<Measurement> averages = new ArrayList<Measurement>(createAverage((Measurement)aObj));
        Collections.sort(averages, new MeasurementAverageComparator());
        for (Measurement measurement : averages)
        {
            FORMAT.format(measurement, aToAppendTo, aPos);
            aToAppendTo.append(System.getProperty("line.separator"));
        }
        return aToAppendTo;
    }

    @Override
    public Object parseObject(String aSource, ParsePosition aPos)
    {
        // Parsing not supported
        return null;
    }
}
