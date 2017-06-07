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

/**
 * A figure that has a label. Then, this figure can return the label 
 * figure with the method "getLabel()"<br>
 * <br>
 * creation : 13 dec. 2005<br>
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public interface ILabelFigure extends IFigure
{

    /**
     * @return the Label Figure
     */
    ILabel getLabel();
    
}
