/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.actions;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.topcased.modeler.commands.DeleteGraphElementCommand;
import org.topcased.modeler.commands.EMFtoGEFCommandWrapper;
import org.topcased.modeler.commands.EObjectInheritanceCopyCommand;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.edit.EMFGraphEdgeEditPart;
import org.topcased.modeler.edit.EMFGraphNodeEditPart;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.exceptions.BoundsFormatException;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.tools.Importer;
import org.topcased.modeler.utils.CommandAdapter;
import org.topcased.modeler.utils.Utils;

/**
 * The Class GenericTransformer. permits to transform an eobject of eclass to another eclass
 */
public class GenericTransformer
{

    private static HashMap<String, AdapterFactory> factories = new HashMap<String, AdapterFactory>();

    private static final String EXT_FACTORIES = "org.eclipse.emf.edit.itemProviderAdapterFactories";

    private CompoundCommand globalCommand;

    private Modeler modeler;

    private EObject element;

    private Map<Diagram, GraphElement> map = new HashMap<Diagram, GraphElement>();

    // the edit part in input
    private AbstractGraphicalEditPart inpart;

    private IMixedEditDomain mixedDomain;

    private EObjectInheritanceCopyCommand commandModel;

    private boolean graphCopy = true;

    private ImporterCommand importerCommand;

    /**
     * Instantiates a new generic transformer.
     * 
     * @param currentNode the current node
     */
    public GenericTransformer(AbstractGraphicalEditPart currentNode)
    {
        this(currentNode, true);
    }

    /**
     * Instantiates a new generic transformer. and specify if we have to perform graphical copy
     * 
     * @param currentNode the current node
     * @param graphCopy the graph copy
     */
    public GenericTransformer(AbstractGraphicalEditPart currentNode, boolean graphCopy)
    {
        this.graphCopy = graphCopy;
        if (currentNode != null)
        {
            inpart = currentNode;
            if (currentNode instanceof EMFGraphNodeEditPart)
            {
                this.element = ((EMFGraphNodeEditPart) inpart).getEObject();
            }
            else if (currentNode instanceof EMFGraphEdgeEditPart)
            {
                this.element = ((EMFGraphEdgeEditPart) inpart).getEObject();
            }
        }
    }

    /**
     * Instantiates a new generic transformer.
     * 
     * @param currentEobject the current eobject
     */
    public GenericTransformer(EObject currentEobject)
    {
        this.element = currentEobject;
    }

    /**
     * Transform.
     * 
     * @param eclass the eclass in target
     */
    public void transform(EClass eclass)
    {
        globalCommand = new TransformationCommand("Generic Transformation");
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        modeler = (Modeler) editor;
        if (graphCopy)
        {
            GraphElement[] graphElements = Utils.getGraphElements(modeler.getDiagrams(), element);
            for (GraphElement gelement : graphElements)
            {
                map.put(Utils.getDiagram(gelement), gelement);
            }
        }
        if (editor instanceof Modeler)
        {
            // get mixed editing domain to do transaction
            mixedDomain = (IMixedEditDomain) modeler.getAdapter(IMixedEditDomain.class);
            // maybe extension point for stereotypes
            EObject model = (EObject) AdapterFactoryEditingDomain.unwrap(element);
            commandModel = new EObjectInheritanceCopyCommand(model, eclass, mixedDomain.getEMFEditingDomain());
            globalCommand.add(new EMFtoGEFCommandWrapper(commandModel));
            if (graphCopy)
            {
                importerCommand = new ImporterCommand();
                globalCommand.add(new EMFtoGEFCommandWrapper(importerCommand));

            }
            if (globalCommand.canExecute())
            {
                try
                {
                    // drop caches about input element
                    ECrossReferenceAdapter cross = ECrossReferenceAdapter.getCrossReferenceAdapter(element);
                    if (cross != null)
                    {
                        cross.unsetTarget(element);
                    }
                    mixedDomain.getGEFCommandStack().execute(globalCommand);
                }
                catch (Exception e)
                {
                    MessageDialog.openWarning(Display.getDefault().getActiveShell(), "Problems during transformation", "It seems the transformation you want to perform can't be executed");
                    e.printStackTrace();
                }
                // graph copy
            }
            else
            {
                MessageDialog.openWarning(Display.getDefault().getActiveShell(), "Problems during transformation", "It seems the transformation you want to perform can't be executed");
            }
        }
    }

    /**
     * Gets the object result of transformation.
     * 
     * @return the object result of transformation from source eobject
     */
    public EObject getEObjectResultOfTransformation()
    {
        EObject result = null;
        if (commandModel != null)
        {
            result = commandModel.getResultEobject();
        }
        return result;
    }

    private final class TransformationCommand extends CompoundCommand
    {
        private TransformationCommand(String label)
        {
            super(label);
        }

        @Override
        public boolean canUndo()
        {
            return true;
        }

        @Override
        public void redo()
        {
            for (ListIterator<Command> commands = getCommands().listIterator(); commands.hasNext();)
            {
                try
                {
                    Command command = commands.next();
                    command.redo();
                }
                catch (RuntimeException exception)
                {
                    // Skip over the command that threw the exception.
                    //
                    commands.previous();

                    try
                    {
                        // Iterate back over the executed commands to undo them.
                        //
                        while (commands.hasPrevious())
                        {
                            Command command = commands.previous();
                            command.undo();
                        }
                    }
                    catch (RuntimeException nestedException)
                    {
                    }
                    MessageDialog.openError(Display.getDefault().getActiveShell(), "Problems during Redo", "An error occurs redoing the command is not possible");
                    ModelerPlugin.log(exception);
                    return;
                }
            }
        }

        @Override
        public void undo()
        {
            for (ListIterator<Command> commands = getCommands().listIterator(getCommands().size()); commands.hasPrevious();)
            {
                try
                {
                    Command command = commands.previous();
                    command.undo();
                }
                catch (RuntimeException exception)
                {
                    // Skip over the command that threw the exception.
                    //
                    commands.next();

                    try
                    {
                        // Iterate forward over the undone commands to redo them.
                        //
                        while (commands.hasNext())
                        {
                            Command command = commands.next();
                            command.redo();
                        }
                    }
                    catch (RuntimeException nestedException)
                    {
                        CommonPlugin.INSTANCE.log(new WrappedException(CommonPlugin.INSTANCE.getString("_UI_IgnoreException_exception"), nestedException).fillInStackTrace());
                    }
                    MessageDialog.openError(Display.getDefault().getActiveShell(), "Problems during Undo", "An error occurs undoing the command is not possible");
                    ModelerPlugin.log(exception);
                    return;
                }
            }
        }
    }

    /**
     * The Class ImporterCommand. permits to add the importer in the compound command
     */
    private class ImporterCommand extends CommandAdapter
    {

        private CompoundCommand importerCommand = null;

        @Override
        public void execute()
        {
            importerCommand = new CompoundCommand();
            graphCopy(mixedDomain, commandModel.getResultEobject());
            // content of importerCommand has already been executed
        }

        @Override
        public void undo()
        {
            if (importerCommand != null)
            {
                importerCommand.undo();
            }
        }

        @Override
        public void redo()
        {
            if (importerCommand != null)
            {
                importerCommand.redo();
            }
        }

        /**
         * Graph copy, make a drag and drop of the new object on all diagrams
         * 
         * @param mixedDomain the mixed domain
         * @param target the target
         * @param globalCommand2
         * @param graphElement the graph element
         * @param oldLocation the old location
         * @param editpart the editpart
         */
        private void graphCopy(IMixedEditDomain domain, EObject target)
        {
            Diagram first = modeler.getActiveDiagram();
            for (Diagram diagram : map.keySet())
            {
                modeler.setActiveDiagram(diagram);
                RootEditPart editpart = modeler.getRootEditPart();
                // Set the active diagram on the diagram that contains the element
                GraphElement graphElement = map.get(diagram);
                Importer importer = new Importer(modeler, target);
                importer.setDoNotUseCommandStack();
                importer.setCtrlKeyDown(false);
                GraphicalEditPart editP = null;
                // if (current != null && !(graphElement.eContainer() instanceof Diagram))
                // {
                // editP = getParentOfCurrent(current, graphElement.eContainer());
                // }
                // else
                // {
                editP = (GraphicalEditPart) editpart.getViewer().getEditPartRegistry().get(graphElement.eContainer());
                if (editP == null)
                {
                    editP = (GraphicalEditPart) editpart.getViewer().getEditPartRegistry().get(diagram);
                }
                // }
                if (editP != null)
                {
                    // we validate the parent of the target edit part to force coordinates to be updated
                    editP.getFigure().getParent().validate();
                    Point location = graphElement.getPosition();
                    importer.setTargetEditPart(editP);
                    importer.setDisplayDialogs(false);
                    importer.setAutoLayout(false);
                    if (location != null)
                    {
                        importer.setLocation(location.getCopy(), false);
                    }
                    try
                    {
                        // we remove it to not have context problem (restore connection)
                        DeleteGraphElementCommand deletecommand = new DeleteGraphElementCommand(graphElement, true);
                        // deleteGraphEdges(graphElement);
                        deletecommand.execute();
                        importerCommand.add(deletecommand);
                        importer.run(new NullProgressMonitor());
                        CompoundCommand importerRunCmd = importer.getRunExecutedCommand();
                        if (importerRunCmd != null)
                        {
                            importerCommand.add(importerRunCmd);
                        }
                    }
                    catch (BoundsFormatException e)
                    {
                        ModelerPlugin.log(e);
                        e.printStackTrace();
                        showError(e.getMessage());
                    }
                    catch (IllegalArgumentException e)
                    {
                        ModelerPlugin.log(e);
                        e.printStackTrace();
                        showError(e.getMessage());
                    }
                    catch (InterruptedException e)
                    {
                        ModelerPlugin.log(e);
                        e.printStackTrace();
                        showError(e.getMessage());
                    }
                    catch (Exception e)
                    {
                        ModelerPlugin.log(e);
                        e.printStackTrace();
                        showError("it seems the object created can't be displayed graphically correctly");
                    }

                }
            }
            modeler.setActiveDiagram(first);

        }

    }

    /**
     * Show a error message dialog.
     * 
     * @param string the string
     */
    private void showError(String string)
    {
        MessageDialog.openWarning(Display.getDefault().getActiveShell(), "Warning", string);
    }

    /**
     * Gets the all super types.
     * 
     * @param class1 the class1
     * 
     * @return the all super types
     */
    public static HashSet<EClass> getAllSuperTypes(EClass class1)
    {
        HashSet<EClass> results = new HashSet<EClass>();
        results.addAll(class1.getEAllSuperTypes());
        return results;
    }

    /**
     * Gets the edit factory.
     * 
     * @param eobject the eobject
     * 
     * @return the edits the factory
     */
    public static AdapterFactory getEditFactory(EObject eobject)
    {
        String uri = eobject.eClass().getEPackage().getNsURI();
        return getFactory(uri);
    }

    /**
     * Gets the factory from uri.
     * 
     * @param uri the uri
     * 
     * @return the factory
     */
    public static AdapterFactory getFactory(String uri)
    {
        AdapterFactory factory = factories.get(uri);
        if (factory == null)
        {
            IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(EXT_FACTORIES);
            for (IConfigurationElement e : extensions)
            {
                if (uri.equals(e.getAttribute("uri")))
                {
                    try
                    {
                        factory = (AdapterFactory) e.createExecutableExtension("class");
                        if (factory != null)
                        {
                            factories.put(uri, factory);
                        }
                    }
                    catch (CoreException e1)
                    {
                        // do nothing
                    }
                }
            }
        }
        return factory;
    }

    /**
     * Checks if a transformation is possible.
     * 
     * @param eclass the eclass
     * 
     * @return the multi status
     */
    public MultiStatus isTransformationPossible(EClass eclass)
    {
        MultiStatus result = new MultiStatus(ModelerPlugin.getId(), 0, "Type incompatibility", null);
        if (element != null)
        {
            Collection<Setting> usages = EObjectInheritanceCopyCommand.getUsages(element);
            if (usages != null)
            {
                for (EStructuralFeature.Setting nonNavigableInverseReference : usages)
                {
                    EStructuralFeature structuralFeature = nonNavigableInverseReference.getEStructuralFeature();
                    if (!(nonNavigableInverseReference.getEObject() instanceof EMFSemanticModelBridge))
                    {
                        boolean compatible = EObjectInheritanceCopyCommand.isCompatible(structuralFeature.getEType(), eclass);
                        if (!compatible)
                        {
                            String econtainer = structuralFeature.eContainer() instanceof EClassifier ? ((EClassifier) structuralFeature.eContainer()).getName() + " ( "
                                    + nonNavigableInverseReference.getEObject().toString() + " )" : structuralFeature.eContainer().toString();
                            Status s = new Status(Status.WARNING, ModelerPlugin.getId(), String.format(
                                    "an element typed %s references your selection, we can not assign instead of your selection an object typed %s", econtainer, eclass.getName()));
                            result.add(s);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void dispose()
    {
        factories.clear();
    }

}
