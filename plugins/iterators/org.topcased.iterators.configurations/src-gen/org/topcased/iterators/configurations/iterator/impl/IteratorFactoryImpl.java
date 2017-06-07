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
 * $Id: IteratorFactoryImpl.java,v 1.1 2013/01/18 11:03:44 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.topcased.iterators.configurations.iterator.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class IteratorFactoryImpl extends EFactoryImpl implements IteratorFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static IteratorFactory init() {
		try {
			IteratorFactory theIteratorFactory = (IteratorFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.topcased.org/1.0.0/iterator/");
			if(theIteratorFactory != null) {
				return theIteratorFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IteratorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IteratorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case IteratorPackage.EPICKER_SET:
			return createEPickerSet();
		case IteratorPackage.OCL_QUERY:
			return createOCLQuery();
		case IteratorPackage.JAVA_QUERY:
			return createJavaQuery();
		case IteratorPackage.EPICKER:
			return createEPicker();
		case IteratorPackage.OPERATION_SET:
			return createOperationSet();
		case IteratorPackage.OCL_OPERATION:
			return createOCLOperation();
		case IteratorPackage.ITERATOR:
			return createIterator();
		case IteratorPackage.CONFIGURATION_MODEL:
			return createConfigurationModel();
		case IteratorPackage.QUERY_PARAM:
			return createQueryParam();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch(eDataType.getClassifierID()) {
		case IteratorPackage.ALGORITHM_KIND:
			return createALGORITHM_KINDFromString(eDataType, initialValue);
		case IteratorPackage.REPRESENTATION_KIND:
			return createREPRESENTATION_KINDFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch(eDataType.getClassifierID()) {
		case IteratorPackage.ALGORITHM_KIND:
			return convertALGORITHM_KINDToString(eDataType, instanceValue);
		case IteratorPackage.REPRESENTATION_KIND:
			return convertREPRESENTATION_KINDToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EPickerSet createEPickerSet() {
		EPickerSetImpl ePickerSet = new EPickerSetImpl();
		return ePickerSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OCLQuery createOCLQuery() {
		OCLQueryImpl oclQuery = new OCLQueryImpl();
		return oclQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JavaQuery createJavaQuery() {
		JavaQueryImpl javaQuery = new JavaQueryImpl();
		return javaQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EPicker createEPicker() {
		EPickerImpl ePicker = new EPickerImpl();
		return ePicker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationSet createOperationSet() {
		OperationSetImpl operationSet = new OperationSetImpl();
		return operationSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OCLOperation createOCLOperation() {
		OCLOperationImpl oclOperation = new OCLOperationImpl();
		return oclOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Iterator createIterator() {
		IteratorImpl iterator = new IteratorImpl();
		return iterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConfigurationModel createConfigurationModel() {
		ConfigurationModelImpl configurationModel = new ConfigurationModelImpl();
		return configurationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QueryParam createQueryParam() {
		QueryParamImpl queryParam = new QueryParamImpl();
		return queryParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ALGORITHM_KIND createALGORITHM_KINDFromString(EDataType eDataType, String initialValue) {
		ALGORITHM_KIND result = ALGORITHM_KIND.get(initialValue);
		if(result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertALGORITHM_KINDToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public REPRESENTATION_KIND createREPRESENTATION_KINDFromString(EDataType eDataType, String initialValue) {
		REPRESENTATION_KIND result = REPRESENTATION_KIND.get(initialValue);
		if(result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertREPRESENTATION_KINDToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IteratorPackage getIteratorPackage() {
		return (IteratorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IteratorPackage getPackage() {
		return IteratorPackage.eINSTANCE;
	}

} //IteratorFactoryImpl
