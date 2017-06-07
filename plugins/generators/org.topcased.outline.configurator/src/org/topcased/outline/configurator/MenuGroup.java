/**
 * <copyright> </copyright>
 * 
 * $Id: MenuGroup.java,v 1.2 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Menu Group</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.outline.configurator.MenuGroup#getId <em>Id</em>}</li>
 * <li>{@link org.topcased.outline.configurator.MenuGroup#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getMenuGroup()
 * @model annotation="http://www.topcased.org/documentation documentation='A MenuGroup represents a JFace separator
 *        group.'"
 * @generated
 */
public interface MenuGroup extends MenuItem
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = ""; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getMenuGroup_Id()
     * @model id="true" required="true" annotation="http://www.topcased.org/uuid uuid='113195647230219'"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.topcased.outline.configurator.MenuGroup#getId <em>Id</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Items</b></em>' containment reference list. The list contents are of type
     * {@link org.topcased.outline.configurator.MenuItem}. It is bidirectional and its opposite is '{@link org.topcased.outline.configurator.MenuItem#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Items</em>' containment reference list isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Items</em>' containment reference list.
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getMenuGroup_Items()
     * @see org.topcased.outline.configurator.MenuItem#getParent
     * @model type="org.topcased.outline.configurator.MenuItem" opposite="parent" containment="true"
     * @generated
     */
    EList getItems();

    /**
     * Check if the given {@link MenuGroup} has one or more Hierarchical {@link CreateChildAction}.
     * 
     * @return
     */
    boolean hasHierarchicalCreateChildActions();

    /**
     * Check if the given {@link MenuGroup} has one or more Exact {@link CreateChildAction}.
     * 
     * @return
     */
    boolean hasExactCreateChildActions();

} // MenuGroup
