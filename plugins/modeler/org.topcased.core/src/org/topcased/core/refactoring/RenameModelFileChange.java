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

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

/**
 * An implementation of a Change
 * 
 * Creation 11 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class RenameModelFileChange extends Change
{
    private RenameModelFileInfo info;

    private List<Resource> resourcesToRename;

    /**
     * The constructor
     * 
     * @param info an Object that contains informations about the refactoring
     * @param resourcesToRename a List of the Resource that should be renamed. These Resources are contained in the
     *        ResourceSet associated with the info object
     */
    public RenameModelFileChange(RenameModelFileInfo info, List<Resource> resourcesToRename)
    {
        this.info = info;
        this.resourcesToRename = resourcesToRename;
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
     */
    public Object getModifiedElement()
    {
        return null;
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.Change#getName()
     */
    public String getName()
    {
        return "Rename Files and update references from other files";
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.Change#initializeValidationData(org.eclipse.core.runtime.IProgressMonitor)
     */
    public void initializeValidationData(IProgressMonitor pm)
    {
        // Do nothing
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.Change#isValid(org.eclipse.core.runtime.IProgressMonitor)
     */
    public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException
    {
        return new RefactoringStatus();
    }

    /**
     * @see org.eclipse.ltk.core.refactoring.Change#perform(org.eclipse.core.runtime.IProgressMonitor)
     */
    public Change perform(IProgressMonitor pm) throws CoreException
    {
        Map<String, String> options = new HashMap<String, String>();
        options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);

        // The file that the user has renamed
        IFile renamedFile = null;
        URI newRenamedFileURI = null;
        URI oldRenamedFileURI = null;

        // We must first remove the old files that will be renamed
        // (not the file that will be moved by the standard Eclipse refactoring)
        for (Resource currentResource : resourcesToRename)
        {
            IFile fileToDelete = getFile(currentResource);
            String fileNameWithoutExtension = fileToDelete.getProjectRelativePath().removeFileExtension().lastSegment();
            String fileExtension = fileToDelete.getProjectRelativePath().getFileExtension();
            if (fileNameWithoutExtension.equals(info.getOldName()) && fileExtension.equals(info.getOldExtension()))
            {
                // The selected file for rename is renamed (moved) by the standard Eclipse refactoring,
                // therefore we don't remove it (otherwise there has a Exception during the Undo command)
                renamedFile = fileToDelete;
            }
            else
            {
                fileToDelete.delete(true, false, new NullProgressMonitor());
            }
        }

        // Then, we change all the Resource URIs that are associated with the files to be renamed
        // Backup of the URI of the file to rename because it has a special treatment
        for (Resource currentResource : resourcesToRename)
        {
            IFile currentFile = getFile(currentResource);
            IPath newPath = currentFile.getFullPath().removeLastSegments(1);
            if (currentFile.equals(renamedFile))
            {
                newPath = newPath.append(info.getNewName().concat(".").concat(info.getNewExtension()));
                oldRenamedFileURI = currentResource.getURI();
                newRenamedFileURI = URI.createPlatformResourceURI(newPath.toOSString(), true);
            }
            else
            {
                newPath = newPath.append(info.getNewName().concat(".").concat(currentFile.getFileExtension()));
            }
            URI newURI = URI.createPlatformResourceURI(newPath.toOSString(), true);

            currentResource.setURI(newURI);
        }

        try
        {
            // Save all the resources that are contained in the ResourceSet (the renamed Resources and also the updated
            // Resources)
            for (Resource resourceToSave : info.getResourceSet().getResources())
            {
                IFile currentFile = getFile(resourceToSave);
                if (currentFile != null)
                {
                    String fileNameWithoutExtension = currentFile.getProjectRelativePath().removeFileExtension().lastSegment();
                    String fileExtension = currentFile.getProjectRelativePath().getFileExtension();
                    if (fileNameWithoutExtension.equals(info.getNewName()) && fileExtension.equals(info.getNewExtension()))
                    {
                        // The currentFile is teh renamed file
                        if (currentFile.exists())
                        {
                            // We are in the normal execution mode so the standard refactoring (the moved) is executed
                            // before this specific task therefor we save the modified resource
                            resourceToSave.save(options);
                        }
                        else
                        {
                            // We are in the Undo mode so the standard refactoring (the moved) is executed
                            // after this specific task therefor we have to save the resource in the older URI (the
                            // standard refactoring move it after)
                            // Set the old uri
                            resourceToSave.setURI(oldRenamedFileURI);
                            // We save the resource under the old name because it will be moved by the standard Eclipse
                            // refactor
                            resourceToSave.save(options);
                            // Set the new uri
                            resourceToSave.setURI(newRenamedFileURI);
                        }
                    }
                    else
                    {
                        resourceToSave.save(options);
                    }
                }
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // Revert the old and the new name for the undo change
        String tmp = info.getNewName();
        info.setNewName(info.getOldName());
        info.setOldName(tmp);
        tmp = info.getNewExtension();
        info.setNewExtension(info.getOldExtension());
        info.setOldExtension(tmp);
        return new RenameModelFileChange(info, resourcesToRename);
    }

    // ------- -------
    // Helping methods
    // ------- -------

    /**
     * Return the IFile associated with the given resource
     * 
     * @param resource the EMF resource
     * @return the containing IFile or <code>null</code> if the resource is not an IFile
     */
    private static IFile getFile(Resource resource)
    {
        URI uri = resource.getURI();
        uri = resource.getResourceSet().getURIConverter().normalize(uri);
        String scheme = uri.scheme();
        if ("platform".equals(scheme) && uri.segmentCount() > 1 && "resource".equals(uri.segment(0))) // $NON-NLS-1$
        // $NON-NLS-2$
        {
            if (uri.isPlatform())
            {
                String platformString = uri.toPlatformString(true);
                return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
            }
        }
        return null;
    }
}
