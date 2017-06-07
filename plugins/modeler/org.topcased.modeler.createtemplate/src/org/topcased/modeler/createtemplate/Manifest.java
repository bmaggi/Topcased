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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.core.plugin.IPlugin;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.internal.core.ICoreConstants;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundlePluginModel;

/**
 * The class that creates the manifest.mf
 *
 */
public class Manifest
{

    private final String fTemplateName;

    private final String fPluginID;

    private final String fPluginLocation;

    private IProject fPlugin;

    /**
     * Constructor
     * 
     * @param pManifestFile the manifest to update
     * @param pTemplateName the name of the template
     * @param pPluginId the id of the plugin
     * @param pProject the project where the file is created
     */
    public Manifest(IProject pProject, String pPluginLocation, String pTemplateName, String pPluginId)
    {
        super();
        fPluginLocation = pPluginLocation;
        fTemplateName = pTemplateName;
        fPluginID = pPluginId;
        fPlugin = pProject;
    }

    /**
     * Create the bundle symbolic name of the plugin with the pluginID.
     * 
     * @return a string
     */
    private String getNewBundleSymbolicName()
    {
        StringBuffer lStringBuffer = new StringBuffer(50);
        lStringBuffer.append(fPluginID);
        return lStringBuffer.toString();
    }

    /**
     * Create the bundle name of the plugin. The name will be composed of the template name and the suffix 'Plug-in'
     * 
     * @return a string
     */
    private String getNewBundleName()
    {
        StringBuffer lStringBuffer = new StringBuffer(50);
        lStringBuffer.append(fTemplateName);
        lStringBuffer.append(" Plug-in");
        return lStringBuffer.toString();
    }

    /**
     * Get the location of the newly manifest file.
     * 
     * @return
     */
    private String getManifestFileLocation()
    {
        StringBuffer lStringBuffer = new StringBuffer(80);
        lStringBuffer.append(fPluginLocation);
        lStringBuffer.append(ICoreConstants.BUNDLE_FILENAME_DESCRIPTOR);
        return lStringBuffer.toString();
    }

    /**
     * Create the manifest
     */
    public void createManifest()
    {
        WorkspaceBundlePluginModel model = new WorkspaceBundlePluginModel(fPlugin.getFile(ICoreConstants.BUNDLE_FILENAME_DESCRIPTOR), fPlugin.getFile(ICoreConstants.PLUGIN_FILENAME_DESCRIPTOR));
        try
        {
            // see ViewTemplate.class org.eclipse.ui.pde.templates
            IPlugin plugin = model.getPlugin();
            IPluginModelFactory factory = model.getPluginFactory();

            plugin.setId(getNewBundleSymbolicName());
            plugin.setName(getNewBundleName());
            plugin.setSchemaVersion("1");
            plugin.setVersion("1.0.0");

            // Add org.topcased.modeler dependencies
            IPluginImport pluginImport = model.getPluginFactory().createImport();
            pluginImport.setId("org.topcased.modeler");
            plugin.add(pluginImport);
            
            // Save the manifest.mf
            model.save();

        }
        catch (CoreException e)
        {
            e.printStackTrace();
        }

    }
}
