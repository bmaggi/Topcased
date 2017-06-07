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
package org.topcased.modeler.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.topcased.modeler.editor.Modeler;

/**
 * Provides utilies to manage resources <br>
 * creation : 8 juin 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:mathieu.garcia@anyware-tech.com">Mathieu Garcia</a>
 */
public final class ResourceUtils
{

    private static final String[] READ_ONLY_RESOURCE_SCHEME = {"pathmap"};

    private static Map registeredResources = new HashMap();

    /**
     * Hidden constructor
     */
    private ResourceUtils()
    {
        // Do nothing, just hide
    }

    /**
     * Return true if the given resource is read only
     * 
     * @param resource the resource to check
     * @return <code>true</code> if the resource cannot be written
     */
    public static boolean isReadOnly(Resource resource)
    {
        URI uri = resource.getURI();
        Boolean isReadOnly = (Boolean) registeredResources.get(uri);

        if (isReadOnly == null)
        {
            isReadOnly = Boolean.valueOf(isSchemeReadOnly(uri.scheme()) || isPluginModel(uri));

            registeredResources.put(uri, isReadOnly);
        }
        return isReadOnly.booleanValue();
    }

    /**
     * Check if the URI points to a plugin
     * 
     * @param uri the URI
     * @return <code>true</code> if the resource is in a plugin
     */
    private static boolean isPluginModel(URI uri)
    {
        return uri.toString().startsWith("platform:/plugin");
    }

    /**
     * Check if the scheme represents an unwriteable protocol
     * 
     * @param scheme the scheme
     * @return <code>true</code> if the scheme cannot be written
     */
    private static boolean isSchemeReadOnly(String scheme)
    {
        return Arrays.asList(READ_ONLY_RESOURCE_SCHEME).contains(scheme);
    }

    /**
     * Return true if the given resource is the model resource
     * 
     * @param resource
     * @return <code>true</code> if it is the main model resource
     */
    public static boolean isModelResource(Resource resource)
    {
        return resource.getResourceSet().getResources().indexOf(resource) == 1;
    }

    /**
     * Add UUID on elements : elements can only be modified if the class inherits from EModelElement
     * 
     * @param modelObject the model to modify
     */
    public static void addUUID(EObject modelObject)
    {
        // Add UUID on this object
        addUUIDForEObject(modelObject);

        // Add UUID on children
        Iterator itChildren = modelObject.eAllContents();
        while (itChildren.hasNext())
        {
            addUUIDForEObject((EObject) itChildren.next());
        }
    }

    /**
     * Add UUID on elements : elements can only be modified if the class inherits from EModelElement
     * 
     * @param modelObject the model to modify
     */
    private static void addUUIDForEObject(EObject modelObject)
    {
        if (modelObject instanceof EModelElement && !(modelObject instanceof EAnnotation))
        {
            // Create Helper
            UuidHelper helper = new UuidHelper();
            helper.initUUID((EModelElement) modelObject, EcoreUtil.generateUUID());
        }
    }

    /**
     * Get modelers which are currently writing a resource the modeler needs
     * 
     * @param modeler the editor trying to get write access, which will not be included in the result
     * @return all modelers writing on the accessed resources. The list size should be 0 or 1, though more elements can
     *         be returned in case a conflicting problem occurred.
     */
    public static List<Modeler> getConflictingWritingModelers(Modeler modeler)
    {
        List<Modeler> result = new ArrayList<Modeler>(1);
        for (Resource r : modeler.getResourceSet().getResources())
        {
            List<Modeler> newResults = getModelersWritingOnResource(r, modeler);
            newResults.removeAll(result);
            result.addAll(newResults);
        }
        return result;
    }

    /**
     * Get modelers which are currently writing a resource
     * 
     * @param resource the edited resource
     * @param editor the editor trying to use the resource, which will not be included in the result
     * @return all modelers writing on the resource. The list size should be 0 or 1, though more elements can be
     *         returned in case a conflicting problem occurred.
     */
    public static List<Modeler> getModelersWritingOnResource(Resource resource, IEditorPart editor)
    {
        List<Modeler> result = new ArrayList<Modeler>(1);
        URI uri = resource.getURI();
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
                    if (editorPart instanceof Modeler && editorPart != editor)
                    {
                        // The editor is a topcased modeler editor
                        Modeler modeler = (Modeler) editorPart;
                        Resource correspondingResourceInModeler = modeler.getResourceSet().getResource(uri, false);
                        if (correspondingResourceInModeler != null && !modeler.isReadOnly())
                        {
                            // modeler is writing the resource
                            result.add(modeler);
                        }
                    }
                }
            }
        }
        return result;
    }
}
