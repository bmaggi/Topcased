/*******************************************************************************
 * Copyright (c) 2008 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.actions;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.action.Action;
import org.topcased.modeler.commands.EMFtoGEFCommandWrapper;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.diagrams.model.DiagramsPackage;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * An action used to duplicate the given diagram. The new diagram is added at the same level than the initial diagram.
 * 
 * Creation 13 mars 08
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class DuplicateDiagramAction extends Action
{
    // The diagram to duplicate
    private Diagram diagram;

    // The Modeler editDomain
    private IMixedEditDomain editDomain;

    /**
     * Constructor
     * 
     * @param domain The editor EditDomain
     * @param diag the Diagram to duplicate
     */
    public DuplicateDiagramAction(IMixedEditDomain domain, Diagram diag)
    {
        super("Duplicate diagram", ModelerPlugin.getImageDescriptor("icons/duplicateDiagram.png"));

        this.editDomain = domain;
        this.diagram = diag;
    }

    /**
     * @see org.eclipse.jface.action.Action#run()
     */
    public void run()
    {
    	// Clone the current diagram
        Diagram clonedDiagram = (Diagram) EcoreUtil.copy(diagram);
        // Give a new name
        clonedDiagram.setName(diagram.getName() + " (duplicated)");
        // Execute changes through a Command so that Undo/Redo is supported
        editDomain.getGEFCommandStack().execute(
                new EMFtoGEFCommandWrapper(new AddCommand(editDomain.getEMFEditingDomain(), diagram.eContainer(), DiagramsPackage.eINSTANCE.getDiagrams_Diagrams(), clonedDiagram)));
    }
}
