/***********************************************************************
 * Copyright (c) 2007, 2008 Topcased consortium
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas LAMBERT (Anyware Technologies) - initial API and implementation
 *    Jacques LESCOT (Anyware Technologies) - Code review
 **********************************************************************/

package org.topcased.gmfconverter.generator.gmfmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.TopNodeReference;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;

/**
 * 
 * @author Nicolas
 */
public class DiagramConfigurationMapGenerator extends MapGenerator<DiagramConfiguration>
{
    /**
     * @see org.topcased.gmfconverter.generator.ObjectGenerator#createGMFObject(java.lang.Object, java.lang.Class)
     */
    protected <G> G createGMFObject(DiagramConfiguration diagramConfiguration, Class<G> gmfClass) throws GeneratorException
    {
        if (!Mapping.class.equals(gmfClass))
        {
            throw new GeneratorException("gmfClass must be a Mapping.");
        }
        Mapping mapping = GMFMapFactory.eINSTANCE.createMapping();
        createCanvasMapping(mapping);
        EList<PartConfiguration> partConfigs = diagramConfiguration.getParts();
        if (partConfigs.size() > 0)
        {
            for (PartConfiguration partConfiguration : partConfigs)
            {
                if (isGenerable(partConfiguration))
                {
                    if (partConfiguration instanceof NodePartConfiguration)
                    {
                        createTopNodeReference(mapping, (NodePartConfiguration) partConfiguration);
                    }
                    else if (partConfiguration instanceof EdgePartConfiguration)
                    {
                        createEdgePart(mapping, (EdgePartConfiguration) partConfiguration);
                    }
                }
            }
        }
        deleteDuplicateNodeMapping(mapping);
        sortTopNodes(mapping);
        return (G) mapping;
    }

    private void sortTopNodes(Mapping mapping)
    {
        List<TopNodeReference> topNodes = new ArrayList<TopNodeReference>();
        topNodes.addAll(mapping.getNodes());
        Collections.sort(topNodes, new Comparator<TopNodeReference>()
        {
            public int compare(TopNodeReference o1, TopNodeReference o2)
            {
                EClass class1 = o1.getOwnedChild().getDomainMetaElement();
                EClass class2 = o2.getOwnedChild().getDomainMetaElement();
                if (class1.isSuperTypeOf(class2))
                {
                    return 1;
                }
                return 0;
            }
        });
        mapping.getNodes().clear();
        mapping.getNodes().addAll(topNodes);
    }

    private void deleteDuplicateNodeMapping(Mapping mapping)
    {
        for (TopNodeReference topnode : mapping.getNodes())
        {
            checkNodeMapping(topnode.getOwnedChild(), mapping);
        }
    }

    private void checkNodeMapping(NodeMapping nodeMapping, Mapping mapping)
    {
        for (ChildReference childReference : nodeMapping.getChildren())
        {
            checkChildReference(childReference, mapping);
        }
    }

    private void checkChildReference(ChildReference childReference, Mapping mapping)
    {
        for (TopNodeReference topnode : mapping.getNodes())
        {
            if (EcoreUtil.equals(topnode.getOwnedChild(), childReference.getOwnedChild()))
            {
                childReference.setOwnedChild(null);
                childReference.setReferencedChild(topnode.getOwnedChild());
            }
        }
        NodeMapping nodeMapping = childReference.getOwnedChild();
        if (nodeMapping != null)
        {
            checkNodeMapping(nodeMapping, mapping);
        }
    }

    private void createCanvasMapping(Mapping mapping)
    {
        CanvasMapping canvasMapping = GMFMapFactory.eINSTANCE.createCanvasMapping();
        EClass rootClass = MapRegistry.getRootEClass();
        canvasMapping.setDomainModel(rootClass.getEPackage());
        canvasMapping.setDomainMetaElement(rootClass);
        canvasMapping.setDiagramCanvas(MapRegistry.getCanvas());
        canvasMapping.setPalette(MapRegistry.getToolRegistry().getPalette());
        mapping.setDiagram(canvasMapping);
    }

    private void createEdgePart(Mapping mapping, EdgePartConfiguration edgePartConfiguration) throws GeneratorException
    {

        EdgePartConfigurationMapGenerator edgeGenerator = getInstance(EdgePartConfigurationMapGenerator.class);

        // Top Node Reference
        LinkMapping linkMapping = edgeGenerator.createGMFObject(edgePartConfiguration, LinkMapping.class);
        if (linkMapping != null)
        {
            mapping.getLinks().add(linkMapping);
        }
    }

    private void createTopNodeReference(Mapping mapping, NodePartConfiguration nodePartConfiguration) throws GeneratorException
    {

        EClass referencedClass = getEClass(nodePartConfiguration);
        EReference ref = getRootEReference(referencedClass);

        // We create the top node reference only if the containment feature exist.
        if (ref != null)
        {
            NodePartConfigurationMapGenerator nodeGenerator = getInstance(NodePartConfigurationMapGenerator.class);
            TopNodeReference topNodeReference = nodeGenerator.createGMFObject(nodePartConfiguration, TopNodeReference.class);
            if (topNodeReference != null)
            {
                mapping.getNodes().add(topNodeReference);
                topNodeReference.setContainmentFeature(ref);
            }
        }

    }

}
