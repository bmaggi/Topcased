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

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * The Class GetExpressionByRegex.
 */
public class GetExpressionByRegex
{

    /** The patterns. */
    Map<String, Pattern> patterns = new HashMap<String, Pattern>();

    /**
     * Add a pattern for recognition (use | for or) of an attribute don't forget to use groups to get attribute value
     * the regex must matches the entire future argument string.
     * 
     * @param attribute the attribute
     * @param regex the regex
     */
    public void addPattern(String attribute, String regex)
    {
        try
        {
            Pattern pattern = Pattern.compile(regex);
            patterns.put(attribute, pattern);
        }
        catch (PatternSyntaxException e)
        {
        }
    }

    /**
     * returns the value of the attribute attributeName in argumentString.
     * 
     * @param attributeName the attribute name
     * @param argumentString the argument string
     * 
     * @return the attribute value
     */
    public String getAttributeValue(String attributeName, String argumentString)
    {
        String result = "";
        Pattern p = patterns.get(attributeName);
        if (p != null)
        {
            Matcher m = p.matcher(argumentString);
            if (m.matches())
            {
                if (m.groupCount() > 0)
                {
                    for (int i = 1; i <= m.groupCount() && result.length() == 0; i++)
                    {
                        String tmp = m.group(i);
                        if (tmp != null && tmp.trim().length() > 0)
                        {
                            result = tmp;
                        }
                    }
                }
            }
        }
        return result;
    }
}
