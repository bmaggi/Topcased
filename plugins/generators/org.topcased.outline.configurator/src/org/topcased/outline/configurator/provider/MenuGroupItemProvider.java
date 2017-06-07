/**
 * <copyright>
 * </copyright>
 *
 * $Id: MenuGroupItemProvider.java,v 1.2 2006/12/19 12:47:43 jako Exp $
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
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.topcased.outline.configurator.MenuGroup;
import org.topcased.outline.configurator.OutlineConfiguratorFactory;
import org.topcased.outline.configurator.OutlineConfiguratorPackage;
import org.topcased.outline.configurator.internal.ConfiguratorPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.outline.configurator.MenuGroup} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class MenuGroupItemProvider extends MenuItemItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
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
    public MenuGroupItemProvider(AdapterFactory adapterFactory)
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

            addIdPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Id feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addIdPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_MenuGroup_id_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_MenuGroup_id_feature", "_UI_MenuGroup_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                OutlineConfiguratorPackage.Literals.MENU_GROUP__ID, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
            childrenFeatures.add(OutlineConfiguratorPackage.Literals.MENU_GROUP__ITEMS);
        }
        return childrenFeatures;
    }

    /**
     * This returns MenuGroup.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/MenuGroup")); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getText(Object object)
    {
        String label = ((MenuGroup) object).getId();
        return label == null || label.length() == 0 ? getString("_UI_MenuGroup_type") : //$NON-NLS-1$
                getString("_UI_MenuGroup_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch (notification.getFeatureID(MenuGroup.class))
        {
            case OutlineConfiguratorPackage.MENU_GROUP__ID:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case OutlineConfiguratorPackage.MENU_GROUP__ITEMS:
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

        newChildDescriptors.add(createChildParameter(OutlineConfiguratorPackage.Literals.MENU_GROUP__ITEMS, OutlineConfiguratorFactory.eINSTANCE.createCreateChildAction()));

        newChildDescriptors.add(createChildParameter(OutlineConfiguratorPackage.Literals.MENU_GROUP__ITEMS, OutlineConfiguratorFactory.eINSTANCE.createMenuGroup()));

        newChildDescriptors.add(createChildParameter(OutlineConfiguratorPackage.Literals.MENU_GROUP__ITEMS, OutlineConfiguratorFactory.eINSTANCE.createMenu()));
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
