/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.editor.outline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.widgets.Text;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.utils.Utils;

/**
 * Class managing an history for user search
 * @author tfaure
 *
 */
public class HistoryContentAssistTextField extends AutoCompleteField
{

    private static String PREFERENCE_FOR_USER_SEARCH_HISTORY = "preference_for_user_search_history";
    private LinkedList<String> list = new LinkedList<String>();
    
    public HistoryContentAssistTextField(Text text, TextContentAdapter textContentAdapter)
    {
        super(text, textContentAdapter, new String[]{});
        String[] strings = getArray(ModelerPlugin.getDefault().getPreferenceStore().getString(PREFERENCE_FOR_USER_SEARCH_HISTORY));
        Collections.addAll(list, strings);
        int index = 0 ;
        for (Iterator<String> i = list.iterator() ; i.hasNext() ;)
        {
            i.next();
            if (index >= getLimitSize())
            {
                i.remove();
            }
            index ++ ;
        }
    }

    /**
     * Transform a string into an array of string
     * @param string
     * @return
     */
    private String[] getArray(String string)
    {
        return string.split("%20");
    }

    /**
     * Get all the proposals from the text
     * @param text
     * @return
     */
    protected String[] getAllProposals(String text)
    {
        if (list != null)
        {
            List<String> strings = new ArrayList<String>(list);
            Collections.sort(strings);
            if (text != null && text.length() > 0)
            {
                for (Iterator<String> i = strings.iterator(); i.hasNext();)
                {
                    String tmp = i.next();
                    if (!tmp.startsWith(text))
                    {
                        i.remove();
                    }
                }
            }
            String[] proposals = strings.toArray(new String[] {});
            return proposals;
        }
        return new String[]{};

    }
    
    /**
     * add String in history
     * @param s
     */
    public void addString(String s)
    {
        if (!list.contains(s) && s != null && s.length() > 0)
        {
            list.addFirst(s);
            if (list.size() > getLimitSize())
            {
                list.removeLast();
            }
        }
        // if the element is contained the position is set to zero
        else if (list.contains(s))
        {
            list.remove(s);
            list.addFirst(s);
        }
    }

    private static int getLimitSize()
    {
        return Utils.getPreferenceStoreAccordingToCurrentIFile().getInt(ModelerPreferenceConstants.PREFERENCE_OUTLINE_LIMIT_FOR_HISTORIK);
    }
    
    /**
     * Return a string from an array
     * @param strings
     * @return
     */
    private String getString(String[] strings)
    {
        StringBuffer buffer = new StringBuffer("");
        for (String s : strings)
        {
            buffer.append(s).append("%20");
        }
        return buffer.toString();
    }
    
    /**
     * Save History in preferences
     */
    public void saveHistory()
    {
        String[] strings = list.toArray(new String[] {});
        ModelerPlugin.getDefault().getPreferenceStore().putValue(PREFERENCE_FOR_USER_SEARCH_HISTORY, getString(strings));

    }

    /**
     * force proposals to be refreshed
     * @param string
     */
    public void refreshProposals(String string)
    {
        setProposals(getAllProposals(string));
    }

}
