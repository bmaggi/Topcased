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
 *  Laura Hernandez (Atos Origin) laura.hernandez@atosorigin.com - SetAuthorAnnotation Implementation
 *
  *****************************************************************************/

package org.topcased.modeler.actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.utils.Utils;

/**
 * The Class setAuthorAnnotation.
 */
public class SetAuthorAnnotation implements IObjectActionDelegate
{

    private static final String AUTHOR_URL_SOURCE = "http://www.topcased.org/author";

    private Shell shell;

    private IStructuredSelection selection;

    /**
     * Constructor for Action1.
     */
    public SetAuthorAnnotation()
    {
        super();
    }

    /**
     * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart)
    {
        shell = targetPart.getSite().getShell();
    }

    /**
     * @see IActionDelegate#run(IAction)
     */
    public void run(IAction action)
    {

        EObject elemModel = null;
        String author = ModelerPlugin.getDefault().getPreferenceStore().getString(ModelerPreferenceConstants.P_DEFAULT_AUTHOR);

        if (author != null && author.length() > 0)
        {
            MessageBox messageBox = new MessageBox(Display.getDefault().getActiveShell(), SWT.YES | SWT.NO | SWT.ICON_INFORMATION);
            messageBox.setMessage(String.format("Do you want to create author eAnnotation with the name \"%s\" for all the elements already created in your model? \n THE MODEL MUST BE CLOSED", author));
            messageBox.setText("Information");
            if (messageBox.open() == SWT.NO)
            {
                return;
            }

            // load the model from the selected uml file
            IFile file = (IFile) selection.getFirstElement();
            String selectedFileURI = file.getLocationURI().toString();
            try
            {
                elemModel = loadModel(selectedFileURI);
                Iterator<EObject> i = elemModel.eAllContents();
                do
                {
                    applyEAnnotation(elemModel, author);
                    elemModel = i.next();
                }
                while (i.hasNext());
                applyEAnnotation(elemModel, author);
                
                // Save model
                elemModel.eResource().save(Collections.EMPTY_MAP);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
                MessageDialog.openError(shell, "Error", e.getMessage());
            }
            catch (IOException e)
            {
                e.printStackTrace();
                MessageDialog.openError(shell, "Error", e.getMessage());
            }
        }
        else
        {
            // create dialog to warn the user
            MessageBox messageBox = new MessageBox(Display.getDefault().getActiveShell(), SWT.OK | SWT.ICON_INFORMATION);
            messageBox.setMessage("You have to set the author property in Preferences before create the eAnnotations\nWindow > Preferences > Topcased > Editors");
            messageBox.setText("Information");
            messageBox.open();
        }

    }

    private void applyEAnnotation(EObject elemModel, String author)
    {
        if (elemModel instanceof EModelElement && !(elemModel instanceof EAnnotation))
        {
            EModelElement element = (EModelElement) elemModel;
            
            if (element.getEAnnotation(AUTHOR_URL_SOURCE) == null)
            {
                Utils.createAuthorEAnnotation(element, author);
            }
        }
    }

    /**
     * Load model.
     * 
     * @param filePath the file path
     * @param needModelCreation create the model if true, load it any
     * 
     * @return the model
     * 
     * @throws FileNotFoundException the file not found exception
     */
    public static EObject loadModel(String diFilePath) throws FileNotFoundException
    {
    	String modelFilePath = diFilePath;
    	
    	// Get the model file path
    	if (modelFilePath.endsWith("di"))
    	{
    		modelFilePath = modelFilePath.substring(0, modelFilePath.length() - 2);
    	}
    	
        // Create a resource set
        ResourceSet resourceSet = new ResourceSetImpl();
        
        // Get the URI of the model file.
        URI fileURI = URI.createURI(modelFilePath);
        // Load the resource for this file.
        Resource resource = null;
        try
        {
            resource = resourceSet.getResource(fileURI, true);
            EObject modelElement = resource.getContents().get(0);
            return modelElement;
        }
        catch (Exception fileNotFound)
        {
            throw new FileNotFoundException("Unable to load the model from the specified file.");
        }
    }

    /**
     * @see IActionDelegate#selectionChanged(IAction, ISelection)
     */
    public void selectionChanged(IAction action, ISelection selection)
    {
        // the selected uml file
        this.selection = (IStructuredSelection) selection;
    }

}
