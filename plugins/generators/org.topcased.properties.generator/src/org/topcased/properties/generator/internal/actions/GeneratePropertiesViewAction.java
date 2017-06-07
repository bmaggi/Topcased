/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation, Alfredo Serrano (Anyware Technologies) - updated API
 ******************************************************************************/
package org.topcased.properties.generator.internal.actions;

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
import org.topcased.properties.configurator.TabbedView;
import org.topcased.properties.generator.PropertiesViewGenerator;
import org.topcased.properties.generator.internal.PropertiesViewGeneratorPlugin;

/**
 * Action that generates the tabbed properties section classes conforming to the JET templates.
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:alfredo@anyware-tech.com">Alfredo Serrano</a>
 */
public class GeneratePropertiesViewAction implements IActionDelegate
{
    /** The current file currentSelection */
    private ISelection currentSelection;

    /** The project to be generated */
    private IProject generatedProject;

    /**
     * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(IAction action, ISelection sel)
    {
        currentSelection = sel;
        action.setEnabled(true);
    }

    /**
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    public void run(IAction action)
    {
        // get the selected *.propertiesconfigurator file
        final IFile file = getFileFromSelection();
        if (file == null)
        {
            PropertiesViewGeneratorPlugin.displayDialog(null, "Invalid currentSelection : Only one file can be selected.", IStatus.ERROR);
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
                    if (manager.getRootModelObject() instanceof TabbedView)
                    {
                        TabbedView configuration = (TabbedView) manager.getRootModelObject();
                        if (!hasCorrectId(configuration.getId()))
                        {
                            PropertiesViewGeneratorPlugin.log("WARNING : The tabbed view identifier must not contain spaces. Please check the tabbedViewId", IStatus.WARNING);
                        }
                        monitor.subTask("Properties Configuration validation");
                        Diagnostician diagnostician = new Diagnostician();
                        Diagnostic diagnostic = diagnostician.validate(configuration);
                        if (diagnostic.getSeverity() <= Diagnostic.INFO)
                        {
                            monitor.worked(1);

                            PropertiesViewGenerator generator = new PropertiesViewGenerator(configuration);
                            generatedProject = generator.generate(monitor);
                        }
                        else
                        {
                            PropertiesViewGeneratorPlugin.log("Validation problem : a problem occured during the properties configuration validation.", IStatus.ERROR);
                        }
                    }
                    else
                    {
                        PropertiesViewGeneratorPlugin.log("The root model object has not the right type. Generation process has been aborted.", IStatus.ERROR);
                    }
                }
                catch (IOException ioe)
                {
                    IStatus status = new Status(IStatus.ERROR, PropertiesViewGeneratorPlugin.getId(), IStatus.OK, "Operation failed.", ioe);
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
            Shell shell = PropertiesViewGeneratorPlugin.getActiveWorkbenchShell();
            ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
            dialog.run(true, false, op);

            AbstractGenerator.organizeImports(generatedProject);
        }
        catch (Exception e)
        {
            PropertiesViewGeneratorPlugin.log(e);
            PropertiesViewGeneratorPlugin.displayDialog(null, "An error occurred during the properties view generation", IStatus.ERROR);
        }
    }

    /**
     * Try to retrieve the selected file from the current currentSelection.
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

    private boolean hasCorrectId(String id)
    {
        String trimmedId = id.trim();
        if (trimmedId.indexOf(" ") != -1)
        {
            return false;
        }
        return true;
    }

}
