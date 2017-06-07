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
import org.topcased.modeler.configurator.ConfiguratorFactory;
import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.ConfiguratorPlugin;
import org.topcased.modeler.configurator.EditorConfiguration;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.configurator.EditorConfiguration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EditorConfigurationItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EditorConfigurationItemProvider(AdapterFactory adapterFactory)
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

            addNamePropertyDescriptor(object);
            addProjectNamePropertyDescriptor(object);
            addPrefixPropertyDescriptor(object);
            addExtensionPropertyDescriptor(object);
            addExtensionDiagramPropertyDescriptor(object);
            addGenModelPropertyDescriptor(object);
            addPluginVersionPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EditorConfiguration_name_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_name_feature", "_UI_EditorConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getEditorConfiguration_Name(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Project Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addProjectNamePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EditorConfiguration_projectName_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_projectName_feature", "_UI_EditorConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getEditorConfiguration_ProjectName(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Prefix feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addPrefixPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EditorConfiguration_prefix_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_prefix_feature", "_UI_EditorConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getEditorConfiguration_Prefix(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Extension feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addExtensionPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EditorConfiguration_extension_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_extension_feature", "_UI_EditorConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getEditorConfiguration_Extension(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Extension Diagram feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addExtensionDiagramPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EditorConfiguration_extensionDiagram_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_extensionDiagram_feature", "_UI_EditorConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getEditorConfiguration_ExtensionDiagram(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Gen Model feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addGenModelPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EditorConfiguration_genModel_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_genModel_feature", "_UI_EditorConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getEditorConfiguration_GenModel(),
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Plugin Version feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addPluginVersionPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_EditorConfiguration_pluginVersion_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_pluginVersion_feature", "_UI_EditorConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getEditorConfiguration_PluginVersion(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
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
            childrenFeatures.add(ConfiguratorPackage.eINSTANCE.getEditorConfiguration_Diagrams());
            childrenFeatures.add(ConfiguratorPackage.eINSTANCE.getEditorConfiguration_Objects());
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
     * This returns EditorConfiguration.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object getImage(Object object)
    {
        return getResourceLocator().getImage("full/obj16/EditorConfiguration"); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getText(Object object)
    {
        String label = ((EditorConfiguration)object).getName();
        return label == null || label.length() == 0 ?
            getString("_UI_EditorConfiguration_type") : //$NON-NLS-1$
            getString("_UI_EditorConfiguration_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch (notification.getFeatureID(EditorConfiguration.class))
        {
            case ConfiguratorPackage.EDITOR_CONFIGURATION__NAME:
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PROJECT_NAME:
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PREFIX:
            case ConfiguratorPackage.EDITOR_CONFIGURATION__EXTENSION:
            case ConfiguratorPackage.EDITOR_CONFIGURATION__EXTENSION_DIAGRAM:
            case ConfiguratorPackage.EDITOR_CONFIGURATION__GEN_MODEL:
            case ConfiguratorPackage.EDITOR_CONFIGURATION__PLUGIN_VERSION:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case ConfiguratorPackage.EDITOR_CONFIGURATION__DIAGRAMS:
            case ConfiguratorPackage.EDITOR_CONFIGURATION__OBJECTS:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

        newChildDescriptors.add
            (createChildParameter
                (ConfiguratorPackage.eINSTANCE.getEditorConfiguration_Diagrams(),
                 ConfiguratorFactory.eINSTANCE.createDiagramConfiguration()));

        newChildDescriptors.add
            (createChildParameter
                (ConfiguratorPackage.eINSTANCE.getEditorConfiguration_Objects(),
                 ConfiguratorFactory.eINSTANCE.createModelObjectConfiguration()));

        newChildDescriptors.add
            (createChildParameter
                (ConfiguratorPackage.eINSTANCE.getEditorConfiguration_Objects(),
                 ConfiguratorFactory.eINSTANCE.createSimpleObjectConfiguration()));
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
