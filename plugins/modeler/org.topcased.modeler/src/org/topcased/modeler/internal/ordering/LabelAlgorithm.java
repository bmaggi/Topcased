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
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;

public class LabelAlgorithm implements IOrderAlgorithm
{
    ItemProviderAdapter adapter = new ReflectiveItemProvider(new ReflectiveItemProviderAdapterFactory());
    

    public List<EObject> sortChildren(EObject eobject)
    {
        List<EObject> result = new ArrayList<EObject>(eobject.eContents().size());
        result.addAll(eobject.eContents());
        Collections.sort(result, new Comparator<EObject>()
        {
            public int compare(EObject o1, EObject o2)
            {
                String label1 = adapter.getText(o1);
                String label2 = adapter.getText(o2);
                return label1.compareTo(label2);
            }
        });
        return result;
    }

    public boolean canOrder(EObject context)
    {
        return true;
    }

}
