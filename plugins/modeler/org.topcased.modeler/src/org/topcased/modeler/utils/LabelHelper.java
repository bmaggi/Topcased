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
import org.eclipse.emf.transaction.util.Adaptable;
import org.eclipse.gef.EditDomain;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.editor.IMixedEditDomain;
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
     * Initialize the name of a child EObject contained in a parent EObject within a given EditDomain (for avoiding type
     * ambiguity)
     * 
     * @param editDomain the EditDomain that contain the AdapterFactory
     * @param parentEObject the parent EObject that will contain the child EObject
     * @param childEObject the child EObject whose name should be initialized
     * @deprecated use {@link #initName(IMixedEditDomain, EObject, EObject)} instead
     */
    public void initName(MixedEditDomain editDomain, EObject parentEObject, EObject childEObject)
    {
        IMixedEditDomain mixed = editDomain;
        initName(mixed, parentEObject, childEObject);
    }

    /**
     * Initialize the name of a child EObject contained in a parent EObject within a given EditDomain
     * 
     * @param editDomain the EditDomain that contain the AdapterFactory
     * @param parentEObject the parent EObject that will contain the child EObject
     * @param childEObject the child EObject whose name should be initialized
     * @deprecated use {@link #initName(IMixedEditDomain, EObject, EObject)} instead
     */
    public void initName(EditDomain editDomain, EObject parentEObject, EObject childEObject)
    {
        IMixedEditDomain mixed = getMixedEditDomain(editDomain);
        if (mixed != null)
        {
            initName(mixed, parentEObject, childEObject);
        }
    }

    /**
     * Initialize the name of a child EObject contained in a parent EObject within a given EditDomain
     * 
     * @param editDomain the mixed edit domain that contains the AdapterFactory
     * @param parentEObject the parent EObject that will contain the child EObject
     * @param childEObject the child EObject whose name should be initialized
     */
    public void initName(IMixedEditDomain editDomain, EObject parentEObject, EObject childEObject)
    {
        if (childEObject != null)
        {
            String name = findName(editDomain, parentEObject, childEObject);

            // Get the adapterFactory.
            AdapterFactory adapterFactory = editDomain.getAdapterFactory();

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
     * Get the adapter factory for this edit domain when it provides one
     * 
     * @param editDomain the edit domain, which should somehow be adaptable to a {@link IMixedEditDomain}
     * @return adapter factory or null if not reachable
     */
    public AdapterFactory getAdapterFactory(EditDomain editDomain)
    {
        AdapterFactory adapterFactory = null;
        IMixedEditDomain mixedEditDomain = getMixedEditDomain(editDomain);
        if (mixedEditDomain != null)
        {
            adapterFactory = ((IMixedEditDomain) editDomain).getAdapterFactory();
        }
        return adapterFactory;
    }

    /**
     * Get the mixed edit domain corresponding to the given GEF edit domain
     * 
     * @param editDomain GEF edit domain
     * @return mixed edit domain
     */
    protected IMixedEditDomain getMixedEditDomain(EditDomain editDomain)
    {

        IMixedEditDomain mixedEditDomain = null;
        if (editDomain instanceof IMixedEditDomain)
        {
            mixedEditDomain = (IMixedEditDomain) editDomain;
        }
        else if (editDomain instanceof Adaptable)
        {
            mixedEditDomain = ((Adaptable) editDomain).getAdapter(IMixedEditDomain.class);
        }
        return mixedEditDomain;
    }

    /**
     * Sets a given name for a model object. No check is done before setting name. (for avoiding type ambiguity)
     * 
     * @param editDomain the EditDomain that contain the AdapterFactory
     * @param childEObject the child EObject whose name should be set
     * @param name The name to set to the model object
     * @deprecated use {@link #setName(IMixedEditDomain, EObject, String)} instead
     */
    public void setName(MixedEditDomain editDomain, EObject childEObject, String name)
    {
        IMixedEditDomain mixed = editDomain;
        setName(mixed, childEObject, name);
    }

    /**
     * Sets a given name for a model object. No check is done before setting name.
     * 
     * @param editDomain the EditDomain that contain the AdapterFactory
     * @param childEObject the child EObject whose name should be set
     * @param name The name to set to the model object
     * @deprecated use {@link #setName(IMixedEditDomain, EObject, String)} instead
     */
    public void setName(EditDomain editDomain, EObject childEObject, String name)
    {
        IMixedEditDomain mixed = getMixedEditDomain(editDomain);
        if (mixed != null)
        {
            setName(mixed, childEObject, name);
        }
    }

    /**
     * Sets a given name for a model object. No check is done before setting name.
     * 
     * @param editDomain the EditDomain that contain the AdapterFactory
     * @param childEObject the child EObject whose name should be set
     * @param name The name to set to the model object
     */
    public void setName(IMixedEditDomain editDomain, EObject childEObject, String name)
    {
        if (childEObject != null)
        {
            // Get the adapterFactory.
            AdapterFactory adapterFactory = editDomain.getAdapterFactory();

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
    private String findName(IMixedEditDomain editDomain, EObject parentEObject, EObject childEObject)
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
    private boolean isNameAvailable(IMixedEditDomain editDomain, EObject parentEObject, EObject childEObject, int currentCpt)
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
     * Checks if the given name in parameter is available in the parent container. (for avoiding type ambiguity)
     * 
     * @param editDomain The edit domain
     * @param parentEObject the parent EObject
     * @param name the name to eventually set
     * @return <code>true</code> if no object currently use this name (it means the name is available)
     * @deprecated use {@link #isNameAvailable(IMixedEditDomain, EObject, String)} instead
     */
    public boolean isNameAvailable(MixedEditDomain editDomain, EObject parentEObject, String name)
    {
        IMixedEditDomain mixed = editDomain;
        return isNameAvailable(mixed, parentEObject, name);
    }

    /**
     * Checks if the given name in parameter is available in the parent container.
     * 
     * @param editDomain The edit domain
     * @param parentEObject the parent EObject
     * @param name the name to eventually set
     * @return <code>true</code> if no object currently use this name (it means the name is available)
     * @deprecated use {@link #isNameAvailable(IMixedEditDomain, EObject, String)} instead
     */
    public boolean isNameAvailable(EditDomain editDomain, EObject parentEObject, String name)
    {
        IMixedEditDomain mixed = getMixedEditDomain(editDomain);
        if (mixed != null)
        {
            return isNameAvailable(mixed, parentEObject, name);
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
    public boolean isNameAvailable(IMixedEditDomain domain, EObject parentEObject, String name)
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
     * present in the EMF release for Eclipse 3.1 (for avoiding type ambiguity)
     * 
     * @param editDomain the editing domain
     * @param model the EObject
     * 
     * @return string the LabelFeature of the EObject
     * @deprecated use {@link #getName(IMixedEditDomain, EObject)} instead
     */
    public String getName(MixedEditDomain editDomain, EObject model)
    {
        IMixedEditDomain mixed = editDomain;
        return getName(mixed, model);
    }

    /**
     * This class uses a custom Provider to get the name. It must be implemented by the extension point that will be
     * present in the EMF release for Eclipse 3.1
     * 
     * @param editDomain the editing domain
     * @param model the EObject
     * 
     * @return string the LabelFeature of the EObject
     * @deprecated use {@link #getName(IMixedEditDomain, EObject)} instead
     */
    public String getName(EditDomain editDomain, EObject model)
    {
        IMixedEditDomain mixed = getMixedEditDomain(editDomain);
        if (mixed != null)
        {
            return getName(mixed, model);
        }
        return null;
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
    public String getName(IMixedEditDomain editDomain, EObject model)
    {
        String name = null;
        String realName = null;

        // Get the adapterFactory.
        AdapterFactory adapterFactory = editDomain.getAdapterFactory();

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

        return name;
    }

    /**
     * Computes the path identifying the position of a Diagram (for avoiding type ambiguity)
     * 
     * @param editDomain the editDomain
     * @param diagram the Diagram
     * @return the path
     * @deprecated use {@link #getDiagramPath(IMixedEditDomain, Diagram)} instead
     */
    public String getDiagramPath(MixedEditDomain editDomain, Diagram diagram)
    {
        IMixedEditDomain mixed = editDomain;
        return getDiagramPath(mixed, diagram);
    }

    /**
     * Computes the path identifying the position of a Diagram
     * 
     * @param editDomain the editDomain
     * @param diagram the Diagram
     * @return the path
     * @deprecated use {@link #getDiagramPath(IMixedEditDomain, Diagram)} instead
     */
    public String getDiagramPath(EditDomain editDomain, Diagram diagram)
    {
        IMixedEditDomain mixed = getMixedEditDomain(editDomain);
        if (mixed != null)
        {
            return getDiagramPath(mixed, diagram);
        }
        return null;
    }

    /**
     * Computes the path identifying the position of a Diagram
     * 
     * @param editDomain the editDomain
     * @param diagram the Diagram
     * @return the path
     */
    public String getDiagramPath(IMixedEditDomain editDomain, Diagram diagram)
    {
        String id = diagram.getSemanticModel().getPresentation();
        DiagramDescriptor diagramDescriptor = DiagramsManager.getInstance().find(id);

        String diagramDescriptorName = diagramDescriptor.getName();
        String diagName = diagram.getName();
        String hierarchy = computeHierarchy(editDomain, diagram);

        return diagramDescriptorName + " : " + hierarchy + " / " + diagName;
    }

    private String computeHierarchy(IMixedEditDomain editDomain, Diagram diagram)
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
