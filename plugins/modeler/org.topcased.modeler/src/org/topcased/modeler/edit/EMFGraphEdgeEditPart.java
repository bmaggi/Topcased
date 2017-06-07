/*******************************************************************************
 * Copyright (c) 2005,2010 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.edit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.ModelerEditPolicyConstants;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.edit.policies.DeleteModelObjectEditPolicy;
import org.topcased.modeler.utils.Utils;

/**
 * This edit part adds abilities for model objects linked with EMF objects : listening... <br>
 * 
 * Creation : 20 December 2004<br>
 * Updated : 11 February 2010<br>
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class EMFGraphEdgeEditPart extends GraphEdgeEditPart implements IModelElementEditPart
{

    /**
     * Constructor
     * 
     * @param conn the edge object
     */
    public EMFGraphEdgeEditPart(GraphEdge conn)
    {
        super(conn);
    }

    /**
     * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
     */
    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class key)
    {
        if (key.isInstance(getEObject()))
        {
            return getEObject();
        }

        return super.getAdapter(key);
    }

    /**
     * @see org.eclipse.gef.EditPart#activate()
     */
    public void activate()
    {
        super.activate();

        if (getEObject() != null && !getEObject().eAdapters().contains(getModelListener()))
        {
            getEObject().eAdapters().add(getModelListener());
        }
    }

    /**
     * @see org.eclipse.gef.EditPart#deactivate()
     */
    public void deactivate()
    {
        if (getEObject() != null)
        {
            getEObject().eAdapters().remove(getModelListener());
        }
        super.deactivate();
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
     */
    protected void createEditPolicies()
    {
        super.createEditPolicies();

        // Provide the Policy to delete the model object associated with the EMFGraphEdge
        installEditPolicy(ModelerEditPolicyConstants.DELETE_MODEL_OBJECT_EDITPOLICY, new DeleteModelObjectEditPolicy(this));
    }

    /**
     * @see org.topcased.modeler.edit.GraphEdgeEditPart#handleModelChanged(org.eclipse.emf.common.notify.Notification)
     */
    protected void handleModelChanged(Notification msg)
    {
        super.handleModelChanged(msg);

        refreshEdgeObjects();
    }

    /**
     * @see org.topcased.modeler.edit.IModelElementEditPart#getEObject()
     */
    public EObject getEObject()
    {
        return Utils.getElement((GraphElement) getModel());
    }

}
