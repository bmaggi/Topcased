/*****************************************************************************
 * Copyright (c) 2013 Atos
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Anne Haugommard (Atos ) anne.haugommard@atos.net - Initial API and implementation
 * 
 *****************************************************************************/
package org.topcased.preferences.batch;

/**
 * The Class ArgOpt.
 */
public class ArgOpt
{

    /** The Constant NO_ARGUMENT_VALUE. */
    public static final int NO_ARGUMENT_VALUE = 0;

    /** The Constant REQUIRED_ARGUMENT_VALUE. */
    public static final int REQUIRED_ARGUMENT_VALUE = 1;

    /** The Constant OPTIONAL_ARGUMENT_VALUE. */
    public static final int OPTIONAL_ARGUMENT_VALUE = 2;

    /** The Constant REQUIRED_ARGUMENT. */
    public static final int REQUIRED_ARGUMENT = 0;

    /** The Constant OPTIONAL_ARGUMENT. */
    public static final int OPTIONAL_ARGUMENT = 1;

    /** The Constant ALONE_ARGUMENT. */
    public static final int ALONE_ARGUMENT = 2;

    /** The long name. */
    protected String longName;

    /** The arg type. */
    protected int argType;

    /** The arg value type. */
    protected int argValueType;

    /** The short name. */
    protected String shortName;

    /** The description. */
    protected String description;

    /**
     * Instantiates a new arg opt.
     * 
     * @param longName the long name
     * @param argType the arg type
     * @param argValueType the arg value type
     * @param shortName the short name
     * @param description the description
     */
    public ArgOpt(String longName, int argType, int argValueType, String shortName, String description)
    {
        this.longName = longName;
        this.argType = argType;
        this.argValueType = argValueType;
        this.shortName = shortName;
        this.description = description;
    }

    /**
     * Gets the long name.
     * 
     * @return the long name
     */
    public String getLongName()
    {
        return this.longName;
    }

    /**
     * Gets the arg_type.
     * 
     * @return the arg_type
     */
    public int getArg_type()
    {
        return this.argType;
    }

    /**
     * Gets the arg value_type.
     * 
     * @return the arg value_type
     */
    public int getArgValue_type()
    {
        return this.argValueType;
    }

    /**
     * Gets the short name.
     * 
     * @return the short name
     */
    public String getShortName()
    {
        return this.shortName;
    }

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription()
    {
        return this.description;
    }

}
