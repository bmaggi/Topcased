/*******************************************************************************
 * Copyright (c) 2009-2010 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *    Jean-Patrice Giacometti (Airbus) - port to DI
 *******************************************************************************/
package org.topcased.scripting.di;

import org.eclipse.eclipsemonkey.dom.IMonkeyDOMFactory;
import org.topcased.scripting.BasicTopcasedDOM;

/**
 * The factory which provides the {@link DiDOM} to Eclipse Monkey.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public class DOMFactory implements IMonkeyDOMFactory
{
    private BasicTopcasedDOM domInstance = new DiDOM();

    public Object getDOMroot()
    {
        return domInstance;
    }
}
