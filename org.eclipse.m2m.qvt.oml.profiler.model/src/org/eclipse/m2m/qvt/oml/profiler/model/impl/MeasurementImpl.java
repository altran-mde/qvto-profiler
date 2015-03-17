/**
 */
package org.eclipse.m2m.qvt.oml.profiler.model.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.qvt.oml.profiler.model.Measurement;
import org.eclipse.m2m.qvt.oml.profiler.model.ModelFactory;
import org.eclipse.m2m.qvt.oml.profiler.model.ModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Measurement</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.m2m.qvt.oml.profiler.model.impl.MeasurementImpl#getId
 * <em>Id</em>}</li>
 * <li>
 * {@link org.eclipse.m2m.qvt.oml.profiler.model.impl.MeasurementImpl#getInvocations
 * <em>Invocations</em>}</li>
 * <li>
 * {@link org.eclipse.m2m.qvt.oml.profiler.model.impl.MeasurementImpl#getTotalTime
 * <em>Total Time</em>}</li>
 * <li>
 * {@link org.eclipse.m2m.qvt.oml.profiler.model.impl.MeasurementImpl#getMinimumTime
 * <em>Minimum Time</em>}</li>
 * <li>
 * {@link org.eclipse.m2m.qvt.oml.profiler.model.impl.MeasurementImpl#getMaximumTime
 * <em>Maximum Time</em>}</li>
 * <li>
 * {@link org.eclipse.m2m.qvt.oml.profiler.model.impl.MeasurementImpl#getOwnTime
 * <em>Own Time</em>}</li>
 * <li>
 * {@link org.eclipse.m2m.qvt.oml.profiler.model.impl.MeasurementImpl#getMeasurements
 * <em>Measurements</em>}</li>
 * <li>
 * {@link org.eclipse.m2m.qvt.oml.profiler.model.impl.MeasurementImpl#getParent
 * <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MeasurementImpl extends MinimalEObjectImpl.Container implements
		Measurement {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getInvocations() <em>Invocations</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInvocations()
	 * @generated
	 * @ordered
	 */
	protected static final int INVOCATIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInvocations() <em>Invocations</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInvocations()
	 * @generated
	 * @ordered
	 */
	protected int invocations = INVOCATIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalTime() <em>Total Time</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTotalTime()
	 * @generated
	 * @ordered
	 */
	protected static final long TOTAL_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTotalTime() <em>Total Time</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTotalTime()
	 * @generated
	 * @ordered
	 */
	protected long totalTime = TOTAL_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumTime() <em>Minimum Time</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinimumTime()
	 * @generated
	 * @ordered
	 */
	protected static final long MINIMUM_TIME_EDEFAULT = 9223372036854775807L;

	/**
	 * The cached value of the '{@link #getMinimumTime() <em>Minimum Time</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinimumTime()
	 * @generated
	 * @ordered
	 */
	protected long minimumTime = MINIMUM_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumTime() <em>Maximum Time</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaximumTime()
	 * @generated
	 * @ordered
	 */
	protected static final long MAXIMUM_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaximumTime() <em>Maximum Time</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaximumTime()
	 * @generated
	 * @ordered
	 */
	protected long maximumTime = MAXIMUM_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOwnTime() <em>Own Time</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOwnTime()
	 * @generated
	 * @ordered
	 */
	protected static final long OWN_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMeasurements() <em>Measurements</em>}
	 * ' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getMeasurements()
	 * @generated
	 * @ordered
	 */
	protected EList<Measurement> measurements;

	/**
	 * @generated NOT
	 */
	private transient Long startTime = null;

	/**
	 * @generated NOT
	 */
	private transient Long ownTime = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MeasurementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MEASUREMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.MEASUREMENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getInvocations() {
		return invocations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setInvocations(int newInvocations) {
		int oldInvocations = invocations;
		invocations = newInvocations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.MEASUREMENT__INVOCATIONS, oldInvocations,
					invocations));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public long getTotalTime() {
		return totalTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTotalTime(long newTotalTime) {
		long oldTotalTime = totalTime;
		totalTime = newTotalTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.MEASUREMENT__TOTAL_TIME, oldTotalTime,
					totalTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public long getMinimumTime() {
		return minimumTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMinimumTime(long newMinimumTime) {
		long oldMinimumTime = minimumTime;
		minimumTime = newMinimumTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.MEASUREMENT__MINIMUM_TIME, oldMinimumTime,
					minimumTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public long getMaximumTime() {
		return maximumTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMaximumTime(long newMaximumTime) {
		long oldMaximumTime = maximumTime;
		maximumTime = newMaximumTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.MEASUREMENT__MAXIMUM_TIME, oldMaximumTime,
					maximumTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public long getOwnTime() {
		if (ownTime != null) {
			return ownTime;
		}

		long time = getTotalTime();
		for (Measurement measurement : getMeasurements()) {
			time -= measurement.getTotalTime();
		}
		return time;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isSetOwnTime() {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Measurement> getMeasurements() {
		if (measurements == null) {
			measurements = new EObjectContainmentWithInverseEList<Measurement>(
					Measurement.class, this,
					ModelPackage.MEASUREMENT__MEASUREMENTS,
					ModelPackage.MEASUREMENT__PARENT);
		}
		return measurements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Measurement getParent() {
		if (eContainerFeatureID() != ModelPackage.MEASUREMENT__PARENT)
			return null;
		return (Measurement) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParent(Measurement newParent,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParent,
				ModelPackage.MEASUREMENT__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParent(Measurement newParent) {
		if (newParent != eInternalContainer()
				|| (eContainerFeatureID() != ModelPackage.MEASUREMENT__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject) newParent).eInverseAdd(this,
						ModelPackage.MEASUREMENT__MEASUREMENTS,
						Measurement.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.MEASUREMENT__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Measurement markStartTime() {
		startTime = System.nanoTime();
		return this;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public synchronized Measurement markEndTime(String category) {
		if (startTime == null) {
			throw new IllegalStateException(
					"markStartTime should be called before markEndTime");
		}
		if (category != null) {
			Measurement m = getMeasurement(getId() + "|" + category);
			// Just mark the invocation, time will be added to parent
			m.setInvocations(m.getInvocations() + 1);
			m.setMinimumTime(0);
		}

		setInvocations(getInvocations() + 1);
		final long duration = System.nanoTime() - startTime;
		setTotalTime(getTotalTime() + duration);
		if (duration > getMaximumTime())
			setMaximumTime(duration);
		if (duration < getMinimumTime())
			setMinimumTime(duration);

		startTime = null;
		return this;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Measurement getMeasurement(String id) {
		for (Measurement measurement : getMeasurements()) {
			if (measurement.getId().equals(id))
				return measurement;
		}

		final Measurement measurement = ModelFactory.eINSTANCE
				.createMeasurement();
		measurement.setId(id);
		getMeasurements().add(measurement);
		return measurement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void merge(Measurement measurement) {
		setInvocations(getInvocations() + measurement.getInvocations());
		setTotalTime(getTotalTime() + measurement.getTotalTime());
		if (measurement.getMaximumTime() > getMaximumTime())
			setMaximumTime(measurement.getMaximumTime());
		if (measurement.getMinimumTime() < getMinimumTime())
			setMinimumTime(measurement.getMinimumTime());
		// This is not a bug!
		// When merging we need to add the own time as we do not add the children
        if (ownTime == null)
        {
        	ownTime = measurement.getOwnTime();
        }
        else
        {
        	ownTime += measurement.getOwnTime();
        }
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.MEASUREMENT__MEASUREMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getMeasurements())
					.basicAdd(otherEnd, msgs);
		case ModelPackage.MEASUREMENT__PARENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParent((Measurement) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.MEASUREMENT__MEASUREMENTS:
			return ((InternalEList<?>) getMeasurements()).basicRemove(otherEnd,
					msgs);
		case ModelPackage.MEASUREMENT__PARENT:
			return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ModelPackage.MEASUREMENT__PARENT:
			return eInternalContainer().eInverseRemove(this,
					ModelPackage.MEASUREMENT__MEASUREMENTS, Measurement.class,
					msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelPackage.MEASUREMENT__ID:
			return getId();
		case ModelPackage.MEASUREMENT__INVOCATIONS:
			return getInvocations();
		case ModelPackage.MEASUREMENT__TOTAL_TIME:
			return getTotalTime();
		case ModelPackage.MEASUREMENT__MINIMUM_TIME:
			return getMinimumTime();
		case ModelPackage.MEASUREMENT__MAXIMUM_TIME:
			return getMaximumTime();
		case ModelPackage.MEASUREMENT__OWN_TIME:
			return getOwnTime();
		case ModelPackage.MEASUREMENT__MEASUREMENTS:
			return getMeasurements();
		case ModelPackage.MEASUREMENT__PARENT:
			return getParent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ModelPackage.MEASUREMENT__ID:
			setId((String) newValue);
			return;
		case ModelPackage.MEASUREMENT__INVOCATIONS:
			setInvocations((Integer) newValue);
			return;
		case ModelPackage.MEASUREMENT__TOTAL_TIME:
			setTotalTime((Long) newValue);
			return;
		case ModelPackage.MEASUREMENT__MINIMUM_TIME:
			setMinimumTime((Long) newValue);
			return;
		case ModelPackage.MEASUREMENT__MAXIMUM_TIME:
			setMaximumTime((Long) newValue);
			return;
		case ModelPackage.MEASUREMENT__MEASUREMENTS:
			getMeasurements().clear();
			getMeasurements().addAll(
					(Collection<? extends Measurement>) newValue);
			return;
		case ModelPackage.MEASUREMENT__PARENT:
			setParent((Measurement) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ModelPackage.MEASUREMENT__ID:
			setId(ID_EDEFAULT);
			return;
		case ModelPackage.MEASUREMENT__INVOCATIONS:
			setInvocations(INVOCATIONS_EDEFAULT);
			return;
		case ModelPackage.MEASUREMENT__TOTAL_TIME:
			setTotalTime(TOTAL_TIME_EDEFAULT);
			return;
		case ModelPackage.MEASUREMENT__MINIMUM_TIME:
			setMinimumTime(MINIMUM_TIME_EDEFAULT);
			return;
		case ModelPackage.MEASUREMENT__MAXIMUM_TIME:
			setMaximumTime(MAXIMUM_TIME_EDEFAULT);
			return;
		case ModelPackage.MEASUREMENT__MEASUREMENTS:
			getMeasurements().clear();
			return;
		case ModelPackage.MEASUREMENT__PARENT:
			setParent((Measurement) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ModelPackage.MEASUREMENT__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case ModelPackage.MEASUREMENT__INVOCATIONS:
			return invocations != INVOCATIONS_EDEFAULT;
		case ModelPackage.MEASUREMENT__TOTAL_TIME:
			return totalTime != TOTAL_TIME_EDEFAULT;
		case ModelPackage.MEASUREMENT__MINIMUM_TIME:
			return minimumTime != MINIMUM_TIME_EDEFAULT;
		case ModelPackage.MEASUREMENT__MAXIMUM_TIME:
			return maximumTime != MAXIMUM_TIME_EDEFAULT;
		case ModelPackage.MEASUREMENT__OWN_TIME:
			return isSetOwnTime();
		case ModelPackage.MEASUREMENT__MEASUREMENTS:
			return measurements != null && !measurements.isEmpty();
		case ModelPackage.MEASUREMENT__PARENT:
			return getParent() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
		case ModelPackage.MEASUREMENT___MARK_START_TIME:
			return markStartTime();
		case ModelPackage.MEASUREMENT___MARK_END_TIME__STRING:
			return markEndTime((String) arguments.get(0));
		case ModelPackage.MEASUREMENT___GET_MEASUREMENT__STRING:
			return getMeasurement((String) arguments.get(0));
		case ModelPackage.MEASUREMENT___MERGE__MEASUREMENT:
			merge((Measurement) arguments.get(0));
			return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", invocations: ");
		result.append(invocations);
		result.append(", totalTime: ");
		result.append(totalTime);
		result.append(", minimumTime: ");
		result.append(minimumTime);
		result.append(", maximumTime: ");
		result.append(maximumTime);
		result.append(')');
		return result.toString();
	}

} // MeasurementImpl
