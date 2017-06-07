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
 *  Thibault Landré (ATOS ORIGIN INTEGRATION) thibault.landre@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.diagrams.validation.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.SimpleSemanticModelElement;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.validation.IModelAnchors;
import org.topcased.modeler.dialogs.DiagnosticCancelDialog;
import org.topcased.modeler.dialogs.InformationDialog;
import org.topcased.modeler.utils.Utils;

/**
 * This class will check that all the GraphEdge of a model have valid anchors. If anchors are not valid, it will try to
 * restore them, otherwise will delete them
 * 
 * @author tlandre
 * 
 */
public class MissingAnchorsJob extends Job
{

    private IFile currentFile;

    private URI currentFileUri;

    private ResourceSet resourceSet;

    private Resource diResource;

    private Set<GraphEdge> missingAnchorEdge = new HashSet<GraphEdge>();

    private static Map<String, IModelAnchors> modelAnchors = getModelAnchors();
    
    
    /**
     * Gets the diagram keepers from the moveElementFilter extension point.
     * 
     * @return the diagram keepers
     */
    private static Map<String, IModelAnchors> getModelAnchors()
    {
        Map<String, IModelAnchors> result = new HashMap<String, IModelAnchors>();
        final String extPoint = "missingAnchors";
        IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.topcased.modeler.diagrams.validation", extPoint);
        if (elements.length > 0)
        {
            for (IConfigurationElement element : elements)
            {
                try
                {
                    String type = element.getAttribute("type");
                    if (type != null)
                    {
                        result.put(type, (IModelAnchors) element.createExecutableExtension("modelanchor"));
                    }
                }
                catch (CoreException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


    public MissingAnchorsJob(IFile currentFile)
    {
        super("Missing Anchors ... ");
        this.currentFile = currentFile;
    }

    protected final URI getCurrentFileUri()
    {
        if (currentFileUri == null)
        {
            currentFileUri = URI.createPlatformResourceURI(currentFile.getFullPath().toString(), true);
        }
        return currentFileUri;
    }

    @Override
    protected IStatus run(IProgressMonitor monitor)
    {
        try
        {
            monitor.beginTask("Correct Anchors", 4);

            monitor.subTask("Open resources...");
            resourceSet = new ResourceSetImpl();
            diResource = resourceSet.getResource(getCurrentFileUri(), true);
            EcoreUtil.resolveAll(diResource);
            monitor.worked(1);

            monitor.subTask("Find missing anchors...");
            retrieveMissingAnchors();
            monitor.worked(2);

            if (confirm())
            {
                monitor.subTask("Update edge...");
                try
                {
                    Diagnostic diag = updateGraphEdge();
                    displayDiagnosticDialog("Summary", diag);
                }
                catch (IOException e)
                {
                    displayInformationDialog(null, e.getLocalizedMessage());
                }
            }

            monitor.worked(3);
            monitor.subTask("Close resources...");
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
            monitor.worked(4);

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

    private Diagnostic updateGraphEdge() throws IOException
    {

        BasicDiagnostic rootDiag = new BasicDiagnostic("org.topcased.modeler", 0, "Those modifications have been done on the model.", new Object[] {null});

        Set<String> impactedDiagram = new HashSet<String>();
        Set<Resource> modifiedResources = new HashSet<Resource>();
        Set<GraphEdge> graphEdgesToDelete = new HashSet<GraphEdge>();

        for (GraphEdge graphEdge : missingAnchorEdge)
        {
            EObject eObject = Utils.getElement(graphEdge);
            Diagram currentDiagram = Utils.getDiagram(graphEdge);
            if (eObject != null)
            {
                if (eObject.eIsProxy())
                {
                    graphEdgesToDelete.add(graphEdge);
                }

                else
                {
                    GraphElement sourceGraphElement = Utils.getGraphElement(currentDiagram, getSourceEObject(eObject), true);
                    GraphElement targetGraphElement = Utils.getGraphElement(currentDiagram, getTargetEObject(eObject), true);

                    if (sourceGraphElement != null && targetGraphElement != null)
                    {
                        fixGraphEdgeAnchor(graphEdge, sourceGraphElement, targetGraphElement);
                        // Add the containing diagram to the list of impacted diagram
                        impactedDiagram.add(getImpactedDiagramText(currentDiagram, false));
                        // Add the resource to the list of resource to save
                        modifiedResources.add(graphEdge.eResource());
                    }
                    // if source or target elements doesn't exist anymore in the diagram, the edge has to be deleted as
                    // well.
                    else
                    {
                        graphEdgesToDelete.add(graphEdge);
                    }
                }
            }
            else
            {
                // If we are in the case of a SimpleSemantifModelElement, we don't have a metamodel element to retrieve
                // the source/target.
                // The connection has to be restore by hand
                if (graphEdge.getSemanticModel() instanceof SimpleSemanticModelElement)
                {
                    graphEdgesToDelete.add(graphEdge);
                }
            }

        }

        // Delete the graphEdge that has to be deleted.
        // Add the corresponding diagram to the impacted diagrams list.
        for (GraphEdge graphEdge : graphEdgesToDelete)
        {
            EObject eObject = graphEdge.eContainer();
            if (eObject instanceof GraphElement)
            {
                GraphElement graphElement = (GraphElement) eObject;
                if(graphEdge.eResource() != null){
                    // Add the resource to the list of resource to save
                    modifiedResources.add(graphEdge.eResource());
                }
                // Add the containing diagram to the list of impacted diagram
                impactedDiagram.add(getImpactedDiagramText(Utils.getDiagram(graphEdge), true));
                
                // Remove the graphEdge from the parent element
                graphElement.getContained().remove(graphEdge);
                
                
                if(graphEdge.getAnchor() != null){
                    // Remove the graphEdge from the first connected graphElement if any
                    if(graphEdge.getAnchor().size() > 0)
                    {
                        graphEdge.getAnchor().get(0).getGraphElement().getAnchorage().remove(graphEdge);
                    }
                    // Remove the graphEdge from the second connected graphElement if any
                    if(graphEdge.getAnchor().size() > 1){
                        graphEdge.getAnchor().get(1).getGraphElement().getAnchorage().remove(graphEdge);      
                    }
                    // Remove the anchors from the graphEdge
                    graphEdge.getAnchor().removeAll(graphEdge.getAnchor());
                }
                
                
                
            }
        }

        // Save modified resources
        for (Resource resource : modifiedResources)
        {
            resource.save(null);
        }

        // Display impactedDiagram
        for (String string : impactedDiagram)
        {
            rootDiag.add(createBasicDiagnostic(string));
        }

        return rootDiag;
    }

    /**
     * Get the source EObject of the edge
     * @param edgeEObject the edge EObject
     * @return the source EObject or null if none found
     */
    protected EObject getSourceEObject(EObject edgeEObject)
    {
        IModelAnchors modelAnchor = getModelAnchor(edgeEObject);
        if(modelAnchor != null)
        { 
            return modelAnchor.getSourceEObject(edgeEObject);
        }
        return null;
    }
    
    private IModelAnchors getModelAnchor(EObject edgeEObject){
        if(modelAnchors.get(edgeEObject.eClass().getName())!=null){
            return modelAnchors.get(edgeEObject.eClass().getName());
        }
        else
        {
            for(EClass eClass : edgeEObject.eClass().getEAllSuperTypes())
            {
                if(modelAnchors.get(eClass.getName())!=null){
                    return modelAnchors.get(eClass.getName());
                }
            }
        }
        return null;
    }
    
    /**
     * Get the target EObject of the edge
     * @param edgeEObject the edge EObject
     * @return the target EObject or null if none found
     */
    protected EObject getTargetEObject(EObject edgeEObject)
    {
        IModelAnchors modelAnchor =  getModelAnchor(edgeEObject);
        if(modelAnchor != null)
        { 
            return modelAnchor.getTargetEObject(edgeEObject);
        }
        return null;
    }
    
    
    /**
     * Update the properties of the GraphEdge in order to restore correct anchor values.
     * @param graphEdge the graphEdge to fix
     * @param sourceGraphElement the graphical source element
     * @param targetGraphElement the graphical target element
     */
    private void fixGraphEdgeAnchor(GraphEdge graphEdge, GraphElement sourceGraphElement, GraphElement targetGraphElement)
    {
        EStructuralFeature sourceFeature = graphEdge.eClass().getEStructuralFeature("anchor");
        if (sourceFeature.isChangeable())
        {
            if (sourceFeature.isMany())
            {
                EList<EObject> sourceList = Utils.getOwnerList(graphEdge, sourceFeature);
                Collection<EObject> newValue = new ArrayList<EObject>();
                if (sourceList != null)
                {
                    newValue.addAll(sourceList);
                }
                newValue.addAll(sourceGraphElement.getAnchorage());
                newValue.addAll(targetGraphElement.getAnchorage());

                graphEdge.eSet(sourceFeature, newValue);
            }
            else
            {
                // TODO : if necessary.
            }
        }
    }

    /**
     * Format the information on the impacted diagrams for user readability
     * 
     * @param diagram the diagram to format
     * @return a readable information
     */
    private String getImpactedDiagramText(Diagram diagram, boolean needReview)
    {
        StringBuilder builder = new StringBuilder();
        if(needReview)
        {
           builder.append("Need User Review - ");
        }
        builder.append("Diagram : \"");
        builder.append(diagram.getName());
        builder.append("\" in resource : \"");
        builder.append(diagram.eResource().getURI());
        builder.append("\"");
        return builder.toString();
    }

    /**
     * Start method to retrieve the missing Anchors. It will search deeply in all the resources.
     */
    private void retrieveMissingAnchors()
    {
        // get the global Diagrams
        EObject o = diResource.getContents().get(0);

        if (o instanceof Diagrams)
        {
            Diagrams diagrams = (Diagrams) o;
            getDiagramsMissingAnchor(diagrams);
        }

    }

    /**
     * Recursive method to cover all resources and diagrams.
     * 
     * @param diagrams
     */
    private void getDiagramsMissingAnchor(Diagrams diagrams)
    {

        for (Diagram diagram : diagrams.getDiagrams())
        {
            getDiagramMissingAnchor(diagram);
        }
        for (Diagrams diagrams2 : diagrams.getSubdiagrams())
        {
            getDiagramsMissingAnchor(diagrams2);
        }
    }

    /**
     * Recursive method to identify all problematic edges.
     * 
     * @param diagram the diagram to verify
     */
    private void getDiagramMissingAnchor(Diagram diagram)
    {
        for (DiagramElement diagramElement : diagram.getContained())
        {
            if (diagramElement instanceof GraphEdge)
            {
                GraphEdge graphEdge = (GraphEdge) diagramElement;
                if (graphEdge.getAnchor() == null || graphEdge.getAnchor().size() != 2)
                {
                    missingAnchorEdge.add(graphEdge);
                }
            }
            if (diagramElement instanceof Diagram)
            {
                getDiagramMissingAnchor(diagram);
            }
        }
    }

    /**
     * Ask for a confirmation if problematic edges have been founded otherwise display
     * "All edges are valid in the diagrams."
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
                if (!missingAnchorEdge.isEmpty())
                {
                    BasicDiagnostic rootDiag = new BasicDiagnostic(Diagnostic.WARNING, "org.topcased.modeler", 0, "Those actions will be done to fix unvalid edge :", new Object[] {null});

                    if (!missingAnchorEdge.isEmpty())
                    {
                        BasicDiagnostic diag = createBasicDiagnostic("All of these elements objects are not valid (anchor are missing)");
                        for (GraphEdge edge : missingAnchorEdge)
                        {
                            EObject eObject = Utils.getElement(edge);
                            if (eObject != null && eObject.eResource() != null)
                            {
                                diag.add(createBasicDiagnostic("Edge " + eObject + " (" + eObject.eResource().getURI() + ")"));
                            }
                            else
                            {
                                diag.add(createBasicDiagnostic("Edge " + edge));
                            }

                        }
                        rootDiag.add(diag);
                    }
                    int result = DiagnosticCancelDialog.open(Display.getDefault().getActiveShell(), "Update Edge ?", "", rootDiag);
                    if (result == Dialog.OK)
                    {
                        resultAtomicBoolean.set(true);
                    }
                }
                else
                {
                    InformationDialog.openInformation(Display.getDefault().getActiveShell(), null, "All edges are valid in the diagrams.");
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

}
