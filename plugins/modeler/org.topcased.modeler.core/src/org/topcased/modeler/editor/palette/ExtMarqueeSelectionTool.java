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
package org.topcased.modeler.editor.palette;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;


/**
 * Tool that does not select objects contained in already selected objects
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ExtMarqueeSelectionTool extends MarqueeSelectionTool {

	
	protected void calculateNewSelection(Collection newSelections, Collection deselections) {

		EditPart targetEditPart = getCurrentViewer().findObjectAtExcluding(
			getStartLocation(),
			Collections.EMPTY_LIST);
		Rectangle marqueeRect = getMarqueeSelectionRectangle();
		for (Iterator itr = getAllChildren().iterator(); itr.hasNext();) {
			GraphicalEditPart child = (GraphicalEditPart)itr.next();
			if (child.getParent() != targetEditPart)
            {
                continue;
            }
				
			IFigure figure = child.getFigure();
			if (!child.isSelectable()
					|| child.getTargetEditPart(MARQUEE_REQUEST) != child
					|| !isFigureVisible(figure)
					|| !figure.isShowing())
            {
                continue;
            }

			Rectangle r = figure.getBounds().getCopy();
			figure.translateToAbsolute(r);
			boolean included = false;
			if (child instanceof ConnectionEditPart && marqueeRect.intersects(r)) {
				Rectangle relMarqueeRect = Rectangle.SINGLETON;
				figure.translateToRelative(relMarqueeRect.setBounds(marqueeRect));
				included = ((PolylineConnection)figure).getPoints().intersects(relMarqueeRect);
			}
            else
            {
                included = marqueeRect.contains(r);
            }

			if (included) {
				if (child.getSelected() == EditPart.SELECTED_NONE 
						|| getSelectionMode() != TOGGLE_MODE)
                {
                    newSelections.add(child);
                }
                else
                {
                    deselections.add(child);
                }
			}
		}
		
		if (getMarqueeBehavior() == BEHAVIOR_NODES_AND_CONNECTIONS)
        {
            calculateConnections(newSelections, deselections);
        }
	}
}
