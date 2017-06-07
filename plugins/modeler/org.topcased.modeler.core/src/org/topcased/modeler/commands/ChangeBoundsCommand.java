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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.resource.StringConverter;
import org.topcased.draw2d.layout.PortConstraint;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.SimpleSemanticModelElement;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.editor.IConfiguration;
import org.topcased.modeler.editor.TopcasedAdapterFactoryEditingDomain;
import org.topcased.modeler.extensions.DiagramsManager;
import org.topcased.modeler.graphconf.NodeGraphConf;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.utils.Utils;

/**
 * Changing bounds of a object <br>
 * creation : 30 nov. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class ChangeBoundsCommand extends Command
{

    /** The node. */
    private GraphNode node;

    /** The new location. */
    private Point newLocation;

    /** The old location. */
    private Point oldLocation;


    /** The old size. */
    private Dimension oldSize;

    /** The new size. */
    private Dimension newSize;

    /** The new attachment. */
    private int newAttachment = PositionConstants.NONE;

    /** The old attachment. */
    private int oldAttachment = PositionConstants.NONE;

    /** The children attach. */
    private boolean childrenAttach = true;

    /**
     * Constructor.
     * 
     * @param node the node to resize
     * @param constraint the new rectangle that contain the figure
     */
    public ChangeBoundsCommand(GraphNode node, Rectangle constraint)
    {
        super("Change Bounds");
        setNode(node);
        setNewLocation(new Point(constraint.x, constraint.y));
        setNewSize(new Dimension(constraint.width, constraint.height));
    }

    /**
     * Constructor.
     * 
     * @param node the node to resize
     * @param constraint the new rectangle that contain the figure
     */
    public ChangeBoundsCommand(GraphNode node, PortConstraint constraint)
    {
        super("Change Bounds");
        setNode(node);
        setNewLocation(new Point(constraint.getRectConstraints().x, constraint.getRectConstraints().y));
        setNewSize(new Dimension(constraint.getRectConstraints().width, constraint.getRectConstraints().height));
        newAttachment = constraint.getAttachment();
    }

    /**
     * Constructor.
     * 
     * @param node the node to resize
     * @param constraint the new rectangle that contain the figure
     * @param childAttach true if the children of the node should have the same
     * attachement
     */
    public ChangeBoundsCommand(GraphNode node, PortConstraint constraint, boolean childAttach)
    {
        this(node, constraint);
        childrenAttach = childAttach;
    }

    /**
     * Constructor.
     * 
     * @param node the node to resize
     * @param constraint the new rectangle that contain the figure
     * @param childAttach true if the children of the node should have the same
     * attachement
     */
    public ChangeBoundsCommand(GraphNode node, Rectangle constraint, boolean childAttach)
    {
        this(node, constraint);
        childrenAttach = childAttach;
    }

    /**
     * Can execute.
     * 
     * @return true, if can execute
     * 
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute()
    {
        boolean result = !TopcasedAdapterFactoryEditingDomain.isEObjectReadOnly(this.node) ;
        
        return result && (node != null && newLocation != null && (newSize != null || !(node.getPosition().equals(newLocation))));
    }

    /**
     * Execute.
     * 
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        IConfiguration configuration = null;
        try
        {
            configuration = DiagramsManager.getInstance().getConfiguration(
                    Utils.getDiagram(node).getSemanticModel().getPresentation());
        }
        catch (CoreException ce)
        {
            ModelerPlugin.log(ce);
        }

        NodeGraphConf nodeGraphConf = null;
        if (Utils.getElement(node) != null)
        {
            nodeGraphConf = Utils.getNodeGraphConf(configuration.getDiagramGraphConf(), Utils.getElement(node),
                    node.getSemanticModel().getPresentation());
        }
        else
        {
            nodeGraphConf = configuration.getDiagramGraphConf().getNodeGraphConf(
                    ((SimpleSemanticModelElement) node.getSemanticModel()).getTypeInfo(),
                    node.getSemanticModel().getPresentation());
        }

        if (nodeGraphConf != null)
        {
            updateConstrainedSize(nodeGraphConf);
        }
        else
        {
        	// The element has not a graphconf. The element is considered as always resizable. So negative numbers are forbidden.
        	if(newSize.height < 0)
        	{
        		newSize.height = 1;
        	}
        	if(newSize.width < 0)
        	{
        		newSize.width = 1;
        	}
        }

        oldLocation = node.getPosition();
        oldSize = node.getSize();

        if (oldSize != null)
        {
            if (oldSize.width < 0)
            {
                newSize.width = -1;
            }
            if (oldSize.height < 0)
            {
                newSize.height = -1;
            }
        }

        if (newAttachment != PositionConstants.NONE)
        {
            oldAttachment = StringConverter.asInt(DIUtils.getPropertyValue(node, ModelerPropertyConstants.PORT_POSITION));
        }
        redo();
    }

    /**
     * Update constrained size.
     * 
     * @param nodeGraphConf the node graph conf
     */
    private void updateConstrainedSize(NodeGraphConf nodeGraphConf)
    {
        // Check whether the dimension is not smaller than the minimum size
        newSize.width = Math.max(newSize.width, nodeGraphConf.getMinimumWidth());
        newSize.height = Math.max(newSize.height, nodeGraphConf.getMinimumHeight());

        // Check whether the dimension is not larger than the maximum size
        if (nodeGraphConf.getMaximumWidth() != 0)
        {
            newSize.width = Math.min(newSize.width, nodeGraphConf.getMaximumWidth());
        }
        if (nodeGraphConf.getMaximumHeight() != 0)
        {
            newSize.height = Math.min(newSize.height, nodeGraphConf.getMaximumHeight());
        }

        // Initialize with the default size when the figure has not a resizable
        // width
        if (!nodeGraphConf.isIsWidthResizable())
        {
            newSize.width = nodeGraphConf.getDefaultWidth();
        }

        // Initialize with the default size when the figure has not a resizable
        // height
        if (!nodeGraphConf.isIsHeightResizable())
        {
            newSize.height = nodeGraphConf.getDefaultHeight();
        }
    }

    /**
     * Redo.
     * 
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        node.setPosition(newLocation);
        node.setSize(newSize);

        if (newAttachment != PositionConstants.NONE)
        {
            DIUtils.setProperty(node, ModelerPropertyConstants.PORT_POSITION, StringConverter.asString(newAttachment));
            if (childrenAttach)
            {
                for (Iterator<DiagramElement> iter = node.getContained().iterator(); iter.hasNext();)
                {
                    DiagramElement childElt = iter.next();
                    if (childElt instanceof GraphNode)
                    {
                        DIUtils.setProperty(childElt, ModelerPropertyConstants.PORT_POSITION,
                                StringConverter.asString(newAttachment));
                    }
                }
            }
        }

    }

    /**
     * Sets the node.
     * 
     * @param node the new node
     */
    private void setNode(GraphNode node)
    {
        this.node = node;
    }

    /**
     * Sets the new location.
     * 
     * @param loc the new new location
     */
    protected void setNewLocation(Point loc)
    {
        newLocation = loc;
    }

    /**
     * Sets the new size.
     * 
     * @param dim the new new size
     */
    private void setNewSize(Dimension dim)
    {
        newSize = dim;
    }

    /**
     * Undo.
     * 
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        node.setPosition(oldLocation);
        node.setSize(oldSize);
        if (oldAttachment != PositionConstants.NONE)
        {
            DIUtils.setProperty(node, ModelerPropertyConstants.PORT_POSITION, StringConverter.asString(oldAttachment));

            if (childrenAttach)
            {
                for (Iterator<DiagramElement> iter = node.getContained().iterator(); iter.hasNext();)
                {
                    DiagramElement childElt = iter.next();
                    if (childElt instanceof GraphNode)
                    {
                        DIUtils.setProperty(childElt, ModelerPropertyConstants.PORT_POSITION,
                                StringConverter.asString(oldAttachment));
                    }
                }
            }
        }
    }


    /**
     * Gets the node.
     * 
     * @return the node
     */
    protected GraphNode getNode()
    {
        return node;
    }
    
    /**
     * Sets the old location.
     * 
     * @param oldLocation the oldLocation to set
     */
    protected void setOldLocation(Point oldLocation)
    {
        this.oldLocation = oldLocation;
    }
    
    /**
     * Gets the old location.
     * 
     * @return the oldLocation
     */
    protected Point getOldLocation()
    {
        return oldLocation;
    }
    
    protected Dimension getOldSize()
    {
        return oldSize ;
    }
    
    protected Dimension getNewSize()
    {
        return newSize ;
    }
    
    /**
     * Gets the new location.
     * 
     * @return the new location
     */
    protected Point getNewLocation()
    {
        return newLocation;
    }
    
    /**
     * Gets the vector translation.
     * @author <a href="mailto:benoit.maggi@atosorigin.com">Benoit MAGGI </a>
     * @return the vector translation
     * 
     */
    protected Point getVectorTranslation()
    {
        if (oldLocation == null){
          setOldLocation(getNode().getPosition()) ; 
        }
        if (newLocation != null){
            return new Point(newLocation.x - oldLocation.x,newLocation.y - oldLocation.y);
        }
        else{
            return null;
        }
        
    }    
    
    
}
