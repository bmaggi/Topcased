/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.internal.decorators;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
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
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.ModelerGraphicalViewer;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * This class decorates the editor objects with an arrow ticks if there is some
 * available diagrams
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class DiagramDecorator implements IDecorator
{

    private static final Image ICON_ARROW;

    /** the object to be decorated */
    private IDecoratorTarget decoratorTarget;

    /** the decoration being displayed */
    private IDecoration decoration;

    static
    {
        ICON_ARROW = ModelerPlugin.getImageDescriptor("$nl$/icons/decorators/diagramAvailable.gif").createImage(); //$NON-NLS-1$
        JFaceResources.getImageRegistry().put("diagramAvailable.gif", ICON_ARROW);
    }

    /**
     * Creates a new <code>AbstractDecorator</code> for the decorator target
     * passed in.
     * 
     * @param target the object to be decorated
     */
    public DiagramDecorator(IDecoratorTarget target)
    {
        this.decoratorTarget = target;
    }

    /**
     * Method to determine if the decoratorTarget is a supported type for this
     * decorator and return the associated Classifier element.
     * 
     * @param target IDecoratorTarget to check and return valid
     *            Classifier target.
     * @return node Node if IDecoratorTarget can be supported, null otherwise.
     */
    public static EObject getEObjectDecoratorTarget(IDecoratorTarget target)
    {
        return (EObject) target.getAdapter(EObject.class);

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
     * @return Returns the decoration.
     */
    public IDecoration getDecoration()
    {
        return decoration;
    }

    /**
     * @param deco The decoration to set.
     */
    public void setDecoration(IDecoration deco)
    {
        this.decoration = deco;
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
     * Compute the direction using the kind of graphical representation is
     * annotated
     * 
     * @param target
     * @return the position where the decorator is displayed
     */
    private IDecoratorTarget.Direction getDirection(IDecoratorTarget target)
    {
        IDecoratorTarget.Direction direction = IDecoratorTarget.Direction.NORTH_EAST;
        GraphicalEditPart editPart = (GraphicalEditPart) target.getAdapter(GraphicalEditPart.class);
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
     * Creates the appropriate review decoration if all the criteria is
     * satisfied by the view passed in.
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
                setDecoration(getDecoratorTarget().addShapeDecoration(getImageFigure(mm),
                        getDirection(getDecoratorTarget()), -1, true));
            }
        }
    }

    private boolean hasDiagram(IDecoratorTarget target)
    {
        EObject modelObject = getEObjectDecoratorTarget(target);
        GraphicalEditPart ep = (GraphicalEditPart) target.getAdapter(GraphicalEditPart.class);
        if (modelObject != null && ep != null)
        {
            if (ep.getViewer() instanceof ModelerGraphicalViewer)
            {
                return !(DiagramsUtils.findAllExistingDiagram(((ModelerGraphicalViewer) ep.getViewer()).getModelerEditor().getDiagrams(),
                        modelObject).isEmpty());
            }
        }

        return false;
    }

    private IFigure getImageFigure(IMapMode mm)
    {
        ImageFigureEx figure = new ImageFigureEx();
        figure.setImage(ICON_ARROW);
        figure.setSize(mm.DPtoLP(ICON_ARROW.getBounds().width), mm.DPtoLP(ICON_ARROW.getBounds().height));

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
