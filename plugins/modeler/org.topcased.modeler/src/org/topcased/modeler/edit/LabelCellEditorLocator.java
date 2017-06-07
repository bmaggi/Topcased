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
package org.topcased.modeler.edit;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;
import org.topcased.draw2d.figures.EditableLabel;
import org.topcased.draw2d.figures.Label;

/**
 * A CellEditorLocator for a specified label
 * 
 * @author jako
 */
public class LabelCellEditorLocator implements CellEditorLocator
{

    private IFigure figure;

    /**
     * Creates a new CellEditorLocator for the given Figure
     * 
     * @param fig the Figure
     */
    public LabelCellEditorLocator(IFigure fig)
    {
        this.figure = fig;
    }

    /**
     * Expands the size of the control by 1 pixel in each direction
     * 
     * @see org.eclipse.gef.tools.CellEditorLocator#relocate(org.eclipse.jface.viewers.CellEditor)
     */
    public void relocate(CellEditor celleditor)
    {
        Text text = (Text) celleditor.getControl();

        Rectangle rect = null;
        if (figure instanceof EditableLabel)
        {
            Point pref = text.computeSize(SWT.DEFAULT, SWT.DEFAULT);
            rect = ((EditableLabel) figure).getTextBounds().getCopy();
            figure.translateToAbsolute(rect);
            text.setBounds(rect.x - 1, rect.y - 1, pref.x + 1, pref.y + 1);
        }
        else if (figure instanceof Label)
        {
            Point pref = text.computeSize(SWT.DEFAULT, SWT.DEFAULT);
            rect = ((Label) figure).getTextBounds().getCopy();
            figure.translateToAbsolute(rect);
            text.setBounds(rect.x - 1, rect.y - 1, pref.x + 1, pref.y + 1);
        }
        else
        {
            rect = figure.getClientArea(Rectangle.SINGLETON);
            figure.translateToAbsolute(rect);
            text.setBounds(rect.x - 1, rect.y - 1, rect.width + 2, rect.height + 2);
        }
    }

}
