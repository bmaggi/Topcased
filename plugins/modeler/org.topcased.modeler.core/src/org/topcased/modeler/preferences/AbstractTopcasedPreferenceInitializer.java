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
package org.topcased.modeler.preferences;

import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.topcased.modeler.extensions.TopcasedPreferenceInitializerDescriptor;
import org.topcased.modeler.extensions.TopcasedPreferenceInitializerManager;

/**
 * This class is used to initialize all the diagram preferences of a Topcased editor
 * 
 * Clients must implement <code>getPreferences()</code>, <code>getEditorId()</code>
 * 
 * @author <a href="mailto:thibault.landre@atosorigin.com">Thibault Landre</a>
 */
public abstract class AbstractTopcasedPreferenceInitializer extends AbstractPreferenceInitializer
{

    /**
     * Get the Preferences of the editor plugin.
     * 
     * @return the preferences of the plugin
     */
    protected abstract Preferences getPreferences();

    /**
     * Get the editor Id.
     * 
     * @return the editor id
     */
    protected abstract String getEditorId();

    /**
     * Initialize all the default preferences of the different diagrams of the editor in the editor's plugin preference
     * store. This method retrieves all the TopcasedPreferenceInitializerDescriptor declared for the editor. It
     * initializes the editor plugin preference store with the preferences given in the
     * TopcasedPreferenceInitializerDescriptor.
     * 
     * This method should not be overridden by subclasses. If it is overridden, the instruction
     * super.initializeDefaultPreferences() should be used.
     * 
     * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
     */
    @Override
    public void initializeDefaultPreferences()
    {
        TopcasedPreferenceInitializerDescriptor[] topcasedPreferenceInitializer = TopcasedPreferenceInitializerManager.getInstance().getTopcasedPreferenceInitializer(getEditorId());
        for (TopcasedPreferenceInitializerDescriptor descriptor : topcasedPreferenceInitializer)
        {
            HashMap<String, String> defaultDiagramPreference = descriptor.getTopcasedPreferenceInitializer().getDefaultPreference();
            for (Entry<String, String> entry : defaultDiagramPreference.entrySet())
            {
                if (Boolean.TRUE.toString().equals(entry.getValue()) || Boolean.FALSE.toString().equals(entry.getValue()))
                {
                    getPreferences().setDefault(entry.getKey(), Boolean.valueOf(entry.getValue()).booleanValue());
                }
                else
                {
                    getPreferences().setDefault(entry.getKey(), entry.getValue());
                }
            }

        }

    }

}
