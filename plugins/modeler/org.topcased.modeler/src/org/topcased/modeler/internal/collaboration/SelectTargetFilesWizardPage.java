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

import static org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog.openFolderSelection;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
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
 * The first page of the export wizard, which allows the user to select the main destination resource.
 *
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
class SelectTargetFilesWizardPage extends WizardPage
{
    /**
     * The base name of the model to export. Defaults to the base name of the controlled resource.
     */
    private Text nameField;

    /**
     * The directory where to create the exported resources. Defaults to the directory of the controlled resource.
     */
    private Text destField;

    /**
     * The default URI initially proposer to the user, determined from the controlled resource's URI.
     */
    private URI defaultURI;

    /**
     * The full URI of the main exported resource (the <code>M.part.model</code> one), or <code>null</code> if the
     * current user inputs are invalid.
     */
    private URI selectedURI;

    /**
     * The file extension of the exported resources (e.g. <code>"uml"</code>).
     */
    private String modelExtension;

    public SelectTargetFilesWizardPage(Resource controlledResource)
    {
        super("selectFiles");
        setTitle("Select main exported file");
        setDescription("Select the name and location of the main exported file");
        defaultURI = ExportUtil.getExportedModelURI(controlledResource);
        modelExtension = controlledResource.getURI().fileExtension();
    }

    /**
     * Returns the full URI of the main exported resource (the <code>M.part.model</code> one) as chosen by the user, or
     * <code>null</code> if the current user inputs are invalid.
     */
    public URI getSelectedURI()
    {
        return selectedURI;
    }

    /**
     * Validate the current user input in the two text fields, and set the page's status and error message accordingly.
     */
    public void validateInputs()
    {
        if (nameField.getText().equals(""))
        {
            invalidatePage("Missing model name.");
            return;
        }
        if (destField.getText().equals(""))
        {
            invalidatePage("Missing destination directory.");
            return;
        }

        IWorkspaceRoot wks = ResourcesPlugin.getWorkspace().getRoot();
        IPath baseDir = new Path(destField.getText());
        if (baseDir.segmentCount() == 1 && !isAccessible(wks.getProject(destField.getText())))
        {
            invalidatePage("Invalid destination directory.");
            return;
        }
        else if (baseDir.segmentCount() > 1 && !isAccessible(wks.getFolder(baseDir)))
        {
            invalidatePage("Invalid destination directory.");
            return;
        }
        else if (baseDir.segmentCount() == 0)
        {
            invalidatePage("Invalid destination directory.");
            return;
        }

        IPath[] files = new IPath[] {baseDir.append(nameField.getText() + ".part." + modelExtension), // Main file
                baseDir.append(nameField.getText() + ".part." + modelExtension + "di"), // Diagrams
                baseDir.append(nameField.getText() + ".cache." + modelExtension) // Cache
        };
        for (IPath file : files)
        {
            if (isAccessible(wks.getFile(file)))
            {
                invalidatePage("File already exists: " + file.toString());
                return;
            }
        }

        IPath path = new Path(destField.getText()).append(nameField.getText()).addFileExtension("part").addFileExtension(modelExtension);
        selectedURI = URI.createPlatformResourceURI(path.toString(), true);
        setErrorMessage(null);
        setPageComplete(true);
    }

    private boolean isAccessible(IResource res)
    {
        return res != null && res.isAccessible();
    }

    private void invalidatePage(String message)
    {
        selectedURI = null;
        setErrorMessage(message);
        setPageComplete(false);
    }

    public void createControl(Composite parent)
    {
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(3, false));
        setControl(container);

        ModifyListener validatingListener = new ModifyListener()
        {
            public void modifyText(ModifyEvent e)
            {
                validateInputs();
            }
        };

        createNameField(container);
        nameField.addModifyListener(validatingListener);
        createDestinationField(container);
        destField.addModifyListener(validatingListener);
    }

    private void createNameField(Composite container)
    {
        Label label = new Label(container, SWT.LEAD);
        label.setText("Sub-model name: ");

        nameField = new Text(container, SWT.BORDER);
        GridData gd = new GridData();
        gd.horizontalSpan = 2;
        gd.horizontalAlignment = SWT.FILL;
        gd.grabExcessHorizontalSpace = true;
        nameField.setLayoutData(gd);
    }

    private void createDestinationField(Composite container)
    {
        Label label = new Label(container, SWT.LEAD);
        label.setText("Destination directory: ");

        destField = new Text(container, SWT.BORDER);
        destField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Button destButton = new Button(container, SWT.NONE);
        destButton.setText("Browse...");
        destButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                IContainer[] result = openFolderSelection(getShell(), "Export into...", null, false, null, null);
                if (result != null && result.length > 0)
                {
                    IPath path = result[0].getFullPath();
                    destField.setText(path.toString());
                }
            }
        });
    }

    @Override
    public void setVisible(boolean visible)
    {
        if (visible)
        {
            URI uri = (this.selectedURI != null) ? this.selectedURI : defaultURI;
            uri = uri.trimFileExtension().trimFileExtension(); // Remove ".part.model" suffix.
            nameField.setText(URI.decode(uri.lastSegment()));
            uri = uri.trimSegments(1);
            destField.setText(uri.toPlatformString(true));
        }
        super.setVisible(visible);
    }
}