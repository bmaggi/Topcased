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
package org.topcased.modeler.generator.internal.actions.doc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.topcased.generator.util.ConfiguratorObjectManager;
import org.topcased.modeler.generator.internal.GeneratorPlugin;
import org.topcased.modeler.generator.internal.generators.doc.DocGenerator;
import org.topcased.modeler.generator.internal.generators.doc.HTMLDocGenerator;

/**
 * Action that generates classes conforming to a default JET templates.
 * 
 * @author jako
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class GenerateHTMLDocAction implements IActionDelegate
{
    private ISelection selection;

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
                monitor.beginTask("Generation process", 20);
                try
                {
                    ConfiguratorObjectManager manager = new ConfiguratorObjectManager();
                    manager.load(file.getFullPath());

                    IContainer parent = file.getParent();
                    IFile target = parent.getFile(new Path("documentation.html"));

                    EObject root = manager.getRootModelObject();
                    if (root instanceof EPackage)
                    {
                        DocGenerator generator = new HTMLDocGenerator((EPackage) root, target);
                        generator.generate(monitor);
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
        }
        catch (Exception e)
        {
            GeneratorPlugin.log(e);
            GeneratorPlugin.displayDialog(null, "An error occurred during the editor generation", IStatus.ERROR);
        }
    }

}
