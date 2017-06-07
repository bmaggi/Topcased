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
package org.topcased.modeler.commands;

import org.topcased.modeler.di.model.GraphElement;

/**
 * A class defining a command to move backward a graph element.<br/> Creation :
 * 11 oct. 2005
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 */
public class MoveBackwardCommand extends AbstractMoveCommand
{
    public MoveBackwardCommand(GraphElement element)
    {
        super(element);
        setLabel("Move backward");
    }

    public void redo()
    {
        moveBackward();
    }
}
