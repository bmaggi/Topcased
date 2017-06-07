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
 * $Id: IteratorImpl.java,v 1.1 2013/01/18 11:03:44 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.topcased.iterators.configurations.iterator.ALGORITHM_KIND;
import org.topcased.iterators.configurations.iterator.EPickerSet;
import org.topcased.iterators.configurations.iterator.Iterator;
import org.topcased.iterators.configurations.iterator.IteratorPackage;
import org.topcased.iterators.configurations.iterator.REPRESENTATION_KIND;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.IteratorImpl#getPickers <em>Pickers</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.IteratorImpl#getRepresentation <em>Representation</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.IteratorImpl#getAlgorithm <em>Algorithm</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.IteratorImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.IteratorImpl#getOperationImports <em>Operation Imports</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.IteratorImpl#isCheckRedundancy <em>Check Redundancy</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class IteratorImpl extends NamedElementImpl implements Iterator {

	/**
	 * The cached value of the '{@link #getPickers() <em>Pickers</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPickers()
	 * @generated
	 * @ordered
	 */
	protected EPickerSet pickers;

	/**
	 * The default value of the '{@link #getRepresentation() <em>Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRepresentation()
	 * @generated
	 * @ordered
	 */
	protected static final REPRESENTATION_KIND REPRESENTATION_EDEFAULT = REPRESENTATION_KIND.STATE_WISE;

	/**
	 * The cached value of the '{@link #getRepresentation() <em>Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRepresentation()
	 * @generated
	 * @ordered
	 */
	protected REPRESENTATION_KIND representation = REPRESENTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected static final ALGORITHM_KIND ALGORITHM_EDEFAULT = ALGORITHM_KIND.DEPTH_WISE;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected ALGORITHM_KIND algorithm = ALGORITHM_EDEFAULT;

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
	 * The cached value of the '{@link #getOperationImports() <em>Operation Imports</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOperationImports()
	 * @generated
	 * @ordered
	 */
	protected EList<String> operationImports;

	/**
	 * The default value of the '{@link #isCheckRedundancy() <em>Check Redundancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isCheckRedundancy()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECK_REDUNDANCY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCheckRedundancy() <em>Check Redundancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isCheckRedundancy()
	 * @generated
	 * @ordered
	 */
	protected boolean checkRedundancy = CHECK_REDUNDANCY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IteratorImpl() {
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
		return IteratorPackage.Literals.ITERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EPickerSet getPickers() {
		if(pickers != null && pickers.eIsProxy()) {
			InternalEObject oldPickers = (InternalEObject)pickers;
			pickers = (EPickerSet)eResolveProxy(oldPickers);
			if(pickers != oldPickers) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IteratorPackage.ITERATOR__PICKERS, oldPickers, pickers));
			}
		}
		return pickers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EPickerSet basicGetPickers() {
		return pickers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPickers(EPickerSet newPickers) {
		EPickerSet oldPickers = pickers;
		pickers = newPickers;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.ITERATOR__PICKERS, oldPickers, pickers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public REPRESENTATION_KIND getRepresentation() {
		return representation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRepresentation(REPRESENTATION_KIND newRepresentation) {
		REPRESENTATION_KIND oldRepresentation = representation;
		representation = newRepresentation == null ? REPRESENTATION_EDEFAULT : newRepresentation;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.ITERATOR__REPRESENTATION, oldRepresentation, representation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ALGORITHM_KIND getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAlgorithm(ALGORITHM_KIND newAlgorithm) {
		ALGORITHM_KIND oldAlgorithm = algorithm;
		algorithm = newAlgorithm == null ? ALGORITHM_EDEFAULT : newAlgorithm;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.ITERATOR__ALGORITHM, oldAlgorithm, algorithm));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.ITERATOR__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getOperationImports() {
		if(operationImports == null) {
			operationImports = new EDataTypeUniqueEList<String>(String.class, this, IteratorPackage.ITERATOR__OPERATION_IMPORTS);
		}
		return operationImports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isCheckRedundancy() {
		return checkRedundancy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCheckRedundancy(boolean newCheckRedundancy) {
		boolean oldCheckRedundancy = checkRedundancy;
		checkRedundancy = newCheckRedundancy;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.ITERATOR__CHECK_REDUNDANCY, oldCheckRedundancy, checkRedundancy));
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
		case IteratorPackage.ITERATOR__PICKERS:
			if(resolve)
				return getPickers();
			return basicGetPickers();
		case IteratorPackage.ITERATOR__REPRESENTATION:
			return getRepresentation();
		case IteratorPackage.ITERATOR__ALGORITHM:
			return getAlgorithm();
		case IteratorPackage.ITERATOR__DESCRIPTION:
			return getDescription();
		case IteratorPackage.ITERATOR__OPERATION_IMPORTS:
			return getOperationImports();
		case IteratorPackage.ITERATOR__CHECK_REDUNDANCY:
			return isCheckRedundancy();
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
		case IteratorPackage.ITERATOR__PICKERS:
			setPickers((EPickerSet)newValue);
			return;
		case IteratorPackage.ITERATOR__REPRESENTATION:
			setRepresentation((REPRESENTATION_KIND)newValue);
			return;
		case IteratorPackage.ITERATOR__ALGORITHM:
			setAlgorithm((ALGORITHM_KIND)newValue);
			return;
		case IteratorPackage.ITERATOR__DESCRIPTION:
			setDescription((String)newValue);
			return;
		case IteratorPackage.ITERATOR__OPERATION_IMPORTS:
			getOperationImports().clear();
			getOperationImports().addAll((Collection<? extends String>)newValue);
			return;
		case IteratorPackage.ITERATOR__CHECK_REDUNDANCY:
			setCheckRedundancy((Boolean)newValue);
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
		case IteratorPackage.ITERATOR__PICKERS:
			setPickers((EPickerSet)null);
			return;
		case IteratorPackage.ITERATOR__REPRESENTATION:
			setRepresentation(REPRESENTATION_EDEFAULT);
			return;
		case IteratorPackage.ITERATOR__ALGORITHM:
			setAlgorithm(ALGORITHM_EDEFAULT);
			return;
		case IteratorPackage.ITERATOR__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case IteratorPackage.ITERATOR__OPERATION_IMPORTS:
			getOperationImports().clear();
			return;
		case IteratorPackage.ITERATOR__CHECK_REDUNDANCY:
			setCheckRedundancy(CHECK_REDUNDANCY_EDEFAULT);
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
		case IteratorPackage.ITERATOR__PICKERS:
			return pickers != null;
		case IteratorPackage.ITERATOR__REPRESENTATION:
			return representation != REPRESENTATION_EDEFAULT;
		case IteratorPackage.ITERATOR__ALGORITHM:
			return algorithm != ALGORITHM_EDEFAULT;
		case IteratorPackage.ITERATOR__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		case IteratorPackage.ITERATOR__OPERATION_IMPORTS:
			return operationImports != null && !operationImports.isEmpty();
		case IteratorPackage.ITERATOR__CHECK_REDUNDANCY:
			return checkRedundancy != CHECK_REDUNDANCY_EDEFAULT;
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
		result.append(" (representation: ");
		result.append(representation);
		result.append(", algorithm: ");
		result.append(algorithm);
		result.append(", description: ");
		result.append(description);
		result.append(", operationImports: ");
		result.append(operationImports);
		result.append(", checkRedundancy: ");
		result.append(checkRedundancy);
		result.append(')');
		return result.toString();
	}

} //IteratorImpl
