/**
 * <copyright>
 * </copyright>
 *
 * $Id: Reference.java,v 1.7 2007/04/12 08:31:46 jako Exp $
 */
package org.topcased.modeler.di.model;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.Reference#isIsIndividualRepresentation <em>Is Individual Representation</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.Reference#getReferenced <em>Referenced</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends DiagramElement
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Is Individual Representation</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Individual Representation</em>' attribute isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is Individual Representation</em>' attribute.
     * @see #setIsIndividualRepresentation(boolean)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getReference_IsIndividualRepresentation()
     * @model
     * @generated
     */
    boolean isIsIndividualRepresentation();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Reference#isIsIndividualRepresentation <em>Is Individual Representation</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Individual Representation</em>' attribute.
     * @see #isIsIndividualRepresentation()
     * @generated
     */
    void setIsIndividualRepresentation(boolean value);

    /**
     * Returns the value of the '<em><b>Referenced</b></em>' reference.
     * It is bidirectional and its opposite is '{@link org.topcased.modeler.di.model.DiagramElement#getReference <em>Reference</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referenced</em>' reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Referenced</em>' reference.
     * @see #setReferenced(DiagramElement)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getReference_Referenced()
     * @see org.topcased.modeler.di.model.DiagramElement#getReference
     * @model opposite="reference" required="true"
     * @generated
     */
    DiagramElement getReferenced();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Reference#getReferenced <em>Referenced</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Referenced</em>' reference.
     * @see #getReferenced()
     * @generated
     */
    void setReferenced(DiagramElement value);

} // Reference
