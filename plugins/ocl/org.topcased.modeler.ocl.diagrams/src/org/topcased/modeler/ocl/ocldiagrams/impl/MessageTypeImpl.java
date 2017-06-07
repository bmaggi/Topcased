/**
 * <copyright>
 * </copyright>
 *
 * $Id: MessageTypeImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DelegatingEList;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.types.operations.MessageTypeOperations;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.UMLReflection;
import org.topcased.modeler.ocl.ocldiagrams.BusinessType;
import org.topcased.modeler.ocl.ocldiagrams.MessageType;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;
import org.topcased.modeler.ocl.ocldiagrams.internal.OCLStandardLibraryImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Message Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.MessageTypeImpl#getReferredOperation <em>Referred Operation
 * </em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.MessageTypeImpl#getReferredSignal <em>Referred Signal</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MessageTypeImpl extends EClassImpl implements MessageType
{
    /**
     * The cached value of the '{@link #getReferredOperation() <em>Referred Operation</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getReferredOperation()
     * @generated
     * @ordered
     */
    protected EOperation referredOperation;

    private EList<EOperation> operations;

    private EList<EStructuralFeature> properties;

    /**
     * The cached value of the '{@link #getReferredSignal() <em>Referred Signal</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getReferredSignal()
     * @generated
     * @ordered
     */
    protected BusinessType referredSignal;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MessageTypeImpl()
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
        return OcldiagramsPackage.Literals.MESSAGE_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EOperation getReferredOperation()
    {
        if (referredOperation != null && ((EObject) referredOperation).eIsProxy())
        {
            InternalEObject oldReferredOperation = (InternalEObject) referredOperation;
            referredOperation = (EOperation) eResolveProxy(oldReferredOperation);
            if (referredOperation != oldReferredOperation)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OcldiagramsPackage.MESSAGE_TYPE__REFERRED_OPERATION, oldReferredOperation, referredOperation));
            }
        }
        return referredOperation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EOperation basicGetReferredOperation()
    {
        return referredOperation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setReferredOperation(EOperation newReferredOperation)
    {
        EOperation oldReferredOperation = referredOperation;
        referredOperation = newReferredOperation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.MESSAGE_TYPE__REFERRED_OPERATION, oldReferredOperation, referredOperation));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BusinessType getReferredSignal()
    {
        if (referredSignal != null && ((EObject) referredSignal).eIsProxy())
        {
            InternalEObject oldReferredSignal = (InternalEObject) referredSignal;
            referredSignal = (BusinessType) eResolveProxy(oldReferredSignal);
            if (referredSignal != oldReferredSignal)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OcldiagramsPackage.MESSAGE_TYPE__REFERRED_SIGNAL, oldReferredSignal, referredSignal));
            }
        }
        return referredSignal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BusinessType basicGetReferredSignal()
    {
        return referredSignal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setReferredSignal(BusinessType newReferredSignal)
    {
        BusinessType oldReferredSignal = referredSignal;
        referredSignal = newReferredSignal;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.MESSAGE_TYPE__REFERRED_SIGNAL, oldReferredSignal, referredSignal));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkExclusiveSignature(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return MessageTypeOperations.checkExclusiveSignature(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkOperationParameters(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return MessageTypeOperations.checkOperationParameters(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkSignalAttributes(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return MessageTypeOperations.checkSignalAttributes(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<EOperation> oclOperations()
    {
        if (operations == null)
        {
            MessageType prototype = (MessageType) OCLStandardLibraryImpl.INSTANCE.getOclMessage();

            if (prototype == this)
            {
                // I *am* the standard library type!
                operations = OCLStandardLibraryImpl.getExistingOperations(this);
            }
            else
            {
                // the prototype defines my operations for me
                operations = prototype.oclOperations();
            }
        }

        return operations;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public EList<EStructuralFeature> oclProperties()
    {
        if (properties == null)
        {
            properties = new DelegatingEList<EStructuralFeature>()
            {
                private static final long serialVersionUID = 1304482875445208763L;

                @Override
                protected List<EStructuralFeature> delegateList()
                {
                    return getEStructuralFeatures();
                }
            };

            EList<EStructuralFeature> features = getEStructuralFeatures();

            if (features.isEmpty())
            {
                // don't do this computation if we already have structural
                // features, which would be the case if we were deserialized
                // from some resource
                Environment< ? , EClassifier, EOperation, EStructuralFeature, ? , ? , ? , ? , ? , ? , ? , ? > env = Environment.Registry.INSTANCE.getEnvironmentFor(this);
                UMLReflection< ? , EClassifier, EOperation, EStructuralFeature, ? , ? , ? , ? , ? , ? > uml = env.getUMLReflection();

                EList< ? extends ETypedElement> typedElements;
                if (getReferredOperation() != null)
                {
                    typedElements = getReferredOperation().getEParameters();
                }
                else if (getReferredSignal() != null)
                {
                    typedElements = ((EClass) getReferredSignal()).getEAllStructuralFeatures();
                }
                else
                {
                    typedElements = ECollections.emptyEList();
                }

                for (ETypedElement next : typedElements)
                {
                    features.add(uml.createProperty(next.getName(), TypeUtil.resolveType(env, uml.getOCLType(next))));
                }
            }
        }

        return properties;
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
            case OcldiagramsPackage.MESSAGE_TYPE__REFERRED_OPERATION:
                if (resolve)
                    return getReferredOperation();
                return basicGetReferredOperation();
            case OcldiagramsPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
                if (resolve)
                    return getReferredSignal();
                return basicGetReferredSignal();
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
            case OcldiagramsPackage.MESSAGE_TYPE__REFERRED_OPERATION:
                setReferredOperation((EOperation) newValue);
                return;
            case OcldiagramsPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
                setReferredSignal((BusinessType) newValue);
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
            case OcldiagramsPackage.MESSAGE_TYPE__REFERRED_OPERATION:
                setReferredOperation((EOperation) null);
                return;
            case OcldiagramsPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
                setReferredSignal((BusinessType) null);
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
            case OcldiagramsPackage.MESSAGE_TYPE__REFERRED_OPERATION:
                return referredOperation != null;
            case OcldiagramsPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
                return referredSignal != null;
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
        if (baseClass == org.eclipse.ocl.types.MessageType.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiagramsPackage.MESSAGE_TYPE__REFERRED_OPERATION:
                    return TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION;
                case OcldiagramsPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
                    return TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL;
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
        if (baseClass == org.eclipse.ocl.types.MessageType.class)
        {
            switch (baseFeatureID)
            {
                case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
                    return OcldiagramsPackage.MESSAGE_TYPE__REFERRED_OPERATION;
                case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
                    return OcldiagramsPackage.MESSAGE_TYPE__REFERRED_SIGNAL;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // MessageTypeImpl
