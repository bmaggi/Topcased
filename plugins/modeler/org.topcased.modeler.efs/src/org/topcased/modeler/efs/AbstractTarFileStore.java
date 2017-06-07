/*******************************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
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

import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;
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
import de.schlichtherle.io.archive.tar.TarDriver;


/**
 * File store implementation representing a file inside a Tar RAS (Reusable Asset) file
 * This FileStore only allows files in the archive. It doesn't support directories.
 */
public abstract class AbstractTarFileStore extends FileStore
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
     * Creates a new Tar file store
     * 
     * @param rootStore
     * @param path
     */
    public AbstractTarFileStore(IFileStore rootStore, IPath path)
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

    private TarEntry[] childEntries(IProgressMonitor monitor) throws CoreException
    {
        List<TarEntry> entries = new ArrayList<TarEntry>();
        TarInputStream in = null;
        try
        {
            in = new TarInputStream(getRootStore().openInputStream(EFS.NONE, monitor));
            TarEntry current;
            while ((current = in.getNextEntry()) != null)
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
        return entries.toArray(new TarEntry[entries.size()]);
    }

    /**
     * @see org.eclipse.core.filesystem.provider.FileStore#childInfos(int, org.eclipse.core.runtime.IProgressMonitor)
     */
    public IFileInfo[] childInfos(int options, IProgressMonitor monitor) throws CoreException
    {
        TarEntry[] entries = childEntries(monitor);
        int entryCount = entries.length;
        IFileInfo[] infos = new IFileInfo[entryCount];
        for (int i = 0; i < entryCount; i++)
        {
            infos[i] = convertTarEntryToFileInfo(entries[i]);
        }
        return infos;
    }

    /**
     * @see org.eclipse.core.filesystem.provider.FileStore#childNames(int, org.eclipse.core.runtime.IProgressMonitor)
     */
    public String[] childNames(int options, IProgressMonitor monitor) throws CoreException
    {
        TarEntry[] entries = childEntries(monitor);
        int entryCount = entries.length;
        String[] names = new String[entryCount];
        for (int i = 0; i < entryCount; i++)
        {
            names[i] = computeName(entries[i]);
        }
        return names;
    }

    /**
     * Computes the simple file name for a given Tar entry.
     * 
     * @param entry the Tar Entry
     * @return the associated fileName within the archive
     */
    private String computeName(TarEntry entry)
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
     * Creates a file info object corresponding to a given Tar entry
     * 
     * @param entry the Tar entry
     * @return The file info for a Tar entry
     */
    private IFileInfo convertTarEntryToFileInfo(TarEntry entry)
    {
        FileInfo info = new FileInfo(computeName(entry));
        info.setLastModified(entry.getModTime().getTime());
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
        TarInputStream in = null;
        try
        {
            in = new TarInputStream(getRootStore().openInputStream(EFS.NONE, monitor));
            String myPath = getPath().toString();
            TarEntry current;
            while ((current = in.getNextEntry()) != null)
            {
                String currentPath = current.getName();
                if (myPath.equals(currentPath))
                {
                    return convertTarEntryToFileInfo(current);
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
     * Finds the Tar entry with the given name in the given archive.
     * 
     * @param name the Tar name
     * @param in the archive where to search
     * @return the found entry and leaves the input stream open positioned at the beginning of the bytes of that entry. Returns null if the entry could not be found.
     * @throws IOException 
     */
    private TarEntry findEntry(String name, TarInputStream in) throws IOException
    {
        TarEntry entry = null;
        while ((entry = in.getNextEntry()) != null)
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
        TarInputStream in = null;
        try
        {
            in = new TarInputStream(getRootStore().openInputStream(EFS.NONE, monitor));

            TarEntry entry = findEntry(getPath().toString(), in);
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
        ArchiveDetector detector = new DefaultArchiveDetector(getArchiveFileSuffix(), new TarDriver());
        final File tarFile = new File(getRootStore().toString(), detector);
        File entryFile = new File(tarFile, getPath().toString());

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
                    File.update(tarFile);
                    File.umount(tarFile);
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
