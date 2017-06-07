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
import org.topcased.modeler.extensions.SynchronizedModelDiagramRule;
import org.topcased.modeler.extensions.SynchronizedModelDiagramRulesManager;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;

/**
 * This class decorates the editor objects with a synchronization icon if the element does not have the right graphical
 * parent.
 * 
 * The test is performed according to the rule provided by the
 * org.topcased.modeler.extensions.SynchronizedModelDiagramRulesManager class
 * 
 * @author vhemery
 * 
 */
public class NotSynchronizedDecorator implements IDecorator
{

    private static final Image ICON_SYNCHRONIZE;

    private static final String WRONG_PARENT_MESSAGE = "\nIts model parent is %s.";

    private static final String NOT_SYNCHRONISED_MESSAGE = "This graphic element does not have the same parent as in the model.";

    /** the object to be decorated */
    private IDecoratorTarget decoratorTarget;

    /** the decoration being displayed */
    private IDecoration decoration;

    /** The right parent tester. */
    private SynchronizedModelDiagramRule mRightParentTester;

    /** Should the decorator be displayed ? */
    private boolean notSyncDecorEnabled;
    
    static
    {
        ICON_SYNCHRONIZE = ModelerPlugin.getImageDescriptor("$nl$/icons/decorators/notSynchronizedModelDiagram.gif").createImage(); //$NON-NLS-1$
        JFaceResources.getImageRegistry().put("notSynchronizedModelDiagram.gif", ICON_SYNCHRONIZE);
    }

    /**
     * Creates a new <code>NotSynchronizedDecorator</code> for the decorator target passed in.
     * 
     * @param pTarget the object to be decorated
     */
    public NotSynchronizedDecorator(IDecoratorTarget pTarget)
    {
        this.decoratorTarget = pTarget;
        EObject lEObject = getEObjectDecoratorTarget(pTarget);
        GraphicalEditPart lEditPart = (GraphicalEditPart) pTarget.getAdapter(GraphicalEditPart.class);
        mRightParentTester = SynchronizedModelDiagramRulesManager.getInstance().getRuleTesterForElement(lEObject, lEditPart);
    }

    /**
     * Method to determine if the decoratorTarget is a supported type for this decorator and return the associated
     * Classifier element.
     * 
     * @param target IDecoratorTarget to check and return valid Classifier target.
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
     * Compute the direction using the kind of graphical representation is annotated
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
     * Creates the appropriate review decoration if all the criteria is satisfied by the view passed in.
     */
    public void refresh()
    {
        removeDecoration();

        if (!hasRightParentContainer(getDecoratorTarget()) && notSyncDecorEnabled)
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
     * Checks if the representation is in the same container as in the model.
     * 
     * @param pTarget the target
     * 
     * @return true, if is synchronized with the model
     */
    private boolean hasRightParentContainer(IDecoratorTarget pTarget)
    {
        if (mRightParentTester != null)
        {
            return mRightParentTester.hasRightGraphicParent(pTarget);
        }
        else
        {
            return true;
        }
    }

    private IFigure getImageFigure(IMapMode mm)
    {
        ImageFigureEx figure = new ImageFigureEx();
        figure.setImage(ICON_SYNCHRONIZE);
        figure.setSize(mm.DPtoLP(ICON_SYNCHRONIZE.getBounds().width), mm.DPtoLP(ICON_SYNCHRONIZE.getBounds().height));

        IFigure tooltip = new org.eclipse.draw2d.Label(composeTooltip());
        tooltip.setSize(100, 100);
        figure.setToolTip(tooltip);

        return figure;
    }

    /**
     * Compose tooltip.
     * 
     * @return the tooltip String
     */
    private String composeTooltip()
    {
        StringBuffer message = new StringBuffer();
        message.append(NOT_SYNCHRONISED_MESSAGE);
        String lModelParentName = mRightParentTester.getModelParentName(getDecoratorTarget(), false);
        if (!"".equals(lModelParentName))
        {
            message.append(String.format(WRONG_PARENT_MESSAGE, lModelParentName));
        }

        return message.toString();
    }

    /**
     * Adds decoration if applicable.
     */
    public void activate()
    {
    	notSyncDecorEnabled = ModelerPlugin.getDefault().getPreferenceStore().getBoolean(ModelerPreferenceConstants.PREFERENCE_NOT_SYNC_DECOR);
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
