/**
 * <copyright>
 * </copyright>
 *
 * $Id: MenuItem.java,v 1.2 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Menu Item</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.outline.configurator.MenuItem#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getMenuItem()
 * @model abstract="true" annotation="http://www.topcased.org/documentation documentation='A MenuItem represents a JFace
 *        contribution item.'"
 * @generated
 */
public interface MenuItem extends EObject
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = ""; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Parent</b></em>' container reference. It is bidirectional and its opposite
     * is '{@link org.topcased.outline.configurator.MenuGroup#getItems <em>Items</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' container reference isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Parent</em>' container reference.
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getMenuItem_Parent()
     * @see org.topcased.outline.configurator.MenuGroup#getItems
     * @model opposite="items" changeable="false"
     * @generated
     */
    MenuGroup getParent();

} // MenuItem
