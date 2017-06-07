/*******************************************************************************
 * Copyright (c) 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.utils;

import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

/**
 * An implementation of {@link ILabelDecorator} which delegate all its methods to another {@link ILabelDecorator}.
 * Subclass and customize only some of the methods.
 * 
 * @author <a href="mailto:pierre-charles.david@obeo.fr">Pierre-Charles David</a>
 */
public class ForwardingLabelDecorator implements ILabelDecorator
{
    private final ILabelDecorator delegate;

    public ForwardingLabelDecorator(ILabelDecorator delegate)
    {
        this.delegate = delegate;
    }

    public void addListener(ILabelProviderListener listener)
    {
        delegate.addListener(listener);
    }

    public Image decorateImage(Image image, Object element)
    {
        return delegate.decorateImage(image, element);
    }

    public String decorateText(String text, Object element)
    {
        return delegate.decorateText(text, element);
    }

    public void dispose()
    {
        delegate.dispose();
    }

    public boolean isLabelProperty(Object element, String property)
    {
        return delegate.isLabelProperty(element, property);
    }

    public void removeListener(ILabelProviderListener listener)
    {
        delegate.removeListener(listener);
    }
}
