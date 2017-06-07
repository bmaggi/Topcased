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
package org.topcased.iterators.configurations.factories.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.polarsys.reqcycle.utils.iterators.pickers.IPicker;
import org.topcased.iterators.configurations.Activator;
import org.topcased.iterators.configurations.exceptions.NoSuchJavaQueryException;
import org.topcased.iterators.configurations.iterator.EPicker;
import org.topcased.iterators.configurations.iterator.EPickerSet;
import org.topcased.iterators.configurations.iterator.Iterator;
import org.topcased.iterators.configurations.iterator.JavaQuery;
import org.topcased.iterators.configurations.iterator.OCLQuery;
import org.topcased.iterators.configurations.iterator.Query;
import org.topcased.iterators.configurations.pickers.internal.ComposedPicker;
import org.topcased.iterators.configurations.pickers.internal.PickerSet;

/**
 * Creates pickers and pickers sets from the ones defined in the configuration.
 */
public class PickerFactory {

	private static final String STORAGE_METAMODEL = "http://www.topcased.org/iterators/1.0.0";

	private Map<Class<? extends Query>, ISubPickerFactory> subPickerFactories;

	/**
	 * Map to keep pickers so they can be reused by other iterators.
	 */
	private Map<EPicker, IPicker> ePickerToIPickerMap;

	/**
	 * Map to keep picker sets so they can be reused by other iterators.
	 */
	private Map<EPickerSet, PickerSet> eSetToSetMap;


	/**
	 * Constructor.
	 */
	public PickerFactory() {
		//Initializing the OCL evaluator.

		subPickerFactories = new HashMap<Class<? extends Query>, ISubPickerFactory>();
		ePickerToIPickerMap = new HashMap<EPicker, IPicker>();
		eSetToSetMap = new HashMap<EPickerSet, PickerSet>();

		ISubPickerFactory javaPickerFactory = new JavaSubPickerFactory();

		subPickerFactories.put(JavaQuery.class, javaPickerFactory);
	}

	/**
	 * Private methods that uses the right factory to get a picker out
	 * of a query.
	 * 
	 * @throws NoSuchJavaQueryException
	 */
	protected IPicker createSubPicker(Query query) throws NoSuchJavaQueryException {
		if(query instanceof OCLQuery) {
			return subPickerFactories.get(OCLQuery.class).createSubPicker(query);
		}
		if(query instanceof JavaQuery) {
			return subPickerFactories.get(JavaQuery.class).createSubPicker(query);
		}
		return null;
	}

	/**
	 * Creates a picker from the configuration.
	 * 
	 * @throws NoSuchJavaQueryException
	 */
	public IPicker createPicker(EPicker ePicker) throws NoSuchJavaQueryException {
		//The ePicker might have already been processed.
		if(ePickerToIPickerMap.containsKey(ePicker)) {
			return ePickerToIPickerMap.get(ePicker);
		}

		EList<Query> registeredQueries = ePicker.getRegisteredQueries();
		ComposedPicker composedPicker = new ComposedPicker();
		if(registeredQueries.size() == 1) {
			//Returning a composed picker which contains a single element
			//is pointless.
			return createSubPicker(registeredQueries.get(0));
		} else {
			for(Query query : registeredQueries) {
				IPicker subPicker = createSubPicker(query);
				if(subPicker != null) {
					composedPicker.compose(subPicker);
				}
				ePickerToIPickerMap.put(ePicker, composedPicker);
			}
		}
		return composedPicker;
	}

	/**
	 * Creates a picker set from the configuration.
	 */
	protected PickerSet createPickerSet(EPickerSet ePickerSet) {
		//The ePickerSet might have already been processed.
		if(eSetToSetMap.containsKey(ePickerSet)) {
			return eSetToSetMap.get(ePickerSet);
		}

		PickerSet pickerSet = new PickerSet();

		//Adding the pickers that are directly referenced by the picker set.
		for(EPicker ePicker : ePickerSet.getPickers()) {
			IPicker picker;
			try {
				picker = this.createPicker(ePicker);
				pickerSet.add(picker);
			} catch (NoSuchJavaQueryException e) {
				Activator.logError(e);
			}

		}
		//Then, adding the subsets.
		for(EPickerSet eSubSet : ePickerSet.getSubsets()) {
			// RECURSIVE CALL TO RETRIEVE SUBSETS.
			PickerSet subSet = this.createPickerSet(eSubSet);
			pickerSet.addSubSet(subSet);
		}
		//Adding the set to the map.
		eSetToSetMap.put(ePickerSet, pickerSet);
		return pickerSet;
	}


	/**
	 * The method that should be used to create picker sets.
	 */
	public PickerSet createPickerSet(Iterator iterator) {
		return this.createPickerSet(iterator.getPickers());
	}


}
