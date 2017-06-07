/*****************************************************************************
 * Copyright (c) 2010 AtosOrigin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Anne Haugommard (AtosOrigin) anne.haugommard@atosorigin.com 
 *
  *****************************************************************************/
package org.topcased.modeler.export.html;

import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.export.html.internal.PartPositionInfo;

public interface IGenerationService
{
    /**
     * Clear generation data.
     */
    public void clear();

    public void putLocation(Diagram diagram, List<PartPositionInfo> value);

    public void sortDiagrams(List<Diagram> allDiagrams);
    
    
    /**
     * Initialize the diagram file
     * @param iFile
     */
    public void setDiagramFile(IFile iFile);

    /**
     * @param diagramElement The element to locate within the map image.
     * 
     * @return Return the coordinates of the given element, relative to the generated image size.
     */
    public String getCoordinates(DiagramElement diagramElement);

    public String getImage(Diagram diagram);

    public String getHTML(Diagram diagram);

    public String getName(Diagram diagram);

    /**
     * Returns the documentation page name if there is any.
     * 
     * @param diagram The documented diagram element
     * @return The documentation page name or null when there is no documentation available.
     */
    public String getDocumentationPage(DiagramElement diagram);

    /**
     * 
     * @see GenerationService#getDocumentationPage(DiagramElement)
     * 
     * @return Returns a complete url of the page to display. A special page is displayed when No documentation is
     *         available.
     */
    public String getDocumentationURL(DiagramElement diagram);

    /**
     * @param diagram The documented element.
     * 
     * @return Returns the documentation in html format.
     */
    public String getDocumentation(GraphElement diagram);

    /**
     * Get the type of model element associated to the graph element
     * @param diagram The diagram element
     * 
     * @return Returns the name of the associated model element type
     */
    public String getModelElementType(GraphElement diagram);
    
    /**
     * @param diagram The documented element.
     * 
     * @return Returns the documentation in html format.
     */
    public String getDiagramDocumentation(Diagram diagram);

    /**
     * Returns the documentation page name if there is any.
     * 
     * @param diagram The documented diagram element
     * @return The documentation page name or null when there is no documentation available.
     */
    public String getDiagramDocumentationPage(Diagram diagram);

    /**
     * 
     * @see GenerationService#getDocumentationPage(DiagramElement)
     * 
     * @return Returns a complete url of the page to display. A special page is displayed when No documentation is
     *         available.
     */
    public String getDiagramDocumentationURL(Diagram diagram);

    /**
     * @param element
     * @return Returns <code>true</code> if the given element has diagram representations.
     */
    public Boolean hasDiagrams(DiagramElement element);

    /**
     * @param element
     * @return Returns the name of the related diagram. If several diagrams are linked to the given element, then we
     *         return the first.
     */
    public String getDiagram(DiagramElement element);

    /**
     * Retrieve the html page of the diagram considered as the parent regarding to the given one
     * 
     * @param diagram a Diagram from which the search will start
     * @return the name of the corresponding html page
     */
    public String getParentDiagramPage(Diagram diagram);

    /**
     * Retrieve the html page of the diagram considered as the root one
     * 
     * @param diagram a Diagram from which the search will start
     * @return the name of the corresponding html page
     */
    public String getRootDiagramPage(Diagram diagram);

    /**
     * 
     * @param diagrams
     * @return return a set of elements which have related diagrams
     */
    public Set<EObject> getElements(Diagrams diagrams);

    /**
     * @param key The EObject related to some diagrams
     * @return A set of diagrams related to the given {@link EObject}.
     */
    public Set<Diagram> getDiagrams(EObject key);

    /**
     * @param element The element to be transformed
     * @return Return a string representation of the given EObject
     */
    public String getName(EObject element);

    public List<EObject> getChildrenSemanticElements(EObject element);
    
    /**
     * Sort list of diagram elements by coordinates (smallest first)
     * @param listToSort list of diagram elements to sort
     * @return Sorted list of diagram elements
     */
    public List<DiagramElement> sortListByCoordinates(List<DiagramElement> listToSort);
}
