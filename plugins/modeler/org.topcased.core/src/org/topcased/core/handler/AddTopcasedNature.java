/***********************************************************************************************************************
 * Copyright (c) 2010 Communication & Systems.
 * 
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Sebastien GABEL (CS) - initial API and implementation
 * 
 **********************************************************************************************************************/
package org.topcased.core.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.topcased.core.nature.TopcasedNature;

/**
 * Handler adding the <b>org.topcased.core.topcasednature</b> to the current workspace project.<br>
 * 
 * Creation : 26 july 2010<br>
 * 
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 * @since Topcased 4.1.0
 */
public class AddTopcasedNature extends AbstractHandler
{

    /**
     * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
     */
    public Object execute(ExecutionEvent event) throws ExecutionException
    {
        IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
        IProject project = (IProject) selection.getFirstElement();

        try
        {
            IProjectDescription projectDesc = project.getDescription();
            String[] natureIds = projectDesc.getNatureIds();
            String[] newNatureIds = new String[natureIds.length + 1];
            System.arraycopy(natureIds, 0, newNatureIds, 0, natureIds.length);
            newNatureIds[natureIds.length] = TopcasedNature.TOPCASED_NATURE_ID;
            projectDesc.setNatureIds(newNatureIds);
            project.setDescription(projectDesc, new NullProgressMonitor());
        }
        catch (CoreException e)
        {
            throw new ExecutionException(e.getMessage(), e);
        }
        return null;
    }
}
