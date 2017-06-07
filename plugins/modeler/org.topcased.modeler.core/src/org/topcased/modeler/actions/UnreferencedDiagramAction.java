/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (ATOS ORIGIN INTEGRATION) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.internal.UnreferencedDiagramJob;

public class UnreferencedDiagramAction implements IObjectActionDelegate
{
	/** The current file. */
	protected IFile currentFile;

	public void setActivePart(IAction action, IWorkbenchPart targetPart)
	{

	}

	public void run(IAction action)
	{
		UnreferencedDiagramJob move = new UnreferencedDiagramJob(currentFile);
		move.setUser(true);
		move.schedule();
	}

	/**
	 * Sets the new selection when it changes.
	 * 
	 * @param action the action
	 * @param selection the selection
	 * 
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection)
	{
		currentFile = null;
		if (!selection.isEmpty())
		{
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object selectedObject = structuredSelection.getFirstElement();
			if (selectedObject instanceof IFile)
			{
				currentFile = (IFile) selectedObject;
			}
		}
	}

}
