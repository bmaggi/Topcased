/*******************************************************************************
 * Copyright (c) 2005, 2007 AIRBUS FRANCE.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.dialogs.ChooseGraphElementDialog;
import org.topcased.modeler.editor.INavigationListener;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.utils.Utils;

/**
 * This action enables to navigate easily to the parent diagram of the current diagram. <br>
 * 
 * Created : 11 July 2005
 * Updated : 19 Nov. 2007
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class OpenParentDiagramAction extends WorkbenchPartAction implements INavigationListener
{

    /**
     * The Constructor
     * 
     * @param part the IWorkbenchPart
     */
    public OpenParentDiagramAction(IWorkbenchPart part)
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
     * Check whether at least one diagram is considered as a parent one
     * 
     * @return <code>true</code> whether a parent diagram exists
     */
    protected boolean calculateEnabled()
    {
        return !getParentDiagrams().isEmpty();
    }

    /**
     * Initializes the action
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setId(ModelerActionConstants.OPEN_PARENT_DIAGRAM);
        setText("Open a Parent Diagram");
    }

    /**
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run()
    {
        // get the modeler
        Modeler modeler = (Modeler) getWorkbenchPart();

        List<Diagram> possibleDiagrams = getParentDiagrams();

        if (!possibleDiagrams.isEmpty())
        {
            Diagram selectedDiagram = (Diagram) chooseGraphElement(possibleDiagrams.toArray(new Diagram[possibleDiagrams.size()]), (EditDomain) modeler.getAdapter(EditDomain.class));
            if (selectedDiagram != null)
            {
                IAction action = new ChangeActiveDiagramAction(modeler, selectedDiagram);
                action.run();
            }

        }
        else
        {
            ModelerPlugin.displayDialog("No parent Diagram", "There is no parent diagram (Note that you should never read this message, otherwise it means that something went wrong", IStatus.INFO);
        }

    }

    private List<Diagram> getParentDiagrams()
    {
        // Get the modeler
        Modeler modeler = (Modeler) getWorkbenchPart();

        List<Diagram> parentDiagrams = new ArrayList<Diagram>();

        // Get the current diagram
        Diagram currentDiagram = modeler.getActiveDiagram();

        if (currentDiagram != null && currentDiagram.getSemanticModel() != null)
        {
            // Get the model object (the model object associated with the current diagram and its parent in the model)
            EObject modelObject = Utils.getElement(currentDiagram.getSemanticModel().getGraphElement());

            while (modelObject != null && modelObject.eContainer() != null && parentDiagrams.isEmpty())
            {
                EObject parentModelObject = modelObject.eContainer();

                // We search if a diagram already exists
                parentDiagrams = DiagramsUtils.findAllExistingDiagram(modeler.getDiagrams(), parentModelObject);

                modelObject = parentModelObject;
            }
        }

        return parentDiagrams;
    }

    /**
     * Returns the destination GraphElement from a choices list
     * 
     * @param elements the list of available GraphElements
     * @param domain the editor edit domain
     * @return the selected GraphElement
     */
    private GraphElement chooseGraphElement(GraphElement[] elements, EditDomain domain)
    {
        GraphElement chosenElt = null;
        if (elements.length == 1)
        {
            chosenElt = elements[0];
        }
        else
        {
            ChooseGraphElementDialog dialog = new ChooseGraphElementDialog(getWorkbenchPart().getSite().getShell(), domain, elements);

            if (dialog.open() == Window.OK)
            {
                Object[] selection = dialog.getResult();

                if (selection != null && selection.length > 0)
                {
                    chosenElt = (GraphElement) selection[0];
                }
            }
        }

        return chosenElt;
    }
}
