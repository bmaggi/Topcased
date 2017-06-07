package org.topcased.modeler.diagramconfigurator.internal.properties.sections;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.LayoutType;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
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
public class NodePartConfigurationLayoutSection extends AbstractEnumerationPropertySection
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
        return DiagramconfiguratorPackage.eINSTANCE.getNodePartConfiguration_Layout();
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getFeaturesAsText()
     * @generated
     */
    protected String getFeatureAsText()
    {
        return ((NodePartConfiguration) getEObject()).getLayout().getName();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getFeatureValue()
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
        return ((NodePartConfiguration) getEObject()).getLayout();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#isEqual()
     * @generated
     */
    protected boolean isEqual(int index)
    {
        return false;
    }
}