/*******************************************************************************
 * Copyright (c) 2008 TOPCASED. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Topcased contributors and others - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.builders;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * <br>
 * Creation : 22 sept. 2008
 * 
 * @author <a href="mailto:steve.monnier@obeo.fr">Steve Monnier</a>
 */
public class TodoNoteBuilder extends IncrementalProjectBuilder
{
    /**
     * Defines the type of the marker of Todo Notes
     */
    public static final String MARKER_TYPE = "org.topcased.modeler.todoNoteMarker";

    /**
     * Defines the URI of the marker attribute
     */
    public static final String URI_MARKER_ATTRIBUTE = "todoNoteURIMarker";

    public static final String PROPERTY_KEY = "noteValue";

    public static final String TODO_PATTERN = "todo";

    public static final String UMLDI_FILE_EXTENSION = ".umldi";

    public static final String SYSMLDI_FILE_EXTENSION = ".sysmldi";

    public static final String SAM_FILE_EXTENSION = ".samdi";

    class SampleDeltaVisitor implements IResourceDeltaVisitor
    {
        /**
         * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
         */
        public boolean visit(IResourceDelta delta) throws CoreException
        {
            IResource resource = delta.getResource();
            switch (delta.getKind())
            {
                case IResourceDelta.ADDED:
                    // handle added resource
                    checkTopcasedFile(resource);
                    break;
                case IResourceDelta.REMOVED:
                    // handle removed resource
                    break;
                case IResourceDelta.CHANGED:
                    // handle changed resource
                    checkTopcasedFile(resource);
                    break;
            }
            // return true to continue visiting children.
            return true;
        }
    }

    class SampleResourceVisitor implements IResourceVisitor
    {
        public boolean visit(IResource resource)
        {
            checkTopcasedFile(resource);

            // return true to continue visiting children.
            return true;
        }
    }

    /**
     * @see org.eclipse.core.resources.IncrementalProjectBuilder#build(int, java.util.Map,
     *      org.eclipse.core.runtime.IProgressMonitor)
     */
    @SuppressWarnings("rawtypes")
    @Override
    protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException
    {
        if (kind == FULL_BUILD)
        {
            fullBuild(monitor);
        }
        else
        {
            IResourceDelta delta = getDelta(getProject());
            if (delta == null)
            {
                fullBuild(monitor);
            }
            else
            {
                incrementalBuild(delta, monitor);
            }
        }
        return null;
    }

    private void deleteMarkers(IFile file)
    {
        try
        {
            file.deleteMarkers(MARKER_TYPE, false, IResource.DEPTH_ZERO);
        }
        catch (CoreException e)
        {
            ModelerPlugin.log(e);
        }
    }

    /**
     * @param file
     * @throws CoreException
     */
    public void createMarkerForResource(IFile file) throws CoreException
    {
        try
        {

            EObject modelInput = openFile(file);
            if (modelInput != null)
            {
                TreeIterator<EObject> tree = EcoreUtil.getAllProperContents(modelInput, false);
                while (tree.hasNext())
                {
                    EObject eobject = tree.next();
                    if (eobject instanceof Property)
                    {
                        Property property = (Property) eobject;
                        if (property.getKey().equals(PROPERTY_KEY) && property.getValue() != null && property.getValue().toLowerCase().startsWith(TODO_PATTERN))
                        {
                            IMarker marker = file.createMarker(MARKER_TYPE);
                            marker.setAttribute(IMarker.MESSAGE, property.getValue());
                            marker.setAttribute(IMarker.USER_EDITABLE, false);
                            marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
                            marker.setAttribute(URI_MARKER_ATTRIBUTE, EcoreUtil.getURI(property).toString());
                        }
                    }
                }
            }
        }
        catch (CoreException e)
        {
            ModelerPlugin.log(e);
        }
    }

    /**
     * Return the EObject root of a File
     * 
     * @param file the file to read
     * @return the root EObject the root object
     */
    protected EObject openFile(IFile file)
    {
        URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), false);
        Resource resource = (new ResourceSetImpl()).getResource(uri, true);
        if (resource != null && resource.getContents() != null && resource.getContents().size() > 0)
        {
            return resource.getContents().get(0);
        }
        return null;
    }

    /**
     * @param monitor
     * @throws CoreException
     */
    protected void fullBuild(final IProgressMonitor monitor) throws CoreException
    {
        try
        {
            getProject().accept(new SampleResourceVisitor());
        }
        catch (CoreException e)
        {
            ModelerPlugin.log(e);
        }
    }

    /**
     * @param delta
     * @param monitor
     * @throws CoreException Launch incremetal build of todo note markers
     */
    protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException
    {
        // the visitor does the work.
        delta.accept(new SampleDeltaVisitor());
    }

    /**
     * @param resource Update the todo note markers for this resource
     */
    protected void checkTopcasedFile(IResource resource)
    {
        if (resource instanceof IFile && (resource.getName().endsWith(UMLDI_FILE_EXTENSION) || resource.getName().endsWith(SYSMLDI_FILE_EXTENSION) || resource.getName().endsWith(SAM_FILE_EXTENSION)))
        {
            IFile file = (IFile) resource;
            deleteMarkers(file);

            try
            {
                createMarkerForResource(file);
            }
            catch (CoreException e)
            {
                ModelerPlugin.log(e);
            }
        }
    }

}
