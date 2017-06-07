/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.export.internal.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.topcased.modeler.edit.DiagramEditPart;
import org.topcased.modeler.editor.Modeler;
import org.topcased.modeler.export.ExportException;
import org.topcased.modeler.export.ExporterDescriptor;
import org.topcased.modeler.export.ExporterManager;
import org.topcased.modeler.export.internal.Activator;

/**
 * This action displays the export dialog and save the diagram into a file. <br>
 * 
 * Creation : 17 May 2005<br>
 * Update : 19 March 2009<br>
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class Export2FileAction implements IEditorActionDelegate
{
	private static File lastDirectory;

	private static String lastExtension;

	private Modeler modeler;

	/**
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action)
	{ 
		FileOutputStream fos = null;
		try
		{
			GraphicalViewer viewer = (GraphicalViewer) modeler.getAdapter(GraphicalViewer.class);
			ISelection sel = viewer.getSelection();

			List<GraphicalEditPart> selectedEPs = new ArrayList<GraphicalEditPart>();

			if (sel instanceof StructuredSelection) {
				StructuredSelection structuredSelection = (StructuredSelection) sel;
				for (Object elem : structuredSelection.toArray()) {
					if (elem instanceof GraphicalEditPart && !(elem instanceof DiagramEditPart)) {
						selectedEPs.add((GraphicalEditPart)elem);
					}
				}
			}
			

			RootEditPart diagramEP = viewer.getRootEditPart();
			
			IPath path = getPath(modeler.getSite().getShell());
			File file = new File(path.toOSString());
			// remove selection to not have "grey labels" on elements
			for (GraphicalEditPart e : selectedEPs)
			{
				if (e != null)
				{
					e.setSelected(GraphicalEditPart.SELECTED_NONE);
				}
			}
			if (checkFile(file))
			{
				fos = new FileOutputStream(file);

				ExporterDescriptor descriptor = getExporter(file);
				if (descriptor != null)
				{
					descriptor.getExporter().export(diagramEP, selectedEPs, fos, true);

					// Remember values
					lastDirectory = file.getParentFile();
					lastExtension = descriptor.getExtension();

					Activator.displayDialog(null, "Export done for file '" + file.getName() + "'", IStatus.INFO);
				}
				else
				{
					Activator.displayDialog(null, "Unable to find exporter for file '" + file.getName() + "'", IStatus.WARNING);
				}
			}
		}
		catch (IOException ioe)
		{
			Activator.displayDialog(null, "An error occured during export. See the error log for more details.", IStatus.ERROR);
			Activator.log(ioe);
		}
		catch (ExportException ee)
		{
			Activator.displayDialog(null, "An error occured during export. See the error log for more details.", IStatus.ERROR);
			Activator.log(ee);
		}
		catch (CoreException ce)
		{
			Activator.displayDialog(null, "An error occured during export. See the error log for more details.", IStatus.ERROR);
			Activator.log(ce);
		}
		finally
		{
			try
			{
				if (fos != null)
				{
					fos.close();
				}
			}
			catch (IOException ioe)
			{
				// Ignore, Do nothing
				Activator.log(ioe);
			}
		}
	}

	private boolean checkFile(File file) throws IOException
	{
		if (file != null)
		{
			// The file already exists. Open a Dialog to confirm whether existing file should be overwritten.
			if (file.exists())
			{
				if (!MessageDialog.openQuestion(modeler.getSite().getShell(), "Overwrite", "The file already exists. Do you really want to overwrite it ?"))
				{
					return false;
				}
			}
			// There is no extension defined within the filename
			else if (new StringTokenizer(file.getName(), ".").countTokens() == 1)
			{
				Activator.displayDialog(null, "You must specify an extension within the filename.", IStatus.ERROR);
				return false;
			}
			// Try to create the new file
			else
			{
				file.createNewFile();
			}

			return true;
		}

		return false;
	}

	/**
	 * Gets the path of the 
	 * 
	 * @param shell The current shell
	 * @return The Path of the resource to create
	 */
	private IPath getPath(Shell shell)
	{
		FileDialog dialog = new FileDialog(shell, SWT.SAVE);

		dialog.setText("Enter a file to export");
		dialog.setFilterExtensions(getExtensions());
		if (lastDirectory != null)
		{
			dialog.setFilterPath(lastDirectory.getAbsolutePath());
		}

		IPath filepath = new Path(dialog.open());
		if (filepath != null && !filepath.isEmpty())
		{
			if (filepath.getFileExtension() == null)
			{
				String extension = dialog.getFilterExtensions()[dialog.getFilterIndex()];
				extension = extension.replaceFirst("\\*\\.", "");
				filepath = filepath.addFileExtension(extension);
			}

			return filepath;
		}
		return null;
	}

	/**
	 * Returns the exporter associated with the given file
	 * 
	 * @param f the file
	 * @return the exporter descriptor
	 */
	protected ExporterDescriptor getExporter(File f)
	{
		ExporterDescriptor foundExporter = null;
		ExporterDescriptor[] descriptors = ExporterManager.getInstance().getExporters();

		for (int i = 0; i < descriptors.length && foundExporter == null; i++)
		{
			if (f.getName().endsWith(descriptors[i].getExtension()))
			{
				foundExporter = descriptors[i];
			}
		}
		return foundExporter;
	}

	/**
	 * Returns the extensions handled by the registered exporters
	 * 
	 * @return the list of extensions
	 */
	protected String[] getExtensions()
	{
		ExporterDescriptor[] descriptors = ExporterManager.getInstance().getExporters();
		String[] extensions = new String[descriptors.length];

		for (int i = 0; i < descriptors.length; i++)
		{
			ExporterDescriptor descriptor = descriptors[i];

			extensions[i] = "*." + descriptor.getExtension();
		}

		// Set the last extension first
		if (lastExtension != null)
		{
			String last = "*." + lastExtension;
			boolean done = false;
			for (int j = 0; j < extensions.length && !done; j++)
			{
				if (last.equals(extensions[j]))
				{
					extensions[j] = extensions[0];
					extensions[0] = last;
					done = true;
				}
			}
		}

		return extensions;
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection)
	{
		// Do nothing
	}

	/**
	 * @see org.eclipse.ui.IEditorActionDelegate#setActiveEditor(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IEditorPart)
	 */
	public void setActiveEditor(IAction action, IEditorPart targetEditor)
	{
		if (targetEditor instanceof Modeler)
		{
			this.modeler = (Modeler) targetEditor;
			action.setEnabled(true);
		}
		else
		{
			action.setEnabled(false);
		}
	}
}
