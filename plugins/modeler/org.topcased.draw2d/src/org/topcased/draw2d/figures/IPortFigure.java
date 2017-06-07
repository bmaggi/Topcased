/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/

package org.topcased.draw2d.figures;

import org.eclipse.draw2d.IFigure;

/**
 * An interface used to type figures that must handle like ports. During the
 * layout, they are attached to the border.<br>
 * 
 * Creation 11 juil. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public interface IPortFigure extends IFigure
{
    /**
     * Returns the attached position inside its container Figure.
     * 
     * @return PositionConstant representing the position
     */
    int getPosition();

    /**
     * Set the position of the Figure. The available values are those defined by
     * the {@link org.eclipse.draw2d.PositionConstants} : TOP, BOTTOM, LEFT, RIGHT or NONE.
     * 
     * @param pos the border where the port is anchored
     */
    void setPosition(int pos);
}
