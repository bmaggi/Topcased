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
package org.topcased.iterators.configurations.pickers.internal;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.polarsys.reqcycle.utils.iterators.exceptions.PickerExecutionException;
import org.polarsys.reqcycle.utils.iterators.pickers.IPicker;

import com.google.common.collect.Iterables;

/**
 * Class used to compose IPickers.
 * 
 * A ComposedPicker is in no mean a PickerSet. A Picker can represent a transition kind
 * in a graph. Therefore, a Composed Picker represents ONE transition kind. It will
 * be treated as such if the user wants to iterate on a transition-based graph. Its
 * subPickers will not be treated independently.
 */
public class ComposedPicker implements IPicker, IAdaptable {

	private Set<IPicker> subPickers;

	public Set<IPicker> getSubPickers() {
		return subPickers;
	}

	public ComposedPicker() {
		/*
		 * A picker can be used only once in a composed picker.
		 * However, the pickers are must be ordered.
		 */
		subPickers = new LinkedHashSet<IPicker>();
	}

	public Iterable<?> getNexts(Object element) throws PickerExecutionException {
		Iterable<?> currentIterable = Collections.EMPTY_LIST;
		for(IPicker subPicker : subPickers) {
			Iterable<?> currentNexts = subPicker.getNexts(element);
			currentIterable = Iterables.concat(currentIterable, currentNexts);
		}
		return currentIterable;
	}


	/**
	 * Adds a picker to the composition.
	 */
	public void compose(IPicker picker) {
		//It is preferable not to have a "tree" of composed pickers.
		if(picker instanceof ComposedPicker) {
			Set<IPicker> subPickers2 = ((ComposedPicker)picker).getSubPickers();
			this.subPickers.addAll(subPickers2);
		} else
			this.subPickers.add(picker);
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		for(IPicker p : subPickers) {
			if(p instanceof ComposedPicker) {
				return ((ComposedPicker)p).getAdapter(adapter); // return ?
			} else if(adapter.isInstance(p)) {
				return p;
			}
		}
		return null;
	}

}
