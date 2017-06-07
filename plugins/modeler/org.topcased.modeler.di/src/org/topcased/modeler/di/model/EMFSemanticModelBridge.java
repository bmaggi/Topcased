/**
 * <copyright>
 * </copyright>
 *
 * $Id: EMFSemanticModelBridge.java,v 1.11 2007/04/12 08:31:47 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>EMF Semantic Model Bridge</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.EMFSemanticModelBridge#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEMFSemanticModelBridge()
 * @model
 * @generated
 */
public interface EMFSemanticModelBridge extends SemanticModelBridge
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Element</em>' reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Element</em>' reference.
     * @see #setElement(EObject)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getEMFSemanticModelBridge_Element()
     * @model required="true"
     * @generated
     */
    EObject getElement();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.EMFSemanticModelBridge#getElement <em>Element</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Element</em>' reference.
     * @see #getElement()
     * @generated
     */
    void setElement(EObject value);

} // EMFSemanticModelBridge
