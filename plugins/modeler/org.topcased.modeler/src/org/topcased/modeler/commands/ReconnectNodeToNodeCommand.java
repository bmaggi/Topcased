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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.ConnectionEditPart;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.utils.Utils;

/**
 * This abstract command may be used when the edge is not contained by
 * any {@link EObject}. It means the edge virtually represents a reference
 * from one node to another.
 * 
 * @Created 19 janv. 07
 * 
 * @author <a href="mailto:alfredo@anyware-tech.com">Jose Alfredo SERRANO</a>
 * 
 */
public abstract class ReconnectNodeToNodeCommand extends ReconnectGraphEdgeCommand
{
    /** This means the user is reconnecting the SOURCE. Its value is 0*/
    public static int SOURCE = 0;
    
    /** This means the user is reconnecting the TARGET. Its value is 1 */
    public static int TARGET = 1;
    
    /** The EObject feature to update */
    private String featureName;
    
    /** The direction of the edge*/
    private int reconnectedEnd = SOURCE;
    
    /** The old container of the reference if the feature is containment */
    private EObject oldContainer;
    
    /** The EObject to update */
    private EObject toUpdate;
    
    /** The containment feature that holds the reference in the old container */
    private EStructuralFeature oldContainingFeature;
    
    ///////////////// CONSTRUCTORS ///////////////////
    //////////////////////////////////////////////////
    
    /**
     * Constructor.
     * User must specify the edge end he is reconnecting by using {@link #SOURCE} to 
     * reconnect the source and {@link #TARGET} to reconnect the target. Another value
     * (a value higher than 1) will make the command to be ignored
     * 
     * @param domain
     * @param connection
     * @param featureName
     * @param reconnectedEnd
     */
    public ReconnectNodeToNodeCommand(ConnectionEditPart connection, String featureName, int reconnectedEnd)
    {
        super(connection);
        this.featureName = featureName;
        this.reconnectedEnd = reconnectedEnd;
    }

    /////////////// OVERRIDED METHODS ///////////////
    /////////////////////////////////////////////////
    
    /**
     * @see org.topcased.modeler.commands.ReconnectGraphEdgeCommand#getOldGraphElement(org.eclipse.gef.ConnectionEditPart)
     */
    protected GraphElement getOldGraphElement(ConnectionEditPart connection)
    {
        toUpdate = getObjectToUpdate();
        GraphElement node = (GraphElement) connection.getTarget().getModel();
        if (toUpdate != Utils.getElement(node))
        {
            return node;
        }
        return (GraphElement) connection.getSource().getModel();
    }

    /////////////////// API METHODS ////////////////
    ////////////////////////////////////////////////
    
    /**
     * Sets the new reference to the given node. The old reference
     * will be removed from the node. This method memorizes the 
     * old container of the new reference to be set to the old reference.
     * Bey this way ancient references will not be lost.
     *  
     * @param node The node which sets the new reference
     * @param newReference The new object to reference
     * @param oldReference The old object referenced. It will be take the place of
     *                  the newReference in the container.
     */
    protected void doDirectReference(EObject node, EObject newReference, EObject oldReference)
    {
        EStructuralFeature feature = node.eClass().getEStructuralFeature(featureName);
        if (feature.isChangeable())
        {
            setOldContainer(feature, newReference);
            if (feature.isMany())
            {
                EList<EObject> sourceList = Utils.getOwnerList(node, feature);
                Collection<EObject> newValue = new ArrayList<EObject>();
                if (sourceList != null)
                {
                    newValue.addAll(sourceList);
                }
                newValue.remove(oldReference);
                newValue.add(newReference);
                node.eSet(feature, newValue);
            }
            else
            {
                node.eSet(feature, newReference);
            }
            switchContainers(oldReference);
        }
    }
    
    /**
     * Undo what was done before by the doDirectReference() method
     * 
     * @param valueToUnset The value to set its old features.
     * @param newNode the new source which contained the value to unset
     * @param oldNode the old source to restablish its value
     * 
     * @see #doDirectReference(EObject, EObject, EObject)
     */
    protected void undoDirectReference(EObject valueToUnset, EObject newNode, EObject oldNode)
    {
        EStructuralFeature feature = valueToUnset.eClass().getEStructuralFeature(featureName);
        if (feature.isChangeable())
        {
            setOldContainer(feature, oldNode);
            if (feature.isMany())
            {
                EList<EObject> sourceList = Utils.getOwnerList(valueToUnset, feature);
                Collection<EObject> newValue = new ArrayList<EObject>();
                if (sourceList != null)
                {
                    newValue.addAll(sourceList);
                }
                newValue.remove(newNode);
                newValue.add(oldNode);
                valueToUnset.eSet(feature, newValue);
            }
            else
            {
                valueToUnset.eSet(feature, oldNode);
            }
            switchContainers(newNode);
        }
    }
    
    /**
     * Adds the reference to the new node.
     * The reference is also removed from the oldNode to avoid conflicts
     * between nodes.
     * 
     * @param reference The value to be referenced by the new node
     * @param newNode The node object which is going to reference the value
     * @param oldNode The node that will not reference the given value any longer
     */
    protected void doInverseReference(EObject reference, EObject newNode, EObject oldNode)
    {        
        // Handle the storing of the edge
        if (newNode != null)
        {
            EStructuralFeature feature = newNode.eClass().getEStructuralFeature(featureName);
            if (feature.isMany())
            {
                EList<EObject> containerList = Utils.getOwnerList(newNode, feature);
                if (containerList != null)
                {
                    containerList.add(reference);
                }
                containerList = Utils.getOwnerList(oldNode, feature);
                if (containerList != null)
                {
                    containerList.remove(reference);
                }
            }
            else
            {
                oldNode.eUnset(feature);
                newNode.eSet(feature, reference);
            }
        }
    }
    
    /**
     * Undo what was done before by the doInverseReference() method.
     * 
     * @param valueToUnset The value to set its old features.
     * @param newNode the new source which contained the value to unset
     * @param oldNode the old source to restablish its value
     * 
     * @see #doInverseReference(EObject, EObject, EObject)
     */
    protected void undoInverseReference(EObject valueToUnset, EObject newNode, EObject oldNode)
    {
        if (oldNode != null)
        {
            EStructuralFeature feature = newNode.eClass().getEStructuralFeature(featureName);
            if (feature.isMany())
            {
                EList<EObject> containerList = Utils.getOwnerList(newNode, feature);
                if (containerList != null)
                {
                    containerList.remove(valueToUnset);
                }
                containerList = Utils.getOwnerList(oldNode, feature);
                if (containerList != null)
                {
                    containerList.add(valueToUnset);
                }
            }
            else
            {
                newNode.eUnset(feature);
                oldNode.eSet(feature, valueToUnset);
            }
        }
    }
    
    ////////////////// GETTERS/SETTERS ////////////////
    ///////////////////////////////////////////////////
    
    /**
     * Returns the type of reconnection
     * 
     * @return the integer value of the end reconnection type.
     * 
     * @see #SOURCE
     * @see #TARGET
     */
    protected int getReconnectionEndType()
    {
        return reconnectedEnd;
    }
    
    /**
     * Retuns the model object corresponding to the fixed edge end
     * 
     * @return The EObject of the fixed node end
     */
    protected EObject getFixedEnd()
    {
        return toUpdate;
    }
    
    ///////////////////// HELPERS /////////////////////
    ///////////////////////////////////////////////////
    
    /*
     * Memorizes the container of the given EObject only if the given
     * feature is a containment EReference
     */
    private void setOldContainer(EStructuralFeature feature, EObject reference)
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
    
    /*
     * Sets the new container of the given reference.
     * This happends only if a container has been memorized
     */
    private void switchContainers(EObject reference)
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
    
    ///////////////// ABSTRACT METHODS ////////////////////
    ///////////////////////////////////////////////////////
    
    /**
     * Retuns the model object corresponding to the fixed edge end
     * 
     * @return The EObject of the fixed node end
     */
    protected abstract EObject getObjectToUpdate();
}
