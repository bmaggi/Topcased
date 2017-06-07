/*****************************************************************************
 * Copyright (c) 2012 AtoS.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  N. PERANSIN (AtoS) nicolas.peransin@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.builder;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

/**
 * This class contributes to the <code>org.eclipse.core.runtime.preferences</code> extension point.
 * 
 * @author Atos (npn)
 */
public class BuilderPreferenceInitializer extends AbstractPreferenceInitializer
{

    /** Separator : works with regex */
    public static final String TAG_SEPARATOR = ",";

    public static final String TASKTAG_ACTIVE_PROP = "taskTag.active";

    public static final String TASKTAG_FLAG_PROP = "taskTag.flag";

    private static final List<String> PROPS = Arrays.asList(TASKTAG_ACTIVE_PROP, TASKTAG_FLAG_PROP);

    private boolean taskTagActive = true;

    private String taskTagFlag = "todo";

    /**
     * Initializes a preference store with default preference values for the Modeler plug-in.
     * 
     * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
     */
    public void initializeDefaultPreferences()
    {
        IPreferenceStore store = BuilderActivator.getDefault().getPreferenceStore();
        store.setDefault(TASKTAG_ACTIVE_PROP, taskTagActive);
        store.setDefault(TASKTAG_FLAG_PROP, taskTagFlag);
    }

    public static BuilderPreferenceInitializer read()
    {
        BuilderPreferenceInitializer init = new BuilderPreferenceInitializer();
        IPreferenceStore store = BuilderActivator.getDefault().getPreferenceStore();
        init.setTaskTagActive(store.getBoolean(TASKTAG_ACTIVE_PROP));
        init.setTaskTagFlag(store.getString(TASKTAG_FLAG_PROP));
        return init;
    }

    public static IPropertyChangeListener createListener(final IPropertyChangeListener delegate)
    {

        return new IPropertyChangeListener()
        {

            public void propertyChange(PropertyChangeEvent pce)
            {
                if (PROPS.contains(pce.getProperty()))
                {
                    delegate.propertyChange(pce);
                }
            }
        };
    }

    /**
     * Return the taskTagActive.
     * 
     * @return the taskTagActive
     */
    public boolean isTaskTagActive()
    {
        return taskTagActive;
    }

    /**
     * Set the taskTagActive.
     * 
     * @param taskTagActive the taskTagActive to set
     */
    public void setTaskTagActive(boolean taskTagActive)
    {
        this.taskTagActive = taskTagActive;
    }

    /**
     * Return the taskTagFlag.
     * 
     * @return the taskTagFlag
     */
    public String getTaskTagFlag()
    {
        return taskTagFlag;
    }

    /**
     * Set the taskTagFlag.
     * 
     * @param taskTagFlag the taskTagFlag to set
     */
    public void setTaskTagFlag(String taskTagFlag)
    {
        this.taskTagFlag = taskTagFlag;
    }

}
