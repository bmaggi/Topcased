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
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.topcased.iterators.exceptions.CannotHandleException;
import org.topcased.iterators.exceptions.CollectionAbortedException;
import org.topcased.iterators.exceptions.PickerExecutionException;
import org.topcased.iterators.handlers.ResultHandler;
import org.topcased.iterators.pickers.IPicker;

import com.google.common.collect.Lists;

/**
 * A depth harvester that keeps a trace of the longest depth the element can be found at.
 */
public class DepthMeasuringHarvester extends DepthHarvester {

	protected Map<Object, Integer> longestPath = new HashMap<Object, Integer>();


	public DepthMeasuringHarvester() {
		super();
	}

	public DepthMeasuringHarvester(Object startingElement) {
		super(startingElement);
	}

	@Override
	public void collect(ResultHandler<Object> handler) throws CollectionAbortedException {
		getLongestPathMap().put(start, 0);
		collectDepthWise(handler, start, 0);
	}

	public Map<Object, Integer> getLongestPathMap() {
		return longestPath;
	}

	protected void collectDepthWise(ResultHandler<Object> handler, Object element, int depth) throws CollectionAbortedException {
		try {
			handler.handleResult(element); //send result to the handler.
			for(IPicker picker : this.getPickers()) {
				Iterable<?> nexts = picker.getNexts(element); //getting children.
				if(nexts != null) { //some elements do not have any child.
					for(Object next : nexts) {

						Integer nextOldDepth = getLongestPathMap().get(next);

						Integer nextCurrentDepth = Math.max(nextOldDepth != null ? nextOldDepth : -1, depth + 1);
						if(nextCurrentDepth != nextOldDepth) {
							getLongestPathMap().put(next, nextCurrentDepth);
						}
						this.collectDepthWise(handler, next, nextCurrentDepth); //recurse
					}
				}
			}
		} catch (CannotHandleException e) {
			// if the element cannot be handled, do nothing.
		} catch (PickerExecutionException e) {
			throw new CollectionAbortedException(e);
		}
	}

	/**
	 * Gets a list of the elements computed during the iteration process,
	 * from the deepest to the most shallow.
	 */
	public List<Object> getElementsFromDeepest() {
		Set<Object> keySet = longestPath.keySet();
		List<Object> result = Lists.newArrayList(keySet);
		Collections.sort(result, new Comparator<Object>() {

			public int compare(Object arg0, Object arg1) {
				Integer depth0 = getLongestPathMap().get(arg0);
				Integer depth1 = getLongestPathMap().get(arg1);
				if(depth0 > depth1) {
					return -1;
				} else if(depth0 == depth1) {
					return 0;
				} else {
					return 1;
				}
			}
		});

		return result;
	}

}
