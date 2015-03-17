package org.eclipse.m2m.qvt.oml.profiler;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Stack;

import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.evaluator.InternalEvaluator;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtGenericVisitorDecorator;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.m2m.internal.qvt.oml.expressions.Constructor;
import org.eclipse.m2m.internal.qvt.oml.expressions.EntryOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.qvt.oml.profiler.model.Measurement;
import org.eclipse.m2m.qvt.oml.profiler.model.ModelFactory;

public class QVTOProfilingDecorator extends QvtGenericVisitorDecorator {

	private final Stack<Measurement> itsMeasurements = new Stack<Measurement>();

	private static final Field STATUS_FIELD;

	static {
		Field status = null;
		try {
			Class<?> clazz = Class.forName(QvtOperationalEvaluationVisitorImpl.class.getName() + "$MappingCallResult");
			status = clazz.getDeclaredField("myStatus");
			status.setAccessible(true);
		} catch (Exception e) {
			QvtPlugin.warning(0, "Mapping status is disabled as mandatory information cannot be found.", e);
		}
		STATUS_FIELD = status;
	}

	static Resource theirResults;

	public QVTOProfilingDecorator(InternalEvaluator qvtExtVisitor) {
		super(qvtExtVisitor);
	}
	
	@Override
	public Object visitEntryOperation(EntryOperation entryOperation) {
		if (!itsMeasurements.isEmpty()) {
			// Don't know if this happens, but if we're already profiling just ignore this visit;
			return super.visitEntryOperation(entryOperation);
		}
		
		final String transformationName = ((Module)entryOperation.eContainer()).getName();
		final Measurement result = ModelFactory.eINSTANCE.createMeasurement();
		result.setId("T|" + transformationName);
		itsMeasurements.push(result).markStartTime();
		try {
			return super.visitEntryOperation(entryOperation);
		} finally {
			itsMeasurements.pop().markEndTime(null);
	
			if (!itsMeasurements.isEmpty()) {
				QvtPlugin.error("Programming error in stack handling: " + itsMeasurements);
				itsMeasurements.clear();
			}
	
			saveResult(result);
		}
	}

	private void saveResult(Measurement aResult) {
		try {
			theirResults.getContents().add(aResult);
			theirResults.save(null);
		} catch (IOException e) {
			QvtPlugin.error("Failed to store profiler result: " + e.getMessage(), e);
		}
	}

	@Override
	public Object visitMappingOperation(MappingOperation mappingOperation) {
		itsMeasurements.push(itsMeasurements.peek().getMeasurement(getKey(mappingOperation))).markStartTime();

		Object result = null;
		try {
			result = super.visitMappingOperation(mappingOperation);
			return result;
		} finally {
			itsMeasurements.pop().markEndTime(getMappingCategory(result));
		}
	}

	private String getMappingCategory(Object aResult) {
		if (aResult == null || STATUS_FIELD == null) {
			return null;
		}

		try {
			int status = STATUS_FIELD.getInt(aResult);
			switch (status) {
			case 0:
				// return "BODY_EXECUTED";
				// visitOperationBody will be called
				return null;
			case 2:
				return "PRECOND_FAILED";
			case 4:
				return "FETCHED_FROM_TRACE";
			case 8:
				return "NO_DISJUNCT_SELECTED";
			default:
				return "UNKNOWN_" + status;
			}
		} catch (Exception e) {
			QvtPlugin.error("Programming error in mapping result handling", e);
			return "EXCEPTION";
		}
	}

	@Override
	public Object visitMappingBody(MappingBody mappingBody) {
		Measurement mappingMeasurement = itsMeasurements.peek();
		itsMeasurements.push(mappingMeasurement.getMeasurement(mappingMeasurement.getId() + "|BODY_EXECUTED"))
				.markStartTime();
		try {
			return super.visitMappingBody(mappingBody);
		} finally {
			itsMeasurements.pop().markEndTime(null);
		}
	}

	@Override
	public Object visitHelper(Helper helper) {
		itsMeasurements.push(itsMeasurements.peek().getMeasurement(getKey(helper))).markStartTime();
		try {
			return super.visitHelper(helper);
		} finally {
			itsMeasurements.pop().markEndTime(null);
		}
	}

	@Override
	public Object visitConstructor(Constructor constructor) {
		itsMeasurements.push(itsMeasurements.peek().getMeasurement(getKey(constructor))).markStartTime();
		try {
			return super.visitConstructor(constructor);
		} finally {
			itsMeasurements.pop().markEndTime(null);
		}
	}

	private String getKey(ImperativeOperation aOperation) {
		StringBuffer key = new StringBuffer();
		// Add the type of operation (use the first letter of the class name)
		key.append(aOperation.getClass().getSimpleName().charAt(0)).append('|');
		if (aOperation.getContext() != null) {
			key.append(aOperation.getContext().getEType().getName()).append("::");
		}
		key.append(aOperation.getName()).append("(");
		for (Iterator<EParameter> i = aOperation.getEParameters().iterator(); i.hasNext();) {
			VarParameter param = (VarParameter) i.next();
			key.append(param.getKind().getName()).append(" ");
			key.append(param.getName()).append(":");
			key.append(param.getEType().getName());
			if (i.hasNext()) {
				key.append(", ");
			}
		}
		key.append(")");
		if (!"OclVoid".equals(aOperation.getEType().getName())) {
			key.append(":").append(aOperation.getEType().getName());
		}
		return key.toString();
	}
}
