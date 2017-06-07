/**
 * <copyright>
 * </copyright>
 *
 * $Id: TypeTypeImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.utilities.PredefinedType;
import org.topcased.modeler.di.model.Property;
import org.topcased.modeler.ocl.ocldi.BusinessType;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;
import org.topcased.modeler.ocl.ocldi.TypeType;
import org.topcased.modeler.ocl.ocldi.internal.OCLStandardLibraryImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Type Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.TypeTypeImpl#getReferredType <em>Referred Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TypeTypeImpl extends BusinessTypeImpl implements TypeType
{
    private EList<EOperation> operations;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getName()
     * @generated NOT
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getName()
     * @generated NOT
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getReferredType() <em>Referred Type</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getReferredType()
     * @generated
     * @ordered
     */
    protected BusinessType referredType;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TypeTypeImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected TypeTypeImpl(EClassifier referredType)
    {
        this();

        this.referredType = (BusinessType) referredType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass()
    {
        return OcldiPackage.Literals.TYPE_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BusinessType getReferredType()
    {
        if (referredType != null && ((EObject) referredType).eIsProxy())
        {
            InternalEObject oldReferredType = (InternalEObject) referredType;
            referredType = (BusinessType) eResolveProxy(oldReferredType);
            if (referredType != oldReferredType)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OcldiPackage.TYPE_TYPE__REFERRED_TYPE, oldReferredType, referredType));
            }
        }
        return referredType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BusinessType basicGetReferredType()
    {
        return referredType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setReferredType(BusinessType newReferredType)
    {
        BusinessType oldReferredType = referredType;
        referredType = newReferredType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.TYPE_TYPE__REFERRED_TYPE, oldReferredType, referredType));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public String getName()
    {
        if (name == null)
        {
            BusinessType ref = getReferredType();
            if (this == OCLStandardLibraryImpl.INSTANCE.getOclType())
            {
                name = SINGLETON_NAME;
            }
            else if (ref != null)
            {
                if (ref instanceof ENamedElement)
                {
                    name = ((ENamedElement) ref).getName();
                }
                else
                {
                    if (!ref.getProperty().isEmpty())
                    {
                        for (Iterator<Property> properties = ref.getProperty().iterator(); properties.hasNext();)
                        {
                            Property aProperty = (Property) properties.next();
                            if (aProperty.getKey().compareTo("name") == 0)
                            {
                                name = aProperty.getValue();
                            }
                        }
                    }

                }
            }
        }
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<EOperation> oclOperations()
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
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
            case OcldiPackage.TYPE_TYPE__REFERRED_TYPE:
                if (resolve)
                    return getReferredType();
                return basicGetReferredType();
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
            case OcldiPackage.TYPE_TYPE__REFERRED_TYPE:
                setReferredType((BusinessType) newValue);
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
            case OcldiPackage.TYPE_TYPE__REFERRED_TYPE:
                setReferredType((BusinessType) null);
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
            case OcldiPackage.TYPE_TYPE__REFERRED_TYPE:
                return referredType != null;
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
        if (baseClass == PredefinedType.class)
        {
            switch (derivedFeatureID)
            {
                default:
                    return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.types.TypeType.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiPackage.TYPE_TYPE__REFERRED_TYPE:
                    return TypesPackage.TYPE_TYPE__REFERRED_TYPE;
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
        if (baseClass == PredefinedType.class)
        {
            switch (baseFeatureID)
            {
                default:
                    return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.types.TypeType.class)
        {
            switch (baseFeatureID)
            {
                case TypesPackage.TYPE_TYPE__REFERRED_TYPE:
                    return OcldiPackage.TYPE_TYPE__REFERRED_TYPE;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @custom
     */
    public static TypeType createTypeType(EClassifier referredType)
    {
        return new TypeTypeImpl(referredType);
    }

} // TypeTypeImpl
