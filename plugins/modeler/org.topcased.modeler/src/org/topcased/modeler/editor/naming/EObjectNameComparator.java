/***********************************************************************
 * Copyright (c) 2008 Obeo and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Laurent Redor (Obeo) - initial API and implementation
 *    Pierre-Charles David (Obeo) - initial API and implementation
 *    David Sciamma (Anyware Technologies) - Workaround for an EMF bug with EFS URI
 *    Gilles Cannenterre (Anyware Technologies) - provide a shared Clipboard
 **********************************************************************/
package org.topcased.modeler.editor.naming;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.topcased.modeler.editor.TopcasedAdapterFactoryEditingDomain;

/**
 * public static class comparing two string according to a specific pattern grouping numeric characters
 * It has been extracted from {@link TopcasedAdapterFactoryEditingDomain}.
 */
public class EObjectNameComparator implements Comparator<String>
{

    private final Pattern pattern;

    public EObjectNameComparator(Pattern pattern)
    {
        this.pattern = pattern;
    }

    public int compare(String o1, String o2)
    {
        if (o1 == null)
        {
            o1 = "";
        }
        if (o2 == null)
        {
            o2 = "";
        }
        Matcher m1 = pattern.matcher(o1);
        Matcher m2 = pattern.matcher(o2);
        Integer val1 = -1;
        Integer val2 = -1;
        if (m1.matches() && m1.groupCount() > 0)
        {
            try
            {
                val1 = Integer.valueOf(m1.group(1));
            }
            catch (NumberFormatException e)
            {
            }
        }
        if (m2.matches() && m2.groupCount() > 0)
        {
            try
            {
                val2 = Integer.valueOf(m2.group(1));
            }
            catch (NumberFormatException e)
            {
            }

        }
        return val1.compareTo(val2);
    }

}