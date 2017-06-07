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
 * $Id: IteratorFactory.java,v 1.1 2013/01/18 11:03:46 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.topcased.iterators.configurations.iterator.IteratorPackage
 * @generated
 */
public interface IteratorFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	IteratorFactory eINSTANCE = org.topcased.iterators.configurations.iterator.impl.IteratorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EPicker Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>EPicker Set</em>'.
	 * @generated
	 */
	EPickerSet createEPickerSet();

	/**
	 * Returns a new object of class '<em>OCL Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>OCL Query</em>'.
	 * @generated
	 */
	OCLQuery createOCLQuery();

	/**
	 * Returns a new object of class '<em>Java Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Java Query</em>'.
	 * @generated
	 */
	JavaQuery createJavaQuery();

	/**
	 * Returns a new object of class '<em>EPicker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>EPicker</em>'.
	 * @generated
	 */
	EPicker createEPicker();

	/**
	 * Returns a new object of class '<em>Operation Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Operation Set</em>'.
	 * @generated
	 */
	OperationSet createOperationSet();

	/**
	 * Returns a new object of class '<em>OCL Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>OCL Operation</em>'.
	 * @generated
	 */
	OCLOperation createOCLOperation();

	/**
	 * Returns a new object of class '<em>Iterator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Iterator</em>'.
	 * @generated
	 */
	Iterator createIterator();

	/**
	 * Returns a new object of class '<em>Configuration Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Configuration Model</em>'.
	 * @generated
	 */
	ConfigurationModel createConfigurationModel();

	/**
	 * Returns a new object of class '<em>Query Param</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Query Param</em>'.
	 * @generated
	 */
	QueryParam createQueryParam();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	IteratorPackage getIteratorPackage();

} //IteratorFactory
