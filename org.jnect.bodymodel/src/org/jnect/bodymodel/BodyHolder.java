/**
 */
package org.jnect.bodymodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Body Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jnect.bodymodel.BodyHolder#getBodies <em>Bodies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jnect.bodymodel.BodymodelPackage#getBodyHolder()
 * @model
 * @generated
 */
public interface BodyHolder extends EObject {
	/**
	 * Returns the value of the '<em><b>Bodies</b></em>' containment reference list.
	 * The list contents are of type {@link org.jnect.bodymodel.Body}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bodies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bodies</em>' containment reference list.
	 * @see org.jnect.bodymodel.BodymodelPackage#getBodyHolder_Bodies()
	 * @model containment="true"
	 * @generated
	 */
	EList<Body> getBodies();

} // BodyHolder
