//------------------------------------------------
// $Id: GraphicConnectionPage.java,v 1.4 2006/12/18 14:47:50 jako Exp $
// (c) Anyware Technologies 2006    www.anyware-tech.com
//------------------------------------------------
package org.topcased.modeler.diagramconfigurator.internal.wizards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.topcased.facilities.widgets.SingleObjectChooser;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;
import org.topcased.modeler.diagramconfigurator.SimpleObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.SourceTargetCouple;
import org.topcased.modeler.diagramconfigurator.provider.DiagramconfiguratorItemProviderAdapterFactory;

/**
 * 
 * First page of the STC wizard. This page set the Source and Target properties of the sourceTargetCouple object and
 * also the 2 boolean fields autoRef and reversible <br>
 * creation : 5 oct. 06
 * 
 * @author <a href="mailto:mickael.gerard@anyware-tech.com">Mickael Gerard</a>
 */
public class GraphicConnectionPage extends WizardPage
{

    private Button reversibleButt, autoRefBut;

    private SingleObjectChooser sourceNode, targetNode;

    private SelectionListener listener = new SelectionAdapter()
    {
        public void widgetSelected(SelectionEvent e)
        {
            super.widgetSelected(e);
            setPageComplete(validatePage());
        }
    };

    /**
     * @param title
     */
    public GraphicConnectionPage(String title)
    {
        super("GraphicConnectionPage");
        setTitle(title);
    }

    /**
     * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
     */
    public void createControl(Composite parent)
    {
        SourceTargetCoupleWizard wizard = (SourceTargetCoupleWizard) getWizard();
        EdgePartConfiguration edgePart = wizard.getEdgePartConfiguration();

        DiagramConfiguration diag = ((DiagramConfiguration) edgePart.eContainer());
        IBaseLabelProvider labelProvider = new AdapterFactoryLabelProvider(new DiagramconfiguratorItemProviderAdapterFactory());

        List parts = getPartsForSourceAndTargetNode(diag);

        Composite composite = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        layout.verticalSpacing = 10;
        layout.horizontalSpacing = 5;

        composite.setLayout(layout);
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));

        // Source Node
        sourceNode = WizardsUtil.createSingleObject(composite, "Source Node", labelProvider);
        sourceNode.setChoices(parts.toArray());

        // TargetNode
        targetNode = WizardsUtil.createSingleObject(composite, "Target Node", labelProvider);
        targetNode.setChoices(parts.toArray());

        createButtonsComposite(composite);

        hookListeners();

        setControl(composite);
        setPageComplete(false);
    }

    /**
     * Retrieve a list of all the part link to a ModelObjectConfiguration
     * 
     * @param diag
     * @return List<PartConfiguration> list of partConfiguration
     */
    private List getPartsForSourceAndTargetNode(DiagramConfiguration diag)
    {
        List parts = new ArrayList();
        parts.add("");
        if (diag.getParts() != null && !diag.getParts().isEmpty())
        {
            PartConfiguration part = null;
            for (Iterator it = diag.getParts().iterator(); it.hasNext();)
            {
                part = (PartConfiguration) it.next();
                if (part instanceof NodePartConfiguration || ((EdgePartConfiguration) part).getObject() instanceof ModelObjectConfiguration)
                {
                    parts.add(part);
                }
            }
        }
        return parts;
    }

    /**
     * Add all listeners
     */
    private void hookListeners()
    {
        sourceNode.addSelectionListener(listener);
        targetNode.addSelectionListener(listener);
    }

    /**
     * remove all the listeners on this page components
     */
    private void unhookListeners()
    {
        sourceNode.removeSelectionListener(listener);
        targetNode.removeSelectionListener(listener);
    }

    /**
     * Remove listeners on dispose
     * 
     * @see org.eclipse.jface.dialogs.DialogPage#dispose()
     */
    public void dispose()
    {
        unhookListeners();
        super.dispose();
    }

    private void createButtonsComposite(Composite composite)
    {
        GridData layoutData;
        // Buttons composite
        Composite buttons = new Composite(composite, SWT.NULL);
        layoutData = new GridData(GridData.FILL_HORIZONTAL);
        layoutData.horizontalSpan = 2;
        buttons.setLayoutData(layoutData);

        GridLayout buttonsLayout = new GridLayout();
        buttonsLayout.numColumns = 2;
        buttonsLayout.horizontalSpacing = 10;
        buttonsLayout.marginTop = 10;
        buttons.setLayout(buttonsLayout);

        // AutoRef
        autoRefBut = new Button(buttons, SWT.CHECK);
        autoRefBut.setText("Auto Ref");
        layoutData = new GridData(GridData.FILL_HORIZONTAL);
        layoutData.horizontalAlignment = GridData.CENTER;
        autoRefBut.setLayoutData(layoutData);
        autoRefBut.addSelectionListener(listener);

        // Reversible
        reversibleButt = new Button(buttons, SWT.CHECK);
        reversibleButt.setText("Reversible");
        layoutData = new GridData(GridData.FILL_HORIZONTAL);
        layoutData.horizontalAlignment = GridData.CENTER;
        reversibleButt.setLayoutData(layoutData);
        reversibleButt.addSelectionListener(listener);
    }

    /**
     * Check that the SourceNode and the TargetNode are filled
     * 
     * @return true is the page is valide
     */
    private boolean validatePage()
    {
        setErrorMessage(null);
        if (sourceNode.getSelection() == null)
        {
            setErrorMessage("Source node must be set");
            return false;
        }
        if (targetNode.getSelection() == null)
        {
            setErrorMessage("Target node must be set");
            return false;
        }
        updateFields();
        return true;
    }

    /**
     * Fills the SourceTargetCouple with the properties set in the page
     */
    private void updateFields()
    {
        SourceTargetCouple stc = ((SourceTargetCoupleWizard) getWizard()).getSourceTargetCouple();
        if (stc != null)
        {
            stc.setSourceNode((PartConfiguration) sourceNode.getSelection());
            stc.setTargetNode((PartConfiguration) targetNode.getSelection());
            stc.setAutoRef(autoRefBut.getSelection());
            stc.setReversible(reversibleButt.getSelection());
        }
    }

    /**
     * If Edge is based on a SimpleObjectConfiguration the ModelPage is skipped
     * 
     * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
     */
    public IWizardPage getNextPage()
    {
        IWizardPage page = super.getNextPage();
        EdgePartConfiguration edge = ((SourceTargetCoupleWizard) getWizard()).getEdgePartConfiguration();
        if (edge.getObject() instanceof SimpleObjectConfiguration)
        {
            page = getWizard().getPage(ModelUpdatePage.MODEL_UPDATE_PAGE_NAME);
        }
        return page;
    }

}