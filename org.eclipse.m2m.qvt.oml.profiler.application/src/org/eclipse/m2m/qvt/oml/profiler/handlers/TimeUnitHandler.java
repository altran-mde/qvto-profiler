package org.eclipse.m2m.qvt.oml.profiler.handlers;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.m2m.qvt.oml.profiler.data.SelectedTimeUnit;

public class TimeUnitHandler {
	@Execute
	public void execute(@Named("org.eclipse.m2m.qvt.oml.profiler.timeunit.parameter") String param, SelectedTimeUnit aTimeUnit) {
		aTimeUnit.setSelection(TimeUnit.valueOf(param));
	}
}