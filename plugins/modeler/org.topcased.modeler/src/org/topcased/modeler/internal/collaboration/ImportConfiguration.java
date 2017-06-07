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

import static org.topcased.modeler.internal.collaboration.ModelUtil.allProperContentsOf;
import static org.topcased.modeler.internal.collaboration.ModelUtil.getXmiId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.internal.collaboration.FrontierElement.Usage;

/**
 * This class encapsulates all the information needed to perform the import command, and in particular the mapping used
 * to update inbound and outbound references for frontier elements between the main (parent) model and the imported
 * model.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
class ImportConfiguration
{
    private final EditingDomain domain;

    private final Resource controlledModelResource;

    private final Resource controlledDiagramsResource;

    private final URI externalModelUri;

    private final Resource externalModelResource;

    private final Resource externalDiagramsResource;

    private final Resource cacheResource;

    private final Collection<Resource> mainModelResources;

    private final Collection<Resource> controlledResources;

    private final Collection<Resource> externalResources;

    private final Set<FrontierElement> outboundFrontierElements;

    private final Set<FrontierElement> inboundFrontierElements;

    public ImportConfiguration(EObject controlledModelRoot, Diagrams controlledDiagramsRoot, URI externalModelUri, EditingDomain domain)
    {
        this.controlledModelResource = controlledModelRoot.eResource();
        this.controlledDiagramsResource = controlledDiagramsRoot.eResource();
        this.externalModelUri = externalModelUri;
        this.domain = domain;

        this.controlledResources = Arrays.asList(controlledModelResource, controlledDiagramsResource);
        this.mainModelResources = new ArrayList<Resource>(domain.getResourceSet().getResources());
        this.mainModelResources.removeAll(controlledResources);

        this.externalModelResource = domain.loadResource(externalModelUri.toString());
        this.externalDiagramsResource = domain.loadResource(ExportUtil.getExportedDiagramsURI(externalModelUri).toString());
        this.cacheResource = domain.loadResource(ExportUtil.getCacheURI(externalModelUri).toString());
        this.externalResources = Arrays.asList(externalModelResource, externalDiagramsResource);

        this.outboundFrontierElements = computeFrontierElements(mainModelResources, controlledResources, externalResources);
        this.inboundFrontierElements = computeFrontierElements(externalResources, Collections.singleton(cacheResource), mainModelResources);
    }

    public Set<FrontierElement> getOutboundFrontierElements()
    {
        return outboundFrontierElements;
    }

    public Set<FrontierElement> getInboundFrontierElements()
    {
        return inboundFrontierElements;
    }

    private Set<FrontierElement> computeFrontierElements(Collection<Resource> source, Collection<Resource> originalDestination, Collection<Resource> newDestination)
    {
        Set<FrontierElement> result = new HashSet<FrontierElement>();
        Map<EObject, List<Usage>> usages = computeReferences(source, originalDestination);
        for (EObject obj : usages.keySet())
        {
            FrontierElement elt = new FrontierElement(obj, usages.get(obj));
            findReplacementCandidates(elt, newDestination);
            if (!elt.getCandidates().isEmpty())
            {
                elt.setReplacement(elt.getCandidates().get(0)); // Initially select the first candidate
            }
            result.add(elt);
        }
        return result;
    }

    /**
     * Retrieve the original EObject from which an exported copy was initially made.
     */
    private void findReplacementCandidates(FrontierElement elt, Collection<Resource> scope)
    {
    	EObject obj = elt.getElement();
        List<EObject> perfectMatches = getPerfectMatches(obj, scope);
        if (perfectMatches.isEmpty())
        {
            elt.setCandidates(getCompatibleCandidates(elt, scope));
            elt.setPerfectMatch(false);
        }
        else
        {
            elt.setCandidates(perfectMatches);
            elt.setPerfectMatch(true);
        }
    }

    private List<EObject> getPerfectMatches(EObject obj, Collection<Resource> scope)
    {
        String id = getXmiId(obj);
        List<EObject> candidates = new ArrayList<EObject>();
        for (Resource res : scope)
        {
            if (!res.equals(obj.eResource()))
            {
                EObject candidate = ((XMLResource) res).getEObject(id);
                if (candidate != null && isCompatibleReplacement(obj, candidate))
                {
                    candidates.add(candidate);
                }
            }
        }
        return candidates;
    }
    
    private List<EObject> getCompatibleCandidates(FrontierElement elt, Collection<Resource> scope)
    {
    	EClassifier commonType = getMostGeneralCompatibleType(elt.getUsages());
    	 List<EObject> result = new ArrayList<EObject>();
         for (Resource res : scope)
         {
        	 for (EObject candidate : allProperContentsOf(res))
             {
                 if (commonType.isInstance(candidate))
                 {
                     result.add(candidate);
                 }
             }
         }
         return result;
    }
    
    private EClassifier getMostGeneralCompatibleType(Collection<Usage> usages) {
    	EClassifier result = EcorePackage.eINSTANCE.getEModelElement();
    	for (Usage usage : usages) {
			EClassifier type = usage.getRequiredType();
			if (result.getInstanceClass().isAssignableFrom(type.getInstanceClass()))
			{
				result = type;
			}
		}
		return result;
	}
    
    private boolean isCompatibleReplacement(EObject obj, EObject candidate)
    {
        return obj.eClass().isSuperTypeOf(candidate.eClass());
    }

    public URI getExportedModelUri()
    {
        return externalModelUri;
    }

    private void unloadResources()
    {
        ResourceSet rs = domain.getResourceSet();
        rs.getResources().removeAll(externalResources);
        rs.getResources().remove(cacheResource);
    }

    public void dispose()
    {
        unloadResources();
    }

    public Resource getControlledModelResource()
    {
        return controlledModelResource;
    }

    public Collection<Resource> getExportedResources()
    {
        return externalResources;
    }

    public Collection<Resource> getMainModelResources()
    {
        return mainModelResources;
    }

    public Resource getExportedModelResource()
    {
        return externalModelResource;
    }

    public Resource getExportedDiagramsResource()
    {
        return externalDiagramsResource;
    }

    public Resource getControlledDiagramsResource()
    {
        return controlledDiagramsResource;
    }

    /**
     * Finds all the cross-resource usages from an element in one of the {@code source} resources to an element in one
     * of the {@code Destination} resource.
     */
    private Map<EObject, List<Usage>> computeReferences(Collection<Resource> source, Collection<Resource> destination)
    {
        Map<EObject, List<Usage>> result = new HashMap<EObject, List<Usage>>();
        for (Resource resource : source)
        {
            for (EObject obj : allProperContentsOf(resource))
            {
                collectExternalReferences(obj, destination, result);
            }
        }
        return result;
    }

    /**
     * Finds all the direct references of an EObject which point to an element in the specified destination resources
     * and adds them to the specified set of {@link Usage}.
     * 
     * @param source the source object from which to look for references.
     * @param destination the target resources to consider.
     * @param usages the collection where the detected references will be added.
     */
    private void collectExternalReferences(EObject source, Collection<Resource> destination, Map<EObject, List<Usage>> usages)
    {
        // 1. Usages through reference features
        for (EReference feature : source.eClass().getEAllReferences())
        {
            Object value = source.eGet(feature);
            if (value instanceof EObject)
            {
                EObject target = (EObject) value;
                if (destination.contains(target.eResource()) && !feature.isDerived())
                {
                    Usage ref = new Usage(source, feature.getName(), target);
                    ref.setRequiredType(feature.getEType());
                    put(usages, ref.getTarget(), ref);
                }
            }
            else if (value instanceof EList< ? >)
            {
                for (Object o : (EList< ? >) value)
                {
                    if (o instanceof EObject)
                    {
                        EObject target = (EObject) o;
                        if (destination.contains(target.eResource()) && !feature.isDerived())
                        {
                            Usage ref = new Usage(source, feature.getName(), (EObject) target);
                            ref.setRequiredType(feature.getEType());
                            put(usages, ref.getTarget(), ref);
                        }
                    }
                }
            }
        }

        // 2. Usage through EAnnotations
        if (source instanceof EModelElement)
        {
            for (EAnnotation annotation : ((EModelElement) source).getEAnnotations())
            {
                collectExternalReferences(annotation, destination, usages);
            }
        }

        // 3. Usage through EAnnotation references
        if (source instanceof EAnnotation)
        {
            for (EObject target : ((EAnnotation) source).getReferences())
            {
                if (destination.contains(target.eResource()))
                {
                    Usage ref = new Usage(source, "EAnnotation " + ((EAnnotation) source).getSource(), target);
                    ref.setRequiredType(EcorePackage.eINSTANCE.getEModelElement());
                    put(usages, ref.getTarget(), ref);
                }
            }
        }
    }

    private <K, V> void put(Map<K, List<V>> map, K key, V value)
    {
        if (!map.containsKey(key))
        {
            map.put(key, new ArrayList<V>());
        }
        map.get(key).add(value);
    }
}
