/**
 * <copyright>
 * </copyright>
 *
 * $Id: CallOperationAction.java,v 1.2 2009/04/20 08:07:05 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Call Operation Action</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.CallOperationAction#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage#getCallOperationAction()
 * @model
 * @generated
 */
public interface CallOperationAction extends EObject
{
    /**
     * Returns the value of the '<em><b>Operation</b></em>' reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Operation</em>' reference.
     * @see #setOperation(EOperation)
     * @see org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage#getCallOperationAction_Operation()
     * @model required="true"
     * @generated
     */
    EOperation getOperation();

    /**
     * Sets the value of the '{@link org.topcased.modeler.ocl.ocldiagrams.CallOperationAction#getOperation
     * <em>Operation</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Operation</em>' reference.
     * @see #getOperation()
     * @generated
     */
    void setOperation(EOperation value);

} // CallOperationAction
