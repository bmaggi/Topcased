/**
 * <copyright>
 * </copyright>
 *
 * $Id: TextElement.java,v 1.7 2007/04/12 08:31:44 jako Exp $
 */
package org.topcased.modeler.di.model;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Text Element</b></em>'. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.modeler.di.model.TextElement#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getTextElement()
 * @model
 * @generated
 */
public interface TextElement extends LeafElement
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Text</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Text</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Text</em>' attribute.
     * @see #setText(String)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getTextElement_Text()
     * @model
     * @generated
     */
    String getText();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.TextElement#getText <em>Text</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Text</em>' attribute.
     * @see #getText()
     * @generated
     */
    void setText(String value);

} // TextElement
