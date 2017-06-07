/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgeGraphConfItemProvider.java,v 1.4 2006/12/18 15:21:43 jako Exp $
 */
package org.topcased.modeler.graphconf.provider;

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
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.topcased.modeler.graphconf.EMFBridge;
import org.topcased.modeler.graphconf.EdgeGraphConf;
import org.topcased.modeler.graphconf.GraphconfPackage;
import org.topcased.modeler.graphconf.StringBridge;
import org.topcased.modeler.graphconf.internal.GraphConfPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.graphconf.EdgeGraphConf} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EdgeGraphConfItemProvider extends AbstractGraphConfItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EdgeGraphConfItemProvider(AdapterFactory adapterFactory)
    {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public List getPropertyDescriptors(Object object)
    {
        if (itemPropertyDescriptors == null)
        {
            super.getPropertyDescriptors(object);

            addDefaultRouterPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Default Router feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDefaultRouterPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EdgeGraphConf_defaultRouter_feature"), getString("_UI_PropertyDescriptor_description", "_UI_EdgeGraphConf_defaultRouter_feature", "_UI_EdgeGraphConf_type"),
                GraphconfPackage.Literals.EDGE_GRAPH_CONF__DEFAULT_ROUTER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns EdgeGraphConf.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/EdgeGraphConf"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getText(Object object)
    {
        String type = "";
        if (((EdgeGraphConf) object).getBridge() instanceof StringBridge)
        {
            type = ((StringBridge) ((EdgeGraphConf) object).getBridge()).getType();
        }
        else if (((EdgeGraphConf) object).getBridge() instanceof EMFBridge)
        {
            if (((EMFBridge) ((EdgeGraphConf) object).getBridge()).getType() != null)
            {
                type = ((EMFBridge) ((EdgeGraphConf) object).getBridge()).getType().getName();
            }
        }
        String presentation = ((EdgeGraphConf) object).getPresentation();
        String label = type + " <<" + presentation + ">>";
        return label == null || label.length() == 0 ? getString("_UI_EdgeGraphConf_type") : getString("_UI_EdgeGraphConf_type") + " : " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
     * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    public void notifyChanged(Notification notification)
    {
        updateChildren(notification);

        switch (notification.getFeatureID(EdgeGraphConf.class))
        {
            case GraphconfPackage.EDGE_GRAPH_CONF__DEFAULT_ROUTER:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s describing all of the
     * children that can be created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object)
    {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceLocator getResourceLocator()
    {
        return GraphConfPlugin.INSTANCE;
    }

}
