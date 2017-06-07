package org.topcased.modeler.editorconfigurator.internal.properties.sections;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage;
import org.topcased.tabbedproperties.sections.AbstractBooleanPropertySection;

/**
 * A Section used to edit a boolean Feature with a Checkbox.
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EditorConfigurationOrganizeImportsSection extends AbstractBooleanPropertySection
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "OrganizeImports";
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return EditorconfiguratorPackage.eINSTANCE.getEditorConfiguration_OrganizeImports();
    }

}