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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.commands.ChangeDiagramElementPropertyCommand;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.edit.DiagramEditPart;
import org.topcased.modeler.editor.IMixedEditDomain;

/**
 * The PageOrientation section on the graphics tab.
 * 
 * Creation 27 avril 2006
 * 
 * @author jlescot
 */
public class PageOrientationPropertySection extends AbstractGraphicPropertySection
{
    /** The button to select the portrait orientation */
    private Button portraitBt;

    /** The button to select the landscape orientation */
    private Button landscapeBt;

    /**
     * @see org.topcased.modeler.editor.properties.sections.graphics.AbstractGraphicPropertySection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        FormData data;

        Group group = getWidgetFactory().createGroup(composite, "");
        FormLayout layout = new FormLayout();
        layout.marginWidth = ITabbedPropertyConstants.HSPACE;
        layout.marginHeight = ITabbedPropertyConstants.VSPACE;
        layout.spacing = ITabbedPropertyConstants.VMARGIN;
        group.setLayout(layout);
        
        CLabel orientationLabel = getWidgetFactory().createCLabel(group, "Orientation:");
        portraitBt = getWidgetFactory().createButton(group, "Portrait", SWT.RADIO);
        landscapeBt = getWidgetFactory().createButton(group, "Landscape", SWT.RADIO);

        portraitBt.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent event)
            {
                handleOrientationChanged();
            }
        });
        
        landscapeBt.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent event)
            {
                handleOrientationChanged();
            }
        });

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, 0);
        group.setLayoutData(data);
        
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(portraitBt, -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        orientationLabel.setLayoutData(data);
        
        data = new FormData();
        data.left = new FormAttachment(orientationLabel, ITabbedPropertyConstants.HSPACE);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        portraitBt.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(orientationLabel, ITabbedPropertyConstants.HSPACE);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(portraitBt, 0);
        landscapeBt.setLayoutData(data);

    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    public void refresh()
    {
        super.refresh();

        if (!portraitBt.isDisposed() && !landscapeBt.isDisposed())
        {
            // Initialize the orientation
            if (getSelectedEditPart() != null && getSelectedEditPart() instanceof DiagramEditPart)
            {
                portraitBt.setSelection(ModelerPropertyConstants.PORTRAIT_ORIENTATION.equals(DIUtils.getPropertyValue((DiagramElement) ((DiagramEditPart) getSelectedEditPart()).getModel(), ModelerPropertyConstants.ORIENTATION)));
                landscapeBt.setSelection(ModelerPropertyConstants.LANDSCAPE_ORIENTATION.equals(DIUtils.getPropertyValue((DiagramElement) ((DiagramEditPart) getSelectedEditPart()).getModel(), ModelerPropertyConstants.ORIENTATION)));
            }
        }
    }
    
    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (landscapeBt != null && !landscapeBt.isDisposed())
        {
            landscapeBt.setEnabled(enabled);
        }
        if (portraitBt != null && !portraitBt.isDisposed())
        {
            portraitBt.setEnabled(enabled);
        }
    }

    /**
     * Handle the button modified event.
     */
    protected void handleOrientationChanged()
    {
//        if (!pageMarginCombo.getText().equals(initialPageMargin))
//        {
            IMixedEditDomain mixedEditDomain = (IMixedEditDomain) getPart().getAdapter(IMixedEditDomain.class);
            if (getDiagEltList().size() == 1)
            {
                ChangeDiagramElementPropertyCommand command = new ChangeDiagramElementPropertyCommand(getDiagElt(), ModelerPropertyConstants.ORIENTATION, portraitBt.getSelection() ? ModelerPropertyConstants.PORTRAIT_ORIENTATION : ModelerPropertyConstants.LANDSCAPE_ORIENTATION);
                /* apply the property change to single selected object */
                mixedEditDomain.getGEFCommandStack().execute(command);
            }
//            initialPageMargin = pageMarginCombo.getText();
//        }
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
        if (notifier instanceof Property && ModelerPropertyConstants.ORIENTATION.equals(((Property) notifier).getKey()))
        {
               refresh();
        }
    }

}
