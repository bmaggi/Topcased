/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.topcased.draw2d.figures.Label;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.validation.core.MarkerUtil;

/**
 * This class decorates the editor objects with error or warning ticks if there
 * is some EMF validation problems
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ErrorDecorator implements IDecorator
{

    private static final Image ICON_ERROR;

    private static final Image ICON_WARNING;

    /** the object to be decorated */
    private IDecoratorTarget decoratorTarget;

    /** the decoration being displayed */
    private IDecoration decoration;

    private IResourceChangeListener resourceListener;

    static
    {
        ICON_ERROR = ModelerPlugin.getImageDescriptor("$nl$/icons/validation/error.gif").createImage(); //$NON-NLS-1$
        ICON_WARNING = ModelerPlugin.getImageDescriptor("$nl$/icons/validation/warning.gif").createImage(); //$NON-NLS-1$
    }

    /**
     * Creates a new <code>AbstractDecorator</code> for the decorator target
     * passed in.
     * 
     * @param target the object to be decorated
     */
    public ErrorDecorator(IDecoratorTarget target)
    {
        this.decoratorTarget = target;
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
     * method to determine if the
     * decoratorTarget is a supported type for this decorator and return the
     * associated Classifier element.
     * 
     * @param decoratorTarget IDecoratorTarget to check and return valid
     *            Classifier target.
     * @return node Node if IDecoratorTarget can be supported, null otherwise.
     */
    public static EObject getEObjectDecoratorTarget(IDecoratorTarget decoratorTarget)
    {
        return (EObject) decoratorTarget.getAdapter(EObject.class);

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
        IDecoratorTarget.Direction direction = IDecoratorTarget.Direction.NORTH_WEST;
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
                    direction = IDecoratorTarget.Direction.WEST;
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

        EObject object = getEObjectDecoratorTarget(getDecoratorTarget());

        if (object != null)
        {
            if (object.eResource() != null)
            {
                IStatus status = MarkerUtil.getStatus(object, true);

                if (!status.isOK())
                {
                    GraphicalEditPart editPart = (GraphicalEditPart) getDecoratorTarget().getAdapter(
                            GraphicalEditPart.class);
                    IMapMode mm = MapModeUtil.getMapMode(editPart.getFigure());

                    if (editPart instanceof ConnectionEditPart)
                    {
                        setDecoration(getDecoratorTarget().addConnectionDecoration(getImageFigure(status, mm), 50,
                                false));
                    }
                    else
                    {
                        setDecoration(getDecoratorTarget().addShapeDecoration(getImageFigure(status, mm),
                                getDirection(getDecoratorTarget()), 0, false));
                    }
                }
            }
        }
    }

    private IFigure getImageFigure(IStatus status, IMapMode mm)
    {
        ImageFigureEx figure = new ImageFigureEx();
        if (status.matches(IStatus.ERROR))
        {
            figure.setImage(ICON_ERROR);
            figure.setSize(mm.DPtoLP(ICON_ERROR.getBounds().width), mm.DPtoLP(ICON_ERROR.getBounds().height));
        }
        else if (status.matches(IStatus.WARNING))
        {
            figure.setImage(ICON_WARNING);
            figure.setSize(mm.DPtoLP(ICON_WARNING.getBounds().width), mm.DPtoLP(ICON_WARNING.getBounds().height));
        }

        IFigure tooltip = new org.eclipse.draw2d.Label(composeTooltip(status));
        tooltip.setSize(100, 100);
        figure.setToolTip(tooltip);

        return figure;
    }

    private String composeTooltip(IStatus status)
    {
        StringBuffer message = new StringBuffer();

        String[] errors = getMessages(status, IStatus.ERROR);
        String[] warnings = getMessages(status, IStatus.WARNING);
        
        // Add error messages
        if (errors.length == 1)
        {
            message.append("Error : ");
            message.append(errors[0]);
        }
        else if (errors.length > 1)
        {
            message.append("Errors :");
            for (int i = 0; i < errors.length; i++)
            {
                message.append("\n\t- ");
                message.append(errors[i]);
            }
        }
            

        // Add warning message
        if (warnings.length > 0 && errors.length > 0)
        {
            message.append("\n\n");
        }

        if (warnings.length == 1)
        {
            message.append("Warning : ");
            message.append(warnings[0]);
        }
        else if (warnings.length > 1)
        {
            message.append("Warnings :");
            for (int i = 0; i < warnings.length; i++)
            {
                message.append("\n\t- ");
                message.append(warnings[i]);
            }
        }
        

        return message.toString();
    }

    private String[] getMessages(IStatus status, int level)
    {
        List messages = new ArrayList();
        if (status.isMultiStatus())
        {
            for (int i = 0; i < status.getChildren().length; i++)
            {
                messages.addAll(Arrays.asList(getMessages(status.getChildren()[i], level)));

            }
        }
        else if (status.matches(level))
        {
            messages.add(status.getMessage());
        }

        return (String[]) messages.toArray(new String[messages.size()]);
    }

    /**
     * Adds decoration if applicable.
     */
    public void activate()
    {

        if (resourceListener == null)
        {
            resourceListener = new IResourceChangeListener()
            {
                public void resourceChanged(IResourceChangeEvent event)
                {
                    handleResourceChanged(event);
                }
            };

            ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceListener);
        }
    }

    /**
     * Removes the decoration.
     */
    public void deactivate()
    {
        removeDecoration();

        if (resourceListener != null)
        {
            ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceListener);
            resourceListener = null;
        }
    }

    /**
     * Handles the event from a resource modification.<br>
     * Here handles modifications of markers.
     * 
     * @param event the resource event
     */
    private void handleResourceChanged(IResourceChangeEvent event)
    {
        IMarkerDelta[] markerDeltas = event.findMarkerDeltas(MarkerUtil.MARKER_ID, true);
        if (markerDeltas.length > 0)
        {
            if (Display.getCurrent() != Display.getDefault())
            {
                asyncFireEObjectMarkerChanged();
            }
            else
            {
                refresh();
            }
        }
    }

    /**
     * Send the events asynchronously
     */
    private void asyncFireEObjectMarkerChanged()
    {
        Display.getDefault().asyncExec(new Runnable()
        {
            /**
             * @see java.lang.Runnable#run()
             */
            public void run()
            {
                refresh();
            }
        });
    }
}
