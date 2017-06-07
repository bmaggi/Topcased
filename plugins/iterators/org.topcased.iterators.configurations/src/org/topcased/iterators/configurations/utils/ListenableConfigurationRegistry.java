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
package org.topcased.iterators.configurations.utils;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;


public abstract class ListenableConfigurationRegistry implements IResourceVisitor, IResourceDeltaVisitor {

	private Collection<RegistryListener> listeners = new HashSet<RegistryListener>();

	public void addListener(RegistryListener listener) {
		listeners.add(listener);
	}

	public void removeListener(RegistryListener listener) {
		listeners.remove(listener);
	}

	protected void notifyListeners() {
		for(RegistryListener listener : listeners) {
			listener.handleChange();
		}
	}

}
