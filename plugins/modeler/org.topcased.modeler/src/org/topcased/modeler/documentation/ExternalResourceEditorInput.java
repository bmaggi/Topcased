/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.documentation;

import java.io.File;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IPathEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.editors.text.ILocationProvider;
import org.eclipse.ui.model.IWorkbenchAdapter;

/**
 * A class defining an editor input in order to be able to visualize external
 * resources in eclipse editors.</br> This class has been copied from
 * org.eclipse.ui.internal.editors.text.JavaFileEditorInput.<br/> Creation : 11
 * oct. 2005
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 */
public class ExternalResourceEditorInput implements IPathEditorInput, ILocationProvider
{

    /**
     * The workbench adapter which simply provides the label.
     * 
     * @since 3.1
     */
    private class WorkbenchAdapter implements IWorkbenchAdapter
    {
        /*
         * @see org.eclipse.ui.model.IWorkbenchAdapter#getChildren(java.lang.Object)
         */
        public Object[] getChildren(Object o)
        {
            return null;
        }

        /*
         * @see org.eclipse.ui.model.IWorkbenchAdapter#getImageDescriptor(java.lang.Object)
         */
        public ImageDescriptor getImageDescriptor(Object object)
        {
            return null;
        }

        /*
         * @see org.eclipse.ui.model.IWorkbenchAdapter#getLabel(java.lang.Object)
         */
        public String getLabel(Object o)
        {
            return ((ExternalResourceEditorInput) o).getName();
        }

        /*
         * @see org.eclipse.ui.model.IWorkbenchAdapter#getParent(java.lang.Object)
         */
        public Object getParent(Object o)
        {
            return null;
        }
    }

    private File fFile;

    private WorkbenchAdapter fWorkbenchAdapter = new WorkbenchAdapter();

    public ExternalResourceEditorInput(File file)
    {
        super();
        fFile = file;
        fWorkbenchAdapter = new WorkbenchAdapter();
    }

    /*
     * @see org.eclipse.ui.IEditorInput#exists()
     */
    public boolean exists()
    {
        return fFile.exists();
    }

    /*
     * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
     */
    public ImageDescriptor getImageDescriptor()
    {
        return null;
    }

    /*
     * @see org.eclipse.ui.IEditorInput#getName()
     */
    public String getName()
    {
        return fFile.getName();
    }

    /*
     * @see org.eclipse.ui.IEditorInput#getPersistable()
     */
    public IPersistableElement getPersistable()
    {
        return null;
    }

    /*
     * @see org.eclipse.ui.IEditorInput#getToolTipText()
     */
    public String getToolTipText()
    {
        return fFile.getAbsolutePath();
    }

    /*
     * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
     */
    public Object getAdapter(Class adapter)
    {
        if (ILocationProvider.class.equals(adapter))
        {
            return this;
        }
        if (IWorkbenchAdapter.class.equals(adapter))
        {
            return fWorkbenchAdapter;
        }
        return Platform.getAdapterManager().getAdapter(this, adapter);
    }

    /*
     * @see org.eclipse.ui.editors.text.ILocationProvider#getPath(java.lang.Object)
     */
    public IPath getPath(Object element)
    {
        if (element instanceof ExternalResourceEditorInput)
        {
            ExternalResourceEditorInput input = (ExternalResourceEditorInput) element;
            return Path.fromOSString(input.fFile.getAbsolutePath());
        }
        return null;
    }

    /*
     * @see org.eclipse.ui.IPathEditorInput#getPath()
     * @since 3.1
     */
    public IPath getPath()
    {
        return Path.fromOSString(fFile.getAbsolutePath());
    }

    /*
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o)
    {
        if (o == this)
        {
            return true;
        }

        if (o instanceof ExternalResourceEditorInput)
        {
            ExternalResourceEditorInput input = (ExternalResourceEditorInput) o;
            return fFile.equals(input.fFile);
        }

        if (o instanceof IPathEditorInput)
        {
            IPathEditorInput input = (IPathEditorInput) o;
            return getPath().equals(input.getPath());
        }

        return false;
    }

    /*
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
    {
        return fFile.hashCode();
    }
}
