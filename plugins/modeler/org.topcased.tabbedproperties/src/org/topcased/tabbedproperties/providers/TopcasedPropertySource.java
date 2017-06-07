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
 *  Emilien PERICO (ATOS ORIGIN INTEGRATION) emilien.perico@atosorigin.com - custom property editors
 *  Caroline BOURDEU d'AGUERRE (ATOS ORIGIN INTEGRATION) caroline.bourdeudaguerre@atosorigin.com
 *
 *****************************************************************************/
package org.topcased.tabbedproperties.providers;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

/**
 * TopcasedPropertySource has the same behavior of PropertySource except it manages ereference not many with a Choose
 * dialog instead of Combo Box
 * 
 * @author tfaure
 * @author eperico
 * 
 */
public class TopcasedPropertySource extends PropertySource
{
        
    /**
     * An instance is constructed from an object and its item property source.
     */
    public TopcasedPropertySource(Object object, IItemPropertySource propertySource)
    {
        super(object, propertySource);
    }

    @Override
    protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor)
    {
        return new TopcasedPropertyDescriptor(object, itemPropertyDescriptor);
    }

}
