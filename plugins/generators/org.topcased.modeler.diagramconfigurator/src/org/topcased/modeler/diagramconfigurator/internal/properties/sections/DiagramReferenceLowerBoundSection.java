package org.topcased.modeler.diagramconfigurator.internal.properties.sections;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.tabbedproperties.sections.AbstractIntegerPropertySection;

/**
 * A section display a text field to edit/see Integer Features
 * 
 * @generated
 */
public class DiagramReferenceLowerBoundSection extends AbstractIntegerPropertySection
{
    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "LowerBound:";
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return DiagramconfiguratorPackage.eINSTANCE.getDiagramReference_LowerBound();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractIntegerPropertySection#getFeatureInteger()
     * @generated
     */
    protected Integer getFeatureInteger()
    {
        Object Int = getEObject().eGet(getFeature());
        if (Int == null)
        {
            return new Integer(0);
        }

        return (Integer) Int;
    }
}