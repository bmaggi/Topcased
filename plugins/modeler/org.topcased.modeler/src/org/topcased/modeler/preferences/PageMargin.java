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
 * This class is used to store a PageMargin object. It provides facilities
 * methods to handle it.
 * 
 * Creation : 16 juin 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class PageMargin
{

    /** Basic No margin */
    public static final PageMargin NO_MARGIN = new PageMargin("No Margin", 0, 0, 0, 0, false);

    /** Basic Small margin */
    public static final PageMargin SMALL_MARGIN = new PageMargin("Small Margin", 20, 20, 20, 20, false);

    private static final String PAGE_MARGIN_DELIMITER = ";";

    private static final int PARAM_NUMBER = 6;

    private String name;

    private int top;

    private int left;

    private int bottom;

    private int right;

    private boolean isModifiable;

    /**
     * The constructor
     * 
     * @param name the name of this configuration
     * @param top Top margin
     * @param left Left margin
     * @param bottom Bottom margin
     * @param right Right margin
     * @param isModifiable <code>true</code> if the configuration ca be
     *            changed
     */
    public PageMargin(String name, int top, int left, int bottom, int right, boolean isModifiable)
    {
        this.name = name;
        this.top = top;
        this.left = left;
        this.bottom = bottom;
        this.right = right;
        this.isModifiable = isModifiable;
    }

    /**
     * The Constructor
     * 
     * @param value the String value of a PageMargin (ex:"No
     *            Margin;0;0;0;0;false")
     */
    public PageMargin(String value)
    {
        StringTokenizer tokenizer = new StringTokenizer(value, PAGE_MARGIN_DELIMITER);

        if (tokenizer.countTokens() == PARAM_NUMBER)
        {
            this.name = tokenizer.nextToken();
            this.top = StringConverter.asInt(tokenizer.nextToken());
            this.left = StringConverter.asInt(tokenizer.nextToken());
            this.bottom = StringConverter.asInt(tokenizer.nextToken());
            this.right = StringConverter.asInt(tokenizer.nextToken());
            this.isModifiable = StringConverter.asBoolean(tokenizer.nextToken());
        }
    }

    /**
     * Returns the default page margin from the preference store
     * @return the default page margin
     */
    public static PageMargin getDefault()
    {
        IPreferenceStore store = ModelerPlugin.getDefault().getPreferenceStore();
        
        PageMargin defaultPageMargin = null;
        String defaultPageMarginName = store.getString(ModelerPreferenceConstants.P_DEFAULT_PAGE_MARGIN);
        StringTokenizer tokenizerMargins = new StringTokenizer(
                store.getString(ModelerPreferenceConstants.P_PAGE_MARGINS),
                ModelerPreferenceConstants.PAGE_MARGINS_DELIMITER);
        int tokenCount = tokenizerMargins.countTokens();
        for (int i = 0; i < tokenCount; i++)
        {
            PageMargin pageMargin = new PageMargin(tokenizerMargins.nextToken());
            if (defaultPageMarginName.equals(pageMargin.getName()))
            {
                defaultPageMargin = pageMargin;
            }
        }
        
        return defaultPageMargin;
    }

    /**
     * Returns the page margin for the given name from the preference store
     * @param name the page margin name
     * @return the page margin
     */
    public static PageMargin getPageMargin(String name)
    {
        IPreferenceStore store = ModelerPlugin.getDefault().getPreferenceStore();
        
        PageMargin foundPageMargin = null;
        StringTokenizer tokenizerMargins = new StringTokenizer(
                store.getString(ModelerPreferenceConstants.P_PAGE_MARGINS),
                ModelerPreferenceConstants.PAGE_MARGINS_DELIMITER);
        int tokenCount = tokenizerMargins.countTokens();
        for (int i = 0; i < tokenCount; i++)
        {
            PageMargin pageMargin = new PageMargin(tokenizerMargins.nextToken());
            if (name.equals(pageMargin.getName()))
            {
                foundPageMargin = pageMargin;
            }
        }
        
        return foundPageMargin;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return name + PAGE_MARGIN_DELIMITER + top + PAGE_MARGIN_DELIMITER + left + PAGE_MARGIN_DELIMITER + bottom
                + PAGE_MARGIN_DELIMITER + right + PAGE_MARGIN_DELIMITER + isModifiable;
    }

    /**
     * Set the name of the PageMargin
     * 
     * @param newName the new name
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Get the name of the PageMargin
     * 
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the top margin of the PageMargin
     * 
     * @param newValue the new top margin
     */
    public void setTop(int newValue)
    {
        top = newValue;
    }

    /**
     * Get the top margin of the PageMargin
     * 
     * @return the top margin
     */
    public int getTop()
    {
        return top;
    }

    /**
     * Set the left margin of the PageMargin
     * 
     * @param newValue the new left margin
     */
    public void setLeft(int newValue)
    {
        left = newValue;
    }

    /**
     * Get the left margin of the PageMargin
     * 
     * @return the left margin
     */
    public int getLeft()
    {
        return left;
    }

    /**
     * Set the bottom margin of the PageMargin
     * 
     * @param newValue the new bottom margin
     */
    public void setBottom(int newValue)
    {
        bottom = newValue;
    }

    /**
     * Get the bottom margin of the PageMargin
     * 
     * @return the bottom margin
     */
    public int getBottom()
    {
        return bottom;
    }

    /**
     * Set the right margin of the PageMargin
     * 
     * @param newValue the new right margin
     */
    public void setRight(int newValue)
    {
        right = newValue;
    }

    /**
     * Get the right margin of the PageMargin
     * 
     * @return the right margin
     */
    public int getRight()
    {
        return right;
    }

    /**
     * Set the isModifiable parameter
     * 
     * @param newValue determine if the PageMargin can be modified by the user
     */
    public void setModifiable(boolean newValue)
    {
        isModifiable = newValue;
    }

    /**
     * Return true if the PageMargin is modifiable
     * 
     * @return true if the PageMargin is modifiable
     */
    public boolean getModifiable()
    {
        return isModifiable;
    }
}
