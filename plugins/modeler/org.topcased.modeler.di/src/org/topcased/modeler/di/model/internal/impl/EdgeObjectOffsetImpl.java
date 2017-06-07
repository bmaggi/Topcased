/**
 * <copyright>
 * </copyright>
 *
 * $Id: EdgeObjectOffsetImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.modeler.di.model.DiagramInterchangeFactory;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.EdgeObjectOffset;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Edge Object Offset</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.EdgeObjectOffsetImpl#getOffset <em>Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeObjectOffsetImpl extends EdgeObjectImpl implements EdgeObjectOffset
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getOffset()
     * @generated
     * @ordered
     */
    protected static final Dimension OFFSET_EDEFAULT = (Dimension) DiagramInterchangeFactory.eINSTANCE.createFromString(DiagramInterchangePackage.eINSTANCE.getDimension(), ""); //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getOffset()
     * @generated
     * @ordered
     */
    protected Dimension offset = OFFSET_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected EdgeObjectOffsetImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass()
    {
        return DiagramInterchangePackage.Literals.EDGE_OBJECT_OFFSET;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Dimension getOffset()
    {
        return offset;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setOffset(Dimension newOffset)
    {
        Dimension oldOffset = offset;
        offset = newOffset;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.EDGE_OBJECT_OFFSET__OFFSET, oldOffset, offset));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case DiagramInterchangePackage.EDGE_OBJECT_OFFSET__OFFSET:
                return getOffset();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case DiagramInterchangePackage.EDGE_OBJECT_OFFSET__OFFSET:
                setOffset((Dimension) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case DiagramInterchangePackage.EDGE_OBJECT_OFFSET__OFFSET:
                setOffset(OFFSET_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case DiagramInterchangePackage.EDGE_OBJECT_OFFSET__OFFSET:
                return OFFSET_EDEFAULT == null ? offset != null : !OFFSET_EDEFAULT.equals(offset);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString()
    {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (offset: "); //$NON-NLS-1$
        result.append(offset);
        result.append(')');
        return result.toString();
    }

} // EdgeObjectOffsetImpl
