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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Class managing order for EModelElements
 * @author tfaure
 *
 */
public class EModelElementOrder implements IOrder
{
    private static final OrderAdapter eannotationAdapter = new OrderAdapter();
    public static String orderAnnotationSource = "http://www.topcased.org/order" ;
    
    public Command save(EObject context, List<EObject> elementsOrdered, EditingDomain domain) throws OrderException
    {
        if (elementsOrdered == null)
        {
            elementsOrdered = new LinkedList<EObject>();
        }
        if (context instanceof EModelElement)
        {
            CompoundCommand compound = new CompoundCommand();
            EModelElement modelElement = (EModelElement) context;
            EAnnotation annotation = modelElement.getEAnnotation(orderAnnotationSource); 
            if (annotation != null)
            {
                compound.append(RemoveCommand.create(domain, Collections.singleton(annotation)));
            }
            annotation = EcoreFactory.eINSTANCE.createEAnnotation();
            EList<Adapter> eAdapters = context.eAdapters();
            if (!eAdapters.contains(eannotationAdapter))
            {
                eAdapters.add(eannotationAdapter);
            }
            annotation.setSource(orderAnnotationSource);
            annotation.getReferences().addAll(elementsOrdered);
            compound.append(AddCommand.create(domain, modelElement, EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS, Collections.singleton(annotation)));
            return compound ;
        }
        else
        {
            throw new IOrder.OrderException("The element " + context + "is not a EModelElement");
        }
    }
    
    public List<EObject> getOrderedElements(EObject context) throws OrderException
    {
        if (context instanceof EModelElement)
        {
            EModelElement modelElement = (EModelElement) context;
            EAnnotation annotation = modelElement.getEAnnotation(orderAnnotationSource); 
            if (annotation != null)
            {
                boolean found = false;
                EList<Adapter> eAdapters = context.eAdapters();
                for (Adapter a : eAdapters)
                {
                    found |= a instanceof OrderAdapter;
                }
                if (!found)
                {
                    eAdapters.add(eannotationAdapter);
                }
                EList<EObject> references = annotation.getReferences();
                return new ArrayList<EObject>(references);
            }
            else
            {
                return null;
            }
        }
        else
        {
            throw new IOrder.OrderException("The element " + context + "is not a EModelElement");
        }
    }

    public boolean canOrder(EObject context)
    {
        return context instanceof EModelElement;
    }

}
