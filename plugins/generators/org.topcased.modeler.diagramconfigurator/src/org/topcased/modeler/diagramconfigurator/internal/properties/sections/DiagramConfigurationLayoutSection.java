package org.topcased.modeler.diagramconfigurator.internal.properties.sections;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.LayoutType;
import org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection;

/**
 * A section which displays the multi features.<br>
 * The section features a table with two buttons letting the user to<br>
 * add or remove items from the selected object.
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class DiagramConfigurationLayoutSection extends AbstractEnumerationPropertySection
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "Layout:";
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return DiagramconfiguratorPackage.eINSTANCE.getDiagramConfiguration_Layout();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getEnumerationFeatureValues()
     * @generated
     */
    protected String[] getEnumerationFeatureValues()
    {
        List values = LayoutType.VALUES;
        String[] vals = new String[values.size()];
        for (int i = 0; i < values.size(); i++)
        {
            LayoutType enumType = (LayoutType) values.get(i);
            vals[i] = enumType.getName();
        }
        return vals;
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getFeatureAsText()
     * @generated
     */
    protected String getFeatureAsText()
    {
        return ((DiagramConfiguration) getEObject()).getLayout().getName();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getFeatureValue(int)
     * @generated
     */
    protected Object getFeatureValue(int index)
    {
        return LayoutType.get(index);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getOldFeatureValue()
     * @generated
     */
    protected Object getOldFeatureValue()
    {
        return ((DiagramConfiguration) getEObject()).getLayout();
    }

}