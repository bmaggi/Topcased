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
package org.topcased.modeler.edit.handles;

import org.eclipse.gef.GraphicalEditPart;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.di.model.EdgeObjectOffset;

/**
 * A drag tracker for {@link org.topcased.modeler.di.model.EdgeObjectOffset}.<br>
 * Creation : 3 nov. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class EdgeObjectOffsetDragTracker extends EdgeObjectDragTracker
{
    public EdgeObjectOffsetDragTracker(GraphicalEditPart editPart, EdgeObjectOffset edgeObject)
    {
        super(editPart, edgeObject);
    }

    /**
     * @see org.eclipse.gef.tools.AbstractTool#getCommandName()
     */
    protected String getCommandName()
    {
        return ModelerRequestConstants.REQ_CHANGE_EO_OFFSET;
    }
}
