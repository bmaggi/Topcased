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
 * $Id: IteratorPackageImpl.java,v 1.1 2013/01/18 11:03:46 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.topcased.iterators.configurations.iterator.ConfigurationModel;
import org.topcased.iterators.configurations.iterator.EPicker;
import org.topcased.iterators.configurations.iterator.EPickerSet;
import org.topcased.iterators.configurations.iterator.Iterator;
import org.topcased.iterators.configurations.iterator.IteratorFactory;
import org.topcased.iterators.configurations.iterator.IteratorPackage;
import org.topcased.iterators.configurations.iterator.JavaQuery;
import org.topcased.iterators.configurations.iterator.NamedElement;
import org.topcased.iterators.configurations.iterator.OCLOperation;
import org.topcased.iterators.configurations.iterator.OCLQuery;
import org.topcased.iterators.configurations.iterator.OperationSet;
import org.topcased.iterators.configurations.iterator.Query;
import org.topcased.iterators.configurations.iterator.QueryParam;
import org.topcased.iterators.configurations.iterator.QueryParams;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class IteratorPackageImpl extends EPackageImpl implements IteratorPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass ePickerSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass queryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass oclQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass javaQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass ePickerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass operationSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass oclOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iteratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass configurationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass queryParamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum algorithM_KINDEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum representatioN_KINDEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private IteratorPackageImpl() {
		super(eNS_URI, IteratorFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link IteratorPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly.
	 * Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IteratorPackage init() {
		if(isInited)
			return (IteratorPackage)EPackage.Registry.INSTANCE.getEPackage(IteratorPackage.eNS_URI);

		// Obtain or create and register package
		IteratorPackageImpl theIteratorPackage = (IteratorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof IteratorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new IteratorPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theIteratorPackage.createPackageContents();

		// Initialize created meta-data
		theIteratorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIteratorPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IteratorPackage.eNS_URI, theIteratorPackage);
		return theIteratorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEPickerSet() {
		return ePickerSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEPickerSet_Pickers() {
		return (EReference)ePickerSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEPickerSet_Subsets() {
		return (EReference)ePickerSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEPickerSet_Description() {
		return (EAttribute)ePickerSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getQuery() {
		return queryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOCLQuery() {
		return oclQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getOCLQuery_Body() {
		return (EAttribute)oclQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJavaQuery() {
		return javaQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJavaQuery_Javaid() {
		return (EAttribute)javaQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJavaQuery_Params() {
		return (EReference)javaQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEPicker() {
		return ePickerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEPicker_RegisteredQueries() {
		return (EReference)ePickerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEPicker_Description() {
		return (EAttribute)ePickerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOperationSet() {
		return operationSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOperationSet_Operations() {
		return (EReference)operationSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOCLOperation() {
		return oclOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getOCLOperation_Context() {
		return (EAttribute)oclOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getOCLOperation_Def() {
		return (EAttribute)oclOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getOCLOperation_MetamodelPrefix() {
		return (EAttribute)oclOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIterator() {
		return iteratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIterator_Pickers() {
		return (EReference)iteratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIterator_Representation() {
		return (EAttribute)iteratorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIterator_Algorithm() {
		return (EAttribute)iteratorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIterator_Description() {
		return (EAttribute)iteratorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIterator_OperationImports() {
		return (EAttribute)iteratorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIterator_CheckRedundancy() {
		return (EAttribute)iteratorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getConfigurationModel() {
		return configurationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConfigurationModel_Iterators() {
		return (EReference)configurationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConfigurationModel_OperationSets() {
		return (EReference)configurationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConfigurationModel_PickerSets() {
		return (EReference)configurationModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getQueryParam() {
		return queryParamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getQueryParam_Name() {
		return (EAttribute)queryParamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getQueryParam_Value() {
		return (EAttribute)queryParamEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getALGORITHM_KIND() {
		return algorithM_KINDEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getREPRESENTATION_KIND() {
		return representatioN_KINDEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IteratorFactory getIteratorFactory() {
		return (IteratorFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if(isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		ePickerSetEClass = createEClass(EPICKER_SET);
		createEReference(ePickerSetEClass, EPICKER_SET__PICKERS);
		createEReference(ePickerSetEClass, EPICKER_SET__SUBSETS);
		createEAttribute(ePickerSetEClass, EPICKER_SET__DESCRIPTION);

		queryEClass = createEClass(QUERY);

		oclQueryEClass = createEClass(OCL_QUERY);
		createEAttribute(oclQueryEClass, OCL_QUERY__BODY);

		javaQueryEClass = createEClass(JAVA_QUERY);
		createEAttribute(javaQueryEClass, JAVA_QUERY__JAVAID);
		createEReference(javaQueryEClass, JAVA_QUERY__PARAMS);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		ePickerEClass = createEClass(EPICKER);
		createEReference(ePickerEClass, EPICKER__REGISTERED_QUERIES);
		createEAttribute(ePickerEClass, EPICKER__DESCRIPTION);

		operationSetEClass = createEClass(OPERATION_SET);
		createEReference(operationSetEClass, OPERATION_SET__OPERATIONS);

		oclOperationEClass = createEClass(OCL_OPERATION);
		createEAttribute(oclOperationEClass, OCL_OPERATION__CONTEXT);
		createEAttribute(oclOperationEClass, OCL_OPERATION__DEF);
		createEAttribute(oclOperationEClass, OCL_OPERATION__METAMODEL_PREFIX);

		iteratorEClass = createEClass(ITERATOR);
		createEReference(iteratorEClass, ITERATOR__PICKERS);
		createEAttribute(iteratorEClass, ITERATOR__REPRESENTATION);
		createEAttribute(iteratorEClass, ITERATOR__ALGORITHM);
		createEAttribute(iteratorEClass, ITERATOR__DESCRIPTION);
		createEAttribute(iteratorEClass, ITERATOR__OPERATION_IMPORTS);
		createEAttribute(iteratorEClass, ITERATOR__CHECK_REDUNDANCY);

		configurationModelEClass = createEClass(CONFIGURATION_MODEL);
		createEReference(configurationModelEClass, CONFIGURATION_MODEL__ITERATORS);
		createEReference(configurationModelEClass, CONFIGURATION_MODEL__OPERATION_SETS);
		createEReference(configurationModelEClass, CONFIGURATION_MODEL__PICKER_SETS);

		queryParamEClass = createEClass(QUERY_PARAM);
		createEAttribute(queryParamEClass, QUERY_PARAM__NAME);
		createEAttribute(queryParamEClass, QUERY_PARAM__VALUE);

		// Create enums
		algorithM_KINDEEnum = createEEnum(ALGORITHM_KIND);
		representatioN_KINDEEnum = createEEnum(REPRESENTATION_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if(isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		queryEClass.getESuperTypes().add(this.getNamedElement());
		oclQueryEClass.getESuperTypes().add(this.getQuery());
		javaQueryEClass.getESuperTypes().add(this.getQuery());
		ePickerEClass.getESuperTypes().add(this.getNamedElement());
		operationSetEClass.getESuperTypes().add(this.getNamedElement());
		iteratorEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(ePickerSetEClass, EPickerSet.class, "EPickerSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEPickerSet_Pickers(), this.getEPicker(), null, "pickers", null, 0, -1, EPickerSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEPickerSet_Subsets(), this.getEPickerSet(), null, "subsets", null, 0, -1, EPickerSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPickerSet_Description(), ecorePackage.getEString(), "description", null, 0, 1, EPickerSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(ePickerSetEClass, null, "EOperation0", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(queryEClass, Query.class, "Query", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(oclQueryEClass, OCLQuery.class, "OCLQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOCLQuery_Body(), ecorePackage.getEString(), "body", null, 0, 1, OCLQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaQueryEClass, JavaQuery.class, "JavaQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaQuery_Javaid(), ecorePackage.getEString(), "javaid", null, 0, 1, JavaQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaQuery_Params(), this.getQueryParam(), null, "params", null, 0, -1, JavaQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ePickerEClass, EPicker.class, "EPicker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEPicker_RegisteredQueries(), this.getQuery(), null, "registeredQueries", null, 0, -1, EPicker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEPicker_Description(), ecorePackage.getEString(), "description", null, 0, 1, EPicker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationSetEClass, OperationSet.class, "OperationSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationSet_Operations(), this.getOCLOperation(), null, "operations", null, 0, -1, OperationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oclOperationEClass, OCLOperation.class, "OCLOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOCLOperation_Context(), ecorePackage.getEString(), "context", null, 1, 1, OCLOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOCLOperation_Def(), ecorePackage.getEString(), "def", null, 1, 1, OCLOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOCLOperation_MetamodelPrefix(), ecorePackage.getEString(), "metamodelPrefix", null, 1, 1, OCLOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iteratorEClass, Iterator.class, "Iterator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIterator_Pickers(), this.getEPickerSet(), null, "pickers", null, 1, 1, Iterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterator_Representation(), this.getREPRESENTATION_KIND(), "representation", null, 1, 1, Iterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterator_Algorithm(), this.getALGORITHM_KIND(), "algorithm", null, 1, 1, Iterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterator_Description(), ecorePackage.getEString(), "description", null, 0, 1, Iterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterator_OperationImports(), ecorePackage.getEString(), "operationImports", null, 0, -1, Iterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterator_CheckRedundancy(), ecorePackage.getEBoolean(), "checkRedundancy", null, 1, 1, Iterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationModelEClass, ConfigurationModel.class, "ConfigurationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigurationModel_Iterators(), this.getIterator(), null, "iterators", null, 0, -1, ConfigurationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationModel_OperationSets(), this.getOperationSet(), null, "operationSets", null, 0, -1, ConfigurationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationModel_PickerSets(), this.getEPickerSet(), null, "pickerSets", null, 0, -1, ConfigurationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryParamEClass, QueryParam.class, "QueryParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQueryParam_Name(), ecorePackage.getEString(), "name", null, 0, 1, QueryParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryParam_Value(), ecorePackage.getEString(), "value", null, 0, 1, QueryParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(algorithM_KINDEEnum, org.topcased.iterators.configurations.iterator.ALGORITHM_KIND.class, "ALGORITHM_KIND");
		addEEnumLiteral(algorithM_KINDEEnum, org.topcased.iterators.configurations.iterator.ALGORITHM_KIND.DEPTH_WISE);
		addEEnumLiteral(algorithM_KINDEEnum, org.topcased.iterators.configurations.iterator.ALGORITHM_KIND.WIDTH_WISE);

		initEEnum(representatioN_KINDEEnum, org.topcased.iterators.configurations.iterator.REPRESENTATION_KIND.class, "REPRESENTATION_KIND");
		addEEnumLiteral(representatioN_KINDEEnum, org.topcased.iterators.configurations.iterator.REPRESENTATION_KIND.STATE_WISE);
		addEEnumLiteral(representatioN_KINDEEnum, org.topcased.iterators.configurations.iterator.REPRESENTATION_KIND.TRANSITION_WISE);

		// Create resource
		createResource(eNS_URI);
	}

} //IteratorPackageImpl
