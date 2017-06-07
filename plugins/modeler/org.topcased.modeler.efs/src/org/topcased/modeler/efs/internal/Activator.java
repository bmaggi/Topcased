/*******************************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.efs.internal;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin
{

    /** The plug-in ID */
    public static final String PLUGIN_ID = "org.topcased.modeler.efs";

    // The shared instance
    private static Activator plugin;

    /** The workspace change listener */
    private final IResourceChangeListener fListener = new WorkspaceChangeListener();

    /**
     * The constructor
     */
    public Activator()
    {
        // Do nothing
    }

    /**
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception
    {
        super.start(context);
        plugin = this;
        ResourcesPlugin.getWorkspace().addResourceChangeListener(fListener, IResourceChangeEvent.PRE_BUILD);
    }

    /**
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception
    {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(fListener);
        plugin = null;
        super.stop(context);
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

    /**
     * Log a message with given level into the Eclipse log file
     * 
     * @param message the message to log
     * @param level the message priority
     */
    public static void log(String message, int level)
    {
        IStatus status = null;
        status = new Status(level, PLUGIN_ID, IStatus.OK, message, null);
        log(status);
    }

    /**
     * Log an exception into the Eclipse log file
     * 
     * @param e the exception to log
     */
    public static void log(Throwable e)
    {
        if (e instanceof InvocationTargetException)
            e = ((InvocationTargetException) e).getTargetException();

        IStatus status = null;
        if (e instanceof CoreException)
            status = ((CoreException) e).getStatus();
        else
            status = new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, "Error", e);

        log(status);
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
            status = new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, message, e);
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
                    MessageDialog.openInformation(getActiveWorkbenchShell(), (title == null) ? "Information" : title, (message == null) ? "" : message);
                }
            });
        }
        else if (level == IStatus.WARNING)
        {
            Display.getDefault().asyncExec(new Runnable()
            {

                public void run()
                {
                    MessageDialog.openWarning(getActiveWorkbenchShell(), (title == null) ? "Warning" : title, (message == null) ? "" : message);
                }
            });
        }
        else if (level == IStatus.ERROR)
        {
            Display.getDefault().asyncExec(new Runnable()
            {

                public void run()
                {
                    MessageDialog.openError(getActiveWorkbenchShell(), (title == null) ? "Error" : title, (message == null) ? "" : message);
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
     * Log an error message
     * 
     * @param code the plug-in-specific status code, or <code>OK</code>
     * @param message a human-readable message, localized to the current locale
     * @param exception a low-level exception, or <code>null</code> if not applicable
     * @throws CoreException 
     */
	public static void error(int code, String message, Throwable exception) throws CoreException 
	{
		throw new CoreException(new Status(IStatus.ERROR, PLUGIN_ID, code, message, exception));
	}

    /** Workspace change listener */
    private class WorkspaceChangeListener implements IResourceChangeListener
    {
        /**
         * {@inheritDoc}
         */
        public void resourceChanged(final IResourceChangeEvent event)
        {
            final IResourceDelta delta = event.getDelta();
            if (delta != null)
            {
                try
                {
                    delta.accept(new IResourceDeltaVisitor()
                    {
                        public final boolean visit(final IResourceDelta current) throws CoreException
                        {
                            final IResource resource = current.getResource();
                            if (!resource.isDerived())
                            {
                                if (resource.getType() == IResource.FILE)
                                {
                                    switch (current.getKind())
                                    {
                                        case IResourceDelta.ADDED:
                                            if (EFSUtils.getKnownExtension().contains(resource.getFileExtension()))
                                            {
                                                EFSUtils.restoreLinkedResources((IFile) resource);
                                            }
                                            break;
                                    }
                                }
                            }
                            return true;
                        }
                    });
                }
                catch (CoreException exception)
                {
                    log(exception);
                }
            }
        }
    }
}
