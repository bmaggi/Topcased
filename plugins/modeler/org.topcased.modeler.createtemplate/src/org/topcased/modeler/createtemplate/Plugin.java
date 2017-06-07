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
import org.eclipse.core.runtime.Path;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.internal.core.ICoreConstants;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundlePluginModel;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorRegistry;

/**
 * The class Plugin manages the creation of the extension for the template
 * 
 */
public class Plugin
{

    private static final String ID = "id";

    private static final String NAME = "name";

    private static final String MODEL = "model";

    private static final String DI = "di";

    private static final String EDITOR_ID = "editorId";

    private static final String DIAGRAM = "isDiagram";

    private static final String GENERIC_ID = "org.topcased.modeler.templates.generated";

    private String fEditorID;

    private Path fModelName;

    private Path fGraphicalModelName;

    private String fTemplateName;

    private String fPluginLocation;

    private IProject fPlugin;

    /**
     * The Default Constructor
     * 
     * @param pProject the project where the plugin.xml is created
     * @param pTemplateName the name of the template
     * @param pModelName a path of the model composed of the name of the model and its extension
     * @param pGraphicalModelName a path to the graphical model composed of the name of the model and its extension
     * @param pPluginLocation the location of the plugin
     */
    public Plugin(IProject pProject, String pTemplateName, Path pModelName, Path pGraphicalModelName, String pPluginLocation)
    {
        fPluginLocation = pPluginLocation;
        fGraphicalModelName = pGraphicalModelName;
        fModelName = pModelName;
        fTemplateName = pTemplateName;

        fPlugin = pProject;
    }

    /**
     * Get the editorID
     */
    private String getEditorId()
    {
        if (fEditorID == null)
        {
            retrieveEditorId();
        }
        return fEditorID;
    }

    /**
     * Retrieve the editorID from the extension of the model
     * 
     * @return the editorID
     */
    private void retrieveEditorId()
    {
        IEditorRegistry editorRegistry = Activator.getDefault().getWorkbench().getEditorRegistry();
        IEditorDescriptor descriptor = editorRegistry.getDefaultEditor(fGraphicalModelName.toString());

        if (descriptor != null)
        {
            fEditorID = descriptor.getId();
        }

    }

    private String getNewTemplateName()
    {
        return fTemplateName;
    }

    private String getNewTemplateId()
    {
        StringBuffer lStringBuffer = new StringBuffer(60);
        lStringBuffer.append(GENERIC_ID);
        lStringBuffer.append(".");
        lStringBuffer.append(fTemplateName);
        return lStringBuffer.toString();
    }

    private String getNewTemplateModel()
    {
        StringBuffer lStringBuffer = new StringBuffer(20);
        lStringBuffer.append("templates/%name%.");
        lStringBuffer.append(fModelName.getFileExtension());
        return lStringBuffer.toString();
    }

    private String getNewTemplateGraphicalModel()
    {
        StringBuffer lStringBuffer = new StringBuffer(20);
        lStringBuffer.append("templates/%name%.");
        lStringBuffer.append(fGraphicalModelName.getFileExtension());
        return lStringBuffer.toString();
    }

    private String getNewTemplateEditorId()
    {
        return getEditorId();
    }

    private String getPluginLocation()
    {
        StringBuffer lStringBuffer = new StringBuffer(80);
        lStringBuffer.append(fPluginLocation);
        lStringBuffer.append(ICoreConstants.PLUGIN_FILENAME_DESCRIPTOR);
        return lStringBuffer.toString();
    }

    /**
	 * Create the extension in the plugin.xml
	 */
    @SuppressWarnings("restriction")
    public void createTemplateExtension()
    {
        WorkspaceBundlePluginModel model = new WorkspaceBundlePluginModel(fPlugin.getFile(ICoreConstants.BUNDLE_FILENAME_DESCRIPTOR), fPlugin.getFile(ICoreConstants.PLUGIN_FILENAME_DESCRIPTOR));
        try
        {
            // see ViewTemplate.class org.eclipse.ui.pde.templates
            IPluginExtension extension = createExtension("org.topcased.modeler.templates", true, model);
            IPluginBase plugin = model.getPluginBase();
            IPluginModelFactory factory = model.getPluginFactory();

            IPluginElement viewElement = factory.createElement(extension);
            viewElement.setName("template"); //$NON-NLS-1$
            viewElement.setAttribute(ID, getNewTemplateId());
            viewElement.setAttribute(NAME, getNewTemplateName());
            viewElement.setAttribute(DI, getNewTemplateGraphicalModel());
            viewElement.setAttribute(MODEL, getNewTemplateModel());
            viewElement.setAttribute(EDITOR_ID, getNewTemplateEditorId());
            viewElement.setAttribute(DIAGRAM, Boolean.FALSE.toString());

            extension.add(viewElement);
            if (!extension.isInTheModel())
            {
                plugin.add(extension);
            }
            
            // Save the plugin.xml
            model.save();

        }
        catch (CoreException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * A utility method to create an extension object for the plug-in model from the provided extension point id.
     * 
     * @param pointId the identifier of the target extension point
     * @param reuse if true, new extension object will be created only if an extension with the same Id does not exist.
     * @return an existing extension (if exists and <samp>reuse </samp> is <samp>true </samp>), or a new extension
     *         object otherwise.
     */
    protected IPluginExtension createExtension(String pointId, boolean reuse, IPluginModelBase model) throws CoreException
    {
        if (reuse)
        {
            IPluginExtension[] extensions = model.getPluginBase().getExtensions();
            for (int i = 0; i < extensions.length; i++)
            {
                IPluginExtension extension = extensions[i];
                if (extension.getPoint().equalsIgnoreCase(pointId))
                {
                    return extension;
                }
            }
        }
        IPluginExtension extension = model.getFactory().createExtension();
        extension.setPoint(pointId);
        return extension;
    }
}
