/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies), 
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.dialogs;

import org.eclipse.gef.EditDomain;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.topcased.facilities.dialogs.ITopcasedDialogConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.utils.LabelHelper;
import org.topcased.modeler.utils.Utils;

/**
 * This dialog allows the user to choose between different diagrams associated with GraphElements. <br>
 * creation : 18 janv. 2006
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ChooseGraphElementDialog extends SelectionDialog implements ITopcasedDialogConstants
{
    private EditDomain domain;

    private GraphElement[] graphElements;

    /**
     * List to display the diagrams.
     */
    private ListViewer listViewer;

    /**
     * Constructor
     * @param parentShell the shell
     * @param editDomain the editor EditDomain
     * @param elements the GraphElements that are contained in diagrams
     */
    public ChooseGraphElementDialog(Shell parentShell, EditDomain editDomain, GraphElement[] elements)
    {
        super(parentShell);
        
        if (editDomain == null || elements == null || elements.length == 0)
        {
            throw new IllegalArgumentException();
        }

        this.graphElements = elements;
        this.domain = editDomain;

        setTitle("Diagram selection");
        setMessage("Select the destination diagram : ");
        
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }
    
    /**
     * @see org.eclipse.ui.dialogs.SelectionDialog#configureShell(org.eclipse.swt.widgets.Shell)
     */
    protected void configureShell(Shell shell)
    {
        shell.setMinimumSize(MIN_DIALOG_WIDTH, MIN_DIALOG_HEIGHT);
        
        super.configureShell(shell);
    }

    /**
     * Create the Dialog area
     * 
     * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    protected Control createDialogArea(Composite parent)
    {
        Composite composite = (Composite) super.createDialogArea(parent);
        GridData dialogLayoutData = new GridData(GridData.FILL_BOTH);
        dialogLayoutData.widthHint = DEFAULT_DIALOG_WIDTH;
        dialogLayoutData.heightHint = DEFAULT_DIALOG_HEIGHT;
        composite.setLayoutData(dialogLayoutData);

        createMessageArea(composite);
        createList(composite);

        hookListeners();

        return composite;
    }

    /**
     * Creates the UI
     * 
     * @param parent the parent composite
     */
    protected void createList(Composite parent)
    {
        listViewer = new ListViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);

        GridData data = new GridData(GridData.FILL_BOTH);
        listViewer.getList().setLayoutData(data);
        // Set the label provider
        listViewer.setLabelProvider(new LabelProvider()
        {
            public String getText(Object element)
            {
                // Return the resolution's label.
                if (element instanceof GraphElement)
                {
                    Diagram diag = Utils.getDiagram((GraphElement) element);
                    return LabelHelper.INSTANCE.getDiagramPath(domain, diag);
                }
                return "";
            }
        });

        // Set the content provider
        ArrayContentProvider cp = new ArrayContentProvider();
        listViewer.setContentProvider(cp);
        listViewer.setInput(graphElements); // it is ignored but must be
        // non-null

        // Set the initial selection
        listViewer.setSelection(new StructuredSelection(graphElements[0]), true);
    }

    /**
     * Add listeners on UI widgets
     */
    protected void hookListeners()
    {
        // Add a selection change listener
        listViewer.addSelectionChangedListener(new ISelectionChangedListener()
        {
            public void selectionChanged(SelectionChangedEvent event)
            {
                // Update OK button enablement
                getOkButton().setEnabled(!event.getSelection().isEmpty());
            }
        });

        // Add double-click listener
        listViewer.addDoubleClickListener(new IDoubleClickListener()
        {
            public void doubleClick(DoubleClickEvent event)
            {
                okPressed();
            }
        });
    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#okPressed()
     */
    protected void okPressed()
    {
        IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
        setResult(selection.toList());
        super.okPressed();
    }
}
