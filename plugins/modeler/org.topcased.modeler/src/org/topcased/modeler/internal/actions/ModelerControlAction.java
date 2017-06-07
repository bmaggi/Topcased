/*******************************************************************************
 * Copyright (c) 2006,2010 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *      Jacques Lescot (Anyware Technologies) - initial API and implementation
 *      Sebastien Gabel (CS) - fix URI encoding/decoding
 ******************************************************************************/
package org.topcased.modeler.internal.actions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.topcased.modeler.commands.CreateDiagramsCommand;
import org.topcased.modeler.commands.EMFtoGEFCommandWrapper;
import org.topcased.modeler.commands.GEFtoEMFCommandWrapper;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.editor.Modeler;

/**
 * A custom Control action that is run from the outline view when a Controllable model object is selected.<br>
 * 
 * Creation 5 oct. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ModelerControlAction extends CommandActionHandler
{
    /**
     * The default file name to use for the controlled resource if no appropriate "name" feature was found on the
     * controlled element.
     */
    private static final String DEFAULT_NAME = "Unknown";

    private IStructuredSelection selection = null;

    private Modeler modeler;

    private EObject eObject;

    /**
     * The constructor
     * 
     * @param theModeler The Modeler
     */
    public ModelerControlAction(Modeler theModeler)
    {
        super(theModeler.getEditingDomain(), EMFEditUIPlugin.INSTANCE.getString("_UI_Control_menu_item"));
        setDescription("_UI_Control_menu_item_description");
        setToolTipText("Split the model into an external model");
        this.modeler = theModeler;
    }

    /**
     * @see org.eclipse.jface.action.Action#isEnabled()
     */
    public boolean isEnabled()
    {
        return getEditingDomain().isControllable(eObject) && !AdapterFactoryEditingDomain.isControlled(eObject);
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

        if (selection.size() == 1)
        {
            Object object = AdapterFactoryEditingDomain.unwrap(selection.getFirstElement());
            // Check whether the selected object is controllable
            result = getEditingDomain().isControllable(object);
            eObject = result ? (EObject) object : null;
        }

        return result;
    }

    private String getElementName(EObject obj)
    {
        EStructuralFeature nameFeature = getLabelFeature(obj.eClass());
        if (nameFeature != null)
        {
            Object value = obj.eGet(nameFeature);
            if (value != null)
            {
                return value.toString();
            }
        }
        return DEFAULT_NAME;
    }

    /**
     * Copied from org.eclipse.emf.edit.provider.ReflectiveItemProvider and slightly modified to return null if no
     * likely candidate is found.
     * 
     * @param eClass
     * @return
     */
    protected EStructuralFeature getLabelFeature(EClass eClass)
    {
        EAttribute result = null;
        for (EAttribute eAttribute : eClass.getEAllAttributes())
        {
            if (!eAttribute.isMany() && eAttribute.getEType().getInstanceClass() != FeatureMap.Entry.class)
            {
                if ("name".equalsIgnoreCase(eAttribute.getName()))
                {
                    result = eAttribute;
                    break;
                }
                else if (eAttribute.getEAttributeType().getInstanceClass() == String.class && result != null && result.getEAttributeType().getInstanceClass() != String.class)
                {
                    result = eAttribute;
                }
            }
        }
        return result;
    }

    /**
     * We have to execute a Control command on the selected model object and on the diagrams that are referenced by
     * objects that are controlled.
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    public void run()
    {
        // Get Resources that will be created (One for the diagrams, another one
        // for the Model)
        ControlResourceDialog dialog = new ControlResourceDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), getEditingDomain(), eObject.eResource(), getElementName(eObject));
        dialog.open();
        Resource resourceModel = dialog.getControlResource();
        if (resourceModel == null)
        {
            return;
        }

        // Create the URI from the model that will be created
        URI newDiagramsURI = URI.createURI(resourceModel.getURI().toString() + "di");
        // TODO Sometimes the Resource already exist, we do not need to
        // create it but only get it
        Resource resourceDiagrams = modeler.getResourceSet().createResource(newDiagramsURI);

        // Create the CompoundCommand
        CompoundCommand compoundCommand = new CompoundCommand();
        // BUG #3258 we are looking for the root of the diagrams to avoid problems with already controled models
        // START
        Diagrams root = modeler.getDiagrams();
        while (root.getParent() != null)
        {
            root = root.getParent();
        }
        // END #3258
        Diagrams containerDiagrams = DiagramsUtils.findNearestContainerDiagrams(root, eObject);
        if (!eObject.equals(containerDiagrams.getModel()))
        {
            // Create the Command that will create a Diagrams model object to
            // associate with the eObject when none is defined and execute it so
            // that the Diagrams exists before the Control action onto the
            // Diagrams is created.
            modeler.getEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(new CreateDiagramsCommand(modeler, eObject)));
        }

        // Create the Command to Control model objects
        compoundCommand.append(new AddCommand(getEditingDomain(), resourceModel.getContents(), eObject));

        // Create the Command to Control the Diagrams associated
        compoundCommand.append(new AddCommand(getEditingDomain(), resourceDiagrams.getContents(), DiagramsUtils.findNearestContainerDiagrams(root, eObject)));

        // Execute the CompoundCommand
        ((IMixedEditDomain) modeler.getAdapter(IMixedEditDomain.class)).getGEFCommandStack().execute(new EMFtoGEFCommandWrapper(compoundCommand));

        modeler.doSave(new NullProgressMonitor());
        modeler.refreshOutlineElement(eObject);
    }

    /**
     * A save-type {@link ResourceDialog resource dialog} that attempts to create the specified resource and load it, if
     * it already exists.
     */
    protected static class ControlResourceDialog extends ResourceDialog
    {
        private EditingDomain domain;

        private Resource controlResource;

        private Resource currentResource;

        private String defaultName;

        /**
         * The constructor
         * 
         * @param parent
         * @param theDomain
         * @param theCurrentResource
         * @param defaultName
         */
        public ControlResourceDialog(Shell parent, EditingDomain theDomain, Resource theCurrentResource, String defaultName)
        {
            super(parent, EMFEditUIPlugin.INSTANCE.getString("_UI_ControlDialog_title"), SWT.SAVE);
            this.domain = theDomain;
            this.currentResource = theCurrentResource;
            this.defaultName = defaultName;
        }

        private String computeDefaultURIString()
        {
            return URI.decode(computeDefaultURI().toString());
        }

        private URI computeDefaultURI()
        {
            URI uri = currentResource.getURI().trimSegments(1);
            uri = uri.appendSegment(getNewFileName());
            return uri;
        }

        private String getNewFileName()
        {
            String ext = currentResource.getURI().fileExtension();
            return defaultName + "." + ext;
        }

        @Override
        protected Control createContents(Composite parent)
        {
            Control result = super.createContents(parent);
            this.uriField.setText(computeDefaultURIString());
            return result;
        }

        /**
         * {@inheritDoc} </br> </br>Overrides to set automatically the path to the container of the selected resource.
         * 
         */
        @Override
        protected void prepareBrowseFileSystemButton(Button browseFileSystemButton)
        {
            browseFileSystemButton.addSelectionListener(new SelectionAdapter()
            {
                @Override
                public void widgetSelected(SelectionEvent event)
                {
                    FileDialog fileDialog = new FileDialog(getShell(), style);

                    // retrieve the absolute path of the folder and set it as default
                    IPath platformPath = new Path(currentResource.getURI().trimSegments(1).toPlatformString(true));

                    IResource absoluteFolder = ResourcesPlugin.getWorkspace().getRoot().findMember(platformPath);
                    if (absoluteFolder != null && absoluteFolder.getLocation() != null)
                    {
                        fileDialog.setFilterPath(absoluteFolder.getLocation().toOSString());
                    }

                    fileDialog.setFileName(getNewFileName());

                    // if the open() returns null, it means the cancel button was pushed.
                    if (fileDialog.open() == null)
                    {
                        return;
                    }

                    String filterPath = fileDialog.getFilterPath();

                    String fileName = fileDialog.getFileName();
                    if (fileName != null)
                    {
                        uriField.setText(URI.createFileURI(filterPath + File.separator + fileName).toString());
                    }
                }

            });
        }

        /**
         * {@inheritDoc} </br> </br>Overrides to set automatically the path to the container of the selected resource.
         * 
         */
        @Override
        protected void prepareBrowseWorkspaceButton(Button browseWorkspaceButton)
        {
            browseWorkspaceButton.addSelectionListener(new SelectionAdapter()
            {
                @Override
                public void widgetSelected(SelectionEvent event)
                {
                    // use the computed uri as default path for the dialog
                    IPath path = new Path(computeDefaultURI().toPlatformString(true));

                    IFile file = WorkspaceResourceDialog.openNewFile(getShell(), null, null, path, null);

                    if (file != null)
                    {
                        uriField.setText(URI.createPlatformResourceURI(file.getFullPath().toString(), true).toString());
                    }
                }
            });
        }

        /**
         * Creates and, if it already exists, loads the specified resource. This implementation verifies that a resource
         * can be opened for that URI, that the resource is not the object's current container, and that it is not
         * read-only in the editing domain. If there is an existing resource with that URI, it prompts before overriding
         * or adding to it.
         * 
         * @see org.eclipse.emf.common.ui.dialogs.ResourceDialog#processResources()
         */
        protected boolean processResources()
        {
            URI uri = URI.createURI(getURIText(), false);
            ResourceSet resourceSet = domain.getResourceSet();
            Resource resource = resourceSet.getResource(uri, false);
            boolean resourceInSet = resource != null;

            if (resource == currentResource)
            {
                MessageDialog.openError(getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_InvalidURI_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_AlreadyInResource"));
                return false;
            }
            if (domain.isReadOnly(resource))
            {
                MessageDialog.openError(getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_InvalidURI_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_ReadOnlyResource"));
                return false;
            }

            boolean resourceExists = false;
            try
            {
                InputStream stream = resourceSet.getURIConverter().createInputStream(uri);
                if (stream != null)
                {
                    resourceExists = true;
                    stream.close();
                }
            }
            catch (IOException exception)
            {
                // Do nothing
            }

            boolean resourceBad = false;
            if (!resourceInSet)
            {
                resource = resourceSet.createResource(uri);
                if (resource == null)
                {
                    MessageDialog.openError(getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_InvalidURI_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_CannotCreateResource"));
                    return false;
                }

                if (resourceExists)
                {
                    try
                    {
                        resource = resourceSet.getResource(uri, true);
                    }
                    catch (RuntimeException exception)
                    {
                        EMFEditUIPlugin.INSTANCE.log(exception);
                        resourceBad = resource.getContents().isEmpty();
                    }
                }
            }

            boolean result = true;
            if (resourceBad)
            {
                result = MessageDialog.openQuestion(getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_ExistingResource_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_ReplaceResource"));
            }
            else if (resourceExists)
            {
                result = MessageDialog.openQuestion(getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_ExistingResource_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_AddToResource"));
            }

            if (!result && !resourceInSet)
            {
                resource.unload();
                resourceSet.getResources().remove(resource);
            }
            else
            {
                this.controlResource = resource;
            }
            return result;
        }

        /**
         * Return the created Resource
         * 
         * @return the Resource
         */
        public Resource getControlResource()
        {
            return controlResource;
        }
    }

}
