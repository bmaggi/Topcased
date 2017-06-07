/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.internal.editor;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.palette.PaletteRoot;
import org.topcased.modeler.editor.IConfiguration;
import org.topcased.modeler.editor.ICreationUtils;
import org.topcased.modeler.editor.IPaletteManager;
import org.topcased.modeler.graphconf.DiagramGraphConf;

/**
 * A basic Configuration in the case when no diagram is activated
 * 
 * Creation 11 oct. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class NoDiagramConfiguration implements IConfiguration
{

    /**
     * @see org.topcased.modeler.editor.IConfiguration#getCreationUtils()
     */
    public ICreationUtils getCreationUtils()
    {
        return null;
    }

    /**
     * @see org.topcased.modeler.editor.IConfiguration#getDiagramGraphConf()
     */
    public DiagramGraphConf getDiagramGraphConf()
    {
        return null;
    }

    /**
     * @see org.topcased.modeler.editor.IConfiguration#getEditPartFactory()
     */
    public EditPartFactory getEditPartFactory()
    {
        return new EditPartFactory()
        {
            public EditPart createEditPart(EditPart context, Object model)
            {
                return new NoDiagramEditPart();
            }
        };
    }

    /**
     * @see org.topcased.modeler.editor.IConfiguration#getId()
     */
    public String getId()
    {
        return "org.topcased.modeler.nodiagram";
    }

    /**
     * @see org.topcased.modeler.editor.IConfiguration#getName()
     */
    public String getName()
    {
        return "No Diagram is defined";
    }

    /**
     * @see org.topcased.modeler.editor.IConfiguration#getPaletteManager()
     */
    public IPaletteManager getPaletteManager()
    {
        return new IPaletteManager()
        {
            public DragTracker getMarqueeDragTracker()
            {
                return null;
            }

            public PaletteRoot getRoot()
            {
                return new PaletteRoot();
            }

            public void updatePalette()
            {
                // Do nothing
            }
        };
    }

}
