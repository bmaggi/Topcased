/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.generator.internal.generators.doc;

import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.Driver;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EPackage;
import org.topcased.modeler.generator.internal.GeneratorPlugin;

/**
 * A Generator used to get a PDF file
 */
public class PDFDocGenerator extends DocGenerator
{

    private IFile targetFile;

    /**
     * Constructor
     * 
     * @param epackage
     * @param target
     */
    public PDFDocGenerator(EPackage epackage, IFile target)
    {
        super(epackage);
        targetFile = target;
    }

    /**
     * @see org.topcased.modeler.generator.internal.generators.doc.DocGenerator#serialize(org.eclipse.core.runtime.IProgressMonitor)
     */
    protected void serialize(IProgressMonitor monitor) throws CoreException
    {
        try
        {
            Driver driver = new Driver();
            FileOutputStream output = new FileOutputStream(targetFile.getLocation().toFile());
            driver.setRenderer(Driver.RENDER_PDF);
            driver.setOutputStream(output);
            InputStream xslInputStream = FileLocator.openStream(GeneratorPlugin.getDefault().getBundle(), new Path("resources/pdf-doc.xsl"), false);
            Transformer xformer = TransformerFactory.newInstance().newTransformer(new StreamSource(xslInputStream));
            DOMSource source = new DOMSource(getDocument());
            SAXResult result = new SAXResult(driver.getContentHandler());
            xformer.transform(source, result);
            output.close();
        }
        catch (Exception e)
        {
            GeneratorPlugin.log(e);
            GeneratorPlugin.log("Unable to serialize generated XML document into target : " + targetFile.getFullPath(), IStatus.ERROR);
        }
        targetFile.getParent().refreshLocal(1, monitor);
    }

}
