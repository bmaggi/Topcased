/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Nicolas Lalevee (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.listeners;

import org.eclipse.emf.common.notify.Notification;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramInterchangePackage;

/**
 * Domain specific listener for Diagram.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public abstract class DiagramListener extends GraphNodeListener
{
    /**
     * @see org.topcased.modeler.listeners.UIAdapterImpl#safeNotifyChanged(org.eclipse.emf.common.notify.Notification)
     */
    protected void safeNotifyChanged(Notification msg)
    {
        super.safeNotifyChanged(msg);

        Object notifier = msg.getNotifier();

        if (notifier instanceof Diagram)
        {

            switch (msg.getFeatureID(Diagram.class))
            {
                case DiagramInterchangePackage.DIAGRAM__NAME:
                    handleNameChanged();
                    break;
            }
        }
    }

    protected abstract void handleNameChanged();

}
