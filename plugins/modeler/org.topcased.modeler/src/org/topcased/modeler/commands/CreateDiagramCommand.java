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

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Display;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.DiagramsFactory;
import org.topcased.modeler.diagrams.model.DiagramsPackage;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.exceptions.BoundsFormatException;
import org.topcased.modeler.extensions.DiagramDescriptor;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.tools.Importer;

/**
 * 
 * Creation : 17 may 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class CreateDiagramCommand extends Command
{
    private Modeler editor;

    private Diagrams diagrams;

    private Diagram initialDiagram;

    private Diagram newDiagram;

    private EObject eObject;

    private DiagramDescriptor diagramDescriptor;

    private boolean initializeContent;

    private boolean containerDiagramsAlreadyExist;

    private String diagName = "unnamed";

	private boolean displayPopup = true;

    /**
     * Constructor
     * 
     * @param ed the Modeler
     * @param obj the model object associated with the diagram to create
     * @param diagram the DiagramDescriptor
     */
    public CreateDiagramCommand(Modeler ed, EObject obj, DiagramDescriptor diagram)
    {
        this(ed, obj, diagram, false);
    }

    /**
     * Constructor
     * 
     * @param ed the Modeler
     * @param obj the model object associated with the diagram to create
     * @param diagram the DiagramDescriptor
     * @param initialize if the children of the model objects must be imported
     *        graphically in the diagram
     */
    public CreateDiagramCommand(Modeler ed, EObject obj, DiagramDescriptor diagram, boolean initialize)
    {
        super("Create Diagram");
        this.editor = ed;
        this.eObject = obj;
        this.diagramDescriptor = diagram;
        this.initializeContent = initialize;
    }

    /**
     * Constructor
     * 
     * @param ed the Modeler
     * @param obj the model object associated with the diagram to create
     * @param diagram the DiagramDescriptor
     * @param initialize if the children of the model objects must be imported
     *        graphically in the diagram
     * @param diagName the title to set for the diagram, or null
     */
    public CreateDiagramCommand(Modeler ed, EObject obj, DiagramDescriptor diagram, boolean initialize, String diagName)
    {
        this(ed,obj,diagram,initialize);
        if (diagName != null)
            this.diagName = diagName;
    }
    
    /**
     * Constructor.
     *
     * @param ed the Modeler
     * @param obj the model object associated with the diagram to create
     * @param diagram the DiagramDescriptor
     * @param initialize if the children of the model objects must be imported
     * graphically in the diagram
     * @param diagName the title to set for the diagram, or null
     * @param displayPopup display the dialog box for drag and drop information
     */
    public CreateDiagramCommand(Modeler ed, EObject obj, DiagramDescriptor diagram, boolean initialize, String diagName, boolean displayPopup)
    {
        this(ed,obj,diagram,initialize);
        this.displayPopup  = displayPopup;
        if (diagName != null)
            this.diagName = diagName;
    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute()
    {
        return editor != null && eObject != null && diagramDescriptor != null;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        // diagrams = editor.getDiagrams();
        initialDiagram = editor.getActiveDiagram();
        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        Diagrams containerDiagrams = DiagramsUtils.findNearestContainerDiagrams(editor.getDiagrams(), eObject);
        
        containerDiagramsAlreadyExist = containerDiagrams != null && eObject.equals(containerDiagrams.getModel());
        if (!containerDiagramsAlreadyExist)
        {
            Diagrams rootDiagrams = editor.getDiagrams();
            while (rootDiagrams.eContainer() != null)
            {
                rootDiagrams = (Diagrams) rootDiagrams.eContainer() ;
            }
            containerDiagrams = DiagramsUtils.findNearestContainerDiagrams(rootDiagrams, eObject);
            containerDiagramsAlreadyExist = containerDiagrams != null && eObject.equals(containerDiagrams.getModel());
        }
        if (!containerDiagramsAlreadyExist)
        {
            containerDiagramsAlreadyExist = containerDiagrams == null ;
            if (containerDiagrams != null)
            {
                Diagrams grams = DiagramsFactory.eINSTANCE.createDiagrams();
                grams.setModel(eObject);
                containerDiagrams.getSubdiagrams().add(grams);
                containerDiagrams = grams ;
                containerDiagramsAlreadyExist = true ;
            }
        }
        if (containerDiagramsAlreadyExist)
        {
            // The Diagrams is already associated with the model object
            diagrams = containerDiagrams;

            Diagram diag = DiagramInterchangeFactory.eINSTANCE.createDiagram();
            EMFSemanticModelBridge bridge = DiagramInterchangeFactory.eINSTANCE.createEMFSemanticModelBridge();
            bridge.setPresentation(diagramDescriptor.getId());
            bridge.setElement(eObject);
            diag.setSemanticModel(bridge);

            // set the default properties of the Diagram
            diag.setName(diagName);
            diag.setPosition(new Point());
            diag.setSize(new Dimension(100, 100));
            diag.setViewport(new Point());

            newDiagram = diag;

            // add the newly created diagram to the model
            AddCommand.create(editor.getEditingDomain(), diagrams, DiagramsPackage.Literals.DIAGRAMS__DIAGRAMS, Collections.singleton(diag)).execute();
            // use a command instead of to force editing domain aware of add command
            //            diagrams.getDiagrams().add(diag);
           

            // update the activeDiagram
            editor.setActiveDiagram(diag);

            if (initializeContent)
            {
                importObjects();
            }
        }
        else
        {
            ModelerPlugin.log("an error occurs diagram creation impossible", IStatus.WARNING);
        }
    }

    private void importObjects()
    {
        Importer importer = new Importer(editor, eObject.eContents());
        importer.setDisplayDialogs(this.displayPopup);

        GraphicalViewer viewer = (GraphicalViewer) editor.getAdapter(GraphicalViewer.class);
        GraphicalEditPart target = (GraphicalEditPart) viewer.getEditPartRegistry().get(editor.getActiveDiagram());
        target.getFigure().validate();
        importer.setTargetEditPart(target);

        Dimension insets = new Dimension(10, 10);
        target.getContentPane().translateToAbsolute(insets);
        importer.setLocation(target.getContentPane().getBounds().getTopLeft().translate(insets));

        try
        {
            new ProgressMonitorDialog(Display.getDefault().getActiveShell()).run(false, true, importer);
        }
        catch (BoundsFormatException bfe)
        {
            ModelerPlugin.displayDialog("Drag'n Drop Problem", "A problem occured during drag'n drop :\n"
                    + bfe.getMessage(), IStatus.ERROR);
        }
        catch (InvocationTargetException ite)
        {
            ModelerPlugin.log(ite);
            ModelerPlugin.displayDialog("Error", "An error occurred. See error log for more details.", IStatus.INFO);
        }
        catch (InterruptedException ie)
        {
            ModelerPlugin.displayDialog("Operation Canceled", "The import was stopped.", IStatus.INFO);
        }

    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        if (containerDiagramsAlreadyExist)
        {
            // delete the last created diagram
            RemoveCommand.create(editor.getEditingDomain(), diagrams, DiagramsPackage.Literals.DIAGRAMS__DIAGRAMS, Collections.singleton(newDiagram)).execute();
//            diagrams.getDiagrams().remove(newDiagram);

            // restore the initial diagram
            editor.setActiveDiagram(initialDiagram);
        }
    }
}