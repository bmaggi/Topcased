/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package org.topcased.modeler.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.ConnectionEditPart;
import org.topcased.modeler.utils.Utils;

/**
 * Sets a reference of the given edge to the node
 *
 * @Created 23 janv. 07
 *
 * @author <a href="mailto:alfredo@anyware-tech.com">Jose Alfredo SERRANO</a>
 *
 */
public abstract class ReconnectNodeToEdgeCommand extends ReconnectGraphEdgeCommand
{
    /** The name of the feature referencing the node */
    private String featureName;
    
    /**
     * @param domain
     * @param connection
     */
    public ReconnectNodeToEdgeCommand(ConnectionEditPart connection, String featureName)
    {
        super(connection);
        this.featureName = featureName;
    }

    /**
     * @see org.topcased.modeler.commands.ReconnectGraphEdgeCommand#redoModel()
     */
    protected void redoModel()
    {
        EObject toUpdate = getObjectToUpdate();
        EObject newNode = Utils.getElement(getNewElement());
        EObject oldNode = Utils.getElement(getOldElement());
        
        // Handle the storing of the edge
        if (newNode != null)
        {
            EStructuralFeature feature = newNode.eClass().getEStructuralFeature(featureName);
            if (feature.isMany())
            {
                EList<EObject> containerList = Utils.getOwnerList(newNode, feature);
                if (containerList != null)
                {
                    containerList.add(toUpdate);
                }
                containerList = Utils.getOwnerList(oldNode, feature);
                if (containerList != null)
                {
                    containerList.remove(toUpdate);
                }
            }
            else
            {
                oldNode.eUnset(feature);
                newNode.eSet(feature, toUpdate);
            }
        }
    }

    /**
     * @see org.topcased.modeler.commands.ReconnectGraphEdgeCommand#undoModel()
     */
    protected void undoModel()
    {
        EObject toUpdate = getObjectToUpdate();
        EObject newNode = Utils.getElement(getNewElement());
        EObject oldNode = Utils.getElement(getOldElement());
        
        // Handle the storing of the edge
        if (newNode != null)
        {
            EStructuralFeature feature = newNode.eClass().getEStructuralFeature(featureName);
            if (feature.isMany())
            {
                EList<EObject> containerList = Utils.getOwnerList(newNode, feature);
                if (containerList != null)
                {
                    containerList.remove(toUpdate);
                }
                containerList = Utils.getOwnerList(oldNode, feature);
                if (containerList != null)
                {
                    containerList.add(toUpdate);
                }
            }
            else
            {
                newNode.eUnset(feature);
                oldNode.eSet(feature, toUpdate);
            }
        }
    }

    /**
     * Returns the model object to be updated by changements
     * 
     * @return The object to be updated
     */
    protected abstract EObject getObjectToUpdate();
}
