/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Anass Radouani (Atos)
 *
 *****************************************************************************/

package org.topcased.modeler.commands;

import java.util.Collection;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

/**
 * Command to unset an element from the Cross Referencer
 */
public class UnsetCrossReferencerCommand extends AbstractCommand
{

    private Collection<EObject> deletes;

    /**
     * Constructor
     * 
     * @param deletes EObject to unset
     */
    public UnsetCrossReferencerCommand(Collection<EObject> deletes)
    {
        super("Delete from cache");
        this.deletes = deletes;
    }

    public void execute()
    {
        redo();
    }

    @Override
    public boolean canUndo()
    {
        return true;
    }

    @Override
    public boolean canExecute()
    {
        return true;
    }

    @Override
    public void undo()
    {
        for (EObject e : deletes)
        {
            for (Adapter a : e.eAdapters())
            {
                if (a instanceof ECrossReferenceAdapter)
                {
                    ECrossReferenceAdapter cross = (ECrossReferenceAdapter) a;
                    cross.setTarget(e);
                }
            }
        }
    }

    public void redo()
    {
        for (EObject e : deletes)
        {
            for (Adapter a : e.eAdapters())
            {
                if (a instanceof ECrossReferenceAdapter)
                {
                    ECrossReferenceAdapter cross = (ECrossReferenceAdapter) a;
                    cross.unsetTarget(e);
                }
            }
        }
    }

}
