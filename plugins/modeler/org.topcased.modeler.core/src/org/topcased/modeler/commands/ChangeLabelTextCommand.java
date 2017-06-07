/*******************************************************************************
 * Copyright (c) 2005,2010 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Maxime Audrain (CS) - Give a command name - Add setter and getter on API
 *******************************************************************************/
package org.topcased.modeler.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.commands.Command;
import org.topcased.modeler.editor.TopcasedAdapterFactoryEditingDomain;
import org.topcased.modeler.l10n.Messages;

/**
 * This is a command called to change the text of a Label linked with an EStructuralFeature of an EObject<br>
 * 
 * Updated : 18 February 2010<br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ChangeLabelTextCommand extends Command
{
    private String name;

    private String oldName;

    private EObject eObject;

    private EStructuralFeature feature;

    /**
     * The Constructor
     * 
     * @param eObj the model object
     * @param feat the feature of the model object
     */
    public ChangeLabelTextCommand(EObject eObj, EStructuralFeature feat)
    {
        super(Messages.getString("ChangeLabelTextCommand.CmdLabel")); //$NON-NLS-1$
        this.eObject = eObj;
        this.feature = feat;
    }

    /**
     * @see org.eclipse.gef.commands.Command#execute()
     */
    public void execute()
    {
        redo();
    }

    /**
     * @see org.eclipse.gef.commands.Command#canExecute()
     * @return whether we can apply changes
     */
    public boolean canExecute()
    {
        boolean result = !TopcasedAdapterFactoryEditingDomain.isEObjectReadOnly(eObject); 
        if (name != null)
        {
            return result && true;
        }
        else
        {
            name = oldName;
            return result && false;
        }
    }

    /**
     * Sets the new name
     * 
     * @param newName the new name
     */
    public void setName(String newName)
    {
        this.name = newName;
    }

    /**
     * Gets the new name
     * 
     * @return string the new name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the old name
     * 
     * @param string the old name
     */
    public void setOldName(String string)
    {
        oldName = string;
    }

    /**
     * Gets the old name
     * 
     * @return string the old name
     */
    public String getOldName()
    {
        return oldName;
    }

    /**
     * Gets the model object
     * 
     * @return eobject the model object
     */
    public EObject getEObject()
    {
        return eObject;
    }

    /**
     * @see org.eclipse.gef.commands.Command#redo()
     */
    public void redo()
    {
        eObject.eSet(feature, name);
    }

    /**
     * @see org.eclipse.gef.commands.Command#undo()
     */
    public void undo()
    {
        eObject.eSet(feature, oldName);
    }

}
