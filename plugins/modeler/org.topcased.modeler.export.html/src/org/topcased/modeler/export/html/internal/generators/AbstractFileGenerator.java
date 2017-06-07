/*******************************************************************************
 * Copyright (c) 2009 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jose Alfredo Serrano (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler.export.html.internal.generators;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowContextDefaultImpl;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.xpand2.Generator;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.diagrams.model.DiagramsPackage;
import org.topcased.modeler.export.html.internal.util.ProgressMonitorAdapter;

/**
 * Generic class to define a new file generator.
 */
public abstract class AbstractFileGenerator
{
	private final String expand;

	private final IContainer outputContainer;

	private final String variable;

	/**
	 * @param expand The statement that is to expand by the generator
	 * @param outputContainer The selected Container Resource where all files will be generated
	 * @param variable The name of the given argument
	 * 
	 */
	public AbstractFileGenerator(String expand, IContainer outputContainer, String variable)
	{
		this.expand = expand;
		this.outputContainer = outputContainer;
		this.variable = variable;
	}

	/**
	 * Run generation
	 * 
	 * @param object Input Element. Templates are build using the input element.
	 * 
	 * @param monitor
	 * 
	 * @throws CoreException Problems related to file accessing and file writing in the workspace.
	 */
	public void generate(final EObject object, IProgressMonitor monitor)
			throws CoreException
	{
		// the final location where files will be generated.
		String srcPath = outputContainer.getLocation().toString();

		Generator generator = new Generator();

		MetaModel metamodel = new EmfMetaModel(object.eClass().getEPackage());
		MetaModel metamodelDiagram = new EmfMetaModel(DiagramInterchangePackage.eINSTANCE);
		MetaModel metamodelDiagrams = new EmfMetaModel(DiagramsPackage.eINSTANCE);
		MetaModel emfMetaModel = new EmfMetaModel(EcorePackage.eINSTANCE);
		generator.addMetaModel(metamodel);
		generator.addMetaModel(metamodelDiagram);
		generator.addMetaModel(metamodelDiagrams);
		generator.addMetaModel(emfMetaModel);
		generator.setExpand(expand);

		generator.setFileEncoding("ISO-8859-1");

		Outlet outlet = new Outlet(srcPath);
		generator.addOutlet(outlet);

		// protected regions configuration
		generator.setPrSrcPaths(srcPath);
		generator.setPrDefaultExcludes(true);

		final Issues issues = new IssuesImpl();

		WorkflowContext ctx = new WorkflowContextDefaultImpl();

		ctx.set(variable, object);

		generator.invoke(ctx, new ProgressMonitorAdapter(new SubProgressMonitor(monitor, 1)),
				issues);
	}
}
