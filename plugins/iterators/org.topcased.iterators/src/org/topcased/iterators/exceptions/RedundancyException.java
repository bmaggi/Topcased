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
package org.topcased.iterators.exceptions;

/**
 * Exception raised when a cycle is detected while iterating.
 * 
 */
public class RedundancyException extends CannotHandleException {

	private static final long serialVersionUID = 1L;

	Object redundantObject;

	public RedundancyException(Object redundantObject) {
		this.redundantObject = redundantObject;
	}

}
