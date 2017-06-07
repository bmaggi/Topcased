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

package org.topcased.gmfconverter.generator.gmfgen;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.topcased.gmfconverter.generator.GmfFileGenerator;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;

/**
 * @author Nicolas
 */
public class GmfGenFileGenerator extends GmfFileGenerator
{

    private final static String FILE_EXTENSION = "gmfgen";

    /**
     * Constructor
     * 
     * @param configurationFile the output GMF configuration IFile 
     * @param diagramConfiguration the input Topcased configurator
     */
    public GmfGenFileGenerator(IFile configurationFile, DiagramConfiguration diagramConfiguration)
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
    protected EObject generateGmfModel()
    {
        GenEditorGenerator genEditorGenerator = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
        return genEditorGenerator;
    }

}
