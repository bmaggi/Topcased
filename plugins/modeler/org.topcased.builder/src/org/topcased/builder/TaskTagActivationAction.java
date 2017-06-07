/*****************************************************************************
 * Copyright (c) 2012 AtoS.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  N. PERANSIN (AtoS) nicolas.peransin@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

/**
 * Add the task tag builder to a project.
 * 
 * @author AtoS (npn)
 */
public class TaskTagActivationAction implements IEditorActionDelegate
{

    /**
     * Containing project of resources which will receive TODO note markers
     */
    public IProject project;

    public TaskTagActivationAction()
    {
        // empty constructor for extension point
    }

    public TaskTagActivationAction(IProject project)
    {
        setProject(project);
    }

    public IProject getProject()
    {
        return project;
    }

    public void setProject(IProject project)
    {
        this.project = project;
    }

    public void setActiveEditor(IAction action, IEditorPart targetEditor)
    {
        // Nothing to do
    }

    /**
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    public void run(IAction action)
    {
        try
        {
            addBuilderToProject();
        }
        catch (CoreException e)
        {
            log(e);
        }
    }

    /**
     * Log an exception into the Eclipse log file
     * 
     * @param e the exception to log
     */
    public void log(Throwable e)
    {
        BuilderActivator.getDefault().log(e);
    }

    /**
     * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(IAction action, ISelection selection)
    {
        if (selection instanceof StructuredSelection)
        {
            StructuredSelection struct = (StructuredSelection) selection;
            Object object = struct.getFirstElement();
            if (object instanceof IProject)
            {
                project = (IProject) object;

                try
                {
                    action.setEnabled(!isBuilderInProject());
                }
                catch (CoreException e)
                {
                    log(e);
                }
            }
        }
    }

    /**
     * @throws CoreException
     */
    public void addBuilderToProject() throws CoreException
    {
        if (!isBuilderInProject())
        {
            IProjectDescription description = project.getDescription();
            ICommand command = description.newCommand();
            command.setBuilderName(TaskTagBuilder.BUILDER_FULLNAME);
            command.setBuilding(IncrementalProjectBuilder.AUTO_BUILD, true);
            command.setBuilding(IncrementalProjectBuilder.INCREMENTAL_BUILD, true);
            command.setBuilding(IncrementalProjectBuilder.FULL_BUILD, true);
            command.setBuilding(IncrementalProjectBuilder.CLEAN_BUILD, true);
            List<ICommand> newBuilders = new ArrayList<ICommand>();
            Collections.addAll(newBuilders, description.getBuildSpec());
            newBuilders.add(command);
            description.setBuildSpec(newBuilders.toArray(new ICommand[newBuilders.size()]));
            project.setDescription(description, null);
        }
    }

    /**
     * Remove the tag builder from the project.
     * 
     * @throws CoreException
     */
    public void removeBuilderFromProject() throws CoreException
    {
        ICommand old = getBuildCommand();
        if (old != null)
        {
            IProjectDescription description = project.getDescription();
            List<ICommand> cmds = new ArrayList<ICommand>(Arrays.asList(description.getBuildSpec()));
            cmds.remove(old);
            description.setBuildSpec(cmds.toArray(new ICommand[cmds.size()]));
            project.setDescription(description, null);
        }
    }

    /**
     * Remove the tag builder from the project.
     * 
     * @return the command
     * @throws CoreException
     */
    public ICommand getBuildCommand() throws CoreException
    {
        for (ICommand command : project.getDescription().getBuildSpec())
        {
            if (command.getBuilderName().equals(TaskTagBuilder.BUILDER_FULLNAME))
            {
                return command;
            }
        }
        return null;
    }

    public boolean isBuilderInProject() throws CoreException
    {
        return getBuildCommand() != null;
    }

}
