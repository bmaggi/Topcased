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
package org.topcased.iterators.yieldadapters;

import org.topcased.iterators.collectors.Collector;
import org.topcased.iterators.utils.YieldAdapterIterable;

/**
 * A class to convert methods that implement the Collector<> class into a standard Iterable<>.
 */
public interface YieldAdapter<T> {

	YieldAdapterIterable<T> adapt(Collector<T> client);
}
