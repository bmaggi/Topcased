/*******************************************************************************
 * Copyright (c) 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *    Vincent Hemery (Atos Origin) - removing topcased specificity
 *******************************************************************************/
package org.topcased.scripting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.osgi.framework.Bundle;
import org.topcased.scripting.extensions.ScriptProjectNatureManager;

/**
 * An abstract project creation wizard to create projects with example scripts in the user's workspace. Plug-ins which
 * offer meta-model specific scripting support can extend this to offer their example scripts.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public abstract class AbstractSamplesProjectWizard extends Wizard implements INewWizard
{
    /** The list of project natures to apply */
    private List<String> naturesList = null;

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
     * org.eclipse.jface.viewers.IStructuredSelection)
     */
    public void init(IWorkbench workbench, IStructuredSelection selection)
    {
    }

    /**
     * Initialize the wizard by creating the necessary pages. Subclasses may override this method to change the pages.
     */
    public void addPages()
    {
        // add page to select applicable project natures
        IWizardPage page = new ProjectNaturesPage();
        addPage(page);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    @Override
    public boolean performFinish()
    {
        // The following code is adapter from Eclipse Monkey.
        IWorkspace w = ResourcesPlugin.getWorkspace();
        IProject project = w.getRoot().getProject(getProjectName());
        try
        {
            Bundle bundle = getBundle();

            URL url = FileLocator.find(bundle, new Path(getManifestFilePath()), null);
            url = FileLocator.resolve(url);
            Object content = url.getContent();
            InputStream ins = (InputStream) content;
            int count = ins.available();
            BufferedReader in = new BufferedReader(new InputStreamReader(ins));
            char[] cbuf = new char[count];
            in.read(cbuf);
            in.close();
            String[] lines = new String(cbuf).split("\n");
            List<String> manifest = new ArrayList<String>();
            for (int i = 0; i < lines.length; i++)
            {
                String string = lines[i];
                string = string.trim();
                if (string.length() > 0)
                    manifest.add(string);
            }

            if (!project.exists())
            {
                project.create(null);
            }
            project.open(null);
            addSpecificEditorNature(project);

            String errors = "";
            for (Iterator<String> iter = manifest.iterator(); iter.hasNext();)
            {
                try
                {
                    String name = iter.next();
                    String[] words = name.split("/");
                    String pathName = "";
                    IFolder folder = null;
                    for (int i = 0; i < words.length - 1; i++)
                    {
                        String string = words[i];
                        pathName = pathName + string + "/";
                        folder = project.getFolder(pathName);
                        if (!folder.exists())
                            folder.create(IResource.NONE, true, null);
                    }
                    IPath path = new Path("samples/" + name);
                    InputStream stream = FileLocator.openStream(bundle, path, false);
                    IFile file = folder.getFile(words[words.length - 1]);
                    file.create(stream, false, null);
                    stream.close();
                }
                catch (CoreException x)
                {
                    errors += x.toString() + "\n";
                }
                catch (IOException x)
                {
                    errors += x.toString() + "\n";
                }
            }
            if (errors.length() > 0)
            {
                MessageDialog.openInformation(getShell(), getProjectName(), "Errors creating the " + getProjectName() + " project: " + errors);
            }
        }
        catch (CoreException x)
        {
            MessageDialog.openInformation(getShell(), getProjectName(), "Unable to create the " + getProjectName() + " project due to " + x);
        }
        catch (IOException x)
        {
            MessageDialog.openInformation(getShell(), getProjectName(), "Unable to create the " + getProjectName() + " project due to " + x);
        }
        return true;
    }

    /**
     * Makes sure the project has the specific project nature so that it is visible in the views dedicated to the chosen
     * editor.
     * 
     * @param project project to add the nature on
     */
    private void addSpecificEditorNature(IProject project) throws CoreException
    {
        if (naturesList == null)
        {
            naturesList = new ArrayList<String>(ScriptProjectNatureManager.getInstance().getNaturesForEditors().keySet());
        }
        for (String natureId : naturesList)
        {
            if (!project.hasNature(natureId))
            {
                IProjectDescription description = project.getDescription();
                String[] prevNatures = description.getNatureIds();
                String[] newNatures = new String[prevNatures.length + 1];
                System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
                newNatures[prevNatures.length] = natureId;
                description.setNatureIds(newNatures);
                project.setDescription(description, new NullProgressMonitor());
            }
        }
    }

    /**
     * Remove a project nature from the list of natures to apply
     * 
     * @param nature nature to remove
     */
    public void removeNature(String nature)
    {
        if (naturesList == null)
        {
            naturesList = new ArrayList<String>(ScriptProjectNatureManager.getInstance().getNaturesForEditors().keySet());
        }
        naturesList.remove(nature);
    }

    /**
     * Add a project nature to the list of natures to apply
     * 
     * @param nature nature to add
     */
    public void addNature(String nature)
    {
        if (naturesList == null)
        {
            naturesList = new ArrayList<String>(ScriptProjectNatureManager.getInstance().getNaturesForEditors().keySet());
        }
        if (!naturesList.contains(nature))
        {
            naturesList.add(nature);
        }
    }

    /**
     * Returns the bundle from which the sample scripts can be loaded.
     */
    protected abstract Bundle getBundle();

    /**
     * Returns the path (relative to the bundle) where to find the manifest file, a simple text file with the list of
     * sample scripts files to put in the new project.
     */
    protected abstract String getManifestFilePath();

    /**
     * Returns the name of the new project to create.
     */
    protected abstract String getProjectName();
}
