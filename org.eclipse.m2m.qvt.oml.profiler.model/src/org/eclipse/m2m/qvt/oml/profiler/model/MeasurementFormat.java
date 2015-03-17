package org.eclipse.m2m.qvt.oml.profiler.model;

import static java.util.concurrent.TimeUnit.MICROSECONDS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;

public class MeasurementFormat extends Format
{
    private static final long serialVersionUID = 3582267423257573079L;

    private static final MessageFormat[] FORMATS = new MessageFormat[] {
        new MessageFormat("{0} was invoked {1,number,integer} times and took {2,number} ms. (own_time: {3,number} ms., own_average: {4,number} us., min: {5,number} us., max: {6,number} us., average: {7,number} us.)"),
        // Backwards compatibility
        new MessageFormat("{0} was invoked {1,number,integer} times and took {2,number} ms. (own_time: {3,number} ms., own_average: {4,number} us., average: {7,number} us.)"),
        new MessageFormat("{0} was invoked {1,number,integer} times and took {2,number} ms. (min: {5,number} us., max: {6,number} us., average: {7,number} us.)"),
        new MessageFormat("{0} was invoked {1,number,integer} times and took {2,number} ms. (average: {7,number} us.)")
    };
    
    @Override
    public StringBuffer format(Object aObj, StringBuffer aToAppendTo, FieldPosition aPos)
    {
        if (!(aObj instanceof Measurement))
        {
            return aToAppendTo;
        }
        Measurement measurement = (Measurement) aObj;
        Object[] arguments = new Object[] { 
                measurement.getId(), 
                measurement.getInvocations(),
                MILLISECONDS.convert(measurement.getTotalTime(), NANOSECONDS),
                MILLISECONDS.convert(measurement.getOwnTime(), NANOSECONDS),
                MICROSECONDS.convert(measurement.getOwnTime() / measurement.getInvocations(), NANOSECONDS), 
				MICROSECONDS.convert(measurement.getMinimumTime(), NANOSECONDS),
				MICROSECONDS.convert(measurement.getMaximumTime(), NANOSECONDS),
				MICROSECONDS.convert(measurement.getTotalTime() / measurement.getInvocations(), NANOSECONDS)        };
        return FORMATS[0].format(arguments, aToAppendTo, aPos);
    }

    @Override
    public Object parseObject(String aSource, ParsePosition aPos)
    {
        Object[] arguments = null;
        for (MessageFormat format : FORMATS)
        {
            arguments = format.parse(aSource, aPos);
            if (arguments != null) break;
        }
        if (arguments == null)
        {
            System.err.println("Parsing failed: " + aSource);
            return null;
        }
        if (arguments[3] == null)
        {
            // If own time not set => owntime = total time
            arguments[3] = arguments[2];
            arguments[4] = arguments[7];
        }

        final Measurement measurement = ModelFactory.eINSTANCE.createMeasurement();
        measurement.setId(safeGet(arguments, 0, String.class));
		measurement.setInvocations(safeGet(arguments, 1, Long.class).intValue());
		measurement.setTotalTime(NANOSECONDS.convert(safeGet(arguments, 2, Long.class), MILLISECONDS));
		measurement.setMinimumTime(NANOSECONDS.convert(safeGet(arguments, 5, Long.class), MICROSECONDS));
		measurement.setMaximumTime(NANOSECONDS.convert(safeGet(arguments, 6, Long.class), MICROSECONDS));
		return measurement;
    }
    
    private static <T> T safeGet(Object[] arguments, int index, Class<T> type)
    {
        Object value = null;
        if (index < arguments.length)
        {
            value = arguments[index];
        }
        if (value == null && Long.class.isAssignableFrom(type))
        {
            value = 0l;
        }
        return type.cast(value);
    }
}
