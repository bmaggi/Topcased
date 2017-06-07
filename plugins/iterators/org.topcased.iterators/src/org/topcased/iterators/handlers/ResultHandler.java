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
package org.topcased.iterators.handlers;

import org.topcased.iterators.exceptions.CannotHandleException;
import org.topcased.iterators.exceptions.CollectionAbortedException;

/**
 * Defines objects that handle results from a Collector<>, with a function called immediately as
 * each value is gathered.
 */
public interface ResultHandler<T> {

	/**
	 * This method is called by collectors whenever a result is collected.
	 * 
	 * @param value
	 *        The collected result
	 * @throws CollectionAbortedException
	 *         The client code requests that the collection is aborted
	 * @throws CannotHandleException
	 */
	void handleResult(T value) throws CollectionAbortedException, CannotHandleException;
}
