/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.export.internal.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.topcased.facilities.dialogs.ITopcasedDialogConstants;
import org.topcased.modeler.export.ExporterDescriptor;
import org.topcased.modeler.export.ExporterManager;
import org.topcased.modeler.export.internal.Activator;

/**
 * 
 * Creation 24 sept. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ExportAllDiagramsDialog extends Dialog implements ITopcasedDialogConstants
{
    private IFile selectedDiagramFile;
    
    // SWT Objects
    private Composite dialogComposite;
    private Text outputPathTxt;
    private Button outputDirectoryBtn;
    private Combo outputFormatCb;
    
    // Configured items
    private IResource outputDirectory;
    private String exporter;

    /**
     * @param parentShell
     * @param selectedFile 
     */
    public ExportAllDiagramsDialog(Shell parentShell, IFile selectedFile)
    {
        super(parentShell);
        this.selectedDiagramFile = selectedFile;
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
        hookListeners();
        loadData();
        return dialogComposite;
    }

    /**
     * Create the Dialog Contents
     */
    private void createDialogComposite()
    {
        GridLayout dialogLayout = new GridLayout();
        GridData dialogLayoutData = new GridData(GridData.FILL_BOTH);
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
        editorConfLbl.setText("Select the output directory : ");
        outputPathTxt = new Text(composite, SWT.BORDER);
        outputPathTxt.setEnabled(false);
        outputPathTxt.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        outputDirectoryBtn = new Button(composite, SWT.NONE);
        outputDirectoryBtn.setText("Browse...");

        Label outputFormatLbl = new Label(composite, SWT.NONE);
        outputFormatLbl.setText("Select the output format : ");

        outputFormatCb = new Combo(composite, SWT.NONE);
        GridData gridData2 = new GridData(GridData.FILL_HORIZONTAL);
        gridData2.horizontalSpan = 2;
        outputFormatCb.setLayoutData(gridData2);
    }
    
    private void loadData() {
        outputDirectory = selectedDiagramFile.getParent();
        outputPathTxt.setText(outputDirectory.getLocation().toString());
        
        outputFormatCb.setItems(ExporterManager.getInstance().getFormats());
        if (ExporterManager.getInstance().getExporter("JPEG") != null) {
            // Use JPEG as the default Exporter
            outputFormatCb.setText("JPEG");
        }
        else {
            // Otherwise use the first encountered format
            outputFormatCb.select(0);
        }
        exporter = outputFormatCb.getText();
    }
    
    private void hookListeners() {
        outputDirectoryBtn.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                ContainerSelectionDialog csDialog = new ContainerSelectionDialog(Activator.getActiveWorkbenchShell(), ResourcesPlugin.getWorkspace().getRoot(), true, "Please select the output directory");
                

                if (csDialog.open() == Window.OK)
                {
                    Object[] results = csDialog.getResult();
                    if (results.length == 1 && results[0] instanceof IPath)
                    {
                        URI uri = URI.createPlatformResourceURI(((IPath) results[0]).toString(), true);
                        outputDirectory = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(uri.toPlatformString(true)));
                        outputPathTxt.setText(outputDirectory.getLocation().toString());
                    }
                }
            }
        });
        
        outputFormatCb.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                exporter = outputFormatCb.getText();
            }
        });
    }

    /**
     * Return the selected output IResource
     * 
     * @return IResource
     */
    public IResource getOutputDirectory()
    {
        return outputDirectory;
    }

    
    /**
     * Returns the exporter associated with the given selection
     * 
     * @return ExporterDescriptor
     */
    public ExporterDescriptor getExporter()
    {
        return ExporterManager.getInstance().getExporter(exporter);
    }

}
