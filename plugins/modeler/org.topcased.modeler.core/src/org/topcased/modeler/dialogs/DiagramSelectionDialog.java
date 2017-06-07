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

import java.util.List;

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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.topcased.facilities.dialogs.ITopcasedDialogConstants;
import org.topcased.modeler.extensions.DiagramDescriptor;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;

/**
 * Selection of a diagram among a list of diagrams
 * 
 * @author jako
 */
public class DiagramSelectionDialog extends SelectionDialog implements ITopcasedDialogConstants
{
    
    // Diagram Ids and Names
    private List<DiagramDescriptor> diagramDescriptors;

    // SWT Objects
    private Composite dialogComposite;

    private ListViewer listViewer;

    private Button initializeBt;

    /**
     * Create the Dialog window showing the different diagrams that can be
     * created
     * 
     * @param descriptors the List of the DiagramDescriptors that can be created
     * @param parentShell the parent Shell
     */
    public DiagramSelectionDialog(List<DiagramDescriptor> descriptors, Shell parentShell)
    {
        super(parentShell);

        if (descriptors == null || descriptors.size() == 0)
        {
            throw new IllegalArgumentException();
        }

        diagramDescriptors = descriptors;

        setTitle("Diagram creation");
        setMessage("Select the diagram to create :");
        
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
        dialogComposite = (Composite) super.createDialogArea(parent);
        GridData dialogLayoutData = new GridData(GridData.FILL_BOTH);
        dialogLayoutData.widthHint = DEFAULT_DIALOG_WIDTH;
        dialogLayoutData.heightHint = DEFAULT_DIALOG_HEIGHT;
        dialogComposite.setLayoutData(dialogLayoutData);
        
        createMessageArea(dialogComposite);
        createList(dialogComposite);
        createInitializeButton(dialogComposite);

        hookListeners();
        
        return dialogComposite;
    }
    
    /**
     * Create the chackbox button to initialize the diagram content and initialize its value.
     * @param parent the parent composite
     */
    protected void createInitializeButton(Composite parent)
    {
        // add initialization checkbox
        initializeBt = new Button(parent, SWT.CHECK);
        initializeBt.setText("Initialize the diagram with existing model objects");
        initializeBt.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
        initializeBt.setSelection(isInitialized());
    }
    
    /**
     * Creates the group for diagram selection
     * 
     * @param parent the parent Composite
     */
    protected void createList(Composite parent)
    {
        listViewer = new ListViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        listViewer.getList().setLayoutData(new GridData(GridData.FILL_BOTH));
        
        // Set the label provider
        listViewer.setLabelProvider(new LabelProvider()
        {
            public String getText(Object element)
            {
                // Return the resolution's label.
                if (element instanceof DiagramDescriptor)
                {
                    DiagramDescriptor diag = (DiagramDescriptor) element;
                    return diag.getName();
                }
                return "";
            }
        });
        
        // Set the content provider
        listViewer.setContentProvider(new ArrayContentProvider());
        listViewer.setInput(diagramDescriptors);
        listViewer.setSelection(new StructuredSelection(diagramDescriptors.get(0)));

        // Set the initial selection
        listViewer.setSelection(new StructuredSelection(diagramDescriptors.get(0)));
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
     * Returns <code>true</code> if the diagram content must be initialized by the existing model objects
     * @return <code>true</code> if diagram must be initialized
     */
    public boolean isInitialized()
    {
        return ModelerPlugin.getDefault().getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_INITIALIZE_DIAGRAM);
    }
    
    /**
     * Store the diagram that was selected
     * 
     * @see org.eclipse.jface.dialogs.Dialog#okPressed()
     */
    protected void okPressed()
    {
        IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
        setResult(selection.toList());
        
        ModelerPlugin.getDefault().getPreferenceStore().setValue(ModelerPreferenceConstants.P_INITIALIZE_DIAGRAM, initializeBt.getSelection());
        
        super.okPressed();
    }
}
