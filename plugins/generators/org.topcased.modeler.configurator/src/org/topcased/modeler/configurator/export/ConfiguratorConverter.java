/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.configurator.export;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.Color;
import org.topcased.modeler.configurator.ConfiguratorPlugin;
import org.topcased.modeler.configurator.DecorationType;
import org.topcased.modeler.configurator.DiagramConfiguration;
import org.topcased.modeler.configurator.DiagramReference;
import org.topcased.modeler.configurator.EdgeContainerType;
import org.topcased.modeler.configurator.EdgeObject;
import org.topcased.modeler.configurator.EdgeObjectType;
import org.topcased.modeler.configurator.EdgePartConfiguration;
import org.topcased.modeler.configurator.EditorConfiguration;
import org.topcased.modeler.configurator.LayoutType;
import org.topcased.modeler.configurator.ModelObjectConfiguration;
import org.topcased.modeler.configurator.NodePartConfiguration;
import org.topcased.modeler.configurator.ObjectConfiguration;
import org.topcased.modeler.configurator.PaletteCategory;
import org.topcased.modeler.configurator.PaletteItem;
import org.topcased.modeler.configurator.PartConfiguration;
import org.topcased.modeler.configurator.ResizableType;
import org.topcased.modeler.configurator.RouterType;
import org.topcased.modeler.configurator.SimpleObjectConfiguration;
import org.topcased.modeler.configurator.SourceTargetCouple;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorFactory;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorFactory;

/**
 * This converter aims to convert an old configurator file into the new configuration format of an editor (a single
 * *.editorconfiguration file and one *.diagramconfigurator file per diagram)
 * 
 * Creation 3 mai 2006
 * 
 * @author jlescot
 */
public class ConfiguratorConverter
{
    private IFile oldConfiguratorFile;

    private EditorConfiguration oldEditorConfiguration;

    private org.topcased.modeler.editorconfigurator.EditorConfiguration newEditorConfiguration;

    /**
     * The Constructor
     * 
     * @param oldConfiguratorFile the oldConfigurator file. Used to retrieve the corresponding IPath.
     * @param oldEditorConfiguration the old EditorConfiguration model object
     */
    public ConfiguratorConverter(IFile oldConfiguratorFile, EditorConfiguration oldEditorConfiguration)
    {
        this.oldConfiguratorFile = oldConfiguratorFile;
        this.oldEditorConfiguration = oldEditorConfiguration;
    }

    /**
     * Execute the conversion process
     */
    public void convert()
    {
        // ----------------------------
        // Generate the expected files

        generateEditorConfiguratorFile(oldEditorConfiguration);

        Iterator it = oldEditorConfiguration.getDiagrams().iterator();
        while (it.hasNext())
        {
            DiagramConfiguration diagramConfiguration = (DiagramConfiguration) it.next();
            generateDiagramConfiguratorFile(diagramConfiguration);
        }

        // ----------------------------
    }

    /**
     * Generate the new editorConfiguration file associated with the old configurator file
     * 
     * @param oldEditorConf the old EditorConfiguration model object
     */
    private void generateEditorConfiguratorFile(EditorConfiguration oldEditorConf)
    {
        // retrieve the Editorconfigurator factory singleton
        EditorconfiguratorFactory factory = EditorconfiguratorFactory.eINSTANCE;

        // create the editorconfigurator model
        newEditorConfiguration = factory.createEditorConfiguration();
        newEditorConfiguration.setGenModel(oldEditorConf.getGenModel());
        newEditorConfiguration.setName(oldEditorConf.getName());
        newEditorConfiguration.setPluginVersion(oldEditorConf.getPluginVersion());
        newEditorConfiguration.setProjectName(oldEditorConf.getProjectName());
        newEditorConfiguration.setProvider("Topcased");

        // create the new editorconfigurator file and add the created model into
        IFile createdFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
                new Path(oldConfiguratorFile.getParent().getFullPath().toString() + File.separator + oldEditorConf.getPrefix() + ".editorconfigurator"));
        ResourceSet rsrcSet = new ResourceSetImpl();
        URI uri = URI.createPlatformResourceURI(createdFile.getFullPath().toString());
        Resource newResource = rsrcSet.createResource(uri);
        newResource.getContents().add(newEditorConfiguration);

        // Save the resource contents to the file system.
        try
        {
            Map options = new HashMap();
            options.put(XMLResource.OPTION_ENCODING, "UTF-8");
            newResource.save(options);
        }
        catch (IOException e)
        {
            ConfiguratorPlugin.log("The newEditorConfigurator file could not be saved.", IStatus.ERROR);
        }
    }

    /**
     * Generate a diagramConfiguration file associated with a diagram contained by the old configurator file
     * 
     * @param oldDiagConf the old DiagramConfiguration model object
     */
    private void generateDiagramConfiguratorFile(DiagramConfiguration oldDiagConf)
    {
        // retrieve the Diagramconfigurator factory singleton
        DiagramconfiguratorFactory factory = DiagramconfiguratorFactory.eINSTANCE;

        // convert the DiagramConfiguration and its properties
        org.topcased.modeler.diagramconfigurator.DiagramConfiguration newDiagConf = factory.createDiagramConfiguration();
        newDiagConf.setDefaultBackgroundColor(ColorConstants.white);
        newDiagConf.setDefaultForegroundColor(ColorConstants.black);
        newDiagConf.setEditorConfigurator(newEditorConfiguration);
        newDiagConf.setGenModel(((EditorConfiguration) oldDiagConf.eContainer()).getGenModel());
        newDiagConf.setLayout(convertLayoutType(oldDiagConf.getLayout()));
        newDiagConf.setName(oldDiagConf.getName());
        newDiagConf.setPackage(oldDiagConf.getPackage());
        newDiagConf.setPluginVersion(((EditorConfiguration) oldDiagConf.eContainer()).getPluginVersion());
        newDiagConf.setPrefix(oldDiagConf.getPrefix());
        newDiagConf.setProjectName(oldDiagConf.getId());
        newDiagConf.setProvider("Topcased");
        newDiagConf.setSamePluginAsEditor(true);

        // convert the ObjectConfigurations
        Iterator it = ((EditorConfiguration) oldDiagConf.eContainer()).getObjects().iterator();
        Map objConfMap = new HashMap(); // the Map that handle mapping between
        // old and new ObjectConfigurations
        while (it.hasNext())
        {
            ObjectConfiguration oldObjectConf = (ObjectConfiguration) it.next();

            // Add only the objects that are used in the current diagram
            Collection references = EcoreUtil.UsageCrossReferencer.find(oldObjectConf, oldDiagConf);
            if (references.size() > 0)
            {
                if (oldObjectConf instanceof ModelObjectConfiguration)
                {
                    org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration newObjectConf = factory.createModelObjectConfiguration();
                    newObjectConf.setGenClass(((ModelObjectConfiguration) oldObjectConf).getGenClass());
                    objConfMap.put(oldObjectConf, newObjectConf);

                    Iterator itDiagrams = ((ModelObjectConfiguration) oldObjectConf).getDiagrams().iterator();
                    while (itDiagrams.hasNext())
                    {
                        DiagramReference oldDiagRef = (DiagramReference) itDiagrams.next();
                        // Add only the DiagramReference to the considered
                        // DiagramConfiguration
                        if (oldDiagConf.equals(oldDiagRef.getDiagram()))
                        {
                            org.topcased.modeler.diagramconfigurator.DiagramReference newDiagRef = factory.createDiagramReference();
                            newDiagRef.setDiagram(newDiagConf);
                            newDiagRef.setLowerBound(oldDiagRef.getLowerBound());
                            newDiagRef.setUpperBound(oldDiagRef.getUpperBound());

                            newObjectConf.getDiagrams().add(newDiagRef);
                        }
                    }
                    newDiagConf.getObjects().add(newObjectConf);
                }
                else if (oldObjectConf instanceof SimpleObjectConfiguration)
                {
                    org.topcased.modeler.diagramconfigurator.SimpleObjectConfiguration newObjectConf = factory.createSimpleObjectConfiguration();
                    newObjectConf.setName(((SimpleObjectConfiguration) oldObjectConf).getName());
                    objConfMap.put(oldObjectConf, newObjectConf);
                    newDiagConf.getObjects().add(newObjectConf);
                }
            }
        }

        // convert the PartConfigurations
        it = oldDiagConf.getParts().iterator();
        // the Map that handle mapping between old and new PartConfigurations
        Map<PartConfiguration, PartConfiguration> partConfMap = new HashMap<PartConfiguration, PartConfiguration>();
        while (it.hasNext())
        {
            PartConfiguration oldPartConf = (PartConfiguration) it.next();
            if (oldPartConf instanceof NodePartConfiguration)
            {
                org.topcased.modeler.diagramconfigurator.NodePartConfiguration newPartConf = factory.createNodePartConfiguration();

                newPartConf.setBackgroundColorChangeable(((NodePartConfiguration) oldPartConf).isBackgroundColorChangeable());
                newPartConf.setContainer(((NodePartConfiguration) oldPartConf).isContainer());
                if (((NodePartConfiguration) oldPartConf).getDefaultBackgroundColor() != null && !"".equals(((NodePartConfiguration) oldPartConf).getDefaultBackgroundColor()))
                    newPartConf.setDefaultBackgroundColor(new Color(null, StringConverter.asRGB(((NodePartConfiguration) oldPartConf).getDefaultBackgroundColor())));
                if (oldPartConf.getDefaultForegroundColor() != null && !"".equals(oldPartConf.getDefaultForegroundColor()))
                    newPartConf.setDefaultForegroundColor(new Color(null, StringConverter.asRGB(oldPartConf.getDefaultForegroundColor())));
                newPartConf.setDefaultHeight(((NodePartConfiguration) oldPartConf).getDefaultHeight());
                newPartConf.setDefaultWidth(((NodePartConfiguration) oldPartConf).getDefaultWidth());
                newPartConf.setDirectEditable(((NodePartConfiguration) oldPartConf).isDirectEditable());
                newPartConf.setFontChangeable(((NodePartConfiguration) oldPartConf).isFontChangeable());
                newPartConf.setForegroundColorChangeable(((NodePartConfiguration) oldPartConf).isForegroundColorChangeable());
                newPartConf.setLayout(convertLayoutType(((NodePartConfiguration) oldPartConf).getLayout()));
                newPartConf.setMaximumHeight(((NodePartConfiguration) oldPartConf).getMaximumHeight());
                newPartConf.setMaximumWidth(((NodePartConfiguration) oldPartConf).getMaximumWidth());
                newPartConf.setMinimumHeight(((NodePartConfiguration) oldPartConf).getMinimumHeight());
                newPartConf.setMinimumWidth(((NodePartConfiguration) oldPartConf).getMinimumWidth());
                newPartConf.setResizing(convertResizableType(((NodePartConfiguration) oldPartConf).getResizing()));
                newPartConf.setType(((NodePartConfiguration) oldPartConf).getType());

                partConfMap.put(oldPartConf, (PartConfiguration) newPartConf);
                newDiagConf.getParts().add(newPartConf);
            }
            else if (oldPartConf instanceof EdgePartConfiguration)
            {
                org.topcased.modeler.diagramconfigurator.EdgePartConfiguration newPartConf = factory.createEdgePartConfiguration();

                if (oldPartConf.getDefaultForegroundColor() != null && !"".equals(oldPartConf.getDefaultForegroundColor()))
                    newPartConf.setDefaultForegroundColor(new Color(null, StringConverter.asRGB(oldPartConf.getDefaultForegroundColor())));
                newPartConf.setDefaultRouter(convertRouterType(((EdgePartConfiguration) oldPartConf).getDefaultRouter()));
                newPartConf.setFontChangeable(((EdgePartConfiguration) oldPartConf).isFontChangeable());
                newPartConf.setForegroundColorChangeable(((EdgePartConfiguration) oldPartConf).isForegroundColorChangeable());
                newPartConf.setSourceDecoration(convertDecorationType(((EdgePartConfiguration) oldPartConf).getSourceDecoration()));
                newPartConf.setTargetDecoration(convertDecorationType(((EdgePartConfiguration) oldPartConf).getTargetDecoration()));

                partConfMap.put(oldPartConf, (PartConfiguration) newPartConf);
                newDiagConf.getParts().add(newPartConf);
            }

        }

        // Add the references to other model objects
        it = oldDiagConf.getParts().iterator();
        while (it.hasNext())
        {
            PartConfiguration oldPartConf = (PartConfiguration) it.next();
            org.topcased.modeler.diagramconfigurator.PartConfiguration newPartConf = (org.topcased.modeler.diagramconfigurator.PartConfiguration) partConfMap.get(oldPartConf);

            newPartConf.setObject((org.topcased.modeler.diagramconfigurator.ObjectConfiguration) objConfMap.get(oldPartConf.getObject()));

            if (oldPartConf instanceof NodePartConfiguration)
            {
                // Update the SuperType reference
                ((org.topcased.modeler.diagramconfigurator.NodePartConfiguration) newPartConf).setSuperType((org.topcased.modeler.diagramconfigurator.NodePartConfiguration) partConfMap.get(((NodePartConfiguration) oldPartConf).getSuperType()));

                // Add the ChildElements references
                for (Iterator itChildElts = ((NodePartConfiguration) oldPartConf).getChildElements().iterator(); itChildElts.hasNext();)
                {
                    NodePartConfiguration oldChildElt = (NodePartConfiguration) itChildElts.next();
                    ((org.topcased.modeler.diagramconfigurator.NodePartConfiguration) newPartConf).getChildElements().add(
                            (org.topcased.modeler.diagramconfigurator.NodePartConfiguration) partConfMap.get(oldChildElt));
                }
            }
            else if (oldPartConf instanceof EdgePartConfiguration)
            {
                // Convert the EdgeObjects
                Iterator itEdgeObjects = ((EdgePartConfiguration) oldPartConf).getEdgeObjects().iterator();
                while (itEdgeObjects.hasNext())
                {
                    EdgeObject oldEdgeObject = (EdgeObject) itEdgeObjects.next();
                    org.topcased.modeler.diagramconfigurator.EdgeObject newEdgeObject = factory.createEdgeObject();

                    newEdgeObject.setId(oldEdgeObject.getId());
                    newEdgeObject.setType(convertEdgeObjectType(oldEdgeObject.getType()));
                    newEdgeObject.setEStructuralFeature(oldEdgeObject.getEStructuralFeature());
                    if (oldEdgeObject.equals(((EdgePartConfiguration) oldPartConf).getDirectEditable()))
                    {
                        ((org.topcased.modeler.diagramconfigurator.EdgePartConfiguration) newPartConf).setDirectEditable(newEdgeObject);
                    }
                    ((org.topcased.modeler.diagramconfigurator.EdgePartConfiguration) newPartConf).getEdgeObjects().add(newEdgeObject);
                }

                // Convert the SourceTargetCouples
                Iterator itCouple = ((EdgePartConfiguration) oldPartConf).getSourceTargetCouple().iterator();
                while (itCouple.hasNext())
                {
                    SourceTargetCouple oldCouple = (SourceTargetCouple) itCouple.next();
                    org.topcased.modeler.diagramconfigurator.SourceTargetCouple newCouple = factory.createSourceTargetCouple();

                    newCouple.setAutoRef(oldCouple.isAutoRef());
                    newCouple.setContainerObject(oldCouple.getContainerObject());
                    newCouple.setContainerRef(oldCouple.getContainerRef());
                    newCouple.setContainerType(convertEdgeContainerType(oldCouple.getContainerType()));
                    newCouple.setRefEdgeToSource(oldCouple.getRefEdgeToSource());
                    newCouple.setRefEdgeToTarget(oldCouple.getRefEdgeToTarget());
                    newCouple.setRefSourceToEdge(oldCouple.getRefSourceToEdge());
                    newCouple.setRefSourceToTarget(oldCouple.getRefSourceToTarget());
                    newCouple.setRefTargetToEdge(oldCouple.getRefTargetToEdge());
                    newCouple.setRefTargetToSource(oldCouple.getRefTargetToSource());
                    newCouple.setReversible(oldCouple.isReversible());
                    newCouple.setSourceNode((org.topcased.modeler.diagramconfigurator.NodePartConfiguration) partConfMap.get(oldCouple.getSourceNode()));
                    newCouple.setTargetNode((org.topcased.modeler.diagramconfigurator.NodePartConfiguration) partConfMap.get(oldCouple.getTargetNode()));

                    ((org.topcased.modeler.diagramconfigurator.EdgePartConfiguration) newPartConf).getSourceTargetCouple().add(newCouple);
                }
            }
        }

        // convert the PaletteConfiguration
        org.topcased.modeler.diagramconfigurator.PaletteConfiguration newPaletteConf = factory.createPaletteConfiguration();
        newPaletteConf.setName(oldDiagConf.getPalette().getName());
        newDiagConf.setPalette(newPaletteConf);

        // convert the PaletteCategories
        it = oldDiagConf.getPalette().getPaletteCategories().iterator();
        while (it.hasNext())
        {
            PaletteCategory oldPaletteCategory = (PaletteCategory) it.next();
            org.topcased.modeler.diagramconfigurator.PaletteCategory newPaletteCategory = factory.createPaletteCategory();

            newPaletteCategory.setName(oldPaletteCategory.getName());
            newDiagConf.getPalette().getPaletteCategories().add(newPaletteCategory);

            // convert the PaletteItems of the current PaletteCategory
            Iterator itPaletteItems = oldPaletteCategory.getItems().iterator();
            while (itPaletteItems.hasNext())
            {
                PaletteItem oldPaletteItem = (PaletteItem) itPaletteItems.next();
                org.topcased.modeler.diagramconfigurator.PaletteItem newPaletteItem = factory.createPaletteItem();

                newPaletteItem.setName(oldPaletteItem.getName());
                newPaletteItem.setPart((org.topcased.modeler.diagramconfigurator.PartConfiguration) partConfMap.get(oldPaletteItem.getPart()));

                newPaletteCategory.getItems().add(newPaletteItem);
            }
        }

        // create the new diagramconfigurator file and add the created model
        // into
        IFile createdFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
                new Path(oldConfiguratorFile.getParent().getFullPath().toString() + File.separator + oldDiagConf.getPrefix() + ".diagramconfigurator"));
        ResourceSet rsrcSet = new ResourceSetImpl();
        URI uri = URI.createPlatformResourceURI(createdFile.getFullPath().toString());
        Resource newResource = rsrcSet.createResource(uri);
        newResource.getContents().add(newDiagConf);

        // Save the resource contents to the file system.
        try
        {
            Map options = new HashMap();
            options.put(XMLResource.OPTION_ENCODING, "UTF-8");
            newResource.save(options);
        }
        catch (IOException e)
        {
            ConfiguratorPlugin.log(e);
        }
    }

    private org.topcased.modeler.diagramconfigurator.LayoutType convertLayoutType(LayoutType oldLayoutType)
    {
        switch (oldLayoutType.getValue())
        {
            case LayoutType.CLASS_LAYOUT:
                return org.topcased.modeler.diagramconfigurator.LayoutType.CLASS_LAYOUT_LITERAL;
            case LayoutType.MULTI_PORT_LAYOUT:
                return org.topcased.modeler.diagramconfigurator.LayoutType.MULTI_PORT_LAYOUT_LITERAL;
            case LayoutType.PORT_LAYOUT:
                return org.topcased.modeler.diagramconfigurator.LayoutType.PORT_LAYOUT_LITERAL;
            case LayoutType.TOOLBAR_LAYOUT:
                return org.topcased.modeler.diagramconfigurator.LayoutType.TOOLBAR_LAYOUT_LITERAL;
            case LayoutType.XY_LAYOUT:
                return org.topcased.modeler.diagramconfigurator.LayoutType.XY_LAYOUT_LITERAL;
        }
        return null;
    }

    private org.topcased.modeler.diagramconfigurator.ResizableType convertResizableType(ResizableType oldResizableType)
    {
        switch (oldResizableType.getValue())
        {
            case ResizableType.ALL:
                return org.topcased.modeler.diagramconfigurator.ResizableType.ALL_LITERAL;
            case ResizableType.HEIGHT:
                return org.topcased.modeler.diagramconfigurator.ResizableType.HEIGHT_LITERAL;
            case ResizableType.WIDTH:
                return org.topcased.modeler.diagramconfigurator.ResizableType.WIDTH_LITERAL;
            case ResizableType.NONE:
                return org.topcased.modeler.diagramconfigurator.ResizableType.NONE_LITERAL;
        }
        return null;
    }

    private org.topcased.modeler.diagramconfigurator.RouterType convertRouterType(RouterType oldRouterType)
    {
        switch (oldRouterType.getValue())
        {
            case RouterType.OBLIQUE_ROUTER:
                return org.topcased.modeler.diagramconfigurator.RouterType.OBLIQUE_ROUTER_LITERAL;
            case RouterType.RECTILINEAR_ROUTER:
                return org.topcased.modeler.diagramconfigurator.RouterType.RECTILINEAR_ROUTER_LITERAL;
            case RouterType.TREE_ROUTER:
                return org.topcased.modeler.diagramconfigurator.RouterType.TREE_ROUTER_LITERAL;
        }
        return null;
    }

    private org.topcased.modeler.diagramconfigurator.DecorationType convertDecorationType(DecorationType oldDecorationType)
    {
        switch (oldDecorationType.getValue())
        {
            case DecorationType.NONE:
                return org.topcased.modeler.diagramconfigurator.DecorationType.NONE_LITERAL;
            case DecorationType.ARROW:
                return org.topcased.modeler.diagramconfigurator.DecorationType.ARROW_LITERAL;
            case DecorationType.DIAMOND:
                return org.topcased.modeler.diagramconfigurator.DecorationType.DIAMOND_LITERAL;
            case DecorationType.TRIANGLE:
                return org.topcased.modeler.diagramconfigurator.DecorationType.TRIANGLE_LITERAL;
        }
        return null;
    }

    private org.topcased.modeler.diagramconfigurator.EdgeObjectType convertEdgeObjectType(EdgeObjectType oldEdgeObjectType)
    {
        switch (oldEdgeObjectType.getValue())
        {
            case EdgeObjectType.MIDDLE:
                return org.topcased.modeler.diagramconfigurator.EdgeObjectType.MIDDLE_LITERAL;
            case EdgeObjectType.SOURCE:
                return org.topcased.modeler.diagramconfigurator.EdgeObjectType.SOURCE_LITERAL;
            case EdgeObjectType.TARGET:
                return org.topcased.modeler.diagramconfigurator.EdgeObjectType.TARGET_LITERAL;
        }
        return null;
    }

    private org.topcased.modeler.diagramconfigurator.EdgeContainerType convertEdgeContainerType(EdgeContainerType oldEdgeContainerType)
    {
        switch (oldEdgeContainerType.getValue())
        {
            case EdgeContainerType.NONE:
                return org.topcased.modeler.diagramconfigurator.EdgeContainerType.NONE_LITERAL;
            case EdgeContainerType.DIAGRAM:
                return org.topcased.modeler.diagramconfigurator.EdgeContainerType.DIAGRAM_LITERAL;
            case EdgeContainerType.SOURCE:
                return org.topcased.modeler.diagramconfigurator.EdgeContainerType.SOURCE_LITERAL;
            case EdgeContainerType.SOURCE_CONTAINER:
                return org.topcased.modeler.diagramconfigurator.EdgeContainerType.SOURCE_CONTAINER_LITERAL;
            case EdgeContainerType.TARGET:
                return org.topcased.modeler.diagramconfigurator.EdgeContainerType.TARGET_LITERAL;
            case EdgeContainerType.TARGET_CONTAINER:
                return org.topcased.modeler.diagramconfigurator.EdgeContainerType.TARGET_CONTAINER_LITERAL;
        }
        return null;
    }
}
