// ------------------------------------------------
// $Id: ModelPage.java,v 1.4 2006/12/18 14:47:50 jako Exp $
// (c) Anyware Technologies 2006 www.anyware-tech.com
// ------------------------------------------------
package org.topcased.modeler.diagramconfigurator.internal.wizards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelItemProviderAdapterFactory;
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
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.EdgeContainerType;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.SourceTargetCouple;

/**
 * 
 * Second page of the STC wizard when edgePartConfiguration is based on a model This page set the ContainerType,
 * ContainerObject and the ContainerRef <br>
 * creation : 5 oct. 06
 * 
 * @author <a href="mailto:mickael.gerard@anyware-tech.com">Mickael Gerard</a>
 */
public class ModelPage extends WizardPage
{

    /**
     * Page name
     */
    protected static String MODEL_PAGE_NAME = "ModelPage";

    private SingleObjectChooser containerType, containerRef, containerObject;

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
    public ModelPage(String title)
    {
        super(MODEL_PAGE_NAME);
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
        List parts = new ArrayList();
        parts.add("");
        parts.addAll(diag.getParts());

        Composite composite = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        layout.verticalSpacing = 10;
        layout.horizontalSpacing = 5;

        composite.setLayout(layout);
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));

        containerType = WizardsUtil.createSingleObject(composite, "Container Type", null);
        // Retrieve edgeContainerType and remove the NONE Value
        // only available for edge not linked to model object
        List edgeContainerType = new ArrayList();
        edgeContainerType.addAll(EdgeContainerType.VALUES);
        edgeContainerType.remove(EdgeContainerType.NONE);
        edgeContainerType.add(0, "");
        containerType.setChoices(edgeContainerType.toArray());

        // Container Object
        IBaseLabelProvider genModelLabelProvider = new AdapterFactoryLabelProvider(new GenModelItemProviderAdapterFactory());
        containerObject = WizardsUtil.createSingleObject(composite, "Container Object", genModelLabelProvider);
        // Container Ref
        IBaseLabelProvider ecoreLabelProvider = new AdapterFactoryLabelProvider(new EcoreItemProviderAdapterFactory());
        containerRef = WizardsUtil.createSingleObject(composite, "Container Ref", ecoreLabelProvider);

        hookListeners();

        setControl(composite);
        setPageComplete(validatePage());
    }

    private void hookListeners()
    {
        // ContainerType
        containerType.addSelectionListener(listener);
        containerType.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                super.widgetSelected(e);
                handleContainerTypeChange();
            }
        });
        // ContainerObject
        containerObject.addSelectionListener(listener);
        containerObject.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                super.widgetSelected(e);
                handleContainerObjectChange();
            }
        });

        // ContainerRef
        containerRef.addSelectionListener(listener);

    }

    private void unhookListeners()
    {
        containerType.removeSelectionListener(listener);
        containerObject.removeSelectionListener(listener);
        containerRef.removeSelectionListener(listener);
    }

    /**
     * UnhookListeners when dispose
     * 
     * @see org.eclipse.jface.dialogs.DialogPage#dispose()
     */
    public void dispose()
    {
        unhookListeners();
        super.dispose();
    }

    /**
     * Check that the SourceNode and the TargetNode are filled
     * 
     * @return true is the page is valide
     */
    private boolean validatePage()
    {
        if (((SourceTargetCoupleWizard) getWizard()).isLinkedToModelObjectConfiguration())
        {
            setErrorMessage(null);
            if (containerType.getSelection() == null)
            {
                setErrorMessage("Container Type must be set");
                return false;
            }
            if (containerObject.getSelection() == null)
            {
                setErrorMessage("Container Object must be set");
                return false;
            }
            if (containerRef.getSelection() == null)
            {
                setErrorMessage("Container Ref must be set");
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
                stc.setContainerType((EdgeContainerType) containerType.getSelection());
                stc.setContainerObject((GenClass) containerObject.getSelection());
                stc.setContainerRef((EStructuralFeature) containerRef.getSelection());
            }
            else
            {
                stc.setContainerType(EdgeContainerType.get(EdgeContainerType.NONE));
            }
        }
    }

    /**
     * Handler on ContainerType changes Updates ContainerObject combo content
     * 
     */
    protected void handleContainerTypeChange()
    {
        List containerObjects = new ArrayList();

        EdgeContainerType type = (EdgeContainerType) containerType.getSelection();
        if (type != null)
        {
            SourceTargetCoupleWizard wizard = (SourceTargetCoupleWizard) getWizard();
            SourceTargetCouple couple = wizard.getSourceTargetCouple();
            switch (type.getValue())
            {
                case EdgeContainerType.NONE:
                    break;
                case EdgeContainerType.SOURCE:
                    if (couple.getSourceNode().getObject() instanceof ModelObjectConfiguration)
                    {
                        containerObjects.add(((ModelObjectConfiguration) couple.getSourceNode().getObject()).getGenClass());
                    }
                    break;
                case EdgeContainerType.TARGET:
                    if (couple.getTargetNode().getObject() instanceof ModelObjectConfiguration)
                    {
                        containerObjects.add(((ModelObjectConfiguration) couple.getTargetNode().getObject()).getGenClass());
                    }
                    break;
                case EdgeContainerType.DIAGRAM:
                case EdgeContainerType.SOURCE_CONTAINER:
                case EdgeContainerType.TARGET_CONTAINER:
                default:
                    containerObjects = getAllModelObjectGenClasses();
                    break;
            }
            containerRef.clearCombo();
            containerObject.clearCombo();
            containerObject.setChoices(containerObjects.toArray());
            if (type.equals(EdgeContainerType.get(EdgeContainerType.DIAGRAM)))
            {
                GenClass selection = ((DiagramConfiguration) wizard.getEdgePartConfiguration().eContainer()).getTemplateRootObject();
                containerObject.setSelection(selection);
            }
            // set the value of the containerObject explicitely in order to call
            // the handler on containerObject Selection
            else
            {
                containerObject.setSelection(containerObjects.get(0));
            }
        }
    }

    /**
     * Fill the ContainerRef combo viewer with all the eStructuralReferences of the selected object in the the
     * ContainerObject
     */
    private void handleContainerObjectChange()
    {
        GenClass val = (GenClass) containerObject.getSelection();
        List containerReferences = new ArrayList();
        if (val != null)
        {
            // retrieve all the StructuralFeatures of the genclass selected in
            // the containerObject
            List structuredFeatures = val.getEcoreClass().getEAllStructuralFeatures();
            GenClass edgeGenClass = ((ModelObjectConfiguration) ((SourceTargetCoupleWizard) getWizard()).getEdgePartConfiguration().getObject()).getGenClass();
            for (Iterator it = structuredFeatures.iterator(); it.hasNext();)
            {
                EStructuralFeature eStructuralFeature = (EStructuralFeature) it.next();
                if (eStructuralFeature.getEType() instanceof EClass)
                {
                    if (((EClass) eStructuralFeature.getEType()).isSuperTypeOf(edgeGenClass.getEcoreClass()))
                    {
                        containerReferences.add(eStructuralFeature);
                    }
                }

            }
        }
        containerRef.clearCombo();
        containerRef.setChoices(containerReferences.toArray());
        containerRef.setSelection(containerReferences.get(0));
    }

    /**
     * @return the list of all the GenClass referenced by the ModelObjectConfiguration
     */
    private List getAllModelObjectGenClasses()
    {
        List containerObjects = new ArrayList();
        EdgePartConfiguration edge = ((SourceTargetCoupleWizard) getWizard()).getEdgePartConfiguration();
        List modelObjects = ((DiagramConfiguration) edge.eContainer()).getObjects();
        if (modelObjects != null && !modelObjects.isEmpty())
        {
            for (Iterator it = modelObjects.iterator(); it.hasNext();)
            {
                Object obj = it.next();
                if (obj instanceof ModelObjectConfiguration)
                {
                    containerObjects.add(((ModelObjectConfiguration) obj).getGenClass());
                }
            }
        }
        return containerObjects;
    }

}