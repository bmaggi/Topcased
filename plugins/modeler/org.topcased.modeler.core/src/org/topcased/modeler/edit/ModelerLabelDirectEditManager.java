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
 *******************************************************************************/
package org.topcased.modeler.edit;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.topcased.draw2d.figures.EditableLabel;
import org.topcased.draw2d.figures.ILabel;

/**
 * @author jako
 */
public class ModelerLabelDirectEditManager extends DirectEditManager
{
    private Font scaledFont;

    private IFigure figure;

    private VerifyListener verifyListener;

    /**
     * Creates a new ModelLabelDirectEditManager with the given attributes.
     * 
     * @param source the source EditPart
     * @param editorType the type of editor
     * @param locator the CellEditorLocator
     * @param fig
     */
    public ModelerLabelDirectEditManager(GraphicalEditPart source, Class<?> editorType, CellEditorLocator locator,
            IFigure fig)
    {
        super(source, editorType, locator);
        figure = fig;
    }

    /**
     * @see org.eclipse.gef.tools.DirectEditManager#initCellEditor()
     */
    protected void initCellEditor()
    {
        Text text = (Text) getCellEditor().getControl();

        // Fix Bug #351
        verifyListener = new VerifyListener()
        {
            public void verifyText(VerifyEvent event)
            {
                if ((getCellEditor().getStyle() & SWT.SINGLE) == SWT.SINGLE)
                {
                    resizeControl(event);
                }
            }
        };
        text.addVerifyListener(verifyListener);

        String initialLabelText = getInitialLabelText();

        getCellEditor().setValue(initialLabelText);
        IFigure fig = getEditPart().getFigure();
        scaledFont = fig.getFont();
        FontData data = scaledFont.getFontData()[0];
        Dimension fontSize = new Dimension(0, data.getHeight());
        figure.translateToAbsolute(fontSize);
        data.setHeight(fontSize.height);
        scaledFont = new Font(null, data);
        text.setFont(scaledFont);
        text.selectAll();
    }

    /**
     * Get the initial text that will be available for the user to edit. 
     * Sub-classes may override this method to add specific behavior
     * @return the initial text that will be displayed in the cell editor and can be edited
     */
    protected String getInitialLabelText()
    {
        String initialLabelText = "";
        if (figure instanceof EditableLabel)
        {
            initialLabelText = ((EditableLabel) figure).getEditableText();
        }
        else if (figure instanceof ILabel)
        {
            initialLabelText = ((ILabel) figure).getText();
        }
        return initialLabelText;
    }

    /**
     * Fix Bug #351
     * This method fixes the bug on the display of the textbox : the first
     * character of the edited text disappears
     * 
     * @param event the edition event
     */
    private void resizeControl(VerifyEvent event)
    {
        Text txt = (Text) getCellEditor().getControl();
        String oldText = txt.getText();
        String leftText = oldText.substring(0, event.start);
        String rightText = oldText.substring(event.end, oldText.length());
        GC gc = new GC(txt);
        Point size = gc.textExtent(leftText + event.text + rightText);
        gc.dispose();
        if (size.x != 0)
        {
            size = txt.computeSize(size.x, SWT.DEFAULT);
        }
        // Fix Bug on GTK where widget with a null size is disposed
        if (size.x == 0)
        {
            size.x = 1;
        }
        if (size.y == 0)
        {
            size.y = 1;
        }
        // End bug fix
        txt.setSize(size.x, size.y);
    }

    /**
     * @see org.eclipse.gef.tools.DirectEditManager#unhookListeners()
     */
    protected void unhookListeners()
    {
        super.unhookListeners();
        if(getCellEditor() != null)
        {
            Text text = (Text) getCellEditor().getControl();
            text.removeVerifyListener(verifyListener);
            verifyListener = null;
        }
    }

    /**
     * Creates the cell editor on the given composite. The cell editor is
     * created by instantiating the cell editor type passed into this
     * DirectEditManager's constuctor.
     * 
     * @param composite the composite to create the cell editor on
     * @return the newly created cell editor
     * 
     * @see org.eclipse.gef.tools.DirectEditManager#createCellEditorOn(org.eclipse.swt.widgets.Composite)
     */
    protected CellEditor createCellEditorOn(Composite composite)
    {
        return new TextCellEditor(composite, SWT.SINGLE);
    }

}
