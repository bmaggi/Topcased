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
package org.topcased.modeler.requests;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.Request;
import org.topcased.modeler.ModelerRequestConstants;

/**
 * This request asks the auto layout of the given elements. <br>
 * creation : 4 mai 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class AutoResizeRequest extends Request
{

    private Dimension clientSize;
    
    private int margin = 10;

    /**
     * Constructor
     */
    public AutoResizeRequest()
    {
        super();
        setType(ModelerRequestConstants.REQ_AUTORESIZE);
    }

    public void setContentPaneSize(Dimension d)
    {
        this.clientSize = d;
    }

    public Dimension getContentPaneSize()
    {
        return clientSize;
    }

    /**
     * Defines the margin around the inner objects
     * @param m the margin to use
     */
    public void setMargin(int m)
    {
        this.margin = m;
    }

    /**
     * Returns the margin around the inner objects
     * @return Returns the margin.
     */
    public int getMargin()
    {
        return margin;
    }
    
    
}
