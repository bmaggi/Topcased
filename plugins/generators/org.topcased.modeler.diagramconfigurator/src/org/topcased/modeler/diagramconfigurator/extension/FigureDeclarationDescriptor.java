/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies), - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.diagramconfigurator.extension;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.IFigure;

/**
 * Class that describes a figure declaration
 * 
 * Creation 30 juin 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class FigureDeclarationDescriptor
{

    // Constants

    public static final String TAG_FIGURE_DECLARATION = "figureDeclaration";

    public static final String ATT_NAME = "name";

    public static final String ATT_CLASS = "class";

    public static final String TAG_DESCRIPTION = "description";

    // Values
    private String name;

    private String description;

    private IConfigurationElement configElement;

    /**
     * Initialize the descriptor from the XML fragment of the extension
     * 
     * @param element The XML Fragment that describes the FigureDeclaration
     * @throws CoreException if the xml fragment is not valid
     */
    FigureDeclarationDescriptor(IConfigurationElement element) throws CoreException
    {
        super();
        configElement = element;

        load();
    }

    private void load() throws CoreException
    {
        name = configElement.getAttribute(ATT_NAME);
        String clazz = configElement.getAttribute(ATT_CLASS);

        // Sanity check.
        if (name == null || clazz == null)
        {
            throw new CoreException(new Status(IStatus.ERROR, configElement.getNamespaceIdentifier(), IStatus.OK, "Invalid extension (missing name, or class name): " + name, null));
        }

        IConfigurationElement[] desc = configElement.getChildren(TAG_DESCRIPTION);
        if (desc.length > 0)
        {
            description = desc[0].getValue();
        }
    }

    /**
     * Get the Figure associated with this extension
     * 
     * @return the figure
     * @throws CoreException
     */
    public IFigure getFigure() throws CoreException
    {
        Object figure = configElement.createExecutableExtension(ATT_CLASS);
        if (!(figure instanceof IFigure))
        {
            throw new CoreException(new Status(IStatus.ERROR, configElement.getNamespaceIdentifier(), IStatus.OK, "Invalid class name for extension : " + getName(), null));
        }

        return (IFigure) figure;
    }

    /**
     * Return the name given to the figure
     * 
     * @return String
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the description associated with the Figure
     * 
     * @return String
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Returns the String that represent the qualified class name of the Figure
     * 
     * @return the qualified class name of the Figure
     */
    public String getQualifiedFigureClassName()
    {
        return configElement.getAttribute(ATT_CLASS);
    }
}
