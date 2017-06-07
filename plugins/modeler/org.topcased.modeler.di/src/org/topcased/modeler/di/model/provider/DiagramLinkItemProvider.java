/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramLinkItemProvider.java,v 1.11 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
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
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.DiagramLink;
import org.topcased.modeler.di.model.internal.DIPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.di.model.DiagramLink} object.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class DiagramLinkItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
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
    public DiagramLinkItemProvider(AdapterFactory adapterFactory)
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

            addZoomPropertyDescriptor(object);
            addViewportPropertyDescriptor(object);
            addDiagramPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Zoom feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addZoomPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_DiagramLink_zoom_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_DiagramLink_zoom_feature", "_UI_DiagramLink_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DiagramInterchangePackage.Literals.DIAGRAM_LINK__ZOOM, true, false, false,
                ItemPropertyDescriptor.REAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Viewport feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addViewportPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_DiagramLink_viewport_feature"), //$NON-NLS-1$
                getString(
                        "_UI_PropertyDescriptor_description", "_UI_DiagramLink_viewport_feature", "_UI_DiagramLink_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DiagramInterchangePackage.Literals.DIAGRAM_LINK__VIEWPORT, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Diagram feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addDiagramPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_DiagramLink_diagram_feature"), //$NON-NLS-1$
                getString(
                        "_UI_PropertyDescriptor_description", "_UI_DiagramLink_diagram_feature", "_UI_DiagramLink_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DiagramInterchangePackage.Literals.DIAGRAM_LINK__DIAGRAM, true, false, false, null, null, null));
    }

    /**
     * This returns DiagramLink.gif.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/DiagramLink")); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object)
    {
        DiagramLink diagramLink = (DiagramLink) object;
        return getString("_UI_DiagramLink_type") + " " + diagramLink.getZoom(); //$NON-NLS-1$ //$NON-NLS-2$
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

        switch (notification.getFeatureID(DiagramLink.class))
        {
            case DiagramInterchangePackage.DIAGRAM_LINK__ZOOM:
            case DiagramInterchangePackage.DIAGRAM_LINK__VIEWPORT:
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

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator()
    {
        return DIPlugin.INSTANCE;
    }

}
