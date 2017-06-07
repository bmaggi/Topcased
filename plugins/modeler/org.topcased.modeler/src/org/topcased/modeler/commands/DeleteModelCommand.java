/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies), 
 *    Jose Alfredo Serrano (Anyware Technologies) - initial API and implementation
 *    Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Fix delete errors
 *    Ludi Akue (ATOS ORIGIN) ludi.akue@atosorigin.com - Improve multi-deletion mechanism 
 *
 *****************************************************************************/
package org.topcased.modeler.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.providers.IDeleteObjectProvider;
import org.topcased.modeler.providers.IDeletePartnerProvider;
import org.topcased.modeler.utils.Utils;

/**
 * A command that erases an object from the model and all the associated graphical objects. <br>
 * 
 * Creation : 1 June 2005<br>
 * Updated : 17 February 2010<br>
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:tristan.faure@atosorigin.com"> Tristan Faure
 */
public class DeleteModelCommand extends CompoundCommand
{

    /** The Modeler editDomain */
    protected IMixedEditDomain editDomain;

    protected Diagrams diagrams;

    private boolean deleteAllReferences;

    /** This boolean stores if a "Go to root diagram" command have been added */
    private boolean goToRoot = false;

    private static Collection<EObject> contextualDeletedElements = new HashSet<EObject>();

    private Collection<EObject> objectsDeleting = new LinkedList<EObject>();

    private static boolean contextualStarting = false;

    /**
     * Stop listening. The session is stopped we clear our list of objects already deleted
     */
    public static void stopListening()
    {
        contextualDeletedElements.clear();
        contextualStarting = false;
    }

    /**
     * Start listening. The session is start we start to register the objects deleted
     */
    public static void initListening()
    {
        contextualDeletedElements.clear();
        contextualStarting = true;
    }

    /**
     * Constructor
     * 
     * @param domain
     * @param diagrams
     * @param model
     */
    public DeleteModelCommand(IMixedEditDomain domain, Diagrams diagrams, EObject model)
    {
        this(domain, diagrams, model, true);
    }

    /**
     * Constructor
     * 
     * @param domain
     * @param diagrams
     * @param model
     * @param deleteAllRef
     */
    public DeleteModelCommand(IMixedEditDomain domain, Diagrams diagrams, EObject model, boolean deleteAllRef)
    {
        super("Delete Object from Model");
        this.editDomain = domain;
        this.diagrams = diagrams;
        this.deleteAllReferences = deleteAllRef;
        initialize(model);
        objectsDeleting.add(model);
    }

    /**
     * Instantiates a new delete model command.
     * 
     * @param domain the domain
     * @param diagrams the diagrams
     * @param collec the collection of eobjects to delete
     */
    public DeleteModelCommand(IMixedEditDomain domain, Diagrams diagrams, Collection<EObject> collec)
    {
        super("Delete Object from Model");
        this.editDomain = domain;
        this.diagrams = diagrams;
        this.deleteAllReferences = true;
        initialize(collec);
        objectsDeleting.addAll(collec);
    }

    public Collection<EObject> getObjectsDeleting()
    {
        return objectsDeleting;
    }

    /**
     * Initialize a delete command from one eobject.
     * 
     * @param model the model
     */
    private void initialize(EObject model)
    {
        if (model != null)
        {
            List<Object> deletedObjects = new LinkedList<Object>();
            if (model instanceof Diagram)
            {
                deletedObjects.add((Diagram) model);
            }
            // check if it is not the main object
            if (model.eResource() != null && model != model.eResource().getContents().get(0))
            {
                deletedObjects.addAll(getCompleteList(model));
                manageGraphicalElements(deletedObjects);
                Command removeCmd = createRemoveCommand(deletedObjects);
                if (removeCmd != null && removeCmd.canExecute())
                {
                    add(removeCmd);
                }
            }
        }
    }

    /**
     * Add commands to delete graphical elements corresponding to deleted objects
     * 
     * @param deletedObjects
     * @param eobjectsToDeleteAfter
     */
    private void manageGraphicalElements(List<Object> deletedObjects)
    {
        List<GraphElement> deletedGraphElements = getDeleteGraphElements(deletedObjects);
        if (!deletedGraphElements.isEmpty())
        {
            moveDiagramsToObjectsToDeleteAfter(deletedGraphElements, deletedObjects);
            Command removeGraphCmd = createRemoveGraphCommand(deletedGraphElements);
            if (removeGraphCmd != null)
            {
                add(removeGraphCmd);
            }
        }
    }

    /**
     * This methods put the diagrams to the elements to delete after
     * 
     * @param deletedGraphElements
     * @param eobjectsToDeleteAfter
     */
    private void moveDiagramsToObjectsToDeleteAfter(List<GraphElement> deletedGraphElements, List<Object> eobjectsToDeleteAfter)
    {
        for (Iterator<GraphElement> i = deletedGraphElements.iterator(); i.hasNext();)
        {
            EObject current = i.next();
            if (current instanceof Diagram)
            {
                i.remove();
                eobjectsToDeleteAfter.add(current);
            }
        }
    }

    /**
     * Initialize a delete command from a collection of eobject.
     * 
     * @param collec the collection to initialize
     */
    private void initialize(Collection<EObject> collec)
    {
        List<Object> deletedList = new LinkedList<Object>();
        for (EObject obj : collec)
        {
            if (obj instanceof Diagram)
            {
                deletedList.add((Diagram) obj);
            }
            // in case of children
            // FIXME (LOST MESSAGE): added the first condition to if
            if (obj != null && obj.eResource() != null && obj != obj.eResource().getContents().get(0))
            {
                List<Object> deletedObjects = getCompleteList(obj);
                deletedList.addAll(deletedObjects);
                manageGraphicalElements(deletedList);
            }
        }
        if (!deletedList.isEmpty())
        {
            Command removeCmd = createRemoveCommand(deletedList);
            if (removeCmd != null && removeCmd.canExecute())
            {
                add(removeCmd);
            }
        }

    }

    /**
     * Create the remove command for a diagram
     * 
     * @param diagram the diagram to remove
     * @return the command or <code>null</code> if action cannot be performed
     */
    protected Command createRemoveDiagramCommand(Diagram diagram)
    {
        List<Object> deletedObjects = new ArrayList<Object>();
        deletedObjects.add(diagram);
        return createRemoveCommand(deletedObjects);
    }

    /**
     * Create the CompoundCommand that remove model objects
     * 
     * @param deletedObjects the list that contain the model objects to remove
     * @return the CompoundCommand
     */
    protected Command createRemoveCommand(List<Object> deletedObjects)
    {
        // CompoundCommand removeCmd = null;
        org.eclipse.emf.common.command.CompoundCommand removeCmd = new org.eclipse.emf.common.command.CompoundCommand();
        CompoundCommand finalCommand = new CompoundCommand();
        final Collection<EObject> deletes = new HashSet<EObject>();
        Collection<EObject> removes = new HashSet<EObject>();
        // performance issue:
        // to improve performance it's better to create one EmftoGef command
        // and to add all the deletion in ONE DeleteCommand
        // then EMF can optimize the process
        if (deletedObjects != null && !deletedObjects.isEmpty())
        {
            // removeCmd = new CompoundCommand();
            for (Object obj : deletedObjects)
            {
                // The list may contains wrapped objects
                if (obj instanceof EObject)
                {
                    goToRootDiagram(obj, finalCommand);

                    List<EObject> objList = new ArrayList<EObject>();

                    // The object must be wrapped if necessary
                    Object wrappedObj = obj;
                    // Get the AdapterFactoryEditingDomain
                    EditingDomain domain = editDomain.getEMFEditingDomain();
                    if (domain instanceof AdapterFactoryEditingDomain)
                    {
                        // getWrapper takes a lot of time to optimize the process we call it
                        // only if obj satisfies the condition bellow
                        if (obj instanceof IWrapperItemProvider || obj instanceof FeatureMap.Entry)
                        {
                            wrappedObj = ((AdapterFactoryEditingDomain) domain).getWrapper(obj);
                        }
                    }
                    objList.add((EObject) wrappedObj);
                    if (deleteAllReferences)
                    {
                        // org.eclipse.emf.common.command.Command cmd =
                        // DeleteCommand.create(editDomain.getEMFEditingDomain(), objList);
                        // FIX the bug Topcased #277 the Model object must be deleted first, and only after references
                        // are deleted
                        deletes.addAll(objList);
                    }
                    else
                    {
                        removes.addAll(objList);
                    }
                }
            }
        }
        if (!deletes.isEmpty())
        {
            if (contextualStarting)
            {
                clean(deletes);
                contextualDeletedElements.addAll(deletes);
            }
            // maybe after the clean deletes is now empty
            if (!deletes.isEmpty())
            {
                removeCmd.append(DeleteCommand.create(editDomain.getEMFEditingDomain(), deletes));
                removeCmd.append(new UnsetCrossReferencerCommand(deletes));
            }
        }
        if (!removes.isEmpty())
        {
            if (contextualStarting)
            {
                clean(removes);
                contextualDeletedElements.addAll(removes);
            }
            // maybe after the clean removes is now empty
            if (!removes.isEmpty())
            {
                removeCmd.append(RemoveCommand.create(editDomain.getEMFEditingDomain(), removes));
            }
        }
        if (!removeCmd.getCommandList().isEmpty())
        {
            finalCommand.add(new EMFtoGEFCommandWrapper(removeCmd));
        }
        return finalCommand;
    }

    /**
     * Clean the collection if the element already managed
     * 
     * @param collec the collection
     */
    private void clean(Collection<EObject> collec)
    {
        // we check if the object is already deleted in the current session
        for (Iterator<EObject> i = collec.iterator(); i.hasNext();)
        {
            EObject eo = i.next();
            if (contextualDeletedElements.contains(eo))
            {
                i.remove();
            }
        }
        // clean objects contained to not delete twice
        cleanForAncestor(collec, collec);
        // clean objects which parents are already deleted
        cleanForAncestor(collec, contextualDeletedElements);
    }

    private void cleanForAncestor(Collection<EObject> collec, Collection<EObject> target)
    {
        for (Iterator<EObject> i = collec.iterator(); i.hasNext();)
        {
            EObject eo = i.next();
            for (int j = 0; j < target.size(); j++)
            {
                Object o2 = target.toArray()[j];
                if (o2 instanceof EObject)
                {
                    EObject eo2 = (EObject) o2;
                    if (eo2 != eo)
                    {
                        if (EcoreUtil.isAncestor(eo2, eo))
                        {
                            i.remove();
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Add a "Go to Root diagram" command if needed
     * 
     * @param deletedObj the deleted object
     * @param removeCmd the list of commands
     */
    private void goToRootDiagram(Object deletedObj, CompoundCommand removeCmd)
    {
        if (deletedObj != null && !goToRoot)
        {
            // Return to root diagram if needed
            EObject unwrapObject = (EObject) AdapterFactoryEditingDomain.unwrap(deletedObj);
            // Check if the active diagram is not a child of the deleted sub-tree
            final Modeler modeler = (Modeler) editDomain.getEditorPart();
            EObject diagObject = Utils.getElement(modeler.getActiveDiagram());
            if (diagObject != null && (diagObject.equals(unwrapObject) || EcoreUtil.isAncestor(unwrapObject, diagObject) || deletedObj.equals(modeler.getActiveDiagram())))
            {
                // If it is, return to the root diagram
                removeCmd.add(new Command()
                {
                    @Override
                    public void execute()
                    {
                        Diagram rootDiagram = DiagramsUtils.getRootDiagram(modeler.getDiagrams());
                        if (rootDiagram != modeler.getActiveDiagram())
                        {
                            modeler.setActiveDiagram(rootDiagram);
                        }
                        else
                        {
                            // The diagram that is being deleted was the last diagram of the model
                            modeler.setActiveDiagram(null);

                            // TODO : There is a bug when we try to delete the current Root diagram while another
                            // diagram exists and may be the new Root Diagram, the NoDiagramConfiguration is then
                            // activated
                        }
                    }
                });
            }

            goToRoot = true;
        }
    }

    /**
     * Create the CompoundCommand that remove the GraphElement objects
     * 
     * @param deletedGraphElts the list that contain the graphElements to remove
     * @return the CompoundCommand
     */
    protected Command createRemoveGraphCommand(List<GraphElement> deletedGraphElts)
    {
        CompoundCommand removeCmd = null;
        if (deletedGraphElts != null && !deletedGraphElts.isEmpty())
        {
            removeCmd = new CompoundCommand();

            for (GraphElement elt : deletedGraphElts)
            {
                if (elt instanceof Diagram)
                {
                    Command removeDiag = createRemoveDiagramCommand((Diagram) elt);
                    if (removeDiag != null)
                    {
                        removeCmd.add(removeDiag);
                    }
                }
                else
                {
                    DeleteGraphElementCommand deleteCmd = new DeleteGraphElementCommand(elt, true);
                    if (deleteCmd != null)
                    {
                        removeCmd.add(deleteCmd);
                    }
                }
            }
        }

        return removeCmd;
    }

    private List<GraphElement> getDeleteGraphElements(List<Object> deletedObjects)
    {
        List<GraphElement> elementList = new ArrayList<GraphElement>();

        // Browse each diagram
        for (Diagram diag : DiagramsUtils.findAllDiagrams((Diagrams) EcoreUtil.getRootContainer(diagrams)))
        {
            checkElement(diag, deletedObjects, elementList);
        }

        return elementList;
    }

    private void checkElement(GraphElement elt, List<Object> deletedObjects, List<GraphElement> deletedGraphElt)
    {
        EObject model = Utils.getElement(elt);
        // Check that the model object is part of the elements to be deleted
        if (model != null && isDelete(model, deletedObjects))
        {
            // Check whether the GraphElement should be deleted
            if (!deletedGraphElt.contains(elt))
            {
                deletedGraphElt.add(elt);
            }
        }
        else
        {
            // We check whether all the children that will be deleted too
            for (DiagramElement child : elt.getContained())
            {
                if (child instanceof GraphElement)
                {
                    checkElement((GraphElement) child, deletedObjects, deletedGraphElt);
                }
            }
        }
    }

    private boolean isDelete(EObject model, List<Object> deletedObjects)
    {
        if (deletedObjects.contains(model) || EcoreUtil.isAncestor(deletedObjects, model))
        {
            return true;
        }

        return false;
    }

    /**
     * This method iterates on the selection and complete with EObjects that must be deleted from each object of the
     * selection.
     * 
     * @param selection the initial selection
     * @return the new list of objects to delete
     */
    protected List<Object> getCompleteList(EObject selection)
    {
        List<Object> completeList = new ArrayList<Object>();
        addObject(selection, completeList);

        return completeList;
    }

    private void addObject(Object selection, List<Object> listToAppend)
    {
        // Check whether the selected object is not linked with the main diagram
        Diagram d = DiagramsUtils.getRootDiagram(diagrams);
        EObject model = Utils.getElement(d);
        if (selection.equals(model))
        {
            return;
        }

        // Check that the selected object is not a direct child of the root object
        AdapterFactory adapterFactory = editDomain.getAdapterFactory();
        IDeleteObjectProvider deleteObjectProvider = null;
        if (adapterFactory != null)
        {
            deleteObjectProvider = (IDeleteObjectProvider) adapterFactory.adapt(selection, IDeleteObjectProvider.class);
            if (deleteObjectProvider != null && !deleteObjectProvider.canBeDeleted(selection))
            {
                return;
            }
        }

        // Handle the rest of the model objects which can be deleted
        if (selection instanceof EObject && !listToAppend.contains(selection))
        {
            for (Iterator<EObject> iter = ((EObject) selection).eContents().iterator(); iter.hasNext();)
            {
                addObject(iter.next(), listToAppend);
            }

            if (!listToAppend.contains(selection))
            {
                listToAppend.add(selection);
            }

            // Deals with dependent objects
            if (adapterFactory != null)
            {
                // Get the provider from the adapterFactory
                IDeletePartnerProvider deleteProvider = (IDeletePartnerProvider) adapterFactory.adapt(selection, IDeletePartnerProvider.class);

                // Add dependencies
                if (deleteProvider != null)
                {
                    for (EObject obj : deleteProvider.getDeletePartners(selection))
                    {
                        addObject(obj, listToAppend);
                        // add the current model element to the list of deleted element.
                        objectsDeleting.add(obj);
                    }
                }
            }
        }
    }
}
