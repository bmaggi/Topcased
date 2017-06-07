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
 * $Id: OperationSetImpl.java,v 1.1 2013/01/18 11:03:44 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.topcased.iterators.configurations.iterator.IteratorPackage;
import org.topcased.iterators.configurations.iterator.OCLOperation;
import org.topcased.iterators.configurations.iterator.OperationSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.OperationSetImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OperationSetImpl extends NamedElementImpl implements OperationSet {

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLOperation> operations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OperationSetImpl() {
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
		return IteratorPackage.Literals.OPERATION_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<OCLOperation> getOperations() {
		if(operations == null) {
			operations = new EObjectContainmentEList<OCLOperation>(OCLOperation.class, this, IteratorPackage.OPERATION_SET__OPERATIONS);
		}
		return operations;
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
		case IteratorPackage.OPERATION_SET__OPERATIONS:
			return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
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
		case IteratorPackage.OPERATION_SET__OPERATIONS:
			return getOperations();
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
		case IteratorPackage.OPERATION_SET__OPERATIONS:
			getOperations().clear();
			getOperations().addAll((Collection<? extends OCLOperation>)newValue);
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
		case IteratorPackage.OPERATION_SET__OPERATIONS:
			getOperations().clear();
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
		case IteratorPackage.OPERATION_SET__OPERATIONS:
			return operations != null && !operations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OperationSetImpl
