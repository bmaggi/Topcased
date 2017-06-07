/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Atos - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id: IteratorItemProvider.java,v 1.1 2013/01/18 11:02:25 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator.provider;


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

import org.topcased.iterators.configurations.iterator.Iterator;
import org.topcased.iterators.configurations.iterator.IteratorPackage;

/**
 * This is the item provider adapter for a {@link org.topcased.iterators.configurations.iterator.Iterator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class IteratorItemProvider extends NamedElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IteratorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if(itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addPickersPropertyDescriptor(object);
			addRepresentationPropertyDescriptor(object);
			addAlgorithmPropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addOperationImportsPropertyDescriptor(object);
			addCheckRedundancyPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Pickers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPickersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Iterator_pickers_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Iterator_pickers_feature", "_UI_Iterator_type"), IteratorPackage.Literals.ITERATOR__PICKERS, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Representation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addRepresentationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Iterator_representation_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Iterator_representation_feature", "_UI_Iterator_type"), IteratorPackage.Literals.ITERATOR__REPRESENTATION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Algorithm feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addAlgorithmPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Iterator_algorithm_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Iterator_algorithm_feature", "_UI_Iterator_type"), IteratorPackage.Literals.ITERATOR__ALGORITHM, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Iterator_description_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Iterator_description_feature", "_UI_Iterator_type"), IteratorPackage.Literals.ITERATOR__DESCRIPTION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Operation Imports feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addOperationImportsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Iterator_operationImports_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Iterator_operationImports_feature", "_UI_Iterator_type"), IteratorPackage.Literals.ITERATOR__OPERATION_IMPORTS, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Check Redundancy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addCheckRedundancyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Iterator_checkRedundancy_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Iterator_checkRedundancy_feature", "_UI_Iterator_type"), IteratorPackage.Literals.ITERATOR__CHECK_REDUNDANCY, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns Iterator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Iterator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Iterator)object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Iterator_type") : getString("_UI_Iterator_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch(notification.getFeatureID(Iterator.class)) {
		case IteratorPackage.ITERATOR__REPRESENTATION:
		case IteratorPackage.ITERATOR__ALGORITHM:
		case IteratorPackage.ITERATOR__DESCRIPTION:
		case IteratorPackage.ITERATOR__OPERATION_IMPORTS:
		case IteratorPackage.ITERATOR__CHECK_REDUNDANCY:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
