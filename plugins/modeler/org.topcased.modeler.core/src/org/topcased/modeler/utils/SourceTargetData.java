/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies),
 *    Thomas Friol (Anyware Technologies)
 *    - initial API and implementation
 *******************************************************************************/
package org.topcased.modeler.utils;

/**
 * <br>
 * creation : 16 juin 2005 Class that store data about source and target couple
 * 
 * @author <a href="mailto:mathieu.garcia@anyware-tech.com">Mathieu Garcia</a>
 */
public class SourceTargetData
{
    /** The edge is not associated with a model object. There is no container. */
    public static final int NONE = 0;

    /** The edge container is the source object */
    public static final int SOURCE = 1;

    /** The edge container is the source container */
    public static final int SOURCE_CONTAINER = 2;

    /** The edge container is the model object represented by the current diagram */
    public static final int DIAGRAM = 3;

    /** The edge container is the target object */
    public static final int TARGET = 4;

    /** The edge container is the target container */
    public static final int TARGET_CONTAINER = 5;
    
    private boolean isReversible;
    private boolean isAutoRef;

    private int containerType;
    private String containerObject;
    private String containerRef;

    private String refEdgeToSource;
    private String refEdgeToTarget;
    private String refSourceToEdge;
    private String refSourceToTarget;
    private String refTargetToEdge;
    private String refTargetToSource;

    /**
     * The Constructor
     * 
     * @param isReversible      specify whether the connection is Reversible
     * @param isAutoRef         specify whether the connection may be autoRef
     * @param containerType     specify the type of container 
     * @param containerObject   specify the model object that is the container
     * @param containerRef      specify the eStructuralFeature that should contain the connection model object
     * @param refEdgeToSource   the eStructuralFeature of the Edge that reference the Source
     * @param refEdgeToTarget   the eStructuralFeature of the Edge that reference the Target
     * @param refSourceToEdge   the eStructuralFeature of the Source that reference the Edge
     * @param refSourceToTarget the eStructuralFeature of the Source that reference the Target
     * @param refTargetToEdge   the eStructuralFeature of the Target that reference the Edge
     * @param refTargetToSource the eStructuralFeature of the Target that reference the Source
     */
    public SourceTargetData(boolean isReversible, boolean isAutoRef, int containerType, String containerObject,
            String containerRef, String refEdgeToSource, String refEdgeToTarget, String refSourceToEdge,
            String refSourceToTarget, String refTargetToEdge, String refTargetToSource)
    {
        this.isReversible = isReversible;
        this.isAutoRef = isAutoRef;

        this.containerType = containerType;
        this.containerObject = containerObject;
        this.containerRef = containerRef;

        this.refEdgeToSource = refEdgeToSource;
        this.refEdgeToTarget = refEdgeToTarget;
        this.refSourceToEdge = refSourceToEdge;
        this.refSourceToTarget = refSourceToTarget;
        this.refTargetToEdge = refTargetToEdge;
        this.refTargetToSource = refTargetToSource;
    }

    public boolean isReversible()
    {
        return isReversible;
    }

    public boolean isAutoRef()
    {
        return isAutoRef;
    }

    public int getContainerType()
    {
        return containerType;
    }

    public String getContainerObject()
    {
        return containerObject;
    }

    public String getContainerRef()
    {
        return containerRef;
    }

    public String getRefEdgeToSource()
    {
        return refEdgeToSource;
    }

    public String getRefEdgeToTarget()
    {
        return refEdgeToTarget;
    }

    public String getRefSourceToEdge()
    {
        return refSourceToEdge;
    }

    public String getRefSourceToTarget()
    {
        return refSourceToTarget;
    }

    public String getRefTargetToEdge()
    {
        return refTargetToEdge;
    }

    public String getRefTargetToSource()
    {
        return refTargetToSource;
    }

}
