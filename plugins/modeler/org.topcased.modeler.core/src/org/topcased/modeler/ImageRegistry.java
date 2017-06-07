/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;
import org.topcased.modeler.internal.ModelerPlugin;

/**
 * The Image registry for the plugin <br>
 * Creation : 24 mars 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @author <a href="mailto:tristan.faure@atosorigin.com">Tristan FAURE</a>
 * Fix bug with key duplication previously the test was done with url.toString and url
 */
public final class ImageRegistry
{

    private static ImageRegistry imageRegistry = null;

    /**
     * Contains the data for an entry in the registry.
     */
    private static class Entry
    {
        /**
         * Comment for <code>image</code>
         */
        Image image;

        /**
         * Comment for <code>descriptor</code>
         */
        ImageDescriptor descriptor;

    }

    /**
     * Table of known images keyed by symbolic image name (key type:
     * <code>URL</code>, value type:
     * <code>Entry</code>).
     */
    private Map<URL, Entry> entries = null;

    /**
     * display used when getting images
     */
    private Display display;

    /**
     * The bundle used to compute image URL by default
     */
    private Bundle bundle;

    /**
     * Creates an empty image registry.
     * <p>
     * There must be an SWT Display created in the current thread before calling
     * this method.
     * </p>
     * 
     * @param b the default bundle used to compute URL
     */
    private ImageRegistry(Bundle b)
    {
        this(b, Display.getCurrent());
    }

    /**
     * Creates an empty image registry.
     * 
     * @param b the default bundle used to compute URL
     * @param d this <code>Display</code> must not be <code>null</code> and
     *            must not be disposed in order to use this registry
     */
    private ImageRegistry(Bundle b, Display d)
    {
        super();
        Assert.isNotNull(d);
        display = d;
        bundle = b;
        hookDisplayDispose(display);
    }

    /**
     * 
     * get the instance of registry
     * 
     * @return the shared instance
     */
    public static ImageRegistry getInstance()
    {
        if (imageRegistry == null)
        {
            imageRegistry = new ImageRegistry(ModelerPlugin.getDefault().getBundle());
            return imageRegistry;
        }

        return imageRegistry;

    }

    /**
     * Hook a dispose listener on the SWT display.
     * 
     * @param d the Display
     */
    private void hookDisplayDispose(Display d)
    {
        d.disposeExec(new Runnable()
        {
            public void run()
            {
                handleDisplayDispose();
            }
        });
    }

    /**
     * Shut downs this resource registry and disposes of all registered images.
     */
    protected void handleDisplayDispose()
    {
        // remove reference to display
        display = null;
        // Do not bother if the table was never used
        if (entries == null)
        {
            return;
        }

        for (Iterator<Entry> e = entries.values().iterator(); e.hasNext();)
        {
            Entry entry = e.next();
            if (entry.image != null)
            {
                entry.image.dispose();
            }
        }
        entries = null;
    }

    public void remove(URL key)
    {
        getEntries().remove(key.toString());
    }

    private Entry getEntry(URL key)
    {
        if (key == null)
        {
            return null;
        }
        Entry entry = (Entry) getEntries().get(key);
        if (entry == null)
        {
            ImageDescriptor descriptor = ImageDescriptor.createFromURL(key);
            entry = put(key, descriptor);
        }

        return entry;
    }

    private void putEntry(URL key, Entry entry)
    {
        getEntries().put(key, entry);
    }

    /**
     * Adds (or replaces) an image descriptor to this registry. The first time
     * this new entry is retrieved, the image descriptor's image will be
     * computed (via<code>ImageDescriptor.createImage</code>) and
     * remembered. This method replaces an existing image descriptor associated
     * with the given key, but fails if there is a real image associated with
     * it.
     * 
     * @param key the key
     * @param descriptor the ImageDescriptor
     * @return the created or updated entry
     * @exception IllegalArgumentException if the key already exists
     */
    private Entry put(URL key, ImageDescriptor descriptor)
    {
        Entry entry = (Entry) getEntries().get(key);
        if (entry == null)
        {
            entry = new Entry();
            putEntry(key, entry);
        }
        if (entry.image == null)
        {
            entry.descriptor = descriptor;
            return entry;
        }
        throw new IllegalArgumentException("ImageRegistry key already in use: " + key); //$NON-NLS-1$
    }

    private Map<URL, Entry> getEntries()
    {
        if (entries == null)
        {
            entries = new HashMap<URL, Entry>(10);
        }
        return entries;
    }

    /**
     * Returns the image associated with the given key in this registry, or
     * <code>null</code> if none.
     * 
     * @param key the key
     * @return the image, or <code>null</code> if none
     */
    public Image get(URL key)
    {
        // can be null
        if (key == null)
        {
            return null;
        }

        Entry entry = getEntry(key);

        if (entry == null)
        {
            return null;
        }
        if (entry.image == null && entry.descriptor != null)
        {
            entry.image = entry.descriptor.createImage();
        }
        return entry.image;
    }

    /**
     * Returns the descriptor associated with the given key in this registry, or
     * <code>null</code> if none.
     * 
     * @param key the key
     * @return the descriptor, or <code>null</code> if none
     */
    public ImageDescriptor getDescriptor(URL key)
    {
        Entry entry = getEntry(key);
        if (entry == null)
        {
            return null;
        }
        return entry.descriptor;
    }

    /**
     * Get the image from the given bundle and the plugin image path
     * 
     * @param b the bundle where find the image
     * @param path the image path
     * @return the image
     */
    public Image get(final Bundle b, final String path)
    {
        if (b.getState() == Bundle.ACTIVE)
        {
            URL pathURL = FileLocator.find(b, new Path(path), null);
            return get(pathURL);
        }

        final Object[] ret = new Object[1];
        BusyIndicator.showWhile(null, new Runnable()
        {
            public void run()
            {
                URL pathURL = FileLocator.find(b, new Path(path), null);
                ret[0] = get(pathURL);
            }
        });

        return (Image) ret[0];

    }

    /**
     * 
     * get image descriptor
     * 
     * @param b
     * @param path
     * @return
     */
    public ImageDescriptor getDescriptor(final Bundle b, final String path)
    {
        if (b.getState() == Bundle.ACTIVE)
        {
            URL pathURL = FileLocator.find(b, new Path(path), null);
            return getDescriptor(pathURL);
        }

        final Object[] ret = new Object[1];
        BusyIndicator.showWhile(null, new Runnable()
        {
            public void run()
            {
                URL pathURL = FileLocator.find(b, new Path(path), null);
                ret[0] = getDescriptor(pathURL);
            }
        });

        return (ImageDescriptor) ret[0];

    }

    /**
     * 
     * get image by its path
     * 
     * @param path
     * @return
     */
    public Image get(String path)
    {
        return get(bundle, path);
    }

    /**
     * 
     * get image descriptor by its path
     * 
     * @param path
     * @return
     */
    public ImageDescriptor getDescriptor(String path)
    {
        return getDescriptor(bundle, path);
    }
}
