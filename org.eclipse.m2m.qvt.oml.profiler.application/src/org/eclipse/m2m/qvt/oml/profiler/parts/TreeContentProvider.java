package org.eclipse.m2m.qvt.oml.profiler.parts;

import java.util.Collection;

import org.eclipse.m2m.qvt.oml.profiler.model.Measurement;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TreeContentProvider implements ITreeContentProvider {
	
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public boolean hasChildren(Object element) {
		Measurement measurement = (Measurement) element;
		return !measurement.getMeasurements().isEmpty();
	}

	public Object getParent(Object element) {
	    Measurement measurement = (Measurement) element;
		return measurement.getParent();
	}

	public Object[] getElements(Object inputElement) {
	    return ((Collection<?>)inputElement).toArray();
	}

	public Object[] getChildren(Object parentElement) {
	    Measurement measurement = (Measurement) parentElement;
		return measurement.getMeasurements().toArray();
	}
}
