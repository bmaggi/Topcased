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
import org.topcased.iterators.pickers.IPicker;

/**
 * A harvester gathers and organizes pickers that collect the data needed
 * to compute an iterator.
 */
public interface IHarvester extends Collector<Object> {

	/**
	 * Recursive collection of items descending from the starting element.
	 */
	public void collect(ResultHandler<Object> handler) throws CollectionAbortedException;

	/**
	 * Gets the pickers that the harvester use to retrieve descendants of an element.
	 * 
	 * @return The list of pickers
	 */
	public Iterable<IPicker> getPickers();

	/**
	 * Gets the pickers that the harvester use to retrieve descendants of an element.
	 * 
	 * @param pickers
	 */
	public void setPickers(Iterable<IPicker> pickers);


	/**
	 * Getter for the starting element.
	 */
	public Object getStartingElement();

	/**
	 * Setter for the starting element.
	 */
	public void setStartingElement(Object startingElement);
}
