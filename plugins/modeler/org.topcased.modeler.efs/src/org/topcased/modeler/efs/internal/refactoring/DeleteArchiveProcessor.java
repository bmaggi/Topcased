/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 **********************************************************************/
package org.topcased.modeler.efs.internal.refactoring;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.DeleteProcessor;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.ltk.core.refactoring.resource.DeleteResourceChange;
import org.topcased.modeler.efs.internal.Activator;

/**
 * A delete processor for Archive models. The processor will delete the archive model and all its linked resources as
 * well.
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 */
public class DeleteArchiveProcessor extends DeleteProcessor
{
    /** A unique identifier of the refactoring processor */
    public static final String IDENTIFIER = "org.topcased.refactoring.deleteArchiveProcessor"; //$NON-NLS-1$

    private IFile archiveFile;

    /**
     * Constructor
     * 
     * @param archiveFile the archive model file
     */
    public DeleteArchiveProcessor(IFile archiveFile)
    {
        this.archiveFile = archiveFile;
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#checkInitialConditions(org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws OperationCanceledException
    {
        return new RefactoringStatus();
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#checkFinalConditions(org.eclipse.core.runtime.IProgressMonitor,
     *      org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext)
     */
    @Override
    public RefactoringStatus checkFinalConditions(IProgressMonitor pm, CheckConditionsContext context)
            throws OperationCanceledException
    {
        return new RefactoringStatus();
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#createChange(org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException
    {
        CompositeChange result = new CompositeChange(getProcessorName());
        try
        {
            pm.beginTask("Collecting changes", 100);

            URI archiveURI = new URI(archiveFile.getFileExtension(), null, "/",
                    archiveFile.getLocationURI().toString(), null);
            IFileStore store = EFS.getStore(archiveURI);
            String[] childNames = store.childNames(EFS.NONE, new NullProgressMonitor());
            for (int i = 0; i < childNames.length; i++)
            {
                IResource res = archiveFile.getParent().findMember(childNames[i]);
                if (res != null && res.isLinked())
                {
                    result.add(new DeleteResourceChange(res.getFullPath(), true)
                    {
                        public Change perform(IProgressMonitor pm) throws CoreException
                        {
                            return super.perform(pm);
                            // No undo is done on a linked resource deletion. Linked resources will be automatically
                            // recreated when the archive file will be restored
//                            return null;
                        }
                    });
                }
            }

            pm.worked(100);
        }
        catch (URISyntaxException use)
        {
            Activator.log(use);
        }
        catch (CoreException e)
        {
            e.printStackTrace();
        }
        finally
        {
            pm.done();
        }
        return result;
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#getElements()
     */
    @Override
    public Object[] getElements()
    {
        return new Object[] {archiveFile};
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#getIdentifier()
     */
    @Override
    public String getIdentifier()
    {
        return IDENTIFIER;
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#getProcessorName()
     */
    @Override
    public String getProcessorName()
    {
        return "Delete linked Resources";
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#isApplicable()
     */
    @Override
    public boolean isApplicable() throws CoreException
    {
        return true;
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#loadParticipants(org.eclipse.ltk.core.refactoring.RefactoringStatus,
     *      org.eclipse.ltk.core.refactoring.participants.SharableParticipants)
     */
    @Override
    public RefactoringParticipant[] loadParticipants(RefactoringStatus status, SharableParticipants sharedParticipants)
            throws CoreException
    {
        return new RefactoringParticipant[0];
    }

}
