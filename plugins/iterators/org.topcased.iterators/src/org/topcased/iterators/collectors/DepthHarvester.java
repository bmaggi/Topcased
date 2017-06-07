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

import org.topcased.iterators.Activator;
import org.topcased.iterators.exceptions.CannotHandleException;
import org.topcased.iterators.exceptions.CollectionAbortedException;
import org.topcased.iterators.handlers.ResultHandler;
import org.topcased.iterators.pickers.IPicker;

public class DepthHarvester extends Harvester {


	public DepthHarvester() {
		super();
	}

	public DepthHarvester(Object startingElement) {
		super(startingElement);
	}

	/**
	 * By default, the collection is performed depth wise.
	 */
	public void collect(ResultHandler<Object> handler) throws CollectionAbortedException {
		this.collectDepthWise(handler, start);
	}

	/**
	 * Depth wise collection.
	 * 
	 * @param handler
	 *        the handler that processes each element.
	 * @param element
	 *        : the element from which the collection is performed.
	 * @throws CollectionAbortedException
	 */
	protected void collectDepthWise(ResultHandler<Object> handler, Object element) throws CollectionAbortedException {
		try {
			handler.handleResult(element); //send result to the handler.
			for(IPicker picker : this.getPickers()) {
				Iterable<?> nexts = picker.getNexts(element); //getting children.
				if(nexts != null) { //some elements do not have any child.
					for(Object next : nexts) {
						this.collectDepthWise(handler, next); //recurse
					}
				}
			}
		} catch (CannotHandleException e) {
			// if the element cannot be handled, do nothing.
		} catch (Exception e) {
			Activator.logError(e);
		}
	}

}
