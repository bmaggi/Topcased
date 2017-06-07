/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
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
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.topcased.modeler.configurator.ConfiguratorFactory;
import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.ConfiguratorPlugin;
import org.topcased.modeler.configurator.EdgePartConfiguration;
import org.topcased.modeler.configurator.ModelObjectConfiguration;
import org.topcased.modeler.configurator.ObjectConfiguration;
import org.topcased.modeler.configurator.PartConfiguration;
import org.topcased.modeler.configurator.SimpleObjectConfiguration;

/**
 * This is the item provider adpater for a
 * {@link org.topcased.modeler.configurator.EdgePartConfiguration}object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EdgePartConfigurationItemProvider extends PartConfigurationItemProvider implements
        IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EdgePartConfigurationItemProvider(AdapterFactory adapterFactory)
    {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public List getPropertyDescriptors(Object object)
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSourceDecorationPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EdgePartConfiguration_sourceDecoration_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_EdgePartConfiguration_sourceDecoration_feature", "_UI_EdgePartConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getEdgePartConfiguration_SourceDecoration(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Target Decoration feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTargetDecorationPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EdgePartConfiguration_targetDecoration_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_EdgePartConfiguration_targetDecoration_feature", "_UI_EdgePartConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getEdgePartConfiguration_TargetDecoration(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Default Router feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultRouterPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EdgePartConfiguration_defaultRouter_feature"), //$NON-NLS-1$
                 getString("_UI_EdgePartConfiguration_defaultRouter_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getEdgePartConfiguration_DefaultRouter(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Direct Editable feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addDirectEditablePropertyDescriptor(Object object)
    {
//        itemPropertyDescriptors.add
//            (createItemPropertyDescriptor
//                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
//                 getResourceLocator(),
//                 getString("_UI_EdgePartConfiguration_directEditable_feature"), //$NON-NLS-1$
//                 getString("_UI_EdgePartConfiguration_directEditable_description"), //$NON-NLS-1$
//                 ConfiguratorPackage.eINSTANCE.getEdgePartConfiguration_DirectEditable(),
//                 true,
//                 null,
//                 getString("_UI_GraphicPropertiesPropertyCategory"), //$NON-NLS-1$
//                 null));

        itemPropertyDescriptors.add(new ItemPropertyDescriptor(
                ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_EdgePartConfiguration_directEditable_feature"), //$NON-NLS-1$
                getString("_UI_EdgePartConfiguration_directEditable_description"), //$NON-NLS-1$
                ConfiguratorPackage.eINSTANCE.getEdgePartConfiguration_DirectEditable(),
                true, 
                null,
                getString("_UI_GraphicPropertiesPropertyCategory"), //$NON-NLS-1$
                null) {
            /**
             * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getComboBoxObjects(java.lang.Object)
             */
            protected Collection getComboBoxObjects(Object object)
            {
                List containments = new ArrayList();
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Collection getChildrenFeatures(Object object)
    {
        if (childrenFeatures == null)
        {
            super.getChildrenFeatures(object);
            childrenFeatures.add(ConfiguratorPackage.eINSTANCE.getEdgePartConfiguration_SourceTargetCouple());
            childrenFeatures.add(ConfiguratorPackage.eINSTANCE.getEdgePartConfiguration_EdgeObjects());
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EStructuralFeature getChildFeature(Object object, Object child)
    {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns EdgePartConfiguration.gif.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public Object getImage(Object object)
    {
        return getResourceLocator().getImage("full/obj16/EdgePartConfiguration"); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getText(Object object)
    {
        PartConfiguration partConf = (PartConfiguration) object;
        String genClassText = "";
        if (partConf.getObject() != null)
        {
            ObjectConfiguration objConf = partConf.getObject();
            if (objConf instanceof ModelObjectConfiguration)
            {
                if (((ModelObjectConfiguration) objConf).getGenClass() != null)
                    genClassText = ((ModelObjectConfiguration) objConf).getGenClass().getName();
            }
            else if (objConf instanceof SimpleObjectConfiguration)
            {
                if (((SimpleObjectConfiguration) objConf).getName() != null)
                    genClassText = ((SimpleObjectConfiguration) objConf).getName();
            }
        }
        return getString("_UI_EdgePartConfiguration_type") + " " + genClassText; //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public void notifyChanged(Notification notification)
    {
        updateChildren(notification);

        switch (notification.getFeatureID(EdgePartConfiguration.class))
        {
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_DECORATION:
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__TARGET_DECORATION:
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__DEFAULT_ROUTER:
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__DIRECT_EDITABLE:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__SOURCE_TARGET_COUPLE:
            case ConfiguratorPackage.EDGE_PART_CONFIGURATION__EDGE_OBJECTS:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
     * describing all of the children that can be created under this object.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object)
    {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add
            (createChildParameter
                (ConfiguratorPackage.eINSTANCE.getEdgePartConfiguration_SourceTargetCouple(),
                 ConfiguratorFactory.eINSTANCE.createSourceTargetCouple()));

        newChildDescriptors.add
            (createChildParameter
                (ConfiguratorPackage.eINSTANCE.getEdgePartConfiguration_EdgeObjects(),
                 ConfiguratorFactory.eINSTANCE.createEdgeObject()));
    }

    /**
     * Return the resource locator for this item provider's resources. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceLocator getResourceLocator()
    {
        return ConfiguratorPlugin.INSTANCE;
    }

}
