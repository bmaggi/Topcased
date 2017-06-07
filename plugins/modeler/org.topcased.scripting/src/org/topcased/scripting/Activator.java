/*******************************************************************************
 * Copyright (c) 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *******************************************************************************/
package org.topcased.scripting;

import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The plugin activator.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public class Activator extends AbstractUIPlugin
{

    /** The plug-in ID */
    public static final String PLUGIN_ID = "org.topcased.scripting";

    // The shared instance
    private static Activator plugin;

    /**
     * The constructor
     */
    public Activator()
    {
        // Nothing to do
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception
    {
        super.start(context);
        plugin = this;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception
    {
        plugin = null;
        super.stop(context);
    }

    /**
     * Log an exception as error
     * 
     * @param exception exception to log
     */
    public static void log(Throwable exception)
    {
        plugin.getLog().log(new Status(Status.ERROR, PLUGIN_ID, exception.getMessage(), exception));
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault()
    {
        return plugin;
    }
}
