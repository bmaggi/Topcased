/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.topcased.modeler.configurator.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.ConfiguratorPlugin;
import org.topcased.modeler.configurator.EdgeObject;
import org.topcased.modeler.configurator.EdgeObjectType;
import org.topcased.modeler.configurator.ModelObjectConfiguration;
import org.topcased.modeler.configurator.PartConfiguration;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.configurator.EdgeObject} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EdgeObjectItemProvider
    extends ItemProviderAdapter
    implements	
        IEditingDomainItemProvider,	
        IStructuredItemContentProvider,	
        ITreeItemContentProvider,	
        IItemLabelProvider,	
        IItemPropertySource		
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EdgeObjectItemProvider(AdapterFactory adapterFactory)
    {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public List getPropertyDescriptors(Object object)
    {
        if (itemPropertyDescriptors == null)
        {
            super.getPropertyDescriptors(object);

            addTypePropertyDescriptor(object);
            addEStructuralFeaturePropertyDescriptor(object);
            addIdPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Type feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTypePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EdgeObject_type_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_EdgeObject_type_feature", "_UI_EdgeObject_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getEdgeObject_Type(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the EStructural Feature feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addEStructuralFeaturePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(
                ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_EdgeObject_eStructuralFeature_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_EdgeObject_eStructuralFeature_feature", "_UI_EdgeObject_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                ConfiguratorPackage.eINSTANCE.getEdgeObject_EStructuralFeature(),
                true, null, null, null) {
            /**
             * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getComboBoxObjects(java.lang.Object)
             */
            protected Collection getComboBoxObjects(Object object) {
                List containments = new ArrayList();
                if (object instanceof EdgeObject)
                {
                    if (((EdgeObject) object).eContainer() instanceof PartConfiguration)
                    {
                        if (((PartConfiguration) ((EdgeObject) object).eContainer()).getObject() instanceof ModelObjectConfiguration)
                        {
                            containments.addAll(((ModelObjectConfiguration) ((PartConfiguration) ((EdgeObject) object).eContainer()).getObject()).getGenClass().getEcoreClass().getEAllStructuralFeatures());
                            if (!containments.contains(null))
                            {
                                containments.add(null);
                            }
                        }
                    }
                }
                return containments;
            }
        });
    }

    /**
     * This adds a property descriptor for the Id feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addIdPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EdgeObject_id_feature"), //$NON-NLS-1$
                 getString("_UI_EdgeObject_id_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getEdgeObject_Id(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This returns EdgeObject.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object getImage(Object object)
    {
        return getResourceLocator().getImage("full/obj16/EdgeObject"); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public String getText(Object object)
    {
        String name = ((EdgeObject)object).getId();

        return name == null || name.length() == 0 ?
            getString("_UI_EdgeObject_type") : //$NON-NLS-1$
            getString("_UI_EdgeObject_type") + " " + name; //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void notifyChanged(Notification notification)
    {
        updateChildren(notification);

        switch (notification.getFeatureID(EdgeObject.class))
        {
            case ConfiguratorPackage.EDGE_OBJECT__TYPE:
            case ConfiguratorPackage.EDGE_OBJECT__ESTRUCTURAL_FEATURE:
            case ConfiguratorPackage.EDGE_OBJECT__ID:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
     * describing all of the children that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object)
    {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceLocator getResourceLocator()
    {
        return ConfiguratorPlugin.INSTANCE;
    }

}
