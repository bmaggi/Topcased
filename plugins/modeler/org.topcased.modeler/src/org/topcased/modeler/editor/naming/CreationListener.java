/***********************************************************************
 * Copyright (c) 2008 Obeo and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Laurent Redor (Obeo) - initial API and implementation
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *    David Sciamma (Anyware Technologies) - Workaround for an EMF bug with EFS URI
 *    Gilles Cannenterre (Anyware Technologies) - provide a shared Clipboard
 *    Vincent Hemery (CS) - extract and adapt listener
 **********************************************************************/
package org.topcased.modeler.editor.naming;

import java.util.EventObject;
import java.util.List;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.topcased.modeler.IAnnotationConstants;
import org.topcased.modeler.commands.CreateGraphEdgeCommand;
import org.topcased.modeler.commands.CreateGraphNodeCommand;
import org.topcased.modeler.commands.GEFtoEMFCommandStackWrapper;
import org.topcased.modeler.commands.GEFtoEMFCommandWrapper;
import org.topcased.modeler.editor.TopcasedAdapterFactoryEditingDomain;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.utils.Utils;

/**
 * This command stack listener configures the creation of an element, to ensure its name is correct and that it contains
 * the author EAnnotation.
 * It has been extracted from {@link TopcasedAdapterFactoryEditingDomain}.
 * 
 * @author vhemery
 */
public class CreationListener implements CommandStackListener
{
    /**
     * 
     */
    private final TopcasedAdapterFactoryEditingDomain editingDomain;

    /**
     * @param topcasedAdapterFactoryEditingDomain
     */
    public CreationListener(TopcasedAdapterFactoryEditingDomain topcasedAdapterFactoryEditingDomain)
    {
        editingDomain = topcasedAdapterFactoryEditingDomain;
    }

    public void commandStackChanged(EventObject event)
    {
        CommandStack eventCommandStack = editingDomain.getCommandStack();
        AbstractCommand command = (AbstractCommand) eventCommandStack.getMostRecentCommand();
        EObject modelObject = getModelObjectFromAbstractCommand(command);
        if (modelObject != null)
        {
            createAuthorEannotation(modelObject);
        }
        if (command instanceof CreateChildCommand && modelObject != null)
        {
            EStructuralFeature nameFeature = TopcasedAdapterFactoryLabeler.getInstance().getLabelFeature(modelObject);
            // we need a Topcased command stack to know the state;
            // label creation only on execute not undo and redo
            org.topcased.modeler.commands.CommandStack stack = null;
            if (eventCommandStack instanceof GEFtoEMFCommandStackWrapper)
            {
                org.eclipse.gef.commands.CommandStack gefStack = ((GEFtoEMFCommandStackWrapper) eventCommandStack).getGEFCommandStack();
                if (gefStack instanceof org.topcased.modeler.commands.CommandStack)
                {
                    stack = (org.topcased.modeler.commands.CommandStack) gefStack;
                }
            }
            if (eventCommandStack instanceof org.topcased.modeler.commands.CommandStack)
            {
                stack = (org.topcased.modeler.commands.CommandStack) eventCommandStack;
            }
            if (stack != null)
            {
                if (nameFeature != null)
                {
                    switch (stack.getState())
                    {
                        case org.topcased.modeler.commands.CommandStack.PRE_EXECUTE:
                            String defaultName = NamingHelper.getDefaultName(modelObject);
                            modelObject.eSet(nameFeature, defaultName);
                            break;
                        default:
                    }
                }
            }
        }
    }

    /**
     * Creates the author eannotation from preferences if needed.
     * 
     * @param object the object
     */
    void createAuthorEannotation(EObject object)
    {
        boolean createAuthorAnnotation = ModelerPlugin.getDefault().getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_CREATE_AUTHOR_ANNOTATION);
    
        if (object instanceof EModelElement && createAuthorAnnotation)
        {
            EModelElement modelObject = (EModelElement) object;
            EAnnotation authorAnnotation = modelObject.getEAnnotation(IAnnotationConstants.AUTHOR_SOURCE);
            String author = ModelerPlugin.getDefault().getPreferenceStore().getString(ModelerPreferenceConstants.P_DEFAULT_AUTHOR);
    
            // creates EAnnotation if needed
            if (authorAnnotation == null && !"".equals(author))
            {
                Utils.createAuthorEAnnotation(modelObject, author);
            }
        }
    }

    /**
     * Gets the model object depending on the command.
     * 
     * @param command the specified abstract command
     * 
     * @return the model object from the command
     */
    EObject getModelObjectFromAbstractCommand(AbstractCommand command)
    {
        EObject modelObject = null;
    
        // create object from the editor
        if (command instanceof GEFtoEMFCommandWrapper)
        {
            modelObject = getModelObjectFromCommand(((GEFtoEMFCommandWrapper) command).getGefCommand());
        }
    
        // create object from the outline
        else if (command instanceof CreateChildCommand)
        {
            modelObject = (EObject) ((List< ? >) command.getAffectedObjects()).get(0);
        }
        return modelObject;
    }

    /**
     * Gets the model object from command searching recursively.
     * 
     * @param command the specified command
     * 
     * @return the model object from command
     */
    private EObject getModelObjectFromCommand(Command command)
    {
        EObject modelObject = null;
        if (command instanceof CreateGraphNodeCommand)
        {
            modelObject = ((CreateGraphNodeCommand) command).getChildEObject();
        }
        else if (command instanceof CreateGraphEdgeCommand)
        {
            modelObject = Utils.getElement(((CreateGraphEdgeCommand) command).getEdge());
        }
        else if (command instanceof CompoundCommand)
        {
            for (Object c : ((CompoundCommand) command).getCommands())
            {
                if (c instanceof Command)
                {
                    EObject object = getModelObjectFromCommand((Command) c);
                    if (object != null)
                    {
                        return object;
                    }
                }
            }
        }
        return modelObject;
    }
}