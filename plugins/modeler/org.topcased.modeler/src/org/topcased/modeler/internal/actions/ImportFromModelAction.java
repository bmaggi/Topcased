/*******************************************************************************
 * Copyright (c) 2009 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Jose Alfredo Serrano (Anyware Technologies) - initial API and implementation
 *      Jacques Lescot (Anyware Technologies) - review code + comment code + fix some issues
 ******************************************************************************/
package org.topcased.modeler.internal.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.topcased.modeler.commands.EMFtoGEFCommandWrapper;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.DiagramsFactory;
import org.topcased.modeler.diagrams.model.DiagramsPackage;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.dialogs.SelectResourceDialog;
import org.topcased.modeler.internal.dialogs.SelectResourceDialog.IContentCreator;

/**
 * This action import a container element into the current model. The import is made semantically and graphically using
 * the {@link GlobalCopier} class.<br>
 * 
 * Creation 16 June. 09
 * 
 * @author <a href="mailto:jose.alfredo.serrano@anyware-tech.com">Jose Alfredo SERRANO</a>
 */
public class ImportFromModelAction extends CommandActionHandler
{
    /** The raw selection done in the outline view */
    private IStructuredSelection selection = null;

    private Modeler modeler;

    /**
     * The selected semantic element that was selected from the outline, this will represent the new container of the
     * element to import
     */
    private EObject selectedEObject;

    /** The containment feature that should be used to hold the element to import */
    private EReference eContainmentFeature;

    /** The selected Diagrams which will be used to contain the imported diagrams optionnally */
    private Diagrams selectedDiagrams;

    /** The EMF command used to modify both the semantic model and the graphical model for that import action */
    private CompoundCommand compoundCommand;

    /** Extension files of concerned models */
    private String extension;

    private boolean isAnUncontrolImport = false;

    /**
     * The constructor
     * 
     * @param theModeler The Modeler
     */
    public ImportFromModelAction(Modeler theModeler)
    {
        super(theModeler.getEditingDomain(), "Import From Model...");
        setDescription("Import the selected element into the selected resource.");
        setToolTipText("Import part of an external model within the current model");
        setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.ui", "icons/full/etool16/import_wiz.gif"));
        this.modeler = theModeler;
    }

    /**
     * @see org.eclipse.jface.action.Action#isEnabled()
     */
    public boolean isEnabled()
    {
        return true;
    }

    /**
     * The creation of the AddCommand is done in the run() method, when the user specifies a target resource.
     * 
     * @see org.eclipse.emf.edit.ui.action.CommandActionHandler#updateSelection(org.eclipse.jface.viewers.IStructuredSelection)
     */
    public boolean updateSelection(IStructuredSelection theSelection)
    {
        boolean result = false;
        this.selection = theSelection;
        Resource currentResource = null;
        Resource currentDiagramsResource = null;

        if (selection.size() == 1)
        {
            Object object = AdapterFactoryEditingDomain.unwrap(selection.getFirstElement());
            selectedEObject = (EObject) object;
            if (selectedEObject != null)
            {
                currentResource = selectedEObject.eResource();
            }

            extension = currentResource != null ? currentResource.getURI().fileExtension() : null;
            if (isEnabled())
            {
                // First retrieve the Diagrams that will hold the imported diagrams
                selectedDiagrams = DiagramsUtils.findNearestContainerDiagrams(modeler.getDiagrams(), selectedEObject);
                if (selectedDiagrams != null)
                {
                    currentDiagramsResource = selectedDiagrams.eResource();
                }

                result = selectedDiagrams != null && currentDiagramsResource != null;
            }
        }

        return result;
    }

    /**
     * We have to execute build commands and execute them. A selection dialog is launched so that user can select the
     * element to import
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    public void run()
    {
        List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
        filters.add(new ViewerFilter()
        {
            @Override
            public boolean select(Viewer viewer, Object parentElement, Object element)
            {
                if (element instanceof EObject)
                    return true;

                IResource resource = (IResource) element;
                if (resource.getType() != IResource.FILE)
                {
                    return true;
                }
                else
                {
                    String fileExtension = ((IFile) resource).getFileExtension();
                    return fileExtension != null && fileExtension.equals(extension);
                }
            }
        });
        ISelectionStatusValidator validator = new ISelectionStatusValidator()
        {
            public IStatus validate(Object[] selectedElements)
            {
                boolean enableOK = false;
                String msg = "";
                for (int i = 0; i < selectedElements.length; i++)
                {
                    if (selectedElements[i] instanceof EObject)
                    {
                        EObject elementToImport = (EObject) selectedElements[i];
                        eContainmentFeature = null;
                        for (EReference currentContainmentFeature : selectedEObject.eClass().getEAllContainments())
                        {
                            if (currentContainmentFeature.getEReferenceType().isInstance(elementToImport))
                            {
                                eContainmentFeature = currentContainmentFeature;
                                break;
                            }
                        }
                        enableOK = eContainmentFeature != null;
                        msg = eContainmentFeature != null ? "" : "The element '" + elementToImport.eClass().getName() + "' cannot be contained by the selected object";
                    }
                    if (enableOK)
                        break;
                }

                return enableOK ? new Status(IStatus.OK, "org.eclipse.emf.common.ui", 0, msg, null) : new Status(IStatus.ERROR, "org.eclipse.emf.common.ui", 0, msg, null);
            }
        };

        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        final EObject elementToImport = SelectResourceDialog.openElementSelection(root, validator, filters, false, new IContentCreator()
        {
            Button button = null;

            public void postCreateContents(Composite parent)
            {
                // parent.setLayout(new GridLayout(1,false));
                button = new Button(parent, SWT.CHECK);
                button.setText("Import by reference (diagrams are not imported)");
                button.setSelection(false);
                button.addSelectionListener(new SelectionListener()
                {

                    public void widgetSelected(SelectionEvent e)
                    {
                        isAnUncontrolImport = ((Button) e.getSource()).isEnabled() && ((Button) e.getSource()).getSelection();
                    }

                    public void widgetDefaultSelected(SelectionEvent e)
                    {
                    }
                });
            }

            public void preCreateContents(Composite parent)
            {
                // DO NOTHING
            }

            public void selectionChanged(SelectionChangedEvent event)
            {
                if (button != null)
                {
                    if (event.getSelection() instanceof IStructuredSelection)
                    {
                        IStructuredSelection structured = (IStructuredSelection) event.getSelection();
                        if (structured.getFirstElement() instanceof EObject)
                        {
                            EObject object = (EObject) structured.getFirstElement();
                            button.setEnabled(object.eResource() != null && object.eResource().getContents().size() > 0 && object.eResource().getContents().get(0) == object);
                        }
                        else
                        {
                            button.setEnabled(false);
                        }
                    }
                }
            }
        });

        if (elementToImport == null)
            return;

        Resource eResource = elementToImport.eResource();
        if (eResource != null)
        {
            // get the object URI to find it again later
            URI eObjectURI = EcoreUtil.getURI(elementToImport);

            // unload old resources
            eResource.unload();

            // Retrieve the current ResourceSet linked with the current graphical editor instance
            ResourceSet resourceSet = selectedEObject.eResource().getResourceSet();
            Resource controlledResource = resourceSet.getResource(eObjectURI.trimFragment(), true);

            // Store the initial list of loaded Resources
            // List<Resource> initialResources = new ArrayList<Resource>(resourceSet.getResources());

            // Retrieve the element to import from the current ResourceSet. Use the URI we store just before to retrieve
            // the corresponding element to import
            EObject eObject = resourceSet.getEObject(eObjectURI, true);

            compoundCommand = new CompoundCommand();
            GlobalCopier copier = new GlobalCopier();

            // make a copy of the selection and append it the current selection.
            EObject semanticEltImported = null;
            if (isAnUncontrolImport)
            {
                semanticEltImported = eObject;
            }
            else
            {
                semanticEltImported = copier.performSemanticCopy(eObject);
            }
            Command cmd = AddCommand.create(domain, selectedEObject, eContainmentFeature, semanticEltImported);
            compoundCommand.append(cmd);
            if (isAnUncontrolImport)
            {
                compoundCommand.append(new AddCommand(domain, controlledResource.getContents(), semanticEltImported));
            }

            // try to find the diagram resource
            Resource resource = eObject.eResource();
            URI uri = resource.getURI();
            if (!isAnUncontrolImport)
            {
                uri = URI.createURI(uri.toString() + "di");
                Resource diagramResource = resourceSet.getResource(uri, true);
                
                // Retrieve the Diagrams that match with the model object if there is any
                if (diagramResource != null && !diagramResource.getContents().isEmpty())
                {
                    Diagrams diagramsToImport = DiagramsUtils.findNearestContainerDiagrams((Diagrams) diagramResource.getContents().get(0), eObject);
                    if (diagramsToImport != null && diagramsToImport.getModel() == eObject)
                    {
                        Diagrams diagramsImported = null;
                        diagramsImported = copier.performViewsCopy(diagramsToImport);
                        diagramsImported.setModel(semanticEltImported);
                        compoundCommand.append(AddCommand.create(domain, selectedDiagrams, DiagramsPackage.eINSTANCE.getDiagrams_Subdiagrams(), diagramsImported));
                    }
                    else
                    {
                        // The Diagrams element to import is not necessary associated with the element to import. It could
                        // be a child Diagrams, or a list of children Diagrams (direct or indirect)
                        List<Diagrams> innerDiagrams = findChildrenDiagrams(diagramsToImport, eObject);
                        if (innerDiagrams != null && innerDiagrams.size() == 1)
                        {
                            // Need to simply append the single Diagrams element found
                            Diagrams diagramsImported = copier.performViewsCopy(innerDiagrams.get(0));
                            compoundCommand.append(AddCommand.create(domain, selectedDiagrams, DiagramsPackage.eINSTANCE.getDiagrams_Subdiagrams(), diagramsImported));
                        }
                        else if (innerDiagrams != null && !innerDiagrams.isEmpty())
                        {
                            // Need to create a Diagrams element associated with the selected semantic element, and then
                            // append all the diagrams to this one
                            Diagrams newDiagrams = DiagramsFactory.eINSTANCE.createDiagrams();
                            newDiagrams.setModel(semanticEltImported);
                            compoundCommand.append(AddCommand.create(domain, selectedDiagrams, DiagramsPackage.eINSTANCE.getDiagrams_Subdiagrams(), newDiagrams));
                            for (Diagrams childDiagramsToImport : innerDiagrams)
                            {
                                Diagrams diagramsImported = childDiagramsToImport;
                                compoundCommand.append(AddCommand.create(domain, newDiagrams, DiagramsPackage.eINSTANCE.getDiagrams_Subdiagrams(), diagramsImported));
                            }
                        }
                    }
                }
            }
            // Execute the CompoundCommand
            ((IMixedEditDomain) modeler.getAdapter(IMixedEditDomain.class)).getGEFCommandStack().execute(new EMFtoGEFCommandWrapper(compoundCommand));

        }
    }

    /**
     * Get a list of Diagrams that need to be duplicated when the given semantic element is duplicated.
     * 
     * @param parentDiagrams a Diagrams from which search should be started. Should be a Diagrams from a "higher level"
     *        regarding the semantic element.
     * @param modelObject the semantic element to be compared with semantic element associated with Diagrams
     * @return a list of Diagrams that could be considered as children Diagrams when compared to the given semantic
     *         element
     */
    private List<Diagrams> findChildrenDiagrams(Diagrams parentDiagrams, EObject modelObject)
    {
        List<Diagrams> diagramsToCopy = new ArrayList<Diagrams>();

        // Check if there is no more child diagrams
        if (parentDiagrams.getSubdiagrams() == null || parentDiagrams.getSubdiagrams().isEmpty())
        {
            return null;
        }

        // Iterates on all Diagrams at the same level
        for (Diagrams subDiagrams : parentDiagrams.getSubdiagrams())
        {
            if (EcoreUtil.isAncestor(modelObject, subDiagrams.getModel()))
            {
                diagramsToCopy.add(subDiagrams);
            }
        }

        // At least one or more diagrams are found
        if (!diagramsToCopy.isEmpty())
        {
            return diagramsToCopy;
        }

        // Otherwise, continue in the sub hierarchy
        for (Diagrams subDiagrams : parentDiagrams.getSubdiagrams())
        {
            List<Diagrams> childrenDiagrams = findChildrenDiagrams(subDiagrams, modelObject);
            if (childrenDiagrams != null)
            {
                return childrenDiagrams;
            }
        }
        return null;
    }

    // ////////////////////////////////////////////////////////
    // ///////////////// COPIER CLASSES ///////////////////////
    // ////////////////////////////////////////////////////////

    /**
     * A Utility class that provide a single method used to copy a set of Views and their associated semantic elements
     * 
     * @author <a href="mailto:jose.alfredo.serrano@anyware-tech.com">Jose Alfredo Serrano</a>
     */
    private static class GlobalCopier
    {
        // A utility class providing helper methods for the copy of semantic elements. We use this adapted Copier in
        // order to manage cases where the copy of a semantic element also involves the copy of some elements that are
        // not contained directly or not in the children of the current element. Indeed, the generic copy
        // (EcoreUtil.copy) ignore them.
        private EcoreUtil.Copier semanticCopier;

        // The map containing original views and their duplicates. Here we can use the default copy behavior provided by
        // EcoreUtils.Copier. We will just update this map by adding also Edge elements.
        private EcoreUtil.Copier viewsCopier;

        /**
         * Constructor
         */
        public GlobalCopier()
        {
            semanticCopier = new EcoreUtil.Copier();
            viewsCopier = new EcoreUtil.Copier();
        }

        /**
         * Referenced semantic elements are also a copy of original ones.
         * 
         * @param semanticElement the element to copy
         * @return the list of copied elements
         */
        public EObject performSemanticCopy(EObject semanticElement)
        {
            // ---------------------------------
            // 1. Deeply copy semantic elements
            EObject semanticCopy = semanticCopier.copy(semanticElement);
            semanticCopier.copyReferences();
            return semanticCopy;
        }

        /**
         * Get a deep copy of a set of Views. Referenced semantic elements are also a copy of original ones if the
         * performSemanticCopy was called before.
         * 
         * @param diagrams a collection of Views to copy
         * @return the list of copied elements
         */
        public Diagrams performViewsCopy(Diagrams diagrams)
        {
            // ----------------------------------
            // 2. Deeply copy graphical elements
            Diagrams diagramsCopy = (Diagrams) viewsCopier.copy(diagrams);
            viewsCopier.copyReferences();

            // -------------------------------------------------------------------
            // 3. Update references between graphical elements and the duplicated semantic elements. Need to iterates
            // over the whole map
            for (Map.Entry<EObject, EObject> entry : viewsCopier.entrySet())
            {
                EObject key = entry.getKey();
                if (key instanceof GraphElement)
                {
                    GraphElement originalView = (GraphElement) key;
                    GraphElement duplicateView = (GraphElement) entry.getValue();

                    // Update the duplicated views to reference the duplicated elements.
                    EObject semanticBridge = originalView.getSemanticModel();
                    if (semanticBridge instanceof EMFSemanticModelBridge)
                    {
                        EMFSemanticModelBridge EMFsemanticBridge = (EMFSemanticModelBridge) semanticBridge;
                        EObject originalElement = EMFsemanticBridge.getElement();
                        if (semanticCopier != null)
                        {
                            Object duplicateElement = semanticCopier.get(originalElement);
                            if (duplicateElement != null)
                            {
                                EMFSemanticModelBridge duplicateSemanticBridge = (EMFSemanticModelBridge) duplicateView.getSemanticModel();
                                duplicateSemanticBridge.setElement((EObject) duplicateElement);
                            }
                        }
                    }
                }
                else if (key instanceof Diagrams)
                {
                    Diagrams originalView = (Diagrams) key;
                    Diagrams duplicateView = (Diagrams) entry.getValue();

                    EObject originalElement = originalView.getModel();
                    if (semanticCopier != null)
                    {
                        Object duplicateElement = semanticCopier.get(originalElement);
                        if (duplicateElement != null)
                        {
                            duplicateView.setModel((EObject) duplicateElement);
                        }
                    }
                }
            }

            return diagramsCopy;
        }
    }

    // ////////////////////////////////////////////////////////
    // /////////////// END COPIER CLASSES /////////////////////
    // ////////////////////////////////////////////////////////
}
