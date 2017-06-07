/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.commands;

import org.eclipse.gef.commands.Command;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.util.DIUtils;

/**
 * That command is used to change a Property of a DiagramElement<br>
 * Creation 25 oct. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ChangeDiagramElementPropertyCommand extends Command
{
    private DiagramElement diagramElement;

    private String propertyKey;

    private String oldPropertyValue;

    private String newPropertyValue;

    /**
     * Constructor
     * 
     * @param diagElt the DiagramElement
     * @param propKey the Property Key used to identify it between all the
     *        available properties of the DiagramElement
     * @param newPropValue the new Property value
     */
    public ChangeDiagramElementPropertyCommand(DiagramElement diagElt, String propKey, String newPropValue)
    {
        super("Change Diagram Orientation");
        this.diagramElement = diagElt;
        this.propertyKey = propKey;
        this.newPropertyValue = newPropValue;

    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     */
    public boolean canExecute()
    {
        return diagramElement != null;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        oldPropertyValue = DIUtils.getPropertyValue(diagramElement, propertyKey);

        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        DIUtils.setProperty(diagramElement, propertyKey, newPropertyValue);
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        DIUtils.setProperty(diagramElement, propertyKey, oldPropertyValue);
    }

}
