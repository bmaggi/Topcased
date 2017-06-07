/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartConfigurationItemProvider.java,v 1.12 2007/04/18 12:54:15 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorFactory;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;
import org.topcased.modeler.diagramconfigurator.internal.DiagramConfiguratorPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.diagramconfigurator.PartConfiguration} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class PartConfigurationItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PartConfigurationItemProvider(AdapterFactory adapterFactory)
    {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
    {
        if (itemPropertyDescriptors == null)
        {
            super.getPropertyDescriptors(object);

            addObjectPropertyDescriptor(object);
            addPresentationPropertyDescriptor(object);
            addDefaultForegroundColorPropertyDescriptor(object);
            addForegroundColorChangeablePropertyDescriptor(object);
            addDefaultFontPropertyDescriptor(object);
            addFontChangeablePropertyDescriptor(object);
            addLineWidthPropertyDescriptor(object);
            addLineStylePropertyDescriptor(object);
            addPrefixPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Object feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addObjectPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_PartConfiguration_object_feature"), getString("_UI_PropertyDescriptor_description", "_UI_PartConfiguration_object_feature", "_UI_PartConfiguration_type"),
                DiagramconfiguratorPackage.Literals.PART_CONFIGURATION__OBJECT, true, false, false, null, getString("_UI_ModelPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Presentation feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPresentationPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_PartConfiguration_presentation_feature"), getString("_UI_PropertyDescriptor_description", "_UI_PartConfiguration_presentation_feature", "_UI_PartConfiguration_type"),
                DiagramconfiguratorPackage.Literals.PART_CONFIGURATION__PRESENTATION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_GraphicPropertiesPropertyCategory"), null));
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
                getString("_UI_PartConfiguration_defaultForegroundColor_feature"), getString("_UI_PropertyDescriptor_description", "_UI_PartConfiguration_defaultForegroundColor_feature",
                        "_UI_PartConfiguration_type"), DiagramconfiguratorPackage.Literals.PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_GraphicPropertiesPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Foreground Color Changeable feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected void addForegroundColorChangeablePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_PartConfiguration_foregroundColorChangeable_feature"), getString("_UI_PropertyDescriptor_description", "_UI_PartConfiguration_foregroundColorChangeable_feature",
                        "_UI_PartConfiguration_type"), DiagramconfiguratorPackage.Literals.PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE, true, false, false,
                ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_PoliciesPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Default Font feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDefaultFontPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_PartConfiguration_defaultFont_feature"), getString("_UI_PropertyDescriptor_description", "_UI_PartConfiguration_defaultFont_feature", "_UI_PartConfiguration_type"),
                DiagramconfiguratorPackage.Literals.PART_CONFIGURATION__DEFAULT_FONT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_GraphicPropertiesPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Font Changeable feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addFontChangeablePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_PartConfiguration_fontChangeable_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_PartConfiguration_fontChangeable_feature", "_UI_PartConfiguration_type"),
                DiagramconfiguratorPackage.Literals.PART_CONFIGURATION__FONT_CHANGEABLE, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString("_UI_PoliciesPropertyCategory"),
                null));
    }

    /**
     * This adds a property descriptor for the Line Width feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addLineWidthPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_PartConfiguration_lineWidth_feature"), getString("_UI_PropertyDescriptor_description", "_UI_PartConfiguration_lineWidth_feature", "_UI_PartConfiguration_type"),
                DiagramconfiguratorPackage.Literals.PART_CONFIGURATION__LINE_WIDTH, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                getString("_UI_GraphicPropertiesPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Line Style feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addLineStylePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_PartConfiguration_lineStyle_feature"), getString("_UI_PropertyDescriptor_description", "_UI_PartConfiguration_lineStyle_feature", "_UI_PartConfiguration_type"),
                DiagramconfiguratorPackage.Literals.PART_CONFIGURATION__LINE_STYLE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_GraphicPropertiesPropertyCategory"),
                null));
    }

    /**
     * This adds a property descriptor for the Prefix feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPrefixPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_PartConfiguration_prefix_feature"), getString("_UI_PropertyDescriptor_description", "_UI_PartConfiguration_prefix_feature", "_UI_PartConfiguration_type"),
                DiagramconfiguratorPackage.Literals.PART_CONFIGURATION__PREFIX, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_TemplatesMergePropertyCategory"), null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Collection< ? extends EStructuralFeature> getChildrenFeatures(Object object)
    {
        if (childrenFeatures == null)
        {
            super.getChildrenFeatures(object);
            childrenFeatures.add(DiagramconfiguratorPackage.Literals.PART_CONFIGURATION__CONSTRAINT);
            childrenFeatures.add(DiagramconfiguratorPackage.Literals.PART_CONFIGURATION__ACTIONS);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
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
    @Override
    public String getText(Object object)
    {
        String label = ((PartConfiguration) object).getPrefix();
        return label == null || label.length() == 0 ? getString("_UI_PartConfiguration_type") : getString("_UI_PartConfiguration_type") + " " + label;
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

        switch (notification.getFeatureID(PartConfiguration.class))
        {
            case DiagramconfiguratorPackage.PART_CONFIGURATION__OBJECT:
            case DiagramconfiguratorPackage.PART_CONFIGURATION__PRESENTATION:
            case DiagramconfiguratorPackage.PART_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
            case DiagramconfiguratorPackage.PART_CONFIGURATION__FOREGROUND_COLOR_CHANGEABLE:
            case DiagramconfiguratorPackage.PART_CONFIGURATION__DEFAULT_FONT:
            case DiagramconfiguratorPackage.PART_CONFIGURATION__FONT_CHANGEABLE:
            case DiagramconfiguratorPackage.PART_CONFIGURATION__LINE_WIDTH:
            case DiagramconfiguratorPackage.PART_CONFIGURATION__LINE_STYLE:
            case DiagramconfiguratorPackage.PART_CONFIGURATION__PREFIX:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case DiagramconfiguratorPackage.PART_CONFIGURATION__CONSTRAINT:
            case DiagramconfiguratorPackage.PART_CONFIGURATION__ACTIONS:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
     * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
    {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add(createChildParameter(DiagramconfiguratorPackage.Literals.PART_CONFIGURATION__CONSTRAINT, DiagramconfiguratorFactory.eINSTANCE.createConstraint()));

        newChildDescriptors.add(createChildParameter(DiagramconfiguratorPackage.Literals.PART_CONFIGURATION__ACTIONS, DiagramconfiguratorFactory.eINSTANCE.createPartAction()));
    }

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator()
    {
        return DiagramConfiguratorPlugin.INSTANCE;
    }

}