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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.topcased.facilities.extensions.AbstractExtensionManager;
import org.topcased.modeler.diagramconfigurator.internal.DiagramConfiguratorPlugin;

/**
 * Class that stores the FigureDeclarations registered with the <i>figureDeclarations</i> extension point.
 * 
 * Creation 30 juin 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public final class FigureDeclarationsManager extends AbstractExtensionManager
{

    /* ========================= */
    /* Extension point constants */
    /* ========================= */

    private static final String FIGURE_DECLARATIONS_EXTENSION_POINT = "figureDeclarations";

    /** the shared instance */
    private static FigureDeclarationsManager manager;

    /**
     * A set that will only ever contain FigureDeclarationDescriptors.
     */
    private SortedSet<FigureDeclarationDescriptor> figureDeclarations = new TreeSet<FigureDeclarationDescriptor>(new Comparator<FigureDeclarationDescriptor>()
    {
        public int compare(FigureDeclarationDescriptor o1, FigureDeclarationDescriptor o2)
        {
            String id1 = o1.getName();
            String id2 = o2.getName();

            return id1.compareTo(id2);
        }
    });

    /**
     * Basic constructor
     */
    private FigureDeclarationsManager()
    {
        super(DiagramConfiguratorPlugin.getId() + "." + FIGURE_DECLARATIONS_EXTENSION_POINT);

        readRegistry();
    }

    /**
     * Get the shared instance.
     * 
     * @return the figureDeclarations manager
     */
    public static FigureDeclarationsManager getInstance()
    {
        if (manager == null)
        {
            manager = new FigureDeclarationsManager();
        }

        return manager;
    }

    /**
     * Find a descriptor in the registry.
     * 
     * @param name the searched figureDeclaration name
     * @return the figureDeclaration or <code>null</code> if not found
     */
    public FigureDeclarationDescriptor find(String name)
    {
        for (FigureDeclarationDescriptor desc : figureDeclarations)
        {
            if (name.equals(desc.getName()))
            {
                return desc;
            }
        }
        return null;
    }

    /**
     * Get an enumeration of FigureDeclaration descriptors.
     * 
     * @return The registered figureDeclarations
     */
    public FigureDeclarationDescriptor[] getFigureDeclarations()
    {
        return figureDeclarations.toArray(new FigureDeclarationDescriptor[figureDeclarations.size()]);
    }

    /**
     * Get the list of all the name of the FigureDeclaration descriptors.
     * 
     * @return The name of the registered figureDeclarations
     */
    public List<String> getFigureDeclarationNames()
    {
        List<String> namesList = new ArrayList<String>();
        for (FigureDeclarationDescriptor desc : figureDeclarations)
        {
            namesList.add(desc.getName());
        }
        return namesList;
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
                if (FigureDeclarationDescriptor.TAG_FIGURE_DECLARATION.equals(confElt.getName()))
                {
                    FigureDeclarationDescriptor descriptor = new FigureDeclarationDescriptor(confElt);
                    figureDeclarations.add(descriptor);
                }
            }
            catch (CoreException ce)
            {
                DiagramConfiguratorPlugin.log(ce);
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
            if (FigureDeclarationDescriptor.TAG_FIGURE_DECLARATION.equals(confElt.getName()))
            {
                String id = confElt.getAttribute(FigureDeclarationDescriptor.ATT_NAME);
                FigureDeclarationDescriptor descriptor = find(id);
                figureDeclarations.remove(descriptor);
            }
        }
    }

}
