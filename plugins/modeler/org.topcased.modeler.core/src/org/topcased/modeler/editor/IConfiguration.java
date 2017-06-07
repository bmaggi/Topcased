/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.editor;

import org.eclipse.gef.EditPartFactory;
import org.topcased.modeler.graphconf.DiagramGraphConf;

/**
 * A diagram configuration : manages Palette, EditPartFactory for this diagram.
 * <br>
 * creation : 25 janv. 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public interface IConfiguration
{
    /**
     * Returns the id of this diagram configuration.
     * 
     * @return the diagram id
     */
    String getId();

    /**
     * Returns the display name of this diagram configuration.
     * 
     * @return the diagram name
     */
    String getName();

    /**
     * Returns the EditPartFactory for this diagram
     * 
     * @return the current edit part factory
     */
    EditPartFactory getEditPartFactory();

    /**
     * Returns the Palette manager for this diagram
     * 
     * @return the current palette manager
     */
    IPaletteManager getPaletteManager();

    /**
     * Returns the CreationUtils class for this diagram
     * 
     * @return the class
     */
    ICreationUtils getCreationUtils();
    
    /**
     * Get the DiagramGraphConf model object associated with the diagram
     * 
     * @return the DiagramGraphConf model object
     */
    DiagramGraphConf getDiagramGraphConf();
}
