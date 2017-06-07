/*****************************************************************************
 * Copyright (c) 2012 AtoS.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  N. PERANSIN (AtoS) nicolas.peransin@atos.net - Initial API and implementation
 *
 *****************************************************************************/package org.topcased.builder;

import java.util.ArrayList;
import java.util.List;
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
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Builder getting the todo comments.
 * 
 * @author Atos (npn)
 */
public class TaskTagBuilder extends IncrementalProjectBuilder
{

    static String getPluginPrefix()
    {
        return BuilderActivator.getDefault().getId() + ".";
    }

    public static final String BUILDER_NAME = "taskTagBuilder";

    public static final String BUILDER_FULLNAME = getPluginPrefix() + BUILDER_NAME;

    /** Defines the name of type of marker: this name is used in extension */
    public static final String MARKER_TYPENAME = "tasksTags";

    /** The canonical name of the marker type */

    public static final String MARKER_TYPE = getPluginPrefix() + MARKER_TYPENAME;

    /** The name of extension points */
    public static final String TAG_EXT_NAME = "taskTagExtension";

    class BuildVisitor implements IResourceDeltaVisitor, IResourceVisitor
    {

        ResourceSet openeds;

        boolean active = false;

        List<String> tags = null;

        BuildVisitor()
        {
            BuilderPreferenceInitializer prefs = BuilderActivator.getDefault().getTagPrefs();

            if (prefs.getTaskTagFlag() != null)
            {
                tags = new ArrayList<String>(5);
                for (String tag : prefs.getTaskTagFlag().split(BuilderPreferenceInitializer.TAG_SEPARATOR))
                {
                    tag = tag.trim();
                    if (tag.length() > 0)
                    {
                        tags.add(tag);
                    }
                }
            }

            active = prefs.isTaskTagActive() && (tags != null) && !tags.isEmpty();
        }

        /**
         * Return the extension applicable for the resource.
         * 
         * @param res resource to handle
         * @return the applicable extension or null
         */
        protected ITaskTagExtension getExtension(IResource res)
        {
            if (!(res instanceof IFile))
            {
                return null;
            }
            IFile file = (IFile) res;

            for (ITaskTagExtension ext : BuilderActivator.getDefault().getTagExtensions())
            {
                if (ext.accept(file))
                {
                    return ext;
                }
            }
            return null;
        }

        protected void markFile(IResource res) throws CoreException
        {
            if (!res.exists())
            {
                return;
            }

            ITaskTagExtension ext = getExtension(res);
            if (ext == null)
            {
                return;
            }

            IFile file = (IFile) res;
            deleteMarkers(file, ext);
            if (!active)
            {
                return;
            }

            openeds = new ResourceSetImpl();
            openeds.getLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
            openeds.getLoadOptions().put(XMLResource.OPTION_DEFER_ATTACHMENT, true);
            openeds.eSetDeliver(false);

            try
            {
                createMarkersFor(file, ext);
            }
            finally
            {
                for (Resource opened : openeds.getResources())
                {
                    opened.unload();
                }
                openeds = null;
            }

        }

        /**
         * Create markers for provided file.
         * 
         * @param file
         * @param ext
         * @throws CoreException
         */
        public void createMarkersFor(IFile file, ITaskTagExtension ext) throws CoreException
        {

            Resource res = openEResource(file, openeds);
            if ((res == null) || (res.getContents() == null) || res.getContents().isEmpty())
            {
                return;
            }

            TreeIterator<EObject> tree = EcoreUtil.getAllProperContents(res, true);
            while (tree.hasNext())
            {
                EObject eObject = tree.next();
                String analysed = ext.analyse(eObject);
                if (analysed == null)
                {
                    continue;
                }

                for (String tag : tags)
                {
                    if (analysed.trim().startsWith(tag))
                    {
                        createMarker(file, analysed, eObject, ext);
                    }
                }
            }
        }

        private void createMarker(IFile file, String text, EObject eObject, ITaskTagExtension ext) throws CoreException
        {

            IMarker marker = ext.getEditingWrapper(file).createMarker(MARKER_TYPE);

            if (marker != null)
            {
                text = text.trim().replaceAll("[\t\n\r]", " ");
                marker.setAttribute(IMarker.MESSAGE, text);
                marker.setAttribute(IMarker.USER_EDITABLE, false);
                marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);

                URI uri = EcoreUtil.getURI(eObject);
                marker.setAttribute(EValidator.URI_ATTRIBUTE, uri.toString());

                ext.addMarkerAttributes(marker, eObject);
            }
        }

        public boolean visit(IResource resource) throws CoreException
        {
            markFile(resource);
            return true;
        }

        /**
         * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
         */
        public boolean visit(IResourceDelta delta) throws CoreException
        {
            if (delta.getKind() != IResourceDelta.REMOVED)
            {
                markFile(delta.getResource());
            }

            // return true to continue visiting children.
            return true;
        }
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException
    {

        BuildVisitor visitor = new BuildVisitor();

        IResourceDelta delta = null;
        if (kind == INCREMENTAL_BUILD)
        {
            delta = getDelta(getProject());
        }

        if (delta == null)
        {
            getProject().accept(visitor);
        }
        else
        {
            delta.accept(visitor);
        }

        return null;
    }

    private void deleteMarkers(IFile file, ITaskTagExtension ext)
    {
        try
        {

            IFile newFile = ext.getEditingWrapper(file);

            // FIX Bug #3607
            if (!newFile.exists())
            {
                return;
            }
            IMarker[] markers = newFile.findMarkers(MARKER_TYPE, false, IResource.DEPTH_ZERO);
            for (IMarker m : markers)
            {
                m.delete();
                /*
                 * String uri = m.getAttribute(URI_MARKER_ATTRIBUTE, null); if
                 * (URI.createURI(uri).trimFragment().lastSegment().equals(file.getName())) { m.delete(); }
                 */
            }

        }
        catch (CoreException e)
        {
            log(e);
        }
    }

    /**
     * Return the EObject root of a File.
     * 
     * @param file the file to read
     * @return the root EObject the root object
     */
    protected Resource openEResource(IFile file, ResourceSet resSet)
    {
        Resource resource = null;
        URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), false);

        for (IWorkbenchWindow w : PlatformUI.getWorkbench().getWorkbenchWindows())
        {
            for (IWorkbenchPage p : w.getPages())
            {
                if (!p.isEditorAreaVisible())
                {
                    continue;
                }
                for (IEditorReference edRef : p.getEditorReferences())
                {
                    IEditorPart ed = edRef.getEditor(false);
                    IEditingDomainProvider edp = getEditingDomainProvider(ed);
                    if ((edp == null) || (edp.getEditingDomain() == null) || (edp.getEditingDomain().getResourceSet() == null))
                    {
                        continue;
                    }
                    try
                    {
                        resource = edp.getEditingDomain().getResourceSet().getResource(uri, false);
                        if (resource != null)
                        {
                            return resource;
                        }
                    }
                    catch (WrappedException ignore)
                    {
                        // if the file can not be loaded, resource is null
                    }
                }
            }
        }

        return resSet.getResource(uri, true);
    }

    private IEditingDomainProvider getEditingDomainProvider(Object object)
    {
        if (object == null)
        {
            return null;
        }

        // First, if the object is an ImageProvider, use it.
        if (IEditingDomainProvider.class.isInstance(object))
        {
            return (IEditingDomainProvider) object;
        }

        // Second, if the object is adaptable, ask it to get an adapter.
        IEditingDomainProvider provider = null;
        if (object instanceof IAdaptable)
        {
            IAdaptable adapt = (IAdaptable) object;
            provider = (IEditingDomainProvider) adapt.getAdapter(IEditingDomainProvider.class);
        }

        // If we haven't found an adapter yet, try asking the AdapterManager.
        if (provider == null)
        {
            String className = IEditingDomainProvider.class.getName();
            provider = (IEditingDomainProvider) Platform.getAdapterManager().loadAdapter(object, className);
        }

        return provider;
    }

    /**
     * Log an exception into the Eclipse log file.
     * 
     * @param e the exception to log
     */
    public void log(Throwable e)
    {
        BuilderActivator.getDefault().log(e);
    }

}
