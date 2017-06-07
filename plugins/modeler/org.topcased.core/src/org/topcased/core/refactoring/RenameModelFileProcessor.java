/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.core.refactoring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.IConditionChecker;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.ltk.core.refactoring.participants.ValidateEditChecker;

/**
 * <p>
 * The processor is where the work is delegated to if participants are involved. The processor loads the participants
 * and manages the lifecycle of the refactoring. In order to do that, the refactoring entry point methods must be
 * implemented.
 * </p>
 * 
 * Creation 10 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class RenameModelFileProcessor extends RenameProcessor
{
    /** A unique identifier of the refactoring processor */
    public static final String IDENTIFIER = "org.topcased.refactoring.renameModelFileProcessor"; //$NON-NLS-1$

    private final RenameModelFileInfo info;

    /**
     * The constructor
     * 
     * @param info an Object that contains informations about the refactoring
     */
    public RenameModelFileProcessor(final RenameModelFileInfo info)
    {
        this.info = info;

        info.setInvolvedFiles(new ArrayList<IFile>());
        info.setResourceSet(new ResourceSetImpl());
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#getElements()
     */
    public Object[] getElements()
    {
        // Returns the two files that should be renamed
        return new Object[] {info.getFilesToRename().toArray()};
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#getIdentifier()
     */
    public String getIdentifier()
    {
        return IDENTIFIER;
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#getProcessorName()
     */
    public String getProcessorName()
    {
        return "Rename Model/Diagram files";
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#isApplicable()
     */
    public boolean isApplicable() throws CoreException
    {
        return true;
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#checkInitialConditions(org.eclipse.core.runtime.IProgressMonitor)
     */
    public RefactoringStatus checkInitialConditions(final IProgressMonitor pm)
    {
        RefactoringStatus result = new RefactoringStatus();

        for (IFile fileToRename : info.getFilesToRename())
        {
            if (fileToRename == null || !fileToRename.exists())
            {
                result.addFatalError("A file that should be renamed could not be determined.");
            }
            else if (fileToRename.isReadOnly())
            {
                result.addFatalError("A file that should be renamed is read-only.");
            }
        }

        return result;
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#checkFinalConditions(org.eclipse.core.runtime.IProgressMonitor,
     *      org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext)
     */
    public RefactoringStatus checkFinalConditions(final IProgressMonitor pm, final CheckConditionsContext context)
    {
        RefactoringStatus result = new RefactoringStatus();
        pm.beginTask("Checking", 100);

        // Create a temporary ResourceSet used to check files that have a relation with the set of files that should be
        // renamed (this is used in the search() method)
        ResourceSet rSet = new ResourceSetImpl();

        // Create a list that contains all the emfObjects that are contained by the files that will be renamed. The list
        // is then passed to the search() method to check whether a file has a reference to a file that will be renamed.
        List<EObject> listEObjectsOfInterest = new ArrayList<EObject>();

        for (IFile fileToRename : info.getFilesToRename())
        {
            Resource res = rSet.getResource(URI.createPlatformResourceURI(fileToRename.getFullPath().toString(), true), true);
            for (Iterator<EObject> itContents = res.getAllContents(); itContents.hasNext();)
            {
                listEObjectsOfInterest.add(itContents.next());
            }
        }

        // Do something long-running here : traverse the entire project (or even workspace) to look for all
        // model/diagram files with the same extension as the selected model file and the associated diagram file.
        switch (info.getReferencesTypeUpdate())
        {
            case RenameModelFileInfo.NONE:
                break;
            case RenameModelFileInfo.ONLY_CURRENT_PROJECT:
                search(info.getFilesToRename().get(0).getProject(), result, rSet, listEObjectsOfInterest);
                break;
            case RenameModelFileInfo.ALL_PROJECTS:
                search(ResourcesPlugin.getWorkspace().getRoot(), result, rSet, listEObjectsOfInterest);
                break;
        }
        pm.worked(50);

        if (context != null)
        {
            IFile[] files = new IFile[info.getInvolvedFiles().size()];
            info.getInvolvedFiles().toArray(files);
            IConditionChecker checker = context.getChecker(ValidateEditChecker.class);
            ValidateEditChecker editChecker = (ValidateEditChecker) checker;
            editChecker.addFiles(files);
        }
        pm.done();
        return result;
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#createChange(org.eclipse.core.runtime.IProgressMonitor)
     */
    public Change createChange(final IProgressMonitor pm)
    {
        CompositeChange result = new CompositeChange(getProcessorName());
        try
        {
            pm.beginTask("Collecting changes", 100);

            List<Resource> resourcesToRename = new ArrayList<Resource>();
            for (IFile fileToRename : info.getFilesToRename())
            {
                resourcesToRename.add(info.getResourceSet().getResource(URI.createPlatformResourceURI(fileToRename.getFullPath().toString(), true), true));
            }
            for (IFile involvedFile : info.getInvolvedFiles())
            {
                info.getResourceSet().getResource(URI.createPlatformResourceURI(involvedFile.getFullPath().toString(), true), true);
            }

            // Resolve all references between the loaded files in the ResourceSet
            EcoreUtil.resolveAll(info.getResourceSet());

            // Add a complete Change to the global CompositeChange
            result.add(new RenameModelFileChange(info, resourcesToRename));
            //TODO : To be must complet, we must split into two separate Change
            // - Rename of the associated files (diagramme for a model, model for a diagram)
            // - Rename of the reference in referenced files
            pm.worked(100);
        }
        finally
        {
            pm.done();
        }
        return result;
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#loadParticipants(org.eclipse.ltk.core.refactoring.RefactoringStatus,
     *      org.eclipse.ltk.core.refactoring.participants.SharableParticipants)
     */
    public RefactoringParticipant[] loadParticipants(final RefactoringStatus status, final SharableParticipants sharedParticipants)
    {
        // This would be the place to load the participants via the ParticipantManager and decide which of them are
        // allowed to participate.
        return new RefactoringParticipant[0];
    }

    // ------- -------
    // Helping methods
    // ------- -------

    private void search(final IContainer rootContainer, final RefactoringStatus status, final ResourceSet resourceSet, final List<EObject> listEObjectsOfInterest)
    {
        try
        {
            IResource[] members = rootContainer.members();
            for (int i = 0; i < members.length; i++)
            {
                if (members[i] instanceof IContainer)
                {
                    search((IContainer) members[i], status, resourceSet, listEObjectsOfInterest);
                }
                else
                {
                    IFile file = (IFile) members[i];
                    handleFile(file, status, resourceSet, listEObjectsOfInterest);
                }
            }
        }
        catch (final CoreException cex)
        {
            status.addFatalError(cex.getMessage());
        }
    }

    private void handleFile(final IFile file, final RefactoringStatus status, final ResourceSet resourceSet, final List<EObject> listEObjectsOfInterest)
    {
        List<String> validExtensions = new ArrayList<String>();
        for (IFile currentFile : info.getFilesToRename())
        {
            validExtensions.add(currentFile.getFileExtension());
        }

        // Check whether the file has the same extension as the model or the diagram files that are renamed
        if (validExtensions.contains(file.getFileExtension()))
        {
            if (file.isReadOnly())
            {
                status.addWarning("An involved file is read-only and could not be changed if needed : ".concat(file.getName()));
            }
            // Does not add again the files that will be renamed
            else if (!info.getFilesToRename().contains(file))
            {
                Resource currentResource = resourceSet.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);

                // Check whether the file has references to the file(s) that will be renamed, and add it to the
                // involvedFiles list when necessary
                if (!EcoreUtil.UsageCrossReferencer.findAll(listEObjectsOfInterest, currentResource).isEmpty())
                {
                    info.getInvolvedFiles().add(file);
                }

                currentResource.unload();
            }
        }
    }

}
