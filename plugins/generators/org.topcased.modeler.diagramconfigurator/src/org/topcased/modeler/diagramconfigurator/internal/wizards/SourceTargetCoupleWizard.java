//------------------------------------------------
// $Id: SourceTargetCoupleWizard.java,v 1.3 2006/12/18 14:47:50 jako Exp $
// (c) Anyware Technologies 2006    www.anyware-tech.com
//------------------------------------------------
package org.topcased.modeler.diagramconfigurator.internal.wizards;

import org.eclipse.jface.wizard.Wizard;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorFactory;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.ModelObjectConfiguration;
import org.topcased.modeler.diagramconfigurator.SourceTargetCouple;

/**
 * 
 * Wizard used to create a new SourceTargetCouple object <br>
 * creation : 4 oct. 06
 * 
 * @author <a href="mailto:mickael.gerard@anyware-tech.com">Mickael Gerard</a>
 */
public class SourceTargetCoupleWizard extends Wizard
{

    private EdgePartConfiguration edgePartConfiguration;

    private SourceTargetCouple sourceTargetCouple;

    /**
     * Create a new SourceTargetCouple Wizard with the parent edgePartConfiguration instance.
     * 
     * @param edgePartConfiguration instance that will be updated
     */
    public SourceTargetCoupleWizard(EdgePartConfiguration edgePartConfiguration)
    {
        super();
        this.edgePartConfiguration = edgePartConfiguration;
        this.sourceTargetCouple = DiagramconfiguratorFactory.eINSTANCE.createSourceTargetCouple();
        this.setWindowTitle("New SourceTargetCouple");
    }

    /**
     * add the new SourcetTargetCouple to the edgePartConfiguration
     * 
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    public boolean performFinish()
    {
        if (sourceTargetCouple != null)
        {
            edgePartConfiguration.getSourceTargetCouple().add(sourceTargetCouple);
            return true;
        }
        return false;
    }

    /**
     * @see org.eclipse.jface.wizard.Wizard#addPages()
     */
    public void addPages()
    {
        addPage(new GraphicConnectionPage("Graphic Connection"));
        addPage(new ModelPage("Model"));
        addPage(new ModelUpdatePage("Model Update"));
    }

    /**
     * 
     * @return edgePartConfiguration concerned by this wizard
     */
    public EdgePartConfiguration getEdgePartConfiguration()
    {
        return edgePartConfiguration;
    }

    /**
     * @return sourceTargetCouple which properties are modified in the wizard
     */
    public SourceTargetCouple getSourceTargetCouple()
    {
        return sourceTargetCouple;
    }

    /**
     * @return true if the edgePartConfiguration has a ModelObjectConfiguration genclass
     */
    protected boolean isLinkedToModelObjectConfiguration()
    {
        if (getEdgePartConfiguration() != null)
        {
            if (getEdgePartConfiguration().getObject() instanceof ModelObjectConfiguration)
            {
                return true;
            }
        }
        return false;
    }

}