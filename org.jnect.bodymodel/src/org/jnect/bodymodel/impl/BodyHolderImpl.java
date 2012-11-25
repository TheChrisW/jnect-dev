/**
 */
package org.jnect.bodymodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.jnect.bodymodel.Body;
import org.jnect.bodymodel.BodyHolder;
import org.jnect.bodymodel.BodymodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Body Holder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jnect.bodymodel.impl.BodyHolderImpl#getBodies <em>Bodies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BodyHolderImpl extends EObjectImpl implements BodyHolder {
	/**
	 * The cached value of the '{@link #getBodies() <em>Bodies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodies()
	 * @generated
	 * @ordered
	 */
	protected EList<Body> bodies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BodyHolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BodymodelPackage.Literals.BODY_HOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Body> getBodies() {
		if (bodies == null) {
			bodies = new EObjectContainmentEList<Body>(Body.class, this, BodymodelPackage.BODY_HOLDER__BODIES);
		}
		return bodies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BodymodelPackage.BODY_HOLDER__BODIES:
				return ((InternalEList<?>)getBodies()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BodymodelPackage.BODY_HOLDER__BODIES:
				return getBodies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BodymodelPackage.BODY_HOLDER__BODIES:
				getBodies().clear();
				getBodies().addAll((Collection<? extends Body>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BodymodelPackage.BODY_HOLDER__BODIES:
				getBodies().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BodymodelPackage.BODY_HOLDER__BODIES:
				return bodies != null && !bodies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BodyHolderImpl
