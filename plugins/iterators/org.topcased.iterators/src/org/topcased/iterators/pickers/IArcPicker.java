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

/**
 * An arc picker is a decorator for IPicker, that allows the transition-based representation
 * of a graph to be iterated on. Every time the getNext() method is called, it will create
 * "arcs", linking the input elements and its children. Therefore, the getNexts() method
 * will return these arcs.
 * 
 * @author omelois
 * 
 */
public interface IArcPicker extends IPicker {

	public IPicker getBasePicker();

}
