/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Caroline Bourdeu d'Aguerre (Atos Origin) caroline.bourdeudaguerre@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.editor.properties.sections;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.edit.DiagramEditPart;

/**
 * Section for diagram element
 *
 */
public class DiagramNameElementSection extends AbstractStringPropertySection
{

    /*
     * (non-Javadoc)
     * 
     * @see org.topcased.modeler.editor.properties.sections.AbstractTextPropertySection#getFeature()
     */
    @Override
    protected EAttribute getFeature()
    {
        EAttribute feature;
        if (eObject instanceof Diagram )
        {
            feature = DiagramInterchangePackage.Literals.DIAGRAM__NAME;
        }
        else
        {
            feature = eObject.eClass().getEIDAttribute();
        }
        return feature;
    }

    @Override
    protected String getLabelText()
    {
        return "Name:";
    }
    
    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#setInput(org.eclipse.ui.IWorkbenchPart,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void setInput(IWorkbenchPart part, ISelection selection)
    {
        super.setInput(part, selection);

        if (selection instanceof IStructuredSelection 
                &&((IStructuredSelection) selection).getFirstElement() instanceof EObject)
        {
            eObject = (EObject) ((IStructuredSelection) selection).getFirstElement();
            eObjectList = ((IStructuredSelection) selection).toList();
        }
        else if (((IStructuredSelection) selection).getFirstElement() instanceof DiagramEditPart)
        {
            selectedEditPart = (EditPart) ((IStructuredSelection) selection).getFirstElement();
            eObject = (EObject) selectedEditPart.getModel();
        }
    }

}
