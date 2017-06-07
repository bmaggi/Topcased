/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Jacques Lescot (Anyware Technologies) - initial API and implementation
 ******************************************************************************/
package org.topcased.modeler.internal.actions;

import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.INavigationListener;
import org.topcased.modeler.editor.Modeler;

/**
 * This action enables to navigate easily to the root diagram.<br>
 * 
 * Created : 19 Nov. 2007
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class GoToRootDiagramAction extends WorkbenchPartAction implements INavigationListener
{

    /**
     * The Constructor
     * 
     * @param part the IWorkbenchPart
     */
    public GoToRootDiagramAction(IWorkbenchPart part)
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
     * @see org.topcased.modeler.editor.INavigationListener#diagramChanged(org.topcased.modeler.di.model.Diagram)
     */
    public void diagramChanged(Diagram newDiagram)
    {
        refresh();
    }

    /**
     * Return true only when the active diagram is not the root diagram
     * 
     * @return <code>true</code> when the current diagram is not the root diagram
     */
    protected boolean calculateEnabled()
    {
        Modeler modeler = (Modeler) getWorkbenchPart();
        Diagram rootDiagram = DiagramsUtils.getRootDiagram(modeler.getDiagrams());
        return rootDiagram != null && !rootDiagram.equals(modeler.getActiveDiagram());
    }

    /**
     * Initializes the action
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setId(ModelerActionConstants.GO_TO_ROOT_DIAGRAM);
        setText("Go to Root Diagram");
    }

    /**
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run()
    {
        // get the modeler
        Modeler modeler = (Modeler) getWorkbenchPart();
        IAction action = new ChangeActiveDiagramAction(modeler, DiagramsUtils.getRootDiagram(modeler.getDiagrams()));
        action.run();
    }

}
