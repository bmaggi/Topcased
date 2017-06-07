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

import java.util.Map;

import org.polarsys.reqcycle.utils.iterators.pickers.IPicker;
import org.topcased.iterators.configurations.ConfigurationManager;
import org.topcased.iterators.configurations.exceptions.NoSuchJavaQueryException;
import org.topcased.iterators.configurations.iterator.JavaQuery;
import org.topcased.iterators.configurations.iterator.Query;
import org.topcased.iterators.configurations.pickers.annotations.IJavaQuery;

/**
 * Factory that creates pickers out of queries defined in the configuration.
 */
public class JavaSubPickerFactory implements ISubPickerFactory {

	/*
	 * A map to store the java queries provided by extensions.
	 */
	private static Map<String, IJavaQuery> queryMap = ConfigurationManager.getJavaQueriesFromExtensions();

	public IPicker createSubPicker(Query query) throws NoSuchJavaQueryException {
		if(query instanceof JavaQuery) {
			return createSubPicker((JavaQuery)query);
		}
		return null;
	}

	/**
	 * Creates a picker from a java query
	 */
	protected IPicker createSubPicker(final JavaQuery query) throws NoSuchJavaQueryException {

		String javaId = query.getJavaid();
		final IJavaQuery javaQuery = queryMap.get(javaId);
		if(javaQuery == null) {
			throw new NoSuchJavaQueryException("No java query was found with the id \"" + javaId + "\".");
		}
		return javaQuery;
	}

}
