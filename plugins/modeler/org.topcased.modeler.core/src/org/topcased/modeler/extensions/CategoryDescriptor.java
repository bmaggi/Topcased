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
 * Class that describes a Category extension
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class CategoryDescriptor
{

    // Constants

    public static final String TAG_CATEGORY = "category";

    public static final String ATT_ID = "id";

    public static final String ATT_NAME = "name";

    public static final String ATT_CATEGORY = "category";

    // Values
    private String id;

    private String name;

    private String parentCategory;
    
    /**
     * Initialize the descriptor from the XML fragment of the extension
     * 
     * @param element The XML Fragment that describes the Diagram
     * @throws CoreException if the xml fragment is not valid
     */
    CategoryDescriptor(IConfigurationElement element) throws CoreException
    {
        super();

        load(element);
    }

    private void load(IConfigurationElement configElement) throws CoreException
    {
        id = configElement.getAttribute(ATT_ID);
        name = configElement.getAttribute(ATT_NAME);
        parentCategory = configElement.getAttribute(ATT_CATEGORY);

        // Sanity check.
        if (id == null || name == null)
        {
            throw new CoreException(new Status(IStatus.ERROR, configElement.getNamespace(), IStatus.OK,
                    "Invalid extension (missing id or name): " + id, null));
        }
    }

    /**
     * Get the id of the category
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
     * Get the id if the parent category
     * 
     * @return String
     */
    public String getParentCategory()
    {
        return parentCategory;
    }
}
