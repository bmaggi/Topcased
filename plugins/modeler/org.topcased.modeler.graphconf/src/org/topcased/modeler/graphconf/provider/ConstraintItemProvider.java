/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConstraintItemProvider.java,v 1.3 2006/12/18 15:21:43 jako Exp $
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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.topcased.modeler.graphconf.Constraint;
import org.topcased.modeler.graphconf.GraphconfPackage;
import org.topcased.modeler.graphconf.internal.GraphConfPlugin;

/**
 * This is the item provider adapter for a {@link org.topcased.modeler.graphconf.Constraint} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ConstraintItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ConstraintItemProvider(AdapterFactory adapterFactory)
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

            addLanguagePropertyDescriptor(object);
            addRulePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Language feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addLanguagePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_Constraint_language_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Constraint_language_feature", "_UI_Constraint_type"),
                GraphconfPackage.Literals.CONSTRAINT__LANGUAGE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Rule feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addRulePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Constraint_rule_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Constraint_rule_feature", "_UI_Constraint_type"), GraphconfPackage.Literals.CONSTRAINT__RULE, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns Constraint.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/Constraint"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getText(Object object)
    {
        String label = ((Constraint) object).getLanguage();
        return label == null || label.length() == 0 ? getString("_UI_Constraint_type") : getString("_UI_Constraint_type") + " " + label;
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

        switch (notification.getFeatureID(Constraint.class))
        {
            case GraphconfPackage.CONSTRAINT__LANGUAGE:
            case GraphconfPackage.CONSTRAINT__RULE:
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
