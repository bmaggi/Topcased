/**
 * <copyright>
 * </copyright>
 *
 * $Id: NodeGraphConfItemProvider.java,v 1.4 2006/12/18 15:21:43 jako Exp $
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
import org.topcased.modeler.graphconf.GraphconfPackage;
import org.topcased.modeler.graphconf.NodeGraphConf;
import org.topcased.modeler.graphconf.StringBridge;
import org.topcased.modeler.graphconf.internal.GraphConfPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.graphconf.NodeGraphConf} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class NodeGraphConfItemProvider extends AbstractGraphConfItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NodeGraphConfItemProvider(AdapterFactory adapterFactory)
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

            addDefaultWidthPropertyDescriptor(object);
            addDefaultHeightPropertyDescriptor(object);
            addMinimumWidthPropertyDescriptor(object);
            addMinimumHeightPropertyDescriptor(object);
            addMaximumWidthPropertyDescriptor(object);
            addMaximumHeightPropertyDescriptor(object);
            addIsWidthResizablePropertyDescriptor(object);
            addIsHeightResizablePropertyDescriptor(object);
            addDefaultBackgroundColorPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Default Width feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDefaultWidthPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NodeGraphConf_defaultWidth_feature"), getString("_UI_PropertyDescriptor_description", "_UI_NodeGraphConf_defaultWidth_feature", "_UI_NodeGraphConf_type"),
                GraphconfPackage.Literals.NODE_GRAPH_CONF__DEFAULT_WIDTH, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Default Height feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDefaultHeightPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NodeGraphConf_defaultHeight_feature"), getString("_UI_PropertyDescriptor_description", "_UI_NodeGraphConf_defaultHeight_feature", "_UI_NodeGraphConf_type"),
                GraphconfPackage.Literals.NODE_GRAPH_CONF__DEFAULT_HEIGHT, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Minimum Width feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addMinimumWidthPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NodeGraphConf_minimumWidth_feature"), getString("_UI_PropertyDescriptor_description", "_UI_NodeGraphConf_minimumWidth_feature", "_UI_NodeGraphConf_type"),
                GraphconfPackage.Literals.NODE_GRAPH_CONF__MINIMUM_WIDTH, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Minimum Height feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addMinimumHeightPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NodeGraphConf_minimumHeight_feature"), getString("_UI_PropertyDescriptor_description", "_UI_NodeGraphConf_minimumHeight_feature", "_UI_NodeGraphConf_type"),
                GraphconfPackage.Literals.NODE_GRAPH_CONF__MINIMUM_HEIGHT, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Maximum Width feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addMaximumWidthPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NodeGraphConf_maximumWidth_feature"), getString("_UI_PropertyDescriptor_description", "_UI_NodeGraphConf_maximumWidth_feature", "_UI_NodeGraphConf_type"),
                GraphconfPackage.Literals.NODE_GRAPH_CONF__MAXIMUM_WIDTH, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Maximum Height feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addMaximumHeightPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NodeGraphConf_maximumHeight_feature"), getString("_UI_PropertyDescriptor_description", "_UI_NodeGraphConf_maximumHeight_feature", "_UI_NodeGraphConf_type"),
                GraphconfPackage.Literals.NODE_GRAPH_CONF__MAXIMUM_HEIGHT, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Is Width Resizable feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addIsWidthResizablePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NodeGraphConf_isWidthResizable_feature"), getString("_UI_PropertyDescriptor_description", "_UI_NodeGraphConf_isWidthResizable_feature", "_UI_NodeGraphConf_type"),
                GraphconfPackage.Literals.NODE_GRAPH_CONF__IS_WIDTH_RESIZABLE, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Is Height Resizable feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    protected void addIsHeightResizablePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NodeGraphConf_isHeightResizable_feature"), getString("_UI_PropertyDescriptor_description", "_UI_NodeGraphConf_isHeightResizable_feature", "_UI_NodeGraphConf_type"),
                GraphconfPackage.Literals.NODE_GRAPH_CONF__IS_HEIGHT_RESIZABLE, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Default Background Color feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected void addDefaultBackgroundColorPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NodeGraphConf_defaultBackgroundColor_feature"), getString("_UI_PropertyDescriptor_description", "_UI_NodeGraphConf_defaultBackgroundColor_feature",
                        "_UI_NodeGraphConf_type"), GraphconfPackage.Literals.NODE_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns NodeGraphConf.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/NodeGraphConf"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getText(Object object)
    {
        String type = "";
        if (((NodeGraphConf) object).getBridge() instanceof StringBridge)
        {
            type = ((StringBridge) ((NodeGraphConf) object).getBridge()).getType();
        }
        else if (((NodeGraphConf) object).getBridge() instanceof EMFBridge)
        {
            if (((EMFBridge) ((NodeGraphConf) object).getBridge()).getType() != null)
            {
                type = ((EMFBridge) ((NodeGraphConf) object).getBridge()).getType().getName();
            }
        }
        String presentation = ((NodeGraphConf) object).getPresentation();
        String label = type + " <<" + presentation + ">>";
        return label == null || label.length() == 0 ? getString("_UI_NodeGraphConf_type") : getString("_UI_NodeGraphConf_type") + " : " + label;
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

        switch (notification.getFeatureID(NodeGraphConf.class))
        {
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_WIDTH:
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_HEIGHT:
            case GraphconfPackage.NODE_GRAPH_CONF__MINIMUM_WIDTH:
            case GraphconfPackage.NODE_GRAPH_CONF__MINIMUM_HEIGHT:
            case GraphconfPackage.NODE_GRAPH_CONF__MAXIMUM_WIDTH:
            case GraphconfPackage.NODE_GRAPH_CONF__MAXIMUM_HEIGHT:
            case GraphconfPackage.NODE_GRAPH_CONF__IS_WIDTH_RESIZABLE:
            case GraphconfPackage.NODE_GRAPH_CONF__IS_HEIGHT_RESIZABLE:
            case GraphconfPackage.NODE_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR:
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
