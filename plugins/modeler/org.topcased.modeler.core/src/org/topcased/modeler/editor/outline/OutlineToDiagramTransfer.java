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
 *    Thibault Landré (Atos Origin) - Fix #772
 *******************************************************************************/
package org.topcased.modeler.editor.outline;

import org.eclipse.emf.edit.ui.dnd.LocalTransfer;

/**
 * This Transfer expects a java.util.List as the object being transferred.
 * 
 * <br>
 * creation : 7 dec. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public final class OutlineToDiagramTransfer extends LocalTransfer
{

    /** <code>TYPE_NAME</code>: key used to mark the type of transfer. */
    public static final String TYPE_NAME = "Outline To Diagram Transfer"; //$NON-NLS-1$

    /** The transfer. */
    private static OutlineToDiagramTransfer transfer = null;

    /** The Constant TYPE_ID. */
    private static final int TYPE_ID = registerType(TYPE_NAME);
    

    /**
     * Instantiates a new outline to diagram transfer.
     */
    private OutlineToDiagramTransfer()
    {
        // Do nothing
    }

    /**
     * Returns the shared instance.
     * 
     * @return the singleton
     */
    public static OutlineToDiagramTransfer getInstance()
    {
        if (transfer == null)
        {
            transfer = new OutlineToDiagramTransfer();
        }

        return transfer;
    }

    /* (non-Javadoc)
     * @see org.eclipse.emf.edit.ui.dnd.LocalTransfer#getTypeIds()
     */
    protected int[] getTypeIds()
    {
        return new int[] {TYPE_ID};
    }
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.ui.dnd.LocalTransfer#getTypeNames()
	 */
	public String[] getTypeNames()
    {
        return new String[] {TYPE_NAME};
    }

    /**
     * Gets the object.
     * 
     * @return the object
     */
    public Object getObject()
    {
        return object;
    }

    /**
     * Sets the object.
     * 
     * @param object the new object
     */
    public void setObject(Object object)
    {
        this.object = object;
    }
}
