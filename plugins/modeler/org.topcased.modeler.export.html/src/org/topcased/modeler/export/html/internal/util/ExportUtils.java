/*******************************************************************************
 * Copyright (c) 2009 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jose Alfredo Serrano (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.export.html.internal.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.commands.CommandStack;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.commands.ChangeDiagramPropertiesCommand;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.utils.Utils;

/**
 * 
 * @author <a href="mailto:jose.alfredo.serrano@anyware-tech.com">Jose Alfredo SERRRANO</a>
 *
 */
public final class ExportUtils {

	private ExportUtils() {/* forbid instantiation*/}
	
	/**
	 * Generates a unique name for the diagram
	 * 
	 * @return An available name based on the commonBasis
	 */
	public static String getFirstAvailableName(String commonBasis, List<String> existingNames, int cpt)
    {
        if (existingNames.contains(commonBasis+cpt)) {
            return getFirstAvailableName(commonBasis, existingNames, cpt+1);
        }      
        return commonBasis+cpt;
    }

    /**
     * Escape all characters that may result in a wrong file name
     * 
     * @param pathName a file name to encode
     * @return The encoded file name
     */
    public static String encodeFileName(String pathName)
    {
        return pathName.replaceAll("[\":*?/|<>\\\\]", "_");
        // return URLEncoder.encode(pathName, "UTF-8").replaceAll("[*]", "_");
    }
    
    /**
     * Get the command stack of the modeler
     * @param modeler the modeler
     * @return the command stack to use
     */
    public static CommandStack getCommandStack(Modeler modeler) {
        return (CommandStack)modeler.getAdapter(CommandStack.class);
    }



    /**
     * Resize the given diagram with an optimized dimension.
     * @param modeler the current editor
     * @param currentDiagram the diagram to resize
     */
    public static void resizeDiagram(Modeler modeler, Diagram currentDiagram)
    {
        // Get the optimized dimension
        Dimension dim =  Utils.getDiagramOptimizedDimension(modeler);
        
        //Create the map of properties for the diagram.
        Map<String, String> newProperties = new HashMap<String, String>();
        newProperties.put(ModelerPropertyConstants.PAGE_FORMAT_NAME, "");
        newProperties.put(ModelerPropertyConstants.PAGE_MARGIN_NAME, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.PAGE_FORMAT_NAME));
        newProperties.put(ModelerPropertyConstants.TOP_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.TOP_MARGIN));
        newProperties.put(ModelerPropertyConstants.BOTTOM_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.BOTTOM_MARGIN));
        newProperties.put(ModelerPropertyConstants.LEFT_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.LEFT_MARGIN));
        newProperties.put(ModelerPropertyConstants.RIGHT_MARGIN, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.RIGHT_MARGIN));
        newProperties.put(ModelerPropertyConstants.ORIENTATION, DIUtils.getPropertyValue(currentDiagram, ModelerPropertyConstants.ORIENTATION));
        newProperties.put(ModelerPropertyConstants.PAGE_WIDTH, String.valueOf(dim.width));
        newProperties.put(ModelerPropertyConstants.PAGE_HEIGHT, String.valueOf(dim.height));
                      
        // Create the command to change the property of the diagram
        ChangeDiagramPropertiesCommand changeDiagramPropertiesCommand = new ChangeDiagramPropertiesCommand(currentDiagram, newProperties);
        
        // execute it
        CommandStack commandStack = getCommandStack(modeler);
        commandStack.execute(changeDiagramPropertiesCommand);
    }
}
