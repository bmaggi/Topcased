/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.diagrams.validation.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * An action to change resource uris
 * 
 * @author tfaure
 * 
 */
public class UpdateResourcesURI implements IObjectActionDelegate
{

    private IFile currentFile = null;

    public void run(IAction action)
    {
        if (currentFile != null)
        {
            Shell activeShell = Display.getDefault().getActiveShell();
            if (MessageDialog.openConfirm(
                    activeShell,
                    "Information",
                    "This process will open your diagram and list all the resources used inside it.\nIf the path of the resource is no longer available you will have the possibility to change it.\nDo you want to continue ?"))
            {
                ResourceAnalysis ra = new ResourceAnalysis();
                try
                {
                    ra.process(URI.createPlatformResourceURI(currentFile.getFullPath().toString(), true));
                }
                catch (Exception e)
                {
                    MessageDialog.openError(Display.getDefault().getActiveShell(), "Error", e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public void selectionChanged(IAction action, ISelection selection)
    {
        currentFile = null;
        if (!selection.isEmpty())
        {
            IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            Object selectedObject = structuredSelection.getFirstElement();
            if (selectedObject instanceof IFile)
            {
                currentFile = (IFile) selectedObject;
            }
        }

    }

    public void setActivePart(IAction action, IWorkbenchPart targetPart)
    {
        // TODO Auto-generated method stub

    }

}
