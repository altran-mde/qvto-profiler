package org.eclipse.m2m.qvt.oml.profiler.data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.inject.Singleton;

import org.eclipse.e4.core.di.annotations.Creatable;

@Creatable
@Singleton
public class HighlightedText
{
    public static final String FIELD_SELECTION = "selection";
    
    private final PropertyChangeSupport SUPPORT;
    
    private String itsSelection;
    
    public HighlightedText()
    {
        SUPPORT = new PropertyChangeSupport(this);
    }

    public String getSelection()
    {
        return itsSelection;
    }

    public void setSelection(String aSelection)
    {
    	if (aSelection == itsSelection) {
    		return;
    	}
        String oldValue = itsSelection;
        itsSelection = aSelection;
        SUPPORT.firePropertyChange(FIELD_SELECTION, oldValue, aSelection);
    }

    public void addPropertyChangeListener(PropertyChangeListener aListener)
    {
        SUPPORT.addPropertyChangeListener(aListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener aListener)
    {
        SUPPORT.removePropertyChangeListener(aListener);
    }
}
