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
package org.topcased.modeler.edit;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.topcased.draw2d.figures.CommentFigure;
import org.topcased.draw2d.figures.ILabel;
import org.topcased.modeler.ModelerEditPolicyConstants;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.edit.policies.NoteDirectEditPolicy;
import org.topcased.modeler.edit.policies.ResizableEditPolicy;

/**
 * The controller used to represent a Generic Note. This is not linked with a domain element.
 * 
 * @author Jacques LESCOT
 */
public class NoteEditPart extends GraphNodeEditPart
{
    /** Constant <code>Color</code> representing light yellow. */
    public final static Color diagramLightYellow = new Color(null, 255, 255, 203);

    /** Constant <code>Color</code> representing dark yellow. */
    public final static Color diagramDarkYellow = new Color(null, 220, 150, 0);

    /**
     * Constructor
     * 
     * @param obj the graph node
     */
    public NoteEditPart(GraphNode obj)
    {
        super(obj);
    }

    /**
     * @see org.topcased.modeler.edit.GraphNodeEditPart#createEditPolicies()
     */
    protected void createEditPolicies()
    {
        super.createEditPolicies();
        installEditPolicy(ModelerEditPolicyConstants.RESIZABLE_EDITPOLICY, new ResizableEditPolicy());
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NoteDirectEditPolicy());
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     */
    protected IFigure createFigure()
    {
        return new CommentFigure();
    }

    /**
     * @see org.topcased.modeler.edit.GraphNodeEditPart#getEditableLabel()
     */
    public ILabel getEditableLabel()
    {
        return ((CommentFigure) getFigure()).getLabel();
    }

    /**
     * Handle the comment edition
     * 
     * @see org.topcased.modeler.edit.GraphNodeEditPart#performDirectEdit()
     */
    protected void performDirectEdit()
    {
        if (getDirectEditManager() == null)
        {
            ILabel label = ((CommentFigure) getFigure()).getLabel();
            setDirectEditManager(new ModelerLabelDirectEditManager(this, TextCellEditor.class,
                    new LabelCellEditorLocator(getFigure()), label)
            {
                protected CellEditor createCellEditorOn(Composite composite)
                {
                    return new TextCellEditor(composite, SWT.MULTI | SWT.WRAP);
                }
            });

        }
        getDirectEditManager().show();
    }

    /**
     * @see org.topcased.modeler.edit.GraphNodeEditPart#refreshVisuals()
     */
    protected void refreshVisuals()
    {
        super.refreshVisuals();

        // Refresh text value
        ((CommentFigure) getFigure()).getLabel().setText(getTextProperty().getValue());
    }

    private Property getTextProperty()
    {
        return DIUtils.getProperty((DiagramElement) getModel(), ModelerPropertyConstants.NOTE_VALUE);
    }

    // TODO Provide own preferences for the GenericText element

    /**
     * @see org.topcased.modeler.edit.GraphNodeEditPart#getPreferenceDefaultBackgroundColor()
     */
    protected Color getPreferenceDefaultBackgroundColor()
    {
        return diagramLightYellow;
    }

    /**
     * @see org.topcased.modeler.edit.GraphNodeEditPart#getPreferenceDefaultForegroundColor()
     */
    protected Color getPreferenceDefaultForegroundColor()
    {
        return diagramDarkYellow;
    }

    /**
     * @see org.topcased.modeler.edit.GraphNodeEditPart#getPreferenceDefaultFont()
     */
    protected Font getPreferenceDefaultFont()
    {
        return null;
    }

}