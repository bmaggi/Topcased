/***********************************************************************
 * Copyright (c) 2005, 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Alfredo Serrano (Anyware Technologies)- initial API and implementation
 *    Gilles Cannenterre (Anyware Technologies) - fix bug 1397
 **********************************************************************/
package org.topcased.modeler.edit.policies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.jface.resource.StringConverter;
import org.topcased.draw2d.layout.PortConstraint;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.commands.ChangeBoundsCommand;
import org.topcased.modeler.commands.CreateGraphNodeCommand;
import org.topcased.modeler.commands.ReplaceNodeContainerCommand;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.di.model.SimpleSemanticModelElement;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.edit.BaseEditPart;
import org.topcased.modeler.edit.DynamicInstanceEditPartController;
import org.topcased.modeler.edit.IPortEditPart;
import org.topcased.modeler.requests.AutoLayoutRequest;
import org.topcased.modeler.tools.AutoLayout;
import org.topcased.modeler.utils.Utils;

/**
 * Basic Edit policy for XY layout objects.<br>
 * Add drag'n drop from outline support.<br>
 * Add Autolayout support.<br>
 * <br>
 * creation : 1 juil. 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public abstract class ModelerLayoutEditPolicy extends XYLayoutEditPolicy
{
    
    /** TheREQ_EXT_METADATA_TRANSLATE_LOCATION specifies if the location in request has to be translated */
    public static String REQ_EXT_METADATA_TRANSLATE_LOCATION = "TRANSLATE_LOCATION" ;
    private Map<GraphicalEditPart, IFigure> feedbacks = new HashMap<GraphicalEditPart, IFigure>();
    /**
     * Returns <code>true</code> if an external object can be displayed in this container. External objects are
     * objects included in a different container.<br>
     * <b>This method can be overridden by subclasses to fit with diagram requirement.</b><br>
     * Default behavior is <b>only local objects</b> are allowed.<br>
     * 
     * @param parent The container
     * @param child the child GraphNode
     * @return <code>false</code>
     */
    protected boolean isExternalObjectAllowed(GraphNode parent, GraphNode child)
    {
        return (DynamicInstanceEditPartController.instance.isExternalObjectAllowed(child, parent));
    }

    /**
     * Returns <code>true</code> if an model object can be displayed several time in the same diagram.<br>
     * <b>This method can be overridden by subclasses to fit with diagram requirement.</b><br>
     * Default behavior is <b>only one representation of an object</b> is allowed.<br>
     * 
     * @param parent The container
     * @param child the child GraphNode
     * @param needModelUpdate <code>true</code> if the model is modified by the command
     * @return <code>false</code>
     */
    protected boolean isSeveralDisplayAllowed(GraphNode parent, GraphNode child, boolean needModelUpdate)
    {
        return false;
    }

    /**
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
     */
    protected Command getCreateCommand(CreateRequest request)
    {
        Rectangle container = ((GraphicalEditPart) getHost()).getContentPane().getClientArea();
        Rectangle constraint = new Rectangle(0, 0, -1, -1);
        if (request.getLocation() != null)
        {
            constraint = (Rectangle) getConstraintFor(request);
        }

        Dimension dim = constraint.getSize();

        // According to the zoom, the size may be negative (and different of
        // -1).
        if (dim.height < 0)
        {
            dim.height = -1;
        }

        if (dim.width < 0)
        {
            dim.width = -1;
        }

        if (dim.height < 0 && dim.width < 0)
        {
            dim = null;
        }

        // get the child object to create
        Object newObject = request.getNewObject();
        if (newObject instanceof GraphNode)
        {
            // get the GraphNodes associated in the diagram model
            GraphNode parentGraphNode = (GraphNode) getHost().getModel();
            GraphNode childGraphNode = (GraphNode) newObject;
            Point loc = calculateChildPosition(constraint, (GraphicalEditPart) getHost());
            int attachment = calculateChildAttachment(childGraphNode, loc, container);
            return getCreateCommand(parentGraphNode, childGraphNode, loc, dim, attachment, true);
        }
        else if (newObject instanceof List && !((List<?>) newObject).isEmpty())
        {
            List<?> objects = (List<?>) newObject;

            CompoundCommand command = new CompoundCommand("Drag from Outline");
            for (int i = 0; i < objects.size(); i++)
            {
                Object element = objects.get(i);
                if (element instanceof GraphNode)
                {
                    // get the GraphNodes associated in the diagram model
                    GraphNode parentGraphNode = (GraphNode) getHost().getModel();
                    GraphNode childGraphNode = (GraphNode) element;

                    Point loc = calculateChildPosition(constraint, (GraphicalEditPart) getHost());
                    int attachment = calculateChildAttachment(childGraphNode, loc, container);

                    Command childCmd = getCreateCommand(parentGraphNode, childGraphNode, loc.getCopy(), dim, attachment, false);
                    if (childCmd != null && childCmd.canExecute())
                    {
                        command.add(childCmd);
                    }
                }
            }
            return command;
        }
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * Determine if the object must be attached to the nearest border. <b>Subclasses should override this method to
     * check if the model object that is created should be attached to the border like a port.</b>
     * 
     * @param node the GraphNode that is created
     * @return false by default
     */
    protected boolean isAttachedToBorder(GraphNode node)
    {
        return false;
    }

    /**
     * Gives the border to attach to. The correct returned values are NORTH, SOUTH, EAST, WEST. A combinaison of them
     * can be used by the use of the | operator. For example, to specify nearest border of the right or left border :
     * EAST | WEST. <b>Subclasses should override this method to give the border to attach the model object</b>
     * 
     * @see org.eclipse.draw2d.PositionConstants
     * @param node the GraphNode that is created
     * @return NORTH | SOUTH | EAST | WEST by default
     */
    protected int borderToAttach(GraphNode node)
    {
        return PositionConstants.NORTH | PositionConstants.SOUTH | PositionConstants.EAST | PositionConstants.WEST;
    }

    /**
     * Calculate the nearest border where the graphNode should be attached <b>at the creation</b> depending on its
     * location (<code>Point</code>) and its container (<code>Rectangle</code>)
     * 
     * @param node the graphNode that is created
     * @param loc the location where the user has clicked in the container coordinates.
     * @param container the container Figure
     * @return a <code>PositionConstant</code>
     */
    protected int calculateChildAttachment(GraphNode node, Point loc, Rectangle container)
    {
        int position = PositionConstants.NONE;

        if (isAttachedToBorder(node))
        {
            int border = borderToAttach(node);

            boolean bottom = (border & PositionConstants.SOUTH) != 0;
            boolean top = (border & PositionConstants.NORTH) != 0;
            boolean right = (border & PositionConstants.WEST) != 0;
            boolean left = (border & PositionConstants.EAST) != 0;

            int toLeft = loc.x;
            int toTop = loc.y;
            int toRight = container.width - loc.x;
            int toBottom = container.height - loc.y;

            if (left && (!top || toLeft < toTop) && (!right || toLeft < toRight) && (!bottom || toLeft < toBottom))
            {
                position = PositionConstants.LEFT;
            }
            else if (top && (!right || toTop < toRight) && (!bottom || toTop < toBottom))
            {
                position = PositionConstants.TOP;
            }
            else if (right && (!bottom || toRight < toBottom))
            {
                position = PositionConstants.RIGHT;
            }
            else
            {
                position = PositionConstants.BOTTOM;
            }
        }

        return position;
    }

    /**
     * Returns the command for the GraphElement creation
     * 
     * @param parent The container
     * @param child The child to add
     * @param loc The position
     * @param dim The selected area
     * @param pos Specify eventually the attachment of the GraphNode
     * @param needModelUpdate <code>true</code> if the model must be updated with this children, <code>false</code>
     *        if we only went to add its graphical representation.
     * @return The command
     */
    protected Command getCreateCommand(GraphNode parent, GraphNode child, Point loc, Dimension dim, int pos, boolean needModelUpdate)
    {
        if (parent != null && child != null)
        {
            EditDomain domain = getHost().getViewer().getEditDomain();

            // get the EObjects of the model
            EObject parentEObject = Utils.getElement(parent);
            EObject childEObject = Utils.getElement(child);

            // ----------------------------------
            // 1- Parent and Child cannot be null and must the child should be
            // contained by the parent
            if (isValid(childEObject, parentEObject))
            {
                // ----------------------------------

                // ----------------------------------
                // 2- Check if this object does not already belong to this
                // container
                GraphElement existingElement = Utils.getGraphElement(parent, childEObject);
                if (existingElement != null && !isSeveralDisplayAllowed(parent, child, needModelUpdate))
                {
                    return UnexecutableCommand.INSTANCE;
                }
                // ----------------------------------

                // Get the model object that should really contain the child (it
                // is not necessary the model object associated with the parent
                // GraphNode
                EObject containerEObject = getParentContainerEObject(parent, child);

                // ----------------------------------
                // 3- Check if this object is external (only done if the model
                // is not modified)
                if (!needModelUpdate)
                {
                    EObject existingContainer = childEObject.eContainer();
                    if (!containerEObject.equals(existingContainer) && !isExternalObjectAllowed(parent, child))
                    {
                        return UnexecutableCommand.INSTANCE;
                    }
                }
                // ----------------------------------

                // ----------------------------------
                // 4- Check that a StructuralFeature can host this child
                // the List where we save the possible EStructuralFeatures
                List<EReference> referencesList = new ArrayList<EReference>();

                // we check all the EStructuralFeatures of type Containment
                for (EReference eRef : containerEObject.eClass().getEAllContainments())
                {
                    // Check if the Reference is of the expected type
                    if (eRef.getEReferenceType().isInstance(childEObject))
                    {
                        referencesList.add(eRef);
                    }
                }

                if (!referencesList.isEmpty())
                {
                    // create the command associated with these parameters
                    return getCreateCommand(domain, child, parent, containerEObject, loc, dim, pos, referencesList, needModelUpdate);
                }
                
                // Check if a custom behavior have been defined in the extension point
                // "org.topcased.modeler.customEditPart" for the given element
                if ( DynamicInstanceEditPartController.instance.isDropable(child, parent, containerEObject))
                {
                    // create the command associated with these parameters
                    return new CreateGraphNodeCommand(domain, child, parent, loc, dim, pos);
                }
            }
            // No domain element is associated with the GraphNode, however this could be just a graphical element
            else if (child.getSemanticModel() instanceof SimpleSemanticModelElement)
            {
                return new CreateGraphNodeCommand(domain, child, parent, loc, dim, pos);
            }
        }

        return UnexecutableCommand.INSTANCE;
    }

    /**
     * Generate the command. By default, the generic CreateGraphNodeCommand is returned. This function should be
     * overriden to return a custumized command.
     * 
     * @param domain the EditDomain (used to init the name)
     * @param newObject the node to create
     * @param newParent the parentNode node
     * @param newContainerParent the model object that should contain the new childNode object
     * @param location the location of the created node
     * @param dimension the size of the created node
     * @param attach the newAttachment of the created node
     * @param featuresList the avalaible model element feature of the parentNode node where the model element of the
     *        childNode node can be added
     * @param needModelUpdate <code>true</code> if the model must be modified during this command, <code>false</code>
     *        if objects already exist in the mode.
     * @return the command
     */
    protected Command getCreateCommand(EditDomain domain, GraphNode newObject, GraphNode newParent, EObject newContainerParent, Point location, Dimension dimension, int attach, List featuresList,
            boolean needModelUpdate)
    {
        return new CreateGraphNodeCommand(domain, newObject, newParent, newContainerParent, location, dimension, attach, featuresList, needModelUpdate);
    }

    /**
     * By default, it is the model object associated with the parent node that should contain the child
     * 
     * @param parent the parent node
     * @return the model object that should contain the child object
     */
    protected EObject getParentContainerEObject(GraphElement parent, DiagramElement child)
    {
        return Utils.getElement(parent);
    }

    /**
     * Check if the current EObject is a valid child for the parent EObject. Subclasses should override this method to
     * proceed a better validation.
     * 
     * @param child the child EObject
     * @param parent the parent EObject
     * @return true if the child can be added
     */
    protected boolean isValid(EObject child, EObject parent)
    {
        return child != null && parent != null && DynamicInstanceEditPartController.instance.isValid(child, parent);
    }

    /**
     * Calculate the Point where to create the child node
     * 
     * @param constraint the rectangle constraint
     * @param parent the parent zone were graph node will be created
     * @return the TopLeft Point of the rectangle that contains the graphNode
     */
    protected Point calculateChildPosition(Rectangle constraint, GraphicalEditPart parent)
    {
        // the zone that delimits the diagram bounds
        Rectangle zone = parent.getContentPane().getClientArea();

        // translate the origin of the client area
        int offsetX = zone.x;
        int offsetY = zone.y;
        zone.translate(-offsetX, -offsetY);

        Point finalLocation = constraint.getLocation();

        // Verify the X position which is the top right point
        // If this point is outside the parent zone the location point
        // will be translated backwards
        int xpos = constraint.x + constraint.width;
        if (xpos > zone.width)
        {
            int diff = xpos - zone.width;
            finalLocation.x = constraint.x - diff;
        }

        // Verify the Y position which is the bottom left point
        // If this point is outside the parent zone the location point
        // will be translated backwards
        int ypos = constraint.y + constraint.height;
        if (ypos > zone.height)
        {
            int diff = ypos - zone.height;
            finalLocation.y = constraint.y - diff;
        }

        // If the final x location point is outside the container
        // it will be placed at the origin
        if (finalLocation.x < zone.x)
        {
            finalLocation.x = zone.x;
        }

        // Idem for the y location
        if (finalLocation.y < zone.y)
        {
            finalLocation.y = zone.y;
        }

        return finalLocation;
    }

    /**
     * Returns the layer used for displaying feedback.
     * 
     * @return the feedback layer
     */
    protected IFigure getFeedbackLayer()
    {
        return getLayer(LayerConstants.SCALED_FEEDBACK_LAYER);
    }

    /**
     * Create the AutoLayout Command for the given request
     * 
     * @param request the autolayout request
     * @return the autolayout command
     */
    protected Command getAutoLayoutCommand(AutoLayoutRequest request)
    {
        List<DiagramElement> elements = request.getObjects();
        int margin = 0;
        if (elements == null || elements.isEmpty())
        {
            if (getHost() instanceof BaseEditPart)
            {
                List<DiagramElement> children = ((GraphElement) ((BaseEditPart) getHost()).getModel()).getContained();
                elements = children;
                // if it is a complete autolayout, set a margin
                margin = 10;
            }
        }

        if (elements != null && !elements.isEmpty())
        {
            List<DiagramElement> filteredElts = filterAttachedToBorderObjects(elements);

            AutoLayout autoLayout = new AutoLayout((GraphicalEditPart) getHost(), false);
            autoLayout.setMargin(margin);
            // FadeAutoLayout autoLayout = new FadeAutoLayout((Diagram) diag,
            // (GraphicalEditPart) getHost(), false);
            return autoLayout.getCommand(filteredElts);
        }
        return null;
    }

    /**
     * This method removes from the given list the objects attached to the border. These objects are not handled by the
     * autolayout algorithm
     * 
     * @param elements the initial list
     * @return the filtered list
     */
    private List<DiagramElement> filterAttachedToBorderObjects(List<DiagramElement> elements)
    {
        // filter attach to border objects (cannot be autolayouted)
        List<DiagramElement> filteredElts = new ArrayList<DiagramElement>();
        for (DiagramElement child : elements)
        {
            if (child instanceof GraphNode && !isAttachedToBorder((GraphNode) child))
            {
                filteredElts.add(child);
            }
        }
        return filteredElts;
    }

    /**
     * Factors out AUTOLAYOUT, otherwise calls <code>super</code>.
     * 
     * @see org.eclipse.gef.EditPolicy#getCommand(Request)
     */
    public Command getCommand(Request request)
    {
        if (ModelerRequestConstants.REQ_AUTOLAYOUT.equals(request.getType()))
        {
            return getAutoLayoutCommand((AutoLayoutRequest) request);
        }

        return super.getCommand(request);
    }

    private Rectangle getOriginalBounds(GraphicalEditPart child)
    {
        Rectangle rect = new PrecisionRectangle(child.getFigure().getBounds());
        rect.translate(getLayoutOrigin().getNegated());
        return rect;
    }

    /**
     * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createChangeConstraintCommand(org.eclipse.gef.requests.ChangeBoundsRequest,
     *      org.eclipse.gef.EditPart, java.lang.Object)
     */
    protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint)
    {
        boolean constraintFree = false;
        Object constraintFreeProperty = request.getExtendedData().get(ModelerRequestConstants.PROP_CONSTRAINT_FREE);
        if (constraintFreeProperty instanceof Boolean)
        {
            constraintFree = ((Boolean) constraintFreeProperty).booleanValue();
        }

        Rectangle newBounds = null;
        if (constraint instanceof PortConstraint)
        {
            newBounds = ((PortConstraint) constraint).getRectConstraints();
        }
        else
        {
            newBounds = (Rectangle) constraint;
        }
        Rectangle oldBounds = getOriginalBounds((GraphicalEditPart) child);

        int xDelta = newBounds.x - oldBounds.x;
        int yDelta = newBounds.y - oldBounds.y;

        switch (request.getResizeDirection())
        {
            // check whether the parent figure is resized through the North side
            case PositionConstants.NORTH_EAST:
            case PositionConstants.NORTH:
                // resize also children elements typed as Port
                if (yDelta != 0)
                {
                    CompoundCommand compoundCommand = new CompoundCommand();

                    for (Object childPart : child.getChildren())
                    {
                        if (childPart instanceof IPortEditPart)
                        {
                            GraphNode childNode = (GraphNode) ((GraphicalEditPart) childPart).getModel();
                            Property portPositionProperty = DIUtils.getProperty(childNode,
                                    ModelerPropertyConstants.PORT_POSITION);
                            if (portPositionProperty != null)
                            {
                                int portPosition = StringConverter.asInt(portPositionProperty.getValue());
                                if (childNode.getPosition().y - yDelta > 0)
                                {
                                    compoundCommand.add(new ChangeBoundsCommand(childNode, new PortConstraint(
                                            new Rectangle(childNode.getPosition().getTranslated(0, -yDelta),
                                                    childNode.getSize()), portPosition)));
                                }
                                else if (portPosition == PositionConstants.LEFT
                                        || portPosition == PositionConstants.RIGHT)
                                {
                                    compoundCommand.add(new ChangeBoundsCommand(childNode, new PortConstraint(
                                            new Rectangle(new Point(-1, 0), childNode.getSize()), portPosition)));
                                }
                            }
                        }
                    }

                    compoundCommand.add(createChangeConstraintCommand(child, constraint, !constraintFree));
                    return compoundCommand;
                }
                break;

            case PositionConstants.NORTH_WEST:
                // resize also children elements typed as Port
                if (yDelta != 0 || xDelta != 0)
                {
                    CompoundCommand compoundCommand = new CompoundCommand();

                    for (Object childPart : child.getChildren())
                    {
                        if (childPart instanceof IPortEditPart)
                        {
                            GraphNode childNode = (GraphNode) ((GraphicalEditPart) childPart).getModel();
                            Property portPositionProperty = DIUtils.getProperty(childNode,
                                    ModelerPropertyConstants.PORT_POSITION);
                            if (portPositionProperty != null)
                            {
                                int portPosition = StringConverter.asInt(portPositionProperty.getValue());
                                if (childNode.getPosition().y - yDelta > 0 && childNode.getPosition().x - xDelta > 0)
                                {
                                    compoundCommand.add(new ChangeBoundsCommand(childNode, new PortConstraint(
                                            new Rectangle(childNode.getPosition().getTranslated(-xDelta, -yDelta),
                                                    childNode.getSize()), portPosition)));
                                }
                                else if ((portPosition == PositionConstants.TOP || portPosition == PositionConstants.BOTTOM)
                                        && childNode.getPosition().y - yDelta > 0
                                        && childNode.getPosition().x - xDelta <= 0)
                                {
                                    compoundCommand.add(new ChangeBoundsCommand(childNode, new PortConstraint(
                                            new Rectangle(new Point(0, childNode.getPosition().y).getTranslated(0,
                                                    -yDelta), childNode.getSize()), portPosition)));
                                }
                                else if (portPosition == PositionConstants.LEFT
                                        && childNode.getPosition().y - yDelta <= 0
                                        && childNode.getPosition().x - xDelta > 0)
                                {
                                    compoundCommand.add(new ChangeBoundsCommand(childNode, new PortConstraint(
                                            new Rectangle(new Point(childNode.getPosition().x, 0).getTranslated(
                                                    -xDelta, 0), childNode.getSize()), portPosition)));
                                }
                                else if ((portPosition == PositionConstants.TOP
                                        || portPosition == PositionConstants.BOTTOM || portPosition == PositionConstants.LEFT)
                                        && childNode.getPosition().y - yDelta <= 0
                                        && childNode.getPosition().x - xDelta <= 0)
                                {
                                    compoundCommand.add(new ChangeBoundsCommand(childNode, new PortConstraint(
                                            new Rectangle(new Point(0, 0), childNode.getSize()), portPosition)));
                                }
                            }
                        }
                    }

                    compoundCommand.add(createChangeConstraintCommand(child, constraint, !constraintFree));
                    return compoundCommand;
                }
                break;

            case PositionConstants.WEST:
            case PositionConstants.SOUTH_WEST:
                // resize also children elements typed as Port
                if (xDelta != 0)
                {
                    CompoundCommand compoundCommand = new CompoundCommand();

                    for (Object childPart : child.getChildren())
                    {
                        if (childPart instanceof IPortEditPart)
                        {
                            GraphNode childNode = (GraphNode) ((GraphicalEditPart) childPart).getModel();
                            Property portPositionProperty = DIUtils.getProperty(childNode,
                                    ModelerPropertyConstants.PORT_POSITION);
                            if (portPositionProperty != null)
                            {
                                int portPosition = StringConverter.asInt(portPositionProperty.getValue());
                                if (childNode.getPosition().x - xDelta > 0)
                                {
                                    compoundCommand.add(new ChangeBoundsCommand(childNode, new PortConstraint(
                                            new Rectangle(childNode.getPosition().getTranslated(-xDelta, 0),
                                                    childNode.getSize()), portPosition)));
                                }
                                else if (portPosition == PositionConstants.TOP
                                        || portPosition == PositionConstants.BOTTOM)
                                {
                                    compoundCommand.add(new ChangeBoundsCommand(childNode, new PortConstraint(
                                            new Rectangle(new Point(0, -1), childNode.getSize()), portPosition)));
                                }
                            }
                        }
                    }

                    compoundCommand.add(createChangeConstraintCommand(child, constraint, !constraintFree));
                    return compoundCommand;
                }
                break;

            default:
                break;
        }
        return createChangeConstraintCommand(child, constraint, !constraintFree);
    }

    /**
     * Overridden to prevent sizes from becoming too small, and to prevent preferred sizes from getting lost. If the
     * Request is a MOVE, the existing width and height are preserved. During RESIZE, the new width and height have a
     * lower bound determined by {@link #getMinimumSizeFor(GraphicalEditPart)} and the current Attachment is preserved.
     * 
     * @see org.eclipse.gef.editpolicies.XYLayoutEditPolicy#getConstraintFor(org.eclipse.gef.requests.ChangeBoundsRequest,
     *      org.eclipse.gef.GraphicalEditPart)
     */
    protected Object getConstraintFor(ChangeBoundsRequest request, GraphicalEditPart child)
    {
        Rectangle rect = new PrecisionRectangle(child.getFigure().getBounds());
        child.getFigure().translateToAbsolute(rect);
        Rectangle original = rect.getCopy();
        rect = request.getTransformedRectangle(rect);
        child.getFigure().translateToRelative(rect);
        rect.translate(getLayoutOrigin().getNegated());

        if (request.getSizeDelta().width == 0 && request.getSizeDelta().height == 0)
        {
            Rectangle cons = getCurrentConstraintFor(child);
            if (cons != null)
            {
                // method
                rect.setSize(cons.width, cons.height);
            }
        }
        else
        { // resize
            Dimension minSize = getMinimumSizeFor(child);
            if (rect.width < minSize.width)
            {
                rect.width = minSize.width;
                if (rect.x > (original.right() - minSize.width))
                {
                    rect.x = original.right() - minSize.width;
                }
            }
            if (rect.height < minSize.height)
            {
                rect.height = minSize.height;
                if (rect.y > (original.bottom() - minSize.height))
                {
                    rect.y = original.bottom() - minSize.height;
                }
            }
        }

        // Return the appropriate Constraint depending on the parent LayoutManager
        IFigure lParent = child.getFigure().getParent();
        if(lParent != null)
        {
            if (lParent.getLayoutManager().getConstraint(child.getFigure()) instanceof PortConstraint)
            {
                int attach = Integer.parseInt(DIUtils.getPropertyValue((DiagramElement) child.getModel(), ModelerPropertyConstants.PORT_POSITION));
    
                PortConstraint constraint = new PortConstraint(rect, attach);
    
                // When the ChangeBoundsRequest is a Move, we need to recalculate the child attachment. It will prevent a
                // bug from the AutoResizer command that will always attach the node to the top border (as the MouseLocation
                // is 0,0).
                if (RequestConstants.REQ_MOVE_CHILDREN.equals(request.getType())
                        || RequestConstants.REQ_MOVE.equals(request.getType()))
                {
                    constraint.setAttachment(calculateChildAttachment((GraphNode) child.getModel(),
                            getAbsoluteMouseLocation(request.getLocation()),
                            ((AbstractGraphicalEditPart) getHost()).getContentPane().getClientArea()));
                }
    
                return constraint;
            }
        }
        return getConstraintFor(rect);
    }

    /**
     * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#getConstraintFor(org.eclipse.gef.requests.CreateRequest)
     */
    protected Object getConstraintFor(CreateRequest request)
    {
        IFigure figure = getLayoutContainer();

        Point where = request.getLocation().getCopy();
        Dimension size = request.getSize();

        // check if the location has to be translated
        Boolean translate = (Boolean) request.getExtendedData().get(REQ_EXT_METADATA_TRANSLATE_LOCATION);
        if (translate == null)
        {
            translate = true ;
        }
        if (translate)
        {
            figure.translateToRelative(where);
            figure.translateFromParent(where);
            where.translate(getLayoutOrigin().getNegated());
        }
        

        // Prevent the check of size.isEmpty(). Keep the height or the width even if it is automatic (-1)
        if (size == null)
        {
            return getConstraintFor(where);
        }
        else
        {
            size = size.getCopy();
            figure.translateToRelative(size);
            figure.translateFromParent(size);
            return getConstraintFor(new Rectangle(where, size));
        }
    }

    /**
     * Get the absolute coordinates from relative coordinates given by the pointer Location
     * 
     * @param relativeLocation
     * @return Point with absolute coordinates
     */
    protected Point getAbsoluteMouseLocation(Point relativeLocation)
    {
        Point location = relativeLocation.getCopy();
        if (location != null)
        {
            IFigure figure = getLayoutContainer();

            figure.translateToRelative(location);
            figure.translateFromParent(location);
            location.translate(getLayoutOrigin().getNegated());

            return location;
        }

        return new Point(0, 0);
    }

    /**
     * Retrieves the child's current constraint from the <code>LayoutManager</code>.
     * 
     * @param child the child
     * @return the current constraint
     */
    protected Rectangle getCurrentConstraintFor(GraphicalEditPart child)
    {
        IFigure fig = child.getFigure();
        if (fig.getParent().getLayoutManager().getConstraint(fig) instanceof PortConstraint)
        {
            return ((PortConstraint) fig.getParent().getLayoutManager().getConstraint(fig)).getRectConstraints();
        }
        return (Rectangle) fig.getParent().getLayoutManager().getConstraint(fig);
    }

    /**
     * Check if the node (child) is always in the diagram bounds
     * 
     * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createChangeConstraintCommand(org.eclipse.gef.EditPart,
     *      java.lang.Object)
     */
    protected Command createChangeConstraintCommand(EditPart child, Object constraint)
    {
        return createChangeConstraintCommand(child, constraint, true);
    }

    /**
     * Create the command to change the constraints of the EditPart.
     * 
     * @param child the EditPart to move
     * @param constraint the new constraints
     * @param checkConstraint if <code>true</code> the command is created only if the bounds are in the parent client
     *        area.
     * @return the ChangeBoundsCommand
     */
    protected Command createChangeConstraintCommand(EditPart child, Object constraint, boolean checkConstraint)
    {
        GraphNode node = (GraphNode) child.getModel();

        if (constraint instanceof PortConstraint)
        {
            return new ChangeBoundsCommand(node, (PortConstraint) constraint);
        }
        else if (!checkConstraint || isValidConstraint((GraphicalEditPart) getHost(), (Rectangle) constraint))
        {
            return new ChangeBoundsCommand(node, (Rectangle) constraint);
        }

        return null;
    }

    /**
     * Check if the given constraint location is valid for a child of this editpart
     * 
     * @param parent the parent editpart
     * @param constraint the child constraint
     * @return <code>true</code> if these constraints are valid
     */
    protected boolean isValidConstraint(GraphicalEditPart parent, Rectangle constraint)
    {
        // the zone that delimits the diagram bounds
        Rectangle zone = parent.getContentPane().getClientArea();

        // translate the zone (because "(Rectangle) constraint" is relative to
        // the zone)
        int offsetX = zone.x;
        int offsetY = zone.y;
        zone.translate(-offsetX, -offsetY);

        return zone.contains(constraint);
    }

    /**
     * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createAddCommand(org.eclipse.gef.EditPart,
     *      java.lang.Object)
     */
    protected Command createAddCommand(EditPart child, Object constraint)
    {
        Rectangle rect = (Rectangle) constraint;
        return new ReplaceNodeContainerCommand((GraphElement) child.getModel(), (GraphElement) getHost().getModel(), rect.getLocation());
    }

    /**
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getDeleteDependantCommand(org.eclipse.gef.Request)
     */
    protected Command getDeleteDependantCommand(Request request)
    {
        return null;
    }

    /**
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#createChildEditPolicy(org.eclipse.gef.EditPart)
     */
    protected EditPolicy createChildEditPolicy(EditPart child)
    {
        return null;
    }

    /**
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#showLayoutTargetFeedback(org.eclipse.gef.Request)
     */
    protected void showLayoutTargetFeedback(Request request)
    {
        if (request instanceof ChangeBoundsRequest)
        {
            showChangeBoundsFeedback((ChangeBoundsRequest) request);
        }
    }

    /**
     * Displays the feedback for all the objects modified by the given request.
     * 
     * @param request the request that changes the objects
     */
    private void showChangeBoundsFeedback(ChangeBoundsRequest request)
    {
        GraphicalEditPart child;
        List<?> children = request.getEditParts();

        for (int i = 0; i < children.size(); i++)
        {
            child = (GraphicalEditPart) children.get(i);
            showFeedback(child, translateToModelConstraint(getConstraintFor(request, child)));
        }
    }

    /**
     * Show the feedback for a given editpart and the given request
     * 
     * @param child the modified edit part
     * @param constraints the new constraints
     */
    private void showFeedback(GraphicalEditPart child, Object constraints)
    {
        Rectangle bounds;
        IFigure containerFigure = ((AbstractGraphicalEditPart) getHost()).getContentPane();

        if (constraints instanceof PortConstraint)
        {
            bounds = ((PortConstraint) constraints).getRectConstraints();
        }
        else
        {
            bounds = (Rectangle) constraints;
        }

        if (bounds != null)
        {
            Point offset = containerFigure.getClientArea().getLocation();

            if (bounds.width < 0 || bounds.height < 0)
            {
                Dimension prefSize = child.getFigure().getPreferredSize(bounds.width, bounds.height);
                bounds = bounds.getCopy();
                if (bounds.width < 0)
                {
                    bounds.width = prefSize.width;
                }
                if (bounds.height < 0)
                {
                    bounds.height = prefSize.height;
                }
            }

            if (constraints instanceof PortConstraint)
            {
                // calculate and update the new constraints of the figure
                // according to the attachment constraint
                switch (((PortConstraint) constraints).getAttachment())
                {
                    case PositionConstants.LEFT:
                        bounds.x = containerFigure.getInsets().left;
                        bounds.y = Math.min(bounds.y, containerFigure.getClientArea().height - bounds.height - containerFigure.getInsets().bottom);
                        break;
                    case PositionConstants.TOP:
                        bounds.x = Math.min(bounds.x, containerFigure.getClientArea().width - bounds.width - containerFigure.getInsets().right);
                        bounds.y = containerFigure.getInsets().top;
                        break;
                    case PositionConstants.RIGHT:
                        bounds.x = containerFigure.getClientArea().width - bounds.width - containerFigure.getInsets().right;
                        bounds.y = Math.min(bounds.y, containerFigure.getClientArea().height - bounds.height - containerFigure.getInsets().bottom);
                        break;
                    case PositionConstants.BOTTOM:
                        bounds.x = Math.min(bounds.x, containerFigure.getClientArea().width - bounds.width - containerFigure.getInsets().right);
                        bounds.y = containerFigure.getClientArea().height - bounds.height - containerFigure.getInsets().bottom;
                        break;

                    default:
                        break;
                }
            }

            bounds = bounds.getTranslated(offset);
            IFigure feedbackFigure = getFeedbackFigure(child);
            feedbackFigure.setBounds(bounds);
        }
    }

    /**
     * Creates the default feedback figure
     * 
     * @return a new feedback figure
     */
    protected IFigure createFeedbackFigure()
    {
        // Use a ghost rectangle for feedback
        RectangleFigure r = new RectangleFigure();
        FigureUtilities.makeGhostShape(r);
        r.setLineStyle(Graphics.LINE_DOT);
        r.setForegroundColor(ColorConstants.white);
        addFeedback(r);
        return r;
    }

    /**
     * Lazily creates and returns the feedback figure used during drags.
     * 
     * @param child the edit part to show the feedback for
     * @return the feedback figure
     */
    protected IFigure getFeedbackFigure(GraphicalEditPart child)
    {
        IFigure feedback = feedbacks.get(child);
        if (feedback == null)
        {
            feedback = createFeedbackFigure();
            feedbacks.put(child, feedback);
        }
        return feedback;
    }

    /**
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#eraseLayoutTargetFeedback(org.eclipse.gef.Request)
     */
    protected void eraseLayoutTargetFeedback(Request request)
    {
        removeFeedbacks();
    }

    private void removeFeedbacks()
    {
        for (IFigure f : feedbacks.values())
        {
            removeFeedback(f);
        }
        feedbacks.clear();
    }

    /**
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#deactivate()
     */
    public void deactivate()
    {
        removeFeedbacks();

        super.deactivate();
    }
}
