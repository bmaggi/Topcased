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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.topcased.modeler.efs.internal.Activator;
import org.topcased.modeler.efs.internal.EFSUtils;

/**
 * This handler is used to create a new RAS file from the selected files. This handler is only enabled when at least two
 * files are selected : we check in the executeAction() method that the two files belong to the domain file and its
 * corresponding diagrams file. Our handler extends AbstractHandler, an IHandler base class.
 * 
 * @author Jacques LESCOT
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public abstract class AbstractCreateJarHandler extends AbstractHandler
{
    private List<IFile> selectedFiles;

    /**
     * The constructor.
     */
    public AbstractCreateJarHandler()
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
        selectedFiles = new ArrayList<IFile>();
        if (selection instanceof IStructuredSelection)
        {
            for (Iterator< ? > itFiles = ((IStructuredSelection) selection).iterator(); itFiles.hasNext();)
            {
                IFile currentFile = (IFile) itFiles.next();
                // Filter linked files (just ignore them) and all other files that are not domain or diagrams files.
                if (!currentFile.isLinked()
                        && (getDiagramsFileExtension().equals(currentFile.getFileExtension()) || getDomainFileExtension().equals(
                                currentFile.getFileExtension())))
                {
                    selectedFiles.add(currentFile);
                }
            }
        }
    }

    private void executeAction()
    {
        // Check whether selection is not empty and that all the selected files are within the same container
        if (!selectedFiles.isEmpty())
        {
            if (checkFilesInSameContainer())
            {
                List<String> availableArchiveNames = getPossibleArchiveNames();
                if (!availableArchiveNames.isEmpty())
                {
                    String archiveName = availableArchiveNames.get(0);
                    if (availableArchiveNames.size() > 1)
                    {
                        ElementListSelectionDialog dialog = new ElementListSelectionDialog(
                                Activator.getActiveWorkbenchShell(), new LabelProvider());
                        dialog.setTitle("Archive Name Selection");
                        dialog.setMessage("Select an archive name - this should be associated with the main diagram file (* = any string, ? = any char):");
                        dialog.setMultipleSelection(false);
                        dialog.setElements(availableArchiveNames.toArray());
                        if (dialog.open() == Window.OK)
                        {
                            archiveName = (String) dialog.getFirstResult();
                        }
                    }
                    createRAS(archiveName);
                }
                else
                {
                    Activator.log("Problems in the selected files. You should select at least a *."
                            + getDomainFileExtension() + " domain file and its associated *."
                            + getDiagramsFileExtension() + " diagrams file.", IStatus.ERROR);
                }
            }
            else
            {
                Activator.log("Selected resources should be within the same container.", IStatus.ERROR);
            }
        }
        else
        {
            Activator.log("The selection is not valid. Do not select linked files.", IStatus.ERROR);
        }
    }

    // Create a RAS file : this is a jar file in fact using the given name
    private void createRAS(String archiveName)
    {
        // The archive is created in the same container than all other selected resources
        IFile rasFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
                selectedFiles.get(0).getFullPath().removeLastSegments(1).append(archiveName));

        try
        {
            // Create the RAS file
            JarOutputStream out = new JarOutputStream(new FileOutputStream(rasFile.getLocationURI().getPath()));

            // Compress the files
            for (IFile sourceFile : selectedFiles)
            {
                EFSUtils.insertFile(out, sourceFile);
                // Update workspace the files
                removeFile(sourceFile);
            }

            // Complete the JAR file
            out.close();

            // Refresh resource hierarchy
            rasFile.getParent().refreshLocal(1, new NullProgressMonitor());
        }
        catch (FileNotFoundException e)
        {
            Activator.log(e);
        }
        catch (IOException e)
        {
            Activator.log(e);
        }
        catch (CoreException e)
        {
            Activator.log(e);
        }
    }

    private void removeFile(IFile sourceFile) throws CoreException
    {
        sourceFile.delete(true, null);
    }

    // Check whether all the selected Resources are within the same Container
    private boolean checkFilesInSameContainer()
    {
        // Choose the first one as a reference
        IContainer container = selectedFiles.get(0).getParent();

        for (IFile selectedFile : selectedFiles)
        {
            if (!container.equals(selectedFile.getParent()))
            {
                return false;
            }
        }
        return true;
    }

    // Compute a list of name that could be used for the archive model
    private List<String> getPossibleArchiveNames()
    {
        List<String> availableModelNames = new ArrayList<String>();
        List<String> availableDiagramNames = new ArrayList<String>();

        for (IFile selectedFile : selectedFiles)
        {
            if (getDomainFileExtension().equals(selectedFile.getFileExtension()))
            {
                availableModelNames.add(selectedFile.getName());
            }
            else if (getDiagramsFileExtension().equals(selectedFile.getFileExtension()))
            {
                availableDiagramNames.add(selectedFile.getName());
            }
        }

        // List all available name that could be used for the archive. At least one model and one diagram file with the
        // same name must be selected.
        List<String> availableArchiveNames = new ArrayList<String>();
        for (String currentName : availableModelNames)
        {
            // Check whether a model and its associated diagrams files are present in the selection
            if (availableDiagramNames.contains(currentName.concat("di")))
            {
                // Add a new possibility to name the archive model
                availableArchiveNames.add(currentName.concat("z"));
            }
        }

        return availableArchiveNames;
    }

    /**
     * Get the file extension of the archive file. By default, the extension is computed using the domain file extension
     * and adding 'z' as suffix.
     * 
     * @return the archive file extension
     */
    protected String getRASFileExtension()
    {
        return getDomainFileExtension().concat("z");
    }

    /**
     * Get the file extension of the diagrams file. By default, the extension is computed using the domain file
     * extension and adding 'di' as suffix.
     * 
     * @return the diagrams file extension
     */
    protected String getDiagramsFileExtension()
    {
        return getDomainFileExtension().concat("di");
    }

    /**
     * Get the file extension of the domain file
     * 
     * @return the domain file extension
     */
    protected abstract String getDomainFileExtension();

    /**
     * Get the scheme of the EFS FileSystem for the given RAS format
     * 
     * @return the RAS Scheme
     */
    protected abstract String getFileSystemScheme();
}
