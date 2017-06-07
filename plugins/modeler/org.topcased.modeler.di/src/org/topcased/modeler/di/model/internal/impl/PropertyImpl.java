/**
 * <copyright>
 * </copyright>
 *
 * $Id: PropertyImpl.java,v 1.6 2009/05/19 09:19:07 sgabel Exp $
 */
package org.topcased.modeler.di.model.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.topcased.modeler.di.model.DiagramInterchangePackage;
import org.topcased.modeler.di.model.Property;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Property</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.PropertyImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.topcased.modeler.di.model.internal.impl.PropertyImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyImpl extends EModelElementImpl implements Property
{
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Topcased.org"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #getKey() <em>Key</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getKey()
     * @generated
     * @ordered
     */
    protected static final String KEY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getKey() <em>Key</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getKey()
     * @generated
     * @ordered
     */
    protected String key = KEY_EDEFAULT;

    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected String value = VALUE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected PropertyImpl()
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
        return DiagramInterchangePackage.Literals.PROPERTY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getKey()
    {
        return key;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setKey(String newKey)
    {
        String oldKey = key;
        key = newKey;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.PROPERTY__KEY, oldKey, key));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getValue()
    {
        return value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setValue(String newValue)
    {
        String oldValue = value;
        value = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.PROPERTY__VALUE, oldValue, value));
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
            case DiagramInterchangePackage.PROPERTY__KEY:
                return getKey();
            case DiagramInterchangePackage.PROPERTY__VALUE:
                return getValue();
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
            case DiagramInterchangePackage.PROPERTY__KEY:
                setKey((String) newValue);
                return;
            case DiagramInterchangePackage.PROPERTY__VALUE:
                setValue((String) newValue);
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
            case DiagramInterchangePackage.PROPERTY__KEY:
                setKey(KEY_EDEFAULT);
                return;
            case DiagramInterchangePackage.PROPERTY__VALUE:
                setValue(VALUE_EDEFAULT);
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
            case DiagramInterchangePackage.PROPERTY__KEY:
                return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
            case DiagramInterchangePackage.PROPERTY__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
        result.append(" (key: "); //$NON-NLS-1$
        result.append(key);
        result.append(", value: "); //$NON-NLS-1$
        result.append(value);
        result.append(')');
        return result.toString();
    }

} // PropertyImpl
