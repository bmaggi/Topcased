/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimpleSemanticModelElementImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.SimpleSemanticModelElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Simple Semantic Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.SimpleSemanticModelElementImpl#getTypeInfo <em>Type Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleSemanticModelElementImpl extends SemanticModelBridgeImpl implements SimpleSemanticModelElement
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #getTypeInfo() <em>Type Info</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getTypeInfo()
     * @generated
     * @ordered
     */
    protected static final String TYPE_INFO_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTypeInfo() <em>Type Info</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getTypeInfo()
     * @generated
     * @ordered
     */
    protected String typeInfo = TYPE_INFO_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected SimpleSemanticModelElementImpl()
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
        return DiagramInterchangePackage.Literals.SIMPLE_SEMANTIC_MODEL_ELEMENT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getTypeInfo()
    {
        return typeInfo;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setTypeInfo(String newTypeInfo)
    {
        String oldTypeInfo = typeInfo;
        typeInfo = newTypeInfo;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPE_INFO, oldTypeInfo, typeInfo));
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
            case DiagramInterchangePackage.SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPE_INFO:
                return getTypeInfo();
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
            case DiagramInterchangePackage.SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPE_INFO:
                setTypeInfo((String) newValue);
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
            case DiagramInterchangePackage.SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPE_INFO:
                setTypeInfo(TYPE_INFO_EDEFAULT);
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
            case DiagramInterchangePackage.SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPE_INFO:
                return TYPE_INFO_EDEFAULT == null ? typeInfo != null : !TYPE_INFO_EDEFAULT.equals(typeInfo);
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
        result.append(" (typeInfo: "); //$NON-NLS-1$
        result.append(typeInfo);
        result.append(')');
        return result.toString();
    }

} // SimpleSemanticModelElementImpl
