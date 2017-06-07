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
 * $Id: EPickerSet.java,v 1.1 2013/01/18 11:03:47 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EPicker Set</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.iterators.configurations.iterator.EPickerSet#getPickers <em>Pickers</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.EPickerSet#getSubsets <em>Subsets</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.EPickerSet#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getEPickerSet()
 * @model
 * @generated
 */
public interface EPickerSet extends EObject {

	/**
	 * Returns the value of the '<em><b>Pickers</b></em>' containment reference list.
	 * The list contents are of type {@link org.topcased.iterators.configurations.iterator.EPicker}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pickers</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Pickers</em>' containment reference list.
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getEPickerSet_Pickers()
	 * @model containment="true"
	 * @generated
	 */
	EList<EPicker> getPickers();

	/**
	 * Returns the value of the '<em><b>Subsets</b></em>' reference list.
	 * The list contents are of type {@link org.topcased.iterators.configurations.iterator.EPickerSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsets</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Subsets</em>' reference list.
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getEPickerSet_Subsets()
	 * @model
	 * @generated
	 */
	EList<EPickerSet> getSubsets();

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
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getEPickerSet_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.topcased.iterators.configurations.iterator.EPickerSet#getDescription <em>Description</em>}' attribute.
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	void EOperation0();

} // EPickerSet
