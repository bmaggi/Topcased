/***********************************************************************************************************************
 * Copyright (c) 2010 Communication & Systems.
 * 
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Sebastien GABEL (CS) - initial API and implementation
 * 
 **********************************************************************************************************************/
package org.topcased.tabbedproperties.sections;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

/**
 * An abstract property section composed by a label and one or several radio buttons.<br>
 * 
 * Creation : 20 may 2010<br>
 * 
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 * @since Topcased 4.0.0
 */
public abstract class AbstractRadioButtonPropertySection extends AbstractTabbedPropertySection
{

    /** The label */
    private CLabel nameLabel;

    /** The control on which buttons will be positioned */
    private Composite compositeForBtns;

    /** A collection gathering buttons to present on the UI */
    private Collection<Button> buttons;

    /**
     * Constructor
     */
    public AbstractRadioButtonPropertySection()
    {
        buttons = new ArrayList<Button>();
    }

    /**
     * Gets the label
     * 
     * @return the nameLabel
     */
    public CLabel getNameLabel()
    {
        return nameLabel;
    }

    /**
     * Gets all the buttons added into this UI.
     * 
     * @return The collection of buttons
     */
    public Collection<Button> getButtons()
    {
        return buttons;
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#setInput(org.eclipse.ui.IWorkbenchPart,
     *      org.eclipse.jface.viewers.ISelection)
     */
    @Override
    public void setInput(IWorkbenchPart part, ISelection selection)
    {
        super.setInput(part, selection);
        setInitialState();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void createWidgets(Composite parent)
    {
        compositeForBtns = getWidgetFactory().createComposite(parent);
        compositeForBtns.setLayout(new GridLayout(getButtonLabels().length, true));

        Button btn = null;
        for (int i = 0; i < getButtonLabels().length; i++)
        {
            btn = getWidgetFactory().createButton(compositeForBtns, getButtonLabels()[i], SWT.RADIO);
            btn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
            buttons.add(btn);
        }
        nameLabel = getWidgetFactory().createCLabel(parent, getLabelText());
    }

    /**
     * Gets the button according to its label.
     * 
     * @param label The label required to search the button.
     * @return The button
     */
    public Button getButton(String label)
    {
        assert label != null;
        for (Button b : buttons)
        {
            if (label.equalsIgnoreCase(b.getText()))
            {
                return b;
            }
        }
        return null;
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#hookListeners()
     */
    @Override
    protected void hookListeners()
    {
        for (Button b : buttons)
        {
            b.addSelectionListener(createSelectionListener());
        }
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractListPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void setSectionData(Composite composite)
    {
        FormData data = new FormData();
        data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] {getLabelText()}));
        data.right = new FormAttachment(100, 0);
        compositeForBtns.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(compositeForBtns, -ITabbedPropertyConstants.HSPACE);
        nameLabel.setLayoutData(data);
    }

    /**
     * Creates and returns the selection listener to install on each button of this component.
     * 
     * @return The newly created selection listener
     */
    protected abstract SelectionListener createSelectionListener();

    /**
     * Gets the radio button labels.
     * 
     * @return The labels of each radio button to create to this widget.
     */
    protected abstract String[] getButtonLabels();

    /**
     * Sets the initial state on one of the button defined. Clients must implement this method.
     */
    protected abstract void setInitialState();

}
