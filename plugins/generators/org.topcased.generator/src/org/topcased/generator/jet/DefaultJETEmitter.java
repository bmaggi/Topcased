/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Thomas Friol (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.generator.jet;

import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.common.util.Monitor;

/**
 * A class defining a default JET Emitter initialized with EMF classpath variables.<br>
 * Generators must override this emitter to use their own classloader. Creation : 9 nov. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class DefaultJETEmitter extends JETEmitter
{
    /**
     * Creates a default JET Emitter.
     * 
     * @param templateURI
     */
    public DefaultJETEmitter(String templateURI)
    {
        super(templateURI);
    }

    /**
     * @see org.eclipse.emf.codegen.jet.JETEmitter#initialize(org.eclipse.emf.common.util.Monitor)
     */
    public void initialize(Monitor monitor) throws JETException
    {
        addVariable("EMF_CODEGEN", "org.eclipse.emf.codegen");
        addVariable("EMF_CODEGEN_ECORE", "org.eclipse.emf.codegen.ecore");
        addVariable("EMF_COMMON", "org.eclipse.emf.common");
        addVariable("EMF_ECORE", "org.eclipse.emf.ecore");

        super.initialize(monitor);
    }

}
