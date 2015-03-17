/**
 */
package org.eclipse.m2m.qvt.oml.profiler.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measurement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getInvocations <em>Invocations</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getTotalTime <em>Total Time</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMinimumTime <em>Minimum Time</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMaximumTime <em>Maximum Time</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getOwnTime <em>Own Time</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMeasurements <em>Measurements</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.profiler.model.ModelPackage#getMeasurement()
 * @model
 * @generated
 */
public interface Measurement extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.ModelPackage#getMeasurement_Id()
	 * @model default="" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Invocations</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocations</em>' attribute.
	 * @see #setInvocations(int)
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.ModelPackage#getMeasurement_Invocations()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getInvocations();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getInvocations <em>Invocations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invocations</em>' attribute.
	 * @see #getInvocations()
	 * @generated
	 */
	void setInvocations(int value);

	/**
	 * Returns the value of the '<em><b>Total Time</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Time</em>' attribute.
	 * @see #setTotalTime(long)
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.ModelPackage#getMeasurement_TotalTime()
	 * @model default="0" required="true"
	 * @generated
	 */
	long getTotalTime();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getTotalTime <em>Total Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Time</em>' attribute.
	 * @see #getTotalTime()
	 * @generated
	 */
	void setTotalTime(long value);

	/**
	 * Returns the value of the '<em><b>Minimum Time</b></em>' attribute.
	 * The default value is <code>"9223372036854775807"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Time</em>' attribute.
	 * @see #setMinimumTime(long)
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.ModelPackage#getMeasurement_MinimumTime()
	 * @model default="9223372036854775807" required="true"
	 * @generated
	 */
	long getMinimumTime();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMinimumTime <em>Minimum Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Time</em>' attribute.
	 * @see #getMinimumTime()
	 * @generated
	 */
	void setMinimumTime(long value);

	/**
	 * Returns the value of the '<em><b>Maximum Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Time</em>' attribute.
	 * @see #setMaximumTime(long)
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.ModelPackage#getMeasurement_MaximumTime()
	 * @model required="true"
	 * @generated
	 */
	long getMaximumTime();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMaximumTime <em>Maximum Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Time</em>' attribute.
	 * @see #getMaximumTime()
	 * @generated
	 */
	void setMaximumTime(long value);

	/**
	 * Returns the value of the '<em><b>Own Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Own Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Own Time</em>' attribute.
	 * @see #isSetOwnTime()
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.ModelPackage#getMeasurement_OwnTime()
	 * @model unique="false" unsettable="true" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	long getOwnTime();

	/**
	 * Returns whether the value of the '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getOwnTime <em>Own Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Own Time</em>' attribute is set.
	 * @see #getOwnTime()
	 * @generated
	 */
	boolean isSetOwnTime();

	/**
	 * Returns the value of the '<em><b>Measurements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurements</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.ModelPackage#getMeasurement_Measurements()
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getParent
	 * @model opposite="parent" containment="true" keys="id"
	 * @generated
	 */
	EList<Measurement> getMeasurements();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMeasurements <em>Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Measurement)
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.ModelPackage#getMeasurement_Parent()
	 * @see org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getMeasurements
	 * @model opposite="measurements" transient="false"
	 * @generated
	 */
	Measurement getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.profiler.model.Measurement#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Measurement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Measurement markStartTime();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Measurement markEndTime(String category);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" idRequired="true"
	 * @generated
	 */
	Measurement getMeasurement(String id);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model measurementRequired="true"
	 * @generated
	 */
	void merge(Measurement measurement);

} // Measurement
