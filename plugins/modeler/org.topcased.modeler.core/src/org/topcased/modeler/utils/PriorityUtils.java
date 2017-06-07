/*******************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Tristan FAURE - ATOS ORIGIN
 *******************************************************************************/
package org.topcased.modeler.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Class to order list according to priorities
 * @author tfaure
 *
 */
public class PriorityUtils
{
    private static final int HIGHEST = 1;

    private static final int HIGH = 2;

    private static final int MIDDLE = 3;

    private static final int LOW = 4;

    private static final int LOWEST = 5;
    
    private static class PriorityComparator<T> implements Comparator<T>
    {
        private final Map<T, Integer> map;

        public PriorityComparator(Map<T, Integer> map)
        {
            this.map = map;
        }

        public int compare(T o1, T o2)
        {
            Integer i1 = map.get(o1);
            if (i1 == null)
            {
                i1 = LOWEST;
            }
            Integer i2 = map.get(o2);
            if (i2 == null)
            {
                i2 = LOWEST;
            }
            return i1.compareTo(i2);
        }

    }
    
    /**
     * Get an integer value from a priority including :
     * LOWEST
     * LOW
     * MIDDLE or NORMAL
     * HIGH
     * HIGHEST
     * @param attribute
     * @return
     */
    public static Integer getPriority(String attribute)
    {
        if ("LOWEST".equals(attribute))
        {
            return LOWEST;
        }
        else if ("LOW".equals(attribute))
        {
            return LOW;
        }
        else if ("MIDDLE".equals(attribute))
        {
            return MIDDLE;
        }
        else if ("NORMAL".equals(attribute))
        {
            return MIDDLE;
        }
        else if ("HIGH".equals(attribute))
        {
            return HIGH;
        }
        else if ("HIGHEST".equals(attribute))
        {
            return HIGHEST;
        }
        return LOWEST;
    }

    /**
     * Sort a list according to the map with key contained in the list and their priorities
     * @param <T>
     * @param list
     * @param priorities
     */
    public static <T> void sort(List<T> list, Map<T, Integer> priorities)
    {
        Comparator<T> priorityComparator1 = new PriorityComparator<T>(priorities);
        Collections.sort(list, priorityComparator1);
    }
}
