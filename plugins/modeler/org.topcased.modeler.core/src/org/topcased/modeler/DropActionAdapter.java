/*****************************************************************************
 * Copyright (c) 2009 atos origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emmanuel Rochefort (Atos Origin) - Initial API and implementation
 *  eperico (atos origin) emilien.perico@atosorigin.com
 *
  *****************************************************************************/
package org.topcased.modeler;

import org.eclipse.gef.EditPart;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.topcased.modeler.editor.Modeler;

public interface DropActionAdapter
{
    // Use to define the activation rules 
    public boolean isEnable(DropTargetEvent event, Transfer transfer, EditPart editPart);
    
    // The action
    public void handleDrop(Modeler modeler, Transfer transfer, EditPart editPart);
    
    // Use to specify if the action can be use in the same time than an other action
    public boolean isExclusiveDropAction();
    
    // set the value of the DropEvent
    public void updateDropTargetEvent(DropTargetEvent event);
}
