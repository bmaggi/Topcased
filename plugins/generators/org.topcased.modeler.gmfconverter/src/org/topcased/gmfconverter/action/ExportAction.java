/***********************************************************************
 * Copyright (c) 2007, 2008 Topcased consortium
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas LAMBERT (Anyware Technologies) - initial API and implementation
 *    Jacques LESCOT (Anyware Technologies) - Code review
 **********************************************************************/

package org.topcased.gmfconverter.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.topcased.gmfconverter.GmfConverter;
import org.topcased.gmfconverter.internal.Activator;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;

/**
 * Action used to export Topcased v1.x configurators into GMF configurators
 */
public class ExportAction implements IActionDelegate
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
        final IFile topCasedFile = convertSelection2File(selection);

        WorkspaceModifyOperation op = new WorkspaceModifyOperation()
        {
            public void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException
            {
                monitor.beginTask("Editor Generation process", 5);
                try
                {
                    ResourceSet resSet = new ResourceSetImpl();

                    // The resource that provide a way to access its content
                    Resource resource = resSet.getResource(URI.createPlatformResourceURI(topCasedFile.getFullPath().toString(), false), true);

                    // Loads the content of the model from the file.
                    Map<Object, Object> options = new HashMap<Object, Object>();
                    resource.load(options);

                    // Gets the top level object.
                    Object rootObject = resource.getContents().get(0);
                    if (rootObject != null && rootObject instanceof DiagramConfiguration)
                    {
                        DiagramConfiguration diagramConfiguration = (DiagramConfiguration) rootObject;

                        monitor.subTask("Diagram Configuration validation");
                        Diagnostician diagnostician = new Diagnostician();
                        Diagnostic diagnostic = diagnostician.validate(diagramConfiguration);
                        if (diagnostic.getSeverity() <= Diagnostic.WARNING)
                        {
                            monitor.worked(1);

                            // Call the conversion process through the GmfConverter class
                            GmfConverter.convert(topCasedFile, diagramConfiguration);
                        }
                        else
                        {
                            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Validation problem",
                                    "A problem occured during the editor configuration validation", BasicDiagnostic.toIStatus(diagnostic));
                        }
                    }
                    else
                    {
                        Activator.log("The root model object has not the right type. Generation process has been aborted.", IStatus.ERROR);
                    }
                }
                catch (IOException ioe)
                {
                    IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.OK, "Operation failed.", ioe);
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
            ProgressMonitorDialog dialog = new ProgressMonitorDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
            dialog.run(false, false, op);
        }
        catch (Exception e)
        {
            Activator.log(e);
            Activator.log("An error occurred during the export process", IStatus.ERROR);
        }
    }

}
