/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * Tristan FAURE - Initial Implementation
 ******************************************************************************/
package org.topcased.modeler.internal.ordering;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.ordering.IOrder.OrderException;

public class VirtualOrderDecorator implements ILightweightLabelDecorator
{

    public static ImageDescriptor VIRTUAL = null;
    static
    {
        VIRTUAL = ModelerPlugin.getImageDescriptor("icons/decorators/virtual_mini.gif");
    }

    public void addListener(ILabelProviderListener listener)
    {
    }

    public void dispose()
    {
    }

    public boolean isLabelProperty(Object element, String property)
    {
        return false;
    }

    public void removeListener(ILabelProviderListener listener)
    {
    }

    public void decorate(Object element, IDecoration decoration)
    {
        try
        {
            if (element instanceof EObject && OrderManager.isVirtualOrder(false) && OrderManager.getOrderForAnElement((EObject) element) != null)
            {
                decoration.addOverlay(VIRTUAL, IDecoration.BOTTOM_RIGHT);
            }
        }
        catch (OrderException e)
        {
        }
    }

}
