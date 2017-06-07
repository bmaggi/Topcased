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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * Abstract implementation of a way to open the domain model contained in an model archive. By default, the domain model name is the same as the archive file.
 * 
 * @author David Sciamma
 */
public abstract class AbstractModelRedirector extends AbstractRedirector {
	
    /**
     * @see org.topcased.modeler.efs.editor.AbstractRedirector#getFileToOpen(org.eclipse.core.resources.IFile)
     */
	@Override
	protected IFile getFileToOpen(IFile rasFile) 
	{
		IPath filePath = rasFile.getFullPath();
		filePath = filePath.removeFileExtension();
		filePath = filePath.addFileExtension(getDomainFileExtension());
		return rasFile.getParent().getFile(new Path(filePath.lastSegment()));
	}

    /**
     * Get the file extension used for domain model
     * @return the domain file extension
     */
    protected abstract String getDomainFileExtension();
}
