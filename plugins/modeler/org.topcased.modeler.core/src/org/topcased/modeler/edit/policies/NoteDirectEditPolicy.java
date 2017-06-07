/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 **********************************************************************/
package org.topcased.modeler.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.util.DIUtils;

/**
 * Manage the LabelDirectEditPolicy for the Note element
 * 
 * @author Jacques LESCOT
 */
public class NoteDirectEditPolicy extends LabelDirectEditPolicy
{
    /**
     * Return the associated Property that will be used to handle the text value
     * 
     * @see org.topcased.modeler.edit.policies.LabelDirectEditPolicy#initModelObject()
     */
    protected EObject initModelObject()
    {
        EObject domainElement = null;
        if (getHost().getModel() instanceof GraphNode)
        {
            domainElement = DIUtils.getProperty((GraphNode) getHost().getModel(),
                    ModelerPropertyConstants.NOTE_VALUE);
        }
        return domainElement;
    }

    /**
     * The feature used to store the new text value
     * 
     * @see org.topcased.modeler.edit.policies.LabelDirectEditPolicy#getLabelTextFeature()
     */
    protected EStructuralFeature getLabelTextFeature()
    {
        return DiagramInterchangePackage.eINSTANCE.getProperty_Value();

    }
}
