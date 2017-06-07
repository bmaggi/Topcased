/*******************************************************************************
 * Copyright (c) 2005, 2008 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies), Thomas Friol (Anyware
 * Technologies) - initial API and implementation
 ******************************************************************************/
package org.topcased.modeler.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class ModelerPreferenceConstants
{
    /** Default documentation editor */
    public static final String P_DOCUMENTATION_HTML_EDITOR = "documentationHtmlEditor";

    /** The default use uuid preference */
    public static final String P_USE_UUID = "useUUID";

    /** The list of the available PageFormat */
    public static final String P_PAGE_FORMATS = "PageFormats";

    /** The name of the default PageFormat */
    public static final String P_DEFAULT_PAGE_FORMAT = "defaultPageFormat";

    /** The list of the available PageMargin */
    public static final String P_PAGE_MARGINS = "PageMargins";

    /** The name of the default PageMargin */
    public static final String P_DEFAULT_PAGE_MARGIN = "defaultPageMargins";

    /** The default page orientation */
    public static final String P_ORIENTATION = "orientation";

    /** The default unit */
    public static final String P_DEFAULT_UNIT = "defaultUnit";

    /** The delimiter for PageFormats */
    public static final String PAGE_FORMATS_DELIMITER = "|";

    /** The delimiter for PageMargins */
    public static final String PAGE_MARGINS_DELIMITER = "|";

    /** The preference for the delete action dialog */
    public static final String DELETE_ACTION_CONFIRM = "deleteActionConfirm";

    /** The preference for the delete model action dialog */
    public static final String DELETE_MODEL_ACTION_CONFIRM = "deleteModelActionConfirm";

    /** The preference for the move action dialog */
    public static final String MOVE_ACTION_CONFIRM = "moveActionConfirm";

    /** The preference for the move model action dialog */
    public static final String MOVE_MODEL_ACTION_CONFIRM = "moveModelActionConfirm";

    /** The preference for the drag and drop model action dialog */
    public static final String DRAGNDROP_MODEL_ACTION_PREF = "dragAndDropModelActionConfirm";

    /** The preference for the create child menu */
    public static final String CREATE_CHILD_MENU_PREF = "createChildMenuId";

    /** The preference for the outline show action */
    public static final String OUTLINE_SHOW_ACTION_PREF = "outlineShowAction";

    /** The preference for the outline sorter action */
    public static final String OUTLINE_SORTER_PREF = "outlineSorter";

    /** The preference for the outline filters action */
    public static final String FILTERS_PREF = "filtersList";

    /** The preference for the outline user filters action */
    public static final String FILTERS_USERS_PREF = "userFiltersList";

    /** The preference for the outline user filters action */
    public static final String FILTERS_USERS_SELECTED_PREF = "userFiltersSelectedList";

    /**
     * The default values for the PreferenceStore. Values are stored in pixels (value in centimeter multiplied by 4)
     */
    public static final String DEFAULT_PAGE_FORMATS = PageFormat.A5 + PAGE_FORMATS_DELIMITER + PageFormat.A4 + PAGE_FORMATS_DELIMITER + PageFormat.A3 + PAGE_FORMATS_DELIMITER + PageFormat.A2
            + PAGE_FORMATS_DELIMITER + PageFormat.A1 + PAGE_FORMATS_DELIMITER + PageFormat.A0;

    public static final String DEFAULT_PAGE_FORMAT = "A4";

    public static final String DEFAULT_PAGE_MARGINS = PageMargin.NO_MARGIN + PAGE_MARGINS_DELIMITER + PageMargin.SMALL_MARGIN;

    public static final String DEFAULT_PAGE_MARGIN = "Small Margin";

    public static final String DEFAULT_UNIT = "pixel";

    public static final String DEFAULT_ORIENTATION = "portrait";

    public static final String P_CHECK_INTEGRITY = "CheckFileIntegrity";

    public static final String P_USE_ANTIALIAS = "UseAntialias";

    public static final String P_INITIALIZE_DIAGRAM = "InitializeDiagramContent";

    /** Create an eannotation for the author */
    public static final String P_CREATE_AUTHOR_ANNOTATION = "CreateAuthorAnnotation";

    /** The default author */
    public static final String P_DEFAULT_AUTHOR = "defaultAuthor";

    /** The Constant PREFERENCE_FOR_READ_ONLY. */
    public static final String PREFERENCE_FOR_READ_ONLY = "preference_for_ready_only";

    /**
     * The Constant PREFERENCE_FOR_READ_ONLY_RESOURCES_DISPLAY for determining whether a dialog shall inform when some
     * dependent resources are read-only.
     */
    public static final String PREFERENCE_FOR_READ_ONLY_RESOURCES_INITIAL = "preference_for_ready_only_resources_display";

    /**
     * The Constant PREFERENCE_FOR_READ_ONLY_RESOURCES_CHANGE for determining whether a dialog shall inform when some
     * dependent resources become read-only.
     */
    public static final String PREFERENCE_FOR_READ_ONLY_RESOURCES_CHANGE = "preference_for_ready_only_resources_change";

    /** The Constant PREFERENCE_FOR_NOT_SYNC_DECOR. */
    public static final String PREFERENCE_NOT_SYNC_DECOR = "preference_for_not_sync_decor";

    /** The Constant PREFERENCE_FOR_PALETTE_CONFIGURATION */
    public static final String PREFERENCE_FOR_PALETTE_CONFIGURATION = "preference_for_palette_configuration";

    /** The Constant PREFERENCE_ASK_FOR_DIAGRAM_NAME */
    public static final String PREFERENCE_ASK_FOR_DIAGRAM_NAME = "preference_ask_for_diagram_name";

    /** Constant preferences for colors for outline and controlled elements */

    /** The constant */
    public static final String PREFERENCE_DIFFERENT_COLORS_FOR_CONTROL = "preference_different_colors_for_control";

    public static final String PREFERENCE_COLOR_FOR_SAME_RESOURCE = "preference_different_colors_for_same_resource";

    public static final String PREFERENCE_COLOR_FOR_DIFFERENT_RESOURCE = "preference_different_colors_for_different_resource";

    public static final String PREFERENCE_ELEMENT_DIFFERENT_RESOURCE_READ_ONLY = "preference_element_different_resource_read_only";

    public static final String PREFERENCE_OUTLINE_SELECT_FILTERED_ELEMENTS = "preference_outline_select_filtered_elements";

    public static final String PREFERENCE_OUTLINE_LIMIT_FOR_SELECTION = "preference_outline_limit_for_selection";

    public static final String PREFERENCE_DISPLAY_HIDDEN_EANNOTATION = "preference_display_hidden_eannotation";

    public static final String PREFERENCE_OUTLINE_LIMIT_FOR_HISTORIK = "preference_outline_limit_for_historik";

    public static final String PREFERENCE_OUTLINE_DISPLAY_VIRTUAL_CONTAINERS = "preference_outline_display_virtual_containers";

    /**
     * The constant READ_ONLY_CHANGES_ACTION_CONFIRM to display the dialog to ask the user to confirm editors are
     * switching to read mode
     */
    public static final String READ_ONLY_CHANGES_ACTION_CONFIRM = "readOnlyChangesActionConfirm";

    /**
     * The constant REFRESH_RESOURCES_ACTION_CONFIRM to display the dialog to confirm the editor will reload its content
     * before switching to write mode
     */
    public static final String REFRESH_RESOURCES_ACTION_CONFIRM = "refreshResourcesActionConfirm";

}
