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
package org.topcased.modeler.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.extensions.DiagramsManager;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.editor.NoDiagramConfiguration;

/**
 * Manages the different diagram configurations. <br>
 * Associates a diagram id with its diagram configuration. <br>
 * 
 * Creation : 9 févr. 2006
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ModelerConfigurationManager
{
    private IConfiguration activeConf;

    /**
     * The constructor
     */
    public ModelerConfigurationManager()
    {
        super();
    }

    /**
     * Set the new active diagram : <b>this method must change the active
     * configuration. </b>
     * 
     * @param activeDiagram
     */
    public void setActiveDiagram(Diagram activeDiagram)
    {
        if (activeDiagram != null)
        {
            if (activeConf == null || !activeConf.getId().equals(activeDiagram.getSemanticModel().getPresentation()))
            {
                // changes the active configuration
                try
                {
                    if (activeDiagram.getSemanticModel() != null)
                    {
                        activeConf = DiagramsManager.getInstance().getConfiguration(
                                activeDiagram.getSemanticModel().getPresentation());
                    }
                    else
                    {
                        activeConf = new NoDiagramConfiguration();
                        ModelerPlugin.log("your diagram seems corrupted : " + activeDiagram.getName() + ", root diagram is opened instead of", IStatus.WARNING);
                    }
                }
                catch (CoreException ce)
                {
                    ModelerPlugin.log(ce);
                }
            }
        }
        else
        {
            // Use a special Configuration when no Diagram is active
            activeConf = new NoDiagramConfiguration();
        }
    }

    /**
     * Returns the active Diagram configuration.
     * 
     * @return the configuration
     */
    public IConfiguration getActiveConfiguration()
    {
        return activeConf;
    }
}
