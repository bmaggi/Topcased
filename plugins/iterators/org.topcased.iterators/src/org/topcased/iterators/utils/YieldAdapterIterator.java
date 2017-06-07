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
package org.topcased.iterators.utils;

import java.util.Iterator;

/**
 * A version of a standard Iterator<> used by the yield adapter. The only addition is a dispose()
 * function to clear resources manually when required.
 */
public interface YieldAdapterIterator<T> extends Iterator<T> {

	/**
	 * Because the Yield Adapter starts a separate thread for duration of the collection, this can
	 * be left open if the calling code only reads part of the collection. If the iterator goes out
	 * of scope, when it is GCed its finalize() will close the collection thread. However garbage
	 * collection is sporadic and the VM will not trigger it simply because there is a lack of
	 * available threads. So, if a lot of partial reads are happening, it will be wise to manually
	 * close the iterator (which will clear the resources immediately).
	 */
	void dispose();
}
