/***********************************************************************
 * Copyright (c) 2007, 2008 Topcased consortium
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas LAMBERT (Anyware Technologies) - initial API and implementation
 *    Jacques LESCOT (Anyware Technologies) - Code review
 **********************************************************************/

package org.topcased.gmfconverter.generator.gmfmap;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LinkMapping;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.modeler.diagramconfigurator.EdgePartConfiguration;
import org.topcased.modeler.diagramconfigurator.SourceTargetCouple;

public class EdgePartConfigurationMapGenerator extends MapGenerator<EdgePartConfiguration>
{

    @SuppressWarnings("unchecked")
    @Override
    protected <G> G createGMFObject(EdgePartConfiguration edgePartConfiguration, Class<G> gmfClass) throws GeneratorException
    {
        if (LinkMapping.class.equals(gmfClass))
        {
            return (G) getLinkMapping(edgePartConfiguration);
        }
        else
        {
            throw new GeneratorException("gmfClass must be a LinkMapping.");
        }
    }

    private LinkMapping getLinkMapping(EdgePartConfiguration edgePartConfiguration)
    {
        LinkMapping linkMapping = GMFMapFactory.eINSTANCE.createLinkMapping();
        linkMapping.setTool(MapRegistry.getAbstractTool(edgePartConfiguration));
        setDomainMetaElement(linkMapping, edgePartConfiguration);
        linkMapping.setDiagramLink(MapRegistry.getConnection(edgePartConfiguration));

        if (edgePartConfiguration.getSourceTargetCouple().size() > 0)
        {
            // FIXME : check why it's a list and if it's really possible to get more than 1 couple.
            SourceTargetCouple sourceTargetCouple = edgePartConfiguration.getSourceTargetCouple().get(0);
            if (sourceTargetCouple.getRefSourceToTarget() != null)
            {
                linkMapping.setLinkMetaFeature(sourceTargetCouple.getRefSourceToTarget());
            }
            else if (sourceTargetCouple.getRefEdgeToTarget() != null)
            {
                linkMapping.setLinkMetaFeature(sourceTargetCouple.getRefEdgeToTarget());
            }
            else if (sourceTargetCouple.getRefTargetToSource() != null && sourceTargetCouple.getRefTargetToSource() instanceof EReference)
            {
                EReference refTargetToSource = (EReference) sourceTargetCouple.getRefTargetToSource();
                if (refTargetToSource.getEOpposite() != null)
                {
                    linkMapping.setLinkMetaFeature(refTargetToSource.getEOpposite());
                }
            }
            if (sourceTargetCouple.getContainerRef() instanceof EReference)
            {
                linkMapping.setContainmentFeature((EReference) sourceTargetCouple.getContainerRef());
            }
        }
        return linkMapping;
    }
}
