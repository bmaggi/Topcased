/*******************************************************************************
 * Copyright (c) 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.internal.collaboration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.topcased.modeler.internal.ModelProperties;

/**
 * Utility class to deal with exported models and resources.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public class ExportUtil
{
    /**
     * The suffix appended to file extensions to distinguish diagrams resources.
     */
    private static final String DIAGRAMS_SUFFIX = "di";

    /**
     * The extension used for the exported model and diagram resources.
     */
    public static final String PART_EXTENSION = "part";

    /**
     * The extension used for the cached copies of the elements exported models and diagrams depend on.
     */
    public static final String CACHE_EXTENSION = "cache";

    public static boolean isCacheUri(URI uri)
    {
        return CACHE_EXTENSION.equals(uri.trimFileExtension().fileExtension());
    }

    /**
     * Returns the default URI for the exported version of a controlled (sub-)model.
     * 
     * @param controlledResource the controlled resource which is being exported.
     * @return a default URI for the exported version if the resource.
     */
    static URI getExportedModelURI(Resource controlledResource)
    {
        URI controlledUri = controlledResource.getURI();
        return getExportedModelURI(controlledUri);
    }

    /**
     * Returns the default URI for the exported version of a controlled (sub-)model.
     * 
     * @param controlledUri the URI of the controlled resource which is being exported.
     * @return a default URI for the exported version if the resource.
     */
    static URI getExportedModelURI(URI controlledUri)
    {
        String ext = controlledUri.fileExtension();
        return controlledUri.trimFileExtension().appendFileExtension(PART_EXTENSION).appendFileExtension(ext);
    }

    /**
     * Returns the URI of the exported diagrams resource given the URI of the model part.
     * 
     * @param exportedModelUri the URI of the exported model resource.
     * @return the URI of the corresponding exported diagrams resource.
     */
    static URI getExportedDiagramsURI(URI exportedModelUri)
    {
        String ext = exportedModelUri.fileExtension();
        return exportedModelUri.trimFileExtension().appendFileExtension(ext + DIAGRAMS_SUFFIX);
    }

    /**
     * Returns the URI of the cache resource given the URI of the model part.
     * 
     * @param exportedModelUri the URI of the exported model resource.
     * @return the URI of the corresponding cache resource.
     */
    static URI getCacheURI(URI exportedModelUri)
    {
        String ext = exportedModelUri.fileExtension();
        return exportedModelUri.trimFileExtension().trimFileExtension().appendFileExtension(CACHE_EXTENSION).appendFileExtension(ext);
    }

    static final Collection<String> SYSTEM_URI_SCHEMES = Arrays.asList("pathmap", "http");

    /**
     * Tests whether a URI corresponds to a "system" resource, which are ignored when computing dependencies of a model
     * to export. System resources include resources which are provided by plugins and the ones using one of
     * {@link #SYSTEM_URI_SCHEMES}.
     */
    static boolean isSystemURI(URI uri)
    {
        return uri != null && (uri.isPlatformPlugin() || SYSTEM_URI_SCHEMES.contains(uri.scheme()));
    }

    /**
     * Tests whether a resource is a "system" resource (those are ignored when computing dependencies of a model to
     * export).
     * 
     * @see #isSystemURI(URI)
     */
    static boolean isSystemResource(Resource res)
    {
        return res != null && isSystemURI(res.getURI());
    }

    private static final DateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public static Date getExportedDate(Resource res)
    {
        ModelProperties mp = new ModelProperties(res);
        String timeStamp = mp.getProperty("export.timestamp");
        if (timeStamp == null)
        {
            return null;
        }
        else
        {
            try
            {
                return TIMESTAMP_FORMAT.parse(timeStamp);
            }
            catch (ParseException e)
            {
                return null;
            }
        }
    }

    public static void setExportedDate(Resource res, Date date)
    {
        ModelProperties mp = new ModelProperties(res);
        String timeStamp = (date != null) ? TIMESTAMP_FORMAT.format(date) : null;
        mp.setProperty("export.timestamp", timeStamp);
    }

    public static void removeExportedDate(Resource res)
    {
        setExportedDate(res, null);
    }

    public static boolean wasModifiedSinceExported(Resource modelRes, Resource diagramsRes)
    {
        Date exportDate = ExportUtil.getExportedDate(modelRes);
        if (exportDate == null)
        {
            return false;
        }
        long modificationTime = getModifiedTime(modelRes);
        if (modificationTime > exportDate.getTime())
        {
            return true;
        }
        if (diagramsRes != null)
        {
            modificationTime = getModifiedTime(diagramsRes);
            return modificationTime > exportDate.getTime();
        }
        else
        {
            return false;
        }
    }

    public static boolean isExported(Resource res)
    {
        return res != null && getExportedDate(res) != null;
    }

    private static long getModifiedTime(Resource res)
    {
        IPath path = new Path(res.getURI().toPlatformString(true));
        IFile modelFile = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
        long modifiedTime = modelFile.getLocalTimeStamp();
        return modifiedTime;
    }
}
