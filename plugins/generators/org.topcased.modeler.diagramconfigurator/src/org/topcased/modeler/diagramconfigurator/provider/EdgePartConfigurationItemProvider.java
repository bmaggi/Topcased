/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgePartConfigurationItemProvider.java,v 1.12 2008/04/15 10:09:40 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorFactory;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.EdgeObject;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.diagramconfigurator.EdgePartConfiguration} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class EdgePartConfigurationItemProvider extends PartConfigurationItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
        IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EdgePartConfigurationItemProvider(AdapterFactory adapterFactory)
    {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
    {
        if (itemPropertyDescriptors == null)
        {
            super.getPropertyDescriptors(object);

            addSourceDecorationPropertyDescriptor(object);
            addTargetDecorationPropertyDescriptor(object);
            addDefaultRouterPropertyDescriptor(object);
            addDirectEditablePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Source Decoration feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addSourceDecorationPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EdgePartConfiguration_sourceDecoration_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_EdgePartConfiguration_sourceDecoration_feature", "_UI_EdgePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.EDGE_PART_CONFIGURATION__SOURCE_DECORATION,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Target Decoration feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addTargetDecorationPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EdgePartConfiguration_targetDecoration_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_EdgePartConfiguration_targetDecoration_feature", "_UI_EdgePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.EDGE_PART_CONFIGURATION__TARGET_DECORATION,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Default Router feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultRouterPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EdgePartConfiguration_defaultRouter_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_EdgePartConfiguration_defaultRouter_feature", "_UI_EdgePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.EDGE_PART_CONFIGURATION__DEFAULT_ROUTER,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Direct Editable feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addDirectEditablePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EdgePartConfiguration_directEditable_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description"), //$NON-NLS-1$
                DiagramconfiguratorPackage.eINSTANCE.getEdgePartConfiguration_DirectEditable(), true, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_PoliciesPropertyCategory"), null)
        {
            /**
             * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getComboBoxObjects(java.lang.Object)
             */
            protected Collection<EdgeObject> getComboBoxObjects(Object object)
            {
                List<EdgeObject> containments = new ArrayList<EdgeObject>();
                EdgePartConfiguration edgePart = (EdgePartConfiguration) object;

                containments.addAll(edgePart.getEdgeObjects());
                if (!containments.contains(null))
                {
                    containments.add(null);
                }
                return containments;
            }
        });
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
    {
        if (childrenFeatures == null)
        {
            super.getChildrenFeatures(object);
            childrenFeatures.add(DiagramconfiguratorPackage.Literals.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE);
            childrenFeatures.add(DiagramconfiguratorPackage.Literals.EDGE_PART_CONFIGURATION__EDGE_OBJECTS);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child)
    {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns EdgePartConfiguration.gif.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/EdgePartConfiguration"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object)
    {
        String label = ((EdgePartConfiguration)object).getPrefix();
        return label == null || label.length() == 0 ?
            getString("_UI_EdgePartConfiguration_type") :
            getString("_UI_EdgePartConfiguration_type") + " " + label;
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

        switch (notification.getFeatureID(EdgePartConfiguration.class))
        {
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_DECORATION:
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__TARGET_DECORATION:
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_ROUTER:
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__DIRECT_EDITABLE:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE:
            case DiagramconfiguratorPackage.EDGE_PART_CONFIGURATION__EDGE_OBJECTS:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
    {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add
            (createChildParameter
                (DiagramconfiguratorPackage.Literals.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE,
                 DiagramconfiguratorFactory.eINSTANCE.createSourceTargetCouple()));

        newChildDescriptors.add
            (createChildParameter
                (DiagramconfiguratorPackage.Literals.EDGE_PART_CONFIGURATION__EDGE_OBJECTS,
                 DiagramconfiguratorFactory.eINSTANCE.createEdgeObject()));
    }

}