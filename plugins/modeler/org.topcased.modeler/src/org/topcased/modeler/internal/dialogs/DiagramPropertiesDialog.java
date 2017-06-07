/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.internal.dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.topcased.facilities.dialogs.ITopcasedDialogConstants;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.preferences.PageFormat;
import org.topcased.modeler.preferences.PageMargin;

/**
 * The Dialog used to set the diagram properties : - page width & height (format
 * A4, A3, ...) - borders
 * 
 * @author jako
 */
public class DiagramPropertiesDialog extends Dialog implements ITopcasedDialogConstants
{
    // the model object
    private Diagram diagram;

    // SWT objects
    private Composite dialogComposite;

    private Group pageFormatGp;

    private Combo pageFormatCb;

    private ArrayList formats;

    private PageFormat selectedPageFormat;

    private String pageFormatName;

    private Text pageWidthFd;

    private String pageWidth;

    private Text pageHeightFd;

    private String pageHeight;

    private Group orientationGp;

    private String orientation;

    private Button portraitBt;

    private Button landscapeBt;

    private Group marginsGp;

    private Combo pageMarginCb;

    private ArrayList margins;

    private PageMargin selectedPageMargin;

    private String pageMarginName;

    private Text topMarginFd;

    private String topMargin;

    private Text bottomMarginFd;

    private String bottomMargin;

    private Text leftMarginFd;

    private String leftMargin;

    private Text rightMarginFd;

    private String rightMargin;

    /**
     * Create the Dialog window for selecting the page properties that are
     * defined in the preferences
     * 
     * @param diag the Diagram
     * @param parentShell the parent Shell
     */
    public DiagramPropertiesDialog(Diagram diag, Shell parentShell)
    {
        super(parentShell);
        this.diagram = diag;
        setShellStyle(getShellStyle() | SWT.RESIZE);
        setBlockOnOpen(true);
    }
    
    /**
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    protected void configureShell(Shell newShell)
    {
        newShell.setText("Diagram Properties");
        newShell.setMinimumSize(MIN_DIALOG_WIDTH, MIN_DIALOG_HEIGHT);
        
        super.configureShell(newShell);
    }

    /**
     * Create the Dialog area
     * 
     * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    protected Control createDialogArea(Composite parent)
    {
        // Dialog
        dialogComposite = (Composite) super.createDialogArea(parent);

        GridLayout dialogLayout = new GridLayout(1, false);
        GridData dialogLayoutData = new GridData(GridData.FILL_BOTH);
        dialogComposite.setLayout(dialogLayout);
        dialogComposite.setLayoutData(dialogLayoutData);

        createDiagramGroup(dialogComposite);

        hookListeners();

        initialize();

        return dialogComposite;
    }

    /**
     * Creates the group for diagram properties
     * 
     * @param parent the parent Composite
     */
    protected void createDiagramGroup(Composite parent)
    {
        pageFormatGp = new Group(parent, SWT.SHADOW_ETCHED_OUT);
        pageFormatGp.setText("Format");
        pageFormatGp.setLayout(new GridLayout(3, false));
        pageFormatGp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        createPageFormatGroup(pageFormatGp);

        orientationGp = new Group(parent, SWT.SHADOW_ETCHED_OUT);
        orientationGp.setLayout(new GridLayout(2, false));
        orientationGp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        createOrientationGroup(orientationGp);

        marginsGp = new Group(parent, SWT.SHADOW_ETCHED_OUT);
        marginsGp.setText("Margins");
        marginsGp.setLayout(new GridLayout(3, false));
        marginsGp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        createMarginsGroup(marginsGp);
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
        pageFormatLbl.setText("Page format : ");
        GridData layoutData = new GridData();
        layoutData.horizontalSpan = 2;
        pageFormatLbl.setLayoutData(layoutData);
        pageFormatCb = new Combo(parent, SWT.BORDER | SWT.READ_ONLY);
        pageFormatCb.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(parent, SWT.NONE).setImage(ModelerImageRegistry.getImage("WIDTH"));
        new Label(parent, SWT.NONE).setText("Page width : ");
        pageWidthFd = new Text(parent, SWT.BORDER);
        pageWidthFd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(parent, SWT.NONE).setImage(ModelerImageRegistry.getImage("HEIGHT"));
        new Label(parent, SWT.NONE).setText("Page height : ");
        pageHeightFd = new Text(parent, SWT.BORDER);
        pageHeightFd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    }

    /**
     * Creates the group for page format properties
     * 
     * @param parent the parent Composite
     */
    protected void createOrientationGroup(Composite parent)
    {
        // selection of the page orientation
        new Label(parent, SWT.NONE).setText("Orientation : ");
        portraitBt = new Button(parent, SWT.RADIO);
        portraitBt.setText("Portrait");

        new Label(parent, SWT.NONE);
        landscapeBt = new Button(parent, SWT.RADIO);
        landscapeBt.setText("Landscape");
    }

    /**
     * Creates the group for margins properties
     * 
     * @param parent the parent Composite
     */
    protected void createMarginsGroup(Composite parent)
    {
        // selection of the page margin
        Label pageMarginLbl = new Label(parent, SWT.NONE);
        pageMarginLbl.setText("Page margin : ");
        GridData layoutData = new GridData();
        layoutData.horizontalSpan = 2;
        pageMarginLbl.setLayoutData(layoutData);
        pageMarginCb = new Combo(parent, SWT.BORDER | SWT.READ_ONLY);
        pageMarginCb.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(parent, SWT.NONE).setImage(ModelerImageRegistry.getImage("LEFTMARGIN"));
        new Label(parent, SWT.NONE).setText("Left margin : ");
        leftMarginFd = new Text(parent, SWT.BORDER);
        leftMarginFd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(parent, SWT.NONE).setImage(ModelerImageRegistry.getImage("TOPMARGIN"));
        new Label(parent, SWT.NONE).setText("Top margin : ");
        topMarginFd = new Text(parent, SWT.BORDER);
        topMarginFd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(parent, SWT.NONE).setImage(ModelerImageRegistry.getImage("RIGHTMARGIN"));
        new Label(parent, SWT.NONE).setText("Right margin : ");
        rightMarginFd = new Text(parent, SWT.BORDER);
        rightMarginFd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(parent, SWT.NONE).setImage(ModelerImageRegistry.getImage("BOTTOMMARGIN"));
        new Label(parent, SWT.NONE).setText("Bottom margin : ");
        bottomMarginFd = new Text(parent, SWT.BORDER);
        bottomMarginFd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

    }

    /**
     * Add the listeners to the Buttons and the Text widgets
     */
    private void hookListeners()
    {
        // Button listeners
        pageFormatCb.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                selectedPageFormat = getSelectedPageFormat();

                pageWidthFd.setText(StringConverter.asString(selectedPageFormat.getWidth()));
                pageHeightFd.setText(StringConverter.asString(selectedPageFormat.getHeight()));
            }
        });

        pageMarginCb.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                selectedPageMargin = getSelectedPageMargin();

                topMarginFd.setText(StringConverter.asString(selectedPageMargin.getTop()));
                leftMarginFd.setText(StringConverter.asString(selectedPageMargin.getLeft()));
                bottomMarginFd.setText(StringConverter.asString(selectedPageMargin.getBottom()));
                rightMarginFd.setText(StringConverter.asString(selectedPageMargin.getRight()));
            }
        });
    }

    /**
     * Return the PageFormat associated with the item selected in the Combo
     * 
     * @return the corresponding PageFormat
     */
    private PageFormat getSelectedPageFormat()
    {
        String name = pageFormatCb.getText();
        for (Iterator i = formats.iterator(); i.hasNext();)
        {
            PageFormat pageFormat = (PageFormat) i.next();
            if (name.equals(pageFormat.getName()))
            {
                return pageFormat;
            }
        }
        return null;
    }

    /**
     * Return the PageMargin associated with the item selected in the Combo
     * 
     * @return the corresponding PageMargin
     */
    private PageMargin getSelectedPageMargin()
    {
        String name = pageMarginCb.getText();
        for (Iterator i = margins.iterator(); i.hasNext();)
        {
            PageMargin pageMargin = (PageMargin) i.next();
            if (name.equals(pageMargin.getName()))
            {
                return pageMargin;
            }
        }
        return null;
    }

    /**
     * Initialize the widgets of the dialog
     */
    private void initialize()
    {
        // retrieve the formats and margins from the preferenceStore
        IPreferenceStore store = ModelerPlugin.getDefault().getPreferenceStore();
        retrieveAvailablePageFormats(store);
        retrieveAvailablePageMargins(store);

        // the textfields are readOnly
        pageWidthFd.setEnabled(false);
        pageHeightFd.setEnabled(false);
        topMarginFd.setEnabled(false);
        bottomMarginFd.setEnabled(false);
        leftMarginFd.setEnabled(false);
        rightMarginFd.setEnabled(false);

        // update the widgets contents with informations contained in the
        // Diagram
        pageFormatCb.setText(DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.PAGE_FORMAT_NAME));
        pageWidthFd.setText(DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.PAGE_WIDTH));
        pageHeightFd.setText(DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.PAGE_HEIGHT));

        pageMarginCb.setText(DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.PAGE_MARGIN_NAME));
        topMarginFd.setText(DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.TOP_MARGIN));
        bottomMarginFd.setText(DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.BOTTOM_MARGIN));
        leftMarginFd.setText(DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.LEFT_MARGIN));
        rightMarginFd.setText(DIUtils.getPropertyValue(diagram, ModelerPropertyConstants.RIGHT_MARGIN));

        if (ModelerPropertyConstants.PORTRAIT_ORIENTATION.equals(DIUtils.getPropertyValue(diagram,
                ModelerPropertyConstants.ORIENTATION)))
        {
            portraitBt.setSelection(true);
        }
        else
        {
            landscapeBt.setSelection(true);
        }
    }

    /**
     * Retrieve the available PageFormats from the PreferenceStore
     * 
     * @param store the PreferenceStore
     */
    private void retrieveAvailablePageFormats(IPreferenceStore store)
    {
        StringTokenizer tokenizerFormats = new StringTokenizer(
                store.getString(ModelerPreferenceConstants.P_PAGE_FORMATS),
                ModelerPreferenceConstants.PAGE_FORMATS_DELIMITER);
        int tokenCount = tokenizerFormats.countTokens();
        formats = new ArrayList();
        pageFormatCb.removeAll();
        for (int i = 0; i < tokenCount; i++)
        {
            PageFormat pageFormat = new PageFormat(tokenizerFormats.nextToken());
            formats.add(pageFormat);
            pageFormatCb.add(pageFormat.getName());
        }
    }

    /**
     * Retrieve the available PageMargins from the PreferenceStore
     * 
     * @param store the PreferenceStore
     */
    private void retrieveAvailablePageMargins(IPreferenceStore store)
    {
        StringTokenizer tokenizerMargins = new StringTokenizer(
                store.getString(ModelerPreferenceConstants.P_PAGE_MARGINS),
                ModelerPreferenceConstants.PAGE_MARGINS_DELIMITER);
        int tokenCount = tokenizerMargins.countTokens();
        margins = new ArrayList();
        pageMarginCb.removeAll();
        for (int i = 0; i < tokenCount; i++)
        {
            PageMargin pageMargin = new PageMargin(tokenizerMargins.nextToken());
            margins.add(pageMargin);
            pageMarginCb.add(pageMargin.getName());
        }
    }

    /**
     * Save new values into string variables
     * 
     * @see org.eclipse.jface.dialogs.Dialog#okPressed()
     */
    protected void okPressed()
    {
        this.pageFormatName = pageFormatCb.getText();
        this.pageWidth = pageWidthFd.getText();
        this.pageHeight = pageHeightFd.getText();

        this.pageMarginName = pageMarginCb.getText();
        this.topMargin = topMarginFd.getText();
        this.bottomMargin = bottomMarginFd.getText();
        this.leftMargin = leftMarginFd.getText();
        this.rightMargin = rightMarginFd.getText();

        if (portraitBt.getSelection())
        {
            this.orientation = ModelerPropertyConstants.PORTRAIT_ORIENTATION;
        }
        else
        {
            this.orientation = ModelerPropertyConstants.LANDSCAPE_ORIENTATION;
        }

        super.okPressed();
    }

    /**
     * Return a Map that contain new properties of the diagram
     * 
     * @return Map
     */
    public Map getNewDiagramProperties()
    {
        Map params = new HashMap();

        params.put(ModelerPropertyConstants.PAGE_FORMAT_NAME, pageFormatName);
        params.put(ModelerPropertyConstants.PAGE_WIDTH, pageWidth);
        params.put(ModelerPropertyConstants.PAGE_HEIGHT, pageHeight);
        params.put(ModelerPropertyConstants.PAGE_MARGIN_NAME, pageMarginName);
        params.put(ModelerPropertyConstants.TOP_MARGIN, topMargin);
        params.put(ModelerPropertyConstants.BOTTOM_MARGIN, bottomMargin);
        params.put(ModelerPropertyConstants.LEFT_MARGIN, leftMargin);
        params.put(ModelerPropertyConstants.RIGHT_MARGIN, rightMargin);
        params.put(ModelerPropertyConstants.ORIENTATION, orientation);

        return params;
    }

}
