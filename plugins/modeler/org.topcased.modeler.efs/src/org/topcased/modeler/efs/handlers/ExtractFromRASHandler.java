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
package org.topcased.modeler.efs.handlers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarOutputStream;

import org.apache.tools.tar.TarOutputStream;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.topcased.modeler.efs.internal.Activator;
import org.topcased.modeler.efs.internal.EFSUtils;

/**
 * This handler is used to dynamically restore original file contents from an existing archive. Our handler extends
 * AbstractHandler, an IHandler base class.
 * 
 * @author Jacques LESCOT
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ExtractFromRASHandler extends AbstractHandler
{
    // Files to be restored from an existing archive
    private List<IFile> selectedFiles;

    // The corresponding archive
    private IFile correspondingArchive;

    /**
     * The constructor.
     */
    public ExtractFromRASHandler()
    {
        // Empty constructor
    }

    /**
     * The command has been executed, so extract extract the needed information from the application context.
     * 
     * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
     */
    public Object execute(ExecutionEvent event) throws ExecutionException
    {
        initSelection(HandlerUtil.getCurrentSelection(event));
        executeAction();
        return null;
    }

    private void initSelection(ISelection selection)
    {
        // Compute the list of files to be extracted from the archive
        selectedFiles = new ArrayList<IFile>();
        if (selection instanceof IStructuredSelection)
        {
            for (Iterator< ? > itFiles = ((IStructuredSelection) selection).iterator(); itFiles.hasNext();)
            {
                IFile currentFile = (IFile) itFiles.next();
                // Filter linked files only
                if (currentFile.isLinked())
                {
                    selectedFiles.add(currentFile);
                }
            }
        }
    }

    private void executeAction()
    {
        if (!selectedFiles.isEmpty())
        {
            // Files to be extracted should all be contained in the same archive
            if (checkFilesInSameArchive())
            {
                // It is not possible to extract a "main" file
                if (checkNoMainFile())
                {
                    try
                    {
                        // Retrieve the corresponding archive file
                        String archiveName = ResourcesPlugin.getWorkspace().getRoot().getFile(
                                new Path(selectedFiles.get(0).getLocationURI().getQuery())).getFullPath().lastSegment();
                        correspondingArchive = (IFile) selectedFiles.get(0).getParent().findMember(archiveName);
                        if (correspondingArchive != null && correspondingArchive.getLocationURI() != null)
                        {
                            List<IFile> filesToBeRearchived = null;
                            // Restore all the files contained in the archive
                            if (correspondingArchive.getFileExtension().endsWith("r"))
                            {
                                filesToBeRearchived = computeFilesToBeRearchived(EFSUtils.extractFromTar(correspondingArchive));
    
                                // Recreate the archive without files to be extracted
                                TarOutputStream out = new TarOutputStream(new FileOutputStream(
                                        correspondingArchive.getLocationURI().getPath()));
                                for (IFile currentFile : filesToBeRearchived)
                                {
                                    EFSUtils.insertFile(out, currentFile);
                                }
                                out.close();
                            }
                            else if (correspondingArchive.getFileExtension().endsWith("z"))
                            {
                                filesToBeRearchived = computeFilesToBeRearchived(EFSUtils.extractFromJar(correspondingArchive));
    
                                // Recreate the archive without files to be extracted
                                JarOutputStream out = new JarOutputStream(new FileOutputStream(
                                        correspondingArchive.getLocationURI().getPath()));
                                for (IFile currentFile : filesToBeRearchived)
                                {
                                    EFSUtils.insertFile(out, currentFile);
                                }
                                out.close();
                            }
    
                            // Update workspace files
                            for (IFile currentFile : filesToBeRearchived)
                            {
                                removeFile(currentFile);
                                EFSUtils.createLink(getFileSystemScheme(), correspondingArchive, currentFile);
                            }
    
                            // Refresh resource hierarchy
                            correspondingArchive.getParent().refreshLocal(1, new NullProgressMonitor());
                        }
                    }
                    catch (FileNotFoundException e)
                    {
                        e.printStackTrace();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    catch (CoreException e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    Activator.log("You can not extract the main model or diagrams file associated with this archive.",
                            IStatus.ERROR);
                }
            }
            else
            {
                Activator.log("The selected files should be part of the same archive model.", IStatus.ERROR);
            }
        }
        else
        {
            Activator.log("The current selection is not valid. You should select only linked files.", IStatus.ERROR);
        }
    }

    // Check whether all the selected Resources are within the same archive model
    private boolean checkFilesInSameArchive()
    {
        // Choose the first archive associated with the linked file as a reference
        IFile archiveFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
                new Path(selectedFiles.get(0).getLocationURI().getQuery()));

        for (IFile selectedFile : selectedFiles)
        {
            if (!archiveFile.equals(ResourcesPlugin.getWorkspace().getRoot().getFile(
                    new Path(selectedFile.getLocationURI().getQuery()))))
            {
                return false;
            }
        }
        return true;
    }

    // Check that the selection does not contain neither the main domain or diagrams file
    private boolean checkNoMainFile()
    {
        // Compute archive name to compare - It is associated with the main domain and diagrams files
        String archiveName = ResourcesPlugin.getWorkspace().getRoot().getFile(
                new Path(selectedFiles.get(0).getLocationURI().getQuery())).getFullPath().removeFileExtension().lastSegment();

        for (IFile selectedFile : selectedFiles)
        {
            if (archiveName.equals(selectedFile.getFullPath().removeFileExtension().lastSegment()))
            {
                return false;
            }
        }
        return true;
    }

    private List<IFile> computeFilesToBeRearchived(List<IFile> initialList)
    {
        List<IFile> filteredFiles = new ArrayList<IFile>();

        for (IFile currentFile : initialList)
        {
            if (!selectedFiles.contains(currentFile))
            {
                filteredFiles.add(currentFile);
            }
        }
        return filteredFiles;
    }

    // Delete a file from the workspace
    private void removeFile(IFile sourceFile) throws CoreException
    {
        sourceFile.delete(true, null);
    }

    // Get the FileScheme to use. Necessary in the {@link #createLink} method to create the linked file URI
    private String getFileSystemScheme()
    {
        // We assume the FileSystem scheme is the same than the associated file extension
        return correspondingArchive.getFileExtension();
    }
}
