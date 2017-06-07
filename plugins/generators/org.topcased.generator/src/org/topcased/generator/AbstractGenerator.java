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
package org.topcased.generator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.merge.java.JMerger;
import org.eclipse.emf.codegen.merge.java.facade.jdom.JDOMFacadeHelper;
import org.eclipse.emf.codegen.merge.properties.PropertyMerger;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.ui.actions.OrganizeImportsAction;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.osgi.framework.Bundle;
import org.topcased.generator.internal.GeneratorPlugin;

/**
 * An abstract implementation of a generator using JET and JMerge to generate code for EMF projects. <br>
 * 
 * Creation : 9 nov. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public abstract class AbstractGenerator
{
    /** The name of the JControl model */
    public static final String JCONTROL_MODEL_NAME = "merge.xml";

    /** The PDE nature id */
    public static final String PDE_NATURE = "org.eclipse.pde.PluginNature";

    /** The Java builder id */
    public static final String JAVA_BUILDER = "org.eclipse.jdt.core.javabuilder";

    /** The Manifest builder id */
    public static final String MANIFEST_BUILDER = "org.eclipse.pde.ManifestBuilder";

    /** The Schema builder id */
    public static final String SCHEMA_BUILDER = "org.eclipse.pde.SchemaBuilder";

    /** The name of the src directory */
    public static final String SOURCE_DIRECTORY = "src";

    /** Encoding for properties file */
    protected final static String PROPERTIES_ENCODING = "ISO-8859-1";

    /*
     * Fields
     */
    private JControlModel jControlModel = null;

    /**
     * Launch the generation. Subclass must implements this method to customize their own generation.
     * 
     * @param monitor the monitor for the work progression
     * 
     * @return the generated project
     * @throws CoreException if the generation fails
     */
    public abstract IProject generate(IProgressMonitor monitor) throws CoreException;

    /**
     * Add the default natures if they are not already present in the given IProjectDescription.<br>
     * Default implementation adds the Java and the PDE natures.
     * 
     * @param projectDescription an existing project description
     * @return the new natures array
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
     * Add the default builders if they are not already present in the given IProjectDescription.<br>
     * Default implementation adds the Java, the Manifest and the Schema builder.
     * 
     * @param projectDescription an existing project description
     * @return the new builders array
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
     * Create an empty EMF Project with default values.
     * 
     * @param projectName the name of the project to create.
     * @return the newly created project
     */
    protected static IProject createEMFProject(String projectName)
    {
        IPath javaSource = new Path(IPath.SEPARATOR + projectName + IPath.SEPARATOR + SOURCE_DIRECTORY);
        IPath projectLocationPath = null;
        IProgressMonitor progressMonitor = new NullProgressMonitor();

        IProject project = null;

        try
        {
            List<IClasspathEntry> classpathEntries = new UniqueEList<IClasspathEntry>();

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
                for (Iterator<IClasspathEntry> i = classpathEntries.iterator(); i.hasNext();)
                {
                    IClasspathEntry classpathEntry = i.next();
                    if (classpathEntry.getPath().isPrefixOf(javaSource))
                    {
                        i.remove();
                    }
                }
                classpathEntries.add(0, sourceClasspathEntry);

                IClasspathEntry jreClasspathEntry = JavaCore.newVariableEntry(new Path(JavaRuntime.JRELIB_VARIABLE), new Path(JavaRuntime.JRESRC_VARIABLE), new Path(JavaRuntime.JRESRCROOT_VARIABLE));
                for (Iterator<IClasspathEntry> i = classpathEntries.iterator(); i.hasNext();)
                {
                    IClasspathEntry classpathEntry = i.next();
                    if (classpathEntry.getPath().isPrefixOf(jreClasspathEntry.getPath()))
                    {
                        i.remove();
                    }
                }
                classpathEntries.add(jreClasspathEntry);
                classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));
            }

            javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]), new SubProgressMonitor(progressMonitor, 1));

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
     * Performs an Organize imports on the generated project.
     * 
     * @param project the generated project
     */
    public static void organizeImports(IProject project)
    {
        final IJavaProject jProject = JavaCore.create(project);

        Runnable runnable = new Runnable()
        {
            public void run()
            {
                OrganizeImportsAction action = new OrganizeImportsAction(GeneratorPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getSite());
                action.run(new StructuredSelection(jProject));
            }
        };
        Display.getDefault().syncExec(runnable);
    }

    /**
     * Save the generated text to a file in the same location as the specified file.
     * 
     * @param generated the generated text to save
     * @param file the original template file
     * @param monitor
     * @param isOverwrite whether the file should be overwritten
     * @throws CoreException exception
     */
    private void saveGenerated(String generated, IFile file, IProgressMonitor monitor, boolean isOverwrite) throws CoreException
    {
        InputStream contents = new ByteArrayInputStream(generated.getBytes());

        if (!file.exists())
        {
            File systemFile = file.getLocation().toFile();
            if (systemFile.exists())
            {
                // check if out of sync
                // not user-friendly : user did not request Refresh...
                file.getParent().refreshLocal(1, monitor);
                file.setContents(contents, true, false, monitor);
            }
            else
            {
                file.create(contents, false, monitor);
            }
        }
        else if (isOverwrite)
        {
            file.setContents(contents, true, false, monitor);
        }
    }

    private JControlModel getJControlModel()
    {
        if (jControlModel == null)
        {
            URL jControlUrl = GeneratorPlugin.getDefault().getBundle().getEntry(JCONTROL_MODEL_NAME);
            jControlModel = new JControlModel();
            jControlModel.initialize(new JDOMFacadeHelper(), jControlUrl.toString());

        }
        return jControlModel;
    }

    /**
     * Use the default JDT code formatter to format the given compilation unit contents.
     * 
     * @param contents the content to format
     * @param filename the name of the file to parse
     * @return the formatted string
     * @throws JETException if the formatting failed
     */
    private String formatCode(String contents, String filename) throws JETException
    {
        // Create a code formatter for this compilation unit
        CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(null);
        IDocument doc = new Document(contents);
        TextEdit edit = codeFormatter.format(CodeFormatter.K_COMPILATION_UNIT, doc.get(), 0, doc.get().length(), 0, null);

        try
        {
            if (edit != null)
            {
                edit.apply(doc);
                contents = doc.get();
            }
            else
            {
                GeneratorPlugin.log("The contents of the document '" + filename + "' can't be formatted", IStatus.ERROR);
            }
        }
        catch (MalformedTreeException e)
        {
            throw new JETException(e);
        }
        catch (BadLocationException e)
        {
            throw new JETException(e);
        }

        return contents;
    }

    /**
     * Perform a Java merge.
     * 
     * @param generatedString
     * @param targetFile
     * @return String
     * @throws CoreException
     */
    private String mergeJava(String generatedString, IFile targetFile) throws CoreException
    {

        JMerger jMerger = new JMerger(getJControlModel());
        jMerger.setSourceCompilationUnit(jMerger.createCompilationUnitForContents(generatedString));
        String newContents = null;
        if (targetFile.exists())
        {
            jMerger.setTargetCompilationUnit(jMerger.createCompilationUnitForInputStream(targetFile.getContents(true)));

        }

        jMerger.merge();
        newContents = jMerger.getTargetCompilationUnitContents();

        return newContents;
    }

    /**
     * Perform a Properties merge.
     * 
     * @param generatedString
     * @param targetFile
     * @param monitor
     * @return String
     * @throws CoreException
     */
    private String mergeProperties(String generatedString, IFile targetFile, IProgressMonitor monitor) throws CoreException
    {

        String newContents = generatedString;
        if (targetFile.exists())
        {
            PropertyMerger propertyMerger = new PropertyMerger();
            propertyMerger.setSourceProperties(generatedString);
            monitor.subTask("Examining old messages");
            String oldProperties = propertyMerger.createPropertiesForInputStream(targetFile.getContents());
            propertyMerger.setTargetProperties(oldProperties);
            monitor.subTask("Preparing new messages");
            propertyMerger.merge();

            String mergedResult = propertyMerger.getTargetProperties();
            if (!mergedResult.equals(oldProperties))
            {
                // If the target is read-only, we can ask the platform to
                // release it, and it may be updated in the process.
                //
                if (targetFile.isReadOnly() && validateEdit(targetFile))
                {
                    propertyMerger.setTargetProperties(propertyMerger.createPropertiesForInputStream(targetFile.getContents()));
                    propertyMerger.merge();
                    mergedResult = propertyMerger.getTargetProperties();
                }
            }
        }

        return newContents;
    }

    /**
     * Check whether the file can be modified
     * 
     * @param file
     * @return true if it is OK
     */
    protected static boolean validateEdit(IFile file)
    {
        return file.getWorkspace().validateEdit(new IFile[] {file}, null).isOK();
    }

    /**
     * Wraps text generation and save in a <code>WorkspaceModifyOperation</code>, and runs this operation in a
     * <code>ProgressMonitorDialog</code>.
     * 
     * @param emitter generates text to save
     * @param arguments arguments to pass to the emitter
     * @param file the original template file
     * @param isOverwrite whether the file should be overwritten
     * @throws JETException
     * @throws CoreException
     */
    private void generate(final JETEmitter emitter, final Object[] arguments, final IFile file, boolean isOverwrite) throws JETException, CoreException
    {
        IProgressMonitor progressMonitor = new NullProgressMonitor();
        String generated = emitter.generate(progressMonitor, arguments);

        boolean overwriteWithGenerated = isOverwrite;

        // Merge and format if it is a Java file
        if ("java".equals(file.getFileExtension()))
        {
            generated = mergeJava(generated, file);
            generated = formatCode(generated, file.getName());
            // Merge generated the overwrite
            overwriteWithGenerated = true;
        }
        // Merge properties file
        if ("properties".equals(file.getFileExtension()))
        {
            generated = mergeProperties(generated, file, progressMonitor);
            // Merge generated the overwrite
            overwriteWithGenerated = true;
        }
        saveGenerated(generated, file, progressMonitor, overwriteWithGenerated);
    }

    /**
     * Apply a JET template to an Object passed as input.
     * 
     * @param input the input object
     * @param templateURI
     * @param outputFile
     * @param isOverwrite whether the file should be overwritten
     * @throws JETException
     * @throws CoreException
     */
    protected void applyTemplate(Object input, String templateURI, IPath outputFile, boolean isOverwrite) throws JETException, CoreException
    {
        this.applyTemplate(new Object[] {input}, templateURI, outputFile, isOverwrite);
    }

    /**
     * Apply a JET template to an Object array passed as input.
     * 
     * @param arguments the input object
     * @param templateURI
     * @param outputFile
     * @param isOverwrite whether the file should be overwritten
     * @throws JETException
     * @throws CoreException
     */
    protected void applyTemplate(Object[] arguments, String templateURI, IPath outputFile, boolean isOverwrite) throws JETException, CoreException
    {
       JETEmitter emitter = createJETEmitter(templateURI);
       IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(outputFile);
       generate(emitter, arguments, file, isOverwrite);
    }
    
    /**
     * Creates the JET Emitter to use for the generation.
     * 
     * @param templateURI the template URI.
     * @return a JET Emitter
     */
    protected abstract JETEmitter createJETEmitter(String templateURI);

    /**
     * Returns a template URI for the given bundle and path relative to this bundle.
     * 
     * @param bundle
     * @param relativePath
     * @return a string URI
     */
    protected String getTemplateURI(Bundle bundle, String relativePath)
    {
        return bundle.getEntry(relativePath).toString();
    }

    /**
     * Creates the given package on the project
     * 
     * @param packageName the name of the package to create if not exists
     * @param project the project where generates
     * @throws CoreException if the generation failed
     */
    protected void createPackage(String packageName, IProject project) throws CoreException
    {
        IPath pathProject = project.getFullPath();
        IPath packagePath = new Path(packageName.replace('.', IPath.SEPARATOR));

        for (int i = 1; i < packagePath.segmentCount() + 1; i++)
        {
            IPath pathPackage = pathProject.append(IPath.SEPARATOR + SOURCE_DIRECTORY + IPath.SEPARATOR + packagePath.removeLastSegments(packagePath.segmentCount() - i));
            IFolder packagefolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(pathPackage);
            if (!(packagefolder.exists()))
            {
                packagefolder.create(true, false, new NullProgressMonitor());
            }
        }
    }
}
