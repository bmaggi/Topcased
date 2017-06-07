/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies), Thomas Friol (Anyware
 * Technologies) - initial API and implementation
 ******************************************************************************/
package org.topcased.modeler.edit.handles;

import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gef.handles.MoveHandleLocator;
import org.topcased.modeler.di.model.EdgeObject;
import org.topcased.modeler.figures.IEdgeObjectFigure;

/**
 * An abstract handle to select
 * {@link org.topcased.modeler.figures.IEdgeObjectFigure}.<br>
 * Its representation is a single rectangle around the
 * {@link org.topcased.modeler.figures.IEdgeObjectFigure}. The default cursor
 * is a hand.<br>
 * Subclass must provide its own {@link org.eclipse.gef.DragTracker}.<br>
 * Creation : 25 oct. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public abstract class EdgeObjectHandle extends AbstractHandle
{
    private EdgeObject edgeObject;

    /**
     * 
     */
    public EdgeObjectHandle(GraphicalEditPart editPart, EdgeObject edgeObject, IEdgeObjectFigure edgeObjectFigure)
    {
        super();
        this.edgeObject = edgeObject;
        setBorder(new LineBorder());
        setOpaque(false);
        setCursor(Cursors.HAND);
        setOwner(editPart);
        setLocator(new MoveHandleLocator(edgeObjectFigure));
    }

    protected EdgeObject getEdgeObject()
    {
        return edgeObject;
    }
}
