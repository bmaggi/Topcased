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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.topcased.modeler.IAnnotationConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.SemanticModelBridge;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.export.html.internal.util.ExportUtils;
import org.topcased.modeler.utils.Utils;

/**
 * This class stores important information such as locations, naming, pages, diagrams, necessary during generation
 * process.
 * 
 * @author <a href="mailto:jose.alfredo.serrano@anyware-tech.com">Jose Alfredo SERRRANO</a>
 * 
 */
public final class GenerationManager
{
    private GenerationManager()
    {
        // forbid instantiation.
    }

    private static Map<Diagram, String> diagName = new HashMap<Diagram, String>();

    // For a given diagram, store a set of PartPositionInfo
    private static Map<Diagram, List<PartPositionInfo>> locations = new HashMap<Diagram, List<PartPositionInfo>>();

    // A cached value of all documentation pages
    private static Map<EObject, String> pages = new HashMap<EObject, String>();

    private static Map<EObject, Set<Diagram>> diagrams_map = new HashMap<EObject, Set<Diagram>>();

    public static void putDiagramName(Diagram diagram, String image)
    {
        diagName.put(diagram, image);
    }

    /**
     * Check whether the diagram name is "valid", i.e does not contains any weird character, such as '/' to avoid the following Exception :
     * java.io.IOException: The system cannot find the path specified 
     */
    public static String getName(Diagram diagram)
    {
        String name = diagName.get(diagram);
        return name != null ? name : ExportUtils.encodeFileName(diagram.getName());
    }

    public static String getImage(Diagram diagram)
    {
        String name = diagName.get(diagram);
        return name != null ? name + ".png" : "";
    }

    public static String getHTML(Diagram diagram)
    {
        String name = diagName.get(diagram);
        return name != null ? name + ".htm" : "";
    }

    public static void putLocation(Diagram diagram, List<PartPositionInfo> value)
    {
        locations.put(diagram, value);
    }

    public static List<PartPositionInfo> getLocation(Diagram diagram)
    {
        return locations.get(diagram);
    }

    /**
     * Clear generation data.
     */
    public static void clear()
    {
        diagName.clear();
        locations.clear();
        pages.clear();
        diagrams_map.clear();
    }

    public static void sortDiagrams(List<Diagram> allDiagrams)
    {
        List<String> diagramNames = new ArrayList<String>();
        for (Diagram diagram : allDiagrams)
        {
            EObject element = ((EMFSemanticModelBridge) diagram.getSemanticModel()).getElement();
            Set<Diagram> list = diagrams_map.get(element);
            if (list == null)
            {
                list = new HashSet<Diagram>();
                diagrams_map.put(element, list);
            }
            list.add(diagram);

            // List of all the diagram names contained by the Diagrams file
            String uniqueFileName = ExportUtils.encodeFileName(diagram.getName());
            if (diagramNames.contains(uniqueFileName))
            {
                uniqueFileName = ExportUtils.getFirstAvailableName(uniqueFileName, diagramNames, 1);
            }
            diagramNames.add(uniqueFileName);
            putDiagramName(diagram, uniqueFileName);
        }
    }

    /**
     * @param diagramElement The element to locate within the map image.
     * 
     * @return Return the coordinates of the given element, relative to the generated image size.
     */
    public static String getCoordinates(DiagramElement diagramElement)
    {
        SemanticModelBridge bridge = ((GraphElement) diagramElement).getSemanticModel();
        if (bridge instanceof EMFSemanticModelBridge)
        {
            EObject semanticElt = ((EMFSemanticModelBridge) bridge).getElement();
            if (semanticElt != null)
            {
                URI instanceURI = EcoreUtil.getURI(semanticElt);
                
                List<PartPositionInfo> partInformations = locations.get(getDiag(diagramElement));
                if (partInformations != null)
                {
                    for (PartPositionInfo position : partInformations)
                    {
                        if(position.getSemanticElement() != null){
                            URI semanticURI = EcoreUtil.getURI(position.getSemanticElement());
                            if (instanceURI.equals(semanticURI) && diagramElement == position.getView())
                            {
                                int x1 = position.getPartX();
                                int y1 = position.getPartY();
                                int x2 = x1 + position.getPartWidth();
                                int y2 = y1 + position.getPartHeight();
                                return "" + x1 + "," + y1 + "," + x2 + "," + y2;
                            }                           
                        }
                    }
                }
            }
        }
        return "";
    }

    private static Diagram getDiag(DiagramElement diagramElement)
    {
        if (diagramElement instanceof Diagram)
            return (Diagram) diagramElement;
        return getDiag(diagramElement.getContainer());
    }

    /**
     * @param diagram The documented element.
     * 
     * @return Returns the documentation in html format.
     */
    public static String getDocumentation(GraphElement diagram)
    {
        SemanticModelBridge bridge = diagram.getSemanticModel();
        if (bridge instanceof EMFSemanticModelBridge)
        {
            EMFSemanticModelBridge emfBridge = (EMFSemanticModelBridge) bridge;
            EObject semanticModel = emfBridge.getElement();

            if (semanticModel instanceof EModelElement)
            {
                EModelElement modelElt = (EModelElement) semanticModel;
                String docValue = "";
                EAnnotation annotation = modelElt.getEAnnotation(IAnnotationConstants.DOCUMENTATION_SOURCE);
                if (annotation != null)
                {
                    docValue = annotation.getDetails().get(IAnnotationConstants.DOCUMENTATION_KEY);
                }
                return docValue == null ? null : docValue;
            }
        }
        return null;
    }

    /**
     * Returns the documentation page name if there is any.
     * 
     * @param diagram The documented diagram element
     * @return The documentation page name or null when there is no documentation available.
     */
    public static String getDocumentationPage(DiagramElement diagram)
    {
        String page = pages.get(diagram);
        if (page == null && diagram instanceof GraphElement)
        {
            GraphElement graphElement = (GraphElement) diagram;
            String doc = getDocumentation(graphElement);
            if (doc != null && doc.length() > 0)
            {
                SemanticModelBridge bridge = graphElement.getSemanticModel();
                if (bridge instanceof EMFSemanticModelBridge)
                {
                    EMFSemanticModelBridge emfBridge = (EMFSemanticModelBridge) bridge;
                    EObject semanticModel = emfBridge.getElement();
                    String id = EcoreUtil.getID(semanticModel);
                    id = id != null ? id : EcoreUtil.getURI(semanticModel).fragment();
                    page = id + ".htm";
                    pages.put(semanticModel, page);
                }
            }

        }
        return page;
    }

    /**
     * @param diagram The documented element.
     * 
     * @return Returns the documentation in html format.
     */
    public static String getDiagramDocumentation(Diagram diagram)
    {
        if (diagram != null)
        {
            EAnnotation annotation = diagram.getEAnnotation(IAnnotationConstants.DOCUMENTATION_SOURCE);
            if (annotation != null)
            {
                return annotation.getDetails().get(IAnnotationConstants.DOCUMENTATION_KEY);
            }
        }
        return null;
    }

    /**
     * Returns the documentation page name if there is any.
     * 
     * @param diagram The documented diagram element
     * @return The documentation page name or null when there is no documentation available.
     */
    public static String getDiagramDocumentationPage(Diagram diagram)
    {
        String page = pages.get(diagram);
        if (page == null)
        {
            String doc = getDiagramDocumentation(diagram);
            if (doc != null && doc.length() > 0)
            {
                String id = EcoreUtil.getID(diagram);
                id = id != null ? id : EcoreUtil.getURI(diagram).fragment();
                page = id + ".htm";
                pages.put(diagram, page);
            }

        }
        return page;
    }

    /**
     * 
     * @see GenerationManager#getDocumentationPage(DiagramElement)
     * 
     * @return Returns a complete url of the page to display. A special page is displayed when No documentation is
     *         available.
     */
    public static String getDiagramDocumentationURL(Diagram diagram)
    {
        String page = getDiagramDocumentationPage(diagram);
        return page == null ? "../noDoc.html" : "documentation/" + page;
    }

    /**
     * 
     * @see GenerationManager#getDocumentationPage(DiagramElement)
     * 
     * @return Returns a complete url of the page to display. A special page is displayed when No documentation is
     *         available.
     */
    public static String getDocumentationURL(DiagramElement diagram)
    {
        String page = getDocumentationPage(diagram);
        return page == null ? "../noDoc.html" : "documentation/" + page;
    }

    /**
     * @param element
     * @return Returns <code>true</code> if the given element has diagram representations.
     */
    public static Boolean hasDiagrams(DiagramElement element)
    {
        if (element instanceof GraphElement)
        {
            GraphElement gElement = (GraphElement) element;
            SemanticModelBridge bridge = gElement.getSemanticModel();
            if (bridge instanceof EMFSemanticModelBridge)
            {
                EObject semanticElt = ((EMFSemanticModelBridge) bridge).getElement();

                return diagrams_map.get(semanticElt) != null && !diagrams_map.get(semanticElt).isEmpty();
            }
        }

        return false;
    }

    /**
     * @param element
     * @return Returns the name of the related diagram. If several diagrams are linked to the given element, then we
     *         return the first.
     */
    public static String getDiagram(DiagramElement element)
    {
        if (element instanceof GraphElement)
        {
            GraphElement gElement = (GraphElement) element;
            SemanticModelBridge bridge = gElement.getSemanticModel();
            if (bridge instanceof EMFSemanticModelBridge)
            {
                EObject semanticElt = ((EMFSemanticModelBridge) bridge).getElement();

                Set<Diagram> set = diagrams_map.get(semanticElt);
                if (set != null && !set.isEmpty())
                {
                    Diagram diagram = set.iterator().next();
                    return getHTML(diagram);
                }
            }
        }

        return null;
    }

    /**
     * 
     * @param diagrams
     * @return return a set of elements which have related diagrams
     */
    public static Set<EObject> getElements(Diagrams diagrams)
    {
        Set<EObject> set = diagrams_map.keySet();
        return set != null ? set : Collections.EMPTY_SET;
    }

    /**
     * @param key The EObject related to some diagrams
     * @return A set of diagrams related to the given {@link EObject}.
     */
    public static Set<Diagram> getDiagrams(EObject key)
    {
        Set<Diagram> set = diagrams_map.get(key);
        return set != null ? set : Collections.EMPTY_SET;
    }

    /**
     * @param element The element to be transformed
     * @return Return a string representation of the given EObject
     */
    public static String getName(EObject element)
    {
        // Get the adapter from the factory.
        ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

        // Get the label provider
        IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory.adapt(element, IItemLabelProvider.class);

        // Get the result
        String result = itemLabelProvider != null ? itemLabelProvider.getText(element) : element == null ? "" : element.toString();

        // Remove all '<' or '>' to avoid problems with scripts and css
        return result.replaceAll("<", "[").replaceAll(">", "]");
    }

    /**
     * Retrieve the html page of the diagram considered as the root one
     * 
     * @param diagram a Diagram from which the search will start
     * @return the name of the corresponding html page
     */
    public static String getRootDiagramPage(Diagram diagram)
    {
        // TODO Improvement could be done here, for example caching that value to increase speed, since all generated
        // diagrams page will have to call that method
        return getHTML(DiagramsUtils.getRootDiagram(DiagramsUtils.findRootDiagrams((Diagrams) diagram.eContainer())));
    }

    /**
     * Retrieve the html page of the diagram considered as the parent regarding to the given one
     * 
     * @param diagram a Diagram from which the search will start
     * @return the name of the corresponding html page
     */
    public static String getParentDiagramPage(Diagram diagram)
    {
        List<Diagram> parentDiagrams = new ArrayList<Diagram>();

        if (diagram != null)
        {
            // Get the model object (the model object associated with the current diagram and its parent in the model)
            EObject modelObject = Utils.getElement(diagram.getSemanticModel().getGraphElement());

            while (modelObject != null && modelObject.eContainer() != null && parentDiagrams.isEmpty())
            {
                EObject parentModelObject = modelObject.eContainer();
                // We search if a diagram already exists
                parentDiagrams = DiagramsUtils.findAllExistingDiagram(DiagramsUtils.findRootDiagrams((Diagrams) diagram.eContainer()), parentModelObject);
                modelObject = parentModelObject;
            }
        }
        // in case none parent diagram is found (because the diagram is considered as the root one - or one of its
        // brother) we return "#" so that the 'href' attribute of the link still point to the current page
        return parentDiagrams.isEmpty() ? "#" : getHTML(parentDiagrams.get(0));
    }
    
    public static List<EObject> getChildrenSemanticElements(EObject element)
    {
        List<EObject> allChildren = new ArrayList<EObject>();
        for (EObject child : element.eContents())
        {
            if (hasDiagrams(child))
            {
                allChildren.add(child);
            }
        }
        return allChildren;
        
    }
    
    /**
     * Test whether the given element has one or more diagrams among one of its child elements.
     * 
     * @param element the semantic element to test
     * @return <code>true</code> or <code>false</code>
     */
    private static boolean hasDiagrams(EObject element)
    {
        if (diagrams_map.get(element) != null)
        {
            return true;
        }
        
        for (EObject child : element.eContents())
        {
            if (hasDiagrams(child))
            {
                return true;
            }
        }
        return false;
    }

}
