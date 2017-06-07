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

package org.topcased.modeler.internal.exceptions;

/**
 * This exception is thrown when the model is not valid (cannot be read)
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class IntegrityException extends Exception
{

    /**
     * Serial
     */
    private static final long serialVersionUID = 6009046741003222595L;

    /**
     * Constructor
     * @param message
     */
    public IntegrityException(String message)
    {
        super(message);
    }

    /**
     * Constructor
     * @param cause
     */
    public IntegrityException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Constructor
     * @param message
     * @param cause
     */
    public IntegrityException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
