/*******************************************************************************
 * Copyright (c) 2008,2010 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *    Sebastien Gabel (CS) - fix URI encoding/decoding
 *******************************************************************************/
package org.topcased.modeler.internal.collaboration;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * This page allows the user to select the main resource containing the sub-model to import.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
class SelectSourceFileWizardPage extends WizardPage
{
    private final URI ctrlUri;

    private Text uriField;

    private URI partURI;

    private List<ViewerFilter> filters = new ArrayList<ViewerFilter>();

    public SelectSourceFileWizardPage(final URI ctrlUri)
    {
        super("selectFile");
        setTitle("Import");
        setDescription("Select the sub-model to import");
        this.ctrlUri = ctrlUri;
        filters.add(new ViewerFilter()
        {
            @Override
            public boolean select(Viewer viewer, Object parentElement, Object element)
            {
                IResource resource = (IResource) element;
                if (resource.getType() != IResource.FILE)
                {
                    return true;
                }
                else
                {
                    return resource.getName().endsWith(".part." + ctrlUri.fileExtension());
                }
            }
        });
    }

    public void createControl(Composite parent)
    {
        Composite contents = new Composite(parent, SWT.NONE);
        contents.setLayout(new GridLayout(3, false));
        setControl(contents);

        Label label = new Label(contents, SWT.LEAD);
        label.setText("Model to import: ");

        uriField = new Text(contents, SWT.BORDER);
        uriField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        uriField.addModifyListener(new ModifyListener()
        {
            public void modifyText(ModifyEvent e)
            {
                validateInputs();
            }
        });

        final Button browseButton = new Button(contents, SWT.NONE);
        browseButton.setText("Select...");
        browseButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), "Import...", "Select the sub-model to import", false, getSuggestedPath(), filters);
                if (files != null && files.length > 0)
                {
                    URI uri = URI.createPlatformResourceURI(files[0].getFullPath().toString(), true);
                    uriField.setText(uri.toPlatformString(true));
                }
            }
        });
    }

    protected Object[] getSuggestedPath()
    {
        IWorkspaceRoot wks = ResourcesPlugin.getWorkspace().getRoot();
        IPath path = new Path(ctrlUri.toPlatformString(true));
        return new Object[] {wks.findMember(path)};
    }

    private void validateInputs()
    {
        boolean valid = false;
        String rawText = uriField.getText();
        if (rawText.length() > 0)
        {
            try
            {
                partURI = URI.createPlatformResourceURI(rawText, true);
            }
            catch (IllegalArgumentException iae)
            {
                partURI = null;
                setErrorMessage("Invalid model file.");
                setPageComplete(false);
                return;
            }
            IWorkspaceRoot wks = ResourcesPlugin.getWorkspace().getRoot();
            IPath path = new Path(partURI.toPlatformString(true));
            IResource res = wks.findMember(path);
            if (res != null && res.getType() == IResource.FILE)
            {
                valid = true;
            }
        }
        if (valid)
        {
            setErrorMessage(null);
            setPageComplete(true);
        }
        else
        {
            partURI = null;
            setErrorMessage("Invalid model file.");
            setPageComplete(false);
        }
        // TODO Also check that the part.di & cache are present
    }

    public URI getPartURI()
    {
        return partURI;
    }

    @Override
    public void setVisible(boolean visible)
    {
        if (visible)
        {
            URI uri = (this.partURI != null) ? this.partURI : ExportUtil.getExportedModelURI(ctrlUri);
            uriField.setText(uri.toPlatformString(true));
        }
        super.setVisible(visible);
    }
}