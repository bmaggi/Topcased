/*****************************************************************************
 * 
 * Copyright (c) 2009 Atos Origin
 *
 * Contributors:
 *  Thibault Landré (Atos Origin) thibault.landre@atosorigin.com - Initial API and implementation
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.topcased.modeler.editor.properties.filters;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IFilter;
import org.topcased.modeler.edit.EMFGraphNodeEditPart;


/**
 * The Class PropertySectionFilter.
 * This class is an abstract filter that manages also the extension point propertySectionFilter.
 * It implements the classic IFilter. Moreover, a test is made to see if a third party tool has requested to hide this section
 */
public abstract class PropertySectionFilter implements IFilter {
	
	/** The extension point id. */
	private static String extensionPointID = "org.topcased.modeler.propertysectionfilter";
	
    /** The config elements. */
    private IConfigurationElement[] configElements;
	
    /** A map containing the filtered sections. */ 
	private Map<String, Boolean> sectionsFiltered; 

	/**
	 * Instantiates a new property section filter.
	 */
	public PropertySectionFilter() {
		initSectionFiltered();
	}
	
	/**
	 * Initialize the map of the declared extension.
	 */
	private void initSectionFiltered() {
		sectionsFiltered = new HashMap<String, Boolean>();
		 if (configElements == null)
	        {
	            configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointID);
	        }
	        for (IConfigurationElement e : configElements)
	        {
	            String name = e.getAttribute("name");
	            Boolean isFiltered = Boolean.valueOf(e.getAttribute("filtered"));
	            sectionsFiltered.put(name, isFiltered);
	        }
	}

	/**
	 * Checks if the section is displayed.
	 * 
	 * @return true, by default. If an extension exists for the sectionId, return the value of the filter. 
	 */
	private boolean isSectionDisplayed(){
		if(sectionsFiltered.containsKey(getSectionId()))
		{
			return !sectionsFiltered.get(getSectionId());
		}
		return true;		
	}
	

	/** 
	 * Test is the section can be displayed and if it can be displayed for the given object
	 * 
	 * This method shouldn't be overriden. Use isValidObject(Obejct toTest) instead
	 * 
	 * @param toTest the to test
	 * @return true, if select
	 * 
	 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
	 */
	public boolean select(Object toTest) {
		if(isSectionDisplayed())
		{
			Object element = toTest;
			if(toTest instanceof EMFGraphNodeEditPart)
			{
				element = ((EMFGraphNodeEditPart)toTest).getEObject();
			}
			return isValidObject(element);
		}
		return false;
	}
	
	/**
	 * The object to test.
	 * 
	 * @param toTest the to test
	 * 
	 * @return true, if checks if is valid object
	 */
	protected abstract boolean isValidObject(Object toTest);
	
	/**
	 * Return the section id where this section is defined. This id is the id of the section defined in the plugin.xml
	 * 
	 * @return the id
	 */
	protected abstract String getSectionId();

}
