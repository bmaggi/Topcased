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
 * $Id: OCLOperation.java,v 1.1 2013/01/18 11:03:47 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OCL Operation</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.iterators.configurations.iterator.OCLOperation#getContext <em>Context</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.OCLOperation#getDef <em>Def</em>}</li>
 * <li>{@link org.topcased.iterators.configurations.iterator.OCLOperation#getMetamodelPrefix <em>Metamodel Prefix</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getOCLOperation()
 * @model
 * @generated
 */
public interface OCLOperation extends EObject {

	/**
	 * Returns the value of the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Context</em>' attribute.
	 * @see #setContext(String)
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getOCLOperation_Context()
	 * @model required="true"
	 * @generated
	 */
	String getContext();

	/**
	 * Sets the value of the '{@link org.topcased.iterators.configurations.iterator.OCLOperation#getContext <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Context</em>' attribute.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(String value);

	/**
	 * Returns the value of the '<em><b>Def</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Def</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Def</em>' attribute.
	 * @see #setDef(String)
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getOCLOperation_Def()
	 * @model required="true"
	 * @generated
	 */
	String getDef();

	/**
	 * Sets the value of the '{@link org.topcased.iterators.configurations.iterator.OCLOperation#getDef <em>Def</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Def</em>' attribute.
	 * @see #getDef()
	 * @generated
	 */
	void setDef(String value);

	/**
	 * Returns the value of the '<em><b>Metamodel Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel Prefix</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Metamodel Prefix</em>' attribute.
	 * @see #setMetamodelPrefix(String)
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getOCLOperation_MetamodelPrefix()
	 * @model required="true"
	 * @generated
	 */
	String getMetamodelPrefix();

	/**
	 * Sets the value of the '{@link org.topcased.iterators.configurations.iterator.OCLOperation#getMetamodelPrefix <em>Metamodel Prefix</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Metamodel Prefix</em>' attribute.
	 * @see #getMetamodelPrefix()
	 * @generated
	 */
	void setMetamodelPrefix(String value);

} // OCLOperation
