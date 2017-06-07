/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.export;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.topcased.facilities.extensions.AbstractExtensionManager;
import org.topcased.modeler.export.internal.Activator;

/**
 * This class manages the extension point <code>org.topcased.modeler.export.exporters</code>. It creates a cache of
 * all the registered exporters and handles dynamic plugins (update the cache).
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public final class ExporterManager extends AbstractExtensionManager
{
    /** Id of the extension point */
    public static final String EXTENSION_POINT = "org.topcased.modeler.export.exporters";

    /** shared instance */
    private static ExporterManager manager;

    private Map exporters = new HashMap();

    /**
     * Constructor
     */
    private ExporterManager()
    {
        super(EXTENSION_POINT);

        readRegistry();
    }

    /**
     * Returns the shared instance
     * 
     * @return the singleton
     */
    public static ExporterManager getInstance()
    {
        if (manager == null)
        {
            manager = new ExporterManager();
        }

        return manager;
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
                if (ExporterDescriptor.TAG_EXPORTER.equals(confElt.getName()))
                {
                    ExporterDescriptor descriptor = new ExporterDescriptor(confElt);
                    exporters.put(descriptor.getFormat(), descriptor);
                }
            }
            catch (CoreException ce)
            {
                Activator.log(ce);
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
            if (ExporterDescriptor.TAG_EXPORTER.equals(confElt.getName()))
            {
                String format = confElt.getAttribute(ExporterDescriptor.ATT_FORMAT);
                exporters.remove(format);
            }
        }
    }

    /**
     * Returns the exporter for the given format
     * 
     * @param format the format
     * @return the image exporter
     */
    public ExporterDescriptor getExporter(String format)
    {
        return (ExporterDescriptor) exporters.get(format);
    }

    /**
     * Returns the available export formats
     * 
     * @return the formats
     */
    public String[] getFormats()
    {
        return (String[]) exporters.keySet().toArray(new String[exporters.keySet().size()]);
    }

    /**
     * Returns the registered Exporter descriptors
     * 
     * @return the descriptors
     */
    public ExporterDescriptor[] getExporters()
    {
        return (ExporterDescriptor[]) exporters.values().toArray(new ExporterDescriptor[exporters.values().size()]);
    }
}
