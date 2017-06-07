/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.editor.properties.sections;

import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.editor.properties.TextChangeHelper;
import org.topcased.tabbedproperties.sections.widgets.IText;
import org.topcased.tabbedproperties.sections.widgets.SpellingTextComposite;

/**
 * An abstract implementation of a section with a text field.
 * 
 * @author Jacques LESCOT
 */
public abstract class AbstractTextPropertySection extends AbstractModelerPropertySection
{

    /**
     * The text control for the section.
     */
    protected IText text;

    /**
     * A helper to listen for events that indicate that a text field has been
     * changed.
     */
    protected TextChangeHelper listener;

    /**
     * @see org.topcased.modeler.editor.properties.sections.AbstractModelerPropertySection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        FormData data;
        text = getTextWidget(composite,getStyle());
        data = new FormData();
        data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] {getLabelText()}));
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        text.setLayoutData(data);

        CLabel nameLabel = getWidgetFactory().createCLabel(composite, getLabelText());
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(text.getControl(), -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(text.getControl(), 0, SWT.CENTER);
        nameLabel.setLayoutData(data);

        listener = new TextChangeHelper()
        {
            public void textChanged(Control control)
            {
                handleTextModified();
            }
        };
        listener.startListeningTo(text.getTextControl());
        listener.startListeningForEnter(text.getTextControl());
    }

    /**
     * Returns the text widget, this method can be override to disable spell checking
     * @param parent, the owning composite
     * @param style, the style to apply
     * @return an instance of {@link IText}
     */
    protected IText getTextWidget(Composite parent, int style) {
        return new SpellingTextComposite(parent, style);
    }
    

    /**
     * Handle the text modified event.
     */
    protected void handleTextModified()
    {
        String newText = text.getText();
        boolean equals = isEqual(newText);
        if (!equals)
        {
            EditingDomain editingDomain = (EditingDomain) getPart().getAdapter(EditingDomain.class);
            Object value = getFeatureValue(newText);
            if (eObjectList.size() == 1)
            {
                /* apply the property change to single selected object */
                editingDomain.getCommandStack().execute(SetCommand.create(editingDomain, eObject, getFeature(), value));
            }
            else
            {
                CompoundCommand compoundCommand = new CompoundCommand();
                /* apply the property change to all selected elements */
                for (Iterator i = eObjectList.iterator(); i.hasNext();)
                {
                    EObject nextObject = (EObject) i.next();
                    compoundCommand.append(SetCommand.create(editingDomain, nextObject, getFeature(), value));
                }
                editingDomain.getCommandStack().execute(compoundCommand);
            }
        }
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    public void refresh()
    {
        super.refresh();
        text.setText(getFeatureAsText());
    }
    
    
    
    @Override
    protected void setEnabled(boolean isEnabled)
    {
        super.setEnabled(isEnabled);
        if (text != null)
        {
            text.setEnabled(isEnabled);
        }
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
     * Determine if the provided string value is an equal representation of the
     * current setting of the text property.
     * 
     * @param newText the new string value.
     * @return <code>true</code> if the new string value is equal to the
     *         current property setting.
     */
    protected abstract boolean isEqual(String newText);

    /**
     * Get the feature for the text field for the section.
     * 
     * @return the feature for the text.
     */
    protected abstract EAttribute getFeature();

    /**
     * Get the value of the feature as text for the text field for the section.
     * 
     * @return the value of the feature as text.
     */
    protected abstract String getFeatureAsText();

    /**
     * Get the new value of the feature for the text field for the section.
     * 
     * @param newText the new value of the feature as a string.
     * @return the new value of the feature.
     */
    protected abstract Object getFeatureValue(String newText);

    /**
     * Get the label for the text field for the section.
     * 
     * @return the label for the text field.
     */
    protected abstract String getLabelText();
}