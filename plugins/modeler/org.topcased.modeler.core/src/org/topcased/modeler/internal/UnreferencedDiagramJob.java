/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (ATOS ORIGIN INTEGRATION) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.internal;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.SemanticModelBridge;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.dialogs.DiagnosticCancelDialog;
import org.topcased.modeler.dialogs.InformationDialog;

/**
 * A job performing a clean of unreferenced diagrams
 * 
 * @author Mathieu Velten
 * 
 */
public class UnreferencedDiagramJob extends Job
{
    private static final String EXTENSION_BAK = "bak";

    private final IFile currentFile;

    private final URI currentFileUri;

    private ResourceSet resourceSet;

    private Resource diResource;

    Set<Diagrams> unreferencedDiagrams = new HashSet<Diagrams>();

    Set<Diagrams> toBeFixedDiagrams = new HashSet<Diagrams>();

    Set<Diagram> unreferencedDiagram = new HashSet<Diagram>();

    Set<Resource> modifiedResources = new HashSet<Resource>();

    public UnreferencedDiagramJob(IFile currentFile)
    {
        super("Remove unreferenced diagrams ... ");
        this.currentFile = currentFile;
        this.currentFileUri = URI.createPlatformResourceURI(currentFile.getFullPath().toString(), true);
    }

    @Override
    protected IStatus run(IProgressMonitor monitor)
    {
        try
        {
            monitor.beginTask("Clean unreferenced diagrams", 4);

            monitor.subTask("Open resources...");
            resourceSet = new ResourceSetImpl();
            diResource = resourceSet.getResource(currentFileUri, true);
            EcoreUtil.resolveAll(diResource);
            monitor.worked(1);

            monitor.subTask("Find unreferenced diagrams...");
            retrieveUnreferenced();
            monitor.worked(1);

            if (confirm())
            {
                monitor.subTask("Remove unreferenced diagrams...");
                try
                {
                    Diagnostic diag = removeUnreferenced();
                    displayDiagnosticDialog("Summary", diag);
                }
                catch (IOException e)
                {
                    displayInformationDialog(null, e.getLocalizedMessage());
                }
            }

            monitor.worked(2);

            for (int i = 0; i < resourceSet.getResources().size(); i++)
            {
                try
                {
                    resourceSet.getResources().get(i).unload();
                }
                catch (Exception e)
                {
                }
            }
            currentFile.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
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

    /**
     * ask for a confirmation if unreferenced diagrams have been founded otherwise display
     * "No unreferenced diagram founded."
     * 
     * @return the result of the confirmation or false if nothing was founded
     */
    private boolean confirm()
    {
        final AtomicBoolean resultAtomicBoolean = new AtomicBoolean(false);
        Display.getDefault().syncExec(new Runnable()
        {
            public void run()
            {

                if (!unreferencedDiagram.isEmpty() || !unreferencedDiagrams.isEmpty() || !toBeFixedDiagrams.isEmpty())
                {
                    BasicDiagnostic rootDiag = new BasicDiagnostic(Diagnostic.WARNING, "org.topcased.modeler", 0, "Those actions will be done to fix unreferenced elements :", new Object[] {null});

                    if (!unreferencedDiagram.isEmpty())
                    {
                        BasicDiagnostic diag = createBasicDiagnostic("all of these diagram objects are not valid (reference to non existing elements)");
                        for (Diagram diagram : unreferencedDiagram)
                        {
                            diag.add(createBasicDiagnostic("Delete Diagram " + diagram.getName() + " (" + getURI(diagram) + ")"));
                        }
                        rootDiag.add(diag);
                    }
                    if (!unreferencedDiagrams.isEmpty())
                    {
                        BasicDiagnostic diag = createBasicDiagnostic("all the diagram in these diagrams objects are not valid (reference to non existing elements)");
                        for (Diagrams diagrams : unreferencedDiagrams)
                        {
                            diag.add(createBasicDiagnostic("Delete Diagrams object (" + getURI(diagrams) + ")"));
                        }
                        rootDiag.add(diag);
                    }
                    if (!toBeFixedDiagrams.isEmpty())
                    {
                        BasicDiagnostic diag = createBasicDiagnostic("all of these diagrams objects are not valid (reference to non existing elements)");
                        for (Diagrams diagrams : toBeFixedDiagrams)
                        {
                            diag.add(createBasicDiagnostic("Fix Diagrams object (" + getURI(diagrams) + ")"));
                        }
                        rootDiag.add(diag);
                    }
                    int result = DiagnosticCancelDialog.open(Display.getDefault().getActiveShell(), "Remove Diagrams ?", "", rootDiag);
                    if (result == Dialog.OK)
                    {
                        resultAtomicBoolean.set(true);
                    }
                }
                else
                {
                    InformationDialog.openInformation(Display.getDefault().getActiveShell(), null, "No unreferenced diagram founded.");
                    resultAtomicBoolean.set(false);
                }
            }
        });

        return resultAtomicBoolean.get();
    }

    private BasicDiagnostic createBasicDiagnostic(String message)
    {
        return createBasicDiagnostic(message, null);
    }

    private BasicDiagnostic createBasicDiagnostic(String message, String subMessage)
    {
        BasicDiagnostic basicDiagnostic = new BasicDiagnostic(Diagnostic.INFO, "org.topcased.modeler", 0, message, new Object[] {null});
        if (subMessage != null)
        {
            basicDiagnostic.add(new BasicDiagnostic(Diagnostic.INFO, "org.topcased.modeler", 0, subMessage, new Object[] {null}));
        }
        return basicDiagnostic;
    }

    private String getURI(EObject eobject)
    {
        return eobject.eResource().getURI().toString() + "#" + eobject.eResource().getURIFragment(eobject);
    }

    private void displayDiagnosticDialog(final String title, final Diagnostic diag)
    {
        Display.getDefault().syncExec(new Runnable()
        {
            public void run()
            {
                DiagnosticDialog.open(Display.getDefault().getActiveShell(), title, "", diag);
            }
        });
    }

    private void displayInformationDialog(final String title, final String message)
    {
        Display.getDefault().syncExec(new Runnable()
        {
            public void run()
            {
                InformationDialog.openInformation(Display.getDefault().getActiveShell(), title, message);
            }
        });
    }

    /**
     * do a backup, remove unreferenced diagrams and rollback if a problem is encounter.
     * 
     * @throws IOException
     */
    private Diagnostic removeUnreferenced() throws IOException
    {

        // test for read-only resources
        HashSet<Resource> readOnlyResources = new HashSet<Resource>();

        for (Resource r : modifiedResources)
        {
            Map<String, ? > attributes = resourceSet.getURIConverter().getAttributes(r.getURI(), null);
            Object readOnly = attributes.get(URIConverter.ATTRIBUTE_READ_ONLY);

            if (readOnly instanceof Boolean)
            {
                if ((Boolean) readOnly)
                {
                    readOnlyResources.add(r);

                }
            }
        }

        if (!readOnlyResources.isEmpty())
        {
            String message = "At least one resource which needs to be modified is read-only, please check your rights on those resources and try again.\n\nRead-only resources :\n";
            for (Resource r : readOnlyResources)
            {
                message += r.getURI().lastSegment() + "\n";
            }
            throw new IOException(message);
        }

        try
        {
            backup();
        }
        catch (Exception e)
        {
            throw new IOException("An error occurs during the backup.\n\n" + e.getLocalizedMessage());
        }

        BasicDiagnostic rootDiag = new BasicDiagnostic("org.topcased.modeler", 0, "Those modifications have been done on the model.", new Object[] {null});

        // remove the unreferenced Diagram(s) from their container
        for (Diagram diagram : unreferencedDiagram)
        {
            removeEObjectFromContainer(diagram);
            rootDiag.add(createBasicDiagnostic("Deleted Diagram : " + diagram.getName() + "(" + getURI(diagram) + ")"));
        }
        for (Diagrams diagrams : unreferencedDiagrams)
        {
            removeEObjectFromContainer(diagrams);
            rootDiag.add(createBasicDiagnostic("Deleted Diagrams object (" + getURI(diagrams) + ")"));
        }

        // try to fix Diagrams
        for (Diagrams diagrams : toBeFixedDiagrams)
        {
            fixDiagrams(diagrams);
            rootDiag.add(createBasicDiagnostic("Fixed Diagrams object (" + getURI(diagrams) + ")"));
        }

        try
        {
            // save resources and remove files if there are empty or the root element is an unreferenced Diagrams
            Iterator<Resource> it = modifiedResources.iterator();
            while (it.hasNext())
            {
                Resource r = it.next();
                if (r.getContents().isEmpty() || unreferencedDiagrams.contains(r.getContents().get(0)))
                {
                    it.remove();
                    r.delete(null);
                    rootDiag.add(createBasicDiagnostic("Deleted resource : " + r.getURI().lastSegment() + " a backup file has been created : " + r.getURI().lastSegment() + "." + EXTENSION_BAK));
                }
                else
                {
                    r.save(null);
                    rootDiag.add(createBasicDiagnostic("Modified resource : " + r.getURI().lastSegment() + " a backup file has been created : " + r.getURI().lastSegment() + "." + EXTENSION_BAK));
                }
            }

        }
        catch (Throwable e)
        {
            try
            {
                rollback();
            }
            catch (Exception e2)
            {
            }
            throw new IOException("An error occurs during the saving.\n\n" + e.getLocalizedMessage());
        }

        return rootDiag;
    }

    private void fixDiagrams(Diagrams diagrams)
    {
        // check if this is a root diagrams
        Resource associatedDiResource = diagrams.eResource();
        EObject rootDiagrams = associatedDiResource.getContents().get(0);

        if (diagrams.equals(rootDiagrams))
        {
            // set model to the root element of the associated uml resource
            URI associatedDiURI = associatedDiResource.getURI();
            String fileExtension = associatedDiURI.fileExtension();
            fileExtension = fileExtension.replace("di", "");
            Resource associatedUmlResource = resourceSet.getResource(associatedDiURI.trimFileExtension().appendFileExtension(fileExtension), true);
            if (associatedDiResource != null)
            {
                EList<EObject> contents = associatedUmlResource.getContents();
                if (!contents.isEmpty())
                {
                    diagrams.setModel(contents.get(0));
                    return;
                }
            }
        }
        diagrams.setModel(null);
    }

    /**
     * save all the modified resources in backup files
     * 
     * @throws IOException
     */
    private void backup() throws Exception
    {
        for (Resource r : modifiedResources)
        {
            URI uri = r.getURI();
            if (uri.isPlatform())
            {
                String platformString = uri.toPlatformString(true);
                IResource iResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);

                if (iResource != null)
                {
                    IPath newPath = iResource.getFullPath().addFileExtension(EXTENSION_BAK);
                    iResource.copy(newPath, true, null);
                }
                else
                {
                    throw new Exception(r.getURI().lastSegment() + " does not exist.");
                }
            }
            else
            {
                throw new Exception(r.getURI().lastSegment() + " is not a platform resource.");
            }
        }

    }

    /**
     * copy back the backup files at their original path
     * 
     * @throws IOException
     */
    private void rollback() throws Exception
    {
        for (Resource r : modifiedResources)
        {
            URI uri = r.getURI();
            if (uri.isPlatformResource())
            {
                String platformString = uri.toPlatformString(true);

                // delete the modified file
                IResource modifiedResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
                if (modifiedResource != null)
                {
                    // save the path for the final move
                    IPath originalPath = modifiedResource.getFullPath();
                    modifiedResource.delete(true, null);

                    IResource bakResource = ResourcesPlugin.getWorkspace().getRoot().findMember(originalPath.addFileExtension(EXTENSION_BAK));
                    if (bakResource != null)
                    {
                        bakResource.move(originalPath, true, null);
                    }

                }
            }
        }
    }

    private static void removeEObjectFromContainer(EObject o)
    {
        if (o instanceof InternalEObject)
        {
            InternalEObject internalEObject = (InternalEObject) o;
            if (internalEObject.eContainer() != null)
            {
                internalEObject.eBasicRemoveFromContainer(null);
            }
        }
    }

    private void addAllSubDiagramsToUnreferenced(Diagrams diagrams)
    {
        for (Diagram d : diagrams.getDiagrams())
        {
            unreferencedDiagram.add(d);
        }
        for (Diagrams d : diagrams.getSubdiagrams())
        {
            unreferencedDiagrams.add(d);
            addAllSubDiagramsToUnreferenced(d);
        }
    }

    private void retrieveUnreferenced()
    {
        // get the global Diagrams
        EObject o = diResource.getContents().get(0);

        if (o instanceof Diagrams)
        {
            Diagrams diagrams = (Diagrams) o;
            findUnreferencedFromDiagrams(diagrams);
        }

        retrieveModifiedResources();
    }

    private void retrieveModifiedResources()
    {
        for (Diagram diagram : unreferencedDiagram)
        {
            modifiedResources.add(diagram.eResource());
        }
        for (Diagrams diagrams : unreferencedDiagrams)
        {
            modifiedResources.add(diagrams.eResource());
        }
        for (Diagrams diagrams : toBeFixedDiagrams)
        {
            modifiedResources.add(diagrams.eResource());
        }
    }

    /**
     * find unreferenced Diagram(s) and add them to the sets
     * 
     * @param diagrams The diagrams where to look for unreferenced Diagram(s)
     * @return true if all the sub-Diagrams and the Diagram-s of this Diagrams are unreferenced
     */
    private boolean findUnreferencedFromDiagrams(Diagrams diagrams)
    {

        boolean allUnreferenced = true;

        // Diagrams is ok, check sub-Diagrams
        for (Diagrams subDiagrams : diagrams.getSubdiagrams())
        {
            if (!findUnreferencedFromDiagrams(subDiagrams))
            {
                allUnreferenced = false;
            }
        }

        // now check the Diagram-s of Diagrams

        for (Diagram d : diagrams.getDiagrams())
        {
            SemanticModelBridge sm = d.getSemanticModel();
            if (sm instanceof EMFSemanticModelBridge)
            {
                EMFSemanticModelBridge emfsm = (EMFSemanticModelBridge) sm;

                EObject element = emfsm.getElement();

                if (element != null && element.eIsProxy())
                {
                    // the proxy can't be resolved => it is an unreferenced Diagrams
                    unreferencedDiagram.add(d);
                }
                else
                {
                    // at least one Diagram proxy have been resolved
                    allUnreferenced = false;
                }
            }
        }

        EObject model = diagrams.getModel();

        if (allUnreferenced)
        {
            addAllSubDiagramsToUnreferenced(diagrams);
            unreferencedDiagrams.add(diagrams);
        }
        else if (model != null && model.eIsProxy())
        {
            // the proxy can't be resolved => Model proxy has to be fixed
            toBeFixedDiagrams.add(diagrams);
        }

        return allUnreferenced;
    }

}
