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
import org.eclipse.emf.edit.command.CutToClipboardCommand;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
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
import org.topcased.modeler.commands.DeleteGraphElementCommand;
import org.topcased.modeler.commands.EMFtoGEFCommandWrapper;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.edit.EMFGraphNodeEditPart;
import org.topcased.modeler.edit.GraphNodeEditPart;
import org.topcased.modeler.editor.MixedEditDomain;
import org.topcased.modeler.internal.actions.GraphicalPropertiesMap.GraphicalProperties;
import org.topcased.modeler.utils.Utils;

/**
 * Copy into Clipboard the selected object and remove from children list container
 * 
 * @author jako
 */
public class CutAction extends WorkbenchPartAction implements ISelectionChangedListener
{
    /** List of graph nodes to cut */
    protected ArrayList<EMFGraphNodeEditPart> editPartToDeleteList = new ArrayList<EMFGraphNodeEditPart>();

    /** The Modeler editDomain */
    protected MixedEditDomain editDomain;

    /** This records the command. */
    protected Command command;
    
    GraphicalPropertiesMap map = new GraphicalPropertiesMap();

    /**
     * Constructs a new CopyTemplateAction. You must manually add this action to the palette viewer's list of selection
     * listeners. Otherwise, this action's enabled state won't be updated properly.
     * 
     * @param part the workbench part
     */
    public CutAction(IWorkbenchPart part)
    {
        super(part);
        editDomain = (MixedEditDomain) getWorkbenchPart().getAdapter(MixedEditDomain.class);
        setActionDefinitionId("org.eclipse.ui.edit.cut");
    }

    /**
     * Initializes the copy action
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setText("&Cut");
        setToolTipText("Cut");
        setId(ActionFactory.CUT.getId());
        ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
        setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
        setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT_DISABLED));
        setEnabled(false);
    }

    /**
     * Returns whether the selected EditPart is a TemplateEditPart.
     * 
     * @return whether the selected EditPart is a TemplateEditPart
     */
    protected boolean calculateEnabled()
    {
        return command != null && command.canExecute() && !editPartToDeleteList.isEmpty();
    }

    /**
     * Sets the default {@link org.eclipse.gef.ui.actions.Clipboard Clipboard's} contents to be the domain element
     * associated with the selected graphical element.
     */
    public void run()
    {
        if (editDomain != null && command != null && !editPartToDeleteList.isEmpty())
        {
            CompoundCommand cutCommand = new CompoundCommand("Cut");
            cutCommand.add(command);
            Iterator<EMFGraphNodeEditPart> iterator = editPartToDeleteList.iterator();
            while (iterator.hasNext())
            {
                EMFGraphNodeEditPart emfGraphNodeEditPart = (EMFGraphNodeEditPart) iterator.next();
                Command deleteGraphicalElementCommand = new DeleteGraphElementCommand((GraphElement) ((GraphNodeEditPart) emfGraphNodeEditPart).getModel(), true);
                cutCommand.add(deleteGraphicalElementCommand);
            }
            editDomain.getCommandStack().execute(cutCommand);
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
        editPartToDeleteList.clear();
        command = createActionCommand(selection);
        refresh();
    }

    /**
     * Creates the GEF command that cut the objects
     * 
     * @return the creation command
     */
    protected Command createActionCommand(IStructuredSelection selection)
    {
        if (selection != null && !selection.isEmpty() && selection.getFirstElement() instanceof EMFGraphNodeEditPart)
        {
            Collection<EObject> collec = new ArrayList<EObject>();
            Iterator< ? > iterator = selection.toList().iterator();
            while (iterator.hasNext())
            {
                Object object = iterator.next();
                if (object instanceof EMFGraphNodeEditPart)
                {
                    EMFGraphNodeEditPart emfGraphNodeEditPart = (EMFGraphNodeEditPart) object;
                    saveProperties(emfGraphNodeEditPart);
                    if (emfGraphNodeEditPart != null)
                    {
                        editPartToDeleteList.add(emfGraphNodeEditPart);
                        collec.add(emfGraphNodeEditPart.getEObject());
                    }
                }
            }
            if (editDomain != null)
            {
                org.eclipse.emf.common.command.Command emfCommand = CutToClipboardCommand.create(editDomain.getEMFEditingDomain(), collec);
                return new EMFtoGEFCommandWrapper(emfCommand);
            }
        }
        return UnexecutableCommand.INSTANCE;
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
}
