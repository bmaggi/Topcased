/**
 * ******************************************************************************
 * Copyright (c) 2006 ANYWARE TECHNOLOGIES. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:    Alfredo Serrano (Anyware Technologies) - initial API and
 *                  Tristan Faure (ATOS ORIGIN INTEGRATION) - change behavior for references
 * implementation
 * ******************************************************************************
 */
package org.topcased.tabbedproperties.providers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.ui.views.properties.IPropertySource;
import org.topcased.tabbedproperties.internal.sections.TabbedPropertiesPlugin;
import org.topcased.tabbedproperties.utils.ObjectAdapter;
import org.topcased.tabbedproperties.utils.TabbedPropertiesConstants;

/**
 * Creation 19 sept. 06
 * 
 * @author alfredo
 * @author tfaure
 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider
 */
public class TabbedPropertiesContentProvider extends AdapterFactoryContentProvider
{

    /**
     * This constructs an instance that wraps this factory.
     * 
     * @param adapterFactory
     */
    public TabbedPropertiesContentProvider(AdapterFactory adapterFactory)
    {
        super(adapterFactory);
    }

    /**
     * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getPropertySource(java.lang.Object)
     */
    public IPropertySource getPropertySource(Object object)
    {
        // we check if the preferences are set to standard behavior or to the newest
        boolean defaultBehavior = TabbedPropertiesPlugin.getDefault().getPreferenceStore().getBoolean(TabbedPropertiesConstants.P_DEFAULT_ADVANCED);
        EObject eObject = ObjectAdapter.adaptObject(object);
        if (eObject != null)
        {
            if (defaultBehavior)
            {
                return super.getPropertySource(eObject);
            }
            else
            {
                // if we have to use new behavior we have to create a TopcasedPropertySource which will manage the properties
                IItemPropertySource itemPropertySource = (IItemPropertySource) (eObject instanceof EObject && eObject.eClass() == null ? null
                        : adapterFactory.adapt(eObject, IItemPropertySource.class));
                if (itemPropertySource != null)
                {
                    return new TopcasedPropertySource(eObject, itemPropertySource);
                }
            }
        }
        return super.getPropertySource(object);
    }
}
