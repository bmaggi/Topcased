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
package org.topcased.modeler.preferences;

import java.util.StringTokenizer;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * This class is used to store a PageFormat object. It provides facilities
 * methods to handle it.
 * 
 * Creation : 16 juin 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class PageFormat
{
    /** Basic A5 format */
    public static final PageFormat A5 = new PageFormat("A5", 592, 840, false);

    /** Basic A4 format */
    public static final PageFormat A4 = new PageFormat("A4", 840, 1188, false);

    /** Basic A3 format */
    public static final PageFormat A3 = new PageFormat("A3", 1188, 1680, false);

    /** Basic A2 format */
    public static final PageFormat A2 = new PageFormat("A2", 1680, 2376, false);

    /** Basic A1 format */
    public static final PageFormat A1 = new PageFormat("A1", 2376, 3364, false);

    /** Basic A0 format */
    public static final PageFormat A0 = new PageFormat("A0", 3364, 4756, false);

    private static final String PAGE_FORMAT_DELIMITER = ";";

    private static final int PARAM_NUMBER = 4;

    private String name;

    private int width;

    private int height;

    private boolean isModifiable;

    /**
     * 
     * The constructor
     * 
     * @param name the name of this configuration
     * @param width The page width
     * @param height The page height
     * @param isModifiable <code>true</code> if the configuration ca be
     *            changed
     */
    public PageFormat(String name, int width, int height, boolean isModifiable)
    {
        this.name = name;
        this.width = width;
        this.height = height;
        this.isModifiable = isModifiable;
    }

    /**
     * The Constructor
     * 
     * @param value the String value of a PageFormat (ex:"A4;210;297;false")
     */
    public PageFormat(String value)
    {
        StringTokenizer tokenizer = new StringTokenizer(value, PAGE_FORMAT_DELIMITER);

        if (tokenizer.countTokens() == PARAM_NUMBER)
        {
            this.name = tokenizer.nextToken();
            this.width = StringConverter.asInt(tokenizer.nextToken());
            this.height = StringConverter.asInt(tokenizer.nextToken());
            this.isModifiable = StringConverter.asBoolean(tokenizer.nextToken());
        }
    }

    /**
     * Returns the default page format from the preference store
     * @return the default page format
     */
    public static PageFormat getDefault()
    {
        IPreferenceStore store = ModelerPlugin.getDefault().getPreferenceStore();

        PageFormat defaultPageFormat = null;
        String defaultPageFormatName = store.getString(ModelerPreferenceConstants.P_DEFAULT_PAGE_FORMAT);
        StringTokenizer tokenizerFormats = new StringTokenizer(
                store.getString(ModelerPreferenceConstants.P_PAGE_FORMATS),
                ModelerPreferenceConstants.PAGE_FORMATS_DELIMITER);
        int tokenCount = tokenizerFormats.countTokens();
        for (int i = 0; i < tokenCount; i++)
        {
            PageFormat pageFormat = new PageFormat(tokenizerFormats.nextToken());
            if (defaultPageFormatName.equals(pageFormat.getName()))
            {
                defaultPageFormat = pageFormat;
            }
        }

        return defaultPageFormat;
    }

    /**
     * Returns the page format for the given name from the preference store
     * @param name the page format name
     * @return the page format
     */
    public static PageFormat getPageFormat(String name)
    {
        IPreferenceStore store = ModelerPlugin.getDefault().getPreferenceStore();

        PageFormat foundPageFormat = null;
        StringTokenizer tokenizerFormats = new StringTokenizer(
                store.getString(ModelerPreferenceConstants.P_PAGE_FORMATS),
                ModelerPreferenceConstants.PAGE_FORMATS_DELIMITER);
        int tokenCount = tokenizerFormats.countTokens();
        for (int i = 0; i < tokenCount; i++)
        {
            PageFormat pageFormat = new PageFormat(tokenizerFormats.nextToken());
            if (name.equals(pageFormat.getName()))
            {
                foundPageFormat = pageFormat;
            }
        }

        return foundPageFormat;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return name + PAGE_FORMAT_DELIMITER + width + PAGE_FORMAT_DELIMITER + height + PAGE_FORMAT_DELIMITER
                + isModifiable;
    }

    /**
     * Set the name of the PageFormat
     * 
     * @param newName the new name
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Get the name of the PageFormat
     * 
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the width of the PageFormat
     * 
     * @param newValue the new width
     */
    public void setWidth(int newValue)
    {
        width = newValue;
    }

    /**
     * Get the width of the PageFormat
     * 
     * @return the width
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * Set the height of the PageFormat
     * 
     * @param newValue the new height
     */
    public void setHeight(int newValue)
    {
        height = newValue;
    }

    /**
     * Get the height of the PageFormat
     * 
     * @return the height
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * Set the isModifiable parameter
     * 
     * @param newValue determine if the PageFormat can be modified by the user
     */
    public void setModifiable(boolean newValue)
    {
        isModifiable = newValue;
    }

    /**
     * Return true if the PageFormat is modifiable
     * 
     * @return true if the page format is modifiable
     */
    public boolean getModifiable()
    {
        return isModifiable;
    }

}
