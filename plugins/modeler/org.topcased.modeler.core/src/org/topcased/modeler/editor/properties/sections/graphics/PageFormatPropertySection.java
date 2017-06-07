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
import org.topcased.modeler.commands.ChangePageFormatCommand;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.edit.DiagramEditPart;
import org.topcased.modeler.editor.MixedEditDomain;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.preferences.PageFormat;

/**
 * The PageFormat section on the graphics tab.
 * 
 * Creation 27 avril 2006
 * 
 * @author jlescot
 */
public class PageFormatPropertySection extends AbstractGraphicPropertySection
{
    /**
     * The pageFormat type before any modification
     */
    private String initialPageFormat;

    /**
     * The combo box control for the section.
     */
    private CCombo pageFormatCombo;

    /** The text widget for the width property */
    private Text widthTxt;

    /** The text widget for the height property */
    private Text heightTxt;

    /**
     * The List containing all available PageFormat
     */
    private ArrayList<PageFormat> pageFormats;

    /**
     * @see org.topcased.modeler.editor.properties.sections.graphics.AbstractGraphicPropertySection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        FormData data;

        Group group = getWidgetFactory().createGroup(composite, "Format");
        FormLayout layout = new FormLayout();
        layout.marginWidth = ITabbedPropertyConstants.HSPACE;
        layout.marginHeight = ITabbedPropertyConstants.VSPACE;
        layout.spacing = ITabbedPropertyConstants.VMARGIN;
        group.setLayout(layout);

        CLabel pageFormatLabel = getWidgetFactory().createCLabel(group, "Page Format:");

        pageFormatCombo = getWidgetFactory().createCCombo(group, SWT.FLAT | SWT.READ_ONLY | SWT.BORDER);

        pageFormatCombo.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent event)
            {
                handleComboModified();
            }
        });

        CLabel widthLbl = getWidgetFactory().createCLabel(group, "Page Width:");
        widthLbl.setImage(ModelerImageRegistry.getImage("WIDTH"));

        widthTxt = getWidgetFactory().createText(group, "");
        widthTxt.setEnabled(false);

        // The height Label is the larger of the Group, so it will be used to
        // fix the left attachment of other widgets. See code below.
        CLabel heightLbl = getWidgetFactory().createCLabel(group, "Page Height:");
        heightLbl.setImage(ModelerImageRegistry.getImage("HEIGHT"));

        heightTxt = getWidgetFactory().createText(group, "");
        heightTxt.setEnabled(false);

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, 0);
        group.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(pageFormatCombo, -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        pageFormatLabel.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(heightLbl, ITabbedPropertyConstants.HSPACE);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(pageFormatLabel, 0, SWT.CENTER);
        pageFormatCombo.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(pageFormatLabel, ITabbedPropertyConstants.VSPACE);
        widthLbl.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(heightLbl, ITabbedPropertyConstants.HSPACE);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(widthLbl, 0, SWT.CENTER);
        widthTxt.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(widthLbl, 0);
        heightLbl.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(heightLbl, ITabbedPropertyConstants.HSPACE);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(heightLbl, 0, SWT.CENTER);
        heightTxt.setLayoutData(data);

    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    public void refresh()
    {
        super.refresh();

        if (!pageFormatCombo.isDisposed())
        {
            // retrieve the formats from the preferenceStore
            IPreferenceStore store = ModelerPlugin.getDefault().getPreferenceStore();
            retrieveAvailablePageFormats(store);

            // Select the initial pageFormat in the list
            if (getSelectedEditPart() != null && getSelectedEditPart() instanceof DiagramEditPart)
            {
                initialPageFormat = DIUtils.getPropertyValue(
                        (DiagramElement) ((DiagramEditPart) getSelectedEditPart()).getModel(),
                        ModelerPropertyConstants.PAGE_FORMAT_NAME);
                if (initialPageFormat != null)
                {
                    int index = pageFormatCombo.indexOf(initialPageFormat);
                    if (index != -1)
                    {
                        pageFormatCombo.select(index);

                        widthTxt.setText(StringConverter.asString(getSelectedPageFormat().getWidth()));
                        heightTxt.setText(StringConverter.asString(getSelectedPageFormat().getHeight()));
                    }
                }
            }
        }
    }
    
    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (pageFormatCombo != null && !pageFormatCombo.isDisposed())
        {
            pageFormatCombo.setEnabled(enabled);
        }
        if (widthTxt != null && !widthTxt.isDisposed())
        {
            widthTxt.setEnabled(enabled);
        }
        if (heightTxt != null && !heightTxt.isDisposed())
        {
            heightTxt.setEnabled(enabled);
        }
    }

    /**
     * Handle the combo modified event.
     */
    protected void handleComboModified()
    {
        if (!pageFormatCombo.getText().equals(initialPageFormat))
        {
            MixedEditDomain mixedEditDomain = (MixedEditDomain) getPart().getAdapter(MixedEditDomain.class);
            if (getDiagEltList().size() == 1)
            {
                ChangePageFormatCommand command = new ChangePageFormatCommand((Diagram) getDiagElt(),
                        getSelectedPageFormat());
                /* apply the property change to single selected object */
                mixedEditDomain.getCommandStack().execute(command);
            }
            initialPageFormat = pageFormatCombo.getText();

            widthTxt.setText(StringConverter.asString(getSelectedPageFormat().getWidth()));
            heightTxt.setText(StringConverter.asString(getSelectedPageFormat().getHeight()));
        }
    }

    /**
     * Retrieve the available PageFormats from the PreferenceStore
     * 
     * @param store the PreferenceStore
     */
    private void retrieveAvailablePageFormats(IPreferenceStore store)
    {
        if (!pageFormatCombo.isDisposed())
        {
            StringTokenizer tokenizerFormats = new StringTokenizer(
                    store.getString(ModelerPreferenceConstants.P_PAGE_FORMATS),
                    ModelerPreferenceConstants.PAGE_FORMATS_DELIMITER);
            int tokenCount = tokenizerFormats.countTokens();
            pageFormats = new ArrayList<PageFormat>();
            pageFormatCombo.removeAll();
            for (int i = 0; i < tokenCount; i++)
            {
                PageFormat pageFormat = new PageFormat(tokenizerFormats.nextToken());
                pageFormats.add(pageFormat);
                pageFormatCombo.add(pageFormat.getName());
            }
        }
    }

    /**
     * Return the PageFormat associated with the item selected in the Combo
     * 
     * @return the corresponding PageFormat
     */
    private PageFormat getSelectedPageFormat()
    {
        String name = pageFormatCombo.getText();
        for (PageFormat pageFormat : pageFormats)
        {
            if (name.equals(pageFormat.getName()))
            {
                return pageFormat;
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
                && ModelerPropertyConstants.PAGE_FORMAT_NAME.equals(((Property) notifier).getKey()))
        {
            refresh();
        }

    }
}
