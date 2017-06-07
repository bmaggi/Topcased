/**
 * <copyright>
 * </copyright>
 *
 * $Id: Category.java,v 1.2 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Category</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.properties.configurator.Category#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.properties.configurator.Category#getTabs <em>Tabs</em>}</li>
 * <li>{@link org.topcased.properties.configurator.Category#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getCategory()
 * @model
 * @generated
 */
public interface Category extends EObject
{
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getCategory_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.Category#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Tabs</b></em>' containment reference list. The list contents are of type
     * {@link org.topcased.properties.configurator.Tab}. It is bidirectional and its opposite is '{@link org.topcased.properties.configurator.Tab#getCategory <em>Category</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tabs</em>' containment reference list isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Tabs</em>' containment reference list.
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getCategory_Tabs()
     * @see org.topcased.properties.configurator.Tab#getCategory
     * @model type="org.topcased.properties.configurator.Tab" opposite="category" containment="true"
     * @generated
     */
    EList getTabs();

    /**
     * Returns the value of the '<em><b>Parent</b></em>' container reference. It is bidirectional and its opposite
     * is '{@link org.topcased.properties.configurator.TabbedView#getCategories <em>Categories</em>}'. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' container reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Parent</em>' container reference.
     * @see #setParent(TabbedView)
     * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage#getCategory_Parent()
     * @see org.topcased.properties.configurator.TabbedView#getCategories
     * @model opposite="categories" required="true"
     * @generated
     */
    TabbedView getParent();

    /**
     * Sets the value of the '{@link org.topcased.properties.configurator.Category#getParent <em>Parent</em>}'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Parent</em>' container reference.
     * @see #getParent()
     * @generated
     */
    void setParent(TabbedView value);

} // Category
