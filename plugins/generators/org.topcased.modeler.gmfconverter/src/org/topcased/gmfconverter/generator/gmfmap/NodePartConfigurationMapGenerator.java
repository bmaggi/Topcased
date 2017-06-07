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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.FeatureLabelMapping;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.TopNodeReference;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;

/**
 * @author Nicolas
 * 
 */
public class NodePartConfigurationMapGenerator extends MapGenerator<NodePartConfiguration>
{
    /**
     * @see org.topcased.gmfconverter.generator.ObjectGenerator#createGMFObject(java.lang.Object, java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    protected <G> G createGMFObject(NodePartConfiguration nodePartConfiguration, Class<G> gmfClass) throws GeneratorException
    {
        if (TopNodeReference.class.equals(gmfClass))
        {
            return (G) getTopNodeReference(nodePartConfiguration);
        }
        else
        {
            throw new GeneratorException("gmfClass must be a TopNodeReference.");
        }
    }

    private TopNodeReference getTopNodeReference(NodePartConfiguration nodePartConfiguration)
    {
        TopNodeReference topNodeReference = GMFMapFactory.eINSTANCE.createTopNodeReference();
        topNodeReference.setOwnedChild(getNodeMapping(nodePartConfiguration));
        return topNodeReference;
    }

    private NodeMapping getNodeMapping(NodePartConfiguration nodePartConfiguration)
    {
        NodeMapping nodeMapping = GMFMapFactory.eINSTANCE.createNodeMapping();
        setDomainMetaElement(nodeMapping, nodePartConfiguration);
        nodeMapping.setTool(MapRegistry.getAbstractTool(nodePartConfiguration));
        nodeMapping.setDiagramNode(MapRegistry.getNode(nodePartConfiguration));
        for (NodePartConfiguration child : nodePartConfiguration.getChildElements())
        {

            ChildReference childReference = getChildReference(nodePartConfiguration, child);
            if (childReference != null)
            {
                nodeMapping.getChildren().add(childReference);
                CompartmentMapping compartmentMapping = getCompartmentMapping(child);
                nodeMapping.getCompartments().add(compartmentMapping);
                childReference.setCompartment(compartmentMapping);
            }
        }
        FeatureLabelMapping featureLabelMapping = getFeatureLabelMapping(nodePartConfiguration);
        if (featureLabelMapping != null)
        {
            nodeMapping.getLabelMappings().add(featureLabelMapping);
        }
        return nodeMapping;
    }

    private FeatureLabelMapping getFeatureLabelMapping(NodePartConfiguration nodePartConfiguration)
    {
        FeatureLabelMapping featureLabelMapping = GMFMapFactory.eINSTANCE.createFeatureLabelMapping();
        DiagramLabel diagramLabel = MapRegistry.getDiagramLabel(nodePartConfiguration);
        if (diagramLabel != null)
        {
            featureLabelMapping.setDiagramLabel(diagramLabel);
            EAttribute labelFeature = getLabelEAttribute(getEClass(nodePartConfiguration));
            if (labelFeature != null)
            {
                featureLabelMapping.getFeatures().add(labelFeature);
                return featureLabelMapping;
            }
        }
        return null;
    }

    private EAttribute getLabelEAttribute(EClass eClass)
    {
        for (EAttribute eAttribute : eClass.getEAllAttributes())
        {
            if ("name".equals(eAttribute.getName().toLowerCase()))
            {
                return eAttribute;
            }
        }
        for (EAttribute eAttribute : eClass.getEAllAttributes())
        {
            if (eAttribute.getEType().getClassifierID() == EcorePackage.ESTRING)
            {
                return eAttribute;
            }
        }
        return null;
    }

    private ChildReference getChildReference(NodePartConfiguration parentNodePartConfiguration, NodePartConfiguration nodePartConfiguration)
    {
        EClass ownerClass = getEClass(parentNodePartConfiguration);
        EClass referencedClass = getEClass(nodePartConfiguration);
        EReference containmentFeature = getEReference(ownerClass, referencedClass);
        // We create the ChildReference only if the containment feature exist.
        if (containmentFeature == null)
        {
            return null;
        }
        ChildReference childReference = GMFMapFactory.eINSTANCE.createChildReference();
        childReference.setOwnedChild(getNodeMapping(nodePartConfiguration));
        childReference.setContainmentFeature(containmentFeature);
        return childReference;
    }

    private CompartmentMapping getCompartmentMapping(NodePartConfiguration nodePartConfiguration)
    {
        CompartmentMapping compartmentMapping = GMFMapFactory.eINSTANCE.createCompartmentMapping();
        compartmentMapping.setCompartment(MapRegistry.getCompartment(nodePartConfiguration));
        return compartmentMapping;
    }
}
