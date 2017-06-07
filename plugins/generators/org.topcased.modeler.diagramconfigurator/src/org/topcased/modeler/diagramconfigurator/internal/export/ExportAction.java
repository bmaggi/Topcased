/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.diagramconfigurator.internal.export;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.internal.DiagramConfiguratorPlugin;
import org.topcased.modeler.diagramconfigurator.util.DiagramconfiguratorResourceImpl;

/**
 * This action is used to call the ConfiguratorConverter on a valid configurator file
 * 
 * Creation 8 sept. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
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
        // get the selected *.diagramconfigurator file
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

        WorkspaceModifyOperation op = new WorkspaceModifyOperation()
        {
            public void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException
            {
                monitor.beginTask("Diagram Configuration conversion (0.9.x to 0.10.x)", 5);
                try
                {
                    DiagramconfiguratorResourceImpl resource = new DiagramconfiguratorResourceImpl(URI.createPlatformResourceURI(file.getFullPath().toString()));
                    resource.getDefaultLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
                    resource.getDefaultLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);

                    // Loads the content of the model from the file.
                    resource.load(null);

                    // Gets the top level object.
                    Object rootObject = resource.getContents().get(0);
                    if (rootObject != null && rootObject instanceof DiagramConfiguration)
                    {
                        DiagramConfiguration diagramConfiguration = (DiagramConfiguration) rootObject;

                        ExportDiagramConfiguratorDialog dialog = new ExportDiagramConfiguratorDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
                        if (dialog.open() == Window.OK)
                        {
                            // Indicate the values that were not present
                            // previously
                            diagramConfiguration.setEditorConfigurator(dialog.getEditorConfigurator());
                            diagramConfiguration.setCopyrightText(dialog.getCopyrightText());
                            diagramConfiguration.setSamePluginAsEditor(dialog.isSamePluginAsEditor());
                        }

                        DiagramconfiguratorResourceImpl resource2 = new DiagramconfiguratorResourceImpl(URI.createPlatformResourceURI(file.getFullPath().toString()));
                        resource2.getDefaultLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
                        resource2.getContents().add(resource.getContents().get(0));
                        resource2.save(null);
                    }
                    else
                    {
                        DiagramConfiguratorPlugin.log("The root model object has not the right type. Generation process has been aborted.", IStatus.ERROR);
                    }

                    resource.unload();
                }
                catch (IOException ioe)
                {
                    IStatus status = new Status(IStatus.ERROR, DiagramConfiguratorPlugin.getId(), IStatus.OK, "Operation failed.", ioe);
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
            DiagramConfiguratorPlugin.log(e);
            DiagramConfiguratorPlugin.log("An error occurred during the export process", IStatus.ERROR);
        }
    }

}
