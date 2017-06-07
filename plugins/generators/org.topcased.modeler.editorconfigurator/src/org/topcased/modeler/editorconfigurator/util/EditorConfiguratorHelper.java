/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.editorconfigurator.util;

import java.util.HashSet;
import java.util.Set;

import org.topcased.modeler.editorconfigurator.EditorConfiguration;

/**
 * This class offers some helper methods to simplify the generation templates. <br>
 * creation : 17 d�c. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class EditorConfiguratorHelper
{
    /**
     * Returns the list of required plugins for the given editor configuration.
     * 
     * @param conf the editor configuration
     * @return the Set of required plugin Ids
     */
    public static Set getRequiredPlugins(EditorConfiguration conf)
    {
        Set requiredPlugins = new HashSet();
        String modelPluginId = conf.getGenModel().getModelPluginID();
        if (modelPluginId != null)
        {
            requiredPlugins.add(modelPluginId);
        }
        requiredPlugins.addAll(conf.getGenModel().getModelRequiredPlugins());
        requiredPlugins.addAll(conf.getGenModel().getEditRequiredPlugins());
        requiredPlugins.addAll(conf.getGenModel().getEditorRequiredPlugins());

        return requiredPlugins;
    }
}
