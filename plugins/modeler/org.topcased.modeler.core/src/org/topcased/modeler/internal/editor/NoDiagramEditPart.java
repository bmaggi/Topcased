/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.internal.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.topcased.modeler.edit.DiagramEditPart;
import org.topcased.modeler.internal.ModelerImageRegistry;

/**
 * A basic implementation of a DiagramEditPart in the case when no diagram is
 * contained in the Diagrams file. The EditPart only create a Basic Figure that
 * display an Image in the editing window.
 * 
 * Creation 12 oct. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class NoDiagramEditPart extends DiagramEditPart
{
    /**
     * The constructor
     */
    public NoDiagramEditPart()
    {
        super(null);
    }

    /**
     * @see org.topcased.modeler.edit.DiagramEditPart#getLayoutEditPolicy()
     */
    protected EditPolicy getLayoutEditPolicy()
    {
        return null;
    }

    /**
     * @see org.topcased.modeler.edit.DiagramEditPart#createEditPolicies()
     */
    protected void createEditPolicies()
    {
        // No policies
    }

    /**
     * @see org.topcased.modeler.edit.DiagramEditPart#createFigure()
     */
    protected IFigure createFigure()
    {
        RectangleFigure p = new RectangleFigure()
        {
            public void paintFigure(Graphics graphics)
            {
                graphics.drawImage(ModelerImageRegistry.getImage("NO_DIAGRAM"), 0, 0);
            }
        };
        p.setBounds(new Rectangle(0, 0, 500, 300));

        return p;
    }

    /**
     * @see org.topcased.modeler.edit.DiagramEditPart#getHeaderDiagram()
     */
    protected String getHeaderDiagram()
    {
        return "No diagram selected";
    }

    /**
     * @see org.topcased.modeler.edit.DiagramEditPart#refreshVisuals()
     */
    protected void refreshVisuals()
    {
        // Do nothing
    }

    /**
     * @see org.topcased.modeler.edit.DiagramEditPart#getModelChildren()
     */
    protected List getModelChildren()
    {
        return new ArrayList();
    }
}
