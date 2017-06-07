/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package org.topcased.modeler.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.resource.EditingDomainHelper;
import org.topcased.modeler.utils.Utils;

/**
 * The command to replace one object inside a new container. Because we treat with containment references, the deletion and the addition of objects from containers take place here.
 * 
 * Any other treatment, such as supplementary feature modification, may be done by overriding the getOrphandChildenCommand() of a {@link LayoutEditPolicy}.
 * 
 * @see LayoutEditPolicy
 * 
 * @Created 24 January 07
 * 
 * @author <a href="mailto:alfredo@anyware-tech.com">Jose Alfredo SERRANO</a>
 * 
 */
public class ReplaceNodeContainerCommand extends Command
{
    /** The model child to be replaced */
    private EObject child;

    /** The graphic child to be replaced */
    private GraphElement childNode;

    /** The new model host receiving the given child */
    private EObject newHost;

    /** The new graphical host receiving the given graphical child */
    private GraphElement newHostNode;

    /** The EClas containment feature */
    private EStructuralFeature newContainmentFeature;

    /** The old child container */
    private EObject oldHost;

    /** The old graphical host of the given graphical child */
    private GraphElement oldHostNode;

    /** The new containment feature */
    private EStructuralFeature oldContainmentFeature;

    /** The new location relative to the new host container */
    private Point newLocation;

    /** The old position relative to the old container */
    private Point oldLocation;

    /** Determine whether the model is synchronized with the diagram or not */
    private boolean isSynchronized = false;

    private Diagrams newDiagrams;

    private Diagrams oldDiagrams;

    private List<Diagrams> childDiagramList;
    
    /**
     * Node ContainerCommand Constructor. Creates a command to place the current object into the new host node
     * 
     * @param currentObject The node being manipulated
     * @param hostNode The node or container to contain the manipulated node
     * @param position The position relative to the hostNode
     */
    public ReplaceNodeContainerCommand(GraphElement currentObject, GraphElement hostNode, Point position)
    {
        super("Node replacement");
        this.childNode = currentObject;
        this.child = Utils.getElement(currentObject);
        this.newHostNode = hostNode;
        this.newHost = Utils.getElement(hostNode);
        this.newLocation = position;
        initFeature();
    }

    public EObject getHost () 
    {
        return newHost ;
    }
    
    public EObject getChild ()
    {
        return child; 
    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute()
    {
        boolean result = !EditingDomainHelper.isEObjectReadOnly(this.oldHost) && !EditingDomainHelper.isEObjectReadOnly(this.newHost);
        if (newContainmentFeature == null)
        {
            return result && false;
        }
        if (newContainmentFeature.isMany())
        {
            List< ? > ownerList = Utils.getOwnerList(newHost, newContainmentFeature);
            return result && !ownerList.contains(child);
        }
        else
        {
            return result && !newHost.eIsSet(newContainmentFeature);
        }
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        if (isSynchronized)
        {
            redoGraphics();
            redoModel();
        }
        else
        {
            redoModel();
            redoGraphics();
        }
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        if (isSynchronized)
        {
            undoGraphics();
            undoModel();
        }
        else
        {
            undoModel();
            undoGraphics();
        }
    }

    /**
     * Sets the parameter which says if model will refresh graphics automatically or not
     * 
     * @param isSynchronized <code>True</code> if model is synchronized The default value is <code>false</code>;
     */
    public void setSynchronization(boolean isSynchronized)
    {
        this.isSynchronized = isSynchronized;
    }

    /**
     * Model modification made here
     */
    protected void redoModel()
    {
        oldHost = child.eContainer();
        if (newContainmentFeature.isMany())
        {
            Utils.getOwnerList(newHost, newContainmentFeature).add(child);
        }
        else
        {
            newHost.eSet(newContainmentFeature, child);
        }
        Diagram diagram = Utils.getDiagram(newHostNode);
        Diagrams diagrams = (Diagrams) diagram.eContainer();
        Diagrams rootDiagrams = DiagramsUtils.findRootDiagrams(diagrams);
        newDiagrams = DiagramsUtils.findNearestContainerDiagrams(rootDiagrams, newHost);
        if (newDiagrams != null)
        {
            // The newly created Diagrams is the new container of the diagrams contained by the initial
            // containerDiagrams

            // 1. Find the list of existing Diagrams that should be moved into that new container
            childDiagramList = new ArrayList<Diagrams>();
            oldDiagrams = DiagramsUtils.findNearestContainerDiagrams(rootDiagrams, oldHost);
            if (oldDiagrams != null)
            {
                for (Diagrams possibleChildDiagrams : oldDiagrams.getSubdiagrams())
                {
                    // The Diagrams should move only if it is associated with a model object that is a descendant of
                    // the eObject element
                    EObject modelObject = possibleChildDiagrams.getModel();
                    if (newHost != modelObject && EcoreUtil.isAncestor(newHost, modelObject))
                    {
                        childDiagramList.add(possibleChildDiagrams);
                    }
                }
            }

            // 2. Move the children diagrams into the newly created Diagrams
            for (Diagrams subdiagrams : childDiagramList)
            {
                subdiagrams.setParent(newDiagrams);
            }
        }
    }

    /**
     * Updates the diagram graphically
     */
    protected void redoGraphics()
    {
        oldLocation = childNode.getPosition();
        if (oldHostNode == null)
        {
            oldHostNode = childNode.getContainer();
        }
        childNode.setPosition(newLocation);
        ((GraphNode) newHostNode).getContained().add(childNode);
    }

    /**
     * Undo any model modification made by the redoModel() method
     */
    protected void undoModel()
    {
        if (oldContainmentFeature.isMany())
        {
            Utils.getOwnerList(oldHost, oldContainmentFeature).add(child);
        }
        else
        {
            oldHost.eSet(oldContainmentFeature, child);
        }
        if (newDiagrams != null && !newDiagrams.getSubdiagrams().isEmpty())
        {
            // 1. Move the children diagrams into the old Diagrams
            for (Diagrams subdiagrams : childDiagramList)
            {
                // Restore the initial container Diagrams
                subdiagrams.setParent(oldDiagrams);
            }
        }
    }

    /**
     * Undo any graphical modification made by redoGraphics() method
     */
    protected void undoGraphics()
    {
        childNode.setPosition(oldLocation);
        ((GraphNode) newHostNode).getContained().remove(childNode);
        ((GraphNode) oldHostNode).getContained().add(childNode);
    }

    // /////////////////// HELPERS //////////////////////
    // //////////////////////////////////////////////////

    private void initFeature()
    {
        if (newHost != null && child != null)
        {
            oldContainmentFeature = child.eContainingFeature();
            for (EReference eRef : newHost.eClass().getEAllContainments())
            {
                if (eRef.getEType().isInstance(child))
                {
                    newContainmentFeature = eRef;
                    break;
                }
            }
        }
    }
}
