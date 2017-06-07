/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditorConfigurationItemProvider.java,v 1.8 2007/04/18 12:54:46 jako Exp $
 */
package org.topcased.modeler.editorconfigurator.provider;

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
import org.topcased.modeler.editorconfigurator.EditorConfiguration;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorFactory;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage;
import org.topcased.modeler.editorconfigurator.internal.EditorConfiguratorPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.editorconfigurator.EditorConfiguration} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EditorConfigurationItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "";

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EditorConfigurationItemProvider(AdapterFactory adapterFactory)
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

            addNamePropertyDescriptor(object);
            addProjectNamePropertyDescriptor(object);
            addGenModelPropertyDescriptor(object);
            addPluginVersionPropertyDescriptor(object);
            addProviderPropertyDescriptor(object);
            addForceOverwritePropertyDescriptor(object);
            addOrganizeImportsPropertyDescriptor(object);
            addCopyrightTextPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EditorConfiguration_name_feature"), getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_name_feature", "_UI_EditorConfiguration_type"),
                EditorconfiguratorPackage.Literals.EDITOR_CONFIGURATION__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_AllPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Project Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addProjectNamePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EditorConfiguration_projectName_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_projectName_feature", "_UI_EditorConfiguration_type"),
                EditorconfiguratorPackage.Literals.EDITOR_CONFIGURATION__PROJECT_NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_AllPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Gen Model feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addGenModelPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EditorConfiguration_genModel_feature"), getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_genModel_feature", "_UI_EditorConfiguration_type"),
                EditorconfiguratorPackage.Literals.EDITOR_CONFIGURATION__GEN_MODEL, true, false, false, null, getString("_UI_ModelPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Plugin Version feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPluginVersionPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EditorConfiguration_pluginVersion_feature"), getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_pluginVersion_feature",
                        "_UI_EditorConfiguration_type"), EditorconfiguratorPackage.Literals.EDITOR_CONFIGURATION__PLUGIN_VERSION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
                getString("_UI_EditorConfiguration_provider_feature"), getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_provider_feature", "_UI_EditorConfiguration_type"),
                EditorconfiguratorPackage.Literals.EDITOR_CONFIGURATION__PROVIDER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString("_UI_AllPropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Force Overwrite feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addForceOverwritePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EditorConfiguration_forceOverwrite_feature"), getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_forceOverwrite_feature",
                        "_UI_EditorConfiguration_type"), EditorconfiguratorPackage.Literals.EDITOR_CONFIGURATION__FORCE_OVERWRITE, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
                getString("_UI_EditorConfiguration_organizeImports_feature"), getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_organizeImports_feature",
                        "_UI_EditorConfiguration_type"), EditorconfiguratorPackage.Literals.EDITOR_CONFIGURATION__ORGANIZE_IMPORTS, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                getString("_UI_TemplatesMergePropertyCategory"), null));
    }

    /**
     * This adds a property descriptor for the Copyright Text feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addCopyrightTextPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_EditorConfiguration_copyrightText_feature"), getString("_UI_PropertyDescriptor_description", "_UI_EditorConfiguration_copyrightText_feature",
                        "_UI_EditorConfiguration_type"), EditorconfiguratorPackage.Literals.EDITOR_CONFIGURATION__COPYRIGHT_TEXT, true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
            childrenFeatures.add(EditorconfiguratorPackage.Literals.EDITOR_CONFIGURATION__ACTIONS);
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
     * This returns EditorConfiguration.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/EditorConfiguration"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object)
    {
        String label = ((EditorConfiguration) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_EditorConfiguration_type") : getString("_UI_EditorConfiguration_type") + " " + label;
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

        switch (notification.getFeatureID(EditorConfiguration.class))
        {
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__NAME:
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PROJECT_NAME:
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__GEN_MODEL:
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PLUGIN_VERSION:
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__PROVIDER:
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__FORCE_OVERWRITE:
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__ORGANIZE_IMPORTS:
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__COPYRIGHT_TEXT:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case EditorconfiguratorPackage.EDITOR_CONFIGURATION__ACTIONS:
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

        newChildDescriptors.add(createChildParameter(EditorconfiguratorPackage.Literals.EDITOR_CONFIGURATION__ACTIONS, EditorconfiguratorFactory.eINSTANCE.createEditorAction()));
    }

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator()
    {
        return EditorConfiguratorPlugin.INSTANCE;
    }

}
