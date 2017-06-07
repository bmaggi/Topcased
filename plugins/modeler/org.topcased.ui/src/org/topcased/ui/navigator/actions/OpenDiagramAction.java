/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package org.topcased.ui.navigator.actions;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.Modeler;
import org.topcased.ui.internal.Activator;

/**
 * An action used to open the selected Diagram in a graphical editor.
 * 
 * Creation 3 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class OpenDiagramAction extends Action
{

    private IWorkbenchPage page;

    private Diagram diagram;

    private ISelectionProvider provider;

    /**
     * Construct the OpenDiagramAction with the given page.
     * 
     * @param p The page to use as context to open the editor.
     * @param selectionProvider The selection provider
     */
    public OpenDiagramAction(IWorkbenchPage p, ISelectionProvider selectionProvider)
    {
        setText("Open Diagram");
        page = p;
        provider = selectionProvider;
    }

    /**
     * @see org.eclipse.jface.action.Action#isEnabled()
     */
    @Override
    public boolean isEnabled()
    {
        ISelection selection = provider.getSelection();
        if (!selection.isEmpty())
        {
            IStructuredSelection sSelection = (IStructuredSelection) selection;
            if (sSelection.size() == 1 && sSelection.getFirstElement() instanceof Diagram)
            {
                diagram = ((Diagram) sSelection.getFirstElement());
                return true;
            }
        }
        return false;
    }

    /**
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    public void run()
    {
        if (isEnabled())
        {
            IFile diagramsFile = WorkspaceSynchronizer.getFile(diagram.eResource());
            if (diagramsFile != null)
            {
                // Open the newly created model
                try
                {
                    IEditorPart editor = IDE.openEditor(page, diagramsFile, true);

                    // Check that models (from the Topcased Navigator and the Editor) are synchronized
                    if (editor instanceof Modeler && (!editor.isDirty() || MessageDialog.openConfirm(Activator.getActiveWorkbenchShell(), "Synchronization is needed", "The associated editor is currently open and has changes that should be saved before activating this diagram.\nDo you really want to continue and try to open this diagram ?")))
                    {
                        // TODO Use the same ResourceSet between the Topcased Navigator and the graphical editors. This
                        // won't be necessary to retrieve the corresponding active Diagram in the new ResourceSet
                        List<Diagram> navigatorDiagrams = DiagramsUtils.findAllDiagrams(DiagramsUtils.findRootDiagrams((Diagrams) diagram.eContainer()));
                        List<Diagram> editorDiagrams = DiagramsUtils.findAllDiagrams(((Modeler) editor).getDiagrams());
                        // Sanity check : there is the same number of diagrams in the two models
                        if (navigatorDiagrams.size() == editorDiagrams.size()) {
                            ((Modeler) editor).setActiveDiagram(editorDiagrams.get(navigatorDiagrams.indexOf(diagram)));
                        }
                        return;
                    }
                }
                catch (PartInitException pie)
                {
                    Activator.log("Could not open diagram!", IStatus.ERROR);
                    MessageDialog.openError(Display.getDefault().getActiveShell(), "Error Opening Diagram", "Could not open diagram!");
                }
            }
        }
    }

}
