/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Maxime Leray (Atos Origin) maxime.leray@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.topcased.modeler.dialogs;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.di.model.provider.DiagramInterchangeItemProviderAdapterFactory;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * The Class ConfirmImpactDialog.
 */
public class ConfirmImpactDialog extends ConfirmationDialog
{

    /** The impacted list. */
    private Collection<EObject> impactedList;

    /** The clipboard. */
    private Clipboard clipboard;

    /** The list. */
    private ListViewer list;

    /**
     * Instantiates a new confirm impact dialog.
     * 
     * @param parentShell the parent shell
     * @param dialogTitle the dialog title
     * @param message the message
     * @param ps the ps
     * @param preference the preference
     */
    public ConfirmImpactDialog(Shell parentShell, String dialogTitle, String message, IPreferenceStore ps, String preference)
    {
        super(parentShell, dialogTitle, message, ps, preference);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.topcased.modeler.dialogs.ConfirmationDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createDialogArea(Composite parent)
    {
        Composite content = (Composite) super.getContainer(parent);

        createImpactList(content);

        createRememberButton(parent);

        return content;
    }

    /**
     * Creates the impact list.
     * 
     * @param parent the parent
     */
    protected void createImpactList(Composite parent)
    {
        GridDataFactory gdf = GridDataFactory.fillDefaults();
        gdf.grab(true, true);
        GridLayoutFactory glf = GridLayoutFactory.fillDefaults();

        Composite content = new Composite(parent, SWT.NONE);
        content.setLayout(glf.create());
        content.setLayoutData(gdf.create());
        Label msg = new Label(content, SWT.NONE);
        msg.setText("The following resources will also be modified:");

        list = new ListViewer(content, SWT.MULTI | SWT.BORDER);
        list.getList().setLayoutData(gdf.create());
        list.setContentProvider(new ArrayContentProvider());
        list.setLabelProvider(new ImpactLabelProvider());
        list.setInput(this.impactedList);
        // add a copy menu on the list
        Menu copyMenu = new Menu(list.getList());
        MenuItem copyItem = new MenuItem(copyMenu, SWT.NONE);
        copyItem.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                copyToClipboard();
            }
        });
        copyItem.setText(JFaceResources.getString("copy"));
        list.getList().setMenu(copyMenu);
    }

    /**
     * Copy to clipboard.
     */
    private void copyToClipboard()
    {
        if (clipboard != null)
        {
            clipboard.dispose();
        }
        String[] selection = list.getList().getSelection();
        if (selection.length > 0)
        {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < selection.length - 1; i++)
            {
                buffer.append(selection[i] + "\n");
            }
            buffer.append(selection[selection.length - 1]);
            clipboard = new Clipboard(list.getList().getDisplay());
            clipboard.setContents(new Object[] {buffer.toString()}, new Transfer[] {TextTransfer.getInstance()});
        }
    }

    /**
     * Sets the impacted list.
     * 
     * @param objects the new impacted list
     */
    public void setImpactedList(Collection< ? extends EObject> objects)
    {
        this.impactedList = (Collection<EObject>) objects;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.topcased.modeler.dialogs.ConfirmationDialog#open()
     */
    @Override
    public int open()
    {
        // log the impacted resources in the error log view
        if (ps != null && preference != null && preference.length() > 0)
        {
            if (ps.getBoolean(preference))
            {
                if (impactedList != null)
                {
                    for (EObject resource : impactedList)
                    {
                        String message = new String();
                        if (resource instanceof Diagram)
                        {
                            Diagram di = (Diagram) resource;
                            message = di.getName() + " (" + di.eResource().getURI().toString() + ")";
                        }
                        else
                        {
                            ReflectiveItemProvider reflectiveItemProvider = new ReflectiveItemProvider(new ReflectiveItemProviderAdapterFactory());
                            message = reflectiveItemProvider.getText(resource);
                        }
                        Status status = new Status(IStatus.INFO, ModelerPlugin.getId(), "The resource " + message + " has been modified.");
                        ModelerPlugin.log(status);
                    }
                }
            }
        }
        return super.open();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.Dialog#close()
     */
    @Override
    public boolean close()
    {
        if (clipboard != null)
        {
            clipboard.dispose();
        }
        return super.close();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.topcased.modeler.dialogs.ConfirmationDialog#buttonPressed(int)
     */
    @Override
    protected void buttonPressed(int buttonId)
    {
        // OK pressed
        if (buttonId == Window.OK && rememberChoice.getSelection())
        {
            if (ps != null && preference != null && preference.length() > 0)
            {
                // Warn the user that the resources will be displayed in error log
                StringBuilder message = new StringBuilder();
                message.append("The impacted resources will now be displayed in the Error Log view (Window > Show View > Error Log).\n");
                message.append("To change the preference, untick the box in the preferences (Window > Preferences > Topcased > Editors).");
                MessageDialog.openInformation(getParentShell(), "Information", message.toString());
            }
        }
        super.buttonPressed(buttonId);
    }

    /**
     * The Class ImpactLabelProvider.
     */
    private static class ImpactLabelProvider extends AdapterFactoryLabelProvider
    {

        /**
         * Instantiates a new impact label provider.
         * 
         * @param adapterFactory the adapter factory
         */
        public ImpactLabelProvider(AdapterFactory adapterFactory)
        {
            super(adapterFactory);
        }

        /**
         * Instantiates a new impact label provider.
         */
        public ImpactLabelProvider()
        {
            this(getDefaultAdapterFactories());
        }

        /**
         * Gets the default adapter factories.
         * 
         * @return the default adapter factories
         */
        private static AdapterFactory getDefaultAdapterFactories()
        {
            ComposedAdapterFactory compo = new ComposedAdapterFactory();
            compo.addAdapterFactory(new DiagramInterchangeItemProviderAdapterFactory());
            return compo;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getText(java.lang.Object)
         */
        @Override
        public String getText(Object element)
        {
            if (element instanceof Diagram)
            {
                Diagram di = (Diagram) element;
                return di.getName() + " (" + di.eResource().getURI().toString() + ")";
            }
            return super.getText(element);
        }
    }

}
