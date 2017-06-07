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
 * A collection of Roles. Each identifier is used to key the EditPolicy.
 * Creation : 03 april 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public interface ModelerEditPolicyConstants
{
    /** The key used to install a <i>Delete Model Object</i> EditPolicy. */
    String DELETE_MODEL_OBJECT_EDITPOLICY = "Delete Model Object EditPolicy";

    /** The key used to install a <i>Delete Model Object</i> EditPolicy. */
    String CHANGE_DIAGRAM_PROPERTIES_EDITPOLICY = "Change Diagram Properties";

    /** The key used to install a <i>Resizable</i> EditPolicy. */
    String RESIZABLE_EDITPOLICY = "Resizable EditPolicy";

    /** The key used to install a <i>Change Background Color</i> EditPolicy. */
    String CHANGE_BACKGROUND_COLOR_EDITPOLICY = "Change Background Color EditPolicy";

    /** The key used to install a <i>Change Background Color</i> EditPolicy. */
    String CHANGE_FOREGROUND_COLOR_EDITPOLICY = "Change Foreground Color EditPolicy";

    /** The key used to install a <i>Change Font</i> EditPolicy. */
    String CHANGE_FONT_EDITPOLICY = "Change Font EditPolicy";

    /** The key used to install a <i>Change Router</i> EditPolicy. */
    String CHANGE_ROUTER = "Change Router EditPolicy";

    /** The key used to install a <i>Restore</i> EditPolicy. */
    String RESTORE_EDITPOLICY = "Restore objects EditPolicy";

    /** The key used to install a <i>Move Forward</i> EditPolicy. */
    String MOVE_PLANS = "Move Plans";

    /** The key used to install an <i>Edge Object Offset</i> EditPolicy. */
    String EDGE_OBJECTS_OFFSET_EDITPOLICY = "Edge Object Offset Edit Policy";

    /** The key used to install an <i>Edge Object UV</i> EditPolicy. */
    String EDGE_OBJECTS_UV_EDITPOLICY = "Edge Object UV Edit Policy";
    
    /** The key used to install an <i>Snap Feedback</i> EditPolicy. */
    String SNAP_FEEDBACK_EDITPOLICY = "Snap Feedback";
    
    /** The key used to install an <i>Unmovable shape</i> EditPolicy. */
    String UNMOVABLE_SHAPE_EDITPOLICY = "Unmovable Shape Edit Policy";
}
