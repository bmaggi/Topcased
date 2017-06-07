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
package org.topcased.modeler.edit.requests;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.requests.LocationRequest;
import org.topcased.modeler.di.model.EdgeObject;

/**
 * A request defining an edge object moving. <br>
 * Creation : 25 oct. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class MoveEdgeObjectRequest extends LocationRequest
{
    private EdgeObject edgeObject;

    private Dimension moveDelta;

    public void setEdgeObject(EdgeObject edgeObject)
    {
        this.edgeObject = edgeObject;
    }

    public EdgeObject getEdgeObject()
    {
        return edgeObject;
    }

    public Dimension getMoveDelta()
    {
        return moveDelta;
    }

    public void setMoveDelta(Dimension moveDelta)
    {
        this.moveDelta = moveDelta;
    }
}
