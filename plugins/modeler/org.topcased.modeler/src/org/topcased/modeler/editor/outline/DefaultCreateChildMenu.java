/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Thomas Friol (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.outline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.MenuManager;
import org.topcased.modeler.actions.CreateChildAction;
import org.topcased.modeler.editor.IMixedEditDomain;

/**
 * A default 'Create child' menu. <br>
 * Creation : 24 nov. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class DefaultCreateChildMenu extends MenuManager implements IMixedCreateChildMenu
{
    private IMixedEditDomain editDomain;

    private EObject selectedObject;

    /**
     * Constructor.
     */
    public DefaultCreateChildMenu()
    {
        super("Create child");
    }

    /**
     * @see org.topcased.modeler.editor.outline.ICreateChildMenu#setMixedEditDomain(org.topcased.modeler.editor.MixedEditDomain)
     */
    public void setMixedEditDomain(IMixedEditDomain domain)
    {
        editDomain = domain;
    }

    /**
     * @see org.topcased.modeler.editor.outline.ICreateChildMenu#setSelectedEObject(org.eclipse.emf.ecore.EObject)
     */
    public void setSelectedEObject(EObject object)
    {
        selectedObject = object;
    }

    /**
     * @see org.topcased.modeler.editor.outline.ICreateChildMenu#createMenuContents()
     */
    public void createMenuContents()
    {
        Collection newChildDescriptors = editDomain.getEMFEditingDomain().getNewChildDescriptors(selectedObject, null);
        Collection createChildActions = generateCreateChildActions(editDomain, newChildDescriptors, selectedObject);
        populateManager(this, createChildActions, null);
    }

    /**
     * This populates the specified <code>manager</code> with
     * {@link org.eclipse.jface.action.ActionContributionItem}s based on the
     * {@link org.eclipse.jface.action.IAction}s contained in the
     * <code>actions</code> collection, by inserting them before the specified
     * contribution item <code>contributionID</code>. If <code>ID</code> is
     * <code>null</code>, they are simply added.
     * 
     * @param manager the menu to fill
     * @param actions the actions to add
     * @param contributionID the position of the contribution
     */
    protected void populateManager(IContributionManager manager, Collection actions, String contributionID)
    {
        if (actions != null)
        {
            for (Iterator i = actions.iterator(); i.hasNext();)
            {
                IAction action = (IAction) i.next();
                if (contributionID != null)
                {
                    manager.insertBefore(contributionID, action);
                }
                else
                {
                    manager.add(action);
                }
            }
        }
    }

    /**
     * This generates a {@link org.topcased.modeler.actions.CreateChildAction}
     * for each object in <code>descriptors</code>, and returns the
     * collection of these actions.
     * 
     * @param domain The modeler domain
     * @param descriptors the child descriptors
     * @param selection the selected object
     * @return a collection of actions
     */
    protected Collection generateCreateChildActions(IMixedEditDomain domain, Collection descriptors, EObject selection)
    {
        Collection actions = new ArrayList();
        if (descriptors != null)
        {
            for (Iterator i = descriptors.iterator(); i.hasNext();)
            {
                actions.add(new CreateChildAction(domain, selection, i.next()));
            }
        }
        return actions;
    }
}
