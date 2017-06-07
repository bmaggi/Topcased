/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 * Thibault Landré (Atos Origin) - modification of the preference store to implements
 * preference in Topcased.
 ******************************************************************************/
package org.topcased.modeler.editor;

import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Override the ScrollingGraphicalViewer by associating the ModelerEditor to the GraphicalViewer
 * 
 * @author jako
 */
public class ModelerGraphicalViewer extends DiagramGraphicalViewer
{
    private Modeler editor;

    /**
     * Constructs a ModelerGraphicalViewer
     */
    public ModelerGraphicalViewer()
    {
        super();
    }

    /**
     * Set the ModelerEditor of this GraphicalViewer
     * 
     * @param modeler the ModelerEditor
     */
    public void setModelerEditor(Modeler modeler)
    {
        this.editor = modeler;
    }

    /**
     * Returns the ModelerEditor associated with this GraphicalViewer
     * 
     * @return the ModelerEditor
     */
    public Modeler getModelerEditor()
    {
        return editor;
    }

    /**
     * @see org.eclipse.gef.ui.parts.AbstractEditPartViewer#getProperty(java.lang.String)
     */
    public Object getProperty(String key)
    {
        if (getModelerEditor() != null && (SnapToGeometry.PROPERTY_SNAP_ENABLED.equals(key) || SnapToGrid.PROPERTY_GRID_ENABLED.equals(key) || SnapToGrid.PROPERTY_GRID_VISIBLE.equals(key)))
        {
            IPreferenceStore ps = getModelerEditor().getPreferenceStore();
            if (ps != null)
            {
                return Boolean.valueOf(ps.getBoolean(getModelerEditor().getSite().getId() + "." + key));
            }
        }
        return super.getProperty(key);
    }

    /**
     * @see org.eclipse.gef.ui.parts.AbstractEditPartViewer#setProperty(java.lang.String, java.lang.Object)
     */
    public void setProperty(String key, Object value)
    {
        if (getModelerEditor() != null && (SnapToGeometry.PROPERTY_SNAP_ENABLED.equals(key) || SnapToGrid.PROPERTY_GRID_ENABLED.equals(key) || SnapToGrid.PROPERTY_GRID_VISIBLE.equals(key)))
        {
            IPreferenceStore ps = getModelerEditor().getPreferenceStore();
            if (ps != null)
            {
                ps.setValue(getModelerEditor().getSite().getId() + "." + key, ((Boolean) value).booleanValue());
            }
        }
        super.setProperty(key, value);
    }
}
