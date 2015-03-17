package org.eclipse.m2m.qvt.oml.profiler.model;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Iterator;

public class MeasurementTreeFormat extends Format
{
    private static final long serialVersionUID = -922880830803143608L;

    private static final String BRANCH = "+-";
    private static final MeasurementFormat FORMAT = new MeasurementFormat();

    @Override
    public StringBuffer format(Object aObj, StringBuffer aToAppendTo, FieldPosition aPos)
    {
        if (!(aObj instanceof Measurement))
        {
            return aToAppendTo;
        }
        return appendToTree((Measurement)aObj, aToAppendTo, aPos, "");
    }

    private StringBuffer appendToTree(Measurement aMeasurement, StringBuffer aToAppendTo, FieldPosition aPos, String aLinePrefix)
    {
        FORMAT.format(aMeasurement, aToAppendTo, aPos);
        for (Iterator<Measurement> i = aMeasurement.getMeasurements().iterator(); i.hasNext();)
        {
            aToAppendTo.append("\n");
            aToAppendTo.append(aLinePrefix + BRANCH);
            appendToTree(i.next(), aToAppendTo, aPos, aLinePrefix + (i.hasNext() ? "| " : "  "));
        }
        return aToAppendTo;
    }

    @Override
    public Object parseObject(String aSource, ParsePosition aPos)
    {
        HashMap<Integer, Measurement> levelMap = new HashMap<Integer, Measurement>();
        for (String line : aSource.split("\n"))
        {
            if (line.isEmpty()) break;

            int level = (line.indexOf(BRANCH) + 2) / 2;
            ParsePosition pos = new ParsePosition(level * 2);
            Measurement parsed = (Measurement) FORMAT.parseObject(line, pos);
            if (parsed == null)
            {
                aPos.setIndex(aPos.getIndex() + pos.getIndex());
                aPos.setErrorIndex(aPos.getIndex() + pos.getErrorIndex());
                return null;
            }
            
            if (level > 0)
            {
                Measurement parent = levelMap.get(level - 1);
                parent.getMeasurements().add(parsed);
            }
            levelMap.put(level, parsed);
            aPos.setIndex(aPos.getIndex() + line.length() + 1);
        }
        return levelMap.get(0);
    }
}
