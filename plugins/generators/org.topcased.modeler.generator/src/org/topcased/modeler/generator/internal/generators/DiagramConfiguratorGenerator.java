/*******************************************************************************
 * Copyright (c) 2006, 2008 TOPCASED consortium. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation, Thibault Landré (Atos Origin) - add preferences implementation
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
import org.eclipse.emf.common.util.Monitor;
import org.topcased.generator.AbstractGenerator;
import org.topcased.generator.jet.DefaultJETEmitter;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.EdgeObject;
import org.topcased.modeler.diagramconfigurator.EdgeObjectType;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
import org.topcased.modeler.diagramconfigurator.PartAction;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;
import org.topcased.modeler.generator.internal.GeneratorPlugin;

/**
 * This class is the Entry point of the generation for a Topcased diagram defined by a *.diagramconfigurator file<br>
 * 
 * Creation : 26 avril 2006
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class DiagramConfiguratorGenerator extends AbstractGenerator
{
    /** ******************** */
    /** JET Template files */
    /** ******************** */
    private static final String PLUGIN_JAVA = "templateDiagram/Plugin.javajet";

    private static final String IMAGE_REGISTRY_JAVA = "templateDiagram/ImageRegistry.javajet";

    private static final String EDIT_POLICY_CONSTANTS_JAVA = "templateDiagram/diagram/EditPolicyConstants.javajet";

    private static final String SIMPLE_OBJECT_CONSTANTS_JAVA = "templateDiagram/diagram/SimpleObjectConstants.javajet";

    private static final String EDGE_OBJECT_CONSTANTS_JAVA = "templateDiagram/diagram/EdgeObjectConstants.javajet";

    private static final String IMAGES_PROPERTIES = "templateDiagram/images.propertiesjet";

    private static final String BUILD_PROPERTIES = "templateDiagram/build.propertiesjet";

    private static final String PLUGIN_XML = "templateDiagram/plugin.xmljet";

    private static final String MANIFEST_MF = "templateDiagram/MANIFEST.MFjet";

    private static final String DIAGRAM_GRAPHCONF = "templateDiagram/diagram/diagram.graphconfjet";

    private static final String TEMPLATE_MODEL = "templateDiagram/template/name.modeljet";

    private static final String TEMPLATE_DIAGRAM = "templateDiagram/template/name.modeldijet";

    private static final String CONFIGURATION_JAVA = "templateDiagram/diagram/Configuration.javajet";

    private static final String EDITPART2MODEL_ADAPTERFACTORY_JAVA = "templateDiagram/diagram/EditPart2ModelAdapterFactory.javajet";

    private static final String CREATION_UTILS_JAVA = "templateDiagram/diagram/CreationUtils.javajet";

    private static final String EDITPART_FACTORY_JAVA = "templateDiagram/diagram/EditPartFactory.javajet";

    private static final String PALETTE_MANAGER_JAVA = "templateDiagram/diagram/PaletteManager.javajet";

    private static final String DIAGRAM_EDITPART_JAVA = "templateDiagram/diagram/edit/DiagramEditPart.javajet";

    private static final String NODE_EDITPART_JAVA = "templateDiagram/diagram/edit/NodeEditPart.javajet";

    private static final String EDGE_EDITPART_JAVA = "templateDiagram/diagram/edit/EdgeEditPart.javajet";

    private static final String EDGE_CREATION_EDITPOLICY_JAVA = "templateDiagram/diagram/policies/EdgeCreationEditPolicy.javajet";

    private static final String DIAGRAM_LAYOUT_EDITPOLICY_JAVA = "templateDiagram/diagram/policies/DiagramLayoutEditPolicy.javajet";

    private static final String NODE_LAYOUT_EDITPOLICY_JAVA = "templateDiagram/diagram/policies/NodeLayoutEditPolicy.javajet";

    private static final String EDGE_OBJECT_UV_EDITPOLICY_JAVA = "templateDiagram/diagram/policies/EdgeObjectUVEditPolicy.javajet";

    private static final String EDGE_CREATION_COMMAND_JAVA = "templateDiagram/diagram/commands/EdgeCreationCommand.javajet";

    private static final String RESTORE_CONNECTION_COMMAND_JAVA = "templateDiagram/diagram/commands/RestoreConnectionCommand.javajet";

    private static final String DIAGRAM_FIGURE_JAVA = "templateDiagram/diagram/figures/DiagramFigure.javajet";

    private static final String NODE_FIGURE_JAVA = "templateDiagram/diagram/figures/NodeFigure.javajet";

    private static final String EDGE_FIGURE_JAVA = "templateDiagram/diagram/figures/EdgeFigure.javajet";

    /** Kermeta adding */
    private static final String PART_ACTION_JAVA = "templateDiagram/diagram/actions/DiagramPartAction.javajet";

    /** Kermeta adding */
    private static final String PART_ACTION_COMMAND_JAVA = "templateDiagram/diagram/commands/DiagramPartActionCommand.javajet";

    private static final String DIAGRAM_PREFERENCE_CONSTANTS_JAVA = "templateDiagram/diagram/preferences/DiagramPreferenceConstants.javajet";

    private static final String NODE_PREFERENCE_PAGE_JAVA = "templateDiagram/diagram/preferences/NodePreferencePage.javajet";

    private static final String EDGE_PREFERENCE_PAGE_JAVA = "templateDiagram/diagram/preferences/EdgePreferencePage.javajet";

    private static final String DIAGRAM_TOPCASED_PREFERENCE_INITIALIZER_JAVA = "templateDiagram/diagram/preferences/DiagramTopcasedPreferenceInitializer.javajet";

    private static final String DIAGRAM_PREFERENCE_PAGE_JAVA = "templateDiagram/diagram/preferences/DiagramPreferencePage.javajet";

    /** The DiagramConfiguration object */
    private DiagramConfiguration configuration;

    /**
     * Constructor
     * 
     * @param conf The editor configuration to generate
     */
    public DiagramConfiguratorGenerator(DiagramConfiguration conf)
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
        IProject project = createEMFProject(configuration.getProjectName());
        monitor.worked(1);

        monitor.subTask("Package creation");
        IPath pathProject = project.getFullPath();
        generateStaticPackages(configuration, pathProject);
        monitor.worked(1);

        generateDiagram(configuration, pathProject, monitor);

        return project;
    }

    /**
     * @see org.topcased.generator.AbstractGenerator#createJETEmitter(java.lang.String)
     */
    protected JETEmitter createJETEmitter(String templateURI)
    {
        JETEmitter emitter = new DefaultJETEmitter(templateURI)
        {
            public void initialize(Monitor monitor) throws JETException
            {
                // The editorconfigurator and the diagramconfigurator plugins
                // must be released to activate the generation.
                addVariable("EDITOR_CONF", "org.topcased.modeler.editorconfigurator");
                addVariable("DIAGRAM_CONF", "org.topcased.modeler.diagramconfigurator");
                addVariable("ECLIPSE_CORE_RUNTIME", "org.eclipse.core.runtime");
                addVariable("ECLIPSE_OSGI", "org.eclipse.osgi");
                // TODO check if the code snippet is correct with other OS
                // addVariable("SWT", "org.eclipse.swt." + Platform.getWS() +
                // "." + Platform.getOS() + "."
                // + Platform.getOSArch());
                addVariable("DRAW2D", "org.eclipse.draw2d");

                super.initialize(monitor);
            }
        };

        emitter.setProjectName(".JETEmittersDiagram");

        return emitter;
    }

    /**
     * Creates the required packages on the project
     * 
     * @param diagConf the diagramConfiguration model object
     * @param pathProject the path for the given project
     * @throws CoreException if the generation failed
     */
    private void generateStaticPackages(DiagramConfiguration diagConf, IPath pathProject) throws CoreException
    {
        IPath packagePath = new Path(diagConf.getBasePackage().replace('.', IPath.SEPARATOR));

        for (int i = 1; i < packagePath.segmentCount() + 1; i++)
        {
            IPath pathPackage = pathProject.append(IPath.SEPARATOR + SOURCE_DIRECTORY + IPath.SEPARATOR + packagePath.removeLastSegments(packagePath.segmentCount() - i));
            IFolder packagefolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(pathPackage);
            if (!(packagefolder.exists()))
            {
                packagefolder.create(true, false, new NullProgressMonitor());
            }
        }

        // create the templates folder and the folder that will handle the first
        // generated template files
        IPath pathTemplates = pathProject.append(IPath.SEPARATOR + "templates");
        IFolder templatesFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(pathTemplates);
        if (!(templatesFolder.exists()))
        {
            templatesFolder.create(true, false, new NullProgressMonitor());
        }
        IPath pathTemplate1 = pathTemplates.append(IPath.SEPARATOR + diagConf.getPackage());
        IFolder template1Folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(pathTemplate1);
        if (!(template1Folder.exists()))
        {
            template1Folder.create(true, false, new NullProgressMonitor());
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

        // create the packages hierarchy
        String[] packagesDiagram = {"actions", "edit", "figures", "policies", "commands", "preferences"};
        for (int j = 0; j < packagesDiagram.length; j++)
        {
            IPath pathDiagram = pathProject.append(IPath.SEPARATOR + SOURCE_DIRECTORY + IPath.SEPARATOR + packagePath + IPath.SEPARATOR + packagesDiagram[j]);
            IFolder folderDiagram = ResourcesPlugin.getWorkspace().getRoot().getFolder(pathDiagram);
            if (!(folderDiagram.exists()))
            {
                folderDiagram.create(true, false, new NullProgressMonitor());
            }
        }
    }

    private void generateDiagram(DiagramConfiguration conf, IPath projectPath, IProgressMonitor monitor)
    {
        try
        {
            monitor.subTask("Files creation");

            generatePluginClass(conf, projectPath);
            generateImageRegistryClass(conf, projectPath);
            generateEditPolicyConstants(conf, projectPath);
            generateSimpleObjectConstants(conf, projectPath);
            generateEdgeObjectConstants(conf, projectPath);

            generatePluginXML(conf, projectPath);
            generateManifestMF(conf, projectPath);
            generateImageProperties(conf, projectPath);
            generateBuildProperties(conf, projectPath);

            generateEditPartFactoryClass(conf, projectPath);
            generatePaletteManagerClass(conf, projectPath);
            generateConfigurationClass(conf, projectPath);
            generateEditPart2ModelAdapterFactoryClass(conf, projectPath);
            generateCreationUtilsClass(conf, projectPath);

            generateDiagramEditPartClass(conf, projectPath);
            generateDiagramFigureClass(conf, projectPath);
            generateDiagramLayoutEditPolicyClass(conf, projectPath);

            generateDiagramGraphConf(conf, projectPath);
            generateTemplateModel(conf, projectPath);
            generateTemplateDiagram(conf, projectPath);

            generateDiagramPreferenceConstantClass(conf, projectPath);
            generateDiagramTopcasedPreferenceInitializerClass(conf, projectPath);
            generateDiagramPreferencePageClass(conf, projectPath);

            monitor.worked(1);

            for (PartConfiguration partConf : conf.getParts())
            {
                generateEditPartClass(conf, partConf, projectPath);

                /** Kermeta adding */
                for (PartAction aPartAction : partConf.getActions())
                {
                    generatePartActionClass(conf, aPartAction, projectPath);
                    generatePartActionCommandClass(conf, aPartAction, projectPath);
                }

                if (partConf instanceof NodePartConfiguration)
                {
                    generateNodeFigureClass(conf, (NodePartConfiguration) partConf, projectPath);
                    if (!partConf.isAbstract())
                    {
                        generateNodePreferencePageClass(conf, (NodePartConfiguration) partConf, projectPath);
                    }
                    if (((NodePartConfiguration) partConf).isContainer())
                    {
                        generateNodeLayoutEditPolicyClass(conf, (NodePartConfiguration) partConf, projectPath);
                    }
                    // Generate the RestoreConnectionCommand also if the node is
                    // not connectable
                    if (((NodePartConfiguration) partConf).getObject() instanceof ModelObjectConfiguration)
                    // && isConnectable((NodePartConfiguration) partConf))
                    {
                        generateRestoreConnectionCommandClass(conf, (NodePartConfiguration) partConf, projectPath);
                    }
                }
                else if (partConf instanceof EdgePartConfiguration)
                {
                    generateEdgeFigureClass(conf, (EdgePartConfiguration) partConf, projectPath);
                    if (!partConf.isAbstract())
                    {
                        generateEdgePreferencePageClass(conf, (EdgePartConfiguration) partConf, projectPath);
                    }
                    boolean hasEndPoint = false;
                    for (EdgeObject edgeObject : ((EdgePartConfiguration) partConf).getEdgeObjects())
                    {
                        if (edgeObject.getType().equals(EdgeObjectType.SOURCE_LITERAL) || edgeObject.getType().equals(EdgeObjectType.TARGET_LITERAL))
                        {
                            hasEndPoint = true;
                        }
                    }
                    if (hasEndPoint)
                    {
                        generateEdgeObjectUVEditPolicyClass(conf, (EdgePartConfiguration) partConf, projectPath);
                    }
                }
            }

            monitor.worked(1);

        }
        catch (JETException e)
        {
            GeneratorPlugin.log(e);
            GeneratorPlugin.displayDialog(null, "JETException : an error occured during diagram generation. See error logs for more details.", IStatus.ERROR);
        }
        catch (CoreException e)
        {
            GeneratorPlugin.log(e);
            GeneratorPlugin.displayDialog(null, "CoreException : an error occured during diagram generation. See error logs for more details.", IStatus.ERROR);
        }
    }

    private String getTemplateURI(String relativePath)
    {
        return getTemplateURI(GeneratorPlugin.getDefault().getBundle(), relativePath);
    }

    // ----------------------------------------
    // The generations common to the same editor
    // ----------------------------------------
    private void generatePluginClass(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        if (!diagConf.isSamePluginAsEditor())
        {
            applyTemplate(diagConf, getTemplateURI(PLUGIN_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/" + diagConf.getPrefix()
                    + "Plugin.java"), diagConf.isForceOverwrite());
        }
    }

    private void generateImageRegistryClass(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(IMAGE_REGISTRY_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/" + diagConf.getPrefix()
                + "ImageRegistry.java"), diagConf.isForceOverwrite());
    }

    private void generateImageProperties(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(IMAGES_PROPERTIES), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/images.properties"),
                diagConf.isForceOverwrite());
    }

    private void generatePluginXML(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        if (diagConf.isSamePluginAsEditor())
        {
            applyTemplate(diagConf, getTemplateURI(PLUGIN_XML), projectPath.append("/plugin" + diagConf.getPackage() + "ToMerge.xml"), diagConf.isForceOverwrite());
        }
        else
        {
            applyTemplate(diagConf, getTemplateURI(PLUGIN_XML), projectPath.append("/plugin.xml"), diagConf.isForceOverwrite());
        }
    }

    private void generateManifestMF(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        if (!diagConf.isSamePluginAsEditor())
        {
            applyTemplate(diagConf, getTemplateURI(MANIFEST_MF), projectPath.append("/META-INF/MANIFEST.MF"), diagConf.isForceOverwrite());
        }
    }

    private void generateBuildProperties(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(BUILD_PROPERTIES), projectPath.append("/build.properties"), diagConf.isForceOverwrite());
    }

    private void generateEditPolicyConstants(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(EDIT_POLICY_CONSTANTS_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/" + diagConf.getPrefix()
                + "EditPolicyConstants.java"), diagConf.isForceOverwrite());
    }

    private void generateSimpleObjectConstants(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(SIMPLE_OBJECT_CONSTANTS_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/"
                + diagConf.getPrefix() + "SimpleObjectConstants.java"), diagConf.isForceOverwrite());
    }

    private void generateEdgeObjectConstants(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(EDGE_OBJECT_CONSTANTS_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/" + diagConf.getPrefix()
                + "EdgeObjectConstants.java"), diagConf.isForceOverwrite());
    }

    // -----------------------------------------------
    // The generations that are proper to each diagram
    // -----------------------------------------------
    private void generateEditPartFactoryClass(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(EDITPART_FACTORY_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/" + diagConf.getPrefix()
                + "EditPartFactory.java"), diagConf.isForceOverwrite());
    }

    private void generatePaletteManagerClass(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(PALETTE_MANAGER_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/" + diagConf.getPrefix()
                + "PaletteManager.java"), diagConf.isForceOverwrite());
    }

    private void generateConfigurationClass(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(CONFIGURATION_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/" + diagConf.getPrefix()
                + "Configuration.java"), diagConf.isForceOverwrite());
    }

    private void generateEditPart2ModelAdapterFactoryClass(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(EDITPART2MODEL_ADAPTERFACTORY_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/"
                + "EditPart2ModelAdapterFactory.java"), diagConf.isForceOverwrite());
    }

    private void generateCreationUtilsClass(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(CREATION_UTILS_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/" + diagConf.getPrefix()
                + "CreationUtils.java"), diagConf.isForceOverwrite());
    }

    private void generateDiagramEditPartClass(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(DIAGRAM_EDITPART_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/edit/" + diagConf.getPrefix()
                + "DiagramEditPart.java"), diagConf.isForceOverwrite());
    }

    private void generateDiagramFigureClass(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(DIAGRAM_FIGURE_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/figures/" + diagConf.getPrefix()
                + "DiagramFigure.java"), diagConf.isForceOverwrite());
    }

    private void generateDiagramLayoutEditPolicyClass(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(DIAGRAM_LAYOUT_EDITPOLICY_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/policies/"
                + diagConf.getPrefix() + "DiagramLayoutEditPolicy.java"), diagConf.isForceOverwrite());
    }

    private void generateDiagramGraphConf(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(DIAGRAM_GRAPHCONF), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/diagram.graphconf"),
                diagConf.isOverwriteGraphConf());
    }

    private void generateTemplateModel(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(TEMPLATE_MODEL), projectPath.append("/templates/" + diagConf.getPackage() + "/%name%." + diagConf.getExtension()), diagConf.isForceOverwrite());
    }

    private void generateTemplateDiagram(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(TEMPLATE_DIAGRAM), projectPath.append("/templates/" + diagConf.getPackage() + "/%name%." + diagConf.getExtensionDiagram()), diagConf.isForceOverwrite());
    }

    // -------------------------------------------------------
    // The generations that are proper to each diagram element
    // -------------------------------------------------------
    private void generateEditPartClass(DiagramConfiguration diagConf, PartConfiguration partConf, IPath projectPath) throws JETException, CoreException
    {
        if (partConf instanceof NodePartConfiguration)
        {
            applyTemplate(partConf, getTemplateURI(NODE_EDITPART_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/edit/" + partConf.getPrefix()
                    + "EditPart.java"), diagConf.isForceOverwrite());
        }
        else if (partConf instanceof EdgePartConfiguration)
        {

            // Generate edge edit part
            applyTemplate(partConf, getTemplateURI(EDGE_EDITPART_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/edit/" + partConf.getPrefix()
                    + "EditPart.java"), diagConf.isForceOverwrite());

            // Generate edge policy
            applyTemplate(partConf, getTemplateURI(EDGE_CREATION_EDITPOLICY_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/policies/"
                    + partConf.getPrefix() + "EdgeCreationEditPolicy.java"), diagConf.isForceOverwrite());

            // Generate edge command
            applyTemplate(partConf, getTemplateURI(EDGE_CREATION_COMMAND_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/commands/"
                    + partConf.getPrefix() + "EdgeCreationCommand.java"), diagConf.isForceOverwrite());
        }
    }

    private void generateNodeFigureClass(DiagramConfiguration diagConf, NodePartConfiguration partConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(partConf, getTemplateURI(NODE_FIGURE_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/figures/" + partConf.getPrefix()
                + "Figure.java"), diagConf.isForceOverwrite());
    }

    private void generateNodeLayoutEditPolicyClass(DiagramConfiguration diagConf, NodePartConfiguration partConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(partConf, getTemplateURI(NODE_LAYOUT_EDITPOLICY_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/policies/"
                + partConf.getPrefix() + "LayoutEditPolicy.java"), diagConf.isForceOverwrite());
    }

    private void generateRestoreConnectionCommandClass(DiagramConfiguration diagConf, NodePartConfiguration partConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(partConf, getTemplateURI(RESTORE_CONNECTION_COMMAND_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/commands/"
                + partConf.getPrefix() + "RestoreConnectionCommand.java"), diagConf.isForceOverwrite());
    }

    private void generateEdgeObjectUVEditPolicyClass(DiagramConfiguration diagConf, EdgePartConfiguration partConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(partConf, getTemplateURI(EDGE_OBJECT_UV_EDITPOLICY_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/policies/"
                + partConf.getPrefix() + "EdgeObjectUVEditPolicy.java"), diagConf.isForceOverwrite());
    }

    private void generateEdgeFigureClass(DiagramConfiguration diagConf, EdgePartConfiguration partConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(partConf, getTemplateURI(EDGE_FIGURE_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/figures/" + partConf.getPrefix()
                + "Figure.java"), diagConf.isForceOverwrite());
    }

    /** Kermeta adding */
    private void generatePartActionClass(DiagramConfiguration diagConf, PartAction partAction, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(partAction, getTemplateURI(PART_ACTION_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/actions/"
                + partAction.getPrefix() + "Action.java"), diagConf.isForceOverwrite());

    }

    /** Kermeta adding */
    private void generatePartActionCommandClass(DiagramConfiguration diagConf, PartAction partAction, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(partAction, getTemplateURI(PART_ACTION_COMMAND_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/commands/"
                + partAction.getPrefix() + "Command.java"), diagConf.isForceOverwrite());
    }

    private void generateDiagramPreferenceConstantClass(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(DIAGRAM_PREFERENCE_CONSTANTS_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/preferences/"
                + diagConf.getPrefix() + "DiagramPreferenceConstants.java"), diagConf.isOverwriteGraphConf());
    }

    private void generateDiagramTopcasedPreferenceInitializerClass(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(DIAGRAM_TOPCASED_PREFERENCE_INITIALIZER_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/preferences/"
                + diagConf.getPrefix() + "DiagramTopcasedPreferenceInitializer.java"), diagConf.isOverwriteGraphConf());
    }

    private void generateDiagramPreferencePageClass(DiagramConfiguration diagConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(diagConf, getTemplateURI(DIAGRAM_PREFERENCE_PAGE_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/preferences/"
                + diagConf.getPrefix() + "DiagramPreferencePage.java"), diagConf.isOverwriteGraphConf());
    }

    private void generateNodePreferencePageClass(DiagramConfiguration diagConf, NodePartConfiguration partConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(partConf, getTemplateURI(NODE_PREFERENCE_PAGE_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/preferences/"
                + partConf.getPrefix() + "PreferencePage.java"), diagConf.isForceOverwrite());
    }

    private void generateEdgePreferencePageClass(DiagramConfiguration diagConf, EdgePartConfiguration partConf, IPath projectPath) throws JETException, CoreException
    {
        applyTemplate(partConf, getTemplateURI(EDGE_PREFERENCE_PAGE_JAVA), projectPath.append("/" + SOURCE_DIRECTORY + "/" + diagConf.getBasePackage().replace('.', '/') + "/preferences/"
                + partConf.getPrefix() + "PreferencePage.java"), diagConf.isForceOverwrite());
    }
}