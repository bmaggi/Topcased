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

import org.topcased.iterators.pickers.IPicker;


/**
 * Basic abstract realization of a IHarvester,
 * that adds the concept of starting element.
 */
public abstract class Harvester implements IHarvester {

	/**
	 * The element from which the collector should start collecting elements.
	 */
	protected Object start;

	/**
	 * Pickers, referenced in an attribute.
	 */
	protected Iterable<IPicker> pickers;

	public Harvester() {
		//Empty constructor
	}

	public Harvester(Object startingElement) {
		start = startingElement;
	}

	public Object getStartingElement() {
		return this.start;
	}

	public void setStartingElement(Object startingElement) {
		this.start = startingElement;
	}

	public Iterable<IPicker> getPickers() {
		return pickers;
	}

	public void setPickers(Iterable<IPicker> pickers) {
		this.pickers = pickers;
	}

}
