/*******************************************************************************
 * Copyright (c) 2005-2008 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 * Thibault Landré (Atos Origin) - Implemented FR1026
 ******************************************************************************/
package org.topcased.modeler.editor.properties.sections.graphics;

import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.commands.ChangeDiagramElementPropertyCommand;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.editor.MixedEditDomain;
import org.topcased.tabbedproperties.sections.AbstractTextPropertySection;
import org.topcased.tabbedproperties.utils.TextChangeListener;

/**
 * The Size section on the graphics tab.
 * 
 * Creation 31 mars 2006
 * 
 * @author jlescot
 */
public class NoteValuePropertySection extends AbstractGraphicPropertySection
{
    private Text valueTxt;

    /** A helper to listen for events that indicate that a text field has been changed. */
    private TextChangeListener listener;
    
    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        
        FormData data = new FormData();
        
        CLabel valueLbl = getWidgetFactory().createCLabel(composite, "Value:");
        valueTxt = getWidgetFactory().createText(composite, "", SWT.MULTI | SWT.WRAP);
        
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        data.bottom = new FormAttachment(100, 0);
        valueTxt.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(valueTxt, -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(valueTxt, 0, SWT.TOP);
        valueLbl.setLayoutData(data);

        hookListeners();
//        valueTxt.addSelectionListener(new SelectionAdapter()
//        {
//            public void widgetDefaultSelected(SelectionEvent e)
//            {
//                handleTextModified();
//            }
//        });
    }

    protected void hookListeners()
    {
        listener = new TextChangeListener()
        {
            public void textChanged(Control control)
            {
                handleTextModified();
            }

            /**
             * @see org.topcased.tabbedproperties.utils.TextChangeListener#focusIn(org.eclipse.swt.widgets.Control)
             */
            public void focusIn(Control control)
            {
                // Do nothing
            }

            /**
             * @see org.topcased.tabbedproperties.utils.TextChangeListener#focusOut(org.eclipse.swt.widgets.Control)
             */
            public void focusOut(Control control)
            {
                // Do nothing
            }
        };
        listener.startListeningTo(valueTxt);

        valueTxt.addListener(SWT.Modify, new Listener()
        {
            public void handleEvent(Event e)
            {
                // Do nothing
            }
        });
    }

    /**
     * Called when the selected color changes
     */
    protected void handleTextModified()
    {
        String newValue = valueTxt.getText();
        if (newValue != null)
        {
            MixedEditDomain mixedEditDomain = (MixedEditDomain) getPart().getAdapter(MixedEditDomain.class);
            if (getDiagEltList().size() == 1)
            {
                ChangeDiagramElementPropertyCommand command = new ChangeDiagramElementPropertyCommand(getDiagElt(),
                        ModelerPropertyConstants.NOTE_VALUE, newValue);
                /* apply the property change to single selected object */
                mixedEditDomain.getCommandStack().execute(command);
            }
            else
            {
                CompoundCommand compoundCommand = new CompoundCommand();
                /* apply the property change to all selected elements */
                for (DiagramElement nextObject : getDiagEltList())
                {
                    ChangeDiagramElementPropertyCommand command = new ChangeDiagramElementPropertyCommand(nextObject,
                            ModelerPropertyConstants.NOTE_VALUE, newValue);
                    compoundCommand.add(command);
                }
                mixedEditDomain.getCommandStack().execute(compoundCommand);
            }
        }
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    public void refresh()
    {
        if (getDiagElt() != null && getDiagElt() instanceof GraphNode)
        {
            GraphNode graphNode = (GraphNode) getDiagElt();

            // Check if the button is not disposed
            if (!valueTxt.isDisposed())
            {
                valueTxt.setText(DIUtils.getPropertyValue(graphNode, ModelerPropertyConstants.NOTE_VALUE));
            }
        }
    }
    
    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (valueTxt != null)
        {
            valueTxt.setEnabled(enabled);
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
        if (notifier instanceof Property && ModelerPropertyConstants.NOTE_VALUE.equals(((Property) notifier).getKey()))
        {
            refresh();
        }
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
     */
    public boolean shouldUseExtraSpace()
    {
        return true;
    }
}