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

import java.util.List;

import org.topcased.iterators.exceptions.CollectionAbortedException;
import org.topcased.iterators.handlers.ResultHandler;
import org.topcased.iterators.pickers.ArcPicker;
import org.topcased.iterators.pickers.IArc;
import org.topcased.iterators.pickers.IPicker;

import com.google.common.collect.Lists;

/**
 * Decorator for the harvester class to transform its nature
 * from a state-aware harvester to a transition-aware harvester,
 * meaning that it collects links (arcs) instead of elements (states).
 * 
 */
public class ArcHarvester implements IHarvester {

	private IHarvester basicHarvester;

	private Object startingElement;

	private Iterable<IPicker> pickers;

	public ArcHarvester(IHarvester basicHarvester, Iterable<IPicker> basicPickers) {
		this.basicHarvester = basicHarvester;
		this.pickers = basicPickers;

		//Transforming the original pickers into arc pickers.
		List<IPicker> arcPickers = Lists.newLinkedList();
		for(IPicker basicPicker : basicPickers) {
			ArcPicker arcPicker = new ArcPicker(basicPicker);
			arcPickers.add(arcPicker);
		}
		this.basicHarvester.setPickers(arcPickers);
	}

	public void collect(ResultHandler<Object> handler) throws CollectionAbortedException {
		basicHarvester.collect(handler);
	}

	public Object getStartingElement() {
		return startingElement;
	}

	public void setStartingElement(Object startingElement) {
		this.startingElement = startingElement;
		StartingArc startingArc = new StartingArc(startingElement);
		this.basicHarvester.setStartingElement(startingArc);
	}

	public Iterable<IPicker> getPickers() {
		return this.pickers;
	}

	public void setPickers(Iterable<IPicker> basicPickers) {
		this.pickers = basicPickers;

		//Transforming the original pickers into arc pickers.
		List<IPicker> arcPickers = Lists.newLinkedList();
		for(IPicker basicPicker : basicPickers) {
			ArcPicker arcPicker = new ArcPicker(basicPicker);
			arcPickers.add(arcPicker);
		}
		this.basicHarvester.setPickers(arcPickers);
	}

	/**
	 * Entrance of a transition-based iterator. Does not have an origin.
	 */
	public class StartingArc implements IArc {

		Object startingElement;

		public StartingArc(Object startingElement) {
			this.startingElement = startingElement;
		}

		public Object getOrigin() {
			return null;
		}

		/**
		 * The starting destination of this arc is the first element
		 * of the state-based iterator.
		 */
		public Object getDestination() {
			return startingElement;
		}
	}




}
