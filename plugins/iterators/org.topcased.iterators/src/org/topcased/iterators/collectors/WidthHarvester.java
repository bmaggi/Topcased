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

import java.util.Collections;

import org.topcased.iterators.Activator;
import org.topcased.iterators.exceptions.CannotHandleException;
import org.topcased.iterators.exceptions.CollectionAbortedException;
import org.topcased.iterators.handlers.ResultHandler;
import org.topcased.iterators.pickers.IPicker;

import com.google.common.collect.Iterables;

public class WidthHarvester extends Harvester {


	public WidthHarvester(Object startingElement) {
		super(startingElement);
	}


	public void collect(ResultHandler<Object> handler) throws CollectionAbortedException {
		collectWidthWise(handler, start);
	}

	/**
	 * Width wise collection.
	 * 
	 * @param handler
	 *        the handler that processes each element.
	 * @param element
	 *        : the element from which the collection is performed.
	 * @throws CollectionAbortedException
	 */
	protected void collectWidthWise(ResultHandler<Object> handler, Object element) throws CollectionAbortedException {
		Iterable<?> currentLayer = Collections.singletonList(element);
		Iterable<?> nextLayer = Collections.EMPTY_LIST;
		while(currentLayer != null && !Iterables.isEmpty(currentLayer)) {
			for(Object currentElement : currentLayer) {
				try {
					handler.handleResult(currentElement);
					//Building the next layer.
					for(IPicker picker : this.getPickers()) {
						Iterable<?> nexts = picker.getNexts(currentElement); //getting children.
						if(nexts != null) {
							nextLayer = Iterables.concat(nextLayer, nexts);
						}
					}
				} catch (CannotHandleException e) {
					//do nothing
				} catch (Exception e) {
					Activator.logError(e);
				}
			}
			//The current layer has been processed. Going through the next one.
			currentLayer = nextLayer;
			nextLayer = Collections.EMPTY_LIST;
		}
	}

}
