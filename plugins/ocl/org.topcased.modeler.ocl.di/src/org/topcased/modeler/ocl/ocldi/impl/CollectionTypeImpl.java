/**
 * <copyright>
 * </copyright>
 *
 * $Id: CollectionTypeImpl.java,v 1.2 2009/04/20 08:10:35 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldi.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassifierImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.ecore.SequenceType;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.types.operations.CollectionTypeOperations;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.topcased.modeler.ocl.ocldi.BagType;
import org.topcased.modeler.ocl.ocldi.CollectionType;
import org.topcased.modeler.ocl.ocldi.OcldiPackage;
import org.topcased.modeler.ocl.ocldi.OrderedSetType;
import org.topcased.modeler.ocl.ocldi.SetType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Collection Type</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.CollectionTypeImpl#getStartPosition <em>Start Position</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.CollectionTypeImpl#getEndPosition <em>End Position</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.CollectionTypeImpl#getTypeStartPosition <em>Type Start Position</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.CollectionTypeImpl#getTypeEndPosition <em>Type End Position</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.CollectionTypeImpl#getElementType <em>Element Type</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldi.impl.CollectionTypeImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CollectionTypeImpl extends EClassifierImpl implements CollectionType
{
    private EList<EOperation> operations;

    private EList<EOperation> iterators;

    /**
     * The default value of the '{@link #getStartPosition() <em>Start Position</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getStartPosition()
     * @generated
     * @ordered
     */
    protected static final int START_POSITION_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getStartPosition() <em>Start Position</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getStartPosition()
     * @generated
     * @ordered
     */
    protected int startPosition = START_POSITION_EDEFAULT;

    /**
     * The default value of the '{@link #getEndPosition() <em>End Position</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getEndPosition()
     * @generated
     * @ordered
     */
    protected static final int END_POSITION_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getEndPosition() <em>End Position</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getEndPosition()
     * @generated
     * @ordered
     */
    protected int endPosition = END_POSITION_EDEFAULT;

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
     * The cached value of the '{@link #getElementType() <em>Element Type</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getElementType()
     * @generated
     * @ordered
     */
    protected EClassifier elementType;

    /**
     * The default value of the '{@link #getKind() <em>Kind</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getKind()
     * @generated
     * @ordered
     */
    protected static final CollectionKind KIND_EDEFAULT = CollectionKind.SET_LITERAL;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CollectionTypeImpl()
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
        return OcldiPackage.Literals.COLLECTION_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getStartPosition()
    {
        return startPosition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setStartPosition(int newStartPosition)
    {
        int oldStartPosition = startPosition;
        startPosition = newStartPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.COLLECTION_TYPE__START_POSITION, oldStartPosition, startPosition));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getEndPosition()
    {
        return endPosition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setEndPosition(int newEndPosition)
    {
        int oldEndPosition = endPosition;
        endPosition = newEndPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.COLLECTION_TYPE__END_POSITION, oldEndPosition, endPosition));
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
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.COLLECTION_TYPE__TYPE_START_POSITION, oldTypeStartPosition, typeStartPosition));
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
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.COLLECTION_TYPE__TYPE_END_POSITION, oldTypeEndPosition, typeEndPosition));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClassifier getElementType()
    {
        if (elementType != null && ((EObject) elementType).eIsProxy())
        {
            InternalEObject oldElementType = (InternalEObject) elementType;
            elementType = (EClassifier) eResolveProxy(oldElementType);
            if (elementType != oldElementType)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OcldiPackage.COLLECTION_TYPE__ELEMENT_TYPE, oldElementType, elementType));
            }
        }
        return elementType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClassifier basicGetElementType()
    {
        return elementType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setElementType(EClassifier newElementType)
    {
        EClassifier oldElementType = elementType;
        elementType = newElementType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiPackage.COLLECTION_TYPE__ELEMENT_TYPE, oldElementType, elementType));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public CollectionKind getKind()
    {
        if (this instanceof BagType)
            return CollectionKind.BAG_LITERAL;
        if (this instanceof SetType)
            return CollectionKind.SET_LITERAL;
        if (this instanceof SequenceType)
            return CollectionKind.SEQUENCE_LITERAL;
        if (this instanceof OrderedSetType)
            return CollectionKind.ORDERED_SET_LITERAL;
        return CollectionKind.COLLECTION_LITERAL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkCollectionTypeName(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return CollectionTypeOperations.checkCollectionTypeName(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean checkNoInvalidValues(DiagnosticChain diagnostics, Map<Object, Object> context)
    {
        return CollectionTypeOperations.checkNoInvalidValues(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<EOperation> oclIterators()
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
            case OcldiPackage.COLLECTION_TYPE__START_POSITION:
                return new Integer(getStartPosition());
            case OcldiPackage.COLLECTION_TYPE__END_POSITION:
                return new Integer(getEndPosition());
            case OcldiPackage.COLLECTION_TYPE__TYPE_START_POSITION:
                return new Integer(getTypeStartPosition());
            case OcldiPackage.COLLECTION_TYPE__TYPE_END_POSITION:
                return new Integer(getTypeEndPosition());
            case OcldiPackage.COLLECTION_TYPE__ELEMENT_TYPE:
                if (resolve)
                    return getElementType();
                return basicGetElementType();
            case OcldiPackage.COLLECTION_TYPE__KIND:
                return getKind();
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
            case OcldiPackage.COLLECTION_TYPE__START_POSITION:
                setStartPosition(((Integer) newValue).intValue());
                return;
            case OcldiPackage.COLLECTION_TYPE__END_POSITION:
                setEndPosition(((Integer) newValue).intValue());
                return;
            case OcldiPackage.COLLECTION_TYPE__TYPE_START_POSITION:
                setTypeStartPosition(((Integer) newValue).intValue());
                return;
            case OcldiPackage.COLLECTION_TYPE__TYPE_END_POSITION:
                setTypeEndPosition(((Integer) newValue).intValue());
                return;
            case OcldiPackage.COLLECTION_TYPE__ELEMENT_TYPE:
                setElementType((EClassifier) newValue);
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
            case OcldiPackage.COLLECTION_TYPE__START_POSITION:
                setStartPosition(START_POSITION_EDEFAULT);
                return;
            case OcldiPackage.COLLECTION_TYPE__END_POSITION:
                setEndPosition(END_POSITION_EDEFAULT);
                return;
            case OcldiPackage.COLLECTION_TYPE__TYPE_START_POSITION:
                setTypeStartPosition(TYPE_START_POSITION_EDEFAULT);
                return;
            case OcldiPackage.COLLECTION_TYPE__TYPE_END_POSITION:
                setTypeEndPosition(TYPE_END_POSITION_EDEFAULT);
                return;
            case OcldiPackage.COLLECTION_TYPE__ELEMENT_TYPE:
                setElementType((EClassifier) null);
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
            case OcldiPackage.COLLECTION_TYPE__START_POSITION:
                return startPosition != START_POSITION_EDEFAULT;
            case OcldiPackage.COLLECTION_TYPE__END_POSITION:
                return endPosition != END_POSITION_EDEFAULT;
            case OcldiPackage.COLLECTION_TYPE__TYPE_START_POSITION:
                return typeStartPosition != TYPE_START_POSITION_EDEFAULT;
            case OcldiPackage.COLLECTION_TYPE__TYPE_END_POSITION:
                return typeEndPosition != TYPE_END_POSITION_EDEFAULT;
            case OcldiPackage.COLLECTION_TYPE__ELEMENT_TYPE:
                return elementType != null;
            case OcldiPackage.COLLECTION_TYPE__KIND:
                return getKind() != KIND_EDEFAULT;
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
        if (baseClass == ASTNode.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiPackage.COLLECTION_TYPE__START_POSITION:
                    return UtilitiesPackage.AST_NODE__START_POSITION;
                case OcldiPackage.COLLECTION_TYPE__END_POSITION:
                    return UtilitiesPackage.AST_NODE__END_POSITION;
                default:
                    return -1;
            }
        }
        if (baseClass == TypedASTNode.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiPackage.COLLECTION_TYPE__TYPE_START_POSITION:
                    return UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION;
                case OcldiPackage.COLLECTION_TYPE__TYPE_END_POSITION:
                    return UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION;
                default:
                    return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.types.CollectionType.class)
        {
            switch (derivedFeatureID)
            {
                case OcldiPackage.COLLECTION_TYPE__ELEMENT_TYPE:
                    return TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE;
                case OcldiPackage.COLLECTION_TYPE__KIND:
                    return TypesPackage.COLLECTION_TYPE__KIND;
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
        if (baseClass == ASTNode.class)
        {
            switch (baseFeatureID)
            {
                case UtilitiesPackage.AST_NODE__START_POSITION:
                    return OcldiPackage.COLLECTION_TYPE__START_POSITION;
                case UtilitiesPackage.AST_NODE__END_POSITION:
                    return OcldiPackage.COLLECTION_TYPE__END_POSITION;
                default:
                    return -1;
            }
        }
        if (baseClass == TypedASTNode.class)
        {
            switch (baseFeatureID)
            {
                case UtilitiesPackage.TYPED_AST_NODE__TYPE_START_POSITION:
                    return OcldiPackage.COLLECTION_TYPE__TYPE_START_POSITION;
                case UtilitiesPackage.TYPED_AST_NODE__TYPE_END_POSITION:
                    return OcldiPackage.COLLECTION_TYPE__TYPE_END_POSITION;
                default:
                    return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.types.CollectionType.class)
        {
            switch (baseFeatureID)
            {
                case TypesPackage.COLLECTION_TYPE__ELEMENT_TYPE:
                    return OcldiPackage.COLLECTION_TYPE__ELEMENT_TYPE;
                case TypesPackage.COLLECTION_TYPE__KIND:
                    return OcldiPackage.COLLECTION_TYPE__KIND;
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
        result.append(" (startPosition: ");
        result.append(startPosition);
        result.append(", endPosition: ");
        result.append(endPosition);
        result.append(", typeStartPosition: ");
        result.append(typeStartPosition);
        result.append(", typeEndPosition: ");
        result.append(typeEndPosition);
        result.append(')');
        return result.toString();
    }

} // CollectionTypeImpl
