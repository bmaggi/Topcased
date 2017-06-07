//------------------------------------------------------------------------------
// Copyright (c) 2005, 2006 IBM Corporation and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
// IBM Corporation - initial implementation
//------------------------------------------------------------------------------
package org.topcased.richtext.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.topcased.richtext.RichTextPlugin;

/**
 * The rich text preferences initializer.
 * 
 * @author Kelvin Low
 * @since 1.0
 */
public class RichTextPreferencesInitializer extends
		AbstractPreferenceInitializer {

	/**
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = RichTextPlugin.getDefault()
				.getPreferenceStore();
		RichTextPreferences.initializeDefaultPreferences(store);
	}

}
