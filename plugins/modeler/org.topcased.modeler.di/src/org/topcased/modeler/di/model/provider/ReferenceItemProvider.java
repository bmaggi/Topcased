/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReferenceItemProvider.java,v 1.11 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.Reference;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.di.model.Reference} object.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class ReferenceItemProvider extends DiagramElementItemProvider implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ReferenceItemProvider(AdapterFactory adapterFactory)
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

            addIsIndividualRepresentationPropertyDescriptor(object);
            addReferencedPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Is Individual Representation feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected void addIsIndividualRepresentationPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_Reference_isIndividualRepresentation_feature"), //$NON-NLS-1$
                getString(
                        "_UI_PropertyDescriptor_description", "_UI_Reference_isIndividualRepresentation_feature", "_UI_Reference_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DiagramInterchangePackage.Literals.REFERENCE__IS_INDIVIDUAL_REPRESENTATION, true, false, false,
                ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Referenced feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addReferencedPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_Reference_referenced_feature"), //$NON-NLS-1$
                getString(
                        "_UI_PropertyDescriptor_description", "_UI_Reference_referenced_feature", "_UI_Reference_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DiagramInterchangePackage.Literals.REFERENCE__REFERENCED, true, false, false, null, null, null));
    }

    /**
     * This returns Reference.gif.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/Reference")); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object)
    {
        Reference reference = (Reference) object;
        return getString("_UI_Reference_type") + " " + reference.isVisible(); //$NON-NLS-1$ //$NON-NLS-2$
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

        switch (notification.getFeatureID(Reference.class))
        {
            case DiagramInterchangePackage.REFERENCE__IS_INDIVIDUAL_REPRESENTATION:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
    }

}
