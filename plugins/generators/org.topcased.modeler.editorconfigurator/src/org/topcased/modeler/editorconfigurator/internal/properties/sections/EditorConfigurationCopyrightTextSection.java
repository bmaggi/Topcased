package org.topcased.modeler.editorconfigurator.internal.properties.sections;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.topcased.modeler.editorconfigurator.EditorconfiguratorPackage;
import org.topcased.tabbedproperties.sections.AbstractStringPropertySection;

/**
 * A section display a text field to edit/see String features
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EditorConfigurationCopyrightTextSection extends AbstractStringPropertySection
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "CopyrightText:";
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return EditorconfiguratorPackage.eINSTANCE.getEditorConfiguration_CopyrightText();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTextPropertySection#getStyle()
     * @generated
     */
    protected int getStyle()
    {
        return SWT.MULTI;
    }
}