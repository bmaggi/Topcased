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
package org.topcased.iterators.configurations.listeners;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.polarsys.reqcycle.utils.iterators.pickers.IPicker;
import org.topcased.iterators.configurations.Activator;
import org.topcased.iterators.configurations.ConfigurationManager;
import org.topcased.iterators.configurations.exceptions.IteratorNotFoundException;
import org.topcased.iterators.configurations.exceptions.NoSuchJavaQueryException;
import org.topcased.iterators.configurations.exceptions.OperationSetNotFoundException;
import org.topcased.iterators.configurations.exceptions.PickerNotFoundException;
import org.topcased.iterators.configurations.exceptions.SameNameException;
import org.topcased.iterators.configurations.exceptions.UnnamedPickerException;
import org.topcased.iterators.configurations.factories.internal.PickerFactory;
import org.topcased.iterators.configurations.iterator.ConfigurationModel;
import org.topcased.iterators.configurations.iterator.EPicker;
import org.topcased.iterators.configurations.iterator.EPickerSet;
import org.topcased.iterators.configurations.iterator.Iterator;
import org.topcased.iterators.configurations.iterator.OperationSet;
import org.topcased.iterators.configurations.pickers.PickerWithDescription;
import org.topcased.iterators.configurations.utils.ListenableConfigurationRegistry;

public class IteratorConfigurationRegistry extends ListenableConfigurationRegistry {

	enum kind {
		ADD, MODIFY, DELETE
	}

	private Map<String, Iterator> iteratorRegistry = new HashMap<String, Iterator>();

	private Map<String, OperationSet> operationSetRegistry = new HashMap<String, OperationSet>();

	private Map<String, EPicker> pickerRegistry = new HashMap<String, EPicker>();

	private ResourceSet resourceSet = new ResourceSetImpl();

	public IteratorConfigurationRegistry() {
		try {
			Set<URI> filesFromExtensions = ConfigurationManager.getConfigurationFilesFromExtensions();
			for(URI uri : filesFromExtensions) {
				fileAdded(uri);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method from IResourceDeltaVisitor, that allows a reaction over file
	 * additions/deletions.
	 */
	public boolean visit(IResourceDelta delta) throws CoreException {
		if(delta.getResource() != null) {
			switch(delta.getKind()) {
			case IResourceDelta.ADDED:
				visit(delta.getResource());
				break;
			case IResourceDelta.REMOVED:
				visit(delta.getResource(), kind.DELETE);
				break;
			case IResourceDelta.CHANGED:
				visit(delta.getResource(), kind.MODIFY);
				break;
			}
		}
		return true;
	}

	/**
	 * Method from IResourceDeltaVisitor, to iterate over the configurations
	 * files.
	 */
	public boolean visit(IResource resource) throws CoreException {
		if(resource.isAccessible()) {
			visit(resource, kind.ADD);
			return true;
		}
		return !(resource instanceof IProject);
	}

	/**
	 * Submethod processing the visit depending on the kind of change.
	 * 
	 * @param resource
	 * @param type
	 *        the kind of resource change.
	 * @throws CoreException
	 */
	private void visit(IResource resource, kind type) throws CoreException {
		if(resource instanceof IFile) {
			IFile file = (IFile)resource;
			String fileExtension = file.getFileExtension();
			if(fileExtension != null && fileExtension.equals("iterator")) {
				switch(type) {
				case ADD:
					this.fileAdded(file);
					break;
				case DELETE:
					this.fileDeleted(file);
					break;
				case MODIFY:
					this.fileModified(file);
					break;
				default:
					break;
				}
				//Notifying the listeners that the resources have changed
				notifyListeners();
			}
		}
	}

	/**
	 * Unregister all iterators that were configured in the configuration file.
	 */
	private void fileDeleted(IFile file) {
		IPath location = file.getLocation();
		String pathname = location.toOSString();
		URI uri = URI.createFileURI(pathname);
		Resource resource = resourceSet.getResource(uri, true);
		for(EObject eObject : resource.getContents()) {
			// Iterating on the iterators of the model.
			if(eObject instanceof ConfigurationModel) {
				for(Iterator iterator : ((ConfigurationModel)eObject).getIterators()) {
					String iteratorName = iterator.getName();
					if(iteratorName != null && !iteratorName.isEmpty()) {
						iteratorRegistry.remove(iteratorName);
					}
				}
				for(OperationSet operationSet : ((ConfigurationModel)eObject).getOperationSets()) {
					String operationSetName = operationSet.getName();
					if(operationSet != null && !operationSetName.isEmpty()) {
						operationSetRegistry.remove(operationSetName);
					}
				}
				for(EPickerSet ePickerSet : ((ConfigurationModel)eObject).getPickerSets()) {
					for(EPicker ePicker : ePickerSet.getPickers()) {
						String pickerName = ePicker.getName();
						if(ePicker != null && !pickerName.isEmpty()) {
							pickerRegistry.remove(pickerName);
						}
					}
				}
			}
		}
		// Unloading the resource.
		resource.unload();
	}

	/**
	 * Register all iterators that were configured in the configuration file.
	 * 
	 * @throws CoreException
	 */
	private void fileAdded(IFile file) throws CoreException {
		IPath location = file.getLocation();
		String pathname = location.toOSString();
		URI uri = URI.createFileURI(pathname);
		try {
			fileAdded(uri);
		} catch (UnnamedPickerException e) {
			Activator.logError(e);
		}
	}

	/**
	 * Register all iterators from configuration files provided by extensions
	 * 
	 * @throws CoreException
	 * @throws UnnamedPickerException
	 */
	private void fileAdded(URI uri) throws CoreException, UnnamedPickerException {
		Resource resource = resourceSet.getResource(uri, true);
		for(EObject eObject : resource.getContents()) {
			if(eObject instanceof ConfigurationModel) {
				// Iterating on the iterators of the model.
				for(Iterator iterator : ((ConfigurationModel)eObject).getIterators()) {
					String iteratorName = iterator.getName();
					if(iteratorName != null && !iteratorName.isEmpty()) {
						// Adding the new iterator to the registry.
						if(iteratorRegistry.get(iteratorName) != null) {
							iteratorRegistry.remove(iteratorName);
							throw new SameNameException("Several iterators with the name \"" + iteratorName + "\" were found");
						}
						iteratorRegistry.put(iteratorName, iterator);
					}
				}
				// Iterating on the operation sets of the model;
				for(OperationSet operationSet : ((ConfigurationModel)eObject).getOperationSets()) {
					String operationSetName = operationSet.getName();
					// Adding the new iterator to the registry.
					if(operationSetRegistry.get(operationSetName) != null) {
						operationSetRegistry.remove(operationSetName);
						throw new SameNameException("Several operation sets with the name \"" + operationSetName + "\" were found");
					}
					operationSetRegistry.put(operationSetName, operationSet);
				}
				// Iterating over the picker sets of the model
				for(EPickerSet ePickerSet : ((ConfigurationModel)eObject).getPickerSets()) {
					for(EPicker ePicker : ePickerSet.getPickers()) {
						String pickerName = ePicker.getName();
						if(pickerName != null) {
							// Adding the new picker to the registry
							if(pickerRegistry.get(pickerName) != null) {
								pickerRegistry.remove(pickerName);
								throw new SameNameException("Several pickers with the name \"" + pickerName + "\" were found");
							}
							pickerRegistry.put(pickerName, ePicker);
						} else {
							throw new UnnamedPickerException("Cannot register a picker with no name.");
						}
					}
				}
			}
		}
	}

	/**
	 * Unregister the removed iterators, and register the new ones.
	 * 
	 * @throws CoreException
	 */
	private void fileModified(IFile file) throws CoreException {
		// Simply process as if the file had been deleted and re-added.
		fileDeleted(file);
		fileAdded(file);
	}

	/**
	 * Retrieves an iterator from the registry.
	 * 
	 * @param name
	 *        the name of the iterator
	 */
	public Iterator lookupIterator(String name) throws IteratorNotFoundException {
		Iterator iterator = iteratorRegistry.get(name);
		if(iterator == null) {
			throw new IteratorNotFoundException("The iterator \"" + name + "\" was not found in the registry : it might have not been loaded correctly");
		}
		return iterator;
	}

	/**
	 * Retrieves an operationSet from the registry.
	 * 
	 * @param name
	 *        the name of the operationSet
	 */
	public OperationSet lookupOperationSet(String name) throws OperationSetNotFoundException {
		OperationSet operationSet = operationSetRegistry.get(name);
		if(operationSet == null) {
			throw new OperationSetNotFoundException("The operation set \"" + name + "\" was not found in the registry : it might have not been loaded correctly");
		}
		return operationSet;
	}

	/**
	 * Retrieves a picker from the registry.
	 * 
	 * @param name
	 *        the name of the picker
	 */
	public EPicker lookupPicker(String name) throws PickerNotFoundException {
		EPicker ePicker = pickerRegistry.get(name);
		if(ePicker == null) {
			throw new PickerNotFoundException("The picker \"" + name + "\" was not found in the registry : it might have not been loaded correctly");
		}
		return ePicker;
	}

	/**
	 * Retrieves all the pickers from the registry.
	 * 
	 * @return the pickers stored in the registry
	 */
	public Map<String, IPicker> getPickers() {
		Set<String> keys = pickerRegistry.keySet();
		Map<String, IPicker> iPickers = new HashMap<String, IPicker>();
		PickerFactory factory = new PickerFactory();
		for(final String pickerName : keys) {
			try {
				EPicker ePicker = pickerRegistry.get(pickerName);
				IPicker corePicker = factory.createPicker(ePicker);
				// wrapping a picker
				PickerWithDescription wrappedPicker = new PickerWithDescription(corePicker);
				wrappedPicker.setName(ePicker.getName());
				wrappedPicker.setDescription(ePicker.getDescription());
				iPickers.put(pickerName, wrappedPicker);
			} catch (NoSuchJavaQueryException e) {
				Activator.logError(e);
			}
		}
		return iPickers;
	}

}
