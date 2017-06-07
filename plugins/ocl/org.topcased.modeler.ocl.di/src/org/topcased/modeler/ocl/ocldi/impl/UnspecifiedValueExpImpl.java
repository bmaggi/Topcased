/**
 * <copyright>
 * </copyright>
 *
 * $Id: UnspecifiedValueExpImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;
import org.topcased.modeler.ocl.ocldi.UnspecifiedValueExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Unspecified Value Exp</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.UnspecifiedValueExpImpl#getTypeStartPosition <em>Type Start Position
 * </em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.UnspecifiedValueExpImpl#getTypeEndPosition <em>Type End Position</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UnspecifiedValueExpImpl extends OCLExpressionImpl implements UnspecifiedValueExp
{
    /**
     * The default value of the '{@link #getTypeStartPosition() <em>Type Start Position</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTypeStartPosition()
     * @generated
     * @ordered
     */
    protected static final int TYPE_START_POSITION_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getTypeStartPosition() <em>Type Start Position</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTypeStartPosition()
     * @generated
     * @ordered
     */
    protected int typeStartPosition = TYPE_START_POSITION_EDEFAULT;

    /**
     * The default value of the '{@link #getTypeEndPosition() <em>Type End Position</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTypeEndPosition()
     * @generated
     * @ordered
     */
    protected static final int TYPE_END_POSITION_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getTypeEndPosition() <em>Type End Position</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getTypeEndPosition()
     * @generated
     * @ordered
     */
    protected int typeEndPosition = TYPE_END_POSITION_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected UnspecifiedValueExpImpl()
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
        return OcldiPackage.Literals.UNSPECIFIED_VALUE_EXP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getTypeStartPosition()
    {
        return typeStartPosition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setTypeStartPosition(int newTypeStartPosition)
    {
        int oldTypeStartPosition = typeStartPosition;
        typeStartPosition = newTypeStartPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.UNSPECIFIED_VALUE_EXP__TYPE_START_POSITION, oldTypeStartPosition, typeStartPosition));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getTypeEndPosition()
    {
        return typeEndPosition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setTypeEndPosition(int newTypeEndPosition)
    {
        int oldTypeEndPosition = typeEndPosition;
        typeEndPosition = newTypeEndPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.UNSPECIFIED_VALUE_EXP__TYPE_END_POSITION, oldTypeEndPosition, typeEndPosition));
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
            case OcldiPackage.UNSPECIFIED_VALUE_EXP__TYPE_START_POSITION:
                return new Integer(getTypeStartPosition());
            case OcldiPackage.UNSPECIFIED_VALUE_EXP__TYPE_END_POSITION:
                return new Integer(getTypeEndPosition());
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
            case OcldiPackage.UNSPECIFIED_VALUE_EXP__TYPE_START_POSITION:
                setTypeStartPosition(((Integer) newValue).intValue());
                return;
            case OcldiPackage.UNSPECIFIED_VALUE_EXP__TYPE_END_POSITION:
                setTypeEndPosition(((Integer) newValue).intValue());
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
            case OcldiPackage.UNSPECIFIED_VALUE_EXP__TYPE_START_POSITION:
                setTypeStartPosition(TYPE_START_POSITION_EDEFAULT);
                return;
            case OcldiPackage.UNSPECIFIED_VALUE_EXP__TYPE_END_POSITION:
                setTypeEndPosition(TYPE_END_POSITION_EDEFAULT);
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
            case OcldiPackage.UNSPECIFIED_VALUE_EXP__TYPE_START_POSITION:
                return typeStartPosition != TYPE_START_POSITION_EDEFAULT;
            case OcldiPackage.UNSPECIFIED_VALUE_EXP__TYPE_END_POSITION:
                return typeEndPosition != TYPE_END_POSITION_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class< ? > baseClass)
    {
        if (baseClass == TypedASTNode.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiPackage.UNSPECIFIED_VALUE_EXP__TYPE_START_POSITION:
                    return UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION;
                case OcldiPackage.UNSPECIFIED_VALUE_EXP__TYPE_END_POSITION:
                    return UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION;
                default:
                    return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.expressions.UnspecifiedValueExp.class)
        {
            switch (derivedFeatureID)
            {
                default:
                    return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class< ? > baseClass)
    {
        if (baseClass == TypedASTNode.class)
        {
            switch (baseFeatureID)
            {
                case UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION:
                    return OcldiPackage.UNSPECIFIED_VALUE_EXP__TYPE_START_POSITION;
                case UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION:
                    return OcldiPackage.UNSPECIFIED_VALUE_EXP__TYPE_END_POSITION;
                default:
                    return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.expressions.UnspecifiedValueExp.class)
        {
            switch (baseFeatureID)
            {
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (typeStartPosition: ");
        result.append(typeStartPosition);
        result.append(", typeEndPosition: ");
        result.append(typeEndPosition);
        result.append(')');
        return result.toString();
    }

} // UnspecifiedValueExpImpl
