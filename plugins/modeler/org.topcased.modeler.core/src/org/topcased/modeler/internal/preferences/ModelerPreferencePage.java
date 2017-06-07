/*******************************************************************************
 * Copyright (c) 2005, 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Thibault Landr� (Atos Origin) - add project scope to preference page
 *******************************************************************************/
package org.topcased.modeler.internal.preferences;

import java.util.ArrayList;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.topcased.facilities.preferences.AbstractTopcasedPreferencePage;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.l10n.Messages;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.preferences.PaletteConfigurationController;
import org.topcased.tabbedproperties.internal.sections.TabbedPropertiesPlugin;
import org.topcased.tabbedproperties.utils.TabbedPropertiesConstants;

/**
 * This class represents a preference page that is contributed to the Preferences dialog. By subclassing
 * <samp>FieldEditorPreferencePage</samp>, we can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the preference store that belongs to the main
 * plug-in class. That way, preferences can be accessed directly via the preference store.
 */

public class ModelerPreferencePage extends AbstractTopcasedPreferencePage implements IWorkbenchPreferencePage, IWorkbenchPropertyPage
{
    /** The parent composite */
    private Composite parentComposite;

    private Group defaultGp;

    private Group controlledEltGroup;

    private Combo unit;

    private Button useAntialiasBt;

    private Button useUUIDBt;

    private Button checkIntegrityBt;

    private Button useHTMLEditor;

    private Button createAuthorAnnotation;

    private Button displayDialogForReadOnly;

    /** Button to choose whether to display dialog to show initial read-only files list */
    private Button displayDialogForReadOnlyInitial;

    /** Button to choose whether to display dialog when read-only files list changes */
    private Button displayDialogForReadOnlyChange;

    private Button displayDialogForReadOnlyChangesInEnableWriteAction;

    private Button displayDialogForRefreshResourcesInEnableWriteAction;

    private Button displayAskForDiagramName;

    private Button dontAskAgainMoveModelAction;

    private Text authorTxt;

    private Button useDefaultAdvancedTab;

    private Button displayNotSyncDecor;

    private Combo palette;

    private Button useDifferentColorsForControlledElements;

    private ColorFieldEditor colorForSameResource;

    private ColorFieldEditor colorForDifferentResource;

    private Button controlledReadOnly;

    private BooleanFieldEditor selectFilteredElements;

    private IntegerFieldEditor limitForElementSelection;

    private IntegerFieldEditor limitForHistorik;

    private Button displayVirtualContainers;

    private BooleanFieldEditor displayHiddenEannotations;

    /**
     * The Constructor
     */
    public ModelerPreferencePage()
    {
        // Does nothing;
    }

    /**
     * Create the contents of the preference page
     * 
     * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
     */
    protected Control createContents(Composite parent)
    {
        parentComposite = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        parentComposite.setLayout(layout);
        parentComposite.setFont(parent.getFont());

        createDefaultGroup(parentComposite);

        doLoad();

        return parentComposite;
    }

    /**
     * Initialize the preferencePage
     * 
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    public void init(IWorkbench workbench)
    {
        // does nothing
    }

    /**
     * Creates a group where the user choose the default unit to use
     * 
     * @param parent the parent Composite
     */
    protected void createDefaultGroup(Composite parent)
    {
        defaultGp = new Group(parent, SWT.NONE);
        defaultGp.setLayout(new GridLayout(2, false));
        defaultGp.setLayoutData(new GridData(GridData.FILL_BOTH));
        defaultGp.setText(Messages.getString("ModelerPreferencePage.0")); //$NON-NLS-1$

        Label unitText = new Label(defaultGp, SWT.NONE);
        unitText.setText(Messages.getString("ModelerPreferencePage.1")); //$NON-NLS-1$

        unit = new Combo(defaultGp, SWT.NONE | SWT.READ_ONLY);
        unit.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        useAntialiasBt = new Button(defaultGp, SWT.CHECK);
        useAntialiasBt.setText(Messages.getString("ModelerPreferencePage.2")); //$NON-NLS-1$
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        useAntialiasBt.setLayoutData(gd);

        useUUIDBt = new Button(defaultGp, SWT.CHECK);
        useUUIDBt.setText(Messages.getString("ModelerPreferencePage.3")); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        useUUIDBt.setLayoutData(gd);

        checkIntegrityBt = new Button(defaultGp, SWT.CHECK);
        checkIntegrityBt.setText(Messages.getString("ModelerPreferencePage.4")); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        checkIntegrityBt.setLayoutData(gd);

        useHTMLEditor = new Button(defaultGp, SWT.CHECK);
        useHTMLEditor.setText(Messages.getString("ModelerPreferencePage.5")); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        useHTMLEditor.setLayoutData(gd);

        useDefaultAdvancedTab = new Button(defaultGp, SWT.CHECK);
        useDefaultAdvancedTab.setText(Messages.getString("ModelerPreferencePage.6")); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        useDefaultAdvancedTab.setLayoutData(gd);

        displayDialogForReadOnly = new Button(defaultGp, SWT.CHECK);
        displayDialogForReadOnly.setText(Messages.getString("ModelerPreferencePage.7")); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        displayDialogForReadOnly.setLayoutData(gd);

        displayDialogForReadOnlyInitial = new Button(defaultGp, SWT.CHECK);
        displayDialogForReadOnlyInitial.setText(Messages.getString("ModelerPreferencePage.24")); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        displayDialogForReadOnlyInitial.setLayoutData(gd);

        displayDialogForReadOnlyChange = new Button(defaultGp, SWT.CHECK);
        displayDialogForReadOnlyChange.setText(Messages.getString("ModelerPreferencePage.25")); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        displayDialogForReadOnlyChange.setLayoutData(gd);

        displayDialogForReadOnlyChangesInEnableWriteAction = new Button(defaultGp, SWT.CHECK);
        displayDialogForReadOnlyChangesInEnableWriteAction.setText(Messages.getString("ModelerPreferencePage.26")); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        displayDialogForReadOnlyChangesInEnableWriteAction.setLayoutData(gd);

        displayDialogForRefreshResourcesInEnableWriteAction = new Button(defaultGp, SWT.CHECK);
        displayDialogForRefreshResourcesInEnableWriteAction.setText(Messages.getString("ModelerPreferencePage.27")); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        displayDialogForRefreshResourcesInEnableWriteAction.setLayoutData(gd);

        displayAskForDiagramName = new Button(defaultGp, SWT.CHECK);
        displayAskForDiagramName.setText(Messages.getString("ModelerPreferencePage.8")); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        displayAskForDiagramName.setLayoutData(gd);

        displayNotSyncDecor = new Button(defaultGp, SWT.CHECK);
        displayNotSyncDecor.setText(Messages.getString("ModelerPreferencePage.9")); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        displayNotSyncDecor.setLayoutData(gd);

        dontAskAgainMoveModelAction = new Button(defaultGp, SWT.CHECK);
        dontAskAgainMoveModelAction.setText(Messages.getString("ModelerPreferencePage.10")); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        dontAskAgainMoveModelAction.setLayoutData(gd);

        createAuthorAnnotation = new Button(defaultGp, SWT.CHECK);
        createAuthorAnnotation.setText(Messages.getString("ModelerPreferencePage.11")); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        createAuthorAnnotation.setLayoutData(gd);

        Label authorDescription = new Label(defaultGp, SWT.NONE);
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        gd.horizontalSpan = 2;
        authorDescription.setLayoutData(gd);
        authorDescription.setText(Messages.getString("ModelerPreferencePage.12")); //$NON-NLS-1$

        Label authorLabel = new Label(defaultGp, SWT.NONE);
        authorLabel.setText(Messages.getString("ModelerPreferencePage.13")); //$NON-NLS-1$

        authorTxt = new Text(defaultGp, SWT.BORDER);
        authorTxt.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // Palette Configuration
        Label paletteText = new Label(defaultGp, SWT.NONE);
        paletteText.setText(Messages.getString("ModelerPreferencePage.14")); //$NON-NLS-1$

        palette = new Combo(defaultGp, SWT.NONE | SWT.READ_ONLY);
        palette.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // group for controlled elements
        controlledEltGroup = new Group(parent, SWT.NONE);
        controlledEltGroup.setLayout(new GridLayout(2, false));
        controlledEltGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
        controlledEltGroup.setText(Messages.getString("ModelerPreferencePage.15")); //$NON-NLS-1$

        gd = new GridData(GridData.FILL_HORIZONTAL);
        useDifferentColorsForControlledElements = new Button(controlledEltGroup, SWT.CHECK);
        gd.horizontalSpan = 2;
        useDifferentColorsForControlledElements.setText(Messages.getString("ModelerPreferencePage.16")); //$NON-NLS-1$
        useDifferentColorsForControlledElements.setLayoutData(gd);

        colorForSameResource = new ColorFieldEditor(ModelerPreferenceConstants.PREFERENCE_COLOR_FOR_SAME_RESOURCE, Messages.getString("ModelerPreferencePage.17"), controlledEltGroup); //$NON-NLS-1$
        colorForSameResource.setPreferenceStore(getPreferenceStore());
        colorForSameResource.getLabelControl(controlledEltGroup).setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        // colorForDifferentResource.getColorSelector().getButton().setLayoutData(new GridData(SWT.FILL, SWT.NONE,
        // false, false));

        colorForDifferentResource = new ColorFieldEditor(ModelerPreferenceConstants.PREFERENCE_COLOR_FOR_DIFFERENT_RESOURCE, Messages.getString("ModelerPreferencePage.18"), controlledEltGroup); //$NON-NLS-1$
        colorForDifferentResource.setPreferenceStore(getPreferenceStore());
        colorForDifferentResource.getLabelControl(controlledEltGroup).setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        // colorForDifferentResource.getColorSelector().getButton().setLayoutData(new GridData(SWT.FILL, SWT.NONE,
        // false, false));

        controlledReadOnly = new Button(controlledEltGroup, SWT.CHECK);
        controlledReadOnly.setText(Messages.getString("ModelerPreferencePage.19")); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        controlledReadOnly.setLayoutData(gd);

        selectFilteredElements = new BooleanFieldEditor(ModelerPreferenceConstants.PREFERENCE_OUTLINE_SELECT_FILTERED_ELEMENTS, Messages.getString("ModelerPreferencePage.20"), controlledEltGroup); //$NON-NLS-1$
        selectFilteredElements.fillIntoGrid(controlledEltGroup, 2);
        selectFilteredElements.setPreferenceStore(getPreferenceStore());

        limitForElementSelection = new IntegerFieldEditor(ModelerPreferenceConstants.PREFERENCE_OUTLINE_LIMIT_FOR_SELECTION, Messages.getString("ModelerPreferencePage.21"), controlledEltGroup); //$NON-NLS-1$
        limitForElementSelection.setPreferenceStore(getPreferenceStore());
        limitForElementSelection.setTextLimit(5);
        limitForElementSelection.fillIntoGrid(controlledEltGroup, 2);
        limitForElementSelection.getLabelControl(controlledEltGroup).setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        limitForElementSelection.getTextControl(controlledEltGroup).setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));

        limitForHistorik = new IntegerFieldEditor(ModelerPreferenceConstants.PREFERENCE_OUTLINE_LIMIT_FOR_HISTORIK, Messages.getString("ModelerPreferencePage.22"), controlledEltGroup); //$NON-NLS-1$
        limitForHistorik.setPreferenceStore(getPreferenceStore());
        limitForHistorik.setTextLimit(5);
        limitForHistorik.fillIntoGrid(controlledEltGroup, 2);
        limitForHistorik.getLabelControl(controlledEltGroup).setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        limitForHistorik.getTextControl(controlledEltGroup).setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));

        displayVirtualContainers = new Button(controlledEltGroup, SWT.CHECK);
        displayVirtualContainers.setText(Messages.getString("ModelerPreferencePage.23")); //$NON-NLS-1$
        displayVirtualContainers.setLayoutData(gd);

        displayHiddenEannotations = new BooleanFieldEditor(ModelerPreferenceConstants.PREFERENCE_DISPLAY_HIDDEN_EANNOTATION, "Display Hidden EAnnotations", controlledEltGroup);
        displayHiddenEannotations.setPreferenceStore(getPreferenceStore());

    }

    /**
     * Update the ModelerPreferencePage with values contained in the PreferenceStore
     */
    protected void doLoad()
    {
        String units = getPreferenceStore().getString(ModelerPreferenceConstants.P_DEFAULT_UNIT);
        unit.setItems(new String[] {units});
        unit.setText(units);

        boolean useAntialias = getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_USE_ANTIALIAS);
        useAntialiasBt.setSelection(useAntialias);

        boolean useUUID = getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_USE_UUID);
        useUUIDBt.setSelection(useUUID);

        boolean checkIntegrity = getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_CHECK_INTEGRITY);
        checkIntegrityBt.setSelection(checkIntegrity);

        boolean documentationHtmlEditor = getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_DOCUMENTATION_HTML_EDITOR);
        useHTMLEditor.setSelection(documentationHtmlEditor);

        boolean useDefaultAdvancedPropertyTab = TabbedPropertiesPlugin.getDefault().getPreferenceStore().getBoolean(TabbedPropertiesConstants.P_DEFAULT_ADVANCED);
        useDefaultAdvancedTab.setSelection(useDefaultAdvancedPropertyTab);

        boolean displayReadOnly = !getPreferenceStore().getBoolean(ModelerPreferenceConstants.PREFERENCE_FOR_READ_ONLY);
        displayDialogForReadOnly.setSelection(displayReadOnly);

        boolean displayReadOnlyInitialInformationDialog = !getPreferenceStore().getBoolean(ModelerPreferenceConstants.PREFERENCE_FOR_READ_ONLY_RESOURCES_INITIAL);
        displayDialogForReadOnlyInitial.setSelection(displayReadOnlyInitialInformationDialog);

        boolean displayReadOnlyChangesInEnableWriteAction = !getPreferenceStore().getBoolean(ModelerPreferenceConstants.READ_ONLY_CHANGES_ACTION_CONFIRM);
        displayDialogForReadOnlyChangesInEnableWriteAction.setSelection(displayReadOnlyChangesInEnableWriteAction);

        boolean displayRefreshResourcesInEnableWriteAction = !getPreferenceStore().getBoolean(ModelerPreferenceConstants.REFRESH_RESOURCES_ACTION_CONFIRM);
        displayDialogForRefreshResourcesInEnableWriteAction.setSelection(displayRefreshResourcesInEnableWriteAction);

        boolean displayReadOnlyChangeInformationDialog = !getPreferenceStore().getBoolean(ModelerPreferenceConstants.PREFERENCE_FOR_READ_ONLY_RESOURCES_CHANGE);
        displayDialogForReadOnlyChange.setSelection(displayReadOnlyChangeInformationDialog);

        boolean askForDiagramName = getPreferenceStore().getBoolean(ModelerPreferenceConstants.PREFERENCE_ASK_FOR_DIAGRAM_NAME);
        displayAskForDiagramName.setSelection(askForDiagramName);

        boolean dispNotSyncDecor = getPreferenceStore().getBoolean(ModelerPreferenceConstants.PREFERENCE_NOT_SYNC_DECOR);
        displayNotSyncDecor.setSelection(dispNotSyncDecor);

        boolean dontAskConfirmMoveModel = getPreferenceStore().getBoolean(ModelerPreferenceConstants.MOVE_MODEL_ACTION_CONFIRM);
        dontAskAgainMoveModelAction.setSelection(dontAskConfirmMoveModel);

        boolean createAnnotation = getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_CREATE_AUTHOR_ANNOTATION);
        createAuthorAnnotation.setSelection(createAnnotation);

        String defaultAuthor = getPreferenceStore().getString(ModelerPreferenceConstants.P_DEFAULT_AUTHOR);
        authorTxt.setText(defaultAuthor);

        ArrayList<String> configs = PaletteConfigurationController.getInstance().getAllPaletteConfiguration();
        configs.add(""); //$NON-NLS-1$
        palette.setItems(configs.toArray(new String[] {}));
        palette.setText(getPreferenceStore().getString(ModelerPreferenceConstants.PREFERENCE_FOR_PALETTE_CONFIGURATION));

        boolean sameColors = getPreferenceStore().getBoolean(ModelerPreferenceConstants.PREFERENCE_DIFFERENT_COLORS_FOR_CONTROL);
        useDifferentColorsForControlledElements.setSelection(sameColors);

        colorForDifferentResource.load();
        colorForSameResource.load();

        boolean controlReadOnly = getPreferenceStore().getBoolean(ModelerPreferenceConstants.PREFERENCE_ELEMENT_DIFFERENT_RESOURCE_READ_ONLY);
        controlledReadOnly.setSelection(controlReadOnly);

        selectFilteredElements.load();
        limitForElementSelection.load();
        limitForHistorik.load();
        boolean controlVirtual = getPreferenceStore().getBoolean(ModelerPreferenceConstants.PREFERENCE_OUTLINE_DISPLAY_VIRTUAL_CONTAINERS);
        displayVirtualContainers.setSelection(controlVirtual);

        displayHiddenEannotations.load();

    }

    /**
     * Update the ModelerPreferencePage with default values
     */
    protected void doLoadDefault()
    {
        unit.setText(getPreferenceStore().getDefaultString(ModelerPreferenceConstants.P_DEFAULT_UNIT));

        boolean useAntialias = getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.P_USE_ANTIALIAS);
        useAntialiasBt.setSelection(useAntialias);

        boolean useUUID = getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.P_USE_UUID);
        useUUIDBt.setSelection(useUUID);

        boolean checkIntegrity = getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.P_CHECK_INTEGRITY);
        checkIntegrityBt.setSelection(checkIntegrity);

        boolean documentationHtmlEditor = getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.P_DOCUMENTATION_HTML_EDITOR);
        useHTMLEditor.setSelection(documentationHtmlEditor);

        boolean useDefaultAdvancedPropertyTab = TabbedPropertiesPlugin.getDefault().getPreferenceStore().getDefaultBoolean(TabbedPropertiesConstants.P_DEFAULT_ADVANCED);
        useDefaultAdvancedTab.setSelection(useDefaultAdvancedPropertyTab);

        boolean createAnnotation = getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.P_CREATE_AUTHOR_ANNOTATION);
        createAuthorAnnotation.setSelection(createAnnotation);

        boolean displayReadOnly = !getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.PREFERENCE_FOR_READ_ONLY);
        displayDialogForReadOnly.setSelection(displayReadOnly);

        boolean displayReadOnlyInitial = !getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.PREFERENCE_FOR_READ_ONLY_RESOURCES_INITIAL);
        displayDialogForReadOnlyInitial.setSelection(displayReadOnlyInitial);

        boolean displayReadOnlyChange = !getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.PREFERENCE_FOR_READ_ONLY_RESOURCES_CHANGE);
        displayDialogForReadOnlyChange.setSelection(displayReadOnlyChange);

        boolean displayReadOnlyChangesInEnableWriteAction = !getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.READ_ONLY_CHANGES_ACTION_CONFIRM);
        displayDialogForReadOnlyChangesInEnableWriteAction.setSelection(displayReadOnlyChangesInEnableWriteAction);

        boolean displayRefreshResourcesInEnableWriteAction = !getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.REFRESH_RESOURCES_ACTION_CONFIRM);
        displayDialogForRefreshResourcesInEnableWriteAction.setSelection(displayRefreshResourcesInEnableWriteAction);

        boolean askForDiagramName = getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.PREFERENCE_ASK_FOR_DIAGRAM_NAME);
        displayAskForDiagramName.setSelection(askForDiagramName);

        boolean dispNotSyncDecor = getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.PREFERENCE_NOT_SYNC_DECOR);
        displayNotSyncDecor.setSelection(dispNotSyncDecor);

        boolean dontAskConfirmMoveModel = getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.PREFERENCE_NOT_SYNC_DECOR);
        dontAskAgainMoveModelAction.setSelection(dontAskConfirmMoveModel);

        authorTxt.setText(getPreferenceStore().getDefaultString(ModelerPreferenceConstants.P_DEFAULT_AUTHOR));

        palette.setText(getPreferenceStore().getDefaultString(ModelerPreferenceConstants.PREFERENCE_FOR_PALETTE_CONFIGURATION));

        boolean sameColors = getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.PREFERENCE_DIFFERENT_COLORS_FOR_CONTROL);
        useDifferentColorsForControlledElements.setSelection(sameColors);

        colorForSameResource.loadDefault();
        colorForDifferentResource.loadDefault();

        boolean controlReadOnly = getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.PREFERENCE_ELEMENT_DIFFERENT_RESOURCE_READ_ONLY);
        controlledReadOnly.setSelection(controlReadOnly);

        selectFilteredElements.loadDefault();
        limitForElementSelection.loadDefault();
        limitForHistorik.loadDefault();
        boolean controlVirtual = getPreferenceStore().getDefaultBoolean(ModelerPreferenceConstants.PREFERENCE_OUTLINE_DISPLAY_VIRTUAL_CONTAINERS);
        displayVirtualContainers.setSelection(controlVirtual);

        displayHiddenEannotations.loadDefault();
    }

    /**
     * Save values and changes made in the ModelerPreferencePage
     */
    protected void doStore()
    {
        getPreferenceStore().setValue(ModelerPreferenceConstants.P_DEFAULT_UNIT, unit.getText());
        getPreferenceStore().setValue(ModelerPreferenceConstants.P_USE_ANTIALIAS, useAntialiasBt.getSelection());
        getPreferenceStore().setValue(ModelerPreferenceConstants.P_USE_UUID, useUUIDBt.getSelection());
        getPreferenceStore().setValue(ModelerPreferenceConstants.P_CHECK_INTEGRITY, checkIntegrityBt.getSelection());
        getPreferenceStore().setValue(ModelerPreferenceConstants.P_DOCUMENTATION_HTML_EDITOR, useHTMLEditor.getSelection());
        TabbedPropertiesPlugin.getDefault().getPreferenceStore().setValue(TabbedPropertiesConstants.P_DEFAULT_ADVANCED, useDefaultAdvancedTab.getSelection());
        getPreferenceStore().setValue(ModelerPreferenceConstants.P_CREATE_AUTHOR_ANNOTATION, createAuthorAnnotation.getSelection());
        getPreferenceStore().setValue(ModelerPreferenceConstants.P_DEFAULT_AUTHOR, authorTxt.getText());
        getPreferenceStore().setValue(ModelerPreferenceConstants.PREFERENCE_FOR_READ_ONLY, !displayDialogForReadOnly.getSelection());
        getPreferenceStore().setValue(ModelerPreferenceConstants.PREFERENCE_FOR_READ_ONLY_RESOURCES_INITIAL, !displayDialogForReadOnlyInitial.getSelection());
        getPreferenceStore().setValue(ModelerPreferenceConstants.PREFERENCE_FOR_READ_ONLY_RESOURCES_CHANGE, !displayDialogForReadOnlyChange.getSelection());
        getPreferenceStore().setValue(ModelerPreferenceConstants.READ_ONLY_CHANGES_ACTION_CONFIRM, !displayDialogForReadOnlyChangesInEnableWriteAction.getSelection());
        getPreferenceStore().setValue(ModelerPreferenceConstants.REFRESH_RESOURCES_ACTION_CONFIRM, !displayDialogForRefreshResourcesInEnableWriteAction.getSelection());
        getPreferenceStore().setValue(ModelerPreferenceConstants.PREFERENCE_NOT_SYNC_DECOR, displayNotSyncDecor.getSelection());
        getPreferenceStore().setValue(ModelerPreferenceConstants.PREFERENCE_FOR_PALETTE_CONFIGURATION, palette.getText());
        getPreferenceStore().setValue(ModelerPreferenceConstants.PREFERENCE_ASK_FOR_DIAGRAM_NAME, displayAskForDiagramName.getSelection());
        getPreferenceStore().setValue(ModelerPreferenceConstants.MOVE_MODEL_ACTION_CONFIRM, dontAskAgainMoveModelAction.getSelection());
        getPreferenceStore().setValue(ModelerPreferenceConstants.PREFERENCE_DIFFERENT_COLORS_FOR_CONTROL, useDifferentColorsForControlledElements.getSelection());
        colorForDifferentResource.store();
        colorForSameResource.store();
        getPreferenceStore().setValue(ModelerPreferenceConstants.PREFERENCE_ELEMENT_DIFFERENT_RESOURCE_READ_ONLY, controlledReadOnly.getSelection());
        selectFilteredElements.store();
        limitForElementSelection.store();
        limitForHistorik.store();
        getPreferenceStore().setValue(ModelerPreferenceConstants.PREFERENCE_OUTLINE_DISPLAY_VIRTUAL_CONTAINERS, displayVirtualContainers.getSelection());
        displayHiddenEannotations.store();
    }

    /**
     * Restore the default values
     * 
     * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
     */
    protected void performDefaults()
    {
        doLoadDefault();
        super.performDefaults();
    }

    /**
     * Store the values in the PreferenceStore
     * 
     * @see org.eclipse.jface.preference.IPreferencePage#performOk()
     */
    public boolean performOk()
    {
        doStore();
        return super.performOk();
    }

    /**
     * @see org.topcased.facilities.preferences.AbstractTopcasedPreferencePage#getBundleId()
     */
    protected String getBundleId()
    {
        return ModelerPlugin.getId();
    }

}
