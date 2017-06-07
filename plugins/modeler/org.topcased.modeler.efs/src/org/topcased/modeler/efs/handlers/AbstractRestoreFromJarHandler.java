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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.topcased.modeler.efs.internal.Activator;
import org.topcased.modeler.efs.internal.EFSUtils;

/**
 * This handler is used to Restore files from a Jar file. Our handler extends AbstractHandler, an IHandler base class.
 * 
 * @author Jacques LESCOT
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public abstract class AbstractRestoreFromJarHandler extends AbstractHandler
{
    private ISelection theSelection;

    /**
     * The constructor.
     */
    public AbstractRestoreFromJarHandler()
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
        this.theSelection = HandlerUtil.getCurrentSelection(event);
        executeAction();
        return null;
    }

    private void executeAction()
    {
        IFile file = getSelectedFile();

        if (file != null && getRASFileExtension().equals(file.getFileExtension()))
        {
            EFSUtils.extractFromJar(file);
        }
        else
        {
            Activator.log("The selection is not valid.", IStatus.ERROR);
        }
    }

    /**
     * Get the selected file
     * 
     * @return File the selected file. In case of a multi selection, return the first one only.
     */
    protected IFile getSelectedFile()
    {
        IFile selectedFile = null;

        if (theSelection instanceof IStructuredSelection)
        {
            Object selectedObject = ((IStructuredSelection) theSelection).getFirstElement();
            if (selectedObject instanceof IFile)
            {
                selectedFile = (IFile) selectedObject;
            }
            // TODO Deal with adapters
        }

        return selectedFile;
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

}
