/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos Origin) vincent.hemery@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/

package org.topcased.modeler.extensions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.editor.ModelerGraphicalViewer;
import org.topcased.modeler.utils.Utils;

/**
 * The Class EObjectRightParentContainerTester.
 * 
 * This class tests whether an EObject is graphically in the same parent container as in the model. This rule provides
 * the basic behavior and example for the org.topcased.modeler.synchronizedModelDiagramRule extension point.
 */
public class SynchronizedModelDiagramRule
{

    protected static final String NO_PARENT_NAME = "none";
    private static final Pattern NAME_PATTERN = Pattern.compile(".*name: (.*?)[,\\)].*");

    /**
     * Gets the name of the parent the targeted element has in the model.
     * 
     * Subtypes may override this method to provide a new way of getting the parent name.
     * 
     * @param pTarget the target
     * @param pLongName if true, a longer version of the name will be returned
     * 
     * @return the model parent name or {@link SynchronizedModelDiagramRule#NO_PARENT_NAME} if no parent found
     */
    public String getModelParentName(IDecoratorTarget pTarget, boolean pLongName)
    {
        EObject lParent = getModelParent(pTarget);
        if (lParent != null)
        {
            return getEObjectName(lParent, pLongName);
        }

        return NO_PARENT_NAME;
    }

    /**
     * Gets the name of the parent the targeted element has in the diagram.
     * 
     * Subtypes may override this method to provide a new way of getting the parent name.
     * 
     * @param pTarget the target
     * @param pLongName if true, a longer version of the name will be returned
     * 
     * @return the graphical parent name or {@link SynchronizedModelDiagramRule#NO_PARENT_NAME} if no parent found
     */
    public String getGraphicalParentName(IDecoratorTarget pTarget, boolean pLongName)
    {
        EObject lParent = getGraphicalParent(pTarget);
        if (lParent != null)
        {
            return getEObjectName(lParent, pLongName);
        }

        return NO_PARENT_NAME;
    }

    /**
     * Gets the e object name.
     * 
     * You may override this method if the objects you are manipulating have another specific method for getting the
     * name.
     * 
     * @param pObject the object
     * @param pLongName if true, a longer version of the name will be returned
     * 
     * @return the e object name
     */
    public String getEObjectName(EObject pObject, boolean pLongName)
    {
        String lClassName = pObject.eClass().getName();
        if (pObject instanceof ENamedElement)
        {
            return lClassName + " " + ((ENamedElement) pObject).getName();
        }
        else
        {
            String lCompleteString = pObject.toString();
            if (pLongName)
            {
                return lClassName + " " + lCompleteString;
            }
            else
            {
                String lName = lCompleteString;
                Matcher lMatcher = NAME_PATTERN.matcher(lCompleteString);
                if (lMatcher.matches())
                {
                    lName = lMatcher.group(1);
                }
                return lClassName + " " + lName;
            }
        }
    }

    /**
     * Checks if the representation has the right graphic parent.
     * 
     * Subtypes should override this method if they want to provide a new implementation of the test.
     * 
     * @param pTarget the target
     * 
     * @return true, if is synchronized with the model
     */
    public boolean hasRightGraphicParent(IDecoratorTarget pTarget)
    {
        GraphicalEditPart lEditPart = (GraphicalEditPart) pTarget.getAdapter(GraphicalEditPart.class);

        if (lEditPart != null)
        {
            if (lEditPart.getViewer() instanceof ModelerGraphicalViewer)
            {
                EObject lSemanticParent = getModelParent(pTarget);
                EObject lGraphicalParent = getGraphicalParent(pTarget);
                if (lSemanticParent != null)
                {
                    return lSemanticParent.equals(lGraphicalParent);
                }
                else
                {
                    // if the semantic parent is null, we must be creating the EObject
                    return true;
                }
            }
        }

        return true;
    }

    /**
     * Gets the graphical parent in the diagram.
     * 
     * Subtypes should override this method if they want to provide a new way of getting the graphical parent. Beware
     * that the hasRightGraphicParent(IDecoratorTarget) and getGraphicalParentName(IDecoratorTarget, boolean) methods
     * have not been overridden by a supertype, or this method may not be used anymore.
     * 
     * @param pTarget the target
     * 
     * @return the graphical parent or null if none
     */
    protected EObject getGraphicalParent(IDecoratorTarget pTarget)
    {
        return getGraphicalContainerParent(pTarget);
    }

    /**
     * Gets the graphical direct container parent.
     * 
     * @param pTarget the target
     * 
     * @return the graphical container or null if none
     */
    private EObject getGraphicalContainerParent(IDecoratorTarget pTarget)
    {
        GraphicalEditPart lEditPart = (GraphicalEditPart) pTarget.getAdapter(GraphicalEditPart.class);
        GraphElement lGraphElement = (GraphElement) lEditPart.getModel();
        GraphElement lContainerGraphElement = lGraphElement.getContainer();
        return Utils.getElement(lContainerGraphElement);
    }

    /**
     * Gets the semantical parent in the model.
     * 
     * Subtypes should override this method if they want to provide a new way of getting the semantical parent. Beware
     * that the hasRightGraphicParent(IDecoratorTarget) and the getModelParentName(IDecoratorTarget, boolean) methods
     * have not been overridden by a supertype, or this method may not be used anymore.
     * 
     * @param pTarget the target
     * 
     * @return the model parent or null if none
     */
    protected EObject getModelParent(IDecoratorTarget pTarget)
    {
        return getModelParentContainer(pTarget);
    }

    /**
     * Gets the model parent container.
     * 
     * @param pTarget the target
     * 
     * @return the model container or null if none
     */
    private EObject getModelParentContainer(IDecoratorTarget pTarget)
    {
        EObject lModelObject = (EObject) pTarget.getAdapter(EObject.class);
        if (lModelObject != null)
        {
            return lModelObject.eContainer();
        }
        return null;
    }
}
