/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thibault Landre (Atos Origin) thibault.landre@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.createtemplate.action;

import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TemplateModelDialog extends Dialog 
{
	private static final Pattern validModelNamePattern = Pattern.compile("[a-zA-Z][a-zA-Z]*");
	
	private static final Color LIGHT_RED = new Color(Display.getCurrent(), 255, 128, 128);
	private static final Color WHITE = new Color(Display.getCurrent(), 255, 255, 255);
	
	private String modelURI;
	private Text modelURIField;
	private String templateModelName;
	private Text templateModelNameField;
	private Button isInstallRequiredButton;
	private Boolean isInstallRequired = false;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -791378125659593641L;
	
	 public TemplateModelDialog(Shell parentShell, IFile selectedFile)
	  {
		 	super(parentShell);
		 	modelURI = selectedFile.getLocationURI().toString();
	    }

	 protected Control createDialogArea(Composite parent)
	 {	
			// create top component
			Composite top = new Composite(parent, SWT.NONE);
			top.setLayout(new GridLayout(2, false));
			
			// create fields
			Label modelURILabel = new Label(top, SWT.NONE);
			modelURIField = new Text(top, SWT.BORDER);
		
			Label templateModelNameLabel = new Label(top, SWT.NONE);
			templateModelNameField = new Text(top, SWT.BORDER);
			
			Label isInstallRequiredLabel = new Label(top, SWT.NONE);
			isInstallRequiredButton = new Button(top, SWT.CHECK);
			
			// layout data
			modelURILabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			templateModelNameLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			isInstallRequiredLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			modelURIField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			templateModelNameField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			isInstallRequiredButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			
			// settings
			modelURILabel.setText("Model path : ");
			templateModelNameLabel.setText("Please specify the template model name : ");
			isInstallRequiredLabel.setText("Deploy on the current platform : ");
			if (modelURI != null) {
				modelURIField.setText(modelURI);
				modelURIField.setEditable(false);
			}


			templateModelNameField.setText(getModelTemplateName());
			
			
		
			
			
			// listeners
			templateModelNameField.addModifyListener(new ModifyListener() 
			{
				public void modifyText(ModifyEvent e) 
				{
					templateModelName = ((Text) e.getSource()).getText();
					templateModelNameField.setBackground(WHITE);
					updateOkButton(validModelNamePattern.matcher(templateModelName).matches());
				}
			});
			
			isInstallRequiredButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) 
				{
					isInstallRequired = isInstallRequiredButton.getSelection();
				}
			});
			
	        // display !
	        return top;
	  }
	 
	 private void updateOkButton(boolean isEnabled)
	 {
		 Button okButton = getButton(IDialogConstants.OK_ID);
		 okButton.setEnabled(isEnabled);
		 if(!isEnabled)
		 {
			 templateModelNameField.setBackground(LIGHT_RED);
		 }
	 }
	 
	 
	 public String getModelUri()
	 {
		 return modelURI;
	 }
	 
	 public String getModelTemplateName()
	 {
		 if(templateModelName == null)
		 {
			 templateModelName = getModelName();
		 }
		 return templateModelName;
	 }
	 
	 public Boolean isInstallRequired()
	 {
		 return isInstallRequired;
	 }
	 
	 /**
	  * Get the name of the selected model.
	  * @return
	  */
	 private String getModelName()
	 {
		 String lModelName = "";
		 Path lPath = new Path(modelURI);
		 	 
		 int extensionLength = lPath.getFileExtension().length();
		 lModelName = lPath.lastSegment().substring(0, lPath.lastSegment().length() - extensionLength -1);
		 
		 return lModelName;
	 }
}
