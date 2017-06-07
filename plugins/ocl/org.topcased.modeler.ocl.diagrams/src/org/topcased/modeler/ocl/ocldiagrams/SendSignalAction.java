/**
 * <copyright>
 * </copyright>
 *
 * $Id: SendSignalAction.java,v 1.2 2009/04/20 08:07:00 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Send Signal Action</b></em>'. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.SendSignalAction#getSignal <em>Signal</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage#getSendSignalAction()
 * @model
 * @generated
 */
public interface SendSignalAction extends EObject
{
    /**
     * Returns the value of the '<em><b>Signal</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Signal</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Signal</em>' reference.
     * @see #setSignal(BusinessType)
     * @see org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage#getSendSignalAction_Signal()
     * @model required="true"
     * @generated
     */
    BusinessType getSignal();

    /**
     * Sets the value of the '{@link org.topcased.modeler.ocl.ocldiagrams.SendSignalAction#getSignal <em>Signal</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Signal</em>' reference.
     * @see #getSignal()
     * @generated
     */
    void setSignal(BusinessType value);

} // SendSignalAction
