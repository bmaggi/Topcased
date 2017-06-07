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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.topcased.modeler.SemanticDependenciesDetector;
import org.topcased.modeler.diagrams.model.Diagrams;

/**
 * This class is used to determine the contents of the cache resource when a model is exported.
 * <p>
 * It supports three kinds of elements:
 * <ul>
 * <li><em>strict</em> dependencies, which are automatically computed and include exactly the elements required for
 * loading the exported model. This is computed in a completely generic way by following references at the EMF level.</li>
 * <li><em>semantic</em> dependencies, which include model elements which are not required from the EMF point of view,
 * but without which the semantics of the exported model is corrupted/incomplete. This depends on the meta-model and
 * uses implementations of the <code>org.topcased.modeler.semanticDependencies</code> extension point. See
 * {@link SemanticDependenciesDetector}.</li>
 * <li><em>user elements</em> which are manually added by the user in the export UI.</li>
 * </ul>
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
class CacheContentsSpecification
{
    /*
     * IMPLEMENTATION NOTE
     * 
     * The current implementation tries to be correct before being efficient. There are probably optimizations to make,
     * but they will wait until after we get it working reliably. In particular it might be possible to cut the search
     * for indirect dependencies earlier, which could make a huge difference in big models.
     */

    /**
     * The root element of the controlled model to export.
     */
    private final EObject controlledModelRoot;

    /**
     * The detector to use to identify semantic dependencies.
     */
    private final SemanticDependenciesDetector semanticDetector;

    /**
     * The minimal set of EObjet containment trees which include all the strict dependencies required by the model and
     * diagrams to export.
     */
    private Set<EObject> strictDependencies;

    /**
     * The minimal set of EObjet containment trees which include all the semantic dependencies required by the model and
     * diagrams to export.
     */
    private Set<EObject> semanticDependencies;

    /**
     * The minimal set of EObjet containment trees which include all the elements explicitly added by the user.
     */
    private Set<EObject> userElements = new HashSet<EObject>();

    /**
     * The resources which contain the elements to export (model elements and diagrams).
     */
    private final Collection<Resource> scope;

    public CacheContentsSpecification(EObject controlledRoot, Diagrams controlledDiagrams, SemanticDependenciesDetector detector)
    {
        this.controlledModelRoot = controlledRoot;
        this.semanticDetector = detector;
        this.scope = Arrays.asList(controlledRoot.eResource(), controlledDiagrams.eResource());
    }

    public EObject getRootElement()
    {
        return controlledModelRoot;
    }

    public Set<EObject> getAllDependencyRoots()
    {
        // We only compute the dependencies of the user-added elements here at the end.
        for (EObject obj : userElements)
        {
            findAllExternalDependencies(obj);
        }
        strictDependencies = computeMinimumRoots(strictDependencies);
        semanticDependencies = computeMinimumRoots(semanticDependencies);

        Set<EObject> result = new HashSet<EObject>();
        result.addAll(strictDependencies);
        result.addAll(semanticDependencies);
        result.addAll(userElements);

        // Don't forget to minimize the result.
        return Collections.unmodifiableSet(computeMinimumRoots(result));
    }

    public Collection<EObject> getStrictDependencies()
    {
        if (strictDependencies == null)
        {
            computeDependencies();
        }
        return Collections.unmodifiableCollection(strictDependencies);
    }

    public Collection<EObject> getSemanticDependencies()
    {
        if (semanticDependencies == null)
        {
            computeDependencies();
        }
        return Collections.unmodifiableCollection(semanticDependencies);
    }

    public Collection<EObject> getUserElements()
    {
        return Collections.unmodifiableCollection(userElements);
    }

    public boolean isValidUserElement(EObject elt)
    {
        if (isInternal(elt))
        {
            // The element is part of the model to export, it can't be put in the cache.
            return false;
        }
        else if (EcoreUtil.isAncestor(strictDependencies, elt) || EcoreUtil.isAncestor(semanticDependencies, elt))
        {
            // The element is already included (directly or not) in the automatically computed dependencies.
            return false;
        }
        else
        {
            // Also check that the element if not an ancestor of an existing root.
            for (EObject root : strictDependencies)
            {
                if (EcoreUtil.isAncestor(elt, root))
                {
                    return false;
                }
            }
            for (EObject root : semanticDependencies)
            {
                if (EcoreUtil.isAncestor(elt, root))
                {
                    return false;
                }
            }

            return true;
        }
    }

    public void addUserElement(EObject elt)
    {
        if (isValidUserElement(elt) && !EcoreUtil.isAncestor(userElements, elt))
        {
            userElements.add(elt);
            userElements = computeMinimumRoots(userElements);
        }
    }

    public boolean removeUserElement(EObject elt)
    {
        return userElements.remove(elt);
    }

    /**
     * Compute the strict and semantic dependencies for all (proper) elements of the resources in scope.
     */
    private void computeDependencies()
    {
        strictDependencies = new HashSet<EObject>();
        semanticDependencies = new HashSet<EObject>();
        for (Resource r : scope)
        {
            for (EObject obj : allProperContentsOf(r))
            {
                findAllExternalDependencies(obj);
            }
        }
        strictDependencies = computeMinimumRoots(strictDependencies);
        semanticDependencies = computeMinimumRoots(semanticDependencies);
    }

    private void findAllExternalDependencies(EObject obj)
    {
        findAllDependencies(obj);
        removeInternalElements(strictDependencies);
        removeInternalElements(semanticDependencies);
    }

    private void removeInternalElements(Collection<EObject> elements)
    {
        for (Iterator<EObject> iter = elements.iterator(); iter.hasNext();)
        {
            EObject dep = iter.next();
            if (isInternal(dep))
            {
                iter.remove();
            }
        }
    }

    /**
     * Tests whether an object is in the scope of the (initially controlled) model to export. Only external dependencies
     * are put in the cache, as the "part" files will contain (copies of) the others.
     */
    private boolean isInternal(EObject obj)
    {
        if (obj == null)
        {
            return false;
        }
        else
        {
            Resource res = obj.eResource();
            if (res == null || !scope.contains(res))
            {
                return false;
            }
            else if (res.equals(this.controlledModelRoot.eResource()))
            {
                // Even is the object is from the controlled resource, we consider it "internal" only if it is inside
                // the sub-model being exported. It can be in the controlled resource but outside, for example inside
                // another root element in the resource. This happens in particular with UML stereotypes when they are
                // applied after the control operation and after an import. Considering these stereotypes internal would
                // remove them from the (re-)export in those cases.
                return EcoreUtil.isAncestor(controlledModelRoot, obj);
            }
            else
            {
                return true;
            }
        }
    }

    /**
     * Find all the direct and indirect, strict and semantic dependencies of an EObject. Strict and semantic
     * dependencies are kept separately (resp. in {@link #strictDependencies} and {@link #semanticDependencies}).
     */
    private void findAllDependencies(EObject obj)
    {
        Set<EObject> startingPoints = new HashSet<EObject>();
        startingPoints.add(obj);

        while (!startingPoints.isEmpty())
        {
            Set<EObject> newStrictDependencies = new HashSet<EObject>();
            Set<EObject> newSemanticDependencies = new HashSet<EObject>();

            for (EObject startPoint : startingPoints)
            {
                // First search for new strict dependencies
                for (EObject dep : findAllDirectDependenciesOf(startPoint))
                {
                    if (isValidNewDependency(dep, startPoint))
                    {
                        newStrictDependencies.add(dep);
                    }
                }
                // Then search separately for semantic ones
                for (EObject dep : semanticDetector.getSemanticDependencies(startPoint))
                {
                    if (isValidNewDependency(dep, startPoint))
                    {
                        newSemanticDependencies.add(dep);
                    }
                }
            }

            strictDependencies.addAll(newStrictDependencies);
            semanticDependencies.addAll(newSemanticDependencies);

            startingPoints.clear();
            // TODO We could probably only consider external elements here as new starting points.
            startingPoints.addAll(newStrictDependencies);
            startingPoints.addAll(newSemanticDependencies);
        }
    }

    private boolean isValidNewDependency(EObject dep, EObject source)
    {
        if (dep == source.eContainer())
        {
            // Don't consider the container as a dependency, or otherwise by transitivity we would pull the whole
            // model.
            return false;
        }
        else if (ExportUtil.isSystemResource(dep.eResource()))
        {
            // Don't consider objects from "system" resources like the Ecore or UML meta-models.
            return false;
        }
        else if (strictDependencies.contains(dep) || semanticDependencies.contains(dep))
        {
            // Already seen.
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * Compute all the strict, direct dependencies of an EObject.
     */
    private Set<EObject> findAllDirectDependenciesOf(EObject obj)
    {
        Set<EObject> deps = new HashSet<EObject>();

        // 1. Dependencies through reference features
        for (EReference feature : obj.eClass().getEAllReferences())
        {
            Object value = obj.eGet(feature);
            if (value instanceof EObject)
            {
                deps.add((EObject) value);
            }
            else if (value instanceof EList< ? >)
            {
                for (Object o : (EList< ? >) value)
                {
                    if (o instanceof EObject)
                    {
                        deps.add((EObject) o);
                    }
                }
            }
        }

        // 2. Dependencies through EAnnotations
        if (obj instanceof EModelElement)
        {
            for (EAnnotation annotation : ((EModelElement) obj).getEAnnotations())
            {
                deps.addAll(findAllDirectDependenciesOf(annotation));
            }
        }

        // 3. Dependencies through EAnnotation references
        if (obj instanceof EAnnotation)
        {
            deps.addAll(((EAnnotation) obj).getReferences());
        }

        // Don't count the object itself as a dependency, even if it points to itself.
        deps.remove(obj);
        return deps;
    }

    /**
     * Compute the minimal non-overlapping sub-model roots which include all these dependencies.
     */
    private Set<EObject> computeMinimumRoots(Set<EObject> externalDependencies)
    {
        Set<EObject> dependenciesRoots = new HashSet<EObject>();
        for (EObject object : externalDependencies)
        {
            boolean newIndependentRoot = true;

            for (EObject root : new HashSet<EObject>(dependenciesRoots)) // Avoid ConcurrentModificationExceptions
            {
                if (EcoreUtil.isAncestor(root, object))
                {
                    // The dependency is already included by an existing root.
                    newIndependentRoot = false;
                    break;
                }
                else if (EcoreUtil.isAncestor(object, root))
                {
                    // The dependency is more general than the root.
                    // Make it the new root.
                    dependenciesRoots.remove(root);
                    dependenciesRoots.add(object);
                    newIndependentRoot = false;
                    // Continue, the new object may subsume several of the previous roots.
                }
            }

            if (newIndependentRoot)
            {
                // The dependency is a new independent root.
                dependenciesRoots.add(object);
            }
        }
        return dependenciesRoots;
    }
}
