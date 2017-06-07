/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * Copyright (c) 2012 Airbus
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies)
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Pierre Gaufillet (Airbus) - General purpose references view
 *
 * $Id: ToggleSynchronizeAction.java,v 1.2 2012/07/26 05:38:11 gaufille Exp $
 **********************************************************************/

package org.topcased.views.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.topcased.views.AnalysisView;
import org.topcased.views.internal.Activator;
import org.topcased.views.internal.Messages;

/**
 * Action that activates the synchronization of an Analysis view.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ToggleSynchronizeAction extends Action
{

    private AnalysisView analysisView;

    /**
     * Constructor
     * 
     * @param view the AnalysisView
     */
    public ToggleSynchronizeAction(AnalysisView view)
    {
        super(Messages.ToggleSynchronizeAction_Synchronize);
        setDescription(Messages.ToggleSynchronizeAction_Synchronize_description);
        setToolTipText(Messages.ToggleSynchronizeAction_Synchronize_tooltip);
        setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/elcl16/synced.gif")); //$NON-NLS-1$
        setDisabledImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/dlcl16/synced.gif")); //$NON-NLS-1$
        setChecked(view.isSynchronized());

        analysisView = view;
    }

    /**
     * Runs the action.
     */
    @Override
    public void run()
    {
        analysisView.setSynchronized(isChecked());
    }
}
