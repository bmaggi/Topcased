/**
 * <copyright>
 * </copyright>
 *
 * $Id: EMFBridge.java,v 1.3 2006/12/18 14:54:16 jako Exp $
 */
package org.topcased.modeler.graphconf;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>EMF Bridge</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.graphconf.EMFBridge#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.graphconf.GraphconfPackage#getEMFBridge()
 * @model
 * @generated
 */
public interface EMFBridge extends Bridge
{
    /**
     * Returns the value of the '<em><b>Type</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(EClass)
     * @see org.topcased.modeler.graphconf.GraphconfPackage#getEMFBridge_Type()
     * @model required="true"
     * @generated
     */
    EClass getType();

    /**
     * Sets the value of the '{@link org.topcased.modeler.graphconf.EMFBridge#getType <em>Type</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
    void setType(EClass value);

} // EMFBridge
