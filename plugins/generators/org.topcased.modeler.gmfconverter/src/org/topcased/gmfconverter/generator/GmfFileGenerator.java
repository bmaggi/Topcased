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

package org.topcased.gmfconverter.generator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.topcased.gmfconverter.internal.Activator;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;

/**
 * An abstract implementation to create an output GMF configuration file from an input Topcased configuration file.
 */
public abstract class GmfFileGenerator
{

    private IFile configurationFile = null;

    private DiagramConfiguration diagramConfiguration = null;

    /**
     * Constructor
     * 
     * @param configurationFile the output GMF configuration IFile 
     * @param diagramConfiguration the input Topcased configurator
     */
    public GmfFileGenerator(IFile configurationFile, DiagramConfiguration diagramConfiguration)
    {
        this.configurationFile = configurationFile;
        this.diagramConfiguration = diagramConfiguration;

    }

    /**
     * Generate the new GMF file
     */
    public void generateGmfFile()
    {
        try
        {
            // create new gmf files and add the created model into
            IFile createdFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
                    new Path(configurationFile.getParent().getFullPath().toString() + File.separator + diagramConfiguration.getPrefix() + '.' + getGmfFileExtension()));
            ResourceSet rsrcSet = new ResourceSetImpl();
            URI uri = URI.createPlatformResourceURI(createdFile.getFullPath().toString(), false);
            Resource newResource = rsrcSet.createResource(uri);
            newResource.getContents().add(generateGmfModel());

            // Save the resource contents to the file system.
            Map<String, String> options = new HashMap<String, String>();
            options.put(XMLResource.OPTION_ENCODING, "UTF-8");
            newResource.save(options);
        }
        catch (IOException ioe)
        {
            Activator.log("The GMF file " + getGmfFileExtension() + " could not be saved.", IStatus.ERROR);
            Activator.log(ioe);
        }
        catch (GeneratorException ge)
        {
            Activator.log("An error occured during generation", IStatus.ERROR);
            Activator.log(ge);
        }

    }

    /**
     * Get the diagramConfiguation
     * @return DiagramConfiguration
     */
    public DiagramConfiguration getDiagramConfiguration()
    {
        return diagramConfiguration;
    }

    /**
     * Return the root element of the newly created GMF configuration model
     * 
     * @return EObject the root Element of the newly created GMF configuration model
     * @throws GeneratorException 
     */
    protected abstract EObject generateGmfModel() throws GeneratorException;

    /**
     * Return the file extension of the GMF file to create
     * 
     * @return String the gmfFile extension
     */
    protected abstract String getGmfFileExtension();

}
