/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.export.internal.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.handlers.HandlerUtil;
import org.topcased.modeler.export.ExportAllDiagrams;
import org.topcased.modeler.export.internal.Activator;

/**
 * Action that export all the diagrams as images at the same location of the selected file. Exported images are named
 * with the diagram name and JPG format is used by default. These images are then used in the generation of the
 * documentation when needed.
 * 
 * Additional work would consist in :
 * - give the user the choice of the output format
 * - create a hierarchy in the generation of the images that follows the hierarchy of the model contents
 * - do not overwrite already existing files or at least alert the user 
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ExportAllDiagramsAction extends AbstractHandler
{


	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		IFile convertSelection2File = convertSelection2File(selection);
		final ExportAllDiagramsDialog exportDialog = new ExportAllDiagramsDialog(Activator.getActiveWorkbenchShell(), convertSelection2File);
        if (exportDialog.open() == Window.OK) {
            
         // get the selected diagrams file
            final IFile file = convertSelection2File;
            ExportAllDiagrams exportAllDiagrams;
            try
            {
                exportAllDiagrams = new ExportAllDiagrams(file, exportDialog.getOutputDirectory().getLocation().toString(), exportDialog.getExporter().getExtension(),  exportDialog.getExporter().getExporter());
                exportAllDiagrams.exportDiagramsToImages();
            }
            catch (CoreException e)
            {
                e.printStackTrace();
            }
          
        }
		return null;
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
