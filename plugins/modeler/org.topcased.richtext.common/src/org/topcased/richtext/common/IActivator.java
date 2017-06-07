//------------------------------------------------------------------------------
// Copyright (c) 2005, 2008 IBM Corporation and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
// IBM Corporation - initial implementation
//------------------------------------------------------------------------------
package org.topcased.richtext.common;

import org.topcased.richtext.common.serviceability.Logger;

/**
 * @author Phong Nguyen Le
 * @since 1.5
 *
 */
public interface IActivator {
	String getId();
	Logger getLogger();
}
