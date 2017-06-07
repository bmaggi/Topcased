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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.topcased.facilities.extensions.AbstractExtensionManager;
import org.topcased.modeler.editor.IConfiguration;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * Class that stores the diagrams registered with the <i>diagrams</i> extension
 * point.
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public final class DiagramsManager extends AbstractExtensionManager
{

    /* ========================= */
    /* Extension point constants */
    /* ========================= */

    private static final String DIAGRAMS_EXTENSION_POINT = "diagrams";

    /** the shared instance */
    private static DiagramsManager manager;

    /**
     * A set that will only ever contain DiagramDescriptors.
     */
    private SortedSet<DiagramDescriptor> diagrams = new TreeSet<DiagramDescriptor>(new Comparator<DiagramDescriptor>()
    {
        public int compare(DiagramDescriptor o1, DiagramDescriptor o2)
        {
            String id1 =  o1.getId();
            String id2 =  o2.getId();

            return id1.compareTo(id2);
        }
    });

    /**
     * Basic constructor
     */
    private DiagramsManager()
    {
        super(ModelerPlugin.getId() + "." + DIAGRAMS_EXTENSION_POINT);

        readRegistry();
    }

    /**
     * Get the shared instance.
     * 
     * @return the diagrams manager
     */
    public static DiagramsManager getInstance()
    {
        if (manager == null)
        {
            manager = new DiagramsManager();
        }

        return manager;
    }

    /**
     * Returns the Diagram configuration for the given id.
     * 
     * @param id the diagram id
     * @return the configuration. If no DiagramDescriptor is associated with this ID, throw a RuntimeException.
     * @throws CoreException is the class does not exist or cannot be loaded
     */
    public IConfiguration getConfiguration(String id) throws CoreException
    {
        DiagramDescriptor diagramDescriptor = DiagramsManager.getInstance().find(id);
        if (diagramDescriptor != null)
        {
            return diagramDescriptor.getConfiguration();
        }
        
        throw new CoreException(
                new Status(
                        IStatus.ERROR,
                        ModelerPlugin.getId(),
                        IStatus.ERROR,
                        "The diagram ID of the diagram file is not registered among the available extensions",
                        null));
    }

    /**
     * Find a descriptor in the registry.
     * 
     * @param id the searched diagram id
     * @return the diagram or <code>null</code> if not found
     */
    public DiagramDescriptor find(String id)
    {
        Iterator<DiagramDescriptor> itr = diagrams.iterator();
        while (itr.hasNext())
        {
            DiagramDescriptor desc = itr.next();
            if (id.equals(desc.getId()))
            {
                return desc;
            }
        }
        return null;
    }

    /**
     * Get an enumeration of diagram descriptors.
     * 
     * @return The registered diagrams
     */
    public DiagramDescriptor[] getDiagrams()
    {
        return (DiagramDescriptor[]) diagrams.toArray(new DiagramDescriptor[diagrams.size()]);
    }

    /**
     * Get an enumeration of diagram descriptors that can be associated with the
     * given model object
     * 
     * @param containerEObject the model object
     * @return The registered diagrams
     */
    public DiagramDescriptor[] getDiagrams(EObject containerEObject, String editorID)
    {
        List<DiagramDescriptor> result = new ArrayList<DiagramDescriptor>();

        Iterator<DiagramDescriptor> iter = diagrams.iterator();
        while (iter.hasNext())
        {
            DiagramDescriptor diagDesc = iter.next();
            if (diagDesc.canCreateDiagramOn(containerEObject, editorID))
            {
                result.add(diagDesc);
            }
        }
        return (DiagramDescriptor[]) result.toArray(new DiagramDescriptor[result.size()]);
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
                if (DiagramDescriptor.TAG_DIAGRAM.equals(confElt.getName()))
                {
                    DiagramDescriptor descriptor = new DiagramDescriptor(confElt);
                    diagrams.add(descriptor);
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
            if (DiagramDescriptor.TAG_DIAGRAM.equals(confElt.getName()))
            {
                String id = confElt.getAttribute(DiagramDescriptor.ATT_ID);
                DiagramDescriptor descriptor = find(id);
                diagrams.remove(descriptor);
            }
        }
    }

}
