package org.topcased.core.internal;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class CorePlugin extends Plugin
{

    /** The plug-in ID */
    public static final String PLUGIN_ID = "org.topcased.core";

    /** The shared instance */
    private static CorePlugin plugin;

    /**
     * The constructor
     */
    public CorePlugin()
    {
        plugin = this;
    }

    /**
     * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception
    {
        super.start(context);
    }

    /**
     * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
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
    public static CorePlugin getDefault()
    {
        return plugin;
    }
    
    /**
     * Gets the symbolic name of the plug-in
     * 
     * @return the symbolic name i.e the given identifier
     */
    private static String getId()
    {
        return getDefault().getBundle().getSymbolicName();
    }
    
    /**
     * Logs an exception into the Eclipse log file.
     * 
     * @param e the exception to log
     * @generated
     */
    public static void log(Throwable e)
    {
        if (e instanceof InvocationTargetException)
        {
            e = ((InvocationTargetException) e).getTargetException();
        }

        IStatus status = null;
        if (e instanceof CoreException)
        {
            status = ((CoreException) e).getStatus();
        }
        else
        {
            status = new Status(IStatus.ERROR, getId(), IStatus.OK, "Error", e); //$NON-NLS-1$
        }
        log(status);
    }
    
    /**
     * Logs an IStatus.
     * 
     * @param status the status to log
     * @generated
     */
    public static void log(IStatus status)
    {
        ResourcesPlugin.getPlugin().getLog().log(status);
    }

}
