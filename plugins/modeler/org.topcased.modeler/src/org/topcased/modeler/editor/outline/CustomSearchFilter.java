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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Text;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.utils.Utils;

/**
 * This class allows user to filter outline with "mini" command language text => filter on any attrivute #text
 * => search element with urifragment equals to text :text => search element with type equals to text ?text1:text2
 * => search element with attribute text1 containing text2 ?text1,text3:text2 => search element with attribute text1
 * and text3 containing text2
 * 
 * @author tfaure
 * 
 */
/**
 * @author tfaure
 * 
 */
public class CustomSearchFilter extends KeyAdapter
{
    private final Text text;

    private String searchedText = null;

    /**
     * pattern for uri fragment
     */
    private Pattern patternFragment = Pattern.compile("#.*");

    /**
     * pattern for type of element
     */
    private Pattern patternType = Pattern.compile(":.*");

    /**
     * pattern for multi attributes
     */
    private Pattern patternForSpecificFeature = Pattern.compile("\\?(.*):(.*)");

    private List<String> featureName = null;

    /**
     * the pattern which will manage the ?*:*
     */
    private Pattern patternToSearch = null;

    private List<EObject> selection = new LinkedList<EObject>();

    private Set<EObject> alreadyFind = new HashSet<EObject>();

    private Set<EObject> alreadyNotFind = new HashSet<EObject>();

    private final TreeViewer viewer;

    private boolean caseSensitive = false;

    /**
     * This inner class manages the filtering process
     */
    ViewerFilter filter = new ViewerFilter()
    {
        @Override
        public boolean select(Viewer viewer, Object parentElement, Object element)
        {
            // if searched text == null ok i select it
            if (searchedText == null)
            {
                return true;
            }
            boolean result = false;
            // compute featureNames
            if (element instanceof EObject)
            {
                if (alreadyFind.contains(element))
                {
                    return true;
                }
                else if (alreadyNotFind.contains(element))
                {
                    return false;
                }
                result |= hasElement((ITreeContentProvider) ((TreeViewer) viewer).getContentProvider(), element);
            }
            return result;
        }

        /**
         * Check if the current element has chidren validating the filter
         * 
         * @param provider
         * @param element
         * @return
         */
        protected boolean hasElement(ITreeContentProvider provider, Object element)
        {
            boolean result = false;
            EObject eobject = (EObject) element;
            // search for type
            if (patternType.matcher(searchedText).matches())
            {
                if (eobject.eClass() != null)
                {
                    String className = eobject.eClass().getName();
                    if (caseSensitive)
                    {
                        result |= searchedText.replaceFirst(":", "").equals(className);
                    }
                    else
                    {
                        result |= searchedText.replaceFirst(":", "").equalsIgnoreCase(className);
                    }
                    if (result)
                    {
                        selection.add(eobject);
                    }
                }
            }
            // search for uri fragment
            else if (patternFragment.matcher(searchedText).matches())
            {
                if (eobject.eResource() != null)
                {
                    String uriFragment = eobject.eResource().getURIFragment(eobject);
                    if (caseSensitive)
                    {
                        result |= searchedText.replaceFirst("#", "").equals(uriFragment);
                    }
                    else
                    {
                        result |= searchedText.replaceFirst("#", "").equalsIgnoreCase(uriFragment);
                    }
                    if (result)
                    {
                        selection.add(eobject);
                    }
                }
            }
            boolean featureContainsString = featureContainsString(eobject, searchedText, featureName);
            result |= featureContainsString;
            for (Object childO : provider.getChildren(element))
            {
                if (childO instanceof EObject)
                {
                    EObject child = (EObject) childO;
                    boolean hasElement = hasElement(provider, child);
                    if (hasElement)
                    {
                        alreadyFind.add(child);
                    }
                    else
                    {
                        alreadyNotFind.add(child);
                    }
                    result |= hasElement;
                }
            }
            return result;
        }

        /**
         * Check if the current eobject has a feature containing a value corresponding to the string searched
         * 
         * @param eobject
         * @param searchedText
         * @param featureName
         * @return
         */
        private boolean featureContainsString(EObject eobject, String searchedText, List<String> featureName)
        {
            Collection<String> toCheck = new LinkedList<String>();
            for (EStructuralFeature f : eobject.eClass().getEAllAttributes())
            {
                if (!f.isDerived())
                {
                    if (featureName == null || featureName.contains(f.getName().toLowerCase()))
                    {
                        Object e = eobject.eGet(f);
                        if (f.isMany())
                        {
                            Collection<Object> coll = (Collection<Object>) e;
                            for (Object o : coll)
                            {
                                if (o != null)
                                {
                                    toCheck.add(o.toString());
                                }
                            }
                        }
                        else
                        {
                            if (e != null)
                            {
                                toCheck.add(e.toString());
                            }
                        }
                    }
                }
            }
            for (String s : toCheck)
            {
                String toSearch = s;
                if (!caseSensitive)
                {
                    toSearch = toSearch.toLowerCase();
                }
                if (patternToSearch.matcher(toSearch).matches())
                {
                    selection.add(eobject);
                    return true;
                }
            }
            return false;
        }
    };

    public CustomSearchFilter(TreeViewer viewer, Text text)
    {
        this.viewer = viewer;
        this.text = text;
    }

    public void clear()
    {
        clear(true);
    }

    /**
     * Clear the filter
     */
    public void clear(boolean refresh)
    {
        alreadyFind.clear();
        alreadyNotFind.clear();
        searchedText = null;
        patternToSearch = null;
        selection.clear();
        if (refresh)
        {
            viewer.refresh();
        }
    }

    /**
     * Return treepath selection from list of EObjects
     * 
     * @param selections
     * @return an ISelection
     */
    private ISelection getSelection(List<EObject> selections)
    {
        TreeSelection select = null;
        List<TreePath> pathes = new LinkedList<TreePath>();
        for (EObject eobject : selections)
        {
            List<Object> eobjects = new LinkedList<Object>();
            eobjects.add(eobject);
            while (eobject.eContainer() != null)
            {
                eobjects.add(0, eobject.eContainer());
                eobject = eobject.eContainer();
            }
            pathes.add(new TreePath(eobjects.toArray()));
        }
        select = new TreeSelection(pathes.toArray(new TreePath[] {}));
        return select;
    }

    public ISelection getSelection()
    {
        return getSelection(selection);
    }

    public void keyReleased(KeyEvent ke)
    {
        if (!Arrays.asList(viewer.getFilters()).contains(getFilter()))
        {
            viewer.addFilter(getFilter());
        }
        // the action is used pressing CR keyboard (enter)
        if (ke.character == SWT.CR || ke.character == SWT.KEYPAD_CR)
        {
            filter();
        }
    }

    private void filter()
    {
        String text2 = text.getText();
        if (text2.length() == 0)
        {
            // if the size is equals to zero reinit
            clear();
        }
        else
        {
            // compute features name
            featureName = null;
            searchedText = text2;
            Matcher matcher = patternForSpecificFeature.matcher(searchedText);
            if (matcher.matches() && matcher.groupCount() == 2)
            {
                String featureListAsString = matcher.group(1);
                String[] split = featureListAsString.split(",");
                if (split != null)
                {
                    featureName = new ArrayList<String>(split.length);
                    for (String s : split)
                    {
                        if (caseSensitive)
                        {
                            featureName.add(s);
                        }
                        else
                        {
                            featureName.add(s.toLowerCase());
                        }
                    }
                }
                searchedText = matcher.group(2);
                patternToSearch = Pattern.compile(".*" + searchedText + ".*", Pattern.MULTILINE | Pattern.DOTALL);
            }
            // pattern for standard search
            if (caseSensitive)
            {
                patternToSearch = Pattern.compile(".*" + searchedText + ".*", Pattern.MULTILINE | Pattern.DOTALL);
            }
            else
            {
                patternToSearch = Pattern.compile(".*" + searchedText.toLowerCase() + ".*", Pattern.MULTILINE | Pattern.DOTALL);
            }
            // global attributes are clear
            selection.clear();
            alreadyFind.clear();
            alreadyNotFind.clear();
            // refresh of the viewer to launch the filter
            viewer.refresh();
            final ISelection theSelection = getSelection();
            if (theSelection instanceof ITreeSelection)
            {
                ITreeSelection treeSelect = (ITreeSelection) theSelection;
                IPreferenceStore store = Utils.getPreferenceStoreAccordingToCurrentIFile();
                if (store.getBoolean(ModelerPreferenceConstants.PREFERENCE_OUTLINE_SELECT_FILTERED_ELEMENTS)
                        && treeSelect.getPaths().length <= store.getInt(ModelerPreferenceConstants.PREFERENCE_OUTLINE_LIMIT_FOR_SELECTION))
                {
                    viewer.setSelection(theSelection, true);
                }
            }
        }
    }

    /**
     * Returns the filter links to this adapter
     * 
     * @return
     */
    public ViewerFilter getFilter()
    {
        return filter;
    }

    public void setCaseSensitive(boolean caseSensitive)
    {
        this.caseSensitive = caseSensitive;
        filter();
    }

    public void dispose()
    {
        clear(false);
    }
}
