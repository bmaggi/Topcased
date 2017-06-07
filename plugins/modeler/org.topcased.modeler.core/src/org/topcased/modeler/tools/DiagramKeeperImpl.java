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
 *  Thibault Landré (Atos Origin) thibault.landre@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.tools;

import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.utils.Utils;

public class DiagramKeeperImpl implements DiagramKeeper
{
    /**
     * {@inheritDoc}
     */
    public boolean keep(GraphElement movedElement)
    {
        return  getEObject(movedElement) != null;
    }

    /**
     * {@inheritDoc}
     */
    public final EObject getEObject(GraphElement movedElement)
    {
        return Utils.getElement(movedElement);
    }

}
