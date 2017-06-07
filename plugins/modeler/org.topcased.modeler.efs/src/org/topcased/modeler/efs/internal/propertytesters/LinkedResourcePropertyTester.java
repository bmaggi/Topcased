/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 **********************************************************************/
package org.topcased.modeler.efs.internal.propertytesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IResource;

/**
 * An expressions property tester that tests whether a Resource is linked or not.
 * 
 * @author Jacques LESCOT
 */
public class LinkedResourcePropertyTester extends PropertyTester
{
    private static final String PROPERTY_IS_RESOURCE_LINKED = "isResourceLinked"; //$NON-NLS-1$

    /**
     * @see org.eclipse.core.expressions.PropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
     *      java.lang.Object)
     */
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue)
    {
        if (receiver instanceof IResource)
        {
            if (PROPERTY_IS_RESOURCE_LINKED.equals(property))
            {
                return expectedValue != null ? expectedValue.equals(((IResource) receiver).isLinked()) : ((IResource) receiver).isLinked();
            }
        }
        return false;
    }
}
