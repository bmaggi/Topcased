/*******************************************************************************
 * Copyright (c) 2009 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jose Alfredo Serrano (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.export.html.internal.generators;

import org.eclipse.core.resources.IContainer;

/**
 * This generator creates an html file with the documentation fragments edited within the DocView.
 * 
 * @author <a href="mailto:jose.alfredo.serrano@anyware-tech.com">Jose Alfredo SERRRANO</a>
 * 
 */
public class DiagramDocumentationFileGenerator extends AbstractFileGenerator
{

    /**
     * Creates a generator
     * 
     * @param outputContainer The selected Container Resource where all files will be generated
     */
    public DiagramDocumentationFileGenerator(IContainer outputContainer)
    {
        super("org::topcased::modeler::export::html::templates::DiagramDocumentationFile::file FOR diagram", outputContainer, "diagram");
    }
}
