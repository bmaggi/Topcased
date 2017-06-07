/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramGraphConfItemProvider.java,v 1.4 2006/12/18 15:21:43 jako Exp $
 */
package org.topcased.modeler.graphconf.provider;

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
import org.topcased.modeler.graphconf.DiagramGraphConf;
import org.topcased.modeler.graphconf.GraphconfFactory;
import org.topcased.modeler.graphconf.GraphconfPackage;
import org.topcased.modeler.graphconf.internal.GraphConfPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.graphconf.DiagramGraphConf} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class DiagramGraphConfItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DiagramGraphConfItemProvider(AdapterFactory adapterFactory)
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

            addIdPropertyDescriptor(object);
            addDefaultBackgroundColorPropertyDescriptor(object);
            addDefaultForegroundColorPropertyDescriptor(object);
            addDefaultFontPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Id feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addIdPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramGraphConf_id_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramGraphConf_id_feature", "_UI_DiagramGraphConf_type"),
                GraphconfPackage.Literals.DIAGRAM_GRAPH_CONF__ID, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
                getString("_UI_DiagramGraphConf_defaultBackgroundColor_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramGraphConf_defaultBackgroundColor_feature",
                        "_UI_DiagramGraphConf_type"), GraphconfPackage.Literals.DIAGRAM_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
                null));
    }

    /**
     * This adds a property descriptor for the Default Foreground Color feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected void addDefaultForegroundColorPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramGraphConf_defaultForegroundColor_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramGraphConf_defaultForegroundColor_feature",
                        "_UI_DiagramGraphConf_type"), GraphconfPackage.Literals.DIAGRAM_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
                null));
    }

    /**
     * This adds a property descriptor for the Default Font feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDefaultFontPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramGraphConf_defaultFont_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramGraphConf_defaultFont_feature", "_UI_DiagramGraphConf_type"),
                GraphconfPackage.Literals.DIAGRAM_GRAPH_CONF__DEFAULT_FONT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public Collection getChildrenFeatures(Object object)
    {
        if (childrenFeatures == null)
        {
            super.getChildrenFeatures(object);
            childrenFeatures.add(GraphconfPackage.Literals.DIAGRAM_GRAPH_CONF__NODE);
            childrenFeatures.add(GraphconfPackage.Literals.DIAGRAM_GRAPH_CONF__EDGE);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EStructuralFeature getChildFeature(Object object, Object child)
    {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns DiagramGraphConf.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/DiagramGraphConf"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getText(Object object)
    {
        String label = ((DiagramGraphConf) object).getId();
        return label == null || label.length() == 0 ? getString("_UI_DiagramGraphConf_type") : getString("_UI_DiagramGraphConf_type") + " : " + label;
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

        switch (notification.getFeatureID(DiagramGraphConf.class))
        {
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__ID:
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_BACKGROUND_COLOR:
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR:
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__DEFAULT_FONT:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__NODE:
            case GraphconfPackage.DIAGRAM_GRAPH_CONF__EDGE:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

        newChildDescriptors.add(createChildParameter(GraphconfPackage.Literals.DIAGRAM_GRAPH_CONF__NODE, GraphconfFactory.eINSTANCE.createNodeGraphConf()));

        newChildDescriptors.add(createChildParameter(GraphconfPackage.Literals.DIAGRAM_GRAPH_CONF__EDGE, GraphconfFactory.eINSTANCE.createEdgeGraphConf()));
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
