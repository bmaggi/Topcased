/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos Origin) vincent.hemery@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/

package org.topcased.modeler.internal.actions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.topcased.modeler.ModelerActionConstants;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.diagrams.model.Diagrams;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.extensions.SynchronizedModelDiagramRule;
import org.topcased.modeler.extensions.SynchronizedModelDiagramRulesManager;
import org.topcased.modeler.internal.ModelerImageRegistry;
import org.topcased.modeler.internal.ModelerPlugin;
import org.topcased.modeler.internal.dialogs.SynchronizedModelDiagramErrorDialog;

/**
 * The Class SynchronizedModelDiagramReportAction reports all problems of synchronization between graphical parents and
 * semantic parent in the diagrams of the current modeler.
 */
public class SynchronizedModelDiagramReportAction extends WorkbenchPartAction
{

    /** The index constants for error details elements. */
    public static final int DETAILS_SIZE = 8;

    public static final int DIAGRAM_NAME_INDEX = 0;

    public static final int OBJECT_NAME_INDEX = 1;

    public static final int OBJECT_LONG_NAME_INDEX = 2;

    public static final int MODEL_PARENT_NAME_INDEX = 3;

    public static final int MODEL_PARENT_LONG_NAME_INDEX = 4;

    public static final int GRAPHICAL_PARENT_NAME_INDEX = 5;

    public static final int GRAPHICAL_PARENT_LONG_NAME_INDEX = 6;

    public static final int DIAGRAM_PART_URI = 6;

    /** The message constants */

    private static final String ERROR_MESSAGE = "Some objects do not have the same parents in the model and in diagrams. Look at the details to know the currently assigned parents.";

    private static final String NO_ERROR_MESSAGE = "No problem detected.";

    private static final String TITLE_NO_ERROR = "Model and diagrams are synchronized";

    private static final String TITLE_ERROR = "Model and diagrams are not synchronized";

    private static final String MARKER_MESSAGE = "The graphic element's parent in the diagram is %s whereas the element's parent in the model is %s.";

    private static final String MARKER_LOCATION = "Diagram %s : %s";

    /** The error information. */
    private List<List<String>> mErrorInformation = new LinkedList<List<String>>();

    /**
     * The Constructor.
     * 
     * @param pPart the IWorkbenchPart
     */
    public SynchronizedModelDiagramReportAction(IWorkbenchPart pPart)
    {
        super(pPart);
    }

    /**
     * See graphical elements which are not represented in their parents.
     * 
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run()
    {
        eraseInformation();

        IFile lCheckedFile = null;

        IWorkbenchPart lPart = getWorkbenchPart();
        if (lPart instanceof Modeler)
        {
            Modeler lModeler = (Modeler) lPart;
            IFileEditorInput lInput = (IFileEditorInput) lModeler.getEditorInput();
            lCheckedFile = lInput.getFile();

            Diagram lActiveDiagram = lModeler.getActiveDiagram();

            List<Diagram> lDiagramList = collectEveryDiagramFromDiagrams(lModeler.getDiagrams());

            for (Diagram lDiagram : lDiagramList)
            {
                lModeler.setActiveDiagram(lDiagram);
                RootEditPart lRootEditPart = lModeler.getRootEditPart();
                EditPart lDiagramPart = lRootEditPart.getContents();
                for (Object lChildPart : lDiagramPart.getChildren())
                {
                    if (lChildPart instanceof GraphicalEditPart)
                    {
                        collectSynchronizationInformation((GraphicalEditPart) lChildPart, lDiagram.getName());
                    }
                }
            }

            // reset active diagram
            lModeler.setActiveDiagram(lActiveDiagram);
        }

        reportInformation(lCheckedFile);
    }

    /**
     * Collect every diagram from diagrams.
     * 
     * @param pDiagrams the diagrams
     * 
     * @return the list of all diagram elements
     */
    private List<Diagram> collectEveryDiagramFromDiagrams(Diagrams pDiagrams)
    {
        // get top level diagram elements.
        List<Diagram> lAllDiagrams = new ArrayList<Diagram>(pDiagrams.getDiagrams());

        // then add all diagram elements from subdiagrams elements.
        for (Diagrams lSubDiagrams : pDiagrams.getSubdiagrams())
        {
            lAllDiagrams.addAll(collectEveryDiagramFromDiagrams(lSubDiagrams));
        }

        return lAllDiagrams;
    }

    /**
     * Erase information.
     */
    private void eraseInformation()
    {
        mErrorInformation.clear();

    }

    /**
     * Report information.
     * 
     * @param pCheckedFile the file on which the checked is performed.
     */
    private void reportInformation(IFile pCheckedFile)
    {
        if (isSynchronized())
        {
            Display.getDefault().asyncExec(new Runnable()
            {
                public void run()
                {
                    MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), TITLE_NO_ERROR, getInformationMessage());
                }
            });
        }
        else
        {
            Display.getDefault().asyncExec(new Runnable()
            {
                public void run()
                {
                    SynchronizedModelDiagramErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), TITLE_ERROR, getInformationMessage(), getInformationDetails(),
                            IStatus.WARNING);
                }
            });
        }

        if (pCheckedFile != null)
        {
            // update problems log on the file
            try
            {
                pCheckedFile.deleteMarkers(SynchronizedModelDiagramRulesManager.SYNCHRONIZED_MODEL_DIAGRAM_RULE_MARKER, true, IResource.DEPTH_ZERO);
            }
            catch (CoreException exception)
            {
                ModelerPlugin.log(exception);
            }

            if (!isSynchronized())
            {
                // log new problems
                createMarkers(pCheckedFile);
            }
        }

    }

    /**
     * Creates the markers on the file.
     * 
     * @param pCheckedFile the checked file
     */
    private void createMarkers(IFile pCheckedFile)
    {
        if (pCheckedFile != null)
        {
            for (List<String> lErrorDetails : getInformationDetails())
            {
                try
                {
                    IMarker marker = pCheckedFile.createMarker(SynchronizedModelDiagramRulesManager.SYNCHRONIZED_MODEL_DIAGRAM_RULE_MARKER);
                    marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
                    String lMsg = String.format(MARKER_MESSAGE, lErrorDetails.get(GRAPHICAL_PARENT_NAME_INDEX), lErrorDetails.get(MODEL_PARENT_NAME_INDEX));
                    marker.setAttribute(IMarker.MESSAGE, lMsg);
                    String lLocation = String.format(MARKER_LOCATION, lErrorDetails.get(DIAGRAM_NAME_INDEX), lErrorDetails.get(OBJECT_NAME_INDEX));
                    marker.setAttribute(IMarker.LOCATION, lLocation);
                    marker.setAttribute(SynchronizedModelDiagramRulesManager.URI_MARKER_ATTRIBUTE, lErrorDetails.get(DIAGRAM_PART_URI));
                }
                catch (CoreException exception)
                {
                    ModelerPlugin.log(exception);
                }
            }
        }
    }

    /**
     * Checks if is synchronized.
     * 
     * @return true, if is synchronized
     */
    private boolean isSynchronized()
    {
        return mErrorInformation.isEmpty();
    }

    /**
     * Collect synchronization information from an edit part and its children.
     * 
     * @param pEditPart the edit part
     * @param pDiagramName the diagram name
     */
    private void collectSynchronizationInformation(GraphicalEditPart pEditPart, String pDiagramName)
    {
        DecorationEditPolicy lDecorationPolicy = new DecorationEditPolicy();
        lDecorationPolicy.setHost(pEditPart);
        IDecoratorTarget lDecorationTarget = lDecorationPolicy.new DecoratorTarget();

        EObject lObject = (EObject) lDecorationTarget.getAdapter(EObject.class);

        SynchronizedModelDiagramRule lRule = SynchronizedModelDiagramRulesManager.getInstance().getRuleTesterForElement(lObject, pEditPart);

        if (lRule != null && !lRule.hasRightGraphicParent(lDecorationTarget))
        {
            storeInformation(pDiagramName, pEditPart, lRule, lObject, lDecorationTarget);
        }

        for (Object lChildPart : pEditPart.getChildren())
        {
            if (lChildPart instanceof GraphicalEditPart)
            {
                collectSynchronizationInformation((GraphicalEditPart) lChildPart, pDiagramName);
            }
        }
    }

    private void storeInformation(String pDiagramName, GraphicalEditPart pEditPart, SynchronizedModelDiagramRule pRule, EObject pObject, IDecoratorTarget pDecorationTarget)
    {
        List<String> lPieceOfInformation = new ArrayList<String>();
        lPieceOfInformation.add(DIAGRAM_NAME_INDEX, pDiagramName);
        String lObjectName = pRule.getEObjectName(pObject, false);
        lPieceOfInformation.add(OBJECT_NAME_INDEX, lObjectName);
        String lObjectLongName = pRule.getEObjectName(pObject, true);
        lPieceOfInformation.add(OBJECT_LONG_NAME_INDEX, lObjectLongName);
        String lModelParentName = pRule.getModelParentName(pDecorationTarget, false);
        lPieceOfInformation.add(MODEL_PARENT_NAME_INDEX, lModelParentName);
        String lModelParentLongName = pRule.getModelParentName(pDecorationTarget, true);
        lPieceOfInformation.add(MODEL_PARENT_LONG_NAME_INDEX, lModelParentLongName);
        String lGraphicalParentName = pRule.getGraphicalParentName(pDecorationTarget, false);
        lPieceOfInformation.add(GRAPHICAL_PARENT_NAME_INDEX, lGraphicalParentName);
        String lGraphicalParentLongName = pRule.getGraphicalParentName(pDecorationTarget, true);
        lPieceOfInformation.add(GRAPHICAL_PARENT_LONG_NAME_INDEX, lGraphicalParentLongName);
        String lDiagramPartURI = null;
        Object lPartModel = pEditPart.getModel();
        if (lPartModel instanceof EObject)
        {
            lDiagramPartURI = EcoreUtil.getURI((EObject) lPartModel).toString();
        }
        lPieceOfInformation.add(DIAGRAM_PART_URI, lDiagramPartURI);
        mErrorInformation.add(lPieceOfInformation);
    }

    /**
     * Gets the information message.
     * 
     * @return the information message
     */
    private String getInformationMessage()
    {
        if (mErrorInformation.isEmpty())
        {
            return NO_ERROR_MESSAGE;
        }
        else
        {
            return ERROR_MESSAGE;
        }
    }

    /**
     * Gets the information details.
     * 
     * @return the information details
     */
    private List<List<String>> getInformationDetails()
    {
        return mErrorInformation;
    }

    /**
     * Determine if the action must appear in the context menu.
     * 
     * @return true, if calculate enabled
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
     */
    @Override
    protected boolean calculateEnabled()
    {
        return true;
    }

    /**
     * Initializes the paste action.
     * 
     * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#init()
     */
    protected void init()
    {
        setId(ModelerActionConstants.SYNCHRONIZED_MODEL_DIAGRAM_REPORT);
        setText("Report synchronization problems between model and diagrams");
        setImageDescriptor(ModelerImageRegistry.getImageDescriptor("SYNCHRONIZED_MODEL_DIAGRAM_REPORT"));
    }

}
