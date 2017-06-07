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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * This intermediate class handles the lazy loading of the exporter. With this class the class of the exporter is
 * instanciated the first time the exporter is called but provides accessor for the general properties.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ExporterDescriptor
{
    // Constants

    public static final String TAG_EXPORTER = "exporter";

    public static final String ATT_FORMAT = "format";

    public static final String ATT_EXTENSION = "extension";

    public static final String ATT_CLASS = "class";

    // Values
    private String format;

    private String extension;

    private IConfigurationElement configElement;

    private IImageExporter exporter;

    /**
     * Initialize the descriptor from the XML fragment of the extension
     * 
     * @param element The XML Fragment that describes the Diagram
     * @throws CoreException if the xml fragment is not valid
     */
    ExporterDescriptor(IConfigurationElement element) throws CoreException
    {
        super();

        load(element);
    }

    /**
     * Initialize the descriptor from the XML extension
     * 
     * @param element the xml fragment
     * @throws CoreException thrown if thye XML fragment is not valid
     */
    private void load(IConfigurationElement element) throws CoreException
    {
        configElement = element;
        format = configElement.getAttribute(ATT_FORMAT);
        extension = configElement.getAttribute(ATT_EXTENSION);
        String clazz = configElement.getAttribute(ATT_CLASS);

        // Sanity check.
        if (format == null || extension == null || clazz == null)
        {
            throw new CoreException(new Status(IStatus.ERROR, configElement.getContributor().getName(), IStatus.OK, "Invalid extension (missing format, extension or class)", null));
        }
    }

    /**
     * Returns the class that export the figure as image.
     * 
     * @return Returns the exporter.
     * @throws CoreException if there is an error while loading class
     */
    public IImageExporter getExporter() throws CoreException
    {
        if (exporter == null)
        {
            Object config = configElement.createExecutableExtension(ATT_CLASS);
            if (!(config instanceof IImageExporter))
            {
                throw new CoreException(new Status(IStatus.ERROR, configElement.getContributor().getName(), IStatus.OK, "Invalid configuration class for exporter format : " + getFormat(), null));
            }
            exporter = (IImageExporter) config;
        }
        return exporter;
    }

    /**
     * Returns the file extension for the genrated image
     * 
     * @return Returns the extension.
     */
    public String getExtension()
    {
        return extension;
    }

    /**
     * Returns the format of the generated image
     * 
     * @return Returns the format.
     */
    public String getFormat()
    {
        return format;
    }
}
