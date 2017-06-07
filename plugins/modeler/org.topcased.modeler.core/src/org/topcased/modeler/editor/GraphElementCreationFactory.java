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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.requests.CreationFactory;
import org.topcased.modeler.utils.Utils;

/**
 * Basic factory to create Graph Element objects. <br>
 * creation : 8 nov. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class GraphElementCreationFactory implements CreationFactory
{
    private ICreationUtils creation;

    private EClass eClass;
    
    private String type;
    
    private String presentation = "default";
    
    private boolean isNode = true;

    /**
     * Constructor
     * 
     * @param creation The class to initialize the objects
     * @param eClass the EClass to create
     */
    public GraphElementCreationFactory(ICreationUtils creation, EClass eClass)
    {
        this(creation, eClass, "default");
    }

    /**
     * Constructor
     * 
     * @param creation The class to initialize the objects
     * @param eClass the EClass to create
     * @param presentation the presentation of the graphical element
     */
    public GraphElementCreationFactory(ICreationUtils creation, EClass eClass, String presentation)
    {
        super();
        this.creation = creation;
        this.eClass = eClass;
        this.presentation = presentation;
    }
    
    /**
     * Constructor
     * 
     * @param creation The class to initialize the objects
     * @param type the type identifying the object
     * @param isNode 
     */
    public GraphElementCreationFactory(ICreationUtils creation, String type, boolean isNode)
    {
        this(creation, type, "default", isNode);
    }

    /**
     * Constructor
     * 
     * @param creation The class to initialize the objects
     * @param type the type identifying the object
     * @param presentation the presentation of the graphical element
     * @param isNode 
     */
    public GraphElementCreationFactory(ICreationUtils creation, String type, String presentation, boolean isNode)
    {
        super();
        this.creation = creation;
        this.type = type;
        this.presentation = presentation;
        this.isNode = isNode;
    }
    
    /**
     * Get the EObject that is instantiated
     * 
     * @return EObject
     */
    public EObject getNewModelObject()
    {
        // TODO should directly return the eobject without calling the deprecated method
        EObject eobject = eClass.getEPackage().getEFactoryInstance().create(eClass);
        return creation.createModelObject(eobject);
    }

    /**
     * @see org.eclipse.gef.requests.CreationFactory#getNewObject()
     */
    public Object getNewObject()
    {
        Object createdObject = null;
        if (eClass != null)
        {
            EObject commandObj = getNewModelObject();
            createdObject = creation.createGraphElement(commandObj, presentation);
        }
        else if (type != null)
        {
            if (isNode)
            {
                createdObject = Utils.createGraphNode(type, presentation);
            }
            else
            {
                createdObject = Utils.createGraphEdge(type, presentation);
            }
        }

        return createdObject;
    }

    /**
     * @see org.eclipse.gef.requests.CreationFactory#getObjectType()
     */
    public Object getObjectType()
    {
        return null;
    }

    /**
     * @return the presentation
     */
    public String getPresentation()
    {
        return presentation;
    }

    /**
     * @return the eClass
     */
    public EClass getEClass()
    {
        return eClass;
    }

    /**
     * @return the type
     */
    public String getType()
    {
        return type;
    }

}
