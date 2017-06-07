/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Thomas Friol (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.outline.generator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.common.util.Monitor;
import org.topcased.generator.AbstractGenerator;
import org.topcased.generator.jet.DefaultJETEmitter;
import org.topcased.outline.configurator.CreateChildMenuConfiguration;
import org.topcased.outline.configurator.OutlineConfiguration;
import org.topcased.outline.generator.internal.GeneratorPlugin;

/**
 * The outline generator. <br>
 * Creation : 3 nov. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class OutlineGenerator extends AbstractGenerator
{
    /** The outline configuration */
    private OutlineConfiguration config;

    /**
     * Constructor.
     * 
     * @param configuration the outline configuration to generate the outline
     */
    public OutlineGenerator(OutlineConfiguration configuration)
    {
        config = configuration;
    }

    /**
     * @see org.topcased.generator.AbstractGenerator#createJETEmitter(java.lang.String)
     */
    protected JETEmitter createJETEmitter(String templateURI)
    {
        return new DefaultJETEmitter(templateURI)
        {
            /**
             * @see org.topcased.generator.jet.DefaultJETEmitter#initialize(org.eclipse.emf.common.util.Monitor)
             */
            public void initialize(Monitor monitor) throws JETException
            {
                addVariable("OUTLINE_CONF", "org.topcased.outline.configurator");
                super.initialize(monitor);
            }
        };
    }

    /**
     * Launch the generation for the current outline configuration
     * 
     * @see org.topcased.generator.AbstractGenerator#generate(org.eclipse.core.runtime.IProgressMonitor)
     */
    public IProject generate(IProgressMonitor monitor) throws CoreException
    {
        monitor.subTask("Project creation");
        IProject project = createEMFProject(config.getProjectName());
        monitor.worked(1);

        try
        {
            monitor.subTask("Plugin configuration");
            if (config.getPluginClassName() != null && config.getPluginClassName().length() != 0)
            {
                monitor.subTask("Plugin configuration");
                createPackage(config.getPackage(), project);
                generatePluginXML(project);
                generatePluginClass(project);
                monitor.worked(1);
            }

            monitor.subTask("Outline generation");
            generateOutline(project);
            monitor.worked(1);
        }
        catch (JETException e)
        {
            GeneratorPlugin.log(e);
            GeneratorPlugin.displayDialog(null, "JETException : an error occured during outline generation. See error logs for more details.", IStatus.ERROR);
        }

        return project;
    }

    /**
     * Returns a template URI for the given path relative to this generator bundle.
     * 
     * @param relativePath
     * @return a string URI
     */
    protected String getTemplateURI(String relativePath)
    {
        return getTemplateURI(GeneratorPlugin.getDefault().getBundle(), relativePath);
    }

    /**
     * Generates the outline using the current {@link OutlineConfiguration} into the given {@link IProject}.
     * 
     * @param project the project where generates
     * @throws JETException
     * @throws CoreException
     */
    private void generateOutline(IProject project) throws JETException, CoreException
    {
        generateCreateChildMenu(project);
    }

    /**
     * Generates the 'Create child' menu
     * 
     * @param project the project where generates
     * @throws JETException
     * @throws CoreException
     */
    private void generateCreateChildMenu(IProject project) throws JETException, CoreException
    {
        CreateChildMenuConfiguration createChild = config.getCreateChild();
        if (createChild != null)
        {
            createPackage(createChild.getMenuPackageName(), project);
            createPackage(config.getUtilitiesPackageName(), project);

            applyTemplate(config, getTemplateURI("templateOutline/CreateChildMenu.javajet"), project.getFullPath().append(
                    IPath.SEPARATOR + SOURCE_DIRECTORY + IPath.SEPARATOR + createChild.getMenuPackageName().replace('.', IPath.SEPARATOR) + IPath.SEPARATOR + createChild.getClassName() + ".java"),
                    false);

            applyTemplate(config, getTemplateURI("templateOutline/ExactSwitch.javajet"), project.getFullPath().append(
                    IPath.SEPARATOR + SOURCE_DIRECTORY + IPath.SEPARATOR + config.getUtilitiesPackageName().replace('.', IPath.SEPARATOR) + IPath.SEPARATOR + "Exact"
                            + config.getGenPackage().getSwitchClassName() + ".java"), false);
        }
    }

    /**
     * Generates the 'plugin.xml' file.
     * 
     * @param project the project where generates
     * @throws JETException
     * @throws CoreException
     */
    private void generatePluginXML(IProject project) throws JETException, CoreException
    {
        applyTemplate(config, getTemplateURI("templateOutline/Plugin.javajet"), project.getFullPath().append(
                IPath.SEPARATOR + SOURCE_DIRECTORY + IPath.SEPARATOR + config.getProjectName().replace('.', IPath.SEPARATOR) + IPath.SEPARATOR + config.getPluginClassName() + ".java"), false);
    }

    /**
     * Generates the plugin class.
     * 
     * @param project the project where generates
     * @throws JETException
     * @throws CoreException
     */
    private void generatePluginClass(IProject project) throws JETException, CoreException
    {
        createPackage(config.getProjectName(), project);
        applyTemplate(config, getTemplateURI("templateOutline/plugin.xmljet"), project.getFullPath().append("/plugin.xml"), false);
    }
}
