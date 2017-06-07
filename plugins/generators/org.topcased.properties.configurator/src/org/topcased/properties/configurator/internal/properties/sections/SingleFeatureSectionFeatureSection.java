package org.topcased.properties.configurator.internal.properties.sections;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;
import org.topcased.properties.configurator.SingleFeatureSection;
import org.topcased.tabbedproperties.sections.AbstractChooserPropertySection;

/**
 * A section featuring a combo box with a seach button. This section<br>
 * displays single references.
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SingleFeatureSectionFeatureSection extends AbstractChooserPropertySection
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "Feature:";
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return PropertiesConfiguratorPackage.eINSTANCE.getSingleFeatureSection_Feature();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractChooserPropertySection#getFeatureValue()
     * @generated
     */
    protected Object getFeatureValue()
    {
        return ((SingleFeatureSection) getEObject()).getFeature();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractChooserPropertySection#getComboFeatureValues()
     * @generated
     */
    protected Object[] getComboFeatureValues()
    {
        return getChoices(getEObject(), PropertiesConfiguratorPackage.eINSTANCE.getSingleFeatureSection_Feature().getEType());
    }
}
