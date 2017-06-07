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
 * $Id: IteratorPackage.java,v 1.1 2013/01/18 11:03:46 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.topcased.iterators.configurations.iterator.IteratorFactory
 * @model kind="package"
 * @generated
 */
public interface IteratorPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "iterator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.topcased.org/1.0.0/iterator/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "iterator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	IteratorPackage eINSTANCE = org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.topcased.iterators.configurations.iterator.impl.EPickerSetImpl <em>EPicker Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.topcased.iterators.configurations.iterator.impl.EPickerSetImpl
	 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getEPickerSet()
	 * @generated
	 */
	int EPICKER_SET = 0;

	/**
	 * The feature id for the '<em><b>Pickers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPICKER_SET__PICKERS = 0;

	/**
	 * The feature id for the '<em><b>Subsets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPICKER_SET__SUBSETS = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPICKER_SET__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>EPicker Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPICKER_SET_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.topcased.iterators.configurations.iterator.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.topcased.iterators.configurations.iterator.impl.NamedElementImpl
	 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.topcased.iterators.configurations.iterator.impl.QueryImpl <em>Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.topcased.iterators.configurations.iterator.impl.QueryImpl
	 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getQuery()
	 * @generated
	 */
	int QUERY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUERY__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUERY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.topcased.iterators.configurations.iterator.impl.OCLQueryImpl <em>OCL Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.topcased.iterators.configurations.iterator.impl.OCLQueryImpl
	 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getOCLQuery()
	 * @generated
	 */
	int OCL_QUERY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY__NAME = QUERY__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY__BODY = QUERY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OCL Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY_FEATURE_COUNT = QUERY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.topcased.iterators.configurations.iterator.impl.JavaQueryImpl <em>Java Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.topcased.iterators.configurations.iterator.impl.JavaQueryImpl
	 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getJavaQuery()
	 * @generated
	 */
	int JAVA_QUERY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__NAME = QUERY__NAME;

	/**
	 * The feature id for the '<em><b>Javaid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__JAVAID = QUERY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__PARAMS = QUERY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Java Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY_FEATURE_COUNT = QUERY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.topcased.iterators.configurations.iterator.impl.EPickerImpl <em>EPicker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.topcased.iterators.configurations.iterator.impl.EPickerImpl
	 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getEPicker()
	 * @generated
	 */
	int EPICKER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPICKER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Registered Queries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPICKER__REGISTERED_QUERIES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPICKER__DESCRIPTION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EPicker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EPICKER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.topcased.iterators.configurations.iterator.impl.OperationSetImpl <em>Operation Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.topcased.iterators.configurations.iterator.impl.OperationSetImpl
	 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getOperationSet()
	 * @generated
	 */
	int OPERATION_SET = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_SET__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_SET__OPERATIONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_SET_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.topcased.iterators.configurations.iterator.impl.OCLOperationImpl <em>OCL Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.topcased.iterators.configurations.iterator.impl.OCLOperationImpl
	 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getOCLOperation()
	 * @generated
	 */
	int OCL_OPERATION = 7;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION__CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Def</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION__DEF = 1;

	/**
	 * The feature id for the '<em><b>Metamodel Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION__METAMODEL_PREFIX = 2;

	/**
	 * The number of structural features of the '<em>OCL Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_OPERATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.topcased.iterators.configurations.iterator.impl.IteratorImpl <em>Iterator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.topcased.iterators.configurations.iterator.impl.IteratorImpl
	 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getIterator()
	 * @generated
	 */
	int ITERATOR = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Pickers</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR__PICKERS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR__REPRESENTATION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR__ALGORITHM = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR__DESCRIPTION = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Operation Imports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR__OPERATION_IMPORTS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Check Redundancy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR__CHECK_REDUNDANCY = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Iterator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.topcased.iterators.configurations.iterator.impl.ConfigurationModelImpl <em>Configuration Model</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.topcased.iterators.configurations.iterator.impl.ConfigurationModelImpl
	 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getConfigurationModel()
	 * @generated
	 */
	int CONFIGURATION_MODEL = 9;

	/**
	 * The feature id for the '<em><b>Iterators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_MODEL__ITERATORS = 0;

	/**
	 * The feature id for the '<em><b>Operation Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_MODEL__OPERATION_SETS = 1;

	/**
	 * The feature id for the '<em><b>Picker Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_MODEL__PICKER_SETS = 2;

	/**
	 * The number of structural features of the '<em>Configuration Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_MODEL_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.topcased.iterators.configurations.iterator.impl.QueryParamImpl <em>Query Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.topcased.iterators.configurations.iterator.impl.QueryParamImpl
	 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getQueryParam()
	 * @generated
	 */
	int QUERY_PARAM = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUERY_PARAM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUERY_PARAM__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Query Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUERY_PARAM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.topcased.iterators.configurations.iterator.ALGORITHM_KIND <em>ALGORITHM KIND</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.topcased.iterators.configurations.iterator.ALGORITHM_KIND
	 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getALGORITHM_KIND()
	 * @generated
	 */
	int ALGORITHM_KIND = 11;

	/**
	 * The meta object id for the '{@link org.topcased.iterators.configurations.iterator.REPRESENTATION_KIND <em>REPRESENTATION KIND</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.topcased.iterators.configurations.iterator.REPRESENTATION_KIND
	 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getREPRESENTATION_KIND()
	 * @generated
	 */
	int REPRESENTATION_KIND = 12;


	/**
	 * Returns the meta object for class '{@link org.topcased.iterators.configurations.iterator.EPickerSet <em>EPicker Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EPicker Set</em>'.
	 * @see org.topcased.iterators.configurations.iterator.EPickerSet
	 * @generated
	 */
	EClass getEPickerSet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.topcased.iterators.configurations.iterator.EPickerSet#getPickers
	 * <em>Pickers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Pickers</em>'.
	 * @see org.topcased.iterators.configurations.iterator.EPickerSet#getPickers()
	 * @see #getEPickerSet()
	 * @generated
	 */
	EReference getEPickerSet_Pickers();

	/**
	 * Returns the meta object for the reference list '{@link org.topcased.iterators.configurations.iterator.EPickerSet#getSubsets <em>Subsets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Subsets</em>'.
	 * @see org.topcased.iterators.configurations.iterator.EPickerSet#getSubsets()
	 * @see #getEPickerSet()
	 * @generated
	 */
	EReference getEPickerSet_Subsets();

	/**
	 * Returns the meta object for the attribute '{@link org.topcased.iterators.configurations.iterator.EPickerSet#getDescription
	 * <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.topcased.iterators.configurations.iterator.EPickerSet#getDescription()
	 * @see #getEPickerSet()
	 * @generated
	 */
	EAttribute getEPickerSet_Description();

	/**
	 * Returns the meta object for class '{@link org.topcased.iterators.configurations.iterator.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Query</em>'.
	 * @see org.topcased.iterators.configurations.iterator.Query
	 * @generated
	 */
	EClass getQuery();

	/**
	 * Returns the meta object for class '{@link org.topcased.iterators.configurations.iterator.OCLQuery <em>OCL Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>OCL Query</em>'.
	 * @see org.topcased.iterators.configurations.iterator.OCLQuery
	 * @generated
	 */
	EClass getOCLQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.topcased.iterators.configurations.iterator.OCLQuery#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.topcased.iterators.configurations.iterator.OCLQuery#getBody()
	 * @see #getOCLQuery()
	 * @generated
	 */
	EAttribute getOCLQuery_Body();

	/**
	 * Returns the meta object for class '{@link org.topcased.iterators.configurations.iterator.JavaQuery <em>Java Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Java Query</em>'.
	 * @see org.topcased.iterators.configurations.iterator.JavaQuery
	 * @generated
	 */
	EClass getJavaQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.topcased.iterators.configurations.iterator.JavaQuery#getJavaid <em>Javaid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Javaid</em>'.
	 * @see org.topcased.iterators.configurations.iterator.JavaQuery#getJavaid()
	 * @see #getJavaQuery()
	 * @generated
	 */
	EAttribute getJavaQuery_Javaid();

	/**
	 * Returns the meta object for the containment reference list '{@link org.topcased.iterators.configurations.iterator.JavaQuery#getParams
	 * <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see org.topcased.iterators.configurations.iterator.JavaQuery#getParams()
	 * @see #getJavaQuery()
	 * @generated
	 */
	EReference getJavaQuery_Params();

	/**
	 * Returns the meta object for class '{@link org.topcased.iterators.configurations.iterator.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.topcased.iterators.configurations.iterator.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.topcased.iterators.configurations.iterator.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.topcased.iterators.configurations.iterator.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.topcased.iterators.configurations.iterator.EPicker <em>EPicker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EPicker</em>'.
	 * @see org.topcased.iterators.configurations.iterator.EPicker
	 * @generated
	 */
	EClass getEPicker();

	/**
	 * Returns the meta object for the containment reference list '{@link org.topcased.iterators.configurations.iterator.EPicker#getRegisteredQueries
	 * <em>Registered Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Registered Queries</em>'.
	 * @see org.topcased.iterators.configurations.iterator.EPicker#getRegisteredQueries()
	 * @see #getEPicker()
	 * @generated
	 */
	EReference getEPicker_RegisteredQueries();

	/**
	 * Returns the meta object for the attribute '{@link org.topcased.iterators.configurations.iterator.EPicker#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.topcased.iterators.configurations.iterator.EPicker#getDescription()
	 * @see #getEPicker()
	 * @generated
	 */
	EAttribute getEPicker_Description();

	/**
	 * Returns the meta object for class '{@link org.topcased.iterators.configurations.iterator.OperationSet <em>Operation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Operation Set</em>'.
	 * @see org.topcased.iterators.configurations.iterator.OperationSet
	 * @generated
	 */
	EClass getOperationSet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.topcased.iterators.configurations.iterator.OperationSet#getOperations
	 * <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.topcased.iterators.configurations.iterator.OperationSet#getOperations()
	 * @see #getOperationSet()
	 * @generated
	 */
	EReference getOperationSet_Operations();

	/**
	 * Returns the meta object for class '{@link org.topcased.iterators.configurations.iterator.OCLOperation <em>OCL Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>OCL Operation</em>'.
	 * @see org.topcased.iterators.configurations.iterator.OCLOperation
	 * @generated
	 */
	EClass getOCLOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.topcased.iterators.configurations.iterator.OCLOperation#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Context</em>'.
	 * @see org.topcased.iterators.configurations.iterator.OCLOperation#getContext()
	 * @see #getOCLOperation()
	 * @generated
	 */
	EAttribute getOCLOperation_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.topcased.iterators.configurations.iterator.OCLOperation#getDef <em>Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Def</em>'.
	 * @see org.topcased.iterators.configurations.iterator.OCLOperation#getDef()
	 * @see #getOCLOperation()
	 * @generated
	 */
	EAttribute getOCLOperation_Def();

	/**
	 * Returns the meta object for the attribute '{@link org.topcased.iterators.configurations.iterator.OCLOperation#getMetamodelPrefix
	 * <em>Metamodel Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Metamodel Prefix</em>'.
	 * @see org.topcased.iterators.configurations.iterator.OCLOperation#getMetamodelPrefix()
	 * @see #getOCLOperation()
	 * @generated
	 */
	EAttribute getOCLOperation_MetamodelPrefix();

	/**
	 * Returns the meta object for class '{@link org.topcased.iterators.configurations.iterator.Iterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Iterator</em>'.
	 * @see org.topcased.iterators.configurations.iterator.Iterator
	 * @generated
	 */
	EClass getIterator();

	/**
	 * Returns the meta object for the reference '{@link org.topcased.iterators.configurations.iterator.Iterator#getPickers <em>Pickers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Pickers</em>'.
	 * @see org.topcased.iterators.configurations.iterator.Iterator#getPickers()
	 * @see #getIterator()
	 * @generated
	 */
	EReference getIterator_Pickers();

	/**
	 * Returns the meta object for the attribute '{@link org.topcased.iterators.configurations.iterator.Iterator#getRepresentation
	 * <em>Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Representation</em>'.
	 * @see org.topcased.iterators.configurations.iterator.Iterator#getRepresentation()
	 * @see #getIterator()
	 * @generated
	 */
	EAttribute getIterator_Representation();

	/**
	 * Returns the meta object for the attribute '{@link org.topcased.iterators.configurations.iterator.Iterator#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Algorithm</em>'.
	 * @see org.topcased.iterators.configurations.iterator.Iterator#getAlgorithm()
	 * @see #getIterator()
	 * @generated
	 */
	EAttribute getIterator_Algorithm();

	/**
	 * Returns the meta object for the attribute '{@link org.topcased.iterators.configurations.iterator.Iterator#getDescription <em>Description</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.topcased.iterators.configurations.iterator.Iterator#getDescription()
	 * @see #getIterator()
	 * @generated
	 */
	EAttribute getIterator_Description();

	/**
	 * Returns the meta object for the attribute list '{@link org.topcased.iterators.configurations.iterator.Iterator#getOperationImports
	 * <em>Operation Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Operation Imports</em>'.
	 * @see org.topcased.iterators.configurations.iterator.Iterator#getOperationImports()
	 * @see #getIterator()
	 * @generated
	 */
	EAttribute getIterator_OperationImports();

	/**
	 * Returns the meta object for the attribute '{@link org.topcased.iterators.configurations.iterator.Iterator#isCheckRedundancy
	 * <em>Check Redundancy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Check Redundancy</em>'.
	 * @see org.topcased.iterators.configurations.iterator.Iterator#isCheckRedundancy()
	 * @see #getIterator()
	 * @generated
	 */
	EAttribute getIterator_CheckRedundancy();

	/**
	 * Returns the meta object for class '{@link org.topcased.iterators.configurations.iterator.ConfigurationModel <em>Configuration Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Configuration Model</em>'.
	 * @see org.topcased.iterators.configurations.iterator.ConfigurationModel
	 * @generated
	 */
	EClass getConfigurationModel();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.topcased.iterators.configurations.iterator.ConfigurationModel#getIterators <em>Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Iterators</em>'.
	 * @see org.topcased.iterators.configurations.iterator.ConfigurationModel#getIterators()
	 * @see #getConfigurationModel()
	 * @generated
	 */
	EReference getConfigurationModel_Iterators();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.topcased.iterators.configurations.iterator.ConfigurationModel#getOperationSets <em>Operation Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Operation Sets</em>'.
	 * @see org.topcased.iterators.configurations.iterator.ConfigurationModel#getOperationSets()
	 * @see #getConfigurationModel()
	 * @generated
	 */
	EReference getConfigurationModel_OperationSets();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.topcased.iterators.configurations.iterator.ConfigurationModel#getPickerSets <em>Picker Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Picker Sets</em>'.
	 * @see org.topcased.iterators.configurations.iterator.ConfigurationModel#getPickerSets()
	 * @see #getConfigurationModel()
	 * @generated
	 */
	EReference getConfigurationModel_PickerSets();

	/**
	 * Returns the meta object for class '{@link org.topcased.iterators.configurations.iterator.QueryParam <em>Query Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Query Param</em>'.
	 * @see org.topcased.iterators.configurations.iterator.QueryParam
	 * @generated
	 */
	EClass getQueryParam();

	/**
	 * Returns the meta object for the attribute '{@link org.topcased.iterators.configurations.iterator.QueryParam#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.topcased.iterators.configurations.iterator.QueryParam#getName()
	 * @see #getQueryParam()
	 * @generated
	 */
	EAttribute getQueryParam_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.topcased.iterators.configurations.iterator.QueryParam#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.topcased.iterators.configurations.iterator.QueryParam#getValue()
	 * @see #getQueryParam()
	 * @generated
	 */
	EAttribute getQueryParam_Value();

	/**
	 * Returns the meta object for enum '{@link org.topcased.iterators.configurations.iterator.ALGORITHM_KIND <em>ALGORITHM KIND</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>ALGORITHM KIND</em>'.
	 * @see org.topcased.iterators.configurations.iterator.ALGORITHM_KIND
	 * @generated
	 */
	EEnum getALGORITHM_KIND();

	/**
	 * Returns the meta object for enum '{@link org.topcased.iterators.configurations.iterator.REPRESENTATION_KIND <em>REPRESENTATION KIND</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>REPRESENTATION KIND</em>'.
	 * @see org.topcased.iterators.configurations.iterator.REPRESENTATION_KIND
	 * @generated
	 */
	EEnum getREPRESENTATION_KIND();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IteratorFactory getIteratorFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.topcased.iterators.configurations.iterator.impl.EPickerSetImpl <em>EPicker Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.topcased.iterators.configurations.iterator.impl.EPickerSetImpl
		 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getEPickerSet()
		 * @generated
		 */
		EClass EPICKER_SET = eINSTANCE.getEPickerSet();

		/**
		 * The meta object literal for the '<em><b>Pickers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EPICKER_SET__PICKERS = eINSTANCE.getEPickerSet_Pickers();

		/**
		 * The meta object literal for the '<em><b>Subsets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EPICKER_SET__SUBSETS = eINSTANCE.getEPickerSet_Subsets();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EPICKER_SET__DESCRIPTION = eINSTANCE.getEPickerSet_Description();

		/**
		 * The meta object literal for the '{@link org.topcased.iterators.configurations.iterator.impl.QueryImpl <em>Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.topcased.iterators.configurations.iterator.impl.QueryImpl
		 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getQuery()
		 * @generated
		 */
		EClass QUERY = eINSTANCE.getQuery();

		/**
		 * The meta object literal for the '{@link org.topcased.iterators.configurations.iterator.impl.OCLQueryImpl <em>OCL Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.topcased.iterators.configurations.iterator.impl.OCLQueryImpl
		 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getOCLQuery()
		 * @generated
		 */
		EClass OCL_QUERY = eINSTANCE.getOCLQuery();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OCL_QUERY__BODY = eINSTANCE.getOCLQuery_Body();

		/**
		 * The meta object literal for the '{@link org.topcased.iterators.configurations.iterator.impl.JavaQueryImpl <em>Java Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.topcased.iterators.configurations.iterator.impl.JavaQueryImpl
		 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getJavaQuery()
		 * @generated
		 */
		EClass JAVA_QUERY = eINSTANCE.getJavaQuery();

		/**
		 * The meta object literal for the '<em><b>Javaid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute JAVA_QUERY__JAVAID = eINSTANCE.getJavaQuery_Javaid();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference JAVA_QUERY__PARAMS = eINSTANCE.getJavaQuery_Params();

		/**
		 * The meta object literal for the '{@link org.topcased.iterators.configurations.iterator.impl.NamedElementImpl <em>Named Element</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.topcased.iterators.configurations.iterator.impl.NamedElementImpl
		 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.topcased.iterators.configurations.iterator.impl.EPickerImpl <em>EPicker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.topcased.iterators.configurations.iterator.impl.EPickerImpl
		 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getEPicker()
		 * @generated
		 */
		EClass EPICKER = eINSTANCE.getEPicker();

		/**
		 * The meta object literal for the '<em><b>Registered Queries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EPICKER__REGISTERED_QUERIES = eINSTANCE.getEPicker_RegisteredQueries();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EPICKER__DESCRIPTION = eINSTANCE.getEPicker_Description();

		/**
		 * The meta object literal for the '{@link org.topcased.iterators.configurations.iterator.impl.OperationSetImpl <em>Operation Set</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.topcased.iterators.configurations.iterator.impl.OperationSetImpl
		 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getOperationSet()
		 * @generated
		 */
		EClass OPERATION_SET = eINSTANCE.getOperationSet();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OPERATION_SET__OPERATIONS = eINSTANCE.getOperationSet_Operations();

		/**
		 * The meta object literal for the '{@link org.topcased.iterators.configurations.iterator.impl.OCLOperationImpl <em>OCL Operation</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.topcased.iterators.configurations.iterator.impl.OCLOperationImpl
		 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getOCLOperation()
		 * @generated
		 */
		EClass OCL_OPERATION = eINSTANCE.getOCLOperation();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OCL_OPERATION__CONTEXT = eINSTANCE.getOCLOperation_Context();

		/**
		 * The meta object literal for the '<em><b>Def</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OCL_OPERATION__DEF = eINSTANCE.getOCLOperation_Def();

		/**
		 * The meta object literal for the '<em><b>Metamodel Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OCL_OPERATION__METAMODEL_PREFIX = eINSTANCE.getOCLOperation_MetamodelPrefix();

		/**
		 * The meta object literal for the '{@link org.topcased.iterators.configurations.iterator.impl.IteratorImpl <em>Iterator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.topcased.iterators.configurations.iterator.impl.IteratorImpl
		 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getIterator()
		 * @generated
		 */
		EClass ITERATOR = eINSTANCE.getIterator();

		/**
		 * The meta object literal for the '<em><b>Pickers</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ITERATOR__PICKERS = eINSTANCE.getIterator_Pickers();

		/**
		 * The meta object literal for the '<em><b>Representation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ITERATOR__REPRESENTATION = eINSTANCE.getIterator_Representation();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ITERATOR__ALGORITHM = eINSTANCE.getIterator_Algorithm();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ITERATOR__DESCRIPTION = eINSTANCE.getIterator_Description();

		/**
		 * The meta object literal for the '<em><b>Operation Imports</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ITERATOR__OPERATION_IMPORTS = eINSTANCE.getIterator_OperationImports();

		/**
		 * The meta object literal for the '<em><b>Check Redundancy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ITERATOR__CHECK_REDUNDANCY = eINSTANCE.getIterator_CheckRedundancy();

		/**
		 * The meta object literal for the '{@link org.topcased.iterators.configurations.iterator.impl.ConfigurationModelImpl
		 * <em>Configuration Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.topcased.iterators.configurations.iterator.impl.ConfigurationModelImpl
		 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getConfigurationModel()
		 * @generated
		 */
		EClass CONFIGURATION_MODEL = eINSTANCE.getConfigurationModel();

		/**
		 * The meta object literal for the '<em><b>Iterators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURATION_MODEL__ITERATORS = eINSTANCE.getConfigurationModel_Iterators();

		/**
		 * The meta object literal for the '<em><b>Operation Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURATION_MODEL__OPERATION_SETS = eINSTANCE.getConfigurationModel_OperationSets();

		/**
		 * The meta object literal for the '<em><b>Picker Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONFIGURATION_MODEL__PICKER_SETS = eINSTANCE.getConfigurationModel_PickerSets();

		/**
		 * The meta object literal for the '{@link org.topcased.iterators.configurations.iterator.impl.QueryParamImpl <em>Query Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.topcased.iterators.configurations.iterator.impl.QueryParamImpl
		 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getQueryParam()
		 * @generated
		 */
		EClass QUERY_PARAM = eINSTANCE.getQueryParam();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUERY_PARAM__NAME = eINSTANCE.getQueryParam_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUERY_PARAM__VALUE = eINSTANCE.getQueryParam_Value();

		/**
		 * The meta object literal for the '{@link org.topcased.iterators.configurations.iterator.ALGORITHM_KIND <em>ALGORITHM KIND</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.topcased.iterators.configurations.iterator.ALGORITHM_KIND
		 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getALGORITHM_KIND()
		 * @generated
		 */
		EEnum ALGORITHM_KIND = eINSTANCE.getALGORITHM_KIND();

		/**
		 * The meta object literal for the '{@link org.topcased.iterators.configurations.iterator.REPRESENTATION_KIND <em>REPRESENTATION KIND</em>}'
		 * enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.topcased.iterators.configurations.iterator.REPRESENTATION_KIND
		 * @see org.topcased.iterators.configurations.iterator.impl.IteratorPackageImpl#getREPRESENTATION_KIND()
		 * @generated
		 */
		EEnum REPRESENTATION_KIND = eINSTANCE.getREPRESENTATION_KIND();

	}

} //IteratorPackage
