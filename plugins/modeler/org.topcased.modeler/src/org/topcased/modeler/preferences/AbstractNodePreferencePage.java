/*****************************************************************************
 * 
 * AbstractNodePreferencePage.java
 * 
 * Copyright (c) 2005-2008 TOPCASED consortium.
 *
 * Contributors:
 *  Thibault Landré (Atos Origin) thibault.landre@atosorigin.com - Initial API and implementation
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.topcased.modeler.preferences;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FontFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.topcased.facilities.preferences.AbstractTopcasedPreferencePage;

/**
 * An abstract implementation of a Topcased Preference Page for an node object. This class defines the page displayed
 * with the graphics preferences that can be store in the preference store : Font, Foreground color, Background Color of
 * the node. Clients must implements <code>getNodeFont()</code>, <code>getNodeForegroundColor()</code>,
 * <code>getNodeBackgroundColor()</code>
 */
public abstract class AbstractNodePreferencePage extends AbstractTopcasedPreferencePage
{

    private ColorFieldEditor foregroundColorFieldEditor;

    private ColorFieldEditor backgroundColorFieldEditor;

    private FontFieldEditor fontFieldEditor;

    /**
     * Initializes this preference page for the given workbench.
     * 
     * @param workbench the workbench
     * 
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     * 
     */
    public void init(IWorkbench workbench)
    {
        // Do nothing
    }

    /**
     * Creates and returns the SWT control for the customized body of this preference page under the given parent
     * composite.
     * 
     * @param parent the parent composite
     * 
     * @return the new control
     * 
     * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createContents(Composite parent)
    {

        // Create the container composite
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout containerLayout = new GridLayout();
        containerLayout.marginWidth = 0;
        containerLayout.marginHeight = 0;
        container.setLayout(containerLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        createDisplay(container);

        loadPreferences();

        return container;

    }

    /**
     * Creates the display.
     * 
     * @param parent the parent.
     */
    protected void createDisplay(Composite parent)
    {
        Group group = new Group(parent, SWT.SHADOW_ETCHED_OUT);
        group.setLayout(new GridLayout());
        group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // Font
        Composite compoFontGlobal = new Composite(group, SWT.NONE);
        compoFontGlobal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        fontFieldEditor = new FontFieldEditor(getNodeFont(), "Font:", compoFontGlobal);
        fontFieldEditor.setPreferenceStore(getPreferenceStore());

        // Foreground
        Composite compoForegroundColorGlobal = new Composite(group, SWT.NONE);

        foregroundColorFieldEditor = new ColorFieldEditor(getNodeForegroundColor(), "ForegroundColor: ", compoForegroundColorGlobal);
        foregroundColorFieldEditor.setPreferenceStore(getPreferenceStore());

        // Background
        Composite compoBackgroundColorGlobal = new Composite(group, SWT.NONE);

        backgroundColorFieldEditor = new ColorFieldEditor(getNodeBackgroundColor(), "BackgroundColor: ", compoBackgroundColorGlobal);
        backgroundColorFieldEditor.setPreferenceStore(getPreferenceStore());
    }

    /**
     * @see org.eclipse.jface.preference.IPreferencePage#performOk()
     * @generated
     */
    @Override
    public boolean performOk()
    {
        storePreferences();
        return super.performOk();
    }

    /**
     * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
     * @generated
     */
    @Override
    protected void performDefaults()
    {
        loadDefaultPreferences();
        super.performDefaults();
    }

    /**
     * Stores the HMI values into the preference store.
     * 
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void storePreferences()
    {
        fontFieldEditor.store();
        foregroundColorFieldEditor.store();
        backgroundColorFieldEditor.store();
    }

    /**
     * Initializes the HMI with preference values.
     * 
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     */
    protected void loadPreferences()
    {
        fontFieldEditor.load();
        foregroundColorFieldEditor.load();
        backgroundColorFieldEditor.load();
    }

    /**
     * Initializes the HMI with default preference values.
     * 
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     */
    protected void loadDefaultPreferences()
    {
        fontFieldEditor.loadDefault();
        foregroundColorFieldEditor.loadDefault();
        backgroundColorFieldEditor.loadDefault();
    }

    /**
     * Get the constant representing the node font preference in the preference store
     * 
     * @return the constant
     */
    protected abstract String getNodeFont();

    /**
     * Get the constant representing the node foreground color preference in the preference store
     * 
     * @return the constant
     */
    protected abstract String getNodeForegroundColor();

    /**
     * Get the constant representing the node background color preference in the preference store
     * 
     * @return the constant
     */
    protected abstract String getNodeBackgroundColor();

}
