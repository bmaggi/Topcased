/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Thibault Landre (Atos Origin) - Fix #720 : add allGraphElements List
 *******************************************************************************/
package org.topcased.modeler.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.SemanticModelBridge;
import org.topcased.modeler.di.model.SimpleSemanticModelElement;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.edit.EMFGraphEdgeEditPart;
import org.topcased.modeler.edit.EMFGraphNodeEditPart;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.ModelerGraphicalViewer;
import org.topcased.modeler.utils.Utils;

/**
 * <br>
 * creation : 30 juin 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public abstract class AbstractRestoreConnectionCommand extends CompoundCommand
{
    private EditPart restoredPart;
    
    private final EList<GraphElement> allGraphElements;

    /**
     * The constructor
     * 
     * @param part the editPart that is restored
     */
    public AbstractRestoreConnectionCommand(EditPart part)
    {
        super();

        restoredPart = part;

        allGraphElements = setAllGraphElements();

        initializeCommands();
    }


    /**
     * Set the AllGraphElements list
     * @return a list with all graphElements contained in the current active diagram.
     */
    private EList<GraphElement> setAllGraphElements()
    {
        EList<GraphElement> allGraphElements = new BasicEList<GraphElement>();
        Iterator<EObject> itDiagContents = getModeler().getActiveDiagram().eAllContents();
        while (itDiagContents.hasNext())
        {
            EObject eObject = itDiagContents.next();
            if(eObject instanceof GraphElement && DIUtils.getProperty((GraphElement)eObject, ModelerPropertyConstants.ESTRUCTURAL_FEATURE_ID) == null)
            {
                allGraphElements.add((GraphElement)eObject);
            }
        }
        return allGraphElements;
    }
    
    protected EditPart getRestoredPart()
    {
        return restoredPart;
    }

    protected GraphElement getGraphElement()
    {
        if (restoredPart instanceof EMFGraphNodeEditPart || restoredPart instanceof EMFGraphEdgeEditPart)
        {
            return (GraphElement) ((AbstractEditPart) restoredPart).getModel();
        }

        return null;
    }

    protected Map getEditPartRegistry()
    {
        return restoredPart.getViewer().getEditPartRegistry();
    }

    protected EditDomain getEditDomain()
    {
        return restoredPart.getViewer().getEditDomain();
    }

    protected Modeler getModeler()
    {
        return ((ModelerGraphicalViewer) getRestoredPart().getViewer()).getModelerEditor();
    }

    protected List<GraphEdge> getExistingEdges(GraphElement src, GraphElement tgt, String type)
    {
        List<GraphEdge> existingEdges = new ArrayList<GraphEdge>();

        List<GraphEdge> outgoing = Utils.getSourceEdges(src);
        
        for(GraphEdge edge : outgoing)
        {
            GraphElement target = Utils.getTarget(edge);

            if (target == tgt)
            {
                SemanticModelBridge bridge = edge.getSemanticModel();
                if (bridge instanceof SimpleSemanticModelElement)
                {
                    String typeInfo = ((SimpleSemanticModelElement) bridge).getTypeInfo();
                    if (type != null && type.equals(typeInfo))
                    {
                        existingEdges.add(edge);
                    }
                }
            }
        }

        return existingEdges;
    }

    protected List<GraphEdge> getExistingEdges(GraphElement src, GraphElement tgt, Class edgeClass)
    {
        List<GraphEdge> existingEdges = new ArrayList<GraphEdge>();

        // List<GraphEdge> outgoing = ;
        for (GraphEdge edge : Utils.getSourceEdges(src))
        {
            // GraphEdge edge = (GraphEdge) it.next();
            GraphElement target = Utils.getTarget(edge);

            if (target == tgt)
            {
                SemanticModelBridge bridge = edge.getSemanticModel();
                if (bridge instanceof EMFSemanticModelBridge)
                {
                    EObject model = ((EMFSemanticModelBridge) bridge).getElement();
                    if (model != null)
                    {
                        if (edgeClass.isAssignableFrom(model.getClass()))
                        {
                            existingEdges.add(edge);
                        }
                    }
                }
            }
        }

        return existingEdges;
    }

    /**
     * Return true if the list of GraphElement contains at least one GraphElement whose the associated model object is
     * equal to the one passed.
     * 
     * @param eObject a model object
     * @param listElt a List that contains GraphElement objects
     * @return boolean
     */
    protected boolean isAlreadyPresent(List listElt, EObject eObject)
    {
        Iterator itElt = listElt.iterator();
        while (itElt.hasNext())
        {
            GraphElement elt = (GraphElement) itElt.next();
            if (Utils.getElement(elt).equals(eObject))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Return a final list that contains all the graphElements of the current active diagram.
     * @return the final list AllGraphElements
     */
    protected EList<GraphElement> getAllGraphElements()
    {
        return allGraphElements;
    }

    /**
     * Subclasses should implements this to add the restoreCommands that should be added to the global CompoundCommand
     */
    protected abstract void initializeCommands();
}
