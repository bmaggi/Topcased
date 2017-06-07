/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.exceptions;

/**
 * Exception when the bounds values format is not OK
 * 
 * @author jako
 */

public class BoundsFormatException extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = -3154298870678956315L;

    /**
     * The Constructor
     */
    public BoundsFormatException()
    {
        super();
    }

    /**
     * The Constructor with a String
     * 
     * @param s the message to display
     */
    public BoundsFormatException(String s)
    {
        super(s);
    }
}
