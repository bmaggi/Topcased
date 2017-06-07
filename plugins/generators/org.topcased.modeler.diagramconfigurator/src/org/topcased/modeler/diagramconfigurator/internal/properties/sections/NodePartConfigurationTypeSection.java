/**
 * @generated
 */
package org.topcased.modeler.diagramconfigurator.internal.properties.sections;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
import org.topcased.modeler.diagramconfigurator.extension.FigureDeclarationsManager;
import org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection;

/**
 * A section display a text field to edit/see String features
 * 
 * @generated NOT
 */
public class NodePartConfigurationTypeSection extends AbstractEnumerationPropertySection
{

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getEnumerationFeatureValues()
     * @generated NOT
     */
    protected String[] getEnumerationFeatureValues()
    {
        // get all the available figures from the extension points
        Collection types = FigureDeclarationsManager.getInstance().getFigureDeclarationNames();
        return (String[]) types.toArray(new String[types.size()]);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getFeatureAsText()
     * @generated NOT
     */
    protected String getFeatureAsText()
    {
        return ((NodePartConfiguration) getEObject()).getType();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getFeatureValue(int)
     * @generated NOT
     */
    protected Object getFeatureValue(int index)
    {
        return FigureDeclarationsManager.getInstance().getFigureDeclarationNames().get(index);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractEnumerationPropertySection#getOldFeatureValue()
     * @generated NOT
     */
    protected Object getOldFeatureValue()
    {
        return ((NodePartConfiguration) getEObject()).getType();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "Type:";
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return DiagramconfiguratorPackage.eINSTANCE.getNodePartConfiguration_Type();
    }

}