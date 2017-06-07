/**
 * <copyright>
 * </copyright>
 *
 * $Id: OutlineConfigurationItemProvider.java,v 1.2 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator.provider;

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
import org.topcased.outline.configurator.OutlineConfiguration;
import org.topcased.outline.configurator.OutlineConfiguratorFactory;
import org.topcased.outline.configurator.OutlineConfiguratorPackage;
import org.topcased.outline.configurator.internal.ConfiguratorPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.outline.configurator.OutlineConfiguration} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class OutlineConfigurationItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = ""; //$NON-NLS-1$

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OutlineConfigurationItemProvider(AdapterFactory adapterFactory)
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

            addNamePropertyDescriptor(object);
            addProjectNamePropertyDescriptor(object);
            addGenPackagePropertyDescriptor(object);
            addPackagePropertyDescriptor(object);
            addPluginClassNamePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_OutlineConfiguration_name_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_OutlineConfiguration_name_feature", "_UI_OutlineConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                OutlineConfiguratorPackage.Literals.OUTLINE_CONFIGURATION__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Project Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addProjectNamePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_OutlineConfiguration_projectName_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_OutlineConfiguration_projectName_feature", "_UI_OutlineConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                OutlineConfiguratorPackage.Literals.OUTLINE_CONFIGURATION__PROJECT_NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Gen Package feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addGenPackagePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_OutlineConfiguration_genPackage_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_OutlineConfiguration_genPackage_feature", "_UI_OutlineConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                OutlineConfiguratorPackage.Literals.OUTLINE_CONFIGURATION__GEN_PACKAGE, true, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Package feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPackagePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_OutlineConfiguration_package_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_OutlineConfiguration_package_feature", "_UI_OutlineConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                OutlineConfiguratorPackage.Literals.OUTLINE_CONFIGURATION__PACKAGE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Plugin Class Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPluginClassNamePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_OutlineConfiguration_pluginClassName_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_OutlineConfiguration_pluginClassName_feature", "_UI_OutlineConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                OutlineConfiguratorPackage.Literals.OUTLINE_CONFIGURATION__PLUGIN_CLASS_NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
            childrenFeatures.add(OutlineConfiguratorPackage.Literals.OUTLINE_CONFIGURATION__CREATE_CHILD);
        }
        return childrenFeatures;
    }

    /**
     * This returns OutlineConfiguration.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/OutlineConfiguration")); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getText(Object object)
    {
        String label = ((OutlineConfiguration) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_OutlineConfiguration_type") : //$NON-NLS-1$
                getString("_UI_OutlineConfiguration_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch (notification.getFeatureID(OutlineConfiguration.class))
        {
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__NAME:
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PROJECT_NAME:
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__PLUGIN_CLASS_NAME:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case OutlineConfiguratorPackage.OUTLINE_CONFIGURATION__CREATE_CHILD:
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

        newChildDescriptors.add(createChildParameter(OutlineConfiguratorPackage.Literals.OUTLINE_CONFIGURATION__CREATE_CHILD, OutlineConfiguratorFactory.eINSTANCE.createCreateChildMenuConfiguration()));
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
