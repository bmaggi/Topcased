/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.edit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.resource.StringConverter;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.commands.ChangeDiagramElementPropertyCommand;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.edit.policies.LabelDirectEditPolicy;
import org.topcased.modeler.edit.policies.MultiPortLayoutEditPolicy;
import org.topcased.modeler.edit.policies.NonRemovableComponentEditPolicy;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.ModelerGraphicalViewer;
import org.topcased.modeler.figures.MultiPortFigure;
import org.topcased.modeler.figures.PortAnchor;
import org.topcased.modeler.listeners.DiagramElementListener;

/**
 * An EditPart used to handle MultiPort behavior. A MultiPort contains children
 * PortEditPart and has a Property that record the visual state of the MultiPort
 * (CLOSED or OPENED)
 * 
 * Creation : 19 oct. 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class MultiPortEditPart extends EMFGraphNodeEditPart implements IPortEditPart
{
    /**
     * This listener also listens the mutliport state property
     * 
     * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
     */
    protected class MultiPortEditPartListener extends GraphNodeEditPartListener
    {
        /**
         * @see org.topcased.modeler.edit.GraphNodeEditPart.GraphNodeEditPartListener#handlePropertyChanged(org.topcased.modeler.di.model.Property,
         *      org.topcased.modeler.di.model.Property)
         */
        protected void handlePropertyChanged(Property oldProperty, Property newProperty)
        {
            super.handlePropertyChanged(oldProperty, newProperty);

            Property property = newProperty != null ? newProperty : oldProperty;

            if (ModelerPropertyConstants.MULTIPORT_STATE.equals(property.getKey()))
            {
                refreshVisuals();
                refreshChildren();
                refreshSourceConnections();
                refreshTargetConnections();
            }
            else if (ModelerPropertyConstants.PORT_POSITION.equals(property.getKey()))
            {
                refreshConstraints();
            }
        }

    }

    private DiagramElementListener diagramListener = new MultiPortEditPartListener();

    /**
     * @param obj
     */
    public MultiPortEditPart(GraphNode obj)
    {
        super(obj);
    }

    /**
     * @see org.topcased.modeler.edit.GraphNodeEditPart#getDiagramElementListener()
     */
    protected DiagramElementListener getDiagramElementListener()
    {
        return diagramListener;
    }

    /**
     * Creates edit policies and associates these with roles
     */
    protected void createEditPolicies()
    {
        super.createEditPolicies();

        installEditPolicy(EditPolicy.COMPONENT_ROLE, new NonRemovableComponentEditPolicy());

        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());

        installEditPolicy(EditPolicy.LAYOUT_ROLE, new MultiPortLayoutEditPolicy());
    }

    /**
     * Update the figure with its current direction
     * 
     * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
     */
    protected void refreshVisuals()
    {
        super.refreshVisuals();

        updateMultiPortFigureState();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     * @generated NOT
     */
    protected IFigure createFigure()
    {
        return new MultiPortFigure();
    }

    /**
     * Update the figure with the new State
     */
    protected void updateMultiPortFigureState()
    {
        Property property = DIUtils.getProperty(getGraphNode(), ModelerPropertyConstants.MULTIPORT_STATE);

        if (property != null)
        {
            ((MultiPortFigure) getFigure()).setClosed(StringConverter.asBoolean(property.getValue()));
        }
    }

    /**
     * @see org.topcased.modeler.edit.EMFGraphNodeEditPart#performRequest(Request)
     * @generated NOT
     */
    public void performRequest(Request request)
    {
        if (request.getType() == RequestConstants.REQ_OPEN)
        {
            ChangeDiagramElementPropertyCommand command = new ChangeDiagramElementPropertyCommand(getGraphNode(), ModelerPropertyConstants.MULTIPORT_STATE,
                    StringConverter.asString(!((MultiPortFigure) getFigure()).isClosed()));
            Modeler editor = ((ModelerGraphicalViewer) getViewer()).getModelerEditor();
            ((CommandStack) editor.getAdapter(CommandStack.class)).execute(command);
        }
        else
        {
            super.performRequest(request);
        }
    }

    /**
     * @return Returns the visualState.
     */
    public boolean isClosed()
    {
        return ((MultiPortFigure) getFigure()).isClosed();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
     * @generated
     */
    protected List<GraphNode> getModelChildren()
    {
        List<GraphNode> graphNodeChildren = new ArrayList<GraphNode>();
        if (!isClosed())
        {
            Iterator<DiagramElement> it = getGraphNode().getContained().iterator();
            while (it.hasNext())
            {
                DiagramElement elt = it.next();
                if (elt instanceof GraphNode)
                {
                    graphNodeChildren.add((GraphNode) elt);
                }
            }
        }
        return graphNodeChildren;
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
     */
    protected List<GraphEdge> getModelSourceConnections()
    {
        List<GraphEdge> srcConnections = new ArrayList<GraphEdge>();
        if (isClosed())
        {
            Iterator<DiagramElement> itChildren = getGraphNode().getContained().iterator();
            while (itChildren.hasNext())
            {
                DiagramElement elt = itChildren.next();
                if (elt instanceof GraphNode)
                {
                    srcConnections.addAll(getSourceConnections((GraphNode) elt));
                }
            }
        }
        return srcConnections;
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
     */
    protected List<GraphEdge> getModelTargetConnections()
    {
        List<GraphEdge> tgtConnections = new ArrayList<GraphEdge>();
        if (isClosed())
        {
            Iterator<DiagramElement> itChildren = getGraphNode().getContained().iterator();
            while (itChildren.hasNext())
            {
                DiagramElement elt = itChildren.next();
                if (elt instanceof GraphNode)
                {
                    tgtConnections.addAll(getTargetConnections((GraphNode) elt));
                }
            }
        }
        return tgtConnections;
    }

    /**
     * Find the incoming graph edges
     * 
     * @param node the target node
     * @return the list of connections
     */
    private List<GraphEdge> getTargetConnections(GraphNode node)
    {
        List<GraphEdge> tgtConnections = new ArrayList<GraphEdge>();
        Iterator<GraphConnector> itAnchors = node.getAnchorage().iterator();
        while (itAnchors.hasNext())
        {
            GraphConnector connector = itAnchors.next();
            Iterator<GraphEdge> itConnectors = connector.getGraphEdge().iterator();
            while (itConnectors.hasNext())
            {
                GraphEdge edge = itConnectors.next();
                if (edge.getAnchor().size() == 2 && connector == edge.getAnchor().get(1))
                {
                    tgtConnections.add(edge);
                }
            }
        }

        return tgtConnections;
    }

    /**
     * Find the outgoing graph edges
     * 
     * @param node the source node
     * @return the list of connections
     */
    private List<GraphEdge> getSourceConnections(GraphNode node)
    {
        List<GraphEdge> srcConnections = new ArrayList<GraphEdge>();

        Iterator<GraphConnector> itAnchors = node.getAnchorage().iterator();
        // Iterator it = getGraphNode().getAnchorage().iterator();
        while (itAnchors.hasNext())
        {
            GraphConnector connector = itAnchors.next();
            Iterator<GraphEdge> itConnectors = connector.getGraphEdge().iterator();
            while (itConnectors.hasNext())
            {
                GraphEdge edge = itConnectors.next();
                if (connector == edge.getAnchor().get(0))
                {
                    srcConnections.add(edge);
                }
            }
        }

        return srcConnections;
    }

    /**
     * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
     */
    public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection)
    {
        return getMultiPortConnectionAnchor();
    }

    /**
     * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
     */
    public ConnectionAnchor getSourceConnectionAnchor(Request request)
    {
        return getMultiPortConnectionAnchor();
    }

    /**
     * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
     */
    public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection)
    {
        return getMultiPortConnectionAnchor();
    }

    /**
     * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
     */
    public ConnectionAnchor getTargetConnectionAnchor(Request request)
    {
        return getMultiPortConnectionAnchor();
    }

    /**
     * Return the connection Anchor depending on the container of the MultiPort
     * 
     * @return the ConnectionAnchor
     */
    protected ConnectionAnchor getMultiPortConnectionAnchor()
    {
        if (getParent().getModel() instanceof Diagram)
        {
            return new PortAnchor(getFigure(), false);
        }
        else
        {
            return new PortAnchor(getFigure(), true);
        }
    }

    /**
     * @see org.topcased.modeler.edit.GraphNodeEditPart#getDefaultWidth()
     */
    protected int getDefaultWidth()
    {
        return -1;
    }

    /**
     * @see org.topcased.modeler.edit.GraphNodeEditPart#getDefaultHeight()
     */
    protected int getDefaultHeight()
    {
        return -1;
    }

    /**
     * @see org.topcased.modeler.edit.GraphNodeEditPart#getMinimumWidth()
     */
    public int getMinimumWidth()
    {
        return -1;
    }

    /**
     * @see org.topcased.modeler.edit.GraphNodeEditPart#getMinimumHeight()
     */
    public int getMinimumHeight()
    {
        return -1;
    }
}
