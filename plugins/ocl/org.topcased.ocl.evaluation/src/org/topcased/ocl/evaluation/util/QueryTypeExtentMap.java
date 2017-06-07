/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Atos - initial API and implementation
 ******************************************************************************/
package org.topcased.ocl.evaluation.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.common.collect.Sets;

public class QueryTypeExtentMap implements Map<EClass, Set<? extends EObject>> {

	ModelSetQueryAdapterSizeMatters adapter = null ;
	EObject random ;
    private final ResourceSet set;
	
	public QueryTypeExtentMap(ResourceSet set){
		this.set = set;
        for (Adapter a : set.eAdapters()){
			if (a instanceof ModelSetQueryAdapterSizeMatters){
				adapter = (ModelSetQueryAdapterSizeMatters) a ;
				break ;
			}
		}
		if (adapter == null){
			adapter = new ModelSetQueryAdapterSizeMatters();
			adapter.setTarget(set);
		}
	}
	
	public void clear() {
		adapter.clear();
	}

	public boolean containsKey(Object arg0) {
	    random = null ;
        for (int i = 0 ; i < set.getResources().size() ; i ++){
            Resource r = set.getResources().get(i);
            for (int j = 0 ; j < r.getContents().size() ; j++){
                random = r.getContents().get(j);
                break;
            }
            if (random != null){
                break ;
            }
        }
		Collection<EObject> reachableObjectsOfType = adapter.getReachableObjectsOfType(random, (EClassifier) arg0);
		return reachableObjectsOfType != null  && reachableObjectsOfType.size() > 0 ;
	}

	public boolean containsValue(Object arg0) {
		return true;
	}

	public Set<java.util.Map.Entry<EClass, Set<? extends EObject>>> entrySet() {
		return Sets.newHashSet();
	}

	public Set<? extends EObject> get(Object arg0) {
	    random = null ;
	    for (int i = 0 ; i < set.getResources().size() ; i ++){
	        Resource r = set.getResources().get(i);
	        for (int j = 0 ; j < r.getContents().size() ; j++){
	            random = r.getContents().get(j);
	            break;
	        }
	        if (random != null){
	            break ;
	        }
	    }
		Collection<EObject> reachableObjectsOfType = adapter.getReachableObjectsOfType(random, (EClassifier) arg0);
		return Sets.newHashSet(reachableObjectsOfType);
	}

	public boolean isEmpty() {
		return false;
	}

	public Set<EClass> keySet() {
		return Sets.newHashSet();
	}

	public Set<? extends EObject> put(EClass arg0, Set<? extends EObject> arg1) {
		return Sets.newHashSet();
	}

	public void putAll(
			Map<? extends EClass, ? extends Set<? extends EObject>> arg0) {
		
	}

	public Set<? extends EObject> remove(Object arg0) {
		return Sets.newHashSet();
	}

	public int size() {
		return 0;
	}

	public Collection<Set<? extends EObject>> values() {
		return Sets.newHashSet();
	}

	
}
