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
import org.topcased.modeler.di.model.Diagram;

/**
 * Manager for the EditPartFactories of each diagram. <br>
 * creation : 25 janv. 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public interface IEditPartFactoryManager
{
    /**
     * This method returns the edit part factory associated with the given
     * diagram type.
     * 
     * @param diag the active diagram
     * @return the active EditPartFactory
     */
    public EditPartFactory getEditPartFactory(Diagram diag);
}
