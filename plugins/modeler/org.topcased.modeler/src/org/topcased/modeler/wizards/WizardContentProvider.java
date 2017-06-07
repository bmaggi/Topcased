/*******************************************************************************
 * Copyright (c) 2005, 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Cyril Faucher (INRIA) - Customization of the getChildren() method
 *******************************************************************************/
package org.topcased.modeler.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * This Content Provider displays contents of model and rootEObject. For the model, this provider delegates contents
 * computing to the model content provider. <br>
 * 
 * Creation : 7 dec. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class WizardContentProvider implements ITreeContentProvider
{

    private static final Object[] NO_CHILDREN = new Object[0];

    private ITreeContentProvider delegatedModelProvider;

    /**
     * Constructor
     * 
     * @param delegatedProvider the delegated content provider
     */
    public WizardContentProvider(ITreeContentProvider delegatedProvider)
    {
        delegatedModelProvider = delegatedProvider;
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
     */
    public Object[] getChildren(Object parentElement)
    {
        // Return the edited model as root element
        if (parentElement instanceof EList)
        {
            return ((EList) parentElement).toArray();
        }

        // For the model objects, retrieves model children and merges result
        // with rootEObject associated with this element
        if (parentElement instanceof IWrapperItemProvider || parentElement instanceof FeatureMap.Entry || parentElement instanceof EObject)
        {
            // Model children
            List<Object> children = new ArrayList<Object>();
            Object[] modelChildren = delegatedModelProvider.getChildren(AdapterFactoryEditingDomain.unwrap(parentElement));
            for (int i = 0; i < modelChildren.length; i++)
            {
                children.add(modelChildren[i]);
            }

            return children.toArray(new Object[children.size()]);
        }

        return NO_CHILDREN;
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
     */
    public Object getParent(Object element)
    {
        // Delegates
        if (element instanceof IWrapperItemProvider || element instanceof FeatureMap.Entry || element instanceof EObject)
        {
            return delegatedModelProvider.getParent(AdapterFactoryEditingDomain.unwrap(element));
        }

        return null;
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
     */
    public boolean hasChildren(Object element)
    {
        if (element instanceof IWrapperItemProvider || element instanceof FeatureMap.Entry || element instanceof EObject)
        {
            return getChildren(AdapterFactoryEditingDomain.unwrap(element)).length > 0;
        }

        return false;
    }

    /**
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements(Object inputElement)
    {
        return getChildren(inputElement);
    }

    /**
     * @see org.eclipse.jface.viewers.IContentProvider#dispose()
     */
    public void dispose()
    {
        // Do nothing
    }

    /**
     * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object,
     *      java.lang.Object)
     */
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
    {
        // Do nothing
    }

}
