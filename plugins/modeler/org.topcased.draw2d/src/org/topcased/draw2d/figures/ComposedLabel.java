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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.graphics.Image;

/**
 * Composed label is a figure that contains one, two or three parts. Each part is a label. Parts can be indentified as
 * prefix, main and suffix. The main part can be editable. The orientation is parametrizable. <br>
 * creation : 10 juin 2005<br>
 * 
 * @author <a href="mailto:mathieu.garcia@anyware-tech.com">Mathieu Garcia</a>
 */
public class ComposedLabel extends Figure implements ILabel
{

    /** Prefix label */
    private ILabel prefix;

    /** Main IFigure */
    private ILabel main;

    /** Suffix label */
    private ILabel suffix;

    /**
     * The default constructor The composed label has a main label and is horizontal
     */
    public ComposedLabel()
    {
        this(null, new Label(), null, true);
    }

    /**
     * Constructor for a composed label with only one part
     * 
     * @param mainFig Main label
     * @param isHorizontal orientation. If true, it's horizontal
     */
    public ComposedLabel(ILabel mainFig, boolean isHorizontal)
    {
        this(null, mainFig, null, isHorizontal);
    }

    /**
     * Constructor for a composed label whith several parts. Prefix and suffix can be null
     * 
     * @param prefixLbl prefix part. If null, no prefix is added to the figure
     * @param mainFig main part
     * @param suffixLbl suffix part. If null, no suffix is added to the figure
     * @param isHorizontal orientation. If true, it's horizontal
     */
    public ComposedLabel(ILabel prefixLbl, ILabel mainFig, ILabel suffixLbl, boolean isHorizontal)
    {
        ToolbarLayout layout = new ToolbarLayout(isHorizontal);
        layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
        // TODO Enable the user to customize the spacing, or the layout in general
        layout.setSpacing(2);
        setLayoutManager(layout);

        prefix = prefixLbl;
        main = mainFig;
        suffix = suffixLbl;

        if (prefix != null)
        {
            prefix.setOpaque(false);
            // When the Prefix is a ComposedLabel, this is always created. When
            // this is a simple Label, we check whether a text is present.
            if (prefix.getText() != null && prefix.getText().length() != 0 || prefix instanceof ComposedLabel || prefix instanceof Label && ((Label) prefix).getIcon() != null)
            {
                add(prefix);
            }
        }
        if (main != null)
        {
            main.setOpaque(false);
            add(main);
        }
        if (suffix != null)
        {
            suffix.setOpaque(false);
            // When the Suffix is a ComposedLabel, this is always created. When
            // this is a simple Label, we check whether a text is present.
            if (suffix.getText() != null && suffix.getText().length() != 0 || suffix instanceof ComposedLabel)
            {
                add(suffix);
            }
        }
    }

    /**
     * Set text for prefix part. If the new text is null or empty, the Label is removed
     * 
     * @param text the new text
     */
    public void setPrefix(String text)
    {
        if (prefix == null)
        {
            throw new UnsupportedOperationException("The ComposedLabel has no prefix");
        }

        if (text != null && !("".equals(text)))
        {
            if (prefix.getParent() == null)
            {
                // add the Label to the toolbarLayout if it is not already done
                add(prefix, 0);
            }
        }
        else
        {
            // the new text is empty, remove the Label if it was visible
            if (prefix.getParent() == this)
            {
                remove(prefix);
            }
        }
        // update the text
        prefix.setText(text);
    }

    /**
     * Set icon for prefix part. If the new icon is null or empty, the Image is removed
     * 
     * @param icon the new icon
     */
    public void setPrefixIcon(Image icon)
    {
        if (prefix == null)
        {
            throw new UnsupportedOperationException("The ComposedLabel has no prefix");
        }

        if (icon != null)
        {
            if (prefix.getParent() == null)
            {
                // add the Label to the toolbarLayout if it is not already done
                add(prefix, 0);
            }
        }
        else
        {
            // the new text is empty, remove the Label if it was visible
            if (prefix.getParent() == this)
            {
                remove(prefix);
            }
        }
        // update the text
        ((Label) prefix).setIcon(icon);
    }

    /**
     * Set text for suffix part. If the new text is null or empty, the Label is removed
     * 
     * @param text the new text
     */
    public void setSuffix(String text)
    {
        if (suffix == null)
        {
            throw new UnsupportedOperationException("The ComposedLabel has no suffix");
        }

        if (text != null && !("".equals(text)))
        {
            if (suffix.getParent() == null)
            {
                // add the Label to the toolbarLayout if it is not already done
                add(suffix, getChildren().size());
            }
        }
        else
        {
            // the new text is empty, remove the Label if it was visible
            if (suffix.getParent() == this)
            {
                remove(suffix);
            }
        }
        // update the text
        suffix.setText(text);
    }

    /**
     * Set text for main part. The Figure is always visible.
     * 
     * @param text the new text
     */
    public void setMain(String text)
    {
        if (main == null)
        {
            throw new UnsupportedOperationException("The ComposedLabel has no main text");
        }

        // update the text
        main.setText(text);
    }

    /**
     * Set Icon
     * 
     * @param image the icon
     * @deprecated A setter method should be available for each Label of the ComposedLabel
     */
    public void setIcon(Image image)
    {
        if (main instanceof Label)
        {
            if (prefix != null && prefix instanceof Label)
            {
                if (prefix.getParent() == null)
                {
                    // add the Label to the toolbarLayout if it is not already done
                    add(prefix, 0);
                }
                ((Label) prefix).setIcon(image);
            }
            else
            {
                ((Label) main).setIcon(image);
            }
        }
    }

    /**
     * Get prefix label
     * 
     * @return a label object
     */
    public ILabel getPrefix()
    {
        return prefix;
    }

    /**
     * Get suffix label
     * 
     * @return a label object
     */
    public ILabel getSuffix()
    {
        return suffix;
    }

    /**
     * Get main figure
     * 
     * @return the main IFigure
     */
    public ILabel getMain()
    {
        return main;
    }

    /**
     * If main part is editable, select or deselect it according a given parameter
     * 
     * @param b selection state
     */
    public void setSelected(boolean b)
    {
        if (main instanceof EditableLabel)
        {
            ((EditableLabel) main).setSelected(b);
        }
        else if (main instanceof ComposedLabel)
        {
            ((ComposedLabel) main).setSelected(b);
        }
    }

    /**
     * @see org.topcased.draw2d.figures.ILabel#setText(java.lang.String)
     */
    public void setText(String s)
    {
        main.setText(s);
    }

    /**
     * @see org.topcased.draw2d.figures.ILabel#getText()
     */
    public String getText()
    {
        return main.getText();
    }

    /**
     * @see org.eclipse.draw2d.Figure#getToolTip()
     */
    public IFigure getToolTip()
    {
        if (main instanceof Label && ((Label) main).isTextTruncated())
        {
            return new org.eclipse.draw2d.Label(this.getText());
        }
        return super.getToolTip();
    }
}
