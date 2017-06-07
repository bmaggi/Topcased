/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies), 
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.editor;

import org.topcased.modeler.di.model.Diagram;

/**
 * Listener that are notified of navigation events
 * <br>creation : 16 déc. 2005
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public interface INavigationListener
{
    /**
     * Method called when the current diagram changes
     * @param newDiagram
     */
    void diagramChanged(Diagram newDiagram);
}
