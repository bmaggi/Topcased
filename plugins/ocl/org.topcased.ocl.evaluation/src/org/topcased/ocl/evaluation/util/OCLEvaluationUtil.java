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
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;


@SuppressWarnings("restriction")
public class OCLEvaluationUtil {

	/**
	 * Gets the classifier out of an object, that might not be an eobject.
	 */
	public static EClassifier getClassifier(Object o){
		if (o instanceof EObject){
			return ((EObject) o).eClass();
		}
		if (o instanceof String){
			return OCLStandardLibraryImpl.INSTANCE.getString();
		}
		if (o instanceof Boolean){
			return OCLStandardLibraryImpl.INSTANCE.getBoolean();
		}
		if (o instanceof Float){
			return OCLStandardLibraryImpl.INSTANCE.getReal();
		}
		if (o instanceof Integer){
			return OCLStandardLibraryImpl.INSTANCE.getInteger();
		}
		if (o instanceof Set<?>){
			return OCLStandardLibraryImpl.INSTANCE.getSet();
		}
		if (o instanceof List<?>){
			return OCLStandardLibraryImpl.INSTANCE.getSequence();
		}
		if (o instanceof Collection<?>){
			return OCLStandardLibraryImpl.INSTANCE.getCollection();
		}
		
		return OCLStandardLibraryImpl.INSTANCE.getOclInvalid();
	}
	
}
