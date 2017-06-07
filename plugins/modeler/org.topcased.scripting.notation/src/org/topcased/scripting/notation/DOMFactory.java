/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos Origin) {vincent.hemery@atosorigin.com} - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.scripting.notation;

import org.eclipse.eclipsemonkey.dom.IMonkeyDOMFactory;
import org.topcased.scripting.BasicTopcasedDOM;

/**
 * The factory which provides the {@link NotationDOM} to Eclipse Monkey.
 */
public class DOMFactory implements IMonkeyDOMFactory
{
    private BasicTopcasedDOM domInstance = new NotationDOM();

    public Object getDOMroot()
    {
        return domInstance;
    }
}
