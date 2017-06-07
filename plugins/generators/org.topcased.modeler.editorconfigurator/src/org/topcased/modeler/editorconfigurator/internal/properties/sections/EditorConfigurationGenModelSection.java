package org.topcased.modeler.editorconfigurator.internal.properties.sections;

import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelItemProviderAdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.topcased.modeler.editorconfigurator.EditorConfiguration;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage;
import org.topcased.tabbedproperties.providers.TabbedPropertiesLabelProvider;
import org.topcased.tabbedproperties.sections.AbstractChooserPropertySection;

/**
 * A section featuring a combo box with a seach button. This section<br>
 * displays single references.
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EditorConfigurationGenModelSection extends AbstractChooserPropertySection
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "GenModel:";
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return EditorconfiguratorPackage.eINSTANCE.getEditorConfiguration_GenModel();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractChooserPropertySection#getFeatureValue()
     * @generated
     */
    protected Object getFeatureValue()
    {
        return ((EditorConfiguration) getEObject()).getGenModel();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractChooserPropertySection#getComboFeatureValues()
     * @generated
     */
    protected Object[] getComboFeatureValues()
    {
        return getChoices(getEObject(), EditorconfiguratorPackage.eINSTANCE.getEditorConfiguration_GenModel().getEType());
    }
    
    @Override
    protected ILabelProvider getLabelProvider()
    {
        return new AdapterFactoryLabelProvider(new GenModelItemProviderAdapterFactory());
    }
}
