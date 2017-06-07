/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thibault Landre (Atos Origin) <a href="mailto:thibault.landre@atosorigin.com">Thibault Landre</a> - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.preferences;

import java.util.HashMap;

/**
 * An interface used to create a preference initializer for a Topcased diagram
 * 
 * @author <a href="mailto:thibault.landre@atosorigin.com">Thibault Landre</a>
 */
public interface ITopcasedPreferenceInitializer
{
    /**
     * This method is used to collect the default preferences of all the elements of a diagram.
     * 
     * The key is used to store the constant which identify the preference. The value is used to store the value of the
     * given preference. Note that boolean value has to be converted in string "true" or "false".
     * 
     * @return a map with the default preferences of all the elements contained in the diagram
     */
    HashMap<String, String> getDefaultPreference();
}
