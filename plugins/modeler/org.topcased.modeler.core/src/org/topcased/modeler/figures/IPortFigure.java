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

import org.eclipse.draw2d.IFigure;

/**
 * An interface used to type figures that must handle like ports. During the
 * layout, they will be attached to the border.<br>
 * <br>
 * Creation : 14 oct. 2005<br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @deprecated Use the IPortFigure defined in the org.topcased.draw2d plugin
 */
public interface IPortFigure extends IFigure
{
    /** Parameter value to represent an input port */
    int IN_PORT = 0;

    /** Parameter value to represent an ouput port */
    int OUT_PORT = 1;

    /** Parameter value to represent an input/ouput port */
    int IN_OUT_PORT = 2;

    /**
     * 
     * @return int
     */
    int getPosition();

    /**
     * @param pos the border where the port is anchored
     */
    void setPosition(int pos);
}
