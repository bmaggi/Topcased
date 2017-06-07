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
 * $Id: ConfigurationModelImpl.java,v 1.1 2013/01/18 11:03:46 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.topcased.iterators.configurations.iterator.ConfigurationModel;
import org.topcased.iterators.configurations.iterator.EPickerSet;
import org.topcased.iterators.configurations.iterator.Iterator;
import org.topcased.iterators.configurations.iterator.IteratorPackage;
import org.topcased.iterators.configurations.iterator.OperationSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.ConfigurationModelImpl#getIterators <em>Iterators</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.ConfigurationModelImpl#getOperationSets <em>Operation Sets</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.ConfigurationModelImpl#getPickerSets <em>Picker Sets</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ConfigurationModelImpl extends MinimalEObjectImpl.Container implements ConfigurationModel {

	/**
	 * The cached value of the '{@link #getIterators() <em>Iterators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getIterators()
	 * @generated
	 * @ordered
	 */
	protected EList<Iterator> iterators;

	/**
	 * The cached value of the '{@link #getOperationSets() <em>Operation Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOperationSets()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationSet> operationSets;

	/**
	 * The cached value of the '{@link #getPickerSets() <em>Picker Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPickerSets()
	 * @generated
	 * @ordered
	 */
	protected EList<EPickerSet> pickerSets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConfigurationModelImpl() {
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
		return IteratorPackage.Literals.CONFIGURATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Iterator> getIterators() {
		if(iterators == null) {
			iterators = new EObjectContainmentEList<Iterator>(Iterator.class, this, IteratorPackage.CONFIGURATION_MODEL__ITERATORS);
		}
		return iterators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<OperationSet> getOperationSets() {
		if(operationSets == null) {
			operationSets = new EObjectContainmentEList<OperationSet>(OperationSet.class, this, IteratorPackage.CONFIGURATION_MODEL__OPERATION_SETS);
		}
		return operationSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<EPickerSet> getPickerSets() {
		if(pickerSets == null) {
			pickerSets = new EObjectContainmentEList<EPickerSet>(EPickerSet.class, this, IteratorPackage.CONFIGURATION_MODEL__PICKER_SETS);
		}
		return pickerSets;
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
		case IteratorPackage.CONFIGURATION_MODEL__ITERATORS:
			return ((InternalEList<?>)getIterators()).basicRemove(otherEnd, msgs);
		case IteratorPackage.CONFIGURATION_MODEL__OPERATION_SETS:
			return ((InternalEList<?>)getOperationSets()).basicRemove(otherEnd, msgs);
		case IteratorPackage.CONFIGURATION_MODEL__PICKER_SETS:
			return ((InternalEList<?>)getPickerSets()).basicRemove(otherEnd, msgs);
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
		case IteratorPackage.CONFIGURATION_MODEL__ITERATORS:
			return getIterators();
		case IteratorPackage.CONFIGURATION_MODEL__OPERATION_SETS:
			return getOperationSets();
		case IteratorPackage.CONFIGURATION_MODEL__PICKER_SETS:
			return getPickerSets();
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
		case IteratorPackage.CONFIGURATION_MODEL__ITERATORS:
			getIterators().clear();
			getIterators().addAll((Collection<? extends Iterator>)newValue);
			return;
		case IteratorPackage.CONFIGURATION_MODEL__OPERATION_SETS:
			getOperationSets().clear();
			getOperationSets().addAll((Collection<? extends OperationSet>)newValue);
			return;
		case IteratorPackage.CONFIGURATION_MODEL__PICKER_SETS:
			getPickerSets().clear();
			getPickerSets().addAll((Collection<? extends EPickerSet>)newValue);
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
		case IteratorPackage.CONFIGURATION_MODEL__ITERATORS:
			getIterators().clear();
			return;
		case IteratorPackage.CONFIGURATION_MODEL__OPERATION_SETS:
			getOperationSets().clear();
			return;
		case IteratorPackage.CONFIGURATION_MODEL__PICKER_SETS:
			getPickerSets().clear();
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
		case IteratorPackage.CONFIGURATION_MODEL__ITERATORS:
			return iterators != null && !iterators.isEmpty();
		case IteratorPackage.CONFIGURATION_MODEL__OPERATION_SETS:
			return operationSets != null && !operationSets.isEmpty();
		case IteratorPackage.CONFIGURATION_MODEL__PICKER_SETS:
			return pickerSets != null && !pickerSets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConfigurationModelImpl
