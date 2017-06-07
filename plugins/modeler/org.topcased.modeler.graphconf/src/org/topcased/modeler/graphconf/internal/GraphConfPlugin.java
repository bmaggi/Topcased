/**
 * <copyright>
 * </copyright>
 *
 * $Id: GraphConfPlugin.java,v 1.1 2006/12/18 15:21:43 jako Exp $
 */
package org.topcased.modeler.graphconf.internal;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * This is the central singleton for the Graphconf editor plugin. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public final class GraphConfPlugin extends EMFPlugin
{
    /**
     * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final GraphConfPlugin INSTANCE = new GraphConfPlugin();

    /**
     * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static Implementation plugin;

    /**
     * Create the instance. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public GraphConfPlugin()
    {
        super(new ResourceLocator[] {});
    }

    /**
     * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the singleton instance.
     * @generated
     */
    public ResourceLocator getPluginResourceLocator()
    {
        return plugin;
    }

    /**
     * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the singleton instance.
     * @generated
     */
    public static Implementation getPlugin()
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
        return getPlugin().getBundle().getSymbolicName();
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
     * Log an IStatus
     * 
     * @param status Status of an operation
     */
    public static void log(IStatus status)
    {
        ResourcesPlugin.getPlugin().getLog().log(status);
    }

    /**
     * The actual implementation of the Eclipse <b>Plugin</b>. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static class Implementation extends EclipseUIPlugin
    {
        /**
         * Creates an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        public Implementation()
        {
            super();

            // Remember the static instance.
            //
            plugin = this;
        }
    }

}
