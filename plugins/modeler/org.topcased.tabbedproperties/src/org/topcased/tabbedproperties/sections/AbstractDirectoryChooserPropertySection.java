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
 *  Thibault Landre (thibault.landre@atosorigin.com)<BR>
 *  Thomas Szadel (thomas.szadel@atosorigin.com)
 *
 *****************************************************************************/
package org.topcased.tabbedproperties.sections;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
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
import org.topcased.tabbedproperties.internal.sections.TabbedPropertiesPlugin;
import org.topcased.tabbedproperties.sections.widgets.DirectoryChooser;

/**
 * A directory chooser.
 * 
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>
 */
public abstract class AbstractDirectoryChooserPropertySection extends AbstractTabbedPropertySection
{

    /**
     * A boolean that store if refreshing is happening and no model modifications should be performed
     */
    private boolean isRefreshing = false;

    /**
     * The text + directorychooser button
     */
    private DirectoryChooser directoryChooser;

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

        directoryChooser = new DirectoryChooser(composite, getWidgetFactory(), SWT.NONE);
        directoryChooser.setEditable(true);

        if (getFeature() != null)
        {
            directoryChooser.setChangeable(getFeature().isChangeable());
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
        data.right = new FormAttachment(directoryChooser, -ITabbedPropertyConstants.HSPACE);
        data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
        labelText.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(0, getStandardLabelWidth(composite, new String[] {getLabelText()}));
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(labelText, 0, SWT.CENTER);
        directoryChooser.setLayoutData(data);

    }

    /**
     * Adds the listeners on the widgets
     */
    @Override
    protected void hookListeners()
    {
        directoryChooser.addModifyListener(new ModifyListener()
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
        if (!isRefreshing && getFeatureValue() != directoryChooser.getSelection())
        {
            List<IStatus> status = verifyDirectory();
            directoryChooser.setStatus(status);
            if (status.isEmpty())
            {
                EditingDomain editingDomain = getEditingDomain();
                if (getEObjectList().size() == 1)
                {
                    /* apply the property change to single selected object */
                    editingDomain.getCommandStack().execute(SetCommand.create(editingDomain, getEObject(), getFeature(), directoryChooser.getSelection()));
                }
            }
        }
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
     */
    @Override
    public void refresh()
    {
        isRefreshing = true;
        directoryChooser.setSelection(getFeatureValue());
        isRefreshing = false;
    }

    /**
     * @return the DirectoryChooser
     */
    protected DirectoryChooser getFileChooser()
    {
        return directoryChooser;
    }

    /**
     * @return the isRefreshing
     */
    protected boolean isRefreshing()
    {
        return isRefreshing;
    }

    /**
     * Handler called to verify the file path on user text modification. By default it checks the directory existence is
     * the property checkDirectoryExistence is set to true
     * 
     * @param Event raised on the file path field
     * @return true is the directory matches
     */
    protected List<IStatus> verifyDirectory()
    {
        List<IStatus> statusList = new ArrayList<IStatus>();
        if (isCheckDirectoryExistence())
        {
            String selection = directoryChooser.getSelection();
            if (selection != null && !"".equals(selection))
            {
                File directory = new File(selection);
                if (!directory.exists())
                {
                    statusList.add(new Status(IStatus.ERROR, TabbedPropertiesPlugin.PLUGIN_ID, getLabelText() + " does not exist!"));
                }
                else if (!directory.isDirectory())
                {
                    statusList.add(new Status(IStatus.ERROR, TabbedPropertiesPlugin.PLUGIN_ID, getLabelText() + " is not a directory!"));
                }
            }
            else if (cannotBeBlank())
            {
                statusList.add(new Status(IStatus.ERROR, TabbedPropertiesPlugin.PLUGIN_ID, getLabelText() + " cannot be blank!"));
            }
        }
        List<IStatus> emptyList = Collections.emptyList();
        return statusList.isEmpty() ? emptyList : statusList;
    }

    /**
     * 
     * @return true if the directory must exist in the file system
     */
    public boolean isCheckDirectoryExistence()
    {
        return false;
    }

    /**
     * @return true if the field is compulsory
     */
    public boolean cannotBeBlank()
    {
        return false;
    }

    /**
     * Get the current feature value of the selected model object.
     * 
     * @return the feature value to select in the ccombo.
     */
    protected abstract String getFeatureValue();

}