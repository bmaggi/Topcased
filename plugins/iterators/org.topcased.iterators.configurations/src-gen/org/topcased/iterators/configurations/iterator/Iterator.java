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
 * $Id: Iterator.java,v 1.1 2013/01/18 11:03:47 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.iterators.configurations.iterator.Iterator#getPickers <em>Pickers</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.Iterator#getRepresentation <em>Representation</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.Iterator#getAlgorithm <em>Algorithm</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.Iterator#getDescription <em>Description</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.Iterator#getOperationImports <em>Operation Imports</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.Iterator#isCheckRedundancy <em>Check Redundancy</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getIterator()
 * @model
 * @generated
 */
public interface Iterator extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Pickers</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pickers</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Pickers</em>' reference.
	 * @see #setPickers(EPickerSet)
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getIterator_Pickers()
	 * @model required="true"
	 * @generated
	 */
	EPickerSet getPickers();

	/**
	 * Sets the value of the '{@link org.topcased.iterators.configurations.iterator.Iterator#getPickers <em>Pickers</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Pickers</em>' reference.
	 * @see #getPickers()
	 * @generated
	 */
	void setPickers(EPickerSet value);

	/**
	 * Returns the value of the '<em><b>Representation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.topcased.iterators.configurations.iterator.REPRESENTATION_KIND}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Representation</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Representation</em>' attribute.
	 * @see org.topcased.iterators.configurations.iterator.REPRESENTATION_KIND
	 * @see #setRepresentation(REPRESENTATION_KIND)
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getIterator_Representation()
	 * @model required="true"
	 * @generated
	 */
	REPRESENTATION_KIND getRepresentation();

	/**
	 * Sets the value of the '{@link org.topcased.iterators.configurations.iterator.Iterator#getRepresentation <em>Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Representation</em>' attribute.
	 * @see org.topcased.iterators.configurations.iterator.REPRESENTATION_KIND
	 * @see #getRepresentation()
	 * @generated
	 */
	void setRepresentation(REPRESENTATION_KIND value);

	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' attribute.
	 * The literals are from the enumeration {@link org.topcased.iterators.configurations.iterator.ALGORITHM_KIND}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Algorithm</em>' attribute.
	 * @see org.topcased.iterators.configurations.iterator.ALGORITHM_KIND
	 * @see #setAlgorithm(ALGORITHM_KIND)
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getIterator_Algorithm()
	 * @model required="true"
	 * @generated
	 */
	ALGORITHM_KIND getAlgorithm();

	/**
	 * Sets the value of the '{@link org.topcased.iterators.configurations.iterator.Iterator#getAlgorithm <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Algorithm</em>' attribute.
	 * @see org.topcased.iterators.configurations.iterator.ALGORITHM_KIND
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(ALGORITHM_KIND value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getIterator_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.topcased.iterators.configurations.iterator.Iterator#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Operation Imports</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Imports</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Operation Imports</em>' attribute list.
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getIterator_OperationImports()
	 * @model
	 * @generated
	 */
	EList<String> getOperationImports();

	/**
	 * Returns the value of the '<em><b>Check Redundancy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check Redundancy</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Check Redundancy</em>' attribute.
	 * @see #setCheckRedundancy(boolean)
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getIterator_CheckRedundancy()
	 * @model required="true"
	 * @generated
	 */
	boolean isCheckRedundancy();

	/**
	 * Sets the value of the '{@link org.topcased.iterators.configurations.iterator.Iterator#isCheckRedundancy <em>Check Redundancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Check Redundancy</em>' attribute.
	 * @see #isCheckRedundancy()
	 * @generated
	 */
	void setCheckRedundancy(boolean value);

} // Iterator
