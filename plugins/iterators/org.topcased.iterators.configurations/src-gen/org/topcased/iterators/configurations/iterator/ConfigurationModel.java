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
 * $Id: ConfigurationModel.java,v 1.1 2013/01/18 11:03:48 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Model</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.iterators.configurations.iterator.ConfigurationModel#getIterators <em>Iterators</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.ConfigurationModel#getOperationSets <em>Operation Sets</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.ConfigurationModel#getPickerSets <em>Picker Sets</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getConfigurationModel()
 * @model
 * @generated
 */
public interface ConfigurationModel extends EObject {

	/**
	 * Returns the value of the '<em><b>Iterators</b></em>' containment reference list.
	 * The list contents are of type {@link org.topcased.iterators.configurations.iterator.Iterator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterators</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Iterators</em>' containment reference list.
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getConfigurationModel_Iterators()
	 * @model containment="true"
	 * @generated
	 */
	EList<Iterator> getIterators();

	/**
	 * Returns the value of the '<em><b>Operation Sets</b></em>' containment reference list.
	 * The list contents are of type {@link org.topcased.iterators.configurations.iterator.OperationSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Sets</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Operation Sets</em>' containment reference list.
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getConfigurationModel_OperationSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<OperationSet> getOperationSets();

	/**
	 * Returns the value of the '<em><b>Picker Sets</b></em>' containment reference list.
	 * The list contents are of type {@link org.topcased.iterators.configurations.iterator.EPickerSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Picker Sets</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Picker Sets</em>' containment reference list.
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getConfigurationModel_PickerSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<EPickerSet> getPickerSets();

} // ConfigurationModel
