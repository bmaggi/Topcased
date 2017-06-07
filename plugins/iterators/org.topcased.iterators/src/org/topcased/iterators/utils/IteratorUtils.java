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
package org.topcased.iterators.utils;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.topcased.iterators.collectors.DepthMeasuringHarvester;
import org.topcased.iterators.factories.IteratorFactory;
import org.topcased.iterators.pickers.IPicker;

/**
 * Utility class using the iterators API
 */
public class IteratorUtils {

	/**
	 * Method used to get to create a dependency list out of pickers. A DepthMeasuringHarvester
	 * is used to iterate other elements, and the depth is computed while the elements are iterated on.
	 * In the end, a list of dependencies is retrieved from the harvester.
	 * 
	 * if A.getNext() = [B,C,D] then B,C,D are deeper than A and A depends on B,C,D.
	 * 
	 * @return a list going from the deepest element, to the most shallow.
	 */
	public static List<?> getDependencyList(Object startingElement, IPicker picker) {
		Set<IPicker> pickerAsSingleton = Collections.singleton(picker);
		DepthMeasuringHarvester harvester = new DepthMeasuringHarvester();
		IteratorFactory factory = new IteratorFactory(pickerAsSingleton, harvester);
		Iterable<Object> iterable = factory.createIterable(startingElement);
		Iterator<Object> iterator = iterable.iterator();
		while(iterator.hasNext()) {
			//Do nothing, just going through the iterator
			iterator.next();
		}
		return harvester.getElementsFromDeepest();
	}


}
