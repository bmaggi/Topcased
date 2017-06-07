/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramConfigurationItemProvider.java,v 1.11 2007/04/18 12:21:26 jako Exp $
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
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorFactory;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.internal.DiagramConfiguratorPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.diagramconfigurator.DiagramConfiguration} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class DiagramConfigurationItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DiagramConfigurationItemProvider(AdapterFactory adapterFactory)
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

            addProjectNamePropertyDescriptor(object);
            addNamePropertyDescriptor(object);
            addPackagePropertyDescriptor(object);
            addPrefixPropertyDescriptor(object);
            addLayoutPropertyDescriptor(object);
            addGenModelPropertyDescriptor(object);
            addDefaultBackgroundColorPropertyDescriptor(object);
            addDefaultForegroundColorPropertyDescriptor(object);
            addDefaultFontPropertyDescriptor(object);
            addTemplateRootObjectPropertyDescriptor(object);
            addForceOverwritePropertyDescriptor(object);
            addOverwriteGraphConfPropertyDescriptor(object);
            addOrganizeImportsPropertyDescriptor(object);
            addEditorConfiguratorPropertyDescriptor(object);
            addCopyrightTextPropertyDescriptor(object);
            addPluginVersionPropertyDescriptor(object);
            addProviderPropertyDescriptor(object);
            addSamePluginAsEditorPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Project Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addProjectNamePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_projectName_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramConfiguration_projectName_feature",
                        "_UI_DiagramConfiguration_type"), DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__PROJECT_NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_AllPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_name_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramConfiguration_name_feature", "_UI_DiagramConfiguration_type"),
                DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_AllPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Package feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPackagePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_package_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramConfiguration_package_feature", "_UI_DiagramConfiguration_type"),
                DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__PACKAGE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_AllPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Prefix feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPrefixPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_prefix_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramConfiguration_prefix_feature", "_UI_DiagramConfiguration_type"),
                DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__PREFIX, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_AllPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Layout feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addLayoutPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_layout_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramConfiguration_layout_feature", "_UI_DiagramConfiguration_type"),
                DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__LAYOUT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_GraphicPropertiesPropertyCategory"),
                null));
    }

    /**
     * This adds a property descriptor for the Gen Model feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addGenModelPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_genModel_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramConfiguration_genModel_feature", "_UI_DiagramConfiguration_type"),
                DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__GEN_MODEL, true, false, false, null, getString("_UI_ModelPropertyCategory"), null));
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
                getString("_UI_DiagramConfiguration_defaultBackgroundColor_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramConfiguration_defaultBackgroundColor_feature",
                        "_UI_DiagramConfiguration_type"), DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__DEFAULT_BACKGROUND_COLOR, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_GraphicPropertiesPropertyCategory"), null));
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
                getString("_UI_DiagramConfiguration_defaultForegroundColor_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramConfiguration_defaultForegroundColor_feature",
                        "_UI_DiagramConfiguration_type"), DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__DEFAULT_FOREGROUND_COLOR, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_GraphicPropertiesPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Default Font feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDefaultFontPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_defaultFont_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramConfiguration_defaultFont_feature",
                        "_UI_DiagramConfiguration_type"), DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__DEFAULT_FONT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_GraphicPropertiesPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Template Root Object feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    protected void addTemplateRootObjectPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_templateRootObject_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramConfiguration_templateRootObject_feature",
                        "_UI_DiagramConfiguration_type"), DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__TEMPLATE_ROOT_OBJECT, true, false, true, null,
                getString("_UI_ModelPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Force Overwrite feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addForceOverwritePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_forceOverwrite_feature"), getString("_UI_DiagramConfiguration_forceOverwrite_description"),
                DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__FORCE_OVERWRITE, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                getString("_UI_TemplatesMergePropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Overwrite Graph Conf feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    protected void addOverwriteGraphConfPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_overwriteGraphConf_feature"), getString("_UI_DiagramConfiguration_overwriteGraphConf_description"),
                DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__OVERWRITE_GRAPH_CONF, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                getString("_UI_TemplatesMergePropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Organize Imports feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addOrganizeImportsPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_organizeImports_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramConfiguration_organizeImports_feature",
                        "_UI_DiagramConfiguration_type"), DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__ORGANIZE_IMPORTS, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                getString("_UI_TemplatesMergePropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Editor Configurator feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    protected void addEditorConfiguratorPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_editorConfigurator_feature"), getString("_UI_DiagramConfiguration_editorConfigurator_description"),
                DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__EDITOR_CONFIGURATOR, true, false, true, null, getString("_UI_ModelPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Copyright Text feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addCopyrightTextPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_copyrightText_feature"), getString("_UI_DiagramConfiguration_copyrightText_description"),
                DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__COPYRIGHT_TEXT, true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_TemplatesMergePropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Plugin Version feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPluginVersionPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_pluginVersion_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramConfiguration_pluginVersion_feature",
                        "_UI_DiagramConfiguration_type"), DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__PLUGIN_VERSION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                getString("_UI_AllPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Provider feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addProviderPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_provider_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DiagramConfiguration_provider_feature", "_UI_DiagramConfiguration_type"),
                DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__PROVIDER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_AllPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Same Plugin As Editor feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    protected void addSamePluginAsEditorPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DiagramConfiguration_samePluginAsEditor_feature"), getString("_UI_DiagramConfiguration_samePluginAsEditor_description"),
                DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__SAME_PLUGIN_AS_EDITOR, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                getString("_UI_TemplatesMergePropertyCategory"), null));
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
            childrenFeatures.add(DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__PALETTE);
            childrenFeatures.add(DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__PARTS);
            childrenFeatures.add(DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__OBJECTS);
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
     * This returns DiagramConfiguration.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/DiagramConfiguration"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object)
    {
        String label = ((DiagramConfiguration) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_DiagramConfiguration_type") : getString("_UI_DiagramConfiguration_type") + " " + label;
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

        switch (notification.getFeatureID(DiagramConfiguration.class))
        {
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PROJECT_NAME:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__NAME:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PACKAGE:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PREFIX:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__LAYOUT:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__GEN_MODEL:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_BACKGROUND_COLOR:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_FOREGROUND_COLOR:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__DEFAULT_FONT:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__TEMPLATE_ROOT_OBJECT:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__FORCE_OVERWRITE:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__OVERWRITE_GRAPH_CONF:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__ORGANIZE_IMPORTS:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__EDITOR_CONFIGURATOR:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__COPYRIGHT_TEXT:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PLUGIN_VERSION:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PROVIDER:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__SAME_PLUGIN_AS_EDITOR:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PALETTE:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__PARTS:
            case DiagramconfiguratorPackage.DIAGRAM_CONFIGURATION__OBJECTS:
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

        newChildDescriptors.add(createChildParameter(DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__PALETTE, DiagramconfiguratorFactory.eINSTANCE.createPaletteConfiguration()));

        newChildDescriptors.add(createChildParameter(DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__PARTS, DiagramconfiguratorFactory.eINSTANCE.createNodePartConfiguration()));

        newChildDescriptors.add(createChildParameter(DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__PARTS, DiagramconfiguratorFactory.eINSTANCE.createEdgePartConfiguration()));

        newChildDescriptors.add(createChildParameter(DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__OBJECTS, DiagramconfiguratorFactory.eINSTANCE.createModelObjectConfiguration()));

        newChildDescriptors.add(createChildParameter(DiagramconfiguratorPackage.Literals.DIAGRAM_CONFIGURATION__OBJECTS, DiagramconfiguratorFactory.eINSTANCE.createSimpleObjectConfiguration()));
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