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

package org.topcased.gmfconverter.generator.gmfmap;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.mappings.Mapping;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.gmfconverter.generator.GmfFileGenerator;
import org.topcased.gmfconverter.generator.ObjectGenerator;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;

/**
 * @author Nicolas
 */
public class GmfMapFileGenerator extends GmfFileGenerator
{

    private final static String FILE_EXTENSION = "gmfmap";

    /**
     * Constructor
     * 
     * @param configurationFile 
     * @param diagramConfiguration
     */
    public GmfMapFileGenerator(IFile configurationFile, DiagramConfiguration diagramConfiguration)
    {
        super(configurationFile, diagramConfiguration);
    }

    /**
     * @see org.topcased.gmfconverter.generator.GmfFileGenerator#getGmfFileExtension()
     */
    protected String getGmfFileExtension()
    {
        return FILE_EXTENSION;
    }

    /**
     * @see org.topcased.gmfconverter.generator.GmfFileGenerator#generateGmfModel()
     */
    protected EObject generateGmfModel() throws GeneratorException
    {
        GenClass rootGenClass = getDiagramConfiguration().getTemplateRootObject();
        if (rootGenClass == null)
        {
            throw new GeneratorException("template root objetc must be set in DiagramConfigurator !");
        }
        MapRegistry.setRootEClass(rootGenClass.getEcoreClass());
        EObject gmfMapping = ObjectGenerator.getInstance(DiagramConfigurationMapGenerator.class).createGMFObject(getDiagramConfiguration(), Mapping.class);
        MapRegistry.resetMap();
        return gmfMapping;

    }

}
