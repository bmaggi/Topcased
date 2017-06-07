/**
 * @generated
 */
package org.topcased.modeler.diagramconfigurator.internal.properties.sections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.viewers.ILabelProvider;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.ObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.PartConfiguration;
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
public class SourceTargetCoupleRefEdgeToSourceSection extends AbstractChooserPropertySection
{
    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "RefEdgeToSource:";
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return DiagramconfiguratorPackage.eINSTANCE.getSourceTargetCouple_RefEdgeToSource();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractChooserPropertySection#getFeatureValue()
     * @generated
     */
    protected Object getFeatureValue()
    {
        return ((SourceTargetCouple) getEObject()).getRefEdgeToSource();
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

        SourceTargetCouple couple = (SourceTargetCouple) getEObject();
        if (couple.getSourceNode() != null)
        {
            ObjectConfiguration sourceObjConf = couple.getSourceNode().getObject();
            ObjectConfiguration edgeObjConf = ((PartConfiguration) couple.eContainer()).getObject();
            if (sourceObjConf instanceof ModelObjectConfiguration && edgeObjConf instanceof ModelObjectConfiguration)
            {
                for (Iterator iter = ((ModelObjectConfiguration) edgeObjConf).getGenClass().getEcoreClass().getEAllStructuralFeatures().iterator(); iter.hasNext();)
                {
                    EStructuralFeature eStructuralFeature = (EStructuralFeature) iter.next();
                    if (eStructuralFeature.getEType() instanceof EClass)
                    {
                        if (((EClass) eStructuralFeature.getEType()).isSuperTypeOf(((ModelObjectConfiguration) sourceObjConf).getGenClass().getEcoreClass()))
                        {
                            containments.add(eStructuralFeature);
                        }
                    }
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
