/***********************************************************************
 * Copyright (c) 2006, 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *    Gilles Cannenterre (Anyware Technologies) - Fix bugs #1161 and #1247
 *    Emilien Perico (Atos Origin) - add behavior for drag&drop with ctrl key
 *    Tristan FAURE (Atos Origin) - add parameters to control import process
 **********************************************************************/

package org.topcased.modeler.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.topcased.modeler.commands.EMFtoGEFCommandWrapper;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.dialogs.InformationDialog;
import org.topcased.modeler.edit.EMFGraphEdgeEditPart;
import org.topcased.modeler.edit.EMFGraphNodeEditPart;
import org.topcased.modeler.edit.policies.ModelerLayoutEditPolicy;
import org.topcased.modeler.editor.DropFactory;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.exceptions.BoundsFormatException;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.requests.AutoLayoutRequest;
import org.topcased.modeler.requests.RestoreConnectionsRequest;
import org.topcased.modeler.utils.CommandAdapter;
import org.topcased.modeler.utils.MonitorHelper;
import org.topcased.modeler.utils.Utils;

/**
 * This class imports existing model objects in the given editpart
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class Importer implements IRunnableWithProgress
{
    private Modeler modeler;

    private DropFactory factory;

    // private CommandStack tempCommandStack;

    private CommandStack commandStack;

    private CreateRequest createRequest;

    private GraphicalEditPart target;

    private List<EObject> importedObjects;

    /** Does the user have the ctrl key pressed? */
    private boolean isCtrlKeyDown;

    /** specify if the importer applies the autolayout. */
    private boolean applyAutoLayout = true;

    /** specify if the importer displays dialogs */
    private boolean displayDialogs = true;

    private List<ImporterRunnable> postRunnables = new LinkedList<ImporterRunnable>();

    /** The command which is constructed and executed during the run action */
    private CompoundCommand runCommand = null;

    /** Whether to use a command stack */
    private boolean useCommandStack = true;

    /**
     * Constructor
     */
    public Importer(Modeler mod, EObject obj)
    {
        this.modeler = mod;
        this.importedObjects = new ArrayList<EObject>();
        this.importedObjects.add(obj);
    }

    /**
     * Get the command which has been executed during the run
     * 
     * @return executed command for eventually undo
     */
    public CompoundCommand getRunExecutedCommand()
    {
        return runCommand;
    }

    public List<EObject> getImportedEObjects()
    {
        return importedObjects;
    }

    /**
     * Constructor
     */
    public Importer(Modeler mod, List< ? > objs)
    {
        this.modeler = mod;
        this.importedObjects = new ArrayList<EObject>(objs.size());
        for (Object obj : objs)
        {
            if (obj instanceof EObject)
            {
                this.importedObjects.add((EObject) obj);
            }
        }
    }

    /**
     * The command stack used to execute the final commands
     * 
     * @return the definitive command stack
     */
    protected CommandStack getCommandStack()
    {
        if (useCommandStack)
        {
            if (commandStack == null)
            {
                commandStack = getViewer().getEditDomain().getCommandStack();
            }
            return commandStack;
        }
        else
        {
            return null;
        }
    }

    /**
     * Define the command stack to use to execute the commands.
     * <b>The default command stack is the command stack from the modeler.</b>
     * Users can change this default value if they want to use an other one.
     * 
     * @param cmdStack The commandStack to set.
     */
    public void setCommandStack(CommandStack cmdStack)
    {
        this.commandStack = cmdStack;
    }

    /**
     * Import the model objects graphically in the diagram (create command and execute it)
     * 
     * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
     */
    public void run(IProgressMonitor monitor) throws BoundsFormatException, IllegalArgumentException, InterruptedException
    {
        final int totalWork = 7;
        monitor.beginTask("Import objects", totalWork);
        try
        {
            runCommand = new CompoundCommand();
            // getTemporaryCommandStack().flush();
            if (target != null && target.getFigure() != null)
            {
                target.getFigure().validate();
            }

            // Create graphical objects
            createObjectsCmd(runCommand);
            monitor.worked(1);
            MonitorHelper.checkCanceled(monitor);

            Object objects = getCreateRequest().getNewObject();
            if (objects == null || !(objects instanceof List))
            {
                throw new IllegalArgumentException("The dragged object is not a list.");
            }
            final List< ? > objectsList = (List< ? >) objects;

            // Check whether the list is not empty
            if (!objectsList.isEmpty())
            {
                // Creates recursively the child hierarchy of the dragged objects
                CommandAdapter cmd = new CreateHierarchyCommand(objectsList);
                runCommand.add(new EMFtoGEFCommandWrapper(cmd));
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);

                // Refresh the container
                cmd = new RefreshContainerCommand();
                runCommand.add(new EMFtoGEFCommandWrapper(cmd));
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);

                // Restore connections only for the added objects
                cmd = new RestoreConnectionsCommand(objectsList);
                runCommand.add(new EMFtoGEFCommandWrapper(cmd));
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);

                // Resize the graphical objects
                cmd = new ResizeObjectsCommand(objectsList);
                runCommand.add(new EMFtoGEFCommandWrapper(cmd));
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);

                // Refresh the container
                cmd = new RefreshContainerCommand();
                runCommand.add(new EMFtoGEFCommandWrapper(cmd));
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);

                // Call the autolayout
                if (applyAutoLayout)
                {
                    autolayoutObjectsCmd(runCommand, objectsList);
                }
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);

                // Commit commands in the CommandStack of the editor
                if (getCommandStack() != null)
                {
                    getCommandStack().execute(runCommand);
                }
                else
                {
                    runCommand.execute();
                }
                // commitCommands();
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);

                // Select the newly created objects
                selectObjects(objectsList);
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);
            }
        }
        catch (InterruptedException ie)
        {
            // Undo all the commands
            // cancelCommands();

            throw ie;
        }
        catch (BoundsFormatException bfe)
        {
            // Undo all the commands
            // cancelCommands();

            throw bfe;
        }
        finally
        {
            monitor.done();
        }
    }

    /**
     * By default autolayout is set to true
     * to disable it calls this method with false before running the import
     * 
     * @param enable the new auto layout
     */
    public void setAutoLayout(boolean enable)
    {
        applyAutoLayout = enable;
    }

    /**
     * Select the objects created by the CreateRequest
     * (no command needed for this action, since model is not modified)
     */
    private void selectObjects(final List< ? > objects)
    {
        Display.getDefault().asyncExec(new Runnable()
        {
            /**
             * @see java.lang.Runnable#run()
             */
            public void run()
            {
                EditPartViewer viewer = getViewer();
                viewer.getControl().forceFocus();

                List<EditPart> selectedEditParts = new ArrayList<EditPart>();
                Iterator< ? > it = objects.iterator();
                while (it.hasNext())
                {
                    Object model = it.next();
                    Object editpart = viewer.getEditPartRegistry().get(model);
                    if (editpart instanceof EditPart)
                    {
                        selectedEditParts.add((EditPart) editpart);
                        for (ImporterRunnable r : postRunnables)
                        {
                            r.run((GraphElement) ((EditPart) editpart).getModel());
                        }
                    }
                }
                IStructuredSelection newSel = new StructuredSelection(selectedEditParts);
                if (!newSel.isEmpty())
                {
                    // Force a layout first.
                    getViewer().flush();
                    viewer.setSelection(newSel);
                }
                postRunnables.clear();
            }
        });
    }

    /**
     * Returns the current command from the target EditPart.
     * 
     * @return The current command from the target EditPart
     */
    protected Command getCommand()
    {
        return getTargetEditPart().getCommand(getCreateRequest());
    }

    /**
     * Autolayout the graphical items aasociated with the given objects
     * This method must be called at command runtime only, once edit parts are created.
     * 
     * @param objects the di objects
     */
    private void autolayoutChildren(List<DiagramElement> objects)
    {
        EditPartViewer viewer = getViewer();
        Iterator<DiagramElement> it = objects.iterator();
        while (it.hasNext())
        {
            DiagramElement model = it.next();
            Object editpart = viewer.getEditPartRegistry().get(model);
            autolayout((EditPart) editpart);
        }
    }

    /**
     * AutoLayout the objects created by the CreateRequest
     * This method must be called at command runtime only, once edit parts are created.
     * 
     * @param ep
     */
    private void autolayout(EditPart ep)
    {
        AutoLayoutRequest request = new AutoLayoutRequest();
        Command command = ep.getCommand(request);
        if (command != null && command.canExecute())
        {
            command.execute();
        }
    }

    /**
     * AutoLayout the objects created by the CreateRequest
     * 
     * @param objects
     */
    private void autolayoutObjectsCmd(CompoundCommand globalCommand, List< ? > objects)
    {
        CommandAdapter cmd = new AutoLayoutChildrenCommand(objects);
        globalCommand.add(new EMFtoGEFCommandWrapper(cmd));

        cmd = new RefreshContainerCommand();
        globalCommand.add(new EMFtoGEFCommandWrapper(cmd));

        cmd = new AutoLayoutCommand(objects);
        globalCommand.add(new EMFtoGEFCommandWrapper(cmd));
    }

    /**
     * Get command to create objects
     * 
     * @param globalCommand
     */
    private void createObjectsCmd(CompoundCommand globalCommand)
    {
        if (getTargetEditPart() != null)
        {
            Command command = getCommand();
            if (command != null && command.canExecute())
            {
                globalCommand.add(command);
            }
        }
    }

    /**
     * Creates the hierarchy for object list and children, if any.
     * This method must be called at command runtime only, once edit parts are created.
     * 
     * @param globalCommand command to complete to be able to undo (no need to execute it)
     * @param objects the objects
     * @param showInfoDialog show info dialog the first time
     */
    private void createHierarchyAndKeepCmd(CompoundCommand globalCommand, List<DiagramElement> objects, boolean showInfoDialog)
    {
        EditPartViewer viewer = getViewer();
        Iterator<DiagramElement> it = objects.iterator();

        InformationDialog dialog = new InformationDialog(ModelerPlugin.getActiveWorkbenchShell(), "Drag and Drop Operations", "You can drop this element without content pressing CTRL key",
                modeler.getPreferenceStore(), ModelerPreferenceConstants.DRAGNDROP_MODEL_ACTION_PREF);

        while (it.hasNext())
        {
            DiagramElement node = it.next();
            Object editpart = viewer.getEditPartRegistry().get(node);
            if (editpart instanceof EditPart && node instanceof GraphNode)
            {
                EObject model = Utils.getElement((GraphNode) node);
                if (model != null)
                {
                    EList<EObject> children = model.eContents();
                    if (!children.isEmpty() && showInfoDialog)
                    {
                        dialog.open();
                        showInfoDialog = false;
                    }
                    CreateRequest req = createRequest(children);

                    Command command = ((EditPart) editpart).getCommand(req);
                    if (command != null && command.canExecute() && !isCtrlKeyDown)
                    {
                        globalCommand.add(command);
                        command.execute();
                    }

                    Object createdObjects = req.getNewObject();
                    if (createdObjects != null && createdObjects instanceof List && !((List< ? >) createdObjects).isEmpty() && !isCtrlKeyDown)
                    {
                        // Creates recursively the child hierarchy of the dragged objects
                        List<DiagramElement> droppedChildren = getEffectivelyDroppedObjects((List< ? >) createdObjects);
                        createHierarchyAndKeepCmd(globalCommand, droppedChildren, showInfoDialog);

                        // Restore connections
                        List<EObject> modelObjects = new ArrayList<EObject>(((GraphNode) node).eContents());
                        restoreConnectionsAndKeepCmd(globalCommand, modelObjects);

                        // Call the autolayout
                        // autolayoutObjects(children);
                    }
                }
            }
        }
    }

    /**
     * Refresh a container edit part
     * This method must be called at command runtime only, once edit parts are created.
     * 
     * @param ep edit part to refresh
     */
    private void refreshContainer(EditPart ep)
    {
        if (ep instanceof GraphicalEditPart)
        {
            ((GraphicalEditPart) ep).getFigure().validate();
        }
    }

    /**
     * Resize the graphical representation of the added objects.
     * This method must be called at command runtime only, once edit parts are created.
     */
    private void resizeObjects(List<DiagramElement> objects)
    {
        // Compute the editparts
        EditPartViewer viewer = getViewer();
        List<GraphicalEditPart> editParts = new ArrayList<GraphicalEditPart>();
        Iterator<DiagramElement> it = objects.iterator();
        while (it.hasNext())
        {
            Object model = it.next();
            if (dropHasBeenEffective(model))
            {
                Object editpart = viewer.getEditPartRegistry().get(model);
                if (editpart instanceof GraphicalEditPart)
                {
                    editParts.add((GraphicalEditPart) editpart);
                }
            }
        }
        if (editParts.isEmpty())
        {
            return;
        }

        // Try and resize
        AutoResizer resizer = new AutoResizer();
        Command resizeCmd = resizer.getCommand(editParts);
        if (resizeCmd != null && resizeCmd.canExecute())
        {
            resizeCmd.execute();
        }
    }

    /**
     * Restore the connections for the added objects (once edit parts are created...)
     * This method must be called at command runtime only, once edit parts are created.
     * 
     * @param globalCommand command to complete to be able to undo (no need to execute it)
     * @param objects objects to restore connections for
     */
    private void restoreConnectionsAndKeepCmd(CompoundCommand globalCommand, List< ? extends EObject> objects)
    {
        EditPartViewer viewer = getViewer();
        Iterator< ? extends EObject> it = objects.iterator();
        while (it.hasNext())
        {
            EObject model = it.next();
            Object editpart = viewer.getEditPartRegistry().get(model);
            if (editpart instanceof EMFGraphNodeEditPart || editpart instanceof EMFGraphEdgeEditPart)
            {
                restoreConnectionsAndKeepCmd(globalCommand, (AbstractEditPart) editpart);
            }
        }
    }

    /**
     * Restore the connections for the created edit part
     * This method must be called at command runtime only, once edit parts are created.
     * 
     * @param globalCommand command to complete to be able to undo (no need to execute it)
     * @param abstractEditPart edit part to restore connections
     */
    private void restoreConnectionsAndKeepCmd(CompoundCommand globalCommand, AbstractEditPart abstractEditPart)
    {
        RestoreConnectionsRequest request = new RestoreConnectionsRequest();
        Command command = abstractEditPart.getCommand(request);
        if (command != null && command.canExecute())
        {
            globalCommand.add(command);
            command.execute();
        }
    }

    /**
     * Return the list of the object that are associated with an EditPart. These
     * are the nodes that were really added during the DND.
     * This method must be called at command runtime only, once edit parts are created.
     * 
     * @param objects the list of all the created objects
     * @return only the objects that were added in the diagram
     */
    private List<DiagramElement> getEffectivelyDroppedObjects(List< ? > objects)
    {
        EditPartViewer viewer = getViewer();

        List<DiagramElement> addedObjects = new ArrayList<DiagramElement>();
        Iterator< ? > it = objects.iterator();
        while (it.hasNext())
        {
            Object model = it.next();
            Object editpart = viewer.getEditPartRegistry().get(model);
            if (editpart instanceof EditPart && model instanceof DiagramElement)
            {
                addedObjects.add((DiagramElement) model);
            }
        }

        return addedObjects;
    }

    /**
     * Return whether model object has been correctly added and is now linked with an edit part
     * This method must be called at command runtime only, once edit parts are created.
     * 
     * @param model model object
     * @return true if linked with an edit part
     */
    private boolean dropHasBeenEffective(Object model)
    {
        EditPartViewer viewer = getViewer();
        Object editpart = viewer.getEditPartRegistry().get(model);
        return editpart instanceof EditPart && model instanceof DiagramElement;
    }

    /**
     * A helper method that casts the target Request to a CreateRequest.
     * 
     * @return CreateRequest
     */
    public CreateRequest getCreateRequest()
    {
        if (createRequest == null)
        {
            createRequest = createTargetRequest();
        }
        return createRequest;
    }

    /**
     * Create the Request
     */
    protected CreateRequest createTargetRequest()
    {
        CreateRequest req = new CreateRequest();
        if (factory == null)
        {
            factory = new DropFactory(modeler);
        }
        factory.setTransferredObjects(importedObjects);
        req.setFactory(factory);
        return req;
    }

    private CreateRequest createRequest(List<EObject> transferredObjects)
    {
        CreateRequest req = new CreateRequest();
        DropFactory locFactory = new DropFactory(modeler);
        locFactory.setTransferredObjects(transferredObjects);
        req.setFactory(locFactory);
        return req;
    }

    public void setLocation(Point location)
    {
        setLocation(location, true);
    }

    public void setLocation(Point location, boolean screenDisplay)
    {
        CreateRequest req = getCreateRequest();
        if (!screenDisplay)
        {
            req.getExtendedData().put(ModelerLayoutEditPolicy.REQ_EXT_METADATA_TRANSLATE_LOCATION, false);
        }
        req.setLocation(location);
    }

    /**
     * Returns the current <i>target</i> <code>EditPart</code>.
     * 
     * @return the target EditPart
     */
    private EditPart getTargetEditPart()
    {
        return target;
    }

    /**
     * Change the current target edit part
     * 
     * @param ep the target edit part
     */
    public void setTargetEditPart(GraphicalEditPart ep)
    {
        if (ep != target)
        {
            target = ep;
        }
    }

    private GraphicalViewer getViewer()
    {
        return (GraphicalViewer) modeler.getAdapter(GraphicalViewer.class);
    }

    /**
     * @param isCtrlKeyDown the isCtrlKeyDown to set
     */
    public void setCtrlKeyDown(boolean isCtrlKeyDown)
    {
        this.isCtrlKeyDown = isCtrlKeyDown;
    }

    public void setDisplayDialogs(boolean displayDialogs)
    {
        this.displayDialogs = displayDialogs;
    }

    /**
     * This method adds a runnable wich will be launched when the edit parts imported will be selected
     * 
     * @param runnable
     */
    public void addGraphNodeProcess(ImporterRunnable runnable)
    {
        postRunnables.add(runnable);
    }

    /**
     * This command restores edit parts' connections for given objects
     * 
     * @author vhemery
     */
    private final class RestoreConnectionsCommand extends CommandAdapter
    {
        private final List< ? > objectsList;

        private CompoundCommand globalCommand = null;

        private RestoreConnectionsCommand(List< ? > objectsList)
        {
            this.objectsList = objectsList;
        }

        @Override
        public void execute()
        {
            globalCommand = new CompoundCommand();
            restoreConnectionsAndKeepCmd(globalCommand, getEffectivelyDroppedObjects(objectsList));
            // content of globalCommand has already been executed
        }

        @Override
        public void undo()
        {
            if (globalCommand != null)
            {
                globalCommand.undo();
            }
        }

        @Override
        public void redo()
        {
            if (globalCommand != null)
            {
                globalCommand.redo();
            }
        }
    }

    /**
     * This command edit parts hierarchy for given objects
     * 
     * @author vhemery
     */
    private final class CreateHierarchyCommand extends CommandAdapter
    {
        private final List< ? > objectsList;

        private CompoundCommand globalCommand = null;

        private CreateHierarchyCommand(List< ? > objectsList)
        {
            this.objectsList = objectsList;
        }

        @Override
        public void execute()
        {
            globalCommand = new CompoundCommand();
            createHierarchyAndKeepCmd(globalCommand, getEffectivelyDroppedObjects(objectsList), displayDialogs);
            // content of globalCommand has already been executed
        }

        @Override
        public void undo()
        {
            if (globalCommand != null)
            {
                globalCommand.undo();
            }
        }

        @Override
        public void redo()
        {
            if (globalCommand != null)
            {
                globalCommand.redo();
            }
        }
    }

    /**
     * This command performs the auto layout on objects' edit parts
     * 
     * @author vhemery
     */
    private final class AutoLayoutCommand extends CommandAdapter
    {
        private final List< ? > objects;

        private AutoLayoutCommand(List< ? > objects)
        {
            this.objects = objects;
        }

        @Override
        public void execute()
        {
            AutoLayoutRequest request = new AutoLayoutRequest();
            request.setObjects(getEffectivelyDroppedObjects(objects));
            Command command = getTargetEditPart().getCommand(request);
            if (command != null && command.canExecute())
            {
                command.execute();
            }
        }
    }

    /**
     * This command resizes objects' edit parts
     * 
     * @author vhemery
     */
    private final class ResizeObjectsCommand extends CommandAdapter
    {
        private final List< ? > objectsList;

        private ResizeObjectsCommand(List< ? > objectsList)
        {
            this.objectsList = objectsList;
        }

        @Override
        public void execute()
        {
            resizeObjects(getEffectivelyDroppedObjects(objectsList));
        }

        @Override
        public void redo()
        {
            execute();
        }

        @Override
        public void undo()
        {
            execute();
        }
    }

    /**
     * This command performs the auto layout on edit part
     * 
     * @author vhemery
     */
    private final class AutoLayoutChildrenCommand extends CommandAdapter
    {
        private final List< ? > objects;

        private AutoLayoutChildrenCommand(List< ? > objects)
        {
            this.objects = objects;
        }

        @Override
        public void execute()
        {
            autolayoutChildren(getEffectivelyDroppedObjects(objects));
        }

        @Override
        public void undo()
        {
            execute();
        }

        @Override
        public void redo()
        {
            execute();
        }
    }

    /**
     * This command refreshes the target container edit part
     * 
     * @author vhemery
     */
    private final class RefreshContainerCommand extends CommandAdapter
    {
        @Override
        public void execute()
        {
            refreshContainer(getTargetEditPart());
        }

        @Override
        public void undo()
        {
            execute();
        }

        @Override
        public void redo()
        {
            execute();
        }
    }

    public static interface ImporterRunnable
    {
        void run(GraphElement editPart);
    }

    /**
     * Tell the importer that it should not use command stack to execute command. This shall be used only when import is
     * performed nested in another command, during execution time.
     * 
     * @see #getRunExecutedCommand() to recover the command to undo
     * @param doNotUseCommandStack
     */
    public void setDoNotUseCommandStack()
    {
        useCommandStack = false;
    }

}
