package org.topcased.modeler.diagramconfigurator.internal.properties.sections;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.tabbedproperties.sections.AbstractFontPropertySection;

/**
 * A Section used to edit a Font type Feature with a Text widget and a button associated with a FontDialog.
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class PartConfigurationDefaultFontSection extends AbstractFontPropertySection
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "DefaultFont:";
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return DiagramconfiguratorPackage.eINSTANCE.getPartConfiguration_DefaultFont();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.tabbedproperties.sections.AbstractFontPropertySection#getFontValue()
     * @generated
     */
    protected Font getFontValue()
    {
        Object font = getEObject().eGet(getFeature());
        if (font != null || font instanceof Font)
        {
            return (Font) font;
        }

        else
            return Display.getDefault().getSystemFont();
    }
}