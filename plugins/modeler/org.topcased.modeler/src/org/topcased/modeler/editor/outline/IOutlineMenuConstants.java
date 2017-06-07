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

package org.topcased.modeler.editor.outline;

import org.eclipse.ui.IWorkbenchActionConstants;

/**
 * This interface contains the references of the constants used in the context menu
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public interface IOutlineMenuConstants
{
    /** Menu Group for the creation actions */
    String NEW_GROUP = "new";
    
    /** Menu Group for the edit actions */
    String EDIT_GROUP = "edit";
    
    /** Menu Group for the first set of extended actions */
    String ADDITIONS_GROUP = IWorkbenchActionConstants.MB_ADDITIONS;
    
    /** Menu Group for the properties actions */
    String PROPERTIES_GROUP = "properties";
    
    /** Menu Group for the edit actions */
    String ADDITIONS_END_GROUP = "additions-end";
}
