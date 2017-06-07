/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.generator.internal.generators;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.topcased.generator.AbstractGenerator;
import org.topcased.generator.jet.DefaultJETEmitter;
import org.topcased.modeler.editorconfigurator.EditorConfiguration;
import org.topcased.modeler.generator.internal.GeneratorPlugin;

/**
 * Generate a plugin for the ReadOnly service <br>
 * creation : 04 July 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ServiceReadOnlyGenerator extends AbstractGenerator
{
    /*
     * Fields
     */
    private EditorConfiguration configuration;

    /**
     * Constructor
     * 
     * @param conf The editor configuration to generate
     */
    public ServiceReadOnlyGenerator(EditorConfiguration conf)
    {
        configuration = conf;
    }

    /**
     * Launch the generation for the current editor configuration
     * 
     * @param monitor the monitor for the work progression
     * @return the IProject
     * 
     * @throws CoreException if the generation fails
     */
    public IProject generate(IProgressMonitor monitor) throws CoreException
    {
        monitor.subTask("Project creation");
        IProject project = createEMFProject(configuration.getProjectName() + "servicereadonly");
        monitor.worked(1);

        monitor.subTask("Package creation");
        IPath pathProject = project.getFullPath();
        generateStaticPackages(project, pathProject);
        monitor.worked(1);

        generateEditor(configuration, pathProject, monitor);

        return project;
    }

    /**
     * @see org.topcased.generator.AbstractGenerator#createJETEmitter(java.lang.String)
     */
    protected JETEmitter createJETEmitter(String templateURI)
    {
        return new DefaultJETEmitter(templateURI)
        {
            public void initialize(IProgressMonitor progressMonitor) throws JETException
            {
                // The configurator plugin must be released to activate the
                // generation.
                addVariable("EDITOR_CONF", "org.topcased.modeler.configurator");
                super.initialize(progressMonitor);
            }
        };
    }

    /**
     * Creates the required packages on the project
     * 
     * @param project the project where generates
     * @param pathProject the path for the given project
     * @throws CoreException if the generation failed
     */
    private void generateStaticPackages(IProject project, IPath pathProject) throws CoreException
    {
        String projectName = project.getName();
        IPath packagePath = new Path(projectName.replace('.', IPath.SEPARATOR));

        for (int i = 1; i < packagePath.segmentCount() + 1; i++)
        {
            IPath pathPackage = pathProject.append(IPath.SEPARATOR + "src" + IPath.SEPARATOR + packagePath.removeLastSegments(packagePath.segmentCount() - i));
            IFolder packagefolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(pathPackage);
            if (!(packagefolder.exists()))
            {
                packagefolder.create(true, false, new NullProgressMonitor());
            }
        }

        String[] packagesUtils = {"actions", "editor", "services"};
        for (int i = 0; i < packagesUtils.length; i++)
        {
            IPath pathPackage = pathProject.append(IPath.SEPARATOR + "src" + IPath.SEPARATOR + packagePath + IPath.SEPARATOR + packagesUtils[i]);
            IFolder packagefolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(pathPackage);
            if (!(packagefolder.exists()))
            {
                packagefolder.create(true, false, new NullProgressMonitor());
            }
        }

        // create the icons folder
        IPath pathIcons = pathProject.append(IPath.SEPARATOR + "icons");
        IFolder iconsFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(pathIcons);
        if (!(iconsFolder.exists()))
        {
            iconsFolder.create(true, false, new NullProgressMonitor());
        }

        // create the META-INF folder
        IPath pathMetaInf = pathProject.append(IPath.SEPARATOR + "META-INF");
        IFolder metaInfFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(pathMetaInf);
        if (!(metaInfFolder.exists()))
        {
            metaInfFolder.create(true, false, new NullProgressMonitor());
        }
    }

    private void generateEditor(EditorConfiguration conf, IPath projectPath, IProgressMonitor monitor)
    {
        try
        {
            monitor.subTask("Files creation");

            generateServicePluginClass(conf, projectPath);
            monitor.worked(1);

            generateServiceEditorActionBarContributorClass(conf, projectPath);
            monitor.worked(1);

            generateServiceEditorClass(conf, projectPath);
            monitor.worked(1);

            generateEditClass(conf, projectPath);
            monitor.worked(1);

            generatePluginXML(conf, projectPath);
            monitor.worked(1);

            generateManifestMF(conf, projectPath);
            monitor.worked(1);

            generateBuildProperties(conf, projectPath);
            monitor.worked(1);
        }
        catch (JETException e)
        {
            GeneratorPlugin.log(e);
            GeneratorPlugin.displayDialog(null, "JETException : an error occured during editor generation. See error logs for more details.", IStatus.ERROR);
        }
        catch (CoreException e)
        {
            GeneratorPlugin.log(e);
            GeneratorPlugin.displayDialog(null, "CoreException : an error occured during editor generation. See error logs for more details.", IStatus.ERROR);
        }
    }

    private String getTemplateURI(String relativePath)
    {
        return getTemplateURI(GeneratorPlugin.getDefault().getBundle(), relativePath);
    }

    // ----------------------------------------
    // Generations that are common to the editor
    // ----------------------------------------
    private void generateServicePluginClass(EditorConfiguration conf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(conf, getTemplateURI("templateServiceReadOnly/Plugin.javajet"), projectPath.append("/" + SOURCE_DIRECTORY + "/" + conf.getProjectName().replace('.', '/') + "servicereadonly/"
                + conf.getPrefix() + "ServicePlugin.java"), conf.isForceOverwrite());
    }

    private void generateServiceEditorActionBarContributorClass(EditorConfiguration conf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(conf, getTemplateURI("templateServiceReadOnly/EditorActionBarContributor.javajet"), projectPath.append("/src/" + conf.getProjectName().replace('.', '/')
                + "servicereadonly/actions/" + conf.getPrefix() + "ServiceEditorActionBarContributor.java"), conf.isForceOverwrite());
    }

    private void generateServiceEditorClass(EditorConfiguration conf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(conf, getTemplateURI("templateServiceReadOnly/Editor.javajet"), projectPath.append("/" + SOURCE_DIRECTORY + "/" + conf.getProjectName().replace('.', '/')
                + "servicereadonly/editor/" + conf.getPrefix() + "ServiceEditor.java"), conf.isForceOverwrite());
    }

    private void generateEditClass(EditorConfiguration conf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(conf, getTemplateURI("templateServiceReadOnly/Edit.javajet"), projectPath.append("/" + SOURCE_DIRECTORY + "/" + conf.getProjectName().replace('.', '/')
                + "servicereadonly/services/" + conf.getPrefix() + "Edit.java"), conf.isForceOverwrite());
    }

    private void generatePluginXML(EditorConfiguration conf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(conf, getTemplateURI("templateServiceReadOnly/plugin.xmljet"), projectPath.append("/plugin.xml"), conf.isForceOverwrite());
    }

    private void generateManifestMF(EditorConfiguration conf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(conf, getTemplateURI("templateServiceReadOnly/MANIFEST.MFjet"), projectPath.append("/META-INF/MANIFEST.MF"), conf.isForceOverwrite());
    }

    private void generateBuildProperties(EditorConfiguration conf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(conf, getTemplateURI("templateServiceReadOnly/build.propertiesjet"), projectPath.append("/build.properties"), conf.isForceOverwrite());
    }

}
