/*******************************************************************************
 * Copyright (c) 2007, 2008 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Lucas Bigeardel (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/

package org.topcased.modeler.l10n;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * l10n localization
 * 
 * @author <a href="mailto:lucas.bigeardel@gmail.com">lucas.bigeardel@gmail.com</a>
 * 
 */
public class Messages
{
    private static final String BUNDLE_NAME = "org.topcased.modeler.messages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private Messages()
    {
    }

    public static String getString(String key)
    {
        try
        {
            return RESOURCE_BUNDLE.getString(key);
        }
        catch (MissingResourceException e)
        {
            return '!' + key + '!';
        }
    }
}
