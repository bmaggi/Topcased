/*******************************************************************************
* Copyright (c) 2005 AIRBUS FRANCE.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
*    Jacques Lescot (Anyware Technologies) - initial API and implementation
*******************************************************************************/ 
package org.topcased.modeler.configurator.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.topcased.modeler.configurator.ConfiguratorPlugin;

/**
 * Class FigureDeclarationManager
 * 
 * @author jako
 */
public final class FigureDeclarationManager
{
    // Extension point constants
    /**
     * Comment for <code>FIGURE_DECLARATIONS_EXTENSION_POINT</code>
     * <p>
     * The name of the extension point
     * </p>
     */
    public static final String FIGURE_DECLARATIONS_EXTENSION_POINT = "figureDeclaration"; //$NON-NLS-1$

    /**
     * Comment for <code>TAG_FIGURE_DECLARATION</code>
     * <p>
     * The tag of one figureDeclaration
     * </p>
     */
    public static final String TAG_FIGURE_DECLARATION = FIGURE_DECLARATIONS_EXTENSION_POINT; //$NON-NLS-1$

    /**
     * Comment for <code>ATT_NAME</code>
     * <p>
     * A figureDeclaration name that will be displayed in the wizard
     * </p>
     */
    public static final String ATT_NAME = "name"; //$NON-NLS-1$

    /**
     * Comment for <code>ATT_CLASS</code>
     * <p>
     * The string which correspond to the figureDeclaration model diagram file
     * </p>
     */
    public static final String ATT_CLASS = "class"; //$NON-NLS-1$

    /** The singleton */
    private static FigureDeclarationManager manager;

    /**
     * libraries from the extension point (key=figureDeclaration name,
     * value=IConfigurationElement for the figureDeclaration)
     */
    private Map figureDeclarations;

    /**
     * Constructor
     */
    private FigureDeclarationManager()
    {
        figureDeclarations = new HashMap();
    }

    /**
     * Singleton getter
     * 
     * @return the static instance of the manager
     */
    public static FigureDeclarationManager getInstance()
    {
        if (manager == null)
            manager = new FigureDeclarationManager();

        return manager;
    }

    /**
     * Returns the list of all existing figureDeclarations referenced in the
     * extension point
     * 
     * @return the List of all figureDeclarations
     */
    public Set getFigureDeclarationIds()
    {
        initialize();

        return figureDeclarations.keySet();
    }

    /**
     * Returns the String that represent the path of the Class from the name of
     * the figure given in the extension point.
     * 
     * @param name the figure name of the extension point
     * @return the Class path of the Figure
     */
    public String getPathClassName(String name)
    {
        initialize();
        IConfigurationElement conf = (IConfigurationElement) figureDeclarations.get(name);
        if (conf == null)
        {
            throw new IllegalArgumentException("The figure '" + name + "' is not registered.");
        }
        
        return conf.getAttribute(ATT_CLASS);
    }

    /**
     * Returns the String that represent the class of the given name
     * 
     * @param name the figure name of the extension point
     * @return the Class name
     */
    public String getClassName(String name)
    {
        String path = getPathClassName(name);

        // get the last part of the path
        int indexBeginning = path.lastIndexOf('.');

        // get and return the name
        return path.substring(indexBeginning + 1, path.length());
    }

    /**
     * Returns the list of all existing figureDeclarations referenced in the
     * extension point
     * 
     * @return the List of the figureDeclaration names
     */
    public String[] getFigureDeclarationNames()
    {
        initialize();

        List figureDeclarationNameList = new ArrayList();
        for (Iterator i = figureDeclarations.values().iterator(); i.hasNext();)
        {
            IConfigurationElement confElement = (IConfigurationElement) i.next();
            String figureDeclarationName = confElement.getAttribute(ATT_NAME);
            figureDeclarationNameList.add(figureDeclarationName);
        }
        String[] figureDeclarationNames = (String[]) figureDeclarationNameList.toArray(new String[figureDeclarationNameList.size()]);
        return figureDeclarationNames;
    }

    /**
     * Fill the Map with the figureDeclarations declared in the Extension point
     */
    private void retrieveFigureDeclarations()
    {
        IExtensionPoint point = Platform.getExtensionRegistry().getExtensionPoint(ConfiguratorPlugin.getId(),
                FIGURE_DECLARATIONS_EXTENSION_POINT);
        IExtension[] extensions = point.getExtensions();

        for (int i = 0; i < extensions.length; i++)
        {
            IConfigurationElement[] figureDeclarationElements = extensions[i].getConfigurationElements();

            // Iterates on all the figureDeclarations
            for (int j = 0; j < figureDeclarationElements.length; j++)
            {
                IConfigurationElement figureDeclarationConf = figureDeclarationElements[j];
                String figureDeclarationName = figureDeclarationConf.getAttribute(ATT_NAME);

                if (figureDeclarationConf.getName().equals(TAG_FIGURE_DECLARATION) && figureDeclarationName != null)
                {
                    // check if the class exists and add it to the
                    // figureDeclarations
                    try
                    {
                        ConfiguratorPlugin.createExtension(figureDeclarationConf, ATT_CLASS);
                        figureDeclarations.put(figureDeclarationName, figureDeclarationConf);
                    }
                    catch (CoreException ce)
                    {
                        ConfiguratorPlugin.log(ce);
                    }
                }
            }
        }
    }

    /**
     * Retrieve the figureDeclarations if it is not done yet
     */
    private void initialize()
    {
        if (figureDeclarations.isEmpty())
        {
            retrieveFigureDeclarations();
        }
    }

}
