/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.core.nature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.topcased.builder.TaskTagActivationAction;
import org.topcased.core.internal.CorePlugin;

/**
 * Manage the Topcased Nature for a project
 * 
 * Creation 8 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class TopcasedNature implements IProjectNature
{

    /** The Topcased Nature ID */
    public static final String TOPCASED_NATURE_ID = CorePlugin.PLUGIN_ID + ".topcasednature";

    private IProject project;

    /**
     * @see org.eclipse.core.resources.IProjectNature#configure()
     */
    public void configure() throws CoreException
    {
        // Add nature-specific information for the project, 
    	//   such as adding a builder to a project's build spec.
        new TaskTagActivationAction(project).addBuilderToProject();

    }

    /**
     * @see org.eclipse.core.resources.IProjectNature#deconfigure()
     */
    public void deconfigure() throws CoreException
    {
    	new TaskTagActivationAction(project).removeBuilderFromProject();
    }

    /**
     * @see org.eclipse.core.resources.IProjectNature#getProject()
     */
    public IProject getProject()
    {
        return project;
    }

    /**
     * @see org.eclipse.core.resources.IProjectNature#setProject(org.eclipse.core.resources.IProject)
     */
    public void setProject(IProject value)
    {
        project = value;
    }

}