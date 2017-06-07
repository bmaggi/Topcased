/*******************************************************************************
 * Copyright (c) 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.internal.collaboration;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.topcased.facilities.dialogs.ITopcasedDialogConstants;
import org.topcased.modeler.editor.outline.ModelLabelProvider;

/**
 * A dialog to ask the user to select a model element. Used to add custom elements in the cache on export.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
class ModelElementChooserDialog extends Dialog
{
    private String message;

    private TreeViewer treeViewer;

    private List<EObject> selectedObjects;

    private AdapterFactory adapterFactory;

    private Object input;

    public ModelElementChooserDialog(Shell parent, String title, String message)
    {
        super(parent, SWT.DIALOG_TRIM | SWT.RESIZE | SWT.PRIMARY_MODAL);
        setText(title);
        this.message = message;
    }

    public void setAdapterFactory(AdapterFactory fact)
    {
        this.adapterFactory = fact;
    }

    public void setInput(Object input)
    {
        this.input = input;
    }

    public EObject open ()
    {
        List<EObject> result = openMulti(false);
        if (result != null && result.size() > 0)
        {
            return result.get(0);
        }
        return null ;
    }
    
    public List<EObject> openMulti ()
    {
        return openMulti(true);
    }
    
    public List<EObject> openMulti(boolean multi)
    {
        Shell shell = new Shell(getParent(), getStyle());
        shell.setText(getText());
        createContents(shell,true);
        treeViewer.setInput(input);
        treeViewer.expandToLevel(2);
        shell.setSize(ITopcasedDialogConstants.DEFAULT_DIALOG_WIDTH, ITopcasedDialogConstants.DEFAULT_DIALOG_HEIGHT);
        shell.open();
        Display display = getParent().getDisplay();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
            {
                display.sleep();
            }
        }
        return (List<EObject>) (selectedObjects == null ? Collections.emptyList() : selectedObjects);
    }

    private void createContents(final Shell shell, boolean multi)
    {
        shell.setLayout(new GridLayout(1, true));

        Label messageLabel = new Label(shell, SWT.LEAD);
        messageLabel.setText(message);

        int style = multi ? SWT.BORDER | SWT.MULTI : SWT.BORDER ;
        treeViewer = new TreeViewer(shell, style);
        treeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
        treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
        treeViewer.setLabelProvider(new ModelLabelProvider(new AdapterFactoryLabelProvider(adapterFactory)));
        treeViewer.addSelectionChangedListener(new ISelectionChangedListener()
        {
            public void selectionChanged(SelectionChangedEvent event)
            {
                selectedObjects = new LinkedList<EObject>();
                ISelection sel = event.getSelection();
                if (sel instanceof IStructuredSelection)
                {
                    for (Iterator<Object> i = ((IStructuredSelection) sel).iterator() ; i.hasNext() ; )
                    {
                        Object next = i.next();
                        if (next instanceof EObject)
                        {
                            selectedObjects.add((EObject) next);
                        }
                    }
                }
            }
        });

        Composite row = new Composite(shell, SWT.NONE);
        GridLayout layout = new GridLayout(2, false);
        row.setLayout(layout);
        Button selectButton = new Button(row, SWT.PUSH);
        selectButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, true, false));
        selectButton.setText("Select");
        selectButton.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                shell.close();
            }
        });

        Button cancelButton = new Button(row, SWT.PUSH);
        cancelButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, true, false));
        cancelButton.setText("Cancel");
        cancelButton.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                selectedObjects = null;
                shell.close();
            }
        });
    }
}
