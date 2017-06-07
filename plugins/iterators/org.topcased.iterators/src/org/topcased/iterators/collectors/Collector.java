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
package org.topcased.iterators.collectors;

import org.topcased.iterators.exceptions.CollectionAbortedException;
import org.topcased.iterators.handlers.ResultHandler;

/**
 * Defines a class that collects values of type T and submits each value to a ResultHandler<>
 * object immediately on collection.
 */
public interface Collector<T> {

	/**
	 * Perform the collection operation.
	 * 
	 * @param handler
	 *        The processor object to return results to.
	 * @throws CollectionAbortedException
	 *         The collection operation was aborted part way through.
	 */
	void collect(ResultHandler<T> handler) throws CollectionAbortedException;
}
