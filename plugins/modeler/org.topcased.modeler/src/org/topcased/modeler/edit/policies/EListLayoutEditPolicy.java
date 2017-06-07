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
package org.topcased.modeler.edit.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.topcased.modeler.commands.CreateGraphNodeCommand;
import org.topcased.modeler.commands.ReplaceNodeContainerCommand;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.utils.Utils;

/**
 * A Layout that allow creation of eObjects in relation with an
 * eStructuralFeature of the parent eObject or not.
 * 
 * Creation : 09 jan. 2006
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class EListLayoutEditPolicy extends OrderedLayoutEditPolicy {
	private EStructuralFeature[] eStructuralFeatures;

	private boolean isSynchronized = false;

	/**
	 * The Constructor
	 * 
	 * @param feature
	 *            the EStructural feature that should be listed
	 */
	public EListLayoutEditPolicy(EStructuralFeature feature) {
		this(feature, false);
	}

	/**
	 * The Constructor
	 * 
	 * @param feature
	 *            the EStructural feature that should be listed
	 */
	public EListLayoutEditPolicy(boolean isSynchronized,
			EStructuralFeature... features) {
		super();
		this.eStructuralFeatures = features;
		this.isSynchronized = isSynchronized;
	}

	public EListLayoutEditPolicy(EStructuralFeature feature, boolean b) {
		this(b, new EStructuralFeature[] { feature });
	}

	/**
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 */
	protected Command getCreateCommand(CreateRequest request) {
		// get the child object to create
		Object newObject = request.getNewObject();

		List referencesList = new ArrayList();
		if (newObject instanceof GraphElement)
		{
			referencesList.add(getCorresponding(eStructuralFeatures, Utils.getElement((GraphElement) newObject)));
		}
		else
		{
			referencesList.add(getCorresponding(eStructuralFeatures, newObject));
		}

		if (newObject instanceof GraphNode) {
			// get the GraphNodes associated in the diagram model
			GraphNode parentGraphNode = (GraphNode) getHost().getModel();
			GraphNode childGraphNode = (GraphNode) newObject;

			return getCreateCommand(parentGraphNode, childGraphNode,
					new Point(), new Dimension(), referencesList, true);
		} else if (newObject instanceof List) {
			List objects = (List) request.getNewObject();

			if (objects.isEmpty()) {
				return UnexecutableCommand.INSTANCE;
			}

			CompoundCommand command = new CompoundCommand("Drag from Outline");
			for (int i = 0; i < objects.size(); i++) {
				Object element = objects.get(i);
				if (element instanceof GraphNode) {

					// get the GraphNodes associated in the diagram model
					GraphNode parentGraphNode = (GraphNode) getHost()
							.getModel();
					GraphNode childGraphNode = (GraphNode) element;

					Command childCmd = getCreateCommand(parentGraphNode,
							childGraphNode, new Point(), new Dimension(),
							referencesList, false);
					if (childCmd != null && childCmd.canExecute()) {
						command.add(childCmd);
					}
				}
			}
			return command;
		}
		return UnexecutableCommand.INSTANCE;
	}

	private Object getCorresponding(EStructuralFeature[] eStructuralFeatures2,
			Object newObject) {
		for (EStructuralFeature f : eStructuralFeatures2) {
			if (f.getEType().isInstance(newObject)) {
				return f;
			}
		}
		return null;
	}

	/**
	 * Check if the current EObject is a valid child for the parent EObject.
	 * 
	 * @param child
	 *            the child EObject
	 * @param parent
	 *            the parent EObject
	 * @return true if the child can be added
	 */
	protected boolean isValid(EObject child, EObject parent) {
		boolean result = false;
		if (eStructuralFeatures != null && eStructuralFeatures.length > 0) {
			result = child != null && parent != null;
			if (result) {
				result = false;
				for (EStructuralFeature f : eStructuralFeatures) {
					result |= f.getEType().isInstance(child);
				}
			}
		}
		return result;
	}

	/**
	 * @see org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy#createAddCommand(org.eclipse.gef.EditPart,
	 *      org.eclipse.gef.EditPart)
	 */
	protected Command createAddCommand(EditPart child, EditPart after) {
		GraphElement childNode = (GraphElement) child.getModel();
		EObject childModel = Utils.getElement(childNode);
		for (EStructuralFeature eStructuralFeature : eStructuralFeatures) {
			if (eStructuralFeature != null
					&& eStructuralFeature.getEType().isInstance(childModel)) {
				ReplaceNodeContainerCommand cmd = new ReplaceNodeContainerCommand(
						childNode, (GraphElement) getHost().getModel(),
						new Point());
				cmd.setSynchronization(isSynchronized);
				return cmd;
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @see org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy#createMoveChildCommand(org.eclipse.gef.EditPart,
	 *      org.eclipse.gef.EditPart)
	 */
	protected Command createMoveChildCommand(EditPart child, EditPart after) {
		return null;
	}

	/**
	 * @see org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy#getInsertionReference(org.eclipse.gef.Request)
	 */
	protected EditPart getInsertionReference(Request request) {
		return null;
	}

	/**
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getDeleteDependantCommand(org.eclipse.gef.Request)
	 */
	protected Command getDeleteDependantCommand(Request request) {
		return null;
	}

	/**
	 * Returns <code>true</code> if a model object can be displayed several time
	 * in the same list.<br>
	 * <b>This method can be overridden by subclasses to fit with diagram
	 * requirement.</b><br>
	 * Default behavior is <b>only one representation of an object</b> is
	 * allowed.<br>
	 * 
	 * @param parent
	 *            The container
	 * @param child
	 *            the child GraphNode
	 * @param needModelUpdate
	 *            <code>true</code> if the model is modified by the command
	 * @return <code>false</code>
	 */
	protected boolean isSeveralDisplayAllowed(GraphNode parent,
			GraphNode child, boolean needModelUpdate) {
		return false;
	}

	/**
	 * Returns <code>true</code> if an external object can be displayed in this
	 * container. External objects are objects included in a different
	 * container.<br>
	 * <b>This method can be overridden by subclasses to fit with diagram
	 * requirement.</b><br>
	 * Default behavior is <b>only local objects</b> are allowed.<br>
	 * 
	 * @param parent
	 *            The container
	 * @param child
	 *            the child GraphNode
	 * @return <code>false</code>
	 */
	protected boolean isExternalObjectAllowed(GraphNode parent, GraphNode child) {
		return false;
	}

	/**
	 * Returns the command for the GraphElement creation
	 * 
	 * @param parent
	 *            The container
	 * @param child
	 *            The child to add
	 * @param loc
	 *            The position
	 * @param dim
	 *            The selected area
	 * @param featuresList
	 *            the avalaible model element feature of the parentNode node
	 *            where the model element of the childNode node can be added
	 * @param needModelUpdate
	 *            <code>true</code> if the model must be updated with this
	 *            children, <code>false</code> if we only went to add its
	 *            graphical representation.
	 * @return The command
	 */
	protected Command getCreateCommand(GraphNode parent, GraphNode child,
			Point loc, Dimension dim, List featuresList, boolean needModelUpdate) {
		if (parent != null && child != null) {
			EditDomain domain = getHost().getViewer().getEditDomain();

			// get the EObjects of the model
			EObject parentEObject = Utils.getElement(parent);
			EObject childEObject = Utils.getElement(child);

			// ----------------------------------
			// 1- Parent and Child cannot be null and must the child should be
			// contained by the parent
			if (isValid(childEObject, parentEObject)) {
				// ----------------------------------

				// ----------------------------------
				// 2- Check if this object does not already belong to this
				// container
				GraphElement existingElement = Utils.getGraphElement(parent,
						childEObject);
				if (existingElement != null
						&& !isSeveralDisplayAllowed(parent, child,
								needModelUpdate)) {
					return UnexecutableCommand.INSTANCE;
				}
				// ----------------------------------

				// Get the model object that should really contain the child (it
				// is not necessary the model object associated with the parent
				// GraphNode
				EObject containerEObject = getParentContainerEObject(parent,
						child);

				// ----------------------------------
				// 3- Check if this object is external (only done if the model
				// is not modified)
				if (!needModelUpdate) {
					EObject existingContainer = childEObject.eContainer();
					if (!containerEObject.equals(existingContainer)
							&& !isExternalObjectAllowed(parent, child)) {
						return UnexecutableCommand.INSTANCE;
					}
				}
				// ----------------------------------

				if (!featuresList.isEmpty()) {
					// create the command associated with these parameters
					return getCreateCommand(domain, child, parent,
							containerEObject, loc, dim, featuresList,
							needModelUpdate);
				}
			}
		}

		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Generate the command. By default, the generic CreateGraphNodeCommand is
	 * returned. This function should be overriden to return a custumized
	 * command.
	 * 
	 * @param domain
	 *            the EditDomain (used to init the name)
	 * @param newObject
	 *            the node to create
	 * @param newParent
	 *            the parentNode node
	 * @param newContainerParent
	 *            the model object that should contain the new childNode object
	 * @param location
	 *            the location of the created node
	 * @param dimension
	 *            the size of the created node
	 * @param featuresList
	 *            the avalaible model element feature of the parentNode node
	 *            where the model element of the childNode node can be added
	 * @param needModelUpdate
	 *            <code>true</code> if the model must be modified during this
	 *            command, <code>false</code> if objects already exist in the
	 *            mode.
	 * 
	 * @return the command
	 */
	protected Command getCreateCommand(EditDomain domain, GraphNode newObject,
			GraphNode newParent, EObject newContainerParent, Point location,
			Dimension dimension, List featuresList, boolean needModelUpdate) {
		return new CreateGraphNodeCommand(domain, newObject, newParent,
				newContainerParent, location, dimension,
				PositionConstants.NONE, featuresList, needModelUpdate);
	}

	/**
	 * By default, it is the model object associated with the parent node that
	 * should contain the child
	 * 
	 * @param parent
	 *            the parent node
	 * @return the model object that should contain the child object
	 */
	protected EObject getParentContainerEObject(GraphElement parent,
			DiagramElement child) {
		return Utils.getElement(parent);
	}

}
