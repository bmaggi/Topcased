/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jacques LESCOT (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.extensions;

import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.topcased.modeler.ImageRegistry;
import org.topcased.modeler.editor.IConfiguration;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * Class that describes a Diagram
 * 
 * @author <a href="mailto:jacqueslescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class DiagramDescriptor
{

    /** The diagram tag */
    public static final String TAG_DIAGRAM = "diagram";

    /** The id attribute */
    public static final String ATT_ID = "id";

    /** The name attribute */
    public static final String ATT_NAME = "name";

    /** The icon attribute */
    public static final String ATT_ICON = "icon";

    /** The editorID attribute */
    public static final String ATT_EDITOR_ID = "editorID";

    /** The configuration attribute */
    public static final String ATT_CONFIGURATION = "configuration";

    /** The enableFor tag */
    public static final String TAG_ENABLE_FOR = "enableFor";

    /** The class attribute */
    public static final String ATT_CLASS = "class";

    /** The creationCommand attribute */
    public static final String ATT_CREATION_COMMAND = "creationCommand";

    // Values
    private String id;

    private String name;
    
    private String editorID;

    private IConfigurationElement configElement;

    private URL iconURL;

    // Add a cache to the configuration
    private IConfiguration configuration;

    /**
     * Initialize the descriptor from the XML fragment of the extension
     * 
     * @param element The XML Fragment that describes the Diagram
     * @throws CoreException if the xml fragment is not valid
     */
    DiagramDescriptor(IConfigurationElement element) throws CoreException
    {
        super();
        configElement = element;

        load();
    }

    private void load() throws CoreException
    {
        id = configElement.getAttribute(ATT_ID);
        name = configElement.getAttribute(ATT_NAME);
        editorID = configElement.getAttribute(ATT_EDITOR_ID);
        String iconPath = configElement.getAttribute(ATT_ICON);
        String configurationClazz = configElement.getAttribute(ATT_CONFIGURATION);

        // Sanity check.
        if (id == null || name == null || configurationClazz == null)
        {
            throw new CoreException(new Status(IStatus.ERROR, configElement.getContributor().getName(), IStatus.OK,
                    "Invalid extension (missing id, label, configuration or diagramConfiguration name): " + id, null));
        }

        if (iconPath != null)
        {
            String bundleId = configElement.getContributor().getName();
            Bundle bundle = Platform.getBundle(bundleId);
            iconURL = FileLocator.find(bundle, new Path(iconPath), null);
        }

        IConfigurationElement[] desc = configElement.getChildren(TAG_ENABLE_FOR);
        for (int cpt = 0; cpt < desc.length; cpt++)
        {
            String clazz = desc[cpt].getAttribute(ATT_CLASS);
            // Sanity check.
            if (clazz == null)
            {
                throw new CoreException(new Status(IStatus.ERROR, configElement.getContributor().getName(), IStatus.OK, "Invalid extension (missing class name of an enableFor model object): " + id,
                        null));
            }
        }
    }

    /**
     * Get the configuration associated with this extension
     * 
     * @return the configuration or <code>null</code> if not found
     * @throws CoreException
     */
    public IConfiguration getConfiguration() throws CoreException
    {
        if (configuration == null)
        {
            Object config = configElement.createExecutableExtension(ATT_CONFIGURATION);
            if (!(config instanceof IConfiguration))
            {
                throw new CoreException(new Status(IStatus.ERROR, configElement.getContributor().getName(), IStatus.OK, "Invalid configuration name for extension : " + getId(), null));
            }
            configuration = (IConfiguration) config;
        }

        return configuration;
    }

    /**
     * Get the icon associated with this diagram
     * 
     * @return the image descriptor or <code>null</code> if not found
     */
    public ImageDescriptor getIconDescriptor()
    {
        ImageDescriptor iconDescriptor = null;

        if (iconURL != null)
        {
            iconDescriptor = ImageRegistry.getInstance().getDescriptor(iconURL);
        }

        return iconDescriptor;
    }

    /**
     * Get the icon associated with this diagram
     * 
     * @return the image or <code>null</code> if not found
     */
    public Image getIcon()
    {
        Image icon = null;

        if (iconURL != null)
        {
            icon = ImageRegistry.getInstance().get(iconURL);
        }

        return icon;
    }

    /**
     * This method is used to check if a Diagram may be created on this model object in the given editor
     * 
     * @param model the model object that should be associated with the diagram
     * @param theEditorID the editorID
     * @return true if the creation is enabled
     */
    public boolean canCreateDiagramOn(EObject model, String theEditorID)
    {
        if (editorID == null || theEditorID.equals(editorID))
        {
            IConfigurationElement[] desc = configElement.getChildren(TAG_ENABLE_FOR);
            for (int cpt = 0; cpt < desc.length; cpt++)
            {
                String clazzName = desc[cpt].getAttribute(ATT_CLASS);
                String bundleId = configElement.getDeclaringExtension().getContributor().getName();
                Bundle bundle = Platform.getBundle(bundleId);
                try
                {
                    if (bundle.loadClass(clazzName).isInstance(model))
                    {
                        return true;
                    }
                }
                catch (ClassNotFoundException e)
                {
                    ModelerPlugin.log(e);
                }
            }
        }

        return false;
    }

    /**
     * This method retrieve the creation command that may be associated with the current Diagram when the creation is
     * requested on a model object that will not be the real container of the diagram
     * 
     * @param model the model object on which the creation is requested
     * @return Command the command to execute for the diagram creation or null when the default behavior should be
     *         performed
     */
    public Command getCreationCommand(EObject model)
    {
        IConfigurationElement[] desc = configElement.getChildren(TAG_ENABLE_FOR);
        for (int cpt = 0; cpt < desc.length; cpt++)
        {
            String clazzName = desc[cpt].getAttribute(ATT_CLASS);
            String bundleId = configElement.getDeclaringExtension().getContributor().getName();
            Bundle bundle = Platform.getBundle(bundleId);
            try
            {
                if (bundle.loadClass(clazzName).isInstance(model) && desc[cpt].getAttribute(ATT_CREATION_COMMAND) != null)
                {
                    Object command;
                    command = desc[cpt].createExecutableExtension(ATT_CREATION_COMMAND);
                    if (!(command instanceof Command && command instanceof ICreationDiagram))
                    {
                        ModelerPlugin.log(new CoreException(new Status(IStatus.ERROR, configElement.getNamespaceIdentifier(), IStatus.OK,
                                "Invalid creation command class for extension : " + getName(), null)));
                    }

                    return (Command) command;
                }
            }
            catch (CoreException e)
            {
                ModelerPlugin.log("The creation command could not have been initialized", e);
            }
            catch (ClassNotFoundException e)
            {
                ModelerPlugin.log("The class attribute could not have been initialized", e);
            }
        }
        return null;
    }

    /**
     * Get the id of the diagram
     * 
     * @return String
     */
    public String getId()
    {
        return id;
    }

    /**
     * Get the name of the diagram (This will be the text displayed in the contextual menu)
     * 
     * @return String
     */
    public String getName()
    {
        return name;
    }
}
