/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.providers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * created 26 mai 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * 
 */
public interface IDeletePartnerProvider
{
    /**
     * Return a list of EObjects that should be deleted when the passed Object is deleted
     * 
     * @param object The Object which is currently removed
     * @return a list of EObject to delete as well
     */
    List<EObject> getDeletePartners(Object object);

}
