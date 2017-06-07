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

package org.topcased.modeler.evaluator;

/**
 * This exception is thrown when the evaluator engine cannot execute the
 * evaluation constraint
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class EvaluatorException extends Exception
{

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 9139516654171648215L;

    /**
     * Constructor
     * 
     * @param message
     */
    public EvaluatorException(String message)
    {
        super(message);
    }

    /**
     * Constructor
     * 
     * @param cause
     */
    public EvaluatorException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Constructor
     * 
     * @param message
     * @param cause
     */
    public EvaluatorException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
