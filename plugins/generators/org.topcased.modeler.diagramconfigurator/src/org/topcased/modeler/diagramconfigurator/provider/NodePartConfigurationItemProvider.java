/**
 * <copyright>
 * </copyright>
 *
 * $Id: NodePartConfigurationItemProvider.java,v 1.16 2008/04/15 10:09:40 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.provider;

import java.util.ArrayList;
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
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;
import org.topcased.modeler.diagramconfigurator.extension.FigureDeclarationDescriptor;
import org.topcased.modeler.diagramconfigurator.extension.FigureDeclarationsManager;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.diagramconfigurator.NodePartConfiguration} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class NodePartConfigurationItemProvider extends PartConfigurationItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
        IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NodePartConfigurationItemProvider(AdapterFactory adapterFactory)
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

            addTypePropertyDescriptor(object);
            addChildElementsPropertyDescriptor(object);
            addSuperTypePropertyDescriptor(object);
            addDefaultBackgroundColorPropertyDescriptor(object);
            addBackgroundColorChangeablePropertyDescriptor(object);
            addResizingPropertyDescriptor(object);
            addContainerPropertyDescriptor(object);
            addLayoutPropertyDescriptor(object);
            addDirectEditablePropertyDescriptor(object);
            addDefaultWidthPropertyDescriptor(object);
            addDefaultHeightPropertyDescriptor(object);
            addMinimumWidthPropertyDescriptor(object);
            addMinimumHeightPropertyDescriptor(object);
            addMaximumWidthPropertyDescriptor(object);
            addMaximumHeightPropertyDescriptor(object);
            addAttachedToBorderPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Type feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addTypePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NodePartConfiguration_type_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_type_feature", "_UI_NodePartConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DiagramconfiguratorPackage.eINSTANCE.getNodePartConfiguration_Type(), true, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_GraphicPropertiesPropertyCategory"), null)
        {
            /**
             * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getComboBoxObjects(java.lang.Object)
             */
            protected Collection<String> getComboBoxObjects(Object object)
            {
                // get all the available figures from the extension points
                Collection<String> types = FigureDeclarationsManager.getInstance().getFigureDeclarationNames();
                return types;
            }

            /**
             * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getDescription(java.lang.Object)
             */
            public String getDescription(Object object)
            {
                FigureDeclarationDescriptor descriptor = FigureDeclarationsManager.getInstance().find(((NodePartConfiguration) object).getType());
                if (descriptor != null && descriptor.getDescription() != null)
                {
                    return descriptor.getDescription();
                }
                return "";
            }
        });
    }

    /**
     * This adds a property descriptor for the Child Elements feature. <!-- begin-user-doc --> Only display
     * nodePartConfiguration of the current diagram <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addChildElementsPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NodePartConfiguration_childElements_feature"), //$NON-NLS-1$
                getString("_UI_PropertyDescriptor_description"), //$NON-NLS-1$
                DiagramconfiguratorPackage.eINSTANCE.getNodePartConfiguration_ChildElements(), true, null, getString("_UI_ModelPropertyCategory"), //$NON-NLS-1$
                null)
        {
            public Collection<NodePartConfiguration> getComboBoxObjects(Object obj)
            {
                List<NodePartConfiguration> result = new ArrayList<NodePartConfiguration>();
                NodePartConfiguration nodePartConf = (NodePartConfiguration) obj;
                for (PartConfiguration partConf : ((DiagramConfiguration) nodePartConf.eContainer()).getParts())
                {
                    if (partConf instanceof NodePartConfiguration)
                    {
                        result.add((NodePartConfiguration) partConf);
                    }
                }
                return result;
            }
        });
    }

    /**
     * This adds a property descriptor for the Super Type feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addSuperTypePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_superType_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_superType_feature", "_UI_NodePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION__SUPER_TYPE,
                 true,
                 false,
                 false,
                 null,
                 getString("_UI_ModelPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Default Background Color feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected void addDefaultBackgroundColorPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_defaultBackgroundColor_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_defaultBackgroundColor_feature", "_UI_NodePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Background Color Changeable feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected void addBackgroundColorChangeablePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_backgroundColorChangeable_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_backgroundColorChangeable_feature", "_UI_NodePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 getString("_UI_PoliciesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Resizing feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addResizingPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_resizing_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_resizing_feature", "_UI_NodePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION__RESIZING,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getString("_UI_PoliciesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Container feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addContainerPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_container_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_container_feature", "_UI_NodePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION__CONTAINER,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 getString("_UI_PoliciesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Layout feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addLayoutPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_layout_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_layout_feature", "_UI_NodePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION__LAYOUT,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Direct Editable feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addDirectEditablePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_directEditable_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_directEditable_feature", "_UI_NodePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION__DIRECT_EDITABLE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 getString("_UI_PoliciesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Default Width feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultWidthPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_defaultWidth_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_defaultWidth_feature", "_UI_NodePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION__DEFAULT_WIDTH,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Default Height feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultHeightPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_defaultHeight_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_defaultHeight_feature", "_UI_NodePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION__DEFAULT_HEIGHT,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Minimum Width feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addMinimumWidthPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_minimumWidth_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_minimumWidth_feature", "_UI_NodePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION__MINIMUM_WIDTH,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Minimum Height feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addMinimumHeightPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_minimumHeight_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_minimumHeight_feature", "_UI_NodePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION__MINIMUM_HEIGHT,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Maximum Width feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addMaximumWidthPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_maximumWidth_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_maximumWidth_feature", "_UI_NodePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION__MAXIMUM_WIDTH,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Maximum Height feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addMaximumHeightPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_maximumHeight_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_maximumHeight_feature", "_UI_NodePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                 getString("_UI_GraphicPropertiesPropertyCategory"),
                 null));
    }

    /**
     * This adds a property descriptor for the Attached To Border feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected void addAttachedToBorderPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_NodePartConfiguration_attachedToBorder_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_NodePartConfiguration_attachedToBorder_feature", "_UI_NodePartConfiguration_type"),
                 DiagramconfiguratorPackage.Literals.NODE_PART_CONFIGURATION__ATTACHED_TO_BORDER,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 getString("_UI_PoliciesPropertyCategory"),
                 null));
    }

    /**
     * This returns NodePartConfiguration.gif.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/NodePartConfiguration"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object)
    {
        String label = ((NodePartConfiguration)object).getPrefix();
        return label == null || label.length() == 0 ?
            getString("_UI_NodePartConfiguration_type") :
            getString("_UI_NodePartConfiguration_type") + " " + label;
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

        switch (notification.getFeatureID(NodePartConfiguration.class))
        {
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__TYPE:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__CHILD_ELEMENTS:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__SUPER_TYPE:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__BACKGROUND_COLOR_CHANGEABLE:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__RESIZING:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__CONTAINER:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__LAYOUT:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DIRECT_EDITABLE:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_WIDTH:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__DEFAULT_HEIGHT:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_WIDTH:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MINIMUM_HEIGHT:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_WIDTH:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__MAXIMUM_HEIGHT:
            case DiagramconfiguratorPackage.NODE_PART_CONFIGURATION__ATTACHED_TO_BORDER:
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