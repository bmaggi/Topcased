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

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.requests.CreationFactory;

/**
 * Returns the creation factory for a palette drop. <br>
 * creation : 30 nov. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class PaletteDropListener extends TemplateTransferDropTargetListener
{

    /**
     * Constructor
     * 
     * @param viewer the diagram viewer
     */
    public PaletteDropListener(EditPartViewer viewer)
    {
        super(viewer);
    }

    protected CreationFactory getFactory(Object template)
    {
        return (CreationFactory) template;
    }

}
