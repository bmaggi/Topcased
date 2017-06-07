/*******************************************************************************
 * Copyright (c) 2005,2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Vincent Hemery (Atos Origin) - Fix 783 synchronization decorator added
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

/**
 * This class provides a decorator for the Diagrams
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class ModelerDecoratorProvider extends AbstractProvider implements IDecoratorProvider
{
    /** The key used for the mood decoration */
    public static final String DIAGRAM = "Diagram_Decorator"; //$NON-NLS-1$

    /** The key used for the element not synchronized with model decoration. */
    public static final String SYNCHRONIZATION = "Not_Synchronized_Decorator"; //$NON-NLS-1$

    /**
     * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider#createDecorators(org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget)
     */
    public void createDecorators(IDecoratorTarget decoratorTarget)
    {
        EObject object = DiagramDecorator.getEObjectDecoratorTarget(decoratorTarget);
        if (object != null)
        {
            decoratorTarget.installDecorator(DIAGRAM, new DiagramDecorator(decoratorTarget));
            decoratorTarget.installDecorator(SYNCHRONIZATION, new NotSynchronizedDecorator(decoratorTarget));
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
                    boolean lSupportsOperations = DiagramDecorator.getEObjectDecoratorTarget(decoratorTarget) != null;
                    lSupportsOperations &= NotSynchronizedDecorator.getEObjectDecoratorTarget(decoratorTarget) != null;
                    return lSupportsOperations;
                }
            }
        }
        return false;
    }
}
