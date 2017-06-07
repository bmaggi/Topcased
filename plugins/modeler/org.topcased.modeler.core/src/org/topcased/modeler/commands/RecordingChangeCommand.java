/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.commands;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gef.commands.Command;

/**
 * This command is based on the EMF ChangeRecorder. You just have to implement
 * the doExecute method to manage undo/redo.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public abstract class RecordingChangeCommand extends Command
{
    private Set<? extends Notifier> notifiers;

    private ChangeRecorder recorder;

    private ChangeDescription change;

    /**
     * Constructor
     * @param resource The Resource to listen
     */
    public RecordingChangeCommand(Resource resource)
    {
        super("Recording Change Command");
        recorder = new ChangeRecorder();
        notifiers = Collections.singleton(resource);
    }
    
    /**
     * Constructor
     * @param resourceSet The Resource to listen
     */
    public RecordingChangeCommand(ResourceSet resourceSet)
    {
        super("Recording Change Command");
        recorder = new ChangeRecorder();
        notifiers = Collections.singleton(resourceSet);
    }

    /**
     * I run the runnable when I execute the first time.
     */
    public void execute()
    {
        try
        {
            recorder.beginRecording(notifiers);
            doExecute();
        }
        finally
        {
            change = recorder.endRecording();
        }
    }

    /**
     * <b>Method to implement : </b> execute the modifications on the model.
     */
    protected abstract void doExecute();

    /**
     * Applies (undoes) changes recorded previously, recording the new changes
     * meanwhile.
     */
    private void applyChanges()
    {
        try
        {
            recorder.beginRecording(notifiers);
            change.apply();
        }
        finally
        {
            change = recorder.endRecording();
        }
    }

    /**
     * I can undo if I have recorded any changes previously.
     */
    public boolean canUndo()
    {
        return change != null;
    }

    /**
     * Undoes by applying recorded changes.
     */
    public void undo()
    {
        applyChanges();
    }

    /**
     * Redoes by applying changes recorded in the last undo.
     */
    public void redo()
    {
        applyChanges();
    }

    /**
     * @see org.eclipse.gef.commands.Command#dispose()
     */
    public void dispose()
    {
        change = null;
        recorder = null;
        notifiers = null;
    }
}