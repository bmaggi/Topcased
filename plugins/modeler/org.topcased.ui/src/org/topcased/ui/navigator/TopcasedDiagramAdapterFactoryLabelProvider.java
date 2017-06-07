/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.topcased.modeler.di.model.Diagram;
import org.topcased.modeler.extensions.DiagramDescriptor;
import org.topcased.modeler.extensions.DiagramsManager;

/**
 * A generic LabelProvider used with DI files and its content.
 * 
 * Creation 4 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class TopcasedDiagramAdapterFactoryLabelProvider extends AdapterFactoryLabelProvider
{
    /**
     * Constructor
     */
    public TopcasedDiagramAdapterFactoryLabelProvider()
    {
        super(TopcasedDiagramAdapterFactoryProvider.getAdapterFactory());
    }

    /**
     * Returns the platform icon for a file. In the case of a Diagram element, we try to retrieve the icon that was
     * defined by the extension, otherwise we use the default icon.
     * 
     * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getImage(java.lang.Object)
     */
    @Override
    public Image getImage(Object object)
    {
        if (object instanceof IFile)
        {
            return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
        }
        else if (object instanceof Diagram)
        {
            Diagram diag = (Diagram) object;

            String id = diag.getSemanticModel().getPresentation();
            if (id != null && !"".equals(id))
            {
                DiagramDescriptor diagDesc = DiagramsManager.getInstance().find(id);
                if (diagDesc != null)
                {
                    Image icon = diagDesc.getIcon();
                    if (icon != null)
                    {
                        return icon;
                    }
                }
            }

            return super.getImage(diag);
        }
        return super.getImage(object);
    }

    /**
     * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getText(java.lang.Object)
     */
    @Override
    public String getText(Object object)
    {
        if (object instanceof IFile)
        {
            return ((IFile) object).getName();
        }
        return super.getText(object);
    }
}
