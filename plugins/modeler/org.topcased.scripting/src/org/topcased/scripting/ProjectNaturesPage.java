/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.scripting;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.topcased.scripting.extensions.ScriptProjectNatureManager;

public class ProjectNaturesPage extends WizardPage
{

    protected ProjectNaturesPage()
    {
        super(Messages.getString("ProjectNaturesPage.pageName"), Messages.getString("ProjectNaturesPage.title"), null);
    }

    public void createControl(Composite parent)
    {
        Composite mainComp = new Composite(parent, SWT.NONE);
        mainComp.setLayout(new GridLayout());
        mainComp.setLayoutData(new GridData(GridData.FILL_BOTH));
        mainComp.setFont(parent.getFont());

        Map<String, String> naturesMap = ScriptProjectNatureManager.getInstance().getNaturesForEditors();
        if (!naturesMap.isEmpty())
        {
            GridData gd = new GridData(GridData.FILL_HORIZONTAL);
            gd.verticalIndent = 20;
            Label label = new Label(mainComp, SWT.NONE);
            label.setText(Messages.getString("ProjectNaturesPage.message"));
            label.setLayoutData(gd);
        }
        else
        {
            GridData gd = new GridData(GridData.FILL_HORIZONTAL);
            gd.verticalIndent = 20;
            Label label = new Label(mainComp, SWT.NONE);
            label.setText(Messages.getString("ProjectNaturesPage.finishMessage"));
            label.setLayoutData(gd);
        }
        for (Entry<String, String> entry : naturesMap.entrySet())
        {
            final String nature = entry.getKey();
            GridData gd = new GridData(GridData.FILL_HORIZONTAL);
            gd.verticalIndent = 10;
            String entryMsg = NLS.bind(Messages.getString("ProjectNaturesPage.entry"), entry.getValue());//$NON-NLS-1$
            final Button butt = new Button(mainComp, SWT.CHECK);
            butt.setText(entryMsg);
            butt.setLayoutData(gd);
            butt.setSelection(true);
            // add listener to update the list of selected natures
            butt.addSelectionListener(new SelectionAdapter()
            {
                @Override
                public void widgetSelected(SelectionEvent e)
                {
                    if (butt.getSelection())
                    {
                        addNature(nature);
                    }
                    else
                    {
                        removeNature(nature);
                    }
                }
            });
        }

        setControl(mainComp);
        setPageComplete(true);
    }

    /**
     * Remove a project nature from the list of natures to apply
     * 
     * @param nature nature to remove
     */
    protected void removeNature(String nature)
    {
        IWizard wizz = getWizard();
        if (wizz instanceof AbstractSamplesProjectWizard)
        {
            ((AbstractSamplesProjectWizard) wizz).removeNature(nature);
        }
    }

    /**
     * Add a project nature to the list of natures to apply
     * 
     * @param nature nature to add
     */
    protected void addNature(String nature)
    {
        IWizard wizz = getWizard();
        if (wizz instanceof AbstractSamplesProjectWizard)
        {
            ((AbstractSamplesProjectWizard) wizz).addNature(nature);
        }
    }
}
