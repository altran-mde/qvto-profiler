package org.eclipse.m2m.qvt.oml.profiler.data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import org.eclipse.e4.core.di.annotations.Creatable;

@Creatable
@Singleton
public class SelectedTimeUnit {
	public static final String FIELD_SELECTION = "selection";

	private static final NumberFormat FORMATTER = new DecimalFormat("0.000");

	private final PropertyChangeSupport SUPPORT;

	private TimeUnit itsSelection = TimeUnit.MILLISECONDS;

	public SelectedTimeUnit() {
		SUPPORT = new PropertyChangeSupport(this);
	}

	public String format(Long aNanoSeconds) {
		final double time = convert(aNanoSeconds);
		return (time < 10 ? FORMATTER.format(time) : Math.round(time))
				+ timeString();
	}

	private double convert(Long aNanoSeconds) {
		switch (itsSelection) {
			case MICROSECONDS:
				return aNanoSeconds / 1000d;
			case MILLISECONDS:
				return aNanoSeconds / 1000000d;
			case SECONDS:
				return aNanoSeconds / 1000000000d;
			default:
				throw new IllegalArgumentException("Not supported: " + itsSelection);
		}
	}

	private String timeString() {
		switch (itsSelection) {
			case MICROSECONDS:
				return " us";
			case MILLISECONDS:
				return " ms";
			case SECONDS:
				return " s";
			default:
				throw new IllegalArgumentException("Not supported: " + itsSelection);
		}
	}

	public TimeUnit getSelection() {
		return itsSelection;
	}

	public void setSelection(TimeUnit aSelection) {
		if (aSelection == itsSelection) {
			return;
		}
		TimeUnit oldValue = itsSelection;
		itsSelection = aSelection;
		SUPPORT.firePropertyChange(FIELD_SELECTION, oldValue, aSelection);
	}

	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		SUPPORT.addPropertyChangeListener(aListener);
	}

	public void removePropertyChangeListener(PropertyChangeListener aListener) {
		SUPPORT.removePropertyChangeListener(aListener);
	}
}
