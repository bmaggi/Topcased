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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * A customized Label based on the label used in the flow example. Primary
 * selection is denoted by highlight and focus rectangle. Normal selection is
 * denoted by highlight only. Borrowed from the Flow Editor example
 * 
 * @author Daniel Lee
 * 
 * Use EditableLabel(TextProvider provider) for editing a special part of the
 * label
 * 
 * @author Mathieu Garcia
 */
public class EditableLabel extends Label implements ILabel
{
    private boolean selected;

    private TextProvider provider;

    private Color colorUnselectedLabel = null;

    private Color colorSelectedLabel = ColorConstants.lightGray;

    /**
     * A TextProvider class where we define an abstract method getText() where
     * subclasses must define the part of the Text that must be displayed during
     * the editing.
     * 
     * Creation : 15 sept. 2005
     * 
     * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
     */
    public abstract static class TextProvider
    {
        /**
         * Returns the Text that must be displayed during the editing.
         * 
         * @return a String
         */
        public abstract String getText();
    }

    /**
     * The default Constructor
     */
    public EditableLabel()
    {
        super();
    }
    
    /**
     * The default Constructor
     */
    public EditableLabel(boolean autoWrap)
    {
        super();
        // Enable auto-wrap
        setTextWrap(autoWrap);
    }

    /**
     * The constructor with a String parameter
     * 
     * @param text the value to display
     */
    public EditableLabel(String text)
    {
        super(text);
    }
    
    /**
     * Constructor with the initial icon
     * @param img the icon displayed in the label
     */
    public EditableLabel(Image img)
    {
        super(img);
    }

    /**
     * The constructor with a TextProvider parameter
     * 
     * @param txtProvider the TextProvider
     */
    public EditableLabel(TextProvider txtProvider)
    {
        super();
        this.provider = txtProvider;
    }

    /**
     * The constructor with a TextProvider parameter
     * 
     * @param img the icon displayed in the label
     * @param txtProvider the TextProvider
     */
    public EditableLabel(Image img, TextProvider txtProvider)
    {
        super(img);
        this.provider = txtProvider;
    }

    /**
     * Sets the new Text of the label
     * 
     * @param s the new String
     */
    public void setText(String s)
    {
        super.setText(s);
    }

    /**
     * Return the current editable Text
     * 
     * @return The editable text
     */
    public String getEditableText()
    {
        if (provider != null)
        {
            return provider.getText();
        }
        else
        {
            return super.getText();
        }
    }

    /**
     * Sets the backgroundColor of the Label when it is selected
     * 
     * @param newColor the new Color
     */
    public void setColorSelectedLabel(Color newColor)
    {
        this.colorSelectedLabel = newColor;
    }

    /**
     * Sets the backgroundColor of the Label when it is not selected
     * 
     * @param newColor the new Color
     */
    public void setColorUnselectedLabel(Color newColor)
    {
        this.colorUnselectedLabel = newColor;
    }

    /**
     * Sets the selection state of this EditableLabel
     * 
     * @param b true will cause the label to appear selected
     */
    public void setSelected(boolean b)
    {
        selected = b;
        if (selected)
        {
            setBackgroundColor(colorSelectedLabel);
            setOpaque(true);
        }
        else
        {
            if (colorUnselectedLabel == null)
            {
                setOpaque(false);
            }
            else
            {
                setBackgroundColor(colorUnselectedLabel);
                setOpaque(true);
            }
        }
        repaint();
    }

    /**
     * Return the selected value of the widget
     * 
     * @return a boolean
     */
    public boolean getSelected()
    {
        return selected;
    }
}
