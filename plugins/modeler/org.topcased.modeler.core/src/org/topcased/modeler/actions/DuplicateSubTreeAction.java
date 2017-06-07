/*****************************************************************************
 * 
 * DuplicateSubTreeAction.java
 * 
 * Copyright (c) 2005-2008 TOPCASED consortium.
 *
 * Contributors:
 *  Thibault Landr� (Atos Origin) <a href="mailto:thibault.landre@atosorigin.com">Thibault Landr�</a>
 *  Thomas Szadel (Atos Origin) <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.topcased.modeler.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.Action;
import org.topcased.modeler.DuplicationAdapter;
import org.topcased.modeler.commands.CreateDiagramsCommand;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.collaboration.ModelUtil;
import org.topcased.modeler.utils.LabelHelper;

/**
 * An action used to duplicate a model subtree. The new subtree is added at the same level. The diagrams associated with
 * the duplicated model subtree are also duplicated. The duplication process can be customized to include additional
 * elements and perform post-processing using the <code>org.topcased.modeler.duplicationAdater</code> extension point.
 * 
 * Creation 20 Mai 08
 * 
 * @author <a href="mailto:thibault.landre@atosorigin.com">Thibault Landr�</a>
 * @see DuplicationAdapter
 */
public class DuplicateSubTreeAction extends Action
{
    private static final String FULL_PREFIX = "Copy of";

    private static final String EXTENSION_POINT_NAMESPACE = "org.topcased.modeler";

    private static final String EXTENSION_POINT_NAME = "duplicationAdapter";

    private static final String ADAPTER_ELEMENT_NAME = "adapter";

    private static final String METAMODEL_ATTRIBUTE_NAME = "metamodel";

    private static final String IMPLEMENTATION_ATTRIBUTE_NAME = "class";

    private EObject duplicateObject;

    private Modeler modeler;

    /**
     * Constructor
     * 
     * @param modeler The modeler
     * @param selectedObject the selected object
     */
    public DuplicateSubTreeAction(Modeler modeler, EObject selectedObject)
    {
        super("Duplicate subtree", ModelerPlugin.getImageDescriptor("icons/duplicateSubtree.png"));
        this.modeler = modeler;
        this.duplicateObject = selectedObject;
    }

    /**
     * The action is only enabled if the target object's container is not read-only (in that case we could not add the
     * duplicate).
     * 
     * @see org.eclipse.jface.action.Action#isEnabled()
     */
    @Override
    public boolean isEnabled()
    {
        Resource parentResource = duplicateObject.eContainer().eResource();
        return !modeler.getEditingDomain().isReadOnly(parentResource);
    }

    /**
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    public void run()
    {
        DuplicationAdapter adapter = getAdapterFor(duplicateObject);
        EditingDomain editingDomain = modeler.getEditingDomain();
        DuplicateSubtreeCommand duplicationCmd = new DuplicateSubtreeCommand(editingDomain, adapter);
        editingDomain.getCommandStack().execute(duplicationCmd);
    }

    /**
     * Finds the list of Diagram and Diagrams to copy from the root.
     * 
     * @param obj The root model.
     * @return The list of diagrams.
     */
    private Collection<Diagram> findDiagramRootsToCopy(EObject obj)
    {
        Collection<Diagram> result = new ArrayList<Diagram>();
        List<Diagram> diags = DiagramsUtils.findAllExistingDiagram(modeler.getDiagrams(), obj);
        if (!diags.isEmpty())
        {
            result.addAll(diags);
        }
        for (EObject child : obj.eContents())
        {
            result.addAll(findDiagramRootsToCopy(child));
        }
        return result;
    }

    /**
     * Update the references of the models.
     * 
     * @param objects The new objects.
     * @param mapping The mapping (see siblings)
     */
    private void updateReferences(Collection<EObject> objects, Map<EObject, EObject> mapping)
    {
        for (EObject obj : objects)
        {
            ModelUtil.updateReferences(obj, mapping);
        }
    }

    /**
     * Copy an EObject and add the copy as a sibling of the original (i.e. in the same container, through the same
     * containment feature). Returns a mapping from original objects to their copies.
     * 
     * @return a mapping from original objects to their copies.
     */
    private Map<EObject, EObject> copyWithSiblings(EObject obj)
    {
        Map<EObject, EObject> originalToCopy = copy(obj);
        List<EObject> siblings = findSiblings(obj);
        if (siblings != null)
        {
            EObject copied = originalToCopy.get(obj);
            siblings.add(copied);
        }

        return originalToCopy;
    }

    /**
     * Renames the copied model object in order to give it the following pattern : <code>Copy of XXXXX.xxx(Y)</code>
     * where Y is the number of copies done.
     * 
     * @param copied The model object copied
     */
    private void renameCopied(EObject copied)
    {
        EditDomain domain = (EditDomain) modeler.getAdapter(EditDomain.class);
        String currentName = LabelHelper.INSTANCE.getName(domain, copied);
        
        // Skip renaming process if the eObject is not named
        if (currentName != null)
        {
            String proposition = FULL_PREFIX.concat(" ").concat(currentName);
            if (LabelHelper.INSTANCE.isNameAvailable(domain, copied.eContainer(), proposition))
            {
                LabelHelper.INSTANCE.setName(domain, copied, proposition);
            }
            else
            {
                renameCopiedWithIndex(copied, proposition);
            }
        }
    }

    /**
     * Renames the copied model object in order to give it the following pattern : <code>Copy of XXXXX.xxx(Y)</code>
     * where Y is the number of copies done.
     * 
     * @param copied The model object copied
     */
    private void renameCopiedWithIndex(EObject copied, String name)
    {
        int numberOfCopies = 1;
        EditDomain domain = (EditDomain) modeler.getAdapter(EditDomain.class);
        String suffix = "(" + numberOfCopies + ")";
        while(!LabelHelper.INSTANCE.isNameAvailable(domain, copied.eContainer(), name.concat(suffix)))
        {
            suffix = "(" + numberOfCopies++ + ")";
        }
        LabelHelper.INSTANCE.setName(domain, copied, name.concat(suffix));
    }

    /**
     * Finds the siblings of an object (where its duplicate will be be added).
     * 
     * @param obj The objects.
     * @return The siblings or null if not found.
     */
    private EList<EObject> findSiblings(EObject obj)
    {
        EObject container = obj.eContainer();
        if (container == null)
        {
            // Objects with no explicit container (e.g. stereotypes) are put directly in the resource.
            return obj.eResource().getContents();
        }
        for (EStructuralFeature feature : container.eClass().getEAllContainments())
        {
            if (!feature.isMany() || feature.isDerived())
            {
                continue;
            }
            @SuppressWarnings("unchecked")
            EList<EObject> siblings = (EList<EObject>) container.eGet(feature);
            if (siblings.contains(obj))
            {
                return siblings;
            }
        }
        return null;
    }

    /**
     * Copy an EObject tree and return a mapping from original objects to their copies.
     * 
     * @return A mapping from original objects to their copies.
     */
    private Map<EObject, EObject> copy(EObject obj)
    {
        Copier copier = new Copier();
        copier.copy(obj);
        copier.copyReferences();
        return copier;
    }

    private class DuplicateSubtreeCommand extends AbstractCommand
    {
        private final EditingDomain editingDomain;

        private final DuplicationAdapter adapter;

        private Collection<EObject> rootObjectsCreated = new ArrayList<EObject>();

        private Command postCmd;

        private CreateDiagramsCommand createDiagramsCommand;

        public DuplicateSubtreeCommand(EditingDomain editingDomain, DuplicationAdapter adapter)
        {
            this.editingDomain = editingDomain;
            this.adapter = adapter;
        }

        public void execute()
        {
            redo();
        }

        public void redo()
        {
            rootObjectsCreated.clear();
            createDiagramsCommand = null;

            // Step 1: duplicate the main semantic elements
            Map<EObject, EObject> modelOriginalToCopy = copyWithSiblings(duplicateObject);
            rootObjectsCreated.add(modelOriginalToCopy.get(duplicateObject));

            // Step 2: duplicate any additional elements specified by an extension
            Collection<EObject> additionalObjects = adapter.getAdditionalObjects(duplicateObject);
            Map<EObject, EObject> additionalObjectToCopy = new HashMap<EObject, EObject>();
            for (EObject obj : additionalObjects)
            {
                additionalObjectToCopy.putAll(copyWithSiblings(obj));
                rootObjectsCreated.add(additionalObjectToCopy.get(obj));
            }
            updateReferences(additionalObjectToCopy.values(), modelOriginalToCopy);
            modelOriginalToCopy.putAll(additionalObjectToCopy);

            // Step 3: duplicate the corresponding diagrams
            Map<EObject, EObject> diagramOriginalToCopy = new HashMap<EObject, EObject>();
            Collection<Diagram> diagramRootsToCopy = findDiagramRootsToCopy(duplicateObject);
            for (EObject obj : diagramRootsToCopy)
            {
                Map<EObject, EObject> mapping = copyWithSiblings(obj);
                rootObjectsCreated.add(mapping.get(obj));
                // The diagram has to be moved inside the new Diagrams container.
                EObject newObj = mapping.get(obj);
                if (newObj instanceof Diagram)
                {
                    Diagram srcDiag = (Diagram) obj;
                    Diagram newDiag = (Diagram) newObj;
                    // rename the diagram as follow "Copy of diagram name"
                    newDiag.setName(FULL_PREFIX.concat(" ").concat(newDiag.getName()));
                    EObject newElement = modelOriginalToCopy.get(((EMFSemanticModelBridge) srcDiag.getSemanticModel()).getElement());
                    ((EMFSemanticModelBridge) newDiag.getSemanticModel()).setElement(newElement);
                    if (DiagramsUtils.findNearestContainerDiagrams(modeler.getDiagrams(), newElement) == null)
                    {
                        createDiagramsCommand = new CreateDiagramsCommand(modeler, newElement.eContainer());
                        ((CommandStack) modeler.getAdapter(CommandStack.class)).execute(createDiagramsCommand);
                    }

                    Diagrams newDiagrams = DiagramsUtils.moveDiagram(modeler.getDiagrams(), newDiag);
                    if (newDiagrams != null)
                    {
                        rootObjectsCreated.add(newDiagrams);
                    }
                }
                diagramOriginalToCopy.putAll(mapping);
            }
            updateReferences(diagramOriginalToCopy.values(), modelOriginalToCopy);

            // Step 4: perform any post-processing required by an extension
            postCmd = adapter.getPostProcessingCommand(modeler.getEditingDomain(), duplicateObject, modelOriginalToCopy, additionalObjectToCopy);
            editingDomain.getCommandStack().execute(postCmd);

            // Step 5: rename the object as follow "Copy of XXXX.xxx (Y)"
            renameCopied(modelOriginalToCopy.get(duplicateObject));
        }

        /**
         * @see org.eclipse.emf.common.command.AbstractCommand#prepare()
         */
        @Override
        protected boolean prepare()
        {
            return true;
        }

        /**
         * @see org.eclipse.emf.common.command.AbstractCommand#canUndo()
         */
        @Override
        public boolean canUndo()
        {
            return true;
        }

        /**
         * @see org.eclipse.emf.common.command.AbstractCommand#undo()
         */
        @Override
        public void undo()
        {
            if (postCmd.canUndo())
            {
                postCmd.undo();                
            }
            for (EObject obj : rootObjectsCreated)
            {
                findSiblings(obj).remove(obj);
            }
        }
    }

    private static final Map<String, DuplicationAdapter> ALL_ADAPTERS = loadAllAdapters();

    /**
     * Finds the appropriate adapter for a given object, depending on its meta-model.
     * 
     * @param obj the target object of the duplication action.
     * @return the corresponding adapter, or a (non-null) empty adapter which does nothing if no adapter is registered
     *         for the object's meta-model.
     */
    private static DuplicationAdapter getAdapterFor(EObject obj)
    {
        return getAdapterFor(obj.eClass().getEPackage().getNsURI());
    }

    /**
     * Finds the appropriate adapter for a given meta-model.
     * 
     * @param metamodelUri the URI of the meta-model
     * @return the corresponding adapter, or a (non-null) empty adapter which does nothing if no adapter is registered
     *         for this meta-model.
     */
    private static DuplicationAdapter getAdapterFor(String metamodelUri)
    {
        DuplicationAdapter adapter = ALL_ADAPTERS.get(metamodelUri);
        if (adapter != null)
        {
            return adapter;
        }
        else
        {
            return new DuplicationAdapter()
            {
                public org.eclipse.emf.common.command.Command getPostProcessingCommand(EditingDomain editingDomain, EObject original, Map<EObject, EObject> mainMapping,
                        Map<EObject, EObject> additionalMapping)
                {
                    return new IdentityCommand();
                }

                public Collection<EObject> getAdditionalObjects(EObject original)
                {
                    return Collections.emptySet();
                }
            };
        }
    }

    /**
     * Loads all the registered {@link DuplicationAdapter}s.
     */
    private static Map<String, DuplicationAdapter> loadAllAdapters()
    {
        Map<String, DuplicationAdapter> adapters = new HashMap<String, DuplicationAdapter>();

        IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(EXTENSION_POINT_NAMESPACE, EXTENSION_POINT_NAME);
        for (IExtension extension : extensionPoint.getExtensions())
        {
            for (IConfigurationElement cfg : extension.getConfigurationElements())
            {
                if (ADAPTER_ELEMENT_NAME.equals(cfg.getName()))
                {
                    String metamodel = cfg.getAttribute(METAMODEL_ATTRIBUTE_NAME);
                    if (metamodel == null)
                    {
                        ModelerPlugin.log("Invalid configuration element: missing 'metamodel' attribute.", IStatus.WARNING);
                        continue;
                    }
                    try
                    {
                        DuplicationAdapter adapter = (DuplicationAdapter) cfg.createExecutableExtension(IMPLEMENTATION_ATTRIBUTE_NAME);
                        adapters.put(metamodel, adapter);
                    }
                    catch (CoreException e)
                    {
                        ModelerPlugin.log(e);
                    }
                }
            }
        }
        return adapters;
    }
}
