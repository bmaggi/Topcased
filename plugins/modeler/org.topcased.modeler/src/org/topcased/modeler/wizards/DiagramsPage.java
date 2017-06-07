/*******************************************************************************
 * Copyright (c) 2005, 2008 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 * Guojun Song (Atos Origin), Thibault Landre (Atos Origin) - Fix #889
 ******************************************************************************/
package org.topcased.modeler.wizards;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.topcased.modeler.extensions.DiagramDescriptor;
import org.topcased.modeler.extensions.DiagramsManager;
import org.topcased.modeler.extensions.TemplateDescriptor;
import org.topcased.modeler.extensions.TemplatesManager;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;

/**
 * This page displays the new file information inputs.
 * 
 * <br>
 * creation : 13 dec. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public abstract class DiagramsPage extends WizardPage
{
    private static final String BROWSE_TEXT = "...";

    private String[] forbiddenCharacters = new String[] {"*", "$", "\"", "*", ":", "<", ">", "?", "|", "&"};

    /**
     * Contains the resource that is initially selected when the wizard is opened. In the case of a file with an invalid
     * extension, we store the container of the file. This variable is then used to load the corresponding data in the
     * wizard.
     */
    private IResource selectedResource;

    private boolean allowInit;

    // SWT objects
    private Button existingModelBt;

    private Button newBlankBt;

    private Button newTplModelBt;

    private Button newModelBt;

    private Composite newModelComp;

    private Composite newTplComp;

    private Group newDMGrp;// group for create a new model

    private Composite digComp; // group for choose one diagram

    private Text directoryFd;

    private Group ctGrp;// includes a button of create new model and template

    private Button directoryBt;

    private Text nameFd;

    private ComboViewer diagCbViewer;

    private ComboViewer templateCbViewer;

    private Group existingModelGrp;

    private Text modelFd;

    private Button modelBt;

    private TreeViewer viewer;

    private ComboViewer rootDiagramCbViewer;

    private Button initializeBt;

    private Label tmpLbl;

    private ModifyListener validationListener = new ModifyListener()
    {
        public void modifyText(ModifyEvent e)
        {
            setPageComplete(validatePage());
        }
    };

    /** Error thrown while loading model file */
    private WrappedException errorWhileLoading = null;

    /**
     * Constructor
     * 
     * @param pageName the page title
     * @param selection the selected object
     * @param allowDiagramInitialization
     */
    public DiagramsPage(String pageName, IStructuredSelection selection, boolean allowDiagramInitialization)
    {
        super(pageName);
        setPageComplete(false);

        Object sel = selection.getFirstElement();
        if (sel != null && sel instanceof IResource)
        {
            if (sel instanceof IFile)
            {
                // check if the selected file as the expected extension
                if (((IFile) sel).getFileExtension().equals(getFileExtension()))
                {
                    selectedResource = (IFile) sel;
                }
                else
                {
                    selectedResource = ((IResource) sel).getParent();
                }
            }
            else
            {
                selectedResource = (IResource) sel;
            }
        }
        else
        {
            selectedResource = ModelerPlugin.getWorkspace().getRoot();
        }

        this.allowInit = allowDiagramInitialization;
    }

    /**
     * Creation of the wizard page
     * 
     * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
     */
    public void createControl(Composite parent)
    {
        Composite mainComp = new Composite(parent, SWT.NONE);
        mainComp.setLayout(new GridLayout());
        mainComp.setLayoutData(new GridData(GridData.FILL_BOTH));
        mainComp.setFont(parent.getFont());

        createDestinationGroup(mainComp);

        // Add listeners
        hookListeners();

        // Initialize widgets value
        loadData();

        // Show description on opening
        setErrorMessage(null);
        setMessage(null);
        setControl(mainComp);

        setPageComplete(validatePage());

    }

    /**
     * Create the Destination group
     * 
     * @param parent the Composite
     */
    protected void createDestinationGroup(Composite parent)
    {
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 20;

        // Group activated when the user choose to Create a new Model
        newModelBt = new Button(parent, SWT.RADIO);
        newModelBt.setText("Create model");
        newModelBt.setLayoutData(gd);

        createNewModelGroup(parent);

        // Group activated when the user choose to Create from an existing Model
        existingModelBt = new Button(parent, SWT.RADIO);
        existingModelBt.setText("Create from an existing Model ");

        existingModelBt.setLayoutData(gd);

        createExistingModelGroup(parent);

    }

    private void createNewModelGroup(Composite parent)
    {
        newDMGrp = new Group(parent, SWT.None);
        newDMGrp.setLayout(new GridLayout(1, false));
        newDMGrp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        newModelComp = new Composite(newDMGrp, SWT.None);
        newModelComp.setLayout(new GridLayout(3, false));
        newModelComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // The destination directory
        Label directoryLbl = new Label(newModelComp, SWT.NONE);
        directoryLbl.setText("Directory : ");

        directoryFd = new Text(newModelComp, SWT.BORDER);
        directoryFd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        directoryFd.setEnabled(false);

        directoryBt = new Button(newModelComp, SWT.PUSH);
        directoryBt.setText(BROWSE_TEXT);

        // The new name of the model file to create
        Label nameLbl = new Label(newModelComp, SWT.NONE);
        nameLbl.setText("Model name : ");

        nameFd = new Text(newModelComp, SWT.BORDER);
        GridData layoutNameFd = new GridData(GridData.FILL_HORIZONTAL);
        layoutNameFd.horizontalSpan = 2;
        nameFd.setLayoutData(layoutNameFd);

        ctGrp = new Group(newDMGrp, SWT.NONE);
        ctGrp.setLayout(new GridLayout(1, false));
        ctGrp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        newTplModelBt = new Button(ctGrp, SWT.RADIO);
        newTplModelBt.setText("From template model");
        newTplModelBt.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        newTplComp = new Composite(ctGrp, SWT.NONE);
        newTplComp.setLayout(new GridLayout(2, false));
        newTplComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        this.tmpLbl = new Label(newTplComp, SWT.NONE);
        tmpLbl.setText("Template : ");

        templateCbViewer = new ComboViewer(newTplComp, SWT.READ_ONLY | SWT.BORDER);
        GridData layoutTemplateCbViewer = new GridData(GridData.FILL_HORIZONTAL);
        layoutTemplateCbViewer.horizontalSpan = 1;
        templateCbViewer.getCombo().setLayoutData(layoutTemplateCbViewer);

        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.verticalIndent = 10;

        // Group activated when the user choose to create a new Model file
        newBlankBt = new Button(ctGrp, SWT.RADIO);
        newBlankBt.setText("Empty model with a default diagram");
        newBlankBt.setLayoutData(gd);

        createTemplateGroup(ctGrp);
    }

    private void createTemplateGroup(Composite ctGrp)
    {
        digComp = new Composite(ctGrp, SWT.NONE);
        digComp.setLayout(new GridLayout(3, false));
        digComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // Template selection
        Label templLbl = new Label(digComp, SWT.NONE);
        templLbl.setText("Diagram : ");

        diagCbViewer = new ComboViewer(digComp, SWT.READ_ONLY | SWT.BORDER);
        GridData layoutTemplateCbViewer = new GridData(GridData.FILL_HORIZONTAL);
        layoutTemplateCbViewer.horizontalSpan = 2;
        diagCbViewer.getCombo().setLayoutData(layoutTemplateCbViewer);

    }

    private void createExistingModelGroup(Composite parent)
    {
        existingModelGrp = new Group(parent, SWT.NONE);
        existingModelGrp.setLayout(new GridLayout(3, false));
        existingModelGrp.setLayoutData(new GridData(GridData.FILL_BOTH));

        // Selection of the existing model file
        Label modelLbl = new Label(existingModelGrp, SWT.NONE);
        modelLbl.setText("Model : ");

        modelFd = new Text(existingModelGrp, SWT.BORDER);
        modelFd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        modelFd.setEnabled(false);

        modelBt = new Button(existingModelGrp, SWT.PUSH);
        modelBt.setText(BROWSE_TEXT);

        // The TreeViewer of the model
        Label viewerLbl = new Label(existingModelGrp, SWT.NONE);
        viewerLbl.setText("Select : ");

        viewer = new TreeViewer(existingModelGrp, SWT.SINGLE | SWT.BORDER);
        GridData gdViewer = new GridData(GridData.FILL_BOTH);
        gdViewer.horizontalSpan = 2;
        gdViewer.minimumHeight = 60;
        viewer.getTree().setLayoutData(gdViewer);

        Label rootDiagramLbl = new Label(existingModelGrp, SWT.NONE);
        rootDiagramLbl.setText("Root Diagram : ");

        rootDiagramCbViewer = new ComboViewer(existingModelGrp, SWT.READ_ONLY | SWT.BORDER);
        GridData layoutRootDiagramCbViewer = new GridData(GridData.FILL_HORIZONTAL);
        layoutRootDiagramCbViewer.horizontalSpan = 2;
        rootDiagramCbViewer.getCombo().setLayoutData(layoutRootDiagramCbViewer);

        if (allowInit)
        {
            initializeBt = new Button(existingModelGrp, SWT.CHECK);
            initializeBt.setText("Initialize the diagram with existing model objects");
            GridData gdInit = new GridData(GridData.FILL_HORIZONTAL);
            gdInit.horizontalSpan = 3;
            initializeBt.setLayoutData(gdInit);
        }

    }

    /**
     * Initialize widgets value
     */
    private void loadData()
    {
        newModelBt.setSelection(true);
        newDMGrp.setEnabled(true);
        newBlankBt.setSelection(true);

        // Set the template provider
        templateCbViewer.setLabelProvider(new LabelProvider()
        {
            public String getText(Object element)
            {
                // Return the resolution's label.
                if (element instanceof TemplateDescriptor)
                {
                    TemplateDescriptor templateDescriptor = (TemplateDescriptor) element;
                    if (!templateDescriptor.isIsDiagram())
                    {
                        return templateDescriptor.getName();
                    }
                }
                return null;
            }
        });

        // retrieve the templates applicable for a given Topcased editor
        TemplateDescriptor[] templateDescriptors = TemplatesManager.getInstance().getTemplates(getEditorID());

        // Set the template content provider
        templateCbViewer.setContentProvider(new ArrayContentProvider());

        for (TemplateDescriptor templatedescriptor : templateDescriptors)
        {
            if (!templatedescriptor.isIsDiagram())
            {
                templateCbViewer.add(templatedescriptor);
            }
        }

        // Set the initial the template selection

        TemplateDescriptor initialTemplate = TemplatesManager.getInstance().find(getDefaultTemplateModelId());

        if (initialTemplate != null && getEditorID().equals(initialTemplate.getEditorId()))
        {
            templateCbViewer.setSelection(new StructuredSelection(initialTemplate), true);
        }

        // If the combo viewer is empty, then disable the template button
        if (templateCbViewer.getSelection().isEmpty())
        {
            newTplComp.setEnabled(false);
            newTplModelBt.setEnabled(false);
        }

        // Set the diagram provider
        diagCbViewer.setLabelProvider(new LabelProvider()
        {
            public String getText(Object element)
            {
                // Return the resolution's label.
                if (element instanceof TemplateDescriptor)
                {
                    TemplateDescriptor templateDescriptor = (TemplateDescriptor) element;

                    if (templateDescriptor.isIsDiagram())
                    {
                        return templateDescriptor.getName();
                    }

                }
                return "";
            }
        });

        // retrieve the diagrams applicable for a given Topcased editor

        // Set the template content provider
        diagCbViewer.setContentProvider(new ArrayContentProvider());

        for (TemplateDescriptor templatedescriptor : templateDescriptors)
        {
            if (templatedescriptor.isIsDiagram())
            {
                diagCbViewer.add(templatedescriptor);
            }
        }

        TemplateDescriptor initialDiagram = TemplatesManager.getInstance().find(getDefaultTemplateId());

        if (initialDiagram != null && getEditorID().equals(initialDiagram.getEditorId()))
        {
            diagCbViewer.setSelection(new StructuredSelection(initialDiagram), true);
        }

        // Set the label provider
        rootDiagramCbViewer.setLabelProvider(new LabelProvider()
        {
            public String getText(Object element)
            {
                // Return the resolution's label.
                if (element instanceof DiagramDescriptor)
                {
                    DiagramDescriptor diag = (DiagramDescriptor) element;
                    return diag.getName();
                }
                return "";
            }
        });

        // Set the content provider
        rootDiagramCbViewer.setContentProvider(new ArrayContentProvider());

        if (selectedResource instanceof IFile)
        {
            existingModelBt.setSelection(true);
            newModelBt.setSelection(false);
            newModelComp.setEnabled(false);
            newDMGrp.setEnabled(false);

            String path = selectedResource.getFullPath().toString();

            if (setModelPath(path))
            {
                handleRootModelObjectChanged();
                existingModelBt.setFocus();
            }
        }
        else
        {
            existingModelGrp.setEnabled(false);
            setDirectoryPath(selectedResource.getFullPath().toString());
            nameFd.setText("DefaultName");
            nameFd.setFocus();
        }

        if (allowInit)
        {
            initializeBt.setSelection(ModelerPlugin.getDefault().getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_INITIALIZE_DIAGRAM));
        }
    }

    /**
     * Set the directory path text in the corresponding widget
     * 
     * @param path the path string
     */
    public void setDirectoryPath(String path)
    {
        directoryFd.setText(path);
    }

    /**
     * Get the directory path text in the corresponding widget
     * 
     * @return the path string written in widget
     */
    protected String getDirectoryPath()
    {
        return directoryFd.getText();
    }

    /**
     * Set the model path text in the corresponding widget and update necessary widgets
     * 
     * @param path the path string
     * @return true if the file was loaded successfully, return false otherwise.
     */
    public boolean setModelPath(String path)
    {
        modelFd.setText(path);

        // update the other widgets
        return loadModelFile();
    }

    /**
     * Get the model path text in the corresponding widget
     * 
     * @return the path string written in widget
     */
    protected String getModelPathField()
    {
        return modelFd.getText();
    }

    /**
     * Add the listeners to the Buttons and the Text widgets
     */
    private void hookListeners()
    {
        directoryFd.addModifyListener(validationListener);
        nameFd.addModifyListener(validationListener);

        templateCbViewer.getCombo().addModifyListener(new ModifyListener()
        {
            public void modifyText(ModifyEvent e)
            {
                newTplModelBt.setSelection(true);
                newBlankBt.setSelection(false);
                setPageComplete(validatePage());
            }
        });

        modelFd.addModifyListener(validationListener);
        diagCbViewer.getCombo().addModifyListener(new ModifyListener()
        {
            public void modifyText(ModifyEvent e)
            {
                newTplModelBt.setSelection(false);
                newBlankBt.setSelection(true);
                setPageComplete(validatePage());
            }
        });

        rootDiagramCbViewer.getCombo().addModifyListener(validationListener);

        // Button listeners
        directoryBt.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                handleDirectoryChoose();
            }
        });

        modelBt.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                handleModelChoose();
            }
        });

        existingModelBt.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                if (existingModelBt.getSelection())
                {
                    newModelComp.setEnabled(false);
                    newDMGrp.setEnabled(false);
                    existingModelGrp.setEnabled(true);
                    newTplModelBt.setSelection(false);
                }
                setPageComplete(validatePage());
            }
        });

        // listener for button "Create a New Model"
        newModelBt.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                if (newModelBt.getSelection())
                {
                    newModelComp.setEnabled(true);
                    newDMGrp.setEnabled(true);
                    existingModelGrp.setEnabled(false);
                }
                setPageComplete(validatePage());
            }
        });

        viewer.addSelectionChangedListener(new ISelectionChangedListener()
        {
            public void selectionChanged(SelectionChangedEvent event)
            {
                handleRootModelObjectChanged();
                setPageComplete(validatePage());
            }
        });

        if (initializeBt != null)
        {
            initializeBt.addSelectionListener(new SelectionAdapter()
            {
                /**
                 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
                 */
                public void widgetSelected(SelectionEvent e)
                {
                    ModelerPlugin.getDefault().getPreferenceStore().setValue(ModelerPreferenceConstants.P_INITIALIZE_DIAGRAM, initializeBt.getSelection());
                }
            });
        }
    }

    /**
     * Handle the directory choice button action
     */
    protected void handleDirectoryChoose()
    {
        ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(), (IContainer) ModelerPlugin.getWorkspace().getRoot().findMember(getDirectoryPath()), false,
                "Choose the destination directory :");
        if (dialog.open() == Window.OK)
        {
            Object[] results = dialog.getResult();
            if (results.length == 1 && results[0] instanceof IPath)
            {
                IPath newPath = (IPath) results[0];
                setDirectoryPath(newPath.toString());
            }
        }
    }

    /**
     * Handle the model choice button action
     */
    protected void handleModelChoose()
    {
        // The initial directory is always the Workspace
        String initialDirectory = ModelerPlugin.getWorkspace().getRoot().getFullPath().toString();

        ResourceSelectionDialog dialog = new ResourceSelectionDialog(getShell(), ModelerPlugin.getWorkspace().getRoot().findMember(initialDirectory), "Choose an existing model file :");
        if (dialog.open() == Window.OK)
        {
            Object[] results = dialog.getResult();
            if (results.length == 1 && results[0] instanceof IFile)
            {
                setModelPath(((IFile) results[0]).getFullPath().toString());
            }
        }
    }

    /**
     * Handle the change of the root model object. Update the available Diagrams
     */
    protected void handleRootModelObjectChanged()
    {
        if (!viewer.getSelection().isEmpty())
        {
            EObject currentSelectedEObject = (EObject) AdapterFactoryEditingDomain.unwrap(((IStructuredSelection) viewer.getSelection()).getFirstElement());

            if (rootDiagramCbViewer.getContentProvider() != null)
            {
                // retrieve the diagrams available for a given model object
                DiagramDescriptor[] diagramDescriptors = DiagramsManager.getInstance().getDiagrams(currentSelectedEObject, getEditorID());
                rootDiagramCbViewer.setInput(diagramDescriptors);

                // Set the initial selection
                rootDiagramCbViewer.setSelection(new StructuredSelection(diagramDescriptors), true);
            }
        }
    }

    /**
     * Load the modelFile selected and update the associated widgets
     * 
     * @return true if the file was loaded successfully, return false otherwise.
     */
    protected boolean loadModelFile()
    {
        Resource resource = loadResource(getModelPathField());

        if (resource != null)
        {
            ComposedAdapterFactory adapterFactory = getAdapterFactory();

            // Set the tree providers of the model file contents
            AdapterFactoryContentProvider adapterContentProvider = new AdapterFactoryContentProvider(adapterFactory);
            adapterContentProvider.inputChanged(viewer, null, null);
            viewer.setContentProvider(new WizardContentProvider(adapterContentProvider));
            viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

            viewer.setInput(resource.getContents());
            viewer.refresh();
            viewer.setSelection(new StructuredSelection(resource.getContents()), true);

            return true;
        }
        return false;
    }

    /**
     * Load and get the resource at the given path URI
     * 
     * @param modelPath the path URI to the model to load
     * @return the loaded resource
     */
    protected Resource loadResource(String modelPath)
    {
        URI uri = URI.createPlatformResourceURI(getModelPathField(), true);
        try
        {
            return getResourceSet().getResource(uri, true);
        }
        catch (WrappedException e)
        {
            errorWhileLoading = e;
            return null;
        }
    }

    /**
     * Return the ResourceSet used to store the model and diagram file. By default create a new ResourceSet.
     * 
     * @return ResourceSet
     */
    protected ResourceSet getResourceSet()
    {
        return new ResourceSetImpl();
    }

    /**
     * Check if the informations contained in the page are OK
     * 
     * @return true is OK
     */
    protected boolean validatePage()
    {
        // erase all previous messages
        setMessage(null);
        setErrorMessage(null);

        if (isNewModel())
        {
            return validateNewModelGroup();
        }
        else
        {
            if (newModelBt.getSelection())
            {
                return false;
            }
            else
            {
                return validateExistingModel();
            }
        }
    }

    /**
     * Check if the "Create a new model with a diagram" is selected and show a message.
     * 
     * @return true if it is OK
     */
    protected boolean updateMessageAndValidate()
    {
        if (newBlankBt.getSelection())
        {
            setMessage("Define a new model from a selected diagram.", IMessageProvider.NONE);
            return validateNewModelGroup();
        }
        return false;
    }

    /**
     * Check if the "Create from a template model" of "Create a blank model with a class diagram" selected and show
     * related information.
     * 
     * @return true if it is OK
     */
    protected boolean updateTemplateMessageAndValidate()
    {
        if (newTplModelBt.getSelection())
        {
            setMessage("Define a model from a selected source.", IMessageProvider.NONE);
            return validateNewModelGroup();
        }
        return false;
    }

    /**
     * Validate the group if the existing model option is chosen
     * 
     * @return <code>true</code> if data is valid
     */
    private boolean validateExistingModel()
    {
        // the user has choosen an existing model
        if (getModelPathField() == null || "".equals(getModelPathField()))
        {
            setErrorMessage("You have to choose an existing model file.");
            return false;
        }

        if (errorWhileLoading != null)
        {
            setErrorMessage("The model is incorrect. Please, fix it before creating diagram. (You can check errors by opening the model editor)");
            return false;
        }

        if (!findModelPathExtension().equals(getFileExtension()))
        {
            setErrorMessage("Invalid model file. The model must be a " + getFileExtension() + " model.");
            return false;
        }

        if (diagramFileExist())
        {
            setMessage("The diagrams file already exists. It will be overwritten !", IMessageProvider.WARNING);
        }

        if (rootDiagramCbViewer.getSelection() == null || rootDiagramCbViewer.getSelection().isEmpty())
        {
            setErrorMessage("You must select a valid model object that will be associated with a Diagram.");
            return false;
        }

        return true;
    }

    /**
     * Get the extension of the selected model resource
     * 
     * @return file extension
     */
    protected String findModelPathExtension()
    {
        return ((IFile) ModelerPlugin.getWorkspace().getRoot().findMember(getModelPathField())).getFileExtension();
    }

    /**
     * Validate the group if the new model option is chosen
     * 
     * @return <code>true</code> if data is valid
     */
    protected boolean validateNewModelGroup()
    {
        IContainer container = getSelectedIContainer();
        if (container == null || container instanceof IWorkspaceRoot)
        {
            setErrorMessage("The destination is not a valid container.");
            return false;
        }

        if (getModelName() == null || "".equals(getModelName()))
        {
            setErrorMessage("Model name cannot be empty.");
            return false;
        }
        else if (containsForbiddenCharacters(getModelName()))
        {
            setErrorMessage("Model name cannot contains the characters " + toString(forbiddenCharacters));
            return false;
        }
        else if (asciExtended(getModelName()))
        {
            setErrorMessage("Model name cannot contains extended ascii characters");
            return false;
        }
        else
        {
            validateExistingFiles();
        }

        if (!(newTplModelBt.getSelection() || newBlankBt.getSelection()))
        {
            setMessage("Define the model diagram informations.", IMessageProvider.NONE);
            return false;
        }
        else if (getTemplateId() == null && (getDiagramId() == null || "".equals(getDiagramId())))
        {
            setErrorMessage("You must select a Template or a root diagram.");
            return false;
        }

        return true;
    }

    /**
     * Check if the string uses ascii
     * extended characters
     * 
     * @param modelName
     * @return
     */
    private boolean asciExtended(String modelName)
    {
        for (char c : modelName.toCharArray())
        {
            if ((int) c > 127)
            {
                return true;
            }
        }
        return false;
    }

    private String toString(String[] array)
    {
        StringBuffer buffer = new StringBuffer("[");
        boolean first = true;
        for (String s : array)
        {
            if (!first)
            {
                buffer.append(", ");
            }
            if (first)
            {
                first = !first;
            }
            buffer.append(s);
        }
        buffer.append("]");
        return buffer.toString();
    }

    /**
     * Check if the new model name contains forbidden characters
     * 
     * @param modelName
     * @return
     */
    private boolean containsForbiddenCharacters(String modelName)
    {
        boolean result = false;
        for (String c : forbiddenCharacters)
        {
            result |= modelName.contains(c);
        }
        return result;
    }

    /**
     * Check if the created files does not already exist
     */
    private void validateExistingFiles()
    {
        if (modelFileExist())
        {
            if (diagramFileExist())
            {
                setMessage("The model file and the diagram file already exist. They will be overwritten !", IMessageProvider.WARNING);
            }
            else
            {
                setMessage("The model file already exists. It will be overwritten !", IMessageProvider.WARNING);
            }
        }
        else if (diagramFileExist())
        {
            setMessage("The diagram file already exists. It will be overwritten !", IMessageProvider.WARNING);
        }
    }

    private boolean modelFileExist()
    {
        if (isNewModel())
        {
            String path = getDirectoryPath() + getSeparator() + getModelNameWithoutExtension(nameFd.getText()) + "." + getFileExtension();
            return resourceExists(path);
        }
        else
        {
            return resourceExists(getModelPathField());
        }
    }

    private boolean diagramFileExist()
    {
        if (isNewModel())
        {
            String path = getDirectoryPath() + getSeparator() + getModelNameWithoutExtension(nameFd.getText()) + "." + getFileExtension() + "di";
            return resourceExists(path);
        }
        else
        {
            return resourceExists(getModelPathField() + "di");
        }
    }

    /**
     * Get the separator to insert in resource path
     * 
     * @return the file separator
     */
    protected String getSeparator()
    {
        return File.separator;
    }

    /**
     * Check if a resource exists at the given path
     * 
     * @param path file path
     * @return true if resource exists
     */
    protected boolean resourceExists(String path)
    {
        IResource resource = ModelerPlugin.getWorkspace().getRoot().findMember(path);
        return resource != null;
    }

    /**
     * Returns if the diagram must be initialized with model objects
     * 
     * @return <code>true</code> if diagram must be initialized
     */
    public boolean isInitialized()
    {
        if (allowInit)
        {
            return ModelerPlugin.getDefault().getPreferenceStore().getBoolean(ModelerPreferenceConstants.P_INITIALIZE_DIAGRAM);
        }

        return false;
    }

    /**
     * Returns the selected destination container
     * 
     * @return the selected container
     */
    public IContainer getSelectedIContainer()
    {
        if (isNewModel())
        {
            return (IContainer) ModelerPlugin.getWorkspace().getRoot().findMember(getDirectoryPath());
        }
        else
        {
            return ((IFile) ModelerPlugin.getWorkspace().getRoot().findMember(getModelPathField())).getParent();
        }
    }

    /**
     * Returns the selected model name
     * 
     * @return the model name. Returns null if no model file name is set.
     */
    public String getModelName()
    {
        if (isNewModel())
        {
            if (nameFd != null && !nameFd.isDisposed())
            {
                return getModelNameWithoutExtension(nameFd.getText());
            }
        }
        else
        {
            if (modelFd != null && !modelFd.isDisposed())
            {
                return getModelNameWithoutExtension(findModelPathResourceName());
            }
        }
        return null;
    }

    /**
     * Get the name of the selected model resource
     * 
     * @return file extension
     */
    protected String findModelPathResourceName()
    {
        IResource resource = ModelerPlugin.getWorkspace().getRoot().findMember(getModelPathField());
        return resource.getName();
    }

    /**
     * Returns the root EObject of the model file
     * 
     * @return the EObject
     */
    public EObject getRootEObject()
    {
        return ((EList<EObject>) viewer.getInput()).get(0);
    }

    /**
     * Returns the selected EObject that will be associated with the diagrams file. If no object is selected, returns
     * the rootEObject of the model
     * 
     * @return the EObject
     */
    public EObject getDiagramEObject()
    {
        if (((IStructuredSelection) viewer.getSelection()).getFirstElement() == null)
        {
            return getRootEObject();
        }
        else
        {
            return (EObject) AdapterFactoryEditingDomain.unwrap(((IStructuredSelection) viewer.getSelection()).getFirstElement());
        }
    }

    /**
     * Returns the name of the modelFile without extension
     * 
     * @param fullName the name with (or without) extension
     * @return the name of the modelFile without extension
     */
    protected String getModelNameWithoutExtension(String fullName)
    {
        String[] nameSplitted = fullName.split("." + getFileExtension());
        return nameSplitted[0];
    }

    /**
     * Returns the selected template id
     * 
     * @return the selected template id. Returns null if none found
     */
    public String getTemplateId()
    {
        if (templateCbViewer != null)
        {
            IStructuredSelection selection = (IStructuredSelection) templateCbViewer.getSelection();
            if (selection != null && !selection.isEmpty())
            {
                return ((TemplateDescriptor) selection.getFirstElement()).getId();
            }
        }
        // TLE : The following code has been add to keep compatibility with the previous implementation of the diagram
        // page
        // Like this, editors which are not using the new API still work.
        if (diagCbViewer != null)
        {
            IStructuredSelection selection = (IStructuredSelection) diagCbViewer.getSelection();
            if (selection != null && !selection.isEmpty())
            {
                return ((TemplateDescriptor) selection.getFirstElement()).getId();
            }
        }

        return null;
    }

    /**
     * Returns the selected diagram id
     * 
     * @return the selected diagram id. Returns null if none found
     */
    public String getNewDiagramId()
    {
        if (diagCbViewer != null)
        {
            IStructuredSelection selection = (IStructuredSelection) diagCbViewer.getSelection();
            if (selection != null && !selection.isEmpty())
            {
                return ((TemplateDescriptor) selection.getFirstElement()).getId();
            }
        }
        return "";
    }

    /**
     * Returns the selected diagram id
     * 
     * @return the selected diagram id. Returns null if none found
     */
    public String getDiagramId()
    {
        if (rootDiagramCbViewer != null)
        {
            IStructuredSelection selection = (IStructuredSelection) rootDiagramCbViewer.getSelection();
            if (selection != null && !selection.isEmpty())
            {
                return ((DiagramDescriptor) selection.getFirstElement()).getId();
            }
        }
        return "";
    }

    /**
     * Return the choice of creation made by the user
     * 
     * @return true if the model file is not created
     */
    public boolean isNewModel()
    {
        return newModelBt.getSelection();
    }

    /**
     * Return the choice of creation made by the user
     * 
     * @return true if A template model has been selected
     */
    public boolean isNewTemplate()
    {
        return newTplModelBt.getSelection();
    }

    /**
     * Return the choice of creation made by the user
     * 
     * @return true if A new model from one diagram has been selected
     */
    public boolean isNewModelDiagram()
    {
        return newBlankBt.getSelection();
    }

    /**
     * Subclasses must implement this method to return the editorID on which the templates should be filtered
     * 
     * @return the string that represent an editorID
     */
    public abstract String getEditorID();

    /**
     * Subclasses must implement this method to return the file extension
     * 
     * @return the string that represent the model file extension
     */
    public abstract String getFileExtension();

    /**
     * Subclasses must implement this method to return the ComposedAdapterFactory
     * 
     * @return the ComposedAdapterFactory
     */
    public abstract ComposedAdapterFactory getAdapterFactory();

    /**
     * Subclasses must implement this <code>IWizard</code> method to perform any special finish processing for their
     * wizard.
     * 
     * @return the ComposedAdapterFactory
     */
    public abstract String getDefaultTemplateId();

    /**
     * 
     * @return
     */
    public String getDefaultTemplateModelId()
    {
        return "";
    }

}
