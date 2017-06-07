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

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.AlignmentRetargetAction;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.MatchHeightRetargetAction;
import org.eclipse.gef.ui.actions.MatchWidthRetargetAction;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.gef.ui.actions.ZoomComboContributionItem;
import org.eclipse.gef.ui.actions.ZoomInRetargetAction;
import org.eclipse.gef.ui.actions.ZoomOutRetargetAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.RetargetAction;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.internal.ModelerImageRegistry;

/**
 * Basic action bar contributor
 */
public class ModelerActionBarContributor extends ActionBarContributor
{

    /**
     * Add the retarget actions
     * 
     * @see org.eclipse.gef.ui.actions.ActionBarContributor#buildActions()
     */
    protected void buildActions()
    {
        RetargetAction action = null;
        addRetargetAction(new UndoRetargetAction());
        addRetargetAction(new RedoRetargetAction());

        addRetargetAction(new DeleteRetargetAction());

        addRetargetAction(new AlignmentRetargetAction(PositionConstants.LEFT));
        addRetargetAction(new AlignmentRetargetAction(PositionConstants.CENTER));
        addRetargetAction(new AlignmentRetargetAction(PositionConstants.RIGHT));
        addRetargetAction(new AlignmentRetargetAction(PositionConstants.TOP));
        addRetargetAction(new AlignmentRetargetAction(PositionConstants.MIDDLE));
        addRetargetAction(new AlignmentRetargetAction(PositionConstants.BOTTOM));

        addRetargetAction(new MatchWidthRetargetAction());
        addRetargetAction(new MatchHeightRetargetAction());
        // Auto resize
        action = new RetargetAction(ModelerActionConstants.AUTO_RESIZE, "Auto Resize");
        action.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("AUTO_RESIZE"));
        action.setToolTipText("Auto Resize the selected objects");
        addRetargetAction(action);

        addRetargetAction(new ZoomInRetargetAction());
        addRetargetAction(new ZoomOutRetargetAction());

        // Refresh
        action = new RetargetAction(ModelerActionConstants.REFRESH, "Refresh");
        action.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("REFRESH"));
        action.setToolTipText("Refresh the current diagram");
        addRetargetAction(action);
        // Previous Diagram
        action = new RetargetAction(ModelerActionConstants.PREVIOUS_DIAGRAM, "Previous Diagram");
        action.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("PREVIOUS_DIAGRAM"));
        action.setToolTipText("Go to the previous diagram");
        addRetargetAction(action);
        // Next Diagram
        action = new RetargetAction(ModelerActionConstants.NEXT_DIAGRAM, "Next Diagram");
        action.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("NEXT_DIAGRAM"));
        action.setToolTipText("Go to the next diagram");
        addRetargetAction(action);
        // Open Parent Diagram
        action = new RetargetAction(ModelerActionConstants.OPEN_PARENT_DIAGRAM, "Open Parent Diagram");
        action.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("PARENT_DIAGRAM"));
        action.setToolTipText("Open the Parent Diagram");
        addRetargetAction(action);
        // Go To Root Diagram
        action = new RetargetAction(ModelerActionConstants.GO_TO_ROOT_DIAGRAM, "Go To Root Diagram");
        action.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("ROOT_DIAGRAM"));
        action.setToolTipText("Go To the Root Diagram");
        addRetargetAction(action);

        // Snap To Geometry
        action = new RetargetAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY, "Snap To Geometry", IAction.AS_CHECK_BOX);
        action.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("SNAP_GEOMETRY"));
        action.setToolTipText("Active/Deactivate Snap to geometry");
        addRetargetAction(action);

        // Snap To Grid
        action = new RetargetAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY, "Show Grid", IAction.AS_CHECK_BOX);
        action.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("SHOW_GRID"));
        action.setToolTipText("Show/Hide grid");
        addRetargetAction(action);

        addRetargetAction(new ZoomInRetargetAction());
        addRetargetAction(new ZoomOutRetargetAction());

        // Validation
        action = new RetargetAction(ModelerActionConstants.VALIDATE, "Validate");
        action.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("VALIDATE"));
        action.setToolTipText("Validate the model");
        addRetargetAction(action);

        // Graphical parent problems report
        action = new RetargetAction(ModelerActionConstants.SYNCHRONIZED_MODEL_DIAGRAM_REPORT, "Report synchronization problems between model and diagrams.");
        action.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("SYNCHRONIZED_MODEL_DIAGRAM_REPORT"));
        action.setToolTipText("See graphical elements which are not represented in their parents.");
        addRetargetAction(action);

        // Enable write
        action = new RetargetAction(ModelerActionConstants.ENABLE_WRITE, "Enable write on the current editor");
        action.setImageDescriptor(ModelerImageRegistry.getImageDescriptor("ENABLE_WRITE"));
        action.setToolTipText("Enable write on the current editor");
        addRetargetAction(action);

    }

    /**
     * Add the actions to the ToolBar
     * 
     * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToToolBar(org.eclipse.jface.action.IToolBarManager)
     */
    public void contributeToToolBar(IToolBarManager toolBarManager)
    {
        super.contributeToToolBar(toolBarManager);

        // Add Undo/Redo contributors to the toolbar
        toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
        toolBarManager.add(getAction(ActionFactory.REDO.getId()));

        // // Add Copy/Cut/Paste contributors to the toolbar
        // toolBarManager.add(new Separator());
        // toolBarManager.add(getAction(ActionFactory.COPY.getId()));
        // toolBarManager.add(getAction(ActionFactory.CUT.getId()));
        // toolBarManager.add(getAction(ActionFactory.PASTE.getId()));

        // Alignment Actions
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(GEFActionConstants.ALIGN_LEFT));
        toolBarManager.add(getAction(GEFActionConstants.ALIGN_CENTER));
        toolBarManager.add(getAction(GEFActionConstants.ALIGN_RIGHT));
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(GEFActionConstants.ALIGN_TOP));
        toolBarManager.add(getAction(GEFActionConstants.ALIGN_MIDDLE));
        toolBarManager.add(getAction(GEFActionConstants.ALIGN_BOTTOM));
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY));
        toolBarManager.add(getAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY));

        // Size Actions
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(GEFActionConstants.MATCH_WIDTH));
        toolBarManager.add(getAction(GEFActionConstants.MATCH_HEIGHT));
        toolBarManager.add(getAction(ModelerActionConstants.AUTO_RESIZE));

        // Zoom actions
        toolBarManager.add(new Separator());
        String[] zoomStrings = new String[] {ZoomManager.FIT_ALL, ZoomManager.FIT_HEIGHT, ZoomManager.FIT_WIDTH};
        toolBarManager.add(new ZoomComboContributionItem(getPage(), zoomStrings));

        // Navigate actions
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(ModelerActionConstants.ENABLE_WRITE));
        toolBarManager.add(getAction(ModelerActionConstants.REFRESH));
        toolBarManager.add(getAction(ModelerActionConstants.PREVIOUS_DIAGRAM));
        toolBarManager.add(getAction(ModelerActionConstants.NEXT_DIAGRAM));
        toolBarManager.add(getAction(ModelerActionConstants.OPEN_PARENT_DIAGRAM));
        toolBarManager.add(getAction(ModelerActionConstants.GO_TO_ROOT_DIAGRAM));

        // Validation actions
        toolBarManager.add(new Separator());
        toolBarManager.add(getAction(ModelerActionConstants.VALIDATE));
        toolBarManager.add(getAction(ModelerActionConstants.SYNCHRONIZED_MODEL_DIAGRAM_REPORT));
    }

    /**
     * Declare additional global actions IDs. Only IDs which were not already added directly or indirectly using
     * {@link #addGlobalActionKey(String)} need to be added
     * 
     * @see org.eclipse.gef.ui.actions.ActionBarContributor#declareGlobalActionKeys()
     */
    protected void declareGlobalActionKeys()
    {
        addGlobalActionKey(ActionFactory.PRINT.getId());
        addGlobalActionKey(ActionFactory.SELECT_ALL.getId());
    }

}
