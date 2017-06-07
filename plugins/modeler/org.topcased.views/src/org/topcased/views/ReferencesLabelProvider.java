/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * Copyright (c) 2012 Airbus
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    David Sciamma (Anyware Technologies)
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Pierre Gaufillet (Airbus) - General purpose references view
 *
 * $Id: ReferencesLabelProvider.java,v 1.2 2012/07/26 05:38:10 gaufille Exp $
 **********************************************************************/

package org.topcased.views;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.topcased.views.EModelElementContentProvider.WrappedEModelElement;

/**
 * Display text for references
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ReferencesLabelProvider extends LabelProvider
{

    private ILabelProvider delegate;

    /**
     * Constructor
     */
    public ReferencesLabelProvider(ILabelProvider delegateProvider)
    {
        super();
        delegate = delegateProvider;
    }

    /**
     * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
     */
    @Override
    public Image getImage(Object element)
    {
        if (element instanceof WrappedEModelElement)
        {
            EModelElement eModelElement = ((WrappedEModelElement) element).getWrappedEModelElement();
            return delegate.getImage(eModelElement);
        }
        else if (element != null)
        {
            return delegate.getImage(element);
        }

        return null;
    }

    /**
     * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
     */
    @Override
    public String getText(Object element)
    {
        if (element instanceof WrappedEModelElement)
        {
            EModelElement eModelElement = ((WrappedEModelElement) element).getWrappedEModelElement();
            return delegate.getText(eModelElement);
        }
        else if (element != null)
        {
            return delegate.getText(element);
        }

        return null;
    }
}
