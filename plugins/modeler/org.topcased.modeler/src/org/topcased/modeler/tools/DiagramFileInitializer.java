/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *    Sebastien Gabel (CS) - Bug fix #2985 & 
 *******************************************************************************/

package org.topcased.modeler.tools;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.DiagramsFactory;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.exceptions.BoundsFormatException;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.l10n.Messages;
import org.topcased.modeler.utils.Utils;

/**
 * This class creates a Diagram from an existing model
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class DiagramFileInitializer
{
    private static final String DIAGRAM_EXTENSION = "di"; //$NON-NLS-1$

    private ResourceSet rsrcSet;

    /**
     * Constructor
     */
    public DiagramFileInitializer()
    {
        this(new ResourceSetImpl());
    }

    /**
     * Constructor
     * 
     * @param resourceSet The ResourceSet to use to create the Diagrams resource. Should be used only when a custom
     *        ResourceSet should be used instead of the default EMF one
     */
    public DiagramFileInitializer(ResourceSet resourceSet)
    {
        this.rsrcSet = resourceSet;
    }

    /**
     * Creates the diagram file for the given existing model
     * 
     * @param root the root EObject associated with the diagram
     * @param diagramId the ID of the diagram to create
     * @param diagramName The diagram name
     * @param initializeContent if <code>true</code>, try to initialize the graphical objects with the existing model
     *        objects
     * @param monitor the progress monitor
     * @throws IOException Throws if the diagram file cannot be written
     */
    public void createDiagram(EObject root, String diagramId, String diagramName, boolean initializeContent, IProgressMonitor monitor) throws IOException
    {
        assert root != null;
        assert diagramId != null;
        assert monitor != null;

        monitor.beginTask(Messages.getString("DiagramFileInitializer.1"), 5); //$NON-NLS-1$

        IFile modelFile = getFile(root.eResource());
        if (modelFile != null && modelFile.exists())
        {
            IContainer container = modelFile.getParent();
            String diagramFileName = modelFile.getName() + DIAGRAM_EXTENSION;

            IFile diagramFile = container.getFile(new Path(diagramFileName));

            // Create the diagram file
            Resource diagramResource = createDiagramFile(root, diagramId, diagramName, diagramFile);
            monitor.worked(1);

            if (initializeContent)
            {
                // Initialize diagrams with existing objects
                importObjects(diagramResource, root, new SubProgressMonitor(monitor, 4));
            }
            // The diagram should be open in all case
            else
            {
                // TODO call in the display thread
                Modeler modeler = openDiagram(diagramResource);

                if (modeler == null)
                {
                    ModelerPlugin.displayDialog(Messages.getString("DiagramFileInitializer.2"), Messages.getString("DiagramFileInitializer.3"), IStatus.ERROR); //$NON-NLS-1$ //$NON-NLS-2$
                }
            }
        }

        monitor.done();

    }

    /**
     * Convert an Package or a Java project into a UML2 model
     * 
     * @param root the root EObject associated with the diagram
     * @param diagramId the ID of the diagram to create
     * @param initializeContent if <code>true</code>, try to initialize the graphical objects with the existing model
     *        objects
     * @param monitor the progress monitor
     * @throws IOException Throws if the diagram file cannot be written
     */
    public void createDiagram(EObject root, String diagramId, boolean initializeContent, IProgressMonitor monitor) throws IOException
    {
        createDiagram(root, diagramId, Messages.getString("DiagramFileInitializer.4"), initializeContent, monitor); //$NON-NLS-1$
    }

    private Resource createDiagramFile(EObject root, String diagramId, String name, IFile diagramFile) throws IOException
    {
        // retrieve the Diagrams and the DiagramInterchange factory singletons
        DiagramsFactory factory = DiagramsFactory.eINSTANCE;
        DiagramInterchangeFactory diFactory = DiagramInterchangeFactory.eINSTANCE;

        // create the EObject of the diagram model
        Diagrams diagrams = factory.createDiagrams();
        Diagram rootDiagram = diFactory.createDiagram();
        EMFSemanticModelBridge emfSemanticModelBridge = diFactory.createEMFSemanticModelBridge();

        // set the properties of the diagrams model
        diagrams.setModel(root);
        diagrams.getDiagrams().add(rootDiagram);

        // set the properties of the Diagram
        rootDiagram.setSize(new Dimension(100, 100));
        rootDiagram.setViewport(new Point(0, 0));
        rootDiagram.setPosition(new Point(0, 0));
        rootDiagram.setName(name);
        rootDiagram.setSemanticModel(emfSemanticModelBridge);

        // set the properties of the SemanticModelBridge
        emfSemanticModelBridge.setElement(root);
        emfSemanticModelBridge.setPresentation(diagramId);

        // create the diagram file and add the created model into
        URI fileURI = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
        Resource resource = rsrcSet.createResource(fileURI);
        resource.getContents().add(diagrams);

        // Save the resource contents to the file system.
        resource.save(Collections.EMPTY_MAP);

        return resource;
    }

    private void importObjects(final Resource diagramResource, final EObject model, final IProgressMonitor monitor)
    {
        Display.getDefault().syncExec(new Runnable()
        {
            /**
             * @see java.lang.Runnable#run()
             */
            public void run()
            {
                syncImportObjects(diagramResource, model, monitor);
            }
        });
    }

    private EObject getActiveRoot(Modeler editor)
    {
        return Utils.getElement(editor.getActiveDiagram());
    }

    /**
     * Execute the import. This method must be called in the UI thread
     * 
     * @param diagramResource the diagram
     * @param model the model
     * @param monitor
     */
    protected void syncImportObjects(final Resource diagramResource, final EObject model, final IProgressMonitor monitor)
    {
        Modeler modeler = openDiagram(diagramResource);

        if (modeler == null)
        {
            ModelerPlugin.displayDialog(Messages.getString("DiagramFileInitializer.5"), Messages.getString("DiagramFileInitializer.6"), IStatus.ERROR); //$NON-NLS-1$ //$NON-NLS-2$
        }
        else
        {
            // Import graphical element
            final Importer importer = new Importer(modeler, getActiveRoot(modeler).eContents());

            GraphicalViewer viewer = (GraphicalViewer) modeler.getAdapter(GraphicalViewer.class);
            GraphicalEditPart target = (GraphicalEditPart) viewer.getEditPartRegistry().get(modeler.getActiveDiagram());

            importer.setTargetEditPart(target);
            Dimension insets = new Dimension(10, 10);
            target.getContentPane().translateToAbsolute(insets);
            importer.setLocation(target.getContentPane().getBounds().getTopLeft().translate(insets));

            try
            {
                importer.run(monitor);
            }
            catch (BoundsFormatException bfe)
            {
                ModelerPlugin.displayDialog(Messages.getString("DiagramFileInitializer.7"), Messages.getString("DiagramFileInitializer.8") + bfe.getMessage(), IStatus.ERROR); //$NON-NLS-1$ //$NON-NLS-2$
            }
            catch (InterruptedException ie)
            {
                ModelerPlugin.displayDialog(Messages.getString("DiagramFileInitializer.9"), Messages.getString("DiagramFileInitializer.10"), IStatus.INFO); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
    }

    private Modeler openDiagram(Resource diagramResource)
    {
        Modeler modeler = null;
        IFile file = getFile(diagramResource);
        if (file != null && file.exists())
        {
            // Open the newly created model
            try
            {
                IEditorPart part = IDE.openEditor(ModelerPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage(), file, true);
                if (part instanceof Modeler)
                {
                    modeler = (Modeler) part;
                }
            }
            catch (PartInitException pie)
            {
                modeler = null;
            }
        }

        return modeler;
    }

    private IFile getFile(Resource resource)
    {
        if (resource != null)
        {
            URI uri = resource.getURI();
            uri = resource.getResourceSet().getURIConverter().normalize(uri);
            String scheme = uri.scheme();
            if ("platform".equals(scheme) && uri.segmentCount() > 1 && "resource".equals(uri.segment(0))) //$NON-NLS-1$ //$NON-NLS-2$
            {
                StringBuffer platformResourcePath = new StringBuffer();
                for (int j = 1; j < uri.segmentCount(); ++j)
                {
                    platformResourcePath.append('/');
                    // Fix #2409 : segments need to be decoded to make a consistency path
                    platformResourcePath.append(URI.decode(uri.segment(j)));
                }
                return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformResourcePath.toString()));
            }
        }
        return null;
    }
}
