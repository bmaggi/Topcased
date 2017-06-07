/*******************************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.efs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.provider.FileInfo;
import org.eclipse.core.filesystem.provider.FileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.topcased.modeler.efs.internal.Activator;

import de.schlichtherle.io.ArchiveDetector;
import de.schlichtherle.io.DefaultArchiveDetector;
import de.schlichtherle.io.File;
import de.schlichtherle.io.FileOutputStream;
import de.schlichtherle.io.archive.zip.Zip32Driver;

/**
 * File store implementation representing a file inside a Jar RAS (Reusable Asset) file
 * This FileStore only allows files in the archive. It doesn't support directories.
 */
public abstract class AbstractJarFileStore extends FileStore
{
    /**
     * The path of this store within the RAS file.
     */
    private IPath path;

    /**
     * The file store that represents the actual RAS file.
     */
    private IFileStore rootStore;

    /**
     * Creates a new Jar file store
     * 
     * @param rootStore
     * @param path
     */
    public AbstractJarFileStore(IFileStore rootStore, IPath path)
    {
        this.rootStore = rootStore;
        this.path = path.makeRelative();
    }

    /**
     * @return the path
     */
    protected IPath getPath()
    {
        return path;
    }

    /**
     * @return the rootStore
     */
    protected IFileStore getRootStore()
    {
        return rootStore;
    }

    private JarEntry[] childEntries(IProgressMonitor monitor) throws CoreException
    {
        List<JarEntry> entries = new ArrayList<JarEntry>();
        JarInputStream in = null;
        try
        {
            in = new JarInputStream(getRootStore().openInputStream(EFS.NONE, monitor));
            JarEntry current;
            while ((current = in.getNextJarEntry()) != null)
            {
            	entries.add(current);
            }
        }
        catch (IOException ioe)
        {
        	Activator.error(EFS.ERROR_READ, "An error occured when trying to read file " + getName() + " in the archive " + getRootStore().getName(), ioe);
        }
        finally
        {
            try
            {
                if (in != null)
                    in.close();
            }
            catch (IOException e)
            {
                // ignore
            }
        }
        return entries.toArray(new JarEntry[entries.size()]);
    }

    /**
     * @see org.eclipse.core.filesystem.provider.FileStore#childInfos(int, org.eclipse.core.runtime.IProgressMonitor)
     */
    public IFileInfo[] childInfos(int options, IProgressMonitor monitor) throws CoreException
    {
        JarEntry[] entries = childEntries(monitor);
        int entryCount = entries.length;
        IFileInfo[] infos = new IFileInfo[entryCount];
        for (int i = 0; i < entryCount; i++)
        {
            infos[i] = convertJarEntryToFileInfo(entries[i]);
        }
        return infos;
    }

    /**
     * @see org.eclipse.core.filesystem.provider.FileStore#childNames(int, org.eclipse.core.runtime.IProgressMonitor)
     */
    public String[] childNames(int options, IProgressMonitor monitor) throws CoreException
    {
        JarEntry[] entries = childEntries(monitor);
        int entryCount = entries.length;
        String[] names = new String[entryCount];
        for (int i = 0; i < entryCount; i++)
        {
            names[i] = computeName(entries[i]);
        }
        return names;
    }

    /**
     * Computes the simple file name for a given Jar entry.
     * 
     * @param entry the Jar Entry
     * @return the associated fileName within the archive
     */
    private String computeName(JarEntry entry)
    {
        // The entry name is a relative path, with an optional trailing separator
        // We need to strip off the trailing slash, and then take everything after the last separator as the name
        String name = entry.getName();
        int end = name.length() - 1;
        if (name.charAt(end) == '/')
        {
            end--;
        }
        return name.substring(name.lastIndexOf('/', end) + 1, end + 1);
    }

    /**
     * Creates a file info object corresponding to a given Jar entry
     * 
     * @param entry the Jar entry
     * @return The file info for a Jar entry
     */
    private IFileInfo convertJarEntryToFileInfo(JarEntry entry)
    {
        FileInfo info = new FileInfo(computeName(entry));
        info.setLastModified(entry.getTime());
        info.setExists(true);
        info.setDirectory(entry.isDirectory());
        info.setLength(entry.getSize());
        return info;
    }

    /**
     * @see org.eclipse.core.filesystem.provider.FileStore#fetchInfo(int, org.eclipse.core.runtime.IProgressMonitor)
     */
    public IFileInfo fetchInfo(int options, IProgressMonitor monitor) throws CoreException
    {
        JarInputStream in = null;
        try
        {
            in = new JarInputStream(getRootStore().openInputStream(EFS.NONE, monitor));
            String myPath = getPath().toString();
            JarEntry current;
            while ((current = in.getNextJarEntry()) != null)
            {
                String currentPath = current.getName();
                if (myPath.equals(currentPath))
                {
                    return convertJarEntryToFileInfo(current);
                }
            }
        }
        catch (IOException ioe)
        {
        	Activator.error(EFS.ERROR_READ, "An error occured when trying to read file " + getName() + " in the archive " + getRootStore().getName(), ioe);
        }
        finally
        {
            try
            {
                if (in != null)
                    in.close();
            }
            catch (IOException e)
            {
                // Ignore
            }
        }
        // Does not exist
        return new FileInfo(getName());
    }

    /**
     * Finds the Jar entry with the given name in the given archive.
     * 
     * @param name the Jar name
     * @param in the archive where to search
     * @return the found entry and leaves the input stream open positioned at the beginning of the bytes of that entry. Returns null if the entry could not be found.
     * @throws IOException 
     */
    private JarEntry findEntry(String name, JarInputStream in) throws IOException
    {
        JarEntry entry = null;
        while ((entry = in.getNextJarEntry()) != null)
        {
            if (entry.getName().equals(name))
            {
                break;
            }
        }
        return entry;
    }

    /**
     * @see org.eclipse.core.filesystem.provider.FileStore#getName()
     */
    public String getName()
    {
        String name = getPath().lastSegment();
        return name == null ? "" : name; //$NON-NLS-1$
    }

    /**
     * @see org.eclipse.core.filesystem.provider.FileStore#openInputStream(int,
     *      org.eclipse.core.runtime.IProgressMonitor)
     */
    public InputStream openInputStream(int options, IProgressMonitor monitor) throws CoreException
    {
        JarInputStream in = null;
        try
        {
            in = new JarInputStream(getRootStore().openInputStream(EFS.NONE, monitor));

            JarEntry entry = findEntry(getPath().toString(), in);
            if (entry == null)
            {
            	Activator.error(EFS.ERROR_READ, "The file " + getName() + " cannot be found in the archive " + getRootStore().getName(), null);
            }
            if (entry.isDirectory())
            {
            	Activator.error(EFS.ERROR_READ, "The path " + getName() + " isn't a file in the archive " + getRootStore().getName(), null);
            }
            return in;
        }
        catch (IOException ioe)
        {
            try
            {
                if (in != null)
                    in.close();
            }
            catch (IOException e1)
            {
                // ignore secondary failure
            }
        	Activator.error(EFS.ERROR_READ, "An error occured when trying to read file " + getName() + " in the archive " + getRootStore().getName(), ioe);
        }
        // can't get here
        return null;
    }

    /**
     * @see org.eclipse.core.filesystem.provider.FileStore#openOutputStream(int,
     *      org.eclipse.core.runtime.IProgressMonitor)
     */
    public OutputStream openOutputStream(int options, final IProgressMonitor monitor) throws CoreException
    {
        // File.setLenient(false);
        ArchiveDetector detector = new DefaultArchiveDetector(getArchiveFileSuffix(), new Zip32Driver());
        final File jarFile = new File(getRootStore().toString(), detector);
        File entryFile = new File(jarFile, getPath().toString());

        try
        {
            return new FileOutputStream(entryFile)
            {
                /**
                 * @see java.io.FilterOutputStream#close()
                 */
                public void close() throws IOException
                {
                    this.flush();
                    super.close();

                    // Updates archive file in the real file system with the contents of the virtual file system
                    File.update(jarFile);
                    File.umount(jarFile);
                }
            };
        }
        catch (FileNotFoundException fnfe)
        {
        	Activator.error(EFS.ERROR_WRITE, "An error occured when trying to write in file " + getName() + " in the archive " + getRootStore().getName(), fnfe);
        }
        return null;
    }

    /**
     * @see org.eclipse.core.filesystem.provider.FileStore#toURI()
     */
    public URI toURI()
    {
        try
        {
            return new URI(getFileSystemScheme(), null, getPath().makeAbsolute().toString(),
                    getRootStore().toURI().toString(), null);
        }
        catch (URISyntaxException e)
        {
            // should not happen
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the FileSystem scheme to be used
     * 
     * @return the FileSystem scheme as a String
     */
    protected abstract String getFileSystemScheme();

    /**
     * Get the archive file suffix
     * 
     * @return the archive file suffix
     */
    protected abstract String getArchiveFileSuffix();
}
