/*****************************************************************************
 * Copyright (c) 2010 Topcased.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Jose Alfredo Serrano (Anyware Technologies) - initial API and implementation
 *      Jacques LESCOT (Anyware Technologies) - Improve Diagrams Explorer generation
 *      Anne Haugommard (Atos Origin) - Move method implementations into GenerationService class
  *****************************************************************************/
package org.topcased.modeler.export.html;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.diagrams.model.Diagrams;


/**
 * Provides static methods from Generation services in order to use them inside Xpand/Xtend templates
 */
public class GenerationManager
{
    
    private GenerationManager(){
        //Forbid instanciation
    }
    
    public static String getCoordinates(DiagramElement diagramElement)
    {
        return ServicesManager.INSTANCE.getGenerationService().getCoordinates(diagramElement);
    }

    public static String getImage(Diagram diagram)
    {
        return ServicesManager.INSTANCE.getGenerationService().getImage(diagram);
    }
    
    public static String getHTML(Diagram diagram){
        return ServicesManager.INSTANCE.getGenerationService().getHTML(diagram);
    }
    
    public static String getName(Diagram diagram){
        return ServicesManager.INSTANCE.getGenerationService().getName(diagram);
    }
    
    public static String getDocumentationPage(DiagramElement diagram){
        return ServicesManager.INSTANCE.getGenerationService().getDocumentationPage(diagram);
    }
    
    public static String getDocumentationURL(DiagramElement diagram){
        return ServicesManager.INSTANCE.getGenerationService().getDocumentationURL(diagram);
    }
    
    public static String getDocumentation(GraphElement diagram){
        return ServicesManager.INSTANCE.getGenerationService().getDocumentation(diagram);
    }
    public static String getDiagramDocumentation(Diagram diagram){
        return ServicesManager.INSTANCE.getGenerationService().getDiagramDocumentation(diagram);
    }
    
    public static String getDiagramDocumentationPage(Diagram diagram)
    {
        return ServicesManager.INSTANCE.getGenerationService().getDiagramDocumentationPage(diagram);
    }
    
    public static String getDiagramDocumentationURL(Diagram diagram)
    {
        return ServicesManager.INSTANCE.getGenerationService().getDiagramDocumentationURL(diagram);
    }
    
    public static Boolean hasDiagrams(DiagramElement element)
    {
        return ServicesManager.INSTANCE.getGenerationService().hasDiagrams(element);
    }
    
    public static String getDiagram(DiagramElement element)
    {
        return ServicesManager.INSTANCE.getGenerationService().getDiagram(element);
    }
    
    public static String getParentDiagramPage(Diagram diagram){
        return ServicesManager.INSTANCE.getGenerationService().getParentDiagramPage(diagram);
    }
    
    public static String getRootDiagramPage(Diagram diagram)
    {
        return ServicesManager.INSTANCE.getGenerationService().getRootDiagramPage(diagram);
    }
    
    public static Set<EObject> getElements(Diagrams diagrams)
    {
        return ServicesManager.INSTANCE.getGenerationService().getElements(diagrams);
    }
    
    public static Set<Diagram> getDiagrams(EObject key)
    {
        return ServicesManager.INSTANCE.getGenerationService().getDiagrams(key);
    }
    
    public static String getName(EObject element){
        return ServicesManager.INSTANCE.getGenerationService().getName(element);
    }
    
    public static List<EObject> getChildrenSemanticElements(EObject element)
    {
        return ServicesManager.INSTANCE.getGenerationService().getChildrenSemanticElements(element);
    }
    
    public static String getModelElementType(GraphElement diagram){
    	return ServicesManager.INSTANCE.getGenerationService().getModelElementType(diagram);
    }
    
    public static List<DiagramElement> sortListByCoordinates(List<DiagramElement> listToSort){
    	return ServicesManager.INSTANCE.getGenerationService().sortListByCoordinates(listToSort);
    }
}
