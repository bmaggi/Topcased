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
import org.topcased.modeler.configurator.ConfiguratorFactory;
import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.ConfiguratorPlugin;
import org.topcased.modeler.configurator.ModelObjectConfiguration;
import org.topcased.modeler.configurator.ObjectConfiguration;
import org.topcased.modeler.configurator.SimpleObjectConfiguration;

/**
 * This is the item provider adpater for a
 * {@link org.topcased.modeler.configurator.ObjectConfiguration}object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ObjectConfigurationItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ObjectConfigurationItemProvider(AdapterFactory adapterFactory)
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

        }
        return itemPropertyDescriptors;
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getText(Object object)
    {
        ObjectConfiguration objConf = (ObjectConfiguration) object;
        String genClassText = "";
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
        return getString("_UI_ObjectConfiguration_type") + " " + genClassText; //$NON-NLS-1$
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
