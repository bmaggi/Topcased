/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies)
 *    - initial API and implementation
 *    Laurent Redor
 *    - developments relating to navigation through several models
 *******************************************************************************/
package org.topcased.modeler.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.ui.PlatformUI;
import org.topcased.modeler.commands.INonDirtyingCommand;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.editor.navigation.DiagramAndModeler;

/**
 * This class is responsible of the navigation throught the diagrams. Then it stores the history of this navigation to
 * allow next and previous actions. <br>
 * creation : 16 déc. 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
 */
public class NavigationManager
{
    private Modeler modeler;

    private int previousLimit = 30;

    private Stack<DiagramAndModeler> previousDiagrams = new Stack<DiagramAndModeler>();

    private Stack<DiagramAndModeler> nextDiagrams = new Stack<DiagramAndModeler>();

    private List<INavigationListener> eventListeners = new ArrayList<INavigationListener>();

    /**
     * Constructor
     * 
     * @param editor the modeler
     */
    NavigationManager(Modeler editor)
    {
        super();
        this.modeler = editor;
    }

    /**
     * Appends the listener to the list of navigation listeners. Multiple adds result in multiple notifications.
     * 
     * @param listener the event listener
     */
    public void addNavigationListener(INavigationListener listener)
    {
        eventListeners.add(listener);
    }

    /**
     * Removes the first occurrence of the specified listener.
     * 
     * @param listener the listener
     */
    public void removeNavigationListener(INavigationListener listener)
    {
        eventListeners.remove(listener);
    }

    /**
     * Notify the listeners that the active diagram as changed
     * 
     * @param newDiagram The new active diagram
     */
    public void notifyListeners(Diagram newDiagram)
    {
        for (int i = 0; i < eventListeners.size(); i++)
        {
            eventListeners.get(i).diagramChanged(newDiagram);
        }
    }

    /**
     * Returns <code>true</code> if a previous action can be performed
     * 
     * @return a boolean
     */
    public boolean canDoPrevious()
    {
        return !previousDiagrams.isEmpty();
    }

    /**
     * Returns <code>true</code> if a next action can be performed
     * 
     * @return a boolean
     */
    public boolean canDoNext()
    {
        return !nextDiagrams.isEmpty();
    }

    /**
     * Go backward in the browse history
     */
    public void previous()
    {
        Diagram oldDiagram = modeler.getActiveDiagram();

        // Add a new browse command to the editor command stack
        // Change the diagram
        DiagramAndModeler prevDiagramAndModeler = previousDiagrams.pop();
        if (modeler != prevDiagramAndModeler.getModeler())
        {
            // The diagrams are in two different editors
            getEditorCommandStack().execute(createNavigateCommand(prevDiagramAndModeler.getModeler(), prevDiagramAndModeler.getDiagram(), modeler, oldDiagram));
        }
        else
        {
            // The diagrams are in the same editor
            getEditorCommandStack().execute(createNavigateCommand(prevDiagramAndModeler.getDiagram()));
        }

        // Change the position in the browse stack
        if (modeler != prevDiagramAndModeler.getModeler())
        {
            // The diagrams are in two different editors (we change the stack of the other navigation manager)
            prevDiagramAndModeler.getModeler().getNavigationManager().addNextDiagram(modeler, oldDiagram);
            // Send event
            prevDiagramAndModeler.getModeler().getNavigationManager().notifyListeners(prevDiagramAndModeler.getDiagram());
        }
        else
        {
            // The diagrams are in the same editor
            nextDiagrams.add(new DiagramAndModeler(oldDiagram, modeler));
            // Send event
            notifyListeners(prevDiagramAndModeler.getDiagram());
        }
    }

    /**
     * Add a diagram in the next navigation stack
     * 
     * @param diagramModeler
     * @param diagram
     */
    private void addNextDiagram(Modeler diagramModeler, Diagram diagram)
    {
        nextDiagrams.add(new DiagramAndModeler(diagram, diagramModeler));
    }

    /**
     * Go forward in the browse history
     */
    public void next()
    {
        Diagram oldDiagram = modeler.getActiveDiagram();
        // Add a new browse command to the editor command stack
        // Change the diagram
        DiagramAndModeler nextDiagramAndModeler = nextDiagrams.pop();
        if (modeler != nextDiagramAndModeler.getModeler())
        {
            // The diagrams are in two different editors
            getEditorCommandStack().execute(createNavigateCommand(nextDiagramAndModeler.getModeler(), nextDiagramAndModeler.getDiagram(), modeler, oldDiagram));
        }
        else
        {
            // The diagrams are in the same editor
            getEditorCommandStack().execute(createNavigateCommand(nextDiagramAndModeler.getDiagram()));
        }

        // Change the position in the browse stack
        if (modeler != nextDiagramAndModeler.getModeler())
        {
            // The diagrams are in two different editors (we change the stack of the other navigation manager)
            nextDiagramAndModeler.getModeler().getNavigationManager().addPreviousDiagram(modeler, oldDiagram);
            // Send event
            nextDiagramAndModeler.getModeler().getNavigationManager().notifyListeners(nextDiagramAndModeler.getDiagram());
        }
        else
        {
            // The diagrams are in the same editor
            previousDiagrams.add(new DiagramAndModeler(oldDiagram, modeler));
            // Send event
            notifyListeners(nextDiagramAndModeler.getDiagram());
        }
    }

    /**
     * Creates the naviagtion command for the given diagram
     * 
     * @param newDiagram the destination diagram
     * @return the navigation command
     */
    private Command createNavigateCommand(Diagram newDiagram)
    {
        return new ChangeActiveDiagramCommand(modeler, newDiagram);
    }

    /**
     * Creates the naviagtion command for the given diagram
     * 
     * @param newEditor the destination editor
     * @param newDiagram the destination diagram
     * @param oldEditor the previous editor
     * @param oldDiagram the previous diagram
     * @return the navigation command
     */
    private Command createNavigateCommand(Modeler newEditor, Diagram newDiagram, Modeler oldEditor, Diagram oldDiagram)
    {
        return new ChangeActiveDiagramCommand(newEditor, newDiagram, oldEditor, oldDiagram);
    }

    /**
     * Change the current diagram
     * 
     * @param newDiagram the new active diagram
     */
    public void set(Diagram newDiagram)
    {
        Diagram oldDiagram = modeler.getActiveDiagram();
        if (oldDiagram != newDiagram || (oldDiagram == null && newDiagram == null))
        {
            // Add a new browse command to the editor command stack
            // Change the diagram
            getEditorCommandStack().execute(createNavigateCommand(newDiagram));

            // Clear the next stack
            nextDiagrams.clear();

            // Add a new previous diagram
            addPreviousDiagram(modeler, oldDiagram);

            // Send event
            notifyListeners(newDiagram);
        }
    }

    /**
     * Change the current diagram with a diagram of another modeler
     * 
     * @param previousModeler the previous active modeler
     * @param previousDiagram the previous diagram
     * @param nextModeler the new active modeler
     * @param newDiagram the new active diagram
     */
    public void set(Modeler previousModeler, Diagram previousDiagram, Modeler nextModeler, Diagram newDiagram)
    {
        // Diagram oldDiagram = previousModeler.getActiveDiagram();
        if (previousDiagram != newDiagram || (previousDiagram == null && newDiagram == null))
        {
            // Add a new browse command to the editor command stack
            // Change the diagram
            getEditorCommandStack().execute(createNavigateCommand(nextModeler, newDiagram, previousModeler, previousDiagram));

            // Clear the next stack
            nextDiagrams.clear();

            // Add a new previous diagram
            addPreviousDiagram(previousModeler, previousDiagram);

            // Send event
            notifyListeners(newDiagram);
        }
    }

    private void addPreviousDiagram(Modeler previousModeler, Diagram diag)
    {
        if (diag != null)
        {
            if (getPreviousLimit() > 0)
            {
                while (previousDiagrams.size() >= getPreviousLimit())
                {
                    previousDiagrams.remove(0);
                }
            }
            previousDiagrams.push(new DiagramAndModeler(diag, previousModeler));
        }
    }

    /**
     * Returns the depth of the browse stack
     * 
     * @return the limit
     */
    public int getPreviousLimit()
    {
        return previousLimit;
    }

    /**
     * Returns the command stack of the modeler
     * 
     * @return the command stack
     */
    private CommandStack getEditorCommandStack()
    {
        return (CommandStack) modeler.getAdapter(CommandStack.class);
    }

    /**
     * The GEF command used to store the navigation actions in the editor's command stack <br>
     * creation : 16 déc. 2005
     * 
     * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
     * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
     */
    private class ChangeActiveDiagramCommand extends Command implements INonDirtyingCommand
    {
        /** The old editor if the old diagram was in other editor than the editor of the new diagram */
        private Modeler oldEditor;

        /** The editor of the new diagram */
        private Modeler newEditor;

        /** The diagram which was replaced by the new */
        private Diagram oldDiagram;

        /** The diagram to activate */
        private Diagram newDiagram;

        /**
         * Constructor in case of the new diagram is in the same editor as the old diagram
         * 
         * @param ed the Modeler
         * @param newDiag the new active diagram
         */
        public ChangeActiveDiagramCommand(Modeler ed, Diagram newDiag)
        {
            super("Create Diagram");
            this.newEditor = ed;
            this.newDiagram = newDiag;
        }

        /**
         * Constructor
         * 
         * @param newEd the Modeler
         * @param newDiag the new active diagram
         * @param oldEd the previous modeler
         * @param oldDiag the previous 
         */
        public ChangeActiveDiagramCommand(Modeler newEd, Diagram newDiag, Modeler oldEd, Diagram oldDiag)
        {
            super("Create Diagram");
            this.newEditor = newEd;
            this.newDiagram = newDiag;
            this.oldEditor = oldEd;
            this.oldDiagram = oldDiag;
        }

        /**
         * @see org.eclipse.gef.commands.Command#canExecute()
         */
        public boolean canExecute()
        {
            return newEditor != null;
        }

        /**
         * @see org.eclipse.gef.commands.Command#canUndo()
         */
        public boolean canUndo()
        {
            return newEditor != null || oldEditor != null;
        }

        /**
         * @see org.eclipse.gef.commands.Command#execute()
         */
        public void execute()
        {
            // If there is an old editor, the old Diagram is already initialized
            if (oldEditor == null)
            {
                oldDiagram = newEditor.getActiveDiagram();
            }
            redo();
        }

        /**
         * @see org.eclipse.gef.commands.Command#redo()
         */
        public void redo()
        {
            if (oldEditor != null && oldEditor != newEditor)
            {
                // The new diagram is in another editor, we must activate it before change diagram (if this editor is
                // not active)
                if (!newEditor.equals(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()))
                {
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(newEditor);
                }
            }
            newEditor.changeActiveDiagram(newDiagram);
        }

        /**
         * @see org.eclipse.gef.commands.Command#undo()
         */
        public void undo()
        {
            if (oldEditor != null && oldEditor != newEditor)
            {
                // The old diagram is in another editor, we must activate it before change diagram (if this editor is
                // not active)
                if (!oldEditor.equals(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()))
                {
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(oldEditor);
                }
            }
            newEditor.changeActiveDiagram(oldDiagram);
        }
    }
}
