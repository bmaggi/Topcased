/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.diagramconfigurator.internal.export;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.topcased.facilities.dialogs.ITopcasedDialogConstants;
import org.topcased.modeler.diagramconfigurator.internal.DiagramConfiguratorPlugin;
import org.topcased.modeler.editorconfigurator.EditorConfiguration;

/**
 * Creation 8 sept. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ExportDiagramConfiguratorDialog extends Dialog implements ITopcasedDialogConstants
{
    // SWT Objects
    private Composite dialogComposite;

    private EditorConfiguration editorConf;

    private Text editorConfText;

    private Button editorConfBtn;

    private String copyright;

    private Text copyrightText;

    private boolean isSamePluginAsEditor;

    private Button isSamePluginAsEditorBtn;

    /**
     * @param parentShell
     */
    public ExportDiagramConfiguratorDialog(Shell parentShell)
    {
        super(parentShell);
        setBlockOnOpen(true);
        setShellStyle(getShellStyle() | SWT.RESIZE);
    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    protected Control createDialogArea(Composite parent)
    {
        // Dialog
        dialogComposite = (Composite) super.createDialogArea(parent);
        createDialogComposite();
        createDialogContents(dialogComposite);
        return dialogComposite;
    }

    /**
     * Create the Dialog Contents
     */
    private void createDialogComposite()
    {
        GridLayout dialogLayout = new GridLayout();
        GridData dialogLayoutData = new GridData(GridData.FILL_BOTH);
        dialogLayoutData.minimumHeight = MIN_DIALOG_HEIGHT;
        dialogComposite.setLayout(dialogLayout);
        dialogComposite.setLayoutData(dialogLayoutData);
    }

    /**
     * Create the view of the list of interaction operators
     * 
     * @param parent the parent composite to contain this group
     */
    protected void createDialogContents(Composite parent)
    {
        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        composite.setLayout(layout);
        composite.setFont(parent.getFont());

        GridData gridData = new GridData(GridData.FILL_BOTH);
        composite.setLayoutData(gridData);

        Label editorConfLbl = new Label(composite, SWT.NONE);
        editorConfLbl.setText("Select an EditorConfiguration file : ");
        editorConfText = new Text(composite, SWT.BORDER);
        editorConfText.setEnabled(false);
        editorConfText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        editorConfBtn = new Button(composite, SWT.BORDER);
        editorConfBtn.setText("...");
        editorConfBtn.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                ResourceSelectionDialog wrDialog = new ResourceSelectionDialog(DiagramConfiguratorPlugin.getPlugin().getWorkbench().getActiveWorkbenchWindow().getShell(),
                        ResourcesPlugin.getWorkspace().getRoot(), "Please select the editor configuration associated with this diagram configuration.");

                if (wrDialog.open() == Window.OK)
                {
                    Object[] results = wrDialog.getResult();
                    if (results.length == 1 && results[0] instanceof IFile)
                    {
                        IFile newFile = (IFile) results[0];
                        if ("editorconfigurator".equals(newFile.getFileExtension()))
                        {
                            URI resourceURI = URI.createPlatformResourceURI(newFile.getFullPath().toString());
                            ResourceSet resouceSet = new ResourceSetImpl();
                            Resource resource = resouceSet.getResource(resourceURI, true);

                            Object rootObject = resource.getContents().get(0);
                            if (rootObject instanceof EditorConfiguration)
                            {
                                editorConf = (EditorConfiguration) rootObject;
                                editorConfText.setText(newFile.getName());
                            }

                            resource.unload();
                        }
                    }
                }
            }
        });

        Label copyrightLbl = new Label(composite, SWT.NONE);
        copyrightLbl.setText("Copyright Text : ");
        copyrightText = new Text(composite, SWT.BORDER | SWT.MULTI);
        GridData gridData2 = new GridData(GridData.FILL_BOTH);
        gridData2.horizontalSpan = 2;
        copyrightText.setLayoutData(gridData2);

        isSamePluginAsEditorBtn = new Button(composite, SWT.BORDER | SWT.CHECK);
        isSamePluginAsEditorBtn.setText("The Diagram Plugin should be generated in the same Plugin as the Editor one");
        GridData gridData3 = new GridData(GridData.FILL_HORIZONTAL);
        gridData3.horizontalSpan = 3;
        isSamePluginAsEditorBtn.setLayoutData(gridData3);
    }

    /**
     * Save the viewers datas before the dialogs disposing
     * 
     * @see org.eclipse.jface.dialogs.Dialog#okPressed()
     */
    protected void okPressed()
    {
        copyright = copyrightText.getText();
        isSamePluginAsEditor = isSamePluginAsEditorBtn.getSelection();

        super.okPressed();
    }

    /**
     * Return the EditorConfiguration that should be referenced by the DiagramConfiguration that is exported.
     * 
     * @return EditorConfiguration
     */
    public EditorConfiguration getEditorConfigurator()
    {
        return editorConf;
    }

    /**
     * Get the Copyright that shoud be used with the generated files
     * 
     * @return String
     */
    public String getCopyrightText()
    {
        return copyright;
    }

    /**
     * Specify whether the Diagram plugin should be generated in the same plugin as the Editor one
     * 
     * @return true if the plugins should be 'merged' in the same plugin.
     */
    public boolean isSamePluginAsEditor()
    {
        return isSamePluginAsEditor;
    }
}
