/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  tlandre (Atos Origin) thibault.landre@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.internal.preferences;

import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.AbstractNodePreferencePage;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;

/**
 * The Note preference page
 */
public class NotePreferencePage extends AbstractNodePreferencePage
{

    @Override
    protected String getNodeFont()
    {
        return ModelerPreferenceConstants.NOTE_DEFAULT_FONT;
    }

    @Override
    protected String getNodeForegroundColor()
    {
        return ModelerPreferenceConstants.NOTE_DEFAULT_FOREGROUND_COLOR;
    }

    @Override
    protected String getNodeBackgroundColor()
    {
        return ModelerPreferenceConstants.NOTE_DEFAULT_BACKGROUND_COLOR;
    }

    @Override
    protected String getBundleId()
    {
        return ModelerPlugin.getId();
    }

}
