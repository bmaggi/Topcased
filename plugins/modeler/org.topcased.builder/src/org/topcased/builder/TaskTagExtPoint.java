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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;

/**
 * Reading extension point.
 * 
 * @author Atos (npn)
 */
public class TaskTagExtPoint
{

    public static final String TAG_EXT_NAME = "taskTagExtensions";

    public static final String CLASS_PROP = "class";

    public static final String ID_PROP = "id";

    IConfigurationElement conf;

    String id;

    List<String> preempts = Collections.emptyList();

    TaskTagExtPoint(IConfigurationElement e)
    {
        conf = e;
        id = e.getAttribute(ID_PROP);
        if (conf.getChildren().length > 0)
        {
            preempts = new ArrayList<String>();
            for (IConfigurationElement preempt : conf.getChildren())
            {
                preempts.add(preempt.getAttribute(ID_PROP));
            }
        }
    }

    public static List<ITaskTagExtension> readConfiguration(IExtensionRegistry reg)
    {
        IConfigurationElement[] elements = reg.getConfigurationElementsFor(BuilderActivator.getDefault().getId(), TAG_EXT_NAME);
        List<TaskTagExtPoint> exts = new ArrayList<TaskTagExtPoint>();
        for (IConfigurationElement e : elements)
        {
            exts.add(new TaskTagExtPoint(e));
        }

        for (TaskTagExtPoint ext : new ArrayList<TaskTagExtPoint>(exts))
        {
            for (String preempt : ext.preempts)
            {
                // Remove all
                for (int i = getIndexById(preempt, exts); i != -1; i = getIndexById(preempt, exts))
                {
                    exts.remove(i);
                }
            }
        }

        List<ITaskTagExtension> handlers = new ArrayList<ITaskTagExtension>(exts.size());
        for (TaskTagExtPoint ext : exts)
        {
            try
            {
                handlers.add((ITaskTagExtension) ext.conf.createExecutableExtension("class"));
            }
            catch (CoreException e)
            {
                BuilderActivator.getDefault().log(e);
            }
        }
        return handlers;
    }

    public static int getIndexById(String id, List<TaskTagExtPoint> exts)
    {
        if ((id == null) || (id.length() == 0))
        {
            return -1;
        }
        for (int i = 0; i < exts.size(); i++)
        {
            if (id.equals(exts.get(i).id))
            {
                return i;
            }
        }
        return -1;
    }
}