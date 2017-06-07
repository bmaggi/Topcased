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

import java.util.LinkedHashSet;

import org.polarsys.reqcycle.utils.iterators.pickers.IPicker;

/**
 * A set of picker, with the notion of subsets.
 */
@SuppressWarnings("serial")
public class PickerSet extends LinkedHashSet<IPicker> {

	public void addSubSet(PickerSet pickerSet) {
		this.addAll(pickerSet);
	}

}
