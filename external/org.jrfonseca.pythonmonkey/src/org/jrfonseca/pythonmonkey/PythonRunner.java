/*******************************************************************************
 * Copyright (c) 2005, 2006 Eclipse Foundation
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bjorn Freeman-Benson - initial implementation
 *     Ward Cunningham - initial implementation
 *     José Fonseca - adapted for python
 *******************************************************************************/

package org.jrfonseca.pythonmonkey;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.eclipsemonkey.EclipseMonkeyPlugin;
import org.eclipse.eclipsemonkey.IMonkeyScriptRunner;
import org.eclipse.eclipsemonkey.RunMonkeyException;
import org.eclipse.eclipsemonkey.ScriptMetadata;
import org.eclipse.eclipsemonkey.StoredScript;
import org.eclipse.eclipsemonkey.dom.IMonkeyDOMFactory;
import org.eclipse.eclipsemonkey.dom.Utilities;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import org.python.util.PythonInterpreter;
import org.python.core.*;

/**
 *
 */
public class PythonRunner implements IMonkeyScriptRunner {

	IPath path;
	IWorkbenchWindow window;
	StoredScript storedScript;

	static MessageConsole console;
	static MessageConsoleStream consoleOutStream;
	static MessageConsoleStream consoleErrStream;
	

	/**
	 * 
	 * @param path
	 * @param window
	 */
	public PythonRunner(IPath path, IWorkbenchWindow window) {
		this.path = path;
		if(window == null) {
			this.window =  PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		} else {
			this.window = window;
		}
	}
	
	/**
	 * @see org.eclipse.eclipsemonkey.IMonkeyScriptRunner#getStoredScript()
	 */
	public StoredScript getStoredScript() {
		return storedScript;
	}

	/**
	 * @see org.eclipse.eclipsemonkey.IMonkeyScriptRunner#run(java.lang.String, java.lang.Object[])
	 */
	public Object run(String entryName, Object[] functionArgs) 
			throws RunMonkeyException {
		
		Object result = null;
		
		try {
			String fileName = this.path.toPortableString();
			Map scriptStore = EclipseMonkeyPlugin.getDefault().getScriptStore();

			storedScript = (StoredScript) (scriptStore.get(fileName));
			
			if (!storedScript.metadata.ensure_doms_are_loaded(window)) {
				return null;
			}

			defineDynamicVariables(path);

			try {
				PythonInterpreter interp = new PythonInterpreter();

				defineStandardGlobalVariables(interp);
				defineExtensionGlobalVariables(interp, storedScript.metadata);
				
				interp.setOut(getConsoleOutStream());
				interp.setErr(getConsoleErrStream());
				
				interp.execfile(new FileInputStream(path.toFile()), path.toPortableString());
			}
			finally {
				undefineDynamicVariables(path);
			}
		}
		catch (PyException x) {
			error(x, this.path.toString(), x.toString());
		}
		catch (IOException x)
		{
			error(x, this.path.toString(), x.toString());
		}
		
		return result;
	}

	private void defineStandardGlobalVariables(PythonInterpreter interp) {
		interp.set("window", window);
		//interp.set("loadBundle", this.loadBundle)
	}

	private void defineExtensionGlobalVariables(PythonInterpreter interp,
			ScriptMetadata metadata) throws IOException 
	{
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry
				.getExtensionPoint("org.eclipse.eclipsemonkey.dom");
		if (point != null) {
			IExtension[] extensions = point.getExtensions();
			for (int i = 0; i < extensions.length; i++) {
				IExtension extension = extensions[i];
				IConfigurationElement[] configurations = extension
						.getConfigurationElements();
				for (int j = 0; j < configurations.length; j++) {
					IConfigurationElement element = configurations[j];
					try {
						IExtension declaring = element.getDeclaringExtension();

//						String declaring_plugin_id = declaring
//								.getDeclaringPluginDescriptor()
//								.getUniqueIdentifier();
						String declaring_plugin_id = declaring.getNamespaceIdentifier();
						
						if (metadata.containsDOM_by_plugin(declaring_plugin_id)) {
							String variableName = element
									.getAttribute("variableName");
							Object object = element
									.createExecutableExtension("class");
							IMonkeyDOMFactory factory = (IMonkeyDOMFactory) object;
							
							Object rootObject = factory.getDOMroot();
							
							interp.set(variableName, rootObject);
						}
					} catch (InvalidRegistryObjectException x) {
						// ignore bad extensions
					} catch (CoreException x) {
						// ignore bad extensions
					}
				}
			}
		}
	}
	
	private void defineDynamicVariables(IPath path) {
		Utilities.state().begin(path);
		Utilities.state().set(Utilities.SCRIPT_NAME, path.toPortableString());
	}

	private void undefineDynamicVariables(IPath path) {
		Utilities.state().end(path);
	}

	private void error(Exception x, String fileName, String string)
			throws RunMonkeyException {

		RunMonkeyException e = new RunMonkeyException(x.getClass().getName(), fileName, null,
				string);

		MessageConsoleStream cs = getConsoleErrStream();		
		cs.println(e.toString());

		throw e;
	}
	
	/**
	 * Returns a reference to the current console, initializing it if it's not created
	 * 
	 * @return A console stream
	 */
	public static MessageConsole getConsole() {
		if (console == null) {
			console = new MessageConsole("Eclipse Monkey Python Console", null);
			consoleOutStream = console.newMessageStream();
			consoleErrStream = console.newMessageStream();

			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
				public void run() {
					consoleOutStream.setColor(PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_BLACK));
					consoleErrStream.setColor(PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_RED));
				}
			});

			ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { console });
		}

		return console;
	}

	/**
	 * Returns a reference to the current console, initializing it if it's not created
	 * 
	 * @return A console stream
	 */
	public static MessageConsoleStream getConsoleOutStream() {
		getConsole();
		return consoleOutStream;
	}

	/**
	 * Returns a reference to the current console, initializing it if it's not created
	 * 
	 * @return A console stream
	 */
	public static MessageConsoleStream getConsoleErrStream() {
		getConsole();
		return consoleErrStream;
	}
}
