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
 * $Id: OperationSet.java,v 1.1 2013/01/18 11:03:48 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Set</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.topcased.iterators.configurations.iterator.OperationSet#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getOperationSet()
 * @model
 * @generated
 */
public interface OperationSet extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.topcased.iterators.configurations.iterator.OCLOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see org.topcased.iterators.configurations.iterator.IteratorPackage#getOperationSet_Operations()
	 * @model containment="true"
	 * @generated
	 */
	EList<OCLOperation> getOperations();

} // OperationSet
