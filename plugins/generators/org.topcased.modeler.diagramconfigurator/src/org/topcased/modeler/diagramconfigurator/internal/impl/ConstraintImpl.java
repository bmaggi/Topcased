/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConstraintImpl.java,v 1.4 2007/04/18 12:21:07 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.topcased.modeler.diagramconfigurator.Constraint;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Constraint</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.ConstraintImpl#getLanguage <em>Language</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.ConstraintImpl#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ConstraintImpl extends EObjectImpl implements Constraint
{
    /**
     * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLanguage()
     * @generated
     * @ordered
     */
    protected static final String LANGUAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLanguage()
     * @generated
     * @ordered
     */
    protected String language = LANGUAGE_EDEFAULT;

    /**
     * The default value of the '{@link #getRule() <em>Rule</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getRule()
     * @generated
     * @ordered
     */
    protected static final String RULE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRule() <em>Rule</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getRule()
     * @generated
     * @ordered
     */
    protected String rule = RULE_EDEFAULT;

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
        return DiagramconfiguratorPackage.Literals.CONSTRAINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getLanguage()
    {
        return language;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLanguage(String newLanguage)
    {
        String oldLanguage = language;
        language = newLanguage;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.CONSTRAINT__LANGUAGE, oldLanguage, language));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getRule()
    {
        return rule;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRule(String newRule)
    {
        String oldRule = rule;
        rule = newRule;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.CONSTRAINT__RULE, oldRule, rule));
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
            case DiagramconfiguratorPackage.CONSTRAINT__LANGUAGE:
                return getLanguage();
            case DiagramconfiguratorPackage.CONSTRAINT__RULE:
                return getRule();
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
            case DiagramconfiguratorPackage.CONSTRAINT__LANGUAGE:
                setLanguage((String) newValue);
                return;
            case DiagramconfiguratorPackage.CONSTRAINT__RULE:
                setRule((String) newValue);
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
            case DiagramconfiguratorPackage.CONSTRAINT__LANGUAGE:
                setLanguage(LANGUAGE_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.CONSTRAINT__RULE:
                setRule(RULE_EDEFAULT);
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
            case DiagramconfiguratorPackage.CONSTRAINT__LANGUAGE:
                return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
            case DiagramconfiguratorPackage.CONSTRAINT__RULE:
                return RULE_EDEFAULT == null ? rule != null : !RULE_EDEFAULT.equals(rule);
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
        result.append(" (language: ");
        result.append(language);
        result.append(", rule: ");
        result.append(rule);
        result.append(')');
        return result.toString();
    }

} // ConstraintImpl
