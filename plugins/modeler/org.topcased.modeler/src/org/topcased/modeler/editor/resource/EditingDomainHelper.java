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
 *    Vincent Hemery (CS) - extract the method to a new Helper class
 **********************************************************************/
package org.topcased.modeler.editor.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.TopcasedAdapterFactoryEditingDomain;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.collaboration.ExportUtil;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.utils.Utils;
import org.topcased.validation.core.MarkerUtil;

/**
 * This class provides utility methods to handle resources and read-only aspects on an
 * {@link AdapterFactoryEditingDomain}. These methods have been extracted from
 * {@link TopcasedAdapterFactoryEditingDomain}.
 * 
 * @author vhemery
 */
public class EditingDomainHelper
{

    /** The instances, for each editing domain using this helper class */
    private static Map<AdapterFactoryEditingDomain, EditingDomainHelper> instancesMap = new HashMap<AdapterFactoryEditingDomain, EditingDomainHelper>();

    /**
     * Get a helper instance, specific to this editing domain (existing one or create a new one).
     * 
     * @param domain the editing domain for which a helper is needed
     * @return helper to handle read-only and resource aspects
     */
    public static EditingDomainHelper getInstance(AdapterFactoryEditingDomain domain)
    {
        if (instancesMap.get(domain) == null)
        {
            EditingDomainHelper helper = new EditingDomainHelper(domain);
            instancesMap.put(domain, helper);
        }
        return instancesMap.get(domain);
    }

    /** The editing domain this helper manipulates. */
    private AdapterFactoryEditingDomain manipulatedEditingDomain;

    /**
     * This attribute means the editing domain makes all the resources read only
     */
    private boolean totalReadOnly = false;

    /**
     * List of the resources that are already opened in another editor (with the names of the other editors).
     */
    private final Map<Resource, List<String>> alreadyOpenedResources = new HashMap<Resource, List<String>>();

    private List<Runnable> refreshRunnables = new LinkedList<Runnable>();

    /** The first resource which is loaded by this EditingDomain. */
    private URI initialResourceURI;

    /**
     * Construct a new helper
     * 
     * @param domain editing domain manipulated by this helper
     */
    private EditingDomainHelper(AdapterFactoryEditingDomain domain)
    {
        manipulatedEditingDomain = domain;
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
        if (totalReadOnly)
        {
            return true;
        }
        if (resource == null)
        {
            return false;
        }
        Map<Resource, Boolean> readOnlyMap = manipulatedEditingDomain.getResourceToReadOnlyMap();
        if (readOnlyMap == null)
        {
            return false;
        }
        else
        {
            Boolean result = readOnlyMap.get(resource);
            if (result == null && resource != null)
            {
                result = isReadOnlyAccordingToAttribute(resource);
                readOnlyMap.put(resource, result);
            }
            return Boolean.TRUE.equals(result);
        }
    }

    /**
     * Determines if the editing domain is in read only mode
     * 
     * @return
     */
    public boolean isTotalReadOnly()
    {
        return totalReadOnly;
    }

    /**
     * Makes the editing domain read only
     * 
     * @param totalReadOnly
     */
    public void setTotalReadOnly(boolean totalReadOnly)
    {
        this.totalReadOnly = totalReadOnly;
    }

    /**
     * Checks the isRead Only attribute of the element
     * 
     * @param resource
     * @return
     */
    public Boolean isReadOnlyAccordingToAttribute(Resource resource)
    {
        Boolean result = false;
        ResourceSet resourceSet = manipulatedEditingDomain.getResourceSet();
        URIConverter converter = (resource.getResourceSet() == null ? resourceSet : resource.getResourceSet()).getURIConverter();

        URI uri = converter.normalize(resource.getURI());
        Map<String, ? > attributes = converter.getAttributes(uri, null);

        result = (Boolean) attributes.get(URIConverter.ATTRIBUTE_READ_ONLY);
        if (result == null)
        {
            result = false;
        }
        return result;
    }

    /**
     * Refresh the list of opened resources and their corresponding editor name
     */
    public void refreshOpenedResources()
    {
        refreshOpenedResources(false);
    }

    /**
     * Refresh the list of opened resources and their corresponding editor name
     * 
     * @param resolveAll true to refresh on all resources, even if never explored
     */
    public void refreshOpenedResources(boolean resolveAll)
    {
        Set<Resource> collection = new HashSet<Resource>(alreadyOpenedResources.keySet());
        if (resolveAll)
        {
            EList<Resource> resources = manipulatedEditingDomain.getResourceSet().getResources();
            collection.addAll(resources);
        }
        for (Resource r : collection)
        {
            checkResource(r);
        }
    }

    /**
     * Refresh the read only resources in the map
     */
    public void refreshReadOnlyResources()
    {
        refreshReadOnlyResources(false);
    }

    /**
     * Refresh the read only resources in the map
     * 
     * @param computeDifferences true if a popup shall be displayed to warn if read-only resources list has changed
     * @return if computeDifferences is false, empty map, otherwise, a map with the names of newly read-only resources
     *         for True key and the names of no longer read-only resources for False key.
     */
    public Map<Boolean, List<String>> refreshReadOnlyResources(boolean computeDifferences)
    {
        refreshOpenedResources();
        for (Runnable r : refreshRunnables)
        {
            r.run();
        }
        // initialize map which will contains changes in read-only files list
        Map<Boolean, List<String>> mapOfChanges;
        if (computeDifferences)
        {
            mapOfChanges = new HashMap<Boolean, List<String>>();
            mapOfChanges.put(Boolean.TRUE, new ArrayList<String>());
            mapOfChanges.put(Boolean.FALSE, new ArrayList<String>());
        }
        else
        {
            mapOfChanges = Collections.emptyMap();
        }

        Map<Resource, Boolean> readOnlyMap = manipulatedEditingDomain.getResourceToReadOnlyMap();
        if (readOnlyMap != null)
        {
            Map<Resource, Boolean> tmp = new HashMap<Resource, Boolean>(readOnlyMap);
            boolean toCheck = Utils.getPreferenceStoreAccordingToCurrentIFile().getBoolean(ModelerPreferenceConstants.PREFERENCE_ELEMENT_DIFFERENT_RESOURCE_READ_ONLY);
            for (Resource r : tmp.keySet())
            {
                // for read only we don't need to change properties of other
                // cases and we don't have other ways to
                // determine old read only resources (with attributes)
                if (!(ExportUtil.isExported(r) || ExportUtil.isCacheUri(r.getURI())))
                {
                    boolean readOnly = (isInOpenedResource(r) && toCheck) || isReadOnlyAccordingToAttribute(r);
                    if (computeDifferences)
                    {
                        // register differences
                        if (readOnly != readOnlyMap.get(r))
                        {
                            mapOfChanges.get(readOnly).add(r.getURI().lastSegment());
                        }
                    }
                    readOnlyMap.put(r, readOnly);
                }
            }
        }
        return mapOfChanges;
    }

    /**
     * Check if element is not directly contained by the main opened resource, but is in dependent resources.
     * 
     * @param element element to check
     * @return true if element is not directly contained by the main resource, but in a child resource
     */
    public boolean isInOpenedResource(EObject element)
    {
        URI initialURI = getInitialResourceURI();
        if (initialURI != null && element.eResource() != null)
        {
            return isInOpenedResource(element.eResource());
        }
        return false;
    }

    /**
     * Check if resource is not directly the main opened resource, but is a dependent resource.
     * 
     * @param resource resource to check
     * @return true if resource is not the main resource, but is a child resource
     */
    public boolean isInOpenedResource(Resource resource)
    {
        URI initialURI = getInitialResourceURI();
        if (initialURI != null && resource != null && resource.getURI() != null)
        {
            if (resource.getURI().toString().endsWith("di"))
            {
                return !initialURI.equals(resource.getURI());
            }
            else
            {
                String initialURIString = initialURI.toString();
                return !(resource.getURI().equals(URI.createURI(initialURIString.substring(0, initialURIString.length() - 2))));
            }
        }
        return false;
    }

    /**
     * Returns the URI of the first opened resource
     */
    public URI getInitialResourceURI()
    {
        return initialResourceURI;
    }

    /**
     * Release all the resources and remove this helper
     */
    public void dispose()
    {
        if (refreshRunnables != null)
        {
            refreshRunnables.clear();
        }
        if (alreadyOpenedResources != null)
        {
            for (Resource r : manipulatedEditingDomain.getResourceSet().getResources())
            {
                if (!alreadyOpenedResources.keySet().contains(r) || isNotEditor(alreadyOpenedResources.get(r)))
                {
                    MarkerUtil.clearMarkerCache(r);
                }
            }
            alreadyOpenedResources.clear();
        }
        Map<Resource, Boolean> readOnlyMap = manipulatedEditingDomain.getResourceToReadOnlyMap();
        if (readOnlyMap != null)
        {
            readOnlyMap.clear();
        }
        instancesMap.remove(manipulatedEditingDomain);
    }

    protected boolean isNotEditor(List<String> list)
    {
        return list != null && list.size() == 1 && !list.get(0).endsWith("di");
    }

    /**
     * Add a runnable run during refresh
     * 
     * @param r , the runnable
     */
    public void addRefreshRunnable(Runnable r)
    {
        refreshRunnables.add(r);
    }

    /**
     * Gets the already opened editors.
     * 
     * @param resource The resource
     * 
     * @return The names of the editors in which this resource is already opened
     */
    public List<String> getAlreadyOpenedEditors(Resource resource)
    {
        return alreadyOpenedResources.get(resource);
    }

    /**
     * Inform this helper that the editing domain is being asked a resource
     * 
     * @param uri resource URI
     */
    public void gettingResource(URI uri)
    {
        if (initialResourceURI == null)
        {
            initialResourceURI = uri;
        }
    }

    /**
     * analyse and determines if the resource is already opened in write mode
     * 
     * @param resource
     */
    public void checkResource(Resource resource)
    {
        if (resource == null)
        {
            return;
        }
        URI uri = resource.getURI();
        EList<Resource> resources = manipulatedEditingDomain.getResourceSet().getResources();
        if (resources.size() > 1 || (!initialResourceURI.equals(resource.getURI())))
        {
            boolean enabled = !ModelerPlugin.getDefault().getStateLocation().append("allowConcurrentAcces").toFile().exists();
            if (enabled)
            {
                String editorName = isToConsiderReadOnly(resource);
                if (editorName != null)
                {
                    List<String> editors = alreadyOpenedResources.get(resource);
                    if (editors == null)
                    {
                        editors = new ArrayList<String>();
                    }
                    if (!editors.contains(editorName))
                    {
                        editors.add(editorName);
                    }
                    alreadyOpenedResources.put(resource, editors);
                }
                else
                {
                    if (alreadyOpenedResources.containsKey(resource))
                    {
                        alreadyOpenedResources.put(resource, null);
                    }
                }
            }
        }
        boolean toCheck = Utils.getPreferenceStoreAccordingToCurrentIFile().getBoolean(ModelerPreferenceConstants.PREFERENCE_ELEMENT_DIFFERENT_RESOURCE_READ_ONLY);
        if (ExportUtil.isExported(resource) || ExportUtil.isCacheUri(uri) || (isInOpenedResource(resource) && toCheck))
        {
            manipulatedEditingDomain.getResourceToReadOnlyMap().put(resource, Boolean.TRUE);
        }
    }

    /**
     * A resource is considered as readonly if it is already loaded in write access mode in other editor.
     * 
     * @param resource The resource to test
     * 
     * @return null if resource isn't already open, the name of the editor which has already loaded this resource in
     *         access mode otherwise
     */
    private String isToConsiderReadOnly(Resource resource)
    {
        if (resource != null && !resource.getURI().equals(initialResourceURI))
        {
            // Test if the resource is already loaded for write in other
            // editor (Topcased modeler editor or EMF
            // editor)
            IWorkbenchWindow[] workbenchWindows = PlatformUI.getWorkbench().getWorkbenchWindows();
            for (IWorkbenchWindow workbenchWindow : workbenchWindows)
            {
                IWorkbenchPage[] workbenchPages = workbenchWindow.getPages();
                for (IWorkbenchPage workbenchPage : workbenchPages)
                {
                    IEditorReference[] editorReferences = workbenchPage.getEditorReferences();
                    for (IEditorReference editorReference : editorReferences)
                    {
                        IEditorPart editorPart = editorReference.getEditor(false);
                        if (editorPart != null)
                        {
                            if (editorPart instanceof Modeler)
                            {
                                // The editor is an topcased modeler editor
                                Modeler modeler = (Modeler) editorPart;
                                if (!modeler.getResourceSet().equals(manipulatedEditingDomain.getResourceSet()))
                                {
                                    // This modeler is not the current
                                    // modeler (the modeler of the initial
                                    // resource)
                                    Resource correspondingResourceInModeler = getCorrespondingResource(modeler.getEditingDomain().getResourceSet().getResources(), resource);
                                    if (correspondingResourceInModeler != null && !modeler.getEditingDomain().isReadOnly(correspondingResourceInModeler))
                                    {
                                        return modeler.getTitle();
                                    }
                                }
                            }
                            else if (editorPart instanceof IEditingDomainProvider)
                            {
                                IEditingDomainProvider editorEMF = (IEditingDomainProvider) editorPart;
                                if (editorEMF.getEditingDomain() instanceof AdapterFactoryEditingDomain)
                                {
                                    // The editor is an emf editor
                                    Resource correspondingResourceInEditorEMF = getCorrespondingResource(editorEMF.getEditingDomain().getResourceSet().getResources(), resource);
                                    if (correspondingResourceInEditorEMF != null && !editorEMF.getEditingDomain().isReadOnly(correspondingResourceInEditorEMF))
                                    {
                                        return editorPart.getTitle();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * Test if this resource is already opened in other editor.
     * 
     * @param resource he resource to test
     * 
     * @return true if it is already open, false otherwise
     */
    public boolean isAlreadyOpened(Resource resource)
    {
        return getAlreadyOpenedEditors(resource) != null;
    }

    /**
     * Check if the eObject is read only
     * 
     * @param eObject
     * @return true if is read only
     */
    public static boolean isEObjectReadOnly(EObject eObject)
    {
        boolean result = false;
        if (eObject != null && eObject.eResource() != null)
        {
            EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
            if (domain != null)
            {
                result = domain.isReadOnly(eObject.eResource());
            }
        }
        return result;
    }

    /**
     * Search a resource in a resources list by the URI.
     * 
     * @param resourcesList A list of resources
     * @param resource The resource to search
     * 
     * @return the resource with the same URI of resource in the resources list, null otherwise
     */
    private static Resource getCorrespondingResource(EList<Resource> resourcesList, Resource resource)
    {
        for (Resource resourceTemp : resourcesList)
        {
            if (resourceTemp.getURI().equals(resource.getURI()))
            {
                return resourceTemp;
            }
        }
        return null;
    }

}
