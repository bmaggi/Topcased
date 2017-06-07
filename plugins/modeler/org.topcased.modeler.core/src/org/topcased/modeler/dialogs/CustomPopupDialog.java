/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN INTEGRATION.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Caroline Bourdeu d'Aguerre (ATOS ORIGIN INTEGRATION) caroline.bourdeudaguerre@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.dialogs;

import java.util.Collection;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

/**
 * The Class CustomPopupDialog.
 */
abstract public class CustomPopupDialog extends PopupDialog
{

    /** The anchor. */
    private Point fAnchor;

    /** The composite. */
    protected Composite composite;

    /** The toolkit. */
    protected FormToolkit toolkit;

    /** The title. */
    private String title;

    /** The form head. */
    protected ScrolledForm formHead;

    /**
     * The Class CloseAction.
     */
    private class CloseAction extends Action
    {

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.action.Action#getImageDescriptor()
         */
        public ImageDescriptor getImageDescriptor()
        {
            return PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_DELETE);
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.action.Action#run()
         */
        public void run()
        {
            close();
        }
    }

    /**
     * Instantiates a new custom popup dialog.
     * 
     * @param parent the parent
     * @param point the point
     * @param title the title
     */
    public CustomPopupDialog(Shell parent, Point point, String title)
    {
        super(parent, SWT.NONE, true, true, false, false, false, null, null);
        this.fAnchor = point;
        this.toolkit = new FormToolkit(Display.getDefault());
        this.title = title;
    }

    /*
     * @see org.eclipse.jface.window.Window#configureShell(Shell)
     */
    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.PopupDialog#configureShell(org.eclipse.swt.widgets.Shell)
     */
    protected void configureShell(Shell shell)
    {
        super.configureShell(shell);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.PopupDialog#createContents(org.eclipse.swt.widgets.Composite)
     */
    protected Control createContents(Composite parent)
    {
        getShell().setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
        initializeBounds();
        return createDialogArea(parent);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.PopupDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    protected Control createDialogArea(Composite parent)
    {
        this.composite = (Composite) super.createDialogArea(parent);
        composite.setLayout(new FillLayout());
        formHead = toolkit.createScrolledForm(composite);
        toolkit.decorateFormHeading(formHead.getForm());

        // set title and image
        formHead.setText(title);

        // add a Close button to the toolbar

        Collection<Action> actions = getActions();
        for (Action action : actions)
        {
            formHead.getToolBarManager().add(action);
        }
        formHead.getToolBarManager().add(new CloseAction());
        formHead.getToolBarManager().update(true);

        FillLayout layout = new FillLayout(SWT.VERTICAL);
        layout.marginHeight = 5;
        layout.marginWidth = 5;
        formHead.getBody().setLayout(layout);
        createSubsection();

        parent.pack();
        return composite;
    }

    /**
     * Gets the actions.
     * 
     * @return the actions
     */
    abstract protected Collection<Action> getActions();

    /**
     * Creates the subsection.
     */
    abstract protected void createSubsection();

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.PopupDialog#getInitialLocation(org.eclipse.swt.graphics.Point)
     */
    protected Point getInitialLocation(Point size)
    {
        if (fAnchor == null)
        {
            return super.getInitialLocation(size);
        }
        Point point = fAnchor;
        Rectangle monitor = getShell().getMonitor().getClientArea();
        if (monitor.width < point.x + size.x)
        {
            point.x = Math.max(0, point.x - size.x);
        }
        if (monitor.height < point.y + size.y)
        {
            point.y = Math.max(0, point.y - size.y);
        }
        return point;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.PopupDialog#close()
     */
    public boolean close()
    {
        if (toolkit != null)
            toolkit.dispose();
        toolkit = null;
        return super.close();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.PopupDialog#getFocusControl()
     */
    protected Control getFocusControl()
    {
        return this.composite;
    }

}
