/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Anass Radouani (Atos) anass.radouani@atos.net - add verification of editor before installing decorators
 *******************************************************************************/

package org.topcased.modeler.internal.decorators;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.topcased.modeler.edit.EListEditPart;
import org.topcased.modeler.utils.Utils;

/**
 * This class provides a decorator for the EMF problems
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ErrorDecoratorProvider extends AbstractProvider implements IDecoratorProvider
{

    /** The key used for the mood decoration */
    public static final String ERROR = "Error_Decorator"; //$NON-NLS-1$

    /**
     * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider#createDecorators(org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget)
     */
    public void createDecorators(IDecoratorTarget decoratorTarget)
    {
        
        if (Utils.getCurrentModeler() != null)
        {
            EObject object = ErrorDecorator.getEObjectDecoratorTarget(decoratorTarget);
            if (object != null)
            {
                decoratorTarget.installDecorator(ERROR, new ErrorDecorator(decoratorTarget));
            }
        }
    }

    /**
     * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
     */
    public boolean provides(IOperation operation)
    {
        Assert.isNotNull(operation);

        if (operation instanceof CreateDecoratorsOperation)
        {
            IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation).getDecoratorTarget();

            GraphicalEditPart editPart = (GraphicalEditPart) decoratorTarget.getAdapter(GraphicalEditPart.class);
            if (editPart != null)
            {
                if (editPart instanceof EListEditPart)
                {
                    return false;
                }
                else
                {
                    return ErrorDecorator.getEObjectDecoratorTarget(decoratorTarget) != null;
                }
            }
        }
        return false;
    }
}
