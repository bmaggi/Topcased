/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.properties.sections.graphics;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.commands.ChangePageMarginCommand;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.edit.DiagramEditPart;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.preferences.PageMargin;

/**
 * The PageMargin section on the graphics tab.
 * 
 * Creation 27 avril 2006
 * 
 * @author jlescot
 */
public class PageMarginPropertySection extends AbstractGraphicPropertySection
{
    /**
     * The pageMargin type before any modification
     */
    private String initialPageMargin;

    /**
     * The combo box control for the section.
     */
    private CCombo pageMarginCombo;

    /** The text widget for the leftMargin property */
    private Text leftMarginTxt;

    /** The text widget for the topMargin property */
    private Text topMarginTxt;

    /** The text widget for the rightMargin property */
    private Text rightMarginTxt;

    /** The text widget for the bottomMargin property */
    private Text bottomMarginTxt;

    /**
     * The List containing all available PageMargin
     */
    private ArrayList<PageMargin> pageMargins;

    /**
     * @see org.topcased.modeler.editor.properties.sections.graphics.AbstractGraphicPropertySection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        FormData data;

        Group group = getWidgetFactory().createGroup(composite, "Margin");
        FormLayout layout = new FormLayout();
        layout.marginWidth = ITabbedPropertyConstants.HSPACE;
        layout.marginHeight = ITabbedPropertyConstants.VSPACE;
        layout.spacing = ITabbedPropertyConstants.VMARGIN;
        group.setLayout(layout);

        CLabel pageMarginLabel = getWidgetFactory().createCLabel(group, "Page Margin:");

        pageMarginCombo = getWidgetFactory().createCCombo(group, SWT.FLAT | SWT.READ_ONLY | SWT.BORDER);

        pageMarginCombo.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent event)
            {
                handleComboModified();
            }
        });

        CLabel leftMarginLbl = getWidgetFactory().createCLabel(group, "Left Margin:");
        leftMarginLbl.setImage(ModelerImageRegistry.getImage("LEFTMARGIN"));

        leftMarginTxt = getWidgetFactory().createText(group, "");
        leftMarginTxt.setEnabled(false);

        CLabel topMarginLbl = getWidgetFactory().createCLabel(group, "Top Margin:");
        topMarginLbl.setImage(ModelerImageRegistry.getImage("TOPMARGIN"));

        topMarginTxt = getWidgetFactory().createText(group, "");
        topMarginTxt.setEnabled(false);

        CLabel rightMarginLbl = getWidgetFactory().createCLabel(group, "Right Margin:");
        rightMarginLbl.setImage(ModelerImageRegistry.getImage("RIGHTMARGIN"));

        rightMarginTxt = getWidgetFactory().createText(group, "");
        rightMarginTxt.setEnabled(false);

        // The bottomMargin Label is the larger of the Group, so it will be used
        // to fix the left attachment of other widgets. See code below.
        CLabel bottomMarginLbl = getWidgetFactory().createCLabel(group, "Bottom Margin:");
        bottomMarginLbl.setImage(ModelerImageRegistry.getImage("BOTTOMMARGIN"));

        bottomMarginTxt = getWidgetFactory().createText(group, "");
        bottomMarginTxt.setEnabled(false);

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, 0);
        group.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(pageMarginCombo, -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        pageMarginLabel.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(bottomMarginLbl, ITabbedPropertyConstants.HSPACE);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(pageMarginLabel, 0, SWT.CENTER);
        pageMarginCombo.setLayoutData(data);

        // -----------------------------------------------
        // Add the widgets that display the margin values

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(pageMarginLabel, ITabbedPropertyConstants.VSPACE);
        leftMarginLbl.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(bottomMarginLbl, ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(leftMarginLbl, 0, SWT.CENTER);
        data.right = new FormAttachment(100, 0);
        leftMarginTxt.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(leftMarginLbl, ITabbedPropertyConstants.VSPACE);
        topMarginLbl.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(bottomMarginLbl, ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(topMarginLbl, 0, SWT.CENTER);
        data.right = new FormAttachment(100, 0);
        topMarginTxt.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(topMarginLbl, ITabbedPropertyConstants.VSPACE);
        rightMarginLbl.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(bottomMarginLbl, ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(rightMarginLbl, 0, SWT.CENTER);
        data.right = new FormAttachment(100, 0);
        rightMarginTxt.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(rightMarginLbl, ITabbedPropertyConstants.VSPACE);
        bottomMarginLbl.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(bottomMarginLbl, ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(bottomMarginLbl, 0, SWT.CENTER);
        data.right = new FormAttachment(100, 0);
        bottomMarginTxt.setLayoutData(data);

        //
        // ------------------------------------------------
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    public void refresh()
    {
        super.refresh();

        if (!pageMarginCombo.isDisposed())
        {
            // retrieve the margins from the preferenceStore
            IPreferenceStore store = ModelerPlugin.getDefault().getPreferenceStore();
            retrieveAvailablePageMargins(store);

            // Select the initial pageMargin in the list
            if (getSelectedEditPart() != null && getSelectedEditPart() instanceof DiagramEditPart)
            {
                initialPageMargin = DIUtils.getPropertyValue(
                        (DiagramElement) ((DiagramEditPart) getSelectedEditPart()).getModel(),
                        ModelerPropertyConstants.PAGE_MARGIN_NAME);
                if (initialPageMargin != null)
                {
                    int index = pageMarginCombo.indexOf(initialPageMargin);
                    if (index != -1)
                    {
                        pageMarginCombo.select(index);

                        leftMarginTxt.setText(StringConverter.asString(getSelectedPageMargin().getLeft()));
                        topMarginTxt.setText(StringConverter.asString(getSelectedPageMargin().getTop()));
                        rightMarginTxt.setText(StringConverter.asString(getSelectedPageMargin().getRight()));
                        bottomMarginTxt.setText(StringConverter.asString(getSelectedPageMargin().getBottom()));
                    }
                }
            }
        }
    }
    
    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (bottomMarginTxt != null && !bottomMarginTxt.isDisposed())
        {
            bottomMarginTxt.setEnabled(enabled);
        }
        if (leftMarginTxt != null && !leftMarginTxt.isDisposed())
        {
            leftMarginTxt.setEnabled(enabled);
        }
        if (pageMarginCombo != null && !pageMarginCombo.isDisposed())
        {
            pageMarginCombo.setEnabled(enabled);
        }
        if (rightMarginTxt != null && !rightMarginTxt.isDisposed())
        {
            rightMarginTxt.setEnabled(enabled);
        }
        if (topMarginTxt != null && !topMarginTxt.isDisposed())
        {
            topMarginTxt.setEnabled(enabled);
        }
    }

    /**
     * Handle the combo modified event.
     */
    protected void handleComboModified()
    {
        if (!pageMarginCombo.getText().equals(initialPageMargin))
        {
            IMixedEditDomain mixedEditDomain = (IMixedEditDomain) getPart().getAdapter(IMixedEditDomain.class);
            if (getDiagEltList().size() == 1)
            {
                ChangePageMarginCommand command = new ChangePageMarginCommand((Diagram) getDiagElt(),
                        getSelectedPageMargin());
                /* apply the property change to single selected object */
                mixedEditDomain.getGEFCommandStack().execute(command);
            }
            initialPageMargin = pageMarginCombo.getText();

            leftMarginTxt.setText(StringConverter.asString(getSelectedPageMargin().getLeft()));
            topMarginTxt.setText(StringConverter.asString(getSelectedPageMargin().getTop()));
            rightMarginTxt.setText(StringConverter.asString(getSelectedPageMargin().getRight()));
            bottomMarginTxt.setText(StringConverter.asString(getSelectedPageMargin().getBottom()));
        }
    }

    /**
     * Retrieve the available PageMargins from the PreferenceStore
     * 
     * @param store the PreferenceStore
     */
    private void retrieveAvailablePageMargins(IPreferenceStore store)
    {
        if (!pageMarginCombo.isDisposed())
        {
            StringTokenizer tokenizerFormats = new StringTokenizer(
                    store.getString(ModelerPreferenceConstants.P_PAGE_MARGINS),
                    ModelerPreferenceConstants.PAGE_MARGINS_DELIMITER);
            int tokenCount = tokenizerFormats.countTokens();
            pageMargins = new ArrayList<PageMargin>();
            pageMarginCombo.removeAll();
            for (int i = 0; i < tokenCount; i++)
            {
                PageMargin pageMargin = new PageMargin(tokenizerFormats.nextToken());
                pageMargins.add(pageMargin);
                pageMarginCombo.add(pageMargin.getName());
            }
        }
    }

    /**
     * Return the PageMargin associated with the item selected in the Combo
     * 
     * @return the corresponding PageMargin
     */
    private PageMargin getSelectedPageMargin()
    {
        String name = pageMarginCombo.getText();
        for (PageMargin pageMargin : pageMargins)
        {
            if (name.equals(pageMargin.getName()))
            {
                return pageMargin;
            }
        }
        return null;
    }

    /**
     * @see org.topcased.modeler.editor.properties.sections.graphics.AbstractGraphicPropertySection#handleModelChanged(org.eclipse.emf.common.notify.Notification)
     */
    protected void handleModelChanged(Notification msg)
    {
        Object notifier = msg.getNotifier();
        if (notifier.equals(getDiagElt()))
        {
            if (msg.getFeatureID(getDiagElt().getClass()) == DiagramInterchangePackage.DIAGRAM_ELEMENT__PROPERTY)
            {
                refresh();
            }
        }
        if (notifier instanceof Property
                && ModelerPropertyConstants.PAGE_MARGIN_NAME.equals(((Property) notifier).getKey()))
        {
            refresh();
        }

    }
}
