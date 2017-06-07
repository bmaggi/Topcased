/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Caroline Bourdeu d'Aguerre (2009) caroline.bourdeudaguerre@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.edit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.swt.dnd.Transfer;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.EMFSemanticModelBridge;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.editor.outline.OutlineToDiagramTransfer;
import org.topcased.modeler.utils.Utils;

// TODO: Auto-generated Javadoc
/**
 * The Class DynamicInstanceEditPartController.
 */
public class DynamicInstanceEditPartController
{

    /** The Constant INSTANCE_LITERAL. */
    private static final String INSTANCE_LITERAL = "instance";

    /** The Constant RECOGNIZED_TYPE. */
    private static final String RECOGNIZED_TYPE = "recognizedType";
 
    /** The Constant IS_A_NODE. */
    private static final String IS_A_NODE = "isANode";

    /** All plugin plug to the extension point. */
    private IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointID);
    
    /** The extension point. */
    private static String extensionPointID = "org.topcased.modeler.customEditPart";

    /** This is a singleton. */
    public static DynamicInstanceEditPartController instance = new DynamicInstanceEditPartController();
    
    public List<CustomEditPartExtension> listExtension;

	/**
     * The constructor is private to not be call.
     */
    private DynamicInstanceEditPartController ()
    {}
    
    /**
     * This method call all the plug register to the extension point
     * If a plug-in match the type of the element it will call to create the corresponding editPart.
     * 
     * @param obj the obj
     * @param element the element
     * @param diagramType the current diagram type (class of its factory)
     * 
     * @return the editPart
     */
    public EditPart getInstanceEditPart(EObject obj, GraphElement element, Class< ? > diagramType)
    {
        EditPart editPart = null;
        // For all registered elements
		for (CustomEditPartExtension ext : getExtensions())
		{
            try
            {
            	 Class< ? > recognizedTypeClass = Platform.getBundle(ext.contributorName).loadClass(ext.recognizedType);
                // If the plug-in match the given element
                if (obj != null && recognizedTypeClass.isAssignableFrom(obj.getClass())) 
                {
                    // Create the editPart
                   
                    if (ext.specific != null)
                    {
                        editPart = ext.specific.defaultCase(element,diagramType);
                        if (editPart != null)
                        {
                            break ;
                        }
                    }
                }
            }
            catch (InvalidRegistryObjectException e2)
            {
                e2.printStackTrace();
            }
            catch (ClassNotFoundException e2)
            {
                e2.printStackTrace();
            }
        }
        if (editPart == null)
        {
            if (element instanceof GraphNode)
            {
                GraphNode node = (GraphNode) element;
                editPart = new EMFGraphNodeEditPart(node); 
            }
            else if (element instanceof GraphEdge)
            {
                GraphEdge edge = (GraphEdge) element ;
                editPart = new EMFGraphEdgeEditPart(edge);
            }
        }
        return editPart;
        
    }
    
    /**
     * Checks if is enabled.
     * 
     * @param objects the objects
     * @param targetEditPart the target edit part
     * 
     * @return true, if is enabled
     */
    public boolean isEnabled(Collection<?> objects, EditPart targetEditPart)
    {
        boolean result = false ;
        ISpecificCase specific;
        
		for (CustomEditPartExtension ext : getExtensions())
		{
            for (Object o : objects)
            {
                // Try with some plug-in
                try
                {
                    String recognizedType = ext.recognizedType;
                    Class< ? > recognizedTypeClass = Platform.getBundle(ext.contributorName).loadClass(recognizedType);
                    if (recognizedTypeClass.isAssignableFrom(o.getClass()))
                    {
                        specific = (ISpecificCase)ext.specific;
                        if (specific != null)
                        {
                            result |= specific.isEnabled(o, targetEditPart);
                        }
                    }
                }
                catch (InvalidRegistryObjectException e2)
                {
                    e2.printStackTrace();
                }
                catch (ClassNotFoundException e3)
                {
                    e3.printStackTrace();
                }
            }

        }
        return result ;        
    }

    
	/**
	 * Checks if the child can dropped in the diagram
	 * 
	 * @param child the child
	 * @param parent the parent
	 * @param containerEObject the container e object
	 * 
	 * @return true, if is enabled
	 */
	public boolean isDropable(GraphNode child, GraphNode parent,
			EObject containerEObject) {

		boolean result = false ;

		for (CustomEditPartExtension ext : getExtensions())
		{
			result |= ext.specific.isDropable(Utils.getElement(child), parent);
		}
		return result;
	}
	
	/**
	 * Checks if the child can dropped in the diagram
	 * 
	 * @param child the child
	 * @param parent the parent
	 * @param containerEObject the container e object
	 * 
	 * @return true, if is enabled
	 */
	public boolean isExternalObjectAllowed(GraphNode child, GraphNode parent) {

		boolean result = false ;

		for (CustomEditPartExtension ext : getExtensions())
		{
			result |= ext.specific.isExternalObjectAllowed(child, parent);
		}
		return result;
	}

    private List<CustomEditPartExtension> getExtensions() {
    	if (listExtension == null)
    	{
    		listExtension = new LinkedList<CustomEditPartExtension>();
    		for (IConfigurationElement e : configElements)
    		{
    			try
    			{
    				ISpecificCase specific = (ISpecificCase) e.createExecutableExtension(INSTANCE_LITERAL);
    				if (specific != null)
    				{
    					CustomEditPartExtension extension = new CustomEditPartExtension();
    					extension.recognizedType = e.getAttribute(RECOGNIZED_TYPE);
    					extension.isANode = Boolean.parseBoolean(e.getAttribute(IS_A_NODE));
    					extension.contributorName = e.getContributor().getName();
    					extension.specific = specific;
    					listExtension.add(extension);
    				}
    			}
    			catch (InvalidRegistryObjectException e2)
    			{
    				e2.printStackTrace();
    			}
    			catch (CoreException e1)
    			{
    				e1.printStackTrace();
    			}
    		}
    	}
    	return listExtension;
	}

    /**
     * Create the graphElement depending on the given obj and presentation
     * @param obj
     * @param presentation
     * @return
     */
	public GraphElement createGraphElement(EObject obj, String presentation) {
		GraphElement graphElt = null;

		// For all registered elements
		for (CustomEditPartExtension ext : getExtensions())
		{
			try {
				Class<?> recognizedTypeClass = Platform.getBundle(ext.contributorName).loadClass(ext.recognizedType);

				// If the plug-in match the given element
				if (obj != null && recognizedTypeClass.isAssignableFrom(obj.getClass())) 
				{
					// Create the graphical element
					if (ext.isANode)
					{
						graphElt = DiagramInterchangeFactory.eINSTANCE.createGraphNode();
					}
					else
					{
						graphElt = DiagramInterchangeFactory.eINSTANCE.createGraphEdge();
					}
					EMFSemanticModelBridge bridge = DiagramInterchangeFactory.eINSTANCE.createEMFSemanticModelBridge();
					bridge.setElement(obj);
					bridge.setPresentation(presentation);
					graphElt.setSemanticModel(bridge);
					ext.specific.setPropertyGraphElement(graphElt);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return graphElt;
	}

	/**
	 * Check if the transfer objects are forbidden into the given editpart
	 * @param transfer
	 * @param editPart
	 * @return
	 */
	public boolean isNotDropable(Transfer transfer, EditPart editPart) {
		boolean isDisable = false;
		EditPart diagramEditPart = editPart;
		
		List<EObject> dropableObjects = getDragObject(transfer);
		if (diagramEditPart != null && diagramEditPart.getModel() instanceof GraphNode)
		{
			// For all registered elements
			for (CustomEditPartExtension ext : getExtensions())
			{
				for (EObject obj : dropableObjects)
				{
					try {
						Class<?> recognizedTypeClass = Platform.getBundle(ext.contributorName).loadClass(ext.recognizedType);
						// If the plug-in match the given element
						if (obj != null && recognizedTypeClass.isAssignableFrom(obj.getClass())) 
						{
							isDisable |= !ext.specific.isDropable(obj, (GraphNode)diagramEditPart.getModel());
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		return isDisable;
	}
	
	/**
	 * Check the transfer's objects are dropable into the given editpart
	 * @param transfer
	 * @param editPart
	 * @return
	 */
	public boolean isDropable(Transfer transfer, EditPart editPart) {
		boolean isDisable = false;
		EditPart diagramEditPart = editPart;
		
		List<EObject> dropableObjects = getDragObject(transfer);
		if (diagramEditPart != null && diagramEditPart.getModel() instanceof GraphNode)
		{

			// For all registered elements
			for (CustomEditPartExtension ext : getExtensions())
			{
				Class<?> recognizedTypeClass;
				try {
					recognizedTypeClass = Platform.getBundle(ext.contributorName).loadClass(ext.recognizedType);
					for (EObject obj : dropableObjects)
					{
						if (obj != null && recognizedTypeClass.isAssignableFrom(obj.getClass())) 
						{
							isDisable = ext.specific.isDropable(obj, (GraphNode)diagramEditPart.getModel());
						}
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();

				}
			}
		}
		return isDisable;
	}
	
	/**
	 * Extract the object from the transfer
	 * @param transfer
	 * @return
	 */
    private List<EObject> getDragObject(Transfer transfer)
    {
        ArrayList<EObject> eObjects = new ArrayList<EObject>();
        List<?> objects = new ArrayList<Object>();

        if (transfer instanceof OutlineToDiagramTransfer)
        {
            Object dragObject = ((OutlineToDiagramTransfer) transfer).getObject();
            if (dragObject instanceof List<?>)
            {
                objects = (List<?>) dragObject;

                // We delete all not usable object
                for (Object obj : objects)
                {
                    if ((obj instanceof EObject))
                    {
                        eObjects.add((EObject) obj);
                    }
                }
            }
        }
        return eObjects;
    }

    /**
     * Check if the child type have a corresponding register plug-in 
     * If the type is not matched isValid return true to not impact the behavior 
     * @param child
     * @param parent
     * @return
     */
    public boolean isValid(EObject child, EObject parent) {
    	boolean isValid = true;
    	// For all registered elements
    	for (CustomEditPartExtension ext : getExtensions())
    	{

    		try {
    			Class<?> recognizedTypeClass = Platform.getBundle(ext.contributorName).loadClass(ext.recognizedType);
    			// If the plug-in match the given element
    			if (child != null && recognizedTypeClass.isAssignableFrom(child.getClass())) 
    			{
    				isValid = ext.specific.isValid(child, parent);
    				break;
    			}
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}
    	}

    	return isValid;
	}
    
    /**
     * Class CustomEditPartExtension use to have in cache
     * the list of all the custom editPart to theregister plug-in
     * @author Caroline Bourdeu d'Aguerre
     *
     */
	private class CustomEditPartExtension
	{
		public ISpecificCase specific;
		public String recognizedType;
		public String contributorName;
		public boolean isANode;
	}
    
}
