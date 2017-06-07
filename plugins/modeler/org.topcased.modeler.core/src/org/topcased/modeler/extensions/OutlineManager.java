/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Thomas Friol (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.extensions;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.topcased.facilities.extensions.AbstractExtensionManager;
import org.topcased.modeler.ImageRegistry;
import org.topcased.modeler.editor.outline.ICreateChildMenu;
import org.topcased.modeler.editor.outline.filters.GenericMetamodelFilter;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * An outline provider.<br>
 * Provides all registered extensions for org.topcased.modeler.outline extension point. <br>
 * Creation : 24 nov. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public final class OutlineManager extends AbstractExtensionManager
{
    /* ========================= */
    /* Extension point constants */
    /* ========================= */

    private static final String OUTLINE_EXTENSION_POINT = "outline";

    private static final String CREATE_CHILD_MENU_ELEMENT = "createChildMenu";

    private static final String CREATE_CHILD_MENU_ID = "id";

    private static final String CREATE_CHILD_MENU_NAME = "name";

    private static final String CREATE_CHILD_MENU_CLASS = "class";

    private static final String CREATE_CHILD_MENU_EDITOR_ID = "editorId";

    private static final String FILTER_ELEMENT = "filter";

    private static final String FILTER_ID = "id";

    private static final String FILTER_NAME = "name";

    private static final String FILTER_CLASS = "class";

    private static final String FILTER_EDITOR_ID = "editorId";

    private static final String SORTER_ELEMENT = "sorter";

    private static final String SORTER_ID = "id";

    private static final String SORTER_NAME = "name";

    private static final String SORTER_ICON = "icon";

    private static final String SORTER_CLASS = "class";

    private static final String SORTER_EDITOR_ID = "editorId";

    private static final String METAMODELFILTER_ELEMENT = "metamodelFilter";

    private static final String METAMODELFILTER_ID = "id";

    private static final String METAMODELFILTER_EDITOR_ID = "editorId";

    private static final String METAMODELFILTER_CLASS = "class";

    /** The singleton */
    private static OutlineManager manager;

    /**
     * The map of 'Create child' menu configurations
     */
    private Map<String, CreateChildMenuConfiguration> createChildMenus;

    /**
     * The map of filter configurations
     */
    private Map<String, FilterConfiguration> filters;

    /**
     * The map of sorter configurations
     */
    private Map<String, SorterConfiguration> sorters;

    /**
     * The map of metamodel filters
     */
    private Map<String, MetamodelFilterConfiguration> metamodelFilters;

    /**
     * Private constructor since it is a singleton.
     */
    private OutlineManager()
    {
        super(ModelerPlugin.getId() + "." + OUTLINE_EXTENSION_POINT);
        createChildMenus = new HashMap<String, CreateChildMenuConfiguration>();
        filters = new HashMap<String, FilterConfiguration>();
        sorters = new HashMap<String, SorterConfiguration>();
        metamodelFilters = new HashMap<String, MetamodelFilterConfiguration>();
        initialize();
    }

    /**
     * Get this outline manager unique instance.
     * 
     * @return this outline manager
     */
    public static OutlineManager getInstance()
    {
        if (manager == null)
        {
            manager = new OutlineManager();
        }

        return manager;
    }

    /**
     * Initialize this outline manager reading the extension registry.
     */
    protected void initialize()
    {
        createChildMenus.clear();
        filters.clear();
        sorters.clear();
        metamodelFilters.clear();
        readRegistry();
    }

    /**
     * @see org.topcased.facilities.extensions.AbstractExtensionManager#addExtension(org.eclipse.core.runtime.IExtension)
     */
    protected void addExtension(IExtension extension)
    {
        IConfigurationElement[] elements = extension.getConfigurationElements();
        for (int i = 0; i < elements.length; i++)
        {
            if (CREATE_CHILD_MENU_ELEMENT.equals(elements[i].getName()))
            {
                addCreateChildMenu(elements[i]);
            }
            else if (FILTER_ELEMENT.equals(elements[i].getName()))
            {
                addFilter(elements[i]);
            }
            else if (SORTER_ELEMENT.equals(elements[i].getName()))
            {
                addSorter(elements[i]);
            }
            else if (METAMODELFILTER_ELEMENT.equals(elements[i].getName()))
            {
                addMetamodelFilter(elements[i]);
            }
        }
    }

    /**
     * Add a 'Metamodel Filter' to this manager
     * 
     * @param element a 'Metamodel Filter' configuration element
     */
    private void addMetamodelFilter(IConfigurationElement element)
    {
        String id = element.getAttribute(METAMODELFILTER_ID);
        String editorId = element.getAttribute(METAMODELFILTER_EDITOR_ID);
        MetamodelFilterConfiguration config = new MetamodelFilterConfiguration(id, editorId, element);
        metamodelFilters.put(id, config);
    }

    /**
     * Add a 'Create child' menu to this manager.
     * 
     * @param element a 'Create child' menu configuration element
     */
    private void addCreateChildMenu(IConfigurationElement element)
    {
        String id = element.getAttribute(CREATE_CHILD_MENU_ID);
        String name = element.getAttribute(CREATE_CHILD_MENU_NAME);
        String editorId = element.getAttribute(CREATE_CHILD_MENU_EDITOR_ID);

        CreateChildMenuConfiguration config = new CreateChildMenuConfiguration(id, name, editorId, element);

        createChildMenus.put(id, config);
    }

    /**
     * Add an outline filter to this manager.
     * 
     * @param element a filter configuration element
     */
    private void addFilter(IConfigurationElement element)
    {
        String id = element.getAttribute(FILTER_ID);
        String name = element.getAttribute(FILTER_NAME);
        String editorId = element.getAttribute(FILTER_EDITOR_ID);

        FilterConfiguration config = new FilterConfiguration(id, name, editorId, element);

        filters.put(id, config);
    }

    /**
     * Add an outline sorter to this manager.
     * 
     * @param element a sorter configuration element
     */
    private void addSorter(IConfigurationElement element)
    {
        String id = element.getAttribute(SORTER_ID);
        String name = element.getAttribute(SORTER_NAME);
        URL icon = Platform.getBundle(element.getDeclaringExtension().getNamespaceIdentifier()).getEntry(element.getAttribute(SORTER_ICON));
        String editorId = element.getAttribute(SORTER_EDITOR_ID);

        SorterConfiguration config = new SorterConfiguration(id, name, icon, editorId, element);
        sorters.put(id, config);
    }

    /**
     * @see org.topcased.facilities.extensions.AbstractExtensionManager#removeExtension(org.eclipse.core.runtime.IExtension)
     */
    protected void removeExtension(IExtension extension)
    {
        IConfigurationElement[] elements = extension.getConfigurationElements();
        for (int i = 0; i < elements.length; i++)
        {
            if (CREATE_CHILD_MENU_ELEMENT.equals(elements[i].getName()))
            {
                createChildMenus.remove(elements[i].getAttribute(CREATE_CHILD_MENU_ID));
            }
            else if (FILTER_ELEMENT.equals(elements[i].getName()))
            {
                filters.remove(elements[i].getAttribute(FILTER_ID));
            }
            else if (SORTER_ELEMENT.equals(elements[i].getName()))
            {
                sorters.remove(elements[i].getAttribute(SORTER_ID));
            }
            else if (METAMODELFILTER_ELEMENT.equals(elements[i].getName()))
            {
                metamodelFilters.remove(elements[i].getAttribute(METAMODELFILTER_ID));
            }
        }
    }

    /**
     * Gets the collection of {@link CreateChildMenuConfiguration} for the given Topcased editor id.
     * 
     * @param editorId a Topcased editor id or <code>null</code> to get all the configurations
     * @return a collection of CreateChildMenuConfiguration. Never returns <code>null</code>.
     */
    public Collection<CreateChildMenuConfiguration> getCreateChildMenus(String editorId)
    {
        if (editorId == null || editorId.length() == 0)
        {
            return createChildMenus.values();
        }

        List<CreateChildMenuConfiguration> configs = new ArrayList<CreateChildMenuConfiguration>();
        for (Iterator<CreateChildMenuConfiguration> it = createChildMenus.values().iterator(); it.hasNext();)
        {
            CreateChildMenuConfiguration config = it.next();
            if (config.getEditorId() == null || config.getEditorId().length() == 0 || editorId.equals(config.getEditorId()))
            {
                configs.add(config);
            }
        }

        return configs;
    }

    /**
     * Gets a {@link CreateChildMenuConfiguration} by its id.
     * 
     * @param configId a configuration id
     * @return a CreateChildMenuConfiguration or <code>null</code> if it does not exist.
     */
    public OutlineManager.CreateChildMenuConfiguration getCreateChildMenuConfiguration(String configId)
    {
        return (CreateChildMenuConfiguration) createChildMenus.get(configId);
    }

    /**
     * Gets the collection of {@link FilterConfiguration} for the given Topcased editor id.
     * 
     * @param editorId a Topcased editor id or <code>null</code> to get all the configurations
     * @return a collection of FilterConfiguration. Never returns <code>null</code>.
     */
    public Collection<FilterConfiguration> getFilters(String editorId)
    {
        if (editorId == null || editorId.length() == 0)
        {
            return filters.values();
        }

        List<FilterConfiguration> configs = new ArrayList<FilterConfiguration>();
        for (Iterator<FilterConfiguration> it = filters.values().iterator(); it.hasNext();)
        {
            FilterConfiguration config = it.next();
            if (config.getEditorId() == null || config.getEditorId().length() == 0 || editorId.equals(config.getEditorId()))
            {
                configs.add(config);
            }
        }

        return configs;
    }

    /**
     * Gets a {@link FilterConfiguration} by its id.
     * 
     * @param configId a configuration id
     * @return a FilterConfiguration or <code>null</code> if it does not exist.
     */
    public OutlineManager.FilterConfiguration getFilterConfiguration(String configId)
    {
        return (FilterConfiguration) filters.get(configId);
    }

    /**
     * Gets the collection of {@link SorterConfiguration} for the given Topcased editor id.
     * 
     * @param editorId a Topcased editor id or <code>null</code> to get all the configurations
     * @return a collection of SorterConfiguration. Never returns <code>null</code>.
     */
    public Collection<SorterConfiguration> getSorters(String editorId)
    {
        if (editorId == null || editorId.length() == 0)
        {
            return sorters.values();
        }

        ArrayList<SorterConfiguration> configs = new ArrayList<SorterConfiguration>();
        for (Iterator<SorterConfiguration> it = sorters.values().iterator(); it.hasNext();)
        {
            SorterConfiguration config = it.next();
            if (config.getEditorId() == null || config.getEditorId().length() == 0 || editorId.equals(config.getEditorId()))
            {
                configs.add(config);
            }
        }

        return configs;
    }

    /**
     * Gets the collection of {@link MetamodelFilterConfiguration} for the given Topcased editor id.
     * 
     * @param editorId a Topcased editor id or <code>null</code> to get all the configurations
     * @return a collection of MetamodelFilterConfiguration. Never returns <code>null</code>.
     */
    public Collection<MetamodelFilterConfiguration> getMetamodelFilter(String editorId)
    {
        if (editorId == null || editorId.length() == 0)
        {
            return metamodelFilters.values();
        }

        List<MetamodelFilterConfiguration> configs = new ArrayList<MetamodelFilterConfiguration>();
        for (Iterator<MetamodelFilterConfiguration> it = metamodelFilters.values().iterator(); it.hasNext();)
        {
            MetamodelFilterConfiguration config = it.next();
            if (config.getEditorId() == null || config.getEditorId().length() == 0 || editorId.equals(config.getEditorId()))
            {
                configs.add(config);
            }
        }

        return configs;
    }

    /**
     * Gets a {@link SorterConfiguration} by its id.
     * 
     * @param configId a configuration id
     * @return a SorterConfiguration or <code>null</code> if it does not exist.
     */
    public OutlineManager.SorterConfiguration getSorterConfiguration(String configId)
    {
        return (SorterConfiguration) sorters.get(configId);
    }

    /**
     * Represents a 'Create child' menu configuration for the org.topcased.modeler.outline extension point.<br>
     * Creation : 24 nov. 2005
     * 
     * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
     */
    public class CreateChildMenuConfiguration
    {
        /**
         * This configuration id.
         */
        private String id;

        /**
         * This configuration name.
         */
        private String name;

        /**
         * This configuration editor id.
         */
        private String editorId;

        /**
         * This configuration menu manager.
         */
        private IConfigurationElement menu;

        /**
         * Constructor.
         * 
         * @param configId this configuration id
         * @param configName this configuration name
         * @param configEditorId this configuration editor id
         * @param configMenu this configuration menu manager
         */
        public CreateChildMenuConfiguration(String configId, String configName, String configEditorId, IConfigurationElement configMenu)
        {
            if (configId == null || configId.length() == 0)
            {
                throw new IllegalArgumentException("id is mandatory for a create child menu configuration.");
            }

            if (configName == null || configName.length() == 0)
            {
                throw new IllegalArgumentException("name is mandatory for a create child menu configuration.");
            }

            if (configMenu == null)
            {
                throw new IllegalArgumentException("menu manager class is mandatory for a create child menu configuration.");
            }

            id = configId;
            name = configName;
            editorId = configEditorId;
            menu = configMenu;
        }

        /**
         * Gets this configuration id.
         * 
         * @return this configuration id
         */
        public String getId()
        {
            return id;
        }

        /**
         * Gets this configuration name.
         * 
         * @return this configuration name
         */
        public String getName()
        {
            return name;
        }

        /**
         * Gets this configuration editor id.
         * 
         * @return this configuration editor id
         */
        public String getEditorId()
        {
            return editorId;
        }

        /**
         * Gets this configuration menu manager.
         * 
         * @return this configuration menu manager
         */
        public ICreateChildMenu getMenu()
        {
            try
            {
                return (ICreateChildMenu) menu.createExecutableExtension(CREATE_CHILD_MENU_CLASS);
            }
            catch (CoreException e)
            {
                ModelerPlugin.log(e);
            }
            return null;
        }
    }

    /**
     * Represents an outline filter configuration for the org.topcased.modeler.outline extension point.<br>
     * Creation : 24 nov. 2005
     * 
     * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
     */
    public class FilterConfiguration
    {
        /**
         * This configuration id.
         */
        private String id;

        /**
         * This configuration name.
         */
        private String name;

        /**
         * This configuration editor id.
         */
        private String editorId;

        /**
         * This configuration filter.
         */
        private ViewerFilter filter;

        /**
         * Constructor.
         * 
         * @param configId this configuration id
         * @param configName this configuration name
         * @param configEditorId this configuration editor id
         * @param configFilter this configuration filter
         */
        public FilterConfiguration(String configId, String configName, String configEditorId, IConfigurationElement configFilter)
        {
            if (configId == null || configId.length() == 0)
            {
                throw new IllegalArgumentException("id is mandatory for a filter configuration.");
            }

            if (configName == null || configName.length() == 0)
            {
                throw new IllegalArgumentException("name is mandatory for a filter configuration.");
            }

            if (configFilter == null)
            {
                throw new IllegalArgumentException("filter class is mandatory for a filter configuration.");
            }

            try
            {
                filter = (ViewerFilter) configFilter.createExecutableExtension(FILTER_CLASS);
            }
            catch (CoreException e)
            {
                filter = null;
                ModelerPlugin.log(e);
            }
            catch (ClassCastException cce)
            {
                throw new IllegalArgumentException("filter class must be an implementation of org.eclipse.jface.viewers.ViewerFilter for a filter configuration.");
            }

            id = configId;
            name = configName;
            editorId = configEditorId;
        }

        /**
         * Gets this configuration id.
         * 
         * @return this configuration id
         */
        public String getId()
        {
            return id;
        }

        /**
         * Gets this configuration name.
         * 
         * @return this configuration name
         */
        public String getName()
        {
            return name;
        }

        /**
         * Gets this configuration editor id.
         * 
         * @return this configuration editor id
         */
        public String getEditorId()
        {
            return editorId;
        }

        /**
         * Gets this configuration filter.
         * 
         * @return this configuration filter
         */
        public ViewerFilter getFilter()
        {
            return filter;
        }
    }

    /**
     * Represents an outline sorter configuration for the org.topcased.modeler.outline extension point.<br>
     * Creation : 24 nov. 2005
     * 
     * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
     */
    public class SorterConfiguration
    {
        /**
         * This configuration id.
         */
        private String id;

        /**
         * This configuration name.
         */
        private String name;

        /**
         * This configuration icon
         */
        private URL icon;

        /**
         * This configuration editor id.
         */
        private String editorId;

        /**
         * This configuration sorter.
         */
        private ViewerSorter sorter;

        /**
         * Constructor.
         * 
         * @param configId this configuration id
         * @param configName this configuration name
         * @param configIcon this configuration icon
         * @param configEditorId this configuration editor id
         * @param configSorter this configuration sorter
         */
        public SorterConfiguration(String configId, String configName, URL configIcon, String configEditorId, IConfigurationElement configSorter)
        {
            if (configId == null || configId.length() == 0)
            {
                throw new IllegalArgumentException("id is mandatory for a filter configuration.");
            }

            if (configName == null || configName.length() == 0)
            {
                throw new IllegalArgumentException("name is mandatory for a filter configuration.");
            }

            if (configSorter == null)
            {
                throw new IllegalArgumentException("filter class is mandatory for a filter configuration.");
            }

            try
            {
                sorter = (ViewerSorter) configSorter.createExecutableExtension(SORTER_CLASS);
            }
            catch (CoreException e)
            {
                sorter = null;
                ModelerPlugin.log(e);
            }
            catch (ClassCastException cce)
            {
                throw new IllegalArgumentException("filter class must be an implementation of org.eclipse.jface.viewers.ViewerFilter for a filter configuration.");
            }

            id = configId;
            name = configName;
            icon = configIcon;
            editorId = configEditorId;
        }

        /**
         * Gets this configuration id.
         * 
         * @return this configuration id
         */
        public String getId()
        {
            return id;
        }

        /**
         * Gets this configuration name.
         * 
         * @return this configuration name
         */
        public String getName()
        {
            return name;
        }

        /**
         * Gets this configuration icon.
         * 
         * @return this configuration icon
         */
        public ImageDescriptor getIcon()
        {
            return ImageRegistry.getInstance().getDescriptor(icon);
        }

        /**
         * Gets this configuration editor id.
         * 
         * @return this configuration editor id
         */
        public String getEditorId()
        {
            return editorId;
        }

        /**
         * Gets this configuration sorter.
         * 
         * @return this configuration sorter
         */
        public ViewerSorter getSorter()
        {
            return sorter;
        }
    }

    /**
     * Represents a metamodel filter configuration for the org.topcased.modeler.outline extension point. This filter is
     * used to define specific user filter.
     * 
     * @author <a href="mailto:thibault.landre@atosorigin.com">Thibault Landr�</a>
     */
    public class MetamodelFilterConfiguration
    {
        /**
         * This configuration id
         */
        private String id;

        /**
         * This configuration editor id.
         */
        private String editorId;

        /**
         * This configuration metamodel filter
         */
        private GenericMetamodelFilter metamodelFilter;

        /**
         * Constructor.
         * 
         * @param configId this configuration id
         * @param configEditorId this configuration editor id
         * @param configMetamodelFilter this configuration metamodel filter
         */
        public MetamodelFilterConfiguration(String configId, String configEditorId, IConfigurationElement configMetamodelFilter)
        {

            if (configId == null || configId.length() == 0)
            {
                throw new IllegalArgumentException("id is mandatory for a metamodel filter configuration.");
            }

            if (configEditorId == null || configEditorId.length() == 0)
            {
                throw new IllegalArgumentException("editor id is mandatory for a metamodel filter configuration.");
            }

            if (configMetamodelFilter == null)
            {
                throw new IllegalArgumentException("metamodelFilter class is mandatory for a metamodel filter configuration.");
            }

            try
            {
                metamodelFilter = (GenericMetamodelFilter) configMetamodelFilter.createExecutableExtension(METAMODELFILTER_CLASS);
            }
            catch (CoreException e)
            {
                metamodelFilter = null;
                ModelerPlugin.log(e);
            }
            catch (ClassCastException cce)
            {
                throw new IllegalArgumentException("metamodelInformation class must be an implementation of  org.topcased.modeler.extensions.IMetamodelInformation for a filter configuration.");
            }

            id = configId;
            editorId = configEditorId;

        }

        /**
         * Gets this configuration id.
         * 
         * @return this configuration id
         */
        public String getId()
        {
            return id;
        }

        /**
         * Gets this configuration editor id.
         * 
         * @return this configuration editor id
         */
        public String getEditorId()
        {
            return editorId;
        }

        /**
         * Gets this configuration metamodel filter.
         * 
         * @return this configuration metamodel filter
         */
        public GenericMetamodelFilter getMetamodelFilter()
        {
            return metamodelFilter;
        }

    }
}
