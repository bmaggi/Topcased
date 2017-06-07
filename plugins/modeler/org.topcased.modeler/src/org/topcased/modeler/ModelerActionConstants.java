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

/**
 * Identifies new Action constants Creation : 25 mars 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public interface ModelerActionConstants
{
    /** The ID for the change background color action. */
    String CHANGE_BACKGROUND_COLOR = "changeBackgroundColor";

    /** The ID for the change foreground color action. */
    String CHANGE_FOREGROUND_COLOR = "changeForegroundColor";

    /** The ID for the change font action. */
    String CHANGE_FONT = "changeFont";

    /** The ID for the change router action. */
    String CHANGE_ROUTER = "changeRouter";

    /** The ID for the change diagram properties action. */
    String CHANGE_DIAGRAM_PROPERTIES = "changeDiagramProperties";

    /** The ID for deleting the model object action. */
    String DELETE_MODEL_OBJECT = "deleteModelObject";

    /** The ID for the Topcased Show Properties view action. */
    String SHOW_PROPERTIES = "org.topcased.modeler.actions.showpropertiesview"; //$NON-NLS-1$

    /** The ID for the Topcased Show Documentation view action. */
    String SHOW_DOCUMENTATION = "org.topcased.modeler.actions.showdocview"; //$NON-NLS-1$

    /** The ID for the Export to file action. */
    String EXPORT_FILE = "org.topcased.modeler.actions.export2file"; //$NON-NLS-1$

    /** The ID for the refresh action. */
    String REFRESH = "org.topcased.modeler.refresh"; //$NON-NLS-1$

    /** The ID for the enable write action. */
    String ENABLE_WRITE = "org.topcased.modeler.enablewrite"; //$NON-NLS-1$

    /** The ID for the navigation to the parent diagram action. */
    String OPEN_PARENT_DIAGRAM = "org.topcased.modeler.openParentDiagram"; //$NON-NLS-1$

    /** The ID for the navigation to the root diagram action. */
    String GO_TO_ROOT_DIAGRAM = "org.topcased.modeler.goToRootDiagram"; //$NON-NLS-1$

    /** The ID for the previous diagram action. */
    String PREVIOUS_DIAGRAM = "org.topcased.modeler.previousDiagram"; //$NON-NLS-1$

    /** The ID for the next diagram action. */
    String NEXT_DIAGRAM = "org.topcased.modeler.nextDiagram"; //$NON-NLS-1$

    /** The ID for the move forward action. */
    String MOVE_FORWARD = "moveForward";

    /** The ID for the move backward action. */
    String MOVE_BACKWARD = "moveBackward";

    /** The ID for the move to front action. */
    String MOVE_TO_FRONT = "moveToFront";

    /** The ID for the move to back action. */
    String MOVE_TO_BACK = "moveToBack";

    /** The ID for the auto resize action. */
    String AUTO_RESIZE = "autoResize";

    /** The ID for the restore connection action */
    String RESTORE_CONNECTIONS = "restoreConnections";

    /** The ID for the validate action. */
    String VALIDATE = "org.topcased.modeler.validation"; //$NON-NLS-1$

    /** The ID for the report of synchronization problems between model and diagram action. */
    String SYNCHRONIZED_MODEL_DIAGRAM_REPORT = "org.topcased.modeler.synchronizedModelDiagramReport"; //$NON-NLS-1$

    /** The ID for the select all action. */
    String SELECT_ALL = "selectAll"; //$NON-NLS-1$

    /** The ID for the select all shapes action. */
    String SELECT_ALL_NODES = "selectAllShapes"; // NON-NLS-1$

    /** The ID for the select all edges action. */
    String SELECT_ALL_CONNECTIONS = "selectAllEdges"; // NON-NLS-1$

    /** The ID for the select all edges action. */
    String AUTO_RESIZE_PAGE = "autoResizePage"; // NON-NLS-1$

}
