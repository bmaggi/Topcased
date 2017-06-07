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

import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.draw2d.ui.text.FlowUtilitiesEx;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextUtilitiesEx;

/**
 * A <code>TextFlow</code> with the following additional capabilities: <br>
 * <UL>
 * <LI>text can be underlined or have a strike-through
 * <LI>truncated with ... when the full text doesn't fit vertically
 * </UL>
 * This class is a hack because of the no compatibility between topcased and
 * gmf runtime 1.1.3
 * This class extends TextFlowEx and override methods to returns custom elements
 * @since 2.5
 * @TODO for > 2.5 check compatibility with gmf runtime
 * @FIXME 
 * @author satif, crevells, tfaure
 * 
 */
public class TextFlowExCustom
    extends TextFlowEx {


    private TextUtilitiesExCustom textUtilities;
    private FlowUtilitiesEx flowUtilities;

    /**
     * Constructs a new TextFlow with the empty String.
     */
    public TextFlowExCustom() {
        super();
    }

    /**
     * Constructs a new TextFlow with the specified String.
     * 
     * @param text
     *            the string
     */
    public TextFlowExCustom(String text) {
        super(text);
    }

    @Override   
    public TextUtilitiesEx getTextUtilities() {
        if (textUtilities == null) {
            textUtilities = new TextUtilitiesExCustom(MapModeUtil.getMapMode(this));
        }
        return textUtilities;
    }

    @Override
    public FlowUtilitiesEx getFlowUtilities()
    {
        if (flowUtilities == null) {
            flowUtilities = new FlowUtilitiesExCustom(MapModeUtil.getMapMode(this));
        }
        return flowUtilities;
    }

    

    
}
