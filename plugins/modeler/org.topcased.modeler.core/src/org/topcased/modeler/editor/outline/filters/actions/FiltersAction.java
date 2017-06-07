/*******************************************************************************
 * Copyright (c) 2005-2008 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Thomas Friol (Anyware Technologies) - initial API and
 * implementation
 * Thibaut Landr� (Atos Origin) - adding user's filter. Refactoring dialog pages.
 ******************************************************************************/
package org.topcased.modeler.editor.outline.filters.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.editor.outline.ModelNavigator;
import org.topcased.modeler.editor.outline.filters.GenericMetamodelFilter;
import org.topcased.modeler.editor.outline.filters.dialogs.FilterSelectionDialog;
import org.topcased.modeler.editor.outline.filters.files.UserFilterFile;
import org.topcased.modeler.extensions.OutlineManager;
import org.topcased.modeler.extensions.OutlineManager.FilterConfiguration;
import org.topcased.modeler.extensions.OutlineManager.MetamodelFilterConfiguration;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.l10n.Messages;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;

/**
 * A class defining an action to select the editor outline filters.<br>
 * Creation : 2 d�c. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class FiltersAction extends Action
{
    private TreeViewer outlineViewer;

    private Modeler modeler;

    private IPreferenceStore ps;

    public FiltersAction(TreeViewer outlineViewer, Modeler modeler)
    {
        super();
        this.outlineViewer = outlineViewer;
        this.modeler = modeler;
        ps = modeler.getPreferenceStore();
        updateIconAndToolTipText();
    }

    /**
     * Update the tooltip text and the icons of the Filter action depending on the outlineViewer's filters applied
     */
    private void updateIconAndToolTipText()
    {
        if (outlineViewer.getFilters().length != 0)
        {
            setImageDescriptor(ModelerImageRegistry.getImageDescriptor("OUTLINE_FILTERS_APPLIED"));
            setToolTipText(Messages.getString("FiltersAction.FiltersOn"));
        }
        else
        {
            setImageDescriptor(ModelerImageRegistry.getImageDescriptor("OUTLINE_FILTERS"));
            setToolTipText(Messages.getString("FiltersAction.FiltersOff"));
        }
    }

    /**
     * @see org.eclipse.jface.action.Action#run()
     */
    public void run()
    {
        // Get the preferences
        List<FilterConfiguration> configs = getFilterConfigurations(ps != null ? ps.getString(ModelerPreferenceConstants.FILTERS_PREF) : ""); //$NON-NLS-1$
        List<Object> userSelectedFilterConfigs = getUserSelectedFilterFile(ps != null ? ps.getString(ModelerPreferenceConstants.FILTERS_USERS_SELECTED_PREF) : ""); //$NON-NLS-1$
        List<Object> userFilterFilterConfigs = getUserFilterFile(ps != null ? ps.getString(ModelerPreferenceConstants.FILTERS_USERS_PREF) : ""); //$NON-NLS-1$

        // Initialize the dialog
        FilterSelectionDialog filterSelectionDialog = new FilterSelectionDialog(OutlineManager.getInstance().getFilters(modeler.getSite().getId()), userFilterFilterConfigs);
        filterSelectionDialog.setTitle(Messages.getString("FiltersAction.FilterSelectionDialogTitle"));
        filterSelectionDialog.setInitialElementSelections(configs);
        filterSelectionDialog.setInitialUserFilterSelection(userSelectedFilterConfigs);

        Collection<MetamodelFilterConfiguration> metamodelConfigurationCollection = OutlineManager.getInstance().getMetamodelFilter(modeler.getSite().getId());
        MetamodelFilterConfiguration metamodelFiterConfiguration = null;
        if (!metamodelConfigurationCollection.isEmpty())
        {
            metamodelFiterConfiguration = new ArrayList<MetamodelFilterConfiguration>(metamodelConfigurationCollection).get(0);
            filterSelectionDialog.setMetamodelFilter(metamodelFiterConfiguration.getMetamodelFilter());
        }

        // Open the dialog
        filterSelectionDialog.open();

        // Get the result and update the filters (viewer and preference)
        Object[] filters = filterSelectionDialog.getResult();
        Map<UserFilterFile, Boolean> userFilters = filterSelectionDialog.getUserFilterResult();
        if (filters != null && userFilters != null)
        {
            removeOutlineFilters();
            updateExtensionFilter(filters);
            if (metamodelFiterConfiguration != null)
            {
                updateUserFilter(userFilters, metamodelFiterConfiguration.getMetamodelFilter());
            }
            
        }

        updateIconAndToolTipText();

    }

    /**
     * Remove the filters applied to the outline tree
     */
    private void removeOutlineFilters()
    {
        ViewerFilter[] viewerFilters = outlineViewer.getFilters();
        for (ViewerFilter viewerFilter : viewerFilters)
        {
            outlineViewer.removeFilter(viewerFilter);
        }
        ModelNavigator.addAll(outlineViewer, ModelNavigator.getStaticFilters());
    }

    /**
     * Update the extension filters applied to the outline tree and save them in the preference
     * 
     * @param filters the new filters to apply
     */
    private void updateExtensionFilter(Object[] filters)
    {
        if (filters != null)
        {
            // Add all new filters
            String newConfigs = ""; //$NON-NLS-1$
            for (int i = 0; i < filters.length; i++)
            {
                FilterConfiguration config = (FilterConfiguration) filters[i];

                outlineViewer.addFilter(config.getFilter());
                newConfigs += config.getId();
                if (i != filters.length - 1)
                {
                    newConfigs += ","; //$NON-NLS-1$
                }
            }

            // Store the filters in the preferences
            if (ps != null)
            {
                ps.setValue(ModelerPreferenceConstants.FILTERS_PREF, newConfigs);
            }
        }
    }

    /**
     * Update the user's defined filters applied to the outline tree and save them in the preference
     * 
     * @param userFilters the new user filters to apply
     * @param genericMetamodelFilter the generic metamodel filter
     */
    private void updateUserFilter(Map<UserFilterFile, Boolean> userFilters, GenericMetamodelFilter genericMetamodelFilter)
    {
        String newFilters = ""; //$NON-NLS-1$
        String newCheckedFilters = ""; //$NON-NLS-1$
        int i = 0;
        for (Map.Entry<UserFilterFile, Boolean> e : userFilters.entrySet())
        {
            newFilters += e.getKey();
            if (i != userFilters.size() - 1)
            {
                newFilters += ","; //$NON-NLS-1$
            }

            if (e.getValue().booleanValue())
            {
                newCheckedFilters += e.getKey();
                if (i != userFilters.size() - 1)
                {
                    newCheckedFilters += ","; //$NON-NLS-1$
                }
                try
                {
                    GenericMetamodelFilter metamodelFilter = genericMetamodelFilter.getClass().newInstance();
                    metamodelFilter.setFilterElementsName(e.getKey().getElements());
                    outlineViewer.addFilter(metamodelFilter);
                }
                catch (InstantiationException e1)
                {
                    ModelerPlugin.log(e1);
                }
                catch (IllegalAccessException e1)
                {
                    ModelerPlugin.log(e1);
                }
            }
            i++;
        }
        if (ps != null)
        {
            ps.setValue(ModelerPreferenceConstants.FILTERS_USERS_PREF, newFilters);
            ps.setValue(ModelerPreferenceConstants.FILTERS_USERS_SELECTED_PREF, newCheckedFilters);
        }
    }

    /**
     * 
     * @param filtersList
     * @return
     */
    public static List<FilterConfiguration> getFilterConfigurations(String filtersList)
    {
        StringTokenizer st = new StringTokenizer(filtersList, ","); //$NON-NLS-1$
        List<FilterConfiguration> configs = new ArrayList<FilterConfiguration>();
        while (st.hasMoreTokens())
        {
            String configId = st.nextToken();
            FilterConfiguration config = OutlineManager.getInstance().getFilterConfiguration(configId);
            if (config != null)
            {
                configs.add(config);
            }
        }
        return configs;
    }

    /**
     * Get the user's filters files store in the preference
     * 
     * @param userFilterFileStringPref the string stores in the preference
     * @return a list of user filter files
     */
    protected static List<Object> getUserFilterFile(String userFilterFileStringPref)
    {
        StringTokenizer st = new StringTokenizer(userFilterFileStringPref, ","); //$NON-NLS-1$
        List<Object> userFilterFileList = new ArrayList<Object>();
        while (st.hasMoreTokens())
        {
            String userFilterFilepath = st.nextToken();
            UserFilterFile userFilterFile = new UserFilterFile(userFilterFilepath);
            if (userFilterFile.exists())
            {
                userFilterFileList.add(userFilterFile);
            }
        }
        return userFilterFileList;
    }

    /**
     * Get the user's selected filters files store in the preference
     * 
     * @param userSelectedFilterFileStringPref the string stores in the preference
     * @return a list of userSelected filter files
     */
    protected static List<Object> getUserSelectedFilterFile(String userSelectedFilterFileStringPref)
    {
        StringTokenizer st = new StringTokenizer(userSelectedFilterFileStringPref, ","); //$NON-NLS-1$
        List<Object> userSelectedFilterFileList = new ArrayList<Object>();
        while (st.hasMoreTokens())
        {
            String userFilterFilepath = st.nextToken();
            UserFilterFile userFilterFile = new UserFilterFile(userFilterFilepath);
            if (userFilterFile.exists())
            {
                userSelectedFilterFileList.add(userFilterFile);
            }
        }
        return userSelectedFilterFileList;
    }

}
