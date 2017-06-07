/*******************************************************************************
 * Copyright (c) 2008 Anyware Technologies. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   David Sciamma (Anyware Technologies) - initial API and implementation 
 ******************************************************************************/

package org.topcased.modeler.efs.editor;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IEditorLauncher;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.topcased.modeler.efs.internal.Activator;

/**
 * Abstract implementation of a way to open a specific entry contained in an  archived model.
 * 
 * @author David Sciamma
 */
public abstract class AbstractRedirector implements IEditorLauncher {

	/**
	 * @see org.eclipse.ui.IEditorLauncher#open(org.eclipse.core.runtime.IPath)
	 */
	public void open(IPath filePath) {

		try 
		{
			IPath workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
			
			if (workspacePath.isPrefixOf(filePath))
			{
				filePath = filePath.removeFirstSegments(workspacePath.segmentCount());
				filePath = filePath.makeRelative();

				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);
				
				if (file != null && file.exists())
				{
					IFile redirectedFile = getFileToOpen(file);
		
					if (redirectedFile == null || !redirectedFile.exists())
					{
						restoreLinks(file);
						redirectedFile = getFileToOpen(file);
					}
					
					// open diagram file
					IFileEditorInput diagramInput = new FileEditorInput(redirectedFile);
					Activator.getActivePage().openEditor(diagramInput, getEditorId());
				}
			}
		} 
		catch (CoreException ce) 
		{
			// Log the exception
			Activator.log(ce);
			Activator.displayDialog("Error", "An error occured when trying to open diagram editor.\nSee the error log for more details.", IStatus.ERROR);
		}
	}

	/**
	 * Retrieve the file to be automatically open within the archive
	 * 
	 * @param rasFile the archive file
	 * @return A file to be open within the given archive
	 */
	protected abstract IFile getFileToOpen(IFile rasFile);

	/**
	 * Create necessary linked files if missing
	 * 
	 * @param rasFile the archive File 
	 * @throws CoreException 
	 */
	protected void restoreLinks(IFile rasFile) throws CoreException
	{
		IContainer container = rasFile.getParent();

        URI rasURI = null;
        
        try
        {
        	rasURI = new URI(getFileSystemScheme(), null, "/", rasFile.getLocationURI().toString(), null);
		} catch (URISyntaxException use) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR, "Impossible to create link.", use));
		}
        
        IFileStore store = EFS.getStore(rasURI);
		
		String[] childNames = store.childNames(EFS.NONE, new NullProgressMonitor());
		for (int i = 0; i < childNames.length; i++)
		{
			IResource res = container.findMember(childNames[i]);
			if (res != null && res.exists())
			{
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR, "The resouce " + res.getFullPath().toString() + " already exists.", null));
			}
			
			try {
				IFile child = container.getFile(new Path(childNames[i]));
				URI childURI = new URI(getFileSystemScheme(), null, "/" + childNames[i], rasFile.getLocationURI().toString(), null);
				child.createLink(childURI, IResource.REPLACE, null);
			} catch (URISyntaxException use) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR, "Impossible to create link.", use));
			}
		}
	}

    /**
     * Get the FileSystem scheme to be used
     * 
     * @return the FileSystem scheme as a String
     */
    protected abstract String getFileSystemScheme();

    /**
     * Get the Identifier of the Diagram editor to be used
     * 
     * @return the editor id
     */
    protected abstract String getEditorId();
}
