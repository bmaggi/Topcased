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

package org.topcased.modeler.internal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.topcased.facilities.util.TopcasedSynchronizerUtil;
import org.topcased.modeler.internal.exceptions.IntegrityException;
import org.topcased.modeler.utils.ResourceUtils;
import org.topcased.validation.core.MarkerUtil;

/**
 * This class checks the integrity of a model file.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public final class IntegrityChecker
{
    /**
     * Constructor
     */
    private IntegrityChecker()
    {
        // Do nothing
    }

    /**
     * Check the integrity of the model stored in the given file.<br>
     * This method tries to save the different models in temporary files and to read them back. If one of these steps
     * fails, the method return <code>false</code>
     * 
     * @param file the main file, the one containing the model
     * @param rSet the resource set containing the different models
     * @param monitor a Progress Monitor
     * @throws IOException temporary files cannot be written
     * @throws IntegrityException Thrown if the integrity is not verified
     */
    public static void checkModelIntegrity(IFile file, ResourceSet rSet, IProgressMonitor monitor) throws IOException, IntegrityException
    {
        try
        {
            // we take a token to be the only one to be executed
            TopcasedSynchronizerUtil.eINSTANCE.blockOrTakeAToken(MarkerUtil.CONSTANT_FOR_SYNCHRONIZATION);
            monitor.beginTask("Integrity check", 4);
            boolean integrityOK = true;
            URI mainFileURI = URI.createPlatformResourceURI(file.getFullPath().toString());
            List temporaryFiles = new ArrayList();
            Map originalURIs = new HashMap();
            Map options = new HashMap();
            options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);

            // Update resources uri to a temporary uri
            for (Iterator iter = rSet.getResources().iterator(); iter.hasNext();)
            {
                int index = 0;
                Resource resource = (Resource) iter.next();
                if (!ResourceUtils.isReadOnly(resource))
                {
                    URI uri = resource.getURI();
                    originalURIs.put(resource, uri);

                    File tempFile = File.createTempFile("Temp", uri.fileExtension());
                    URI newURI = URI.createFileURI(tempFile.getAbsolutePath());
                    resource.setURI(newURI);
                    temporaryFiles.add(tempFile);
                }
            }
            monitor.worked(1);

            // Save temporary resources
            try
            {
                for (Iterator iter = rSet.getResources().iterator(); iter.hasNext();)
                {
                    Resource resource = (Resource) iter.next();
                    if (!ResourceUtils.isReadOnly(resource))
                    {
                        resource.save(options);
                    }
                }

                // Check if saved files are ok
                if (null == openURI(mainFileURI, new ResourceSetImpl()))
                {
                    integrityOK = false;
                }
            }
            catch (IOException ioe)
            {
                integrityOK = false;
            }
            monitor.worked(1);

            // Restore resources uri with real uri
            for (Iterator iter = rSet.getResources().iterator(); iter.hasNext();)
            {
                Resource resource = (Resource) iter.next();
                if (!ResourceUtils.isReadOnly(resource))
                {
                    URI uri = (URI) originalURIs.get(resource);
                    if (uri != null)
                    {
                        resource.setURI(uri);
                    }
                }
            }
            monitor.worked(1);

            // Remove temp files
            for (Iterator iter = temporaryFiles.iterator(); iter.hasNext();)
            {
                File tempFile = (File) iter.next();
                if (tempFile != null && tempFile.exists())
                {
                    tempFile.delete();
                }
            }
            monitor.worked(1);

            monitor.done();
            if (!integrityOK)
            {
                throw new IntegrityException("The model is not valid");
            }
        }
        finally
        {
            // in any case we release the token to not block other process
            TopcasedSynchronizerUtil.eINSTANCE.releaseToken(MarkerUtil.CONSTANT_FOR_SYNCHRONIZATION);
        }
    }

    /**
     * Open a URI which contains a model
     * 
     * @param uri the file uri
     * @param rSet the resourceSet where the model is stored
     * @return the main EObject
     */
    private static EObject openURI(URI uri, ResourceSet rSet)
    {
        Resource resource = rSet.getResource(uri, true);
        return (EObject) resource.getContents().get(0);
    }
}
