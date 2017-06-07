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
import org.topcased.modeler.diagramconfigurator.EdgeContainerType;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.SourceTargetCouple;
import org.topcased.modeler.diagramconfigurator.provider.DiagramconfiguratorItemProviderAdapterFactory;
import org.topcased.tabbedproperties.AbstractTabbedPropertySheetPage;
import org.topcased.tabbedproperties.providers.TabbedPropertiesLabelProvider;
import org.topcased.tabbedproperties.sections.AbstractChooserPropertySection;

/**
 * A section featuring a combo box with a search button. This section displays single references.
 * 
 * @generated
 */
public class SourceTargetCoupleContainerRefSection extends AbstractChooserPropertySection
{
    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "ContainerRef:";
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return DiagramconfiguratorPackage.eINSTANCE.getSourceTargetCouple_ContainerRef();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractChooserPropertySection#getFeatureValue()
     * @generated
     */
    protected Object getFeatureValue()
    {
        return ((SourceTargetCouple) getEObject()).getContainerRef();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractChooserPropertySection#getComboFeatureValues()
     * @generated NOT
     */
    protected Object[] getComboFeatureValues()
    {
        List containments = new ArrayList();
        SourceTargetCouple couple = (SourceTargetCouple) getEObject();

        EdgeContainerType type = couple.getContainerType();
        switch (type.getValue())
        {
            case EdgeContainerType.NONE:
                break;
            case EdgeContainerType.SOURCE:
                if (couple.getSourceNode().getObject() instanceof ModelObjectConfiguration)
                {
                    containments.addAll(((ModelObjectConfiguration) couple.getSourceNode().getObject()).getGenClass().getEcoreClass().getEAllContainments());
                }
                break;
            case EdgeContainerType.TARGET:
                if (couple.getTargetNode().getObject() instanceof ModelObjectConfiguration)
                {
                    containments.addAll(((ModelObjectConfiguration) couple.getTargetNode().getObject()).getGenClass().getEcoreClass().getEAllContainments());
                }
                break;
            case EdgeContainerType.DIAGRAM:
            case EdgeContainerType.SOURCE_CONTAINER:
            case EdgeContainerType.TARGET_CONTAINER:
            default:
                if (couple.getContainerObject() != null)
                {
                    containments.addAll(couple.getContainerObject().getEcoreClass().getEAllContainments());
                }
                break;
        }
        if (!containments.contains(null))
        {
            containments.add(null);
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
