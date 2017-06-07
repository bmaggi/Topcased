/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Thomas Friol (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.outline.generator.internal.actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.topcased.generator.AbstractGenerator;
import org.topcased.generator.util.ConfiguratorObjectManager;
import org.topcased.outline.configurator.OutlineConfiguration;
import org.topcased.outline.generator.OutlineGenerator;
import org.topcased.outline.generator.internal.GeneratorPlugin;

/**
 * Action that generates outline code. <br>
 * 
 * Creation : 3 nov. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class GenerateOutlineAction implements IActionDelegate
{
    /** The current selection */
    private ISelection currentSelection;

    /** The generated project */
    private IProject genProject;

    /**
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    public void run(IAction action)
    {
        final IFile file = getFileFromSelection();
        if (file == null)
        {
            GeneratorPlugin.displayDialog(null, "Invalid selection : Only one file can be selected.", IStatus.ERROR);
            return;
        }

        WorkspaceModifyOperation op = new WorkspaceModifyOperation()
        {
            public void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException
            {
                monitor.beginTask("Generation process", 10);
                try
                {
                    ConfiguratorObjectManager manager = new ConfiguratorObjectManager();
                    manager.load(file.getFullPath());
                    // retrieve the root model object and check if it has the expected type
                    if (manager.getRootModelObject() instanceof OutlineConfiguration)
                    {
                        OutlineConfiguration configuration = (OutlineConfiguration) manager.getRootModelObject();
                        monitor.subTask("Properties Configuration validation");
                        Diagnostician diagnostician = new Diagnostician();
                        Diagnostic diagnostic = diagnostician.validate(configuration);
                        if (diagnostic.getSeverity() <= Diagnostic.INFO)
                        {
                            monitor.worked(1);

                            OutlineGenerator generator = new OutlineGenerator(configuration);
                            genProject = generator.generate(monitor);
                        }
                        else
                        {
                            GeneratorPlugin.log("Validation problem : a problem occured during the properties configuration validation.", IStatus.ERROR);
                        }
                    }
                    else
                    {
                        GeneratorPlugin.log("The root model object has not the right type. Generation process has been aborted.", IStatus.ERROR);
                    }
                }
                catch (IOException ioe)
                {
                    IStatus status = new Status(IStatus.ERROR, GeneratorPlugin.getId(), IStatus.OK, "Operation failed.", ioe);
                    throw new CoreException(status);
                }
                finally
                {
                    monitor.done();
                }
            }
        };

        try
        {
            Shell shell = GeneratorPlugin.getActiveWorkbenchShell();
            ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
            dialog.run(false, true, op);

            AbstractGenerator.organizeImports(genProject);
        }
        catch (Exception e)
        {
            GeneratorPlugin.log(e);
            GeneratorPlugin.displayDialog(null, "An error occurred during the outline generation", IStatus.ERROR);
        }

    }

    /**
     * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(IAction action, ISelection selection)
    {
        this.currentSelection = selection;
        action.setEnabled(true);
    }

    /**
     * Try to retrieve the selected file from the current selection.
     * 
     * @return the selected file
     */
    private IFile getFileFromSelection()
    {
        // get the selected *.configuration file
        if (currentSelection instanceof IStructuredSelection)
        {
            IStructuredSelection sel = (IStructuredSelection) currentSelection;
            if (!sel.isEmpty() && sel.size() == 1)
            {
                Object selectedObj = sel.getFirstElement();
                if (selectedObj instanceof IFile)
                {
                    return (IFile) selectedObj;
                }
                // Try to adapt
                if (selectedObj instanceof IAdaptable)
                {
                    return (IFile) ((IAdaptable) selectedObj).getAdapter(IFile.class);
                }
            }
        }
        return null;
    }
}
