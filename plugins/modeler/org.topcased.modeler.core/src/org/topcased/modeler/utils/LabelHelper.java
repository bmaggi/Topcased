/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.utils;

import java.util.Iterator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditDomain;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.editor.MixedEditDomain;
import org.topcased.modeler.extensions.DiagramDescriptor;
import org.topcased.modeler.extensions.DiagramsManager;
import org.topcased.modeler.providers.ILabelFeatureProvider;

/**
 * This helper class is used to get the name of an EObject for a given EditDomain. The class provides also utilities to
 * find an available name to give to the newly created EObject.
 * 
 * Created 2 juin 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * 
 */
public class LabelHelper
{
    /** The singleton */
    public static final LabelHelper INSTANCE = new LabelHelper();

    /**
     * Initialize the name of a child EObject contained in a parent EObject within a given EditDomain
     * 
     * @param editDomain the EditDomain that contain the AdapterFactory
     * @param parentEObject the parent EObject that will contain the child EObject
     * @param childEObject the child EObject whose name should be initialized
     */
    public void initName(EditDomain editDomain, EObject parentEObject, EObject childEObject)
    {
        if (editDomain instanceof MixedEditDomain && childEObject != null)
        {
            String name = findName(editDomain, parentEObject, childEObject);

            // Get the adapterFactory.
            AdapterFactory adapterFactory = ((MixedEditDomain) editDomain).getAdapterFactory();

            ILabelFeatureProvider labelFeatureProvider = null;
            if (adapterFactory != null)
            {
                // Get the provider from the adapterFactory
                labelFeatureProvider = (ILabelFeatureProvider) adapterFactory.adapt(childEObject, ILabelFeatureProvider.class);
            }
            // Either delegate the call or return nothing.
            EAttribute att = null;
            if (labelFeatureProvider != null)
            {
                att = labelFeatureProvider.getLabelFeature(childEObject);
            }

            if (att != null && ((EDataType) att.getEType()).getInstanceClass().equals(String.class))
            {
                childEObject.eSet(att, name);
            }
        }
    }

    /**
     * Sets a given name for a model object. No check is done before setting name.
     * 
     * @param editDomain the EditDomain that contain the AdapterFactory
     * @param childEObject the child EObject whose name should be set
     * @param name The name to set to the model object
     */
    public void setName(EditDomain editDomain, EObject childEObject, String name)
    {
        if (editDomain instanceof MixedEditDomain && childEObject != null)
        {
            // Get the adapterFactory.
            AdapterFactory adapterFactory = ((MixedEditDomain) editDomain).getAdapterFactory();

            ILabelFeatureProvider labelFeatureProvider = null;
            if (adapterFactory != null)
            {
                // Get the provider from the adapterFactory
                labelFeatureProvider = (ILabelFeatureProvider) adapterFactory.adapt(childEObject, ILabelFeatureProvider.class);
            }
            // Either delegate the call or return nothing.
            EAttribute att = null;
            if (labelFeatureProvider != null)
            {
                att = labelFeatureProvider.getLabelFeature(childEObject);
            }

            if (att != null && ((EDataType) att.getEType()).getInstanceClass().equals(String.class))
            {
                childEObject.eSet(att, name);
            }
        }
    }

    /**
     * This returns a name to give to the new EObject
     * 
     * @param editDomain the EditDomain
     * @param parentEObject the parent EObject
     * @param childEObject the new EObject to add
     * @return the text for the LabelFeature
     */
    private String findName(EditDomain editDomain, EObject parentEObject, EObject childEObject)
    {
        int cpt = 1;
        while (!isNameAvailable(editDomain, parentEObject, childEObject, cpt))
        {
            cpt++;
        }
        return childEObject.eClass().getName() + cpt;
    }

    /**
     * Check if a name is available
     * 
     * @param editDomain the EditDomain
     * @param parentEObject the parent EObject
     * @param childEObject the new EObject to add
     * @param currentCpt the current cpt
     * @return true if the name is available
     */
    private boolean isNameAvailable(EditDomain editDomain, EObject parentEObject, EObject childEObject, int currentCpt)
    {
        EList<EObject> list = parentEObject.eContents();
        for (Iterator<EObject> i = list.iterator(); i.hasNext();)
        {
            EObject child = i.next();

            // check if the current child is the same type of the childEObject
            if (childEObject.eClass().getName().equals(child.eClass().getName()))
            {
                String nameToMatch = child.eClass().getName() + currentCpt;
                if (nameToMatch.equals(getName(editDomain, child)))
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the given name in parameter is available in the parent container.
     * 
     * @param editDomain The edit domain
     * @param parentEObject the parent EObject
     * @param name the name to eventually set
     * @return <code>true</code> if no object currently use this name (it means the name is available)
     */
    public boolean isNameAvailable(EditDomain domain, EObject parentEObject, String name)
    {
        EList<EObject> list = parentEObject.eContents();
        for (Iterator<EObject> i = list.iterator(); i.hasNext();)
        {
            EObject child = i.next();
            if (name != null && name.equals(getName(domain, child)))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * This class uses a custom Provider to get the name. It must be implemented by the extension point that will be
     * present in the EMF release for Eclipse 3.1
     * 
     * @param editDomain the editing domain
     * @param model the EObject
     * 
     * @return string the LabelFeature of the EObject
     */
    public String getName(EditDomain editDomain, EObject model)
    {
        String name = null;
        String realName = null;

        if (editDomain instanceof MixedEditDomain)
        {
            // Get the adapterFactory.
            AdapterFactory adapterFactory = ((MixedEditDomain) editDomain).getAdapterFactory();

            ILabelFeatureProvider labelFeatureProvider = null;
            if (adapterFactory != null)
            {
                // Get the provider from the adapterFactory
                labelFeatureProvider = (ILabelFeatureProvider) adapterFactory.adapt(model, ILabelFeatureProvider.class);
            }

            // Either delegate the call or return nothing.
            EAttribute att = null;
            if (labelFeatureProvider != null)
            {
                att = labelFeatureProvider.getLabelFeature(model);
            }
            if (att != null)
            {
                realName = EcoreUtil.convertToString(att.getEAttributeType(), model.eGet(att));
            }

            if (realName != null)
            {
                name = realName;
            }
        }

        return name;
    }

    /**
     * Computes the path identifying the position of a Diagram
     * 
     * @param editDomain the editDomain
     * @param diagram the Diagram
     * @return the path
     */
    public String getDiagramPath(EditDomain editDomain, Diagram diagram)
    {
        String id = diagram.getSemanticModel().getPresentation();
        DiagramDescriptor diagramDescriptor = DiagramsManager.getInstance().find(id);

        String diagramDescriptorName = diagramDescriptor.getName();
        String diagName = diagram.getName();
        String hierarchy = computeHierarchy(editDomain, diagram);

        return diagramDescriptorName + " : " + hierarchy + " / " + diagName;
    }

    private String computeHierarchy(EditDomain editDomain, Diagram diagram)
    {
        EObject diagEObject = Utils.getElement(diagram.getSemanticModel().getGraphElement());
        String hierarchy = getName(editDomain, diagEObject);
        while (diagEObject.eContainer() != null)
        {
            String tmp = getName(editDomain, diagEObject.eContainer());
            if (tmp != null && !"".equals(tmp))
            {
                hierarchy = tmp.concat("::" + hierarchy);
            }
            diagEObject = diagEObject.eContainer();
        }
        return hierarchy;
    }
}
