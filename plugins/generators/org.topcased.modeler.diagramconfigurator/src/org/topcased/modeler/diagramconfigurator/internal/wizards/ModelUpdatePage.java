//------------------------------------------------
// $Id: ModelUpdatePage.java,v 1.5 2006/12/18 14:47:50 jako Exp $
// (c) Anyware Technologies 2006    www.anyware-tech.com
//------------------------------------------------
package org.topcased.modeler.diagramconfigurator.internal.wizards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.topcased.facilities.widgets.SingleObjectChooser;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.ObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.SourceTargetCouple;

/**
 * Page that sets the references between Source, target and edge <br>
 * creation : 6 oct. 06
 * 
 * @author <a href="mailto:mickael.gerard@anyware-tech.com">Mickael Gerard</a>
 */
public class ModelUpdatePage extends WizardPage
{
    /**
     * Page name
     */
    protected static String MODEL_UPDATE_PAGE_NAME = "ModelUploafPage";

    private SingleObjectChooser sourceToEdge, targetToEdge, edgeToSource, edgeToTarget, sourceToTarget, targetToSource;

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
    public ModelUpdatePage(String title)
    {
        super(MODEL_UPDATE_PAGE_NAME);
        setTitle(title);
    }

    /**
     * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
     */
    public void createControl(Composite parent)
    {
        Composite composite = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        layout.verticalSpacing = 10;
        layout.horizontalSpacing = 5;

        composite.setLayout(layout);
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));

        IBaseLabelProvider ecoreLabelProvider = new AdapterFactoryLabelProvider(new EcoreItemProviderAdapterFactory());
        if (((SourceTargetCoupleWizard) getWizard()).isLinkedToModelObjectConfiguration())
        {
            sourceToEdge = WizardsUtil.createSingleObject(composite, "SourceToEdge Ref", ecoreLabelProvider);
            targetToEdge = WizardsUtil.createSingleObject(composite, "TargetToEdge Ref", ecoreLabelProvider);
            edgeToSource = WizardsUtil.createSingleObject(composite, "EdgeToSource Ref", ecoreLabelProvider);
            edgeToTarget = WizardsUtil.createSingleObject(composite, "EdgeToTarget Ref", ecoreLabelProvider);
        }
        sourceToTarget = WizardsUtil.createSingleObject(composite, "SourceToTarget Ref", ecoreLabelProvider);
        targetToSource = WizardsUtil.createSingleObject(composite, "TargetToSource Ref", ecoreLabelProvider);

        hookListeners();

        setControl(composite);
    }

    /**
     * Add all the listeners
     */
    private void hookListeners()
    {
        sourceToTarget.addSelectionListener(listener);
        targetToSource.addSelectionListener(listener);
        if (((SourceTargetCoupleWizard) getWizard()).isLinkedToModelObjectConfiguration())
        {
            sourceToEdge.addSelectionListener(listener);
            targetToEdge.addSelectionListener(listener);
            edgeToSource.addSelectionListener(listener);
            edgeToTarget.addSelectionListener(listener);
        }
    }

    /**
     * remove all the listeners on this page components
     */
    private void unhookListeners()
    {
        sourceToTarget.removeSelectionListener(listener);
        targetToSource.removeSelectionListener(listener);
        if (((SourceTargetCoupleWizard) getWizard()).isLinkedToModelObjectConfiguration())
        {
            sourceToEdge.removeSelectionListener(listener);
            targetToEdge.removeSelectionListener(listener);
            edgeToSource.removeSelectionListener(listener);
            edgeToTarget.removeSelectionListener(listener);
        }
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

    /**
     * 
     * Initialise the combos with the data corresponding to the properties set (SourceNode, TargetNode and Edge Model)
     */
    private void initCombo()
    {
        SourceTargetCoupleWizard wizard = (SourceTargetCoupleWizard) getWizard();
        EdgePartConfiguration edgePart = wizard.getEdgePartConfiguration();
        SourceTargetCouple couple = wizard.getSourceTargetCouple();

        sourceToTarget.setChoices(getEStructuralFeaturesList(couple.getSourceNode().getObject(), couple.getTargetNode().getObject()).toArray());
        targetToSource.setChoices(getEStructuralFeaturesList(couple.getTargetNode().getObject(), couple.getSourceNode().getObject()).toArray());
        if (wizard.isLinkedToModelObjectConfiguration())
        {
            sourceToEdge.setChoices(getEStructuralFeaturesList(couple.getSourceNode().getObject(), edgePart.getObject()).toArray());
            targetToEdge.setChoices(getEStructuralFeaturesList(couple.getTargetNode().getObject(), edgePart.getObject()).toArray());
            edgeToSource.setChoices(getEStructuralFeaturesList(edgePart.getObject(), couple.getSourceNode().getObject()).toArray());
            edgeToTarget.setChoices(getEStructuralFeaturesList(edgePart.getObject(), couple.getTargetNode().getObject()).toArray());
        }
        setPageComplete(validatePage());

    }

    /**
     * @return true if the page is valide
     */
    private boolean validatePage()
    {
        if (!((SourceTargetCoupleWizard) getWizard()).isLinkedToModelObjectConfiguration())
        {
            setErrorMessage(null);
            if ((sourceToTarget.getSelection() == null) && (targetToSource.getSelection() == null))
            {
                setErrorMessage("SourceToTarget Ref or TargetToSource Ref must be set");
                return false;
            }
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
            if (((SourceTargetCoupleWizard) getWizard()).isLinkedToModelObjectConfiguration())
            {

                stc.setRefSourceToEdge((EStructuralFeature) sourceToEdge.getSelection());
                stc.setRefTargetToEdge((EStructuralFeature) targetToEdge.getSelection());
                stc.setRefEdgeToSource((EStructuralFeature) edgeToSource.getSelection());
                stc.setRefEdgeToTarget((EStructuralFeature) edgeToTarget.getSelection());
            }
            stc.setRefTargetToSource((EStructuralFeature) targetToSource.getSelection());
            stc.setRefSourceToTarget((EStructuralFeature) sourceToTarget.getSelection());
        }
    }

    /**
     * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
     */
    public void setVisible(boolean visible)
    {
        if (visible)
        {
            initCombo();
        }
        super.setVisible(visible);
    }

    /**
     * Return all the Estructural features of fromObject with the type of toObj
     * 
     * @param fromObj
     * @param toObj
     * @return Collection EStructural
     */
    private List getEStructuralFeaturesList(ObjectConfiguration fromObj, ObjectConfiguration toObj)
    {
        List containments = new ArrayList();
        if (fromObj instanceof ModelObjectConfiguration && toObj instanceof ModelObjectConfiguration)
        {
            for (Iterator iter = ((ModelObjectConfiguration) fromObj).getGenClass().getEcoreClass().getEAllStructuralFeatures().iterator(); iter.hasNext();)
            {
                EStructuralFeature eStructuralFeature = (EStructuralFeature) iter.next();
                if (eStructuralFeature.getEType() instanceof EClass)
                {
                    if (((EClass) eStructuralFeature.getEType()).isSuperTypeOf(((ModelObjectConfiguration) toObj).getGenClass().getEcoreClass()))
                    {
                        containments.add(eStructuralFeature);
                    }
                }
            }
        }
        if (!containments.contains(null))
        {
            containments.add("");
        }
        return containments;
    }

}