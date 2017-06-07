/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 * Thibault Landré (Atos Origin) - add project scope to preference page
 ******************************************************************************/
package org.topcased.modeler.internal.preferences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.topcased.facilities.preferences.AbstractTopcasedPreferencePage;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.preferences.PageFormat;

/**
 * This class represents the preference page associated with the definition of
 * the PageFormats.
 */
public class PageFormatPreferencePage extends AbstractTopcasedPreferencePage implements IWorkbenchPreferencePage
{

    private static final String DEFAULT_SUFFIX = " (default)";

    /** The parent composite */
    private Composite parentComposite;

    private Group pageFormatGp;

    private Group orientationGp;

    private List formatsLst;

    private ArrayList formats;

    private PageFormat activePageFormat;

    private Button portraitBt;

    private Button landscapeBt;

    private Text pageFormatNameFd;

    private Text pageWidthFd;

    private Text pageHeightFd;

    private Button addPageFormatBt;

    private Button removePageFormatBt;

    private Button defaultPageFormatBt;

    private String defaultPageFormat;

    private FocusListener focusListener = new FocusListener()
    {

        public void focusGained(FocusEvent e)
        {
        }

        public void focusLost(FocusEvent e)
        {
            updateActivePageFormat();
        }

    };

    /**
     * The Constructor
     */
    public PageFormatPreferencePage()
    {
        //Does nothing 
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

        pageFormatGp = new Group(parentComposite, SWT.SHADOW_ETCHED_OUT);
        pageFormatGp.setText("Page Format");
        pageFormatGp.setLayout(new GridLayout(3, false));
        pageFormatGp.setLayoutData(new GridData(GridData.FILL_BOTH));
        createPageFormatGroup(pageFormatGp);

        orientationGp = new Group(parentComposite, SWT.SHADOW_ETCHED_OUT);
        orientationGp.setText("Orientation");
        orientationGp.setLayout(new GridLayout(2, false));
        orientationGp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        createOrientationGroup(orientationGp);

        hookListeners();

        doLoad();

        initializeWidgets();

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
     * Initialize the widgets (Buttons, TextFields)
     */
    private void initializeWidgets()
    {
        pageFormatNameFd.setEnabled(false);
        pageWidthFd.setEnabled(false);
        pageHeightFd.setEnabled(false);
    }

    /**
     * Creates the group for page format properties
     * 
     * @param parent the parent Composite
     */
    protected void createPageFormatGroup(Composite parent)
    {
        // selection of the page format
        Label pageFormatLbl = new Label(parent, SWT.NONE);
        pageFormatLbl.setText("Available page format : ");
        GridData layoutData = new GridData();
        layoutData.verticalSpan = 3;
        layoutData.verticalAlignment = SWT.TOP;
        pageFormatLbl.setLayoutData(layoutData);

        // add the list that contains the available page formats
        formatsLst = new List(parent, SWT.SINGLE | SWT.BORDER | SWT.SCROLL_PAGE | SWT.V_SCROLL);
        GridData layoutData2 = new GridData(GridData.FILL_BOTH);
        layoutData2.heightHint = 120;
        layoutData2.verticalSpan = 3;
        formatsLst.setLayoutData(layoutData2);

        // add the Buttons
        GridData layoutData3 = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
        layoutData3.widthHint = 80;
        addPageFormatBt = new Button(parent, SWT.PUSH);
        addPageFormatBt.setText("Add");
        addPageFormatBt.setLayoutData(layoutData3);
        removePageFormatBt = new Button(parent, SWT.PUSH);
        removePageFormatBt.setText("Remove");
        removePageFormatBt.setLayoutData(layoutData3);
        defaultPageFormatBt = new Button(parent, SWT.PUSH);
        defaultPageFormatBt.setText("Default");
        defaultPageFormatBt.setLayoutData(layoutData3);

        // the pageFormat name
        Composite parentName = new Composite(parent, SWT.NONE);
        parentName.setLayout(new GridLayout(2, false));
        parentName.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));

        new Label(parentName, SWT.NONE).setText("Name : ");
        pageFormatNameFd = new Text(parentName, SWT.BORDER);
        pageFormatNameFd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // the composite that contains others informations on the page format
        Composite parent2 = new Composite(parent, SWT.NONE);
        parent2.setLayout(new GridLayout(3, false));
        parent2.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));

        // the width of the selected PageFormat
        Composite parentWidthValue = new Composite(parent2, SWT.NONE);
        parentWidthValue.setLayout(new GridLayout(3, false));
        parentWidthValue.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 1, 1));

        GridData layoutData5 = new GridData();
        layoutData5.widthHint = 60;

        new Label(parentWidthValue, SWT.NONE).setImage(ModelerImageRegistry.getImage("WIDTH"));
        new Label(parentWidthValue, SWT.NONE).setText("Page width : ");
        pageWidthFd = new Text(parentWidthValue, SWT.BORDER);
        pageWidthFd.setLayoutData(layoutData5);

        // the vertical separator
        Label separator2 = new Label(parent2, SWT.SEPARATOR);
        GridData layoutDataSeparator2 = new GridData();
        layoutDataSeparator2.heightHint = 40;
        separator2.setLayoutData(layoutDataSeparator2);

        // the height of the selected PageFormat
        Composite parentHeightValue = new Composite(parent2, SWT.NONE);
        parentHeightValue.setLayout(new GridLayout(3, false));
        parentHeightValue.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 1, 1));

        new Label(parentHeightValue, SWT.NONE).setImage(ModelerImageRegistry.getImage("HEIGHT"));
        new Label(parentHeightValue, SWT.NONE).setText("Page height : ");
        pageHeightFd = new Text(parentHeightValue, SWT.BORDER);
        pageHeightFd.setLayoutData(layoutData5);

    }

    /**
     * Add the listeners to the Buttons and the Text widgets
     */
    private void hookListeners()
    {
        pageFormatNameFd.addFocusListener(focusListener);
        pageHeightFd.addFocusListener(focusListener);
        pageWidthFd.addFocusListener(focusListener);

        // Button listeners
        addPageFormatBt.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                addPageFormat();
            }
        });

        removePageFormatBt.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                removePageFormat();
            }
        });

        defaultPageFormatBt.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                setDefault();
            }
        });

        formatsLst.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                setActivePageFormat(getActivePageFormat());
            }
        });

    }

    /**
     * Add a new Page Format to the existing list
     * 
     */
    private void addPageFormat()
    {
        activePageFormat = new PageFormat("newPageFormat;0;0;true");
        formats.add(activePageFormat);
        formatsLst.add("newPageFormat");
    }

    /**
     * Remove the selected Page Format
     * 
     */
    private void removePageFormat()
    {
        if (formatsLst.getSelectionCount() == 1)
        {
            formats.remove(activePageFormat);
            formatsLst.remove(formatsLst.getSelection()[0]);

            if (defaultPageFormat.equals(activePageFormat.getName()))
            {
                // we have suppressed the defaultPageFormat
                defaultPageFormat = getPreferenceStore().getDefaultString(
                        ModelerPreferenceConstants.P_DEFAULT_PAGE_FORMAT);
                updatePageFormatList();
            }

            pageFormatNameFd.setText("");
            pageWidthFd.setText("");
            pageHeightFd.setText("");

            pageFormatNameFd.setEnabled(false);
            pageWidthFd.setEnabled(false);
            pageHeightFd.setEnabled(false);
        }
    }

    /**
     * Refresh the contents of the page corresponding to the selected PageFormat
     * 
     * @param pageFormat
     */
    private void setActivePageFormat(PageFormat pageFormat)
    {
        activePageFormat = pageFormat;

        if (activePageFormat.getModifiable())
        {
            removePageFormatBt.setEnabled(true);
            pageFormatNameFd.setEnabled(true);
            pageWidthFd.setEnabled(true);
            pageHeightFd.setEnabled(true);
        }
        else
        {
            removePageFormatBt.setEnabled(false);
            pageFormatNameFd.setEnabled(false);
            pageWidthFd.setEnabled(false);
            pageHeightFd.setEnabled(false);
        }

        pageFormatNameFd.setText(activePageFormat.getName());
        pageWidthFd.setText(StringConverter.asString(activePageFormat.getWidth()));
        pageHeightFd.setText(StringConverter.asString(activePageFormat.getHeight()));
    }

    /**
     * Set the current selected item as the new default PageFormat
     */
    private void setDefault()
    {
        // check if at a PageFormat is selected in the list
        if (formatsLst.getSelection().length == 1)
        {
            // check if the selected PageFormat is not already the default
            // PageFormat
            if (activePageFormat.getName() != defaultPageFormat)
            {
                defaultPageFormat = activePageFormat.getName();
                int index = formatsLst.getSelectionIndex();
                updatePageFormatList();
                formatsLst.setSelection(index);
            }
        }
    }

    /**
     * Update the list that contains the names of the available PageFormats
     */
    private void updatePageFormatList()
    {
        // delete existing items
        formatsLst.removeAll();

        // fill again the list
        for (Iterator i = formats.iterator(); i.hasNext();)
        {
            PageFormat pageFormat = (PageFormat) i.next();
            if (defaultPageFormat.equals(pageFormat.getName()))
            {
                formatsLst.add(pageFormat.getName() + DEFAULT_SUFFIX);
            }
            else
            {
                formatsLst.add(pageFormat.getName());
            }
        }
    }

    /**
     * Check if the informations contained in the preference page are OK
     * 
     * @return true if it is OK
     */
    protected boolean updateActivePageFormat()
    {
        if (formatsLst.getSelection()[0].equals(defaultPageFormat + DEFAULT_SUFFIX))
        {
            formatsLst.setItem(formatsLst.getSelectionIndex(), pageFormatNameFd.getText() + DEFAULT_SUFFIX);
        }
        else
        {
            formatsLst.setItem(formatsLst.getSelectionIndex(), pageFormatNameFd.getText());
        }

        activePageFormat.setName(pageFormatNameFd.getText());
        activePageFormat.setWidth(StringConverter.asInt(pageWidthFd.getText()));
        activePageFormat.setHeight(StringConverter.asInt(pageHeightFd.getText()));

        setErrorMessage(null);
        return true;
    }

    /**
     * Creates the default orientation group
     * 
     * @param parent the parent Composite
     */
    protected void createOrientationGroup(Composite parent)
    {
        new Label(parent, SWT.NONE).setText("Default orientation : ");
        portraitBt = new Button(parent, SWT.RADIO);
        portraitBt.setText("Portrait");

        new Label(parent, SWT.NONE);
        landscapeBt = new Button(parent, SWT.RADIO);
        landscapeBt.setText("Landscape");
    }

    /**
     * Update the ModelerPreferencePage with values contained in the
     * PreferenceStore
     */
    protected void doLoad()
    {
        defaultPageFormat = getPreferenceStore().getString(ModelerPreferenceConstants.P_DEFAULT_PAGE_FORMAT);

        StringTokenizer tokenizerFormats = new StringTokenizer(getPreferenceStore().getString(
                ModelerPreferenceConstants.P_PAGE_FORMATS), ModelerPreferenceConstants.PAGE_FORMATS_DELIMITER);
        int tokenCount = tokenizerFormats.countTokens();
        formats = new ArrayList();
        formatsLst.removeAll();
        for (int i = 0; i < tokenCount; i++)
        {
            PageFormat pageFormat = new PageFormat(tokenizerFormats.nextToken());
            formats.add(pageFormat);
            if (defaultPageFormat.equals(pageFormat.getName()))
            {
                formatsLst.add(pageFormat.getName() + DEFAULT_SUFFIX);
            }
            else
            {
                formatsLst.add(pageFormat.getName());
            }
        }

        if (ModelerPropertyConstants.PORTRAIT_ORIENTATION.equals(getPreferenceStore().getString(
                ModelerPreferenceConstants.P_ORIENTATION)))
        {
            portraitBt.setSelection(true);
            landscapeBt.setSelection(false);
        }
        else
        {
            portraitBt.setSelection(false);
            landscapeBt.setSelection(true);
        }
    }

    /**
     * Update the ModelerPreferencePage with default values
     */
    protected void doLoadDefault()
    {
        defaultPageFormat = getPreferenceStore().getDefaultString(ModelerPreferenceConstants.P_DEFAULT_PAGE_FORMAT);

        StringTokenizer tokenizerFormats = new StringTokenizer(getPreferenceStore().getDefaultString(
                ModelerPreferenceConstants.P_PAGE_FORMATS), ModelerPreferenceConstants.PAGE_FORMATS_DELIMITER);
        int tokenCount = tokenizerFormats.countTokens();
        formats = new ArrayList();
        formatsLst.removeAll();
        for (int i = 0; i < tokenCount; i++)
        {
            PageFormat pageFormat = new PageFormat(tokenizerFormats.nextToken());
            formats.add(pageFormat);
            if (defaultPageFormat.equals(pageFormat.getName()))
            {
                formatsLst.add(pageFormat.getName() + DEFAULT_SUFFIX);
            }
            else
            {
                formatsLst.add(pageFormat.getName());
            }
        }

        portraitBt.setSelection("portrait".equals(getPreferenceStore().getDefaultString(
                ModelerPreferenceConstants.P_ORIENTATION)));
    }

    /**
     * Save values and changes made in the ModelerPreferencePage
     */
    protected void doStore()
    {
        StringBuffer bufferFormats = new StringBuffer();
        for (Iterator i = formats.iterator(); i.hasNext();)
        {
            PageFormat pageFormat = (PageFormat) i.next();
            bufferFormats.append(pageFormat.toString());
            bufferFormats.append(ModelerPreferenceConstants.PAGE_FORMATS_DELIMITER);
        }
        getPreferenceStore().setValue(ModelerPreferenceConstants.P_PAGE_FORMATS, bufferFormats.toString());

        if (portraitBt.getSelection())
        {
            getPreferenceStore().setValue(ModelerPreferenceConstants.P_ORIENTATION,
                    ModelerPropertyConstants.PORTRAIT_ORIENTATION);
        }
        else
        {
            getPreferenceStore().setValue(ModelerPreferenceConstants.P_ORIENTATION,
                    ModelerPropertyConstants.LANDSCAPE_ORIENTATION);
        }

        getPreferenceStore().setValue(ModelerPreferenceConstants.P_DEFAULT_PAGE_FORMAT, defaultPageFormat);
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
     * Return the PageFormat associated with the item selected in the list
     * 
     * @return the corresponding PageFormat
     */
    private PageFormat getActivePageFormat()
    {
        if (formatsLst.getSelectionCount() == 1)
        {
            return getActivePageFormat(formatsLst.getSelection()[0]);
        }

        return null;
    }

    /**
     * Return the PageFormat associated with the item selected in the list
     * 
     * @param name the name that identify the PageFormat
     * @return the corresponding PageFormat
     */
    private PageFormat getActivePageFormat(String name)
    {
        for (Iterator i = formats.iterator(); i.hasNext();)
        {
            PageFormat pageFormat = (PageFormat) i.next();
            if (defaultPageFormat.equals(pageFormat.getName()))
            {
                if (name.equals(pageFormat.getName() + DEFAULT_SUFFIX))
                {
                    return pageFormat;
                }
            }
            else
            {
                if (name.equals(pageFormat.getName()))
                {
                    return pageFormat;
                }
            }
        }
        return null;
    }
    
    /**
     * @see org.topcased.facilities.preferences.AbstractTopcasedPreferencePage#getBundleId()
     */
    protected String getBundleId() 
    {
    	return ModelerPlugin.getId();
    }
}
