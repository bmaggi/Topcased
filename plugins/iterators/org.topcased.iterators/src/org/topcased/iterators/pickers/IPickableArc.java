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

import java.util.List;


public interface IPickableArc extends IArc {

	public abstract IPicker getPicker();

	public abstract IArc getParentArc();

	public abstract boolean provokesCycling();

	public abstract List<Object> getCycle();
}
