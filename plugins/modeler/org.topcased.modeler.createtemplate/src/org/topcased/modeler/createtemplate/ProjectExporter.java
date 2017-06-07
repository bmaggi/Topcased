/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.createtemplate;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

public class ProjectExporter
{

    /** the project in input */
    private final IProject iproject;

    /** the progress monitor if ti provided*/
    private IProgressMonitor progressmonitor;

    public ProjectExporter(IProject currentIproject)
    {
        this(currentIproject, null);
    }

    public ProjectExporter(IProject currentIproject, IProgressMonitor monitor)
    {
        this.iproject = currentIproject;
        this.progressmonitor = monitor;
    }

    
    /**
     * Run the copy process and ask to restart if all is ok.
     * 
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void run() throws IOException
    {
        if (progressmonitor == null)
        {
            progressmonitor = new NullProgressMonitor();
        }
        IPath dropin = getDropinPath();
        progressmonitor.beginTask("Export plugin", 1);
        copyTo(dropin);
        restart();
        progressmonitor.done();
    }
    
    

    private void restart()
    {
        if (MessageDialog.openQuestion(Display.getDefault().getActiveShell(), "Restart", "It's necessary to restart Topcased to register export\nDo you want to restart it? "))
        {
            PlatformUI.getWorkbench().restart();
        }
    }

    private void copyTo(IPath dropin) throws IOException
    {
        File inputFile = new File(iproject.getLocation().toFile().toString());
        File outputFile = new File(dropin.toFile().toString() + File.separator + iproject.getName()+File.separator);
        new File(dropin.toFile().toString() + File.separator + iproject.getName()+File.separator).mkdir();
        Utils.copyFolder(inputFile, outputFile);
    }

    private IPath getDropinPath()
    {
        return new Path(Platform.getInstallLocation().getURL().getFile().toString() + IPath.SEPARATOR + "dropins" + IPath.SEPARATOR);
    }

}
