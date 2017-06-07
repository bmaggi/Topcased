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

package org.topcased.modeler.edit.policies;

import org.eclipse.gef.requests.ChangeBoundsRequest;

/**
 * This EditPolicy overrides the behavior of the
 * {@link org.eclipse.gef.editpolicies.NonResizableEditPolicy} class and removes
 * the feedback drawing : this drawing is delegated to the layoutEditPolicy of
 * the container.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class NonResizableEditPolicy extends org.eclipse.gef.editpolicies.NonResizableEditPolicy
{
    /**
     * @see org.eclipse.gef.editpolicies.NonResizableEditPolicy#showChangeBoundsFeedback(org.eclipse.gef.requests.ChangeBoundsRequest)
     */
    protected void showChangeBoundsFeedback(ChangeBoundsRequest request)
    {
        // Do nothing
        // Feedback is delegated to the container layout edit policy
    }
}
