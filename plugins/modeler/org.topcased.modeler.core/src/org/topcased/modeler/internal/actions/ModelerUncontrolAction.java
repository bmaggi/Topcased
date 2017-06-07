/*******************************************************************************
 * Copyright (c) 2006,2010 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     Jacques Lescot (Anyware Technologies) - initial API and implementation
 *     Sebastien Gabel (CS) - fix URI encoding/decoding
 ******************************************************************************/
package org.topcased.modeler.internal.actions;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.topcased.modeler.commands.EMFtoGEFCommandWrapper;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.MixedEditDomain;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * A custom Uncontrol action that is run from the outline view when a Controlled model object is selected.<br>
 * 
 * Creation 6 oct. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ModelerUncontrolAction extends CommandActionHandler
{
    private IStructuredSelection selection = null;

    private Modeler modeler;

    private EObject eObject;

    private CompoundCommand compoundCommand;

    private Resource controlledResource;

    private Resource controlledDiagramsResource;

    /**
     * The constructor
     * 
     * @param theModeler The Modeler
     */
    public ModelerUncontrolAction(Modeler theModeler)
    {
        super(theModeler.getEditingDomain(), EMFEditUIPlugin.INSTANCE.getString("_UI_Uncontrol_menu_item"));
        setDescription("_UI_Uncontrol_menu_item_description");
        setToolTipText("Merge the external model with the current model");
        this.modeler = theModeler;
    }

    /**
     * @see org.eclipse.jface.action.Action#isEnabled()
     */
    public boolean isEnabled()
    {
        return getEditingDomain().isControllable(eObject) && AdapterFactoryEditingDomain.isControlled(eObject);
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
        this.controlledResource = null;
        this.controlledDiagramsResource = null;

        if (selection.size() == 1)
        {
            Object object = AdapterFactoryEditingDomain.unwrap(selection.getFirstElement());
            // Check whether the selected object is controllable
            result = getEditingDomain().isControllable(object);
            eObject = result ? (EObject) object : null;
            if (eObject != null) {
                controlledResource = eObject.eResource();
            }

            if (isEnabled())
            {
                // Create the CompoundCommand
                compoundCommand = new CompoundCommand();

                // First retrieve the Diagrams that match with the model object
                // to Uncontrol
                Diagrams controlledDiagrams = DiagramsUtils.findNearestContainerDiagrams(modeler.getDiagrams(), eObject);
                if (controlledDiagrams != null)
                {
                    // Create the Command to Uncontrol the Diagrams
                    compoundCommand.append(new RemoveCommand(domain, controlledDiagrams.eResource().getContents(), controlledDiagrams));
                    controlledDiagramsResource = controlledDiagrams.eResource();
                }

                // Create the Command to Uncontrol the model object
                compoundCommand.append(new RemoveCommand(domain, eObject.eResource().getContents(), eObject));

                result = compoundCommand.canExecute();
            }
        }

        return result;
    }

    /**
     * We have to execute the Uncontrol command on the selected model object and on the diagrams that were referenced by
     * the controlled objects.
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    public void run()
    {
        // Execute the CompoundCommand
        ((MixedEditDomain) modeler.getAdapter(MixedEditDomain.class)).getCommandStack().execute(new EMFtoGEFCommandWrapper(compoundCommand));

        // Remove the resources from the resource-set ensure the changes made by the above command will not be saved
        // back to disk.
        modeler.getEditingDomain().getResourceSet().getResources().remove(controlledResource);
        modeler.getEditingDomain().getResourceSet().getResources().remove(controlledDiagramsResource);

        Collection<IResource> todelete = new ArrayList<IResource>();
        addFileResource(controlledResource, todelete);
        addFileResource(controlledDiagramsResource, todelete);
        String fileNames = joinedFileNames(todelete);

        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        boolean confirmDelete = MessageDialog.openQuestion(shell, "Delete controlled resources?", "Delete the original controlled files (" + fileNames + ")?");
        if (confirmDelete)
        {
            for (IResource file : todelete)
            {
                try
                {
                    file.delete(true, new NullProgressMonitor());
                }
                catch (CoreException e)
                {
                    ModelerPlugin.log(e);
                    ModelerPlugin.displayDialog("Unable to delete", "An error occurred when trying to delete " + file.toString() + ". See error logs for more details.", IStatus.ERROR);
                }
            }
        }
        modeler.refreshOutlineElement(eObject);
    }

    private String joinedFileNames(Collection<IResource> todelete)
    {
        StringBuilder fileNames = new StringBuilder();
        boolean first = true;
        for (IResource file : todelete)
        {
            if (!first)
            {
                fileNames.append(", ");
            }
            else
            {
                first = false;
            }
            fileNames.append(file.getFullPath());
        }
        return fileNames.toString();
    }

    private void addFileResource(Resource emfRes, Collection<IResource> fileResources)
    {
        URI uri = (emfRes != null) ? emfRes.getURI() : null;
        if (uri != null && uri.isPlatformResource())
        {
            IPath path = new Path(uri.toPlatformString(true));
            IResource r = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
            if (r != null)
            {
                fileResources.add(r);
            }
        }
    }
}
