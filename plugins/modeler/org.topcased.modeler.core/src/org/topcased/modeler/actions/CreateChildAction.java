/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.actions;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandActionDelegate;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.topcased.modeler.commands.EMFtoGEFCommandWrapper;
import org.topcased.modeler.editor.MixedEditDomain;

/**
 * This action creates a new child for an EObject. <br>
 * creation : 30 mai 2005
 * TODO Check the API for this class
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class CreateChildAction extends Action
{
    /**
     * This describes the child to be created.
     */
    private Object descriptor;

    /**
     * This records the command.
     */
    private Command command;

    /**
     * The Modeler editDomain
     */
    private MixedEditDomain editDomain;

    /**
     * Constructor
     * 
     * @param domain The editor EditDomain
     * @param selectedObject The parent EObject
     * @param desc the child description
     */
    public CreateChildAction(MixedEditDomain domain, EObject selectedObject, Object desc)
    {
        super();

        this.descriptor = desc;
        this.editDomain = domain;
        this.command = createActionCommand(selectedObject);

        updateAction();
    }

    /**
     * Update the action with the current command settings
     */
    private void updateAction()
    {
        if (command != null)
        {
            setEnabled(command.canExecute());

            if (command instanceof EMFtoGEFCommandWrapper
                    && ((EMFtoGEFCommandWrapper) command).getEMFCommand() instanceof CommandActionDelegate)
            {
                CommandActionDelegate commandActionDelegate = (CommandActionDelegate) ((EMFtoGEFCommandWrapper) command).getEMFCommand();

                ImageDescriptor imageDescriptor = getObjectImageDescriptor(commandActionDelegate.getImage());
                if (imageDescriptor != null)
                {
                    setImageDescriptor(imageDescriptor);
                }

                if (commandActionDelegate.getText() != null)
                {
                    setText(commandActionDelegate.getText());
                }

                if (commandActionDelegate.getDescription() != null)
                {
                    setDescription(commandActionDelegate.getDescription());
                }

                if (commandActionDelegate.getToolTipText() != null)
                {
                    setToolTipText(commandActionDelegate.getToolTipText());
                }
            }
        }
    }

    /**
     * Creates the GEF command that creates the child
     * 
     * @param object the parent EObject
     * @return the creation command
     */
    protected Command createActionCommand(EObject object)
    {
        Command cmd = UnexecutableCommand.INSTANCE;
        if (object != null)
        {
            Collection<EObject> collec = new ArrayList<EObject>();
            collec.add(object);

            EMFtoGEFCommandWrapper gefCommand = null;
            // if we found an editing domain, create command
            if (editDomain != null)
            {
                org.eclipse.emf.common.command.Command emfCommand = CreateChildCommand.create(
                        editDomain.getEMFEditingDomain(), object, descriptor, collec);
                gefCommand = new EMFtoGEFCommandWrapper(emfCommand);
            }

            cmd = gefCommand;
        }
        return cmd;
    }

    /**
     * If necessary, this converts any image representation into an image
     * descriptor.
     * 
     * @param object the EObject
     * @return the Image descriptor associated with the EObject
     */
    protected ImageDescriptor getObjectImageDescriptor(Object object)
    {
        return ExtendedImageRegistry.getInstance().getImageDescriptor(object);
    }

    /**
     * This executes the command.
     */
    public void run()
    {
        // this guard is for extra security, but should not be necessary
        if (editDomain != null && command != null)
        {
            // use up the command
            editDomain.getCommandStack().execute(command);
        }
    }
}
