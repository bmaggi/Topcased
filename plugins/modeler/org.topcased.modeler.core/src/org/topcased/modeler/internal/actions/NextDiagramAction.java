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
package org.topcased.modeler.internal.actions;

import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.editor.INavigationListener;
import org.topcased.modeler.editor.Modeler;

/**
 * This action enables to navigate to the next diagram. <br>
 * <br>
 * creation : 16 déc. 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class NextDiagramAction extends WorkbenchPartAction implements INavigationListener
{

    /**
     * The Constructor
     * 
     * @param part the IWorkbenchPart
     */
    public NextDiagramAction(IWorkbenchPart part)
    {
        super(part);
        Modeler modeler = (Modeler) getWorkbenchPart();
        modeler.getNavigationManager().addNavigationListener(this);
    }
    
    /**
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#dispose()
     */
    public void dispose()
    {
        Modeler modeler = (Modeler) getWorkbenchPart();
        modeler.getNavigationManager().removeNavigationListener(this);
        super.dispose();
    }

    /**
     * Always return true
     * 
     * @return <code>true</code>
     */
    protected boolean calculateEnabled()
    {
        // get the modeler
        Modeler modeler = (Modeler) getWorkbenchPart();
        return modeler.getNavigationManager().canDoNext();
    }

    /**
     * Initializes the action
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setId(ModelerActionConstants.NEXT_DIAGRAM);
        setText("Next Diagram");
    }

    /**
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run()
    {
        // get the modeler
        Modeler modeler = (Modeler) getWorkbenchPart();
        modeler.getNavigationManager().next();
    }

    /**
     * @see org.topcased.modeler.editor.INavigationListener#diagramChanged(org.topcased.modeler.di.model.Diagram)
     */
    public void diagramChanged(Diagram newDiagram)
    {
        refresh();
    }
}
