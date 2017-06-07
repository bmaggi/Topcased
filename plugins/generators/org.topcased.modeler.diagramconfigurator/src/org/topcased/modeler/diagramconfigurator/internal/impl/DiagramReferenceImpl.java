/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramReferenceImpl.java,v 1.4 2007/04/18 12:21:05 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.topcased.modeler.diagramconfigurator.DiagramConfiguration;
import org.topcased.modeler.diagramconfigurator.DiagramReference;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Diagram Reference</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramReferenceImpl#getDiagram <em>Diagram</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramReferenceImpl#getLowerBound <em>Lower Bound</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.DiagramReferenceImpl#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DiagramReferenceImpl extends EObjectImpl implements DiagramReference
{
    /**
     * The cached value of the '{@link #getDiagram() <em>Diagram</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDiagram()
     * @generated
     * @ordered
     */
    protected DiagramConfiguration diagram;

    /**
     * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getLowerBound()
     * @generated
     * @ordered
     */
    protected static final int LOWER_BOUND_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLowerBound()
     * @generated
     * @ordered
     */
    protected int lowerBound = LOWER_BOUND_EDEFAULT;

    /**
     * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getUpperBound()
     * @generated
     * @ordered
     */
    protected static final int UPPER_BOUND_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getUpperBound()
     * @generated
     * @ordered
     */
    protected int upperBound = UPPER_BOUND_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DiagramReferenceImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass()
    {
        return DiagramconfiguratorPackage.Literals.DIAGRAM_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DiagramConfiguration getDiagram()
    {
        if (diagram != null && diagram.eIsProxy())
        {
            InternalEObject oldDiagram = (InternalEObject) diagram;
            diagram = (DiagramConfiguration) eResolveProxy(oldDiagram);
            if (diagram != oldDiagram)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramconfiguratorPackage.DIAGRAM_REFERENCE__DIAGRAM, oldDiagram, diagram));
            }
        }
        return diagram;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DiagramConfiguration basicGetDiagram()
    {
        return diagram;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDiagram(DiagramConfiguration newDiagram)
    {
        DiagramConfiguration oldDiagram = diagram;
        diagram = newDiagram;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_REFERENCE__DIAGRAM, oldDiagram, diagram));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getLowerBound()
    {
        return lowerBound;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLowerBound(int newLowerBound)
    {
        int oldLowerBound = lowerBound;
        lowerBound = newLowerBound;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_REFERENCE__LOWER_BOUND, oldLowerBound, lowerBound));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getUpperBound()
    {
        return upperBound;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setUpperBound(int newUpperBound)
    {
        int oldUpperBound = upperBound;
        upperBound = newUpperBound;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.DIAGRAM_REFERENCE__UPPER_BOUND, oldUpperBound, upperBound));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE__DIAGRAM:
                if (resolve)
                    return getDiagram();
                return basicGetDiagram();
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE__LOWER_BOUND:
                return new Integer(getLowerBound());
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE__UPPER_BOUND:
                return new Integer(getUpperBound());
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE__DIAGRAM:
                setDiagram((DiagramConfiguration) newValue);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE__LOWER_BOUND:
                setLowerBound(((Integer) newValue).intValue());
                return;
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE__UPPER_BOUND:
                setUpperBound(((Integer) newValue).intValue());
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE__DIAGRAM:
                setDiagram((DiagramConfiguration) null);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE__LOWER_BOUND:
                setLowerBound(LOWER_BOUND_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE__UPPER_BOUND:
                setUpperBound(UPPER_BOUND_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE__DIAGRAM:
                return diagram != null;
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE__LOWER_BOUND:
                return lowerBound != LOWER_BOUND_EDEFAULT;
            case DiagramconfiguratorPackage.DIAGRAM_REFERENCE__UPPER_BOUND:
                return upperBound != UPPER_BOUND_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString()
    {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (lowerBound: ");
        result.append(lowerBound);
        result.append(", upperBound: ");
        result.append(upperBound);
        result.append(')');
        return result.toString();
    }

} // DiagramReferenceImpl
