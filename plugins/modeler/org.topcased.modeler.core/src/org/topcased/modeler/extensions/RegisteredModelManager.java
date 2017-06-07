/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. 
 * All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		David Sciamma (Anyware Technologies) 
 * 		- initial API and implementation
 ******************************************************************************/
package org.topcased.modeler.extensions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.topcased.facilities.extensions.AbstractExtensionManager;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * Class that stores the validators registered with the <i>validators</i>
 * extension point.
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class RegisteredModelManager extends AbstractExtensionManager
{

    /* ========================= */
    /* Extension point constants */
    /* ========================= */

    private static final String REGISTERED_MODEL_EXTENSION_POINT = "registeredModels";

    /** the shared instance */
    private static RegisteredModelManager manager;

    /**
     * A set that will only ever contain RegisteredModelDescriptors.
     */
    private SortedSet<RegisteredModelDescriptor> registeredModels = new TreeSet<RegisteredModelDescriptor>(new Comparator<RegisteredModelDescriptor>()
    {
        public int compare(RegisteredModelDescriptor o1, RegisteredModelDescriptor o2)
        {
            String path1 = o1.getModelPath();
            String path2 = o2.getModelPath();

            return path1.compareTo(path2);
        }
    });

    /**
     * A set that will only ever contain CategoryDescriptors.
     */
    private SortedSet<CategoryDescriptor> categories = new TreeSet<CategoryDescriptor>(new Comparator<CategoryDescriptor>()
    {
        public int compare(CategoryDescriptor o1, CategoryDescriptor o2)
        {
            String id1 = o1.getId();
            String id2 = o2.getId();

            return id1.compareTo(id2);
        }
    });

    /**
     * Basic constructor
     */
    private RegisteredModelManager()
    {
        super(ModelerPlugin.getId() + "." + REGISTERED_MODEL_EXTENSION_POINT);

        readRegistry();
    }

    /**
     * Get the shared instance.
     * 
     * @return the validators manager
     */
    public static RegisteredModelManager getInstance()
    {
        if (manager == null)
        {
            manager = new RegisteredModelManager();
        }

        return manager;
    }

    /**
     * Find a descriptor in the registry.
     * 
     * @param id the searched category id
     * @return the category or <code>null</code> if not found
     */
    public CategoryDescriptor findCategory(String id)
    {
        Iterator<CategoryDescriptor> itr = categories.iterator();
        while (itr.hasNext())
        {
            CategoryDescriptor desc = itr.next();
            if (id.equals(desc.getId()))
            {
                return desc;
            }
        }
        return null;
    }

    /**
     * Find a descriptor in the registry.
     * 
     * @param path the searched model path
     * @return the model descriptor or <code>null</code> if not found
     */
    public RegisteredModelDescriptor findRegisteredModel(String path)
    {
        Iterator<RegisteredModelDescriptor> itr = registeredModels.iterator();
        while (itr.hasNext())
        {
            RegisteredModelDescriptor desc = itr.next();
            if (path.equals(desc.getModelPath()))
            {
                return desc;
            }
        }
        return null;
    }

    /**
     * Get an enumeration of model descriptors.
     * 
     * @return The registered models
     */
    public RegisteredModelDescriptor[] getRegisteredModels()
    {
        return (RegisteredModelDescriptor[]) registeredModels.toArray(new RegisteredModelDescriptor[registeredModels.size()]);
    }

    /**
     * Get an enumeration of model descriptors that are valid for the given
     * metamodel.
     * 
     * @param uri the uri of a metamodel
     * @return The registered models
     */
    public RegisteredModelDescriptor[] getRegisteredModels(String uri)
    {
        RegisteredModelDescriptor[] models;
        if (uri != null)
        {
            List<RegisteredModelDescriptor> filteredModels = new ArrayList<RegisteredModelDescriptor>();
            Iterator<RegisteredModelDescriptor> it = registeredModels.iterator();
            while (it.hasNext())
            {
                RegisteredModelDescriptor desc = it.next();
                String descURI = desc.getMetamodelURI();
                if (descURI == null || descURI.equals(uri))
                {
                    filteredModels.add(desc);
                }
            }
            models = filteredModels.toArray(new RegisteredModelDescriptor[filteredModels.size()]);
        }
        else
        {
            models = getRegisteredModels();
        }
        
        return models;
    }

    /**
     * @see org.topcased.facilities.extensions.AbstractExtensionManager#addExtension(org.eclipse.core.runtime.IExtension)
     */
    protected void addExtension(IExtension extension)
    {

        IConfigurationElement[] elements = extension.getConfigurationElements();
        for (int i = 0; i < elements.length; i++)
        {
            IConfigurationElement confElt = elements[i];
            try
            {
                if (RegisteredModelDescriptor.TAG_MODEL.equals(confElt.getName()))
                {
                    RegisteredModelDescriptor descriptor = new RegisteredModelDescriptor(confElt);
                    registeredModels.add(descriptor);
                }
                if (CategoryDescriptor.TAG_CATEGORY.equals(confElt.getName()))
                {
                    CategoryDescriptor descriptor = new CategoryDescriptor(confElt);
                    categories.add(descriptor);
                }
            }
            catch (CoreException ce)
            {
                ModelerPlugin.log(ce);
            }
        }
    }

    /**
     * @see org.topcased.facilities.extensions.AbstractExtensionManager#removeExtension(org.eclipse.core.runtime.IExtension)
     */
    protected void removeExtension(IExtension extension)
    {

        IConfigurationElement[] elements = extension.getConfigurationElements();
        for (int i = 0; i < elements.length; i++)
        {
            IConfigurationElement confElt = elements[i];
            if (RegisteredModelDescriptor.TAG_MODEL.equals(confElt.getName()))
            {
                String path = confElt.getAttribute(RegisteredModelDescriptor.ATT_PATH);
                RegisteredModelDescriptor descriptor = findRegisteredModel(path);
                registeredModels.remove(descriptor);
            }
            if (CategoryDescriptor.TAG_CATEGORY.equals(confElt.getName()))
            {
                String id = confElt.getAttribute(CategoryDescriptor.ATT_ID);
                CategoryDescriptor descriptor = findCategory(id);
                categories.remove(descriptor);
            }
        }
    }

}
