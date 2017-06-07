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

import org.eclipse.draw2d.Graphics;
import org.topcased.draw2d.figures.EditableLabel;

/**
 * A Label that can be rotated
 * 
 * Creation : 13 oct. 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @deprecated a similar figure should be created if necessary in the
 *             org.topcased.draw2d plugin
 */
public class RotatableEditableLabel extends EditableLabel
{
    private float _rotationAngle = 0.0f;

    public RotatableEditableLabel()
    {
        super();
    }

    public RotatableEditableLabel(String s)
    {
        super(s);
    }

    public void paintFigure(Graphics graphics)
    {
        graphics.pushState();
        // graphics.rotate(90.0f);
        super.paintFigure(graphics);
        graphics.popState();

    }

    /**
     * 
     * @param newRotationAngle
     */
    public void setRotationAngle(float newRotationAngle)
    {
        _rotationAngle = newRotationAngle;
    }

}
