/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.internal.ordering;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.topcased.modeler.internal.ordering.IOrder.OrderException;

class OrderAdapter extends AdapterImpl
{

    @Override
    public void setTarget(Notifier newTarget)
    {
        super.setTarget(newTarget);
        if (newTarget instanceof EModelElement)
        {
            EModelElement emodelElement = (EModelElement) newTarget;
            checkIntegrity(emodelElement);
        }
    }

    @Override
    public void notifyChanged(Notification msg)
    {
        super.notifyChanged(msg);
        if (msg.getFeature() instanceof EReference)
        {
            EReference f = (EReference) msg.getFeature();
            if (f.isContainment() && msg.getNotifier() instanceof EModelElement)
            {
                if (msg.getEventType() == Notification.REMOVE || msg.getEventType() == Notification.REMOVE_MANY)
                {
                    manageEModelElement(msg);
                }
            }
        }
        // check integrity
        if (msg.getNotifier() instanceof EModelElement)
        {
            EModelElement element = (EModelElement) msg.getNotifier();
            checkIntegrity(element);
        }
    }

    /**
     * To prevent problems or users modifications
     * @param element
     */
    protected void checkIntegrity(EModelElement element)
    {
        EAnnotation anno = element.getEAnnotation(EModelElementOrder.orderAnnotationSource);
        if (anno != null && anno.getReferences() != null)
        {
            for (Iterator<EObject> i = anno.getReferences().iterator(); i.hasNext();)
            {
                EObject e = i.next();
                if (e.eContainer() != element)
                {
                    i.remove();
                }
            }
        }
    }

    protected void manageEModelElement(Notification msg)
    {
        EModelElement eobject = (EModelElement) msg.getNotifier();
        Collection<EObject> order;
        try
        {
            order = OrderManager.getOrderForAnElement(eobject);
            if (order != null)
            {
                order = new HashSet<EObject>(order);
                EAnnotation anno = eobject.getEAnnotation(EModelElementOrder.orderAnnotationSource);
                if (anno != null)
                {
                    Collection<EObject> collec = new LinkedList<EObject>();
                    switch (msg.getEventType())
                    {
                        case Notification.REMOVE:
                            collec.add((EObject) msg.getOldValue());
                        case Notification.REMOVE_MANY:
                            if (collec.isEmpty())
                            {
                                collec.addAll((Collection< ? extends EObject>) msg.getOldValue());
                            }
                            break;
                        default:
                            break;
                    }
                    if (!collec.isEmpty())
                    {
                        for (EObject e : collec)
                        {
                            if (order.contains(e))
                            {
                                anno.getReferences().remove(e);
                            }
                        }
                    }
                }
            }
        }
        catch (OrderException e1)
        {
        }
    }
}