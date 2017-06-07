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
 * $Id: JavaQueryImpl.java,v 1.1 2013/01/18 11:03:44 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.iterators.configurations.iterator.IteratorPackage;
import org.topcased.iterators.configurations.iterator.JavaQuery;
import org.topcased.iterators.configurations.iterator.QueryParam;
import org.topcased.iterators.configurations.iterator.QueryParams;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.JavaQueryImpl#getJavaid <em>Javaid</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.JavaQueryImpl#getParams <em>Params</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class JavaQueryImpl extends QueryImpl implements JavaQuery {

	/**
	 * The default value of the '{@link #getJavaid() <em>Javaid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getJavaid()
	 * @generated
	 * @ordered
	 */
	protected static final String JAVAID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJavaid() <em>Javaid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getJavaid()
	 * @generated
	 * @ordered
	 */
	protected String javaid = JAVAID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected EList<QueryParam> params;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected JavaQueryImpl() {
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
		return IteratorPackage.Literals.JAVA_QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getJavaid() {
		return javaid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setJavaid(String newJavaid) {
		String oldJavaid = javaid;
		javaid = newJavaid;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.JAVA_QUERY__JAVAID, oldJavaid, javaid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<QueryParam> getParams() {
		if(params == null) {
			params = new EObjectContainmentEList<QueryParam>(QueryParam.class, this, IteratorPackage.JAVA_QUERY__PARAMS);
		}
		return params;
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
		case IteratorPackage.JAVA_QUERY__PARAMS:
			return ((InternalEList<?>)getParams()).basicRemove(otherEnd, msgs);
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
		case IteratorPackage.JAVA_QUERY__JAVAID:
			return getJavaid();
		case IteratorPackage.JAVA_QUERY__PARAMS:
			return getParams();
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
		case IteratorPackage.JAVA_QUERY__JAVAID:
			setJavaid((String)newValue);
			return;
		case IteratorPackage.JAVA_QUERY__PARAMS:
			getParams().clear();
			getParams().addAll((Collection<? extends QueryParam>)newValue);
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
		case IteratorPackage.JAVA_QUERY__JAVAID:
			setJavaid(JAVAID_EDEFAULT);
			return;
		case IteratorPackage.JAVA_QUERY__PARAMS:
			getParams().clear();
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
		case IteratorPackage.JAVA_QUERY__JAVAID:
			return JAVAID_EDEFAULT == null ? javaid != null : !JAVAID_EDEFAULT.equals(javaid);
		case IteratorPackage.JAVA_QUERY__PARAMS:
			return params != null && !params.isEmpty();
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
		result.append(" (javaid: ");
		result.append(javaid);
		result.append(')');
		return result.toString();
	}

} //JavaQueryImpl
