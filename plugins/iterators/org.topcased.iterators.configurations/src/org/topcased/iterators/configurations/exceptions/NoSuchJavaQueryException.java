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
package org.topcased.iterators.configurations.exceptions;

public class NoSuchJavaQueryException extends ConfigurationLoadingException {

	private static final long serialVersionUID = 1L;

	public NoSuchJavaQueryException(String message) {
		super(message);
	}

}
