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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.di.model.GraphElement;

/**
 * The Position section on the graphics tab.
 * 
 * Creation 31 mars 2006
 * 
 * @author jlescot
 */
public class PositionPropertySection extends AbstractPropertySection implements PropertyChangeListener
{
    private Text xPos;

    private Text yPos;

    private GraphElement graphElement;

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#setInput(org.eclipse.ui.IWorkbenchPart,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void setInput(IWorkbenchPart part, ISelection selection)
    {
        super.setInput(part, selection);
        Assert.isTrue(selection instanceof IStructuredSelection);
        Object input = ((IStructuredSelection) selection).getFirstElement();
        if (input instanceof EditPart)
        {
            input = ((EditPart) input).getModel();
        }
        if (input instanceof GraphElement)
        {
            this.graphElement = (GraphElement) input;
        }
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        FormData data;

        // The XPosition of the GraphElement
        CLabel xLabel = getWidgetFactory().createCLabel(composite, "XPos:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        xLabel.setLayoutData(data);

        xPos = getWidgetFactory().createText(composite, "");
        xPos.setEnabled(false);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        data.right = new FormAttachment(50, -ITabbedPropertyConstants.HSPACE);
        xPos.setLayoutData(data);

        // The YPosition of the GraphElement
        CLabel yLabel = getWidgetFactory().createCLabel(composite, "YPos:");
        data = new FormData();
        data.left = new FormAttachment(50, ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        yLabel.setLayoutData(data);

        yPos = getWidgetFactory().createText(composite, "");
        yPos.setEnabled(false);
        data = new FormData();
        data.left = new FormAttachment(50, STANDARD_LABEL_WIDTH);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        data.right = new FormAttachment(100, 0);
        yPos.setLayoutData(data);
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    public void refresh()
    {
        if (getElement() != null && getElement().getPosition() != null)
        {
            xPos.setText(String.valueOf(getElement().getPosition().x));
            yPos.setText(String.valueOf(getElement().getPosition().y));
        }
    }

    /**
     * Get the element.
     * 
     * @return the element.
     */
    public GraphElement getElement()
    {
        return graphElement;
    }

    /**
     * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
     */
    public void propertyChange(PropertyChangeEvent evt)
    {
        refresh();
    }
}