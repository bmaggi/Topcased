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
 * $Id: JavaQuery.java,v 1.1 2013/01/18 11:03:46 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Query</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.iterators.configurations.iterator.JavaQuery#getJavaid <em>Javaid</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.JavaQuery#getParams <em>Params</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getJavaQuery()
 * @model
 * @generated
 */
public interface JavaQuery extends Query {

	/**
	 * Returns the value of the '<em><b>Javaid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Javaid</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Javaid</em>' attribute.
	 * @see #setJavaid(String)
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getJavaQuery_Javaid()
	 * @model
	 * @generated
	 */
	String getJavaid();

	/**
	 * Sets the value of the '{@link org.topcased.iterators.configurations.iterator.JavaQuery#getJavaid <em>Javaid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Javaid</em>' attribute.
	 * @see #getJavaid()
	 * @generated
	 */
	void setJavaid(String value);

	/**
	 * Returns the value of the '<em><b>Params</b></em>' containment reference list.
	 * The list contents are of type {@link org.topcased.iterators.configurations.iterator.QueryParam}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Params</em>' containment reference list.
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getJavaQuery_Params()
	 * @model containment="true"
	 * @generated
	 */
	EList<QueryParam> getParams();

} // JavaQuery
