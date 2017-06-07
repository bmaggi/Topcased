/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thibault Landre (Atos Origin) thibault.landre@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.createtemplate.action;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IActionDelegate;
import org.topcased.modeler.createtemplate.Activator;
import org.topcased.modeler.createtemplate.ProjectExporter;
import org.topcased.modeler.createtemplate.job.TemplateModelCreationJob;

public class TemplateModelAction implements IActionDelegate{

	private ISelection fSelection;
	  
	public void selectionChanged(IAction action, ISelection pSelection) 
	{
		fSelection = pSelection;
	    action.setEnabled(true);	
	}
	
	public void run(IAction action) 
	{
		final TemplateModelDialog lTemplateModelDialog = new TemplateModelDialog(Activator.getActiveWorkbenchShell(), convertSelection2File(fSelection));
        if (lTemplateModelDialog.open() == Window.OK)
        {
            String lModelUri = lTemplateModelDialog.getModelUri();
            String lTemplateModelName = lTemplateModelDialog.getModelTemplateName();
            Boolean lIsInstallationRequired = lTemplateModelDialog.isInstallRequired();

            TemplateModelCreationJob lTemplateModelCreationJob = new TemplateModelCreationJob(lModelUri, lTemplateModelName, lIsInstallationRequired);
            lTemplateModelCreationJob.run(null);
        }	  
	}
	
	  /**
     * Try to retrieve the selected file from the given selection
     * 
     * @param sel the selection
     * @return the selected file
     */
    private IFile convertSelection2File(ISelection sel)
    {
        // get the selected diagrams file
        if (sel instanceof IStructuredSelection)
        {
            IStructuredSelection ssel = (IStructuredSelection) sel;
            // Only one file should be selected
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

	

}
