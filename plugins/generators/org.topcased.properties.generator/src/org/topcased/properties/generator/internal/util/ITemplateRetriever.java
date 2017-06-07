/************************************************************************************
 * Copyright (c) 2006 ANYWARE TECHNOLOGIES. All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Eclipse Public License v1.0 which accompanies
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *      Jose Alfredo Serrano (Anyware Technologies) - initial API and implementation
 ************************************************************************************/
package org.topcased.properties.generator.internal.util;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;

/**
 * This type retrieve a string path of the template to use
 * 
 * @author alfredo
 * 
 */
public interface ITemplateRetriever
{
    /**
     * Returns a project relatif string path of the template to use for the given GenFeature
     * 
     * @param genFeature The gen Feature to generate a section
     * @return The project relatif string path of the template
     */
    String getTemplate(GenFeature genFeature);
}
