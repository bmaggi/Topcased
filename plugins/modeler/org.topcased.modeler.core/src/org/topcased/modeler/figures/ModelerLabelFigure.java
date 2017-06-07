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
import org.eclipse.draw2d.PositionConstants;
import org.topcased.draw2d.figures.EditableLabel;
import org.topcased.draw2d.figures.ILabel;
import org.topcased.draw2d.figures.ILabelFigure;

/**
 * The figure to display a Label.
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ModelerLabelFigure extends EditableLabel implements ILabelFigure
{
    /**
     * Constructor
     */
    public ModelerLabelFigure()
    {
        super();
        setAlignment(PositionConstants.LEFT);
    }

    /**
     * Constructor
     */
    public ModelerLabelFigure(String text)
    {
        super(text);
        setAlignment(PositionConstants.LEFT);
    }

    /**
     * Constructor
     */
    public ModelerLabelFigure(TextProvider provider)
    {
        super(provider);
        setAlignment(PositionConstants.LEFT);
    }

    /**
     * Return the Header figure
     * 
     * @return returns the figure used to edit the name
     * @deprecated use getLabel() instead
     */
    public IFigure getHeader()
    {
        return this;
    }

    public ILabel getLabel()
    {
        return this;
    }
    
}
