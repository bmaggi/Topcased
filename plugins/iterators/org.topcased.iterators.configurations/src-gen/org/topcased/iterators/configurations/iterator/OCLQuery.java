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
 * $Id: OCLQuery.java,v 1.1 2013/01/18 11:03:46 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OCL Query</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.iterators.configurations.iterator.OCLQuery#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getOCLQuery()
 * @model
 * @generated
 */
public interface OCLQuery extends Query {

	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getOCLQuery_Body()
	 * @model
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link org.topcased.iterators.configurations.iterator.OCLQuery#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

} // OCLQuery
