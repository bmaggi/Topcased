/***********************************************************************
 * Copyright (c) 2005, 2008 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Mathieu Garcia (Anyware Technologies) - initial API and implementation
 *    Thomas Friol (Anyware Technologies) - initial API and implementation
 *    Gilles Cannenterre (Anyware Technologies) - Fix bugs #1161 and #1247
 **********************************************************************/
package org.topcased.modeler.editor;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.actions.ActionFactory;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.internal.ModelerImageRegistry;

/**
 * Provide a Context Menu for the Modeler with standards actions
 * 
 * @author jako
 */
public class ModelerContextMenuProvider extends ContextMenuProvider
{
    private ActionRegistry actionRegistry;

    /**
     * Constructs a context menu for the specified EditPartViewer and the Actions registered in the ActionRegistry
     * 
     * @param viewer the EditPartViewer
     * @param registry the ActionRegistry
     */
    public ModelerContextMenuProvider(EditPartViewer viewer, ActionRegistry registry)
    {
        super(viewer);
        setActionRegistry(registry);
    }

    /**
     * Called when the menu is about to show. Construct the context menu by adding actions common to all editparts.
     * 
     * @see org.eclipse.gef.ContextMenuProvider#buildContextMenu(org.eclipse.jface.action.IMenuManager)
     */
    public void buildContextMenu(IMenuManager manager)
    {
        GEFActionConstants.addStandardActionGroups(manager);

        IAction action;

        action = getActionRegistry().getAction(ActionFactory.UNDO.getId());
        manager.appendToGroup(GEFActionConstants.GROUP_UNDO, action);

        action = getActionRegistry().getAction(ActionFactory.REDO.getId());
        manager.appendToGroup(GEFActionConstants.GROUP_UNDO, action);

        action = getActionRegistry().getAction(ModelerActionConstants.DELETE_MODEL_OBJECT);
        if (action.isEnabled())
        {
            manager.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        }

        action = getActionRegistry().getAction(ActionFactory.COPY.getId());
        if (action.isEnabled())
        {
            manager.appendToGroup(GEFActionConstants.GROUP_COPY, action);
        }

        action = getActionRegistry().getAction(ActionFactory.CUT.getId());
        if (action.isEnabled())
        {
            manager.appendToGroup(GEFActionConstants.GROUP_COPY, action);
        }

        action = getActionRegistry().getAction(ActionFactory.PASTE.getId());
        if (action.isEnabled())
        {
            manager.appendToGroup(GEFActionConstants.GROUP_COPY, action);
        }

        action = getActionRegistry().getAction(ActionFactory.DELETE.getId());
        if (action.isEnabled())
        {
            manager.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        }

        action = getActionRegistry().getAction(GEFActionConstants.DIRECT_EDIT);
        if (action.isEnabled())
        {
            manager.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        }

        action = getActionRegistry().getAction(ModelerActionConstants.RESTORE_CONNECTIONS);
        if (action.isEnabled())
        {
            manager.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        }

        IMenuManager subMenu = buildGraphicPropertiesMenu();
        manager.appendToGroup(GEFActionConstants.GROUP_EDIT, subMenu);

        // Add the subMenu that handle Alignment actions
        subMenu = buildAlignmentMenu();
        manager.appendToGroup(GEFActionConstants.GROUP_EDIT, subMenu);

        subMenu = buildSelectAllMenu();
        manager.appendToGroup(GEFActionConstants.GROUP_EDIT, subMenu);

        action = getActionRegistry().getAction(ModelerActionConstants.SHOW_PROPERTIES);
        if (action.isEnabled())
        {
            manager.appendToGroup(GEFActionConstants.GROUP_VIEW, action);
        }

        action = getActionRegistry().getAction(ModelerActionConstants.SHOW_DOCUMENTATION);
        if (action.isEnabled())
        {
            manager.appendToGroup(GEFActionConstants.GROUP_VIEW, action);
        }
    }

    protected IMenuManager buildSelectAllMenu()
    {
        MenuManager submenuSelectAll = new MenuManager("Select", ModelerImageRegistry.getImageDescriptor("SELECT_ALL"), "org.topcased.modeler.submenu.select");

        IAction action = getActionRegistry().getAction(ModelerActionConstants.SELECT_ALL);
        if (action.isEnabled())
        {
            submenuSelectAll.add(action);
        }

        action = getActionRegistry().getAction(ModelerActionConstants.SELECT_ALL_NODES);
        if (action.isEnabled())
        {
            submenuSelectAll.add(action);
        }

        action = getActionRegistry().getAction(ModelerActionConstants.SELECT_ALL_CONNECTIONS);
        if (action.isEnabled())
        {
            submenuSelectAll.add(action);
        }
        return submenuSelectAll;
    }

    protected IMenuManager buildGraphicPropertiesMenu()
    {
        // Graphic Edition Actions
        MenuManager submenuGraphicEdition = new MenuManager("Graphical Properties");

        IAction action = getActionRegistry().getAction(ModelerActionConstants.CHANGE_DIAGRAM_PROPERTIES);
        if (action.isEnabled())
        {
            submenuGraphicEdition.add(action);
        }

        action = getActionRegistry().getAction(ModelerActionConstants.MOVE_FORWARD);
        if (action.isEnabled())
        {
            submenuGraphicEdition.add(action);
        }

        action = getActionRegistry().getAction(ModelerActionConstants.MOVE_TO_FRONT);
        if (action.isEnabled())
        {
            submenuGraphicEdition.add(action);
        }

        action = getActionRegistry().getAction(ModelerActionConstants.MOVE_BACKWARD);
        if (action.isEnabled())
        {
            submenuGraphicEdition.add(action);
        }

        action = getActionRegistry().getAction(ModelerActionConstants.MOVE_TO_BACK);
        if (action.isEnabled())
        {
            submenuGraphicEdition.add(action);
        }

        submenuGraphicEdition.add(new Separator());

        action = getActionRegistry().getAction(ModelerActionConstants.CHANGE_BACKGROUND_COLOR);
        if (action.isEnabled())
        {
            submenuGraphicEdition.add(action);
        }

        action = getActionRegistry().getAction(ModelerActionConstants.CHANGE_FOREGROUND_COLOR);
        if (action.isEnabled())
        {
            submenuGraphicEdition.add(action);
        }

        submenuGraphicEdition.add(new Separator());

        action = getActionRegistry().getAction(ModelerActionConstants.CHANGE_FONT);
        if (action.isEnabled())
        {
            submenuGraphicEdition.add(action);
        }

        action = getActionRegistry().getAction(ModelerActionConstants.CHANGE_ROUTER);
        if (action.isEnabled())
        {
            submenuGraphicEdition.add(action);
        }

        action = getActionRegistry().getAction(ModelerActionConstants.AUTO_RESIZE);
        if (action.isEnabled())
        {
            submenuGraphicEdition.add(action);
        }
        
        // Auto resize diagram page format.. See. #1973
        action = getActionRegistry().getAction(ModelerActionConstants.AUTO_RESIZE_PAGE);
        if (action.isEnabled())
        {
            submenuGraphicEdition.add(action);
        }

        return submenuGraphicEdition;
    }

    protected IMenuManager buildAlignmentMenu()
    {
        // Alignment Actions
        IMenuManager submenuAlignment = new MenuManager("Alignment");

        IAction action = getActionRegistry().getAction(GEFActionConstants.ALIGN_LEFT);
        if (action.isEnabled())
        {
            submenuAlignment.add(action);
        }

        action = getActionRegistry().getAction(GEFActionConstants.ALIGN_CENTER);
        if (action.isEnabled())
        {
            submenuAlignment.add(action);
        }

        action = getActionRegistry().getAction(GEFActionConstants.ALIGN_RIGHT);
        if (action.isEnabled())
        {
            submenuAlignment.add(action);
        }

        submenuAlignment.add(new Separator());

        action = getActionRegistry().getAction(GEFActionConstants.ALIGN_TOP);
        if (action.isEnabled())
        {
            submenuAlignment.add(action);
        }

        action = getActionRegistry().getAction(GEFActionConstants.ALIGN_MIDDLE);
        if (action.isEnabled())
        {
            submenuAlignment.add(action);
        }

        action = getActionRegistry().getAction(GEFActionConstants.ALIGN_BOTTOM);
        if (action.isEnabled())
        {
            submenuAlignment.add(action);
        }

        submenuAlignment.add(new Separator());

        action = getActionRegistry().getAction(GEFActionConstants.MATCH_WIDTH);
        if (action.isEnabled())
        {
            submenuAlignment.add(action);
        }

        action = getActionRegistry().getAction(GEFActionConstants.MATCH_HEIGHT);
        if (action.isEnabled())
        {
            submenuAlignment.add(action);
        }

        return submenuAlignment;
    }

    /**
     * Returns the ActionRegistry
     * 
     * @return the ActionRegistry
     */
    protected ActionRegistry getActionRegistry()
    {
        return actionRegistry;
    }

    /**
     * Set the ActionRegistry for this ContextMenuProvider
     * 
     * @param registry the ActionRegistry
     */
    protected void setActionRegistry(ActionRegistry registry)
    {
        actionRegistry = registry;
    }

}
