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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.topcased.modeler.commands.CompoundCommand;
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

    private CommandStack tempCommandStack;

    private CommandStack commandStack;

    private CreateRequest createRequest;

    private GraphicalEditPart target;

    private List<EObject> importedObjects;
    
    /** Does the user have the ctrl key pressed? */
    private boolean isCtrlKeyDown;

    /** specify if the importer applies the autolayout. */
    private boolean applyAutoLayout = true;

    /** specify if the importer displays dialogs */
    private boolean displayDialogs = true ;

    private List<ImporterRunnable> postRunnables = new LinkedList<ImporterRunnable>();

    /**
     * Constructor
     */
    public Importer(Modeler mod, EObject obj)
    {
        this.modeler = mod;
        this.importedObjects = new ArrayList();
        this.importedObjects.add(obj);
    }
    
    public List<EObject> getImportedEObjects ()
    {
        return importedObjects ;
    }

    /**
     * Constructor
     */
    public Importer(Modeler mod, List objs)
    {
        this.modeler = mod;
        this.importedObjects = objs;
    }

    /**
     * Get the temporary CommandStack
     * 
     * @return the temp CommandStack
     */
    protected CommandStack getTemporaryCommandStack()
    {
        if (tempCommandStack == null)
        {
            tempCommandStack = new CommandStack();
        }

        return tempCommandStack;
    }
    
    /**
     * The command stack used to execute the final commands
     * @return the definitive command stack
     */
    protected CommandStack getCommandStack()
    {
        if (commandStack == null)
        {
            commandStack = getViewer().getEditDomain().getCommandStack();
        }

        return commandStack;
    }
    
    /**
     * Define the command stack to use to execute the commands.
     * <b>The default command stack is the command stack from the modeler.</b>
     * Users can change this default value if they want to use an other one.
     * @param cmdStack The commandStack to set.
     */
    public void setCommandStack(CommandStack cmdStack)
    {
        this.commandStack = cmdStack;
    }

    /**
     * Import the model objects graphically in the diagram
     * 
     * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
     */
    public void run(IProgressMonitor monitor) throws BoundsFormatException, IllegalArgumentException,
            InterruptedException
    {
        final int totalWork = 7;
        monitor.beginTask("Import objects", totalWork);
        try
        {
            getTemporaryCommandStack().flush();
            if (target != null && target.getFigure() != null)
            {
            	target.getFigure().validate();
            }

            // Create graphical objects
            createObjects();
            monitor.worked(1);
            MonitorHelper.checkCanceled(monitor);

            Object objects = getCreateRequest().getNewObject();
            if (objects == null || !(objects instanceof List))
            {
                throw new IllegalArgumentException("The dragged object is not a list.");
            }
            List addedObjects = getEffectivelyDroppedObjects((List) objects);

            // Check whether the list is not empty
            if (!addedObjects.isEmpty())
            {
                // Creates recursively the child hierarchy of the dragged objects
                createHierarchy(addedObjects, displayDialogs);
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);
    
                // Refresh the container
                refreshContainer(getTargetEditPart());
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);
    
                // Restore connections only for the added objects
                restoreConnections(addedObjects);
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);
    
                // Resize the graphical objects
                resizeObjects(addedObjects);
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);
    
                // Refresh the container
                refreshContainer(getTargetEditPart());
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);
    
                // Call the autolayout
                if (applyAutoLayout)
                {
                    autolayoutObjects(addedObjects);
                }
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);
    
                // Commit commands in the CommandStack of the editor
                commitCommands();
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);
    
                // Select the newly created objects
                selectObjects(addedObjects);
                monitor.worked(1);
                MonitorHelper.checkCanceled(monitor);
            }
        }
        catch (InterruptedException ie)
        {
            // Undo all the commands
            cancelCommands();

            throw ie;
        }
        catch (BoundsFormatException bfe)
        {
            // Undo all the commands
            cancelCommands();

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
        applyAutoLayout  = enable ;
    }
    
    private void cancelCommands()
    {
        while (getTemporaryCommandStack().canUndo())
        {
            getTemporaryCommandStack().undo();
        }
    }

    /**
     * Select the objects created by the CreateRequest
     */
    private void selectObjects(final List objects)
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

                List selectedEditParts = new ArrayList();
                Iterator it = objects.iterator();
                while (it.hasNext())
                {
                    Object model = it.next();
                    Object editpart = viewer.getEditPartRegistry().get(model);
                    if (editpart instanceof EditPart)
                    {
                        selectedEditParts.add(editpart);
                        for (ImporterRunnable r : postRunnables)
                        {
                            r.run((GraphElement)((EditPart) editpart).getModel());
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

    private void commitCommands()
    {
        // cancelCommands();

        CompoundCommand groupCmd = new CompoundCommand();
        Object[] cmds = getTemporaryCommandStack().getCommands();
        for (int i = 0; i < cmds.length; i++)
        {
            Object command = cmds[i];
            if (command != null && command instanceof Command && ((Command) command).canExecute())
            {
                groupCmd.addExecuted((Command) command);
            }
        }
        
        getCommandStack().execute(groupCmd);
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
     * 
     * @param objects the di objects
     */
    private void autolayoutChildren(List objects)
    {
        EditPartViewer viewer = getViewer();
        Iterator it = objects.iterator();
        while (it.hasNext())
        {
            Object model = it.next();
            Object editpart = viewer.getEditPartRegistry().get(model);
            autolayout((EditPart) editpart);
        }
    }

    /**
     * AutoLayout the objects created by the CreateRequest
     * 
     * @param ep
     */
    private void autolayout(EditPart ep)
    {
        AutoLayoutRequest request = new AutoLayoutRequest();
        Command command = ep.getCommand(request);
        if (command != null && command.canExecute())
        {
            getTemporaryCommandStack().execute(command);
        }
    }

    /**
     * AutoLayout the objects created by the CreateRequest
     * 
     * @param objects
     */
    private void autolayoutObjects(List objects)
    {
        autolayoutChildren(objects);
        
        refreshContainer(getTargetEditPart());

        AutoLayoutRequest request = new AutoLayoutRequest();
        request.setObjects(objects);
        Command command = getTargetEditPart().getCommand(request);
        if (command != null && command.canExecute())
        {
            getTemporaryCommandStack().execute(command);
        }
    }

    private void createObjects()
    {
        if (getTargetEditPart() != null)
        {
            Command command = getCommand();
            if (command != null && command.canExecute())
            {
                getTemporaryCommandStack().execute(command);
            }
        }
    }

    /**
     * Creates the hierarchy for object list and children, if any
     * 
     * @param objects the objects
     * @param showInfoDialog show info dialog the first time
     */
    private void createHierarchy(List objects, boolean showInfoDialog)
    {
        EditPartViewer viewer = getViewer();
        Iterator it = objects.iterator();

        InformationDialog dialog = new InformationDialog(ModelerPlugin.getActiveWorkbenchShell(), "Drag and Drop Operations", "You can drop this element without content pressing CTRL key",
                modeler.getPreferenceStore(), ModelerPreferenceConstants.DRAGNDROP_MODEL_ACTION_PREF);
        
        while (it.hasNext())
        {
            Object node = it.next();
            Object editpart = viewer.getEditPartRegistry().get(node);
            if (editpart instanceof EditPart && node instanceof GraphNode)
            {
                EObject model = Utils.getElement((GraphNode) node);
                if (model != null)
                {
                    List children = model.eContents();
                    if (!children.isEmpty() && showInfoDialog)
                    {
                        dialog.open();
                        showInfoDialog = false;
                    }
                    CreateRequest req = createRequest(children);

                    Command command = ((EditPart) editpart).getCommand(req);
                    if (command != null && command.canExecute() && !isCtrlKeyDown)
                    {
                        getTemporaryCommandStack().execute(command);
                    }

                    Object createdObjects = req.getNewObject();
                    if (createdObjects != null && createdObjects instanceof List && !((List) createdObjects).isEmpty()
                                && !isCtrlKeyDown)
                    {
                        // Creates recursively the child hierarchy of the
                        // dragged
                        // objects
                        createHierarchy((List) createdObjects, showInfoDialog);

                        // Restore connections
                        List modelObjects = new ArrayList(((GraphNode) node).eContents());
                        restoreConnections(modelObjects);

                        // Call the autolayout
                        // autolayoutObjects(children);
                    }
                }
            }
        }
    }

    private void refreshContainer(EditPart ep)
    {
        if (ep instanceof GraphicalEditPart)
        {
            ((GraphicalEditPart) ep).getFigure().validate();
        }
    }

    /**
     * Resize the graphical representation of the added objects
     */
    private void resizeObjects(List objects)
    {
        // Compute the editparts
        EditPartViewer viewer = getViewer();
        List editParts = new ArrayList();
        Iterator it = objects.iterator();
        while (it.hasNext())
        {
            Object model = it.next();
            Object editpart = viewer.getEditPartRegistry().get(model);
            if (editpart instanceof GraphicalEditPart)
            {
                editParts.add(editpart);
            }
        }

        // Try to resize
        AutoResizer resizer = new AutoResizer();
        Command resizeCmd = resizer.getCommand(editParts);
        if (resizeCmd != null && resizeCmd.canExecute())
        {
            getTemporaryCommandStack().execute(resizeCmd);
        }
    }

    /**
     * Restore the connections for the added objects
     */
    private void restoreConnections(List objects)
    {
        EditPartViewer viewer = getViewer();
        Iterator it = objects.iterator();
        while (it.hasNext())
        {
            Object model = it.next();
            Object editpart = viewer.getEditPartRegistry().get(model);
            if (editpart instanceof EMFGraphNodeEditPart || editpart instanceof EMFGraphEdgeEditPart)
            {
                restoreConnections((AbstractEditPart) editpart);
            }
        }
    }

    private void restoreConnections(AbstractEditPart abstractEditPart)
    {
        RestoreConnectionsRequest request = new RestoreConnectionsRequest();
        Command command = abstractEditPart.getCommand(request);
        if (command != null && command.canExecute())
        {
            getTemporaryCommandStack().execute(command);
        }
    }

    /**
     * Return the list of the object that are associated with an EditPart. These
     * are the nodes that were really added during the DND.
     * 
     * @param objects the list of all the created objects
     * @return only the objects that were added in the diagram
     */
    private List getEffectivelyDroppedObjects(List objects)
    {
        EditPartViewer viewer = getViewer();

        List addedObjects = new ArrayList();
        Iterator it = objects.iterator();
        while (it.hasNext())
        {
            Object model = it.next();
            Object editpart = viewer.getEditPartRegistry().get(model);
            if (editpart instanceof EditPart)
            {
                addedObjects.add(model);
            }
        }

        return addedObjects;
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

    private CreateRequest createRequest(List transferredObjects)
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
     * @param runnable
     */
    public void addGraphNodeProcess(ImporterRunnable runnable)
    {
        postRunnables.add(runnable);
    }
    
    public static interface ImporterRunnable 
    {
        void run (GraphElement editPart) ;
    }

}
