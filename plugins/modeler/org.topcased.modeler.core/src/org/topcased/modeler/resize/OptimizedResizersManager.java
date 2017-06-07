/*******************************************************************************
 * Copyright (c) 2010 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Vincent Hemery (Atos Origin) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.resize;

import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.CommandStack;
import org.topcased.facilities.extensions.AbstractExtensionManager;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * This class manages extensions for the org.topcased.modeler.optimizedResize extension point. It can be called to
 * perform resize using all of the declared extensions.
 * 
 * @author vhemery
 */
public class OptimizedResizersManager extends AbstractExtensionManager
{
    /** The extension point id */
    private static final String EXTENSION_POINT_ID = "org.topcased.modeler.optimizedResize";

    /** The resizedPart attribute in extensions */
    private static final String ATT_PART = "resizedPart";

    /** The resizerClass attribute in extensions */
    private static final String ATT_RESIZER = "resizerClass";

    /** The singleton instance */
    private static OptimizedResizersManager instance = null;

    /** The list of resizers, sorted by the class of edit parts they resize */
    private Map<Class< ? extends GraphicalEditPart>, List<OptimizedResizer>> definedResizers;

    /**
     * Private constructor
     */
    private OptimizedResizersManager()
    {
        super(EXTENSION_POINT_ID);
        definedResizers = new HashMap<Class< ? extends GraphicalEditPart>, List<OptimizedResizer>>();
        readRegistry();
    }

    /**
     * Get the singleton instance
     * 
     * @return the only instance
     */
    public static OptimizedResizersManager getInstance()
    {
        if (instance == null)
        {
            // initialize singleton
            instance = new OptimizedResizersManager();
        }
        return instance;
    }

    /**
     * Get the command to resize the part to its optimized dimension, using all declared extensions.
     * 
     * @param part the part which may have to be resized
     * @param stack the compound command to complete with resize commands
     */
    public void resize(GraphicalEditPart part, CommandStack stack)
    {
        boolean hasBeenResized = false;
        /*
         * If several resizers exist for a same element, they shall apply one after the other. They shall apply min or
         * max values, so we won't worry whether one undoes the work of another. On the other hand, they must be
         * implemented in a way that they will not uselessly enlarge/reduce a figure.
         */
        for (Entry<Class< ? extends GraphicalEditPart>, List<OptimizedResizer>> entry : definedResizers.entrySet())
        {
            if (entry.getKey().isInstance(part))
            {
                for (OptimizedResizer resizer : entry.getValue())
                {
                    resizer.resize(part, stack);
                    hasBeenResized = true;
                }
            }
        }
        // validate new size by parents
        if (hasBeenResized)
        {
            if (part.getFigure().getParent() != null)
            {
                part.getFigure().getParent().validate();
            }
            else
            {
                part.getFigure().validate();
            }
        }
    }

    /**
     * Add the resizers defined by this extension
     * 
     * @param extension extension defining optimized resizers
     * @see org.topcased.facilities.extensions.AbstractExtensionManager#addExtension(org.eclipse.core.runtime.IExtension)
     */
    protected void addExtension(IExtension extension)
    {
        IConfigurationElement[] elements = extension.getConfigurationElements();
        for (IConfigurationElement confElt : elements)
        {
            try
            {
                Object resizer = confElt.createExecutableExtension(ATT_RESIZER);
                if (resizer instanceof OptimizedResizer)
                {
                    String partClassName = confElt.getAttribute(ATT_PART);
                    Class< ? > partClass = resizer.getClass().getClassLoader().loadClass(partClassName);
                    if (GraphicalEditPart.class.isAssignableFrom(partClass))
                    {
                        if (!definedResizers.containsKey(partClass))
                        {
                            definedResizers.put((Class< ? extends GraphicalEditPart>) partClass, new LinkedList<OptimizedResizer>());
                        }
                        definedResizers.get(partClass).add((OptimizedResizer) resizer);
                    }
                }
            }
            catch (ClassNotFoundException e)
            {
                // edit part class does not exist
                ModelerPlugin.log(e);
            }
            catch (CoreException e1)
            {
                // resizer class does not exist
                ModelerPlugin.log(e1);
            }
        }
    }

    /**
     * Remove the resizers defined by this extension
     * 
     * @param extension extension defining optimized resizers
     * @see org.topcased.facilities.extensions.AbstractExtensionManager#removeExtension(org.eclipse.core.runtime.IExtension)
     */
    protected void removeExtension(IExtension extension)
    {
        IConfigurationElement[] elements = extension.getConfigurationElements();
        for (IConfigurationElement confElt : elements)
        {
            String partClassName = confElt.getAttribute(ATT_PART);
            Class< ? > partClass;
            try
            {
                partClass = URLClassLoader.getSystemClassLoader().loadClass(partClassName);
                if (GraphicalEditPart.class.isAssignableFrom(partClass))
                {
                    List<OptimizedResizer> listOfResizers = definedResizers.get(partClass);
                    String resizerClassName = confElt.getAttribute(ATT_RESIZER);
                    for (OptimizedResizer resizer : listOfResizers)
                    {
                        if (resizer.getClass().getName().equals(resizerClassName))
                        {
                            listOfResizers.remove(resizer);
                            if (listOfResizers.isEmpty())
                            {
                                definedResizers.remove(partClassName);
                            }
                            return;
                        }
                    }
                }
            }
            catch (ClassNotFoundException e)
            {
                // edit part class does not exist
                ModelerPlugin.log(e);
            }
        }
    }
}
