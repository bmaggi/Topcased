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

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.commands.ChangeDiagramElementPropertyCommand;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.edit.GraphEdgeEditPart;
import org.topcased.modeler.edit.GraphNodeEditPart;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.utils.Utils;

/**
 * The Font section on the graphics tab.
 * 
 * Creation 31 mars 2006
 * 
 * @author jlescot
 */
public class FontPropertySection extends AbstractGraphicPropertySection
{
    /**
     * The fontdata before any modification
     */
    private FontData initialFData;

    private Text fontText;

    private Button fontButton;

    /**
     * @see org.topcased.modeler.editor.properties.sections.graphics.AbstractGraphicPropertySection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        FormData data;

        CLabel fontLabel = getWidgetFactory().createCLabel(composite, "Font:");

        fontText = getWidgetFactory().createText(composite, "");
        fontText.setEditable(false);

        fontButton = getWidgetFactory().createButton(composite, "Change...", SWT.PUSH);

        fontButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent event)
            {
                handleButtonPressed();
            }
        });

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(fontText, -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        fontLabel.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(fontButton, -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        fontText.setLayoutData(data);

        data = new FormData();
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(fontLabel, ITabbedPropertyConstants.VSPACE, SWT.CENTER);
        fontButton.setLayoutData(data);

    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    public void refresh()
    {
        super.refresh();

        if (Utils.getFont(getDiagElt()) != null)
        {
            initialFData = Utils.getFont(getDiagElt()).getFontData()[0];
        }
        else if(getSelectedEditPart() instanceof GraphNodeEditPart)
        {
        	initialFData = ((GraphNodeEditPart)getSelectedEditPart()).getEditPartDefaultFont().getFontData()[0];
        } 
        else if(getSelectedEditPart() instanceof GraphEdgeEditPart)
        {
        	initialFData = ((GraphEdgeEditPart)getSelectedEditPart()).getEditPartDefaultFont().getFontData()[0];
        }
        else if (getSelectedEditPart() instanceof AbstractGraphicalEditPart)
        {
            IFigure figure =  ((AbstractGraphicalEditPart) getSelectedEditPart()).getFigure();
            if(figure.getFont() != null)
            {
                initialFData = figure.getFont().getFontData()[0];
            }
        }
        if(initialFData!=null)
        {
            fontText.setText(StringConverter.asString(initialFData));
        }
    }
    
    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (fontText != null)
        {
            fontText.setEnabled(enabled);
        }
        if (fontButton != null)
        {
            fontButton.setEnabled(enabled);
        }
    }

    /**
     * Handle the button pressed event.
     */
    protected void handleButtonPressed()
    {
        FontDialog ftDialog = new FontDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
        ftDialog.setFontList(new FontData[] {initialFData});
        FontData fData = ftDialog.open();

        if (fData != null && fData != initialFData)
        {
            IMixedEditDomain mixedEditDomain = (IMixedEditDomain) getPart().getAdapter(IMixedEditDomain.class);
            initialFData = fData;
            if (getDiagEltList().size() == 1)
            {
                ChangeDiagramElementPropertyCommand command = new ChangeDiagramElementPropertyCommand(getDiagElt(),
                        ModelerPropertyConstants.FONT, StringConverter.asString(fData));
                /* apply the property change to single selected object */
                mixedEditDomain.getGEFCommandStack().execute(command);
            }
            else
            {
                CompoundCommand compoundCommand = new CompoundCommand();
                /* apply the property change to all selected elements */
                for (DiagramElement nextObject : getDiagEltList())
                {
                    ChangeDiagramElementPropertyCommand command = new ChangeDiagramElementPropertyCommand(nextObject,
                            ModelerPropertyConstants.FONT, StringConverter.asString(fData));
                    compoundCommand.add(command);
                }
                mixedEditDomain.getGEFCommandStack().execute(compoundCommand);
            }

            fontText.setText(StringConverter.asString(initialFData));
        }

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
        if (notifier instanceof Property && ModelerPropertyConstants.FONT.equals(((Property) notifier).getKey()))
        {
            refresh();
        }
//        refresh();
    }
}
