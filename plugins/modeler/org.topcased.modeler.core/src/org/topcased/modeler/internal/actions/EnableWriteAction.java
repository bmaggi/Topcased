/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.internal.actions;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.dialogs.ConfirmationDialog;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.l10n.Messages;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.utils.ResourceUtils;

/**
 * This action tries to get write access for a currently read-only editor.
 * 
 * @author mvelten
 * 
 */
public class EnableWriteAction extends WorkbenchPartAction
{
    public EnableWriteAction(IWorkbenchPart part)
    {
        super(part);
    }

    /**
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
     */
    @Override
    protected boolean calculateEnabled()
    {
        Modeler modeler = (Modeler) getWorkbenchPart();
        if (modeler != null && modeler.isReadOnly())
        {
            return true;
        }
        return false;
    }

    /**
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    @Override
    protected void init()
    {
        setId(ModelerActionConstants.ENABLE_WRITE);
        setText("Enable write on the current editor");
    }

    /**
     * @see org.eclipse.jface.action.IAction#run()
     */
    @Override
    public void run()
    {
        Modeler currentModeler = (Modeler) getWorkbenchPart();

        List<Modeler> futureReadOnlyModelers = ResourceUtils.getConflictingWritingModelers(currentModeler);

        // ask the user if he really wants to switch other editors in read-only mode
        if (futureReadOnlyModelers.isEmpty() || checkReadOnlyChanges(currentModeler, futureReadOnlyModelers))
        {
            for (Modeler futureReadOnlyModeler : futureReadOnlyModelers)
            {
                // ask to the user if he wants to save his changes, otherwise discard them by reloading resources
                if (futureReadOnlyModeler.isDirty())
                {
                    Boolean check = checkSaveModifications(futureReadOnlyModeler);
                    if (Boolean.TRUE.equals(check))
                    {
                        futureReadOnlyModeler.doSave(new NullProgressMonitor());
                    }
                    else if (Boolean.FALSE.equals(check))
                    {
                        futureReadOnlyModeler = futureReadOnlyModeler.rejectModifications();
                    }
                    else
                    {
                        // cancel everything
                        return;
                    }
                }
                // release write tokens
                futureReadOnlyModeler.switchToReadMode();
            }

            // reload the modified resources if the user acknowledges
            List<String> modifiedResources = currentModeler.getOutdatedResourcesAsString();
            if (modifiedResources != null && !modifiedResources.isEmpty())
            {
                if (checkRefreshResources(currentModeler, modifiedResources))
                {
                    currentModeler = currentModeler.reloadResources();
                }
                else
                {
                    // cancel everything
                    return;
                }
            }

            // take write token
            currentModeler.switchToWriteMode();
            // ensure correct modeler is active
            currentModeler.getSite().getPage().activate(currentModeler);
            refresh();
        }
    }

    /**
     * Check whether the user agrees on reloading content of out of date editor
     * 
     * @param currentModeler modeler which is switching to write mode
     * @param modifiedResources resources which have to be reloaded
     * @return true if user agrees on reloading
     */
    private static boolean checkRefreshResources(Modeler currentModeler, List<String> modifiedResources)
    {
        String title = Messages.getString("EnableWriteAction.RefreshResourcesTitle");
        String message = Messages.getString("EnableWriteAction.RefreshResources");
        message = NLS.bind(message, currentModeler.getTitle());
        for (String modifiedResource : modifiedResources)
        {
            message += System.getProperty("line.separator") + modifiedResource;
        }
        ConfirmationDialog dialog = new ConfirmationDialog(ModelerPlugin.getActiveWorkbenchShell(), title, message, ModelerPlugin.getDefault().getPreferenceStore(),
                ModelerPreferenceConstants.REFRESH_RESOURCES_ACTION_CONFIRM);
        return dialog.open() == Window.OK;
    }

    /**
     * Check whether the user agrees on saving content of dirty editor
     * 
     * @param futureReadOnlyModeler modeler which is switching to read mode
     * @return Boolean.TRUE is saving, Boolean.FALSE if modifications must be rejected, null to cancel
     */
    private static Boolean checkSaveModifications(Modeler futureReadOnlyModeler)
    {
        String message = Messages.getString("EnableWriteAction.SaveChanges");
        String title = Messages.getString("EnableWriteAction.SaveChangesTitle");
        message = NLS.bind(message, futureReadOnlyModeler.getTitle());
        String[] dialogButtonLabels = new String[] {IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL, IDialogConstants.CANCEL_LABEL};
        MessageDialog dialog = new MessageDialog(ModelerPlugin.getActiveWorkbenchShell(), title, null, message, MessageDialog.QUESTION_WITH_CANCEL, dialogButtonLabels, 0);
        switch (dialog.open())
        {
            case 0:
                return Boolean.TRUE;
            case 1:
                return Boolean.FALSE;
            case 2:
                return null;
        }
        return null;
    }

    /**
     * Check whether the user agrees to switch writing editors to read mode
     * 
     * @param currentModeler the modeler which is aimed at switching to write mode
     * @param futureReadOnlyModelers modelers which have to switch to read mode
     * @return true if user agrees
     */
    private static boolean checkReadOnlyChanges(Modeler currentModeler, List<Modeler> futureReadOnlyModelers)
    {
        String message = null;
        if (futureReadOnlyModelers.size() == 1)
        {
            message = Messages.getString("EnableWriteAction.SwitchToReadOnlySingle");
            message = NLS.bind(message, futureReadOnlyModelers.get(0).getTitle());
        }
        else
        {
            message = Messages.getString("EnableWriteAction.SwitchToReadOnlyMultiple");
            for (Modeler m : futureReadOnlyModelers)
            {
                message.concat(System.getProperty("line.separator"));
                message.concat(m.getTitle());
            }
        }

        ConfirmationDialog dialog = new ConfirmationDialog(ModelerPlugin.getActiveWorkbenchShell(), "", message, ModelerPlugin.getDefault().getPreferenceStore(),
                ModelerPreferenceConstants.READ_ONLY_CHANGES_ACTION_CONFIRM);
        return dialog.open() == Window.OK;
    }
}
