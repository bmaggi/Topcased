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

import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.RouterConstants;
import org.topcased.modeler.commands.ChangeRouterCommand;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.GraphEdge;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.editor.MixedEditDomain;

/**
 * The Router section on the graphics tab.
 * 
 * Creation 03 avril 2006
 * 
 * @author jlescot
 */
public class RouterPropertySection extends AbstractGraphicPropertySection
{
    /**
     * The router type before any modification
     */
    private String initialRouter;

    /**
     * The combo box control for the section.
     */
    private CCombo routerCombo;

    /**
     * @see org.topcased.modeler.editor.properties.sections.graphics.AbstractGraphicPropertySection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        FormData data;

        CLabel routerLabel = getWidgetFactory().createCLabel(composite, "Router:");

        routerCombo = getWidgetFactory().createCCombo(composite, SWT.FLAT | SWT.READ_ONLY | SWT.BORDER);

        routerCombo.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent event)
            {
                handleComboModified();
            }
        });

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(routerCombo, -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        routerLabel.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        routerCombo.setLayoutData(data);

    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    public void refresh()
    {
        super.refresh();
        if (!routerCombo.isDisposed())
        {
            // Initialize the available routers
            routerCombo.setItems(new String[] {RouterConstants.FOREST, RouterConstants.OBLIQUE,
                    RouterConstants.RECTILINEAR});

            // Select the initial router in the list
            if (getSelectedEditPart() != null && getSelectedEditPart() instanceof AbstractConnectionEditPart)
            {
                ConnectionRouter router = ((AbstractConnectionEditPart) getSelectedEditPart()).getConnectionFigure().getConnectionRouter();
                initialRouter = RouterConstants.getRouterName(router);
                if (initialRouter != null)
                {
                    int index = routerCombo.indexOf(initialRouter);
                    if (index != -1)
                    {
                        routerCombo.select(index);
                    }
                }
            }
        }
    }
    
    

    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (routerCombo != null)
        {
            routerCombo.setEnabled(enabled);
        }
    }

    /**
     * Handle the combo modified event.
     */
    protected void handleComboModified()
    {
        if (!routerCombo.getText().equals(initialRouter))
        {
            MixedEditDomain mixedEditDomain = (MixedEditDomain) getPart().getAdapter(MixedEditDomain.class);
            if (getDiagEltList().size() == 1)
            {
                ChangeRouterCommand command = new ChangeRouterCommand((GraphEdge) getDiagElt(), routerCombo.getText());
                /* apply the property change to single selected object */
                mixedEditDomain.getCommandStack().execute(command);
            }
            else
            {
                CompoundCommand compoundCommand = new CompoundCommand();
                /* apply the property change to all selected elements */
                for (DiagramElement nextObject : getDiagEltList())
                {
                    ChangeRouterCommand command = new ChangeRouterCommand((GraphEdge) nextObject, routerCombo.getText());
                    compoundCommand.add(command);
                }
                mixedEditDomain.getCommandStack().execute(compoundCommand);
            }
            initialRouter = routerCombo.getText();
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
        if (notifier instanceof Property && ModelerPropertyConstants.ROUTER.equals(((Property) notifier).getKey()))
        {
            refresh();
        }
    }
}
