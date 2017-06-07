/*******************************************************************************
 * Copyright (c) 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.internal.collaboration;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * Utility class with common code for {@link ExportSubmodelCommand} and {@link ImportSubmodelCommand}.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public final class ModelUtil
{
    /**
     * Helper to allow the use of enhanced for loops to iterate on resources contents.
     */
    static Iterable<EObject> allContentsOf(final Resource res)
    {
        return new Iterable<EObject>()
        {
            public Iterator<EObject> iterator()
            {
                return res.getAllContents();
            }
        };
    }

    /**
     * Helper to allow the use of enhanced for loops to iterate on proper resources contents.
     */
    static Iterable<EObject> allProperContentsOf(final Resource res)
    {
        return new Iterable<EObject>()
        {
            public Iterator<EObject> iterator()
            {
                return EcoreUtil.getAllProperContents(res, true);
            }
        };
    }

    /**
     * Updates the references of all the elements in all the resources according to the specified mapping. Every
     * reference from every EObject in all the resources specified which used to point to a key of the mapping is
     * updated to point to the corresponding mapping value instead.
     * 
     * @param resources the scope of the objects to update. All the objects in all these resources and any controlled
     *        sub-resource will be updated
     * @param mapping a mapping from old destination to new destination for references.
     */
    static void updateReferences(Collection< ? extends Resource> resources, Map<EObject, EObject> mapping)
    {
        for (Resource res : resources)
        {
            updateReferences(res, mapping);
        }
    }

    /**
     * Updates the references of all the elements in the resource according to the specified mapping. Every reference
     * from every EObject in the resource which used to point to a key of the mapping is updated to point to the
     * corresponding mapping value instead.
     * 
     * @param res the scope of the objects to update. All the objects in the resource and any controlled sub-resource
     *        will be updated
     * @param mapping a mapping from old destination to new destination for references.
     */
    static void updateReferences(Resource res, Map<EObject, EObject> mapping)
    {
        for (EObject obj : allContentsOf(res))
        {
            updateReferences(obj, mapping);
        }
    }

    /**
     * Updates the references of all the <em>proper</em> elements of all the specified resources according to the
     * specified mapping. Every reference from every EObject in the specified resources which used to point to a key of
     * the mapping is updated to point to the corresponding mapping value instead.
     * <p>
     * This method differs from {@link #updateReferences(Resource, Map)} in that it ignores elements which are
     * controlled sub-models (and hence stored in other resources than <code>res</code> ).
     * 
     * @param resources the scope of the objects to update. Only the objects which are strictly in these resources will
     *        be updated. Controlled sub-resources are ignored.
     * @param mapping a mapping from old destination to new destination for references.
     */
    static void updateProperReferences(Collection< ? extends Resource> resources, Map<EObject, EObject> mapping)
    {
        for (Resource res : resources)
        {
            updateProperReferences(res, mapping);
        }
    }

    /**
     * Updates the references of all the <em>proper</em> elements of the resource according to the specified mapping.
     * Every reference from every EObject in the resource which used to point to a key of the mapping is updated to
     * point to the corresponding mapping value instead.
     * <p>
     * This method differs from {@link #updateReferences(Resource, Map)} in that it ignores elements which are
     * controlled sub-models (and hence stored in other resources than <code>res</code> ).
     * 
     * @param res the scope of the objects to update. Only the objects which are strictly in this resource will be
     *        updated. Controlled sub-resources are ignored.
     * @param mapping a mapping from old destination to new destination for references.
     */
    static void updateProperReferences(Resource res, Map<EObject, EObject> mapping)
    {
        for (EObject obj : allProperContentsOf(res))
        {
            if (obj.eResource() != null)
            {
                updateReferences(obj, mapping);
            }
        }
    }

    /**
     * Updates all the direct references of the given object according to the specified mapping. The references
     * supported include normal EMF references (through structural features) and references through the object's
     * EAnnotation (and their own references, recursively).
     * 
     * @param obj the object to update
     * @param mapping a mapping from old destination to new destination for references.
     */
    public static void updateReferences(EObject obj, Map<EObject, EObject> mapping)
    {
        // 1. "Normal" references through Ecore reference features
        for (EStructuralFeature feature : obj.eClass().getEAllReferences())
        {
            Object oldValue = obj.eGet(feature);
            if (mapping.containsKey(oldValue) && mapping.get(oldValue) != null)
            {
                EObject newValue = mapping.get(oldValue);
                obj.eSet(feature, newValue);
            }
            else if (feature.isMany() && !feature.isDerived())
            {
                @SuppressWarnings("unchecked")
                EList<EObject> oldValues = (EList<EObject>) oldValue;
                for (int i = 0; i < oldValues.size(); i++)
                {
                    EObject oldRef = oldValues.get(i);
                    if (mapping.containsKey(oldRef) && mapping.get(oldRef) != null)
                    {
                        oldValues.set(i, mapping.get(oldRef));
                    }
                }
            }
        }
        // 2. EAnnotation references
        if (obj instanceof EAnnotation)
        {
            EAnnotation annotation = (EAnnotation) obj;
            EList<EObject> refs = annotation.getReferences();
            for (int i = 0; i < refs.size(); i++)
            {
                EObject oldref = refs.get(i);
                if (mapping.containsKey(oldref) && mapping.get(oldref) != null)
                {
                    annotation.getReferences().set(i, mapping.get(oldref));
                }
            }
        }
        // 3. Recursively update the object's EAnnotations
        if (obj instanceof EModelElement)
        {
            EModelElement elt = (EModelElement) obj;
            for (EAnnotation ann : elt.getEAnnotations())
            {
                updateReferences(ann, mapping);
            }
        }
    }

    static String getXmiId(EObject obj)
    {
        Resource res = obj.eResource();
        if (res != null && res instanceof XMLResource)
        {
            return ((XMLResource) res).getID(obj);
        }
        else
        {
            return null;
        }
    }
}
