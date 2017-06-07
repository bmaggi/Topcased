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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

/**
 * An abstract property section composed by a label, a text field and a button dedicated to create model objects.
 * 
 * Creation : 16 june 2010<br>
 * 
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 * @since Topcased 4.0.0
 */
public abstract class AbstractStringWithButtonSection extends AbstractStringPropertySection
{

    /**
     * The create Button
     */
    private Button createButton;

    /**
     * Gets the button.
     * 
     * @return The create button
     */
    public Button getButton()
    {
        return createButton;
    }

    /**
     * Handles creation of one or several model objects. Clients must implement this method.
     */
    protected abstract void createModelObject();

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTextPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void createWidgets(Composite composite)
    {
        createButton = getWidgetFactory().createButton(composite, "Create", SWT.PUSH); //$NON-NLS-1$
        createButton.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                createModelObject();

                // reset fields
                createButton.setEnabled(false);
                getText().setEnabled(true);
            }
        });

        super.createWidgets(composite);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTextPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void setSectionData(Composite composite)
    {
        FormData data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(createButton, 0, SWT.CENTER);
        data.right = new FormAttachment(getText().getControl(), -ITabbedPropertyConstants.HSPACE);
        getNameLabel().setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] {getLabelText()}));
        data.right = new FormAttachment(createButton);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        data.bottom = new FormAttachment(100, 0);
        getText().setLayoutData(data);

        data = new FormData();
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, 0);
        createButton.setLayoutData(data);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTextPropertySection#refresh()
     */
    @Override
    public void refresh()
    {
        String text = getFeatureAsString();
        createButton.setEnabled(text == null ? true : false);
        getText().setEnabled(text != null ? true : false);
        getText().setText(text != null ? text : ""); //$NON-NLS-1$
    }

}
