/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramConfiguratorPlugin.java,v 1.4 2007/04/18 12:21:26 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelEditPlugin;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.swt.custom.BusyIndicator;
import org.osgi.framework.Bundle;
import org.topcased.modeler.editorconfigurator.internal.EditorConfiguratorPlugin;

/**
 * This is the central singleton for the Diagramconfigurator editor plugin. <!-- begin-user-doc --> <!-- end-user-doc
 * -->
 * 
 * @generated
 */
public final class DiagramConfiguratorPlugin extends EMFPlugin
{
    /**
     * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final DiagramConfiguratorPlugin INSTANCE = new DiagramConfiguratorPlugin();

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
    public DiagramConfiguratorPlugin()
    {
        super(new ResourceLocator[] {EcoreEditPlugin.INSTANCE, EditorConfiguratorPlugin.INSTANCE, GenModelEditPlugin.INSTANCE,});
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
            status = new Status(IStatus.ERROR, getId(), IStatus.OK, "Error", e);

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

    /**
     * Creates an extension. If the extension plugin has not been loaded a busy cursor will be activated during the
     * duration of the load.
     * 
     * @param element the config element defining the extension
     * @param classAttribute the name of the attribute carrying the class
     * @return the extension object
     */
    public static Object createExtension(final IConfigurationElement element, final String classAttribute) throws CoreException
    {
        try
        {
            Bundle extensionBundle = Platform.getBundle(element.getDeclaringExtension().getNamespace());
            if (extensionBundle.getState() == Bundle.ACTIVE)
            {
                String clazzName = element.getAttribute(classAttribute);
                try
                {
                    Class clazz = extensionBundle.loadClass(clazzName);
                    Class[] paramsClass = {};
                    Constructor constructor = clazz.getConstructor(paramsClass);

                    Object[] paramsObj = {};
                    return constructor.newInstance(paramsObj);

                }
                catch (NoSuchMethodException e)
                {
                    DiagramConfiguratorPlugin.log("Unable to load class " + clazzName, IStatus.ERROR);
                    DiagramConfiguratorPlugin.log(e);
                }
                catch (Exception e)
                {
                    DiagramConfiguratorPlugin.log("Unable to load class " + clazzName, IStatus.ERROR);
                    DiagramConfiguratorPlugin.log(e);
                }
            }
            else
            {
                final Object[] ret = new Object[1];
                final Exception[] exc = new Exception[1];
                BusyIndicator.showWhile(null, new Runnable()
                {
                    public void run()
                    {
                        Bundle bundle = Platform.getBundle(element.getDeclaringExtension().getNamespace());
                        String clazzName = element.getAttribute(classAttribute);
                        try
                        {
                            Class clazz = bundle.loadClass(clazzName);
                            Class[] paramsClass = {};
                            Constructor constructor = clazz.getConstructor(paramsClass);

                            Object[] paramsObj = {};
                            ret[0] = constructor.newInstance(paramsObj);

                        }
                        catch (NoSuchMethodException e)
                        {
                            exc[0] = e;
                        }
                        catch (Exception e)
                        {
                            exc[0] = e;
                        }
                    }
                });
                if (exc[0] != null)
                    throw exc[0];
                else
                    return ret[0];
            }

            return null;
        }
        catch (CoreException core)
        {
            throw core;
        }
        catch (Exception e)
        {
            throw new CoreException(new Status(IStatus.ERROR, getId(), IStatus.ERROR, "Unable to create extension", e));
        }
    }

}