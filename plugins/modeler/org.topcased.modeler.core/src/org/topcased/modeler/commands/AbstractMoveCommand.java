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

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphElement;

/**
 * A class defining an abstract command to change the visual plan of a graph element. It offers methods to advance, to
 * move back or to put on the foreground or the background.<br/>
 * 
 * Creation : 11 October 2005<br>
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 */
public abstract class AbstractMoveCommand extends Command
{
    /* The element to move through diagram plans */
    protected GraphElement element;

    private int initialPosition;

    /**
     * Constructor.
     * Cannot be instantiated since it is an abstract class.
     * 
     * @param element the element to move through diagram plans
     */
    protected AbstractMoveCommand(GraphElement element)
    {
        this.element = element;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    @Override
    public void execute()
    {
        initialPosition = getPosition();
        if (initialPosition != -1)
        {
            redo();
        }
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    @Override
    public void undo()
    {
        move(initialPosition - getPosition());
    }

    /**
     * Move forward the current graph element in the diagram plans.<br/>
     */
    protected void moveForward()
    {
        move(+1);
    }

    /**
     * Move backward the current graph element in the diagram plans.<br/>
     */
    protected void moveBackward()
    {
        move(-1);
    }

    /**
     * Move to front the current graph element in the diagram plans.<br/>
     */
    protected void moveToFront()
    {
        move(Integer.MAX_VALUE);
    }

    /**
     * Move to back the current graph element in the diagram plans.<br/>
     */
    protected void moveToBack()
    {
        move(Integer.MIN_VALUE);
    }

    /**
     * Move forward or move backward the current graph element. The level represents the number (positive or negative)
     * of plans that the element must go through.<br/>
     * If level equals Integer.MAX_VALUE, the element will be move to front. If the level equals Interger.MIN_VALUE, the
     * element will be move to back.
     * 
     * @param level the number of plans to move
     */
    protected void move(int level)
    {
        if (element != null)
        {
            GraphElement parent = element.getContainer();
            if (parent != null)
            {
                EList<DiagramElement> children = parent.getContained();
                int actualPosition = getPosition();
                if (actualPosition != -1)
                {
                    int futurePosition = actualPosition;
                    // Move to front
                    if (level == Integer.MAX_VALUE)
                    {
                        futurePosition = children.size() - 1;
                    }
                    // Move to back
                    else if (level == Integer.MIN_VALUE)
                    {
                        futurePosition = 0;
                    }
                    else
                    {
                        futurePosition = actualPosition + level;
                    }
                    try
                    {
                        children.move(futurePosition, actualPosition);
                    }
                    catch (IndexOutOfBoundsException ioob)
                    {
                        // The graph element cannot be moved, so do nothing
                    }
                }
            }
        }
    }

    protected int getPosition()
    {
        if (element != null)
        {
            GraphElement parent = element.getContainer();
            if (parent != null)
            {
                EList<DiagramElement> children = parent.getContained();
                return children.indexOf(element);
            }
        }
        return -1;
    }
}
