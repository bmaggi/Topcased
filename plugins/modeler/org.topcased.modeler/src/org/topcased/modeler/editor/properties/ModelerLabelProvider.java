/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.properties;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.edit.DiagramEditPart;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.utils.Utils;

/**
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ModelerLabelProvider extends LabelProvider
{

    private AdapterFactoryLabelProvider adapterFactoryLabelProvider;

    /**
     * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
     */
    public Image getImage(Object element)
    {
        Object theElement = element;
        if (theElement == null || theElement.equals(StructuredSelection.EMPTY))
        {
            return null;
        }
        if (theElement instanceof IStructuredSelection)
        {
            IStructuredSelection structuredSelection = (IStructuredSelection) theElement;
            if (areDifferentTypes(structuredSelection))
            {
                return null;
            }
            theElement = structuredSelection.getFirstElement();
        }
        if (theElement instanceof EditPart)
        {
            GraphElement graphElement = (GraphElement) ((EditPart) theElement).getModel();
            if (theElement instanceof DiagramEditPart)
            {
                theElement = graphElement;
            }
            else
            {
                theElement = Utils.getElement(graphElement);
            }
        }
        theElement = AdapterFactoryEditingDomain.unwrap(theElement);
        if (theElement instanceof EObject || theElement instanceof Resource)
        {
            if(getAdapterFactoryLabelProvider() != null)
            {
                return getAdapterFactoryLabelProvider().getImage(theElement);
            }
        }
        return null;
    }

    /**
     * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
     */
    public String getText(Object element)
    {
        Object theElement = element;
        if (theElement == null || theElement.equals(StructuredSelection.EMPTY))
        {
            return null;
        }
        if (theElement instanceof IStructuredSelection)
        {
            IStructuredSelection structuredSelection = (IStructuredSelection) theElement;
            if (areDifferentTypes(structuredSelection))
            {
                return structuredSelection.size() + " items selected";//$NON-NLS-1$
            }
            theElement = structuredSelection.getFirstElement();
        }
        if (theElement instanceof EditPart)
        {
            GraphElement graphElement = (GraphElement) ((EditPart) theElement).getModel();
            if (graphElement instanceof Diagram)
            {
                theElement = graphElement;
            }
            else
            {
                theElement = Utils.getElement(graphElement);
            }
            if (theElement == null && getAdapterFactoryLabelProvider() != null)
            {
                return getAdapterFactoryLabelProvider().getText(graphElement);
            }
        }
        theElement = AdapterFactoryEditingDomain.unwrap(theElement);
        if (theElement instanceof EObject && getAdapterFactoryLabelProvider() != null)
        {
            return getAdapterFactoryLabelProvider().getText(theElement);
        }
        else if (theElement instanceof Resource)
        {
            return "\u00ABResource\u00BB";
        }

        return null;
    }

    /**
     * Return the AdapterFactoryLabelProvider
     * 
     * @return AdapterFactoryLabelProvider
     */
    protected AdapterFactoryLabelProvider getAdapterFactoryLabelProvider()
    {
        if (adapterFactoryLabelProvider == null)
        {
            if (PlatformUI.getWorkbench() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null
                    && PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() != null)
            {
                Modeler modeler = (Modeler) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getAdapter(Modeler.class);
                if (modeler != null)
                {
                    adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(modeler.getAdapterFactory());
                }
            }
        }
        return adapterFactoryLabelProvider;
    }

    /**
     * Determine there are objects in the structured selection of different types.
     * 
     * @param structuredSelection the structured selection.
     * @return true if there are objects of different types in the selection.
     */
    private boolean areDifferentTypes(IStructuredSelection structuredSelection)
    {
        if (structuredSelection.size() == 1)
        {
            return false;
        }
        Iterator< ? > i = structuredSelection.iterator();
        Object element = i.next();
        for (; i.hasNext();)
        {
            if (i.next().getClass() != element.getClass())
            {
                return true;
            }
        }

        return false;
    }
}
