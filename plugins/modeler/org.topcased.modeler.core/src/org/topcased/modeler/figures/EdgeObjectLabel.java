/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies), Thomas Friol (Anyware
 * Technologies) - initial API and implementation
 ******************************************************************************/
package org.topcased.modeler.figures;

import org.eclipse.draw2d.Connection;
import org.topcased.draw2d.figures.Label;

/**
 * A figure to represent a label edge object. <br>
 * Creation : 25 oct. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class EdgeObjectLabel extends Label implements IEdgeObjectFigure
{
    /* The owning connection */
    private Connection connection;

    /**
     * 
     */
    public EdgeObjectLabel(Connection connection)
    {
        super();
        this.connection = connection;
    }

    /**
     * @see org.topcased.modeler.figures.IEdgeObjectFigure#getConnection()
     */
    public Connection getConnection()
    {
        return connection;
    }

    /**
     * @see org.topcased.modeler.figures.IEdgeObjectFigure#isEmpty()
     */
    public boolean isEmpty()
    {
        return getText().length() == 0;
    }

    /**
     * @see org.topcased.modeler.figures.IEdgeObjectFigure#isEditable()
     */
    public boolean isEditable()
    {
        return false;
    }
}
