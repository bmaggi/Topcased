/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * Copyright (c) 2012 Airbus
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies)
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Pierre Gaufillet (Airbus) - General purpose references view
 *
 * $Id: EModelElementContentProvider.java,v 1.4 2012/07/26 05:38:10 gaufille Exp $
 **********************************************************************/

package org.topcased.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.SemanticModelBridge;

/**
 * Returns references to an EModelElement and the associated StructuralFeatures
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class EModelElementContentProvider implements ITreeContentProvider
{

    private Map<Resource, List<WrappedEModelElement>> subtrees;

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
     */
    public Object[] getChildren(Object element)
    {
        if (element instanceof Resource)
        {
            Resource resource = (Resource) element;
            return subtrees.get(resource).toArray();
        }
        return new Object[0];
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
     */
    public Object getParent(Object element)
    {
        return null;
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
     */
    public boolean hasChildren(Object element)
    {
        return element instanceof Resource;
    }

    /**
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements(Object inputElement)
    {
        if (inputElement instanceof EModelElement)
        {
            EModelElement eModelElement = (EModelElement) inputElement;
            List<Resource> result = new ArrayList<Resource>();
            // Reset subtrees
            subtrees = new HashMap<Resource, List<WrappedEModelElement>>();

            ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(eModelElement);
            if (adapter == null)
            {
                adapter = new ECrossReferenceAdapter();
            }
            for (EStructuralFeature.Setting setting : adapter.getInverseReferences(eModelElement, true))
            {
                EObject eObject = setting.getEObject();
                if (eObject instanceof SemanticModelBridge || eObject instanceof DiagramElement)
                {
                    // TODO Manage the case of GMF and Papyrus Diagrams
                    while ((eObject != null) && !(eObject instanceof Diagram))
                    {
                        eObject = eObject.eContainer();
                    }

                    // Reject references to a diagram by one of its children as they always share the same resource
                    if (eObject != null && eObject != inputElement)
                    {
                        Resource resource = eObject.eResource();
                        if (!result.contains(resource))
                        {
                            // Add a list of children for this new resource
                            result.add(resource);
                            subtrees.put(resource, new ArrayList<WrappedEModelElement>());
                        }
                        Diagram diagram = (Diagram) eObject;
                        if (!isContained(subtrees.get(resource), diagram))
                        {
                            // We need to wrap the EModelElement to avoid an infinite loop
                            // for self references
                            subtrees.get(resource).add(new WrappedEModelElement(diagram));
                        }
                    }
                }
                else if (eObject instanceof EModelElement)
                {
                    Resource resource = eObject.eResource();
                    if (!result.contains(resource))
                    {
                        // Add a list of children for this new resource
                        result.add(resource);
                        subtrees.put(resource, new ArrayList<WrappedEModelElement>());
                    }
                    EModelElement eModelElement2 = (EModelElement) eObject;
                    if (!isContained(subtrees.get(resource), eModelElement2))
                    {
                        // We need to wrap the EModelElement to avoid an infinite loop
                        // for self references
                        subtrees.get(resource).add(new WrappedEModelElement(eModelElement2));
                    }
                }
            }
            return result.toArray();
        }
        return new Object[0];
    }

    /**
     * Search whether the given EModelElement is already wrapped into a WrappedEModelElement in the given list.
     * 
     * @param l a list of WrappedEModelElement
     * @param eModelElement the EModelElement to look for
     * @return true whether the given EModelElement is already wrapped into a WrappedEModelElement
     */
    private boolean isContained(List< ? > l, EModelElement eModelElement)
    {
        boolean found = false;
        Iterator< ? > it = l.iterator();
        while (it.hasNext() && !found)
        {
            Object contained = it.next();
            if (contained instanceof WrappedEModelElement)
            {
                WrappedEModelElement containedWEME = (WrappedEModelElement) contained;
                if (containedWEME.getWrappedEModelElement().equals(eModelElement))
                {
                    found = true;
                }
            }
            else if (contained instanceof EModelElement)
            {
                EModelElement containedEME = (EModelElement) contained;
                if (containedEME.equals(eModelElement))
                {
                    found = true;
                }
            }
        }
        return found;
    }

    /**
     * @see org.eclipse.jface.viewers.IContentProvider#dispose()
     */
    public void dispose()
    {
        // Do nothing
    }

    /**
     * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object,
     *      java.lang.Object)
     */
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
    {
    }

    /**
     * Define a wrapper for an EModelElement. This is used to distinguish the current selected EModelElement (from which
     * we are searching EReferences) from the same EModelElement that may be represented in the view in the case of a
     * self reference.
     */
    protected class WrappedEModelElement
    {

        private EModelElement wrappedEModelElement;

        /**
         * Constructor
         * 
         * @param eModelElementToWrap
         */
        public WrappedEModelElement(EModelElement eModelElementToWrap)
        {
            this.wrappedEModelElement = eModelElementToWrap;
        }

        /**
         * @return the wrappedEModelElement
         */
        public EModelElement getWrappedEModelElement()
        {
            return wrappedEModelElement;
        }
    }

}
