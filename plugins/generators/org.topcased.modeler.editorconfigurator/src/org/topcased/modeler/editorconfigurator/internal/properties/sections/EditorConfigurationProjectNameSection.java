package org.topcased.modeler.editorconfigurator.internal.properties.sections;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage;
import org.topcased.tabbedproperties.sections.AbstractStringPropertySection;

/**
 * A section display a text field to edit/see String features
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EditorConfigurationProjectNameSection extends AbstractStringPropertySection
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "ProjectName:";
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return EditorconfiguratorPackage.eINSTANCE.getEditorConfiguration_ProjectName();
    }

}