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
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.handlers.HandlerUtil;
import org.topcased.modeler.efs.internal.Activator;
import org.topcased.modeler.efs.internal.EFSUtils;
import org.topcased.modeler.efs.internal.dialogs.FilteredFilesResourceSelectionDialog;

/**
 * This handler is used to dynamically add contents to an existing archive. Our handler extends AbstractHandler, an
 * IHandler base class.
 * 
 * @author Jacques LESCOT
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class AddToExistingRASHandler extends AbstractHandler
{
    // Files to be added into an existing archive
    private List<IFile> selectedFiles;

    // The selected archive on which additional contents should be added
    private IFile selectedArchive;

    /**
     * The constructor.
     */
    public AddToExistingRASHandler()
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

    // Compute the list of files to be included in the archive
    private void initSelection(ISelection selection)
    {
        IContainer parentContainer = null;
        selectedFiles = new ArrayList<IFile>();
        if (selection instanceof IStructuredSelection)
        {
            for (Iterator< ? > itFiles = ((IStructuredSelection) selection).iterator(); itFiles.hasNext();)
            {
                IFile currentFile = (IFile) itFiles.next();
                // Filter linked files - just ignore them
                if (!currentFile.isLinked())
                {
                    if (parentContainer == null)
                    {
                        parentContainer = currentFile.getParent();
                    }
                    // Only add files contained within the same parent Resource
                    if (currentFile.getParent().equals(parentContainer))
                    {
                        selectedFiles.add(currentFile);
                    }
                }
            }
        }
    }

    private void executeAction()
    {
        FilteredFilesResourceSelectionDialog dialog = new FilteredFilesResourceSelectionDialog(
                Activator.getActiveWorkbenchShell(), selectedFiles.get(0).getParent(), "Select Archive:");
        // Filter only known model archives
        dialog.setFileExtensionFilter(EFSUtils.getKnownExtension());

        if (dialog.open() == Window.OK)
        {
            Object[] result = dialog.getResult();
            if (result.length == 1 && result[0] instanceof IFile)
            {
                selectedArchive = (IFile) result[0];
                try
                {
                    List<IFile> allFilesToArchive = null;

                    // Case of uncompressed archives
                    if (selectedArchive.getFileExtension().endsWith("r"))
                    {
                        allFilesToArchive = EFSUtils.extractFromTar(selectedArchive);
                        for (IFile existingFile : selectedFiles)
                        {
                            allFilesToArchive.add(existingFile);
                        }

                        TarOutputStream out = new TarOutputStream(new FileOutputStream(
                                selectedArchive.getLocationURI().getPath()));
                        for (IFile existingFile : allFilesToArchive)
                        {
                            EFSUtils.insertFile(out, existingFile);
                        }
                        out.close();
                    }

                    // Case of compressed archives
                    else if (selectedArchive.getFileExtension().endsWith("z"))
                    {
                        allFilesToArchive = EFSUtils.extractFromJar(selectedArchive);
                        for (IFile existingFile : selectedFiles)
                        {
                            allFilesToArchive.add(existingFile);
                        }

                        JarOutputStream out = new JarOutputStream(new FileOutputStream(
                                selectedArchive.getLocationURI().getPath()));
                        for (IFile existingFile : allFilesToArchive)
                        {
                            EFSUtils.insertFile(out, existingFile);
                        }
                        out.close();
                    }

                    // Update workspace files
                    for (IFile existingFile : allFilesToArchive)
                    {
                        removeFile(existingFile);
                        EFSUtils.createLink(getFileSystemScheme(), selectedArchive, existingFile);
                    }

                    // Refresh resource hierarchy
                    selectedArchive.getParent().refreshLocal(1, new NullProgressMonitor());
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
        }
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
        return selectedArchive.getFileExtension();
    }
}
