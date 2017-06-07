/**
 * <copyright>
 * </copyright>
 *
 * $Id: Property.java,v 1.9 2007/04/12 08:31:48 jako Exp $
 */
package org.topcased.modeler.di.model;

import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Property</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.Property#getKey <em>Key</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.Property#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getProperty()
 * @model
 * @extends EModelElement
 * @generated
 */
public interface Property extends EModelElement
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Key</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Key</em>' attribute.
     * @see #setKey(String)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getProperty_Key()
     * @model
     * @generated
     */
    String getKey();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Property#getKey <em>Key</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Key</em>' attribute.
     * @see #getKey()
     * @generated
     */
    void setKey(String value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see org.topcased.modeler.di.model.DiagramInterchangePackage#getProperty_Value()
     * @model
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link org.topcased.modeler.di.model.Property#getValue <em>Value</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

} // Property
