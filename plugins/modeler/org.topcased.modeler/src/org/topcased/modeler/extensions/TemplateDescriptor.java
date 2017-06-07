/*******************************************************************************
 * Copyright (c) 2005,2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jacques LESCOT (Anyware Technologies)
 *    - initial API and implementation
 *    Thibault Landré - Fix #889
 *******************************************************************************/
package org.topcased.modeler.extensions;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

/**
 * Class that describes a Template
 * 
 * @author <a href="mailto:jacqueslescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class TemplateDescriptor
{

    // Constants

    public static final String TAG_TEMPLATE = "template";

    public static final String ATT_ID = "id";

    public static final String ATT_NAME = "name";

    public static final String ATT_EDITOR_ID = "editorId";

    public static final String ATT_MODEL = "model";

    public static final String ATT_DI = "di";
    
    // Fix #889
    public static final String ATT_IS_DIAGRAM = "isDiagram";

    // Values
    private String id;

    private String name;

    private String editorId;

    private String model;

    private String di;
    
    // Fix #889
    private String isDiagram;

    private IConfigurationElement configElement;

    /**
     * Initialize the descriptor from the XML fragment of the extension
     * 
     * @param element The XML Fragment that describes the Template
     * @throws CoreException if the xml fragment is not valid
     */
    TemplateDescriptor(IConfigurationElement element) throws CoreException
    {
        super();
        configElement = element;

        load();
    }

    /**
     * Return the IConfigurationElement associated with the TemplateDescriptor
     * @return
     */
    public IConfigurationElement getConfigurationElement()
    {
        return configElement;
    }
    
    private void load() throws CoreException
    {
        id = configElement.getAttribute(ATT_ID);
        name = configElement.getAttribute(ATT_NAME);
        editorId = configElement.getAttribute(ATT_EDITOR_ID);
        model = configElement.getAttribute(ATT_MODEL);
        di = configElement.getAttribute(ATT_DI);
        isDiagram = configElement.getAttribute(ATT_IS_DIAGRAM);

        // Sanity check.
        if (id == null || name == null || editorId == null || model == null || di == null)
        {
            throw new CoreException(new Status(IStatus.ERROR, configElement.getNamespace(), IStatus.OK,
                    "Invalid extension (missing id, name, editorId, model or di attribute): " + id, null));
        }
    }

    /**
     * Get the id of the diagram
     * 
     * @return String
     */
    public String getId()
    {
        return id;
    }

    /**
     * Get the name of the diagram (This will be the text displayed in the
     * contextual menu)
     * 
     * @return String
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get the editorId of the template (This identify the Topcased editor on
     * which the template is applicable)
     * 
     * @return String
     */
    public String getEditorId()
    {
        return editorId;
    }

    /**
     * Get the relativePath to the template of the model file
     * 
     * @return String
     */
    public String getModel()
    {
        return model;
    }

    /**
     * Get the relativePath to the template of the di file
     * 
     * @return String
     */
    public String getDI()
    {
        return di;
    }

    /**
     * Returns the Template object associated with a template id
     * 
     * @return the Template object associated
     */
    public Template getTemplateModel()
    {
        return new Template(getFile(model));
    }

    /**
     * Returns the Template object associated with a template id
     * 
     * @return the Template object associated
     */
    public Template getTemplateDI()
    {
        return new Template(getFile(di));
    }

    /**
     * Returns the file of the given relativePath
     * 
     * @param relativePath the relativePath of the template which represent the
     *            file to get
     * @return the file
     */
    private File getFile(String relativePath)
    {
        try
        {
            Bundle extensionBundle = Platform.getBundle(configElement.getDeclaringExtension().getNamespace());
            URL templateFileURL = extensionBundle.getEntry(relativePath);
            return new File(Platform.asLocalURL(templateFileURL).getFile());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Get the value of the IsDiagram attribute
     * @return the value as a String
     */
    // Fix #889
    public String getIsDiagram()
    {
        return isDiagram;
    }
    
    /**
     * Transform the value of the IsDiagram attribute into a boolean
     * @return true if it is a diagram, false otherwise.
     */
    // Fix #889
    public boolean isIsDiagram()
    {
        if("false".equals(isDiagram))
        {
            return false;
        }
        return true;
    }
}
