/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.topcased.modeler.internal.editor.palette;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * Class that helps to save and restore the state of the palette.
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class PaletteStateRecorder
{
    private File getPaletteStateFile(String diagramId)
    {
        IPath path = ModelerPlugin.getDefault().getStateLocation();
        if (path == null)
        {
            return null;
        }
        path = path.append(diagramId + ".xml");
        return path.toFile();
    }

    public void saveState(String diagramId, PaletteViewer palette)
    {
        XMLMemento memento = XMLMemento.createWriteRoot("PaletteState");
        palette.saveState(memento);

        // Save it to a file.
        File stateFile = getPaletteStateFile(diagramId);
        if (stateFile != null)
        {
            try
            {
                FileOutputStream stream = new FileOutputStream(stateFile);
                OutputStreamWriter writer = new OutputStreamWriter(stream, "utf-8"); //$NON-NLS-1$
                memento.save(writer);
                writer.close();
            }
            catch (IOException ioe)
            {
                stateFile.delete();
                ModelerPlugin.log(ioe);
            }
        }
    }

    public void restoreState(String diagramId, PaletteViewer palette)
    {
        palette.getControl().setRedraw(false);
        final File stateFile = getPaletteStateFile(diagramId);

        // check that there is a state file
        if (stateFile != null && stateFile.exists())
        {

            try
            {
                FileInputStream input = new FileInputStream(stateFile);
                BufferedReader reader = new BufferedReader(new InputStreamReader(input, "utf-8")); //$NON-NLS-1$
                IMemento memento = XMLMemento.createReadRoot(reader);

                palette.restoreState(memento);
            }
            catch (FileNotFoundException fnfe)
            {
                ModelerPlugin.log(fnfe);
            }
            catch (UnsupportedEncodingException uee)
            {
                ModelerPlugin.log(uee);
            }
            catch (WorkbenchException we)
            {
                ModelerPlugin.log(we);
            }
        }
        palette.getControl().setRedraw(true);
    }
}
