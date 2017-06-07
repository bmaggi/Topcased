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
package ca.ecliptical.emf.xpath;

import java.util.List;

import org.jaxen.JaxenException;
import org.jaxen.XPath;

/**
 * Dependency-hiding API facade for EMF XPath implementation.
 * 
 * @see org.jaxen.emf.EMFXPath
 */
public class EMFXPath {
	
	protected final XPath xpath;

	public EMFXPath(String xpath) throws IllegalArgumentException {
		try {
			this.xpath = new org.jaxen.emf.EMFXPath(xpath);
		} catch (JaxenException e) {
			throw new IllegalArgumentException(e.getLocalizedMessage());
		}
	}
	
	public Object evaluate(Object context) throws RuntimeException {
		try {
			return xpath.evaluate(context);
		} catch (JaxenException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List selectNodes(Object context) throws RuntimeException {
		try {
			return xpath.selectNodes(context);
		} catch (JaxenException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Object selectSingleNode(Object context) throws RuntimeException {
		try {
			return xpath.selectSingleNode(context);
		} catch (JaxenException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String stringValueOf(Object context) throws RuntimeException {
		try {
			return xpath.stringValueOf(context);
		} catch (JaxenException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Number numberValueOf(Object context) throws RuntimeException {
		try {
			return xpath.numberValueOf(context);
		} catch (JaxenException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean booleanValueOf(Object context) throws RuntimeException {
		try {
			return xpath.booleanValueOf(context);
		} catch (JaxenException e) {
			throw new RuntimeException(e);
		}
	}
}
