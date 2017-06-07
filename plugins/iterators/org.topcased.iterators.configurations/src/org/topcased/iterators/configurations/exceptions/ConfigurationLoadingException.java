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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PlatformUI;

public class ConfigurationLoadingException extends CoreException {

	public ConfigurationLoadingException(String message) {
		this(new Status(IStatus.ERROR, PlatformUI.PLUGIN_ID, 0, message, null));
	}

	private ConfigurationLoadingException(Status status) {
		super(status);
	}

	private static final long serialVersionUID = 1L;



}
