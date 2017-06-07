/******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.topcased.draw2d.gmffixing;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextUtilitiesEx;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

/**
 * This class is a hack because of the no compatibility between topcased and
 * gmf runtime 1.1.3
 * This class has the same behavior as TextUtilitiesEx of gmf runtime 1.1.2
 * @author satif, crevells, tfaure
 * @since 2.5
 * @TODO for > 2.5 check compatibility with gmf runtime
 * @FIXME 
 */
public class TextUtilitiesExCustom
    extends TextUtilitiesEx {

    /**
     * The mapmode to be used for translating measurement units.
     */
    private IMapMode mapmode;

    /**
     * Creates a new instance.
     * @param mapmode mapmode to be used for translating measurement units
     */
    public TextUtilitiesExCustom(IMapMode mapmode) {
        super(mapmode);
        this.mapmode = mapmode;
    }

    public int getAscent(Font font) {
        int ascent = super.getAscent(font);
        return mapmode.DPtoLP(ascent);
    }

    public int getDescent(Font font) {
        int descent = super.getDescent(font);
        return mapmode.DPtoLP(descent);
    }

    public Dimension getStringExtents(String s, Font f) {
        Dimension dimension = FigureUtilities.getStringExtents(s, f);
        if ((f.getFontData()[0].getStyle() & SWT.ITALIC) != 0) {
            dimension.width += (dimension.width / s.length()) / 2;
        }

        return new Dimension(mapmode.DPtoLP(dimension.width), mapmode
            .DPtoLP(dimension.height));
    }

    public Dimension getTextExtents(String s, Font f) {
        Dimension dimension = FigureUtilities.getTextExtents(s, f);
        if ((f.getFontData()[0].getStyle() & SWT.ITALIC) != 0 && s.length() > 0) {
            dimension.width += (dimension.width / s.length()) / 2;
        }

        return new Dimension(mapmode.DPtoLP(dimension.width), mapmode
            .DPtoLP(dimension.height));
    }

}
