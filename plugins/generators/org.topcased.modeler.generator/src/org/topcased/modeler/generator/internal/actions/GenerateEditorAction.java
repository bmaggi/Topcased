/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.generator.internal.actions;

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
import org.topcased.modeler.editorconfigurator.EditorConfiguration;
import org.topcased.modeler.generator.internal.GeneratorPlugin;
import org.topcased.modeler.generator.internal.generators.EditorConfiguratorGenerator;

/**
 * Action that generates editor classes conforming to a default JET templates.
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class GenerateEditorAction implements IActionDelegate
{
    private ISelection selection;

    private IProject generatedProject;

    /**
     * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(IAction action, ISelection sel)
    {
        selection = sel;
        action.setEnabled(true);
    }

    /**
     * Try to retrieve the selected file from the given selection
     * 
     * @param sel the selection
     * @return the selected file
     */
    private IFile convertSelection2File(ISelection sel)
    {
        // get the selected *.configuration file
        if (selection instanceof IStructuredSelection)
        {
            IStructuredSelection ssel = (IStructuredSelection) sel;
            if (!ssel.isEmpty() && ssel.size() == 1)
            {
                Object selectedObj = ssel.getFirstElement();
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

    /**
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    public void run(IAction action)
    {
        // get the selected *.configuration file
        final IFile file = convertSelection2File(selection);
        if (file == null)
        {
            GeneratorPlugin.displayDialog(null, "Invalid selection : Only one file can be selected.", IStatus.ERROR);
            return;
        }

        WorkspaceModifyOperation op = new WorkspaceModifyOperation()
        {
            public void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException
            {
                monitor.beginTask("Editor Generation process", 11);
                try
                {
                    ConfiguratorObjectManager manager = new ConfiguratorObjectManager();
                    manager.load(file.getFullPath());
                    // retrieve the root model object and check if it has the expected type
                    if (manager.getRootModelObject() instanceof EditorConfiguration)
                    {
                        EditorConfiguration configuration = (EditorConfiguration) manager.getRootModelObject();

                        monitor.subTask("Editor Configuration validation");
                        Diagnostician diagnostician = new Diagnostician();
                        Diagnostic diagnostic = diagnostician.validate(configuration);
                        if (diagnostic.getSeverity() <= Diagnostic.INFO)
                        {
                            monitor.worked(1);

                            EditorConfiguratorGenerator generator = new EditorConfiguratorGenerator(configuration);
                            generatedProject = generator.generate(monitor);
                        }
                        else
                        {
                            GeneratorPlugin.log("Validation problem : a problem occured during the editor configuration validation.", IStatus.ERROR);

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
            dialog.run(true, false, op);

            ConfiguratorObjectManager manager = new ConfiguratorObjectManager();
            manager.load(file.getFullPath());
            // retrieve the root model object and check if it has the expected type
            if (manager.getRootModelObject() instanceof EditorConfiguration)
            {
                EditorConfiguration configuration = (EditorConfiguration) manager.getRootModelObject();
                if (configuration.isOrganizeImports())
                {
                    AbstractGenerator.organizeImports(generatedProject);
                }
            }
        }
        catch (Exception e)
        {
            GeneratorPlugin.log(e);
            GeneratorPlugin.displayDialog(null, "An error occurred during the editor generation", IStatus.ERROR);
        }
    }

}
