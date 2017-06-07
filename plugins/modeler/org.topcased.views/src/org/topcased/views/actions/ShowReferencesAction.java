/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * Copyright (c) 2012 Airbus
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies)
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Pierre Gaufillet (Airbus) - General purpose references view
 *
 * $Id: ShowReferencesAction.java,v 1.2 2012/07/26 05:38:11 gaufille Exp $
 **********************************************************************/

package org.topcased.views.actions;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.topcased.views.ReferencesView;
import org.topcased.views.internal.Activator;

/**
 * This action shows the references to the selected object
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ShowReferencesAction implements IObjectActionDelegate
{

    private IWorkbenchPart activePart;

    private EModelElement activeEModelElement;

    /**
     * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
     *      org.eclipse.ui.IWorkbenchPart)
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart)
    {
        activePart = targetPart;
    }

    /**
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    public void run(IAction action)
    {
        if (activeEModelElement != null)
        {
            try
            {
                IViewPart view = activePart.getSite().getPage().showView(ReferencesView.VIEW_ID);
                ((ReferencesView) view).setAnalyzedObject(activeEModelElement);
            }
            catch (PartInitException exception)
            {
                Activator.log(exception);
            }
        }
    }

    /**
     * Returns the selected EObject from the given selection
     * 
     * @param selection the selection which contains the EObject
     * @return the selected EObject
     */
    protected EObject getSelection(IStructuredSelection selection)
    {
        Object selectedObject = selection.getFirstElement();
        if (selectedObject != null)
        {
            if (selectedObject instanceof EObject)
            {
                return (EObject) selectedObject;
            }

            if (selectedObject instanceof IAdaptable)
            {
                Object adaptedObj = ((IAdaptable) selectedObject).getAdapter(EObject.class);
                if (adaptedObj instanceof EObject)
                {
                    return (EObject) adaptedObj;
                }
            }

            IAdapterManager adapterManager = Platform.getAdapterManager();
            if (adapterManager.hasAdapter(selectedObject, EObject.class.getName()))
            {
                Object adaptedObj = adapterManager.loadAdapter(selectedObject, EObject.class.getName());
                if (adaptedObj instanceof EObject)
                {
                    return (EObject) adaptedObj;
                }
            }
        }
        return null;
    }

    /**
     * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(IAction action, ISelection selection)
    {
        activeEModelElement = null;
        if (selection instanceof IStructuredSelection)
        {
            EObject selectedEObject = getSelection((IStructuredSelection) selection);
            if (selectedEObject instanceof EModelElement)
            {
                activeEModelElement = (EModelElement) selectedEObject;
            }
        }
    }

}
