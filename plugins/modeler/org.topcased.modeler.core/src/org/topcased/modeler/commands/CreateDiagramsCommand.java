/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.commands.Command;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.DiagramsFactory;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.Modeler;

/**
 * This command create a Diagrams model object when none is associated yet with the given EObject.
 * 
 * Creation 6 nov. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class CreateDiagramsCommand extends Command
{
    // The Modeler
    private Modeler editor;

    // The diagrams that is being created in the case when no Diagrams is associated with the eObject yet
    private Diagrams diagrams;

    // The model object that is associated with the Diagrams
    private EObject eObject;

    // Record whether a Diagrams already exist. This is used to determine whether a Diagrams model object should be
    // created or not.
    private boolean containerDiagramsAlreadyExist;

    /**
     * Constructor
     * 
     * @param ed the Modeler
     * @param obj the model object associated with the diagram to create
     */
    public CreateDiagramsCommand(Modeler ed, EObject obj)
    {
        super("Create Diagrams");
        this.editor = ed;
        this.eObject = obj;
    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute()
    {
        boolean isReadonly = false ;
        if (editor != null && eObject != null)
        {
            EditingDomain domain = editor.getEditingDomain();
            isReadonly = domain.isReadOnly(eObject.eResource());
        }
        
        return !isReadonly && editor != null && eObject != null;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        Diagrams containerDiagrams = DiagramsUtils.findNearestContainerDiagrams(editor.getDiagrams(), eObject);

        if (containerDiagrams == null)
        {
            containerDiagramsAlreadyExist = false;
            // the eObject is a parent of the current diagram object
            if (EcoreUtil.isAncestor(eObject, editor.getDiagrams().getModel()))
            {
                // The containerDiagrams we try to add should be added as the root Diagrams object

                // create the new Diagrams to associate with the eObject
                diagrams = DiagramsFactory.eINSTANCE.createDiagrams();
                diagrams.setModel(eObject);

                // Set the Diagrams as the new root object
                editor.getDiagrams().setParent(diagrams);
                editor.getDiagrams().eResource().getContents().set(0, diagrams);
            }
            else
            {
                // Check if the root object of the model file is a common ancestor
                Resource modelResource = editor.getDiagrams().getModel().eResource();
                EObject modelRoot = (EObject) modelResource.getContents().get(0);
                if (EcoreUtil.isAncestor(modelRoot, editor.getDiagrams().getModel()) && EcoreUtil.isAncestor(modelRoot, eObject))
                {
                    Diagrams rootDiagrams = DiagramsFactory.eINSTANCE.createDiagrams();
                    rootDiagrams.setModel(modelRoot);

                    // create the new Diagrams to associate with the eObject
                    diagrams = DiagramsFactory.eINSTANCE.createDiagrams();
                    diagrams.setModel(eObject);

                    // Set the Diagrams as the new root object
                    editor.getDiagrams().setParent(rootDiagrams);
                    diagrams.setParent(rootDiagrams);

                    editor.getDiagrams().eResource().getContents().set(0, rootDiagrams);
                }
                else
                {
                    // TODO throw an exception
                }
            }
        }
        else
        {
            containerDiagramsAlreadyExist = eObject.equals(containerDiagrams.getModel());

            if (!containerDiagramsAlreadyExist)
            {
                // create the new Diagrams to associate with the eObject
                diagrams = DiagramsFactory.eINSTANCE.createDiagrams();
                diagrams.setModel(eObject);

                if (!containerDiagrams.getSubdiagrams().isEmpty())
                {
                    // The newly created Diagrams is the new container of the diagrams contained by the initial
                    // containerDiagrams

                    // 1. Find the list of existing Diagrams that should be moved into that new container
                    List<Diagrams> childDiagramList = new ArrayList<Diagrams>();
                    for (Iterator<Diagrams> itSubdiagrams = containerDiagrams.getSubdiagrams().iterator(); itSubdiagrams.hasNext();)
                    {
                        Diagrams possibleChildDiagrams = itSubdiagrams.next();
                        // The Diagrams should move only if it is associated with a model object that is a descendant of
                        // the eObject element
                        if (EcoreUtil.isAncestor(eObject, possibleChildDiagrams.getModel()))
                        {
                            childDiagramList.add(possibleChildDiagrams);
                        }

                    }

                    // 2. Move the children diagrams into the newly created Diagrams
                    for (Iterator<Diagrams> itChildDiagram = childDiagramList.iterator(); itChildDiagram.hasNext();)
                    {
                        Diagrams subdiagrams = itChildDiagram.next();
                        subdiagrams.setParent(diagrams);
                    }
                }
                containerDiagrams.getSubdiagrams().add(diagrams);
            }
        }
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        if (!containerDiagramsAlreadyExist && diagrams != null && diagrams.getParent() != null)
        {
            if (!diagrams.getSubdiagrams().isEmpty())
            {
                // 1. Find the list of existing Diagrams that should be moved into that new container
                List<Diagrams> childDiagramList = new ArrayList<Diagrams>();
                for (Iterator<Diagrams> itSubdiagrams = diagrams.getSubdiagrams().iterator(); itSubdiagrams.hasNext();)
                {
                    childDiagramList.add(itSubdiagrams.next());
                }

                // 2. Move the children diagrams into the newly created Diagrams
                for (Iterator<Diagrams> itChildDiagram = childDiagramList.iterator(); itChildDiagram.hasNext();)
                {
                    // Restore the initial container Diagrams
                    Diagrams subdiagrams = itChildDiagram.next();
                    subdiagrams.setParent(diagrams.getParent());
                }
            }
            // Remove the created diagrams
            diagrams.setParent(null);
        }
    }

}
