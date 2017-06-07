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
import org.topcased.modeler.configurator.DiagramReference;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.configurator.DiagramReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagramReferenceItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DiagramReferenceItemProvider(AdapterFactory adapterFactory)
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

            addDiagramPropertyDescriptor(object);
            addLowerBoundPropertyDescriptor(object);
            addUpperBoundPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Diagram feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDiagramPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DiagramReference_diagram_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_DiagramReference_diagram_feature", "_UI_DiagramReference_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getDiagramReference_Diagram(),
                 true,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Lower Bound feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addLowerBoundPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DiagramReference_lowerBound_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_DiagramReference_lowerBound_feature", "_UI_DiagramReference_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getDiagramReference_LowerBound(),
                 true,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Upper Bound feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addUpperBoundPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DiagramReference_upperBound_feature"), //$NON-NLS-1$
                 getString("_UI_PropertyDescriptor_description", "_UI_DiagramReference_upperBound_feature", "_UI_DiagramReference_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                 ConfiguratorPackage.eINSTANCE.getDiagramReference_UpperBound(),
                 true,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This returns DiagramReference.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object getImage(Object object)
    {
        return getResourceLocator().getImage("full/obj16/DiagramReference"); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    public String getText(Object object)
    {
        DiagramReference diagRef = (DiagramReference) object;
        String diagConfText = "";
        if (diagRef.getDiagram() != null)
            diagConfText = diagRef.getDiagram().getName();
        return getString("_UI_DiagramReference_type") + " " + diagConfText; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch (notification.getFeatureID(DiagramReference.class))
        {
            case ConfiguratorPackage.DIAGRAM_REFERENCE__DIAGRAM:
            case ConfiguratorPackage.DIAGRAM_REFERENCE__LOWER_BOUND:
            case ConfiguratorPackage.DIAGRAM_REFERENCE__UPPER_BOUND:
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
