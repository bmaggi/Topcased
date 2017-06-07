/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware
 * Technologies), Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.topcased.modeler;

/**
 * Common Topcased EAnnotation Constants<br>
 * <br>
 * creation : 16 juin 2005
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public interface IAnnotationConstants
{
    /**
     * The source of the EAnnotation that will contains the uuid
     */
    String UUID_SOURCE = "http://www.topcased.org/uuid";

    /**
     * The name of the details entry that will contain the uuid attribute
     */
    String UUID_KEY = "uuid";

    /**
     * The source of the EAnnotation that will contains the documentation
     */
    String DOCUMENTATION_SOURCE = "http://www.topcased.org/documentation";

    /**
     * The source of the EAnnotation that will contains the author
     */
    String AUTHOR_SOURCE = "http://www.topcased.org/author";

    /**
     * The source of the EAnnotation that will contains the extensionAuthor
     */
    String EXTENSION_AUTHOR_SOURCE = "http://www.topcased.org/extensionAuthor";

    /**
     * The source of the EAnnotation that will contains the resources
     */
    String RESOURCES_SOURCE = "http://www.topcased.org/resources";

    /**
     * The name of the details entry that will contain the documentation attribute
     */
    String DOCUMENTATION_KEY = "documentation";

    /**
     * The name of the details entry that will contain the author attribute
     */
    String AUTHOR_KEY = "author";

    /**
     * The name of the details entry that will contain the extensionAuthor attribute
     */
    String EXTENSION_AUTHOR_KEY = "extensionAuthor";
}
