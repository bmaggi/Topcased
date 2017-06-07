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
package org.topcased.modeler.edit;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayeredPane;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.ScalableFreeformLayeredPane;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.GridLayer;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.editparts.GridLayerEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.mapmode.IdentityMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.ModelerGraphicalViewer;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;

/**
 * <br>
 * creation : 27 sept. 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class DiagramsRootEditPart extends ScalableFreeformRootEditPart
{
    private IMapMode mmode;

    /**
     * @see org.eclipse.gef.editparts.ScalableFreeformRootEditPart#createPrintableLayers()
     */
    protected LayeredPane createPrintableLayers()
    {
        FreeformLayeredPane layeredPane = new ScalableFreeformLayeredPane();

        layeredPane.add(new FreeformLayer(), PRIMARY_LAYER);
        layeredPane.add(new ConnectionLayerEx(), CONNECTION_LAYER);
        layeredPane.add(new FreeformLayer(), DiagramRootEditPart.DECORATION_PRINTABLE_LAYER);

        return layeredPane;
    }

    /**
     * @see org.eclipse.gef.editparts.FreeformGraphicalRootEditPart#getDragTracker(org.eclipse.gef.Request)
     */
    public DragTracker getDragTracker(Request req)
    {
        DragTracker tracker = null;
        if (getViewer() instanceof ModelerGraphicalViewer)
        {
            Modeler editor = ((ModelerGraphicalViewer) getViewer()).getModelerEditor();
            if (editor.getActiveConfiguration() != null)
            {
                tracker = editor.getActiveConfiguration().getPaletteManager().getMarqueeDragTracker();
            }
        }

        if (tracker == null)
        {
            tracker = super.getDragTracker(req);
        }

        return tracker;
    }

    /**
     * @see org.eclipse.gef.editparts.ScalableFreeformRootEditPart#createScaledLayers()
     */
    protected ScalableFreeformLayeredPane createScaledLayers()
    {
        ScalableFreeformLayeredPane layers = new org.eclipse.gmf.runtime.draw2d.ui.internal.graphics.ScalableFreeformLayeredPane(
                getMapMode());
        ((org.eclipse.gmf.runtime.draw2d.ui.internal.graphics.ScalableFreeformLayeredPane) layers).setAntiAlias(useAntialias());
        layers.add(getPrintableLayers(), PRINTABLE_LAYERS);

        layers.add(createGridLayer(), GRID_LAYER);

        layers.add(new FreeformLayer(), DiagramRootEditPart.DECORATION_UNPRINTABLE_LAYER);
        layers.add(new FreeformLayer(), SCALED_FEEDBACK_LAYER);

        return layers;
    }

    protected GridLayer createGridLayer()
    {
        return new GridLayerEx();
    }

    protected boolean useAntialias()
    {
        return ModelerPlugin.getDefault().getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_USE_ANTIALIAS);
    }

    protected IMapMode getMapMode()
    {
        if (mmode == null)
        {
            mmode = new IdentityMapMode();
        }

        return mmode;
    }
}
