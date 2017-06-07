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
package org.topcased.iterators.configurations.pickers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.polarsys.reqcycle.utils.iterators.exceptions.PickerExecutionException;
import org.polarsys.reqcycle.utils.iterators.pickers.IPicker;
import org.topcased.iterators.configurations.pickers.annotations.IJavaQuery;

/**
 * This class allows to wrap an {@link IPicker} inside a object providing
 * additional fields and methods, such as the name and description
 * of the picker.
 * The wrapped object
 * can be adapted to the enclosed type (e.g. {@link IJavaQuery}).
 * 
 * @author mgrihang
 * 
 */
public class PickerWithDescription implements IPicker, IAdaptable {

	private IPicker corePicker;

	private String name;

	private String description;

	public PickerWithDescription(IPicker iPicker) {
		corePicker = iPicker;
	}

	public Iterable<?> getNexts(Object element) throws PickerExecutionException {
		return corePicker.getNexts(element);
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class key) {

		Object receiver = null;

		if(key.isInstance(corePicker)) {
			receiver = corePicker;
		} else if(corePicker instanceof IAdaptable) {
			IAdaptable a = (IAdaptable)corePicker;
			receiver = a.getAdapter(key);
			if(receiver == null) {
				receiver = Platform.getAdapterManager().getAdapter(corePicker, key);
			}
		}

		return receiver;
	}

	public PickerWithDescription copy() throws InstantiationException, IllegalAccessException {
		PickerWithDescription clone = new PickerWithDescription(corePicker.getClass().newInstance());
		clone.name = this.name;
		clone.description = this.description;
		return clone;
	}

	public IPicker getCorePicker() {
		return corePicker;
	}

}
