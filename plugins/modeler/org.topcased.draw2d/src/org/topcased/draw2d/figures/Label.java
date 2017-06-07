/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.draw2d.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.swt.graphics.Image;
import org.topcased.draw2d.gmffixing.WrappingLabelCustom;

/**
 * This is the Label class of eclipse draw2d with the generic
 * This class inherits from WrappingLabelCustom because of
 * incompatibility with gmf runtime 1.1.3
 * @TODO for > 2.5 check compatibility with gmf runtime
 * @FIXME 
 * representation of the label (ILabel)
 */
public class Label extends WrappingLabelCustom implements ILabel {

	/**
	 * The default contructor
	 */
	public Label() {
		super();
		setAlignment(PositionConstants.CENTER);
	}

	@Override
    public void setText(String text)
    {
        super.setText(text);
    }

    /**
	 * Constructor
	 * 
	 * @param s the text of the label
	 */
	public Label(String s) {
		super(s);
        setAlignment(PositionConstants.CENTER);
	}
	
	
    /**
	 * Constructor
	 * 
	 * @param i the image of the label
	 */
    public Label(Image i)
    {
        super(i);
        setAlignment(PositionConstants.CENTER);
    }

    /**
	 * Constructor
	 * 
	 * @param s the text of the label
	 * @param i the image of the label
	 */
    public Label(String s, Image i)
    {
        super(s, i);
        setAlignment(PositionConstants.CENTER);
    }

    /**
     * @see org.eclipse.draw2d.Figure#getToolTip()
     */
    public IFigure getToolTip()
    {
        if (isTextTruncated()) {
            return new org.eclipse.draw2d.Label(this.getText());
        }
        return super.getToolTip();
    }

}
