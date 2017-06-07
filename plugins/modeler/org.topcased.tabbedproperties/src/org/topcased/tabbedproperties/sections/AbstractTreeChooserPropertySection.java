/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thibault Landre (Atos Origin) thibault.landre@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.tabbedproperties.sections;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.topcased.tabbedproperties.sections.widgets.TreeChooser;

/**
 * An abstract property section which proposes a treechoser along with a label to display the selected EObject.
 * <p>
 * Clients must implement <code>getFeatureValue()</code> and <code>getResource()</code>
 * </p>
 * 
 * @author tlandre
 * 
 */
public abstract class AbstractTreeChooserPropertySection extends AbstractTabbedPropertySection
{

    /**
     * A boolean that store if refreshing is happening and no model modifications should be performed
     */
    private boolean isRefreshing = false;

    /**
     * The text + treeChooser button
     */
    private TreeChooser treeChooser;

    /**
     * The label for this section
     */
    private CLabel labelText;

    /**
     * Section composite. This composite can be return if client desire to implement other widgets in relation with the
     * list represented by this instance.
     */
    // private Composite sectionComposite;
    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
     */
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage)
    {
        super.createControls(parent, aTabbedPropertySheetPage);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void createWidgets(Composite composite)
    {
        labelText = getWidgetFactory().createCLabel(composite, getLabelText());

        treeChooser = new TreeChooser(composite, getWidgetFactory(), SWT.NONE);

        if (getFeature() != null)
        {
            treeChooser.setChangeable(getFeature().isChangeable());
        }

    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void setSectionData(Composite composite)
    {
        FormData data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(treeChooser, -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        labelText.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] {getLabelText()}));
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(labelText, 0, SWT.CENTER);
        treeChooser.setLayoutData(data);
    }

    /**
     * Adds the listeners on the widgets
     */
    @Override
    protected void hookListeners()
    {
        treeChooser.addModifyListener(new ModifyListener()
        {

            public void modifyText(ModifyEvent e)
            {
                handleTextModified();
            }

        });
    }

    /**
     * Handle the combo modified event.
     */
    protected void handleTextModified()
    {
        if (!isRefreshing && getFeatureValue() != treeChooser.getSelection())
        {
            EditingDomain editingDomain = getEditingDomain();
            if (getEObjectList().size() == 1)
            {
                /* apply the property change to single selected object */
                editingDomain.getCommandStack().execute(SetCommand.create(editingDomain, getEObject(), getFeature(), treeChooser.getSelection()));
            }
        }
    }

    /**
     * Refresh.
     * 
     * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
     */
    @Override
    public void refresh()
    {
        isRefreshing = true;
        if (getResource() != null)
        {
            treeChooser.setChangeable(true);
            treeChooser.setInput(getResource());
            treeChooser.setSelection(getFeatureValue());
        }
        else
        {
            treeChooser.setChangeable(false);
        }
        isRefreshing = false;
    }

    /**
     * @return the TreeChooser
     */
    protected TreeChooser getTreeChooser()
    {
        return treeChooser;
    }

    /**
     * @return the isRefreshing
     */
    protected boolean isRefreshing()
    {
        return isRefreshing;
    }

    /**
     * Get the current feature value of the selected model object.
     * 
     * @return the feature value to select in the ccombo.
     */
    protected abstract String getFeatureValue();

    /**
     * The EMF Resource
     * 
     * @return the EMF Resource
     */
    protected abstract Resource getResource();

}
