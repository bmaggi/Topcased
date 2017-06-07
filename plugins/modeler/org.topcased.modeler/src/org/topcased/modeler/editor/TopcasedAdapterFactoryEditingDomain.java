/***********************************************************************
 * Copyright (c) 2008 Obeo and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Laurent Redor (Obeo) - initial API and implementation
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *    David Sciamma (Anyware Technologies) - Workaround for an EMF bug with EFS URI
 *    Gilles Cannenterre (Anyware Technologies) - provide a shared Clipboard
 *    Vincent Hemery (CS) - extract some methods and classes for re-usability
 **********************************************************************/
package org.topcased.modeler.editor;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.gef.Disposable;
import org.topcased.modeler.editor.clipboard.ClipboardSharer;
import org.topcased.modeler.editor.naming.CreationListener;
import org.topcased.modeler.editor.naming.NamingHelper;
import org.topcased.modeler.editor.resource.EditingDomainHelper;
import org.topcased.modeler.editor.resource.TopcasedResourceSet;

/**
 * Extends the classic AdapterFactoryEditingDomain to define a shared clipboard and manage the problem of resource
 * modify in multiple editors - Bug #1405<br>
 * 
 * Creation : 19 juin 2008.
 * 
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
 */
public class TopcasedAdapterFactoryEditingDomain extends AdapterFactoryEditingDomain implements Disposable
{

    /**
     * The Constructor.
     * 
     * @param adapterFactory the adapter factory
     * @param commandStack the command stack
     * @param resourceToReadOnlyMap the resource to read only map
     */
    public TopcasedAdapterFactoryEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack, Map<Resource, Boolean> resourceToReadOnlyMap)
    {
        super(adapterFactory, commandStack, resourceToReadOnlyMap);
        this.resourceSet = new TopcasedResourceSet(this);

        this.commandStack.addCommandStackListener(new CreationListener(this));
    }

    /**
     * Gets the default name.
     * 
     * @param modelObject the model object
     * 
     * @return the default name
     * @deprecated use {@link NamingHelper#getDefaultName(EObject)} instead
     */
    public static String getDefaultName(EObject modelObject)
    {
        return NamingHelper.getDefaultName(modelObject);
    }

    /**
     * The Constructor.
     * 
     * @param adapterFactory the adapter factory
     * @param commandStack the command stack
     */
    public TopcasedAdapterFactoryEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack)
    {
        super(adapterFactory, commandStack);
        this.resourceSet = new AdapterFactoryEditingDomainResourceSet();
    }

    /**
     * The Constructor.
     * 
     * @param adapterFactory the adapter factory
     * @param commandStack the command stack
     * @param resourceSet the resource set
     */
    public TopcasedAdapterFactoryEditingDomain(AdapterFactory adapterFactory, CommandStack commandStack, ResourceSet resourceSet)
    {
        super(adapterFactory, commandStack, resourceSet);
    }

    /**
     * This returns whether the resource is read only.
     * 
     * @param resource the resource
     * 
     * @return true, if checks if is read only
     * 
     * @see org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain#isReadOnly(org.eclipse.emf.ecore.resource.Resource)
     */
    public boolean isReadOnly(Resource resource)
    {
        return EditingDomainHelper.getInstance(this).isReadOnly(resource);
    }

    /**
     * Gets the clipboard.
     * 
     * @return the clipboard
     * 
     * @see org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain#getClipboard()
     */
    @Override
    public Collection<Object> getClipboard()
    {
        return ClipboardSharer.getClipboard();
    }

    /**
     * Sets the clipboard.
     * 
     * @param clipboard the clipboard
     * 
     * @see org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain#setClipboard(java.util.Collection)
     */
    @Override
    public void setClipboard(Collection<Object> clipboard)
    {
        ClipboardSharer.setClipboard(clipboard);
    }

    /**
     * Release all the resources
     */
    public void dispose()
    {
        EditingDomainHelper.getInstance(this).dispose();
        if (resourceToReadOnlyMap != null)
        {
            resourceToReadOnlyMap.clear();
        }
        if (clipboard != null)
        {
            clipboard.clear();
        }
    }

    /**
     * Check if the eObject is read only
     * 
     * @param eObject
     * @return true if is read only
     * @deprecated use {@link EditingDomainHelper} method instead
     */
    public static boolean isEObjectReadOnly(EObject eObject)
    {
        return EditingDomainHelper.isEObjectReadOnly(eObject);
    }

}
