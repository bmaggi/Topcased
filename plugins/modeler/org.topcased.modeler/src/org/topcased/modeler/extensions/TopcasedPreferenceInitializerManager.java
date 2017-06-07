/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thibault Landre (Atos Origin) <a href="mailto:thibault.landre@atosorigin.com">Thibault Landre</a> - Initial API and implementation
 *
 *****************************************************************************/
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
 * Class that stores the preference initializer registered with the <i>topcasedPreferenceInitializer</i> extension
 * point.
 * 
 * @author <a href="mailto:thibault.landre@atosorigin.com">Thibault Landre</a>
 * 
 */
public final class TopcasedPreferenceInitializerManager extends AbstractExtensionManager
{
    private static final String TOPCASED_PREFERENCE_INITIALIZER_EXTENSION_POINT = "topcasedPreferenceInitializer";

    /** the shared instance */
    private static TopcasedPreferenceInitializerManager manager;

    /**
     * A set that will only ever contain TopcasedPreferenceInitializerDescriptor.
     */
    private SortedSet<TopcasedPreferenceInitializerDescriptor> topcasedPreferencesInitializer = new TreeSet<TopcasedPreferenceInitializerDescriptor>(new Comparator<TopcasedPreferenceInitializerDescriptor>()
    {
        public int compare(TopcasedPreferenceInitializerDescriptor o1, TopcasedPreferenceInitializerDescriptor o2)
        {
            String id1 = o1.getId();
            String id2 = o2.getId();

            return id1.compareTo(id2);
        }
    });

    /**
     * Basic constructor
     */
    private TopcasedPreferenceInitializerManager()
    {
        super(ModelerPlugin.getId() + "." + TOPCASED_PREFERENCE_INITIALIZER_EXTENSION_POINT);

        readRegistry();
    }

    /**
     * Get the shared instance.
     * 
     * @return the diagrams manager
     */
    public static TopcasedPreferenceInitializerManager getInstance()
    {
        if (manager == null)
        {
            manager = new TopcasedPreferenceInitializerManager();
        }
        return manager;
    }

    /**
     * @see org.topcased.facilities.extensions.AbstractExtensionManager#addExtension(org.eclipse.core.runtime.IExtension)
     */
    @Override
    protected void addExtension(IExtension extension)
    {
        IConfigurationElement[] elements = extension.getConfigurationElements();
        for (IConfigurationElement confElt : elements)
        {
            try
            {
                if (TopcasedPreferenceInitializerDescriptor.TAG_PREFERENCEINITIALIZER.equals(confElt.getName()))
                {
                    TopcasedPreferenceInitializerDescriptor descriptor = new TopcasedPreferenceInitializerDescriptor(confElt);
                    topcasedPreferencesInitializer.add(descriptor);
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
    @Override
    protected void removeExtension(IExtension extension)
    {
        IConfigurationElement[] elements = extension.getConfigurationElements();
        for (IConfigurationElement confElt : elements)
        {
            if (TopcasedPreferenceInitializerDescriptor.TAG_PREFERENCEINITIALIZER.equals(confElt.getName()))
            {
                String id = confElt.getAttribute(TopcasedPreferenceInitializerDescriptor.ATT_ID);
                TopcasedPreferenceInitializerDescriptor descriptor = find(id);
                topcasedPreferencesInitializer.remove(descriptor);
            }
        }

    }

    /**
     * Find a descriptor in the registry.
     * 
     * @param id the searched topcasedPreferenceInitializer id
     * @return the topcasedPreferenceInitializer or <code>null</code> if not found
     */
    private TopcasedPreferenceInitializerDescriptor find(String id)
    {
        Iterator<TopcasedPreferenceInitializerDescriptor> itr = topcasedPreferencesInitializer.iterator();
        while (itr.hasNext())
        {
            TopcasedPreferenceInitializerDescriptor desc = (TopcasedPreferenceInitializerDescriptor) itr.next();
            if (id.equals(desc.getId()))
            {
                return desc;
            }
        }
        return null;
    }

    /**
     * Get an enumeration of template descriptors that are applicable only for the given editorId
     * 
     * @param editorId the id of the Topcased editor
     * @return The registered templates of a given Topcased editor
     */
    public TopcasedPreferenceInitializerDescriptor[] getTopcasedPreferenceInitializer(String editorId)
    {
        List<TopcasedPreferenceInitializerDescriptor> topcasedPreferencesInitializerList = new ArrayList<TopcasedPreferenceInitializerDescriptor>();

        Iterator<TopcasedPreferenceInitializerDescriptor> itr = topcasedPreferencesInitializer.iterator();
        while (itr.hasNext())
        {
            TopcasedPreferenceInitializerDescriptor desc = (TopcasedPreferenceInitializerDescriptor) itr.next();
            if (editorId.equals(desc.getEditorId()))
            {
                topcasedPreferencesInitializerList.add(desc);
            }
        }
        return (TopcasedPreferenceInitializerDescriptor[]) topcasedPreferencesInitializerList.toArray(new TopcasedPreferenceInitializerDescriptor[topcasedPreferencesInitializerList.size()]);
    }

}
