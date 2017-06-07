/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.progress.UIJob;

/**
 * A generic ContentProvider used with Model files and its content.
 * 
 * Creation 4 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class TopcasedModelAdapterFactoryContentProvider extends AdapterFactoryContentProvider implements IResourceChangeListener, IResourceDeltaVisitor
{
    private ResourceSet resourceSet;

    /**
     * Construct an instance that wraps this factory.
     * 
     * @param adapterFactory The AdapterFactory should yield adapters that implement the various item content provider
     *        interfaces.
     */
    public TopcasedModelAdapterFactoryContentProvider(AdapterFactory adapterFactory)
    {
        super(adapterFactory);
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
        resourceSet = new ResourceSetImpl();
    }

    /**
     * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#hasChildren(java.lang.Object)
     */
    @Override
    public boolean hasChildren(Object object)
    {
        if (object instanceof IFile)
            return true;
        return super.hasChildren(object);
    }

    /**
     * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getChildren(java.lang.Object)
     */
    @Override
    public Object[] getChildren(Object object)
    {
        if (object instanceof IFile)
        {
            String path = ((IFile) object).getFullPath().toString();
            URI uri = URI.createPlatformResourceURI(path, true);
            object = resourceSet.getResource(uri, true);
        }
        return super.getChildren(object);
    }

    /**
     * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getParent(java.lang.Object)
     */
    @Override
    public Object getParent(Object object)
    {
        if (object instanceof IFile)
            return ((IResource) object).getParent();
        return super.getParent(object);
    }

    /**
     * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
     */
    @Override
    public Object[] getElements(Object object)
    {
        if (object instanceof IFile)
        {
            String path = ((IFile) object).getFullPath().toString();
            URI uri = URI.createPlatformResourceURI(path, true);
            object = resourceSet.getResource(uri, true);
        }
        return super.getElements(object);
    }

    /**
     * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
     */
    public void resourceChanged(IResourceChangeEvent event)
    {
        IResourceDelta delta = event.getDelta();
        try
        {
            delta.accept(this);
        }
        catch (CoreException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @see org.eclipse.jface.viewers.IContentProvider#dispose()
     */
    @Override
    public void dispose()
    {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);

        super.dispose();
    }

    /**
     * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
     */
    public boolean visit(IResourceDelta delta)
    {
        IResource source = delta.getResource();

        switch (delta.getKind())
        {
            case IResourceDelta.ADDED:
                // handle added resource
                break;
            case IResourceDelta.REMOVED:
                // handle removed resource
                break;
            case IResourceDelta.CHANGED:
                // handle changed resource
                if (source instanceof IFile)
                {
                    final IFile file = (IFile) source;
                    Resource oldResource = resourceSet.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), false);
                    if (oldResource != null)
                    {
                        oldResource.unload();
                    }
                    new UIJob("Update the Model in TopcasedViewer")
                    {
                        @Override
                        public IStatus runInUIThread(IProgressMonitor monitor)
                        {
                            if (viewer != null && !viewer.getControl().isDisposed())
                                ((StructuredViewer) viewer).refresh(file);
                            return Status.OK_STATUS;
                        }
                    }.schedule();
                }
                break;
        }
        return true;
    }

}
