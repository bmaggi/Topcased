/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 **********************************************************************/
package org.topcased.modeler.efs.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;
import org.apache.tools.tar.TarOutputStream;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;

/**
 * Helper class used to manage common tasks used by Topcased EFS
 * 
 * @author Jacques LESCOT
 */
public final class EFSUtils
{
    /**
     * Create a new linked file associated with the given sourceFile contained in the rasFile using a given fileScheme
     * to create the associated URI
     * 
     * @param fileScheme the fileScheme to use to create the URI 
     * @param rasFile the archive model
     * @param sourceFile the source file on which a link should be created
     * @throws CoreException 
     */
    public static void createLink(String fileScheme, IFile rasFile, IFile sourceFile) throws CoreException
    {
        try
        {
            URI uri = new URI(fileScheme, null, "/" + sourceFile.getName(), rasFile.getLocationURI().toString(), null);
            sourceFile.createLink(uri, IResource.REPLACE, null);
        }
        catch (URISyntaxException urise)
        {
            throw new CoreException(
                    new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR, "Error in URL", urise));
        }
    }

    /**
     * Append file contents into an existing Jar output stream
     * 
     * @param out the Jar output stream 
     * @param sourceFile the source File
     * @throws FileNotFoundException 
     * @throws IOException 
     */
    public static void insertFile(JarOutputStream out, IFile sourceFile) throws FileNotFoundException, IOException
    {
        // Create a buffer for reading the files
        byte[] buf = new byte[1024];

        String sourcePath = sourceFile.getLocationURI().getPath();
        String sourceName = sourceFile.getName();

        FileInputStream in = new FileInputStream(sourcePath);

        // Add JAR entry to output stream.
        out.putNextEntry(new JarEntry(sourceName));

        // Transfer bytes from the file to the JAR file
        int len;
        while ((len = in.read(buf)) > 0)
        {
            out.write(buf, 0, len);
        }

        // Complete the entry
        out.closeEntry();
        in.close();
    }

    /**
     * Append file contents into an existing Tar output stream
     * 
     * @param out the Tar output stream 
     * @param sourceFile the source File
     * @throws FileNotFoundException 
     * @throws IOException 
     */
    public static void insertFile(TarOutputStream out, IFile sourceFile) throws FileNotFoundException, IOException
    {
        // Create a buffer for reading the files
        byte[] buf = new byte[1024];

        String sourcePath = sourceFile.getLocationURI().getPath();
        String sourceName = sourceFile.getName();

        FileInputStream in = new FileInputStream(sourcePath);

        // Add TAR entry to output stream.
        TarEntry te = new TarEntry(sourceName);
        te.setModTime(sourceFile.getModificationStamp());
        te.setSize(sourceFile.getLocation().toFile().length());

        out.putNextEntry(te);

        // Transfer bytes from the file to the TAR file
        int len;
        while ((len = in.read(buf)) > 0)
        {
            out.write(buf, 0, len);
        }

        // Complete the entry
        out.closeEntry();
        in.close();
    }
    
    /**
     * Extract contents (domain and diagrams model in general) of the Jar file
     * 
     * @param rasFile the input archive
     * @return the List of files that have been extracted
     */
    public static List<IFile> extractFromJar(IFile rasFile)
    {
        List<IFile> extractedFiles = new ArrayList<IFile>();
        try
        {
            IContainer container = rasFile.getParent();

            // Get the RAS file
            JarInputStream in = new JarInputStream(new FileInputStream(rasFile.getLocationURI().getPath()));

            JarEntry entry = null;
            while ((entry = in.getNextJarEntry()) != null)
            {
                String filename = entry.getName();

                IFile file = container.getFile(new Path(filename));
                if (file.isLinked())
                {
                    file.delete(true, null);
                }

                if (file.exists())
                {
                    throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR,
                            "A file with the name : " + filename + " already exists.", null));
                }
                writeToFile(in, file.getLocation().toFile());
                extractedFiles.add(file);
            }
            // Close the RAS file
            in.close();
            
            // Remove RAS File
            rasFile.delete(true, null);

            // Refresh resource hierarchy
            container.refreshLocal(1, new NullProgressMonitor());
        }
        catch (CoreException e)
        {
            Activator.log(e);
        }
        catch (FileNotFoundException e)
        {
            Activator.log(e);
        }
        catch (IOException e)
        {
            Activator.log(e);
        }
        return extractedFiles;
    }

    /**
     * Extract contents (domain and diagrams model in general) of the Tar file
     * 
     * @param rasFile the input archive
     * @return the List of files that have been extracted
     */
    public static List<IFile> extractFromTar(IFile rasFile)
    {
        List<IFile> extractedFiles = new ArrayList<IFile>();
        try
        {
            IContainer container = rasFile.getParent();

            // Get the RAS file
            TarInputStream in = new TarInputStream(new FileInputStream(rasFile.getLocationURI().getPath()));

            TarEntry entry = null;
            while ((entry = in.getNextEntry()) != null)
            {
                String filename = entry.getName();

                IFile file = container.getFile(new Path(filename));
                if (file.isLinked())
                {
                    file.delete(true, null);
                }

                if (file.exists())
                {
                    throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR,
                            "A file with the name : " + filename + " already exists.", null));
                }
                writeToFile(in, file.getLocation().toFile());
                extractedFiles.add(file);
            }
            // Close the RAS file
            in.close();
            
            // Remove RAS File
            rasFile.delete(true, null);

            // Refresh resource hierarchy
            container.refreshLocal(1, new NullProgressMonitor());
        }
        catch (CoreException e)
        {
            Activator.log(e);
        }
        catch (FileNotFoundException e)
        {
            Activator.log(e);
        }
        catch (IOException e)
        {
            Activator.log(e);
        }
        return extractedFiles;
    }
    
    // Write a given stream in a given File
    private static void writeToFile(InputStream is, File file) throws IOException
    {
        FileOutputStream out = new FileOutputStream(file);
        int c;
        while ((c = is.read()) != -1)
        {
            out.write(c);
        }
        out.close();
    }

    /**
     * Create necessary linked resources if missing
     * 
     * @param archiveFile the archive File
     * @throws CoreException
     */
    public static void restoreLinkedResources(IFile archiveFile) throws CoreException
    {
        IContainer container = archiveFile.getParent();

        URI rasURI = null;

        try
        {
            rasURI = new URI(archiveFile.getFileExtension(), null, "/", archiveFile.getLocationURI().toString(), null);
        }
        catch (URISyntaxException use)
        {
            throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR,
                    "Impossible to reach the archive model.", use));
        }

        IFileStore store = EFS.getStore(rasURI);

        String[] childNames = store.childNames(EFS.NONE, new NullProgressMonitor());
        for (int i = 0; i < childNames.length; i++)
        {
            IResource res = container.findMember(childNames[i]);
            if (res != null && res.exists())
            {
                // TODO When reopening a project, all those warnings are raised. See how it could be filtered (in the Activator class through the ResourceChangeListener)
                Activator.log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, IStatus.ERROR, "The resouce "
                        + res.getFullPath().toString()
                        + " already exists. Could not create the corresponding linked resources.", null));
            }

            try
            {
                IFile child = container.getFile(new Path(childNames[i]));
                URI childURI = new URI(archiveFile.getFileExtension(), null, "/" + childNames[i],
                        archiveFile.getLocationURI().toString(), null);
                child.createLink(childURI, IResource.REPLACE, null);
            }
            catch (URISyntaxException use)
            {
                throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR,
                        "Impossible to create link.", use));
            }
        }
    }
    
    /**
     * Remove the existing linked Resources
     * 
     * @param archiveFile the archive File
     * @throws CoreException
     */
    public static void removeLinkedResources(IFile archiveFile) throws CoreException
    {
        IContainer container = archiveFile.getParent();

        URI rasURI = null;

        try
        {
            rasURI = new URI(archiveFile.getFileExtension(), null, "/", archiveFile.getLocationURI().toString(), null);
        }
        catch (URISyntaxException use)
        {
            throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR,
                    "Impossible to reach the archive model.", use));
        }

        IFileStore store = EFS.getStore(rasURI);

        String[] childNames = store.childNames(EFS.NONE, new NullProgressMonitor());
        for (int i = 0; i < childNames.length; i++)
        {
            IResource res = container.findMember(childNames[i]);
            if (res != null && res.isLinked())
            {
                res.delete(true, new NullProgressMonitor());
            }
        }
    }
    
    /**
     * @return the list of known archive file extension.
     */
    public static List<String> getKnownExtension()
    {
        // TODO Provide extensibility - through an extension point ?
        List<String> knownExtensions = new ArrayList<String>();
        knownExtensions.add("samz");
        knownExtensions.add("samr");
        knownExtensions.add("umlz");
        knownExtensions.add("umlr");
        knownExtensions.add("sysmlz");
        knownExtensions.add("sysmlr");
        return knownExtensions;
    }
}
