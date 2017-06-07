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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.topcased.modeler.editor.outline.ModelLabelProvider;

/**
 * This page shows the user the elements which have been determined to be dependencies of the sub-model, and for which
 * copies will be put in the separate cache resource.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
class CachePreviewWizardPage extends WizardPage
{
    private AdapterFactory adapterFactory;

    private TreeViewer treeViewer;

    private CacheContentsSpecification cacheSpec;

    private Button removeButton;

    private Button addButton;

    private Object selectedObject;

    public CachePreviewWizardPage(AdapterFactory adapterFactory, CacheContentsSpecification cacheSpec)
    {
        super("previewCache");
        setTitle("Cache preview");
        setDescription("The elements shown below will be included in the cache.");
        this.adapterFactory = adapterFactory;
        this.cacheSpec = cacheSpec;
    }

    public void createControl(Composite parent)
    {
        Composite contents = new Composite(parent, SWT.NONE);
        contents.setLayout(new GridLayout(2, false));

        Label label = new Label(contents, SWT.NONE);
        label.setText("Cache contents:");
        label.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, true, false, 2, 1));

        treeViewer = new TreeViewer(contents, SWT.SINGLE | SWT.BORDER);
        treeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
        treeViewer.setContentProvider(new CachePreviewContentProvider(new AdapterFactoryContentProvider(adapterFactory)));
        ModelLabelProvider labelProvider = new ModelLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
        treeViewer.setLabelProvider(new CachePreviewLabelProvider(labelProvider));
        treeViewer.setInput(cacheSpec);
        treeViewer.addSelectionChangedListener(new ISelectionChangedListener()
        {
            public void selectionChanged(SelectionChangedEvent event)
            {
                selectedObject = null;
                ISelection sel = event.getSelection();
                if (sel instanceof IStructuredSelection)
                {
                    selectedObject = ((IStructuredSelection) sel).getFirstElement();
                    updateButtonsStatus();
                }
            }
        });

        Composite userButtons = new Composite(contents, SWT.NONE);
        userButtons.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
        userButtons.setLayout(new GridLayout(1, true));
        createAddButton(userButtons);
        createRemoveButton(userButtons);
        removeButton.setEnabled(false);

        setControl(contents);
    }

    private void createAddButton(Composite parent)
    {
        addButton = new Button(parent, SWT.PUSH);
        addButton.setText("Add...");
        addButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        addButton.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                addUserElement();
            }
        });
    }

    private void createRemoveButton(Composite parent)
    {
        removeButton = new Button(parent, SWT.PUSH);
        removeButton.setText("Remove");
        removeButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false));
        removeButton.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                removeUserElement();
            }
        });
    }

    private void updateButtonsStatus()
    {
        removeButton.setEnabled(cacheSpec.getUserElements().contains(selectedObject));
        addButton.setEnabled(true);
        addButton.setEnabled(selectedObject == CachePreviewContentProvider.CATEGORY_USER);
    }

    private void addUserElement()
    {
        ModelElementChooserDialog dlg = new ModelElementChooserDialog(getShell(), "Select an element", "Select an element to add to the cache:");
        dlg.setAdapterFactory(adapterFactory);
        dlg.setInput(cacheSpec.getRootElement().eContainer().eResource());
        EObject userElement = dlg.open();
        if (userElement != null && !cacheSpec.isValidUserElement(userElement))
        {
            MessageDialog.openError(getShell(), "Invalid element", "This element can not be added to the user-specified cache elements.");
        }
        else if (userElement != null)
        {
            cacheSpec.addUserElement(userElement);
            treeViewer.refresh();
        }
    }

    private void removeUserElement()
    {
        cacheSpec.removeUserElement((EObject) selectedObject);
        treeViewer.refresh();
    }
}
