/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.graph.DirectedGraph;
import org.eclipse.draw2d.graph.DirectedGraphLayout;
import org.eclipse.draw2d.graph.Edge;
import org.eclipse.draw2d.graph.EdgeList;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.draw2d.graph.NodeList;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.exceptions.BoundsFormatException;
import org.topcased.modeler.requests.AutoResizeRequest;
import org.topcased.modeler.utils.Utils;

/**
 * This class computes the command that autolayouts a list of GraphNodes. <br>
 * creation : 4 mai 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class AutoLayout
{
    private static final int DEFAULT_PADDING = 60;

    private int minX;

    private int minY;
    
    private int margin = 0;

    private boolean failOnOverflow;

    private GraphicalEditPart containerEditPart;

    /**
     * Creates an autolayout algorithm for the given diagram.
     * 
     * @param diag the diagram where the objects are layout
     * @param container the container EditPart
     * @param fail If tset to <code>true</code>, the autolayout will not
     *            return the command if one of the node is out of the diagram
     */
    public AutoLayout(GraphicalEditPart container, boolean fail)
    {
        failOnOverflow = fail;
        containerEditPart = container;
    }

    /**
     * Returns the autolayout command
     * 
     * @param elements the list of elements to autolayout
     * @return the autolayout command
     * @throws BoundsFormatException
     */
    public Command getCommand(List elements) throws BoundsFormatException
    {
        if (elements.size() != 0)
        {
            // Create Graph
            DirectedGraph g = new DirectedGraph();
            createGraph(g, elements);

            // Auto Layout
            DirectedGraphLayout layout = new DirectedGraphLayout();
            layout.visit(g);

            // Command creation
            return getCommand(g);
        }

        return UnexecutableCommand.INSTANCE;
    }

    /**
     * Creates the list of commands for the given DirectedGraph
     * 
     * @param g the autolayout graph
     * @return the command to update the model objects
     * @throws BoundsFormatException if the object cannot be autolayout (diagram
     *             too small)
     */
    protected Command getCommand(DirectedGraph g) throws BoundsFormatException
    {
        CompoundCommand cmd = new CompoundCommand();

        // Change format Command
        Rectangle boundingRect = getBoundingBox(g);
        boolean overflow = overflow(containerEditPart, boundingRect);
        // Check overflow
        if (failOnOverflow && overflow)
        {
            throw new BoundsFormatException("The container size is too small, autolayout cannot be performed.\n"
                    + "Please enlarge the size manually.");
        }
        if (overflow)
        {
            AutoResizeRequest request = new AutoResizeRequest();
            request.setContentPaneSize(boundingRect.getSize());
            Command partCmd = containerEditPart.getCommand(request);
            if (partCmd != null && partCmd.canExecute())
            {
                cmd.add(partCmd);
            }
            else
            {
                throw new BoundsFormatException(
                        "Autolayout cannot be performed. There is no format available to display all the objects. Your model may be too big for the current page size. You should choose a greater page size and try again to drag'n drop the whole model from the outline.");
            }
        }

        // ChangeBounds Commands
        ListIterator nodesIt = g.nodes.listIterator();
        while (nodesIt.hasNext())
        {
            Node node = (Node) nodesIt.next();
            GraphNode gNode = (GraphNode) node.data;
            if (gNode != null)
            {
                GraphicalEditPart ep = (GraphicalEditPart) containerEditPart.getViewer().getEditPartRegistry().get(
                        gNode);

                // Create the ChangeBoundsCommand for the given graphNode
                Rectangle nodeRect = node2rectangle(node);

                ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_MOVE_CHILDREN);
                request.setEditParts(ep);
                // Handle zoom
                nodeRect.translate(gNode.getPosition());
                Point pos = gNode.getPosition().getCopy();
                ep.getFigure().translateToAbsolute(pos);
                ep.getFigure().translateToAbsolute(nodeRect);
                nodeRect.translate(pos.getNegated());

                request.setMoveDelta(nodeRect.getTopLeft());
                request.setLocation(pos);

                // Set the property for free location of nodes
                request.getExtendedData().put(ModelerRequestConstants.PROP_CONSTRAINT_FREE, Boolean.TRUE);

                Command moveCmd = containerEditPart.getCommand(request);
                if (moveCmd != null && moveCmd.canExecute())
                {
                    cmd.add(moveCmd);
                }

            }
        }

        return cmd;
    }

    private Rectangle getBoundingBox(DirectedGraph graph)
    {
        Rectangle bounds = new Rectangle(0, 0, 0, 0);
        ListIterator nodesIt = graph.nodes.listIterator();
        while (nodesIt.hasNext())
        {
            Node node = (Node) nodesIt.next();
            GraphNode gNode = (GraphNode) node.data;
            if (gNode != null)
            {
                GraphicalEditPart ep = (GraphicalEditPart) containerEditPart.getViewer().getEditPartRegistry().get(
                        gNode);
                
                Rectangle nodeRect = node2rectangle(node);
                nodeRect.translate(gNode.getPosition());
//                ep.getFigure().translateToAbsolute(nodeRect);
                
                bounds = bounds.union(nodeRect);
            }
        }

        return bounds;
    }

    /**
     * 
     * Check if the given rectangle overflows the given diagram.
     * 
     * @param diag the container diagram
     * @param box the box to check
     * @return <code>true</code> if the bow can be shown with the given
     *         diagram
     */
    private boolean overflow(GraphicalEditPart ep, Rectangle box)
    {
        int width = ep.getContentPane().getClientArea().width;
        int height = ep.getContentPane().getClientArea().height;

        Rectangle container = new Rectangle(0, 0, width, height);

        return !container.contains(box);
    }

    /**
     * Add the nodes to the directed graph
     * 
     * @param g the graph used to do the autolayout
     * @param elements the elements to autolayout
     */
    private void createGraph(DirectedGraph g, List elements)
    {
        // Init
        HashMap elementToNode = new HashMap(500);
        minX = -1;
        minY = -1;

        // Creates nodes and edges
        NodeList nodes = createNodeList(elements, elementToNode);
        ArrayList objects = new ArrayList();
        objects.addAll(elements);
        objects.addAll(getConnections(elementToNode));
        EdgeList edges = createEdgeList(objects, elementToNode);

        // Add nodes and edges to the graph
        g.nodes = nodes;
        g.edges = edges;

        // // Break cycle and deals with subgraphes
        // BreakCycles breakCycle = new BreakCycles();
        // breakCycle.visit(g);

        addNonConnectedSubgraphs(nodes, edges);
    }

    /**
     * Creates nodes for given elements
     * 
     * @param elements the model elements
     * @param elementsToNode the map that associates nodes and elements
     * @return a NodeList
     */
    private NodeList createNodeList(List elements, Map elementsToNode)
    {
        ListIterator li = elements.listIterator();
        NodeList nodes = new NodeList();
        while (li.hasNext())
        {
            Object elt = li.next();

            // Only keep GraphNodes
            if (elt instanceof GraphNode)
            {
                GraphNode gNode = (GraphNode) elt;
                Point position = gNode.getPosition();
                if (minX < 0)
                {
                    minX = position.x;
                    minY = position.y;
                }
                else
                {
                    minX = Math.min(minX, position.x);
                    minY = Math.min(minY, position.y);
                }
                Node n = new Node(gNode);
                Insets padding = new Insets(0, 0, DEFAULT_PADDING, DEFAULT_PADDING);

                n.setPadding(padding);

                Dimension size = getNodeSize(gNode);
                if (size != null)
                {
                    n.width = size.width;
                    n.height = size.height;
                }
                n.x = position.x;
                n.y = position.y;
                elementsToNode.put(gNode, n);
                nodes.add(n);
            }
        }
        return nodes;
    }

    private Dimension getNodeSize(GraphNode gNode)
    {
        GraphicalEditPart ep = (GraphicalEditPart) containerEditPart.getViewer().getEditPartRegistry().get(gNode);

        // ep.getFigure().invalidateTree();
        // Dimension temp = ep.getFigure().getPreferredSize();
        // Dimension temp2 = ep.getFigure().getSize();
        return ep.getFigure().getSize();
    }

    /**
     * Creates edges for given elements
     * 
     * @param elements the model elements
     * @param elementsToNode the map that associates nodes and elements
     * @return a EdgeList
     */
    private EdgeList createEdgeList(List elements, Map elementsToNode)
    {
        EdgeList edges = new EdgeList();
        ArrayList objects = new ArrayList();
        objects.addAll(elements);
        ListIterator li = objects.listIterator();
        while (li.hasNext())
        {
            Object elt = li.next();

            // Only keep GraphEdges
            if (elt instanceof GraphEdge)
            {
                GraphEdge gEdge = (GraphEdge) elt;
                GraphElement from = Utils.getSource(gEdge);
                GraphElement to = Utils.getTarget(gEdge);
                Node fromNode = (Node) elementsToNode.get(from);
                Node toNode = (Node) elementsToNode.get(to);

                // Keep edges linking 2 graph objects
                if (fromNode != null && toNode != null && !fromNode.equals(toNode))
                {
                    Edge edge = new Edge(gEdge, toNode, fromNode);
                    edges.add(edge);
                }
            }
        }

        return edges;
    }

    /**
     * Returns the list of all the connections linking 2 objects of the graph.
     * 
     * @param elementsToNode map between model elements and nodes
     * @return the list of connections
     */
    private List getConnections(HashMap elementsToNode)
    {
        Iterator keys = elementsToNode.keySet().iterator();
        ArrayList<GraphEdge> connections = new ArrayList<GraphEdge>();
        while (keys.hasNext())
        {
            GraphNode gNode = (GraphNode) keys.next();
            List<GraphEdge> targetConnections = Utils.getTargetEdges(gNode);
            for (int i = 0; i < targetConnections.size(); i++)
            {
                GraphEdge gEdge = targetConnections.get(i);
                GraphElement source = Utils.getSource(gEdge);
                Object o = elementsToNode.get(source);
                if (o != null)
                {
                    connections.add(gEdge);
                }
            }

        }
        return connections;
    }

    private void addNonConnectedSubgraphs(List nodes, List edges)
    {
        Node ghostNode = new Node();
        ghostNode.width = 1;
        ghostNode.height = 1;
        ghostNode.setPadding(new Insets(0));

        boolean used = false;
        for (ListIterator ni = nodes.listIterator(); ni.hasNext();)
        {
            Node n = (Node) ni.next();
            if (n != ghostNode && n.incoming.isEmpty())
            {
                used = true;
                Edge e = new Edge(ghostNode, n);
                e.weight = 0;
                edges.add(e);
            }
        }

        if (used)
        {
            nodes.add(ghostNode);
        }
    }

    /**
     * Convert a Node into a Rectangler
     * 
     * @param node the Graph node
     * @return the associated rectangle
     */
    private Rectangle node2rectangle(Node node)
    {
        return new Rectangle(node.x + margin, node.y + margin, node.width, node.height);
    }

    /**
     * Define a margin in the autolayout
     * @param margin The margin to set.
     */
    public void setMargin(int margin)
    {
        this.margin = margin;
    }
}
