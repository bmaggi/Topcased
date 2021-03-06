/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.ui.navigator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.topcased.modeler.di.model.provider.DiagramInterchangeItemProviderAdapterFactory;
import org.topcased.modeler.diagrams.model.provider.DiagramsItemProviderAdapterFactory;

/**
 * Provides the shared adapter factory for the content and label provider of a DI file
 * 
 * Creation 4 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public final class TopcasedDiagramAdapterFactoryProvider
{
    private static ComposedAdapterFactory adapterFactory;

    /**
     * Create the list of AdapterFactory
     * 
     * @return a list of AdapterFactory
     */
    public final static List<AdapterFactory> createFactoryList()
    {
        List<AdapterFactory> factories = new ArrayList<AdapterFactory>();

        // These are the custom provider generated by EMF
        factories.add(new DiagramsItemProviderAdapterFactory());
        factories.add(new DiagramInterchangeItemProviderAdapterFactory());

        // These are EMF generic providers
        factories.add(new ResourceItemProviderAdapterFactory());
        factories.add(new ReflectiveItemProviderAdapterFactory());

        return factories;
    }

    /**
     * Return the single instance of ComposedAdapterFactory
     * 
     * @return ComposedAdapterFactory the single instance
     */
    public final static ComposedAdapterFactory getAdapterFactory()
    {
        if (adapterFactory == null)
        {
            adapterFactory = new ComposedAdapterFactory(createFactoryList());
        }
        return adapterFactory;
    }
}
