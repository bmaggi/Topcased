/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler;

import org.eclipse.gef.RequestConstants;

/**
 * created 12 avr. 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * 
 */
public interface ModelerRequestConstants extends RequestConstants
{

    /** Indicates that a change router should be performed. */
    String REQ_CHANGE_ROUTER = "changeRouter";

    /** Indicates that a change background color should be performed. */
    String REQ_CHANGE_BACKGROUND_COLOR = "changeBackgroundColor";

    /** Indicates that a change foreground color should be performed. */
    String REQ_CHANGE_FOREGROUND_COLOR = "changeForegroundColor";

    /** Indicates that a change font should be performed. */
    String REQ_CHANGE_FONT = "changeFont";

    /** Indicates that a change diagram properties should be performed. */
    String REQ_CHANGE_DIAGRAM_PROPERTIES = "changeDiagramProperties";

    /** Indicates that a delete model object request should be performed. */
    String REQ_DELETE_MODEL_OBJECT = "deleteModelObject";

    /** Indicates that a move forward should be performed. */
    String REQ_MOVE_FORWARD = "moveForward";

    /** Indicates that a move backward should be performed. */
    String REQ_MOVE_BACKWARD = "moveBackward";

    /** Indicates that a move to front should be performed. */
    String REQ_MOVE_TO_FRONT = "moveToFront";

    /** Indicates that a move to back should be performed. */
    String REQ_MOVE_TO_BACK = "moveToBack";

    /** Indicates that an offset change on an edge object should be performed. */
    String REQ_CHANGE_EO_OFFSET = "changeEdgeObjectOffset";

    /** Indicates that an uv change on an edge object should be performed. */
    String REQ_CHANGE_EO_UV = "changeEdgeObjectUV";

    /**
     * The ID for the Autolayout request.
     */
    String REQ_AUTOLAYOUT = "org.topcased.modeler.request.autolayout"; //$NON-NLS-1$
    /**
     * The ID for the Autoresize request.
     */
    String REQ_AUTORESIZE = "org.topcased.modeler.request.autoresize"; //$NON-NLS-1$
    
    /**
     * The ID for the Restore Connections request.
     */
    String REQ_RESTORE_CONN = "org.topcased.modeler.request.restoreConnections"; //$NON-NLS-1$

    /**
     * constants for set all connector bendpoint request
     */
    String REQ_SET_ALL_BENDPOINT = "set_all_connector_bendpoint";      //$NON-NLS-1$
    
    /**
     * constants for Change Bounds Request with an explicit free location
     */
    String PROP_CONSTRAINT_FREE = "constraint_free"; //$NON-NLS-1$ 

}
