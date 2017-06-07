/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
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
package org.topcased.draw2d.figures;

import org.eclipse.draw2d.IFigure;

/**
 * A figure that contains other objects. Those objects can be contained directly
 * in this figure or in an inner one. Then, this figure can return the "real"
 * container figure with the method "getContentPane()"<br>
 * <br>
 * creation : 9 nov. 2005<br>
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public interface IContainerFigure extends IFigure
{

    /**
     * @return the Container Figure
     */
    IFigure getContentPane();
}
