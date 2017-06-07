/**
 * <copyright>
 * </copyright>
 *
 * $Id: PropertiesConfiguratorFactory.java,v 1.2 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage
 * @generated
 */
public interface PropertiesConfiguratorFactory extends EFactory
{
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    PropertiesConfiguratorFactory eINSTANCE = org.topcased.properties.configurator.internal.impl.PropertiesConfiguratorFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Tabbed View</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Tabbed View</em>'.
     * @generated
     */
    TabbedView createTabbedView();

    /**
     * Returns a new object of class '<em>Tab</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Tab</em>'.
     * @generated
     */
    Tab createTab();

    /**
     * Returns a new object of class '<em>Category</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Category</em>'.
     * @generated
     */
    Category createCategory();

    /**
     * Returns a new object of class '<em>Single Feature Section</em>'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return a new object of class '<em>Single Feature Section</em>'.
     * @generated
     */
    SingleFeatureSection createSingleFeatureSection();

    /**
     * Returns a new object of class '<em>Multiple Feature Section</em>'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return a new object of class '<em>Multiple Feature Section</em>'.
     * @generated
     */
    MultipleFeatureSection createMultipleFeatureSection();

    /**
     * Returns a new object of class '<em>Advanced Section</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Advanced Section</em>'.
     * @generated
     */
    AdvancedSection createAdvancedSection();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    PropertiesConfiguratorPackage getPropertiesConfiguratorPackage();

} // PropertiesConfiguratorFactory
