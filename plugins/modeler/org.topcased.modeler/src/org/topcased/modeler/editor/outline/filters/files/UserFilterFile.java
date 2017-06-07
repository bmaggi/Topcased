/*****************************************************************************
 * 
 * UserFilterFile.java
 * 
 * Copyright (c) 2008 Atos Origin.
 *
 * Contributors:
 *  Thibault Landré (Atos Origin) thibault.landre@atosorigin.com
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
  *****************************************************************************/
package org.topcased.modeler.editor.outline.filters.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.topcased.modeler.l10n.Messages;

/**
 * A file uses to store user's defined filter. The pre-defined extension of this file is '.fltd'.
 */
public final class UserFilterFile extends File
{

    public static final String EXTENSION = Messages.getString("UserFilterFile.Extension");

    private static final long serialVersionUID = 2203881475329184471L;

    public UserFilterFile(String filePath)
    {
        super(filePath);
    }

    /**
     * Write in the file the elements contained in the list with an element per line.
     * 
     * @param elements the elements to write
     */
    public void writeElements(List<Object> elements)
    {
        try
        {
            FileWriter out = new FileWriter(this);
            for (Object obj : elements)
            {
                out.write(obj.toString());
                out.write(System.getProperty("line.separator")); //$NON-NLS-1$
            }
            out.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Read the file and return a list of elements. An element corresponds to a line in the file.
     * 
     * @return a list of elements found in the file
     */
    public ArrayList<Object> getElements()
    {
        ArrayList<Object> elements = new ArrayList<Object>();
        try
        {
            Scanner scanner = new Scanner(this);

            while (scanner.hasNextLine())
            {
                elements.add(scanner.nextLine());
            }
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return elements;
    }

}
