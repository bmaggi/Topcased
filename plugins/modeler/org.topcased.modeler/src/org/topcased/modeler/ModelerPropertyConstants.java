/*******************************************************************************
 * Copyright (c) 2005, 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler;

/**
 * Constants that are used as properties for GraphElements
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public interface ModelerPropertyConstants
{

    String BACKGROUND_COLOR = "backgroundColor";
    String FOREGROUND_COLOR = "foregroundColor";

    String FONT = "font";

    String PAGE_FORMAT_NAME = "pageFormatName";
    String PAGE_WIDTH = "diagramWidth";
    String PAGE_HEIGHT = "diagramHeight";

    String PAGE_MARGIN_NAME = "pageMarginName";
    String TOP_MARGIN = "diagramTopMargin";
    String LEFT_MARGIN = "diagramLeftMargin";
    String BOTTOM_MARGIN = "diagramBottomMargin";
    String RIGHT_MARGIN = "diagramRightMargin";

    String ORIENTATION = "orientation";
    String PORTRAIT_ORIENTATION = "portrait";
    String LANDSCAPE_ORIENTATION = "landscape";

    String PORT_DIRECTION = "portDirection";
    String PORT_POSITION = "portPosition";

    String MULTIPORT_STATE = "isClosed";

    String ROUTER = "router";
    
    String ESTRUCTURAL_FEATURE_ID = "eStructuralFeatureID";

    // A direction used to set up the orientation of a diagram element
    String DIRECTION = "direction";

    /** A key to store text contents of a Note element */
    String NOTE_VALUE = "noteValue";
}
