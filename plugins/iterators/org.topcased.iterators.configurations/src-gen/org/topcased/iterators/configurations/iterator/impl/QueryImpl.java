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
 * $Id: QueryImpl.java,v 1.1 2013/01/18 11:03:45 omelois Exp $
 */
package org.topcased.iterators.configurations.iterator.impl;

import org.eclipse.emf.ecore.EClass;

import org.topcased.iterators.configurations.iterator.IteratorPackage;
import org.topcased.iterators.configurations.iterator.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public abstract class QueryImpl extends NamedElementImpl implements Query {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected QueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IteratorPackage.Literals.QUERY;
	}

} //QueryImpl
