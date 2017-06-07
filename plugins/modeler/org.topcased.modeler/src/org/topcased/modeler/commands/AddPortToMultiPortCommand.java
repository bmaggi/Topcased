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

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.commands.Command;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.utils.Utils;

/**
 * 
 * Creation : 09 may 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class AddPortToMultiPortCommand extends Command
{
    /** The child GraphNode that is dropped */
    private GraphNode childNode;

    /** The old parent GraphNode that contained the childNode */
    private GraphNode oldParentNode;

    /** The new parent GraphNode that should contain the childNode */
    private GraphNode newParentNode;

    /**
     * Constructor
     * 
     * @param parent the parentEditPart that will contain the PortEditPart
     * @param child the PortEditPart that is moved
     */
    public AddPortToMultiPortCommand(GraphNode parent, GraphNode child)
    {
        super("Move a Port to a MultiPort");
        this.newParentNode = parent;
        this.childNode = child;
        this.oldParentNode = (GraphNode) child.getContainer();
    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute()
    {
        return newParentNode != null && childNode != null && newParentNode != null;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        redo();
    }

    /**
     * Add a new DataPort object to the SynchronisationGate model object
     * 
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        oldParentNode.getContained().remove(childNode);
        newParentNode.getContained().add(childNode);

        redoModel();
    }

    /**
     * Update the DI model
     */
    protected void redoModel()
    {
        EObject childEObject = Utils.getElement(childNode);
        EObject parentEObject = Utils.getElement(newParentNode);

        EReference selectedFeature = null;

        // we check all the EStructuralFeatures of type Containment
        for (Iterator<EReference> i = parentEObject.eClass().getEAllContainments().iterator(); i.hasNext();)
        {
            EReference eRef = (EReference) i.next();
            // Check if the Reference is of the expected type
            if (eRef.getEReferenceType().isInstance(childEObject))
            {
                selectedFeature = eRef;
            }

        }

        if (selectedFeature != null)
        {
            if (parentEObject != null && childEObject != null)
            {
                EList<EObject> ownerList = Utils.getOwnerList(parentEObject, selectedFeature);
                if (!ownerList.contains(childEObject))
                {
                    ownerList.add(childEObject);
                }
            }
        }
    }

    /**
     * Remove the last added DataPort
     * 
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        newParentNode.getContained().remove(childNode);
        oldParentNode.getContained().add(childNode);

        undoModel();
    }

    /**
     * Undo the DI model modifications
     */
    protected void undoModel()
    {
        EObject childEObject = Utils.getElement(childNode);
        EObject parentEObject = Utils.getElement(oldParentNode);

        EReference selectedFeature = null;

        // we check all the EStructuralFeatures of type Containment
        for (Iterator<EReference> i = parentEObject.eClass().getEAllContainments().iterator(); i.hasNext();)
        {
            EReference eRef = (EReference) i.next();
            // Check if the Reference is of the expected type
            if (eRef.getEReferenceType().isInstance(childEObject))
            {
                selectedFeature = eRef;
            }

        }

        if (selectedFeature != null)
        {
            if (parentEObject != null && childEObject != null)
            {
                EList<EObject> ownerList = Utils.getOwnerList(parentEObject, selectedFeature);
                if (!ownerList.contains(childEObject))
                {
                    ownerList.add(childEObject);
                }
            }
        }
    }
}
