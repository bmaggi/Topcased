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
 * $Id: OCLOperationImpl.java,v 1.1 2013/01/18 11:03:45 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.topcased.iterators.configurations.iterator.IteratorPackage;
import org.topcased.iterators.configurations.iterator.OCLOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OCL Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.OCLOperationImpl#getContext <em>Context</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.OCLOperationImpl#getDef <em>Def</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.impl.OCLOperationImpl#getMetamodelPrefix <em>Metamodel Prefix</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OCLOperationImpl extends MinimalEObjectImpl.Container implements OCLOperation {

	/**
	 * The default value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected String context = CONTEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDef() <em>Def</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDef()
	 * @generated
	 * @ordered
	 */
	protected static final String DEF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDef() <em>Def</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDef()
	 * @generated
	 * @ordered
	 */
	protected String def = DEF_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetamodelPrefix() <em>Metamodel Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMetamodelPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String METAMODEL_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetamodelPrefix() <em>Metamodel Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMetamodelPrefix()
	 * @generated
	 * @ordered
	 */
	protected String metamodelPrefix = METAMODEL_PREFIX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OCLOperationImpl() {
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
		return IteratorPackage.Literals.OCL_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContext(String newContext) {
		String oldContext = context;
		context = newContext;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.OCL_OPERATION__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDef() {
		return def;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDef(String newDef) {
		String oldDef = def;
		def = newDef;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.OCL_OPERATION__DEF, oldDef, def));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getMetamodelPrefix() {
		return metamodelPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMetamodelPrefix(String newMetamodelPrefix) {
		String oldMetamodelPrefix = metamodelPrefix;
		metamodelPrefix = newMetamodelPrefix;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.OCL_OPERATION__METAMODEL_PREFIX, oldMetamodelPrefix, metamodelPrefix));
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
		case IteratorPackage.OCL_OPERATION__CONTEXT:
			return getContext();
		case IteratorPackage.OCL_OPERATION__DEF:
			return getDef();
		case IteratorPackage.OCL_OPERATION__METAMODEL_PREFIX:
			return getMetamodelPrefix();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case IteratorPackage.OCL_OPERATION__CONTEXT:
			setContext((String)newValue);
			return;
		case IteratorPackage.OCL_OPERATION__DEF:
			setDef((String)newValue);
			return;
		case IteratorPackage.OCL_OPERATION__METAMODEL_PREFIX:
			setMetamodelPrefix((String)newValue);
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
		case IteratorPackage.OCL_OPERATION__CONTEXT:
			setContext(CONTEXT_EDEFAULT);
			return;
		case IteratorPackage.OCL_OPERATION__DEF:
			setDef(DEF_EDEFAULT);
			return;
		case IteratorPackage.OCL_OPERATION__METAMODEL_PREFIX:
			setMetamodelPrefix(METAMODEL_PREFIX_EDEFAULT);
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
		case IteratorPackage.OCL_OPERATION__CONTEXT:
			return CONTEXT_EDEFAULT == null ? context != null : !CONTEXT_EDEFAULT.equals(context);
		case IteratorPackage.OCL_OPERATION__DEF:
			return DEF_EDEFAULT == null ? def != null : !DEF_EDEFAULT.equals(def);
		case IteratorPackage.OCL_OPERATION__METAMODEL_PREFIX:
			return METAMODEL_PREFIX_EDEFAULT == null ? metamodelPrefix != null : !METAMODEL_PREFIX_EDEFAULT.equals(metamodelPrefix);
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
		result.append(" (context: ");
		result.append(context);
		result.append(", def: ");
		result.append(def);
		result.append(", metamodelPrefix: ");
		result.append(metamodelPrefix);
		result.append(')');
		return result.toString();
	}

} //OCLOperationImpl
