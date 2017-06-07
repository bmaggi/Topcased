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
package org.topcased.modeler.commands;

import java.util.EventObject;

import org.eclipse.gef.commands.CommandStackListener;

/**
 * Adapts an
 * {@link org.eclipse.emf.common.command.CommandStackListener EMF Command Stack Listener}
 * to a
 * {@link org.eclipse.gef.commands.CommandStackListener GEF Command Stack Listener}.
 * 
 * Creation : 21 fev. 2006
 *  
 * @author aarong, <a href="mailto:jacques.lescot@anyware-tech.com">Jacques
 *         LESCOT</a>
 */
public class EMFtoGEFCommandStackListenerWrapper implements CommandStackListener
{
    private final org.eclipse.emf.common.command.CommandStackListener emfListener;

    /**
     * Constructor
     * 
     * @param commandStackListener the EMF CommandStackListener
     */
    public EMFtoGEFCommandStackListenerWrapper(
            final org.eclipse.emf.common.command.CommandStackListener commandStackListener)
    {
        emfListener = commandStackListener;
    }

    /**
     * @see org.eclipse.gef.commands.CommandStackListener#commandStackChanged(java.util.EventObject)
     */
    public void commandStackChanged(final EventObject event)
    {
        emfListener.commandStackChanged(event);
    }
}
