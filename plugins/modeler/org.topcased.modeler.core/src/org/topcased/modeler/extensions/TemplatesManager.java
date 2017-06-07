/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. 
 * All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		Jacques LESCOT (Anyware Technologies) 
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
 * Class that stores the templates registered with the <i>templates</i>
 * extension point.
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class TemplatesManager extends AbstractExtensionManager
{

    /* ========================= */
    /* Extension point constants */
    /* ========================= */

    private static final String TEMPLATES_EXTENSION_POINT = "templates";

    /** the shared instance */
    private static TemplatesManager manager;

    /**
     * A set that will only ever contain TemplateDescriptors.
     */
    private SortedSet<TemplateDescriptor> templates = new TreeSet<TemplateDescriptor>(new Comparator<TemplateDescriptor>()
    {
        public int compare(TemplateDescriptor o1, TemplateDescriptor o2)
        {
            String id1 = o1.getId();
            String id2 = o2.getId();

            return id1.compareTo(id2);
        }
    });

    /**
     * Basic constructor
     */
    private TemplatesManager()
    {
        super(ModelerPlugin.getId() + "." + TEMPLATES_EXTENSION_POINT);

        readRegistry();
    }

    /**
     * Get the shared instance.
     * 
     * @return the diagrams manager
     */
    public static TemplatesManager getInstance()
    {
        if (manager == null)
        {
            manager = new TemplatesManager();
        }

        return manager;
    }

    /**
     * Find a descriptor in the registry.
     * 
     * @param id the searched template id
     * @return the template or <code>null</code> if not found
     */
    public TemplateDescriptor find(String id)
    {
        Iterator<TemplateDescriptor> itr = templates.iterator();
        while (itr.hasNext())
        {
            TemplateDescriptor desc = itr.next();
            if (id.equals(desc.getId()))
            {
                return desc;
            }
        }
        return null;
    }

    /**
     * Get an enumeration of template descriptors.
     * 
     * @return The registered templates
     */
    public TemplateDescriptor[] getTemplates()
    {
        return (TemplateDescriptor[]) templates.toArray(new TemplateDescriptor[templates.size()]);
    }

    /**
     * Get an enumeration of template descriptors that are applicable only for
     * the given editorId
     * 
     * @param editorId the id of the Topcased editor
     * @return The registered templates of a given Topcased editor
     */
    public TemplateDescriptor[] getTemplates(String editorId)
    {
        List<TemplateDescriptor> templateList = new ArrayList<TemplateDescriptor>();
        
        Iterator<TemplateDescriptor> itr = templates.iterator();
        while (itr.hasNext())
        {
            TemplateDescriptor desc = itr.next();
            if (editorId.equals(desc.getEditorId()))
            {
                templateList.add(desc);
            }
        }
        return templateList.toArray(new TemplateDescriptor[templateList.size()]);
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
                if (TemplateDescriptor.TAG_TEMPLATE.equals(confElt.getName()))
                {
                    TemplateDescriptor descriptor = new TemplateDescriptor(confElt);
                    templates.add(descriptor);
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
            if (TemplateDescriptor.TAG_TEMPLATE.equals(confElt.getName()))
            {
                String id = confElt.getAttribute(TemplateDescriptor.ATT_ID);
                TemplateDescriptor descriptor = find(id);
                templates.remove(descriptor);
            }
        }
    }

}
