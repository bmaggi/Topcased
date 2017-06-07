package org.topcased.modeler.diagramconfigurator.internal.properties.sections;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.modeler.diagramconfigurator.DecorationType;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection;

/**
 * A section which displays the multi features.<br>
 * The section features a table with two buttons letting the user to add or remove items from the selected object.
 * 
 * @generated
 */
public class EdgePartConfigurationTargetDecorationSection extends AbstractEnumerationPropertySection
{
    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "TargetDecoration:";
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return DiagramconfiguratorPackage.eINSTANCE.getEdgePartConfiguration_TargetDecoration();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getEnumerationFeatureValues()
     * @generated
     */
    protected String[] getEnumerationFeatureValues()
    {
        List values = DecorationType.VALUES;
        String[] vals = new String[values.size()];
        for (int i = 0; i < values.size(); i++)
        {
            DecorationType enumType = (DecorationType) values.get(i);
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
        return ((EdgePartConfiguration) getEObject()).getTargetDecoration().getName();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getFeatureValue(int)
     * @generated
     */
    protected Object getFeatureValue(int index)
    {
        return DecorationType.get(index);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getOldFeatureValue()
     * @generated
     */
    protected Object getOldFeatureValue()
    {
        return ((EdgePartConfiguration) getEObject()).getTargetDecoration();
    }

}