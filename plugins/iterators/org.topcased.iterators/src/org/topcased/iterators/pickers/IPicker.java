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


/**
 * A picker defines a way to collect children from an element.
 * The type of children and the type of parent are not taken into consideration
 * by the interface, meaning that the implementation should make sure that the
 * types are consistent.
 */
public interface IPicker {

	/**
	 * @param element
	 *        the element from which the children are to be retrieved
	 * @return
	 *         the children of the elements
	 * @throws Exception
	 */
	public Iterable<?> getNexts(Object element) throws PickerExecutionException;

}
