/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.graphconf.exceptions;

/**
 * Exception when the diagram.graphconf file is not found in the configuration of a diagram
 * 
 * Creation 1 août 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class MissingGraphConfFileException extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = -515138926205749952L;

    /**
     * 
     */
    public MissingGraphConfFileException()
    {
        super();
    }

    /**
     * @param message
     */
    public MissingGraphConfFileException(String message)
    {
        super(message);
    }

}
