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
 * An exception class that can be thrown by results handlers to
 * signal that the processed element cannot be handled.
 */
public class CannotHandleException extends Exception {

	private static final long serialVersionUID = 1L;


	public CannotHandleException() {
	}

	public CannotHandleException(String message) {
		super(message);
	}

	public CannotHandleException(String message, Throwable cause) {
		super(message, cause);
	}

	public CannotHandleException(Throwable cause) {
		super(cause);
	}

}
