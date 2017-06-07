/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
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
package org.topcased.modeler.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.ArrayDelegatingEList;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.InternalEList;

public class CustomResolver
{
    protected final ResourceSet resourceSet;

    /**
     * @param set
     * @param nbThreads 
     */
    public CustomResolver (ResourceSet set)
    {
        this.resourceSet = set;
    }
    
    /**
     * Manage the eobject, browse the references and resolve
     * @param e
     * @param set
     */
    protected void manage(EObject e,ResourceSet set)
    {
        for (int indexRef = 0 ; indexRef < e.eClass().getEAllReferences().size() ; indexRef++)
        {
            EReference ref = e.eClass().getEAllReferences().get(indexRef);
            Collection<EObject> containments = new ArrayList<EObject>();
            List<EObject> objects = new ArrayList<EObject>();
            Object o = e.eGet(ref, false);
            if (ref.isMany())
            {
                manageList(ref, containments, objects, o);
            }
            else
            {
                objects.add((EObject) o);
            }
            for (int i = 0 ; i < objects.size() ; i++)
            {
                EObject eobject = objects.get(i);
                if (eobject != null)
                {
                    boolean isProxy = eobject.eIsProxy() ;
                    if (eobject.eIsProxy())
                    {
                        getResource(set, eobject);
                    }
                    if (eobject != null && !isProxy && containments.contains(eobject))
                    {
                        manage(eobject, set);
                    }
                }
            }
        }
    }

    protected void getResource(ResourceSet set, EObject eobject)
    {
        InternalEObject internal = (InternalEObject)eobject;
        URI uri = internal.eProxyURI();
        set.getResource(uri.trimFragment(), true);
    }

    protected void manageList(EReference ref, Collection<EObject> containments, Collection<EObject> objects, Object o)
    {
        if (o instanceof BasicEList)
        {
            BasicEList<EObject> eobjects = (BasicEList<EObject>) o;
            for (int i = 0; i < eobjects.size(); i++)
            {
                EObject basicGet = eobjects.basicGet(i);
                objects.add(basicGet);
                if (ref.isContainment())
                {
                    containments.add(basicGet);
                }
            }
        }
        else if (o instanceof InternalEList)
        {
            InternalEList<EObject> eobjects = (InternalEList<EObject>) o;
            for (int i = 0; i < eobjects.size(); i++)
            {
                EObject basicGet = eobjects.basicGet(i);
                objects.add(basicGet);
                if (ref.isContainment())
                {
                    containments.add(basicGet);
                }
            }
        }
        else if (o instanceof ArrayDelegatingEList)
        {
            ArrayDelegatingEList<EObject> eobjects = (ArrayDelegatingEList<EObject>) o;
            for (int i = 0; i < eobjects.size(); i++)
            {
                EObject basicGet = eobjects.basicGet(i);
                objects.add(basicGet);
                if (ref.isContainment())
                {
                    containments.add(basicGet);
                }
            }
        }
        else if (o instanceof List)
        {
            List<EObject> coll = (List<EObject>) o;
            for (int i = 0; i < coll.size(); i++)
            {
                EObject o2 = coll.get(i);
                objects.add(o2);
                if (ref.isContainment())
                {
                    containments.add(o2);
                }
            }
        }
    }

    public void resolve()
    {
        Map<Object, Object> oldOptions = new HashMap<Object, Object>();
        oldOptions.putAll(resourceSet.getLoadOptions());
        boolean oldResSetDeliver = resourceSet.eDeliver();
        // adapters are disabled
        resourceSet.eSetDeliver(false);
        browse();
        resourceSet.eSetDeliver(oldResSetDeliver);
        resourceSet.getLoadOptions().putAll(oldOptions);
        
    }

    protected void browse()
    {
        for (int i = 0; i < resourceSet.getResources().size() && isFinish(); i++)
        {
            Resource r = resourceSet.getResources().get(i);
            if (r != null)
            {
                for (int j = 0; j < r.getContents().size(); j++)
                {
                    EObject e = r.getContents().get(j);
                    if (e != null)
                    {
                        manage(e,resourceSet);
                    }
                }
            }
        }
    }

    protected boolean isFinish()
    {
        return true;
    }

    
    
}
