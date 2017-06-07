/*******************************************************************************
 * Copyright (c) 2006 ANYWARE TECHNOLOGIES. All rights reserved. 
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 *               implementation
 *               Jose Alfredo Serrano (Anyware Technologies) - updated API
 ******************************************************************************/
package org.topcased.tabbedproperties.sections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.topcased.tabbedproperties.sections.widgets.IText;
import org.topcased.tabbedproperties.sections.widgets.SpellingTextComposite;
import org.topcased.tabbedproperties.utils.TextChangeListener;

/**
 * An abstract implementation of a section with a text field.<br>
 * 
 * Creation 5 apr. 2006<br>
 * Updated : 7 august 2006<br>
 * 
 * @author Jacques LESCOT
 * @author Alfredo SERRANO
 */
public abstract class AbstractTextPropertySection extends AbstractTabbedPropertySection
{
    /** The text control for the section. */
    private IText text;

    /** The label used with to identify the Section */
    private CLabel nameLabel;

    /** A helper to listen for events that indicate that a text field has been changed. */
    private TextChangeListener listener;

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
     */
    protected void createWidgets(Composite composite)
    {
        text = getTextWidget(composite,getStyle());

        if (getFeature() != null)
        {
            boolean isChangeable = getFeature().isChangeable();

            text.setEditable(isChangeable);
            text.setEnabled(isChangeable);
        }

        nameLabel = getWidgetFactory().createCLabel(composite, getLabelText());

    }

    /**
     * Returns the text widget, this method can be override to disable spell checking
     * @param parent, the owning composite
     * @param style, the style to apply
     * @return an instance of {@link IText}
     */
    public IText getTextWidget(Composite parent, int style) {
		return new SpellingTextComposite(parent, style);
	}

	/**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
     */
    protected void setSectionData(Composite composite)
    {
        FormData data = new FormData();
        data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] {getLabelText()}));
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        data.bottom = new FormAttachment(100, 0);
        text.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(text.getControl(), -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(text.getControl(), 0, SWT.TOP);
        nameLabel.setLayoutData(data);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#hookListeners()
     */
    protected void hookListeners()
    {
        listener = new TextChangeListener()
        {
            public void textChanged(Control control)
            {
                handleTextModified();
            }

            public void focusIn(Control control)
            {
                AbstractTextPropertySection.this.focusIn();
            }

            public void focusOut(Control control)
            {
                AbstractTextPropertySection.this.focusOut();
            }
        };
        listener.startListeningTo(text.getTextControl());

        // Do not listen to the "Enter" key pressed when the widget is a
        // MultiLine Text
        if ((getStyle() & SWT.MULTI) == 0)
        {
            listener.startListeningForEnter(text.getTextControl());
        }
        text.getTextControl().addListener(SWT.Modify, new Listener()
        {
            public void handleEvent(Event e)
            {
                verifyField(e);
            }
        });
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    public void refresh()
    {
        super.refresh();
        getText().setText(getFeatureAsString());
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#setEnabled(boolean)
     */
    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (getText() != null)
        {
            getText().setEnabled(enabled);
        }
    }

    /**
     * Handle the text modified event. When there is any problem while creating and executing the command, the view will
     * be only refreshed
     */
    protected void handleTextModified()
    {
        if (isTextValid())
        {
            createCommand(getOldFeatureValue(), getNewFeatureValue(getText().getText()));
        }
        else
        {
            refresh();
        }
    }

    /**
     * Handle action when the focus is gained Default action is to do nothing. Clients may override this method if they
     * desire a particular action to be executed when the text control gain the focus.
     */
    protected void focusIn()
    {
        // Do nothing
    }

    /**
     * Handle action when the focus is lost. Default action is to do nothing. Clients may override this method if they
     * desire a particular action to be executed when the text control lost the focus.
     */
    protected void focusOut()
    {
        // Do nothing
    }

    /**
     * Get the style of the text widget. By default, this is a single line text
     * 
     * @return the style
     */
    protected int getStyle()
    {
        return SWT.SINGLE;
    }

    /**
     * @return the listener
     */
    protected TextChangeListener getListener()
    {
        return listener;
    }

    /**
     * @return the text
     */
    protected IText getText()
    {
        return text;
    }

    /**
     * @return the nameLabel
     */
    public CLabel getNameLabel()
    {
        return nameLabel;
    }

    /**
     * Check whether the text entered is valid or not. Subclasses should override this method to provide their own
     * check. By default, return true.
     * 
     * @return true if the text entered is valid
     */
    protected boolean isTextValid()
    {
        return true;
    }

    /**
     * Get the value of the feature as text for the text field for the section.
     * 
     * @return the value of the feature as text.
     */
    protected abstract String getFeatureAsString();

    /**
     * Get the new value of the feature from the text field of the section.
     * 
     * @param newText the new value of the feature as a string.
     * @return the new value of the feature.
     */
    protected abstract Object getNewFeatureValue(String newText);

    /**
     * Returns the feature value from the model as an object type.
     * 
     * @return the feature object
     */
    protected abstract Object getOldFeatureValue();

    /**
     * Subclasses may provide their own checker on the text that is entered by the user and update the 'doit' flag of
     * the Event in consequence.
     * 
     * @param e the Event that is sent when the Text is modified
     */
    protected abstract void verifyField(Event e);

}