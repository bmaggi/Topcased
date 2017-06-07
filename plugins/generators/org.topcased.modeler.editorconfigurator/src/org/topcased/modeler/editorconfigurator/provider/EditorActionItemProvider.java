/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditorActionItemProvider.java,v 1.1 2007/04/18 12:54:47 jako Exp $
 */
package org.topcased.modeler.editorconfigurator.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.topcased.modeler.editorconfigurator.EditorAction;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage;
import org.topcased.modeler.editorconfigurator.internal.EditorConfiguratorPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.editorconfigurator.EditorAction} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EditorActionItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "";

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EditorActionItemProvider(AdapterFactory adapterFactory)
    {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
    {
        if (itemPropertyDescriptors == null)
        {
            super.getPropertyDescriptors(object);

            addPrefixPropertyDescriptor(object);
            addMenuBarGroupPropertyDescriptor(object);
            addLabelPropertyDescriptor(object);
            addIconPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Prefix feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPrefixPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EditorAction_prefix_feature"), getString("_UI_PropertyDescriptor_description", "_UI_EditorAction_prefix_feature", "_UI_EditorAction_type"),
                EditorconfiguratorPackage.Literals.EDITOR_ACTION__PREFIX, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Menu Bar Group feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addMenuBarGroupPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EditorAction_menuBarGroup_feature"), getString("_UI_PropertyDescriptor_description", "_UI_EditorAction_menuBarGroup_feature", "_UI_EditorAction_type"),
                EditorconfiguratorPackage.Literals.EDITOR_ACTION__MENU_BAR_GROUP, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Label feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addLabelPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EditorAction_label_feature"), getString("_UI_PropertyDescriptor_description", "_UI_EditorAction_label_feature", "_UI_EditorAction_type"),
                EditorconfiguratorPackage.Literals.EDITOR_ACTION__LABEL, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Icon feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addIconPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EditorAction_icon_feature"), getString("_UI_PropertyDescriptor_description", "_UI_EditorAction_icon_feature", "_UI_EditorAction_type"),
                EditorconfiguratorPackage.Literals.EDITOR_ACTION__ICON, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns EditorAction.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/EditorAction"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object)
    {
        String label = ((EditorAction) object).getLabel();
        return label == null || label.length() == 0 ? getString("_UI_EditorAction_type") : getString("_UI_EditorAction_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
     * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification)
    {
        updateChildren(notification);

        switch (notification.getFeatureID(EditorAction.class))
        {
            case EditorconfiguratorPackage.EDITOR_ACTION__PREFIX:
            case EditorconfiguratorPackage.EDITOR_ACTION__MENU_BAR_GROUP:
            case EditorconfiguratorPackage.EDITOR_ACTION__LABEL:
            case EditorconfiguratorPackage.EDITOR_ACTION__ICON:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
     * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
    {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator()
    {
        return EditorConfiguratorPlugin.INSTANCE;
    }

}
