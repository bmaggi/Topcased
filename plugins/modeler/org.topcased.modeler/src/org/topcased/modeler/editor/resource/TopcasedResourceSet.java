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
 *    Vincent Hemery (CS) - extract and adapt ResourceSet class
 **********************************************************************/
package org.topcased.modeler.editor.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.gef.Disposable;

/**
 * This is an implementation of a context that knows about its editing domain. It is used to help implement
 * {@link #getEditingDomainFor(java.lang.Object) getEditingDomainFor(Object)} and
 * {@link #getEditingDomainFor(org.eclipse.emf.ecore.EObject) getEditingDomainFor(EObject)} An instance of this is
 * created if needed in the constructor.
 */
public class TopcasedResourceSet extends ResourceSetImpl implements IEditingDomainProvider
{

    /**
     * The editing domain used by this resource set.
     */
    private final AdapterFactoryEditingDomain linkedEditingDomain;

    public void dispose()
    {
        if (linkedEditingDomain instanceof Disposable)
        {
            ((Disposable) linkedEditingDomain).dispose();
        }
        else
        {
            EditingDomainHelper.getInstance(linkedEditingDomain).dispose();
        }
    }

    /**
     * Constructor.
     * 
     * @param editingDomain editing domain used by this resource set
     */
    public TopcasedResourceSet(AdapterFactoryEditingDomain editingDomain)
    {
        super();
        linkedEditingDomain = editingDomain;
    }

    /**
     * Gets the editing domain.
     * 
     * @return the editing domain
     * 
     * @see org.eclipse.emf.edit.domain.IEditingDomainProvider#getEditingDomain()
     */
    public EditingDomain getEditingDomain()
    {
        return linkedEditingDomain;
    }

    /**
     * Gets the resource.
     * 
     * @param uri the uri
     * @param loadOnDemand the load on demand
     * 
     * @return the resource
     * 
     * @see org.eclipse.emf.ecore.resource.impl.ResourceSetImpl#getResource(org.eclipse.emf.common.util.URI, boolean) <br>
     *      We consider all the resources that is already loaded in write access mode in other editor like readonly
     */
    public Resource getResource(URI uri, boolean loadOnDemand)
    {
        EditingDomainHelper.getInstance(linkedEditingDomain).gettingResource(uri);
        Resource resource = super.getResource(uri, loadOnDemand);
        if (resource != null)
        {
            EditingDomainHelper.getInstance(linkedEditingDomain).checkResource(resource);
        }
        return resource;
    }
}