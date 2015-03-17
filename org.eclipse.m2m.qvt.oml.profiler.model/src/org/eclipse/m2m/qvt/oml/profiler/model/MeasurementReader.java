package org.eclipse.m2m.qvt.oml.profiler.model;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;

public class MeasurementReader implements Closeable
{
    private static final MeasurementTreeFormat FORMAT = new MeasurementTreeFormat();
    
    private final BufferedReader itsReader;
    
    public MeasurementReader(String aFile) throws FileNotFoundException {
    	this(new File(aFile));
	}
    
    public MeasurementReader(File aFile) throws FileNotFoundException {
    	this(new FileReader(aFile));
	}
    
    public MeasurementReader(InputStream aStream) {
    	this(new InputStreamReader(aStream));
	}
    
    public MeasurementReader(Reader aReader) {
    	this(new BufferedReader(aReader));
	}
    
    public MeasurementReader(BufferedReader aReader) {
    	itsReader = aReader;
	}
    
    public void close() throws IOException {
    	itsReader.close();
    }

    public Measurement read() throws IOException, ParseException
    {
        StringBuffer record = null;
        String line;
        while((line = itsReader.readLine()) != null)
        {
            if (line.contains(MeasurementWriter.TREE_REPORT_TOKEN))
            {
                // Start recording
                record = new StringBuffer();
            }
            else if (record != null)
            {
                if (line.isEmpty())
                {
                    // Found end, add it
                    return (Measurement) FORMAT.parseObject(record.toString());
                }
                else
                {
                    // Record
                    record.append(line).append('\n');
                }
            }
        }
        return null;
    }
}
