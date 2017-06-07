/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package org.topcased.modeler.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditDomain;
import org.topcased.modeler.utils.SourceTargetData;
import org.topcased.modeler.utils.Utils;

/**
 * This commands sets a reference of a node to the given edge
 * 
 * @Created 22 janv. 07
 * 
 * @author <a href="mailto:alfredo@anyware-tech.com">Jose Alfredo SERRANO</a>
 * 
 */
public abstract class ReconnectEdgeToNodeCommand extends ReconnectGraphEdgeCommand
{
    /** The name of the feature referencing the node */
    private String featureName;
    
    /** The name of the feature containing the edge */
    private String containerRef;
    
    /** The container that has hold the edge */
    private EObject oldContainer;
    
    /** The type of containment */
    private int commandType;
    
    /** Sais whether the container has been change or not */
    private boolean hasChangedContainer = false;
    
    /** The GEF edit domain (sometimes not necessary) */
    protected EditDomain editDomain;
    
    /**
     * @param domain
     * @param connection
     */
    public ReconnectEdgeToNodeCommand(ConnectionEditPart connection, String featureName)
    {
        super(connection);
        this.featureName = featureName;
    }

    /**
     * @param domain
     * @param connection
     * @param needModelUpdate
     */
    public ReconnectEdgeToNodeCommand(EditDomain domain, ConnectionEditPart connection, String featureName, boolean needModelUpdate)
    {
        super(connection, needModelUpdate);
        this.featureName = featureName;
        editDomain = domain;
    }

    /**
     * @see org.topcased.modeler.commands.ReconnectGraphEdgeCommand#redoModel()
     */
    protected void redoModel()
    {
        EObject toUpdate = getObjectToUpdate();
        EObject newReference = Utils.getElement(getNewElement());
        EObject oldReference = Utils.getElement(getOldElement());
        
        EStructuralFeature sourceFeature = toUpdate.eClass().getEStructuralFeature(featureName);
        if (sourceFeature.isChangeable())
        {
            if (sourceFeature.isMany())
            {
                EList<EObject> sourceList = Utils.getOwnerList(toUpdate, sourceFeature);
                Collection<EObject> newValue = new ArrayList<EObject>();
                if (sourceList != null)
                {
                    newValue.addAll(sourceList);
                }
                newValue.remove(oldReference);
                newValue.add(newReference);
                toUpdate.eSet(sourceFeature, newValue);
            }
            else
            {
                toUpdate.eSet(sourceFeature, newReference);
            }
        }
        
        doContainer(newReference, toUpdate);
    }

    /**
     * @see org.topcased.modeler.commands.ReconnectGraphEdgeCommand#undoModel()
     */
    protected void undoModel()
    {
        EObject updatedObject = getObjectToUpdate();
        EObject newReference = Utils.getElement(getNewElement());
        EObject oldReference = Utils.getElement(getOldElement());
        
        EStructuralFeature sourceFeature = updatedObject.eClass().getEStructuralFeature(featureName);
        if (sourceFeature.isChangeable())
        {
            if (sourceFeature.isMany())
            {
                EList<EObject> sourceList = Utils.getOwnerList(updatedObject, sourceFeature);
                Collection<EObject> newValue = new ArrayList<EObject>();
                if (sourceList != null)
                {
                    newValue.addAll(sourceList);
                }
                newValue.remove(newReference);
                newValue.add(oldReference);
                updatedObject.eSet(sourceFeature, newValue);
            }
            else
            {
                updatedObject.eSet(sourceFeature, oldReference);
            }
        }
        
        undoContainer(updatedObject);
    }
    
    /**
     * Keeps a trace of the container's feature
     * 
     * @param reference The containers feature name
     * @param commandType the type of containment
     * 
     * @see SourceTargetData#NONE
     * @see SourceTargetData#DIAGRAM
     * @see SourceTargetData#SOURCE
     * @see SourceTargetData#SOURCE_CONTAINER
     * @see SourceTargetData#TARGET
     * @see SourceTargetData#TARGET_CONTAINER
     */
    public void setContainerRef(String reference, int commandType)
    {
        containerRef = reference;
        this.commandType = commandType;
    }
    
    /**
     * Sets the object to update within the same container as the owner
     * 
     * @param owner The owner which has a reference to the object to update
     * @param toUpdate The object sharing the same container as the owner
     */
    protected void doContainer(EObject owner, EObject toUpdate)
    {
        if (owner != null && containerRef != null)
        {
            EObject newContainer = getContainer(owner);
            EStructuralFeature feature = newContainer.eClass().getEStructuralFeature(containerRef);
            oldContainer = toUpdate.eContainer();
            if (feature.isMany())
            {
                EList<EObject> containerList = Utils.getOwnerList(newContainer, feature);
                if (containerList != null)
                {
                    hasChangedContainer = containerList.add(toUpdate);
                }
            }
            else
            {
                newContainer.eSet(feature, toUpdate);
                hasChangedContainer = true;
            }
        }
    }
    
    /**
     * Sets back the old conatiner to the given object
     * 
     * @param updated The object to be placed inside its ancient container
     */
    protected void undoContainer(EObject updated)
    {
        if (oldContainer != null && hasChangedContainer)
        {
            EStructuralFeature feature = oldContainer.eClass().getEStructuralFeature(containerRef);
            if (feature.isMany())
            {
                EList<EObject> containerList = Utils.getOwnerList(oldContainer, feature);
                if (containerList != null)
                {
                    containerList.add(updated);
                }
            }
            else
            {
                oldContainer.eSet(feature, updated);
            }
        }
    }
    
    ////////////////// HELPERS ////////////////////
    ///////////////////////////////////////////////
    
    private EObject getContainer(EObject theContainer)
    {
        if (commandType == SourceTargetData.SOURCE || commandType == SourceTargetData.TARGET)
        {
            return theContainer;
        }
        if (commandType == SourceTargetData.SOURCE_CONTAINER || commandType == SourceTargetData.TARGET_CONTAINER)
        {
            return theContainer.eContainer();
        }
        return null;
    }
    
    ////////////////// ABSTRACT METHODS /////////////////
    /////////////////////////////////////////////////////
    
    /**
     * Returns the model object to be updated with changes
     * 
     * @return The object to be updated
     */
    protected abstract EObject getObjectToUpdate();
}
