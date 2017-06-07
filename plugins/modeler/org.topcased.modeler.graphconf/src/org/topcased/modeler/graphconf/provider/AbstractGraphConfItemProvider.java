/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractGraphConfItemProvider.java,v 1.4 2006/12/18 15:21:43 jako Exp $
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
import org.topcased.modeler.graphconf.AbstractGraphConf;
import org.topcased.modeler.graphconf.GraphconfFactory;
import org.topcased.modeler.graphconf.GraphconfPackage;
import org.topcased.modeler.graphconf.internal.GraphConfPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.graphconf.AbstractGraphConf} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class AbstractGraphConfItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AbstractGraphConfItemProvider(AdapterFactory adapterFactory)
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

            addPresentationPropertyDescriptor(object);
            addDefaultForegroundColorPropertyDescriptor(object);
            addDefaultFontPropertyDescriptor(object);
            addLineWidthPropertyDescriptor(object);
            addLineStylePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Presentation feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPresentationPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_AbstractGraphConf_presentation_feature"), getString("_UI_PropertyDescriptor_description", "_UI_AbstractGraphConf_presentation_feature", "_UI_AbstractGraphConf_type"),
                GraphconfPackage.Literals.ABSTRACT_GRAPH_CONF__PRESENTATION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
                getString("_UI_AbstractGraphConf_defaultForegroundColor_feature"), getString("_UI_PropertyDescriptor_description", "_UI_AbstractGraphConf_defaultForegroundColor_feature",
                        "_UI_AbstractGraphConf_type"), GraphconfPackage.Literals.ABSTRACT_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
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
                getString("_UI_AbstractGraphConf_defaultFont_feature"), getString("_UI_PropertyDescriptor_description", "_UI_AbstractGraphConf_defaultFont_feature", "_UI_AbstractGraphConf_type"),
                GraphconfPackage.Literals.ABSTRACT_GRAPH_CONF__DEFAULT_FONT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Line Width feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addLineWidthPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_AbstractGraphConf_lineWidth_feature"), getString("_UI_PropertyDescriptor_description", "_UI_AbstractGraphConf_lineWidth_feature", "_UI_AbstractGraphConf_type"),
                GraphconfPackage.Literals.ABSTRACT_GRAPH_CONF__LINE_WIDTH, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Line Style feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addLineStylePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_AbstractGraphConf_lineStyle_feature"), getString("_UI_PropertyDescriptor_description", "_UI_AbstractGraphConf_lineStyle_feature", "_UI_AbstractGraphConf_type"),
                GraphconfPackage.Literals.ABSTRACT_GRAPH_CONF__LINE_STYLE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
            childrenFeatures.add(GraphconfPackage.Literals.ABSTRACT_GRAPH_CONF__BRIDGE);
            childrenFeatures.add(GraphconfPackage.Literals.ABSTRACT_GRAPH_CONF__CONSTRAINT);
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
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getText(Object object)
    {
        String label = ((AbstractGraphConf) object).getPresentation();
        return label == null || label.length() == 0 ? getString("_UI_AbstractGraphConf_type") : getString("_UI_AbstractGraphConf_type") + " " + label;
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

        switch (notification.getFeatureID(AbstractGraphConf.class))
        {
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__PRESENTATION:
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__DEFAULT_FOREGROUND_COLOR:
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__DEFAULT_FONT:
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__LINE_WIDTH:
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__LINE_STYLE:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__BRIDGE:
            case GraphconfPackage.ABSTRACT_GRAPH_CONF__CONSTRAINT:
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

        newChildDescriptors.add(createChildParameter(GraphconfPackage.Literals.ABSTRACT_GRAPH_CONF__BRIDGE, GraphconfFactory.eINSTANCE.createEMFBridge()));

        newChildDescriptors.add(createChildParameter(GraphconfPackage.Literals.ABSTRACT_GRAPH_CONF__BRIDGE, GraphconfFactory.eINSTANCE.createStringBridge()));

        newChildDescriptors.add(createChildParameter(GraphconfPackage.Literals.ABSTRACT_GRAPH_CONF__CONSTRAINT, GraphconfFactory.eINSTANCE.createConstraint()));
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
