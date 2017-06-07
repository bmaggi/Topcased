/*******************************************************************************
 * Copyright (c) 2005, 2008 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Gilles Cannenterre (Anyware Technologies) - Fix bugs #1161 and #1247
 *******************************************************************************/
package org.topcased.modeler.internal.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CopyToClipboardCommand;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.commands.EMFtoGEFCommandWrapper;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.edit.EMFGraphNodeEditPart;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.internal.actions.GraphicalPropertiesMap.GraphicalProperties;
import org.topcased.modeler.utils.Utils;

/**
 * Copy into the "shared" Clipboard the selected object.
 * 
 * @author jako
 */
public class CopyAction extends WorkbenchPartAction implements ISelectionChangedListener
{

    /** The modeler editDomain */
    protected IMixedEditDomain editDomain;

    /** This records the command. */
    private Command command;

    GraphicalPropertiesMap map = new GraphicalPropertiesMap();

    /**
     * Constructs a new CopyTemplateAction. You must manually add this action to the palette viewer's list of selection
     * listeners. Otherwise, this action's enabled state won't be updated properly.
     * 
     * @param part the workbench part
     */
    public CopyAction(IWorkbenchPart part)
    {
        super(part);
        editDomain = (IMixedEditDomain) getWorkbenchPart().getAdapter(IMixedEditDomain.class);
        setActionDefinitionId("org.eclipse.ui.edit.copy");
    }

    /**
     * Gets the built command.
     * 
     * @return The created command
     */
    public Command getCommand()
    {
        return command;
    }

    /**
     * Initializes the copy action
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setText("&Copy");
        setToolTipText("Copy");
        setId(ActionFactory.COPY.getId());
        ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
        setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
        setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
        setEnabled(false);
    }

    /**
     * Returns whether the selected EditPart is a GraphNodeEditPart.
     * 
     * @return whether the selected EditPart is a GraphNodeEditPart
     */
    protected boolean calculateEnabled()
    {
        return editDomain != null && command != null && command.canExecute();
    }

    /**
     * Sets the default {@link org.eclipse.gef.ui.actions.Clipboard Clipboard's} contents to be the domain element
     * associated with the selected graphical element.
     */
    public void run()
    {
        // this guard is for extra security, but should not be necessary
        if (editDomain != null && command != null)
        {

            // use up the command - Do not use the CommandStack, to avoid marking the editor as dirty
            command.execute();
            editDomain.getEMFEditingDomain().getClipboard().add(map.clone());
        }
    }

    /**
     * Update the command and refreshes the enabled state of this action.
     * 
     * @see ISelectionChangedListener#selectionChanged(SelectionChangedEvent)
     */
    public void selectionChanged(SelectionChangedEvent event)
    {
        ISelection s = event.getSelection();
        if (!(s instanceof IStructuredSelection))
        {
            return;
        }
        IStructuredSelection selection = (IStructuredSelection) s;

        // Recompute the command according to the current selection
        command = createActionCommand(selection);
        refresh();
    }

    public void saveProperties(EMFGraphNodeEditPart part)
    {
        map.clear();
        if (part.getModel() instanceof GraphNode)
        {
            GraphNode node = (GraphNode) part.getModel();
            saveProperties(node, false);
            for (Iterator<EObject> i = EcoreUtil.getAllProperContents(node, true); i.hasNext();)
            {
                EObject e = i.next();
                if (e instanceof GraphNode)
                {
                    GraphNode child = (GraphNode) e;
                    saveProperties(child, true);
                }
            }
        }
    }

    /**
     * Save the properties of the element in the map
     * 
     * @param node
     * @param child
     */
    private void saveProperties(GraphNode node, boolean child)
    {
        EObject element = Utils.getElement(node);
        if (map.containsKey(element))
        {
            return;
        }
        GraphicalProperties p = new GraphicalProperties();
        p.setBackGroundColor(DIUtils.getPropertyValue(node, ModelerPropertyConstants.BACKGROUND_COLOR));
        p.setFont(DIUtils.getPropertyValue(node, ModelerPropertyConstants.FONT));
        p.setForeGroundColor(DIUtils.getPropertyValue(node, ModelerPropertyConstants.FOREGROUND_COLOR));
        p.setDimension(node.getSize());
        if (child)
        {
            p.setPosition(node.getPosition());
        }
        map.put(element, p);
    }

    /**
     * Creates the GEF command that copy the objects
     * 
     * @return the creation command
     */
    protected Command createActionCommand(IStructuredSelection selection)
    {
        // several objects are contained in the current selection.
        if (selection != null && !selection.isEmpty() && selection.getFirstElement() instanceof EMFGraphNodeEditPart)
        {
            Collection<Object> collec = new ArrayList<Object>();
            Iterator< ? > iterator = selection.toList().iterator();
            while (iterator.hasNext())
            {
                Object object = iterator.next();
                if (object instanceof EMFGraphNodeEditPart)
                {
                    EMFGraphNodeEditPart part = ((EMFGraphNodeEditPart) object);
                    saveProperties(part);
                    EObject domainElement = part.getEObject();
                    if (domainElement != null)
                    {
                        collec.add(domainElement);
                    }
                }
            }
            if (editDomain != null)
            {
                org.eclipse.emf.common.command.Command emfCommand = CopyToClipboardCommand.create(editDomain.getEMFEditingDomain(), collec);
                return new EMFtoGEFCommandWrapper(emfCommand);
            }
        }
        return UnexecutableCommand.INSTANCE;
    }
}
