/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thibault Landre (Atos Origin) <a href="mailto:thibault.landre@atosorigin.com">Thibault Landre</a> - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.internal.actions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerImageRegistry;

/**
 * This class represents the action to select all connectors displayed in a diagram.
 */
public class SelectAllConnectionsAction extends WorkbenchPartAction implements ISelectionChangedListener
{

    /** The all edit part children. */
    private Set<GraphicalEditPart> allEditPartChildren = new HashSet<GraphicalEditPart>();

    /** The part. */
    private IWorkbenchPart part;

    /**
     * Instantiates a new select all connections action.
     * 
     * @param part the part
     */
    public SelectAllConnectionsAction(IWorkbenchPart part)
    {
        super(part);
        this.part = part;
    }

    /**
     * Selection changed.
     * 
     * @param event the event
     * 
     * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
     */
    public void selectionChanged(SelectionChangedEvent event)
    {

    }

    /**
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
     */
    @Override
    protected boolean calculateEnabled()
    {
        return false;
    }

    /**
     * Initializes the paste action.
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setId(ModelerActionConstants.SELECT_ALL_CONNECTIONS);
        setText("Select All Connections");
        setImageDescriptor(ModelerImageRegistry.getImageDescriptor("SELECT_ALL_CONNECTORS"));
    }

    /**
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#isEnabled()
     */
    @Override
    public boolean isEnabled()
    {
        return true;
    }

    /**
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    public void run()
    {
        Modeler modeler = (Modeler) part.getAdapter(Modeler.class);
        allEditPartChildren.clear();
        modeler.setSelection(new StructuredSelection(getAllChildren(modeler).toArray()));
    }

    
    /**
     * Populate the allEditPartChildren set.
     * 
     * @return the allEditPartChildren set
     */
    protected Set<GraphicalEditPart> getAllChildren(Modeler modeler)
    {
        if (allEditPartChildren.isEmpty())
        {
            getAllChildren(modeler.getRootEditPart(), allEditPartChildren);
        }
        return allEditPartChildren;
    }

    /**
     * A recursive method to populate the allEditPartChildren set.
     * This method add all the children connections edit part of the given parent editPart to the set, except instance of DiagramEditPart.
     * 
     * @param editPart the parent EditPart
     * @param allChildren the set of all children editPart
     * 
     */
    protected void getAllChildren(EditPart editPart, Set<GraphicalEditPart> allChildren)
    {
        List children = editPart.getChildren();
        for (int i = 0; i < children.size(); i++)
        {
            GraphicalEditPart child = (GraphicalEditPart) children.get(i);
            allEditPartChildren.addAll(child.getSourceConnections());
            allEditPartChildren.addAll(child.getTargetConnections());

            getAllChildren(child, allEditPartChildren);
        }
    }

}
