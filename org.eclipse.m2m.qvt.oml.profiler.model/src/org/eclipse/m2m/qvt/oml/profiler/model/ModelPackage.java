/**
 */
package org.eclipse.m2m.qvt.oml.profiler.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.qvt.oml.profiler.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "profiler";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/1.0.0/Profiler";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "profiler";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.eclipse.m2m.qvt.oml.profiler.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.qvt.oml.profiler.model.impl.MeasurementImpl <em>Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.impl.MeasurementImpl
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.impl.ModelPackageImpl#getMeasurement()
	 * @generated
	 */
	int MEASUREMENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Invocations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__INVOCATIONS = 1;

	/**
	 * The feature id for the '<em><b>Total Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__TOTAL_TIME = 2;

	/**
	 * The feature id for the '<em><b>Minimum Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__MINIMUM_TIME = 3;

	/**
	 * The feature id for the '<em><b>Maximum Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__MAXIMUM_TIME = 4;

	/**
	 * The feature id for the '<em><b>Own Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__OWN_TIME = 5;

	/**
	 * The feature id for the '<em><b>Measurements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__MEASUREMENTS = 6;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT__PARENT = 7;

	/**
	 * The number of structural features of the '<em>Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_FEATURE_COUNT = 8;

	/**
	 * The operation id for the '<em>Mark Start Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT___MARK_START_TIME = 0;

	/**
	 * The operation id for the '<em>Mark End Time</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT___MARK_END_TIME__STRING = 1;

	/**
	 * The operation id for the '<em>Get Measurement</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT___GET_MEASUREMENT__STRING = 2;

	/**
	 * The operation id for the '<em>Merge</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT___MERGE__MEASUREMENT = 3;

	/**
	 * The number of operations of the '<em>Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_OPERATION_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement <em>Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement</em>'.
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement
	 * @generated
	 */
	EClass getMeasurement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getId()
	 * @see #getMeasurement()
	 * @generated
	 */
	EAttribute getMeasurement_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getInvocations <em>Invocations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Invocations</em>'.
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getInvocations()
	 * @see #getMeasurement()
	 * @generated
	 */
	EAttribute getMeasurement_Invocations();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getTotalTime <em>Total Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Time</em>'.
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getTotalTime()
	 * @see #getMeasurement()
	 * @generated
	 */
	EAttribute getMeasurement_TotalTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMinimumTime <em>Minimum Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Time</em>'.
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMinimumTime()
	 * @see #getMeasurement()
	 * @generated
	 */
	EAttribute getMeasurement_MinimumTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMaximumTime <em>Maximum Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Time</em>'.
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMaximumTime()
	 * @see #getMeasurement()
	 * @generated
	 */
	EAttribute getMeasurement_MaximumTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getOwnTime <em>Own Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Own Time</em>'.
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getOwnTime()
	 * @see #getMeasurement()
	 * @generated
	 */
	EAttribute getMeasurement_OwnTime();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMeasurements <em>Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measurements</em>'.
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMeasurements()
	 * @see #getMeasurement()
	 * @generated
	 */
	EReference getMeasurement_Measurements();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getParent()
	 * @see #getMeasurement()
	 * @generated
	 */
	EReference getMeasurement_Parent();

	/**
	 * Returns the meta object for the '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#markStartTime() <em>Mark Start Time</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Mark Start Time</em>' operation.
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement#markStartTime()
	 * @generated
	 */
	EOperation getMeasurement__MarkStartTime();

	/**
	 * Returns the meta object for the '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#markEndTime(java.lang.String) <em>Mark End Time</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Mark End Time</em>' operation.
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement#markEndTime(java.lang.String)
	 * @generated
	 */
	EOperation getMeasurement__MarkEndTime__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMeasurement(java.lang.String) <em>Get Measurement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Measurement</em>' operation.
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMeasurement(java.lang.String)
	 * @generated
	 */
	EOperation getMeasurement__GetMeasurement__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#merge(org.eclipse.m2m.qvt.oml.profiler.model.Measurement) <em>Merge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Merge</em>' operation.
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement#merge(org.eclipse.m2m.qvt.oml.profiler.model.Measurement)
	 * @generated
	 */
	EOperation getMeasurement__Merge__Measurement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.qvt.oml.profiler.model.impl.MeasurementImpl <em>Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.qvt.oml.profiler.model.impl.MeasurementImpl
		 * @see org.eclipse.m2m.qvt.oml.profiler.model.impl.ModelPackageImpl#getMeasurement()
		 * @generated
		 */
		EClass MEASUREMENT = eINSTANCE.getMeasurement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT__ID = eINSTANCE.getMeasurement_Id();

		/**
		 * The meta object literal for the '<em><b>Invocations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT__INVOCATIONS = eINSTANCE.getMeasurement_Invocations();

		/**
		 * The meta object literal for the '<em><b>Total Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT__TOTAL_TIME = eINSTANCE.getMeasurement_TotalTime();

		/**
		 * The meta object literal for the '<em><b>Minimum Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT__MINIMUM_TIME = eINSTANCE.getMeasurement_MinimumTime();

		/**
		 * The meta object literal for the '<em><b>Maximum Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT__MAXIMUM_TIME = eINSTANCE.getMeasurement_MaximumTime();

		/**
		 * The meta object literal for the '<em><b>Own Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT__OWN_TIME = eINSTANCE.getMeasurement_OwnTime();

		/**
		 * The meta object literal for the '<em><b>Measurements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT__MEASUREMENTS = eINSTANCE.getMeasurement_Measurements();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT__PARENT = eINSTANCE.getMeasurement_Parent();

		/**
		 * The meta object literal for the '<em><b>Mark Start Time</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEASUREMENT___MARK_START_TIME = eINSTANCE.getMeasurement__MarkStartTime();

		/**
		 * The meta object literal for the '<em><b>Mark End Time</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEASUREMENT___MARK_END_TIME__STRING = eINSTANCE.getMeasurement__MarkEndTime__String();

		/**
		 * The meta object literal for the '<em><b>Get Measurement</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEASUREMENT___GET_MEASUREMENT__STRING = eINSTANCE.getMeasurement__GetMeasurement__String();

		/**
		 * The meta object literal for the '<em><b>Merge</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEASUREMENT___MERGE__MEASUREMENT = eINSTANCE.getMeasurement__Merge__Measurement();

	}

} //ModelPackage
