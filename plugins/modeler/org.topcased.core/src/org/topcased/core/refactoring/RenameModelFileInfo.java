/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.core.refactoring;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * An info object that holds the information that is passed from the user to the refactoring.
 * 
 * Creation 10 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class RenameModelFileInfo
{
    /** Indicate that the refactoring should update any references into other files */
    public final static int NONE = 0;

    /** Indicate that the refactoring should also update references into other files of the same project */
    public final static int ONLY_CURRENT_PROJECT = 1;

    /** Indicate that the refactoring should also update references into other files in all the projects of the workspace */
    public final static int ALL_PROJECTS = 2;

    // The new name for the model file
    private String newName;

    // The old name of the model file (as selected by the user)
    private String oldName;
    
    // The new extension of the model file
    private String newExtension;

    // The old extension of the model file (as selected by the user)
    private String oldExtension;

    // A list of files that should be renamed
    private List<IFile> filesToRename;

    // Files that have references to the renamed file(s)
    private List<IFile> involvedFiles;

    // The ResourceSet used to update automatically references to the renamed files in others files
    private ResourceSet resourceSet;

    // Indicate the range of refactoring that is expected by the user ()
    private int referencesTypeUpdate;

    /**
     * Get the new name of the file(s)
     * 
     * @return String
     */
    public String getNewName()
    {
        return newName;
    }

    /**
     * Set the new name of the file(s) to rename
     * 
     * @param newName String the new file(s) name
     */
    public void setNewName(final String newName)
    {
        this.newName = newName;
    }

    /**
     * Get the intial name of the file(s) that will be renamed
     * 
     * @return String
     */
    public String getOldName()
    {
        return oldName;
    }

    /**
     * Set the initial name of the file(s) that will be renamed
     * 
     * @param oldName String the old file(s) name
     */
    public void setOldName(final String oldName)
    {
        this.oldName = oldName;
    }

    /**
     * Get the list of File (the selected file and optionally some participants) that should be renamed
     * 
     * @return List all the files that should be renamed
     */
    public List<IFile> getFilesToRename()
    {
        return filesToRename;
    }

    /**
     * Set the list of files that should be renamed. Generally this is the selected file and optionally additional files
     * that should participate to the refactoring
     * 
     * @param filesToRename the list of file that should be renamed
     */
    public void setFilesToRename(final List<IFile> filesToRename)
    {
        this.filesToRename = filesToRename;
    }

    /**
     * Get the list of files that have references to the files that will be renamed. Their content should be updated
     * too.
     * 
     * @return List a list of files that have at least one reference to the file(s) that will be renamed
     */
    public List<IFile> getInvolvedFiles()
    {
        return involvedFiles;
    }

    /**
     * Set the list of files that have references to the files that will be renamed. Their content should be updated
     * too.
     * 
     * @param involvedFiles a list of files that have at least one reference to the file(s) that will be renamed
     */
    public void setInvolvedFiles(final List<IFile> involvedFiles)
    {
        this.involvedFiles = involvedFiles;
    }

    /**
     * Get the ResourceSet used to load the files before the renaming
     * 
     * @return ResourceSet the resourceSet used in the rename refactoring
     */
    public ResourceSet getResourceSet()
    {
        return resourceSet;
    }

    /**
     * Set the ResourceSet to use in the rename refactoring
     * 
     * @param resourceSet the resourceSet used in the rename refactoring
     */
    public void setResourceSet(final ResourceSet resourceSet)
    {
        this.resourceSet = resourceSet;
    }

    /**
     * Get the type of range/deep the rename refactoring should use.
     * 
     * @see #NONE
     * @see #ONLY_CURRENT_PROJECT
     * @see #ALL_PROJECTS
     * 
     * @return int the value of the range/deep the rename refactoring should use.
     */
    public int getReferencesTypeUpdate()
    {
        return referencesTypeUpdate;
    }

    /**
     * Store the type of range/deep the rename refactoring should use.
     * 
     * @see #NONE
     * @see #ONLY_CURRENT_PROJECT
     * @see #ALL_PROJECTS
     * 
     * @param referencesTypeUpdate the range/deep the rename refactoring should use.
     */
    public void setReferencesTypeUpdate(final int referencesTypeUpdate)
    {
        this.referencesTypeUpdate = referencesTypeUpdate;
    }

    /**
     * @return the oldExtension
     */
    public String getOldExtension()
    {
        return oldExtension;
    }

    /**
     * @param oldExtension the oldExtension to set
     */
    public void setOldExtension(String oldExtension)
    {
        this.oldExtension = oldExtension;
    }

    /**
     * @return the newExtension
     */
    public String getNewExtension()
    {
        return newExtension;
    }

    /**
     * @param newExtension the newExtension to set
     */
    public void setNewExtension(String newExtension)
    {
        this.newExtension = newExtension;
    }

}
