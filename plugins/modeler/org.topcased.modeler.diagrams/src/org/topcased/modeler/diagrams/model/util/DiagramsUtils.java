/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and implementation
 * eperico (Atos Origin) emilien.perico@atosorigin.com - add method findAllExistingDiagramForElement
 ******************************************************************************/
package org.topcased.modeler.diagrams.model.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.DiagramsFactory;
import org.topcased.modeler.diagrams.model.internal.DiagramsPlugin;

/**
 * A Helper class used to facilitate Diagrams management.<br>
 * 
 * Creation 6 oct. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @author <a href="mailto:tristan.faure@atosorigin.com">Tristan FAURE</a> Fix Bug #2853, to resolve problem we use
 *         EcoreUtil.equals instead of Object.equals
 */
public final class DiagramsUtils
{
    /**
     * Constructor
     */
    private DiagramsUtils()
    {
        // Do nothing
    }

    /**
     * Retrieve the root Diagrams model object
     * 
     * @param diagrams a Diagrams model object
     * @return the root model object of that Diagrams
     */
    public static Diagrams findRootDiagrams(Diagrams diagrams)
    {
        return diagrams.getParent() == null ? diagrams : findRootDiagrams(diagrams.getParent());
    }

    /**
     * Retrieve the root Diagram from a Diagrams element : we search in the hierarchy (subtree) of the Diagrams element.
     * 
     * @param diagrams the Diagrams where to search
     * @return the root Diagram if it exists, otherwise return null.
     */
    public static Diagram getRootDiagram(Diagrams diagrams)
    {
        if (diagrams != null)
        {
            if (!diagrams.getDiagrams().isEmpty())
            {
                // There is at least one Diagram inside the current Diagrams element.
                return diagrams.getDiagrams().get(0);
            }
            else
            {
                // We continue to explore the Diagrams subhierarchy
                for (Diagrams subdiagrams : diagrams.getSubdiagrams())
                {
                    // Check for the current "branch" whether a diagram was found
                    Diagram possibleDiagram = getRootDiagram(subdiagrams);
                    if (possibleDiagram != null)
                    {
                        return possibleDiagram;
                    }
                }
            }
        }

        return null;
    }

    /**
     * Return all the Diagram model objects that are defined in the Diagrams file. This method iterates recursively on
     * all the subDiagrams.
     * 
     * @param rootDiagrams the root Diagrams model object
     * @return List The list contents are of type org.topcased.modeler.di.model.Diagram.
     */
    public static List<Diagram> findAllDiagrams(Diagrams rootDiagrams)
    {
        List<Diagram> allDiagrams = new ArrayList<Diagram>();

        allDiagrams.addAll(rootDiagrams.getDiagrams());
        for (Diagrams subDiagrams : rootDiagrams.getSubdiagrams())
        {
            findAllDiagrams(subDiagrams, allDiagrams);
        }

        return allDiagrams;
    }

    private static void findAllDiagrams(Diagrams diagrams, List<Diagram> diagramsList)
    {
        diagramsList.addAll(diagrams.getDiagrams());
        for (Diagrams subDiagrams : diagrams.getSubdiagrams())
        {
            findAllDiagrams(subDiagrams, diagramsList);
        }
    }

    /**
     * This method return the list of Diagram model objects that are defined for a given EObject.<br>
     * These diagrams are contained by a single Diagrams model objects.
     * 
     * @param rootDiagrams the root Diagrams model object
     * @param modelObject the model object
     * @return List The list of the available Diagram model objects associated with the modelObject. Returns an empty
     *         list when none is defined.
     */
    public static List<Diagram> findAllExistingDiagram(Diagrams rootDiagrams, EObject modelObject)
    {
        if (rootDiagrams == null || modelObject == null)
        {
            return new ArrayList<Diagram>();
        }
        // If the Diagrams match with the corresponding eObject, then we return
        // the contained Diagram objects
        if (equals(modelObject, rootDiagrams.getModel()))
        {
            return rootDiagrams.getDiagrams();
        }
        CrossReferenceAdapter crossReferenceAdapter = CrossReferenceAdapter.getExistingDiagramsCrossReferenceAdapter(rootDiagrams);
        if (crossReferenceAdapter != null)
        {
            return crossReferenceAdapter.getDiagramsInverseReferences(modelObject);
        }
        else
        {
            // We check in the subDiagrams whether a Diagrams match
            for (Diagrams subdiagrams : rootDiagrams.getSubdiagrams())
            {
                // Recursive call of the method
                List<Diagram> tempList = findAllExistingDiagram(subdiagrams, modelObject);
                // Check whether a List of Diagram has been found and that is not
                // Empty
                if (!tempList.isEmpty())
                {
                    return tempList;
                }
            }
            return new ArrayList<Diagram>();
        }

        // return Collections.emptyList();
    }

    /**
     * This method return the list of Diagram of the first level that are defined for a given EObject.<br>
     * Retrieve the associated Diagrams for the specified modelObject
     * 
     * @param modelObject the model object
     * 
     * @return List The list of the available Diagram model objects associated with the modelObject. Returns an empty
     *         list when none is defined.
     */
    public static List<Diagram> findAllExistingDiagramForElement(EObject modelObject)
    {
        return findAllExistingDiagramForElement(modelObject, false);
    }

    /**
     * Search all the diagrams in the resource set. be careful with check all to true it can spent a lot of time
     * 
     * @param modelObject
     * @param checkAll
     * @return
     */
    public static List<Diagram> findAllExistingDiagramForElement(EObject modelObject, boolean checkAll)
    {
        Set<Diagram> existingDiagram = new HashSet<Diagram>();
        if (modelObject != null)
        {
            List<Diagrams> diagrams = new LinkedList<Diagrams>();
            if (!checkAll)
            {
                ResourceSet resourceSet = modelObject.eResource().getResourceSet();
                Resource diagramResource = resourceSet.getResource(URI.createURI(modelObject.eResource().getURI().toString().concat("di")), true);

                if (diagramResource != null && !diagramResource.getContents().isEmpty())
                {
                    EObject eObject = diagramResource.getContents().get(0);
                    if (eObject != null && eObject instanceof Diagrams)
                    {
                        diagrams.add((Diagrams) eObject);
                    }
                }
            }
            else
            {
                for (Resource r : modelObject.eResource().getResourceSet().getResources())
                {
                    if (!r.getContents().isEmpty() && r.getContents().get(0) instanceof Diagrams)
                    {
                        diagrams.add((Diagrams) r.getContents().get(0));
                    }
                }
            }
            for (Diagrams d : diagrams)
            {
                existingDiagram.addAll(findAllExistingDiagram(d, modelObject));
            }
        }
        return new ArrayList<Diagram>(existingDiagram);
    }

    public static boolean equals(EObject e1, EObject e2)
    {
        if (e1 == null || e2 == null)
        {
            return e1 == e2;
        }
        boolean result = (e1 == e2);
        if (!result)
        {
            Resource r1 = e1.eResource();
            Resource r2 = e2.eResource();
            if (r1 != null && r2 != null)
            {
                if (r1.getURI() != null && r1.getURI().equals(r2.getURI()))
                {
                    String fragment = r1.getURIFragment(e1);
                    result = (fragment != null && fragment.equals(r2.getURIFragment(e2)));
                }
            }
        }
        return result;
    }

    /**
     * This method returns the nearest Diagrams in the hierarchy that should contains a Diagram associated with the
     * given modelObject.<br>
     * If the Diagrams is associated with the exact type of the modelObject, then it should directly contains the
     * Diagram, otherwise it mean that a new Diagrams should be first created (and the children Diagrams should be then
     * moved into the newly created Diagrams).
     * 
     * @param rootDiagrams a Diagrams
     * @param modelObject the modelObject
     * @return the nearest Diagrams that should contains a Diagram associated with the given modelObject or null if not
     *         found.
     */
    public static Diagrams findNearestContainerDiagrams(Diagrams rootDiagrams, EObject modelObject)
    {
        if (equals(modelObject, rootDiagrams.getModel()))
        {
            return rootDiagrams;
        }
        else if (EcoreUtil.isAncestor(rootDiagrams.getModel(), modelObject))
        {
            Diagrams ancestorDiagrams = rootDiagrams;
            for (Diagrams subdiagrams : rootDiagrams.getSubdiagrams())
            {
                Diagrams diagrams = findNearestContainerDiagrams(subdiagrams, modelObject);
                if (diagrams != null)
                {
                    ancestorDiagrams = diagrams;
                }
            }
            return ancestorDiagrams;
        }
        return null;
    }

    /**
     * This method is used to update a Diagrams model to be compliant with the new Diagrams metamodel (nsURI=0.11).<br>
     * It first checks whether the Diagrams model is flattened (old version of the Diagrams metamodel) and create the
     * necessary Diagrams objects that transform the model into a hierarchical one.<br>
     * This method should be called before the opening of the Diagrams in the editor. It should then be removed in a
     * further version. (1.0 ?)
     * 
     * @param rootDiagrams the rootDiagrams
     * @deprecated Remove this in the 2.x release
     */
    @Deprecated
    public static void updateDI(Diagrams rootDiagrams)
    {
        // This is the list of the Diagram objects that are not contained by the
        // corresponding Diagrams object
        List<Diagram> diagramToMove = new ArrayList<Diagram>();

        // Check first whether the Diagrams belong to an old DI file
        for (Diagram currentDiagram : rootDiagrams.getDiagrams())
        {
            if (!equals(rootDiagrams.getModel(), (((EMFSemanticModelBridge) currentDiagram.getSemanticModel()).getElement())))
            {
                diagramToMove.add(currentDiagram);
            }
        }

        if (!diagramToMove.isEmpty())
        {
            // It appears that the Diagrams model was an old one. There we
            // update the Resource file to update it and create the appropriate
            // Diagrams objects
            for (Diagram currentDiagram : diagramToMove)
            {
                if (rootDiagrams.getModel() != ((EMFSemanticModelBridge) currentDiagram.getSemanticModel()).getElement())
                {
                    moveDiagram(rootDiagrams, currentDiagram);
                }
            }

            DiagramsPlugin.log("The Diagrams file has been updated on the load to be compliant with the 0.11.x version of Topcased.", IStatus.INFO);
        }
    }

    /**
     * Moves a diagram in another root diagrams.
     * 
     * @param rootDiagrams The root diagrams.
     * @param diagram The diagram to move.
     * @return the new Diagrams created, if one was required, or <code>null</code> otherwise.
     */
    public static Diagrams moveDiagram(Diagrams rootDiagrams, Diagram diagram)
    {
        EObject diagramEObject = ((EMFSemanticModelBridge) diagram.getSemanticModel()).getElement();

        Diagrams containerDiagrams = findNearestContainerDiagrams(rootDiagrams, diagramEObject);

        if (containerDiagrams == null)
        {
            // FIXME throw an exception (try to create a parent Diagrams)
            return null;
        }
        else if (!equals(diagramEObject, containerDiagrams.getModel()))
        {
            // The Diagrams object should be created
            Diagrams newDiagrams = DiagramsFactory.eINSTANCE.createDiagrams();
            newDiagrams.setModel(diagramEObject);
            newDiagrams.getDiagrams().add(diagram);

            // Move also Subddiagrams that are in the subHierarchy of the
            // Diagram that is moved
            List<Diagrams> subdiagramsToMove = new ArrayList<Diagrams>();
            for (Diagrams subdiagrams : containerDiagrams.getSubdiagrams())
            {
                if (EcoreUtil.isAncestor(diagramEObject, subdiagrams.getModel()))
                {
                    subdiagramsToMove.add(subdiagrams);
                }
            }
            for (Diagrams subdiagrams : subdiagramsToMove)
            {
                subdiagrams.setParent(newDiagrams);
            }

            newDiagrams.setParent(containerDiagrams);
            return newDiagrams;
        }
        else
        {
            // add the Diagram in the existing Diagrams object
            containerDiagrams.getDiagrams().add(diagram);
            return null;
        }
    }

    /**
     * This method is used to retrieve the first GraphElement that both contains (directly or not) the two passed
     * GraphElements. This method is particularly used to retrieve the first GraphElement that should contains an Edge
     * between two GraphElements : we assume that this is the first parent ancestor common to the two GraphElements.
     * 
     * @param elt1 The first GraphElement
     * @param elt2 The second GraphElement
     * @return the nearest common ancestor
     */
    public static GraphElement getNearestCommonParentGraphElement(GraphElement elt1, GraphElement elt2)
    {
        // Check whether the elt1 is the Diagram
        if (elt1.getContainer() == null)
        {
            return elt1;
        }

        // Check whether the elt2 is the Diagram
        if (elt2.getContainer() == null)
        {
            return elt2;
        }

        List<GraphElement> containersElt1List = new ArrayList<GraphElement>();
        getContainerList(elt1, containersElt1List);
        List<GraphElement> containersElt2List = new ArrayList<GraphElement>();
        getContainerList(elt2, containersElt2List);

        for (GraphElement currentContainerToCheck : containersElt1List)
        {
            for (GraphElement currentContainer : containersElt2List)
            {
                if (equals(currentContainerToCheck, currentContainer))
                {
                    return currentContainer;
                }
            }
        }
        return null;
    }

    private static void getContainerList(GraphElement elt, List<GraphElement> list)
    {
        if (elt.getContainer() != null)
        {
            list.add(elt.getContainer());
            getContainerList(elt.getContainer(), list);
        }
    }
}