/**
 * <copyright>
 * </copyright>
 *
 * $Id: OutlineConfiguratorAdapterFactory.java,v 1.2 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.topcased.outline.configurator.CreateChildAction;
import org.topcased.outline.configurator.CreateChildMenuConfiguration;
import org.topcased.outline.configurator.Menu;
import org.topcased.outline.configurator.MenuGroup;
import org.topcased.outline.configurator.MenuItem;
import org.topcased.outline.configurator.OutlineConfiguration;
import org.topcased.outline.configurator.OutlineConfiguratorPackage;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * 
 * @see org.topcased.outline.configurator.OutlineConfiguratorPackage
 * @generated
 */
public class OutlineConfiguratorAdapterFactory extends AdapterFactoryImpl
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = ""; //$NON-NLS-1$

    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static OutlineConfiguratorPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OutlineConfiguratorAdapterFactory()
    {
        if (modelPackage == null)
        {
            modelPackage = OutlineConfiguratorPackage.eINSTANCE;
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
    protected OutlineConfiguratorSwitch modelSwitch = new OutlineConfiguratorSwitch()
    {
        public Object caseOutlineConfiguration(OutlineConfiguration object)
        {
            return createOutlineConfigurationAdapter();
        }

        public Object caseCreateChildMenuConfiguration(CreateChildMenuConfiguration object)
        {
            return createCreateChildMenuConfigurationAdapter();
        }

        public Object caseCreateChildAction(CreateChildAction object)
        {
            return createCreateChildActionAdapter();
        }

        public Object caseMenu(Menu object)
        {
            return createMenuAdapter();
        }

        public Object caseMenuItem(MenuItem object)
        {
            return createMenuItemAdapter();
        }

        public Object caseMenuGroup(MenuGroup object)
        {
            return createMenuGroupAdapter();
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
     * Creates a new adapter for an object of class '{@link org.topcased.outline.configurator.OutlineConfiguration <em>Outline Configuration</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.outline.configurator.OutlineConfiguration
     * @generated
     */
    public Adapter createOutlineConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.outline.configurator.CreateChildMenuConfiguration <em>Create Child Menu Configuration</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.outline.configurator.CreateChildMenuConfiguration
     * @generated
     */
    public Adapter createCreateChildMenuConfigurationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.outline.configurator.CreateChildAction <em>Create Child Action</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.outline.configurator.CreateChildAction
     * @generated
     */
    public Adapter createCreateChildActionAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.outline.configurator.Menu <em>Menu</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.outline.configurator.Menu
     * @generated
     */
    public Adapter createMenuAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.outline.configurator.MenuItem <em>Menu Item</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.outline.configurator.MenuItem
     * @generated
     */
    public Adapter createMenuItemAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.topcased.outline.configurator.MenuGroup <em>Menu Group</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.topcased.outline.configurator.MenuGroup
     * @generated
     */
    public Adapter createMenuGroupAdapter()
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

} // OutlineConfiguratorAdapterFactory
