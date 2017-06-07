/*******************************************************************************
 * Copyright (c) 2009 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Jose Alfredo Serrano (Anyware Technologies) - initial API and implementation
 *      Jacques LESCOT (Anyware Technologies) - Improve Diagrams Explorer generation
 ******************************************************************************/
package org.topcased.modeler.export.html.internal;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.edit.DiagramEditPart;
import org.topcased.modeler.export.ExportAllDiagrams;
import org.topcased.modeler.export.ExporterManager;
import org.topcased.modeler.export.IImageExporter;
import org.topcased.modeler.export.html.HTMLPlugin;
import org.topcased.modeler.export.html.ServicesManager;
import org.topcased.modeler.export.html.internal.generators.DiagramDocumentationFileGenerator;
import org.topcased.modeler.export.html.internal.generators.DiagramFileGenerator;
import org.topcased.modeler.export.html.internal.generators.DocumentationFileGenerator;
import org.topcased.modeler.export.html.internal.generators.OutlineFileGenerator;

/**
 * Export runner. See the generate method for further information.
 * 
 * @author <a href="mailto:jose.alfredo.serrano@anyware-tech.com">Jose Alfredo SERRRANO</a>
 * 
 */
public class Export2HTML
{
    private static String[] specialChar = {"\\", "/", ":",  "*",  "?", "|", "<", ">"};
    
    private static String CHAR_REPLACEMENT = "_";
    
    /**
     * Generate folders, images and html files of the selected *di model.
     * 
     * @param iFile The selected *di file.
     * @param iFolder The root folder where files and images will be generated.
     */
    public void generate(final IFile iFile, final IContainer iFolder)
    {
        // generation must be done in a different thread.
        // we create an operation.
        WorkspaceModifyOperation op = new WorkspaceModifyOperation()
        {
            public void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException
            {
                try
                {
                    ServicesManager.INSTANCE.initGenerationService(iFile);
                    
                    // Then iterates on all the diagrams and export them one by one
                	ResourceSet lresourceSet = HTMLPlugin.getResourceSet();
                	Resource resource = lresourceSet.getResource(URI.createURI(iFile.getLocationURI().toString()), true);
                    EObject diagrams = (Diagrams) resource.getContents().get(0);
                    List<Diagram> allDiagrams = DiagramsUtils.findAllDiagrams((Diagrams) diagrams);

                    monitor.beginTask("Export diagrams to html process ...", allDiagrams.size() + 50);

                    // 1.1 Create folder hierarchy if it does not exists.
                    final IFolder content = iFolder.getFolder(new Path("content"));
                    if (!content.exists())
                    {
                        content.create(true, true, new SubProgressMonitor(monitor, 1));
                    }

                    final IFolder images = content.getFolder(new Path("images"));
                    if (!images.exists())
                    {
                        images.create(true, true, new SubProgressMonitor(monitor, 1));
                    }

                    final IFolder docs = content.getFolder(new Path("documentation"));
                    if (!docs.exists())
                    {
                        docs.create(true, true, new SubProgressMonitor(monitor, 1));
                    }

                    // 1.2 Copy generic resources
                    copyResources(iFolder, new SubProgressMonitor(monitor, 10));

                    // clear all remaining traces from previous generations.
                    ServicesManager.INSTANCE.getGenerationService().clear();

                    // sort diagrams and create a name for them
                    ServicesManager.INSTANCE.getGenerationService().sortDiagrams(allDiagrams);

                    IImageExporter imageExporter = ExporterManager.getInstance().getExporter("PNG").getExporter();

                    ExportAllDiagrams exportAllDiagrams = new ExportAllDiagrams(iFile, images.getLocation().toOSString(), "png", imageExporter);

                    // iterate through all diagrams contained in the selected model
                    for (Diagram currentDiagram : allDiagrams)
                    {

                        try
                        {
                            
                            // 2.0 clean diagram name
                            String diagName = cleanDiagramName(currentDiagram);
                            currentDiagram.setName(diagName);
                            
                            // 2.1 generate diagram file
                            exportAllDiagrams.exportOneDiagram(ServicesManager.INSTANCE.getGenerationService().getName(currentDiagram), currentDiagram);

                            // 2.2 generate documentation files
                            DiagramDocumentationFileGenerator diagDocsGenerator = new DiagramDocumentationFileGenerator(docs);
                            String doc = ServicesManager.INSTANCE.getGenerationService().getDiagramDocumentation(currentDiagram);
                            if (doc != null && doc.length() > 0)
                                diagDocsGenerator.generate(currentDiagram, new SubProgressMonitor(monitor, 1));

                            DocumentationFileGenerator docsGenerator = new DocumentationFileGenerator(docs);
                            generateDocumentation(currentDiagram, docsGenerator, monitor);
                            for (Object next : exportAllDiagrams.getRootEditPart().getChildren())
                            {
                                if (next instanceof DiagramEditPart)
                                {
                                    DiagramEditPart diagramEP = (DiagramEditPart) next;
                                    Object model = diagramEP.getModel();
                                    if (model == currentDiagram)
                                    {
                                        Map<String, Object> options = new HashMap<String, Object>();
                                        List<PartPositionInfo> infos = PartPositionInfoGenerator.getDiagramPartInfo(diagramEP, options);
                                        ServicesManager.INSTANCE.getGenerationService().putLocation(currentDiagram, infos);
                                    }
                                }
                            }
                            DiagramFileGenerator generator = new DiagramFileGenerator(content);
                            generator.generate(currentDiagram, new SubProgressMonitor(monitor, 1));
                        }
                        catch (Exception e)
                        {
                            HTMLPlugin.log(e);
                            HTMLPlugin.displayDialog(null, "An error occurred during the export process using ImageExporter", IStatus.ERROR);
                            return;
                        }

                        monitor.worked(1);
                    }

                    // 2.3 Generate HTML code for outline
                    OutlineFileGenerator generator = new OutlineFileGenerator(iFolder);
                    generator.generate(EcoreUtil.getRootContainer(((Diagrams) diagrams).getModel()), new SubProgressMonitor(monitor, 1));

                    exportAllDiagrams.unloadResources(new SubProgressMonitor(monitor, 1), diagrams);

                    monitor.worked(1);
                }
                catch (Exception e)
                {
                    HTMLPlugin.log(e);
                    HTMLPlugin.displayDialog(null, "An error occurred while trying to create the output file", IStatus.ERROR);
                    return;
                }
                finally
                {
                    HTMLPlugin.setResourceSet(null);
                    // refresh Resources
                    iFolder.refreshLocal(IResource.DEPTH_INFINITE, monitor);
                }

                monitor.done();
            }

        };

        try
        {
            ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
            dialog.run(false, false, op);
        }
        catch (InvocationTargetException e)
        {
            HTMLPlugin.log(e);
            HTMLPlugin.displayDialog(null, "An error occurred during the diagrams images generation", IStatus.ERROR);
        }
        catch (InterruptedException e)
        {
            HTMLPlugin.log(e);
            HTMLPlugin.displayDialog(null, "An error occurred during the diagrams images generation", IStatus.ERROR);
        }
    }

    private String cleanDiagramName(Diagram currentDiagram)
    {
        String cleanedName = "";

        if (currentDiagram.getName() != null)
        {
            cleanedName = currentDiagram.getName();
            for (int i = 0; i < specialChar.length; i++)
            {
                String array_element = specialChar[i];
                cleanedName = cleanedName.replace(array_element, CHAR_REPLACEMENT);
            }
        }
        return cleanedName;
    }
    
    private void generateDocumentation(GraphElement graphElement, DocumentationFileGenerator docsGenerator, IProgressMonitor monitor) throws CoreException
    {
        for (DiagramElement element : graphElement.getContained())
        {
            if (element instanceof GraphElement)
            {
                GraphElement graphElt = (GraphElement) element;

                // first generate children documentation
                generateDocumentation(graphElt, docsGenerator, monitor);

                // then its own documentation
                String doc = ServicesManager.INSTANCE.getGenerationService().getDocumentation(graphElt);
                if (doc != null && doc.length() > 0)
                    docsGenerator.generate(graphElt, new SubProgressMonitor(monitor, 1));
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void copyResources(IContainer outputFolder, SubProgressMonitor monitor)
    {
        monitor.beginTask("Copy resources", 1);
        String resourcesPath = "/resources";
        Enumeration resources = HTMLPlugin.getDefault().getBundle().findEntries(resourcesPath, "*.*", true);
        while (resources.hasMoreElements())
        {
            URL url = (URL) resources.nextElement();
            try
            {
                String bundlePath = url.getPath();
                String path = bundlePath.substring(resourcesPath.length() + 1);

                InputStream is = url.openStream();

                IFile file = outputFolder.getFile(new Path(path));
                createHierarchy(file.getParent(), monitor);
                if (!file.exists())
                {
                    file.create(is, true, monitor);
                }
            }
            catch (IOException ioe)
            {
                HTMLPlugin.log(ioe);
            }
            catch (CoreException ce)
            {
                HTMLPlugin.log(ce);
            }
        }

        monitor.done();
    }

    private void createHierarchy(IContainer container, IProgressMonitor monitor) throws CoreException
    {
        if (!container.exists())
        {
            if (container.getParent() instanceof IFolder && !container.getParent().exists())
            {
                createHierarchy(container.getParent(), monitor);
            }
            if (container instanceof IFolder)
            {
                ((IFolder) container).create(true, true, monitor);
            }
        }
    }
}
