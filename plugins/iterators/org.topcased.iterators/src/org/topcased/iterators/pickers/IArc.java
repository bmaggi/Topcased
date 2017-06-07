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
package org.topcased.iterators.pickers;

/**
 * Describes the link between an element and his children
 * (which are retrieved by the getNexts() method of pickers.
 */
public interface IArc {

	public abstract Object getOrigin();

	public abstract Object getDestination();

}
