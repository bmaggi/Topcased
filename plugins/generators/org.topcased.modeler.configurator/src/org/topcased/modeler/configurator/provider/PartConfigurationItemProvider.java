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
import org.topcased.modeler.configurator.ModelObjectConfiguration;
import org.topcased.modeler.configurator.ObjectConfiguration;
import org.topcased.modeler.configurator.PartConfiguration;
import org.topcased.modeler.configurator.SimpleObjectConfiguration;

/**
 * This is the item provider adpater for a
 * {@link org.topcased.modeler.configurator.PartConfiguration}object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class PartConfigurationItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PartConfigurationItemProvider(AdapterFactory adapterFactory)
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

            addObjectPropertyDescriptor(object);
            addDefaultForegroundColorPropertyDescriptor(object);
            addForegroundColorChangeablePropertyDescriptor(object);
            addFontChangeablePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Object feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addObjectPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_PartConfiguration_object_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_PartConfiguration_object_feature", "_UI_PartConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getPartConfiguration_Object(),
                 true,
                 null,
                 getString("_UI_ModelPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Default Foreground Color feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultForegroundColorPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_PartConfiguration_defaultForegroundColor_feature"), //$NON-NLS-1$
                 getString("_UI_PartConfiguration_defaultForegroundColor_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getPartConfiguration_DefaultForegroundColor(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Foreground Color Changeable feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addForegroundColorChangeablePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_PartConfiguration_foregroundColorChangeable_feature"), //$NON-NLS-1$
                 getString("_UI_PartConfiguration_foregroundColorChangeable_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getPartConfiguration_ForegroundColorChangeable(),
                 true,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 getString("_UI_PoliciesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This adds a property descriptor for the Font Changeable feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addFontChangeablePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_PartConfiguration_fontChangeable_feature"), //$NON-NLS-1$
                 getString("_UI_PartConfiguration_fontChangeable_description"), //$NON-NLS-1$
                 ConfiguratorPackage.eINSTANCE.getPartConfiguration_FontChangeable(),
                 true,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 getString("_UI_PoliciesPropertyCategory"), //$NON-NLS-1$
                 null));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
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
        return getString("_UI_PartConfiguration_type") + " " + genClassText; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch (notification.getFeatureID(PartConfiguration.class))
        {
            case ConfiguratorPackage.PART_CONFIGURATION__OBJECT:
            case ConfiguratorPackage.PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
            case ConfiguratorPackage.PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
            case ConfiguratorPackage.PART_CONFIGURATION__FONT_CHANGEABLE:
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
