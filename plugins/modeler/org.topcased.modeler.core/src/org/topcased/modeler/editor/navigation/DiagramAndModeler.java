 /*******************************************************************************
  * Copyright (c) 2008 TOPCASED. All rights reserved. This program
  * and the accompanying materials are made available under the terms of the
  * Eclipse Public License v1.0 which accompanies this distribution, and is
  * available at http://www.eclipse.org/legal/epl-v10.html
  *
  * Contributors: Topcased contributors and others - initial API and implementation
  *******************************************************************************/
package org.topcased.modeler.editor.navigation;

import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.editor.Modeler;

/**
 * This class is use in the navigation manager to store the diagram and its modeler.
 * The safeguarding of the diagram is not suffisant because the navigation can be between 
 * to modeler if there is an instance of system in the first modeler.
 * <br>Creation : 28 mai 2008
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
 */
public class DiagramAndModeler
{
    private Diagram diagram;
    private Modeler modeler;
    
    /**
     * Create an instance of DiagramAndModeler
     * @param diagram The diagram referenced by this instance
     * @param modeler The modeler referenced by this instance
     */
    public DiagramAndModeler(Diagram diagram, Modeler modeler)
    {
        setDiagram(diagram);
        setModeler(modeler);
    }
    
    /**
     * @return the diagram
     */
    public Diagram getDiagram()
    {
        return diagram;
    }
    /**
     * @return the modeler
     */
    public Modeler getModeler()
    {
        return modeler;
    }

    /**
     * @param diagram the diagram to set
     */
    private void setDiagram(Diagram diagram)
    {
        this.diagram = diagram;
    }

    /**
     * @param modeler the modeler to set
     */
    private void setModeler(Modeler modeler)
    {
        this.modeler = modeler;
    }
    
    
}
