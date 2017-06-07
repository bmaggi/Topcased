/**
 * <copyright>
 * </copyright>
 *
 * $Id: TabbedViewItemProvider.java,v 1.2 2006/12/19 10:05:51 jako Exp $
 */
package org.topcased.properties.configurator.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.topcased.properties.configurator.PropertiesConfiguratorFactory;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;
import org.topcased.properties.configurator.TabbedView;
import org.topcased.properties.configurator.internal.ConfiguratorPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.properties.configurator.TabbedView} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class TabbedViewItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TabbedViewItemProvider(AdapterFactory adapterFactory)
    {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public List getPropertyDescriptors(Object object)
    {
        if (itemPropertyDescriptors == null)
        {
            super.getPropertyDescriptors(object);

            addProjectNamePropertyDescriptor(object);
            addIdPropertyDescriptor(object);
            addNamePropertyDescriptor(object);
            addGenModelPropertyDescriptor(object);
            addBasePackagePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Project Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addProjectNamePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_TabbedView_projectName_feature"), getString("_UI_PropertyDescriptor_description", "_UI_TabbedView_projectName_feature", "_UI_TabbedView_type"),
                PropertiesConfiguratorPackage.Literals.TABBED_VIEW__PROJECT_NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Id feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addIdPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_TabbedView_id_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_TabbedView_id_feature", "_UI_TabbedView_type"), PropertiesConfiguratorPackage.Literals.TABBED_VIEW__ID, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_TabbedView_name_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_TabbedView_name_feature", "_UI_TabbedView_type"), PropertiesConfiguratorPackage.Literals.TABBED_VIEW__NAME, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Gen Model feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addGenModelPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_TabbedView_genModel_feature"), getString("_UI_PropertyDescriptor_description", "_UI_TabbedView_genModel_feature", "_UI_TabbedView_type"),
                PropertiesConfiguratorPackage.Literals.TABBED_VIEW__GEN_MODEL, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Base Package feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addBasePackagePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_TabbedView_basePackage_feature"), getString("_UI_PropertyDescriptor_description", "_UI_TabbedView_basePackage_feature", "_UI_TabbedView_type"),
                PropertiesConfiguratorPackage.Literals.TABBED_VIEW__BASE_PACKAGE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public Collection getChildrenFeatures(Object object)
    {
        if (childrenFeatures == null)
        {
            super.getChildrenFeatures(object);
            childrenFeatures.add(PropertiesConfiguratorPackage.Literals.TABBED_VIEW__CATEGORIES);
        }
        return childrenFeatures;
    }

    /**
     * This returns TabbedView.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/TabbedView"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getText(Object object)
    {
        String label = ((TabbedView) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_TabbedView_type") : getString("_UI_TabbedView_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
     * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    public void notifyChanged(Notification notification)
    {
        updateChildren(notification);

        switch (notification.getFeatureID(TabbedView.class))
        {
            case PropertiesConfiguratorPackage.TABBED_VIEW__PROJECT_NAME:
            case PropertiesConfiguratorPackage.TABBED_VIEW__ID:
            case PropertiesConfiguratorPackage.TABBED_VIEW__NAME:
            case PropertiesConfiguratorPackage.TABBED_VIEW__BASE_PACKAGE:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case PropertiesConfiguratorPackage.TABBED_VIEW__CATEGORIES:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s describing all of the
     * children that can be created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object)
    {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add(createChildParameter(PropertiesConfiguratorPackage.Literals.TABBED_VIEW__CATEGORIES, PropertiesConfiguratorFactory.eINSTANCE.createCategory()));
    }

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceLocator getResourceLocator()
    {
        return ConfiguratorPlugin.INSTANCE;
    }

}
