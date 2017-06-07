/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.internal;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class ModelerPlugin extends AbstractUIPlugin
{
    // The shared instance.
    private static ModelerPlugin plugin;

    /**
     * The constructor.
     */
    public ModelerPlugin()
    {
        super();
        plugin = this;

    }

    /**
     * This method is called upon plug-in activation
     * 
     * @param context the context
     * @throws Exception exception
     */
    public void start(BundleContext context) throws Exception
    {
        super.start(context);
    }

    /**
     * This method is called when the plug-in is stopped
     * 
     * @param context the context
     * @throws Exception exception
     */
    public void stop(BundleContext context) throws Exception
    {
        super.stop(context);
        plugin = null;
    }

    /**
     * Returns the shared instance.
     * 
     * @return the instance
     */
    public static ModelerPlugin getDefault()
    {
        return plugin;
    }

    /**
     * get the Id of the Plugin
     * 
     * @return the Plugin Id
     */
    public static String getId()
    {
        return getDefault().getBundle().getSymbolicName();
    }

    /**
     * Log a message with given level into the Eclipse log file
     * 
     * @param message the message to log
     * @param level the message priority
     */
    public static void log(String message, int level)
    {
        IStatus status = null;
        status = new Status(level, getId(), IStatus.OK, message, null);
        log(status);
    }

    /**
     * Log an exception into the Eclipse log file
     * 
     * @param e the exception to log
     */
    public static void log(Throwable e)
    {
        log("Error", e);
    }

    /**
     * Log an exception into the Eclipse log file
     * 
     * @param message the message logged *
     * @param e the exception to log
     */
    public static void log(String message, Throwable e)
    {

        Throwable t = e;
        if (e instanceof InvocationTargetException)
        {
            t = ((InvocationTargetException) e).getTargetException();
        }

        IStatus status = null;
        if (t instanceof CoreException)
        {
            status = ((CoreException) t).getStatus();
        }
        else
        {
            status = new Status(IStatus.ERROR, getId(), IStatus.OK, message, e);
        }

        log(status);
    }

    /**
     * Write a debug message if the debug is enabled.
     * 
     * @param message the message to log
     */
    public static void debug(String message)
    {
        if (Platform.inDebugMode())
        {
            System.out.println(message);
        }
    }

    /**
     * Log an IStatus
     * 
     * @param status Status of an operation
     */
    public static void log(IStatus status)
    {
        getDefault().getLog().log(status);
    }

    /**
     * Display a dialog box with the specified level
     * 
     * @param title title dialog box
     * @param message message displayed
     * @param level message level
     */
    public static void displayDialog(final String title, final String message, final int level)
    {
        if (level == IStatus.INFO)
        {
            Display.getDefault().asyncExec(new Runnable()
            {
                public void run()
                {
                    MessageDialog.openInformation(getActiveWorkbenchShell(), (title == null) ? "Information" : title,
                            (message == null) ? "" : message);
                }
            });
        }
        else if (level == IStatus.WARNING)
        {
            Display.getDefault().asyncExec(new Runnable()
            {
                public void run()
                {
                    MessageDialog.openWarning(getActiveWorkbenchShell(), (title == null) ? "Warning" : title,
                            (message == null) ? "" : message);
                }
            });
        }
        else if (level == IStatus.ERROR)
        {
            Display.getDefault().asyncExec(new Runnable()
            {
                public void run()
                {
                    MessageDialog.openError(getActiveWorkbenchShell(), (title == null) ? "Error" : title,
                            (message == null) ? "" : message);
                }
            });
        }
    }

    /**
     * Returns the active workbench shell
     * 
     * @return the active workbench shell
     */
    public static Shell getActiveWorkbenchShell()
    {
        IWorkbenchWindow workBenchWindow = getActiveWorkbenchWindow();
        if (workBenchWindow == null)
        {
            return null;
        }
        return workBenchWindow.getShell();
    }

    /**
     * Returns the active workbench page or <code>null</code> if none.
     * 
     * @return the active workbench page
     */
    public static IWorkbenchPage getActivePage()
    {
        IWorkbenchWindow window = getActiveWorkbenchWindow();
        if (window != null)
        {
            return window.getActivePage();
        }
        return null;
    }

    /**
     * Returns the active workbench window
     * 
     * @return the active workbench window
     */
    public static IWorkbenchWindow getActiveWorkbenchWindow()
    {
        if (getDefault() == null)
        {
            return null;
        }
        IWorkbench workBench = getDefault().getWorkbench();
        if (workBench == null)
        {
            return null;
        }
        return workBench.getActiveWorkbenchWindow();
    }

    /**
     * Returns the workspace instance.
     * 
     * @return the current workspace
     */
    public static IWorkspace getWorkspace()
    {
        return ResourcesPlugin.getWorkspace();
    }

    /**
     * Open an url with the configured web browser in the preferences pages.
     * 
     * @param url the url to open
     */
    public static void openURL(URL url)
    {
        try
        {
            IWorkbenchBrowserSupport support = getDefault().getWorkbench().getBrowserSupport();
            IWebBrowser browser = support.createBrowser(IWorkbenchBrowserSupport.LOCATION_BAR
                    | IWorkbenchBrowserSupport.LOCATION_BAR | IWorkbenchBrowserSupport.STATUS, url.toString(), null,
                    null);
            browser.openURL(url);
        }
        catch (PartInitException pie)
        {
            log(pie);
        }
    }

    /**
     * Returns an image descriptor for the image file at the given plug-in
     * relative path.
     * 
     * @param path the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path)
    {
        return AbstractUIPlugin.imageDescriptorFromPlugin("org.topcased.modeler", path);
    }
}
