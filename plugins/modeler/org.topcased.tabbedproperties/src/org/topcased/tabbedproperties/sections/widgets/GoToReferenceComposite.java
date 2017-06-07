package org.topcased.tabbedproperties.sections.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * TODO Comment this class
 */
public class GoToReferenceComposite extends CSingleObjectChooser
{

    /**
     * This button will perform the change selection
     */
    private Button goToBt;

    /**
     * Constructor
     * 
     * @param parent the parent Composite
     * @param factory the factory necessary to create the widget
     * @param style
     */
    public GoToReferenceComposite(Composite parent, int style, TabbedPropertySheetWidgetFactory factory)
    {
        super(parent, factory, style);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.widgets.CSingleObjectChooser#createContents(org.eclipse.swt.widgets.Composite)
     */
    protected void createContents(Composite parent)
    {
        super.createContents(parent);

        goToBt = getWidgetFactory().createButton(parent, "GoTo->", SWT.PUSH);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.widgets.CSingleObjectChooser#getNumberOfColumns()
     */
    protected int getNumberOfColumns()
    {
        return 3;
    }

    /**
     * @see org.topcased.tabbedproperties.sections.widgets.CSingleObjectChooser#hookListeners()
     */
    protected void hookListeners()
    {
        super.hookListeners();
        goToBt.addSelectionListener(new SelectionAdapter()
        {
            /**
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            public void widgetSelected(SelectionEvent e)
            {
                handleGoTo();
            }
        });
    }

    /**
     * This method is to be overriden in order to implement the desired behavior
     */
    protected void handleGoTo()
    {
        // Do nothing
    }
}
