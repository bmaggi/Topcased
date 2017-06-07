/**
 * Copyright (c) 2005-2006 Aptana, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html. If redistributing this code,
 * this entire header must remain intact.
 */
package org.eclipse.eclipsemonkey.utils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import org.osgi.framework.Bundle;

/**
 * @author Kevin Lindsey based on code by Patrick Mueller
 */
public class BundleClassLoader extends ClassLoader
{
	private ArrayList _bundles;

	/**
	 * ScriptClassLoader
	 */
	public BundleClassLoader()
	{
		super(BundleClassLoader.class.getClassLoader());

		this._bundles = new ArrayList();
	}

	/**
	 * addBundle
	 *
	 * @param bundle
	 */
	public void addBundle(Bundle bundle)
	{
		if (bundle == null)
		{
			throw new IllegalArgumentException("Messages.BundleClassLoader_BundleMustNotBeNull");
		}
		
		if (this._bundles.contains(bundle) == false)
		{
			this._bundles.add(bundle);
		}
	}

	/**
	 * findClass
	 * 
	 * @param name
	 * @return Class
	 * @throws ClassNotFoundException
	 */
	protected Class findClass(String name) throws ClassNotFoundException
	{
		Class result = this.loadClassFromBundles(name);

		if (result == null)
		{
			throw new ClassNotFoundException(StringUtils.format("Messages.BundleClassLoader_UnableToFindClass", name));
		}

		return result;
	}
	
	/**
	 * findResource
	 * 
	 * @param name
	 * @return URL
	 */
	protected URL findResource(String name)
	{
		URL result = super.findResource(name);

		if (result == null)
		{
			Iterator iterator = this._bundles.iterator();
			
			while (iterator.hasNext())
			{
				Bundle bundle = (Bundle) iterator.next();
				
				result = bundle.getResource(name);

				if (result != null)
				{
					break;
				}
			}
		}

		return result;
	}

	/**
	 * findResources
	 * 
	 * @param name
	 * @return Enumeration
	 * @throws IOException
	 */
	protected Enumeration findResources(String name) throws IOException
	{
		Enumeration result = super.findResources(name);

		if (result == null)
		{
			Iterator iterator = this._bundles.iterator();
			
			while (iterator.hasNext())
			{
				Bundle bundle = (Bundle) iterator.next();
				
				result = bundle.getResources(name);

				if (result != null)
				{
					break;
				}
			}
		}

		if (result == null)
		{
			throw new IOException(StringUtils.format("Messages.BundleClassLoader_UnableToFindResources", name));
		}

		return result;
	}

	/**
	 * loadClass
	 * 
	 * @param name
	 * @return Class
	 * @throws ClassNotFoundException
	 */
	public Class loadClass(String name) throws ClassNotFoundException
	{
		Class result = super.loadClass(name);

		if (result == null)
		{
			result = this.loadClassFromBundles(name);
		}

		if (result == null)
		{
			throw new ClassNotFoundException(StringUtils.format("Messages.BundleClassLoader_UnableToLoadClass", name));
		}

		return result;
	}

	/**
	 * loadClass
	 * 
	 * @param name
	 * @param resolve
	 * @return Class
	 * @throws ClassNotFoundException
	 */
	protected synchronized Class loadClass(String name, boolean resolve) throws ClassNotFoundException
	{
		Class result = super.loadClass(name, resolve);

		if (result == null)
		{
			result = this.loadClassFromBundles(name);
		}

		if (result == null)
		{
			throw new ClassNotFoundException(StringUtils.format("Messages.BundleClassLoader_UnableToLoadClass", name));
		}

		return result;
	}

	/**
	 * loadClassFromBundles
	 * 
	 * @param name
	 * @return Class
	 * @throws ClassNotFoundException
	 */
	private Class loadClassFromBundles(String name) throws ClassNotFoundException
	{
		Class result = null;
		Iterator iterator = this._bundles.iterator();

		while (iterator.hasNext())
		{
			Bundle bundle = (Bundle) iterator.next();

			result = bundle.loadClass(name);

			if (result != null)
			{
				break;
			}
		}

		return result;
	}
}
