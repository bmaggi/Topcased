/**
 * <copyright>
 * </copyright>
 *
 * $Id: Menu.java,v 1.2 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Menu</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.outline.configurator.Menu#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getMenu()
 * @model annotation="http://www.topcased.org/documentation documentation='A Menu represents a JFace menu manager.'"
 * @generated
 */
public interface Menu extends MenuGroup
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = ""; //$NON-NLS-1$

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
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getMenu_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.topcased.outline.configurator.Menu#getName <em>Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // Menu
