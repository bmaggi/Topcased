/*****************************************************************************
 * Copyright (c) 2012 AtoS.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  N. PERANSIN (AtoS) nicolas.peransin@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.builder;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * Bundle activator for builder.
 * <p>
 * As the plugin contains preferences pages, UIPlugin is required.
 * </p>
 * 
 * @author Atos (npn)
 */
public class BuilderActivator extends AbstractUIPlugin
{

    private static BundleContext context;

    private static BuilderActivator plugin;

    static BundleContext getContext()
    {
        return context;
    }

    static BuilderActivator getDefault()
    {
        return plugin;
    }

    /**
     * Return the Id of the Plugin.
     * 
     * @return the Plugin Id
     */
    public String getId()
    {
        return getBundle().getSymbolicName();
    }

    List<ITaskTagExtension> tagExtensions;

    final IRegistryChangeListener extListener = new IRegistryChangeListener()
    {

        public void registryChanged(IRegistryChangeEvent arg0)
        {
            rebuilds();
        }
    };

    public List<ITaskTagExtension> getTagExtensions()
    {
        if (tagExtensions == null)
        {
            tagExtensions = TaskTagExtPoint.readConfiguration(Platform.getExtensionRegistry());
        }
        return tagExtensions;
    }

    BuilderPreferenceInitializer prefs = null;

    final IPropertyChangeListener prefListener = BuilderPreferenceInitializer.createListener(new IPropertyChangeListener()
    {

        public void propertyChange(PropertyChangeEvent arg0)
        {
            prefs = null;
            rebuilds();
        }
    });

    public BuilderPreferenceInitializer getTagPrefs()
    {
        if (prefs == null)
        {
            prefs = BuilderPreferenceInitializer.read();
        }
        return prefs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext bundleContext) throws Exception
    {
        super.start(bundleContext);

        BuilderActivator.context = bundleContext;
        plugin = this;

        Platform.getExtensionRegistry().addRegistryChangeListener(extListener, getId());
        getPreferenceStore().addPropertyChangeListener(prefListener);
    }

    private void rebuilds()
    {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        if (!workspace.isAutoBuilding())
        {
            return;
        }

        TaskTagActivationAction action = new TaskTagActivationAction();

        for (IProject p : ResourcesPlugin.getWorkspace().getRoot().getProjects())
        {
            action.setProject(p);
            try
            {
                if (action.isBuilderInProject())
                {
                    p.build(IncrementalProjectBuilder.FULL_BUILD, TaskTagBuilder.BUILDER_FULLNAME, null, null);
                }
            }
            catch (CoreException e)
            {
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext bundleContext) throws Exception
    {
        BuilderActivator.context = null;

        Platform.getExtensionRegistry().removeRegistryChangeListener(extListener);
        getPreferenceStore().removePropertyChangeListener(prefListener);
    }

    /**
     * Log an exception into the Eclipse log file
     * 
     * @param e the exception to log
     */
    public void log(Throwable e)
    {
        log(e != null ? e.getMessage() : "Error", e);
    }

    /**
     * Log an exception into the Eclipse log file
     * 
     * @param message the message logged
     * @param e the exception to log
     */
    public void log(String message, Throwable e)
    {
        Throwable t = e;
        while (e instanceof InvocationTargetException)
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

        getLog().log(status);
    }

}
