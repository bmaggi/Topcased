/***********************************************************************
 * Copyright (c) 2006, 2008 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Thibault Landré (Atos Origin) - modify refresh()
 **********************************************************************/
package org.topcased.modeler.editor.properties.sections.graphics;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.commands.ChangeDiagramElementPropertyCommand;
import org.topcased.modeler.di.model.DiagramElement;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.editor.IMixedEditDomain;

/**
 * The ForegroundColor section on the graphics tab.
 * 
 * Creation 31 mars 2006
 * 
 * @author Jacques LESCOT
 */
public class ForegroundColorPropertySection extends AbstractGraphicPropertySection
{
    private ColorSelector colorSelector;

    /**
     * @see org.topcased.modeler.editor.properties.sections.graphics.AbstractGraphicPropertySection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
    {
        super.createControls(parent, tabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        FormData data;

        CLabel colorLabel = getWidgetFactory().createCLabel(composite, "Foreground Color:");
        Composite compositeColorSelector = getWidgetFactory().createFlatFormComposite(composite);
        colorSelector = new ColorSelector(compositeColorSelector);
        colorSelector.addListener(new IPropertyChangeListener()
        {
            public void propertyChange(PropertyChangeEvent event)
            {
                handleColorChanged();
            }
        });

        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.top = new FormAttachment(0, 0);
        data.right = new FormAttachment(compositeColorSelector, -ITabbedPropertyConstants.HSPACE);
        colorLabel.setLayoutData(data);

        data = new FormData();
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(colorLabel, 0, SWT.CENTER);
        data.left = new FormAttachment(colorLabel, ITabbedPropertyConstants.HSPACE);
        compositeColorSelector.setLayoutData(data);
    }

    /**
     * Called when the selected color changes
     */
    protected void handleColorChanged()
    {
        RGB newColor = colorSelector.getColorValue();
        if (newColor != null)
        {
            IMixedEditDomain mixedEditDomain = (IMixedEditDomain) getPart().getAdapter(IMixedEditDomain.class);
            if (getDiagEltList().size() == 1)
            {
                ChangeDiagramElementPropertyCommand command = new ChangeDiagramElementPropertyCommand(getDiagElt(), ModelerPropertyConstants.FOREGROUND_COLOR, StringConverter.asString(newColor));
                /* apply the property change to single selected object */
                mixedEditDomain.getGEFCommandStack().execute(command);
            }
            else
            {
                CompoundCommand compoundCommand = new CompoundCommand();
                /* apply the property change to all selected elements */
                for (DiagramElement nextObject : getDiagEltList())
                {
                    ChangeDiagramElementPropertyCommand command = new ChangeDiagramElementPropertyCommand(nextObject, ModelerPropertyConstants.FOREGROUND_COLOR, StringConverter.asString(colorSelector.getColorValue()));
                    compoundCommand.add(command);
                }
                mixedEditDomain.getGEFCommandStack().execute(compoundCommand);
            }
        }
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    public void refresh()
    {
        super.refresh();

        if (getSelectedEditPart() != null && getSelectedEditPart() instanceof AbstractGraphicalEditPart)
        {
        	// Check if the button is not disposed
        	if(!colorSelector.getButton().isDisposed())
        	{
        		colorSelector.setColorValue(((AbstractGraphicalEditPart) getSelectedEditPart()).getFigure().getForegroundColor().getRGB());
    		}
        }
    }

    @Override
    protected void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (colorSelector != null)
        {
            colorSelector.setEnabled(enabled);
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
        if (notifier instanceof Property && ModelerPropertyConstants.FOREGROUND_COLOR.equals(((Property) notifier).getKey()))
        {
               refresh();
        }
    }
}
