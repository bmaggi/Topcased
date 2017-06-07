/*******************************************************************************
 * Copyright (c) 2005, 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation 
 *    Mathieu Garcia (Anyware Technologies) - initial API and implementation
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Thomas Friol (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.documentation;

import java.util.EventObject;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * A class defining an empty composite to use in an IDocPage. <br>
 * Creation : 10 oct. 2005 <br>
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 */
public abstract class DocPageComposite extends Composite implements CommandStackListener
{
    /**
     * The command stack should not be used. It has not be removed for compatibility with old constructor.
     * 
     * @deprecated use {@link #getCommandStack()} instead
     */
    private CommandStack commandStack = null;

    private IEditingDomainProvider domainProvider = null;

    /**
     * Construct a new empty DocPageComposite.
     * 
     * @param parent the parent composite
     * @param style the composite style
     * @param stack the command stack to use to execute commands
     * @deprecated use {@link #DocPageComposite(Composite, int, IEditingDomainProvider)} instead
     */
    public DocPageComposite(Composite parent, int style, CommandStack stack)
    {
        super(parent, style);
        setLayout(new GridLayout());
        commandStack = stack;
        commandStack.addCommandStackListener(this);

        this.addDisposeListener(new DisposeListener()
        {
            /**
             * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
             */
            public void widgetDisposed(DisposeEvent e)
            {
                handleDispose();
            }
        });

        createContents(this);
    }

    /**
     * Construct a new empty DocPageComposite.
     * 
     * @param parent the parent composite
     * @param style the composite style
     * @param editingDomainProvider the provider of editing domain to execute commands
     */
    public DocPageComposite(Composite parent, int style, IEditingDomainProvider editingDomainProvider)
    {
        super(parent, style);
        domainProvider = editingDomainProvider;
        setLayout(new GridLayout());
        try
        {
            getCommandStack().addCommandStackListener(this);
        }
        catch (IllegalArgumentException stackExc)
        {
            /*
             * An IllegalArgumentException has occurred because command stack is not yet available, since the input view
             * has not been linked from the editing domain, hence it can not provide the command stack. This can occur
             * when no editor is active. Do nothing.
             */
        }

        this.addDisposeListener(new DisposeListener()
        {
            /**
             * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
             */
            public void widgetDisposed(DisposeEvent e)
            {
                handleDispose();
            }
        });

        createContents(this);
    }

    /**
     * Called when the composite is disposed. <b>Subclasses must release local resources and listeners here.</b>
     */
    protected void handleDispose()
    {
        try
        {
            getCommandStack().removeCommandStackListener(this);
        }
        catch (IllegalArgumentException stackExc)
        {
            /*
             * An IllegalArgumentException has occurred because command stack is no longer available, since the input
             * view has been unlinked from the editing domain, hence it can no longer provide the command stack. This
             * can occur at eclipse closure only. Since the command stack should be destroyed and no longer be used, it
             * is not disturbing that its listener is not removed. Do nothing.
             */
        }
    }

    /**
     * Returns this composite command stack.
     * 
     * @return a command stack
     */
    protected CommandStack getCommandStack()
    {
        if (domainProvider != null)
        {
            return domainProvider.getEditingDomain().getCommandStack();
        }
        else
        {
            // old deprecated constructor has been used. Return deprecated attribute for compatibility
            return commandStack;
        }
    }

    /**
     * Creates the content of this composite. Clients should override this method to create their own composite.
     * 
     * @param parent the parent composite
     */
    protected abstract void createContents(Composite parent);

    /**
     * Informs this composite that it needs to be refresh.
     */
    protected void refresh()
    {
        // Do nothing
    }

    /**
     * @see org.eclipse.gef.commands.CommandStackListener#commandStackChanged(java.util.EventObject)
     */
    public void commandStackChanged(EventObject event)
    {
        if (Display.getCurrent() != Display.getDefault())
        {
            Display.getDefault().asyncExec(new Runnable()
            {
                public void run()
                {
                    refresh();
                }
            });
        }
        else
        {
            refresh();
        }
    }

    /**
     * Set the composite read only
     * 
     * @param readOnly
     */
    public void setReadOnly(boolean readOnly)
    {
        this.setEnabled(!readOnly);
    }
}
