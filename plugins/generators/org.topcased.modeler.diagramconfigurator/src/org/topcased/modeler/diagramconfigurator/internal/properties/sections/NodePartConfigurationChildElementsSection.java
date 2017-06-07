package org.topcased.modeler.diagramconfigurator.internal.properties.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.NodePartConfiguration;
import org.topcased.modeler.diagramconfigurator.provider.DiagramconfiguratorItemProviderAdapterFactory;
import org.topcased.tabbedproperties.AbstractTabbedPropertySheetPage;
import org.topcased.tabbedproperties.providers.TabbedPropertiesLabelProvider;
import org.topcased.tabbedproperties.sections.AbstractReferencePropertySection;

/**
 * A section which displays the multi features.<br>
 * The section features a table with two buttons letting the user to add or remove items from the selected object.
 * 
 * @generated
 */
public class NodePartConfigurationChildElementsSection extends AbstractReferencePropertySection
{

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
     * @generated
     */
    protected String getLabelText()
    {
        return "ChildElements:";
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
     * @generated
     */
    protected EStructuralFeature getFeature()
    {
        return DiagramconfiguratorPackage.eINSTANCE.getNodePartConfiguration_ChildElements();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractListPropertySection#getListValues()
     * @generated
     */
    protected Object getListValues()
    {
        return ((NodePartConfiguration) getEObject()).getChildElements();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractListPropertySection#getLabelProvider()
     * @generated
     */
    protected IBaseLabelProvider getLabelProvider()
    {
        if (getFeature() instanceof EReference)
        {
            List f = new ArrayList();
            f.add(new DiagramconfiguratorItemProviderAdapterFactory());
            f.addAll(AbstractTabbedPropertySheetPage.getPrincipalAdapterFactories());
            return new TabbedPropertiesLabelProvider(new ComposedAdapterFactory(f));
        }
        return null;
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
     * @custom
     */
    public boolean shouldUseExtraSpace()
    {
        return true;
    }
}