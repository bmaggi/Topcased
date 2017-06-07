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
package org.topcased.iterators.configurations.factories;

import java.util.Map;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.polarsys.reqcycle.utils.iterators.factories.IteratorFactory;
import org.polarsys.reqcycle.utils.iterators.pickers.IPicker;
import org.topcased.iterators.configurations.Activator;
import org.topcased.iterators.configurations.exceptions.ConfigurationLoadingException;
import org.topcased.iterators.configurations.factories.internal.PickerFactory;
import org.topcased.iterators.configurations.iterator.ALGORITHM_KIND;
import org.topcased.iterators.configurations.iterator.Iterator;
import org.topcased.iterators.configurations.iterator.OperationSet;
import org.topcased.iterators.configurations.iterator.REPRESENTATION_KIND;
import org.topcased.iterators.configurations.listeners.IteratorConfigurationRegistry;
import org.topcased.iterators.configurations.pickers.internal.PickerSet;
import org.topcased.iterators.configurations.utils.RegistryListener;

/**
 * This is a class the user calls to create his custom iterators.
 */
public class IterableCreationManager {

	/**
	 * This class is a singleton.
	 */
	private static IterableCreationManager INSTANCE;

	private final IteratorConfigurationRegistry registry = new IteratorConfigurationRegistry();

	/**
	 * Constructor that retrieves configuration files and that adds a listener to the
	 * workspace that reacts every time a resource is added/deleted/modified.
	 */
	private IterableCreationManager() throws ConfigurationLoadingException {
		try {
			//Retrieving all the configuration files already existing.
			ResourcesPlugin.getWorkspace().getRoot().accept(registry);
			//Creating a ResourceChangeListener from the registry.
			IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {

				public void resourceChanged(IResourceChangeEvent event) {
					try {
						event.getDelta().accept(IterableCreationManager.this.registry);
					} catch (ConfigurationLoadingException e) {
						Activator.logError(e);
					} catch (CoreException e) {
						Activator.logError(e);
					}
				}
			};
			//The listener will update the registry every time a conf file is changed.
			ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener);
		} catch (ConfigurationLoadingException e) {
			throw e;
		} catch (CoreException e) {
			Activator.logError(e);
		}
	}

	/**
	 * Access to the singleton
	 * 
	 * @return the instance of IterableCreationManager.
	 * @throws ConfigurationLoadingException
	 *         in the case there was a problem with the initial loading of the configuration.
	 */
	public static IterableCreationManager getInstance() throws ConfigurationLoadingException {
		if(INSTANCE == null) {
			try {
				INSTANCE = new IterableCreationManager();
			} catch (ConfigurationLoadingException e) {
				Activator.logError(e);
				throw e;
			}
		}
		return INSTANCE;
	}


	public IteratorConfigurationRegistry getRegistry() {
		return this.registry;
	}

	/**
	 * Method that has to be used to create an iterable from its name.
	 * 
	 * @throws ConfigurationLoadingException
	 */
	public static Iterable<?> getIterable(String name, Object startingElement) throws ConfigurationLoadingException {

		IterableCreationManager instance = getInstance();
		IteratorConfigurationRegistry registry = instance.getRegistry();
		Iterator iterator = registry.lookupIterator(name);

		PickerFactory pickerFactory = new PickerFactory();

//		for(String operationSetName : iterator.getOperationImports()) {
//			OperationSet operationSet = registry.lookupOperationSet(operationSetName);
//			pickerFactory.loadOperations(operationSet);
//		}

		//Creating the pickers from the configuration file.
		PickerSet pickers = pickerFactory.createPickerSet(iterator);
		//Creating an iterator factory from the pickers previously created.
		IteratorFactory iteratorFactory = new IteratorFactory(pickers);


		/*
		 * DepthWise is default.
		 */
		if(iterator.getAlgorithm() == ALGORITHM_KIND.WIDTH_WISE) {
			iteratorFactory.activateWidthWisdom();
		}

		/*
		 * Default behavior does not check redundancy.
		 */
		if(iterator.isCheckRedundancy()) {
			iteratorFactory.activateRedundancyAwareness();
		}

		if(iterator.getRepresentation() == REPRESENTATION_KIND.STATE_WISE) {
			return iteratorFactory.createIterable(startingElement);
		}

		if(iterator.getRepresentation() == REPRESENTATION_KIND.TRANSITION_WISE) {
			return iteratorFactory.createTransitionWiseIterable(startingElement);
		}

		return null;
	}

	/**
	 * Adds a listener to the registry.
	 */
	public static void addListenerToRegistry(RegistryListener listener) {
		try {
			getInstance().getRegistry().addListener(listener);
		} catch (ConfigurationLoadingException e) {
			Activator.logError(e);
		}
	}

	/**
	 * Retrieves all the instances of {@link IPicker} that have been found in the workspace
	 * or provided by other plug-ins.
	 * 
	 * @return a map of the available pickers
	 */
	public Map<String, IPicker> getAvailablePickers() {
		return registry.getPickers();
	}



}
