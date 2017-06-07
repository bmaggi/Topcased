package org.topcased.modeler.export.html;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class HTMLPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.topcased.modeler.export.html";

	// The shared instance
	private static HTMLPlugin plugin;
	
	//The ResourceSet of export HTML
	private static ResourceSet resourceSet;
	
	
	public static ResourceSet getResourceSet() {
		if(resourceSet == null)
		{
			setResourceSet(new ResourceSetImpl());
		}
		return resourceSet;
	}

	public static void setResourceSet(ResourceSet resourceSet) {
		HTMLPlugin.resourceSet = resourceSet;
	}

	/**
	 * The constructor
	 */
	public HTMLPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static HTMLPlugin getDefault() {
		return plugin;
	}

	public static void log(final Throwable thr)
	{
		String defaultMsg = "No details available.";
		String msg = thr.getMessage() == null ? defaultMsg : thr.getMessage();
		IStatus status = new Status(IStatus.ERROR, PLUGIN_ID, 0, msg, thr);
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
}
