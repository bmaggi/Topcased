/**
 * <copyright> </copyright>
 * 
 * $Id: CreateChildMenuConfiguration.java,v 1.2 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Create Child Menu Configuration</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.outline.configurator.CreateChildMenuConfiguration#getItems <em>Items</em>}</li>
 * <li>{@link org.topcased.outline.configurator.CreateChildMenuConfiguration#getClassName <em>Class Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getCreateChildMenuConfiguration()
 * @model annotation="http://www.topcased.org/documentation documentation='The create child menu configuration contains
 *        the \'Create child\' actions to customize'"
 * @generated
 */
public interface CreateChildMenuConfiguration extends EObject
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = ""; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Items</b></em>' containment reference list. The list contents are of type
     * {@link org.topcased.outline.configurator.MenuItem}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Items</em>' containment reference list isn't clear, there really should be more of
     * a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Items</em>' containment reference list.
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getCreateChildMenuConfiguration_Items()
     * @model type="org.topcased.outline.configurator.MenuItem" containment="true"
     * @generated
     */
    EList getItems();

    /**
     * Returns the value of the '<em><b>Class Name</b></em>' attribute. The default value is
     * <code>"CreateChildMenu"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Class Name</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Class Name</em>' attribute.
     * @see #setClassName(String)
     * @see org.topcased.outline.configurator.OutlineConfiguratorPackage#getCreateChildMenuConfiguration_ClassName()
     * @model default="CreateChildMenu" annotation="http://www.topcased.org/documentation documentation='The class name
     *        that is generated. By default, the name is \'CreateChildMenu\'.'"
     * @generated
     */
    String getClassName();

    /**
     * Sets the value of the '{@link org.topcased.outline.configurator.CreateChildMenuConfiguration#getClassName <em>Class Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Class Name</em>' attribute.
     * @see #getClassName()
     * @generated
     */
    void setClassName(String value);

    String getMenuPackageName();

} // CreateChildMenuConfiguration
