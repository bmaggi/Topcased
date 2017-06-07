/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramsPlugin.java,v 1.3 2007/04/12 08:32:18 jako Exp $
 */
package org.topcased.modeler.diagrams.model.internal;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.topcased.modeler.di.model.internal.DIPlugin;

/**
 * This is the central singleton for the Diagrams editor plugin.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public final class DiagramsPlugin extends EMFPlugin
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "";

    /**
     * Keep track of the singleton.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final DiagramsPlugin INSTANCE = new DiagramsPlugin();

    /**
     * Keep track of the singleton.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private static Implementation plugin;

    /**
     * Create the instance.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public DiagramsPlugin()
    {
        super
            (new ResourceLocator [] 
            {
                DIPlugin.INSTANCE,
            });
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
    @Override
    public ResourceLocator getPluginResourceLocator()
    {
        return plugin;
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
    public static Implementation getPlugin()
    {
        return plugin;
    }

    /**
     * The actual implementation of the Eclipse <b>Plugin</b>.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static class Implementation extends EclipseUIPlugin
    {
        /**
         * Creates an instance.
         * <!-- begin-user-doc --> <!-- end-user-doc -->
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

    // ---
    // ------
    // ---------
    // ------------
    // CODE CUSTOM
    // ------------
    // ---------
    // ------
    // ---

    /**
     * Get the Id of the Plugin
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

}
