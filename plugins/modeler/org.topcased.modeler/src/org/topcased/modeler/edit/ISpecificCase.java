/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Caroline Bourdeu d'Aguerre (2009) caroline.bourdeudaguerre@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.edit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;

public interface ISpecificCase
{
    
    /**
     * Default case.
     * This interface in implemented by class that are plug the the extension 
     * point : org.topcased.modeler.customEditPart
     * @param node the node
     * @param diagramType the diagram type
     * 
     * @return the edits the part
     */
    EditPart defaultCase (GraphElement element, Class< ? > diagramType) ;
    
    /**
     * Check if the type is correct
     * @param object to check the type
     * @param editPart
     * @return
     */
    boolean isEnabled(Object object, EditPart editPart);
    
    /**
     * Check if the child is dropable in the given parent
     * @param child
     * @param parent
     * @return true if the child is dropable
     */
    boolean isDropable(EObject child, GraphNode parent);

    public GraphElement setPropertyGraphElement(GraphElement graphElement);

    /**
     * Check if the given child can be added to the parent
     * @param child
     * @param parent
     * @return
     */
	boolean isExternalObjectAllowed(GraphNode child, GraphNode parent);

	/**
	 * Check if the child can be a child of the given parent
	 * @param child
	 * @param parent
	 * @return
	 */
	boolean isValid(EObject child, EObject parent);
}

