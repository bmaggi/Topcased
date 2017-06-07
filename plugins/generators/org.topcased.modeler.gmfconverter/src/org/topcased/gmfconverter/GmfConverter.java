/***********************************************************************
 * Copyright (c) 2007, 2008 Topcased consortium
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas LAMBERT (Anyware Technologies) - initial API and implementation
 *    Jacques LESCOT (Anyware Technologies) - Code review
 **********************************************************************/

package org.topcased.gmfconverter;

import org.eclipse.core.resources.IFile;
import org.topcased.gmfconverter.generator.gmfgraph.GmfGraphFileGenerator;
import org.topcased.gmfconverter.generator.gmfmap.GmfMapFileGenerator;
import org.topcased.gmfconverter.generator.gmftool.GmfToolFileGenerator;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;

/**
 * @author Nicolas
 */
public class GmfConverter
{
    /**
     * Convert an input *.diagramconfigurator into GMF configuration files
     * 
     * @param file the input *.diagramconfigurator file 
     * @param diagramConfiguration the DiagramConfiguration element contained by the input IFile
     */
    public static void convert(IFile file, DiagramConfiguration diagramConfiguration)
    {

        // Generate .gmfgraph
        GmfGraphFileGenerator gmfGraphGenerator = new GmfGraphFileGenerator(file, diagramConfiguration);
        gmfGraphGenerator.generateGmfFile();

        // Generate .gmftool
        GmfToolFileGenerator gmfToolGenerator = new GmfToolFileGenerator(file, diagramConfiguration);
        gmfToolGenerator.generateGmfFile();

        // Generate .gmfmap
        GmfMapFileGenerator gmfMapGenerator = new GmfMapFileGenerator(file, diagramConfiguration);
        gmfMapGenerator.generateGmfFile();

        // Generate .gmfgen
        // GmfGenFileGenerator gmfGenGenerator = new GmfGenFileGenerator(file,
        // diagramConfiguration);
        // gmfGenGenerator.generateGmfFile();
    }

}
