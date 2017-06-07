/*****************************************************************************
 * Copyright (c) 2012 AtoS.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  N. PERANSIN (AtoS) nicolas.peransin@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.builder;

import static org.topcased.builder.BuilderPreferenceInitializer.TASKTAG_ACTIVE_PROP;
import static org.topcased.builder.BuilderPreferenceInitializer.TASKTAG_FLAG_PROP;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.topcased.builder.l10n.Messages;

/**
 * This class represents a preference page that is contributed to the Preferences dialog.
 * <p>
 * By subclassing <samp>FieldEditorPreferencePage</samp>, we can use the field support built into JFace that allows us
 * to create a page that is small and knows how to save, restore and apply itself.
 * </p>
 * <p>
 * This page is used to modify preferences only. They are stored in the preference store that belongs to the main
 * plug-in class. That way, preferences can be accessed directly via the preference store.
 * </p>
 * 
 * @author Atos (npn)
 */
public class BuilderPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage
{

    public BuilderPreferencePage()
    {
        super(GRID);
        setPreferenceStore(BuilderActivator.getDefault().getPreferenceStore());
        setDescription(label("description"));
    }

    @Override
    protected void createFieldEditors()
    {

        Composite parent = getFieldEditorParent();

        Group titleGroup = new Group(parent, SWT.NONE);
        titleGroup.setText(label("taskTag.group")); //$NON-NLS-1$		
        titleGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        titleGroup.setLayout(new GridLayout(1, false));

        Composite inner = new Composite(titleGroup, SWT.NONE);
        inner.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        inner.setLayout(new GridLayout(2, false));

        label("taskTag.description", inner);
        addField(new BooleanFieldEditor(TASKTAG_ACTIVE_PROP, label(TASKTAG_ACTIVE_PROP), inner));
        addField(new StringFieldEditor(TASKTAG_FLAG_PROP, label(TASKTAG_FLAG_PROP), inner));
        label("taskTag.hint", inner);

    }

    private String label(String id)
    {
        return Messages.getString("BuilderPreferencePage." + id);
    }

    private void label(String id, Composite parent)
    {
        Label label = new Label(parent, SWT.NONE);
        label.setText(label(id));
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        label.setLayoutData(gd);
    }

    public void init(IWorkbench wrkBench)
    {
        // nothing to do
    }

}
