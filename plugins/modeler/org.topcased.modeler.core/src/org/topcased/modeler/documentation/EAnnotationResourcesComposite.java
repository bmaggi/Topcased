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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.topcased.modeler.IAnnotationConstants;
import org.topcased.modeler.commands.AddDocumentationResourcesCommand;
import org.topcased.modeler.commands.EditDocumentationResourcesCommand;
import org.topcased.modeler.commands.RemoveDocumentationResourcesCommand;
import org.topcased.modeler.dialogs.TypedResourcesSelectionDialog;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.providers.ArrayTreeContentProvider;

/**
 * A class defining a composite to edit the resources of a EModelElement as an EAnnotation. <br>
 * Creation : 10 oct. 2005
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 */
public class EAnnotationResourcesComposite extends DocPageComposite
{
    private static final String PREFIX_WORKSPACE_RESOURCE = "WR";

    private static final String PREFIX_EXTERNAL_RESOURCE = "ER";

    private static final String PREFIX_REMOTE_RESOURCE = "RR";

    private EModelElement documentedElement;

    private TreeViewer resourcesList;

    private Button addResourcesButton;

    private Button removeResourcesButton;

    private Button editResourceButton;

    private ISelectionChangedListener selectionChangedListener;

    private SelectionListener buttonSelectionListener;

    private IDoubleClickListener listDoubleClickListener;

    private KeyListener listKeyListener;

    /**
     * Constructor.
     * 
     * @param parent the parent composite
     * @param style the composite style
     * @param commandStack the command stack to use to execute commands
     * @deprecated use {@link #EAnnotationResourcesComposite(Composite, int, IEditingDomainProvider)} instead
     */
    public EAnnotationResourcesComposite(Composite parent, int style, CommandStack commandStack)
    {
        super(parent, style, commandStack);
    }

    /**
     * Constructor.
     * 
     * @param parent the parent composite
     * @param style the composite style
     * @param editingDomainProvider the provider of editing domain to execute commands
     */
    public EAnnotationResourcesComposite(Composite parent, int style, IEditingDomainProvider editingDomainProvider)
    {
        super(parent, style, editingDomainProvider);
    }

    /**
     * @see org.topcased.modeler.documentation.DocPageComposite#createContents(org.eclipse.swt.widgets.Composite)
     */
    protected void createContents(Composite parent)
    {
        selectionChangedListener = new ISelectionChangedListener()
        {
            public void selectionChanged(SelectionChangedEvent event)
            {
                handleResourcesListSelectionChanged();
            }

        };
        buttonSelectionListener = new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                if (e.getSource() == addResourcesButton)
                {
                    handleAddResources();
                }
                else if (e.getSource() == removeResourcesButton)
                {
                    handleRemoveResources();
                }
                else if (e.getSource() == editResourceButton)
                {
                    handleEditResource();
                }
            }
        };

        listDoubleClickListener = new IDoubleClickListener()
        {
            public void doubleClick(DoubleClickEvent event)
            {
                handleOpenResource();
            }
        };

        listKeyListener = new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                if (e.keyCode == SWT.DEL)
                {
                    handleRemoveResources();
                }
            }
        };

        resourcesList = new TreeViewer(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
        resourcesList.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
        resourcesList.setContentProvider(new ArrayTreeContentProvider());
        resourcesList.setLabelProvider(new ResourcesLabelProvider());
        resourcesList.addSelectionChangedListener(selectionChangedListener);
        resourcesList.addDoubleClickListener(listDoubleClickListener);
        resourcesList.getTree().addKeyListener(listKeyListener);

        Composite actionsComp = new Composite(parent, SWT.NONE);
        actionsComp.setLayout(new GridLayout(3, true));
        actionsComp.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));

        addResourcesButton = new Button(actionsComp, SWT.PUSH);
        addResourcesButton.setText("Add");
        addResourcesButton.setLayoutData(new GridData(GridData.FILL_BOTH));
        addResourcesButton.addSelectionListener(buttonSelectionListener);

        removeResourcesButton = new Button(actionsComp, SWT.PUSH);
        removeResourcesButton.setText("Remove");
        removeResourcesButton.setLayoutData(new GridData(GridData.FILL_BOTH));
        removeResourcesButton.addSelectionListener(buttonSelectionListener);

        editResourceButton = new Button(actionsComp, SWT.PUSH);
        editResourceButton.setText("Edit");
        editResourceButton.setLayoutData(new GridData(GridData.FILL_BOTH));
        editResourceButton.addSelectionListener(buttonSelectionListener);
    }

    /**
     * Change the edited object
     * 
     * @param modelElement the edited object
     */
    public void setDocumentedElement(EModelElement modelElement)
    {
        if (modelElement == null || this.documentedElement != modelElement)
        {
            this.documentedElement = modelElement;
            refresh();
        }
    }

    /**
     * Get the element to be documented
     * 
     * @return EModelElement
     */
    public EModelElement getDocumentedElement()
    {
        return documentedElement;
    }

    /**
     * @see org.topcased.modeler.documentation.DocPageComposite#refresh()
     */
    protected void refresh()
    {
        resourcesList.setInput(null);
        resourcesList.getTree().setEnabled(getDocumentedElement() != null);
        addResourcesButton.setEnabled(getDocumentedElement() != null);
        removeResourcesButton.setEnabled(false);
        editResourceButton.setEnabled(false);
        if (getDocumentedElement() != null)
        {
            EAnnotation annotation = getDocumentedElement().getEAnnotation(IAnnotationConstants.RESOURCES_SOURCE);
            if (annotation != null)
            {
                resourcesList.setInput(annotation.getDetails());
            }
        }
    }

    private void handleResourcesListSelectionChanged()
    {
        IStructuredSelection selection = (IStructuredSelection) resourcesList.getSelection();
        removeResourcesButton.setEnabled(!selection.isEmpty());
        editResourceButton.setEnabled(selection.size() == 1);
    }

    private void handleAddResources()
    {
        if (getDocumentedElement() != null)
        {
            // Get the map of resources to add
            Map<String, String> resourcesToAdd = new HashMap<String, String>();

            TypedResourcesSelectionDialog dialog = new TypedResourcesSelectionDialog(ModelerPlugin.getActiveWorkbenchShell());
            int result = dialog.open();
            if (result == Window.OK)
            {
                switch (dialog.getType())
                {
                    case TypedResourcesSelectionDialog.REMOTE_RESOURCE:
                        RemoteResourceDialog rrDialog = new RemoteResourceDialog(ModelerPlugin.getActiveWorkbenchShell(), "http://");

                        if (rrDialog.open() == Window.OK)
                        {
                            resourcesToAdd.put(getNewResourceKey(PREFIX_REMOTE_RESOURCE, 0, resourcesToAdd), rrDialog.getValue());
                        }
                        break;

                    case TypedResourcesSelectionDialog.EXTERNAL_RESOURCE:
                        FileDialog erDialog = new FileDialog(ModelerPlugin.getActiveWorkbenchShell(), SWT.MULTI);
                        if (erDialog.open() != null)
                        {
                            String[] resources = erDialog.getFileNames();
                            for (int i = 0; i < resources.length; i++)
                            {
                                resourcesToAdd.put(getNewResourceKey(PREFIX_EXTERNAL_RESOURCE, 0, resourcesToAdd), erDialog.getFilterPath() + File.separator + resources[i]);
                            }
                        }

                        break;

                    /* Default case : WORKSPACE_RESOURCE */
                    default:
                        WorkspaceResourceDialog wrDialog = new WorkspaceResourceDialog(ModelerPlugin.getActiveWorkbenchShell());
                        result = wrDialog.open();
                        if (result == Window.OK)
                        {
                            Object[] resources = wrDialog.getResult();
                            for (int i = 0; i < resources.length; i++)
                            {
                                if (resources[i] instanceof IFile)
                                {
                                    resourcesToAdd.put(getNewResourceKey(PREFIX_WORKSPACE_RESOURCE, 0, resourcesToAdd), ((IFile) resources[i]).getFullPath().toString());
                                }
                            }
                        }

                        break;
                }

                // Execute the add resources command if there are some resources to add
                if (!resourcesToAdd.isEmpty())
                {
                    Command cmd = new AddDocumentationResourcesCommand(getDocumentedElement(), resourcesToAdd);
                    getCommandStack().execute(cmd);
                }
            }
        }
    }

    private void handleRemoveResources()
    {
        if (getDocumentedElement() != null)
        {
            // Get the map of resources to add from the current resources list selection
            Map<String, String> resourcesToRemove = new HashMap<String, String>();
            IStructuredSelection selection = (IStructuredSelection) resourcesList.getSelection();
            for (Iterator<BasicEMap.Entry<String, String>> it = selection.toList().iterator(); it.hasNext();)
            {
                BasicEMap.Entry<String, String> entry = it.next();
                resourcesToRemove.put(entry.getKey(), entry.getValue());
            }

            // Execute the remove resources command if there are some resources to remove
            if (!resourcesToRemove.isEmpty())
            {
                if (MessageDialog.openQuestion(ModelerPlugin.getActiveWorkbenchShell(), "Resources removing...", "Are you sure you want to delete the selected resource(s) ?"))
                {
                    Command cmd = new RemoveDocumentationResourcesCommand(getDocumentedElement(), resourcesToRemove);
                    getCommandStack().execute(cmd);
                }
            }
        }
    }

    private void handleEditResource()
    {
        IStructuredSelection selection = (IStructuredSelection) resourcesList.getSelection();
        if (selection.size() == 1)
        {
            BasicEMap.Entry<String, String> entry = (BasicEMap.Entry<String, String>) selection.getFirstElement();
            String prefix = entry.getKey().substring(0, 2);
            String newResource = null;
            if (PREFIX_REMOTE_RESOURCE.equals(prefix))
            {
                RemoteResourceDialog rrDialog = new RemoteResourceDialog(ModelerPlugin.getActiveWorkbenchShell(), (String) entry.getValue());
                if (rrDialog.open() == Window.OK)
                {
                    newResource = rrDialog.getValue();
                }
            }
            else if (PREFIX_EXTERNAL_RESOURCE.equals(prefix))
            {
                FileDialog erDialog = new FileDialog(ModelerPlugin.getActiveWorkbenchShell());
                erDialog.setFileName((String) entry.getValue());
                newResource = erDialog.open();
            }
            else if (PREFIX_WORKSPACE_RESOURCE.equals(prefix))
            {
                WorkspaceResourceDialog wrDialog = new WorkspaceResourceDialog(ModelerPlugin.getActiveWorkbenchShell());
                wrDialog.setInitialSelections(new IFile[] {ResourcesPlugin.getWorkspace().getRoot().getFile(new Path((String) entry.getValue())),});
                if (wrDialog.open() == Window.OK)
                {
                    newResource = ((IFile) wrDialog.getResult()[0]).getFullPath().toString();
                }
            }

            if (newResource != null)
            {
                getCommandStack().execute(new EditDocumentationResourcesCommand(entry, newResource));
            }
        }
    }

    private void handleOpenResource()
    {
        IStructuredSelection selection = (IStructuredSelection) resourcesList.getSelection();
        if (selection.size() == 1)
        {
            BasicEMap.Entry<String, String> entry = (BasicEMap.Entry<String, String>) selection.getFirstElement();
            String resourcePath = (String) entry.getValue();
            String prefix = ((String) entry.getKey()).substring(0, 2);
            if (PREFIX_REMOTE_RESOURCE.equals(prefix))
            {
                try
                {
                    ModelerPlugin.openURL(new URL(resourcePath));
                }
                catch (MalformedURLException mue)
                {
                    ModelerPlugin.displayDialog("Invalid remote resource", "The remote resource '" + resourcePath + "' is invalid. It is impossible to open it.", IStatus.ERROR);
                }
            }
            else if (PREFIX_EXTERNAL_RESOURCE.equals(prefix))
            {
                File resource = new File(resourcePath);
                ExternalResourceEditorInput input = new ExternalResourceEditorInput(resource);
                try
                {
                    IDE.openEditor(ModelerPlugin.getActivePage(), input, getEditorId(resource));
                }
                catch (PartInitException pie)
                {
                    ModelerPlugin.displayDialog("Invalid external resource", "The external resource '" + resourcePath + "' cannot be opened.", IStatus.ERROR);
                }
            }
            else if (PREFIX_WORKSPACE_RESOURCE.equals(prefix))
            {
                IFile resource = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resourcePath));
                try
                {
                    IDE.openEditor(ModelerPlugin.getActivePage(), resource);
                }
                catch (PartInitException pie)
                {
                    ModelerPlugin.displayDialog("Invalid workspace resource", "The workspace resource '" + resourcePath + "' cannot be opened.", IStatus.ERROR);
                }
            }
        }
    }

    /**
     * Recursively compute a new resource key using its prefix, a starting index and a map of resources to create. It
     * also look in the existing resources to find a free index.
     * 
     * @param resourcePrefix the resource prefix to use
     * @param startIndex the start index (ie : 0)
     * @param resourcesToAdd the map of resources to add
     * @return a new resource key
     */
    private String getNewResourceKey(String resourcePrefix, int startIndex, Map<String, ? > resourcesToAdd)
    {
        String key = resourcePrefix + startIndex;
        EAnnotation annotation = getDocumentedElement().getEAnnotation(IAnnotationConstants.RESOURCES_SOURCE);
        if ((annotation == null && resourcesToAdd.get(key) == null) || (annotation != null && annotation.getDetails().get(key) == null && resourcesToAdd.get(key) == null))
        {
            return key;
        }

        return getNewResourceKey(resourcePrefix, startIndex + 1, resourcesToAdd);
    }

    /**
     * Get the editor id to use to open an external resource.<br>
     * This method is copied from org.eclipse.ui.internal.editors.text.OpenExternalFileAction
     * 
     * @param file the ecternal resource file
     * @return an editor id
     */
    private String getEditorId(File file)
    {
        IWorkbench workbench = ModelerPlugin.getDefault().getWorkbench();
        IEditorRegistry editorRegistry = workbench.getEditorRegistry();
        IEditorDescriptor descriptor = editorRegistry.getDefaultEditor(file.getName(), getContentType(file));
        if (descriptor != null)
        {
            return descriptor.getId();
        }
        return EditorsUI.DEFAULT_TEXT_EDITOR_ID;
    }

    @Override
    public void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (resourcesList != null && resourcesList.getControl() != null)
        {
            resourcesList.getControl().setEnabled(enabled);
        }
        if (this.editResourceButton != null)
        {
            this.editResourceButton.setEnabled(enabled);
        }
        if (this.removeResourcesButton != null)
        {
            this.removeResourcesButton.setEnabled(enabled);
        }
        if (this.addResourcesButton != null)
        {
            this.addResourcesButton.setEnabled(enabled);
        }
    }

    /**
     * Return the content type of the given file.<br/>
     * This method is copied from org.eclipse.ui.internal.editors.text.OpenExternalFileAction
     * 
     * @param file a file
     * @return a content type
     */
    private IContentType getContentType(File file)
    {
        if (file == null)
        {
            return null;
        }

        InputStream stream = null;
        try
        {
            stream = new FileInputStream(file);
            return Platform.getContentTypeManager().findContentTypeFor(stream, file.getName());
        }
        catch (IOException x)
        {
            ModelerPlugin.log(x);
            return null;
        }
        finally
        {
            try
            {
                if (stream != null)
                {
                    stream.close();
                }
            }
            catch (IOException x)
            {
                ModelerPlugin.log(x);
            }
        }
    }

    /**
     * A label provider used for the resources list viewer.
     */
    private class ResourcesLabelProvider extends LabelProvider
    {
        private WorkbenchLabelProvider wlp = new WorkbenchLabelProvider();

        /**
         * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
         */
        public String getText(Object element)
        {
            if (element instanceof BasicEMap.Entry< ? , ? >)
            {
                return ((BasicEMap.Entry<String, String>) element).getValue();
            }

            return "Unknown resource";
        }

        /**
         * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
         */
        public Image getImage(Object element)
        {
            if (element instanceof BasicEMap.Entry< ? , ? >)
            {
                BasicEMap.Entry<String, String> resource = (BasicEMap.Entry<String, String>) element;
                String prefix = resource.getKey().substring(0, 2);
                if (PREFIX_REMOTE_RESOURCE.equals(prefix))
                {
                    return ModelerImageRegistry.getImage("EXTERNAL_RESOURCE");
                }
                else if (PREFIX_EXTERNAL_RESOURCE.equals(prefix))
                {
                    return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
                }
                else if (PREFIX_WORKSPACE_RESOURCE.equals(prefix))
                {
                    IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path((String) resource.getValue()));
                    return wlp.getImage(iFile);
                }
            }

            return null;
        }
    }

    /**
     * A class defining a dialog to add or edit a worksapce resource.
     */
    private class WorkspaceResourceDialog extends ResourceSelectionDialog
    {
        /**
         * Constructor
         * 
         * @param parentShell
         */
        public WorkspaceResourceDialog(Shell parentShell)
        {
            super(parentShell, ResourcesPlugin.getWorkspace().getRoot(), "Please select the workspace resources to add to the documentation.");
        }
    }

    /**
     * A class defining a dialog to add or edit a remote resource.
     */
    private class RemoteResourceDialog extends InputDialog
    {

        /**
         * Constructor
         * 
         * @param parentShell
         * @param initialValue
         */
        public RemoteResourceDialog(Shell parentShell, String initialValue)
        {
            super(parentShell, "Remote resource", "Please enter the URL of the remote resource.", initialValue, null);
        }
    }
}
