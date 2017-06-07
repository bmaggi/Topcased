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
package org.topcased.modeler.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditDomain;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.utils.SourceTargetData;
import org.topcased.modeler.utils.Utils;

/**
 * Handle edge creation<br>
 * <br>
 * creation : 15 juin 2005
 * 
 * @author <a href="mailto:mathieu.garcia@anyware-tech.com">Mathieu Garcia</a>
 */
public abstract class CreateTypedEdgeCommand extends CreateGraphEdgeCommand
{
    /** Source target data */
    private SourceTargetData srcTgtData;

    private EObject oldContainer;
    
    private EStructuralFeature oldContainingFeature;
    
    /**
     * The constructor
     * 
     * @param domain the edit domain
     * @param newObj the edge
     * @param src the graph element source
     * @param needModelUpdate
     */
    public CreateTypedEdgeCommand(EditDomain domain, GraphEdge newObj, GraphElement src, boolean needModelUpdate)
    {
        super(domain, newObj, src, needModelUpdate);
    }

    /**
     * Update the source target data
     * 
     * @param data
     */
    public void setSourceTargetData(SourceTargetData data)
    {
        srcTgtData = data;
    }

    /**
     * Retrieve the container EObject from the container Type parameter
     * 
     * @return the EObject
     */
    protected EObject getContainerEObject()
    {
        switch (srcTgtData.getContainerType())
        {
            case SourceTargetData.SOURCE:
                return Utils.getElement(getSource());
            case SourceTargetData.SOURCE_CONTAINER:
                return getContainer(Utils.getElement((GraphElement) getSource().eContainer()));
            case SourceTargetData.DIAGRAM:
                return Utils.getDiagramModelObject(getSource());
            case SourceTargetData.TARGET:
                return Utils.getElement(getTarget());
            case SourceTargetData.TARGET_CONTAINER:
                return getContainer(Utils.getElement((GraphElement) getTarget().eContainer()));
            default:
                return null;
        }
    }

    /**
     * @see CreateGraphEdgeCommand#redoModel()
     */
    protected void redoModel()
    {
        EObject containerEObject = getContainerEObject();

        // Handle the storing of the edge
        if (containerEObject != null && !"".equals(srcTgtData.getContainerRef()))
        {
            EStructuralFeature feature = containerEObject.eClass().getEStructuralFeature(srcTgtData.getContainerRef());
            if (feature.isMany())
            {
                EList<EObject> containerList = Utils.getOwnerList(containerEObject, feature);
                if (containerList != null)
                {
                    containerList.add(Utils.getElement(getEdge()));
                }
            }
            else
            {
                containerEObject.eSet(feature, Utils.getElement(getEdge()));
            }
        }

        setReference(Utils.getElement(getEdge()), Utils.getElement(getSource()), srcTgtData.getRefEdgeToSource());
        setReference(Utils.getElement(getEdge()), Utils.getElement(getTarget()), srcTgtData.getRefEdgeToTarget());
        setReference(Utils.getElement(getSource()), Utils.getElement(getEdge()), srcTgtData.getRefSourceToEdge());
        setReference(Utils.getElement(getSource()), Utils.getElement(getTarget()), srcTgtData.getRefSourceToTarget());
        setReference(Utils.getElement(getTarget()), Utils.getElement(getEdge()), srcTgtData.getRefTargetToEdge());
        setReference(Utils.getElement(getTarget()), Utils.getElement(getSource()), srcTgtData.getRefTargetToSource());

        if (containerEObject != null && !"".equals(srcTgtData.getContainerRef()))
        {
            initName(containerEObject);
        }
    }

    /**
     * Update the EStructuralFeature of an EObject to another EObject
     * 
     * @param objectToUpdate the EObject to update
     * @param objectReferenced the EObject to reference
     * @param featureName the EStructuralFeature that should support the reference
     */
    protected void setReference(EObject objectToUpdate, EObject objectReferenced, String featureName)
    {
        if (featureName != null && !"".equals(featureName))
        {
            EStructuralFeature feature = objectToUpdate.eClass().getEStructuralFeature(featureName);
            if (feature.isChangeable())
            {
                storeReferenceContainer(feature, objectReferenced);
                if (feature.isMany())
                {
                    EList<EObject> sourceList = Utils.getOwnerList(objectToUpdate, feature);
                    Collection<EObject> newValue = new ArrayList<EObject>();
                    if (sourceList != null)
                    {
                        newValue.addAll(sourceList);
                    }
                    newValue.add(objectReferenced);
                    objectToUpdate.eSet(feature, newValue);
                }
                else
                {
                    objectToUpdate.eSet(feature, objectReferenced);
                }
            }
        }
    }

    /**
     * @see CreateGraphEdgeCommand#undoModel()
     */
    protected void undoModel()
    {
        EObject containerEObject = getContainerEObject();

        // Remove the edge from the container
        if (containerEObject != null && srcTgtData.getContainerRef() != null)
        {
            EStructuralFeature feature = containerEObject.eClass().getEStructuralFeature(srcTgtData.getContainerRef());
            if (feature.isMany())
            {
                EList<EObject> containerList = Utils.getOwnerList(containerEObject, feature);
                if (containerList != null)
                {
                    containerList.remove(Utils.getElement(getEdge()));
                }
            }
            else
            {
                containerEObject.eUnset(feature);
            }
        }

        unsetReference(Utils.getElement(getEdge()), Utils.getElement(getSource()), srcTgtData.getRefEdgeToSource());
        unsetReference(Utils.getElement(getEdge()), Utils.getElement(getTarget()), srcTgtData.getRefEdgeToTarget());
        unsetReference(Utils.getElement(getSource()), Utils.getElement(getEdge()), srcTgtData.getRefSourceToEdge());
        unsetReference(Utils.getElement(getSource()), Utils.getElement(getTarget()), srcTgtData.getRefSourceToTarget());
        unsetReference(Utils.getElement(getTarget()), Utils.getElement(getEdge()), srcTgtData.getRefTargetToEdge());
        unsetReference(Utils.getElement(getTarget()), Utils.getElement(getSource()), srcTgtData.getRefTargetToSource());
    }

    /**
     * Unset the EStructuralFeature of an EObject that reference another EObject
     * 
     * @param objectUpdated the EObject previously
     * @param objectReferenced the EObject referenced
     * @param featureName the EStructuralFeature that support the reference
     */
    protected void unsetReference(EObject objectUpdated, EObject objectReferenced, String featureName)
    {
        if (featureName != null && !"".equals(featureName))
        {
            EStructuralFeature sourceFeature = objectUpdated.eClass().getEStructuralFeature(featureName);
            if (sourceFeature.isMany())
            {
                EList<EObject> sourceList = Utils.getOwnerList(objectUpdated, sourceFeature);
                Collection<EObject> newValue = new ArrayList<EObject>();
                if (sourceList != null)
                {
                    newValue.addAll(sourceList);
                }
                newValue.remove(objectReferenced);
                objectUpdated.eSet(sourceFeature, newValue);
            }
            else
            {
                objectUpdated.eUnset(sourceFeature);
            }
            restoreReferenceContainer(objectReferenced);
        }
    }
    
    private EObject getContainer(EObject eObject)
    {
        EStructuralFeature feature = eObject.eClass().getEStructuralFeature(srcTgtData.getContainerRef());
        if (feature ==  null)
        {
            // When the container cannot host the object we look on the parent container
            EObject container = eObject.eContainer();
            return getContainer(container);
        }
        return eObject;
    }
    
    private void storeReferenceContainer(EStructuralFeature feature, EObject reference)
    {
        if (feature instanceof EReference)
        {
            EReference eReference = (EReference) feature;
            if (eReference.isContainment())
            {
                oldContainer = reference.eContainer();
                oldContainingFeature = reference.eContainmentFeature();
            }
        }
    }
    
    private void restoreReferenceContainer(EObject reference)
    {
        if (oldContainer != null)
        {
            if (oldContainingFeature.isMany())
            {
                EList<EObject> containerList = Utils.getOwnerList(oldContainer, oldContainingFeature);
                if (containerList != null)
                {
                    containerList.add(reference);
                }
            }
            else
            {
                oldContainer.eSet(oldContainingFeature, reference);
            }
        }
    }

    /**
     * @return the srcTgtData
     */
    public SourceTargetData getSrcTgtData()
    {
        return srcTgtData;
    }
}
