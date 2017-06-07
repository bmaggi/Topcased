package org.topcased.properties.configurator.internal.properties.sections;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;
import org.topcased.tabbedproperties.sections.AbstractBooleanPropertySection;

/**
 * A Section used to edit a boolean Feature with a Checkbox.
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SingleFeatureSectionMultilineSection extends AbstractBooleanPropertySection
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "Multiline";
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return PropertiesConfiguratorPackage.eINSTANCE.getSingleFeatureSection_Multiline();
    }

}