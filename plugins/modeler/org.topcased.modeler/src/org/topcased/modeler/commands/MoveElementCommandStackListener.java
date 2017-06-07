/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Maxime Leray (Atos Origin) maxime.leray@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.commands;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DragAndDropCommand;
import org.eclipse.gef.commands.CommandStackEvent;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.outline.OutlineToOutlineDropAdapter;
import org.topcased.modeler.utils.Utils;

/**
 * The listener interface for receiving moveElementCommandStack events. The class that is interested in processing a
 * commandStack event implements this interface, and the object created with that class is registered with a component
 * using the component's <code>addMoveElementCommandStackListener<code> method. When
 * the moveElementCommandStack event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see CommandStackEvent
 */
public class MoveElementCommandStackListener implements IDisposableCommandStackEventListener
{

    /** The commands. */
    private final Map<Command, CompoundCommand> commandMap = new HashMap<Command, CompoundCommand>();

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.commands.CommandStackEventListener#stackChanged(org.eclipse.gef.commands.CommandStackEvent)
     */
    public void stackChanged(CommandStackEvent event)
    {
        List<Object> commands = CommandStack.getCommands(event.getCommand(), DragAndDropCommand.class, true);
        for (Object o : commands)
        {
            if (o instanceof DragAndDropCommand)
            {
                DragAndDropCommand dragAndDrop = (DragAndDropCommand) o;
                switch (event.getDetail())
                {
                    case CommandStack.PRE_EXECUTE:
                        execute(dragAndDrop);
                        break;
                    case CommandStack.PRE_REDO:
                        redo(dragAndDrop);
                        break;
                    case CommandStack.POST_REDO:
                        postRedo(dragAndDrop);
                        break;
                    case CommandStack.POST_UNDO:
                        undo(dragAndDrop);
                        break;
                }
            }
        }
    }

    /**
     * Undo.
     * 
     * @param dragAndDrop the drag and drop
     */
    private void undo(DragAndDropCommand dragAndDrop)
    {
        if (commandMap.containsKey(dragAndDrop))
        {
            CompoundCommand compoundCmd = commandMap.get(dragAndDrop);
            compoundCmd.undo();
        }

    }

    /**
     * Redo.
     * 
     * @param dragAndDrop the drag and drop
     */
    private void postRedo(DragAndDropCommand dragAndDrop)
    {
        if (commandMap.containsKey(dragAndDrop))
        {
            new RefreshDiagramCommand().execute();
        }
    }

    /**
     * Redo.
     * 
     * @param dragAndDrop the drag and drop
     */
    private void redo(DragAndDropCommand dragAndDrop)
    {
        if (commandMap.containsKey(dragAndDrop))
        {
            CompoundCommand compoundCmd = commandMap.get(dragAndDrop);
            compoundCmd.redo();
        }
    }

    /**
     * Execute.
     * 
     * @param dragAndDrop the drag and drop
     */
    private void execute(DragAndDropCommand dragAndDrop)
    {
        Collection< ? > target = dragAndDrop.getCollection();
        if (target != null)
        {
            Map<GraphElement, Diagram> impactedDiagrams = new HashMap<GraphElement, Diagram>();
            for (Iterator< ? > it = target.iterator(); it.hasNext();)
            {
                Object object = (Object) it.next();
                if (object instanceof EObject)
                {
                    impactedDiagrams.putAll(OutlineToOutlineDropAdapter.getImpactedDiagrams((EObject) object));
                }
            }
            final CompoundCommand compoundCommand = new CompoundCommand("Remove graph nodes");
            compoundCommand.append(new RefreshDiagramCommand());
            for (GraphElement g : impactedDiagrams.keySet())
            {
                if (!(g instanceof Diagram) && g.eResource() != null)
                {
                    // EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(g);
                    // compoundCommand.append(RemoveCommand.create(domain, g.eContainer(),
                    // DiagramInterchangePackage.Literals.GRAPH_ELEMENT__CONTAINED, g));
                    compoundCommand.append(new GEFtoEMFCommandWrapper(new DeleteGraphElementCommand(g, true)));
                }
            }
            if (!compoundCommand.getCommandList().isEmpty())
            {
                commandMap.put(dragAndDrop, compoundCommand);
                compoundCommand.execute();
            }
        }
    }

    /**
     * An internal command to refresh active diagram.
     * 
     * @author mleray
     */
    private class RefreshDiagramCommand extends AbstractCommand
    {

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.emf.common.command.AbstractCommand#canUndo()
         */
        @Override
        public boolean canUndo()
        {
            return true;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.emf.common.command.AbstractCommand#undo()
         */
        @Override
        public void undo()
        {
            refresh();
        }

        /**
         * Refresh.
         */
        private void refresh()
        {
            Modeler modeler = Utils.getCurrentModeler();
            if (modeler != null)
            {
                modeler.refreshActiveDiagram();
            }
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.emf.common.command.Command#execute()
         */
        public void execute()
        {
            refresh();
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.emf.common.command.Command#redo()
         */
        public void redo()
        {
        }
    }

    public void dipose()
    {
        commandMap.clear();
    }
}
