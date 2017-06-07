/*******************************************************************************
 * Copyright (c) 2005-2008 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Thomas Friol (Anyware Technologies) - initial API and
 * implementation
 * Thibaut Landré (Atos Origin) - update filter : add Additional Resources
 ******************************************************************************/
package org.topcased.modeler.editor.outline.filters;

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
 * A filter to show only diagrams in the outline view. <br>
 * Creation : 19 dï¿½c. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class OnlyDiagramsFilter extends ViewerFilter
{

    /**
     * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer,
     *      java.lang.Object, java.lang.Object)
     */
    public boolean select(Viewer viewer, Object parentElement, Object element)
    {
    	if(element  instanceof AdditionalResources)
    	{
    		return true;
    	}
        if (viewer instanceof TreeViewer)
        {
            if (element instanceof EObject || element instanceof IWrapperItemProvider
                    || element instanceof FeatureMap.Entry)
            {
                return hasDiagrams((ITreeContentProvider) ((TreeViewer) viewer).getContentProvider(), element);

            }
        }

        return false;
    }

    /**
     * Tests wheter a specified object has one or more diagrams in its child
     * elements or if it is a Diagram itself.
     * 
     * @param a tree content provider to go through the element children
     *            hierarchy.
     * @param element the element to test
     * @return <code>true</code> or <code>false</code>
     */
    private boolean hasDiagrams(ITreeContentProvider cp, Object element)
    {
        if (element instanceof Diagram)
        {
            return true;
        }
        else
        {
            Object[] children = cp.getChildren(element);
            for (int i = 0; i < children.length; i++)
            {
                if (hasDiagrams(cp, children[i]))
                {
                    return true;
                }
            }
        }

        return false;
    }

}
