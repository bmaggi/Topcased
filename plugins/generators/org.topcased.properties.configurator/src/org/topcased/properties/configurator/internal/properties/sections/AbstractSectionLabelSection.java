package org.topcased.properties.configurator.internal.properties.sections;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.properties.configurator.PropertiesConfiguratorPackage;
import org.topcased.tabbedproperties.sections.AbstractStringPropertySection;

/**
 * A section display a text field to edit/see String features
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class AbstractSectionLabelSection extends AbstractStringPropertySection
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "Label:";
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return PropertiesConfiguratorPackage.eINSTANCE.getAbstractSection_Label();
    }

}