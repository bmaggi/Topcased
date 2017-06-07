/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 **********************************************************************/
package org.topcased.modeler.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.topcased.modeler.ModelerSimpleObjectConstants;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.SimpleSemanticModelElement;
import org.topcased.modeler.edit.EMFGraphEdgeEditPart;
import org.topcased.modeler.edit.EMFGraphNodeEditPart;
import org.topcased.modeler.edit.GraphEdgeEditPart;
import org.topcased.modeler.edit.GraphNodeEditPart;
import org.topcased.modeler.edit.NoteEditPart;
import org.topcased.modeler.utils.Utils;

/**
 * A basic implementation used to render generic tools common to all Topcased diagrams. Suclasses should override the
 * createEditPart() method and call super() to enable use of these generic elements.
 * 
 * @author Jacques LESCOT
 */
public class ModelerEditPartFactory implements EditPartFactory
{
    /**
     * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
     */
    public EditPart createEditPart(EditPart context, Object model)
    {
        if (model instanceof GraphNode)
        {
            GraphNode node = (GraphNode) model;
            EObject element = Utils.getElement(node);
            if (element != null)
            {
                // A default EMFGraphNodeEditPart used to represent elements that are not associated with a model
                // element anymore (desynchronization problem)
                return new EMFGraphNodeEditPart(node);
            }
            else if (node.getSemanticModel() instanceof SimpleSemanticModelElement)
            {
                if (ModelerSimpleObjectConstants.SIMPLE_OBJECT_NOTE.equals(((SimpleSemanticModelElement) node.getSemanticModel()).getTypeInfo()))
                {
                    return new NoteEditPart(node);
                }
            }
            return new GraphNodeEditPart(node);
        }
        if (model instanceof GraphEdge)
        {
            GraphEdge edge = (GraphEdge) model;
            EObject element = Utils.getElement(edge);
            if (element != null)
            {
                // A default EMFGraphEdgeEditPart used to represent elements that are not associated with a model
                // element anymore (desynchronization problem)
                return new EMFGraphEdgeEditPart(edge);
            }
            return new GraphEdgeEditPart(edge);
        }

        throw new IllegalStateException("No edit part matches with the '" + model.getClass().getName()
                + "' model element. Check your xxxEditPartFactory#createEditPart(EditPart,Object) class");
    }

}
