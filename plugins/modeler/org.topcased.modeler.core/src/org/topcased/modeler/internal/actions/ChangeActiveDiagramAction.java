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

import org.eclipse.jface.action.Action;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.editor.Modeler;

/**
 * Create a new Diagram linked with a model object. <br>
 * 
 * @author jako
 */
public class ChangeActiveDiagramAction extends Action
{

    private Modeler editor;

    private Diagram newDiagram;

    /**
     * Constructor
     * 
     * @param ed the Editor
     * @param diag the new active diagram
     */
    public ChangeActiveDiagramAction(Modeler ed, Diagram diag)
    {
        super("Change Active Diagram");
        this.editor = ed;
        this.newDiagram = diag;
    }

    /**
     * Execute the Action
     * 
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run()
    {
        editor.setActiveDiagram(newDiagram);
    }

}
