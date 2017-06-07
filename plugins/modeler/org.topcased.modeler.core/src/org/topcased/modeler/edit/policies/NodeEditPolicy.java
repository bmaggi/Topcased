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
package org.topcased.modeler.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;

/**
 * Basic Connection edit policy : Zoom support. <br>
 * <br>
 * creation : 6 juin 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public abstract class NodeEditPolicy extends GraphicalNodeEditPolicy
{
    /**
     * Feedback should be added to the scaled feedback layer.
     * 
     * @see org.eclipse.gef.editpolicies.GraphicalEditPolicy#getFeedbackLayer()
     */
    protected IFigure getFeedbackLayer()
    {
        return getLayer(LayerConstants.SCALED_FEEDBACK_LAYER);
    }

}
