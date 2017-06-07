/**
 * <copyright>
 * </copyright>
 *
 * $Id: TabItemProvider.java,v 1.2 2006/12/19 10:05:51 jako Exp $
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
import org.topcased.properties.configurator.Tab;
import org.topcased.properties.configurator.internal.ConfiguratorPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.properties.configurator.Tab} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class TabItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TabItemProvider(AdapterFactory adapterFactory)
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

            addLabelPropertyDescriptor(object);
            addAfterTabPropertyDescriptor(object);
            addIndentedPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Label feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addLabelPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Tab_label_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Tab_label_feature", "_UI_Tab_type"), PropertiesConfiguratorPackage.Literals.TAB__LABEL, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the After Tab feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addAfterTabPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Tab_afterTab_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Tab_afterTab_feature", "_UI_Tab_type"), PropertiesConfiguratorPackage.Literals.TAB__AFTER_TAB, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Indented feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addIndentedPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Tab_indented_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Tab_indented_feature", "_UI_Tab_type"), PropertiesConfiguratorPackage.Literals.TAB__INDENTED, true, false, false,
                ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
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
            childrenFeatures.add(PropertiesConfiguratorPackage.Literals.TAB__SECTIONS);
        }
        return childrenFeatures;
    }

    /**
     * This returns Tab.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/Tab"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getText(Object object)
    {
        String label = ((Tab) object).getLabel();
        return label == null || label.length() == 0 ? getString("_UI_Tab_type") : getString("_UI_Tab_type") + " " + label;
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

        switch (notification.getFeatureID(Tab.class))
        {
            case PropertiesConfiguratorPackage.TAB__ID:
            case PropertiesConfiguratorPackage.TAB__LABEL:
            case PropertiesConfiguratorPackage.TAB__INDENTED:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case PropertiesConfiguratorPackage.TAB__SECTIONS:
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

        newChildDescriptors.add(createChildParameter(PropertiesConfiguratorPackage.Literals.TAB__SECTIONS, PropertiesConfiguratorFactory.eINSTANCE.createSingleFeatureSection()));

        newChildDescriptors.add(createChildParameter(PropertiesConfiguratorPackage.Literals.TAB__SECTIONS, PropertiesConfiguratorFactory.eINSTANCE.createMultipleFeatureSection()));

        newChildDescriptors.add(createChildParameter(PropertiesConfiguratorPackage.Literals.TAB__SECTIONS, PropertiesConfiguratorFactory.eINSTANCE.createAdvancedSection()));
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
