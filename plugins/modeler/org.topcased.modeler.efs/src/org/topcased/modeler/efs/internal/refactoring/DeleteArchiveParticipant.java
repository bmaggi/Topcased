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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.DeleteParticipant;
import org.topcased.modeler.efs.internal.EFSUtils;

/**
 * The participant to the deletion of an archive model. This participant delegate the work to the processor.<br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 */
public class DeleteArchiveParticipant extends DeleteParticipant
{
    DeleteArchiveProcessor deleteArchiveProcessor = null;

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#checkConditions(org.eclipse.core.runtime.IProgressMonitor,
     *      org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext)
     */
    @Override
    public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context)
            throws OperationCanceledException
    {
        final class StatusContainer
        {
            public RefactoringStatus conditions = new RefactoringStatus();
        }
        RefactoringStatus conditions;
        conditions = deleteArchiveProcessor.checkInitialConditions(pm);
        if (!conditions.isOK())
        {
            return conditions;
        }
        final StatusContainer statusContainer = new StatusContainer();
        statusContainer.conditions = deleteArchiveProcessor.checkFinalConditions(pm, context);

        return statusContainer.conditions;
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#createChange(org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException
    {
        return deleteArchiveProcessor.createChange(pm);
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#getName()
     */
    @Override
    public String getName()
    {
        return deleteArchiveProcessor.getProcessorName();
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant#initialize(java.lang.Object)
     */
    @Override
    protected boolean initialize(Object element)
    {
        if (element instanceof IFile && EFSUtils.getKnownExtension().contains(((IFile) element).getFileExtension()))
        {
            deleteArchiveProcessor = new DeleteArchiveProcessor((IFile) element);
            return true;
        }
        return false;
    }
}
