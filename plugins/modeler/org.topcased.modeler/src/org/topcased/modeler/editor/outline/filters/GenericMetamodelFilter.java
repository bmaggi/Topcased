/*****************************************************************************
 * 
 * GenericMetamodelFilter.java
 * 
 * Copyright (c) 2008 Atos Origin.
 *
 * Contributors:
 *  Thibault Landre (Atos Origin) thibault.landre@atosorigin.com,
 *  Sebastien GABEL (CS) - API changes
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.topcased.modeler.editor.outline.filters;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.editor.outline.AdditionalResources;

/**
 * This abstract class is used to defined a contributor for the outline metamodel filter. Subclasses must override method
 * <b>getMetamodelElements()</b> and <b>getClass(String elementName)</b>. See the
 * <code>org.topcased.modeler.outline</code> extension point.<br>
 * 
 */
public abstract class GenericMetamodelFilter extends ViewerFilter
{
    /**
     * A collection of element names
     */
    private Collection<Object> filterElementsName;

    /**
     * Return an EList of {@link ENamedElement} representing the selected elements contained in the metamodel.<br>
     * This method has to be overridden by subclasses.
     * 
     * @return a list of selected named elements.
     */
    public abstract EList< ? extends ENamedElement> getMetamodelElements();

    /**
     * Return the class of an instance type name.<br>
     * This method may be overridden by subclasses.
     * 
     * @param elementName the instance type name of the class
     * @return the class corresponding to the element name; null by default
     */
    public abstract Class< ? > getClass(String elementName);

    /**
     * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object,
     *      java.lang.Object)
     */
    public boolean select(Viewer viewer, Object parentElement, Object element)
    {
        if (element instanceof AdditionalResources)
        {
            return true;
        }
        else if (element instanceof Diagram)
        {
            return true;
        }
        else if (viewer instanceof TreeViewer)
        {
            if (element instanceof EObject || element instanceof IWrapperItemProvider || element instanceof FeatureMap.Entry)
            {
                return hasElement((ITreeContentProvider) ((TreeViewer) viewer).getContentProvider(), element);
            }
        }
        return false;
    }

    /**
     * Tests whether a specified object has one or more element in its child elements or if it is the element itself.
     * 
     * @param a tree content provider to go through the element children hierarchy.
     * @param element the element to test
     * @return <code>true</code> or <code>false</code>
     */
    private boolean hasElement(ITreeContentProvider cp, Object element)
    {
        if (isInstance(element))
        {
            return true;
        }
        else
        {
            Object[] children = cp.getChildren(element);
            for (int i = 0; i < children.length; i++)
            {
                if (hasElement(cp, children[i]))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if the given element is an instance of the filtered elements
     * 
     * @param element The model element to test
     * @return <code>true</code> or <code>false</code>
     */
    protected boolean isInstance(Object element)
    {
        for (Object elementName : filterElementsName)
        {
            if (getClass(elementName.toString()) != null)
            {
                Class< ? > clazz = getClass(elementName.toString());
                if (clazz != null && clazz.isInstance(element))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get the list of the elements composing the filter.
     */
    public Collection<Object> getFilterElementName()
    {
        return filterElementsName;
    }

    /**
     * Set the list of the elements composing the filter. These elements will be displayed in the outline. Others will
     * be filtered.
     * 
     * @param elementsName the list of elements
     */
    public void setFilterElementsName(List<Object> elementsName)
    {
        filterElementsName = elementsName;
    }

}
