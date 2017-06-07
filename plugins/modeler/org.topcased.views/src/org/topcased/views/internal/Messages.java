/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * Copyright (c) 2012 Airbus
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies)
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Pierre Gaufillet (Airbus) - General purpose references view
 *
 * $Id: Messages.java,v 1.2 2012/07/26 05:38:11 gaufille Exp $
 **********************************************************************/

package org.topcased.views.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{

    private static final String BUNDLE_NAME = "org.topcased.views.internal.messages"; //$NON-NLS-1$

    public static String Activator_Error;

    public static String AnalysisView_InvalidSelection;

    public static String EReferencesView_InvalidSelection;

    public static String ReferencesView_RefreshReferences;

    public static String RefreshAction_Refresh;

    public static String RefreshAction_Refresh_description;

    public static String RefreshAction_Refresh_tooltip;

    public static String ToggleSynchronizeAction_Synchronize;

    public static String ToggleSynchronizeAction_Synchronize_description;

    public static String ToggleSynchronizeAction_Synchronize_tooltip;

    static
    {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages()
    {
    }
}
