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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.commands.Command;
import org.topcased.modeler.di.model.EdgeObjectOffset;

/**
 * A command to move {@link org.topcased.modeler.di.model.EdgeObjectOffset}.<br>
 * Creation : 25 oct. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class MoveEdgeObjectOffsetCommand extends Command
{
    private Dimension newOffset;

    private Dimension oldOffset;

    private EdgeObjectOffset edgeObject;

    public MoveEdgeObjectOffsetCommand(EdgeObjectOffset edgeObject, Dimension newOffset)
    {
        super("Move edge object offset");
        this.edgeObject = edgeObject;
        this.oldOffset = edgeObject.getOffset();
        this.newOffset = newOffset;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        edgeObject.setOffset(newOffset);
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        edgeObject.setOffset(oldOffset);
    }
}
