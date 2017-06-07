/**
 * <copyright>
 * </copyright>
 *
 * $Id: OutlineConfiguratorFactory.java,v 1.2 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.topcased.outline.configurator.OutlineConfiguratorPackage
 * @generated
 */
public interface OutlineConfiguratorFactory extends EFactory
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = ""; //$NON-NLS-1$

    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    OutlineConfiguratorFactory eINSTANCE = org.topcased.outline.configurator.internal.impl.OutlineConfiguratorFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Outline Configuration</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Outline Configuration</em>'.
     * @generated
     */
    OutlineConfiguration createOutlineConfiguration();

    /**
     * Returns a new object of class '<em>Create Child Menu Configuration</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Create Child Menu Configuration</em>'.
     * @generated
     */
    CreateChildMenuConfiguration createCreateChildMenuConfiguration();

    /**
     * Returns a new object of class '<em>Create Child Action</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Create Child Action</em>'.
     * @generated
     */
    CreateChildAction createCreateChildAction();

    /**
     * Returns a new object of class '<em>Menu</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Menu</em>'.
     * @generated
     */
    Menu createMenu();

    /**
     * Returns a new object of class '<em>Menu Group</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Menu Group</em>'.
     * @generated
     */
    MenuGroup createMenuGroup();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    OutlineConfiguratorPackage getOutlineConfiguratorPackage();

} // OutlineConfiguratorFactory
