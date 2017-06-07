/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies), Thomas Friol (Anyware
 * Technologies) - initial API and implementation
 ******************************************************************************/
package org.topcased.modeler.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.CompoundCommand;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.editor.resource.EditingDomainHelper;
import org.topcased.modeler.utils.Utils;

/**
 * Delete the given GraphElement and all its connections. <br>
 * creation : 1 juin 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class DeleteGraphElementCommand extends CompoundCommand
{
    private List<GraphElement> deletedObjects;

    /**
     * Build the command
     * 
     * @param elt the GraphElement to delete
     * @param deleteEdge specify whether connections to or from the elt should
     *            be deleted too
     */
    public DeleteGraphElementCommand(GraphElement elt, boolean deleteEdge)
    {
        super("Global Element Deletion");

        initialize(elt, deleteEdge);
    }
    
    private void initialize(GraphElement elt, boolean deleteEdge)
    {
        deletedObjects = new ArrayList<GraphElement>();

        addElement(elt);

        if (deleteEdge)
        {
            // All connections from or to this element or one of its children
            // have to bo deleted
            addEdges(elt, elt);
        }
    }

    private void addElement(GraphElement elt)
    {
        if (!deletedObjects.contains(elt))
        {
            if (elt instanceof GraphEdge)
            {
                deletedObjects.add(elt);

                DeleteGraphEdgeCommand deleteCmd = new DeleteGraphEdgeCommand();
                deleteCmd.setPartToBeDeleted(elt);
                add(deleteCmd);
            }
            if (elt instanceof GraphNode)
            {
                deletedObjects.add(elt);

                DeleteGraphNodeCommand deleteCmd = new DeleteGraphNodeCommand();
                deleteCmd.setPartToBeDeleted(elt);
                add(deleteCmd);
            }
        }
    }

    private void addEdges(GraphElement elt, GraphElement root)
    {
        // Remove edges if this is not inner edges
        Iterator<GraphEdge> itEdges = Utils.getEdges(elt).iterator();
        while (itEdges.hasNext())
        {
            DiagramElement element = itEdges.next();
            if (element instanceof GraphElement)
            {
                if (!Utils.isChild(root, (GraphElement) element))
                {
                    addElement((GraphElement) element);
                }
            }
        }

        // Remove children edges
        Iterator<DiagramElement> itChildren = elt.getContained().iterator();
        while (itChildren.hasNext())
        {
            DiagramElement child = itChildren.next();
            if (child instanceof GraphElement)
            {
                addEdges((GraphElement) child, root);
            }
        }
    }

    @Override
    public boolean canExecute()
    {
        if (deletedObjects != null)
        {
            for (GraphElement e : deletedObjects)
            {
                if (EditingDomainHelper.isEObjectReadOnly(e))
                {
                    return false ;
                }
            }
        }
        return super.canExecute();
    }
    
    
}
