/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos Origin) vincent.hemery@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/

package org.topcased.modeler.extensions;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Image;
import org.topcased.draw2d.figures.Label;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * This class provides a basis implementation for Decorators which decorate specialized editor objects with an arrow
 * ticks if there is some available diagrams indirectly linked to the element.
 * 
 */
public abstract class AbstractLinkedDiagramDecorator implements IDecorator
{

    /** The Constant ICON_ARROW. */
    private static final Image ICON_ARROW;

    /** the object to be decorated. */
    private IDecoratorTarget decoratorTarget;

    /** the decoration being displayed. */
    private IDecoration decoration;

    static
    {
        ICON_ARROW = ModelerPlugin.getImageDescriptor("$nl$/icons/decorators/linkedDiagramAvailable.gif").createImage(); //$NON-NLS-1$
        JFaceResources.getImageRegistry().put("linkedDiagramAvailable.gif", ICON_ARROW);
    }

    /**
     * Creates a new <code>AbstractDecorator</code> for the decorator target passed in.
     * 
     * @param pTarget the object to be decorated
     */
    public AbstractLinkedDiagramDecorator(IDecoratorTarget pTarget)
    {
        this.decoratorTarget = pTarget;
    }

    /**
     * Gets the object to be decorated.
     * 
     * @return Returns the object to be decorated
     */
    protected IDecoratorTarget getDecoratorTarget()
    {
        return decoratorTarget;
    }

    /**
     * Gets the decoration.
     * 
     * @return Returns the decoration.
     */
    public IDecoration getDecoration()
    {
        return decoration;
    }

    /**
     * Sets the decoration.
     * 
     * @param pDeco The decoration to set.
     */
    public void setDecoration(IDecoration pDeco)
    {
        this.decoration = pDeco;
    }

    /**
     * Removes the decoration if it exists and sets it to null.
     */
    protected void removeDecoration()
    {
        if (decoration != null)
        {
            decoratorTarget.removeDecoration(decoration);
            decoration = null;
        }
    }

    /**
     * Compute the direction using the kind of graphical representation is annotated.
     * 
     * @param pTarget the target
     * 
     * @return the position where the decorator is displayed
     */
    private IDecoratorTarget.Direction getDirection(IDecoratorTarget pTarget)
    {
        IDecoratorTarget.Direction direction = IDecoratorTarget.Direction.NORTH_EAST;
        GraphicalEditPart editPart = (GraphicalEditPart) pTarget.getAdapter(GraphicalEditPart.class);
        if (editPart != null)
        {
            if (editPart instanceof ConnectionEditPart)
            {
                direction = IDecoratorTarget.Direction.CENTER;
            }
            else
            {
                IFigure figure = editPart.getFigure();
                if (figure instanceof Label)
                {
                    direction = IDecoratorTarget.Direction.EAST;
                }
            }
        }
        return direction;
    }

    /**
     * Creates the appropriate review decoration if all the criteria are satisfied by the view passed in.
     */
    public void refresh()
    {
        removeDecoration();

        if (hasDiagram(getDecoratorTarget()))
        {
            GraphicalEditPart editPart = (GraphicalEditPart) getDecoratorTarget().getAdapter(GraphicalEditPart.class);
            IMapMode mm = MapModeUtil.getMapMode(editPart.getFigure());

            if (editPart instanceof ConnectionEditPart)
            {
                setDecoration(getDecoratorTarget().addConnectionDecoration(getImageFigure(mm), 30, true));
            }
            else
            {
                setDecoration(getDecoratorTarget().addShapeDecoration(getImageFigure(mm), getDirection(getDecoratorTarget()), -1, true));
            }
        }
    }

    /**
     * Checks for diagram.
     * 
     * @param target the target
     * 
     * @return true, if successful
     */
    protected abstract boolean hasDiagram(IDecoratorTarget target);

    /**
     * Gets the image figure.
     * 
     * @param pMm the mm
     * 
     * @return the image figure
     */
    private IFigure getImageFigure(IMapMode pMm)
    {
        ImageFigureEx figure = new ImageFigureEx();
        figure.setImage(ICON_ARROW);
        figure.setSize(pMm.DPtoLP(ICON_ARROW.getBounds().width), pMm.DPtoLP(ICON_ARROW.getBounds().height));

        // IFigure tooltip = new
        // org.eclipse.draw2d.Label(composeTooltip(status));
        // tooltip.setSize(100, 100);
        // figure.setToolTip(tooltip);

        return figure;
    }

    /**
     * Adds decoration if applicable.
     */
    public void activate()
    {
        refresh();
    }

    /**
     * Removes the decoration.
     */
    public void deactivate()
    {
        removeDecoration();
    }
}
