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

import org.eclipse.jface.preference.PreferencePage;
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
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.preferences.PageMargin;

/**
 * This class represents the preference page associated with the definition of
 * the PageMargins.
 */

public class PageMarginPreferencePage extends AbstractTopcasedPreferencePage implements IWorkbenchPreferencePage
{

    private static final String DEFAULT_SUFFIX = " (default)";

    /** The parent composite */
    private Composite parentComposite;

    private Group marginsGp;

    private List marginsLst;

    private ArrayList margins;

    private PageMargin activePageMargin;

    private Text pageMarginNameFd;

    private Text topMarginFd;

    private Text bottomMarginFd;

    private Text leftMarginFd;

    private Text rightMarginFd;

    private Button addPageMarginsBt;

    private Button removePageMarginsBt;

    private Button defaultPageMarginsBt;

    private String defaultPageMargin;

    private FocusListener focusListener = new FocusListener()
    {
        public void focusGained(FocusEvent e)
        {
        }

        public void focusLost(FocusEvent e)
        {
            updateActivePageMargin();
        }
    };

    /**
     * The Constructor
     */
    public PageMarginPreferencePage()
    {
        // Does nothing
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

        marginsGp = new Group(parentComposite, SWT.SHADOW_ETCHED_OUT);
        marginsGp.setText("Page Margins");
        marginsGp.setLayout(new GridLayout(3, false));
        marginsGp.setLayoutData(new GridData(GridData.FILL_BOTH));
        createPageMarginsGroup(marginsGp);

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
        pageMarginNameFd.setEnabled(false);
        topMarginFd.setEnabled(false);
        leftMarginFd.setEnabled(false);
        bottomMarginFd.setEnabled(false);
        rightMarginFd.setEnabled(false);
    }

    /**
     * Creates the group for margins properties
     * 
     * @param parent the parent Composite
     */
    protected void createPageMarginsGroup(Composite parent)
    {
        // selection of the page margins
        Label pageMarginsLbl = new Label(parent, SWT.NONE);
        pageMarginsLbl.setText("Available page margins : ");
        GridData layoutData = new GridData();
        layoutData.verticalSpan = 3;
        layoutData.verticalAlignment = SWT.TOP;
        pageMarginsLbl.setLayoutData(layoutData);

        // add the list that contains the available page margins
        marginsLst = new List(parent, SWT.SINGLE | SWT.BORDER | SWT.SCROLL_PAGE | SWT.V_SCROLL);
        GridData layoutData2 = new GridData(GridData.FILL_BOTH);
        layoutData2.heightHint = 120;
        layoutData2.verticalSpan = 3;
        marginsLst.setLayoutData(layoutData2);

        // add the buttons
        GridData layoutData3 = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
        layoutData3.widthHint = 80;
        addPageMarginsBt = new Button(parent, SWT.PUSH);
        addPageMarginsBt.setText("Add");
        addPageMarginsBt.setLayoutData(layoutData3);
        removePageMarginsBt = new Button(parent, SWT.PUSH);
        removePageMarginsBt.setText("Remove");
        removePageMarginsBt.setLayoutData(layoutData3);
        defaultPageMarginsBt = new Button(parent, SWT.PUSH);
        defaultPageMarginsBt.setText("Default");
        defaultPageMarginsBt.setLayoutData(layoutData3);

        // the pageMargins name
        Composite parentName = new Composite(parent, SWT.NONE);
        parentName.setLayout(new GridLayout(2, false));
        parentName.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));

        new Label(parentName, SWT.NONE).setText("Name : ");
        pageMarginNameFd = new Text(parentName, SWT.BORDER);
        pageMarginNameFd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // the composite that contains details on the page margin selected
        Composite parent2 = new Composite(parent, SWT.NONE);
        parent2.setLayout(new GridLayout(3, false));
        parent2.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));

        // the top and left margins of the selected page margins
        Composite parentTopBottomValues = new Composite(parent2, SWT.NONE);
        parentTopBottomValues.setLayout(new GridLayout(3, false));
        parentTopBottomValues.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 1, 1));

        GridData layoutData4 = new GridData();
        layoutData4.widthHint = 60;

        new Label(parentTopBottomValues, SWT.NONE).setImage(ModelerImageRegistry.getImage("TOPMARGIN"));
        new Label(parentTopBottomValues, SWT.NONE).setText("Top margin : ");
        topMarginFd = new Text(parentTopBottomValues, SWT.BORDER);
        topMarginFd.setLayoutData(layoutData4);

        new Label(parentTopBottomValues, SWT.NONE).setImage(ModelerImageRegistry.getImage("BOTTOMMARGIN"));
        new Label(parentTopBottomValues, SWT.NONE).setText("Bottom margin : ");
        bottomMarginFd = new Text(parentTopBottomValues, SWT.BORDER);
        bottomMarginFd.setLayoutData(layoutData4);

        // the vertical separator
        new Label(parent2, SWT.SEPARATOR);

        // the bottom and right margins of the selected page margins
        Composite parentLeftRightValues = new Composite(parent2, SWT.NONE);
        parentLeftRightValues.setLayout(new GridLayout(3, false));
        parentLeftRightValues.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 1, 1));

        new Label(parentLeftRightValues, SWT.NONE).setImage(ModelerImageRegistry.getImage("LEFTMARGIN"));
        new Label(parentLeftRightValues, SWT.NONE).setText("Left margin : ");
        leftMarginFd = new Text(parentLeftRightValues, SWT.BORDER);
        leftMarginFd.setLayoutData(layoutData4);

        new Label(parentLeftRightValues, SWT.NONE).setImage(ModelerImageRegistry.getImage("RIGHTMARGIN"));
        new Label(parentLeftRightValues, SWT.NONE).setText("Right margin : ");
        rightMarginFd = new Text(parentLeftRightValues, SWT.BORDER);
        rightMarginFd.setLayoutData(layoutData4);

    }

    /**
     * Add the listeners to the Buttons and the Text widgets
     */
    private void hookListeners()
    {
        pageMarginNameFd.addFocusListener(focusListener);
        topMarginFd.addFocusListener(focusListener);
        leftMarginFd.addFocusListener(focusListener);
        bottomMarginFd.addFocusListener(focusListener);
        rightMarginFd.addFocusListener(focusListener);

        // Button listeners
        addPageMarginsBt.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                addPageMargin();
            }
        });

        removePageMarginsBt.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                removePageMargin();
            }
        });

        defaultPageMarginsBt.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                setDefault();
            }
        });

        marginsLst.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                setActivePageMargin(getActivePageMargin());
            }
        });

    }

    /**
     * Add a new Page Margin to the existing list
     * 
     */
    private void addPageMargin()
    {
        activePageMargin = new PageMargin("newPageMargin;0;0;0;0;true");
        margins.add(activePageMargin);
        marginsLst.add("newPageMargin");
    }

    /**
     * Remove the selected Page Margin
     * 
     */
    private void removePageMargin()
    {
        if (marginsLst.getSelectionCount() == 1)
        {
            margins.remove(activePageMargin);
            marginsLst.remove(marginsLst.getSelection()[0]);

            if (defaultPageMargin.equals(activePageMargin.getName()))
            {
                // we have suppressed the defaultPageMargin
                defaultPageMargin = getPreferenceStore().getDefaultString(
                        ModelerPreferenceConstants.P_DEFAULT_PAGE_MARGIN);
                updatePageMarginList();
            }

            pageMarginNameFd.setText("");
            topMarginFd.setText("");
            leftMarginFd.setText("");
            bottomMarginFd.setText("");
            rightMarginFd.setText("");

            pageMarginNameFd.setEnabled(false);
            topMarginFd.setEnabled(false);
            leftMarginFd.setEnabled(false);
            bottomMarginFd.setEnabled(false);
            rightMarginFd.setEnabled(false);
        }
    }

    /**
     * Refresh the contents of the page corresponding to the selected PageMargin
     * 
     * @param pageMargin
     */
    private void setActivePageMargin(PageMargin pageMargin)
    {
        activePageMargin = pageMargin;

        if (activePageMargin.getModifiable())
        {
            removePageMarginsBt.setEnabled(true);
            pageMarginNameFd.setEnabled(true);
            topMarginFd.setEnabled(true);
            leftMarginFd.setEnabled(true);
            bottomMarginFd.setEnabled(true);
            rightMarginFd.setEnabled(true);
        }
        else
        {
            removePageMarginsBt.setEnabled(false);
            pageMarginNameFd.setEnabled(false);
            topMarginFd.setEnabled(false);
            leftMarginFd.setEnabled(false);
            bottomMarginFd.setEnabled(false);
            rightMarginFd.setEnabled(false);
        }

        pageMarginNameFd.setText(activePageMargin.getName());
        topMarginFd.setText(StringConverter.asString(activePageMargin.getTop()));
        leftMarginFd.setText(StringConverter.asString(activePageMargin.getLeft()));
        bottomMarginFd.setText(StringConverter.asString(activePageMargin.getBottom()));
        rightMarginFd.setText(StringConverter.asString(activePageMargin.getRight()));
    }

    /**
     * Set the current selected item as the new default PageMargin
     */
    private void setDefault()
    {
        // check if at a PageMargin is selected in the list
        if (marginsLst.getSelection().length == 1)
        {
            // check if the selected PageMargin is not already the default
            // PageMargin
            if (activePageMargin.getName() != defaultPageMargin)
            {
                defaultPageMargin = activePageMargin.getName();
                int index = marginsLst.getSelectionIndex();
                updatePageMarginList();
                marginsLst.setSelection(index);
            }
        }
    }

    /**
     * Update the list that contains the names of the available PageMargins
     */
    private void updatePageMarginList()
    {
        // delete existing items
        marginsLst.removeAll();

        // fill again the list
        for (Iterator i = margins.iterator(); i.hasNext();)
        {
            PageMargin pageMargin = (PageMargin) i.next();
            if (defaultPageMargin.equals(pageMargin.getName()))
            {
                marginsLst.add(pageMargin.getName() + DEFAULT_SUFFIX);
            }
            else
            {
                marginsLst.add(pageMargin.getName());
            }
        }
    }

    /**
     * Check if the inmarginions contained in the preference page are OK
     * 
     * @return true if it is OK
     */
    protected boolean updateActivePageMargin()
    {
        if (marginsLst.getSelection()[0].equals(defaultPageMargin + DEFAULT_SUFFIX))
        {
            marginsLst.setItem(marginsLst.getSelectionIndex(), pageMarginNameFd.getText() + DEFAULT_SUFFIX);
        }
        else
        {
            marginsLst.setItem(marginsLst.getSelectionIndex(), pageMarginNameFd.getText());
        }

        activePageMargin.setName(pageMarginNameFd.getText());
        activePageMargin.setTop(StringConverter.asInt(topMarginFd.getText()));
        activePageMargin.setLeft(StringConverter.asInt(leftMarginFd.getText()));
        activePageMargin.setBottom(StringConverter.asInt(bottomMarginFd.getText()));
        activePageMargin.setRight(StringConverter.asInt(rightMarginFd.getText()));

        setErrorMessage(null);
        return true;
    }

    /**
     * Update the ModelerPreferencePage with values contained in the
     * PreferenceStore
     */
    protected void doLoad()
    {
        defaultPageMargin = getPreferenceStore().getString(ModelerPreferenceConstants.P_DEFAULT_PAGE_MARGIN);

        StringTokenizer tokenizerMargins = new StringTokenizer(getPreferenceStore().getString(
                ModelerPreferenceConstants.P_PAGE_MARGINS), ModelerPreferenceConstants.PAGE_MARGINS_DELIMITER);
        int tokenCount = tokenizerMargins.countTokens();
        margins = new ArrayList();
        marginsLst.removeAll();
        for (int i = 0; i < tokenCount; i++)
        {
            PageMargin pageMargin = new PageMargin(tokenizerMargins.nextToken());
            margins.add(pageMargin);
            if (defaultPageMargin.equals(pageMargin.getName()))
            {
                marginsLst.add(pageMargin.getName() + DEFAULT_SUFFIX);
            }
            else
            {
                marginsLst.add(pageMargin.getName());
            }
        }
    }

    /**
     * Update the ModelerPreferencePage with default values
     */
    protected void doLoadDefault()
    {
        defaultPageMargin = getPreferenceStore().getDefaultString(ModelerPreferenceConstants.P_DEFAULT_PAGE_MARGIN);

        StringTokenizer tokenizerMargins = new StringTokenizer(getPreferenceStore().getDefaultString(
                ModelerPreferenceConstants.P_PAGE_MARGINS), ModelerPreferenceConstants.PAGE_MARGINS_DELIMITER);
        int tokenCount = tokenizerMargins.countTokens();
        margins = new ArrayList();
        marginsLst.removeAll();
        for (int i = 0; i < tokenCount; i++)
        {
            PageMargin pageMargin = new PageMargin(tokenizerMargins.nextToken());
            margins.add(pageMargin);
            if (defaultPageMargin.equals(pageMargin.getName()))
            {
                marginsLst.add(pageMargin.getName() + DEFAULT_SUFFIX);
            }
            else
            {
                marginsLst.add(pageMargin.getName());
            }
        }
    }

    /**
     * Save values and changes made in the ModelerPreferencePage
     */
    protected void doStore()
    {
        StringBuffer bufferMargins = new StringBuffer();
        for (Iterator i = margins.iterator(); i.hasNext();)
        {
            PageMargin pageMargin = (PageMargin) i.next();
            bufferMargins.append(pageMargin.toString());
            bufferMargins.append(ModelerPreferenceConstants.PAGE_MARGINS_DELIMITER);
        }
        getPreferenceStore().setValue(ModelerPreferenceConstants.P_PAGE_MARGINS, bufferMargins.toString());

        getPreferenceStore().setValue(ModelerPreferenceConstants.P_DEFAULT_PAGE_MARGIN, defaultPageMargin);
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
     * Return the PageMargin associated with the item selected in the list
     * 
     * @return the corresponding PageMargin
     */
    private PageMargin getActivePageMargin()
    {
        if (marginsLst.getSelectionCount() == 1)
        {
            return getActivePageMargin(marginsLst.getSelection()[0]);
        }

        return null;
    }

    /**
     * Return the PageMargin associated with the item selected in the list
     * 
     * @param name the name that identify the PageMargin
     * @return the corresponding PageMargin
     */
    private PageMargin getActivePageMargin(String name)
    {
        for (Iterator i = margins.iterator(); i.hasNext();)
        {
            PageMargin pageMargin = (PageMargin) i.next();
            if (defaultPageMargin.equals(pageMargin.getName()))
            {
                if (name.equals(pageMargin.getName() + DEFAULT_SUFFIX))
                {
                    return pageMargin;
                }
            }
            else
            {
                if (name.equals(pageMargin.getName()))
                {
                    return pageMargin;
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
