/*******************************************************************************
 * Copyright (c) 2009-2010 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *    Jean-Patrice Giacometti (Airbus) - port to DI
 *******************************************************************************/
package org.topcased.scripting.di;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.scripting.BasicTopcasedDOM;

/**
 * The DI DOM, with specific services and helpers to manipulate Topcased Diagram models.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public class DiDOM extends BasicTopcasedDOM
{
    /**
     * Provides access to the factory to create all the elements of a Diagram editor
     * 
     * @return The Diagram factory
     */
    public DiagramInterchangeFactory getFactory()
    {
        return DiagramInterchangePackage.eINSTANCE.getDiagramInterchangeFactory();
    }

    /**
     * Returns the currently selected model element in the current editor if it is an instance of the named meta-class
     * (or a sub-class).
     * 
     * @param typeName the name of a meta-class (e.g. "GraphNode" or "GraphEdge")
     * @return the first element selected in the current editor if there is one and it is an instance of the named
     *         meta-class or a sub-class of it.
     */
    public EObject getSelection(String typeName)
    {
        EClassifier type = DiagramInterchangePackage.eINSTANCE.getEClassifier(typeName);
        if (type == null)
        {
            return null;
        }
        EObject selection = getSelection();
        if (selection != null && type.isInstance(selection))
        {
            return selection;
        }
        else
        {
            return null;
        }
    }

    /**
     * Returns the currently selected view model element, either in the editor or the outline view. If several elements are
     * selected, only the first is returned.
     * 
     * @return the currently selected view model element.
     */
    @Override
    public EObject getSelection()
    {
        EObject result = null;
        ISelection selection = getEditorSelection();
        if (selection instanceof ITreeSelection)
        {
            result = (EObject) ((ITreeSelection) selection).getFirstElement();
        }
        else if (selection instanceof IStructuredSelection)
        {
            Object element = ((IStructuredSelection) selection).getFirstElement();
            if (element instanceof AbstractEditPart)
            {
                result = (EObject) (((AbstractEditPart) element).getModel());
            }
        }
        return result;
    }

}