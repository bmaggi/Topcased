/**
 * @generated
 */
package org.topcased.modeler.diagramconfigurator.internal.properties.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.viewers.ILabelProvider;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.EdgeObject;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;
import org.topcased.modeler.diagramconfigurator.provider.DiagramconfiguratorItemProviderAdapterFactory;
import org.topcased.tabbedproperties.AbstractTabbedPropertySheetPage;
import org.topcased.tabbedproperties.providers.TabbedPropertiesLabelProvider;
import org.topcased.tabbedproperties.sections.AbstractChooserPropertySection;

/**
 * A section featuring a combo box with a search button. This section displays single references.
 * 
 * @generated
 */
public class EdgeObjectEStructuralFeatureSection extends AbstractChooserPropertySection
{
    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "EStructuralFeature:";
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return DiagramconfiguratorPackage.eINSTANCE.getEdgeObject_EStructuralFeature();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractChooserPropertySection#getFeatureValue()
     * @generated
     */
    protected Object getFeatureValue()
    {
        return ((EdgeObject) getEObject()).getEStructuralFeature();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractChooserPropertySection#getComboFeatureValues()
     * @generated NOT
     */
    protected Object[] getComboFeatureValues()
    {
        List containments = new ArrayList();

        // Add an empty selection
        containments.add("");

        if (getEObject() instanceof EdgeObject)
        {
            if (((EdgeObject) getEObject()).eContainer() instanceof PartConfiguration)
            {
                if (((PartConfiguration) ((EdgeObject) getEObject()).eContainer()).getObject() instanceof ModelObjectConfiguration)
                {
                    containments.addAll(((ModelObjectConfiguration) ((PartConfiguration) ((EdgeObject) getEObject()).eContainer()).getObject()).getGenClass().getEcoreClass().getEAllStructuralFeatures());
                }
            }
        }
        return containments.toArray();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractChooserPropertySection#getLabelProvider()
     * @generated
     */
    protected ILabelProvider getLabelProvider()
    {
        List f = new ArrayList();
        f.add(new DiagramconfiguratorItemProviderAdapterFactory());
        f.addAll(AbstractTabbedPropertySheetPage.getPrincipalAdapterFactories());
        return new TabbedPropertiesLabelProvider(new ComposedAdapterFactory(f));
    }

}
