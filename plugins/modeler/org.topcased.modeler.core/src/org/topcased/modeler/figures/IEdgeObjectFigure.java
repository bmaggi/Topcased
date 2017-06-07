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
import org.eclipse.draw2d.IFigure;

/**
 * An interface defining the structure of an
 * {@link org.topcased.modeler.di.model.EdgeObject} figure.<br>
 * Creation : 24 oct. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public interface IEdgeObjectFigure extends IFigure
{
    /**
     * Gets the owner connection figure
     * 
     * @return a connection figure
     */
    Connection getConnection();

    /**
     * Tests whether this edge object figure is empty or not
     * 
     * @return a boolean
     */
    boolean isEmpty();

    /**
     * Tests whether this edge object figure is editable or not
     * 
     * @return a boolean
     */
    boolean isEditable();
}
