/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Nicolas Lalevee (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.extensions;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * This menu manager creates the context menu for the registered models.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class RegisteredModelMenu extends MenuManager
{
    protected class LoadAction extends Action
    {
        private EditingDomain domain;

        private String modelPath;

        /**
         * Constructor
         * 
         * @param domain the EMF editing domain
         * @param name The name of the file
         * @param path the path of the model to load
         */
        public LoadAction(EditingDomain domain, String name, String path)
        {
            super();
            this.domain = domain;
            this.modelPath = path;
            setText(name);
            setDescription("Load the registered model");
            update();
        }

        /**
         * @see org.eclipse.jface.action.IAction#run()
         */
        public void run()
        {
            domain.getResourceSet().getResource(URI.createURI(modelPath), true);
        }

        /**
         * Update the enable state of the action
         */
        public void update()
        {
            setEnabled(domain != null && modelPath != null);
        }
    }

    private EditingDomain domain;

    private String metamodel;

    public RegisteredModelMenu(String text, EditingDomain domain)
    {
        this(text, null, domain, null);
    }

    public RegisteredModelMenu(String text, EditingDomain domain, String metamodelURI)
    {
        this(text, null, domain, metamodelURI);
    }

    public RegisteredModelMenu(String text, String id, EditingDomain domain, String metamodelURI)
    {
        super(text, id);
        this.domain = domain;
        this.metamodel = metamodelURI;
        create(this);
    }

    protected void create(IMenuManager manager)
    {
        if (domain != null)
        {
            RegisteredModelDescriptor[] modelDescriptors = RegisteredModelManager.getInstance().getRegisteredModels(metamodel);
            for (int i = 0; i < modelDescriptors.length; i++)
            {
                String category = modelDescriptors[i].getParentCategory();
                IMenuManager categoryMenu = findOrCreateCategory(manager, category);
                createLoadAction(categoryMenu, modelDescriptors[i]);
            }
        }
    }

    /**
     * Find the given category and create it if it does not exist.
     * 
     * @param manager the parent menu
     * @param categoryId the category id
     * @return the menu associated to this category
     */
    protected IMenuManager findOrCreateCategory(IMenuManager manager, String categoryId)
    {
        IMenuManager categoryMenu = null;
        if (categoryId == null)
        {
            categoryMenu = manager;
        }
        else
        {
            CategoryDescriptor category = RegisteredModelManager.getInstance().findCategory(categoryId);
            if (category == null)
            {
                ModelerPlugin.log("Invalid category : '" + categoryId + "' is not registered.", IStatus.WARNING);
            }
            else
            {
                IMenuManager parentCategory = findOrCreateCategory(manager, category.getParentCategory());
                if (parentCategory != null)
                {
                    categoryMenu = parentCategory.findMenuUsingPath(categoryId);
                    if (categoryMenu == null)
                    {
                        categoryMenu = new MenuManager(category.getName(), categoryId);
                        parentCategory.add(categoryMenu);
                    }
                }
            }
        }
        return categoryMenu;
    }

    protected void createLoadAction(IMenuManager manager, final RegisteredModelDescriptor desc)
    {
        Action action = new LoadAction(domain, desc.getName(), desc.getModelPath());
        manager.add(action);
    }
}
