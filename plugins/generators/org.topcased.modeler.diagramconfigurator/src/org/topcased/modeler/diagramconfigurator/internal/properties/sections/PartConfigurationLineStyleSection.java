package org.topcased.modeler.diagramconfigurator.internal.properties.sections;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.LineStyle;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;
import org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection;

/**
 * A section which displays the multi features.<br>
 * The section features a table with two buttons letting the user to add or remove items from the selected object.
 * 
 * @generated
 */
public class PartConfigurationLineStyleSection extends AbstractEnumerationPropertySection
{
    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "LineStyle:";
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return DiagramconfiguratorPackage.eINSTANCE.getPartConfiguration_LineStyle();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getEnumerationFeatureValues()
     * @generated
     */
    protected String[] getEnumerationFeatureValues()
    {
        List values = LineStyle.VALUES;
        String[] vals = new String[values.size()];
        for (int i = 0; i < values.size(); i++)
        {
            LineStyle enumType = (LineStyle) values.get(i);
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
        return ((PartConfiguration) getEObject()).getLineStyle().getName();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getFeatureValue(int)
     * @generated
     */
    protected Object getFeatureValue(int index)
    {
        return LineStyle.get(index);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getOldFeatureValue()
     * @generated
     */
    protected Object getOldFeatureValue()
    {
        return ((PartConfiguration) getEObject()).getLineStyle();
    }
}