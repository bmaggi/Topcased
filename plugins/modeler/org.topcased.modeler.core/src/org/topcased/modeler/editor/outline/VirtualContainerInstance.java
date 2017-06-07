/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.editor.outline;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;

/**
 * This class encapsulates a virtual container and delegates the services to the saved container
 * @author Tristan FAURE
 *
 */
public class VirtualContainerInstance
{
    /** The eobject used to compute the virtual container */
    private EObject container;
    /** the virtual container for delegation */
    private final VirtualContainer virtualContainer;

    /** 
     * Returns the container
     */
    public EObject getContainer ()
    {
        return container ;
    }
    
    /** 
     * Create an instance where virtual container services will be computed with parent eobject
     */
    public VirtualContainerInstance (VirtualContainer virtualContainer, EObject parent)
    {
        this.virtualContainer = virtualContainer;
        this.container = parent;
    }
    
    /** 
     * Returns the children of the container of this instance
     */
    public Collection<EObject> getChildren()
    {
        Collection<EObject> children = virtualContainer.getChildren(container);
        if (children == null)
        {
            children = Collections.EMPTY_LIST ;
        }
        return children;
    }
    
    /** 
     * Returns the label of the virtual container
     */
    public String getLabel()
    {
        return virtualContainer.getLabel(container);
    }
    
    /** 
     * Returns the image of the virtual container
     */
    public Image getImage()
    {
        return virtualContainer.getIcon(container);
    }
    
}
