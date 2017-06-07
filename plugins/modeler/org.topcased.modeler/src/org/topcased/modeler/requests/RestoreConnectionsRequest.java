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
package org.topcased.modeler.requests;

import org.eclipse.gef.Request;
import org.topcased.modeler.ModelerRequestConstants;

/**
 * This request asks the EditPart to re-create all the incoming/outgoing
 * connections <br>
 * creation : 4 mai 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class RestoreConnectionsRequest extends Request
{

    /**
     * Constructor
     */
    public RestoreConnectionsRequest()
    {
        super(ModelerRequestConstants.REQ_RESTORE_CONN);
    }
}
