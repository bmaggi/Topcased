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
package org.topcased.modeler.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.Adaptable;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.topcased.modeler.ModelerRequestConstants;
import org.topcased.modeler.commands.DeleteModelCommand;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.edit.IModelElementEditPart;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.editor.MixedEditDomain;
import org.topcased.modeler.editor.Modeler;

/**
 * The EditPolicy that handle the Delete Model Object command<br>
 * 
 * Creation : 09 may 2005<br>
 * Update : 14 October 2010<br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class DeleteModelObjectEditPolicy extends AbstractEditPolicy
{

    private final IModelElementEditPart editPart;

    /**
     * Constructor
     */
    public DeleteModelObjectEditPolicy()
    {
        this.editPart = null;
    }

    /**
     * Constructor
     * 
     * @param editPart An edit part linked to a semantic model object
     */
    public DeleteModelObjectEditPolicy(IModelElementEditPart editPart)
    {
        this.editPart = editPart;
    }

    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
     */
    public Command getCommand(Request request)
    {
        if (understandsRequest(request))
        {
            EObject model = getEObject();
            if (model != null)
            {
                if (hasRootEditPart(getHost()))
                {
                    EditDomain domain = getHost().getViewer().getEditDomain();
                    IMixedEditDomain mixedDom = null;
                    if (domain instanceof IMixedEditDomain)
                    {
                        mixedDom = (IMixedEditDomain) domain;
                    }
                    else if (domain instanceof Adaptable)
                    {
                        mixedDom = ((Adaptable) domain).getAdapter(IMixedEditDomain.class);
                    }
                    if (mixedDom != null)
                    {
                        Diagrams diagrams = ((Modeler) mixedDom.getEditorPart()).getDiagrams();
                        if (domain != null && diagrams != null)
                        {
                            return getDeleteCommand(mixedDom, diagrams, model);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * Gets the invoked delete command regarding the current scope. Here the default delete command is returned but
     * subclasses may override this method.
     * 
     * @return the instantiation of the right delete command.
     */
    protected Command getDeleteCommand(IMixedEditDomain domain, Diagrams diagrams, EObject model)
    {
        if (domain instanceof MixedEditDomain)
        {
            // use the old deprecated method in case an editor overrides it.
            return getDeleteCommand((MixedEditDomain) domain, diagrams, model);
        }
        return new DeleteModelCommand(domain, diagrams, model);
    }

    /**
     * Gets the invoked delete command regarding the current scope. Here the default delete command is returned but
     * subclasses may override this method.
     * 
     * @return the instantiation of the right delete command.
     * @deprecated use {@link #getDeleteCommand(IMixedEditDomain, Diagrams, EObject)} instead
     */
    protected Command getDeleteCommand(MixedEditDomain domain, Diagrams diagrams, EObject model)
    {
        return new DeleteModelCommand(domain, diagrams, model);
    }

    /**
     * Recursive method to test is there is a RootEditPart for this editPart. This method exists to avoid NPE on
     * getHost().getViewer() method.
     * 
     * @param editPart the EditPart to test
     * @return true if it exists, false otherwise.
     */
    private boolean hasRootEditPart(EditPart editPart)
    {
        boolean hasRootEditPart = false;
        if (editPart != null)
        {
            EditPart lParentEditPart = editPart.getParent();
            if (lParentEditPart != null)
            {
                if (lParentEditPart instanceof RootEditPart)
                {
                    hasRootEditPart = true;
                }
                else
                {
                    hasRootEditPart = hasRootEditPart(lParentEditPart);
                }
            }
        }
        return hasRootEditPart;
    }

    /**
     * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#understandsRequest(org.eclipse.gef.Request)
     */
    public boolean understandsRequest(Request req)
    {
        if (ModelerRequestConstants.REQ_DELETE_MODEL_OBJECT.equals(req.getType()))
        {
            EObject model = getEObject();
            if (model != null)
            {
                EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(model);
                return domain != null && !domain.isReadOnly(model.eResource());
            }
        }
        return super.understandsRequest(req);
    }

    /**
     * Gets the model object targeted by this edit policy
     * 
     * @return an EObject representing the current model object
     */
    protected EObject getEObject()
    {
        if (editPart == null)
        {
            EObject model = null;
            if (getHost() instanceof IModelElementEditPart)
            {
                return ((IModelElementEditPart) getHost()).getEObject();
            }
            return model;
        }
        else
        {
            return editPart.getEObject();
        }
    }

}
