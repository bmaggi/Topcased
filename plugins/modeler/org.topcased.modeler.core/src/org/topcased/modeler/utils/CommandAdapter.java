/*****************************************************************************
 * 
 * CommandAdapter
 * 
 * Copyright (c) 2008 Atos Origin
 *
 * Contributors:
 * Tristan FAURE ATOS ORIGIN INTEGRATION - tristan.faure@atosorigin.com
 * - Initial API and Implementation
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.topcased.modeler.utils;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;

/**
 * An adapter for Command interface
 * @author tfaure
 *
 */
public class CommandAdapter implements Command
{

    public boolean canExecute()
    {
        return true;
    }

    public void execute()
    {
    }

    public boolean canUndo()
    {
        return true;
    }

    public void undo()
    {
    }

    public void redo()
    {
    }

    public Collection< ? > getResult()
    {
        return Collections.emptyList();
    }

    public Collection< ? > getAffectedObjects()
    {
        return Collections.emptyList();
    }

    public String getLabel()
    {
        return "Adapter";
    }

    public String getDescription()
    {
        return "Adapter";
    }

    public void dispose()
    {
    }

    public Command chain(Command command)
    {
        return null;
    }

}
