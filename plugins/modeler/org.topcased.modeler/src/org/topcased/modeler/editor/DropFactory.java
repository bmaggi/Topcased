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
package org.topcased.modeler.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.requests.CreationFactory;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;

/**
 * This factory is used for the creation of graphical objects from existing
 * model objects. <br>
 * creation : 4 mai 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class DropFactory implements CreationFactory
{
    private Modeler modeler;

    private List transfer;

    private List result;

    /**
     * The Constructor
     * 
     * @param editor the Topcased editor
     */
    public DropFactory(Modeler editor)
    {
        super();
        this.modeler = editor;
    }

    /**
     * Returns the List of object selected. Only GraphNodes are treated.
     * 
     * @see org.eclipse.gef.requests.CreationFactory#getNewObject()
     */
    public Object getNewObject()
    {
        if (result != null)
        {
            return result;
        }

        // Iterates on each selected element and filter only the GraphNodes
        result = new ArrayList();
        for (Iterator iter = transfer.iterator(); iter.hasNext();)
        {
            Object element = iter.next();

            if (element instanceof EObject)
            {
                // the graphElement is created with its default presentation
                // REV PRESENTATION : create a method that returns the default presentation
                GraphElement graphElt = modeler.getActiveConfiguration().getCreationUtils().createGraphElement(
                        (EObject) element, "default");
                if (graphElt instanceof GraphNode)
                {
                    result.add(graphElt);
                }
            }
        }
        return result;
    }

    /**
     * Returns the type of the new object. Always <code>null</code>
     * 
     * @return null
     * @see org.eclipse.gef.requests.CreationFactory#getObjectType()
     */
    public Object getObjectType()
    {
        return null;
    }

    /**
     * Set the objects that are dragged.
     * 
     * @param transf the list of object
     */
    public void setTransferredObjects(List transf)
    {
        if (this.transfer != transf)
        {
            this.transfer = transf;
            result = null;
        }
    }
}
