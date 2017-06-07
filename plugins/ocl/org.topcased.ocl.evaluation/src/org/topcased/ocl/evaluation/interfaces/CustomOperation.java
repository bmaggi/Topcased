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
package org.topcased.ocl.evaluation.interfaces;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.expressions.Variable;

/**
 * Interface for the user to implement if he wants to implement Java methods and call them 
 * in OCL
 */
public interface CustomOperation {

	/**
	 * Matches the following ocl code : 
	 * context.customOperation(args)
	 */
	public Object execute(Object context, Object[] args) throws IllegalArgumentException;
	/**
	 * Check whether the operation is executable for a given context and given arguments.
	 * @param context
	 * @param args
	 * @return
	 */
	public boolean check(Object context, Object[] args);

	/**
	 * The name of the operation to be added to the evaluation environment.
	 */
	public String getName();

	/**
	 * The type on which the operation is executable.
	 */
	public EClassifier getEClassifier();

	/**
	 * The type returned by the operation.
	 */
	public EClassifier getType();

	/**
	 * The parameters of the operation.
	 */
	public List<Variable<EClassifier, EParameter>> getParameters();
	
}
