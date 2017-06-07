/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.edit.handles;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.GraphicalEditPart;
import org.topcased.modeler.di.model.EdgeObjectUV;
import org.topcased.modeler.figures.IEdgeObjectFigure;

/**
 * An handle to select {@link org.topcased.modeler.di.model.EdgeObjectUV}
 * figures.<br>
 * Creation : 3 nov. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class EdgeObjectUVHandle extends EdgeObjectHandle
{

    /**
     * Constructor.
     * 
     * @param editPart
     * @param edgeObject
     * @param edgeObjectFigure
     */
    public EdgeObjectUVHandle(GraphicalEditPart editPart, EdgeObjectUV edgeObject, IEdgeObjectFigure edgeObjectFigure)
    {
        super(editPart, edgeObject, edgeObjectFigure);
    }

    /**
     * @see org.eclipse.gef.handles.AbstractHandle#createDragTracker()
     */
    protected DragTracker createDragTracker()
    {
        return new EdgeObjectUVDragTracker(getOwner(), (EdgeObjectUV) getEdgeObject());
    }
}
