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
 * $Id: EPickerSetImpl.java,v 1.1 2013/01/18 11:03:45 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.topcased.iterators.configurations.iterator.EPicker;
import org.topcased.iterators.configurations.iterator.EPickerSet;
import org.topcased.iterators.configurations.iterator.IteratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EPicker Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.EPickerSetImpl#getPickers <em>Pickers</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.EPickerSetImpl#getSubsets <em>Subsets</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.EPickerSetImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EPickerSetImpl extends MinimalEObjectImpl.Container implements EPickerSet {

	/**
	 * The cached value of the '{@link #getPickers() <em>Pickers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPickers()
	 * @generated
	 * @ordered
	 */
	protected EList<EPicker> pickers;

	/**
	 * The cached value of the '{@link #getSubsets() <em>Subsets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSubsets()
	 * @generated
	 * @ordered
	 */
	protected EList<EPickerSet> subsets;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EPickerSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IteratorPackage.Literals.EPICKER_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<EPicker> getPickers() {
		if(pickers == null) {
			pickers = new EObjectContainmentEList<EPicker>(EPicker.class, this, IteratorPackage.EPICKER_SET__PICKERS);
		}
		return pickers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<EPickerSet> getSubsets() {
		if(subsets == null) {
			subsets = new EObjectResolvingEList<EPickerSet>(EPickerSet.class, this, IteratorPackage.EPICKER_SET__SUBSETS);
		}
		return subsets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.EPICKER_SET__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void EOperation0() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case IteratorPackage.EPICKER_SET__PICKERS:
			return ((InternalEList<?>)getPickers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case IteratorPackage.EPICKER_SET__PICKERS:
			return getPickers();
		case IteratorPackage.EPICKER_SET__SUBSETS:
			return getSubsets();
		case IteratorPackage.EPICKER_SET__DESCRIPTION:
			return getDescription();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case IteratorPackage.EPICKER_SET__PICKERS:
			getPickers().clear();
			getPickers().addAll((Collection<? extends EPicker>)newValue);
			return;
		case IteratorPackage.EPICKER_SET__SUBSETS:
			getSubsets().clear();
			getSubsets().addAll((Collection<? extends EPickerSet>)newValue);
			return;
		case IteratorPackage.EPICKER_SET__DESCRIPTION:
			setDescription((String)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case IteratorPackage.EPICKER_SET__PICKERS:
			getPickers().clear();
			return;
		case IteratorPackage.EPICKER_SET__SUBSETS:
			getSubsets().clear();
			return;
		case IteratorPackage.EPICKER_SET__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case IteratorPackage.EPICKER_SET__PICKERS:
			return pickers != null && !pickers.isEmpty();
		case IteratorPackage.EPICKER_SET__SUBSETS:
			return subsets != null && !subsets.isEmpty();
		case IteratorPackage.EPICKER_SET__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //EPickerSetImpl
