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
package org.topcased.modeler.internal;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.widgets.Display;
import org.topcased.modeler.dialogs.InformationDialog;

public class MoveDiagramJob extends Job
{
    private final IFile currentFile;

    public MoveDiagramJob(IFile currentFile)
    {
        super("Clean controlled diagrams ... ");
        this.currentFile = currentFile;
    }

    @Override
    protected IStatus run(IProgressMonitor monitor)
    {
        try
        {
            MoveDiagram move = new MoveDiagram(URI.createURI(getDiagramFile().getLocationURI().toString()), monitor);
            handleDiagnostic(move.move());
            getDiagramFile().getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
        }
        catch (CoreException e)
        {
        }
        finally
        {
            monitor.done();
        }
        return Status.OK_STATUS;
    }

    private IResource getDiagramFile()
    {
        return currentFile;
    }

    /**
     * Display the diagnostic in a MessageDialog.
     * 
     * @param diagnostic the diagnostic
     */
    private void handleDiagnostic(final Diagnostic diagnostic)
    {
        final StringBuilder dialogTitle = new StringBuilder();
        final StringBuilder errorMessage = new StringBuilder();
        dialogTitle.append("Move Report : ");
        Display.getDefault().syncExec(new Runnable()
        {
            public void run()
            {
                if (diagnostic.getChildren().isEmpty())
                {
                    InformationDialog.openInformation(Display.getDefault().getActiveShell(), "information", "no diagrams need to be moved");
                }
                else
                {
                    DiagnosticDialog.open(Display.getDefault().getActiveShell(), dialogTitle.toString(), errorMessage.toString(), diagnostic);
                }
            }
        });
    }

}
