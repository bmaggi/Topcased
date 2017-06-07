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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.core.build.IBuild;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;

/**
 * The Build class.
 * 
 * This class creates a build.properties for the plugin.
 * 
 */
public class Build
{

    private IProject fPlugin;

    /**
     * Cosntructor
     * 
     * @param pProject the project where the build.properties is needed.
     */
    public Build(IProject pProject)
    {
        fPlugin = pProject;
    }

    /**
     * Create the build.properties. It will add the bin as output and for bin.includes : - the templates folder - the
     * plugin.xml - the META-INF folder
     */
    public void createBuildFile()
    {
        IFile buildFile = fPlugin.getFile("build.properties"); //$NON-NLS-1$
        if (!buildFile.exists())
        {
            try
            {
                WorkspaceBuildModel model = new WorkspaceBuildModel(buildFile);

                IBuild build = model.getBuild(true);

                IBuildEntry entryOutput = model.getFactory().createEntry("output.."); //$NON-NLS-1$
                entryOutput.addToken("bin/");
                build.add(entryOutput);

                IBuildEntry entry = model.getFactory().createEntry("bin.includes"); //$NON-NLS-1$	
                entry.addToken("plugin.xml"); //$NON-NLS-1$
                entry.addToken("templates/");
                entry.addToken("META-INF/"); //$NON-NLS-1$
                entry.addToken("."); //$NON-NLS-1$

                build.add(entry);

                model.save();
            }
            catch (CoreException e)
            {
                e.printStackTrace();
            }
        }

    }

}
