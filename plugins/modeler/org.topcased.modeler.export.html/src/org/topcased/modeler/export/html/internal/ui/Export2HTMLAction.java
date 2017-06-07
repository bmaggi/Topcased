/*******************************************************************************
 * Copyright (c) 2009 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jose Alfredo Serrano (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.export.html.internal.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;
import org.topcased.modeler.export.html.HTMLPlugin;
import org.topcased.modeler.export.html.internal.Export2HTML;

/**
 * Action that export all the diagrams as images at the same location of the selected file. Exported images are named
 * with the diagram name and JPG format is used by default. These images are then used in the generation of the
 * documentation when needed.
 * 
 * Additional work would consist in :
 * <ul>
 * <li>give the user the choice of the output format</li>
 * <li>create a hierarchy in the generation of the images that follows the hierarchy of the model contents</li>
 * <li>do not overwrite already existing files or at least alert the user</li>
 * </ul>
 * 
 * @author <a href="mailto:jose.alfredo.serrano@anyware-tech.com">Jose Alfredo SERRRANO</a>
 */
public class Export2HTMLAction implements IActionDelegate
{
    private ISelection selection;

    /**
     * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(IAction action, ISelection sel)
    {
        selection = sel;
        action.setEnabled(true);
    }

    /**
     * Try to retrieve the selected file from the given selection
     * 
     * @param sel the selection
     * @return the selected file
     */
    private IFile convertSelection2File(ISelection sel)
    {
        // get the selected diagrams file
        if (sel instanceof IStructuredSelection)
        {
            IStructuredSelection ssel = (IStructuredSelection) sel;
            // Only one file should be selected
            if (!ssel.isEmpty() && ssel.size() == 1)
            {
                Object selectedObj = ssel.getFirstElement();
                if (selectedObj instanceof IFile)
                {
                    return (IFile) selectedObj;
                }
                // Try to adapt
                if (selectedObj instanceof IAdaptable)
                {
                    return (IFile) ((IAdaptable) selectedObj).getAdapter(IFile.class);
                }
            }
        }
        return null;
    }

    /**
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    public void run(IAction action)
    {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

        final IFile file = convertSelection2File(selection);
        final IProject fCurrProject = file.getProject();
        final Class< ? >[] acceptedClasses = new Class[] {IProject.class, IFolder.class};
        IProject[] allProjects = root.getProjects();
        List<IProject> rejectedElements = new ArrayList<IProject>(allProjects.length);
        for (int i = 0; i < allProjects.length; i++)
        {
            if (!allProjects[i].equals(fCurrProject))
            {
                rejectedElements.add(allProjects[i]);
            }
        }

        FolderSelectionDialog dialog = new FolderSelectionDialog(Display.getCurrent().getActiveShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
        dialog.setTitle("Folder Selection");

        dialog.setValidator(new ISelectionStatusValidator()
        {
            public IStatus validate(Object[] selectedFolder)
            {
                if (selectedFolder.length == 1 && (selectedFolder[0] instanceof IFolder || selectedFolder[0] instanceof IProject))
                    return Status.OK_STATUS;
                return new Status(IStatus.ERROR, HTMLPlugin.PLUGIN_ID, "Invalid Selection");
            }
        });
        dialog.setMessage("Select destination folder");
        dialog.addFilter(new TypedViewerFilter(acceptedClasses, rejectedElements.toArray()));
        dialog.setInput(root);
        dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));

        if (dialog.open() == Window.OK)
        {
            // Get the selected diagrams file
            IContainer container = (IContainer) dialog.getFirstResult();
            Export2HTML exporter = new Export2HTML();
            exporter.generate(file, container);
        }
    }

    /**
     * A custom filter that could be configured to accept or reject some elements
     */
    public class TypedViewerFilter extends ViewerFilter
    {
        private Class< ? >[] fAcceptedTypes;

        private Object[] fRejectedElements;

        /**
         * Creates a filter that only allows elements of gives types.
         * 
         * @param acceptedTypes The types of accepted elements
         */
        public TypedViewerFilter(Class< ? >[] acceptedTypes)
        {
            this(acceptedTypes, null);
        }

        /**
         * Creates a filter that only allows elements of gives types, but not from a list of rejected elements.
         * 
         * @param acceptedTypes Accepted elements must be of this types
         * @param rejectedElements Element equals to the rejected elements are filtered out
         */
        public TypedViewerFilter(Class< ? >[] acceptedTypes, Object[] rejectedElements)
        {
            Assert.isNotNull(acceptedTypes);
            fAcceptedTypes = acceptedTypes;
            fRejectedElements = rejectedElements;
        }

        /**
         * @see ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
         */
        public boolean select(Viewer viewer, Object parentElement, Object element)
        {
            if (fRejectedElements != null)
            {
                for (int i = 0; i < fRejectedElements.length; i++)
                {
                    if (element.equals(fRejectedElements[i]))
                    {
                        return false;
                    }
                }
            }
            for (int i = 0; i < fAcceptedTypes.length; i++)
            {
                if (fAcceptedTypes[i].isInstance(element))
                {
                    return true;
                }
            }
            return false;
        }

    }
}
