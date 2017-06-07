/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.ui.refactoring.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.topcased.core.refactoring.RenameModelFileInfo;
import org.topcased.core.refactoring.RenameModelFileProcessor;
import org.topcased.core.refactoring.RenameModelFileRefactoring;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.ui.internal.Activator;
import org.topcased.ui.refactoring.wizards.RenameModelFileWizard;

/**
 * Action that is triggered from the navigator context menu<br>
 * This action is declared in the <code>plugin.xml</code>.
 * 
 * Creation 10 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @deprecated
 */
public class RenameModelFileAction implements IActionDelegate
{
    private IFile selectedFile;

    private RenameModelFileInfo info = new RenameModelFileInfo();

    /**
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    public void run(final IAction action)
    {
        if (selectedFile != null)
        {
            String fileName = selectedFile.getName().substring(0, selectedFile.getName().length() - selectedFile.getFileExtension().length() - 1);
            String fileExtension = selectedFile.getFullPath().getFileExtension();
            info.setOldName(fileName);
            info.setOldExtension(fileExtension);
            info.setNewName(fileName);
            info.setNewExtension(fileExtension);

            // Retrieve all the Participant files in the rename refactoring
            info.setFilesToRename(retrieveFileAndParticipantsToRename());

            if (saveAll())
            {
                openWizard();
            }
        }
        else
        {
            MessageDialog.openError(Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell(), "Selection error",
                    "You must select an EMF model to execute the Rename Model refactoring action.");
        }
    }

    /**
     * Return a list of File : these are the files that are involved in the rename refactoring. In general this is the
     * model and the diagram file. By default we consider that the selected file is a model or a diagram file, and we
     * add the associated file if it exists.
     * 
     * @return List the list of files that should be renamed
     */
    protected List<IFile> retrieveFileAndParticipantsToRename()
    {
        List<IFile> filesToRename = new ArrayList<IFile>();
        filesToRename.add(selectedFile);

        ResourceSet rSet = new ResourceSetImpl();
        Resource selectedResource = rSet.getResource(URI.createPlatformResourceURI(selectedFile.getFullPath().toString(), true), true);
        if (selectedResource.getContents().get(0) instanceof Diagrams)
        {
            // retrieve the model file if it exists
            String diagramFileString = selectedFile.getFullPath().toString();
            String modelFileString = diagramFileString.substring(0, diagramFileString.length() - 2);
            Path modelFilePath = new Path(modelFileString);
            if (ResourcesPlugin.getWorkspace().getRoot().exists(modelFilePath))
            {
                filesToRename.add(ResourcesPlugin.getWorkspace().getRoot().getFile(modelFilePath));
            }
        }
        else
        {
            // retrieve the diagrams file if it exists
            String modelFileString = selectedFile.getFullPath().toString();
            String diagramFileString = modelFileString.concat("di");
            Path diagramFilePath = new Path(diagramFileString);
            if (ResourcesPlugin.getWorkspace().getRoot().exists(diagramFilePath))
            {
                filesToRename.add(ResourcesPlugin.getWorkspace().getRoot().getFile(diagramFilePath));
            }
        }

        return filesToRename;
    }

    /**
     * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(final IAction action, final ISelection selection)
    {
        if (selection instanceof IStructuredSelection)
        {
            Object selectedObject = ((IStructuredSelection) selection).getFirstElement();

            // TODO Check also whether the model file is a valid model (check the file extension) and whether its
            // contents is valid (use an extension : http://www.eclipticalsoftware.com/emf)
            if (selectedObject instanceof IFile)
            {
                selectedFile = (IFile) selectedObject;

                ResourceSet rSet = new ResourceSetImpl();
                try
                {
                    Resource selectedResource = rSet.getResource(URI.createPlatformResourceURI(selectedFile.getFullPath().toString(), true), true);
                    selectedResource.getContents();
                }
                catch (Exception e)
                {
                    selectedFile = null;
                }
            }
        }
    }

    private static boolean saveAll()
    {
        IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        return IDE.saveAllEditors(new IResource[] {workspaceRoot}, true);
    }

    private void openWizard()
    {
        RefactoringProcessor processor = new RenameModelFileProcessor(info);
        RenameModelFileRefactoring ref = new RenameModelFileRefactoring(processor);
        RenameModelFileWizard wizard = new RenameModelFileWizard(ref, info);
        RefactoringWizardOpenOperation op = new RefactoringWizardOpenOperation(wizard);
        try
        {
            String titleForFailedChecks = "";
            op.run(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), titleForFailedChecks);
        }
        catch (final InterruptedException irex)
        {
            // operation was cancelled
        }
    }

}
