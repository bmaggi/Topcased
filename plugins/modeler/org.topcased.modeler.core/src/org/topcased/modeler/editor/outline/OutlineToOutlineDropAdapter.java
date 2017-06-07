/*****************************************************************************
 * 
 * OutlineToOutlineDropAdapter.java
 * 
 * Copyright (c) 2008 Atos Origin
 *
 * Contributors:
 *  Thibault Landr� (Atos Origin) <a href="mailto:thibault.landre@atosorigin.com">Thibault Landr�</a>
 * - Initial API and Implementation
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.topcased.modeler.editor.outline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DragAndDropCommand;
import org.eclipse.emf.edit.command.DragAndDropFeedback;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.dialogs.ConfirmImpactDialog;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.ordering.IOrder.OrderException;
import org.topcased.modeler.internal.ordering.OrderManager;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.tools.DiagramKeeper;
import org.topcased.modeler.utils.CommandAdapter;
import org.topcased.modeler.utils.Utils;

/**
 * This implementation extends the EditingDomainViewerDropAdapter and add a graphical refresh of the active diagram<br>
 * Fix #772.
 */
public class OutlineToOutlineDropAdapter extends EditingDomainViewerDropAdapter
{

    /** A reference to the modeler. */
    private final Modeler modeler;

    /** The di keepers. */
    private static Map<String, DiagramKeeper> diKeepers = getDiagramKeepers();

    /**
     * Instantiates a new outline to outline drop adapter.
     * 
     * @param modeler the modeler
     * @param viewer the viewer
     */
    public OutlineToOutlineDropAdapter(Modeler modeler, Viewer viewer)
    {
        super(modeler.getEditingDomain(), viewer);
        this.modeler = modeler;
    }

    /**
     * Add the refresh of the activeDiagram to the drop action.
     * 
     * @param event the event
     * 
     * @see org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent)
     */
    @Override
    public void drop(DropTargetEvent event)
    {
        Map<GraphElement, Diagram> impactedDiagrams = new HashMap<GraphElement, Diagram>();
        if (event.data instanceof IStructuredSelection)
        {
            IStructuredSelection selection = (IStructuredSelection) event.data;
            for (Object object : selection.toArray())
            {
                impactedDiagrams.putAll(getImpactedDiagrams((EObject) object));
            }
        }
        ConfirmImpactDialog dialog = new ConfirmImpactDialog(ModelerPlugin.getActiveWorkbenchShell(), "Move Operations", "Are you sure you want to move these model elements ?",
                ModelerPlugin.getDefault().getPreferenceStore(), ModelerPreferenceConstants.MOVE_MODEL_ACTION_CONFIRM);
        // create a diagram set to avoid duplicate diagram in the displayed list
        Set<Diagram> diagramSet = new HashSet<Diagram>();
        for (Diagram diagram : impactedDiagrams.values())
        {
            diagramSet.add(diagram);
        }
        if (!diagramSet.isEmpty())
        {
            dialog.setImpactedList(diagramSet);
            int result = dialog.open();
            if (result == Window.OK)
            {
                handleDrop(event);
                modeler.refreshActiveDiagram();
            }
        }
        else
        {
            handleDrop(event);
            modeler.refreshActiveDiagram();
        }
    }

    /**
     * Gets the impacted diagrams.
     * 
     * @param droppedElement the dropped element
     * 
     * @return the impacted diagrams
     */
    public static Map<GraphElement, Diagram> getImpactedDiagrams(EObject droppedElement)
    {
        Map<GraphElement, Diagram> result = new HashMap<GraphElement, Diagram>();
        Modeler m = Utils.getCurrentModeler();
        if (m != null)
        {
            Collection<Setting> references = Utils.getCrossReferences(droppedElement);
            for (Setting setting : references)
            {
                if (setting.getEObject() instanceof EMFSemanticModelBridge && !(setting.getEObject().eContainer() instanceof Diagram) && !(setting.getEObject().eContainer() instanceof GraphEdge))
                {
                    EMFSemanticModelBridge bridge = (EMFSemanticModelBridge) setting.getEObject();
                    Diagram diagram = Utils.getDiagram(bridge.getGraphElement());
                    if (diagram != null)
                    {
                        DiagramKeeper diKeeper = diKeepers.get(diagram.getSemanticModel().getPresentation());
                        if (diKeeper == null || (bridge.getGraphElement().eContainer() != null && !diKeeper.keep(bridge.getGraphElement())))
                        {
                            Diagram di = getDiagram(bridge);
                            if (di != null)
                            {
                                result.put(bridge.getGraphElement(), di);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Gets the diagram.
     * 
     * @param element the element
     * 
     * @return the diagram
     */
    private static Diagram getDiagram(EObject element)
    {
        while (!(element instanceof Diagram) && element != null)
        {
            element = element.eContainer();
        }
        return (Diagram) element;
    }

    /**
     * Handles the drop operations.<br>
     * This method is intended to be overridden by subclasses.
     * 
     * @param event the event
     */
    protected void handleDrop(DropTargetEvent event)
    {
        super.drop(event);
    }

    /**
     * Gets the modeler.
     * 
     * @return the modeler
     */
    protected Modeler getModeler()
    {
        return this.modeler;
    }

    /**
     * Gets the diagram keepers from the moveElementFilter extension point.
     * 
     * @return the diagram keepers
     */
    private static Map<String, DiagramKeeper> getDiagramKeepers()
    {
        Map<String, DiagramKeeper> result = new HashMap<String, DiagramKeeper>();
        final String extPoint = "moveElementFilter";
        IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(ModelerPlugin.getId(), extPoint);
        if (elements.length > 0)
        {
            for (IConfigurationElement element : elements)
            {
                try
                {
                    String classPresentation = element.getAttribute("configuration");
                    if (classPresentation != null)
                    {
                        result.put(classPresentation, (DiagramKeeper) element.createExecutableExtension("keeper"));
                    }
                }
                catch (CoreException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    protected void helper(DropTargetEvent event)
    {
        // If we can't do anything else, we'll provide the default select feedback
        // and enable auto-scroll and auto-expand effects.
        event.feedback = DND.FEEDBACK_SELECT | getAutoFeedback();

        // If we don't already have it, try to get the source early. We can't give
        // feedback if it's not available yet (this is platform-dependent).
        //
        if (source == null)
        {
            source = getDragSource(event);
            if (source == null)
            {
                // Clear out any old information from a previous drag.
                //
                dragAndDropCommandInformation = null;
                return;
            }
        }

        // Get the target object from the item widget and the mouse location in it.
        //
        Object target = extractDropTarget(event.item);
        float location = getLocation(event);

        // Determine if we can create a valid command at the current location.
        //
        boolean valid = false;

        // If we don't have a previous cached command...
        //
        if (command == null)
        {
            // We'll need to keep track of the information we use to create the
            // command, so that we can recreate it in drop.
            dragAndDropCommandInformation = new TopcasedDndCommandInformation(domain, target, location, event.operations, originalOperation, source);

            // Remember the target; create the command and test if it is executable.
            //
            commandTarget = target;
            command = dragAndDropCommandInformation.createCommand();
            valid = command.canExecute();
        }
        else
        {
            // Check if the cached command can provide DND feedback/revalidation.
            //
            if (target == commandTarget && command instanceof DragAndDropFeedback)
            {
                // If so, revalidate the command.
                //
                valid = ((DragAndDropFeedback) command).validate(target, location, event.operations, originalOperation, source);

                // Keep track of any changes to the command information.
                dragAndDropCommandInformation = new TopcasedDndCommandInformation(domain, target, location, event.operations, originalOperation, source);
            }
            else
            {
                // If not, dispose the current command and create a new one.
                //
                dragAndDropCommandInformation = new TopcasedDndCommandInformation(domain, target, location, event.operations, originalOperation, source);
                commandTarget = target;
                command.dispose();
                command = dragAndDropCommandInformation.createCommand();
                valid = command.canExecute();
            }
        }

        // If this command can provide detailed drag and drop feedback...
        //
        if (command instanceof DragAndDropFeedback)
        {
            // Use it for the operation and drag under effect.
            //
            DragAndDropFeedback dragAndDropFeedback = (DragAndDropFeedback) command;
            event.detail = dragAndDropFeedback.getOperation();
            event.feedback = dragAndDropFeedback.getFeedback() | getAutoFeedback();
        }
        else if (!valid)
        {
            // There is no executable command, so we'd better nix the whole deal.
            //
            event.detail = DND.DROP_NONE;
        }

        // // If we can't do anything else, we'll provide the default select feedback
        // // and enable auto-scroll and auto-expand effects.
        // event.feedback = DND.FEEDBACK_SELECT | getAutoFeedback();
        //
        // // If we don't already have it, try to get the source early. We can't give
        // // feedback if it's not available yet (this is platform-dependent).
        // //
        // boolean manageFeedBack = false ;
        // if (source == null)
        // {
        // source = getDragSource(event);
        // if (source == null)
        // {
        // // Clear out any old information from a previous drag.
        // //
        // dragAndDropCommandInformation = null;
        // return;
        // }
        // }
        //
        // // Get the target object from the item widget and the mouse location in it.
        // //
        // Object target = extractDropTarget(event.item);
        // Collection<Object> sources = null;
        // if (source instanceof Collection)
        // {
        // sources = (Collection<Object>) source;
        // }
        // else
        // {
        // sources = new ArrayList<Object>();
        // sources.add(source);
        // }
        // if (haveSameContainer(sources, target))
        // {
        // if ((event.operations & DND.DROP_MOVE) != 0)
        // {
        // EObject eContainer = ((EObject) target).eContainer();
        // if (OrderManager.getOrder(eContainer) != null)
        // {
        // event.detail = DND.DROP_MOVE;
        // manageFeedBack = true ;
        // // event.feedback = DND.FEEDBACK_INSERT_AFTER | DND.FEEDBACK_INSERT_BEFORE | DND.FEEDBACK_SELECT |
        // getAutoFeedback();
        // }
        // }
        // }
        // else
        // {
        // super.helper(event);
        // }
        // super.helper(event);
        // if (manageFeedBack)
        // {
        // event.feedback |= DND.FEEDBACK_INSERT_AFTER ;
        // }
    }

    protected boolean haveSameContainer(Collection<Object> list, Object e)
    {
        if (!(e instanceof EObject) || list == null)
        {
            return false;
        }
        EObject eE = (EObject) e;
        for (Object o : list)
        {
            if (!(o instanceof EObject))
            {
                return false;
            }
            EObject eO = (EObject) o;
            if (eE.eContainer() != eO.eContainer())
            {
                return false;
            }
        }
        return true;
    }

    public class TopcasedDndCommandInformation extends DragAndDropCommandInformation
    {

        public TopcasedDndCommandInformation(EditingDomain domain, Object target, float location, int operations, int operation, Collection< ? > source)
        {
            super(domain, target, location, operations, operation, source);
        }

        @Override
        public Command createCommand()
        {
            return new DragAndDropCommand(domain, target, location, operations, originalOperation, source)
            {

                @Override
                protected Collection< ? > getChildren(Object object)
                {
                    if (object instanceof EObject)
                    {
                        try
                        {
                            List<EObject> orderForAnElementAndElementsNotOrdered = OrderManager.getOrderForAnElementAndElementsNotOrdered((EObject) object);
                            if (orderForAnElementAndElementsNotOrdered != null)
                            {
                                return orderForAnElementAndElementsNotOrdered;
                            }
                        }
                        catch (OrderException e)
                        {
                        }
                    }
                    return super.getChildren(object);
                }

                @Override
                protected boolean prepareDropMoveInsert(Object parent, Collection< ? > children, int index)
                {
                    // We don't want to move insert an object before or after itself...
                    //
                    if (collection.contains(owner))
                    {
                        dragCommand = IdentityCommand.INSTANCE;
                        dropCommand = UnexecutableCommand.INSTANCE;
                    }
                    // If the dragged objects share a parent...
                    //
                    else if (children.containsAll(collection))
                    {
                        dragCommand = IdentityCommand.INSTANCE;

                        // Create move commands for all the objects in the collection.
                        //
                        CompoundCommand compoundCommand = new CompoundCommand();
                        List<Object> before = new ArrayList<Object>();
                        List<Object> after = new ArrayList<Object>();
                        int j = 0;
                        for (Object object : children)
                        {
                            if (collection.contains(object))
                            {
                                if (j < index)
                                {
                                    before.add(object);
                                }
                                else if (j > index)
                                {
                                    after.add(object);
                                }
                            }
                            ++j;
                        }

                        for (Object object : before)
                        {
                            if (OrderManager.isVirtualOrder() && parent instanceof EObject && object instanceof EObject)
                            {
                                manageOrder(parent, children, index - 1, compoundCommand, object);
                            }
                            else
                            {
                                compoundCommand.append(MoveCommand.create(domain, parent, null, object, index - 1));
                            }
                        }

                        for (ListIterator<Object> objects = after.listIterator(after.size()); objects.hasPrevious();)
                        {
                            Object object = objects.previous();
                            if (OrderManager.isVirtualOrder() && parent instanceof EObject && object instanceof EObject)
                            {
                                manageOrder(parent, children, index, compoundCommand, object);
                            }
                            else
                            {
                                compoundCommand.append(MoveCommand.create(domain, parent, null, object, index));
                            }
                        }

                        dropCommand = compoundCommand.getCommandList().size() == 0 ? (Command) IdentityCommand.INSTANCE : compoundCommand;
                    }
                    else if (isCrossDomain())
                    {
                        dragCommand = IdentityCommand.INSTANCE;
                        dropCommand = UnexecutableCommand.INSTANCE;
                    }
                    else
                    {
                        // Just remove the objects and add them.
                        //
                        dropCommand = AddCommand.create(domain, parent, null, collection, index);
                        if (analyzeForNonContainment(dropCommand))
                        {
                            dropCommand.dispose();
                            dropCommand = UnexecutableCommand.INSTANCE;
                            dragCommand = IdentityCommand.INSTANCE;
                        }
                        else
                        {
                            dragCommand = RemoveCommand.create(domain, collection);
                        }
                    }

                    boolean result = dragCommand.canExecute() && dropCommand.canExecute();
                    return result;
                }

                protected void manageOrder(Object parent, Collection< ? > children, int index, CompoundCommand compoundCommand, Object object)
                {
                    final EObject eParent = (EObject) parent;
                    EObject eObject = (EObject) object;
                    if (OrderManager.getOrder(eParent) != null)
                    {
                        EList<EObject> childrenOrder;
                        try
                        {
                            List<EObject> tmp = OrderManager.getOrderForAnElementAndElementsNotOrdered(eParent);
                            if (tmp == null)
                            {
                                childrenOrder = new BasicEList<EObject>(eParent.eContents());
                            }
                            else
                            {
                                childrenOrder = new BasicEList<EObject>(tmp);
                            }
                            compoundCommand.append(new CommandAdapter()
                            {
                                @Override
                                public void execute()
                                {
                                }

                                @Override
                                public void undo()
                                {
                                    modeler.refreshOutlineElement(eParent);
                                }
                            });
                            if (!childrenOrder.isEmpty())
                            {
                                childrenOrder.move(index, eObject);
                            }
                            compoundCommand.append(OrderManager.saveOrder(eParent, childrenOrder, domain));
                            compoundCommand.append(new CommandAdapter()
                            {
                                @Override
                                public void execute()
                                {
                                    modeler.refreshOutlineElement(eParent);
                                }

                                @Override
                                public void redo()
                                {
                                    modeler.refreshOutlineElement(eParent);
                                }

                            });
                        }
                        catch (OrderException e)
                        {
                        }
                    }
                }
            };
        }

    }

}
