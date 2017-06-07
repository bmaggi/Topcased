/*******************************************************************************
 * Copyright (c) 2008,2009 TOPCASED. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Laurent Redor (Obeo)
 *               Sebastien Gabel (CS) - Bug fix #1922
 ******************************************************************************/
package org.topcased.ui.refactoring;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.topcased.core.refactoring.RenameModelFileInfo;
import org.topcased.core.refactoring.RenameModelFileProcessor;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.ui.navigator.TopcasedFilePropertyTester;

/**
 * <p>
 * The participant to the renaming of a file. This participant delegate the work to the processor.
 * </p>
 * <p>
 * This class replace the action org.topcased.ui.refactoring.actions.RenameModelFileAction
 * </p>
 * 
 * Creation 15 mai 08
 * 
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent REDOR</a>
 */
public class ModelRenameParticipant extends RenameParticipant
{

    private IFile selectedFile = null;

    private RenameModelFileProcessor renameFileProcessor;

    private RenameModelFileInfo info;

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#checkConditions(org.eclipse.core.runtime.IProgressMonitor,
     *      org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext)
     */
    @Override
    public RefactoringStatus checkConditions(final IProgressMonitor pm, final CheckConditionsContext context) throws OperationCanceledException
    {
        final class StatusContainer
        {

            public RefactoringStatus conditions = new RefactoringStatus();
        }
        // Open a wizard to select the type of refactor
        RefactoringStatus conditions = renameFileProcessor.checkInitialConditions(pm);
        for (IFile f : info.getFilesToRename())
        {
            if (!TopcasedFilePropertyTester.isTopcasedFile(f))
            {
                return null;
            }
        }
        if (!conditions.isOK())
        {
            return conditions;
        }
        final StatusContainer statusContainer = new StatusContainer();
        PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable()
        {

            public void run()
            {
                MessageDialogRefactorRange messageDialogRefactorRange = new MessageDialogRefactorRange(PlatformUI.getWorkbench().getDisplay().getActiveShell(), "Refactoring range of rename model",
                        null, "Select the correct range", MessageDialog.QUESTION, new String[] {"OK"}, 0, info);
                int result = messageDialogRefactorRange.open();
                if (result == Window.OK)
                {
                    statusContainer.conditions = renameFileProcessor.checkFinalConditions(pm, context);
                }
                else
                {
                    statusContainer.conditions = RefactoringStatus.createErrorStatus("No range has been selected.");
                }
            }
        });
        return statusContainer.conditions;
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#createChange(org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException
    {
        return renameFileProcessor.createChange(pm);
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#getName()
     */
    @Override
    public String getName()
    {
        return renameFileProcessor.getProcessorName();
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#initialize(java.lang.Object)
     */
    @Override
    protected boolean initialize(Object element)
    {

        if (element instanceof IFile)
        {
            selectedFile = (IFile) element;

            try
            {
                // TODO Check also whether the model file is a valid model (check the file extension) and whether its
                // contents is valid (use an extension : http://www.eclipticalsoftware.com/emf)

                Resource selectedResource = new ResourceSetImpl().getResource(URI.createPlatformResourceURI(selectedFile.getFullPath().toString(), true), true);
                selectedResource.getContents();
            }
            catch (Exception e)
            {
                selectedFile = null;
            }
        }
        if (selectedFile != null)
        {
            info = new RenameModelFileInfo();
            info.setOldName(selectedFile.getFullPath().removeFileExtension().lastSegment());
            info.setOldExtension(selectedFile.getFullPath().getFileExtension());

            IPath newNameWithExt = new Path(getArguments().getNewName());
            info.setNewName(newNameWithExt.removeFileExtension().toString());
            info.setNewExtension(newNameWithExt.getFileExtension());

            // Retrieve all the Participant files involved into the refactoringd
            info.setFilesToRename(retrieveFileAndParticipantsToRename());

            if (saveAll())
            {
                renameFileProcessor = new RenameModelFileProcessor(info);
                return true;
            }
        }
        return false;
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
        IFile correspondingFile = getCorrespondingFile(selectedResource, selectedFile);
        if (correspondingFile != null)
        {
            filesToRename.add(correspondingFile);
        }
        // Fix #1922
        IFile requirementFile = getRequirementFile(selectedFile);
        if (requirementFile != null)
        {
            filesToRename.add(requirementFile);
        }
        return filesToRename;
    }

    /**
     * Search the diagram file if the selected resource is a model and search the model file of the selected resource is
     * a diagram
     * 
     * @param selectedResource The selected resource
     * @param selectedFile The selected file
     * @return The corresponding file or null (in case of diagram which is not exist)
     */
    private IFile getCorrespondingFile(Resource selectedResource, IFile selectedFile)
    {
        IFile correspondingFile = null;
        if (selectedResource.getContents().get(0) instanceof Diagrams)
        {
            // retrieve the model file if it exists
            String diagramFileString = selectedFile.getFullPath().toString();
            String modelFileString = diagramFileString.substring(0, diagramFileString.length() - 2);
            Path modelFilePath = new Path(modelFileString);
            if (ResourcesPlugin.getWorkspace().getRoot().exists(modelFilePath))
            {
                correspondingFile = ResourcesPlugin.getWorkspace().getRoot().getFile(modelFilePath);
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
                correspondingFile = ResourcesPlugin.getWorkspace().getRoot().getFile(diagramFilePath);
            }
        }
        return correspondingFile;
    }

    /**
     * Search the specific requirement model that can be attached to this model and/or diagram files.
     * 
     * @param selectedFile The selected file
     * @return the {@link IFile} corresponding to the requirement model, <code>null</code> if not exists.
     */
    private IFile getRequirementFile(IFile selectedFile)
    {
        IFile reqFile = null;
        IPath pathWithoutExt = selectedFile.getFullPath().removeFileExtension();
        IPath pathReq = pathWithoutExt.addFileExtension("requirement");
        if (ResourcesPlugin.getWorkspace().getRoot().exists(pathReq))
        {
            reqFile = ResourcesPlugin.getWorkspace().getRoot().getFile(pathReq);
        }
        return reqFile;
    }

    private static boolean saveAll()
    {
        IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        return IDE.saveAllEditors(new IResource[] {workspaceRoot}, true);
    }
}
