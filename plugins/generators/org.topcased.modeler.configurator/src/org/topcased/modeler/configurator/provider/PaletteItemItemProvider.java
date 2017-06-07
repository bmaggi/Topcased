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
import org.topcased.modeler.configurator.DiagramConfiguration;
import org.topcased.modeler.configurator.PaletteItem;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.configurator.PaletteItem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PaletteItemItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PaletteItemItemProvider(AdapterFactory adapterFactory)
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
            addPartPropertyDescriptor(object);
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
                 getString("_UI_PaletteItem_name_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_PaletteItem_name_feature", "_UI_PaletteItem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getPaletteItem_Name(),
                 true,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Part feature.
     * <!-- begin-user-doc -->
     * Only display partConfiguration of the current diagram
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected void addPartPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(
                ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_PaletteItem_part_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_PaletteItem_part_feature", "_UI_PaletteItem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getPaletteItem_Part(),
                 true,
                 null,
                 null,
                 null)
        {
            public Collection getComboBoxObjects(Object obj)
            {
                List result = new ArrayList();
                PaletteItem palItem = (PaletteItem) obj;
                DiagramConfiguration diagConf = (DiagramConfiguration) palItem.eContainer().eContainer().eContainer();
                result.addAll(diagConf.getParts());
                return result;
            }
        });                  
    }

    /**
     * This returns PaletteItem.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object getImage(Object object)
    {
        return getResourceLocator().getImage("full/obj16/PaletteItem"); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getText(Object object)
    {
        String label = ((PaletteItem)object).getName();
        return label == null || label.length() == 0 ?
            getString("_UI_PaletteItem_type") : //$NON-NLS-1$
            getString("_UI_PaletteItem_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch (notification.getFeatureID(PaletteItem.class))
        {
            case ConfiguratorPackage.PALETTE_ITEM__NAME:
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
