/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Atos - initial API and implementation
 ******************************************************************************/
package org.topcased.iterators.configurations;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osgi.framework.BundleContext;
import org.topcased.iterators.configurations.exceptions.ConfigurationLoadingException;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.topcased.iterators.configurations"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Logs an error from the exception to the activator logger.
	 * 
	 * @param e
	 *        the exception.
	 */
	public static void logError(Exception e) {
		ILog logger = Activator.getDefault().getLog();
		IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
		logger.log(status);
	}

	//	/**
	//	 * Logs a semantic exception
	//	 * @param e the exception.
	//	 */
	//	public static void logSemanticException(SemanticException e){
	//		ILog logger = Activator.getDefault().getLog();
	//		IStatus status = new Status(IStatus.WARNING,Activator.PLUGIN_ID,e.getMessage(),e);
	//		logger.log(status); 
	//	}

	/**
	 * Logs an error from the exception to the activator logger.
	 * 
	 * @param e
	 *        the exception.
	 */
	public static void displayLoadingError(Exception e) {
		if(e instanceof ConfigurationLoadingException) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), null);
			StatusManager.getManager().handle(status, StatusManager.BLOCK);
		}
	}

}
