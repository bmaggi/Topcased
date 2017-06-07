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
package org.topcased.modeler.configurator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.topcased.modeler.configurator.ConfiguratorPackage;
import org.topcased.modeler.configurator.DiagramConfiguration;
import org.topcased.modeler.configurator.DiagramReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.configurator.impl.DiagramReferenceImpl#getDiagram <em>Diagram</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.DiagramReferenceImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.topcased.modeler.configurator.impl.DiagramReferenceImpl#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramReferenceImpl extends EObjectImpl implements DiagramReference
{
    /**
     * The cached value of the '{@link #getDiagram() <em>Diagram</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDiagram()
     * @generated
     * @ordered
     */
    protected DiagramConfiguration diagram = null;

    /**
     * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLowerBound()
     * @generated
     * @ordered
     */
    protected static final int LOWER_BOUND_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLowerBound()
     * @generated
     * @ordered
     */
    protected int lowerBound = LOWER_BOUND_EDEFAULT;

    /**
     * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUpperBound()
     * @generated
     * @ordered
     */
    protected static final int UPPER_BOUND_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUpperBound()
     * @generated
     * @ordered
     */
    protected int upperBound = UPPER_BOUND_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DiagramReferenceImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass()
    {
        return ConfiguratorPackage.eINSTANCE.getDiagramReference();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DiagramConfiguration getDiagram()
    {
        if (diagram != null && diagram.eIsProxy())
        {
            DiagramConfiguration oldDiagram = diagram;
            diagram = (DiagramConfiguration)eResolveProxy((InternalEObject)diagram);
            if (diagram != oldDiagram)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfiguratorPackage.DIAGRAM_REFERENCE__DIAGRAM, oldDiagram, diagram));
            }
        }
        return diagram;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DiagramConfiguration basicGetDiagram()
    {
        return diagram;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDiagram(DiagramConfiguration newDiagram)
    {
        DiagramConfiguration oldDiagram = diagram;
        diagram = newDiagram;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.DIAGRAM_REFERENCE__DIAGRAM, oldDiagram, diagram));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getLowerBound()
    {
        return lowerBound;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLowerBound(int newLowerBound)
    {
        int oldLowerBound = lowerBound;
        lowerBound = newLowerBound;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.DIAGRAM_REFERENCE__LOWER_BOUND, oldLowerBound, lowerBound));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getUpperBound()
    {
        return upperBound;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUpperBound(int newUpperBound)
    {
        int oldUpperBound = upperBound;
        upperBound = newUpperBound;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConfiguratorPackage.DIAGRAM_REFERENCE__UPPER_BOUND, oldUpperBound, upperBound));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(EStructuralFeature eFeature, boolean resolve)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.DIAGRAM_REFERENCE__DIAGRAM:
                if (resolve) return getDiagram();
                return basicGetDiagram();
            case ConfiguratorPackage.DIAGRAM_REFERENCE__LOWER_BOUND:
                return new Integer(getLowerBound());
            case ConfiguratorPackage.DIAGRAM_REFERENCE__UPPER_BOUND:
                return new Integer(getUpperBound());
        }
        return eDynamicGet(eFeature, resolve);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eSet(EStructuralFeature eFeature, Object newValue)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.DIAGRAM_REFERENCE__DIAGRAM:
                setDiagram((DiagramConfiguration)newValue);
                return;
            case ConfiguratorPackage.DIAGRAM_REFERENCE__LOWER_BOUND:
                setLowerBound(((Integer)newValue).intValue());
                return;
            case ConfiguratorPackage.DIAGRAM_REFERENCE__UPPER_BOUND:
                setUpperBound(((Integer)newValue).intValue());
                return;
        }
        eDynamicSet(eFeature, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eUnset(EStructuralFeature eFeature)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.DIAGRAM_REFERENCE__DIAGRAM:
                setDiagram((DiagramConfiguration)null);
                return;
            case ConfiguratorPackage.DIAGRAM_REFERENCE__LOWER_BOUND:
                setLowerBound(LOWER_BOUND_EDEFAULT);
                return;
            case ConfiguratorPackage.DIAGRAM_REFERENCE__UPPER_BOUND:
                setUpperBound(UPPER_BOUND_EDEFAULT);
                return;
        }
        eDynamicUnset(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean eIsSet(EStructuralFeature eFeature)
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case ConfiguratorPackage.DIAGRAM_REFERENCE__DIAGRAM:
                return diagram != null;
            case ConfiguratorPackage.DIAGRAM_REFERENCE__LOWER_BOUND:
                return lowerBound != LOWER_BOUND_EDEFAULT;
            case ConfiguratorPackage.DIAGRAM_REFERENCE__UPPER_BOUND:
                return upperBound != UPPER_BOUND_EDEFAULT;
        }
        return eDynamicIsSet(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String toString()
    {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (lowerBound: "); //$NON-NLS-1$
        result.append(lowerBound);
        result.append(", upperBound: "); //$NON-NLS-1$
        result.append(upperBound);
        result.append(')');
        return result.toString();
    }

} //DiagramReferenceImpl
