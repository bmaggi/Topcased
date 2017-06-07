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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.ConfiguratorPlugin;
import org.topcased.modeler.configurator.DiagramConfiguration;
import org.topcased.modeler.configurator.ModelObjectConfiguration;
import org.topcased.modeler.configurator.NodePartConfiguration;
import org.topcased.modeler.configurator.ObjectConfiguration;
import org.topcased.modeler.configurator.PartConfiguration;
import org.topcased.modeler.configurator.SimpleObjectConfiguration;
import org.topcased.modeler.configurator.util.FigureDeclarationManager;

/**
 * This is the item provider adpater for a
 * {@link org.topcased.modeler.configurator.NodePartConfiguration}object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class NodePartConfigurationItemProvider extends PartConfigurationItemProvider implements
        IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NodePartConfigurationItemProvider(AdapterFactory adapterFactory)
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

            addTypePropertyDescriptor(object);
            addChildElementsPropertyDescriptor(object);
            addSuperTypePropertyDescriptor(object);
            addDefaultBackgroundColorPropertyDescriptor(object);
            addBackgroundColorChangeablePropertyDescriptor(object);
            addResizingPropertyDescriptor(object);
            addContainerPropertyDescriptor(object);
            addLayoutPropertyDescriptor(object);
            addDirectEditablePropertyDescriptor(object);
            addDefaultWidthPropertyDescriptor(object);
            addDefaultHeightPropertyDescriptor(object);
            addMinimumWidthPropertyDescriptor(object);
            addMinimumHeightPropertyDescriptor(object);
            addMaximumWidthPropertyDescriptor(object);
            addMaximumHeightPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Type feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addTypePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_NodePartConfiguration_type_feature"), //$NON-NLS-1$
                getString(
                        "_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_type_feature", "_UI_NodePartConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_Type(), true,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null)
        {
            protected Collection getComboBoxObjects(Object object)
            {
                // get all the available types from the extension points
                Set types = FigureDeclarationManager.getInstance().getFigureDeclarationIds();
                return types;
            }
        });
    }

    /**
     * This adds a property descriptor for the Child Elements feature.
     * <!-- begin-user-doc -->
     * Only display nodePartConfiguration of the current diagram
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addChildElementsPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(
                ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_childElements_feature"), //$NON-NLS-1$
                 getString("_UI_NodePartConfiguration_childElements_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_ChildElements(),
                 true,
                 null,
                 getString("_UI_ModelPropertyCategory"), //$NON-NLS-1$
                 null)
        {
            public Collection getComboBoxObjects(Object obj)
            {
                List result = new ArrayList();
                NodePartConfiguration nodePartConf = (NodePartConfiguration) obj;
                EList parts = ((DiagramConfiguration) nodePartConf.eContainer()).getParts();
                for (Iterator iter = parts.iterator(); iter.hasNext();)
                {
                    PartConfiguration partConf = (PartConfiguration) iter.next();
                    if (partConf instanceof NodePartConfiguration)
                    {
                        result.add(partConf);
                    }
                }
                return result;
            }
        });  
    }

    /**
     * This adds a property descriptor for the Super Type feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSuperTypePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_superType_feature"), //$NON-NLS-1$
                 getString("_UI_NodePartConfiguration_superType_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_SuperType(),
                 true,
                 null,
                 getString("_UI_ModelPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Default Width feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultWidthPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_defaultWidth_feature"), //$NON-NLS-1$
                 getString("_UI_NodePartConfiguration_defaultWidth_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_DefaultWidth(),
                 true,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Default Height feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultHeightPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_defaultHeight_feature"), //$NON-NLS-1$
                 getString("_UI_NodePartConfiguration_defaultHeight_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_DefaultHeight(),
                 true,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Minimum Width feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMinimumWidthPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_minimumWidth_feature"), //$NON-NLS-1$
                 getString("_UI_NodePartConfiguration_minimumWidth_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_MinimumWidth(),
                 true,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Minimum Height feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMinimumHeightPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_minimumHeight_feature"), //$NON-NLS-1$
                 getString("_UI_NodePartConfiguration_minimumHeight_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_MinimumHeight(),
                 true,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Maximum Width feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMaximumWidthPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_maximumWidth_feature"), //$NON-NLS-1$
                 getString("_UI_NodePartConfiguration_maximumWidth_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_MaximumWidth(),
                 true,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Maximum Height feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMaximumHeightPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_maximumHeight_feature"), //$NON-NLS-1$
                 getString("_UI_NodePartConfiguration_maximumHeight_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_MaximumHeight(),
                 true,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Default Background Color feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultBackgroundColorPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_defaultBackgroundColor_feature"), //$NON-NLS-1$
                 getString("_UI_NodePartConfiguration_defaultBackgroundColor_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_DefaultBackgroundColor(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Background Color Changeable feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBackgroundColorChangeablePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_backgroundColorChangeable_feature"), //$NON-NLS-1$
                 getString("_UI_NodePartConfiguration_backgroundColorChangeable_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_BackgroundColorChangeable(),
                 true,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 getString("_UI_PoliciesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Resizing feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addResizingPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_resizing_feature"), //$NON-NLS-1$
                 getString("_UI_NodePartConfiguration_resizing_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_Resizing(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getString("_UI_PoliciesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Container feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addContainerPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_container_feature"), //$NON-NLS-1$
                 getString("_UI_NodePartConfiguration_container_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_Container(),
                 true,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 getString("_UI_PoliciesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Direct Editable feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDirectEditablePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_directEditable_feature"), //$NON-NLS-1$
                 getString("_UI_NodePartConfiguration_directEditable_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_DirectEditable(),
                 true,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 getString("_UI_PoliciesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Layout feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addLayoutPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_layout_feature"), //$NON-NLS-1$
                 getString("_UI_NodePartConfiguration_layout_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getNodePartConfiguration_Layout(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This returns NodePartConfiguration.gif.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public Object getImage(Object object)
    {
        return getResourceLocator().getImage("full/obj16/NodePartConfiguration"); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
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
        return getString("_UI_NodePartConfiguration_type") + " " + genClassText; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch (notification.getFeatureID(NodePartConfiguration.class))
        {
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__TYPE:
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__CHILD_ELEMENTS:
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__SUPER_TYPE:
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE:
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__RESIZING:
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__CONTAINER:
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__LAYOUT:
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DIRECT_EDITABLE:
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_WIDTH:
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_HEIGHT:
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_WIDTH:
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_HEIGHT:
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_WIDTH:
            case ConfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
