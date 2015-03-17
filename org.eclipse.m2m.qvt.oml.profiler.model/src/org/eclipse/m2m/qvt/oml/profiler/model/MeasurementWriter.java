package org.eclipse.m2m.qvt.oml.profiler.model;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * @deprecated use {@link Resource#save(java.util.Map)} instead.
 */
@Deprecated
public class MeasurementWriter implements Closeable {
	static final String TREE_REPORT_TOKEN = "Tree profile report: ";
	static final String AVERAGE_REPORT_TOKEN = "Average profile report: ";
	
	private static final MeasurementTreeFormat TREE_FORMAT = new MeasurementTreeFormat();
	private static final MeasurementAverageFormat AVERAGE_FORMAT = new MeasurementAverageFormat();

	private final Writer itsWriter;
	
	public MeasurementWriter(String aFile, boolean aAppend) throws IOException 
	{
		this(new File(aFile), aAppend);
	}
	
	public MeasurementWriter(File aFile, boolean aAppend) throws IOException 
	{
		this(new FileWriter(aFile, aAppend));
	}
	
	public MeasurementWriter(OutputStream aStream)
	{
		this(new OutputStreamWriter(aStream));
	}
	
	public MeasurementWriter(Writer aWriter) 
	{
		itsWriter = aWriter;
	}
	
    public void write (Measurement... measurements) throws IOException
    {
    	for (Measurement measurement : measurements) 
    	{
    		itsWriter.write(AVERAGE_REPORT_TOKEN + measurement.getId() + "\n");
    		itsWriter.write(AVERAGE_FORMAT.format(measurement));
    		itsWriter.write("\n");
    		itsWriter.write(TREE_REPORT_TOKEN + measurement.getId() + "\n");
    		itsWriter.write(TREE_FORMAT.format(measurement));
    		itsWriter.write("\n\n");
		}
    	itsWriter.flush();
    }
    
    public void close() throws IOException {
    	itsWriter.close();
    }
}
