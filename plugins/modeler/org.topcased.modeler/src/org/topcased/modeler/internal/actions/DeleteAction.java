/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 * 
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation Tristan FAURE (ATOS ORIGIN INTEGRATION)
 * tristan.faure@atosorigin.com - Fix delete errors Ludi Akue (ATOS ORIGIN
 * INTEGRATION) ludi.akue@atosorigin.com - improve multi-deletion mechanism
 * 
 *****************************************************************************/
package org.topcased.modeler.internal.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.topcased.modeler.commands.DeleteModelCommand;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.SemanticModelBridge;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.actions.precondition.ActionPreconditionHandler;
import org.topcased.modeler.l10n.Messages;
import org.topcased.modeler.utils.Utils;

/**
 * This action is used to delete selected element(s) in the outline.<br>
 * 
 * Creation : 30 mai 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class DeleteAction extends Action
{
    private Diagrams diagrams;

    /**
     * The selected objects
     */
    private IStructuredSelection selection;

    /**
     * The Modeler editDomain
     */
    private IMixedEditDomain editDomain;

    private Modeler modeler;

    /**
     * Constructor
     * 
     * @param domain The editor EditDomain
     * @param diagrams the root Diagrams element
     * @param sel the selected element(s)
     */
    public DeleteAction(IMixedEditDomain domain, Diagrams diagrams, ISelection sel)
    {
        super(Messages.getString("DeleteModelObjectAction.CmdLabel"),
                ModelerPlugin.getImageDescriptor("icons/deleteFromModel.gif"));

        this.diagrams = diagrams;
        this.editDomain = domain;
        if (sel instanceof IStructuredSelection)
        {
            this.selection = (IStructuredSelection) sel;
        }
        setEnabled(isParametersOK());
    }

    /**
     * Check the parameters validity
     * 
     * @return <code>true</code> if the parameters are valid
     */
    protected boolean isParametersOK()
    {
        return diagrams != null && editDomain != null && selection != null && !selection.isEmpty();
    }

    /**
     * Creates the GEF command that deletes the objects
     * 
     * @return the creation command
     */
    protected Command createActionCommand(IStructuredSelection sel)
    {
        CompoundCommand globalCommand = new CompoundCommand();
        // sort to put graphedge at the begin of list
        Iterator< ? > it = selection.iterator();
        try
        {
            DeleteModelCommand.initListening();
            List<EObject> eobjects = new LinkedList<EObject>();
            while (it.hasNext())
            {
                Object obj = it.next();

                if (obj instanceof IWrapperItemProvider || obj instanceof FeatureMap.Entry || obj instanceof EObject)
                {
                    EObject model = (EObject) AdapterFactoryEditingDomain.unwrap(obj);
                    eobjects.add(model);
                }
            }
            Collections.sort(eobjects, new Utils.EObjectComparatorForGraphElements(diagrams));
            DeleteModelCommand command = new DeleteModelCommand(editDomain, diagrams, eobjects);
            if (!command.getCommands().isEmpty())
            {
                globalCommand.add(command);
            }
        }
        finally
        {
            DeleteModelCommand.stopListening();
        }

        return globalCommand;
    }

    /**
     * This executes the command.
     */
    public void run()
    {
        if (isParametersOK())
        {
            modeler = (Modeler) editDomain.getEditorPart();
            boolean conditionsChecked = ActionPreconditionHandler.getInstance().executePreconditions(this, modeler,
                    selection);
            if (conditionsChecked)
            {
                ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(Display.getDefault().getActiveShell());
                try
                {
                    // Fix for [#4134] : run must not be forked to avoid dead lock with transactions
                    progressDialog.run(false, false, new IRunnableWithProgress()
                    {
                        public void run(IProgressMonitor monitor) throws InvocationTargetException,
                                InterruptedException
                        {
                            DeleteAction.this.run(monitor);
                        }
                    });
                }
                catch (InvocationTargetException ite)
                {
                    ModelerPlugin.log(ite);
                    ModelerPlugin.displayDialog("Unable to delete",
                            "An error occurred during the delete action. See error logs for more details.",
                            IStatus.ERROR);
                }
                catch (InterruptedException ie)
                {
                    ModelerPlugin.log(ie);
                    ModelerPlugin.displayDialog("Unable to delete",
                            "An error occurred during the delete action. See error logs for more details.",
                            IStatus.ERROR);
                }
            }
        }
    }

    /**
     * Compute and execute the delete command
     * 
     * @param monitor the progress monitor
     */
    protected void run(final IProgressMonitor monitor)
    {
        monitor.beginTask("Delete the objects", 2);
        monitor.setTaskName("Compute command");
        Command command = createActionCommand(selection);
        monitor.worked(1);
        if (command != null && command.canExecute())
        {
            monitor.setTaskName("Execute command");
            // #BUG 2559
            switchDiagram();
            editDomain.getGEFCommandStack().execute(command);
            monitor.worked(1);
        }
        else
        {
            Display.getDefault().syncExec(new Runnable()
            {
                public void run()
                {
                    ModelerPlugin.displayDialog("Unable to delete", "One of the selected object cannot be deleted",
                            IStatus.WARNING);
                }
            });
        }
        monitor.done();
    }

    /**
     * Switch to the parent diagram if the active diagram is contained in the deleted element
     */
    private void switchDiagram()
    {
        // check if deleted element is the one of the diagram container
        SemanticModelBridge model = modeler.getActiveDiagram().getSemanticModel();
        if (model instanceof EMFSemanticModelBridge)
        {
            EObject element = ((EMFSemanticModelBridge) model).getElement();
            Object firstElement = selection.getFirstElement();
            if (firstElement instanceof EObject && element != null
                    && EcoreUtil.isAncestor((EObject) firstElement, element))
            {
                ModelerPlugin.getDefault().getWorkbench().getDisplay().syncExec(new Runnable()
                {
                    public void run()
                    {
                        OpenParentDiagramAction action = new OpenParentDiagramAction(modeler);
                        action.run();
                    }
                });
            }
        }
    }
}
