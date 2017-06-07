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
 * An exception class that can be thrown by pickers.
 */
public class PickerExecutionException extends Exception {

	private static final long serialVersionUID = 1L;


	public PickerExecutionException() {
	}

	public PickerExecutionException(String message) {
		super(message);
	}

	public PickerExecutionException(String message, Throwable cause) {
		super(message, cause);
	}

	public PickerExecutionException(Throwable cause) {
		this(cause.getMessage());

	}

}
