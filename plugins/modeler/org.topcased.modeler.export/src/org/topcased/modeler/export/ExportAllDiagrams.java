/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 * Thibault Landre (Atos Origin) - refactor to extract the exportAllDiagram from ExportAllDiagramsAction
 * Alexia Allanic (Atos Origin) - Add margin to not truncate images
 * 
 ******************************************************************************/
package org.topcased.modeler.export;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.commands.ChangeDiagramPropertiesCommand;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.edit.DiagramEditPart;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.export.internal.Activator;
import org.topcased.modeler.utils.OffscreenEditPartFactory;
import org.topcased.modeler.utils.Utils;

/**
 * A class to export all the diagrams of a given *.*di file into images. The diagram are automatically resized to an
 * optimized size.
 */
public class ExportAllDiagrams
{
    private final IFile file;

    private final String outputDirectoryPath;

    private final String extension;

    private final IImageExporter imageExporter;

    private IWorkbenchWindow workbenchWindow;

    private boolean displayRenamingInformation;

    private static boolean useDisplayRunnable = true;

    public static void setUseDisplayRunnable(boolean use)
    {
        useDisplayRunnable = use;
    }

    public static boolean getUseDisplayRunnable()
    {
        return useDisplayRunnable;
    }

    /**
     * Constructor
     * 
     * @param file the *.*di file where the diagrams are stored, can be null if you use export method with diagrams in
     *        parameter
     * @param outputDirectoryPath the directory in which the images will be saved
     * @param extension the image extension
     * @param imageExporter the image exporter used. The image exporter should be coherent with the file extension
     */
    public ExportAllDiagrams(IFile file, String outputDirectoryPath, String extension, IImageExporter imageExporter)
    {
        this.file = file;
        this.extension = extension;
        this.outputDirectoryPath = outputDirectoryPath;
        this.imageExporter = imageExporter;
        try
        {
            this.workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        }
        catch (IllegalStateException e)
        {
            this.workbenchWindow = null;
            // is normal in batch mode
        }
        this.displayRenamingInformation = true;
    }

    /**
     * Run the export of all diagrams of a *.*di file into images in the given format.
     * 
     * @param pDisplayRenamingInformation
     */
    public void exportDiagramsToImages(boolean pDisplayRenamingInformation)
    {
        this.displayRenamingInformation = pDisplayRenamingInformation;
        exportDiagramsToImages();
    }

    /**
     * Run the export of all diagrams of a *.*di file into images in the given format.
     */
    public void exportDiagramsToImages()
    {
        IRunnableWithProgress op = new IRunnableWithProgress()
        {
            public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException
            {
                if (monitor == null)
                {
                    monitor = new NullProgressMonitor();
                }
                final IProgressMonitor newMonitor = monitor;
                if (useDisplayRunnable)
                {
                    Display.getDefault().syncExec(new Runnable()
                    {
                        public void run()
                        {
                            export(newMonitor);
                            newMonitor.done();
                        }
                    });
                }
                else
                {
                    export(newMonitor);
                    newMonitor.done();

                }
            }
        };
        try
        {
            if (workbenchWindow != null && workbenchWindow.getShell() != null)
            {
                new ProgressMonitorDialog(workbenchWindow.getShell()).run(false, false, op);
                refresh();
            }
            else
            {
                op.run(new NullProgressMonitor());
            }
        }
        catch (InvocationTargetException e)
        {
        }
        catch (InterruptedException e)
        {
        }
    }

    private void refresh()
    {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot rootWS = workspace.getRoot();
        File workspaceF = new File(rootWS.getLocation().toString());
        File folderOutput = new File(outputDirectoryPath);
        if (folderOutput.compareTo(workspaceF) > 0)
        {
            String projectpath = outputDirectoryPath.replace(rootWS.getLocation().toString(), "");
            IResource r = null;
            if (projectpath.lastIndexOf("/") == 0)
            {
                r = rootWS.getProject(projectpath);
            }
            else
            {
                r = rootWS.getFolder(new Path(projectpath));
            }
            if (r != null && r.exists())
            {
                try
                {
                    r.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
                }
                catch (CoreException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getFirstAvailableName(String commonBasis, List<String> existingNames, int cpt)
    {
        if (existingNames.contains(commonBasis + cpt))
        {
            return getFirstAvailableName(commonBasis, existingNames, cpt + 1);
        }
        return commonBasis + cpt;
    }

    /**
     * Get the command stack of the modeler
     * 
     * @param modeler the modeler
     * @return the command stack to use
     */
    private CommandStack getCommandStack(Modeler modeler)
    {
        return (CommandStack) modeler.getAdapter(CommandStack.class);
    }

    /**
     * Resize the given diagram with an optimized dimension.
     * 
     * @param rootEditPart the rootEdit part
     * @param currentDiagram the diagram to resize
     * @param stack the stack to run
     */
    private void resizeDiagram(RootEditPart root, Diagram currentDiagram, CommandStack stack)
    {
        // Execute necessary resize on children nodes
        Utils.optimizelyResizeChildren(root, stack);

        // Get the optimized dimension
        Dimension dim = Utils.getDiagramOptimizedDimension(root, currentDiagram);
        // Add margin to not truncate images
        dim.width += 30;
        dim.height += 30;
        // Create the map of properties for the diagram.
        Map<String, String> newProperties = new HashMap<String, String>();
        newProperties.put(ModelerPropertyConstants.PAGE_FORMAT_NAME, "");
        newProperties.put(ModelerPropertyConstants.PAGE_MARGIN_NAME, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.PAGE_FORMAT_NAME));
        newProperties.put(ModelerPropertyConstants.TOP_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.TOP_MARGIN));
        newProperties.put(ModelerPropertyConstants.BOTTOM_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.BOTTOM_MARGIN));
        newProperties.put(ModelerPropertyConstants.LEFT_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.LEFT_MARGIN));
        newProperties.put(ModelerPropertyConstants.RIGHT_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.RIGHT_MARGIN));
        newProperties.put(ModelerPropertyConstants.ORIENTATION, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.ORIENTATION));
        newProperties.put(ModelerPropertyConstants.PAGE_WIDTH, String.valueOf(dim.width));
        newProperties.put(ModelerPropertyConstants.PAGE_HEIGHT, String.valueOf(dim.height));

        // Create the command to change the property of the diagram
        ChangeDiagramPropertiesCommand changeDiagramPropertiesCommand = new ChangeDiagramPropertiesCommand(currentDiagram, newProperties);

        // execute it
        stack.execute(changeDiagramPropertiesCommand);
    }

    /**
     * Resize the given diagram with an optimized dimension.
     * 
     * @param modeler the current editor
     * @param currentDiagram the diagram to resize
     */
    private void resizeDiagram(Modeler modeler, Diagram currentDiagram)
    {
        CommandStack commandStack = getCommandStack(modeler);
        // Execute necessary resize on children nodes
        Utils.optimizelyResizeChildren(modeler.getRootEditPart(), commandStack);

        // Get the optimized dimension
        Dimension dim = Utils.getDiagramOptimizedDimension(modeler);
        // Add margin to not truncate images
        dim.width += 30;
        dim.height += 30;
        // Create the map of properties for the diagram.
        Map<String, String> newProperties = new HashMap<String, String>();
        newProperties.put(ModelerPropertyConstants.PAGE_FORMAT_NAME, "");
        newProperties.put(ModelerPropertyConstants.PAGE_MARGIN_NAME, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.PAGE_FORMAT_NAME));
        newProperties.put(ModelerPropertyConstants.TOP_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.TOP_MARGIN));
        newProperties.put(ModelerPropertyConstants.BOTTOM_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.BOTTOM_MARGIN));
        newProperties.put(ModelerPropertyConstants.LEFT_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.LEFT_MARGIN));
        newProperties.put(ModelerPropertyConstants.RIGHT_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.RIGHT_MARGIN));
        newProperties.put(ModelerPropertyConstants.ORIENTATION, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.ORIENTATION));
        newProperties.put(ModelerPropertyConstants.PAGE_WIDTH, String.valueOf(dim.width));
        newProperties.put(ModelerPropertyConstants.PAGE_HEIGHT, String.valueOf(dim.height));

        // Create the command to change the property of the diagram
        ChangeDiagramPropertiesCommand changeDiagramPropertiesCommand = new ChangeDiagramPropertiesCommand(currentDiagram, newProperties);

        // execute it
        commandStack.execute(changeDiagramPropertiesCommand);
    }

    /**
     * Export all diagrams of the IFile
     * 
     * @param newMonitor
     */
    private void export(IProgressMonitor newMonitor)
    {
        // Indicate that at least two diagrams with the same name were present
        // in the Diagrams file
        boolean duplicates = false;

        // Then iterates on all the diagrams and export them one by one
        // List<Diagram> findAllDiagrams =
        // DiagramsUtils.findAllDiagrams(modeler.getDiagrams());
        if (file != null)
        {
            ResourceSetImpl resourceSet = new ResourceSetImpl();
            Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);
            EObject eobject = resource.getContents().get(0);
            EcoreUtil.resolveAll(resourceSet);
            if (eobject instanceof Diagrams)
            {
                Diagrams diagrams = (Diagrams) eobject;
                export(newMonitor, diagrams);
            }
        }
        else
        {
            Activator.log(new Status(Status.ERROR, Activator.PLUGIN_ID, "please provide a file in constructor"));
        }

    }

    /**
     * export all the diagrams in image
     * 
     * @param newMonitor , the monitor
     * @param diagrams , the emf element diagrams
     */
    public void export(IProgressMonitor newMonitor, Diagrams diagrams)
    {
        boolean duplicates;
        List<Diagram> findAllDiagrams = DiagramsUtils.findAllDiagrams(diagrams);
        newMonitor.beginTask("Images Export", findAllDiagrams.size());
        duplicates = createDiagramFiles(newMonitor, findAllDiagrams);

        unloadResources(newMonitor, diagrams);

        // Alert the user that file names have been changed to avoid duplicates
        if (duplicates && displayRenamingInformation)
        {
            String message = "During export, at least two diagrams had the same name, created files have been renamed to avoid confusion.";
            if (workbenchWindow != null && workbenchWindow.getShell() != null)
            {
                MessageDialog.openInformation(Activator.getActiveWorkbenchShell(), "Renaming Issue", message);
            }
            else
            {
                Activator.log(new Status(Status.INFO, Activator.PLUGIN_ID, message));
            }
        }
        newMonitor.beginTask("finalizing...", 1);
        newMonitor.worked(1);
    }

    /**
     * Browse all the diagrams and export them
     * 
     * @param newMonitor
     * @param findAllDiagrams
     * @return
     */
    private boolean createDiagramFiles(IProgressMonitor newMonitor, List<Diagram> findAllDiagrams)
    {
        boolean duplicates = false;
        try
        {
            List<String> diagramNames = new ArrayList<String>();
            try
            {
                for (Diagram currentDiagram : findAllDiagrams)
                {
                    String uniqueFileName = encodeFileName(currentDiagram.getName());
                    if (diagramNames.contains(uniqueFileName))
                    {
                        duplicates = true;
                        uniqueFileName = getFirstAvailableName(uniqueFileName, diagramNames, 1);
                    }
                    diagramNames.add(uniqueFileName);
                    exportOneDiagram(uniqueFileName, currentDiagram);
                    newMonitor.worked(1);
                }
            }
            catch (SWTError e)
            {
                String message = "An error occurred while trying to create the output file for diagram ";
                Activator.log(new Exception(message, e));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return duplicates;
    }

    public void exportOneDiagram(String uniqueFileName, Diagram currentDiagram)
    {
        exportOneDiagram(uniqueFileName, currentDiagram, null);
    }

    /**
     * Export the parameter diagram to an image with the given name
     * 
     * @param uniqueFileName the unique file name, if this parameter is null or empty it is replaced by the diagram name
     * @param currentDiagram the current diagram
     * 
     * @return true, if duplicates
     */
    public void exportOneDiagram(String uniqueFileName, Diagram currentDiagram, List<EObject> visibleElements)
    {
        if (currentDiagram == null)
        {
            Activator.log(new Status(Status.ERROR, Activator.PLUGIN_ID, "please provide a diagram"));
            return;
        }
        if (uniqueFileName == null || uniqueFileName.length() == 0)
        {
            uniqueFileName = currentDiagram.getName();
        }
        // if useDisplayRunnable is true then we are not in batch mode
        DiagramEditPart createDiagramEditPart = OffscreenEditPartFactory.getInstance().createDiagramEditPart(currentDiagram, !useDisplayRunnable);

        if (createDiagramEditPart != null)
        {
            GraphicalViewer viewer = (GraphicalViewer) createDiagramEditPart.getRoot().getViewer();
            viewer.flush();
            resizeDiagram(OffscreenEditPartFactory.getInstance().getRootEditPart(), currentDiagram, OffscreenEditPartFactory.getInstance().getCommandStack());
            viewer.flush();
            RootEditPart diagramEP = viewer.getRootEditPart();
            // Remove selection handles
            ((EditPart) diagramEP.getChildren().get(0)).setSelected(EditPart.SELECTED_NONE);
            // Store initial zoom value
            double initialZoomValue = currentDiagram.getZoom();
            // Enforce zoom level as 100%
            ((ScalableFreeformRootEditPart) viewer.getRootEditPart()).getZoomManager().setZoom(1.0);

            FileOutputStream fos = null;
            try
            {
                String ext = "." + extension;
                File outputFile = new File(outputDirectoryPath.concat(File.separator).concat(uniqueFileName).concat(ext));
                new File(outputFile.getParent()).mkdirs();
                outputFile.createNewFile();
                fos = new FileOutputStream(outputFile);
                imageExporter.export(diagramEP, getEditParts(diagramEP, visibleElements), fos, true);
            }
            catch (ExportException e)
            {
                String message = "An error occurred during the export process using ImageExporter";
                Activator.log(new Exception(message, e));
                Activator.displayDialog(null, message, IStatus.ERROR);
            }
            catch (IOException e)
            {
                String message = "An error occurred while trying to create the output file for diagram : " + currentDiagram.getName();
                Activator.log(new Exception(message, e));
                Activator.displayDialog(null, message, IStatus.ERROR);
            }
            catch (Exception e)
            {
                String message = "An error occurred while trying to create the output file for diagram : " + currentDiagram.getName();
                Activator.log(new Exception(message, e));
                Activator.displayDialog(null, message, IStatus.ERROR);
            }
            finally
            {
                // Restore initial zoom level
                // OffscreenEditPartFactory.getInstance().dispose();
                OffscreenEditPartFactory.getInstance().disposeIteration();
                currentDiagram.setZoom(initialZoomValue);
                try
                {
                    if (fos != null)
                    {
                        fos.close();
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            String message = "An error occurred, & create edit part, while trying to create the output file for diagram : " + currentDiagram.getName();
            Activator.log(new Exception(message));
        }
    }

    /**
     * get the edit parts corresponding to the elements given in parameter
     * 
     * @param diagramEP
     * @param visibleElements
     * @return a {@link List} of {@link GraphicalEditPart}
     */
    private List<GraphicalEditPart> getEditParts(RootEditPart diagramEP, List<EObject> visibleElements)
    {
        if (visibleElements == null || visibleElements.isEmpty() || diagramEP == null)
        {
            return null;
        }
        List<GraphicalEditPart> result = new LinkedList<GraphicalEditPart>();
        for (EObject e : visibleElements)
        {
            List<GraphElement> elements = Utils.getGraphElements((GraphElement) diagramEP.getContents().getModel(), e, true);
            if (elements != null)
            {
                for (GraphElement g : elements)
                {
                    EditPartViewer viewer = diagramEP.getViewer();
                    if (viewer != null)
                    {
                        Map<?,?> editPartRegistry = viewer.getEditPartRegistry();
                        if (editPartRegistry != null)
                        {
                            Object o = editPartRegistry.get(g);
                            if (o instanceof GraphicalEditPart)
                            {
                                result.add((GraphicalEditPart) o);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public void unloadResources(IProgressMonitor newMonitor, EObject diagrams)
    {
        if (newMonitor == null)
        {
            newMonitor = new NullProgressMonitor();
        }
        if (diagrams != null)
        {
            ResourceSet resourceSet2 = diagrams.eResource().getResourceSet();
            newMonitor.beginTask("unload", resourceSet2.getResources().size());
            for (int i = resourceSet2.getResources().size() - 1; i >= 0; i--)
            {
                try
                {
                    Resource r = resourceSet2.getResources().get(i);
                    if (r.isLoaded())
                    {
                        r.unload();
                    }
                }
                catch (Exception e)
                {
                    // not very clean but it sometimes occurs
                }
                newMonitor.worked(1);
            }
        }

        // If the modeler was not open : close it
        OffscreenEditPartFactory.getInstance().dispose();
    }

    /**
     * Escape all characters that may result in a wrong file name
     * 
     * @param pathName a file name to encode
     * @return The encoded file name
     */
    private String encodeFileName(String pathName)
    {
        return pathName.replaceAll("[\":*?/|<>\\\\]", "_");
        // return URLEncoder.encode(pathName, "UTF-8").replaceAll("[*]", "_");
    }

    /**
     * get the current root edit part
     * 
     * @return
     */
    public RootEditPart getRootEditPart()
    {
        return OffscreenEditPartFactory.getInstance().getRootEditPart();
    }

}