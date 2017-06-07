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

package org.topcased.gmfconverter.generator.gmfgraph;

import org.eclipse.gmf.gmfgraph.LineKind;
import org.topcased.gmfconverter.generator.GeneratorException;
import org.topcased.gmfconverter.generator.ObjectGenerator;
import org.topcased.modeler.diagramconfigurator.LineStyle;

/**
 * @author Nicolas
 */
public class LineStyleGraphGenerator extends ObjectGenerator<LineStyle>
{
    /**
     * @see org.topcased.gmfconverter.generator.ObjectGenerator#createGMFObject(java.lang.Object, java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    protected <G> G createGMFObject(LineStyle topCasedObject, Class<G> gmfClass) throws GeneratorException
    {
        if (!LineKind.class.equals(gmfClass))
        {
            throw new GeneratorException("gmfClass must be a LineKind.");
        }
        switch (topCasedObject.getValue())
        {
            case LineStyle.CUSTOM:
                return (G) LineKind.LINE_CUSTOM_LITERAL;
            case LineStyle.DASH:
                return (G) LineKind.LINE_DASH_LITERAL;
            case LineStyle.DASHDOT:
                return (G) LineKind.LINE_DASHDOT_LITERAL;
            case LineStyle.DASHDOTDOT:
                return (G) LineKind.LINE_DASHDOTDOT_LITERAL;
            case LineStyle.DOT:
                return (G) LineKind.LINE_DOT_LITERAL;
            case LineStyle.SOLID:
                return (G) LineKind.LINE_SOLID_LITERAL;
            default:
                throw new GeneratorException("Unknow LineStyle type.");
        }

    }
}
