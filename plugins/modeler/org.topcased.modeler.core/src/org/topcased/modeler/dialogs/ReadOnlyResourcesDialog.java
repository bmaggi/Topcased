/*****************************************************************************
 * Copyright (c) 2010 AIRBUS FRANCE.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos Origin) - initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.dialogs;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.l10n.Messages;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;

/**
 * A JFace dialog used to show information on read-only files to the end user. It shows when some resources become
 * read-only or when they are no longer read-only. It can also be used to show resources which are initially read-only.<br>
 * This dialog is able to store the user's choice not to display it again into a preference store.<br>
 * 
 * @author vhemery
 */
public class ReadOnlyResourcesDialog extends InformationDialog
{
    /** The title of the dialog */
    private static final String TITLE = Messages.getString("ReadOnlyResourcesDialog.Title");//$NON-NLS-1$

    /** The intro message for read only resource */
    private static final String READ_ONLY_RESOURCE = Messages.getString("ReadOnlyResourcesDialog.ReadOnlyResource");//$NON-NLS-1$

    /** The intro message for read only resources */
    private static final String READ_ONLY_RESOURCES = Messages.getString("ReadOnlyResourcesDialog.ReadOnlyResources");//$NON-NLS-1$

    /** The intro message for read only resource */
    private static final String NEW_READ_ONLY_RESOURCE = Messages.getString("ReadOnlyResourcesDialog.NewReadOnlyResource");//$NON-NLS-1$

    /** The intro message for read only resources */
    private static final String NEW_READ_ONLY_RESOURCES = Messages.getString("ReadOnlyResourcesDialog.NewReadOnlyResources");//$NON-NLS-1$

    /** The intro message for non read only resource */
    private static final String NOT_READ_ONLY_RESOURCE = Messages.getString("ReadOnlyResourcesDialog.OldReadOnlyResource");//$NON-NLS-1$

    /** The intro message for non read only resources */
    private static final String NOT_READ_ONLY_RESOURCES = Messages.getString("ReadOnlyResourcesDialog.OldReadOnlyResources");//$NON-NLS-1$

    /** The message for explaining how to distinguish read only resources */
    private static final String READ_ONLY_RECOGNITION = Messages.getString("ReadOnlyResourcesDialog.ReadOnlyRecognition");//$NON-NLS-1$

    /** The line break */
    private static final String LINE_BREAK = System.getProperty("line.separator");//$NON-NLS-1$

    /** The prefix to display before a resource file name */
    private static final String RESOURCE_PREFIX = LINE_BREAK + " - ";

    /** Whether there are effective differences or initial read-only resources which shall be displayed */
    private boolean areThereElementsToDisplay;

    /**
     * Create a new dialog. (in case of initial report)
     * 
     * @param parentShell the parent shell of the dialog
     * @param readOnlyResources the names of initial read-only resources
     */
    public ReadOnlyResourcesDialog(Shell parentShell, List<String> readOnlyResources)
    {
        super(parentShell, TITLE, getMessage(readOnlyResources), ModelerPlugin.getDefault().getPreferenceStore(), ModelerPreferenceConstants.PREFERENCE_FOR_READ_ONLY_RESOURCES_INITIAL);
        areThereElementsToDisplay = readOnlyResources != null && !readOnlyResources.isEmpty();
    }

    /**
     * Create a new dialog. (in case of difference report)
     * 
     * @param parentShell the parent shell of the dialog
     * @param differencesInReadOnlyResources a map with the names of newly read-only resources for True key and the
     *        names of no longer read-only resources for False key
     */
    public ReadOnlyResourcesDialog(Shell parentShell, Map<Boolean, List<String>> differencesInReadOnlyResources)
    {
        super(parentShell, TITLE, getMessage(differencesInReadOnlyResources), ModelerPlugin.getDefault().getPreferenceStore(), ModelerPreferenceConstants.PREFERENCE_FOR_READ_ONLY_RESOURCES_CHANGE);
        areThereElementsToDisplay = checkDisplay(differencesInReadOnlyResources);
    }

    /**
     * Check whether there is actually something to display. (in case of difference report)
     * 
     * @param differencesInReadOnlyResources the differences in read-only files lists
     * @return true if there are some differences
     */
    private boolean checkDisplay(Map<Boolean, List<String>> differencesInReadOnlyResources)
    {
        List<String> readOnlyResources = differencesInReadOnlyResources.get(Boolean.TRUE);
        List<String> writeableResources = differencesInReadOnlyResources.get(Boolean.FALSE);
        return (readOnlyResources != null && !readOnlyResources.isEmpty()) || (writeableResources != null && !writeableResources.isEmpty());
    }

    /**
     * Get the message to display to the user. (in case of initial report)
     * 
     * @param readOnlyResources read-only files lists
     * @return the message to display
     */
    private static String getMessage(List<String> readOnlyResources)
    {
        StringBuffer messageToDisplay = new StringBuffer();
        if (readOnlyResources != null && !readOnlyResources.isEmpty())
        {
            if (readOnlyResources.size() == 1)
            {
                messageToDisplay.append(READ_ONLY_RESOURCE);
            }
            else
            {
                messageToDisplay.append(READ_ONLY_RESOURCES);
            }
            for (String filename : readOnlyResources)
            {
                messageToDisplay.append(RESOURCE_PREFIX);
                messageToDisplay.append(filename);
            }
        }
        messageToDisplay.append(LINE_BREAK);
        messageToDisplay.append(LINE_BREAK);
        messageToDisplay.append(READ_ONLY_RECOGNITION);
        return messageToDisplay.toString();
    }

    /**
     * Get the message to display to the user. (in case of difference report)
     * 
     * @param differencesInReadOnlyResources the differences in read-only files lists
     * @return the message to display
     */
    private static String getMessage(Map<Boolean, List<String>> differencesInReadOnlyResources)
    {
        StringBuffer messageToDisplay = new StringBuffer();
        List<String> readOnlyResources = differencesInReadOnlyResources.get(Boolean.TRUE);
        List<String> writeableResources = differencesInReadOnlyResources.get(Boolean.FALSE);
        if (readOnlyResources != null && !readOnlyResources.isEmpty())
        {
            if (readOnlyResources.size() == 1)
            {
                messageToDisplay.append(NEW_READ_ONLY_RESOURCE);
            }
            else
            {
                messageToDisplay.append(NEW_READ_ONLY_RESOURCES);
            }
            for (String filename : readOnlyResources)
            {
                messageToDisplay.append(RESOURCE_PREFIX);
                messageToDisplay.append(filename);
            }
        }
        if (writeableResources != null && !writeableResources.isEmpty())
        {
            if (messageToDisplay.length() > 0)
            {
                messageToDisplay.append(LINE_BREAK);
                messageToDisplay.append(LINE_BREAK);
            }
            if (writeableResources.size() == 1)
            {
                messageToDisplay.append(NOT_READ_ONLY_RESOURCE);
            }
            else
            {
                messageToDisplay.append(NOT_READ_ONLY_RESOURCES);
            }
            for (String filename : writeableResources)
            {
                messageToDisplay.append(RESOURCE_PREFIX);
                messageToDisplay.append(filename);
            }
        }
        messageToDisplay.append(LINE_BREAK);
        messageToDisplay.append(LINE_BREAK);
        messageToDisplay.append(READ_ONLY_RECOGNITION);
        return messageToDisplay.toString();
    }

    /**
     * Open the window if necessary
     * 
     * @return Window.OK once the informations is acknowledged
     * @see org.eclipse.jface.window.Window#open()
     */
    @Override
    public int open()
    {
        if (areThereElementsToDisplay)
        {
            return super.open();
        }
        else
        {
            return Window.OK;
        }
    }

}
