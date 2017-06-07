/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Caroline Bourdeu d'Aguerre - caroline.bourdeudaguerre@atosorigin.com - execute the run command in a compound command in order to manage undo/redo
 *******************************************************************************/
package org.topcased.modeler.internal.actions;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;
import org.topcased.modeler.commands.CreateDiagramCommand;
import org.topcased.modeler.commands.CreateDiagramsCommand;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.diagrams.model.util.DiagramsUtils;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.extensions.DiagramDescriptor;
import org.topcased.modeler.extensions.ICreationDiagram;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.preferences.ModelerPreferenceConstants;
import org.topcased.modeler.utils.Utils;

/**
 * Create a new Diagram linked with a model object.<br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @author <a href="mailto:maxime.leray@atosorigin.com">Maxime Leray</a>
 */
public class CreateDiagramAction extends Action
{
    private final DiagramDescriptor diagramDescriptor;

    private final EObject object;

    private final Modeler editor;

    private final boolean initializeContent;

    private final Command creationCommand;
    
    private boolean useDefaultName = false;

	private boolean displayDialog = true;

    /**
     * Constructor
     * 
     * @param ed the Modeler object
     * @param obj the model object associated with the diagram
     * @param diagram the DiagramDescriptor associated with the diagram to create
     */
    public CreateDiagramAction(Modeler ed, EObject obj, DiagramDescriptor diagram)
    {
        this(ed, obj, diagram, false);
    }

    /**
     * Constructor
     * 
     * @param ed the Modeler object
     * @param obj the model object associated with the diagram
     * @param diagram the DiagramDescriptor associated with the diagram to create
     * @param initialize if the children of the model objects must be imported graphically in the diagram
     */
    public CreateDiagramAction(Modeler ed, EObject obj, DiagramDescriptor diagram, boolean initialize)
    {
        super(diagram.getName());
        this.editor = ed;
        this.object = obj;
        this.diagramDescriptor = diagram;
        this.initializeContent = initialize;
        this.creationCommand = diagramDescriptor.getCreationCommand(object);

        ImageDescriptor icon = this.diagramDescriptor.getIconDescriptor();
        if (icon != null)
        {
            setImageDescriptor(icon);
        }
    }
    
    /**
     * Constructor.
     *
     * @param ed the Modeler object
     * @param obj the model object associated with the diagram
     * @param diagram the DiagramDescriptor associated with the diagram to create
     * @param initialize if the children of the model objects must be imported graphically in the diagram
     * @param useDefaultName create the diagram using the default name
     * @param displayDialog display the dialog box for drag and drop information
     */
    public CreateDiagramAction(Modeler ed, EObject obj, DiagramDescriptor diagram, boolean initialize, boolean useDefaultName, boolean displayDialog)
    {
    	this(ed, obj, diagram, initialize);
        this.useDefaultName = useDefaultName;
        this.displayDialog  = displayDialog;
    }

    /**
     * Execute the Action
     * 
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run()
    {
        CompoundCommand compoundCommand = new CompoundCommand("Diagram Creation");
        if (creationCommand == null)
        {
            // The CreateDiagramsCommand should be first executed before the CreateDiagramCommand : indeed, the Diagrams
            // element should be first created when it does not exist yet.
            compoundCommand.add(new CreateDiagramsCommand(editor, object));
            CreateDiagramCommand createDiagramCommand = getCreateDiagramCommand();
            if (createDiagramCommand == null)
            {
                return;
            }
            compoundCommand.add(createDiagramCommand);
            ((CommandStack) editor.getAdapter(CommandStack.class)).execute(compoundCommand);
        }
        else if (creationCommand instanceof ICreationDiagram)
        {
            EObject realObject = ((ICreationDiagram) creationCommand).getLinkedElementWithDiagram(object);

            if (realObject != null)
            {
                compoundCommand.add(creationCommand);
                compoundCommand.add(new CreateDiagramsCommand(editor, realObject));
                compoundCommand.add(getCreateDiagramCommand(realObject));
                ((CommandStack) editor.getAdapter(CommandStack.class)).execute(compoundCommand);
            }
        }
    }

    /**
     * Returns the preference store associated with the current modeler.
     * 
     * @return the preference store
     */
    private IPreferenceStore getPreferenceStore()
    {
        IFile currentFile = Modeler.getCurrentIFile();
        if (currentFile != null)
        {
            IProject project = currentFile.getProject();
            Preferences root = Platform.getPreferencesService().getRootNode();
            if (project != null && root != null)
            {
                try
                {
                    if (root.node(ProjectScope.SCOPE).node(project.getName()).nodeExists(ModelerPlugin.getId()))
                    {
                        return new ScopedPreferenceStore(new ProjectScope(project), ModelerPlugin.getId());
                    }
                }
                catch (BackingStoreException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return ModelerPlugin.getDefault().getPreferenceStore();
    }

    /**
     * Generate the {@link CreateDiagramCommand command} for the creation of a new diagram associated with the given
     * object. Depending on the user preferences, a popup can be opened at first in order to get the name of the
     * diagram.
     * 
     * @param eObject the object
     * @return the generated command. can be null if the user cancels the input of the diagram's name.
     */
    protected CreateDiagramCommand getCreateDiagramCommand(final EObject eObject)
    {
        // initialize the name of the diagram with the name of the object it is created for
        String diagramName = getDefaultDiagramName();
        // if the user wants to customize the name
        if (!useDefaultName && getPreferenceStore().getBoolean(ModelerPreferenceConstants.PREFERENCE_ASK_FOR_DIAGRAM_NAME))
        {
            String defaultName = diagramName == null ? "" : diagramName;
            InputDialog nameDialog = new InputDialog(null, "Name the new diagram", "Enter a name for the new diagram:", defaultName, new IInputValidator()
            {
                public String isValid(String newName)
                {
                    if (eObject.eResource() != null)
                    {
                        List<Diagram> diagrams = DiagramsUtils.findAllExistingDiagramForElement(eObject);
                        for (Diagram diagram : diagrams)
                        {
                            if (newName != null && newName.equals(diagram.getName()))
                            {
                                String error = "\"" + newName + "\" is already used for another diagram.";
                                return error;
                            }
                        }
                    }
                    return null;
                }
            });
            int returnCode = nameDialog.open();
            if (returnCode == InputDialog.CANCEL)
            {
                return null;
            }
            if (nameDialog.getValue() != null)
            {
                diagramName = nameDialog.getValue();
            }
        }
        if (diagramName == null)
        {
            // This case happens when the user wants the default name AND object is not a NamedElement. The label
            // "unnamed" will be used.
            return new CreateDiagramCommand(editor, eObject, diagramDescriptor, initializeContent);
        }
        else
        {
            return new CreateDiagramCommand(editor, eObject, diagramDescriptor, initializeContent, diagramName, this.displayDialog);
        }
    }

    /**
     * Generate the {@link CreateDiagramCommand command} for the creation of a new diagram. Depending on the user
     * preferences, a popup can be opened at first in order to get the name of the diagram.
     * 
     * @return the generated command. can be null if the user cancels the input of the diagram's name.
     */
    public CreateDiagramCommand getCreateDiagramCommand()
    {
        return getCreateDiagramCommand(object);
    }

    /**
     * Generate a default name for the new diagram. It can be either the object name or the object name with a numerical
     * suffix (when many diagrams are added).
     * 
     * @return the object name or null when object is not a NamedElement
     */
    protected String getDefaultDiagramName()
    {
        ReflectiveItemProvider reflectiveItemProvider = new ReflectiveItemProvider(new ReflectiveItemProviderAdapterFactory());
        String defaultName = null;
        try
        {
            defaultName = reflectiveItemProvider.getText(object);
            // getText returns "className objectName"
            defaultName = defaultName.replaceFirst(Utils.formatClassName(object.eClass().getName()), "").trim();
        }
        catch (Exception e1)
        {
            // if any exception occurs, return
            return null;
        }
        List<Diagram> diagrams = DiagramsUtils.findAllExistingDiagramForElement(object);
        boolean nameAlreadyUsed = false;
        for (Diagram diagram : diagrams)
        {
            if (diagram.getName().equals(defaultName))
            {
                nameAlreadyUsed = true;
                break;
            }
        }
        if (nameAlreadyUsed)
        {
            Pattern pattern = Pattern.compile(defaultName + "((\\d)*)");
            SortedSet<String> matchingNames = new TreeSet<String>();
            for (Diagram diagram : diagrams)
            {
                if (pattern.matcher(diagram.getName()).matches())
                {
                    matchingNames.add(diagram.getName());
                }
            }
            String lastName = matchingNames.last();
            Matcher matcher = pattern.matcher(lastName);
            matcher.matches();
            String suffix = "1";
            if (matcher.groupCount() > 1)
            {
                try
                {
                    suffix = String.valueOf(Integer.parseInt(matcher.group(1)) + 1);
                }
                catch (NumberFormatException e)
                {
                    // do nothing
                }
            }
            defaultName += suffix;
        }
        return defaultName;
    }

    @Override
    public boolean isEnabled()
    {
        boolean isReadOnly = false ;
        if (editor != null && object != null)
        {
            EditingDomain domain = editor.getEditingDomain();
            isReadOnly = domain.isReadOnly(object.eResource());
        }
        return !isReadOnly && object != null && editor != null ;
    }
    
    
}
