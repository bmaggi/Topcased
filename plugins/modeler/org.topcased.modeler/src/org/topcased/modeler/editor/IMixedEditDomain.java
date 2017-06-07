/*******************************************************************************
 * Copyright (c) 2012 CNES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Vincent HEMERY (CS) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.editor;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.Adaptable;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.ui.IEditorPart;

/**
 * This interface shall be used to provide an edit domain which brings GEF edit domain but also EMF editing domain
 * capabilities.<br/>
 * It must be able to provide both objects. The most convenient way to do so is to extend the GEF or EMF one and to
 * provide a proxy for the other one.<br/>
 * It must also be adaptable to a various set of classes, for which the method {@link #getAdapter(Class)} returns the
 * same result as the corresponding method from this interface. To achieve this, since an adapter manager is registered
 * by this Interface, you may simply use the following implementation for the {@link #getAdapter(Class)} method :<br/>
 * <code>
 * IAdapterManager manager = IMixedEditDomain.Helper.getAdapterManager();
 * return (T) manager.getAdapter(this, adapter);</code><br/>
 * {@link Adaptable} is used rather than {@link IAdaptable} to avoid
 * name clash, since you may want to implement this interface by subclassing a transactional editing domain.
 * 
 * @author vhemery
 */
public interface IMixedEditDomain extends Adaptable
{

    /**
     * Get the corresponding EMF editing domain
     * 
     * @return editing domain with EMF capabilities
     */
    public EditingDomain getEMFEditingDomain();

    /**
     * Get the corresponding GEF edit domain
     * 
     * @return edit domain with GEF capabilities
     */
    public DefaultEditDomain getGEFEditDomain();

    /**
     * Get the corresponding GEF editor part
     * 
     * @return editor part
     */
    public IEditorPart getEditorPart();

    /**
     * Dispose all no longer necessary objects, like command stacks or pointers.
     */
    public void dispose();

    /**
     * Sets the global adapter factory used in this edit domain
     * 
     * @param adapterFactory the adapter factory to use
     */
    public void setAdapterFactory(AdapterFactory adapterFactory);

    /**
     * Returns the global adapter factory used in this edit domain
     * 
     * @return the adapter factory
     */
    public AdapterFactory getAdapterFactory();

    /**
     * Returns the command stack used to execute EMF commands
     * 
     * @return EMF command stack
     */
    public org.eclipse.emf.common.command.CommandStack getEMFCommandStack();

    /**
     * Returns the command stack used to execute GEF commands
     * 
     * @return GEF command stack
     */
    public org.eclipse.gef.commands.CommandStack getGEFCommandStack();

    /**
     * This helper returns the adapter manager. Use it rather than <code>Platform</code>, to ensure adapter factory is
     * correctly
     * registered.
     * 
     * @author vhemery
     */
    public static class Helper
    {
        /**
         * Register adapter factory
         */
        static
        {
            IAdapterManager manager = Platform.getAdapterManager();
            IAdapterFactory factory = new MixedEditDomainAdapterFactory();
            manager.registerAdapters(factory, IMixedEditDomain.class);
        }

        /**
         * Returns the adapter manager used for extending <code>IAdaptable</code> objects.
         * 
         * @return the adapter manager for this platform
         * @see IAdapterManager
         */
        public static IAdapterManager getAdapterManager()
        {
            return Platform.getAdapterManager();
        }

        /**
         * An adapter factory which defines behavioral extensions for {@link IMixedEditDomain}.
         * 
         * @see IMixedEditDomain
         */
        private static class MixedEditDomainAdapterFactory implements IAdapterFactory
        {

            /**
             * Returns an object which is an instance of the given class
             * associated with the given object. Returns <code>null</code> if
             * no such object can be found.
             * 
             * @param adaptableObject the adaptable object being queried
             *        (usually an instance of <code>IAdaptable</code>)
             * @param adapterType the type of adapter to look up
             * @return a object castable to the given adapter type,
             *         or <code>null</code> if this adapter factory
             *         does not have an adapter of the given type for the
             *         given object
             */
            @SuppressWarnings("rawtypes")
            public Object getAdapter(Object adaptableObject, Class adapterType)
            {
                if (adaptableObject instanceof IMixedEditDomain)
                {
                    IMixedEditDomain dom = (IMixedEditDomain) adaptableObject;
                    if (IMixedEditDomain.class.equals(adapterType)){
                        return adaptableObject;
                    }
                    else if (EditDomain.class.equals(adapterType) || DefaultEditDomain.class.equals(adapterType))
                    {
                        return dom.getGEFEditDomain();
                    }
                    else if (EditingDomain.class.equals(adapterType))
                    {
                        return dom.getEMFEditingDomain();
                    }
                    else if (IEditorPart.class.equals(adapterType))
                    {
                        dom.getEditorPart();
                    }
                    else if (org.eclipse.emf.common.command.CommandStack.class.equals(adapterType))
                    {
                        return dom.getEMFCommandStack();
                    }
                    else if (org.eclipse.gef.commands.CommandStack.class.equals(adapterType))
                    {
                        return dom.getGEFCommandStack();
                    }
                    else if (AdapterFactory.class.equals(adapterType))
                    {
                        return dom.getAdapterFactory();
                    }
                }
                return null;
            }

            /**
             * Returns the collection of adapter types handled by this
             * factory.
             * <p>
             * This method is generally used by an adapter manager to discover which adapter types are supported, in
             * advance of dispatching any actual <code>getAdapter</code> requests.
             * </p>
             * 
             * @return the collection of adapter types
             */
            @SuppressWarnings("rawtypes")
            public Class[] getAdapterList()
            {
                return new Class[] {DefaultEditDomain.class, EditDomain.class, EditingDomain.class, IEditorPart.class, org.eclipse.emf.common.command.CommandStack.class,
                        org.eclipse.gef.commands.CommandStack.class};
            }

        }
    }

}
