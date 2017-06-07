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
package org.topcased.modeler.figures;

import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.topcased.modeler.ModelerColorConstants;

/**
 * Basic figure that represents a graph node <br>
 * creation : 3 dec. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class GraphNodeFigure extends Figure
{
    private Label lblHeader;

    /**
     * Constructor
     */
    public GraphNodeFigure()
    {
        ToolbarLayout layout = new ToolbarLayout();
        setLayoutManager(layout);
        setBorder(new CompoundBorder(new LineBorder(ModelerColorConstants.red, 1), new MarginBorder(1)));
        setOpaque(true);

        lblHeader = new Label();
        lblHeader.setText("Unresolved");
        add(lblHeader);

        Label lblTooltip = new Label();
        lblTooltip.setText("The model object referenced by this figure cannot be resolved.");
        setToolTip(lblTooltip);
    }

    /**
     * @return the figure where children are added
     */
    public IFigure getContentPane()
    {
        return lblHeader;
    }
}
