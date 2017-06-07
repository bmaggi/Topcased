/*******************************************************************************
 * Copyright (c) 2010 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Vincent Hemery (Atos Origin) - Initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.actions.preconditions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.topcased.modeler.ActionConditionChecker;
import org.topcased.modeler.dialogs.ConfirmationDialog;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.l10n.Messages;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;

/**
 * Check that the user has confirmed the deletion, either through a popup or through the corresponding preference.
 * 
 * @author vhemery
 */
public class DeleteConfirmationChecker implements ActionConditionChecker
{
    /**
     * Check that the user confirms the deletion through a popup or preference.
     * 
     * @param actionToCheck the action which must be checked.
     * @param modeler the modeler part
     * @param selection the selection on which the action is performed
     * @return true if popup is acknowledged or must not be displayed
     */
    public boolean checkCondition(Action actionToCheck, Modeler modeler, IStructuredSelection selection)
    {
        ConfirmationDialog dialog = new ConfirmationDialog(ModelerPlugin.getActiveWorkbenchShell(), Messages.getString("DeleteModelObjectAction.CmdLabel"),
                Messages.getString("DeleteModelObjectAction.ConfirmMessage"), modeler.getPreferenceStore(), ModelerPreferenceConstants.DELETE_MODEL_ACTION_CONFIRM);
        int result = dialog.open();
        return result == Window.OK;
    }
}
