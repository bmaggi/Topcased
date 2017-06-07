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
package org.topcased.iterators.configurations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.topcased.iterators.configurations.pickers.annotations.IJavaQuery;

public class ConfigurationManager {

	private static final String PLUGIN_ID = "org.topcased.iterators.configurations";

	private static final String REGISTERED_CONFIGURATION_ID = "registeredConfiguration";

	private static final String JAVA_QUERY_ID = "javaQuery";

	/**
	 * This method evaluates the extensions provided by other plug-ins
	 * for the "registeredConfiguration" extension point.
	 * 
	 * @return a set of URIs corresponding to configuration files
	 */
	public static Set<URI> getConfigurationFilesFromExtensions() {

		Set<URI> uris = new HashSet<URI>();

		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(PLUGIN_ID + "." + REGISTERED_CONFIGURATION_ID);
		IConfigurationElement[] config = extensionPoint.getConfigurationElements();

		for(IConfigurationElement configElement : config) {
			String iteratorFile = configElement.getAttribute("iteratorFile");

			String pluginPath = configElement.getContributor().getName();
			URI fileURI = URI.createPlatformPluginURI(pluginPath + "/" + iteratorFile, true);
			uris.add(fileURI);
		}

		return uris;
	}

	/**
	 * This method evaluates the extensions provided by other plug-ins
	 * for the "javaQuery" extension point.
	 * 
	 * @return a map of java queries
	 */
	public static Map<String, IJavaQuery> getJavaQueriesFromExtensions() {

		HashMap<String, IJavaQuery> queryMap = new HashMap<String, IJavaQuery>();

		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(PLUGIN_ID + "." + JAVA_QUERY_ID);
		IConfigurationElement[] config = extensionPoint.getConfigurationElements();

		for(IConfigurationElement configElement : config) {
			String queryId = configElement.getAttribute("queryId");
			IJavaQuery javaQuery;
			try {
				javaQuery = (IJavaQuery)configElement.createExecutableExtension("queryClass");
				queryMap.put(queryId, javaQuery);
			} catch (CoreException e) {
				Activator.logError(e);
			}

		}

		return queryMap;

	}

}
