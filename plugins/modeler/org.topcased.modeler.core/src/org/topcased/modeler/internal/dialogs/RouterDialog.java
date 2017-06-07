/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies), Thomas Friol (Anyware
 * Technologies) - initial API and implementation
 ******************************************************************************/
package org.topcased.modeler.internal.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.topcased.modeler.RouterConstants;

/**
 * The Dialog used to select a type of router
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class RouterDialog extends Dialog
{
    private String previousRouter;

    private String router;

    private Combo routerCb;

    /**
     * Constructor.
     * 
     * @param parentShell the parent shell
     * @param routingType The routing type initially selected
     */
    public RouterDialog(Shell parentShell, String routingType)
    {
        super(parentShell);
        previousRouter = routingType;

        setBlockOnOpen(true);
    }

    /**
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    protected void configureShell(Shell newShell)
    {
        newShell.setText("Router selection");
        super.configureShell(newShell);
    }

    /**
     * Return the selected router.
     * 
     * @return the selected router
     */
    public String getRouter()
    {
        return router;
    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    protected Control createDialogArea(Composite parent)
    {
        Composite container = (Composite) super.createDialogArea(parent);

        Label label = new Label(container, SWT.NONE);
        label.setText("Please choose the type of router to use.");

        routerCb = new Combo(container, SWT.READ_ONLY);
        GridData gd = new GridData();
        gd.horizontalAlignment = GridData.CENTER;
        routerCb.setLayoutData(gd);

        hookListeners();
        loadData();
        return container;
    }

    protected void hookListeners()
    {
        routerCb.addModifyListener(new ModifyListener()
        {
            public void modifyText(org.eclipse.swt.events.ModifyEvent e)
            {
                router = routerCb.getText();
            }
        });
    }

    protected void loadData()
    {
        routerCb.add(RouterConstants.FOREST);
        routerCb.add(RouterConstants.OBLIQUE);
        routerCb.add(RouterConstants.RECTILINEAR);

        if (previousRouter != null)
        {
            int index = routerCb.indexOf(previousRouter);
            if (index != -1)
            {
                routerCb.select(index);
            }
        }
    }
}
