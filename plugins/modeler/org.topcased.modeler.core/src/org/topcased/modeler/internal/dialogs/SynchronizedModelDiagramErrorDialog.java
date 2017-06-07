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

package org.topcased.modeler.internal.dialogs;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IconAndMessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.topcased.modeler.internal.actions.SynchronizedModelDiagramReportAction;

/**
 * The Class SynchronizedModelDiagramErrorDialog displays the error report for the SynchronizedModelDiagramReportAction
 * action.
 */
public final class SynchronizedModelDiagramErrorDialog extends IconAndMessageDialog
{

    /**
     * Reserve room for this many list items.
     */
    private static final int LIST_ITEM_COUNT = 8;

    private static final String DIAGRAM_NAME_TITLE = "In diagram";

    private static final String ELEMENT_NAME_TITLE = "Element Name";

    private static final String GRAPHICAL_PARENT_NAME_TITLE = "Graphical parent name";

    private static final String MODEL_PARENT_NAME_TITLE = "Model parent name";

    /**
     * The Details button.
     */
    private Button mDetailsButton;

    /**
     * The title of the dialog.
     */
    private String mTitle;

    /**
     * The SWT Table control that displays the error details.
     */
    private Table mTable;

    /**
     * Indicates whether the error details viewer is currently created.
     */
    private boolean mTableCreated = false;

    /** The severity. */
    private int mSeverity = IStatus.ERROR;

    /**
     * The current clipboard. To be disposed when closing the dialog.
     */
    private Clipboard mClipboard;

    /** The error details. */
    private List<List<String>> mErrorDetails;

    /**
     * Creates an error dialog. Note that the dialog will have no visual representation (no widgets) until it is told to
     * open.
     * <p>
     * Normally one should use <code>openError</code> to create and open one of these.
     * </p>
     * 
     * @param pParentShell the shell under which to create this dialog
     * @param pDialogTitle the title to use for this dialog
     * @param pMessage the message to show in this dialog
     * @param pErrorDetails the error details to show to the user. Each element should be of size 7.
     * @param pSeverity the severity of the error : IStatus.INFO, IStatus.WARNING or IStatus.ERROR
     */
    private SynchronizedModelDiagramErrorDialog(Shell pParentShell, String pDialogTitle, String pMessage, List<List<String>> pErrorDetails, int pSeverity)
    {
        super(pParentShell);
        this.mTitle = pDialogTitle;
        this.message = pMessage;
        this.mErrorDetails = pErrorDetails;
        this.mSeverity = pSeverity;
    }

    /*
     * (non-Javadoc) Method declared on Dialog. Handles the pressing of the Ok or Details button in this dialog. If the
     * Ok button was pressed then close this dialog. If the Details button was pressed then toggle the displaying of the
     * error details area. Note that the Details button will only be visible if the error being displayed specifies
     * child details.
     */
    protected void buttonPressed(int pId)
    {
        if (pId == IDialogConstants.DETAILS_ID)
        {
            // was the details button pressed?
            toggleDetailsArea();
        }
        else
        {
            super.buttonPressed(pId);
        }
    }

    /**
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    @Override
    protected void configureShell(Shell pShell)
    {
        super.configureShell(pShell);
        pShell.setText(mTitle);
    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void createButtonsForButtonBar(Composite pParent)
    {
        // create OK and Details buttons
        createButton(pParent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createDetailsButton(pParent);
    }

    /**
     * Create the details button if it should be included.
     * 
     * @param pParent the parent composite
     */
    protected void createDetailsButton(Composite pParent)
    {
        mDetailsButton = createButton(pParent, IDialogConstants.DETAILS_ID, IDialogConstants.SHOW_DETAILS_LABEL, false);
    }

    /**
     * This implementation of the <code>Dialog</code> framework method creates and lays out a composite. Subclasses that
     * require a different dialog area may either override this method, or call the <code>super</code> implementation
     * and add controls to the created composite.
     */
    protected Control createDialogArea(Composite pParent)
    {
        createMessageArea(pParent);
        // create a composite with standard margins and spacing
        Composite lComposite = new Composite(pParent, SWT.NONE);
        GridLayout lLayout = new GridLayout();
        lLayout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
        lLayout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
        lLayout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
        lLayout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
        lLayout.numColumns = 2;
        lComposite.setLayout(lLayout);
        GridData lChildData = new GridData(GridData.FILL_BOTH);
        lChildData.horizontalSpan = 2;
        lChildData.grabExcessVerticalSpace = false;
        lComposite.setLayoutData(lChildData);
        lComposite.setFont(pParent.getFont());

        return lComposite;
    }

    /**
     * @see IconAndMessageDialog#createDialogAndButtonArea(Composite)
     */
    @Override
    protected void createDialogAndButtonArea(Composite pParent)
    {
        super.createDialogAndButtonArea(pParent);
        if (this.dialogArea instanceof Composite)
        {
            // Create a label if there are no children to force a smaller layout
            Composite lDialogComposite = (Composite) dialogArea;
            if (lDialogComposite.getChildren().length == 0)
            {
                new Label(lDialogComposite, SWT.NULL);
            }
        }
    }

    /**
     * 
     * 
     * @see org.eclipse.jface.dialogs.IconAndMessageDialog#getImage()
     */
    protected Image getImage()
    {
        if (mSeverity == IStatus.WARNING)
        {
            return getWarningImage();
        }
        if (mSeverity == IStatus.INFO)
        {
            return getInfoImage();
        }

        // If it was not a warning or an info then return the error image
        return getErrorImage();
    }

    /**
     * Create this dialog's drop-down table component.
     * 
     * @param pParent the parent composite
     * @return the drop-down table component
     */
    protected Table createDropDownTable(Composite pParent)
    {
        // create the list
        Table lTable = new Table(pParent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
        // fill the list
        populateTable(lTable);
        GridData lData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL | GridData.GRAB_VERTICAL);
        lData.heightHint = lTable.getItemHeight() * LIST_ITEM_COUNT;
        lData.horizontalSpan = 2;
        lTable.setLayoutData(lData);
        lTable.setFont(pParent.getFont());
        Menu lCopyMenu = new Menu(lTable);
        MenuItem lCopyItem = new MenuItem(lCopyMenu, SWT.NONE);
        lCopyItem.addSelectionListener(new SelectionListener()
        {
            /*
             * @see SelectionListener.widgetSelected (SelectionEvent)
             */
            public void widgetSelected(SelectionEvent e)
            {
                copyToClipboard();
            }

            /*
             * @see SelectionListener.widgetDefaultSelected(SelectionEvent)
             */
            public void widgetDefaultSelected(SelectionEvent e)
            {
                copyToClipboard();
            }
        });
        lCopyItem.setText(JFaceResources.getString("copy")); //$NON-NLS-1$
        lTable.setMenu(lCopyMenu);
        mTableCreated = true;

        return lTable;
    }

    /*
     * (non-Javadoc) Method declared on Window.
     */
    /**
     * Extends <code>Window.open()</code>. Opens an error dialog to display the error. If you specified a mask to filter
     * the displaying of these children, the error dialog will only be displayed if there is at least one child status
     * matching the mask.
     */
    public int open()
    {
        return super.open();
    }

    /**
     * Opens an error dialog to display the given error. Use this method if the error object being displayed does not
     * contain child items, or if you wish to display all such items without filtering.
     * 
     * @param pParent the parent shell of the dialog
     * @param pDialogTitle the title to use for this dialog
     * @param pMessage the message to show in this dialog
     * @param pErrorDetails the error details to show to the user. Each element should be of size 7.
     * @return the code of the button that was pressed that resulted in this dialog closing. This will be
     *         <code>Dialog.OK</code> if the OK button was pressed, or <code>Dialog.CANCEL</code> if this dialog's close
     *         window decoration or the ESC key was used.
     */
    public static int openError(Shell pParent, String pDialogTitle, String pMessage, List<List<String>> pErrorDetails)
    {
        return openError(pParent, pDialogTitle, pMessage, pErrorDetails, IStatus.ERROR);
    }

    /**
     * Opens an error dialog to display the given error. Use this method if the error object being displayed contains
     * child items <it>and </it> you wish to specify a mask which will be used to filter the displaying of these
     * children. The error dialog will only be displayed if there is at least one child status matching the mask.
     * 
     * @param pParentShell the parent shell of the dialog
     * @param pTitle the title to use for this dialog
     * @param pMessage the message to show in this dialog
     * @param pErrorDetails the error details to show to the user. Each element should be of size 7.
     * @param pSeverity the severity of the error : IStatus.INFO, IStatus.WARNING or IStatus.ERROR
     * @return the code of the button that was pressed that resulted in this dialog closing. This will be
     *         <code>Dialog.OK</code> if the OK button was pressed, or <code>Dialog.CANCEL</code> if this dialog's close
     *         window decoration or the ESC key was used.
     */
    public static int openError(Shell pParentShell, String pTitle, String pMessage, List<List<String>> pErrorDetails, int pSeverity)
    {
        SynchronizedModelDiagramErrorDialog lDialog = new SynchronizedModelDiagramErrorDialog(pParentShell, pTitle, pMessage, pErrorDetails, pSeverity);
        return lDialog.open();
    }

    /**
     * Populates the table using this error details.
     * 
     * @param pTableToPopulate The table to fill.
     */
    private void populateTable(Table pTableToPopulate)
    {

        pTableToPopulate.setHeaderVisible(true);
        pTableToPopulate.setLinesVisible(true);
        TableColumn lColumn0 = new TableColumn(pTableToPopulate, SWT.NONE);
        lColumn0.setText(ELEMENT_NAME_TITLE);
        TableColumn lColumn1 = new TableColumn(pTableToPopulate, SWT.NONE);
        lColumn1.setText(DIAGRAM_NAME_TITLE);
        TableColumn lColumn2 = new TableColumn(pTableToPopulate, SWT.NONE);
        lColumn2.setText(GRAPHICAL_PARENT_NAME_TITLE);
        TableColumn lColumn3 = new TableColumn(pTableToPopulate, SWT.NONE);
        lColumn3.setText(MODEL_PARENT_NAME_TITLE);

        TableViewer lDetailsViewer = new TableViewer(pTableToPopulate);

        lDetailsViewer.setContentProvider(new DetailEntryContentProvider());
        lDetailsViewer.setLabelProvider(new DetailEntryLabelProvider());
        ColumnViewerToolTipSupport.enableFor(lDetailsViewer, ToolTip.NO_RECREATE);

        lDetailsViewer.setInput(mErrorDetails);

        lColumn0.pack();
        lColumn1.pack();
        lColumn2.pack();
        lColumn3.pack();
    }

    /**
     * The Class DetailEntryContentProvider provides the detailed elements to the table widget.
     */
    private class DetailEntryContentProvider implements IStructuredContentProvider
    {

        /**
         * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
         */
        public Object[] getElements(Object pInputElement)
        {
            if (pInputElement instanceof List)
            {
                return ((List< ? >) pInputElement).toArray();
            }
            return new String[][] {};
        }

        /**
         * @see org.eclipse.jface.viewers.IContentProvider#dispose()
         */
        public void dispose()
        {
        }

        /**
         * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
         *      java.lang.Object, java.lang.Object)
         */
        public void inputChanged(Viewer pViewer, Object pOldInput, Object pNewInput)
        {
        }

    }

    /**
     * The Class DetailEntryLabelProvider provides the labels of each cell and the tooltips for displaying the detailed
     * elements in the table widget.
     */
    private class DetailEntryLabelProvider extends CellLabelProvider
    {

        /**
         * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipText(java.lang.Object)
         */
        public String getToolTipText(Object pElement)
        {
            return getDetailEntryToolTipText(pElement);
        }

        /**
         * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipShift(java.lang.Object)
         */
        public Point getToolTipShift(Object pObject)
        {
            return new Point(5, 5);
        }

        /**
         * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipDisplayDelayTime(java.lang.Object)
         */
        public int getToolTipDisplayDelayTime(Object pObject)
        {
            return 0;
        }

        /**
         * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipTimeDisplayed(java.lang.Object)
         */
        public int getToolTipTimeDisplayed(Object pObject)
        {
            return 20000;
        }

        /**
         * @see org.eclipse.jface.viewers.CellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
         */
        public void update(ViewerCell pCell)
        {
            pCell.setText(getDetailCellText(pCell.getElement(), pCell.getColumnIndex()));
        }
    }

    /**
     * Gets the detail entry tool tip text.
     * 
     * @param pElement the element
     * 
     * @return the detail entry tool tip text
     */
    private String getDetailEntryToolTipText(Object pElement)
    {
        if (pElement instanceof List && ((List< ? >) pElement).size() == SynchronizedModelDiagramReportAction.DETAILS_SIZE)
        {
            StringBuffer tooltip = new StringBuffer();
            tooltip.append(GRAPHICAL_PARENT_NAME_TITLE + " :\n");
            tooltip.append(((List< ? >) pElement).get(SynchronizedModelDiagramReportAction.GRAPHICAL_PARENT_LONG_NAME_INDEX));
            tooltip.append("\n\n");
            tooltip.append(MODEL_PARENT_NAME_TITLE + " :\n");
            tooltip.append(((List< ? >) pElement).get(SynchronizedModelDiagramReportAction.MODEL_PARENT_LONG_NAME_INDEX));
            return tooltip.toString();
        }
        return null;
    }

    /**
     * Gets the detail cell text.
     * 
     * @param pElement the element
     * @param pColumnIndex the column index
     * 
     * @return the cell text
     */
    private String getDetailCellText(Object pElement, int pColumnIndex)
    {
        if (pElement instanceof List && ((List< ? >) pElement).size() == SynchronizedModelDiagramReportAction.DETAILS_SIZE)
        {
            List< ? > lElement = (List< ? >) pElement;
            int lIndex = -1;
            switch (pColumnIndex)
            {
                case 0:
                    lIndex = SynchronizedModelDiagramReportAction.OBJECT_NAME_INDEX;
                    break;
                case 1:
                    lIndex = SynchronizedModelDiagramReportAction.DIAGRAM_NAME_INDEX;
                    break;
                case 2:
                    lIndex = SynchronizedModelDiagramReportAction.GRAPHICAL_PARENT_NAME_INDEX;
                    break;
                case 3:
                    lIndex = SynchronizedModelDiagramReportAction.MODEL_PARENT_NAME_INDEX;
                    break;
                default:
                    break;
            }
            if (lIndex >= 0 && lIndex < SynchronizedModelDiagramReportAction.DETAILS_SIZE)
            {
                Object lResult = lElement.get(lIndex);
                if (lResult instanceof String)
                {
                    return (String) lResult;
                }
            }
        }
        return "";
    }

    /**
     * Toggles the unfolding of the details area. This is triggered by the user pressing the details button.
     */
    private void toggleDetailsArea()
    {
        Point lWindowSize = getShell().getSize();
        Point lOldSize = getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT);
        if (mTableCreated)
        {
            mTable.dispose();
            mTableCreated = false;
            mDetailsButton.setText(IDialogConstants.SHOW_DETAILS_LABEL);
        }
        else
        {
            mTable = createDropDownTable((Composite) getContents());
            mDetailsButton.setText(IDialogConstants.HIDE_DETAILS_LABEL);
            getContents().getShell().layout();
        }
        Point lNewSize = getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT);
        getShell().setSize(new Point(lWindowSize.x, lWindowSize.y + (lNewSize.y - lOldSize.y)));
    }

    /**
     * Put the details of the error onto the stream.
     * 
     * @param pErrorDetails
     * @param pBuffer
     */
    private void populateCopyBuffer(List<List<String>> pErrorDetails, StringBuffer pBuffer)
    {
        pBuffer.append(DIAGRAM_NAME_TITLE);
        pBuffer.append("\t\t");
        pBuffer.append(ELEMENT_NAME_TITLE);
        pBuffer.append("\t\t");
        pBuffer.append(GRAPHICAL_PARENT_NAME_TITLE);
        pBuffer.append("\t\t");
        pBuffer.append(MODEL_PARENT_NAME_TITLE);
        pBuffer.append("\n\n");
        for (List<String> lErrorDetail : pErrorDetails)
        {
            if (lErrorDetail.size() == SynchronizedModelDiagramReportAction.DETAILS_SIZE)
            {
                pBuffer.append(lErrorDetail.get(SynchronizedModelDiagramReportAction.DIAGRAM_NAME_INDEX));
                pBuffer.append("\t\t");
                pBuffer.append(lErrorDetail.get(SynchronizedModelDiagramReportAction.OBJECT_NAME_INDEX));
                pBuffer.append("\t\t");
                pBuffer.append(lErrorDetail.get(SynchronizedModelDiagramReportAction.GRAPHICAL_PARENT_NAME_INDEX));
                pBuffer.append("\t\t");
                pBuffer.append(lErrorDetail.get(SynchronizedModelDiagramReportAction.MODEL_PARENT_NAME_INDEX));
                pBuffer.append("\n");
            }
        }
    }

    /**
     * Copy the contents of the statuses to the clipboard.
     */
    private void copyToClipboard()
    {
        if (mClipboard != null)
        {
            mClipboard.dispose();
        }
        StringBuffer statusBuffer = new StringBuffer();
        populateCopyBuffer(mErrorDetails, statusBuffer);
        mClipboard = new Clipboard(mTable.getDisplay());
        mClipboard.setContents(new Object[] {statusBuffer.toString()}, new Transfer[] {TextTransfer.getInstance()});
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.window.Window#close()
     */
    public boolean close()
    {
        if (mClipboard != null)
        {
            mClipboard.dispose();
        }
        return super.close();
    }

    /**
     * Show the details portion of the dialog if it is not already visible. This method will only work when it is
     * invoked after the control of the dialog has been set. In other words, after the <code>createContents</code>
     * method has been invoked and has returned the control for the content area of the dialog. Invoking the method
     * before the content area has been set or after the dialog has been disposed will have no effect.
     * 
     */
    protected void showDetailsArea()
    {
        if (!mTableCreated)
        {
            Control lControl = getContents();
            if (lControl != null && !lControl.isDisposed())
            {
                toggleDetailsArea();
            }
        }
    }

    /**
     * @see org.eclipse.jface.dialogs.Dialog#isResizable()
     */
    @Override
    protected boolean isResizable()
    {
        return true;
    }

}
