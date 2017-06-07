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
package org.topcased.iterators.factories;

import org.topcased.iterators.collectors.ArcHarvester;
import org.topcased.iterators.collectors.DepthHarvester;
import org.topcased.iterators.collectors.IHarvester;
import org.topcased.iterators.collectors.WidthHarvester;
import org.topcased.iterators.pickers.IArc;
import org.topcased.iterators.pickers.IPicker;
import org.topcased.iterators.utils.YieldAdapterIterable;
import org.topcased.iterators.yieldadapters.RedundancyAwareThreadedYieldAdapter;
import org.topcased.iterators.yieldadapters.ThreadedYieldAdapter;
import org.topcased.iterators.yieldadapters.YieldAdapter;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * Creates a factory that creates iterators and iterables, depending on the
 * pickers that were chosen to instantiate this factory.
 */
public class IteratorFactory {

	protected Iterable<IPicker> pickers;

	protected IHarvester harvester;

	protected YieldAdapter<Object> yieldAdapter;



	/**
	 * Constructor.
	 * 
	 * @param pickers
	 */
	public IteratorFactory(Iterable<IPicker> pickers) {
		this(pickers, new DepthHarvester(null));
	}


	/**
	 * Constructor.
	 * 
	 * @param pickers
	 * @param harvester
	 */
	public IteratorFactory(Iterable<IPicker> pickers, IHarvester harvester) {
		this.pickers = pickers;
		//instantiating a default harvester.
		this.harvester = harvester;
		this.harvester.setPickers(pickers);
		//instantiating a default yield adapter;
		this.yieldAdapter = new ThreadedYieldAdapter<Object>();
	}

	/**
	 * Depending on the factory configuration, returning an iterable;
	 * 
	 * @param element
	 *        the starting element.
	 */
	public Iterable<Object> createIterable(Object element) {
		harvester.setStartingElement(element);
		return yieldAdapter.adapt(harvester);
	}

	/**
	 * 
	 */
	public void activateWidthWisdom() {
		//Changing the harvester so the iterator will go width-wise.
		this.harvester = new WidthHarvester(null);
		this.harvester.setPickers(pickers);
	}

	/**
	 * 
	 */
	public void activateDepthWisdom() {
		//Changing the harvester so the iterator will go width-wise.
		this.harvester = new DepthHarvester(null);
		this.harvester.setPickers(pickers);
	}

	public void activateRedundancyAwareness() {
		//Changing the adapter so that it avoids redundancy.
		this.yieldAdapter = new RedundancyAwareThreadedYieldAdapter<Object>();
	}

	public void deactivateRedundancyAwareness() {
		//Changing the adapter so that it avoids redundancy.
		this.yieldAdapter = new ThreadedYieldAdapter<Object>();
	}

	public Iterable<Object> createTransitionWiseIterable(Object startingElement) {
		ArcHarvester arcHarvester = new ArcHarvester(this.harvester, this.pickers);
		arcHarvester.setStartingElement(startingElement);
		YieldAdapterIterable<Object> arcIterable = yieldAdapter.adapt(arcHarvester);
		return Iterables.transform(arcIterable, new Function<Object, Object>() {

			public Object apply(Object from) {
				if(from instanceof IArc) {
					return ((IArc)from).getDestination();
				}
				return from;
			}
		});
	}



}
