/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Caroline Bourdeu d'Aguerre (2009) caroline.bourdeudaguerre@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.topcased.modeler.preferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * The Class PaletteConfigurationController.
 */
public final class PaletteConfigurationController {


	/** The extension point. */
	private static final String EXTENSION_POINT_ID = "org.topcased.modeler.paletteConfiguration";

	// This is a singleton
	/** The instance. */
	private static PaletteConfigurationController instance = new PaletteConfigurationController();

	/** The visible elements. */
	private static Map<String, PaletteConfigurator> visibleElements;

	/** All plugin plug to the extension point. */
	private IConfigurationElement[] configElements = Platform
			.getExtensionRegistry().getConfigurationElementsFor(
					EXTENSION_POINT_ID);
	
	/**
	 * Instantiates a new palette configuration controller.
	 */
	private PaletteConfigurationController() {
		initializeElements();
	}

	/**
	 * Gets the single instance of PaletteConfigurationController.
	 * 
	 * @return single instance of PaletteConfigurationController
	 */
	public static PaletteConfigurationController getInstance() {
		return instance;
	}

	/**
	 * Gets the all palette configuration.
	 * 
	 * @return the all palette configuration
	 */
	public ArrayList<String> getAllPaletteConfiguration()
	{
		ArrayList<String> configs = new ArrayList<String>(); 
		for (IConfigurationElement e : configElements) {
			configs.add(e.getAttribute("name"));
		}
		return configs;
	}
	
	/**
	 * Initialize elements from all extension point
	 */
	private void initializeElements() {
		visibleElements = new HashMap<String, PaletteConfigurator>();

		// For all registered elements
		for (IConfigurationElement e : configElements) {
			String paletteConfiguration = e.getAttribute("name");
			if (paletteConfiguration != null
					&& paletteConfiguration.length() > 0) {
				PaletteConfigurator conf = new PaletteConfigurator();
				visibleElements.put(paletteConfiguration, conf);

				// Add all diagram
				for (IConfigurationElement diagrams : e
						.getChildren("diagramSpecificPalette")) {
					String diagramPalette = diagrams.getAttribute("diagramId");
					if (diagramPalette != null && diagramPalette.length() > 0) {
						DiagramConfigurator diag = new DiagramConfigurator();
						conf.put(diagramPalette, diag);

						// Add all palette element
						for (IConfigurationElement elem : diagrams
								.getChildren("paletteElement")) {
							diag.add(elem.getAttribute("name").replaceAll(" ", "").toLowerCase());
						}
					}
				}
			}
		}
	}

	/**
	 * Checks if the element is visible for the given diagram
	 * according to the palette configuration preference
	 * 
	 * @param diagramId the diagram id
	 * @param element the element
	 * 
	 * @return true, if is visible
	 */
	public boolean isVisible(String diagramId, String element) {
		boolean isVisible = true;

		// get the configurator from preferences
		String configuratorId = getPreferenceStore()
				.getString(
						ModelerPreferenceConstants.PREFERENCE_FOR_PALETTE_CONFIGURATION);
		if (configuratorId != null && configuratorId.length() > 0) {
			PaletteConfigurator palette = visibleElements.get(configuratorId);
			if (palette != null) {
				DiagramConfigurator diag = palette.getDiagramConfigurator(diagramId);
				if (diag != null) {
					isVisible = diag.isVisible(element);
				}
			}
		}
		return isVisible;
	}

	/**
	 * Gets the preference store.
	 * 
	 * @return the preference store
	 */
	private IPreferenceStore getPreferenceStore() {
		IFile currentFile = Modeler.getCurrentIFile();
        if (currentFile != null)
        {
            IProject project = currentFile.getProject();
            Preferences root = Platform.getPreferencesService().getRootNode();
            if (project != null && root != null)
            {
            	try
            	{
            		if (root.node(ProjectScope.SCOPE).node(project.getName()).nodeExists(ModelerPlugin.getId()))
            		{
            			return new ScopedPreferenceStore(new ProjectScope(project), ModelerPlugin.getId());
            		}
            	}
            	catch (BackingStoreException e)
            	{
            		e.printStackTrace();
            	}
            }
        }
		return ModelerPlugin.getDefault().getPreferenceStore();
	}


	/**
	 * The Class PaletteConfigurator.
	 */
	private class PaletteConfigurator {
		
		/** The palette configurators. */
		private Map<String, DiagramConfigurator> paConfigurators = new HashMap<String, DiagramConfigurator>();

		/**
		 * Gets the diagram configurator.
		 * 
		 * @param diagramName the diagram name
		 * 
		 * @return the diagram configurator
		 */
		public DiagramConfigurator getDiagramConfigurator(String diagramName) {
			return paConfigurators.get(diagramName);
		}

		/**
		 * Put in the palette configurators
		 * 
		 * @param diagName the diag name
		 * @param conf the conf
		 */
		public void put(String diagName, DiagramConfigurator conf) {
			paConfigurators.put(diagName, conf);
		}
	}

	/**
	 * The Class DiagramConfigurator.
	 */
	private class DiagramConfigurator {
		
		/** The dia configurators. */
		private Set<String> diaConfigurators = new HashSet<String>();

		/**
		 * Checks if the given element is visible.
		 * 		=> is in diagram configuration list
		 * 
		 * @param elem the elem
		 * 
		 * @return true, if is visible
		 */
		public boolean isVisible(String elem) {
			return diaConfigurators.contains(elem.replaceAll(" ", "").toLowerCase());
		}

		/**
		 * Adds the element name in the diagram configuration
		 * 
		 * @param elementName the element name
		 */
		public void add(String elementName) {
			diaConfigurators.add(elementName);
		}
	}
}
