/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConstraintImpl.java,v 1.2 2009/04/20 08:07:08 sgabel Exp $
 */
package org.topcased.modeler.ocl.ocldiagrams.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassifierImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.topcased.modeler.ocl.ocldiagrams.BusinessType;
import org.topcased.modeler.ocl.ocldiagrams.Constraint;
import org.topcased.modeler.ocl.ocldiagrams.OcldiagramsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Constraint</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.ConstraintImpl#getSpecification <em>Specification</em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.ConstraintImpl#getConstrainedElements <em>Constrained Elements
 * </em>}</li>
 * <li>{@link org.topcased.modeler.ocl.ocldiagrams.impl.ConstraintImpl#getStereotype <em>Stereotype</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ConstraintImpl extends EClassifierImpl implements Constraint
{
    /**
     * The cached value of the '{@link #getSpecification() <em>Specification</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSpecification()
     * @generated
     * @ordered
     */
    protected ExpressionInOCL<EClassifier, EParameter> specification;

    /**
     * The cached value of the '{@link #getConstrainedElements() <em>Constrained Elements</em>}' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getConstrainedElements()
     * @generated
     * @ordered
     */
    protected EList<BusinessType> constrainedElements;

    /**
     * The default value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getStereotype()
     * @generated
     * @ordered
     */
    protected static final String STEREOTYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getStereotype()
     * @generated
     * @ordered
     */
    protected String stereotype = STEREOTYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ConstraintImpl()
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
        return OcldiagramsPackage.Literals.CONSTRAINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ExpressionInOCL<EClassifier, EParameter> getSpecification()
    {
        return specification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetSpecification(ExpressionInOCL<EClassifier, EParameter> newSpecification, NotificationChain msgs)
    {
        ExpressionInOCL<EClassifier, EParameter> oldSpecification = specification;
        specification = newSpecification;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.CONSTRAINT__SPECIFICATION, oldSpecification, newSpecification);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSpecification(ExpressionInOCL<EClassifier, EParameter> newSpecification)
    {
        if (newSpecification != specification)
        {
            NotificationChain msgs = null;
            if (specification != null)
                msgs = ((InternalEObject) specification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.CONSTRAINT__SPECIFICATION, null, msgs);
            if (newSpecification != null)
                msgs = ((InternalEObject) newSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OcldiagramsPackage.CONSTRAINT__SPECIFICATION, null, msgs);
            msgs = basicSetSpecification(newSpecification, msgs);
            if (msgs != null)
                msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.CONSTRAINT__SPECIFICATION, newSpecification, newSpecification));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<BusinessType> getConstrainedElements()
    {
        if (constrainedElements == null)
        {
            constrainedElements = new EObjectResolvingEList<BusinessType>(BusinessType.class, this, OcldiagramsPackage.CONSTRAINT__CONSTRAINED_ELEMENTS);
        }
        return constrainedElements;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getStereotype()
    {
        return stereotype;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setStereotype(String newStereotype)
    {
        String oldStereotype = stereotype;
        stereotype = newStereotype;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OcldiagramsPackage.CONSTRAINT__STEREOTYPE, oldStereotype, stereotype));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case OcldiagramsPackage.CONSTRAINT__SPECIFICATION:
                return basicSetSpecification(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
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
            case OcldiagramsPackage.CONSTRAINT__SPECIFICATION:
                return getSpecification();
            case OcldiagramsPackage.CONSTRAINT__CONSTRAINED_ELEMENTS:
                return getConstrainedElements();
            case OcldiagramsPackage.CONSTRAINT__STEREOTYPE:
                return getStereotype();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case OcldiagramsPackage.CONSTRAINT__SPECIFICATION:
                setSpecification((ExpressionInOCL<EClassifier, EParameter>) newValue);
                return;
            case OcldiagramsPackage.CONSTRAINT__CONSTRAINED_ELEMENTS:
                getConstrainedElements().clear();
                getConstrainedElements().addAll((Collection< ? extends BusinessType>) newValue);
                return;
            case OcldiagramsPackage.CONSTRAINT__STEREOTYPE:
                setStereotype((String) newValue);
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
            case OcldiagramsPackage.CONSTRAINT__SPECIFICATION:
                setSpecification((ExpressionInOCL<EClassifier, EParameter>) null);
                return;
            case OcldiagramsPackage.CONSTRAINT__CONSTRAINED_ELEMENTS:
                getConstrainedElements().clear();
                return;
            case OcldiagramsPackage.CONSTRAINT__STEREOTYPE:
                setStereotype(STEREOTYPE_EDEFAULT);
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
            case OcldiagramsPackage.CONSTRAINT__SPECIFICATION:
                return specification != null;
            case OcldiagramsPackage.CONSTRAINT__CONSTRAINED_ELEMENTS:
                return constrainedElements != null && !constrainedElements.isEmpty();
            case OcldiagramsPackage.CONSTRAINT__STEREOTYPE:
                return STEREOTYPE_EDEFAULT == null ? stereotype != null : !STEREOTYPE_EDEFAULT.equals(stereotype);
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
        result.append(" (stereotype: ");
        result.append(stereotype);
        result.append(')');
        return result.toString();
    }

} // ConstraintImpl
