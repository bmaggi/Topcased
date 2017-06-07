/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David SCIAMMA (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * /**
 * Class that describes a Resgistered model
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class RegisteredModelDescriptor
{

    // Constants

    public static final String TAG_MODEL = "model";

    public static final String ATT_NAME = "name";

    public static final String ATT_PATH = "path";

    public static final String ATT_CATEGORY = "category";

    public static final String ATT_METAMODEL = "metamodel";

    // Values
    private String name;

    private String path;

    private String metamodelURI;

    private String parentCategory;
    
    /**
     * Initialize the descriptor from the XML fragment of the extension
     * 
     * @param element The XML Fragment that describes the Diagram
     * @throws CoreException if the xml fragment is not valid
     */
    RegisteredModelDescriptor(IConfigurationElement element) throws CoreException
    {
        super();

        load(element);
    }

    private void load(IConfigurationElement configElement) throws CoreException
    {
        name = configElement.getAttribute(ATT_NAME);
        path = configElement.getAttribute(ATT_PATH);
        metamodelURI = configElement.getAttribute(ATT_METAMODEL);
        parentCategory = configElement.getAttribute(ATT_CATEGORY);

        // Sanity check.
        if (name == null || path == null)
        {
            throw new CoreException(new Status(IStatus.ERROR, configElement.getNamespace(), IStatus.OK,
                    "Invalid extension (missing name or model path) : " + path, null));
        }
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
     * Get the id of the parent category or <code>null</code> if there is no category
     * 
     * @return String
     */
    public String getParentCategory()
    {
        return parentCategory;
    }

    /**
     * Get the path of the registered model
     * 
     * @return String
     */
    public String getModelPath()
    {
        return path;
    }

    /**
     * Get the uri of the metamodel for which this model is valid
     * 
     * @return String
     */
    public String getMetamodelURI()
    {
        return metamodelURI;
    }
}
