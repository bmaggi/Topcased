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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.util.DIUtils;

/**
 * The command used to change the router of a graphEdge
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ChangeRouterCommand extends Command
{

    private GraphEdge edge;

    private String oldRouter;

    private List<RelativeBendpoint> oldBendpoints;

    private String newRouter;

    /**
     * Constructor
     * 
     * @param element the GraphEdge
     * @param router the new router
     */
    public ChangeRouterCommand(GraphEdge element, String router)
    {
        super("Change Router");
        this.edge = element;
        this.newRouter = router;
    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute()
    {
        return edge != null;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        oldRouter = DIUtils.getPropertyValue(edge, ModelerPropertyConstants.ROUTER);
        oldBendpoints = new ArrayList<RelativeBendpoint>(edge.getWaypoints());
        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        edge.getWaypoints().clear();
        DIUtils.setProperty(edge, ModelerPropertyConstants.ROUTER, newRouter);
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        if ("".equals(oldRouter))
        {
            DIUtils.setProperty(edge, ModelerPropertyConstants.ROUTER, null);
        }
        else
        {
            DIUtils.setProperty(edge, ModelerPropertyConstants.ROUTER, oldRouter);
        }

        edge.getWaypoints().addAll(oldBendpoints);
    }

}
