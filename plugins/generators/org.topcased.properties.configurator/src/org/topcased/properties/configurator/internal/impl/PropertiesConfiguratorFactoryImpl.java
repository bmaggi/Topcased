/**
 * <copyright>
 * </copyright>
 *
 * $Id: PropertiesConfiguratorFactoryImpl.java,v 1.1 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator.internal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.topcased.properties.configurator.AdvancedSection;
import org.topcased.properties.configurator.Category;
import org.topcased.properties.configurator.MultipleFeatureSection;
import org.topcased.properties.configurator.PropertiesConfiguratorFactory;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;
import org.topcased.properties.configurator.SingleFeatureSection;
import org.topcased.properties.configurator.Tab;
import org.topcased.properties.configurator.TabbedView;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class PropertiesConfiguratorFactoryImpl extends EFactoryImpl implements PropertiesConfiguratorFactory
{
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static PropertiesConfiguratorFactory init()
    {
        try
        {
            PropertiesConfiguratorFactory thePropertiesConfiguratorFactory = (PropertiesConfiguratorFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.topcased.org/PropertiesViewConfiguration/1.0");
            if (thePropertiesConfiguratorFactory != null)
            {
                return thePropertiesConfiguratorFactory;
            }
        }
        catch (Exception exception)
        {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new PropertiesConfiguratorFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PropertiesConfiguratorFactoryImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EObject create(EClass eClass)
    {
        switch (eClass.getClassifierID())
        {
            case PropertiesConfiguratorPackage.TABBED_VIEW:
                return createTabbedView();
            case PropertiesConfiguratorPackage.TAB:
                return createTab();
            case PropertiesConfiguratorPackage.CATEGORY:
                return createCategory();
            case PropertiesConfiguratorPackage.SINGLE_FEATURE_SECTION:
                return createSingleFeatureSection();
            case PropertiesConfiguratorPackage.MULTIPLE_FEATURE_SECTION:
                return createMultipleFeatureSection();
            case PropertiesConfiguratorPackage.ADVANCED_SECTION:
                return createAdvancedSection();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TabbedView createTabbedView()
    {
        TabbedViewImpl tabbedView = new TabbedViewImpl();
        return tabbedView;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Tab createTab()
    {
        TabImpl tab = new TabImpl();
        return tab;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Category createCategory()
    {
        CategoryImpl category = new CategoryImpl();
        return category;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SingleFeatureSection createSingleFeatureSection()
    {
        SingleFeatureSectionImpl singleFeatureSection = new SingleFeatureSectionImpl();
        return singleFeatureSection;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public MultipleFeatureSection createMultipleFeatureSection()
    {
        MultipleFeatureSectionImpl multipleFeatureSection = new MultipleFeatureSectionImpl();
        return multipleFeatureSection;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AdvancedSection createAdvancedSection()
    {
        AdvancedSectionImpl advancedSection = new AdvancedSectionImpl();
        return advancedSection;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PropertiesConfiguratorPackage getPropertiesConfiguratorPackage()
    {
        return (PropertiesConfiguratorPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    public static PropertiesConfiguratorPackage getPackage()
    {
        return PropertiesConfiguratorPackage.eINSTANCE;
    }

} // PropertiesConfiguratorFactoryImpl
