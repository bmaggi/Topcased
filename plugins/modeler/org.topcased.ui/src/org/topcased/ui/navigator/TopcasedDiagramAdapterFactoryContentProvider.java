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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.progress.UIJob;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;

/**
 * A generic ContentProvider used with Model files and its content.
 * 
 * Creation 4 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class TopcasedDiagramAdapterFactoryContentProvider extends AdapterFactoryContentProvider implements IResourceChangeListener, IResourceDeltaVisitor
{
    private static final Object[] NO_CHILDREN = new Object[0];

    private ResourceSet resourceSet;

    /**
     * Construct
     */
    public TopcasedDiagramAdapterFactoryContentProvider()
    {
        super(TopcasedDiagramAdapterFactoryProvider.getAdapterFactory());
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
        resourceSet = new ResourceSetImpl();
    }

    /**
     * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#hasChildren(java.lang.Object)
     */
    @Override
    public boolean hasChildren(Object object)
    {
        if (object instanceof Diagram)
        {
            return false;
        }
        if (object instanceof IFile)
        {
            return TopcasedFilePropertyTester.isDi((IFile) object);
        }
        return super.hasChildren(object);
    }

    /**
     * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getChildren(java.lang.Object)
     */
    @Override
    public Object[] getChildren(Object object)
    {
        Object[] children = null;
        if (object instanceof IFile)
        {
            IFile modelFile = (IFile) object;
            if (TopcasedFilePropertyTester.isDi(modelFile))
            {
                URI resourceURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
                Resource model = resourceSet.getResource(resourceURI, true);
                Diagrams rootDiagrams = (Diagrams) model.getContents().get(0);
                children = DiagramsUtils.findAllDiagrams(rootDiagrams).toArray();
            }
        }
        return children != null ? children : NO_CHILDREN;

        // if (object instanceof IFile)
        // {
        // String path = ((IFile) object).getFullPath().toString();
        // URI uri = URI.createPlatformResourceURI(path);
        // object = resourceSet.getResource(uri, true);
        // }
        // return super.getChildren(object);
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
                    new UIJob("Update the Diagrams File in TopcasedViewer")
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
