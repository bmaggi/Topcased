/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thibault Landre (Atos Origin) thibault.landre@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.createtemplate;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.pde.internal.core.natures.PDE;

/**
 * The Class Project
 */
public class Project 
{

    /**
     * Default Constructor
     */
	public Project() 
	{
		super();
	}

	
	/**
	 * Update the .project of the plugin with the correct project name
	 * @throws IOException
	 */
	public static void updateProject(IProject lProject) throws IOException, CoreException
	{
		addProjectNature(lProject, JavaCore.NATURE_ID);
		addProjectNature(lProject, PDE.PLUGIN_NATURE);	
	}
	
	 /**
     * Add the nature to an IProject
     * @param project the IProject to add the nature
     * @return true if the nature has been successfully added
     */
    private static boolean addProjectNature(final IProject project, final String newNature) {
        try {
            final IProjectDescription description = project.getDescription();
            final String[] natures = description.getNatureIds();

            // Add the nature
            final String[] newNatures = new String[natures.length + 1];
            System.arraycopy(natures, 0, newNatures, 1, natures.length);
            newNatures[0] = newNature;
            description.setNatureIds(newNatures);
            project.setDescription(description, null);

            return true;

        } catch (final CoreException e) {
            e.printStackTrace();
        }
        return false;
    }

}
