/**
 * <copyright>
 * </copyright>
 *
 * $Id: PropertiesConfiguratorAdapterFactory.java,v 1.2 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.topcased.properties.configurator.AbstractSection;
import org.topcased.properties.configurator.AdvancedSection;
import org.topcased.properties.configurator.Category;
import org.topcased.properties.configurator.MultipleFeatureSection;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;
import org.topcased.properties.configurator.SingleFeatureSection;
import org.topcased.properties.configurator.Tab;
import org.topcased.properties.configurator.TabbedView;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * 
 * @see org.topcased.properties.configurator.PropertiesConfiguratorPackage
 * @generated
 */
public class PropertiesConfiguratorAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static PropertiesConfiguratorPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PropertiesConfiguratorAdapterFactory()
    {
        if (modelPackage == null)
        {
            modelPackage = PropertiesConfiguratorPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc --> This
     * implementation returns <code>true</code> if the object is either the model's package or is an instance object
     * of the model. <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    public boolean isFactoryForType(Object object)
    {
        if (object == modelPackage)
        {
            return true;
        }
        if (object instanceof EObject)
        {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch the delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PropertiesConfiguratorSwitch modelSwitch = new PropertiesConfiguratorSwitch()
    {
        public Object caseTabbedView(TabbedView object)
        {
            return createTabbedViewAdapter();
        }

        public Object caseTab(Tab object)
        {
            return createTabAdapter();
        }

        public Object caseAbstractSection(AbstractSection object)
        {
            return createAbstractSectionAdapter();
        }

        public Object caseCategory(Category object)
        {
            return createCategoryAdapter();
        }

        public Object caseSingleFeatureSection(SingleFeatureSection object)
        {
            return createSingleFeatureSectionAdapter();
        }

        public Object caseMultipleFeatureSection(MultipleFeatureSection object)
        {
            return createMultipleFeatureSectionAdapter();
        }

        public Object caseAdvancedSection(AdvancedSection object)
        {
            return createAdvancedSectionAdapter();
        }

        public Object defaultCase(EObject object)
        {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    public Adapter createAdapter(Notifier target)
    {
        return (Adapter) modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.properties.configurator.TabbedView <em>Tabbed View</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.properties.configurator.TabbedView
     * @generated
     */
    public Adapter createTabbedViewAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.properties.configurator.Tab <em>Tab</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.properties.configurator.Tab
     * @generated
     */
    public Adapter createTabAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.properties.configurator.AbstractSection <em>Abstract Section</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.properties.configurator.AbstractSection
     * @generated
     */
    public Adapter createAbstractSectionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.properties.configurator.Category <em>Category</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.properties.configurator.Category
     * @generated
     */
    public Adapter createCategoryAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.properties.configurator.SingleFeatureSection <em>Single Feature Section</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.properties.configurator.SingleFeatureSection
     * @generated
     */
    public Adapter createSingleFeatureSectionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.properties.configurator.MultipleFeatureSection <em>Multiple Feature Section</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.properties.configurator.MultipleFeatureSection
     * @generated
     */
    public Adapter createMultipleFeatureSectionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.properties.configurator.AdvancedSection <em>Advanced Section</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.properties.configurator.AdvancedSection
     * @generated
     */
    public Adapter createAdvancedSectionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default implementation returns null.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter()
    {
        return null;
    }

} // PropertiesConfiguratorAdapterFactory
