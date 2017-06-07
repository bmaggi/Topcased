/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.editor;

import java.util.HashMap;

import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.ui.IEditorPart;
import org.topcased.modeler.commands.AdvancedCommandStack;
import org.topcased.modeler.commands.GEFtoEMFCommandStackWrapper;

/**
 * This edit domain is based ont the default GEF edit domain but also brings EMF capabilities.<br>
 * It stores the composed adapter factory used in the editor.<br>
 * <br>
 * creation : 27 mai 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class MixedEditDomain extends DefaultEditDomain implements IMixedEditDomain
{

    /**
     * This is the global domain adapter factory.
     */
    private AdapterFactory adapterFactory;

    /**
     * The EMF Edit Domain
     */
    private AdapterFactoryEditingDomain emfEditingDomain;

    private ResourceSet resourceSet;

    /**
     * @param editorPart
     */
    public MixedEditDomain(IEditorPart editorPart)
    {
        this(editorPart, null);
    }

    /**
     * @param editorPart
     * @param res
     */
    public MixedEditDomain(IEditorPart editorPart, ResourceSet res)
    {
        super(editorPart);

        resourceSet = res;
        setCommandStack(new AdvancedCommandStack());
    }

    /**
     * Returns the global adapter factory used in this edit domain
     * 
     * @return the adapter factory
     */
    public AdapterFactory getAdapterFactory()
    {
        return adapterFactory;
    }

    /**
     * Set the glocal adapter factory used in this edit domain and initialize the EMF editing domain
     * 
     * @param factory the new adapter factory
     */
    public void setAdapterFactory(AdapterFactory factory)
    {
        adapterFactory = factory;

        if (emfEditingDomain == null)
        {
            final CommandStack emfCommandStack = new GEFtoEMFCommandStackWrapper(getCommandStack());

            AdapterFactoryEditingDomain editingDomain = null;
            // Create the editing domain with a simple command stack.
            if (resourceSet != null)
            {
                editingDomain = new TopcasedAdapterFactoryEditingDomain(adapterFactory, emfCommandStack, resourceSet);
            }
            else
            {
                editingDomain = new TopcasedAdapterFactoryEditingDomain(adapterFactory, emfCommandStack, new HashMap<Resource, Boolean>());
            }

            setEMFEditingDomain(editingDomain);
        }
    }

    /**
     * Returns the EMF editDomain
     * 
     * @return the EMF editDomain
     */
    public AdapterFactoryEditingDomain getEMFEditingDomain()
    {
        return emfEditingDomain;
    }

    /**
     * Set the EMF editing domain
     * 
     * @param editingDomain the new EMF editing domain
     */
    public void setEMFEditingDomain(AdapterFactoryEditingDomain editingDomain)
    {
        this.emfEditingDomain = editingDomain;
    }

    public void dispose()
    {
        getCommandStack().dispose();
        adapterFactory = null;
        resourceSet = null;
        emfEditingDomain = null;
    }

    /**
     * Get the corresponding GEF edit domain
     * 
     * @return edit domain with GEF capabilities
     */
    public DefaultEditDomain getGEFEditDomain()
    {
        return this;
    }

    /**
     * Returns an object which is an instance of the given class
     * associated with this object. Returns <code>null</code> if
     * no such object can be found.
     * 
     * @param adapter the adapter class to look up
     * @return a object castable to the given class,
     *         or <code>null</code> if this object does not
     *         have an adapter for the given class
     */
    @SuppressWarnings("unchecked")
    public <T> T getAdapter(Class< ? extends T> adapter)
    {
        IAdapterManager manager = IMixedEditDomain.Helper.getAdapterManager();
        return (T) manager.getAdapter(this, adapter);
    }

    /**
     * Returns the command stack used to execute EMF commands
     * 
     * @return EMF command stack
     */
    public CommandStack getEMFCommandStack()
    {
        return getEMFEditingDomain().getCommandStack();
    }

    /**
     * Returns the command stack used to execute GEF commands
     * 
     * @return GEF command stack
     */
    public org.eclipse.gef.commands.CommandStack getGEFCommandStack()
    {
        return getCommandStack();
    }
}
