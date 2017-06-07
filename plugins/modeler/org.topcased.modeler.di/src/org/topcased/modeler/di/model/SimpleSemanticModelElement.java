/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimpleSemanticModelElement.java,v 1.11 2007/04/12 08:31:51 jako Exp $
 */
package org.topcased.modeler.di.model;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Simple Semantic Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.SimpleSemanticModelElement#getTypeInfo <em>Type Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getSimpleSemanticModelElement()
 * @model
 * @generated
 */
public interface SimpleSemanticModelElement extends SemanticModelBridge
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Type Info</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type Info</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type Info</em>' attribute.
     * @see #setTypeInfo(String)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getSimpleSemanticModelElement_TypeInfo()
     * @model
     * @generated
     */
    String getTypeInfo();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.SimpleSemanticModelElement#getTypeInfo <em>Type Info</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Type Info</em>' attribute.
     * @see #getTypeInfo()
     * @generated
     */
    void setTypeInfo(String value);

} // SimpleSemanticModelElement
