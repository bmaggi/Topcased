/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	  Thibault Landre (Atos Origin),
 *    Benjamin Marconato (Atos Origin) - Initial API and implementation
  *****************************************************************************/
package org.topcased.modeler.createtemplate.job;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.topcased.modeler.createtemplate.Activator;
import org.topcased.modeler.createtemplate.Build;
import org.topcased.modeler.createtemplate.Manifest;
import org.topcased.modeler.createtemplate.Plugin;
import org.topcased.modeler.createtemplate.Project;
import org.topcased.modeler.createtemplate.ProjectExporter;
import org.topcased.modeler.createtemplate.Utils;

/**
 * TODO
 * 
 * Creation : 25th mar. 2009
 * 
 */
public class TemplateModelCreationJob {

	private static final String PLUGIN_GENERIC_ID = "org.topcased.modeler.templates";
	
	private static final String GENERIC_NAME = "%name%";
	
	private static final Pattern MODELFILE = Pattern.compile("<model href="); 
	
	private static final Pattern SUBDIAGRAM_MODELFILE = Pattern.compile("<subdiagrams  model=");
	
	private String graphicalModelURI;
	
	private String modelURI;
	
	private Path fGraphicalModelName;

	private Path fModelName; 
	
	private String templateModelName;

	private String fPluginID;
	
	private boolean fIsInstallationRequired;
	
	
	
	
	/**
	 * Constructor
	 * @param modelUri model to export (URI)
	 * @param templateModelName name of the template model
	 * @param isInstallationRequired if the plugin must be deployed in the plugin
	 */
	public TemplateModelCreationJob(String modelUri, String templateModelName, boolean isInstallationRequired) {
		this.graphicalModelURI = modelUri;
		this.templateModelName = templateModelName;
		fIsInstallationRequired = isInstallationRequired;
	}

	/**
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus run(IProgressMonitor monitor) {
		try 
		{
			// Export the structure of the plugin
			IProject lProject = createPlugin();
			
			// Copy Graphical Model
			Utils.copyFile(new File(new URI(graphicalModelURI)), new File(getGraphicalModelLocation()));
			
			// Copy Model
			Utils.copyFile(new File(new URI(getModelURi())), new File(getModelLocation()));
			
			// Replace the occurence of the model name in the graphical model.
			Utils.fileReplaceCharSequence(getModelName().toString(), getNewModelName(), new File(getGraphicalModelLocation()));
			
			// Copy relatives file of the graphical model
			copyRelativesModels();
			
			// Update Manifest.MF
			updateManifest(lProject);
			
			// Update the plugin.xml
			updatePluginXML(lProject);
			
			// Update the build.properties
			updateBuildProperties(lProject);
			
			lProject.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
			
			// Export
			if(fIsInstallationRequired)
			{
				ProjectExporter projectExporter = new ProjectExporter(lProject);
				projectExporter.run();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The template model creation failed.", e);
		}
		return new Status(IStatus.OK, Activator.PLUGIN_ID, "The template model has been created successfully.");
	}
	


	
	private void updateBuildProperties(IProject project) 
	{
		Build build = new Build(project);
		build.createBuildFile();
	}

	/**
	 * Get the new model name to be set in the template graphical model file
	 * @return
	 */
	private String getNewModelName() 
	{
		StringBuffer lStringBuffer = new StringBuffer(10);
		lStringBuffer.append(GENERIC_NAME);
		lStringBuffer.append(".");
		lStringBuffer.append(getModelName().getFileExtension());
		return lStringBuffer.toString();
	}

	private Path getModelName() 
	{
		if(fModelName == null)
		{
			findModelName();
		}
		return fModelName;
	}
	
	private void findModelName()  
	{
		// Create a channel 
		try {
			FileChannel lFileChannel = new RandomAccessFile((new URI(graphicalModelURI).getPath()), "rw").getChannel();
			InputStream is = Channels.newInputStream(lFileChannel);
	        BufferedReader in = new BufferedReader(new InputStreamReader(is));
	        
	        String aLine = null;
	        while((aLine = in.readLine()) != null) 
	        {
	          	if(MODELFILE.matcher(aLine).find() || SUBDIAGRAM_MODELFILE.matcher(aLine).find())
	          	{
	          		int endIndex = aLine.indexOf("#");
	          		int beginIndex = aLine.indexOf("href=\"");
	          		String modelString = aLine.substring(beginIndex+6, endIndex);
	          		fModelName = new Path(modelString);
	          	}
	        }
	        
	        in.close();
	        is.close();
	        lFileChannel.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}		
		catch (IOException io)
		{
			io.printStackTrace();
		}
		catch (URISyntaxException use)
		{
			use.printStackTrace();
		}
	}

	
	
	private void copyRelativesModels() 
	{
		//TODO : recursively find all the dependencies of the model and their locations
		//TODO : move these dependencies to a specific folder, and update their relations
	}

	/**
	 * Get the template folder location where the models will be copied
	 * @return
	 */
	private String getTemplateFolderLocation()
	{
		StringBuffer lStringBuffer = new StringBuffer(80);
		lStringBuffer.append(getExportPluginLocation());
		lStringBuffer.append(File.separator);
		lStringBuffer.append("templates");
		lStringBuffer.append(File.separator);
		lStringBuffer.append(GENERIC_NAME);
		return lStringBuffer.toString();
	}
	/**
	 * Get the location of the diagram file in the created plugin. 
	 * @return
	 */
	private String getGraphicalModelLocation()
	{
		StringBuffer lStringBuffer = new StringBuffer(80);
		lStringBuffer.append(getTemplateFolderLocation());
		lStringBuffer.append(".");
		lStringBuffer.append(getGraphicalModelName().getFileExtension());	
		return lStringBuffer.toString();
	}
	
	/**
	 * Get the location of the model file in the created plugin
	 * @return
	 */
	private String getModelLocation()
	{
		StringBuffer lStringBuffer = new StringBuffer(80);
		lStringBuffer.append(getTemplateFolderLocation());
		lStringBuffer.append(".");
		lStringBuffer.append(getModelName().getFileExtension());
		return lStringBuffer.toString();
	}
	
	private IProject createPlugin()
    {
        IProject lProject = null;
        try
        {
            lProject = ResourcesPlugin.getWorkspace().getRoot().getProject(getPluginId());
            if (!lProject.exists())
            {
                lProject.create(new NullProgressMonitor());
                lProject.open(new NullProgressMonitor());

                // Update the nature
                Project.updateProject(lProject);

                // Create the folder template
                IFolder lFolder = lProject.getFolder("templates");
                if (!lFolder.exists())
                {
                    lFolder.create(true, true, null);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (CoreException e)
        {
            e.printStackTrace();
        }
        return lProject;

    }
	
	/**
	 * Get the location where the plugin will be created. 
	 * It will created in the .metadata of the current workspace, in the org.topcased.modeler.createtemplate folder (in .plugins folder).
	 * @return
	 */
	private String getExportPluginLocation()
	{
		StringBuffer lStringBuffer = new StringBuffer(60);
		lStringBuffer.append(ResourcesPlugin.getWorkspace().getRoot().getLocation());
		lStringBuffer.append(File.separator);
		lStringBuffer.append(getPluginId());
		lStringBuffer.append(File.separator);
		return lStringBuffer.toString();
	}
	

	/**
	 * Update the manifest.mf of the plugin with the correct ID.
	 * @see Manifest
	 * @throws IOException
	 */
	private void updateManifest(IProject lProject) throws IOException
	{
		Manifest lManifest = new Manifest(lProject,getExportPluginLocation(), templateModelName, getPluginId());
		lManifest.createManifest();
	}
	

	/**
	 * Update the plugin.xml of the plugin with the correct attributes.
	 * @see Plugin
	 * @throws IOException
	 */
	private void updatePluginXML(IProject lProject)  throws IOException
	{
		Plugin lPlugin = new Plugin(lProject ,templateModelName, getModelName(), getGraphicalModelName(), getExportPluginLocation());
		lPlugin.createTemplateExtension();
	}
	



	/**
	 * Get the pluginID. 
	 * The plugin ID will be used as a name for the plugin.
	 * @return the string
	 */
	private String getPluginId()
	{
		if(fPluginID == null)
		{
			createPluginId();
		}
		return fPluginID;
	}
	
	/**
	 * Create the plugin id. 
	 * The plugin id is a concatenation of the PLUGIN_GENERIC_ID, the editor extension and the name of the template.
	 */
	private void createPluginId()
	{
		StringBuffer stringBuffer = new StringBuffer(80);
		stringBuffer.append(PLUGIN_GENERIC_ID);
		stringBuffer.append(".");
		stringBuffer.append(getModelName().getFileExtension());
		stringBuffer.append(".");
		stringBuffer.append(templateModelName.toLowerCase());
		fPluginID = stringBuffer.toString();
	}
	
	/**
	 * Get the model name. 
	 * The model name is composed of the name of the model and its extension
	 * @return
	 */
	private Path getGraphicalModelName()
	{
		if(fGraphicalModelName == null)
		{
			fGraphicalModelName = new Path(new Path(graphicalModelURI).lastSegment());
		}
		return fGraphicalModelName;
	}
	
	private String getModelURi()
	{
		if(modelURI == null)
		{
			initializeModelURI();
		}
		return modelURI;
	}

	private void initializeModelURI() {
		Path lPath = new Path(graphicalModelURI);
		
		IPath locationPath = lPath.removeLastSegments(1);
		
		modelURI = locationPath.append(getModelName()).toString();
	}
	
	

}
