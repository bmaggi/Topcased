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
package org.topcased.draw2d.figures;

import org.eclipse.swt.graphics.Image;



/**
 * This figure is an editable label which can be edited
 */
public class EditableLabelFigure extends EditableLabel implements ILabelFigure
{
    /**
     * Constructor
     */
    public EditableLabelFigure()
    {
        super();
    }

    /**
     * The constructor with a String parameter
     * 
     * @param text the value to display
     */
    public EditableLabelFigure(String text)
    {
        super(text);
    }
    
    /**
     * The constructor with an Icon parameter
     * 
     * @param img the icon displayed in the label
     */
    public EditableLabelFigure(Image img)
    {
        super(img);
    }

    /**
     * The constructor with a TextProvider parameter
     * 
     * @param txtProvider the TextProvider
     */
    public EditableLabelFigure(TextProvider txtProvider)
    {
        super(txtProvider);
    }

    /**
     * The constructor with a TextProvider parameter
     * 
     * @param img the icon displayed in the label
     * @param txtProvider the TextProvider
     */
    public EditableLabelFigure(Image img, TextProvider txtProvider)
    {
        super(img, txtProvider);
    }
    
    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return this;
    }
    

}