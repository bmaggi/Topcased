/**
 * <copyright> </copyright>
 * 
 * $Id: CreateChildActionItemProvider.java,v 1.2 2006/12/19 12:47:43 jako Exp $
 */
package org.topcased.outline.configurator.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
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
import org.topcased.outline.configurator.CreateChildAction;
import org.topcased.outline.configurator.OutlineConfiguratorPackage;
import org.topcased.outline.configurator.internal.ConfiguratorPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.outline.configurator.CreateChildAction} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class CreateChildActionItemProvider extends MenuItemItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
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
    public CreateChildActionItemProvider(AdapterFactory adapterFactory)
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

            addClassPropertyDescriptor(object);
            addTypePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Class feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addClassPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_CreateChildAction_class_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_CreateChildAction_class_feature", "_UI_CreateChildAction_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                OutlineConfiguratorPackage.Literals.CREATE_CHILD_ACTION__CLASS, true, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Type feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addTypePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_CreateChildAction_type_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_CreateChildAction_type_feature", "_UI_CreateChildAction_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                OutlineConfiguratorPackage.Literals.CREATE_CHILD_ACTION__TYPE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns CreateChildAction.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/CreateChildAction")); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getText(Object object)
    {
        GenClass labelValue = ((CreateChildAction) object).getClass_();
        String label = labelValue == null ? null : labelValue.getInterfaceName();
        return label == null || label.length() == 0 ? getString("_UI_CreateChildAction_type") : //$NON-NLS-1$
                getString("_UI_CreateChildAction_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch (notification.getFeatureID(CreateChildAction.class))
        {
            case OutlineConfiguratorPackage.CREATE_CHILD_ACTION__TYPE:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
