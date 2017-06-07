/*******************************************************************************
 * Copyright (c) 2006 ANYWARE TECHNOLOGIES. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jose Alfredo Serrano (Anyware Technologies) - initial API
 ******************************************************************************/
package org.topcased.properties.generator;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Monitor;
import org.topcased.generator.AbstractGenerator;
import org.topcased.generator.jet.DefaultJETEmitter;
import org.topcased.properties.configurator.AbstractSection;
import org.topcased.properties.configurator.Category;
import org.topcased.properties.configurator.MultipleFeatureSection;
import org.topcased.properties.configurator.SingleFeatureSection;
import org.topcased.properties.configurator.Tab;
import org.topcased.properties.configurator.TabbedView;
import org.topcased.properties.configurator.util.GeneratorUtils;
import org.topcased.properties.generator.internal.PropertiesViewGeneratorPlugin;
import org.topcased.properties.generator.internal.util.ITemplateRetriever;
import org.topcased.properties.generator.internal.util.TemplateRetriever;

/**
 * This class is the Entry point of the generation for a Topcased tabbed properties view by a *.propertiesconfigurator file<br>
 * 
 * Creation 01 aug. 2006
 * 
 * @author <a href="mailto:alfredo@anyware-tech.com">Alfredo SERRANO</a>
 * 
 */
public class PropertiesViewGenerator extends AbstractGenerator
{
    /** A simple IPath separator */
    public static final char SLASH = IPath.SEPARATOR;

    /** The plugin.xml template location */
    private static final String PLUGIN_XML = "template/plugin.xmljet";

    /** The plugin activator template location */
    private static final String PLUGIN_ACTIVATOR = "template/Plugin.javajet";

    /** The build properties template location */
    private static final String BUILD_PROPERTIES = "template/build.propertiesjet";

    /** The manifest template location */
    private static final String MANIFEST_MF = "template/MANIFEST.MFjet";

    /** The label provider template location */
    private static final String LABEL_PROVIDER = "template/LabelProvider.javajet";

    /** The properties sheet page template location */
    private static final String TABBED_SHEET = "template/sectionTemplates/PropertiesSheetPage.javajet";

    /** The model input. This is the root object from the tree */
    private TabbedView modelInput;

    /** The project to generate */
    private IProject generatedProject;

    /** The package where generated class will be placed */
    private String thePackage;

    /** A sub-package where section classes will be placed */
    private String sections;

    /** A sub-package where the sheet page is going to be placed */
    private String advanced;

    /**
     * Class constructor. Create a new properties view generator
     * 
     * @param tabbedView the model input
     */
    public PropertiesViewGenerator(TabbedView tabbedView)
    {
        modelInput = tabbedView;
        thePackage = tabbedView.getProjectNameUnspaced();
        String basePackage = tabbedView.getBasePackage();
        if (basePackage != null && !basePackage.equals(""))
        {
            thePackage = basePackage;
        }
        sections = thePackage + ".sections";
        advanced = sections + ".advanced";
    }

    // ////////// Getters/Setters //////////////
    // /////////////////////////////////////////

    /**
     * @return the advanced
     */
    public String getAdvanced()
    {
        return advanced;
    }

    /**
     * @return the generatedProject
     */
    public IProject getGeneratedProject()
    {
        return generatedProject;
    }

    /**
     * @return the sections
     */
    public String getSections()
    {
        return sections;
    }

    /**
     * @return the thePackage
     */
    public String getThePackage()
    {
        return thePackage;
    }

    // /////////// Implementing abstract methods //////////////
    // ////////////////////////////////////////////////////////

    /**
     * Launch the generation for the current properties configuration
     * 
     * @param monitor the monitor for the work progression
     * @return the generated IProject
     * 
     * @throws CoreException if the generation fails
     */
    public IProject generate(IProgressMonitor monitor) throws CoreException
    {
        monitor.subTask("Project creation");
        IProject project = createEMFProject(modelInput.getProjectName());
        generatedProject = project;
        monitor.worked(1);

        try
        {
            generateStaticPackages();
            monitor.subTask("Plugin configuration");
            if (modelInput.getId() != null && modelInput.getId().length() != 0)
            {
                monitor.subTask("Plugin configuration");
                generatePluginXML();
                monitor.worked(1);
                generateManifestMF();
                monitor.worked(1);
                generateBuildProperties();
                monitor.worked(1);
                generatePluginActivator();
            }
            monitor.worked(1);
            generateLabelProvider();
            monitor.worked(1);
            generateAdvancedSection();
            monitor.worked(1);
            generateSections();
        }
        catch (JETException e)
        {
            PropertiesViewGeneratorPlugin.log(e);
            PropertiesViewGeneratorPlugin.displayDialog(null, "JETException : an error occured during properties generation. See error logs for more details.", IStatus.ERROR);
        }

        return project;
    }

    /**
     * @see org.topcased.generator.AbstractGenerator#createJETEmitter(java.lang.String)
     */
    protected JETEmitter createJETEmitter(String templateURI)
    {
        return new DefaultJETEmitter(templateURI)
        {
            public void initialize(Monitor monitor) throws JETException
            {
                // The propertiesconfigurator plugin must be released to activate the generation.
                addVariable("PROPERTIES_VIEW_CONF", "org.topcased.properties.configurator");
                addVariable("SWT", "org.eclipse.swt." + Platform.getWS() + "." + Platform.getOS() + "." + Platform.getOSArch());

                super.initialize(monitor);
            }
        };
    }

    // //////////// Public API Methods ///////////////
    // ///////////////////////////////////////////////

    /**
     * Returns IPath of the given packageName. The parameter may have the following format: <code>org.topcased.something.else</code> The return IPath will replace the '.' into IPaths Separators
     * 
     * @param packageName the package in java format
     * @return IPath of the given package.
     */
    public static IPath getPackageIPath(String packageName)
    {
        return new Path(packageName.replace('.', IPath.SEPARATOR));
    }

    // ///////////// Helpers ///////////////
    // /////////////////////////////////////

    /**
     * Returns a template URI for the given path relative to this generator bundle.
     * 
     * @param relativePath @return a string URI
     */
    private String getTemplateURI(String relativePath)
    {
        return super.getTemplateURI(PropertiesViewGeneratorPlugin.getDefault().getBundle(), relativePath);
    }

    /**
     * Creates the required packages on the project
     * 
     * @param pathProject the path for the given project @throws CoreException if the generation failed
     */
    private void generateStaticPackages() throws CoreException
    {
        IPath pathProject = generatedProject.getFullPath();

        createPackage(sections, generatedProject);

        // create the templates and template1 folders
        IPath pathTemplates = pathProject.append(IPath.SEPARATOR + "model");
        IFolder templatesFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(pathTemplates);
        if (!(templatesFolder.exists()))
        {
            templatesFolder.create(true, false, new NullProgressMonitor());
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

    /**
     * Generate the plugin.xml file with the right extensions
     * 
     * @throws JETException @throws CoreException
     */
    private void generatePluginXML() throws JETException, CoreException
    {
        IPath pluginxmlPath = generatedProject.getFullPath().append("/plugin.xml");
        IFile pluginxml = ResourcesPlugin.getWorkspace().getRoot().getFile(pluginxmlPath);
        if (pluginxml.exists())
        {
            pluginxmlPath = generatedProject.getFullPath().append("/pluginToMerge.xml");
        }
        applyTemplate(modelInput, getTemplateURI(PLUGIN_XML), pluginxmlPath, false);
    }

    /**
     * Generate the MANIFEST file
     * 
     * @throws JETException @throws CoreException
     */
    private void generateManifestMF() throws JETException, CoreException
    {
        IPath manifestPath = generatedProject.getFullPath().append("/META-INF/MANIFEST.MF");
        IFile manifest = ResourcesPlugin.getWorkspace().getRoot().getFile(manifestPath);
        if (manifest.exists())
        {
            manifestPath = generatedProject.getFullPath().append("/META-INF/MANIFESTtoMerge.MF");
        }
        applyTemplate(modelInput, getTemplateURI(MANIFEST_MF), manifestPath, false);
    }

    /**
     * Generate the build.properties file
     * 
     * @throws JETException @throws CoreException
     */
    private void generateBuildProperties() throws JETException, CoreException
    {
        IPath buildPropertiesPath = generatedProject.getFullPath().append("/build.properties");
        IFile buildProperties = ResourcesPlugin.getWorkspace().getRoot().getFile(buildPropertiesPath);
        if (!buildProperties.exists())
        {
            applyTemplate(modelInput, getTemplateURI(BUILD_PROPERTIES), buildPropertiesPath, false);
        }
    }

    /**
     * Generates a plugin activator if there is not any
     * 
     * @throws JETException @throws CoreException
     */
    private void generatePluginActivator() throws JETException, CoreException
    {
        GenModel model = modelInput.getGenModel();
        String modelPluginClassName = model.getModelPluginClassName();
        IPath p = new Path(SOURCE_DIRECTORY).append(getPackageIPath(model.getModelPluginPackageName()).append(modelPluginClassName));
        IPath pluginActivatorPath = generatedProject.getFullPath().append(p);
        IFile pluginActivator = ResourcesPlugin.getWorkspace().getRoot().getFile(pluginActivatorPath.addFileExtension("java"));
        if (!pluginActivator.exists())
        {
            String sectionPath = SLASH + SOURCE_DIRECTORY + SLASH + getPackageIPath(thePackage).toOSString() + SLASH;
            IPath path = generatedProject.getFullPath().append(sectionPath + modelPluginClassName + "Sections.java");
            applyTemplate(modelInput, getTemplateURI(PLUGIN_ACTIVATOR), path, false);
        }
    }

    /**
     * Generates the label provider for the properties sheet page
     * 
     * @throws JETException @throws CoreException
     */
    private void generateLabelProvider() throws JETException, CoreException
    {
        createPackage(thePackage + ".providers", generatedProject);
        String sectionPath = SLASH + SOURCE_DIRECTORY + SLASH + getPackageIPath(thePackage + ".providers").toOSString() + SLASH;
        applyTemplate(modelInput, getTemplateURI(LABEL_PROVIDER), generatedProject.getFullPath().append(sectionPath + "SectionsLabelProvider.java"), false);
    }

    /**
     * Generate the section classes
     * 
     * @throws JETException @throws CoreException
     */
    private void generateSections() throws JETException, CoreException
    {
        List<?> categories = modelInput.getCategories();
        ITemplateRetriever retriever = new TemplateRetriever();
        for (Iterator<?> iter = categories.iterator(); iter.hasNext();)
        {
            Category category = (Category) iter.next();
            List<?> tabs = category.getTabs();
            for (Iterator<?> iterator = tabs.iterator(); iterator.hasNext();)
            {
                Tab tab = (Tab) iterator.next();
                List<?> sectionsList = tab.getSections();
                for (Iterator<?> it = sectionsList.iterator(); it.hasNext();)
                {
                    AbstractSection abSection = (AbstractSection) it.next();
                    if (abSection instanceof SingleFeatureSection)
                    {
                        SingleFeatureSection section = (SingleFeatureSection) abSection;
                        String template = retriever.getTemplate(section.getFeature());
                        applyTemplate(template, abSection);
                    }
                    else if (abSection instanceof MultipleFeatureSection)
                    {
                        MultipleFeatureSection section = (MultipleFeatureSection) abSection;
                        section.getFeatures();
                        // TODO multiple feature section get the right template
                        String template = null;
                        applyTemplate(template, abSection);
                    }
                    else
                    {

                    }
                }
            }
        }
    }

    /**
     * Apply generation for the given section with the given template
     * 
     * @param template The template location @param abSection The section tu generate
     * 
     * @throws JETException @throws CoreException
     */
    private void applyTemplate(String template, AbstractSection abSection) throws JETException, CoreException
    {
        if (template != null)
        {
            generateSectionClass(template, abSection);
        }
        else
        {
            IStatus status = new Status(IStatus.WARNING, PropertiesViewGeneratorPlugin.PLUGIN_ID, IStatus.WARNING, "Template not found.", null);
            PropertiesViewGeneratorPlugin.log(status);
        }
    }

    /**
     * Generates the section class with the given template
     * 
     * @param templateURI The template location @param section The template argument
     * 
     * @throws JETException @throws CoreException
     */
    private void generateSectionClass(String templateURI, AbstractSection section) throws JETException, CoreException
    {
        String sectionPath = SLASH + SOURCE_DIRECTORY + SLASH + getPackageIPath(sections).toOSString() + SLASH;
        applyTemplate(section, getTemplateURI(templateURI), generatedProject.getFullPath().append(sectionPath + section.getClassName() + ".java"), false);
    }

    /**
     * Generate the tabbed property sheet page
     * 
     * @param section the template agument
     * 
     * @throws JETException @throws CoreException
     */
    private void generateAdvancedSection() throws JETException, CoreException
    {
        GenModel model = modelInput.getGenModel();
        EList<GenPackage> packages = model.getGenPackages();
        String prefix = model.getModelName();
        if (!packages.isEmpty())
        {
            GenPackage p = packages.get(0);
            prefix = p.getPrefix();
        }
        createPackage(advanced, generatedProject);
        String advancedPath = SLASH + SOURCE_DIRECTORY + SLASH + getPackageIPath(advanced).toOSString() + SLASH;

        applyTemplate(modelInput, getTemplateURI(TABBED_SHEET), generatedProject.getFullPath().append(advancedPath + GeneratorUtils.capName(prefix) + "PropertySheetPage.java"), false);
    }
}