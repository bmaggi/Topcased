/*******************************************************************************
 * Copyright (c) 2011 Atos. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Tristan FAURE (Atos) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.ui.navigator;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.topcased.modeler.editor.Modeler;

/**
 * A property tester allowing developers to be sure a di file is a di it is now useless to check "if (endsWith("di"))"
 * 
 * @author tfaure
 * 
 */
public class TopcasedFilePropertyTester extends PropertyTester
{

    public static Set<String> records = getRecords();

    private static final String EXTENSION_POINT_EDITORS_ID = "org.eclipse.ui.editors";

    private static final String EXTENSION_POINT_DIAGRAMS = "org.topcased.modeler.diagrams";

    public boolean test(Object receiver, String property, Object[] args, Object expectedValue)
    {
        if ("isTopcasedFile".equals(property))
        {
            if (receiver instanceof IFile)
            {
                return isTopcasedFile((IFile) receiver);
            }
        }
        if ("isTopcasedDiFile".equals(property))
        {
            if (receiver instanceof IFile)
            {
                return isDi((IFile) receiver);
            }
        }
        return false;
    }

    /**
     * Check if the file is a TOPCASED File
     * 
     * @param file to check
     * @return true if the file is managed by TOPCASED
     */
    public static boolean isTopcasedFile(IFile file)
    {
        return file != null && records.contains(file.getFileExtension()) && (file.getFileExtension().endsWith("di") || diExist(file));
    }

    public static boolean diExist(IFile file)
    {
        if (file != null && file.getParent() != null)
        {
            IResource findMember = file.getParent().findMember(file.getName() + "di");
            return findMember != null && findMember.exists();
        }
        return false;
    }

    /**
     * Check if the file is a TOPCASED File
     * 
     * @param file to check
     * @return true if the file is managed by TOPCASED
     */
    public static boolean isDi(IFile file)
    {
        return file != null && file.getFileExtension() != null && file.getFileExtension().endsWith("di") && isTopcasedFile(file);
    }

    private static Set<String> getRecords()
    {
        Set<String> allEditors = new HashSet<String>();
        IConfigurationElement[] diagrams = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_DIAGRAMS);
        for (IConfigurationElement e : diagrams)
        {
            String editorID = e.getAttribute("editorID");
            if (editorID != null)
            {
                allEditors.add(editorID);
            }
        }
        Set<String> rec = new HashSet<String>();
        IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_EDITORS_ID);
        for (IConfigurationElement e : elements)
        {
            if (allEditors.contains(e.getAttribute("id")))
            {
                String className = e.getAttribute("class");
                try
                {
                    if (className != null && e.getContributor().getName() != null)
                    {
                        Class< ? > c = Platform.getBundle(e.getContributor().getName()).loadClass(className);
                        if (c != null && Modeler.class.isAssignableFrom(c))
                        {
                            String extensions = e.getAttribute("extensions");
                            StringTokenizer tokenizer = new StringTokenizer(extensions, ",");
                            while (tokenizer.hasMoreTokens())
                            {
                                rec.add(tokenizer.nextToken());
                            }
                        }
                    }
                }
                catch (InvalidRegistryObjectException e1)
                {
                }
                catch (ClassNotFoundException e1)
                {
                }
            }
        }
        return rec;
    }

}
