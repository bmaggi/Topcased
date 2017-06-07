//------------------------------------------------------------------------------
//Copyright (c) 2005, 2008 IBM Corporation and others.
//All rights reserved. This program and the accompanying materials
//are made available under the terms of the Eclipse Public License v1.0
//which accompanies this distribution, and is available at
//http://www.eclipse.org/legal/epl-v10.html
//
//Contributors:
//IBM Corporation - initial implementation
//------------------------------------------------------------------------------
package org.topcased.richtext.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.topcased.richtext.common.CommonPlugin;

/**
* Helper class with methods to retrieve extensions
* Moved part of org.eclipse.epf.library.edit.util.ExtensionManager, to allow
* access by classes that have no dependency on org.eclipse.epf.library.edit
* 
* @author Phong Nguyen Le 
* @author Weiping Lu
* @since  1.5
*/
public class ExtensionHelper {
	private static Map IDToExtensionMap = new HashMap();
	
	public static Object createExtension(String namespace, String extensionPointName) {
		// Process the contributors.
		//
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(namespace, extensionPointName);
		if (extensionPoint != null) {
			IExtension[] extensions = extensionPoint.getExtensions();
			Object ext = null;
			ext_walk:
			for (int i = 0; i < extensions.length; i++) {
				IExtension extension = extensions[i];
				String pluginId = extension.getNamespaceIdentifier();
				Bundle bundle = Platform.getBundle(pluginId);
				IConfigurationElement[] configElements = extension
						.getConfigurationElements();
				for (int j = 0; j < configElements.length; j++) {
					IConfigurationElement configElement = configElements[j];
					try {
						String className = configElement.getAttribute("class"); //$NON-NLS-1$
						if(className != null) {
							ext = bundle.loadClass(className).newInstance();
							break ext_walk;
						}
					} catch (Exception e) {
						CommonPlugin.getDefault().getLogger().logError(e);
					}
				}
			}
			return ext;
		}
		return null;
	}
	
	public static Object getExtension(String namespace, String extensionPointName) {
		String ID = namespace + '.' + extensionPointName;
		Object ext = IDToExtensionMap.get(ID);
		if(ext == null) {
			synchronized (IDToExtensionMap) {
				ext = IDToExtensionMap.get(ID);
				if(ext == null) {
					ext = createExtension(namespace, extensionPointName);
					if(ext != null) {
						IDToExtensionMap.put(ID, ext);
					}
				} 
			}

		}
		return ext;
	}

	public static IMarkerAttributeContributer getMarkerAttributeContributer() {
		IMarkerAttributeContributer ret = (IMarkerAttributeContributer) getExtension(
				CommonPlugin.getDefault().getId(), "markerAttributeContributer");//$NON-NLS-1$
		return ret;
	}
	
	/**
	 * Create object based on type and context through extension
	 * @param type
	 * @param context
	 * @return created object or null if no extension is found
	 */
	public static Object create(Class type, Object context) {
		IObjectFactory ret = (IObjectFactory) getExtension(
				CommonPlugin.getDefault().getId(), "objectFactory");//$NON-NLS-1$
		if (ret == null) {
			return null;
		}
		return ret.create(type, context);
	}
	
	public static <T>List<T> getExtensions(String namespace, String extensionPointName, Class<T> type) {
		List<T> list = new ArrayList<T>();
		try {
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(namespace, extensionPointName);
			if (extensionPoint != null) {
				IExtension[] extensions = extensionPoint.getExtensions();
				for (int i = 0; i < extensions.length; i++) {
					IExtension extension = extensions[i];
					String pluginId = extension.getNamespaceIdentifier();
					Bundle bundle = Platform.getBundle(pluginId);
					IConfigurationElement[] configElements = extension
					.getConfigurationElements();
					for (int j = 0; j < configElements.length; j++) {
						IConfigurationElement configElement = configElements[j];
						try {
							String className = configElement.getAttribute("class"); //$NON-NLS-1$
							if(className != null) {
								Object ext = bundle.loadClass(className).newInstance();
								if(type.isInstance(ext)) {
									list.add((T)ext);
								}
							}
						} catch (Exception e) {
							CommonPlugin.getDefault().getLogger().logError(e);
						}
					}
				}
			}
		}
		catch(Exception e) {
			CommonPlugin.getDefault().getLogger().logError(e);
		}
		if(list.isEmpty()) {
			return Collections.<T>emptyList();
		}
		return list;
	}


}
