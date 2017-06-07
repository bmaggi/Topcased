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
 *     Channing Walton - bug 143456
 *******************************************************************************/

package org.eclipse.eclipsemonkey.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IPath;
import org.eclipse.eclipsemonkey.EclipseMonkeyPlugin;
import org.eclipse.eclipsemonkey.MenuRunMonkeyScript;
import org.eclipse.eclipsemonkey.RunMonkeyException;
import org.eclipse.eclipsemonkey.ScriptMetadata;
import org.eclipse.eclipsemonkey.StoredScript;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.ParseException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.ActionSetContributionItem;
import org.eclipse.ui.internal.WorkbenchWindow;

/**
 *
 */
public class RecreateMonkeyMenuAction implements IWorkbenchWindowActionDelegate {

	/**
	 * 
	 */
	public RecreateMonkeyMenuAction() {
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		clearTheMenu();
		Collection metaDatas = getAllMetadatas();
		List menuData = createMenuFromMetadatas(metaDatas);
		createTheMenu(menuData, action);
	}

	private Collection getAllMetadatas() {
		ArrayList result = new ArrayList();
		Iterator iter = EclipseMonkeyPlugin.getDefault().getScriptStore()
				.values().iterator();
		for (; iter.hasNext();) {
			StoredScript element = (StoredScript) iter.next();
			result.add(element.metadata);
		}
		return result;
	}

	private void clearTheMenu() {
		MenuManager manager = ((WorkbenchWindow) window).getMenuManager();
		IContributionItem two = manager.findUsingPath("eclipsemonkeyMenu");
		IMenuManager three = (IMenuManager) ((ActionSetContributionItem) two)
				.getInnerItem();
		three.removeAll();
	}

	private Pattern submenu_pattern = Pattern.compile("^(.+?)>(.*)$");

	class MonkeyMenuStruct {
		String key;

		IMenuManager menu;

		MonkeyMenuStruct submenu;
	}

	private void createTheMenu(List menuData, final IAction action) {
		MenuManager outerManager = ((WorkbenchWindow) window).getMenuManager();
		IContributionItem contribution = outerManager
				.findUsingPath("eclipsemonkeyMenu");
		IMenuManager menuManager = (IMenuManager) ((ActionSetContributionItem) contribution)
				.getInnerItem();

		MonkeyMenuStruct current = new MonkeyMenuStruct();
		current.key = "";
		current.menu = menuManager;
		current.submenu = new MonkeyMenuStruct();

		SortedSet sorted = new TreeSet();
		sorted.addAll(menuData);

		Iterator iter = sorted.iterator();
		while (iter.hasNext()) {
			Association element = (Association) iter.next();
			String menu_string = element.key;
			final IPath script_file_to_run = element.path;
			String accelerator = element.accelerator;
			addNestedMenuAction(current, menu_string, script_file_to_run,
					accelerator);
		}

		final IWorkbenchWindow _window = this.window;

		if (sorted.size() != 0)
			menuManager.add(new Separator());

		if (MenuRunMonkeyScript.last_run != null) {
			String lastScriptText = "Run Last Script: "
					+ MenuRunMonkeyScript.last_run.metadata.getMenuName();
			Action rerunAction = menuAction(lastScriptText,
					MenuRunMonkeyScript.last_run.scriptPath, "CTRL+ALT+M");
			menuManager.add(rerunAction);
		}

		menuManager.add(new Action("Paste New Script") {
			public void run() {
				IWorkbenchWindowActionDelegate delegate = new PasteScriptFromClipboardAction();
				delegate.init(_window);
				delegate.run(action);
			}
		});

		if (sorted.size() == 0) {
			menuManager.add(new Action("Examples") {
				public void run() {
					IWorkbenchWindowActionDelegate delegate = new CreateMonkeyExamplesAction();
					delegate.init(_window);
					delegate.run(action);
				}
			});
		}

		menuManager.updateAll(true);

	}

	private void addNestedMenuAction(MonkeyMenuStruct current,
			String menu_string, final IPath script_file_to_run,
			String accelerator) {
		if (menu_string == null)
			return;
		Matcher match = submenu_pattern.matcher(menu_string);
		if (match.find()) {
			String primary_key = match.group(1).trim();
			String secondary_key = match.group(2).trim();
			if (!primary_key.equals(current.submenu.key)) {
				IMenuManager submenu = new MenuManager(primary_key);
				current.menu.add(submenu);
				current.submenu.menu = submenu;
				current.submenu.key = primary_key;
				current.submenu.submenu = new MonkeyMenuStruct();
			}
			addNestedMenuAction(current.submenu, secondary_key,
					script_file_to_run, accelerator);
		} else {
			current.menu.add(menuAction(menu_string, script_file_to_run,
					accelerator));
		}
	}

	private Action menuAction(String key, final IPath path, String accelerator) {
		final MenuRunMonkeyScript runner = new MenuRunMonkeyScript(path,
				window);
		Action action = new Action(key) {
			public void run() {
				try {
					runner.run("main", new Object[] {});
				} catch (RunMonkeyException x) {
					MessageDialog.openError(window.getShell(), x.exceptionName,
					x.errorMessage + "\n" + x.fileName + x.optionalLineNumber());
				}
			}
		};
		if (accelerator != null) {
			action.setAccelerator(getAccelerator(accelerator));
		}
		return action;
	}

	private int getAccelerator(String accelerator) {
		try {
			KeyStroke instance = KeyStroke.getInstance(accelerator);
			if (instance != null) {
				return instance.getNaturalKey() | instance.getModifierKeys();
			}
		} catch (ParseException e) {
			reportKeyStrokeInvalid(accelerator);
		} catch (IllegalArgumentException e) {
			reportKeyStrokeInvalid(accelerator);
		}
		return KeyStroke.NO_KEY;
	}

	private void reportKeyStrokeInvalid(String accelerator) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();
		MessageDialog.openError(shell, "Eclipse Monkey", "The keystroke '"
				+ accelerator + "' is not valid and so has not been assigned.");
	}

	private List createMenuFromMetadatas(Collection metaDatas) {
		List menuData = new ArrayList();
		for (Iterator iter = metaDatas.iterator(); iter.hasNext();) {
			ScriptMetadata data = (ScriptMetadata) iter.next();
			if (data.getMenuName() != null)
				menuData.add(new Association(data.getMenuName(),
						data.getPath(), data.getAccelerator()));
		}
		return menuData;
	}

	private static int id = 0;

	class Association implements Comparable {
		String accelerator;

		String key;

		IPath path;

		int uniqueId;

		Association(String k, IPath p, String accelerator) {
			this.key = k;
			this.path = p;
			this.accelerator = accelerator;
			this.uniqueId = id++;
		}

		/**
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(Object arg0) {
			Association b = (Association) arg0;
			int value = key.compareTo(b.key);
			if (value == 0) {
				if (uniqueId < b.uniqueId)
					return -1;
				else
					return 1;
			} else
				return value;
		}
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
	 */
	public void dispose() {
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

	private IWorkbenchWindow window;
}