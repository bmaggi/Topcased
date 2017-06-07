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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.editor.MixedEditDomain;

/**
 * The ForegroundColor section on the graphics tab.
 * 
 * Creation 31 mars 2006
 * 
 * @author jlescot
 */
public class VisibilityPropertySection extends AbstractGraphicPropertySection
{
    private Button visibilityBtn;

    /**
     * @see org.topcased.modeler.editor.properties.sections.graphics.AbstractGraphicPropertySection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        FormData data;

        visibilityBtn = getWidgetFactory().createButton(composite, "Visibility", SWT.CHECK);
        visibilityBtn.addSelectionListener(new SelectionListener()
        {
            public void widgetSelected(SelectionEvent e)
            {
                handleVisibilityChanged();
            }

            public void widgetDefaultSelected(SelectionEvent e)
            {
                // TODO Auto-generated method stub

            }
        });

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(0, 0);
        data.right = new FormAttachment(100, 0);
        visibilityBtn.setLayoutData(data);
    }

    /**
     * Called when the visibility Button changes
     */
    protected void handleVisibilityChanged()
    {
        MixedEditDomain mixedEditDomain = (MixedEditDomain) getPart().getAdapter(MixedEditDomain.class);
        if (getDiagEltList().size() == 1)
        {
            mixedEditDomain.getEMFEditingDomain().getCommandStack().execute(
                    SetCommand.create(mixedEditDomain.getEMFEditingDomain(), getDiagElt(),
                            DiagramInterchangePackage.eINSTANCE.getDiagramElement_Visible(), new Boolean(
                                    visibilityBtn.getSelection())));
        }
        else
        {
            CompoundCommand compoundCommand = new CompoundCommand();
            /* apply the property change to all selected elements */
            for (DiagramElement nextObject : getDiagEltList())
            {
                Command command = SetCommand.create(mixedEditDomain.getEMFEditingDomain(), nextObject,
                        DiagramInterchangePackage.eINSTANCE.getDiagramElement_Visible(), new Boolean(
                                visibilityBtn.getSelection()));
                compoundCommand.append(command);
            }
            mixedEditDomain.getEMFEditingDomain().getCommandStack().execute(compoundCommand);
        }
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    public void refresh()
    {
        super.refresh();

        if (getDiagElt() != null)
        {
            visibilityBtn.setSelection(getDiagElt().isVisible());
        }
    }

    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (visibilityBtn != null)
        {
            visibilityBtn.setEnabled(enabled);
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
            if (msg.getFeatureID(getDiagElt().getClass()) == DiagramInterchangePackage.DIAGRAM_ELEMENT__VISIBLE)
            {
                refresh();
            }
        }
    }
}
