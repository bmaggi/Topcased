/*****************************************************************************
 * Copyright (c) 2013 Atos
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Anne Haugommard (Atos ) anne.haugommard@atos.net - Initial API and implementation
 * 
 *****************************************************************************/
package org.topcased.preferences.batch;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.preferences.IExportedPreferences;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;

public class ImportPreferencesApplication implements IApplication {

	/** check if arguments are valid */
	private boolean validArguments = true;

	/** first and only argument to set the preferences file location */
	private ArgOpt preferencesFile = new ArgOpt("preferencesFile",
			ArgOpt.REQUIRED_ARGUMENT, ArgOpt.REQUIRED_ARGUMENT_VALUE, "pref",
			"preferences file URL (.epf)");

	private String preferencesFileLocation = null;
	private boolean successful = false;

	@Override
	public Object start(IApplicationContext context) throws Exception {

		Display.getDefault().wake();
		// setupWorkbench();
		String[] args = (String[]) context.getArguments().get(
				IApplicationContext.APPLICATION_ARGS);
		// Get the arguments
		GetOpt getOpt = new GetOpt();
		String argFlat = getOpt.getFlatArguments(args);
		ArgOpt[] listOpts = { preferencesFile };
		HashMap<String, String> parameters = new HashMap<String, String>();
		if (argFlat.indexOf("--help") >= 0 || argFlat.indexOf("-h") >= 0) {

			getOpt.printHelp(listOpts);
			this.validArguments = false;
		} else {
			parameters = getOpt.getArguments(listOpts, args);
			if (GetOpt.error == null || GetOpt.error.length() > 0) {
				System.out.println(GetOpt.error);
				this.validArguments = false;
			}

		}
		/**
		 * If the arguments are valid
		 */
		/**
		 * If the arguments are valid
		 */
		if (this.validArguments) {
			preferencesFileLocation = parameters.get("preferencesFile");
			try {
				log(IStatus.INFO,
						"Starting the batch mode for preferences import ...");
				log(IStatus.INFO,
						"--------------------------------------------------");
				File preferences = new File(preferencesFileLocation);
				/*
				 * Manage the existence/validity of the document template
				 */
				if (!preferences.exists()) {
					throw new Exception("This preferences file does not exist ");
				}
				if (!preferences.isDirectory()) {
					IPreferencesService service = org.eclipse.core.runtime.Platform
							.getPreferencesService();

					log(IStatus.INFO, "Reading preferences file : '"
							+ preferencesFileLocation + "'...");
					IExportedPreferences prefs = service
							.readPreferences(new FileInputStream(preferences));
					if (prefs == null) {
						log(IStatus.ERROR,
								"Preferences file '+preferencesFileLocation+' is not a valid file. Please re-generate it...");
						return EXIT_OK;
					}
					log(IStatus.INFO, "Applying preferences from file ...");
					IStatus resultStatus = service.applyPreferences(prefs);
					successful = resultStatus.isOK();
				}
			} catch (Exception e) {
				log(IStatus.INFO, "\n$$$$$$$$$$$$$--ERROR--$$$$$$$$$$$$$");
				String message = " Exception occured : " + e.getMessage();
				log(IStatus.ERROR, message);
				log(IStatus.INFO, "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
			}

		}
		if (successful) {
			log(IStatus.INFO, "Import is successful. ");
		} else {
			log(IStatus.INFO, "An error occured. ");
		}
		/*
		 * Stop the application
		 */
		this.stop();
		return EXIT_OK;
	}

	@Override
	public void stop() {
		log(IStatus.INFO, "End of the preferences import");
		log(IStatus.INFO, "--------------------------------------------------");
	}

	private void log(int status, String message) {
		System.out.println(message);
	}

}
