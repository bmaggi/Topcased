package org.topcased.modeler.diagramconfigurator.internal.properties.sections;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.tabbedproperties.sections.AbstractStringPropertySection;

/**
 * A section display a text field to edit/see String features
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class DiagramConfigurationCopyrightTextSection extends AbstractStringPropertySection
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
        return DiagramconfiguratorPackage.eINSTANCE.getDiagramConfiguration_CopyrightText();
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

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
     * @custom
     */
    public boolean shouldUseExtraSpace()
    {
        return true;
    }
}