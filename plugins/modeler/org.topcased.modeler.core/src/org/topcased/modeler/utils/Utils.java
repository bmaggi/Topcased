/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies), Thomas Friol (Anyware
 * Technologies) - initial API and implementation
 ******************************************************************************/
package org.topcased.modeler.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.RangeModel;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.DataFormatException;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.service.prefs.BackingStoreException;
import org.topcased.modeler.IAnnotationConstants;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.GraphConnector;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.di.model.SimpleSemanticModelElement;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.edit.BaseEditPart;
import org.topcased.modeler.edit.DiagramEditPart;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.evaluator.EvaluatorException;
import org.topcased.modeler.evaluator.extension.EvaluatorsManager;
import org.topcased.modeler.graphconf.Constraint;
import org.topcased.modeler.graphconf.DiagramGraphConf;
import org.topcased.modeler.graphconf.EdgeGraphConf;
import org.topcased.modeler.graphconf.NodeGraphConf;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.resize.OptimizedResizersManager;

/**
 * Helper class to manage the graph model. <br>
 * creation : 10 d�c. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public final class Utils
{
    /** AUTOSIZE MARGIN */
    private final static int AUTOSIZE_MARGIN = 10;

    /**
     * Constructor
     */
    private Utils()
    {
        // Do nothing
    }

    /**
     * Returns the EList associated with the given feature for the given EMF object.
     * 
     * @param owner The EMF Object
     * @param feat The list feature
     * @return the EList or <code>null</code> if the feature cannot be found or it is not a multiple feature.
     */
    public static EList<EObject> getOwnerList(EObject owner, EStructuralFeature feat)
    {
        return owner.eClass().getEAllStructuralFeatures().contains(feat) && feat.isMany() ? (EList<EObject>) owner.eGet(feat) : null;
    }

    /**
     * Returns the model object linked with the given graph element (If the bridge is an EMFSemanticModelBridge)
     * 
     * @param graphElt the graph element
     * @return the model object associated with the given graph element or <code>null</code> if unable to find a model
     *         object.
     */
    public static EObject getElement(GraphElement graphElt)
    {
        if (graphElt != null && (graphElt.getSemanticModel() instanceof EMFSemanticModelBridge))
        {
            return ((EMFSemanticModelBridge) graphElt.getSemanticModel()).getElement();
        }

        return null;
    }

    /**
     * Returns the GraphElement child associated with the given model object
     * 
     * @param container the graph container
     * @param model the model EObject
     * @return The GraphElement associated with the model object or <code>null</code> if no child can be found.
     */
    public static GraphElement getGraphElement(GraphElement container, EObject model)
    {
        return getGraphElement(container, model, false);
    }

    /**
     * Returns the GraphElement child associated with the given model object
     * 
     * @param container the graph container
     * @param model the model EObject
     * @param deepSearch a boolean indicating if the search process must be recursive
     * @return The GraphElement associated with the model object or <code>null</code> if no child can be found.
     */
    public static GraphElement getGraphElement(GraphElement container, EObject model, boolean deepSearch)
    {
        if (container != null)
        {
            for (DiagramElement diagramElt : container.getContained())
            {
                if (diagramElt instanceof GraphElement)
                {
                    GraphElement graphElt = (GraphElement) diagramElt;
                    EObject object = getElement(graphElt);
                    if (object != null && object.equals(model))
                    {
                        return graphElt;
                    }
                    if (deepSearch)
                    {
                        GraphElement result = getGraphElement(graphElt, model, deepSearch);
                        if (result != null)
                        {
                            return result;
                        }
                    }
                }
            }

        }
        return null;
    }

    /**
     * Returns the GraphElement children associated with the given model object
     * 
     * @param container the graph container
     * @param model the model EObject
     * @param deepSearch a boolean indicating if the search process must be recursive
     * @return The list of GraphElements associated with the model object or an Empty list if no child can be found.
     */
    public static List<GraphElement> getGraphElements(GraphElement container, EObject model, boolean deepSearch)
    {
        // use this method in other search algorithms
        List<GraphElement> children = new ArrayList<GraphElement>();
        for (DiagramElement diagramElt : container.getContained())
        {
            if (diagramElt instanceof GraphElement)
            {
                GraphElement graphElt = (GraphElement) diagramElt;
                EObject object = getElement(graphElt);
                if (object != null && object.equals(model))
                {
                    children.add(graphElt);
                }
                if (deepSearch)
                {
                    GraphElement result = getGraphElement(graphElt, model, deepSearch);
                    if (result != null)
                    {
                        children.add(result);
                    }
                }
            }
        }

        return children;
    }

    /**
     * Returns the graphElements associated with the given EObject in all the diagrams
     * 
     * @param diagrams the Diagrams object
     * @param model the searched EObject
     * @return the List of associated GraphElements
     */
    public static GraphElement[] getGraphElements(Diagrams diagrams, EObject model)
    {
        List<GraphElement> results = new ArrayList<GraphElement>();

        for (Diagram diagram : DiagramsUtils.findAllDiagrams(diagrams))
        {
            GraphElement elt = getGraphElement(diagram, model, true);
            if (elt != null)
            {
                results.add(elt);
            }
        }

        return results.toArray(new GraphElement[results.size()]);
    }

    /**
     * Returns the type info associated with the given graph element (If the bridge is a SimpleSemanticModelBridge)
     * 
     * @param graphElt the graph element
     * @return the type info associated with the given graph element or <code>null</code> if unable to find a type info
     *         (it is not a SimpleSemanticModelBridge).
     */
    public static String getTypeInfo(GraphElement graphElt)
    {
        if (graphElt != null && (graphElt.getSemanticModel() instanceof SimpleSemanticModelElement))
        {
            return ((SimpleSemanticModelElement) graphElt.getSemanticModel()).getTypeInfo();
        }

        return null;
    }

    /**
     * Creates a graph node NOT linked with a model object
     * 
     * @param type the identifier of the node
     * @return the graph node
     */
    public static GraphNode createGraphNode(String type)
    {
        return createGraphNode(type, "default");
    }

    /**
     * Creates a graph node NOT linked with a model object
     * 
     * @param type the identifier of the node
     * @param presentation the presentation of the graphical element
     * @return the graph node
     */
    public static GraphNode createGraphNode(String type, String presentation)
    {
        GraphNode node = DiagramInterchangeFactory.eINSTANCE.createGraphNode();
        SimpleSemanticModelElement element = DiagramInterchangeFactory.eINSTANCE.createSimpleSemanticModelElement();
        element.setTypeInfo(type);
        element.setPresentation(presentation);
        node.setSemanticModel(element);
        return node;
    }

    /**
     * Creates a graph edge NOT linked with a model object
     * 
     * @param type the identifier of the edge
     * @return the graph edge
     */
    public static GraphEdge createGraphEdge(String type)
    {
        return createGraphEdge(type, "default");
    }

    /**
     * Creates a graph edge NOT linked with a model object
     * 
     * @param type the identifier of the edge
     * @param presentation the presentation of the graphical element
     * @return the graph edge
     */
    public static GraphEdge createGraphEdge(String type, String presentation)
    {
        GraphEdge edge = DiagramInterchangeFactory.eINSTANCE.createGraphEdge();
        SimpleSemanticModelElement element = DiagramInterchangeFactory.eINSTANCE.createSimpleSemanticModelElement();
        element.setTypeInfo(type);
        element.setPresentation(presentation);
        edge.setSemanticModel(element);
        return edge;
    }

    /**
     * Returns the background Color of the Figure
     * 
     * @param graphElement
     * @return Color
     */
    public static Color getBackgroundColor(GraphElement graphElement)
    {
        return getColor(graphElement, ModelerPropertyConstants.BACKGROUND_COLOR);
    }

    /**
     * Returns the foreground Color of the Figure
     * 
     * @param graphElement
     * @return Color
     */
    public static Color getForegroundColor(GraphElement graphElement)
    {
        return getColor(graphElement, ModelerPropertyConstants.FOREGROUND_COLOR);
    }

    /**
     * Get the Color corresponding to a Property with a particular key
     * 
     * @param graphElement
     * @param key ("backgroundColor" or "foregroundColor")
     * @return Color
     */
    private static Color getColor(GraphElement graphElement, String key)
    {
        Property property = DIUtils.getProperty(graphElement, key);
        if (property != null)
        {
            return getColor(property.getValue());
        }
        return null;
    }

    /**
     * Get the Color corresponding to a string with a particular format. Return null if color cannot be resolved.
     * 
     * @param rgb a string representing the rgb. Format is "R,G,B" like 244,164,96 or 128,0,255
     * @return the color
     */
    public static Color getColor(String rgb)
    {
        try
        {
            RGB colorRGB = StringConverter.asRGB(rgb);
            if (colorRGB != null)
            {
                Color color = JFaceResources.getColorRegistry().get(StringConverter.asString(colorRGB));
                if (color == null)
                {
                    JFaceResources.getColorRegistry().put(StringConverter.asString(colorRGB), colorRGB);
                    color = JFaceResources.getColorRegistry().get(StringConverter.asString(colorRGB));
                }
                return color;
            }
        }
        catch (DataFormatException e)
        {
            // Just ignore
        }
        return null;
    }

    /**
     * Get the Font corresponding to a DiagramElement
     * 
     * @param diagElement
     * @return Font
     */
    public static Font getFont(DiagramElement diagElement)
    {
        Property property = DIUtils.getProperty(diagElement, ModelerPropertyConstants.FONT);
        if (property != null)
        {
            if (property.getValue().length() != 0)
            {
                FontData fontData = StringConverter.asFontData(property.getValue());
                return getFont(fontData);
            }
        }
        return null;
    }

    /**
     * Gets the Font with given styles.
     * 
     * @param fontData An existing font data
     * @param style One or several Font style(s)
     * @return Font
     */
    public static Font getFont(FontData fontData, int style)
    {
        fontData.setStyle(fontData.getStyle() | style);
        return getFont(fontData);
    }

    /**
     * 
     * @param fontData
     * @return the font associated with the FontData
     */
    public static Font getFont(FontData fontData)
    {
        if (fontData != null)
        {
            FontData[] fontDataList = new FontData[] {fontData};
            String asString = StringConverter.asString(fontData);
            if (!JFaceResources.getFontRegistry().hasValueFor(asString))
            {
                JFaceResources.getFontRegistry().put(asString, fontDataList);
            }
            // the get on a font always return a font even if this font is not registered
            return JFaceResources.getFontRegistry().get(asString);
        }
        return null;
    }

    /**
     * Get the target GraphElement for the given connection
     * 
     * @param gEdge the connection
     * @return the target graph element
     */
    public static GraphElement getTarget(GraphEdge gEdge)
    {
        GraphConnector toConnector = gEdge.getAnchor().get(gEdge.getAnchor().size() - 1);
        return toConnector.getGraphElement();
    }

    /**
     * Get the source GraphElement for the given connection
     * 
     * @param gEdge the connection
     * @return the source graph element
     */
    public static GraphElement getSource(GraphEdge gEdge)
    {
        GraphConnector fromConnector = gEdge.getAnchor().get(0);
        return fromConnector.getGraphElement();
    }

    /**
     * Check if an object is a child of an other object
     * 
     * @param parent the parent graph element
     * @param child the possible child element
     * @return a boolean ;)
     */
    public static boolean isChild(GraphElement parent, GraphElement child)
    {
        GraphElement childParent = child.getContainer();
        if (childParent == null)
        {
            return false;
        }
        if (childParent == parent)
        {
            return true;
        }

        return isChild(parent, childParent);
    }

    /**
     * Get the list of the incoming/outgoing connections
     * 
     * @param gElt the graphical element
     * @return the list of connections
     */
    public static List<GraphEdge> getEdges(GraphElement gElt)
    {
        List<GraphEdge> connections = new ArrayList<GraphEdge>();
        for (GraphConnector connector : gElt.getAnchorage())
        {
            connections.addAll(connector.getGraphEdge());
        }
        return connections;
    }

    /**
     * Get the list of the outgoing connection
     * 
     * @param gElt the source element
     * @return the list of source connections
     */
    public static List<GraphEdge> getSourceEdges(GraphElement gElt)
    {
        List<GraphEdge> srcConnections = new ArrayList<GraphEdge>();
        for (GraphConnector connector : gElt.getAnchorage())
        {
            for (GraphEdge edge : connector.getGraphEdge())
            {
                if (connector == edge.getAnchor().get(0))
                {
                    srcConnections.add(edge);
                }
            }
        }
        return srcConnections;
    }

    /**
     * Get the list of the incoming connection
     * 
     * @param gElt the source element
     * @return the list of target connections
     */
    public static List<GraphEdge> getTargetEdges(GraphElement gElt)
    {
        List<GraphEdge> tgtConnections = new ArrayList<GraphEdge>();
        for (GraphConnector connector : gElt.getAnchorage())
        {
            for (GraphEdge edge : connector.getGraphEdge())
            {
                if (edge.getAnchor().size() == 2 && connector == edge.getAnchor().get(1))
                {
                    tgtConnections.add(edge);
                }
            }
        }
        return tgtConnections;
    }

    /**
     * Used to get the model object that is the root of the current diagram
     * 
     * @param graphElement
     * @return the root model object of the current diagram
     */
    public static EObject getDiagramModelObject(GraphElement graphElement)
    {
        return Utils.getElement(getDiagram(graphElement));
    }

    /**
     * Used to get the Diagram node of a given graphElement
     * 
     * @param graphElement
     * @return the current Diagram
     */
    public static Diagram getDiagram(GraphElement graphElement)
    {
        if (graphElement != null && graphElement.getContainer() != null)
        {
            return getDiagram(graphElement.getContainer());
        }
        if (graphElement instanceof Diagram)
        {
            return (Diagram) graphElement;
        }
        return null;
    }

    /**
     * Used to get the Diagrams of GraphElements
     * 
     * @param graphElements the elements to have the diagram
     * @return the current Diagram
     */
    public static Diagram[] getDiagrams(GraphElement[] graphElements)
    {
        List<Diagram> diagrams = new ArrayList<Diagram>();

        for (int i = 0; i < graphElements.length; i++)
        {
            Diagram diag = getDiagram(graphElements[i]);
            if (diag != null && !diagrams.contains(diag))
            {
                diagrams.add(diag);
            }
        }

        return diagrams.toArray(new Diagram[diagrams.size()]);
    }

    /**
     * This api will expose the diagram at the location given in absolute co-ordinates.
     * 
     * @param canvas
     * @param location
     */
    public static void exposeLocation(FigureCanvas canvas, Point location)
    {
        Point loc = location.getCopy();
        int padding = 50;
        if (loc.x >= 0)
        {
            loc.x += padding;
        }
        else
        {
            location.x -= padding;
        }

        if (loc.y >= 0)
        {
            loc.y += padding;
        }
        else
        {
            loc.y -= padding;
        }

        int viewPortXLocation = canvas.getBounds().x; // getViewport().getHorizontalRangeModel().getValue();
        int viewPortXExtent = canvas.getBounds().x + canvas.getBounds().width; // getViewport().getHorizontalRangeModel()
        // .getExtent();

        int viewPortYLocation = canvas.getBounds().y; // getViewport().getVerticalRangeModel().getValue();
        int viewPortYExtent = canvas.getBounds().y + canvas.getBounds().height; // Viewport().getVerticalRangeModel().
        // getExtent();

        int deltaX = 0;
        int deltaY = 0;

        if (loc.x < viewPortXLocation)
        {
            deltaX = loc.x - viewPortXLocation;
        }
        else if (loc.x > viewPortXExtent)
        {
            deltaX = loc.x - viewPortXExtent;
        }

        if (loc.y < viewPortYLocation)
        {
            deltaY = loc.y - viewPortYLocation;
        }
        else if (loc.y > viewPortYExtent)
        {
            deltaY = loc.y - viewPortYExtent;
        }

        RangeModel hRange = canvas.getViewport().getHorizontalRangeModel();
        RangeModel vRange = canvas.getViewport().getVerticalRangeModel();
        if ((deltaX != 0) || (deltaY != 0))
        {
            canvas.getViewport().setIgnoreScroll(true);
            int x = hRange.getValue() + deltaX;
            int y = vRange.getValue() + deltaY;
            if (x < 0)
            {
                x = 0;
            }
            if (y < 0)
            {
                y = 0;
            }
            canvas.scrollSmoothTo(x, y);
            canvas.getViewport().setIgnoreScroll(false);
        }
    }

    /**
     * Search in the DiagramGraphConf the first NodeGraphConf with the corresponding EClass and presentation that
     * validate all the constraints when they exist
     * 
     * @param diagGraphConf the DiagramGraphConf that contains all the NodeGraphConf objects
     * @param modelObject the model object that should correspond to a NodeGraphConf
     * @param presentation the presentation to match
     * @return the first NodeGraphConf that match all the constraints
     */
    public static NodeGraphConf getNodeGraphConf(DiagramGraphConf diagGraphConf, EObject modelObject, String presentation)
    {
        NodeGraphConf nodeGraphConf = null;
        boolean isFound = false;

        // Get the list of the NodeGraphConf that belongs to a given EClass and
        // presentation
        List<NodeGraphConf> allNodes = diagGraphConf.getListNodeGraphConf(modelObject.eClass(), presentation);

        for (Iterator<NodeGraphConf> itNodes = allNodes.iterator(); itNodes.hasNext() && !isFound;)
        {
            nodeGraphConf = itNodes.next();
            boolean validateConstraints = true;

            // Iterates on all the existing constraints that should
            for (Constraint constraint : (List<Constraint>) nodeGraphConf.getConstraint())
            {
                // all the constraints should be valid
                try
                {
                    validateConstraints = validateConstraints && EvaluatorsManager.getInstance().evaluate(modelObject, constraint.getRule(), constraint.getLanguage());
                }
                catch (EvaluatorException ee)
                {
                    // A problem occured during the evaluation of the
                    // constraint. We consider that the constraint is not valid
                    // and that the object is compliant with it.
                    // Then Just log
                    ModelerPlugin.log(ee);
                }
            }
            if (validateConstraints)
            {
                // a NodeGraphConf that validate all the constraints was found
                isFound = true;
            }
        }

        // TODO Iterates on the ESuperTypes of the EClass associated with the
        // modelObject to check whether a configuration corresponding to a
        // parent object may be used
        return nodeGraphConf;
    }

    /**
     * Search in the DiagramGraphConf the first EdgeGraphConf with the corresponding EClass and presentation that
     * validate all the constraints when they exist
     * 
     * @param diagGraphConf the DiagramGraphConf that contains all the EdgeGraphConf objects
     * @param modelObject the model object that should correspond to an EdgeGraphConf
     * @param presentation the presentation to match
     * @return the first EdgeGraphConf that match all the constraints
     */
    public static EdgeGraphConf getEdgeGraphConf(DiagramGraphConf diagGraphConf, EObject modelObject, String presentation)
    {
        EdgeGraphConf edgeGraphConf = null;
        boolean isFound = false;
        if (diagGraphConf == null || modelObject == null)
        {
            return null;
        }

        // Get the list of the EdgeGraphConf that belongs to a given EClass and
        // presentation
        List allEdges = diagGraphConf.getListEdgeGraphConf(modelObject.eClass(), presentation);

        for (Iterator<EdgeGraphConf> itEdges = allEdges.iterator(); itEdges.hasNext() && !isFound;)
        {
            edgeGraphConf = itEdges.next();
            boolean validateConstraints = true;

            // Iterates on all the existing constraints that should
            for (Constraint constraint : (List<Constraint>) edgeGraphConf.getConstraint())
            {
                // all the constraints should be valid
                try
                {
                    validateConstraints = validateConstraints && EvaluatorsManager.getInstance().evaluate(modelObject, constraint.getRule(), constraint.getLanguage());
                }
                catch (EvaluatorException ee)
                {
                    // A problem occured during the evaluation of the
                    // constraint. We consider that the constraint is not valid
                    // and that the object is compliant with it.
                    // Then Just log
                    ModelerPlugin.log(ee);
                }
            }
            if (validateConstraints)
            {
                // an EdgeGraphConf that validate all the constraints was found
                isFound = true;
            }
        }

        // TODO Iterates on the ESuperTypes of the EClass associated with the
        // modelObject to check whether a configuration corresponding to a
        // parent object may be used
        return edgeGraphConf;
    }

    /**
     * Returns the diagrams for any eobject
     * 
     * @param any
     * @return
     */
    public static Diagrams getDiagrams(EObject any)
    {
        if (any != null && any.eResource() != null && any.eResource().getResourceSet() != null)
        {
            ResourceSet set = any.eResource().getResourceSet();
            for (Resource r : set.getResources())
            {
                if (!r.getContents().isEmpty() && r.getContents().get(0) instanceof Diagrams)
                {
                    return (Diagrams) r.getContents().get(0);
                }
            }
        }
        return null;
    }

    /**
     * Get the optimized diagram dimension. The new dimension is based on the bottom bounds of the graphical element
     * which is the lowest for the height and the right bound of the graphical element which is the most right for the
     * width, plus the diagram's margins. If the diagram has a "landscape" orientation, then the height and the width of
     * the dimension are switched.
     * 
     * @param modeler the modeler of the diagram
     * @return the new dimension of the diagram
     */
    public static Dimension getDiagramOptimizedDimension(Modeler modeler)
    {
        return getDiagramOptimizedDimension(modeler.getRootEditPart(), modeler.getActiveDiagram());
    }

    public static Dimension getDiagramOptimizedDimension(RootEditPart root, Diagram activeDiagram)
    {
        Dimension dim = new Dimension(0, 0);
        // Populate the allEditPartChildren
        Set<GraphicalEditPart> allEditPartChildren = getAllChildren(root, new HashSet<GraphicalEditPart>());
        for (GraphicalEditPart part : allEditPartChildren)
        {
            // Added validate action to update the editPart with the graphNode properties
            if (part.getFigure().getParent() != null)
            {
                part.getFigure().getParent().validate();
            }
            else
            {
                part.getFigure().validate();
            }
            int bottom = part.getFigure().getBounds().bottom();
            int right = part.getFigure().getBounds().right();
            if (dim.height < bottom)
            {
                dim.height = bottom;
            }
            if (dim.width < right)
            {
                dim.width = right;
            }
        }

        // adding the margins
        int topMargin = Integer.parseInt(DIUtils.getPropertyValue(activeDiagram, ModelerPropertyConstants.TOP_MARGIN));
        int bottomMargin = Integer.parseInt(DIUtils.getPropertyValue(activeDiagram, ModelerPropertyConstants.TOP_MARGIN));
        int leftMargin = Integer.parseInt(DIUtils.getPropertyValue(activeDiagram, ModelerPropertyConstants.LEFT_MARGIN));
        int rightMargin = Integer.parseInt(DIUtils.getPropertyValue(activeDiagram, ModelerPropertyConstants.RIGHT_MARGIN));

        dim.height = dim.height + topMargin + bottomMargin + AUTOSIZE_MARGIN;
        dim.width = dim.width + leftMargin + rightMargin + AUTOSIZE_MARGIN;

        // Check the orientation of the diagram. If the orientation is not "portrait" then we switch the width and the
        // height.
        if (!isPortraitOrientation(activeDiagram))
        {
            int tmp = dim.height;
            dim.height = dim.width;
            dim.width = tmp;
        }

        return dim;
    }

    /**
     * Returns the references to the source object.
     * 
     * @param source the source
     * @return a collection of references
     */
    public static Collection<Setting> getCrossReferences(EObject source)
    {
        Collection<Setting> collection = null;
        ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter.getCrossReferenceAdapter(source);
        if (crossReferenceAdapter != null)
        {
            collection = crossReferenceAdapter.getNonNavigableInverseReferences(source);
        }
        else
        {
            collection = EcoreUtil.UsageCrossReferencer.find(source, source.eResource().getResourceSet());
        }
        return !collection.isEmpty() ? collection : Collections.<Setting> emptyList();
    }

    /**
     * Check the diagram orientation
     * 
     * @return true if the currentDiagram has a Portrait orientation, false if it has a Landscape Orientation. Return
     *         false if the currentDiagram is null.
     */
    public static boolean isPortraitOrientation(DiagramElement diagram)
    {
        if (diagram != null)
        {
            return ModelerPropertyConstants.PORTRAIT_ORIENTATION.equals(DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.ORIENTATION));
        }
        return false;
    }

    /**
     * A recursive method to populate the allEditPartChildren set. This method add all the children edit part nodes of
     * the given parent editPart to the set, except instance of DiagramEditPart.
     * 
     * @param editPart the parent EditPart
     * @param allEditPartChildren the Set to populate
     * @return allEditPartChildren the set populate
     */
    private static Set<GraphicalEditPart> getAllChildren(EditPart editPart, Set<GraphicalEditPart> allEditPartChildren)
    {
        List children = editPart.getChildren();
        for (int i = 0; i < children.size(); i++)
        {
            GraphicalEditPart child = (GraphicalEditPart) children.get(i);
            if (!(child instanceof DiagramEditPart))
            {
                allEditPartChildren.add(child);
            }
            allEditPartChildren = getAllChildren(child, allEditPartChildren);

        }
        return allEditPartChildren;
    }

    /**
     * Creates the author eAnnotation.
     * 
     * @param modelElement the eAnnotation owner
     * @param authorName the author name
     */
    public static void createAuthorEAnnotation(EModelElement modelElement, String authorName)
    {
        EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
        annotation.setSource(IAnnotationConstants.AUTHOR_SOURCE);
        modelElement.getEAnnotations().add(annotation);

        annotation.getDetails().put(IAnnotationConstants.AUTHOR_KEY, authorName);
    }

    /**
     * Creates the documentation eAnnotation.
     * 
     * @param modelElement the eAnnotation owner
     * @param documentation the documentation content
     */
    public static void createDocumentationEAnnotation(EModelElement modelElement, String documentation)
    {
        if (modelElement != null && documentation != null && documentation.length() != 0)
        {
            EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
            annotation.setSource(IAnnotationConstants.DOCUMENTATION_SOURCE);
            modelElement.getEAnnotations().add(annotation);
            annotation.getDetails().put(IAnnotationConstants.DOCUMENTATION_KEY, documentation);
        }
    }

    /**
     * Creates the extensionAuthor eAnnotation.
     * 
     * @param modelElement the eAnnotation owner
     * @param authorName the author name
     */
    public static void createExtensionAuthorEAnnotation(EModelElement modelElement, String stereotypeName, String level)
    {
        EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
        annotation.setSource(IAnnotationConstants.EXTENSION_AUTHOR_SOURCE);
        modelElement.getEAnnotations().add(annotation);

        annotation.getDetails().put(stereotypeName, level);
    }

    /**
     * Formats the class name so that compound class names are split with ' '. For example, with the argument
     * "StateMachine", the method returns "State Machine".
     * 
     * @param className the class name
     * @return the formatted class name
     */
    public static String formatClassName(String className)
    {
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for (char c : className.toCharArray())
        {
            if (first)
            {
                builder.append(c);
                first = false;
            }
            else if (Character.isUpperCase(c))
            {
                builder.append(" " + c);
            }
            else
            {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    /**
     * For this comparator a connection is at the beginning of a list
     */
    public static class EditPartComparator implements Comparator<AbstractGraphicalEditPart>
    {
        public int compare(AbstractGraphicalEditPart o1, AbstractGraphicalEditPart o2)
        {
            if (o1 instanceof BaseEditPart && o2 instanceof BaseEditPart || o1 instanceof AbstractConnectionEditPart && o2 instanceof AbstractConnectionEditPart)
            {
                return 0;
            }
            else if (o1 instanceof BaseEditPart && o2 instanceof AbstractConnectionEditPart)
            {
                return 1;
            }
            else if (o1 instanceof AbstractConnectionEditPart && o2 instanceof BaseEditPart)
            {
                return -1;
            }

            return 0;
        }
    }

    /**
     * Get the current modeler
     * 
     * @return null if there is no opened modeler
     */
    public static Modeler getCurrentModeler()
    {
        IWorkbench workbench = PlatformUI.getWorkbench();
        if (workbench != null)
        {
            IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
            if (activeWorkbenchWindow != null)
            {
                IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
                if (activePage != null)
                {
                    if (activePage.getActiveEditor() instanceof Modeler)
                    {
                        return (Modeler) activePage.getActiveEditor();
                    }
                }
            }
        }
        return null;

    }

    /**
     * This classes sorts all eobjects at the same rank except eobjects linked to graphelement typed GraphEdge these
     * elements mus be at the beginning of list
     */
    public static class EObjectComparatorForGraphElements implements Comparator
    {

        private final Diagrams di;

        public EObjectComparatorForGraphElements(Diagrams diagrams)
        {
            di = diagrams;
        }

        public int compare(Object o1, Object o2)
        {
            if (di != null)
            {
                if (o1 instanceof EObject)
                {
                    GraphElement[] elements = Utils.getGraphElements(di, (EObject) o1);
                    if (elements != null && elements.length > 0)
                    {
                        GraphElement element = elements[0];
                        if (element instanceof GraphEdge)
                        {
                            return -1;
                        }
                    }
                }
                if (o2 instanceof EObject)
                {
                    GraphElement[] elements = Utils.getGraphElements(di, (EObject) o2);
                    if (elements != null && elements.length > 0)
                    {
                        GraphElement element = elements[0];
                        if (element instanceof GraphEdge)
                        {
                            return 1;
                        }
                    }
                }
            }
            return 0;
        }
    }

    /**
     * Get from a list of int a string with space separated values
     * 
     * @param featureIDs
     * @return
     */
    public static String getSpaceSeparated(int... featureIDs)
    {
        String result = "";
        for (int feature : featureIDs)
        {
            result += feature + " ";
        }
        return result;
    }

    /**
     * get from a string with ints separated by spaces an array of structural features of the given eclass
     * 
     * @param intFeaturesSpaceSeparated
     * @param eClass
     * @return
     */
    public static EStructuralFeature[] getEStructuralFeatures(String intFeaturesSpaceSeparated, EClass eClass)
    {
        String[] split = intFeaturesSpaceSeparated.split(" ");
        EStructuralFeature[] features = new EStructuralFeature[split.length];
        for (int i = 0; i < split.length; i++)
        {
            features[i] = eClass.getEStructuralFeature(Integer.parseInt(split[i]));
        }
        return features;
    }

    /**
     * Returns the good preference store according to varibale currentIFile in Modeler If there is a problem, returns
     * the ModelerPlugin.getDefault().getPreferenceStore()
     */
    public static IPreferenceStore getPreferenceStoreAccordingToCurrentIFile(AbstractUIPlugin plugin)
    {
        if (plugin == null)
        {
            throw new IllegalArgumentException("argument can not be null");
        }
        IFile currentFile = Modeler.getCurrentIFile();
        String pluginId = plugin.getBundle().getSymbolicName();
        if (currentFile != null)
        {
            IProject project = currentFile.getProject();
            IEclipsePreferences root = Platform.getPreferencesService().getRootNode();
            if (project != null && root != null)
            {
                try
                {
                    if (root.node(ProjectScope.SCOPE).node(project.getName()).nodeExists(pluginId))
                    {
                        return new ScopedPreferenceStore(new ProjectScope(project), pluginId);
                    }
                }
                catch (BackingStoreException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return ModelerPlugin.getDefault().getPreferenceStore();
    }

    /**
     * Returns the good preference store according to varibale currentIFile in Modeler If there is a problem, returns
     * the ModelerPlugin.getDefault().getPreferenceStore()
     */
    public static IPreferenceStore getPreferenceStoreAccordingToCurrentIFile()
    {
        return getPreferenceStoreAccordingToCurrentIFile(ModelerPlugin.getDefault());
    }

    /**
     * This resolve all resolve a resource set This method analyses the resource set by structure and doesn't navigate
     * through cross references without prediction
     * 
     */
    public static void customResolveAll(ResourceSet resourceSet)
    {
        CustomResolver resolver = new CustomResolver(resourceSet);
        resolver.resolve();
    }

    /**
     * Resize children nodes for optimizing the place taken
     * 
     * @param root the root edit part which children should eventually be resized
     * @param stack stack to execute commands
     */
    public static void optimizelyResizeChildren(RootEditPart root, CommandStack stack)
    {
        // Populate the allEditParts
        LinkedHashSet<GraphicalEditPart> allEditParts = new LinkedHashSet<GraphicalEditPart>();
        allEditParts.add((GraphicalEditPart) root.getChildren().get(0));
        getAllChildren(root, allEditParts);
        // resize parts from bottom (tree's leaves) to the top (root)
        List<GraphicalEditPart> allEditPartsList = new ArrayList<GraphicalEditPart>(allEditParts);
        Collections.reverse(allEditPartsList);
        for (GraphicalEditPart part : allEditPartsList)
        {
            OptimizedResizersManager.getInstance().resize(part, stack);
        }
    }
}