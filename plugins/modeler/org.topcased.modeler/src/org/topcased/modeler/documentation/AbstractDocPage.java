/***********************************************************************
 * Copyright (c) 2009 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and documentation
 **********************************************************************/
package org.topcased.modeler.documentation;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.part.PageBookView;

/**
 * This class defines an abstract page used to edit a documentation text and some resources to be associated with a
 * given model element<br>
 * Subclasses will specify the type of model element to be handled. <br>
 * 
 * Created : 11 August 2009<br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public abstract class AbstractDocPage extends Page implements IDocPage, IEditingDomainProvider
{
    private EObject documentedElement;

    // SWT Widgets
    private Composite mainComp;

    protected AbstractCommentsComposite commentsComposite;

    protected EAnnotationResourcesComposite resourcesComposite;

    private TabFolder tabFolder;

    /** the workbench part which provides input for this page */
    private IWorkbenchPart inputPart;

    /**
     * Build the page with the editor command stack : used to execute commands.
     * 
     * @param stack the editor command stack
     * @deprecated use {@link #AbstractDocPage()} instead
     */
    public AbstractDocPage(CommandStack stack)
    {
        this();
    }

    /**
     * Build the page
     */
    public AbstractDocPage()
    {
    }

    /**
     * This returns the editing domain as required by the {@link IEditingDomainProvider} interface. This is important
     * for recovering the command stack in order to execute commands.
     * 
     * @return The required editing domain
     * @throws IllegalArgumentException There is an error when the part cannot be adapted in any EditingDomain.
     */
    public EditingDomain getEditingDomain()
    {
        IWorkbenchPart part = inputPart;
        if (part == null)
        {
            part = getSite().getPage().getActiveEditor();
			if (part == null) {
				throw new IllegalArgumentException();
			}
        }

        if (part.getAdapter(EditingDomain.class) != null)
        {
            return (EditingDomain) part.getAdapter(EditingDomain.class);
        }

        if (part instanceof IEditingDomainProvider)
        {
            return ((IEditingDomainProvider) part).getEditingDomain();
        }

        if (part.getAdapter(IEditingDomainProvider.class) != null)
        {
            return ((IEditingDomainProvider) part.getAdapter(IEditingDomainProvider.class)).getEditingDomain();
        }

        if (part instanceof PageBookView)
        {
            IPage page = ((PageBookView) part).getCurrentPage();
            if (page instanceof IEditingDomainProvider)
            {
                return ((IEditingDomainProvider) page).getEditingDomain();
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * Returns the editor command stack, recovered from the editing domain
     * 
     * @return the command stack
     */
    protected CommandStack getCommandStack()
    {
        return getEditingDomain().getCommandStack();
    }

    /**
     * @see org.eclipse.ui.part.Page#createControl(org.eclipse.swt.widgets.Composite)
     */
    public void createControl(Composite parent)
    {
        mainComp = new Composite(parent, SWT.NONE);
        mainComp.setLayout(new GridLayout());
        mainComp.setLayoutData(new GridData(GridData.FILL_BOTH));

        tabFolder = new TabFolder(mainComp, SWT.TOP);
        tabFolder.setLayoutData(new GridData(GridData.FILL_BOTH));

        createCommentsTabItem(tabFolder);
        createResourcesTabItem(tabFolder);
    }

    /**
     * Create the content of the comments tab item. It contains a multi lines text field in order to edit the comments
     * of the documentation.
     * 
     * @param parent the parent tab folder
     */
    private void createCommentsTabItem(TabFolder parent)
    {
        TabItem tabItem = new TabItem(parent, SWT.NONE);
        tabItem.setText("Comments");

        Composite container = new Composite(parent, SWT.NONE);

        GridLayout containerLayout = new GridLayout();
        containerLayout.marginWidth = 0;
        containerLayout.marginHeight = 0;
        container.setLayout(containerLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        tabItem.setControl(container);

        commentsComposite = createCommentsComposite(container);
        commentsComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
    }

    /**
     * Create the content of the resources tab item. It contains a list and three buttons in order to view, add, remove
     * and edit linked resources.
     * 
     * @param parent the parent tab folder
     */
    private void createResourcesTabItem(TabFolder parent)
    {
        TabItem tabItem = new TabItem(parent, SWT.NONE);
        tabItem.setText("Resources");

        Composite container = new Composite(parent, SWT.NONE);
        GridLayout containerLayout = new GridLayout();
        containerLayout.marginWidth = 0;
        containerLayout.marginHeight = 0;
        container.setLayout(containerLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        tabItem.setControl(container);

        resourcesComposite = new EAnnotationResourcesComposite(container, SWT.NONE, this);
        resourcesComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
    }

    /**
     * @see org.eclipse.ui.part.Page#getControl()
     */
    public Control getControl()
    {
        return mainComp;
    }

    /**
     * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(IWorkbenchPart part, ISelection selection)
    {
        manageDocumentatedElement(part, selection, true);
    }

    protected void manageDocumentatedElement(IWorkbenchPart part, ISelection selection, boolean checkResources)
    {
        inputPart = part;
        EObject elt = getSelectedModelElement(selection);
        if (elt == null || elt != documentedElement)
        {
            documentedElement = elt;
            if (commentsComposite != null && !commentsComposite.isDisposed())
            {
                commentsComposite.setDocumentedElement(documentedElement);
            }
            // ResourceComposite is only available when an EModelElement is selected.
            if (documentedElement instanceof EModelElement)
            {
                resourcesComposite.setDocumentedElement((EModelElement) documentedElement);
            }
            if (documentedElement != null && checkResources)
            {
                EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(documentedElement);
                if (editingDomain instanceof AdapterFactoryEditingDomain)
                {
                    AdapterFactoryEditingDomain topDomain = (AdapterFactoryEditingDomain) editingDomain;
                    if (tabFolder != null)
                    {
                        boolean readOnly = topDomain.isReadOnly(documentedElement.eResource());
                        commentsComposite.setReadOnly(readOnly);
                        resourcesComposite.setReadOnly(readOnly);
                    }
                }
            }
        }
    }

    /**
     * @see org.eclipse.ui.part.Page#setFocus()
     */
    @Override
    public void setFocus()
    {
        if (commentsComposite != null && !commentsComposite.isDisposed())
        {
            commentsComposite.setFocus();
        }
        else if (resourcesComposite != null && !resourcesComposite.isDisposed())
        {
            resourcesComposite.setFocus();
        }
    }

    /**
     * Subclasses may override this to propose their own Comments composite implementation
     * 
     * @param parent the parent Composite
     * @return an AbstractCommentsComposite
     */
    protected abstract AbstractCommentsComposite createCommentsComposite(Composite parent);

    /**
     * Return the model element on which the documentation will be attached. Subclasses may override this method in
     * order to extract the model element from the given selection.
     * 
     * @param selection the initial selection
     * @return the model element on which the documentation will be attached
     */
    protected abstract EObject getSelectedModelElement(ISelection selection);

}
