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
package org.topcased.iterators.handlers;

import org.topcased.iterators.pickers.ExecutivePicker;

/**
 * Extension that can be added to a picker to perform an additional treatment,
 * such as displaying a console output, or building a data structure. The treatment
 * is performed every time the getNext() method is called.
 */
public interface PickingHandler {

	public void performTreatment(ExecutivePicker picker, Object element, Iterable<?> nexts);

}
