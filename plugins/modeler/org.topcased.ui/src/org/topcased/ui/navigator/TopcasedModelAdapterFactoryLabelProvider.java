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
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * A generic LabelProvider used with Model files and its content.
 * 
 * Creation 4 janv. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class TopcasedModelAdapterFactoryLabelProvider extends AdapterFactoryLabelProvider
{
    /**
     * Construct an instance that wraps this factory.
     * 
     * @param adapterFactory The AdapterFactory should yield adapters that implement the various item label provider
     *        interfaces.
     */
    public TopcasedModelAdapterFactoryLabelProvider(AdapterFactory adapterFactory)
    {
        super(adapterFactory);
    }

    /**
     * Returns the platform icon for a file. You can replace with your own icon If not a IFile, then passes to the
     * regular EMF.Edit providers
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
