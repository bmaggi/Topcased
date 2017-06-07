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
package org.topcased.modeler.internal;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Allows to associate simple string properties to a model in a persistent way but without modifying the model files
 * themselves.
 * <p>
 * The properties are stored in a standard Java "properties" file, named like the model it applies to and stored along
 * with it. The mechanism provided by this class should only be used to store informations which are not semantically
 * part of the models themselves and which are not specific to a user or editing session (as the file will be stored in
 * configuration and shared by other users).
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public class ModelProperties
{
    /**
     * The extension to use for the file storing the properties.
     */
    private static final String EXTENSION = "properties";

    /**
     * The resource containing the model to which the properties apply.
     */
    private final Resource modelResource;

    public ModelProperties(Resource modelResource)
    {
        this.modelResource = modelResource;
    }

    public void setProperty(String propertyName, String propertyValue)
    {
        try
        {
            Properties props = loadProperties(propertyValue != null);
            if (props != null)
            {
                if (propertyValue != null)
                {
                    props.setProperty(propertyName, propertyValue);
                }
                else
                {
                    props.remove(propertyName);
                }
                saveProperties(props);
            }
        }
        catch (CoreException e)
        {
            ModelerPlugin.log(e);
        }
        catch (IOException e)
        {
            ModelerPlugin.log(e);
        }
    }

    public String getProperty(String propertyName)
    {
        Properties props;
        try
        {
            props = loadProperties(false);
        }
        catch (CoreException e)
        {
            ModelerPlugin.log(e);
            return null;
        }
        catch (IOException e)
        {
            ModelerPlugin.log(e);
            return null;
        }
        return (props == null) ? null : props.getProperty(propertyName);
    }

    private IFile getWorkspaceFile()
    {
        URI propsFileUri = modelResource.getURI().trimFileExtension().appendFileExtension(EXTENSION);
        String pathString = propsFileUri.toPlatformString(true);
        if (pathString != null)
        {
            IPath path = new Path(pathString);
            return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
        }
        else
        {
            return null;
        }
    }

    private Properties loadProperties(boolean createIfMissing) throws CoreException, IOException
    {
        IFile file = getWorkspaceFile();
        if (file == null)
        {
            return null;
        }
        if (!file.exists())
        {
            if (createIfMissing)
            {
                file.create(new ByteArrayInputStream(new byte[0]), true, null);
            }
            else
            {
                return null;
            }
        }
        Properties props = new Properties();
        InputStream contents = file.getContents();
        try
        {
            props.load(contents);
        }
        finally
        {
            contents.close();
        }
        return props;
    }

    private void saveProperties(Properties props) throws CoreException, IOException
    {
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        props.store(data, null);
        IFile file = getWorkspaceFile();
        if (file == null)
        {
            return;
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(data.toByteArray());
        file.setContents(bais, 0, null);
    }
}
