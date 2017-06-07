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
package org.topcased.modeler.commands;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.topcased.modeler.di.model.GraphEdge;

/**
 * @author Pratik Shah
 * @since 3.1
 * @deprecated
 */
public class CreateBendpointCommand extends Command
{

    private GraphEdge link;

    private Bendpoint point;

    public CreateBendpointCommand(GraphEdge link, Point location, int index)
    {
        super("Create Bendpoint");
        this.link = link;
        point = new AbsoluteBendpoint(location);
    }

    public boolean canExecute()
    {
        return link != null && point != null;
    }

    public void execute()
    {
        System.out.println("The CreateBendPointCommand need to be refactored - Pb of type when migrate to Java 1.5");
        // link.getWaypoints().add(index, point);
    }

    public void undo()
    {
        // link.getWaypoints().remove(index);
    }

}
