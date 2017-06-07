/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgeObjectItemProvider.java,v 1.10 2007/04/18 12:21:19 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.provider;

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
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.EdgeObject;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;
import org.topcased.modeler.diagramconfigurator.internal.DiagramConfiguratorPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.diagramconfigurator.EdgeObject} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EdgeObjectItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EdgeObjectItemProvider(AdapterFactory adapterFactory)
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

            addIdPropertyDescriptor(object);
            addTypePropertyDescriptor(object);
            addEStructuralFeaturePropertyDescriptor(object);
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
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_EdgeObject_id_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_EdgeObject_id_feature", "_UI_EdgeObject_type"), DiagramconfiguratorPackage.Literals.EDGE_OBJECT__ID, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Type feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addTypePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_EdgeObject_type_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_EdgeObject_type_feature", "_UI_EdgeObject_type"), DiagramconfiguratorPackage.Literals.EDGE_OBJECT__TYPE, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the EStructural Feature feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated NOT
     */
    protected void addEStructuralFeaturePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EdgeObject_eStructuralFeature_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_EdgeObject_eStructuralFeature_feature", "_UI_EdgeObject_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DiagramconfiguratorPackage.eINSTANCE.getEdgeObject_EStructuralFeature(), true, null, null, null)
        {
            /**
             * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getComboBoxObjects(java.lang.Object)
             */
            protected Collection<EStructuralFeature> getComboBoxObjects(Object object)
            {
                List<EStructuralFeature> containments = new ArrayList<EStructuralFeature>();
                if (object instanceof EdgeObject)
                {
                    if (((EdgeObject) object).eContainer() instanceof PartConfiguration && ((PartConfiguration) ((EdgeObject) object).eContainer()).getObject() instanceof ModelObjectConfiguration)
                    {
                        containments.addAll(((ModelObjectConfiguration) ((PartConfiguration) ((EdgeObject) object).eContainer()).getObject()).getGenClass().getEcoreClass().getEAllStructuralFeatures());
                        if (!containments.contains(null))
                        {
                            containments.add(null);
                        }
                    }
                }
                return containments;
            }
        });
    }

    /**
     * This returns EdgeObject.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/EdgeObject"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object)
    {
        String label = ((EdgeObject) object).getId();
        return label == null || label.length() == 0 ? getString("_UI_EdgeObject_type") : getString("_UI_EdgeObject_type") + " " + label;
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

        switch (notification.getFeatureID(EdgeObject.class))
        {
            case DiagramconfiguratorPackage.EDGE_OBJECT__ID:
            case DiagramconfiguratorPackage.EDGE_OBJECT__TYPE:
            case DiagramconfiguratorPackage.EDGE_OBJECT__ESTRUCTURAL_FEATURE:
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
        return DiagramConfiguratorPlugin.INSTANCE;
    }

}