package org.topcased.tabbedproperties.internal.utils;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final String BUNDLE_NAME = "org.topcased.tabbedproperties.internal.utils.Messages"; //$NON-NLS-1$

    private Messages()
    {
    }

    static
    {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    public static String AbstractTabbedPropertySection_CommandName;

    public static String MessageManager_pWarningSummary;

    public static String MessageManager_pErrorSummary;
}