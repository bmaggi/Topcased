/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.utils;

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Helper class for {@link IProgressMonitor}.
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public final class MonitorHelper
{
    /**
     * Constructor
     */
    private MonitorHelper()
    {
        // do nothing
    }

    /**
     * Check if the monitor is canceled. If it is <code>true</code>, it throws a InterruptedException
     * @param monitor the monitior to check
     * @throws InterruptedException thrown if the monitor is canceled
     */
    public static void checkCanceled(IProgressMonitor monitor) throws InterruptedException
    {
        if (monitor.isCanceled())
        {
            throw new InterruptedException();
        }
    }
}
