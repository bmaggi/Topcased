/*******************************************************************************
 * Copyright (c) 2005, 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.internal.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.RGB;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;

/**
 * This class contributes to the
 * <code>org.eclipse.core.runtime.preferences</code> extension point.
 * 
 * Creation : 1 aout 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ModelerPreferenceInitializer extends AbstractPreferenceInitializer
{
    /**
     * Initializes a preference store with default preference values for the
     * Modeler plug-in.
     * 
     * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
     */
    public void initializeDefaultPreferences()
    {
        IEclipsePreferences store = new DefaultScope().getNode(ModelerPlugin.getId());

        store.putBoolean(ModelerPreferenceConstants.P_USE_ANTIALIAS, false);
        store.putBoolean(ModelerPreferenceConstants.P_USE_UUID, false);
        store.putBoolean(ModelerPreferenceConstants.P_CHECK_INTEGRITY, true);
        store.putBoolean(ModelerPreferenceConstants.P_INITIALIZE_DIAGRAM, false);
        store.putBoolean(ModelerPreferenceConstants.P_DOCUMENTATION_HTML_EDITOR, false);

        store.put(ModelerPreferenceConstants.P_PAGE_FORMATS, ModelerPreferenceConstants.DEFAULT_PAGE_FORMATS);
        store.put(ModelerPreferenceConstants.P_DEFAULT_PAGE_FORMAT, ModelerPreferenceConstants.DEFAULT_PAGE_FORMAT);
        store.put(ModelerPreferenceConstants.P_PAGE_MARGINS, ModelerPreferenceConstants.DEFAULT_PAGE_MARGINS);
        store.put(ModelerPreferenceConstants.P_DEFAULT_PAGE_MARGIN, ModelerPreferenceConstants.DEFAULT_PAGE_MARGIN);
        store.put(ModelerPreferenceConstants.P_DEFAULT_UNIT, ModelerPreferenceConstants.DEFAULT_UNIT);
        store.put(ModelerPreferenceConstants.P_ORIENTATION, ModelerPreferenceConstants.DEFAULT_ORIENTATION);
        store.putBoolean(ModelerPreferenceConstants.PREFERENCE_NOT_SYNC_DECOR,true);
        store.putBoolean(ModelerPreferenceConstants.PREFERENCE_DIFFERENT_COLORS_FOR_CONTROL, true);
        PreferenceConverter.setDefault(ModelerPlugin.getDefault().getPreferenceStore(),ModelerPreferenceConstants.PREFERENCE_COLOR_FOR_SAME_RESOURCE,new RGB(0,0,0));
        PreferenceConverter.setDefault(ModelerPlugin.getDefault().getPreferenceStore(),ModelerPreferenceConstants.PREFERENCE_COLOR_FOR_DIFFERENT_RESOURCE,new RGB(192,192,192));
        store.putBoolean(ModelerPreferenceConstants.PREFERENCE_ELEMENT_DIFFERENT_RESOURCE_READ_ONLY, false);
        store.putBoolean(ModelerPreferenceConstants.PREFERENCE_OUTLINE_SELECT_FILTERED_ELEMENTS, false);
        store.putInt(ModelerPreferenceConstants.PREFERENCE_OUTLINE_LIMIT_FOR_SELECTION, 500);
        store.putInt(ModelerPreferenceConstants.PREFERENCE_OUTLINE_LIMIT_FOR_HISTORIK, 10);
        store.putBoolean(ModelerPreferenceConstants.PREFERENCE_OUTLINE_DISPLAY_VIRTUAL_CONTAINERS, true);
        store.putBoolean(ModelerPreferenceConstants.PREFERENCE_DISPLAY_HIDDEN_EANNOTATION, false);
        store.putBoolean(ModelerPreferenceConstants.PREFERENCE_TODO_NOTE_BUILDER, true);
        
        // Store note default preference 
        store.put(ModelerPreferenceConstants.NOTE_DEFAULT_BACKGROUND_COLOR, "255, 255, 203");
        store.put(ModelerPreferenceConstants.NOTE_DEFAULT_FOREGROUND_COLOR, "220, 150, 0");
        store.put(ModelerPreferenceConstants.NOTE_DEFAULT_FONT, StringConverter.asFontData("Sans-regular-10").toString());
        store.put(ModelerPreferenceConstants.PREFERENCE_TEXT_FOR_TODO, "todo");
    }
}
