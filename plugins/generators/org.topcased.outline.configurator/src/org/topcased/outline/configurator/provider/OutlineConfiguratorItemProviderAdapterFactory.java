/**
 * <copyright>
 * </copyright>
 *
 * $Id: OutlineConfiguratorItemProviderAdapterFactory.java,v 1.2 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.topcased.outline.configurator.util.OutlineConfiguratorAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The adapters generated by this
 * factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The adapters
 * also support Eclipse property sheets. Note that most of the adapters are shared among multiple instances. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class OutlineConfiguratorItemProviderAdapterFactory extends OutlineConfiguratorAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = ""; //$NON-NLS-1$

    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection supportedTypes = new ArrayList();

    /**
     * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OutlineConfiguratorItemProviderAdapterFactory()
    {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.outline.configurator.OutlineConfiguration}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected OutlineConfigurationItemProvider outlineConfigurationItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.outline.configurator.OutlineConfiguration}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createOutlineConfigurationAdapter()
    {
        if (outlineConfigurationItemProvider == null)
        {
            outlineConfigurationItemProvider = new OutlineConfigurationItemProvider(this);
        }

        return outlineConfigurationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.topcased.outline.configurator.CreateChildMenuConfiguration} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected CreateChildMenuConfigurationItemProvider createChildMenuConfigurationItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.outline.configurator.CreateChildMenuConfiguration}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createCreateChildMenuConfigurationAdapter()
    {
        if (createChildMenuConfigurationItemProvider == null)
        {
            createChildMenuConfigurationItemProvider = new CreateChildMenuConfigurationItemProvider(this);
        }

        return createChildMenuConfigurationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.outline.configurator.CreateChildAction}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CreateChildActionItemProvider createChildActionItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.outline.configurator.CreateChildAction}. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Adapter createCreateChildActionAdapter()
    {
        if (createChildActionItemProvider == null)
        {
            createChildActionItemProvider = new CreateChildActionItemProvider(this);
        }

        return createChildActionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.outline.configurator.Menu} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MenuItemProvider menuItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.outline.configurator.Menu}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public Adapter createMenuAdapter()
    {
        if (menuItemProvider == null)
        {
            menuItemProvider = new MenuItemProvider(this);
        }

        return menuItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.topcased.outline.configurator.MenuGroup} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MenuGroupItemProvider menuGroupItemProvider;

    /**
     * This creates an adapter for a {@link org.topcased.outline.configurator.MenuGroup}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public Adapter createMenuGroupAdapter()
    {
        if (menuGroupItemProvider == null)
        {
            menuGroupItemProvider = new MenuGroupItemProvider(this);
        }

        return menuGroupItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory()
    {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory)
    {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isFactoryForType(Object type)
    {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public Adapter adapt(Notifier notifier, Object type)
    {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object adapt(Object object, Object type)
    {
        if (isFactoryForType(type))
        {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class) || (((Class) type).isInstance(adapter)))
            {
                return adapter;
            }
        }

        return null;
    }

    /**
     * This adds a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void addListener(INotifyChangedListener notifyChangedListener)
    {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void removeListener(INotifyChangedListener notifyChangedListener)
    {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public void fireNotifyChanged(Notification notification)
    {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null)
        {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void dispose()
    {
        if (outlineConfigurationItemProvider != null)
            outlineConfigurationItemProvider.dispose();
        if (createChildMenuConfigurationItemProvider != null)
            createChildMenuConfigurationItemProvider.dispose();
        if (createChildActionItemProvider != null)
            createChildActionItemProvider.dispose();
        if (menuItemProvider != null)
            menuItemProvider.dispose();
        if (menuGroupItemProvider != null)
            menuGroupItemProvider.dispose();
    }

}