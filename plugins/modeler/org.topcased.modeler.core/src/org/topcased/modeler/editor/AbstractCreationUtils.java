/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.editor;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.graphconf.DiagramGraphConf;
import org.topcased.modeler.graphconf.EMFBridge;
import org.topcased.modeler.graphconf.EdgeGraphConf;
import org.topcased.modeler.graphconf.NodeGraphConf;
import org.topcased.modeler.utils.Utils;

/**
 * <br>
 * creation : 2 nov. 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public abstract class AbstractCreationUtils implements ICreationUtils
{
    
    private DiagramGraphConf diagramConfiguration;

    /**
     * Constructor
     * @param diagramConf the Diagram Graphical Configuration
     */
    public AbstractCreationUtils(DiagramGraphConf diagramConf)
    {
        this.diagramConfiguration = diagramConf;
    }
    
    /**
     * Return the Diagram Graphical Configuration associated with this Factory
     * @return the Diagram Graphical Configuration
     */
    protected DiagramGraphConf getDiagramGraphConf()
    {
        return this.diagramConfiguration;
    }    
    
    /**
     * Get the first presentation of the model object
     * @param obj the model object
     * @return the first presentation encountered in the diagram.graphconf file.
     */
    protected String getDefaultPresentation(EObject obj)
    {
        Iterator itNodes = getDiagramGraphConf().getNode().iterator();
        while (itNodes.hasNext())
        {
            NodeGraphConf currentNode = (NodeGraphConf) itNodes.next();
            if (currentNode.getBridge() instanceof EMFBridge && obj.eClass().equals(((EMFBridge) currentNode.getBridge()).getType()))
            {
                return currentNode.getPresentation();
            }
        }

        Iterator itEdges = getDiagramGraphConf().getEdge().iterator();
        while (itEdges.hasNext())
        {
            EdgeGraphConf currentEdge = (EdgeGraphConf) itEdges.next();
            if (currentEdge.getBridge() instanceof EMFBridge && obj.eClass().equals(((EMFBridge) currentEdge.getBridge()).getType()))
            {
                return currentEdge.getPresentation();
            }
        }
        return null;
            
    }
    
    /**
     * @see org.topcased.modeler.editor.ICreationUtils#createGraphElement(org.eclipse.emf.ecore.EObject)
     */
    public GraphElement createGraphElement(EObject model)
    {
        return createGraphElement(model, getDefaultPresentation(model));
    }
    

    /**
     * Creates a graph node for an EMF object
     * 
     * @param model the EMF Object
     * @return the graph node
     */
    protected GraphNode createGraphNode(EObject model)
    {
        return createGraphNode(model, getDefaultPresentation(model));
    }
    
    /**
     * Creates a graph node for an EMF object with a given presentation
     * 
     * @param model the EMF Object
     * @param presentation the presentation of the graphical element
     * @return the graph node
     */
    protected GraphNode createGraphNode(EObject model, String presentation)
    {
        GraphNode node = DiagramInterchangeFactory.eINSTANCE.createGraphNode();
        EMFSemanticModelBridge bridge = DiagramInterchangeFactory.eINSTANCE.createEMFSemanticModelBridge();
        bridge.setElement(model);
        bridge.setPresentation(presentation);
        node.setSemanticModel(bridge);
        return node;
    }
  
    /**
     * Creates a graph node for the EStructuralFeature of an EMF object
     * 
     * @param model the EMF Object
     * @param featureID the EStructuralFeatureID
     * @return the graph node
     */
    protected GraphNode createGraphNode(EObject model, int featureID)
    {
        return createGraphNode(model, featureID, getDefaultPresentation(model));
    }
    
    /**
     * Creates a graph node for multi EStructuralFeature of an EMF object with a given presentation
     * 
     * @param model the EMF Object
     * @param featureIDs the EStructuralFeatureIDs, they are stored into di properties in a space separated format example :
     * 		-->{ 1 2 3 }
     * 		this allows users to create a node with a container able to sotre objects from different estructural features.
     * 		when you get back your values please split your String on space character (" ") 
     * @return the graph node
     */
    protected GraphNode createGraphNode(EObject model, int... featureIDs)
    {
        return createGraphNode(model, getDefaultPresentation(model), featureIDs);
    }
    
    /**
     * Creates a graph node for the EStructuralFeature of an EMF object with a given presentation
     * 
     * @param model the EMF Object
     * @param featureID the EStructuralFeatureID
     * @param presentation the presentation of the graphical element 
     * @return the graph node
     */
    protected GraphNode createGraphNode(EObject model, int featureID, String presentation)
    {
        GraphNode node = DiagramInterchangeFactory.eINSTANCE.createGraphNode();
        EMFSemanticModelBridge bridge = DiagramInterchangeFactory.eINSTANCE.createEMFSemanticModelBridge();
        bridge.setElement(model);
        bridge.setPresentation(presentation);
        node.setSemanticModel(bridge);
        DIUtils.setProperty(node, ModelerPropertyConstants.ESTRUCTURAL_FEATURE_ID, String.valueOf(featureID));
        return node;
    }
    
    /**
     * Creates a graph node for multi EStructuralFeature of an EMF object with a given presentation
     * 
     * @param model the EMF Object
     * @param featureIDs the EStructuralFeatureIDs, they are stored into di properties in a space separated format example :
     * 		-->{ 1 2 3 }
     * 		this allows users to create a node with a container able to sotre objects from different estructural features.
     * 		when you get back your values please split your String on space character (" "), you can use Utils.getEstructuralFeatures
     * @param presentation the presentation of the graphical element 
     * @return the graph node
     */
    protected GraphNode createGraphNode(EObject model, String presentation, int... featureIDs)
    {
        GraphNode node = DiagramInterchangeFactory.eINSTANCE.createGraphNode();
        EMFSemanticModelBridge bridge = DiagramInterchangeFactory.eINSTANCE.createEMFSemanticModelBridge();
        bridge.setElement(model);
        bridge.setPresentation(presentation);
        node.setSemanticModel(bridge);
        DIUtils.setProperty(node, ModelerPropertyConstants.ESTRUCTURAL_FEATURE_ID, Utils.getSpaceSeparated(featureIDs));
        return node;
    }
    
    
    
    /**
     * Creates a graph edge for an EMF object
     * 
     * @param model the EMF Object
     * @return the graph edge
     */
    protected GraphEdge createGraphEdge(EObject model)
    {
        return createGraphEdge(model, getDefaultPresentation(model));
    }

    /**
     * Creates a graph edge for an EMF object with a given presentation
     * 
     * @param model the EMF Object
     * @param presentation the presentation of the graphical element
     * @return the graph edge
     */
    protected GraphEdge createGraphEdge(EObject model, String presentation)
    {
        GraphEdge edge = DiagramInterchangeFactory.eINSTANCE.createGraphEdge();
        EMFSemanticModelBridge bridge = DiagramInterchangeFactory.eINSTANCE.createEMFSemanticModelBridge();
        bridge.setElement(model);
        bridge.setPresentation(presentation);
        edge.setSemanticModel(bridge);
        return edge;
    }

}