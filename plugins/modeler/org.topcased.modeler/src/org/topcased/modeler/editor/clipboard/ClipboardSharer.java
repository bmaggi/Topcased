/***********************************************************************
 * Copyright (c) 2012 CNES
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Vincent Hemery (CS) - initial API and implementation
 **********************************************************************/
package org.topcased.modeler.editor.clipboard;

import java.util.Collection;
import java.util.Collections;

public class ClipboardSharer
{
    /**
     * Class holding the singleton
     */
    private static class ClipboardHolder
    {
        /** This is the current clipboard. */
        private static Collection<Object> staticClipboard = Collections.emptyList();
    }

    /**
     * Gets the clipboard shared among all TOPCASED editors.
     * 
     * @return the clipboard
     * 
     * @see org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain#getClipboard()
     */
    public static Collection<Object> getClipboard()
    {
        return ClipboardHolder.staticClipboard;
    }

    /**
     * Sets the clipboard shared among all TOPCASED editors.
     * 
     * @param clipboard the new clipboard
     * 
     * @see org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain#setClipboard(java.util.Collection)
     */
    public static void setClipboard(Collection<Object> clipboard)
    {
        ClipboardHolder.staticClipboard = clipboard;
    }
}
