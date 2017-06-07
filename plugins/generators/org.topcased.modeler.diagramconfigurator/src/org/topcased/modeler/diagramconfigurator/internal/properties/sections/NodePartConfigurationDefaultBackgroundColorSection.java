package org.topcased.modeler.diagramconfigurator.internal.properties.sections;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.tabbedproperties.sections.AbstractColorPropertySection;

/**
 * A Section used to edit a Color type Feature with a dedicated button and ColorDialog.
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class NodePartConfigurationDefaultBackgroundColorSection extends AbstractColorPropertySection
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "DefaultBackgroundColor:";
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return DiagramconfiguratorPackage.eINSTANCE.getNodePartConfiguration_DefaultBackgroundColor();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractColorPropertySection#getRGBValue()
     * @generated
     */
    protected RGB getRGBValue()
    {
        Object color = getEObject().eGet(getFeature());
        if (color != null && color instanceof Color)
        {
            return ((Color) color).getRGB();
        }
        return null;
    }
}