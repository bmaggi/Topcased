/*******************************************************************************
 * Copyright (c) 2005,2010 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Sebastien Gabel (CS) - API changes and evolutions - fix warnings 
 *******************************************************************************/
package org.topcased.modeler.edit.policies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.jface.resource.StringConverter;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.commands.CreateGraphNodeCommand;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.utils.Utils;

/**
 * A Policy that provides support for the creation Command of a GraphNode and the drop Command.
 * 
 * Creation : 24 October 2005<br>
 * Update : 17 February 2010<br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 */
public class MultiPortLayoutEditPolicy extends OrderedLayoutEditPolicy
{
    /**
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
     */
    protected Command getCreateCommand(CreateRequest request)
    {
        Dimension dim = null;
        Point loc = new Point(0, 0);

        // get the child object to create
        Object newObject = request.getNewObject();
        if (newObject instanceof GraphNode)
        {
            // get the GraphNodes associated in the diagram model
            GraphNode parentGraphNode = (GraphNode) getHost().getModel();
            GraphNode childGraphNode = (GraphNode) newObject;

            return getCreateCommand(parentGraphNode, childGraphNode, loc, dim, true);
        }
        else if (newObject instanceof List< ? > && !((List< ? >) newObject).isEmpty())
        {
            List< ? > objects = (List< ? >) newObject;
            CompoundCommand cc = new CompoundCommand("Drag from Outline");
            for (Object element : objects)
            {
                if (element instanceof GraphNode)
                {
                    // get the GraphNodes associated in the diagram model
                    GraphNode parentGraphNode = (GraphNode) getHost().getModel();
                    GraphNode childGraphNode = (GraphNode) element;

                    Command childCmd = getCreateCommand(parentGraphNode, childGraphNode, loc.getCopy(), dim, false);
                    if (childCmd != null && childCmd.canExecute())
                    {
                        cc.add(childCmd);
                    }
                }
            }
            return cc;
        }
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * Returns the command for the GraphElement creation
     * 
     * @param parent The container
     * @param child The child to add to this container
     * @param loc The default position
     * @param dim The selected area
     * @param needModelUpdate <code>true</code> if the model must be updated with this children, <code>false</code> if
     *        we only went to add its graphical representation.
     * @return The create command
     */
    protected Command getCreateCommand(GraphNode parent, GraphNode child, Point loc, Dimension dim, boolean needModelUpdate)
    {
        if (parent != null && child != null)
        {
            // get the EObjects of the model
            EObject parentEObject = Utils.getElement(parent);
            EObject childEObject = Utils.getElement(child);

            // 1- Parent and Child cannot be null and must the child should be contained by the parent
            if (isValid(childEObject, parentEObject))
            {
                // 2- Check if this object does not already belong to this container
                GraphElement existingElement = Utils.getGraphElement(parent, childEObject);
                if (existingElement != null && !isSeveralDisplayAllowed(parent, child, needModelUpdate))
                {
                    return UnexecutableCommand.INSTANCE;
                }

                // 3- Check if this object is external (only done if the model is not modified)
                if (!needModelUpdate)
                {
                    EObject existingContainer = childEObject.eContainer();
                    if (!parentEObject.equals(existingContainer) && !isExternalObjectAllowed(parent, child))
                    {
                        return UnexecutableCommand.INSTANCE;
                    }
                }

                // get the model object that should really contain the child (it
                // is not necessary the model object associated with the parent
                // GraphNode
                EObject containerEObject = getParentContainerEObject(parent);

                // 4- Check that a StructuralFeature can host this child
                // the List where we save the possible EStructuralFeatures
                List<EReference> referencesList = new ArrayList<EReference>();

                // we check all the EStructuralFeatures of type Containment
                for (Iterator<EReference> i = containerEObject.eClass().getEAllContainments().iterator(); i.hasNext();)
                {
                    EReference eRef = (EReference) i.next();
                    // Check if the Reference is of the expected type
                    if (eRef.getEReferenceType().isInstance(childEObject))
                    {
                        referencesList.add(eRef);
                    }
                }

                if (!referencesList.isEmpty())
                {
                    return getCreateCommand(parent, child, containerEObject, loc, dim, referencesList, needModelUpdate);
                }
            }
        }
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * Returns the command for the GraphElement creation
     * 
     * @param parent The parent GraphElement
     * @param child The GraphElement to create
     * @param parentContainer The model object associated to the parent GraphElement
     * @param loc The default location
     * @param dim The selected area
     * @param features The references that will contain the child model element
     * @param needModelUpdate
     * @param needModelUpdate <code>true</code> if the model must be updated with this children, <code>false</code> if
     *        we only went to add its graphical representation.
     * @return The create command
     */
    protected Command getCreateCommand(GraphNode parent, GraphNode child, EObject parentContainer, Point loc, Dimension dim, List< ? extends EStructuralFeature> features, boolean needModelUpdate)
    {
        // Gets the edit domain
        EditDomain domain = getHost().getViewer().getEditDomain();

        // compute the required attachment for child
        int attachment = getAttachment(parent);

        // create the command associated with these parameters
        return new CreateGraphNodeCommand(domain, child, parent, parentContainer, loc, dim, attachment, features, needModelUpdate);
    }

    /**
     * Gets the attachment according to the {@link GraphNode} parent.
     * 
     * @param parent The GraphNode parent
     * @return the attachment
     */
    protected int getAttachment(GraphNode parent)
    {
        int attachment = PositionConstants.NONE;

        // The attachment should be the same as the parent Node
        if (DIUtils.getProperty(parent, ModelerPropertyConstants.PORT_POSITION) != null)
        {
            attachment = StringConverter.asInt(DIUtils.getPropertyValue(parent, ModelerPropertyConstants.PORT_POSITION));
        }
        return attachment;
    }

    /**
     * Returns <code>true</code> if an external object can be displayed in this container. External objects are objects
     * included in a different container.<br>
     * <b>This method can be overridden by subclasses to fit with diagram requirement.</b><br>
     * Default behavior is <b>only local objects</b> are allowed.<br>
     * 
     * @param parent The container
     * @param child the child GraphNode
     * @return <code>false</code>
     */
    protected boolean isExternalObjectAllowed(GraphNode parent, GraphNode child)
    {
        return false;
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
     * By default, it is the model object associated with the parent node that should contain the child
     * 
     * @param parent the parent node
     * @return the model object that should contain the child object
     */
    protected EObject getParentContainerEObject(GraphElement parent)
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
        return (child != null && parent != null);
    }

    /**
     * Calculate the Point where to create the child node
     * 
     * @param constraint the rectangle constraint
     * @param childGraphNode the graphNode to create
     * @return the TopLeft Point of the rectangle that contains the graphNode
     */
    protected Point calculateChildPosition(Rectangle constraint, GraphNode childGraphNode)
    {
        return constraint.getLocation();
    }

    /**
     * @see org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy#createMoveChildCommand(org.eclipse.gef.EditPart,
     *      org.eclipse.gef.EditPart)
     */
    protected Command createMoveChildCommand(EditPart child, EditPart after)
    {
        return null;
    }

    /**
     * @see org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy#getInsertionReference(org.eclipse.gef.Request)
     */
    protected EditPart getInsertionReference(Request request)
    {
        return null;
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
     * @see org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy#createAddCommand(org.eclipse.gef.EditPart,
     *      org.eclipse.gef.EditPart)
     */
    protected Command createAddCommand(EditPart child, EditPart after)
    {
        return null;
    }
}
