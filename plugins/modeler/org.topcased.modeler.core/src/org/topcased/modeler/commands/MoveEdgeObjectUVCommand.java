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
package org.topcased.modeler.commands;

import org.eclipse.gef.commands.Command;
import org.topcased.modeler.di.model.EdgeObjectUV;

/**
 * A command to move {@link org.topcased.modeler.di.model.EdgeObjectUV} <br>
 * <br>
 * Creation : 3 nov. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class MoveEdgeObjectUVCommand extends Command
{
    private EdgeObjectUV edgeObject;

    private int oldUDistance;

    private int newUDistance;

    private int oldVDistance;

    private int newVDistance;

    public MoveEdgeObjectUVCommand(EdgeObjectUV edgeObject, int newUDistance, int newVDistance)
    {
        super("Move edge object UV");
        this.edgeObject = edgeObject;
        this.oldUDistance = edgeObject.getUDistance();
        this.oldVDistance = edgeObject.getVDistance();
        this.newUDistance = newUDistance;
        this.newVDistance = newVDistance;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        edgeObject.setUDistance(newUDistance);
        edgeObject.setVDistance(newVDistance);
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        edgeObject.setUDistance(oldUDistance);
        edgeObject.setVDistance(oldVDistance);
    }
}
