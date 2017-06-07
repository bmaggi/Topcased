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
 * $Id: EPicker.java,v 1.1 2013/01/18 11:03:46 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EPicker</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.iterators.configurations.iterator.EPicker#getRegisteredQueries <em>Registered Queries</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.EPicker#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getEPicker()
 * @model
 * @generated
 */
public interface EPicker extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Registered Queries</b></em>' containment reference list.
	 * The list contents are of type {@link org.topcased.iterators.configurations.iterator.Query}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registered Queries</em>' containment reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Registered Queries</em>' containment reference list.
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getEPicker_RegisteredQueries()
	 * @model containment="true"
	 * @generated
	 */
	EList<Query> getRegisteredQueries();

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
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getEPicker_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.topcased.iterators.configurations.iterator.EPicker#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // EPicker
