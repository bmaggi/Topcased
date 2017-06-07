package org.topcased.ui.internal;

import java.lang.reflect.InvocationTargetException;

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
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin
{

    /** The plug-in ID */
    public static final String PLUGIN_ID = "org.topcased.ui";

    // The shared instance
    private static Activator plugin;

    /**
     * The constructor
     */
    public Activator()
    {
        plugin = this;
    }

    /**
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception
    {
        super.start(context);
    }

    /**
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception
    {
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
     * Returns an image descriptor for the image file at the given plug-in relative path.
     * 
     * @param path the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path)
    {
        return AbstractUIPlugin.imageDescriptorFromPlugin("org.topcased.ui.navigator", path);
    }
}
