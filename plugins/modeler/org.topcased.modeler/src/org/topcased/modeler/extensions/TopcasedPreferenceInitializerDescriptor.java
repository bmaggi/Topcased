/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thibault Landre (Atos Origin) <a href="mailto:thibault.landre@atosorigin.com">Thibault Landre</a> - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.topcased.modeler.preferences.ITopcasedPreferenceInitializer;

/**
 * Class that describes a Topcased Preference Initializer
 * 
 * @author <a href="mailto:thibault.landre@atosorigin.com">Thibault Landre</a>
 */
public class TopcasedPreferenceInitializerDescriptor
{
    public static final String TAG_PREFERENCEINITIALIZER = "preferenceInitializer";

    /** The id attribute */
    public static final String ATT_ID = "id";

    /** The editorID attribute */
    public static final String ATT_EDITOR_ID = "editorId";

    /** The class attribute */
    public static final String ATT_CLASS = "class";

    // Values
    private String id;

    private String editorId;

    private ITopcasedPreferenceInitializer topcasedPreferenceInitializer;

    private IConfigurationElement configElement;

    /**
     * Initialize the descriptor from the XML fragment of the extension
     * 
     * @param element The XML Fragment that describes the Diagram
     * @throws CoreException if the xml fragment is not valid
     */
    public TopcasedPreferenceInitializerDescriptor(IConfigurationElement element) throws CoreException
    {
        configElement = element;

        load();
    }

    private void load() throws CoreException
    {
        id = configElement.getAttribute(ATT_ID);

        editorId = configElement.getAttribute(ATT_EDITOR_ID);

        topcasedPreferenceInitializer = (ITopcasedPreferenceInitializer) configElement.createExecutableExtension(ATT_CLASS);

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
     * Get the editorId of the template (This identify the Topcased editor on which the template is applicable)
     * 
     * @return String
     */
    public String getEditorId()
    {
        return editorId;
    }

    /**
     * Get the TopcasedPreferenceInitializer associated with this descriptor
     * 
     * @return the TopcasedPreferenceInitializer associated with this descriptor
     */
    public ITopcasedPreferenceInitializer getTopcasedPreferenceInitializer()
    {
        return topcasedPreferenceInitializer;
    }
}
