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
package org.topcased.ocl.evaluation.exceptions;

import org.eclipse.ocl.ParserException;


public class OperationParsingException extends Exception {

	private static final long serialVersionUID = 1L;
	
	String oclOperation;
	
	public OperationParsingException(String operationDef, ParserException parent){
		super (parent.getMessage(), parent.getCause());
		oclOperation = operationDef;
	}
	
	public String getOperationDef(){
		return oclOperation;
	}
	
}
