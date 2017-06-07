/*******************************************************************************
 * Copyright (c) 2005, 2008 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Gilles Cannenterre (Anyware Technologies) - Fix bugs #1161 and #1247
 *******************************************************************************/
package org.topcased.modeler.internal.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.topcased.modeler.ModelerPropertyConstants;
import org.topcased.modeler.commands.EMFtoGEFCommandWrapper;
import org.topcased.modeler.di.model.GraphElement;
import org.topcased.modeler.di.model.GraphNode;
import org.topcased.modeler.di.model.util.DIUtils;
import org.topcased.modeler.edit.DiagramEditPart;
import org.topcased.modeler.edit.EMFGraphNodeEditPart;
import org.topcased.modeler.editor.IMixedEditDomain;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.exceptions.BoundsFormatException;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.actions.GraphicalPropertiesMap.GraphicalProperties;
import org.topcased.modeler.tools.Importer;
import org.topcased.modeler.tools.Importer.ImporterRunnable;
import org.topcased.modeler.utils.Utils;

/**
 * Create and send paste order with the new object to copy
 * 
 * @author jako
 */
public class PasteAction extends SelectionAction
{
    /** The Modeler editDomain */
    private IMixedEditDomain editDomain;

    /** This records the command. */
    private EMFtoGEFCommandWrapper command;

    /** The modeler. */
    private Modeler modeler;

    /** The part targeted. */
    private AbstractGraphicalEditPart target;

    private GraphicalPropertiesMap map;

    /**
     * Paste the contents from the {@link org.eclipse.gef.ui.actions.Clipboard} to current selection
     * 
     * @param part the part associated with this action
     */
    public PasteAction(IWorkbenchPart part)
    {
        super(part);
        editDomain = (IMixedEditDomain) getWorkbenchPart().getAdapter(IMixedEditDomain.class);
        modeler = (Modeler) getWorkbenchPart().getAdapter(Modeler.class);
        setActionDefinitionId("org.eclipse.ui.edit.paste");
    }

    /**
     * Initializes the paste action
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setText("&Paste");
        setToolTipText("Paste");
        setId(ActionFactory.PASTE.getId());
        ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
        setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
        setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE_DISABLED));
        setEnabled(false);
    }

    /**
     * Executes the command.
     */
    public void run()
    {
        // this guard is for extra security, but should not be necessary
        if (editDomain != null && modeler != null && command != null && target != null)
        {
            List<EObject> possibleOrphanFeatures = findAllExternalReferences(editDomain.getEMFEditingDomain().getClipboard());
            Object[] refToRemove = null;
            if (!possibleOrphanFeatures.isEmpty())
            {
                refToRemove = checkExternalReferences(possibleOrphanFeatures);
                if (refToRemove == null)
                {
                    return;
                }
            }

            // use up the command
            editDomain.getGEFCommandStack().execute(command);
            // Clean of external references is done after the command has been executed. Indeed we do not change
            // Clipboard contents.
            cleanExternalReferences(refToRemove, command.getEMFCommand().getResult());

            // import to diagram
            List<Object> pastedEObjects = new ArrayList<Object>();
            pastedEObjects.addAll(command.getEMFCommand().getResult());
            Importer importer = new Importer(modeler, pastedEObjects);

            target.getFigure().validate();
            importer.setTargetEditPart(target);

            Dimension insets = new Dimension(10, 10);
            target.getContentPane().translateToAbsolute(insets);
            importer.setLocation(target.getContentPane().getBounds().getTopLeft().translate(insets));
            importer.setCommandStack(editDomain.getGEFCommandStack());
            try
            {
                // copy of the graphical properties, there is only one elements copied so no check for application
                importer.addGraphNodeProcess(new ImporterRunnable()
                {
                    public void run(GraphElement graphElement)
                    {
                        if (map != null)
                        {
                            if (graphElement instanceof GraphNode)
                            {
                                GraphNode node = (GraphNode) graphElement;
                                EObject element = Utils.getElement(node);
                                manageProperty(map.getEquivalent(element), node);
                                for (Iterator<EObject> i = EcoreUtil.getAllProperContents(node, true); i.hasNext();)
                                {
                                    EObject next = i.next();
                                    if (next instanceof GraphNode)
                                    {
                                        GraphNode child = (GraphNode) next;
                                        manageProperty(map.getEquivalent(Utils.getElement(child)), child);
                                    }
                                }
                            }
                        }
                    }
                });
                importer.run(new NullProgressMonitor());
            }
            catch (BoundsFormatException e)
            {
                ModelerPlugin.log(e);
            }
            catch (IllegalArgumentException e)
            {
                ModelerPlugin.log(e);
            }
            catch (InterruptedException e)
            {
                ModelerPlugin.log(e);
            }
        }
    }

    /**
     * manage the property of the element inKey
     * 
     * @param inKey
     * @param node
     */
    private void manageProperty(GraphicalProperties p, GraphNode node)
    {
        if (p != null)
        {
            DIUtils.setProperty(node, ModelerPropertyConstants.BACKGROUND_COLOR, p.getBackGroundColor());
            DIUtils.setProperty(node, ModelerPropertyConstants.FOREGROUND_COLOR, p.getForeGroundColor());
            DIUtils.setProperty(node, ModelerPropertyConstants.FONT, p.getFont());
            if (p.getPosition() != null)
            {
                node.setPosition(p.getPosition());
            }
            node.setSize(p.getDimension());
        }
    }

    private Object[] checkExternalReferences(List<EObject> possibleOrphanFeatures)
    {
        // Show dialog about all involved dependencies
        ListSelectionDialog dlg = new ListSelectionDialog(ModelerPlugin.getActiveWorkbenchShell(), possibleOrphanFeatures, new ArrayContentProvider(), new LabelProvider()
        {
            @Override
            public String getText(Object element)
            {
                String modelName = ((EObject) element).eResource().getURI().lastSegment();
                IItemLabelProvider lblProvider = (IItemLabelProvider) modeler.getAdapterFactory().adapt(element, IItemLabelProvider.class);
                String elementName = lblProvider != null ? lblProvider.getText(element) : "";
                return elementName.concat(" [in model '").concat(modelName).concat("']");
            }

            @Override
            public Image getImage(Object element)
            {
                IItemLabelProvider lblProvider = (IItemLabelProvider) modeler.getAdapterFactory().adapt(element, IItemLabelProvider.class);
                return lblProvider != null ? ExtendedImageRegistry.getInstance().getImage(lblProvider.getImage(element)) : null;
            }
        }, "External references to remove:");
        dlg.setTitle("Involved dependencies");
        dlg.setInitialSelections(possibleOrphanFeatures.toArray());
        dlg.open();
        return dlg.getResult();
    }

    private void cleanExternalReferences(Object[] refToRemove, Collection< ? > copiedElements)
    {
        if (refToRemove != null)
        {
            for (int i = 0; i < refToRemove.length; i++)
            {
                Collection<Setting> settings = EcoreUtil.UsageCrossReferencer.find((EObject) refToRemove[i], copiedElements);
                for (Setting currentSetting : settings)
                {
                    currentSetting.unset();
                }
            }
        }
    }

    // It would be quite easy to use EcoreUtil.getAllContents to walk a set of EMF objects, traverse the
    // eCrossReferences of each EObject, and to use EcoreUtil.isAncestor to check if each particular cross
    // referenced object is contained within the contents of the set...
    private List<EObject> findAllExternalReferences(Collection< ? > copiedElts)
    {
        List<EObject> possibleOrphanFeatures = new ArrayList<EObject>();
        for (TreeIterator<EObject> allContents = EcoreUtil.getAllContents(copiedElts); allContents.hasNext();)
        {
            EObject currentElt = allContents.next();
            for (EObject currentRef : currentElt.eCrossReferences())
            {
                if (!EcoreUtil.isAncestor(copiedElts, currentRef))
                {
                    possibleOrphanFeatures.add(currentRef);
                }
            }
        }
        return possibleOrphanFeatures;
    }

    /**
     * Returns whether the selected EditPart is a GraphNodeEditPart.
     * 
     * @return whether the selected EditPart is a GraphNodeEditPart
     */
    protected boolean calculateEnabled()
    {
        if (editDomain.getEMFEditingDomain().getClipboard() != null)
        {
            for (Iterator< ? > i = editDomain.getEMFEditingDomain().getClipboard().iterator(); i.hasNext();)
            {
                Object o = i.next();
                if (o instanceof GraphicalPropertiesMap)
                {
                    map = (GraphicalPropertiesMap) o;
                    i.remove();
                }
            }
        }
        return command != null && command.canExecute();
    }

    /**
     * @see org.eclipse.gef.ui.actions.SelectionAction#handleSelectionChanged()
     */
    @Override
    protected void handleSelectionChanged()
    {
        // Update commands
        this.target = null;
        this.command = null;
        ISelection s = getSelection();
        if (!(s instanceof IStructuredSelection))
        {
            return;
        }
        IStructuredSelection selection = (IStructuredSelection) s;

        if (selection != null && selection.size() == 1)
        {
            Object obj = selection.getFirstElement();
            if (obj instanceof EMFGraphNodeEditPart)
            {
                EMFGraphNodeEditPart ed = (EMFGraphNodeEditPart) obj;
                this.target = ed;
                this.command = createActionCommand(ed.getEObject());
            }
            else if (obj instanceof DiagramEditPart)
            {
                DiagramEditPart ed = (DiagramEditPart) obj;
                this.target = ed;
                this.command = createActionCommand(ed.getEObject());
            }
        }
        super.handleSelectionChanged();
    }

    /**
     * Creates the EMFtoGEFCommandWrapper
     * 
     * @param object the selected EObject
     * @return the command
     */
    protected EMFtoGEFCommandWrapper createActionCommand(EObject object)
    {
        EMFtoGEFCommandWrapper cmd = null;
        if (object != null)
        {
            EMFtoGEFCommandWrapper gefCommand = null;
            // if we found an editing domain, create command
            if (editDomain != null)
            {
                Command emfCommand = (PasteFromClipboardCommand) PasteFromClipboardCommand.create(editDomain.getEMFEditingDomain(), object, null);
                gefCommand = new EMFtoGEFCommandWrapper(emfCommand);
            }
            cmd = gefCommand;
        }
        return cmd;
    }

}
