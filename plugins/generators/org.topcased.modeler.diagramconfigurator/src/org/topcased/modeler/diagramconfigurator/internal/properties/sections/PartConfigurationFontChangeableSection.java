package org.topcased.modeler.diagramconfigurator.internal.properties.sections;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.tabbedproperties.sections.AbstractBooleanPropertySection;

/**
 * A Section used to edit a boolean Feature with a Checkbox.
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class PartConfigurationFontChangeableSection extends AbstractBooleanPropertySection
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "FontChangeable";
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return DiagramconfiguratorPackage.eINSTANCE.getPartConfiguration_FontChangeable();
    }

}