/*******************************************************************************
 * Copyright (c) 2006 Ecliptical Software Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Ecliptical Software Inc. - initial API and implementation
 *******************************************************************************/
package org.jaxen.emf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jaxen.BaseXPath;
import org.jaxen.Context;
import org.jaxen.ContextSupport;
import org.jaxen.FunctionContext;
import org.jaxen.JaxenException;
import org.jaxen.NamespaceContext;
import org.jaxen.Navigator;
import org.jaxen.SimpleNamespaceContext;
import org.jaxen.VariableContext;
import org.jaxen.XPathFunctionContext;

import ca.ecliptical.emf.jaxen.Current;
import ca.ecliptical.emf.jaxen.EMFModelNavigator;
import ca.ecliptical.emf.jaxen.ModelWrapper;

/**
 * Implements XPath for EMF models. Specifically, provides the ability
 * to use the Jaxen XPath engine with EMF-based models using the following
 * navigation model:
 * 
 * <ul>
 * <li>{@link org.eclipse.emf.ecore.resource.ResourceSet ResourceSet} is
 * the root</li>
 * <li>it may have several 
 * <code>{@link org.eclipse.emf.ecore.resource.Resource resources}</code>
 * child elements (as there may be multiple Resources in a ResourceSet)</li>
 * <li>each <code>resources</code> element has an <code>uri</code> attribute,
 * representing the Resource's
 * {@link org.eclipse.emf.ecore.resource.Resource#getURI() URI}</li>
 * <li><code>resources</code> have <code>contents</code> elements as children,
 * which represent {@link org.eclipse.emf.ecore.EObject EObjects} in their
 * {@link org.eclipse.emf.ecore.resource.Resource#getContents() contents}
 * list</li>
 * <li>each EObject in turn exposes its single-valued attribute features as 
 * its element's attributes and its reference features as its child elements</li>
 * <li>multi-valued attributes are represented as child elements</li>
 * <li>elements representing EObjects have one additional attribute, 
 * <code>e:uri</code>, which specifies the object's 
 * {@link org.eclipse.emf.ecore.util.EcoreUtil#getURI(org.eclipse.emf.ecore.EObject) URI}</li>
 * <li>non-containment references are represented by elements with no
 * further children and have only one attribute, <code>e:uri</code></li>
 * <li>namespaces are not used (and the namespaces axis is not supported),
 * except for the e:uri attribute, which is in a pre-registered internal namespace
 * (<code>http://ecliptical.ca/emf/xpath</code>)</li>
 * </ul>
 * 
 * <p>
 * For instance, using the example Library model referenced in EMF tutorials,
 * XPath expression
 * <code>/resource[@uri='my.library']/contents/books</code> would
 * designate all books in the first library in the given resource. Expression
 * <code>books[author/@e:refid=current()/writers[@name='John Grisham']/@e:id]</code>
 * designates books whose author's name is John Grisham.
 * </p>
 * 
 * <p>
 * Note that this "document mapping" does not have any direct correlation with
 * EMF's XML persistence mechanism. In fact, the models need not be persisted
 * in XML at all in order to be used with this class.
 * </p>
 * 
 * @see org.jaxen.XPath
 * @see org.eclipse.emf.ecore.EObject
 * @see org.eclipse.emf.ecore.resource.Resource
 */
public class EMFXPath extends BaseXPath {

	private static final long serialVersionUID = 2260234323904801523L;
	
	public static final String EMF_XPATH_NAMESPACE_URI = "http://ecliptical.ca/emf/xpath";
	
	public static final String EMF_XPATH_NAMESPACE_PREFIX = "e";
	
	public static final String RESOURCES_ELEMENT_NAME = "resources";
	
	public static final String RESOURCE_URI_ATTR_NAME = "uri";
	
	public static final String RESOURCE_CONTENTS_ELEMENT_NAME = "contents";
	
	public static final String EOBJECT_URI_ATTR_NAME = "uri";
	
	public static final String FEATURE_MAP_ENTRY_FEATURE_ATTR_NAME = "feature";
	
	private ContextSupport support;
	
	private Context rootContext;

	/**
	 * Creates an instance with XPath expression string to compile.
	 * 
	 * @param xpathExpr XPath expression string to compile
	 * @throws JaxenException if the expression cannot be compiled
	 */
	public EMFXPath(String xpathExpr) throws JaxenException {
		super(xpathExpr, new EMFModelNavigator());
	}
	
    protected Context getContext(Object node) {
		return rootContext = super.getContext(node);
	}

	public List selectNodes(Object node) throws JaxenException {
		List result = super.selectNodes(node);
		List newList = new ArrayList();

		for (Iterator i = ((Collection) result).iterator(); i.hasNext();) {
			Object member = i.next();
			newList.add(unwrap(member));
		}

		return newList;
	}
	
	protected Object unwrap(Object object) { 
		if (object instanceof ModelWrapper)
			return ((ModelWrapper) object).getWrappedObject();
		
		return object;
	}
	
	protected ContextSupport getContextSupport() {
        if (support == null) {
			support = new RootContextSupport(createNamespaceContext(),
					createFunctionContext(), createVariableContext(),
					getNavigator());
		}

		return support;
	}
	
	protected FunctionContext createFunctionContext() {
		XPathFunctionContext functionContext = new XPathFunctionContext(true);
		functionContext.registerFunction(null, "current", new Current());
		return functionContext;
	}
	
	protected NamespaceContext createNamespaceContext() {
		SimpleNamespaceContext namespaceContext = new SimpleNamespaceContext();
		namespaceContext.addNamespace(EMF_XPATH_NAMESPACE_PREFIX, EMF_XPATH_NAMESPACE_URI);
		return namespaceContext;
	}
	
	public class RootContextSupport extends ContextSupport {

		private static final long serialVersionUID = 1844204807495484444L;

	    public RootContextSupport(NamespaceContext namespaceContext,
				FunctionContext functionContext,
				VariableContext variableContext, Navigator navigator) {
			super(namespaceContext, functionContext, variableContext, navigator);
		}
	    
	    public Context getRootContext() {
	    	return rootContext;
	    }
	}
}
