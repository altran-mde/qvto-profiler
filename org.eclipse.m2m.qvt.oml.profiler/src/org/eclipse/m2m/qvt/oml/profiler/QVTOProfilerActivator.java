package org.eclipse.m2m.qvt.oml.profiler;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QVTEvaluationOptions;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtGenericVisitorDecorator;
import org.eclipse.m2m.qvt.oml.util.ISessionData;

public final class QVTOProfilerActivator {

	private static final Field VISITOR_DECORATORS_FIELD;

	static {
		Field decoratorsField = null;
		try {
			decoratorsField = QVTEvaluationOptions.class.getField("VISITOR_DECORATORS");
			decoratorsField.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(decoratorsField, decoratorsField.getModifiers() & ~Modifier.FINAL);
		} catch (Exception e) {
			QvtPlugin.error("QVTo profiler is disabled as mandatory information cannot be found.", e);
		}
		VISITOR_DECORATORS_FIELD = decoratorsField;
	}

	private QVTOProfilerActivator() {
		// Empty
	}

	public static final void activate(File aProfilingOutput) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		final URI resourceURI = URI.createFileURI(aProfilingOutput.getAbsolutePath());
		QVTOProfilingDecorator.theirResults = resourceSet.createResource(resourceURI);

		List<Class<? extends QvtGenericVisitorDecorator>> visitorDecorators = new ArrayList<Class<? extends QvtGenericVisitorDecorator>>(
				QVTEvaluationOptions.VISITOR_DECORATORS.defaultValue());

		if (!visitorDecorators.contains(QVTOProfilingDecorator.class)) {
			visitorDecorators.add(QVTOProfilingDecorator.class);
		}

		registerDecorators(visitorDecorators);
	}

	public static final void deactivate() {
		List<Class<? extends QvtGenericVisitorDecorator>> visitorDecorators = new ArrayList<Class<? extends QvtGenericVisitorDecorator>>(
				QVTEvaluationOptions.VISITOR_DECORATORS.defaultValue());

		visitorDecorators.remove(QVTOProfilingDecorator.class);

		registerDecorators(visitorDecorators);
	}

	private static void registerDecorators(List<Class<? extends QvtGenericVisitorDecorator>> aDecorators) {
		try {
			VISITOR_DECORATORS_FIELD.set(null,
					new ISessionData.SimpleEntry<List<Class<? extends QvtGenericVisitorDecorator>>>(aDecorators));
		} catch (Exception e) {
			QvtPlugin.error("QVTo profiler is disabled as it could not be activated.", e);
		}
	}
}
