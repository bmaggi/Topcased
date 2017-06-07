/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.generator.internal.generators.doc;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.topcased.modeler.generator.internal.GeneratorPlugin;
import org.w3c.dom.NodeList;

/**
 * <br>
 * creation : 27 june 2005
 * 
 * @author <a href="mailto:mathieu.garcia@anyware-tech.com">Mathieu Garcia</a>
 */
public class HTMLDocGenerator extends DocGenerator
{

    private static final String PDE_NATURE = "org.eclipse.pde.PluginNature";

    private static final String JAVA_BUILDER = "org.eclipse.jdt.core.javabuilder";

    private static final String MANIFEST_BUILDER = "org.eclipse.pde.ManifestBuilder";

    private static final String SCHEMA_BUILDER = "org.eclipse.pde.SchemaBuilder";

    private static final String SOURCE_DIRECTORY = "src";

    private IFile targetFile;

    /**
     * The constructor
     * 
     * @param epackage
     * @param target
     */
    public HTMLDocGenerator(EPackage epackage, IFile target)
    {
        super(epackage);
        targetFile = target;
    }

    /**
     * Add default natures to the project
     * 
     * @param projectDescription
     * @return String[]
     */
    protected static String[] addDefaultNatures(IProjectDescription projectDescription)
    {
        String[] natureIds = projectDescription.getNatureIds();

        if (natureIds == null)
        {
            natureIds = new String[] {JavaCore.NATURE_ID};
        }
        else
        {
            boolean hasJavaNature = false;
            boolean hasPDENature = false;
            for (int i = 0; i < natureIds.length; ++i)
            {
                if (JavaCore.NATURE_ID.equals(natureIds[i]))
                {
                    hasJavaNature = true;
                }
                if (PDE_NATURE.equals(natureIds[i]))
                {
                    hasPDENature = true;
                }
            }

            if (!hasJavaNature)
            {
                String[] oldNatureIds = natureIds;
                natureIds = new String[oldNatureIds.length + 1];
                System.arraycopy(oldNatureIds, 0, natureIds, 0, oldNatureIds.length);
                natureIds[oldNatureIds.length] = JavaCore.NATURE_ID;
            }
            if (!hasPDENature)
            {
                String[] oldNatureIds = natureIds;
                natureIds = new String[oldNatureIds.length + 1];
                System.arraycopy(oldNatureIds, 0, natureIds, 0, oldNatureIds.length);
                natureIds[oldNatureIds.length] = PDE_NATURE;
            }
        }
        return natureIds;
    }

    /**
     * Add default builders to project
     * 
     * @param projectDescription
     * @return ICommand[]
     */
    protected static ICommand[] addDefaultBuilders(IProjectDescription projectDescription)
    {
        ICommand[] builders = projectDescription.getBuildSpec();

        if (builders == null)
        {
            builders = new ICommand[0];
        }
        boolean hasJavaBuilder = false;
        boolean hasManifestBuilder = false;
        boolean hasSchemaBuilder = false;
        for (int i = 0; i < builders.length; ++i)
        {
            if (JAVA_BUILDER.equals(builders[i].getBuilderName()))
            {
                hasJavaBuilder = true;
            }
            if (MANIFEST_BUILDER.equals(builders[i].getBuilderName()))
            {
                hasManifestBuilder = true;
            }
            if (SCHEMA_BUILDER.equals(builders[i].getBuilderName()))
            {
                hasSchemaBuilder = true;
            }
        }
        if (!hasJavaBuilder)
        {
            ICommand[] oldBuilders = builders;
            builders = new ICommand[oldBuilders.length + 1];
            System.arraycopy(oldBuilders, 0, builders, 0, oldBuilders.length);
            builders[oldBuilders.length] = projectDescription.newCommand();
            builders[oldBuilders.length].setBuilderName(JAVA_BUILDER);
        }
        if (!hasManifestBuilder)
        {
            ICommand[] oldBuilders = builders;
            builders = new ICommand[oldBuilders.length + 1];
            System.arraycopy(oldBuilders, 0, builders, 0, oldBuilders.length);
            builders[oldBuilders.length] = projectDescription.newCommand();
            builders[oldBuilders.length].setBuilderName(MANIFEST_BUILDER);
        }
        if (!hasSchemaBuilder)
        {
            ICommand[] oldBuilders = builders;
            builders = new ICommand[oldBuilders.length + 1];
            System.arraycopy(oldBuilders, 0, builders, 0, oldBuilders.length);
            builders[oldBuilders.length] = projectDescription.newCommand();
            builders[oldBuilders.length].setBuilderName(SCHEMA_BUILDER);
        }
        return builders;
    }

    /**
     * Build project
     * 
     * @param projectName
     * @return IProject
     */
    protected static IProject createPluginProject(String projectName)
    {
        IPath javaSource = new Path(IPath.SEPARATOR + projectName + IPath.SEPARATOR + "src");
        IPath projectLocationPath = null;
        IProgressMonitor progressMonitor = new NullProgressMonitor();

        IProject project = null;

        try
        {
            List classpathEntries = new UniqueEList();

            project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
            IJavaProject javaProject = JavaCore.create(project);
            IProjectDescription projectDescription = null;
            if (!project.exists())
            {
                projectDescription = project.getWorkspace().newProjectDescription(projectName);
                projectDescription.setLocation(projectLocationPath);
                project.create(projectDescription, new NullProgressMonitor());
            }
            else
            {
                projectDescription = project.getDescription();
                classpathEntries.addAll(Arrays.asList(javaProject.getRawClasspath()));
            }

            boolean isInitiallyEmpty = classpathEntries.isEmpty();

            // add the natures
            String[] natureIds = addDefaultNatures(projectDescription);
            projectDescription.setNatureIds(natureIds);

            // add the builders
            ICommand[] builders = addDefaultBuilders(projectDescription);
            projectDescription.setBuildSpec(builders);

            // open the project and apply the new Descriptions
            project.open(new NullProgressMonitor());
            project.setDescription(projectDescription, new NullProgressMonitor());

            // initialize the directory which will contains the sources
            IContainer sourceContainer = project;
            if (javaSource.segmentCount() > 1)
            {
                sourceContainer = project.getFolder(javaSource.removeFirstSegments(1).makeAbsolute());
                if (!sourceContainer.exists())
                {
                    ((IFolder) sourceContainer).create(false, true, new SubProgressMonitor(progressMonitor, 1));
                }
            }

            if (isInitiallyEmpty)
            {

                IClasspathEntry sourceClasspathEntry = JavaCore.newSourceEntry(javaSource);
                for (Iterator i = classpathEntries.iterator(); i.hasNext();)
                {
                    IClasspathEntry classpathEntry = (IClasspathEntry) i.next();
                    if (classpathEntry.getPath().isPrefixOf(javaSource))
                    {
                        i.remove();
                    }
                }
                classpathEntries.add(0, sourceClasspathEntry);

                IClasspathEntry jreClasspathEntry = JavaCore.newVariableEntry(new Path(JavaRuntime.JRELIB_VARIABLE), new Path(JavaRuntime.JRESRC_VARIABLE), new Path(JavaRuntime.JRESRCROOT_VARIABLE));
                for (Iterator i = classpathEntries.iterator(); i.hasNext();)
                {
                    IClasspathEntry classpathEntry = (IClasspathEntry) i.next();
                    if (classpathEntry.getPath().isPrefixOf(jreClasspathEntry.getPath()))
                    {
                        i.remove();
                    }
                }
                classpathEntries.add(jreClasspathEntry);
            }

            javaProject.setRawClasspath((IClasspathEntry[]) classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]), new SubProgressMonitor(progressMonitor, 1));
        }
        catch (CoreException e)
        {
            GeneratorPlugin.log(e);
        }
        finally
        {
            progressMonitor.done();
        }

        return project;
    }

    /**
     * Return template uri
     * 
     * @param relativePath
     * @return String
     */
    private String getTemplateURI(String relativePath)
    {
        return GeneratorPlugin.getDefault().getBundle().getEntry(relativePath).toString();
    }

    /**
     * Apply template
     * 
     * @param input
     * @param templateURI
     * @param outputFile
     * @throws JETException
     * @throws CoreException
     */
    private void applyTemplate(Object input, String templateURI, IPath outputFile) throws JETException, CoreException
    {
        JETEmitter emitter = new JETEmitter(templateURI);

        IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(outputFile);
        InputStream contents = new ByteArrayInputStream("fichier vide".getBytes());
        if (!(file.exists()))
        {
            file.create(contents, false, new NullProgressMonitor());
        }

        Object[] arguments = new Object[] {input};

        generate(emitter, arguments, file);
    }

    /**
     * JET Generation
     * 
     * @param emitter
     * @param arguments
     * @param file
     * @throws JETException
     * @throws CoreException
     */
    private void generate(final JETEmitter emitter, final Object[] arguments, final IFile file) throws JETException, CoreException
    {
        IProgressMonitor progressMonitor = new NullProgressMonitor();
        String generated = emitter.generate(progressMonitor, arguments);
        saveGenerated(generated, file, progressMonitor);
    }

    /**
     * Save generated file
     * 
     * @param generated
     * @param file
     * @param monitor
     * @throws CoreException
     */
    private void saveGenerated(String generated, IFile file, IProgressMonitor monitor) throws CoreException
    {
        InputStream contents = new ByteArrayInputStream(generated.getBytes());

        IContainer parent = file.getParent();
        IFile target = parent.getFile(new Path(file.getName()));

        if (target.exists())
        {
            target.setContents(contents, true, false, monitor);
        }
        else
        {
            File systemFile = target.getLocation().toFile();
            if (systemFile.exists())
            { // check if out of sync
                parent.refreshLocal(1, monitor); // not user-friendly: user
                // did
                // not
                // request Refresh...
                target.setContents(contents, true, false, monitor);
            }
            else
            {
                target.create(contents, false, monitor);
            }
        }
    }

    /**
     * @see DocGenerator#serialize(IProgressMonitor)
     */
    protected void serialize(IProgressMonitor monitor) throws CoreException
    {
        try
        {
            // Create project
            IProject project = createPluginProject("org.topcased.metamodel.help." + getEPackage().getName());

            String projectName = project.getName();
            IPath pathProject = project.getFullPath();

            // Generate java package
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

            // GeneratePluginClass
            applyTemplate(getEPackage().getName(), getTemplateURI("templateHelp/Plugin.javajet"), pathProject.append("/" + SOURCE_DIRECTORY + "/" + projectName.replace('.', '/') + "/"
                    + getEPackage().getName().toUpperCase() + "HelpPlugin.java"));

            // Generate plugin.xml
            applyTemplate(getEPackage().getName(), getTemplateURI("templateHelp/plugin.xmljet"), pathProject.append("/plugin.xml"));

            // Generate build.properties
            applyTemplate(getEPackage().getName(), getTemplateURI("templateHelp/build.propertiesjet"), pathProject.append("/build.properties"));

            // Generate epackageToc.xml
            applyTemplate(getEPackage().getName(), getTemplateURI("templateHelp/epackageToc.xmljet"), pathProject.append("/epackageToc.xml"));

            // Generate toc.xml
            InputStream xslInputStream = FileLocator.openStream(GeneratorPlugin.getDefault().getBundle(), new Path("resources/gen-toc.xsl"), false);
            Transformer xformer = TransformerFactory.newInstance().newTransformer(new StreamSource(xslInputStream));
            DOMSource source = new DOMSource(getDocument());

            IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(pathProject.append("/toc.xml"));
            InputStream contents = new ByteArrayInputStream("fichier vide".getBytes());
            if (!(file.exists()))
            {
                file.create(contents, false, new NullProgressMonitor());
            }

            IContainer parent = file.getParent();
            IFile target = parent.getFile(new Path(file.getName()));

            StreamResult result = new StreamResult(target.getLocation().toFile());
            xformer.transform(source, result);

            // Create html folders
            IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(pathProject.append("/html"));
            if (!(folder.exists()))
            {
                folder.create(true, false, new NullProgressMonitor());
            }

            folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(pathProject.append("/html/types"));
            if (!(folder.exists()))
            {
                folder.create(true, false, new NullProgressMonitor());
            }

            folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(pathProject.append("/html/classes"));
            if (!(folder.exists()))
            {
                folder.create(true, false, new NullProgressMonitor());
            }

            // Generate main.html files
            applyTemplate(getEPackage().getName(), getTemplateURI("templateHelp/main.htmljet"), pathProject.append("/html/main.html"));
            applyTemplate("EDatatypes", getTemplateURI("templateHelp/main.htmljet"), pathProject.append("/html/types/main.html"));
            applyTemplate("Eclasses", getTemplateURI("templateHelp/main.htmljet"), pathProject.append("/html/classes/main.html"));

            // Generate edatatype files
            NodeList list = getDocument().getElementsByTagName("edatatype");
            for (int i = 0; i < list.getLength(); i++)
            {
                String name = list.item(i).getAttributes().getNamedItem("name").getNodeValue();

                file = ResourcesPlugin.getWorkspace().getRoot().getFile(pathProject.append("/html/types/" + name + ".html"));
                contents = new ByteArrayInputStream("fichier vide".getBytes());
                if (!(file.exists()))
                {
                    file.create(contents, false, new NullProgressMonitor());
                }

                parent = file.getParent();
                target = parent.getFile(new Path(file.getName()));
                xslInputStream = FileLocator.openStream(GeneratorPlugin.getDefault().getBundle(), new Path("resources/gen-datatype.xsl"), false);
                xformer = TransformerFactory.newInstance().newTransformer(new StreamSource(xslInputStream));
                source = new DOMSource(getDocument());
                result = new StreamResult(target.getLocation().toFile());
                xformer.setParameter("edatatype", name);
                xformer.transform(source, result);
            }

            // Generate eclass files
            list = getDocument().getElementsByTagName("eclass");
            for (int i = 0; i < list.getLength(); i++)
            {
                String name = list.item(i).getAttributes().getNamedItem("name").getNodeValue();

                file = ResourcesPlugin.getWorkspace().getRoot().getFile(pathProject.append("/html/classes/" + name + ".html"));
                contents = new ByteArrayInputStream("fichier vide".getBytes());
                if (!(file.exists()))
                {
                    file.create(contents, false, new NullProgressMonitor());
                }

                parent = file.getParent();
                target = parent.getFile(new Path(file.getName()));
                xslInputStream = FileLocator.openStream(GeneratorPlugin.getDefault().getBundle(), new Path("resources/gen-class.xsl"), false);
                xformer = TransformerFactory.newInstance().newTransformer(new StreamSource(xslInputStream));
                source = new DOMSource(getDocument());
                result = new StreamResult(target.getLocation().toFile());
                xformer.setParameter("eclass", name);
                xformer.transform(source, result);
            }
        }
        catch (Exception e)
        {
            GeneratorPlugin.log(e);
            GeneratorPlugin.log("Unable to produce help plugin", IStatus.ERROR);
        }
        targetFile.getParent().refreshLocal(1, monitor);
    }

}
