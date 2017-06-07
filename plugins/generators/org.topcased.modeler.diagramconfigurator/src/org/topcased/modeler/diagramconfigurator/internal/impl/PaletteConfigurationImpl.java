/**
 * <copyright>
 * </copyright>
 *
 * $Id: PaletteConfigurationImpl.java,v 1.4 2007/04/18 12:21:18 jako Exp $
 */
package org.topcased.modeler.diagramconfigurator.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.topcased.modeler.diagramconfigurator.DiagramconfiguratorPackage;
import org.topcased.modeler.diagramconfigurator.PaletteCategory;
import org.topcased.modeler.diagramconfigurator.PaletteConfiguration;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Palette Configuration</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PaletteConfigurationImpl#getName <em>Name</em>}</li>
 * <li>{@link org.topcased.modeler.diagramconfigurator.internal.impl.PaletteConfigurationImpl#getPaletteCategories <em>Palette Categories</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PaletteConfigurationImpl extends EObjectImpl implements PaletteConfiguration
{
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getPaletteCategories() <em>Palette Categories</em>}' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPaletteCategories()
     * @generated
     * @ordered
     */
    protected EList<PaletteCategory> paletteCategories;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PaletteConfigurationImpl()
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
        return DiagramconfiguratorPackage.Literals.PALETTE_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getName()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setName(String newName)
    {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DiagramconfiguratorPackage.PALETTE_CONFIGURATION__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<PaletteCategory> getPaletteCategories()
    {
        if (paletteCategories == null)
        {
            paletteCategories = new EObjectContainmentEList<PaletteCategory>(PaletteCategory.class, this, DiagramconfiguratorPackage.PALETTE_CONFIGURATION__PALETTE_CATEGORIES);
        }
        return paletteCategories;
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
            case DiagramconfiguratorPackage.PALETTE_CONFIGURATION__PALETTE_CATEGORIES:
                return ((InternalEList< ? >) getPaletteCategories()).basicRemove(otherEnd, msgs);
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
            case DiagramconfiguratorPackage.PALETTE_CONFIGURATION__NAME:
                return getName();
            case DiagramconfiguratorPackage.PALETTE_CONFIGURATION__PALETTE_CATEGORIES:
                return getPaletteCategories();
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
            case DiagramconfiguratorPackage.PALETTE_CONFIGURATION__NAME:
                setName((String) newValue);
                return;
            case DiagramconfiguratorPackage.PALETTE_CONFIGURATION__PALETTE_CATEGORIES:
                getPaletteCategories().clear();
                getPaletteCategories().addAll((Collection< ? extends PaletteCategory>) newValue);
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
            case DiagramconfiguratorPackage.PALETTE_CONFIGURATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case DiagramconfiguratorPackage.PALETTE_CONFIGURATION__PALETTE_CATEGORIES:
                getPaletteCategories().clear();
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
            case DiagramconfiguratorPackage.PALETTE_CONFIGURATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case DiagramconfiguratorPackage.PALETTE_CONFIGURATION__PALETTE_CATEGORIES:
                return paletteCategories != null && !paletteCategories.isEmpty();
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
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} // PaletteConfigurationImpl
