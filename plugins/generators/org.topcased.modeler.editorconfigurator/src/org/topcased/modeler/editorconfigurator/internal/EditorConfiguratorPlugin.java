/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditorConfiguratorPlugin.java,v 1.4 2007/04/18 12:54:51 jako Exp $
 */
package org.topcased.modeler.editorconfigurator.internal;

import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelEditPlugin;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;

/**
 * This is the central singleton for the Editorconfigurator editor plugin. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public final class EditorConfiguratorPlugin extends EMFPlugin
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "";

    /**
     * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final EditorConfiguratorPlugin INSTANCE = new EditorConfiguratorPlugin();

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
    public EditorConfiguratorPlugin()
    {
        super(new ResourceLocator[] {EcoreEditPlugin.INSTANCE, GenModelEditPlugin.INSTANCE,});
    }

    /**
     * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the singleton instance.
     * @generated
     */
    @Override
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
