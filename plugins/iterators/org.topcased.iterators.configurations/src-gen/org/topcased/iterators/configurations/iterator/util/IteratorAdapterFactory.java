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
 * $Id: IteratorAdapterFactory.java,v 1.1 2013/01/18 11:03:56 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.topcased.iterators.configurations.iterator.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.topcased.iterators.configurations.iterator.IteratorPackage
 * @generated
 */
public class IteratorAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static IteratorPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IteratorAdapterFactory() {
		if(modelPackage == null) {
			modelPackage = IteratorPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if(object == modelPackage) {
			return true;
		}
		if(object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IteratorSwitch<Adapter> modelSwitch = new IteratorSwitch<Adapter>() {

		@Override
		public Adapter caseEPickerSet(EPickerSet object) {
			return createEPickerSetAdapter();
		}

		@Override
		public Adapter caseQuery(Query object) {
			return createQueryAdapter();
		}

		@Override
		public Adapter caseOCLQuery(OCLQuery object) {
			return createOCLQueryAdapter();
		}

		@Override
		public Adapter caseJavaQuery(JavaQuery object) {
			return createJavaQueryAdapter();
		}

		@Override
		public Adapter caseNamedElement(NamedElement object) {
			return createNamedElementAdapter();
		}

		@Override
		public Adapter caseEPicker(EPicker object) {
			return createEPickerAdapter();
		}

		@Override
		public Adapter caseOperationSet(OperationSet object) {
			return createOperationSetAdapter();
		}

		@Override
		public Adapter caseOCLOperation(OCLOperation object) {
			return createOCLOperationAdapter();
		}

		@Override
		public Adapter caseIterator(Iterator object) {
			return createIteratorAdapter();
		}

		@Override
		public Adapter caseConfigurationModel(ConfigurationModel object) {
			return createConfigurationModelAdapter();
		}

		@Override
		public Adapter caseQueryParam(QueryParam object) {
			return createQueryParamAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param target
	 *        the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.topcased.iterators.configurations.iterator.EPickerSet <em>EPicker Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.topcased.iterators.configurations.iterator.EPickerSet
	 * @generated
	 */
	public Adapter createEPickerSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.topcased.iterators.configurations.iterator.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.topcased.iterators.configurations.iterator.Query
	 * @generated
	 */
	public Adapter createQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.topcased.iterators.configurations.iterator.OCLQuery <em>OCL Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.topcased.iterators.configurations.iterator.OCLQuery
	 * @generated
	 */
	public Adapter createOCLQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.topcased.iterators.configurations.iterator.JavaQuery <em>Java Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.topcased.iterators.configurations.iterator.JavaQuery
	 * @generated
	 */
	public Adapter createJavaQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.topcased.iterators.configurations.iterator.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.topcased.iterators.configurations.iterator.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.topcased.iterators.configurations.iterator.EPicker <em>EPicker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.topcased.iterators.configurations.iterator.EPicker
	 * @generated
	 */
	public Adapter createEPickerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.topcased.iterators.configurations.iterator.OperationSet <em>Operation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.topcased.iterators.configurations.iterator.OperationSet
	 * @generated
	 */
	public Adapter createOperationSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.topcased.iterators.configurations.iterator.OCLOperation <em>OCL Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.topcased.iterators.configurations.iterator.OCLOperation
	 * @generated
	 */
	public Adapter createOCLOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.topcased.iterators.configurations.iterator.Iterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.topcased.iterators.configurations.iterator.Iterator
	 * @generated
	 */
	public Adapter createIteratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.topcased.iterators.configurations.iterator.ConfigurationModel
	 * <em>Configuration Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.topcased.iterators.configurations.iterator.ConfigurationModel
	 * @generated
	 */
	public Adapter createConfigurationModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.topcased.iterators.configurations.iterator.QueryParam <em>Query Param</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.topcased.iterators.configurations.iterator.QueryParam
	 * @generated
	 */
	public Adapter createQueryParamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //IteratorAdapterFactory
