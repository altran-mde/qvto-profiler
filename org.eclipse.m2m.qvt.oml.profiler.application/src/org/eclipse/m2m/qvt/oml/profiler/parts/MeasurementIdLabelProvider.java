package org.eclipse.m2m.qvt.oml.profiler.parts;

import java.net.URL;

import org.eclipse.m2m.qvt.oml.profiler.model.Measurement;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

final class MeasurementIdLabelProvider extends ColumnLabelProvider
{
    public static final Image IMPERATIVE_OPERATION = createImage("icons/cat-imperative-operation.gif");
    public static final Image MAPPING = createImage("icons/cat-mapping.gif");
    public static final Image OPERATION = createImage("icons/cat-operation.gif");
    public static final Image CLASS = createImage("icons/cat-class.gif");

    private static Image createImage(String aPath)
    {
        Bundle bundle = FrameworkUtil.getBundle(TreeTablePart.class);
        URL url = FileLocator.find(bundle, new Path(aPath), null);
        ImageDescriptor imageDcr = ImageDescriptor.createFromURL(url);
        return imageDcr.createImage();
    }

    private final Font FONT;
    private String itsSelection = null;

    public MeasurementIdLabelProvider(Device aDevice)
    {
        FONT = new Font(aDevice, "arial", 10, SWT.BOLD | SWT.ITALIC);
    }
    
    public void setSelection(String aSelection)
    {
        itsSelection = aSelection;
    }
    
    @Override
    public Font getFont(Object aElement)
    {
        if (itsSelection == null || itsSelection.isEmpty())
        {
            return null;
        }
        Measurement measurement = (Measurement) aElement;
//        return measurement.getId().equals(itsSelection) ? FONT : super.getFont(aElement);
        return measurement.getId().toLowerCase().contains(itsSelection.toLowerCase()) ? FONT : super.getFont(aElement);
    }
    
    @Override
    public String getText(Object element)
    {
        Measurement measurement = (Measurement) element;
        return measurement.getId().substring(2);
    }

    @Override
    public Image getImage(Object element)
    {
        Measurement measurement = (Measurement) element;
        switch (measurement.getId().charAt(0))
        {
            case 'M':
                return MAPPING;
            case 'H':
                return IMPERATIVE_OPERATION;
            case 'C':
                return OPERATION;
            case 'T':
                return CLASS;
        }
        return null;
    }
}