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
package org.topcased.iterators.pickers;

import org.topcased.iterators.exceptions.PickerExecutionException;
import org.topcased.iterators.handlers.PickingHandler;

/**
 * Picker that will perform an additional treatment after each getNext() method,
 * depending on the handlers that it is provided with.
 * 
 */
public abstract class ExecutivePicker implements IPicker {

	/**
	 * An executive picker is a decorator for a picker.
	 */
	protected IPicker basicPicker;

	public ExecutivePicker(IPicker picker) {
		basicPicker = picker;
	}

	/**
	 * Simple addition of a treatment right after the retrieval of
	 * the element's children.
	 * 
	 * @throws Exception
	 */
	public Iterable<?> getNexts(Object element) throws PickerExecutionException {
		Iterable<?> nexts = basicPicker.getNexts(element);
		Iterable<PickingHandler> handlers = this.retrieveHandlers();
		if(handlers != null) {
			for(PickingHandler handler : handlers) {
				handler.performTreatment(this, element, nexts);
			}
		}
		return nexts;
	}

	/**
	 * Method to retrieve the handlers that will actively perform the additional
	 * treatment(s) the ExecutivePicker has to perform. It has to be implemented,
	 * depending on which handlers are to be added to the picker.
	 */
	protected abstract Iterable<PickingHandler> retrieveHandlers();

}
